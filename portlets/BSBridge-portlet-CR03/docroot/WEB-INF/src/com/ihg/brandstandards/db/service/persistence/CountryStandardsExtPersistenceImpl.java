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

import com.ihg.brandstandards.db.NoSuchCountryStandardsExtException;
import com.ihg.brandstandards.db.model.CountryStandardsExt;
import com.ihg.brandstandards.db.model.impl.CountryStandardsExtImpl;
import com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl;

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
 * The persistence implementation for the country standards ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandardsExtPersistence
 * @see CountryStandardsExtUtil
 * @generated
 */
public class CountryStandardsExtPersistenceImpl extends BasePersistenceImpl<CountryStandardsExt>
	implements CountryStandardsExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CountryStandardsExtUtil} to access the country standards ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CountryStandardsExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsExtModelImpl.FINDER_CACHE_ENABLED,
			CountryStandardsExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsExtModelImpl.FINDER_CACHE_ENABLED,
			CountryStandardsExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CountryStandardsExtPersistenceImpl() {
		setModelClass(CountryStandardsExt.class);
	}

	/**
	 * Caches the country standards ext in the entity cache if it is enabled.
	 *
	 * @param countryStandardsExt the country standards ext
	 */
	@Override
	public void cacheResult(CountryStandardsExt countryStandardsExt) {
		EntityCacheUtil.putResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsExtImpl.class, countryStandardsExt.getPrimaryKey(),
			countryStandardsExt);

		countryStandardsExt.resetOriginalValues();
	}

	/**
	 * Caches the country standards exts in the entity cache if it is enabled.
	 *
	 * @param countryStandardsExts the country standards exts
	 */
	@Override
	public void cacheResult(List<CountryStandardsExt> countryStandardsExts) {
		for (CountryStandardsExt countryStandardsExt : countryStandardsExts) {
			if (EntityCacheUtil.getResult(
						CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
						CountryStandardsExtImpl.class,
						countryStandardsExt.getPrimaryKey()) == null) {
				cacheResult(countryStandardsExt);
			}
			else {
				countryStandardsExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all country standards exts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CountryStandardsExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CountryStandardsExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the country standards ext.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CountryStandardsExt countryStandardsExt) {
		EntityCacheUtil.removeResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsExtImpl.class, countryStandardsExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CountryStandardsExt> countryStandardsExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CountryStandardsExt countryStandardsExt : countryStandardsExts) {
			EntityCacheUtil.removeResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
				CountryStandardsExtImpl.class,
				countryStandardsExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new country standards ext with the primary key. Does not add the country standards ext to the database.
	 *
	 * @param countryStandardsExtPK the primary key for the new country standards ext
	 * @return the new country standards ext
	 */
	@Override
	public CountryStandardsExt create(
		CountryStandardsExtPK countryStandardsExtPK) {
		CountryStandardsExt countryStandardsExt = new CountryStandardsExtImpl();

		countryStandardsExt.setNew(true);
		countryStandardsExt.setPrimaryKey(countryStandardsExtPK);

		return countryStandardsExt;
	}

	/**
	 * Removes the country standards ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryStandardsExtPK the primary key of the country standards ext
	 * @return the country standards ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException if a country standards ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandardsExt remove(
		CountryStandardsExtPK countryStandardsExtPK)
		throws NoSuchCountryStandardsExtException, SystemException {
		return remove((Serializable)countryStandardsExtPK);
	}

	/**
	 * Removes the country standards ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the country standards ext
	 * @return the country standards ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException if a country standards ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandardsExt remove(Serializable primaryKey)
		throws NoSuchCountryStandardsExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CountryStandardsExt countryStandardsExt = (CountryStandardsExt)session.get(CountryStandardsExtImpl.class,
					primaryKey);

			if (countryStandardsExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCountryStandardsExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(countryStandardsExt);
		}
		catch (NoSuchCountryStandardsExtException nsee) {
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
	protected CountryStandardsExt removeImpl(
		CountryStandardsExt countryStandardsExt) throws SystemException {
		countryStandardsExt = toUnwrappedModel(countryStandardsExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(countryStandardsExt)) {
				countryStandardsExt = (CountryStandardsExt)session.get(CountryStandardsExtImpl.class,
						countryStandardsExt.getPrimaryKeyObj());
			}

			if (countryStandardsExt != null) {
				session.delete(countryStandardsExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (countryStandardsExt != null) {
			clearCache(countryStandardsExt);
		}

		return countryStandardsExt;
	}

	@Override
	public CountryStandardsExt updateImpl(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt)
		throws SystemException {
		countryStandardsExt = toUnwrappedModel(countryStandardsExt);

		boolean isNew = countryStandardsExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (countryStandardsExt.isNew()) {
				session.save(countryStandardsExt);

				countryStandardsExt.setNew(false);
			}
			else {
				session.merge(countryStandardsExt);
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

		EntityCacheUtil.putResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsExtImpl.class, countryStandardsExt.getPrimaryKey(),
			countryStandardsExt);

		return countryStandardsExt;
	}

	protected CountryStandardsExt toUnwrappedModel(
		CountryStandardsExt countryStandardsExt) {
		if (countryStandardsExt instanceof CountryStandardsExtImpl) {
			return countryStandardsExt;
		}

		CountryStandardsExtImpl countryStandardsExtImpl = new CountryStandardsExtImpl();

		countryStandardsExtImpl.setNew(countryStandardsExt.isNew());
		countryStandardsExtImpl.setPrimaryKey(countryStandardsExt.getPrimaryKey());

		countryStandardsExtImpl.setCountryCode(countryStandardsExt.getCountryCode());
		countryStandardsExtImpl.setStdId(countryStandardsExt.getStdId());
		countryStandardsExtImpl.setRegionId(countryStandardsExt.getRegionId());
		countryStandardsExtImpl.setRegionCode(countryStandardsExt.getRegionCode());
		countryStandardsExtImpl.setRegionName(countryStandardsExt.getRegionName());

		return countryStandardsExtImpl;
	}

	/**
	 * Returns the country standards ext with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the country standards ext
	 * @return the country standards ext
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException if a country standards ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandardsExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCountryStandardsExtException, SystemException {
		CountryStandardsExt countryStandardsExt = fetchByPrimaryKey(primaryKey);

		if (countryStandardsExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCountryStandardsExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return countryStandardsExt;
	}

	/**
	 * Returns the country standards ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchCountryStandardsExtException} if it could not be found.
	 *
	 * @param countryStandardsExtPK the primary key of the country standards ext
	 * @return the country standards ext
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException if a country standards ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandardsExt findByPrimaryKey(
		CountryStandardsExtPK countryStandardsExtPK)
		throws NoSuchCountryStandardsExtException, SystemException {
		return findByPrimaryKey((Serializable)countryStandardsExtPK);
	}

	/**
	 * Returns the country standards ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the country standards ext
	 * @return the country standards ext, or <code>null</code> if a country standards ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandardsExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CountryStandardsExt countryStandardsExt = (CountryStandardsExt)EntityCacheUtil.getResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
				CountryStandardsExtImpl.class, primaryKey);

		if (countryStandardsExt == _nullCountryStandardsExt) {
			return null;
		}

		if (countryStandardsExt == null) {
			Session session = null;

			try {
				session = openSession();

				countryStandardsExt = (CountryStandardsExt)session.get(CountryStandardsExtImpl.class,
						primaryKey);

				if (countryStandardsExt != null) {
					cacheResult(countryStandardsExt);
				}
				else {
					EntityCacheUtil.putResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
						CountryStandardsExtImpl.class, primaryKey,
						_nullCountryStandardsExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CountryStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
					CountryStandardsExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return countryStandardsExt;
	}

	/**
	 * Returns the country standards ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryStandardsExtPK the primary key of the country standards ext
	 * @return the country standards ext, or <code>null</code> if a country standards ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandardsExt fetchByPrimaryKey(
		CountryStandardsExtPK countryStandardsExtPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)countryStandardsExtPK);
	}

	/**
	 * Returns all the country standards exts.
	 *
	 * @return the country standards exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandardsExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the country standards exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of country standards exts
	 * @param end the upper bound of the range of country standards exts (not inclusive)
	 * @return the range of country standards exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandardsExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the country standards exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of country standards exts
	 * @param end the upper bound of the range of country standards exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of country standards exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandardsExt> findAll(int start, int end,
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

		List<CountryStandardsExt> list = (List<CountryStandardsExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COUNTRYSTANDARDSEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COUNTRYSTANDARDSEXT;

				if (pagination) {
					sql = sql.concat(CountryStandardsExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CountryStandardsExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CountryStandardsExt>(list);
				}
				else {
					list = (List<CountryStandardsExt>)QueryUtil.list(q,
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
	 * Removes all the country standards exts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CountryStandardsExt countryStandardsExt : findAll()) {
			remove(countryStandardsExt);
		}
	}

	/**
	 * Returns the number of country standards exts.
	 *
	 * @return the number of country standards exts
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

				Query q = session.createQuery(_SQL_COUNT_COUNTRYSTANDARDSEXT);

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
	 * Initializes the country standards ext persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.CountryStandardsExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CountryStandardsExt>> listenersList = new ArrayList<ModelListener<CountryStandardsExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CountryStandardsExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CountryStandardsExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COUNTRYSTANDARDSEXT = "SELECT countryStandardsExt FROM CountryStandardsExt countryStandardsExt";
	private static final String _SQL_COUNT_COUNTRYSTANDARDSEXT = "SELECT COUNT(countryStandardsExt) FROM CountryStandardsExt countryStandardsExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "countryStandardsExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CountryStandardsExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CountryStandardsExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"countryCode", "stdId", "regionId", "regionCode", "regionName"
			});
	private static CountryStandardsExt _nullCountryStandardsExt = new CountryStandardsExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CountryStandardsExt> toCacheModel() {
				return _nullCountryStandardsExtCacheModel;
			}
		};

	private static CacheModel<CountryStandardsExt> _nullCountryStandardsExtCacheModel =
		new CacheModel<CountryStandardsExt>() {
			@Override
			public CountryStandardsExt toEntityModel() {
				return _nullCountryStandardsExt;
			}
		};
}