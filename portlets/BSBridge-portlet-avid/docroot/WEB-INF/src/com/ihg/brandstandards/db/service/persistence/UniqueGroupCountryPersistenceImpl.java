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

import com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException;
import com.ihg.brandstandards.db.model.UniqueGroupCountry;
import com.ihg.brandstandards.db.model.impl.UniqueGroupCountryImpl;
import com.ihg.brandstandards.db.model.impl.UniqueGroupCountryModelImpl;

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
 * The persistence implementation for the unique group country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroupCountryPersistence
 * @see UniqueGroupCountryUtil
 * @generated
 */
public class UniqueGroupCountryPersistenceImpl extends BasePersistenceImpl<UniqueGroupCountry>
	implements UniqueGroupCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UniqueGroupCountryUtil} to access the unique group country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UniqueGroupCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupCountryModelImpl.FINDER_CACHE_ENABLED,
			UniqueGroupCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupCountryModelImpl.FINDER_CACHE_ENABLED,
			UniqueGroupCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UniqueGroupCountryPersistenceImpl() {
		setModelClass(UniqueGroupCountry.class);
	}

	/**
	 * Caches the unique group country in the entity cache if it is enabled.
	 *
	 * @param uniqueGroupCountry the unique group country
	 */
	@Override
	public void cacheResult(UniqueGroupCountry uniqueGroupCountry) {
		EntityCacheUtil.putResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupCountryImpl.class, uniqueGroupCountry.getPrimaryKey(),
			uniqueGroupCountry);

		uniqueGroupCountry.resetOriginalValues();
	}

	/**
	 * Caches the unique group countries in the entity cache if it is enabled.
	 *
	 * @param uniqueGroupCountries the unique group countries
	 */
	@Override
	public void cacheResult(List<UniqueGroupCountry> uniqueGroupCountries) {
		for (UniqueGroupCountry uniqueGroupCountry : uniqueGroupCountries) {
			if (EntityCacheUtil.getResult(
						UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
						UniqueGroupCountryImpl.class,
						uniqueGroupCountry.getPrimaryKey()) == null) {
				cacheResult(uniqueGroupCountry);
			}
			else {
				uniqueGroupCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all unique group countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UniqueGroupCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UniqueGroupCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unique group country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UniqueGroupCountry uniqueGroupCountry) {
		EntityCacheUtil.removeResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupCountryImpl.class, uniqueGroupCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UniqueGroupCountry> uniqueGroupCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UniqueGroupCountry uniqueGroupCountry : uniqueGroupCountries) {
			EntityCacheUtil.removeResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
				UniqueGroupCountryImpl.class, uniqueGroupCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new unique group country with the primary key. Does not add the unique group country to the database.
	 *
	 * @param groupCountryId the primary key for the new unique group country
	 * @return the new unique group country
	 */
	@Override
	public UniqueGroupCountry create(long groupCountryId) {
		UniqueGroupCountry uniqueGroupCountry = new UniqueGroupCountryImpl();

		uniqueGroupCountry.setNew(true);
		uniqueGroupCountry.setPrimaryKey(groupCountryId);

		return uniqueGroupCountry;
	}

	/**
	 * Removes the unique group country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCountryId the primary key of the unique group country
	 * @return the unique group country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException if a unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupCountry remove(long groupCountryId)
		throws NoSuchUniqueGroupCountryException, SystemException {
		return remove((Serializable)groupCountryId);
	}

	/**
	 * Removes the unique group country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unique group country
	 * @return the unique group country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException if a unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupCountry remove(Serializable primaryKey)
		throws NoSuchUniqueGroupCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UniqueGroupCountry uniqueGroupCountry = (UniqueGroupCountry)session.get(UniqueGroupCountryImpl.class,
					primaryKey);

			if (uniqueGroupCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUniqueGroupCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uniqueGroupCountry);
		}
		catch (NoSuchUniqueGroupCountryException nsee) {
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
	protected UniqueGroupCountry removeImpl(
		UniqueGroupCountry uniqueGroupCountry) throws SystemException {
		uniqueGroupCountry = toUnwrappedModel(uniqueGroupCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uniqueGroupCountry)) {
				uniqueGroupCountry = (UniqueGroupCountry)session.get(UniqueGroupCountryImpl.class,
						uniqueGroupCountry.getPrimaryKeyObj());
			}

			if (uniqueGroupCountry != null) {
				session.delete(uniqueGroupCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (uniqueGroupCountry != null) {
			clearCache(uniqueGroupCountry);
		}

		return uniqueGroupCountry;
	}

	@Override
	public UniqueGroupCountry updateImpl(
		com.ihg.brandstandards.db.model.UniqueGroupCountry uniqueGroupCountry)
		throws SystemException {
		uniqueGroupCountry = toUnwrappedModel(uniqueGroupCountry);

		boolean isNew = uniqueGroupCountry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (uniqueGroupCountry.isNew()) {
				session.save(uniqueGroupCountry);

				uniqueGroupCountry.setNew(false);
			}
			else {
				session.merge(uniqueGroupCountry);
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

		EntityCacheUtil.putResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupCountryImpl.class, uniqueGroupCountry.getPrimaryKey(),
			uniqueGroupCountry);

		return uniqueGroupCountry;
	}

	protected UniqueGroupCountry toUnwrappedModel(
		UniqueGroupCountry uniqueGroupCountry) {
		if (uniqueGroupCountry instanceof UniqueGroupCountryImpl) {
			return uniqueGroupCountry;
		}

		UniqueGroupCountryImpl uniqueGroupCountryImpl = new UniqueGroupCountryImpl();

		uniqueGroupCountryImpl.setNew(uniqueGroupCountry.isNew());
		uniqueGroupCountryImpl.setPrimaryKey(uniqueGroupCountry.getPrimaryKey());

		uniqueGroupCountryImpl.setGroupCountryId(uniqueGroupCountry.getGroupCountryId());
		uniqueGroupCountryImpl.setUniqueGroupId(uniqueGroupCountry.getUniqueGroupId());
		uniqueGroupCountryImpl.setCountryCode(uniqueGroupCountry.getCountryCode());
		uniqueGroupCountryImpl.setCreatorId(uniqueGroupCountry.getCreatorId());
		uniqueGroupCountryImpl.setCreatedDate(uniqueGroupCountry.getCreatedDate());
		uniqueGroupCountryImpl.setUpdatedBy(uniqueGroupCountry.getUpdatedBy());
		uniqueGroupCountryImpl.setUpdatedDate(uniqueGroupCountry.getUpdatedDate());

		return uniqueGroupCountryImpl;
	}

	/**
	 * Returns the unique group country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the unique group country
	 * @return the unique group country
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException if a unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUniqueGroupCountryException, SystemException {
		UniqueGroupCountry uniqueGroupCountry = fetchByPrimaryKey(primaryKey);

		if (uniqueGroupCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUniqueGroupCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return uniqueGroupCountry;
	}

	/**
	 * Returns the unique group country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException} if it could not be found.
	 *
	 * @param groupCountryId the primary key of the unique group country
	 * @return the unique group country
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException if a unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupCountry findByPrimaryKey(long groupCountryId)
		throws NoSuchUniqueGroupCountryException, SystemException {
		return findByPrimaryKey((Serializable)groupCountryId);
	}

	/**
	 * Returns the unique group country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unique group country
	 * @return the unique group country, or <code>null</code> if a unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UniqueGroupCountry uniqueGroupCountry = (UniqueGroupCountry)EntityCacheUtil.getResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
				UniqueGroupCountryImpl.class, primaryKey);

		if (uniqueGroupCountry == _nullUniqueGroupCountry) {
			return null;
		}

		if (uniqueGroupCountry == null) {
			Session session = null;

			try {
				session = openSession();

				uniqueGroupCountry = (UniqueGroupCountry)session.get(UniqueGroupCountryImpl.class,
						primaryKey);

				if (uniqueGroupCountry != null) {
					cacheResult(uniqueGroupCountry);
				}
				else {
					EntityCacheUtil.putResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
						UniqueGroupCountryImpl.class, primaryKey,
						_nullUniqueGroupCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
					UniqueGroupCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return uniqueGroupCountry;
	}

	/**
	 * Returns the unique group country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupCountryId the primary key of the unique group country
	 * @return the unique group country, or <code>null</code> if a unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupCountry fetchByPrimaryKey(long groupCountryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupCountryId);
	}

	/**
	 * Returns all the unique group countries.
	 *
	 * @return the unique group countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroupCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unique group countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unique group countries
	 * @param end the upper bound of the range of unique group countries (not inclusive)
	 * @return the range of unique group countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroupCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the unique group countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unique group countries
	 * @param end the upper bound of the range of unique group countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unique group countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroupCountry> findAll(int start, int end,
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

		List<UniqueGroupCountry> list = (List<UniqueGroupCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNIQUEGROUPCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNIQUEGROUPCOUNTRY;

				if (pagination) {
					sql = sql.concat(UniqueGroupCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UniqueGroupCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UniqueGroupCountry>(list);
				}
				else {
					list = (List<UniqueGroupCountry>)QueryUtil.list(q,
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
	 * Removes all the unique group countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UniqueGroupCountry uniqueGroupCountry : findAll()) {
			remove(uniqueGroupCountry);
		}
	}

	/**
	 * Returns the number of unique group countries.
	 *
	 * @return the number of unique group countries
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

				Query q = session.createQuery(_SQL_COUNT_UNIQUEGROUPCOUNTRY);

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
	 * Initializes the unique group country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UniqueGroupCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UniqueGroupCountry>> listenersList = new ArrayList<ModelListener<UniqueGroupCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UniqueGroupCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UniqueGroupCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNIQUEGROUPCOUNTRY = "SELECT uniqueGroupCountry FROM UniqueGroupCountry uniqueGroupCountry";
	private static final String _SQL_COUNT_UNIQUEGROUPCOUNTRY = "SELECT COUNT(uniqueGroupCountry) FROM UniqueGroupCountry uniqueGroupCountry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uniqueGroupCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UniqueGroupCountry exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UniqueGroupCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"groupCountryId", "uniqueGroupId", "countryCode", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static UniqueGroupCountry _nullUniqueGroupCountry = new UniqueGroupCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UniqueGroupCountry> toCacheModel() {
				return _nullUniqueGroupCountryCacheModel;
			}
		};

	private static CacheModel<UniqueGroupCountry> _nullUniqueGroupCountryCacheModel =
		new CacheModel<UniqueGroupCountry>() {
			@Override
			public UniqueGroupCountry toEntityModel() {
				return _nullUniqueGroupCountry;
			}
		};
}