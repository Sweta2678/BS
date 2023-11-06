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

import com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException;
import com.ihg.brandstandards.db.model.StandardsDisplayOrderExt;
import com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtImpl;
import com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl;

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
 * The persistence implementation for the standards display order ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderExtPersistence
 * @see StandardsDisplayOrderExtUtil
 * @generated
 */
public class StandardsDisplayOrderExtPersistenceImpl extends BasePersistenceImpl<StandardsDisplayOrderExt>
	implements StandardsDisplayOrderExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsDisplayOrderExtUtil} to access the standards display order ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsDisplayOrderExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderExtModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderExtModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StandardsDisplayOrderExtPersistenceImpl() {
		setModelClass(StandardsDisplayOrderExt.class);
	}

	/**
	 * Caches the standards display order ext in the entity cache if it is enabled.
	 *
	 * @param standardsDisplayOrderExt the standards display order ext
	 */
	@Override
	public void cacheResult(StandardsDisplayOrderExt standardsDisplayOrderExt) {
		EntityCacheUtil.putResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderExtImpl.class,
			standardsDisplayOrderExt.getPrimaryKey(), standardsDisplayOrderExt);

		standardsDisplayOrderExt.resetOriginalValues();
	}

	/**
	 * Caches the standards display order exts in the entity cache if it is enabled.
	 *
	 * @param standardsDisplayOrderExts the standards display order exts
	 */
	@Override
	public void cacheResult(
		List<StandardsDisplayOrderExt> standardsDisplayOrderExts) {
		for (StandardsDisplayOrderExt standardsDisplayOrderExt : standardsDisplayOrderExts) {
			if (EntityCacheUtil.getResult(
						StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsDisplayOrderExtImpl.class,
						standardsDisplayOrderExt.getPrimaryKey()) == null) {
				cacheResult(standardsDisplayOrderExt);
			}
			else {
				standardsDisplayOrderExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards display order exts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsDisplayOrderExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsDisplayOrderExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards display order ext.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsDisplayOrderExt standardsDisplayOrderExt) {
		EntityCacheUtil.removeResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderExtImpl.class,
			standardsDisplayOrderExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StandardsDisplayOrderExt> standardsDisplayOrderExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsDisplayOrderExt standardsDisplayOrderExt : standardsDisplayOrderExts) {
			EntityCacheUtil.removeResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsDisplayOrderExtImpl.class,
				standardsDisplayOrderExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards display order ext with the primary key. Does not add the standards display order ext to the database.
	 *
	 * @param stdId the primary key for the new standards display order ext
	 * @return the new standards display order ext
	 */
	@Override
	public StandardsDisplayOrderExt create(long stdId) {
		StandardsDisplayOrderExt standardsDisplayOrderExt = new StandardsDisplayOrderExtImpl();

		standardsDisplayOrderExt.setNew(true);
		standardsDisplayOrderExt.setPrimaryKey(stdId);

		return standardsDisplayOrderExt;
	}

	/**
	 * Removes the standards display order ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdId the primary key of the standards display order ext
	 * @return the standards display order ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException if a standards display order ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrderExt remove(long stdId)
		throws NoSuchStandardsDisplayOrderExtException, SystemException {
		return remove((Serializable)stdId);
	}

	/**
	 * Removes the standards display order ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards display order ext
	 * @return the standards display order ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException if a standards display order ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrderExt remove(Serializable primaryKey)
		throws NoSuchStandardsDisplayOrderExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsDisplayOrderExt standardsDisplayOrderExt = (StandardsDisplayOrderExt)session.get(StandardsDisplayOrderExtImpl.class,
					primaryKey);

			if (standardsDisplayOrderExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsDisplayOrderExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsDisplayOrderExt);
		}
		catch (NoSuchStandardsDisplayOrderExtException nsee) {
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
	protected StandardsDisplayOrderExt removeImpl(
		StandardsDisplayOrderExt standardsDisplayOrderExt)
		throws SystemException {
		standardsDisplayOrderExt = toUnwrappedModel(standardsDisplayOrderExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsDisplayOrderExt)) {
				standardsDisplayOrderExt = (StandardsDisplayOrderExt)session.get(StandardsDisplayOrderExtImpl.class,
						standardsDisplayOrderExt.getPrimaryKeyObj());
			}

			if (standardsDisplayOrderExt != null) {
				session.delete(standardsDisplayOrderExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsDisplayOrderExt != null) {
			clearCache(standardsDisplayOrderExt);
		}

		return standardsDisplayOrderExt;
	}

	@Override
	public StandardsDisplayOrderExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsDisplayOrderExt standardsDisplayOrderExt)
		throws SystemException {
		standardsDisplayOrderExt = toUnwrappedModel(standardsDisplayOrderExt);

		boolean isNew = standardsDisplayOrderExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (standardsDisplayOrderExt.isNew()) {
				session.save(standardsDisplayOrderExt);

				standardsDisplayOrderExt.setNew(false);
			}
			else {
				session.merge(standardsDisplayOrderExt);
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

		EntityCacheUtil.putResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderExtImpl.class,
			standardsDisplayOrderExt.getPrimaryKey(), standardsDisplayOrderExt);

		return standardsDisplayOrderExt;
	}

	protected StandardsDisplayOrderExt toUnwrappedModel(
		StandardsDisplayOrderExt standardsDisplayOrderExt) {
		if (standardsDisplayOrderExt instanceof StandardsDisplayOrderExtImpl) {
			return standardsDisplayOrderExt;
		}

		StandardsDisplayOrderExtImpl standardsDisplayOrderExtImpl = new StandardsDisplayOrderExtImpl();

		standardsDisplayOrderExtImpl.setNew(standardsDisplayOrderExt.isNew());
		standardsDisplayOrderExtImpl.setPrimaryKey(standardsDisplayOrderExt.getPrimaryKey());

		standardsDisplayOrderExtImpl.setStdId(standardsDisplayOrderExt.getStdId());
		standardsDisplayOrderExtImpl.setTitle(standardsDisplayOrderExt.getTitle());
		standardsDisplayOrderExtImpl.setIsGlobal(standardsDisplayOrderExt.getIsGlobal());
		standardsDisplayOrderExtImpl.setFramework(standardsDisplayOrderExt.getFramework());
		standardsDisplayOrderExtImpl.setChainCode(standardsDisplayOrderExt.getChainCode());
		standardsDisplayOrderExtImpl.setRegionCode(standardsDisplayOrderExt.getRegionCode());
		standardsDisplayOrderExtImpl.setDisplayOrder(standardsDisplayOrderExt.getDisplayOrder());

		return standardsDisplayOrderExtImpl;
	}

	/**
	 * Returns the standards display order ext with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards display order ext
	 * @return the standards display order ext
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException if a standards display order ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrderExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsDisplayOrderExtException, SystemException {
		StandardsDisplayOrderExt standardsDisplayOrderExt = fetchByPrimaryKey(primaryKey);

		if (standardsDisplayOrderExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsDisplayOrderExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsDisplayOrderExt;
	}

	/**
	 * Returns the standards display order ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException} if it could not be found.
	 *
	 * @param stdId the primary key of the standards display order ext
	 * @return the standards display order ext
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException if a standards display order ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrderExt findByPrimaryKey(long stdId)
		throws NoSuchStandardsDisplayOrderExtException, SystemException {
		return findByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns the standards display order ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards display order ext
	 * @return the standards display order ext, or <code>null</code> if a standards display order ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrderExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsDisplayOrderExt standardsDisplayOrderExt = (StandardsDisplayOrderExt)EntityCacheUtil.getResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsDisplayOrderExtImpl.class, primaryKey);

		if (standardsDisplayOrderExt == _nullStandardsDisplayOrderExt) {
			return null;
		}

		if (standardsDisplayOrderExt == null) {
			Session session = null;

			try {
				session = openSession();

				standardsDisplayOrderExt = (StandardsDisplayOrderExt)session.get(StandardsDisplayOrderExtImpl.class,
						primaryKey);

				if (standardsDisplayOrderExt != null) {
					cacheResult(standardsDisplayOrderExt);
				}
				else {
					EntityCacheUtil.putResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsDisplayOrderExtImpl.class, primaryKey,
						_nullStandardsDisplayOrderExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsDisplayOrderExtModelImpl.ENTITY_CACHE_ENABLED,
					StandardsDisplayOrderExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsDisplayOrderExt;
	}

	/**
	 * Returns the standards display order ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdId the primary key of the standards display order ext
	 * @return the standards display order ext, or <code>null</code> if a standards display order ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrderExt fetchByPrimaryKey(long stdId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns all the standards display order exts.
	 *
	 * @return the standards display order exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrderExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards display order exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards display order exts
	 * @param end the upper bound of the range of standards display order exts (not inclusive)
	 * @return the range of standards display order exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrderExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards display order exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards display order exts
	 * @param end the upper bound of the range of standards display order exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards display order exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrderExt> findAll(int start, int end,
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

		List<StandardsDisplayOrderExt> list = (List<StandardsDisplayOrderExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSDISPLAYORDEREXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSDISPLAYORDEREXT;

				if (pagination) {
					sql = sql.concat(StandardsDisplayOrderExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsDisplayOrderExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsDisplayOrderExt>(list);
				}
				else {
					list = (List<StandardsDisplayOrderExt>)QueryUtil.list(q,
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
	 * Removes all the standards display order exts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsDisplayOrderExt standardsDisplayOrderExt : findAll()) {
			remove(standardsDisplayOrderExt);
		}
	}

	/**
	 * Returns the number of standards display order exts.
	 *
	 * @return the number of standards display order exts
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSDISPLAYORDEREXT);

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
	 * Initializes the standards display order ext persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsDisplayOrderExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsDisplayOrderExt>> listenersList = new ArrayList<ModelListener<StandardsDisplayOrderExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsDisplayOrderExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsDisplayOrderExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSDISPLAYORDEREXT = "SELECT standardsDisplayOrderExt FROM StandardsDisplayOrderExt standardsDisplayOrderExt";
	private static final String _SQL_COUNT_STANDARDSDISPLAYORDEREXT = "SELECT COUNT(standardsDisplayOrderExt) FROM StandardsDisplayOrderExt standardsDisplayOrderExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsDisplayOrderExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsDisplayOrderExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsDisplayOrderExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "title", "isGlobal", "framework", "chainCode",
				"regionCode", "displayOrder"
			});
	private static StandardsDisplayOrderExt _nullStandardsDisplayOrderExt = new StandardsDisplayOrderExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsDisplayOrderExt> toCacheModel() {
				return _nullStandardsDisplayOrderExtCacheModel;
			}
		};

	private static CacheModel<StandardsDisplayOrderExt> _nullStandardsDisplayOrderExtCacheModel =
		new CacheModel<StandardsDisplayOrderExt>() {
			@Override
			public StandardsDisplayOrderExt toEntityModel() {
				return _nullStandardsDisplayOrderExt;
			}
		};
}