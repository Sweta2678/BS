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

import com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException;
import com.ihg.brandstandards.db.model.TaxonomyTranslate;
import com.ihg.brandstandards.db.model.impl.TaxonomyTranslateImpl;
import com.ihg.brandstandards.db.model.impl.TaxonomyTranslateModelImpl;

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
 * The persistence implementation for the taxonomy translate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyTranslatePersistence
 * @see TaxonomyTranslateUtil
 * @generated
 */
public class TaxonomyTranslatePersistenceImpl extends BasePersistenceImpl<TaxonomyTranslate>
	implements TaxonomyTranslatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxonomyTranslateUtil} to access the taxonomy translate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxonomyTranslateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyTranslateModelImpl.FINDER_CACHE_ENABLED,
			TaxonomyTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyTranslateModelImpl.FINDER_CACHE_ENABLED,
			TaxonomyTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaxonomyTranslatePersistenceImpl() {
		setModelClass(TaxonomyTranslate.class);
	}

	/**
	 * Caches the taxonomy translate in the entity cache if it is enabled.
	 *
	 * @param taxonomyTranslate the taxonomy translate
	 */
	@Override
	public void cacheResult(TaxonomyTranslate taxonomyTranslate) {
		EntityCacheUtil.putResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyTranslateImpl.class, taxonomyTranslate.getPrimaryKey(),
			taxonomyTranslate);

		taxonomyTranslate.resetOriginalValues();
	}

	/**
	 * Caches the taxonomy translates in the entity cache if it is enabled.
	 *
	 * @param taxonomyTranslates the taxonomy translates
	 */
	@Override
	public void cacheResult(List<TaxonomyTranslate> taxonomyTranslates) {
		for (TaxonomyTranslate taxonomyTranslate : taxonomyTranslates) {
			if (EntityCacheUtil.getResult(
						TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyTranslateImpl.class,
						taxonomyTranslate.getPrimaryKey()) == null) {
				cacheResult(taxonomyTranslate);
			}
			else {
				taxonomyTranslate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all taxonomy translates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaxonomyTranslateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaxonomyTranslateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the taxonomy translate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxonomyTranslate taxonomyTranslate) {
		EntityCacheUtil.removeResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyTranslateImpl.class, taxonomyTranslate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaxonomyTranslate> taxonomyTranslates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxonomyTranslate taxonomyTranslate : taxonomyTranslates) {
			EntityCacheUtil.removeResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyTranslateImpl.class, taxonomyTranslate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new taxonomy translate with the primary key. Does not add the taxonomy translate to the database.
	 *
	 * @param taxonomyTranslatePK the primary key for the new taxonomy translate
	 * @return the new taxonomy translate
	 */
	@Override
	public TaxonomyTranslate create(TaxonomyTranslatePK taxonomyTranslatePK) {
		TaxonomyTranslate taxonomyTranslate = new TaxonomyTranslateImpl();

		taxonomyTranslate.setNew(true);
		taxonomyTranslate.setPrimaryKey(taxonomyTranslatePK);

		return taxonomyTranslate;
	}

	/**
	 * Removes the taxonomy translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taxonomyTranslatePK the primary key of the taxonomy translate
	 * @return the taxonomy translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException if a taxonomy translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyTranslate remove(TaxonomyTranslatePK taxonomyTranslatePK)
		throws NoSuchTaxonomyTranslateException, SystemException {
		return remove((Serializable)taxonomyTranslatePK);
	}

	/**
	 * Removes the taxonomy translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the taxonomy translate
	 * @return the taxonomy translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException if a taxonomy translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyTranslate remove(Serializable primaryKey)
		throws NoSuchTaxonomyTranslateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaxonomyTranslate taxonomyTranslate = (TaxonomyTranslate)session.get(TaxonomyTranslateImpl.class,
					primaryKey);

			if (taxonomyTranslate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxonomyTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxonomyTranslate);
		}
		catch (NoSuchTaxonomyTranslateException nsee) {
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
	protected TaxonomyTranslate removeImpl(TaxonomyTranslate taxonomyTranslate)
		throws SystemException {
		taxonomyTranslate = toUnwrappedModel(taxonomyTranslate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxonomyTranslate)) {
				taxonomyTranslate = (TaxonomyTranslate)session.get(TaxonomyTranslateImpl.class,
						taxonomyTranslate.getPrimaryKeyObj());
			}

			if (taxonomyTranslate != null) {
				session.delete(taxonomyTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxonomyTranslate != null) {
			clearCache(taxonomyTranslate);
		}

		return taxonomyTranslate;
	}

	@Override
	public TaxonomyTranslate updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyTranslate taxonomyTranslate)
		throws SystemException {
		taxonomyTranslate = toUnwrappedModel(taxonomyTranslate);

		boolean isNew = taxonomyTranslate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taxonomyTranslate.isNew()) {
				session.save(taxonomyTranslate);

				taxonomyTranslate.setNew(false);
			}
			else {
				session.merge(taxonomyTranslate);
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

		EntityCacheUtil.putResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyTranslateImpl.class, taxonomyTranslate.getPrimaryKey(),
			taxonomyTranslate);

		return taxonomyTranslate;
	}

	protected TaxonomyTranslate toUnwrappedModel(
		TaxonomyTranslate taxonomyTranslate) {
		if (taxonomyTranslate instanceof TaxonomyTranslateImpl) {
			return taxonomyTranslate;
		}

		TaxonomyTranslateImpl taxonomyTranslateImpl = new TaxonomyTranslateImpl();

		taxonomyTranslateImpl.setNew(taxonomyTranslate.isNew());
		taxonomyTranslateImpl.setPrimaryKey(taxonomyTranslate.getPrimaryKey());

		taxonomyTranslateImpl.setTaxId(taxonomyTranslate.getTaxId());
		taxonomyTranslateImpl.setLocaleCode(taxonomyTranslate.getLocaleCode());
		taxonomyTranslateImpl.setTitle(taxonomyTranslate.getTitle());
		taxonomyTranslateImpl.setDesc(taxonomyTranslate.getDesc());
		taxonomyTranslateImpl.setImageLoc(taxonomyTranslate.getImageLoc());
		taxonomyTranslateImpl.setCreatorId(taxonomyTranslate.getCreatorId());
		taxonomyTranslateImpl.setCreatedDate(taxonomyTranslate.getCreatedDate());
		taxonomyTranslateImpl.setUpdatedBy(taxonomyTranslate.getUpdatedBy());
		taxonomyTranslateImpl.setUpdatedDate(taxonomyTranslate.getUpdatedDate());

		return taxonomyTranslateImpl;
	}

	/**
	 * Returns the taxonomy translate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the taxonomy translate
	 * @return the taxonomy translate
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException if a taxonomy translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyTranslate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxonomyTranslateException, SystemException {
		TaxonomyTranslate taxonomyTranslate = fetchByPrimaryKey(primaryKey);

		if (taxonomyTranslate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxonomyTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxonomyTranslate;
	}

	/**
	 * Returns the taxonomy translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException} if it could not be found.
	 *
	 * @param taxonomyTranslatePK the primary key of the taxonomy translate
	 * @return the taxonomy translate
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException if a taxonomy translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyTranslate findByPrimaryKey(
		TaxonomyTranslatePK taxonomyTranslatePK)
		throws NoSuchTaxonomyTranslateException, SystemException {
		return findByPrimaryKey((Serializable)taxonomyTranslatePK);
	}

	/**
	 * Returns the taxonomy translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the taxonomy translate
	 * @return the taxonomy translate, or <code>null</code> if a taxonomy translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyTranslate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaxonomyTranslate taxonomyTranslate = (TaxonomyTranslate)EntityCacheUtil.getResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyTranslateImpl.class, primaryKey);

		if (taxonomyTranslate == _nullTaxonomyTranslate) {
			return null;
		}

		if (taxonomyTranslate == null) {
			Session session = null;

			try {
				session = openSession();

				taxonomyTranslate = (TaxonomyTranslate)session.get(TaxonomyTranslateImpl.class,
						primaryKey);

				if (taxonomyTranslate != null) {
					cacheResult(taxonomyTranslate);
				}
				else {
					EntityCacheUtil.putResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyTranslateImpl.class, primaryKey,
						_nullTaxonomyTranslate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaxonomyTranslateModelImpl.ENTITY_CACHE_ENABLED,
					TaxonomyTranslateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxonomyTranslate;
	}

	/**
	 * Returns the taxonomy translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taxonomyTranslatePK the primary key of the taxonomy translate
	 * @return the taxonomy translate, or <code>null</code> if a taxonomy translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyTranslate fetchByPrimaryKey(
		TaxonomyTranslatePK taxonomyTranslatePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)taxonomyTranslatePK);
	}

	/**
	 * Returns all the taxonomy translates.
	 *
	 * @return the taxonomy translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyTranslate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the taxonomy translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of taxonomy translates
	 * @param end the upper bound of the range of taxonomy translates (not inclusive)
	 * @return the range of taxonomy translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyTranslate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the taxonomy translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of taxonomy translates
	 * @param end the upper bound of the range of taxonomy translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of taxonomy translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyTranslate> findAll(int start, int end,
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

		List<TaxonomyTranslate> list = (List<TaxonomyTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAXONOMYTRANSLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXONOMYTRANSLATE;

				if (pagination) {
					sql = sql.concat(TaxonomyTranslateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxonomyTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaxonomyTranslate>(list);
				}
				else {
					list = (List<TaxonomyTranslate>)QueryUtil.list(q,
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
	 * Removes all the taxonomy translates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaxonomyTranslate taxonomyTranslate : findAll()) {
			remove(taxonomyTranslate);
		}
	}

	/**
	 * Returns the number of taxonomy translates.
	 *
	 * @return the number of taxonomy translates
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

				Query q = session.createQuery(_SQL_COUNT_TAXONOMYTRANSLATE);

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
	 * Initializes the taxonomy translate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.TaxonomyTranslate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaxonomyTranslate>> listenersList = new ArrayList<ModelListener<TaxonomyTranslate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaxonomyTranslate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaxonomyTranslateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAXONOMYTRANSLATE = "SELECT taxonomyTranslate FROM TaxonomyTranslate taxonomyTranslate";
	private static final String _SQL_COUNT_TAXONOMYTRANSLATE = "SELECT COUNT(taxonomyTranslate) FROM TaxonomyTranslate taxonomyTranslate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxonomyTranslate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxonomyTranslate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaxonomyTranslatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"taxId", "localeCode", "title", "desc", "imageLoc", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static TaxonomyTranslate _nullTaxonomyTranslate = new TaxonomyTranslateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaxonomyTranslate> toCacheModel() {
				return _nullTaxonomyTranslateCacheModel;
			}
		};

	private static CacheModel<TaxonomyTranslate> _nullTaxonomyTranslateCacheModel =
		new CacheModel<TaxonomyTranslate>() {
			@Override
			public TaxonomyTranslate toEntityModel() {
				return _nullTaxonomyTranslate;
			}
		};
}