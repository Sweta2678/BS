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

import com.ihg.grs.common.NoSuchDirectoryException;
import com.ihg.grs.common.model.Directory;
import com.ihg.grs.common.model.impl.DirectoryImpl;
import com.ihg.grs.common.model.impl.DirectoryModelImpl;

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
 * The persistence implementation for the directory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gulam.vora
 * @see DirectoryPersistence
 * @see DirectoryUtil
 * @generated
 */
public class DirectoryPersistenceImpl extends BasePersistenceImpl<Directory>
	implements DirectoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DirectoryUtil} to access the directory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DirectoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
			DirectoryModelImpl.FINDER_CACHE_ENABLED, DirectoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
			DirectoryModelImpl.FINDER_CACHE_ENABLED, DirectoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
			DirectoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DirectoryPersistenceImpl() {
		setModelClass(Directory.class);
	}

	/**
	 * Caches the directory in the entity cache if it is enabled.
	 *
	 * @param directory the directory
	 */
	@Override
	public void cacheResult(Directory directory) {
		EntityCacheUtil.putResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
			DirectoryImpl.class, directory.getPrimaryKey(), directory);

		directory.resetOriginalValues();
	}

	/**
	 * Caches the directories in the entity cache if it is enabled.
	 *
	 * @param directories the directories
	 */
	@Override
	public void cacheResult(List<Directory> directories) {
		for (Directory directory : directories) {
			if (EntityCacheUtil.getResult(
						DirectoryModelImpl.ENTITY_CACHE_ENABLED,
						DirectoryImpl.class, directory.getPrimaryKey()) == null) {
				cacheResult(directory);
			}
			else {
				directory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all directories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DirectoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DirectoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the directory.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Directory directory) {
		EntityCacheUtil.removeResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
			DirectoryImpl.class, directory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Directory> directories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Directory directory : directories) {
			EntityCacheUtil.removeResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
				DirectoryImpl.class, directory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new directory with the primary key. Does not add the directory to the database.
	 *
	 * @param directoryId the primary key for the new directory
	 * @return the new directory
	 */
	@Override
	public Directory create(int directoryId) {
		Directory directory = new DirectoryImpl();

		directory.setNew(true);
		directory.setPrimaryKey(directoryId);

		return directory;
	}

	/**
	 * Removes the directory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param directoryId the primary key of the directory
	 * @return the directory that was removed
	 * @throws com.ihg.grs.common.NoSuchDirectoryException if a directory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Directory remove(int directoryId)
		throws NoSuchDirectoryException, SystemException {
		return remove((Serializable)directoryId);
	}

	/**
	 * Removes the directory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the directory
	 * @return the directory that was removed
	 * @throws com.ihg.grs.common.NoSuchDirectoryException if a directory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Directory remove(Serializable primaryKey)
		throws NoSuchDirectoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Directory directory = (Directory)session.get(DirectoryImpl.class,
					primaryKey);

			if (directory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDirectoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(directory);
		}
		catch (NoSuchDirectoryException nsee) {
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
	protected Directory removeImpl(Directory directory)
		throws SystemException {
		directory = toUnwrappedModel(directory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(directory)) {
				directory = (Directory)session.get(DirectoryImpl.class,
						directory.getPrimaryKeyObj());
			}

			if (directory != null) {
				session.delete(directory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (directory != null) {
			clearCache(directory);
		}

		return directory;
	}

	@Override
	public Directory updateImpl(com.ihg.grs.common.model.Directory directory)
		throws SystemException {
		directory = toUnwrappedModel(directory);

		boolean isNew = directory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (directory.isNew()) {
				session.save(directory);

				directory.setNew(false);
			}
			else {
				session.merge(directory);
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

		EntityCacheUtil.putResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
			DirectoryImpl.class, directory.getPrimaryKey(), directory);

		return directory;
	}

	protected Directory toUnwrappedModel(Directory directory) {
		if (directory instanceof DirectoryImpl) {
			return directory;
		}

		DirectoryImpl directoryImpl = new DirectoryImpl();

		directoryImpl.setNew(directory.isNew());
		directoryImpl.setPrimaryKey(directory.getPrimaryKey());

		directoryImpl.setDirectoryId(directory.getDirectoryId());
		directoryImpl.setFirstName(directory.getFirstName());
		directoryImpl.setLastName(directory.getLastName());
		directoryImpl.setBusinessTitle(directory.getBusinessTitle());
		directoryImpl.setGeoRegion(directory.getGeoRegion());
		directoryImpl.setRole(directory.getRole());
		directoryImpl.setRegionType(directory.getRegionType());
		directoryImpl.setOrganizationName(directory.getOrganizationName());
		directoryImpl.setPortraitURL(directory.getPortraitURL());
		directoryImpl.setCreatedate(directory.getCreatedate());
		directoryImpl.setCreateUserId(directory.getCreateUserId());
		directoryImpl.setLastUpdateUserId(directory.getLastUpdateUserId());
		directoryImpl.setUpdatedate(directory.getUpdatedate());
		directoryImpl.setEmail(directory.getEmail());

		return directoryImpl;
	}

	/**
	 * Returns the directory with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the directory
	 * @return the directory
	 * @throws com.ihg.grs.common.NoSuchDirectoryException if a directory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Directory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDirectoryException, SystemException {
		Directory directory = fetchByPrimaryKey(primaryKey);

		if (directory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDirectoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return directory;
	}

	/**
	 * Returns the directory with the primary key or throws a {@link com.ihg.grs.common.NoSuchDirectoryException} if it could not be found.
	 *
	 * @param directoryId the primary key of the directory
	 * @return the directory
	 * @throws com.ihg.grs.common.NoSuchDirectoryException if a directory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Directory findByPrimaryKey(int directoryId)
		throws NoSuchDirectoryException, SystemException {
		return findByPrimaryKey((Serializable)directoryId);
	}

	/**
	 * Returns the directory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the directory
	 * @return the directory, or <code>null</code> if a directory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Directory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Directory directory = (Directory)EntityCacheUtil.getResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
				DirectoryImpl.class, primaryKey);

		if (directory == _nullDirectory) {
			return null;
		}

		if (directory == null) {
			Session session = null;

			try {
				session = openSession();

				directory = (Directory)session.get(DirectoryImpl.class,
						primaryKey);

				if (directory != null) {
					cacheResult(directory);
				}
				else {
					EntityCacheUtil.putResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
						DirectoryImpl.class, primaryKey, _nullDirectory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DirectoryModelImpl.ENTITY_CACHE_ENABLED,
					DirectoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return directory;
	}

	/**
	 * Returns the directory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param directoryId the primary key of the directory
	 * @return the directory, or <code>null</code> if a directory with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Directory fetchByPrimaryKey(int directoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)directoryId);
	}

	/**
	 * Returns all the directories.
	 *
	 * @return the directories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Directory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the directories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.DirectoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of directories
	 * @param end the upper bound of the range of directories (not inclusive)
	 * @return the range of directories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Directory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the directories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.DirectoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of directories
	 * @param end the upper bound of the range of directories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of directories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Directory> findAll(int start, int end,
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

		List<Directory> list = (List<Directory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DIRECTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIRECTORY;

				if (pagination) {
					sql = sql.concat(DirectoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Directory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Directory>(list);
				}
				else {
					list = (List<Directory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the directories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Directory directory : findAll()) {
			remove(directory);
		}
	}

	/**
	 * Returns the number of directories.
	 *
	 * @return the number of directories
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

				Query q = session.createQuery(_SQL_COUNT_DIRECTORY);

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
	 * Initializes the directory persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.grs.common.model.Directory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Directory>> listenersList = new ArrayList<ModelListener<Directory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Directory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DirectoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DIRECTORY = "SELECT directory FROM Directory directory";
	private static final String _SQL_COUNT_DIRECTORY = "SELECT COUNT(directory) FROM Directory directory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "directory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Directory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DirectoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"directoryId", "firstName", "lastName", "businessTitle",
				"geoRegion", "role", "regionType", "organizationName",
				"portraitURL", "createdate", "createUserId", "lastUpdateUserId",
				"updatedate", "email"
			});
	private static Directory _nullDirectory = new DirectoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Directory> toCacheModel() {
				return _nullDirectoryCacheModel;
			}
		};

	private static CacheModel<Directory> _nullDirectoryCacheModel = new CacheModel<Directory>() {
			@Override
			public Directory toEntityModel() {
				return _nullDirectory;
			}
		};
}