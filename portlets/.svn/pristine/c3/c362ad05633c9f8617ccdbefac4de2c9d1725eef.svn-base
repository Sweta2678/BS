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

import com.ihg.brandstandards.db.NoSuchStandardsCountryExtException;
import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.model.impl.StandardsCountryExtImpl;
import com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl;

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
 * The persistence implementation for the standards country ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryExtPersistence
 * @see StandardsCountryExtUtil
 * @generated
 */
public class StandardsCountryExtPersistenceImpl extends BasePersistenceImpl<StandardsCountryExt>
	implements StandardsCountryExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsCountryExtUtil} to access the standards country ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsCountryExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryExtModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryExtModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StandardsCountryExtPersistenceImpl() {
		setModelClass(StandardsCountryExt.class);
	}

	/**
	 * Caches the standards country ext in the entity cache if it is enabled.
	 *
	 * @param standardsCountryExt the standards country ext
	 */
	@Override
	public void cacheResult(StandardsCountryExt standardsCountryExt) {
		EntityCacheUtil.putResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryExtImpl.class, standardsCountryExt.getPrimaryKey(),
			standardsCountryExt);

		standardsCountryExt.resetOriginalValues();
	}

	/**
	 * Caches the standards country exts in the entity cache if it is enabled.
	 *
	 * @param standardsCountryExts the standards country exts
	 */
	@Override
	public void cacheResult(List<StandardsCountryExt> standardsCountryExts) {
		for (StandardsCountryExt standardsCountryExt : standardsCountryExts) {
			if (EntityCacheUtil.getResult(
						StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryExtImpl.class,
						standardsCountryExt.getPrimaryKey()) == null) {
				cacheResult(standardsCountryExt);
			}
			else {
				standardsCountryExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards country exts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsCountryExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsCountryExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards country ext.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsCountryExt standardsCountryExt) {
		EntityCacheUtil.removeResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryExtImpl.class, standardsCountryExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsCountryExt> standardsCountryExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsCountryExt standardsCountryExt : standardsCountryExts) {
			EntityCacheUtil.removeResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryExtImpl.class,
				standardsCountryExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards country ext with the primary key. Does not add the standards country ext to the database.
	 *
	 * @param rowNum the primary key for the new standards country ext
	 * @return the new standards country ext
	 */
	@Override
	public StandardsCountryExt create(long rowNum) {
		StandardsCountryExt standardsCountryExt = new StandardsCountryExtImpl();

		standardsCountryExt.setNew(true);
		standardsCountryExt.setPrimaryKey(rowNum);

		return standardsCountryExt;
	}

	/**
	 * Removes the standards country ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rowNum the primary key of the standards country ext
	 * @return the standards country ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException if a standards country ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryExt remove(long rowNum)
		throws NoSuchStandardsCountryExtException, SystemException {
		return remove((Serializable)rowNum);
	}

	/**
	 * Removes the standards country ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards country ext
	 * @return the standards country ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException if a standards country ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryExt remove(Serializable primaryKey)
		throws NoSuchStandardsCountryExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsCountryExt standardsCountryExt = (StandardsCountryExt)session.get(StandardsCountryExtImpl.class,
					primaryKey);

			if (standardsCountryExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsCountryExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsCountryExt);
		}
		catch (NoSuchStandardsCountryExtException nsee) {
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
	protected StandardsCountryExt removeImpl(
		StandardsCountryExt standardsCountryExt) throws SystemException {
		standardsCountryExt = toUnwrappedModel(standardsCountryExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsCountryExt)) {
				standardsCountryExt = (StandardsCountryExt)session.get(StandardsCountryExtImpl.class,
						standardsCountryExt.getPrimaryKeyObj());
			}

			if (standardsCountryExt != null) {
				session.delete(standardsCountryExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsCountryExt != null) {
			clearCache(standardsCountryExt);
		}

		return standardsCountryExt;
	}

	@Override
	public StandardsCountryExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt)
		throws SystemException {
		standardsCountryExt = toUnwrappedModel(standardsCountryExt);

		boolean isNew = standardsCountryExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (standardsCountryExt.isNew()) {
				session.save(standardsCountryExt);

				standardsCountryExt.setNew(false);
			}
			else {
				session.merge(standardsCountryExt);
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

		EntityCacheUtil.putResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryExtImpl.class, standardsCountryExt.getPrimaryKey(),
			standardsCountryExt);

		return standardsCountryExt;
	}

	protected StandardsCountryExt toUnwrappedModel(
		StandardsCountryExt standardsCountryExt) {
		if (standardsCountryExt instanceof StandardsCountryExtImpl) {
			return standardsCountryExt;
		}

		StandardsCountryExtImpl standardsCountryExtImpl = new StandardsCountryExtImpl();

		standardsCountryExtImpl.setNew(standardsCountryExt.isNew());
		standardsCountryExtImpl.setPrimaryKey(standardsCountryExt.getPrimaryKey());

		standardsCountryExtImpl.setRowNum(standardsCountryExt.getRowNum());
		standardsCountryExtImpl.setCountryCode(standardsCountryExt.getCountryCode());
		standardsCountryExtImpl.setFlag(standardsCountryExt.getFlag());

		return standardsCountryExtImpl;
	}

	/**
	 * Returns the standards country ext with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country ext
	 * @return the standards country ext
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException if a standards country ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsCountryExtException, SystemException {
		StandardsCountryExt standardsCountryExt = fetchByPrimaryKey(primaryKey);

		if (standardsCountryExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsCountryExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsCountryExt;
	}

	/**
	 * Returns the standards country ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryExtException} if it could not be found.
	 *
	 * @param rowNum the primary key of the standards country ext
	 * @return the standards country ext
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException if a standards country ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryExt findByPrimaryKey(long rowNum)
		throws NoSuchStandardsCountryExtException, SystemException {
		return findByPrimaryKey((Serializable)rowNum);
	}

	/**
	 * Returns the standards country ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country ext
	 * @return the standards country ext, or <code>null</code> if a standards country ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsCountryExt standardsCountryExt = (StandardsCountryExt)EntityCacheUtil.getResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryExtImpl.class, primaryKey);

		if (standardsCountryExt == _nullStandardsCountryExt) {
			return null;
		}

		if (standardsCountryExt == null) {
			Session session = null;

			try {
				session = openSession();

				standardsCountryExt = (StandardsCountryExt)session.get(StandardsCountryExtImpl.class,
						primaryKey);

				if (standardsCountryExt != null) {
					cacheResult(standardsCountryExt);
				}
				else {
					EntityCacheUtil.putResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryExtImpl.class, primaryKey,
						_nullStandardsCountryExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsCountryExtModelImpl.ENTITY_CACHE_ENABLED,
					StandardsCountryExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsCountryExt;
	}

	/**
	 * Returns the standards country ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rowNum the primary key of the standards country ext
	 * @return the standards country ext, or <code>null</code> if a standards country ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryExt fetchByPrimaryKey(long rowNum)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rowNum);
	}

	/**
	 * Returns all the standards country exts.
	 *
	 * @return the standards country exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country exts
	 * @param end the upper bound of the range of standards country exts (not inclusive)
	 * @return the range of standards country exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards country exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country exts
	 * @param end the upper bound of the range of standards country exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards country exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryExt> findAll(int start, int end,
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

		List<StandardsCountryExt> list = (List<StandardsCountryExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCOUNTRYEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCOUNTRYEXT;

				if (pagination) {
					sql = sql.concat(StandardsCountryExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsCountryExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryExt>(list);
				}
				else {
					list = (List<StandardsCountryExt>)QueryUtil.list(q,
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
	 * Removes all the standards country exts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsCountryExt standardsCountryExt : findAll()) {
			remove(standardsCountryExt);
		}
	}

	/**
	 * Returns the number of standards country exts.
	 *
	 * @return the number of standards country exts
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCOUNTRYEXT);

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
	 * Initializes the standards country ext persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsCountryExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsCountryExt>> listenersList = new ArrayList<ModelListener<StandardsCountryExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsCountryExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsCountryExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCOUNTRYEXT = "SELECT standardsCountryExt FROM StandardsCountryExt standardsCountryExt";
	private static final String _SQL_COUNT_STANDARDSCOUNTRYEXT = "SELECT COUNT(standardsCountryExt) FROM StandardsCountryExt standardsCountryExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsCountryExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsCountryExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsCountryExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"rowNum", "countryCode", "flag"
			});
	private static StandardsCountryExt _nullStandardsCountryExt = new StandardsCountryExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsCountryExt> toCacheModel() {
				return _nullStandardsCountryExtCacheModel;
			}
		};

	private static CacheModel<StandardsCountryExt> _nullStandardsCountryExtCacheModel =
		new CacheModel<StandardsCountryExt>() {
			@Override
			public StandardsCountryExt toEntityModel() {
				return _nullStandardsCountryExt;
			}
		};
}