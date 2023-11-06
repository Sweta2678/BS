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

import com.ihg.brandstandards.db.NoSuchTreeXMLException;
import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.db.model.impl.TreeXMLImpl;
import com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl;

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
 * The persistence implementation for the tree x m l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TreeXMLPersistence
 * @see TreeXMLUtil
 * @generated
 */
public class TreeXMLPersistenceImpl extends BasePersistenceImpl<TreeXML>
	implements TreeXMLPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TreeXMLUtil} to access the tree x m l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TreeXMLImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
			TreeXMLModelImpl.FINDER_CACHE_ENABLED, TreeXMLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
			TreeXMLModelImpl.FINDER_CACHE_ENABLED, TreeXMLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
			TreeXMLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TreeXMLPersistenceImpl() {
		setModelClass(TreeXML.class);
	}

	/**
	 * Caches the tree x m l in the entity cache if it is enabled.
	 *
	 * @param treeXML the tree x m l
	 */
	@Override
	public void cacheResult(TreeXML treeXML) {
		EntityCacheUtil.putResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
			TreeXMLImpl.class, treeXML.getPrimaryKey(), treeXML);

		treeXML.resetOriginalValues();
	}

	/**
	 * Caches the tree x m ls in the entity cache if it is enabled.
	 *
	 * @param treeXMLs the tree x m ls
	 */
	@Override
	public void cacheResult(List<TreeXML> treeXMLs) {
		for (TreeXML treeXML : treeXMLs) {
			if (EntityCacheUtil.getResult(
						TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
						TreeXMLImpl.class, treeXML.getPrimaryKey()) == null) {
				cacheResult(treeXML);
			}
			else {
				treeXML.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tree x m ls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TreeXMLImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TreeXMLImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tree x m l.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TreeXML treeXML) {
		EntityCacheUtil.removeResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
			TreeXMLImpl.class, treeXML.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TreeXML> treeXMLs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TreeXML treeXML : treeXMLs) {
			EntityCacheUtil.removeResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
				TreeXMLImpl.class, treeXML.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tree x m l with the primary key. Does not add the tree x m l to the database.
	 *
	 * @param ID the primary key for the new tree x m l
	 * @return the new tree x m l
	 */
	@Override
	public TreeXML create(long ID) {
		TreeXML treeXML = new TreeXMLImpl();

		treeXML.setNew(true);
		treeXML.setPrimaryKey(ID);

		return treeXML;
	}

	/**
	 * Removes the tree x m l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the tree x m l
	 * @return the tree x m l that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTreeXMLException if a tree x m l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TreeXML remove(long ID)
		throws NoSuchTreeXMLException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the tree x m l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tree x m l
	 * @return the tree x m l that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTreeXMLException if a tree x m l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TreeXML remove(Serializable primaryKey)
		throws NoSuchTreeXMLException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TreeXML treeXML = (TreeXML)session.get(TreeXMLImpl.class, primaryKey);

			if (treeXML == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTreeXMLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(treeXML);
		}
		catch (NoSuchTreeXMLException nsee) {
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
	protected TreeXML removeImpl(TreeXML treeXML) throws SystemException {
		treeXML = toUnwrappedModel(treeXML);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(treeXML)) {
				treeXML = (TreeXML)session.get(TreeXMLImpl.class,
						treeXML.getPrimaryKeyObj());
			}

			if (treeXML != null) {
				session.delete(treeXML);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (treeXML != null) {
			clearCache(treeXML);
		}

		return treeXML;
	}

	@Override
	public TreeXML updateImpl(com.ihg.brandstandards.db.model.TreeXML treeXML)
		throws SystemException {
		treeXML = toUnwrappedModel(treeXML);

		boolean isNew = treeXML.isNew();

		Session session = null;

		try {
			session = openSession();

			if (treeXML.isNew()) {
				session.save(treeXML);

				treeXML.setNew(false);
			}
			else {
				session.merge(treeXML);
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

		EntityCacheUtil.putResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
			TreeXMLImpl.class, treeXML.getPrimaryKey(), treeXML);

		return treeXML;
	}

	protected TreeXML toUnwrappedModel(TreeXML treeXML) {
		if (treeXML instanceof TreeXMLImpl) {
			return treeXML;
		}

		TreeXMLImpl treeXMLImpl = new TreeXMLImpl();

		treeXMLImpl.setNew(treeXML.isNew());
		treeXMLImpl.setPrimaryKey(treeXML.getPrimaryKey());

		treeXMLImpl.setID(treeXML.getID());
		treeXMLImpl.setXMLLOB(treeXML.getXMLLOB());
		treeXMLImpl.setCreatorId(treeXML.getCreatorId());
		treeXMLImpl.setCreatedDate(treeXML.getCreatedDate());
		treeXMLImpl.setUpdatedBy(treeXML.getUpdatedBy());
		treeXMLImpl.setUpdatedDate(treeXML.getUpdatedDate());

		return treeXMLImpl;
	}

	/**
	 * Returns the tree x m l with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tree x m l
	 * @return the tree x m l
	 * @throws com.ihg.brandstandards.db.NoSuchTreeXMLException if a tree x m l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TreeXML findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTreeXMLException, SystemException {
		TreeXML treeXML = fetchByPrimaryKey(primaryKey);

		if (treeXML == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTreeXMLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return treeXML;
	}

	/**
	 * Returns the tree x m l with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTreeXMLException} if it could not be found.
	 *
	 * @param ID the primary key of the tree x m l
	 * @return the tree x m l
	 * @throws com.ihg.brandstandards.db.NoSuchTreeXMLException if a tree x m l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TreeXML findByPrimaryKey(long ID)
		throws NoSuchTreeXMLException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the tree x m l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tree x m l
	 * @return the tree x m l, or <code>null</code> if a tree x m l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TreeXML fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TreeXML treeXML = (TreeXML)EntityCacheUtil.getResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
				TreeXMLImpl.class, primaryKey);

		if (treeXML == _nullTreeXML) {
			return null;
		}

		if (treeXML == null) {
			Session session = null;

			try {
				session = openSession();

				treeXML = (TreeXML)session.get(TreeXMLImpl.class, primaryKey);

				if (treeXML != null) {
					cacheResult(treeXML);
				}
				else {
					EntityCacheUtil.putResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
						TreeXMLImpl.class, primaryKey, _nullTreeXML);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TreeXMLModelImpl.ENTITY_CACHE_ENABLED,
					TreeXMLImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return treeXML;
	}

	/**
	 * Returns the tree x m l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the tree x m l
	 * @return the tree x m l, or <code>null</code> if a tree x m l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TreeXML fetchByPrimaryKey(long ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the tree x m ls.
	 *
	 * @return the tree x m ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TreeXML> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tree x m ls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tree x m ls
	 * @param end the upper bound of the range of tree x m ls (not inclusive)
	 * @return the range of tree x m ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TreeXML> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tree x m ls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tree x m ls
	 * @param end the upper bound of the range of tree x m ls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tree x m ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TreeXML> findAll(int start, int end,
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

		List<TreeXML> list = (List<TreeXML>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TREEXML);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TREEXML;

				if (pagination) {
					sql = sql.concat(TreeXMLModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TreeXML>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TreeXML>(list);
				}
				else {
					list = (List<TreeXML>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tree x m ls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TreeXML treeXML : findAll()) {
			remove(treeXML);
		}
	}

	/**
	 * Returns the number of tree x m ls.
	 *
	 * @return the number of tree x m ls
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

				Query q = session.createQuery(_SQL_COUNT_TREEXML);

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
	 * Initializes the tree x m l persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.TreeXML")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TreeXML>> listenersList = new ArrayList<ModelListener<TreeXML>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TreeXML>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TreeXMLImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TREEXML = "SELECT treeXML FROM TreeXML treeXML";
	private static final String _SQL_COUNT_TREEXML = "SELECT COUNT(treeXML) FROM TreeXML treeXML";
	private static final String _ORDER_BY_ENTITY_ALIAS = "treeXML.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TreeXML exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TreeXMLPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"ID", "XMLLOB", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static TreeXML _nullTreeXML = new TreeXMLImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TreeXML> toCacheModel() {
				return _nullTreeXMLCacheModel;
			}
		};

	private static CacheModel<TreeXML> _nullTreeXMLCacheModel = new CacheModel<TreeXML>() {
			@Override
			public TreeXML toEntityModel() {
				return _nullTreeXML;
			}
		};
}