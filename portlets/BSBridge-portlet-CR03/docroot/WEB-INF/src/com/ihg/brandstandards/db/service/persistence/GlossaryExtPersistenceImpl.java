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

import com.ihg.brandstandards.db.NoSuchGlossaryExtException;
import com.ihg.brandstandards.db.model.GlossaryExt;
import com.ihg.brandstandards.db.model.impl.GlossaryExtImpl;
import com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl;

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
 * The persistence implementation for the glossary ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryExtPersistence
 * @see GlossaryExtUtil
 * @generated
 */
public class GlossaryExtPersistenceImpl extends BasePersistenceImpl<GlossaryExt>
	implements GlossaryExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GlossaryExtUtil} to access the glossary ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GlossaryExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryExtModelImpl.FINDER_CACHE_ENABLED, GlossaryExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryExtModelImpl.FINDER_CACHE_ENABLED, GlossaryExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GlossaryExtPersistenceImpl() {
		setModelClass(GlossaryExt.class);
	}

	/**
	 * Caches the glossary ext in the entity cache if it is enabled.
	 *
	 * @param glossaryExt the glossary ext
	 */
	@Override
	public void cacheResult(GlossaryExt glossaryExt) {
		EntityCacheUtil.putResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryExtImpl.class, glossaryExt.getPrimaryKey(), glossaryExt);

		glossaryExt.resetOriginalValues();
	}

	/**
	 * Caches the glossary exts in the entity cache if it is enabled.
	 *
	 * @param glossaryExts the glossary exts
	 */
	@Override
	public void cacheResult(List<GlossaryExt> glossaryExts) {
		for (GlossaryExt glossaryExt : glossaryExts) {
			if (EntityCacheUtil.getResult(
						GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryExtImpl.class, glossaryExt.getPrimaryKey()) == null) {
				cacheResult(glossaryExt);
			}
			else {
				glossaryExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all glossary exts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GlossaryExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GlossaryExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the glossary ext.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GlossaryExt glossaryExt) {
		EntityCacheUtil.removeResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryExtImpl.class, glossaryExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GlossaryExt> glossaryExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GlossaryExt glossaryExt : glossaryExts) {
			EntityCacheUtil.removeResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryExtImpl.class, glossaryExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new glossary ext with the primary key. Does not add the glossary ext to the database.
	 *
	 * @param glossaryId the primary key for the new glossary ext
	 * @return the new glossary ext
	 */
	@Override
	public GlossaryExt create(long glossaryId) {
		GlossaryExt glossaryExt = new GlossaryExtImpl();

		glossaryExt.setNew(true);
		glossaryExt.setPrimaryKey(glossaryId);

		return glossaryExt;
	}

	/**
	 * Removes the glossary ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param glossaryId the primary key of the glossary ext
	 * @return the glossary ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryExtException if a glossary ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryExt remove(long glossaryId)
		throws NoSuchGlossaryExtException, SystemException {
		return remove((Serializable)glossaryId);
	}

	/**
	 * Removes the glossary ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the glossary ext
	 * @return the glossary ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryExtException if a glossary ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryExt remove(Serializable primaryKey)
		throws NoSuchGlossaryExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GlossaryExt glossaryExt = (GlossaryExt)session.get(GlossaryExtImpl.class,
					primaryKey);

			if (glossaryExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlossaryExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(glossaryExt);
		}
		catch (NoSuchGlossaryExtException nsee) {
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
	protected GlossaryExt removeImpl(GlossaryExt glossaryExt)
		throws SystemException {
		glossaryExt = toUnwrappedModel(glossaryExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(glossaryExt)) {
				glossaryExt = (GlossaryExt)session.get(GlossaryExtImpl.class,
						glossaryExt.getPrimaryKeyObj());
			}

			if (glossaryExt != null) {
				session.delete(glossaryExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (glossaryExt != null) {
			clearCache(glossaryExt);
		}

		return glossaryExt;
	}

	@Override
	public GlossaryExt updateImpl(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws SystemException {
		glossaryExt = toUnwrappedModel(glossaryExt);

		boolean isNew = glossaryExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (glossaryExt.isNew()) {
				session.save(glossaryExt);

				glossaryExt.setNew(false);
			}
			else {
				session.merge(glossaryExt);
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

		EntityCacheUtil.putResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryExtImpl.class, glossaryExt.getPrimaryKey(), glossaryExt);

		return glossaryExt;
	}

	protected GlossaryExt toUnwrappedModel(GlossaryExt glossaryExt) {
		if (glossaryExt instanceof GlossaryExtImpl) {
			return glossaryExt;
		}

		GlossaryExtImpl glossaryExtImpl = new GlossaryExtImpl();

		glossaryExtImpl.setNew(glossaryExt.isNew());
		glossaryExtImpl.setPrimaryKey(glossaryExt.getPrimaryKey());

		glossaryExtImpl.setGlossaryId(glossaryExt.getGlossaryId());
		glossaryExtImpl.setActiveInd(glossaryExt.getActiveInd());
		glossaryExtImpl.setGlossaryTermText(glossaryExt.getGlossaryTermText());
		glossaryExtImpl.setGlossaryTermDesc(glossaryExt.getGlossaryTermDesc());
		glossaryExtImpl.setGlossaryRegions(glossaryExt.getGlossaryRegions());
		glossaryExtImpl.setGlossaryChains(glossaryExt.getGlossaryChains());

		return glossaryExtImpl;
	}

	/**
	 * Returns the glossary ext with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary ext
	 * @return the glossary ext
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryExtException if a glossary ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlossaryExtException, SystemException {
		GlossaryExt glossaryExt = fetchByPrimaryKey(primaryKey);

		if (glossaryExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlossaryExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return glossaryExt;
	}

	/**
	 * Returns the glossary ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryExtException} if it could not be found.
	 *
	 * @param glossaryId the primary key of the glossary ext
	 * @return the glossary ext
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryExtException if a glossary ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryExt findByPrimaryKey(long glossaryId)
		throws NoSuchGlossaryExtException, SystemException {
		return findByPrimaryKey((Serializable)glossaryId);
	}

	/**
	 * Returns the glossary ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary ext
	 * @return the glossary ext, or <code>null</code> if a glossary ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GlossaryExt glossaryExt = (GlossaryExt)EntityCacheUtil.getResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryExtImpl.class, primaryKey);

		if (glossaryExt == _nullGlossaryExt) {
			return null;
		}

		if (glossaryExt == null) {
			Session session = null;

			try {
				session = openSession();

				glossaryExt = (GlossaryExt)session.get(GlossaryExtImpl.class,
						primaryKey);

				if (glossaryExt != null) {
					cacheResult(glossaryExt);
				}
				else {
					EntityCacheUtil.putResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryExtImpl.class, primaryKey, _nullGlossaryExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GlossaryExtModelImpl.ENTITY_CACHE_ENABLED,
					GlossaryExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return glossaryExt;
	}

	/**
	 * Returns the glossary ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param glossaryId the primary key of the glossary ext
	 * @return the glossary ext, or <code>null</code> if a glossary ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryExt fetchByPrimaryKey(long glossaryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)glossaryId);
	}

	/**
	 * Returns all the glossary exts.
	 *
	 * @return the glossary exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossary exts
	 * @param end the upper bound of the range of glossary exts (not inclusive)
	 * @return the range of glossary exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossary exts
	 * @param end the upper bound of the range of glossary exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of glossary exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryExt> findAll(int start, int end,
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

		List<GlossaryExt> list = (List<GlossaryExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GLOSSARYEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOSSARYEXT;

				if (pagination) {
					sql = sql.concat(GlossaryExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GlossaryExt>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryExt>(list);
				}
				else {
					list = (List<GlossaryExt>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the glossary exts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GlossaryExt glossaryExt : findAll()) {
			remove(glossaryExt);
		}
	}

	/**
	 * Returns the number of glossary exts.
	 *
	 * @return the number of glossary exts
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

				Query q = session.createQuery(_SQL_COUNT_GLOSSARYEXT);

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
	 * Initializes the glossary ext persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GlossaryExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GlossaryExt>> listenersList = new ArrayList<ModelListener<GlossaryExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GlossaryExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GlossaryExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GLOSSARYEXT = "SELECT glossaryExt FROM GlossaryExt glossaryExt";
	private static final String _SQL_COUNT_GLOSSARYEXT = "SELECT COUNT(glossaryExt) FROM GlossaryExt glossaryExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "glossaryExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GlossaryExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GlossaryExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"glossaryId", "activeInd", "glossaryTermText",
				"glossaryTermDesc", "glossaryRegions", "glossaryChains"
			});
	private static GlossaryExt _nullGlossaryExt = new GlossaryExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GlossaryExt> toCacheModel() {
				return _nullGlossaryExtCacheModel;
			}
		};

	private static CacheModel<GlossaryExt> _nullGlossaryExtCacheModel = new CacheModel<GlossaryExt>() {
			@Override
			public GlossaryExt toEntityModel() {
				return _nullGlossaryExt;
			}
		};
}