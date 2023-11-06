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

package com.ihg.grs.common.service.persistence;

import com.ihg.grs.common.NoSuchGlossaryException;
import com.ihg.grs.common.model.Glossary;
import com.ihg.grs.common.model.impl.GlossaryImpl;
import com.ihg.grs.common.model.impl.GlossaryModelImpl;

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
 * The persistence implementation for the glossary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gulam.vora
 * @see GlossaryPersistence
 * @see GlossaryUtil
 * @generated
 */
public class GlossaryPersistenceImpl extends BasePersistenceImpl<Glossary>
	implements GlossaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GlossaryUtil} to access the glossary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GlossaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, GlossaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, GlossaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GlossaryPersistenceImpl() {
		setModelClass(Glossary.class);
	}

	/**
	 * Caches the glossary in the entity cache if it is enabled.
	 *
	 * @param glossary the glossary
	 */
	@Override
	public void cacheResult(Glossary glossary) {
		EntityCacheUtil.putResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryImpl.class, glossary.getPrimaryKey(), glossary);

		glossary.resetOriginalValues();
	}

	/**
	 * Caches the glossaries in the entity cache if it is enabled.
	 *
	 * @param glossaries the glossaries
	 */
	@Override
	public void cacheResult(List<Glossary> glossaries) {
		for (Glossary glossary : glossaries) {
			if (EntityCacheUtil.getResult(
						GlossaryModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryImpl.class, glossary.getPrimaryKey()) == null) {
				cacheResult(glossary);
			}
			else {
				glossary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all glossaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GlossaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GlossaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the glossary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Glossary glossary) {
		EntityCacheUtil.removeResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryImpl.class, glossary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Glossary> glossaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Glossary glossary : glossaries) {
			EntityCacheUtil.removeResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryImpl.class, glossary.getPrimaryKey());
		}
	}

	/**
	 * Creates a new glossary with the primary key. Does not add the glossary to the database.
	 *
	 * @param glossaryId the primary key for the new glossary
	 * @return the new glossary
	 */
	@Override
	public Glossary create(int glossaryId) {
		Glossary glossary = new GlossaryImpl();

		glossary.setNew(true);
		glossary.setPrimaryKey(glossaryId);

		return glossary;
	}

	/**
	 * Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param glossaryId the primary key of the glossary
	 * @return the glossary that was removed
	 * @throws com.ihg.grs.common.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary remove(int glossaryId)
		throws NoSuchGlossaryException, SystemException {
		return remove((Serializable)glossaryId);
	}

	/**
	 * Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the glossary
	 * @return the glossary that was removed
	 * @throws com.ihg.grs.common.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary remove(Serializable primaryKey)
		throws NoSuchGlossaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Glossary glossary = (Glossary)session.get(GlossaryImpl.class,
					primaryKey);

			if (glossary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlossaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(glossary);
		}
		catch (NoSuchGlossaryException nsee) {
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
	protected Glossary removeImpl(Glossary glossary) throws SystemException {
		glossary = toUnwrappedModel(glossary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(glossary)) {
				glossary = (Glossary)session.get(GlossaryImpl.class,
						glossary.getPrimaryKeyObj());
			}

			if (glossary != null) {
				session.delete(glossary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (glossary != null) {
			clearCache(glossary);
		}

		return glossary;
	}

	@Override
	public Glossary updateImpl(com.ihg.grs.common.model.Glossary glossary)
		throws SystemException {
		glossary = toUnwrappedModel(glossary);

		boolean isNew = glossary.isNew();

		Session session = null;

		try {
			session = openSession();

			if (glossary.isNew()) {
				session.save(glossary);

				glossary.setNew(false);
			}
			else {
				session.merge(glossary);
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

		EntityCacheUtil.putResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryImpl.class, glossary.getPrimaryKey(), glossary);

		return glossary;
	}

	protected Glossary toUnwrappedModel(Glossary glossary) {
		if (glossary instanceof GlossaryImpl) {
			return glossary;
		}

		GlossaryImpl glossaryImpl = new GlossaryImpl();

		glossaryImpl.setNew(glossary.isNew());
		glossaryImpl.setPrimaryKey(glossary.getPrimaryKey());

		glossaryImpl.setGlossaryId(glossary.getGlossaryId());
		glossaryImpl.setTerm(glossary.getTerm());
		glossaryImpl.setDescription(glossary.getDescription());
		glossaryImpl.setActiveIndicator(glossary.getActiveIndicator());
		glossaryImpl.setCreateUserId(glossary.getCreateUserId());
		glossaryImpl.setCreatedate(glossary.getCreatedate());
		glossaryImpl.setLastUpdateUserId(glossary.getLastUpdateUserId());
		glossaryImpl.setUpdatedate(glossary.getUpdatedate());

		return glossaryImpl;
	}

	/**
	 * Returns the glossary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary
	 * @return the glossary
	 * @throws com.ihg.grs.common.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlossaryException, SystemException {
		Glossary glossary = fetchByPrimaryKey(primaryKey);

		if (glossary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlossaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return glossary;
	}

	/**
	 * Returns the glossary with the primary key or throws a {@link com.ihg.grs.common.NoSuchGlossaryException} if it could not be found.
	 *
	 * @param glossaryId the primary key of the glossary
	 * @return the glossary
	 * @throws com.ihg.grs.common.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByPrimaryKey(int glossaryId)
		throws NoSuchGlossaryException, SystemException {
		return findByPrimaryKey((Serializable)glossaryId);
	}

	/**
	 * Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary
	 * @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Glossary glossary = (Glossary)EntityCacheUtil.getResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryImpl.class, primaryKey);

		if (glossary == _nullGlossary) {
			return null;
		}

		if (glossary == null) {
			Session session = null;

			try {
				session = openSession();

				glossary = (Glossary)session.get(GlossaryImpl.class, primaryKey);

				if (glossary != null) {
					cacheResult(glossary);
				}
				else {
					EntityCacheUtil.putResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryImpl.class, primaryKey, _nullGlossary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
					GlossaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return glossary;
	}

	/**
	 * Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param glossaryId the primary key of the glossary
	 * @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByPrimaryKey(int glossaryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)glossaryId);
	}

	/**
	 * Returns all the glossaries.
	 *
	 * @return the glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossaries
	 * @param end the upper bound of the range of glossaries (not inclusive)
	 * @return the range of glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossaries
	 * @param end the upper bound of the range of glossaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findAll(int start, int end,
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

		List<Glossary> list = (List<Glossary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GLOSSARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOSSARY;

				if (pagination) {
					sql = sql.concat(GlossaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Glossary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Glossary>(list);
				}
				else {
					list = (List<Glossary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the glossaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Glossary glossary : findAll()) {
			remove(glossary);
		}
	}

	/**
	 * Returns the number of glossaries.
	 *
	 * @return the number of glossaries
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

				Query q = session.createQuery(_SQL_COUNT_GLOSSARY);

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
	 * Initializes the glossary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.grs.common.model.Glossary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Glossary>> listenersList = new ArrayList<ModelListener<Glossary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Glossary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GlossaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GLOSSARY = "SELECT glossary FROM Glossary glossary";
	private static final String _SQL_COUNT_GLOSSARY = "SELECT COUNT(glossary) FROM Glossary glossary";
	private static final String _ORDER_BY_ENTITY_ALIAS = "glossary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Glossary exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GlossaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"glossaryId", "term", "description", "activeIndicator",
				"createUserId", "createdate", "lastUpdateUserId", "updatedate"
			});
	private static Glossary _nullGlossary = new GlossaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Glossary> toCacheModel() {
				return _nullGlossaryCacheModel;
			}
		};

	private static CacheModel<Glossary> _nullGlossaryCacheModel = new CacheModel<Glossary>() {
			@Override
			public Glossary toEntityModel() {
				return _nullGlossary;
			}
		};
}