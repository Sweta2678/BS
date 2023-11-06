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

import com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException;
import com.ihg.brandstandards.db.model.GEMTemplateColumn;
import com.ihg.brandstandards.db.model.impl.GEMTemplateColumnImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateColumnModelImpl;

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
 * The persistence implementation for the g e m template column service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateColumnPersistence
 * @see GEMTemplateColumnUtil
 * @generated
 */
public class GEMTemplateColumnPersistenceImpl extends BasePersistenceImpl<GEMTemplateColumn>
	implements GEMTemplateColumnPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMTemplateColumnUtil} to access the g e m template column persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMTemplateColumnImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateColumnModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateColumnModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMTemplateColumnPersistenceImpl() {
		setModelClass(GEMTemplateColumn.class);
	}

	/**
	 * Caches the g e m template column in the entity cache if it is enabled.
	 *
	 * @param gemTemplateColumn the g e m template column
	 */
	@Override
	public void cacheResult(GEMTemplateColumn gemTemplateColumn) {
		EntityCacheUtil.putResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateColumnImpl.class, gemTemplateColumn.getPrimaryKey(),
			gemTemplateColumn);

		gemTemplateColumn.resetOriginalValues();
	}

	/**
	 * Caches the g e m template columns in the entity cache if it is enabled.
	 *
	 * @param gemTemplateColumns the g e m template columns
	 */
	@Override
	public void cacheResult(List<GEMTemplateColumn> gemTemplateColumns) {
		for (GEMTemplateColumn gemTemplateColumn : gemTemplateColumns) {
			if (EntityCacheUtil.getResult(
						GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateColumnImpl.class,
						gemTemplateColumn.getPrimaryKey()) == null) {
				cacheResult(gemTemplateColumn);
			}
			else {
				gemTemplateColumn.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m template columns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMTemplateColumnImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMTemplateColumnImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m template column.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMTemplateColumn gemTemplateColumn) {
		EntityCacheUtil.removeResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateColumnImpl.class, gemTemplateColumn.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMTemplateColumn> gemTemplateColumns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMTemplateColumn gemTemplateColumn : gemTemplateColumns) {
			EntityCacheUtil.removeResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateColumnImpl.class, gemTemplateColumn.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m template column with the primary key. Does not add the g e m template column to the database.
	 *
	 * @param columnId the primary key for the new g e m template column
	 * @return the new g e m template column
	 */
	@Override
	public GEMTemplateColumn create(long columnId) {
		GEMTemplateColumn gemTemplateColumn = new GEMTemplateColumnImpl();

		gemTemplateColumn.setNew(true);
		gemTemplateColumn.setPrimaryKey(columnId);

		return gemTemplateColumn;
	}

	/**
	 * Removes the g e m template column with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnId the primary key of the g e m template column
	 * @return the g e m template column that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException if a g e m template column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateColumn remove(long columnId)
		throws NoSuchGEMTemplateColumnException, SystemException {
		return remove((Serializable)columnId);
	}

	/**
	 * Removes the g e m template column with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m template column
	 * @return the g e m template column that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException if a g e m template column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateColumn remove(Serializable primaryKey)
		throws NoSuchGEMTemplateColumnException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMTemplateColumn gemTemplateColumn = (GEMTemplateColumn)session.get(GEMTemplateColumnImpl.class,
					primaryKey);

			if (gemTemplateColumn == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMTemplateColumnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemTemplateColumn);
		}
		catch (NoSuchGEMTemplateColumnException nsee) {
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
	protected GEMTemplateColumn removeImpl(GEMTemplateColumn gemTemplateColumn)
		throws SystemException {
		gemTemplateColumn = toUnwrappedModel(gemTemplateColumn);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemTemplateColumn)) {
				gemTemplateColumn = (GEMTemplateColumn)session.get(GEMTemplateColumnImpl.class,
						gemTemplateColumn.getPrimaryKeyObj());
			}

			if (gemTemplateColumn != null) {
				session.delete(gemTemplateColumn);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemTemplateColumn != null) {
			clearCache(gemTemplateColumn);
		}

		return gemTemplateColumn;
	}

	@Override
	public GEMTemplateColumn updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateColumn gemTemplateColumn)
		throws SystemException {
		gemTemplateColumn = toUnwrappedModel(gemTemplateColumn);

		boolean isNew = gemTemplateColumn.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemTemplateColumn.isNew()) {
				session.save(gemTemplateColumn);

				gemTemplateColumn.setNew(false);
			}
			else {
				session.merge(gemTemplateColumn);
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

		EntityCacheUtil.putResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateColumnImpl.class, gemTemplateColumn.getPrimaryKey(),
			gemTemplateColumn);

		return gemTemplateColumn;
	}

	protected GEMTemplateColumn toUnwrappedModel(
		GEMTemplateColumn gemTemplateColumn) {
		if (gemTemplateColumn instanceof GEMTemplateColumnImpl) {
			return gemTemplateColumn;
		}

		GEMTemplateColumnImpl gemTemplateColumnImpl = new GEMTemplateColumnImpl();

		gemTemplateColumnImpl.setNew(gemTemplateColumn.isNew());
		gemTemplateColumnImpl.setPrimaryKey(gemTemplateColumn.getPrimaryKey());

		gemTemplateColumnImpl.setColumnId(gemTemplateColumn.getColumnId());
		gemTemplateColumnImpl.setTemplateId(gemTemplateColumn.getTemplateId());
		gemTemplateColumnImpl.setColumnName(gemTemplateColumn.getColumnName());
		gemTemplateColumnImpl.setValueType(gemTemplateColumn.getValueType());
		gemTemplateColumnImpl.setDefaultValue(gemTemplateColumn.getDefaultValue());
		gemTemplateColumnImpl.setIsMandatory(gemTemplateColumn.getIsMandatory());
		gemTemplateColumnImpl.setDisplayOrderNumber(gemTemplateColumn.getDisplayOrderNumber());
		gemTemplateColumnImpl.setCreatorId(gemTemplateColumn.getCreatorId());
		gemTemplateColumnImpl.setCreatedDate(gemTemplateColumn.getCreatedDate());
		gemTemplateColumnImpl.setUpdatedBy(gemTemplateColumn.getUpdatedBy());
		gemTemplateColumnImpl.setUpdatedDate(gemTemplateColumn.getUpdatedDate());

		return gemTemplateColumnImpl;
	}

	/**
	 * Returns the g e m template column with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template column
	 * @return the g e m template column
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException if a g e m template column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateColumn findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMTemplateColumnException, SystemException {
		GEMTemplateColumn gemTemplateColumn = fetchByPrimaryKey(primaryKey);

		if (gemTemplateColumn == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMTemplateColumnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemTemplateColumn;
	}

	/**
	 * Returns the g e m template column with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException} if it could not be found.
	 *
	 * @param columnId the primary key of the g e m template column
	 * @return the g e m template column
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException if a g e m template column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateColumn findByPrimaryKey(long columnId)
		throws NoSuchGEMTemplateColumnException, SystemException {
		return findByPrimaryKey((Serializable)columnId);
	}

	/**
	 * Returns the g e m template column with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template column
	 * @return the g e m template column, or <code>null</code> if a g e m template column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateColumn fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMTemplateColumn gemTemplateColumn = (GEMTemplateColumn)EntityCacheUtil.getResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateColumnImpl.class, primaryKey);

		if (gemTemplateColumn == _nullGEMTemplateColumn) {
			return null;
		}

		if (gemTemplateColumn == null) {
			Session session = null;

			try {
				session = openSession();

				gemTemplateColumn = (GEMTemplateColumn)session.get(GEMTemplateColumnImpl.class,
						primaryKey);

				if (gemTemplateColumn != null) {
					cacheResult(gemTemplateColumn);
				}
				else {
					EntityCacheUtil.putResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateColumnImpl.class, primaryKey,
						_nullGEMTemplateColumn);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMTemplateColumnModelImpl.ENTITY_CACHE_ENABLED,
					GEMTemplateColumnImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemTemplateColumn;
	}

	/**
	 * Returns the g e m template column with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnId the primary key of the g e m template column
	 * @return the g e m template column, or <code>null</code> if a g e m template column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateColumn fetchByPrimaryKey(long columnId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)columnId);
	}

	/**
	 * Returns all the g e m template columns.
	 *
	 * @return the g e m template columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateColumn> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m template columns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template columns
	 * @param end the upper bound of the range of g e m template columns (not inclusive)
	 * @return the range of g e m template columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateColumn> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m template columns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template columns
	 * @param end the upper bound of the range of g e m template columns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m template columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateColumn> findAll(int start, int end,
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

		List<GEMTemplateColumn> list = (List<GEMTemplateColumn>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMTEMPLATECOLUMN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMTEMPLATECOLUMN;

				if (pagination) {
					sql = sql.concat(GEMTemplateColumnModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMTemplateColumn>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplateColumn>(list);
				}
				else {
					list = (List<GEMTemplateColumn>)QueryUtil.list(q,
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
	 * Removes all the g e m template columns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMTemplateColumn gemTemplateColumn : findAll()) {
			remove(gemTemplateColumn);
		}
	}

	/**
	 * Returns the number of g e m template columns.
	 *
	 * @return the number of g e m template columns
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

				Query q = session.createQuery(_SQL_COUNT_GEMTEMPLATECOLUMN);

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
	 * Initializes the g e m template column persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMTemplateColumn")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMTemplateColumn>> listenersList = new ArrayList<ModelListener<GEMTemplateColumn>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMTemplateColumn>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMTemplateColumnImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMTEMPLATECOLUMN = "SELECT gemTemplateColumn FROM GEMTemplateColumn gemTemplateColumn";
	private static final String _SQL_COUNT_GEMTEMPLATECOLUMN = "SELECT COUNT(gemTemplateColumn) FROM GEMTemplateColumn gemTemplateColumn";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemTemplateColumn.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMTemplateColumn exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMTemplateColumnPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"columnId", "templateId", "columnName", "valueType",
				"defaultValue", "isMandatory", "displayOrderNumber", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMTemplateColumn _nullGEMTemplateColumn = new GEMTemplateColumnImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMTemplateColumn> toCacheModel() {
				return _nullGEMTemplateColumnCacheModel;
			}
		};

	private static CacheModel<GEMTemplateColumn> _nullGEMTemplateColumnCacheModel =
		new CacheModel<GEMTemplateColumn>() {
			@Override
			public GEMTemplateColumn toEntityModel() {
				return _nullGEMTemplateColumn;
			}
		};
}