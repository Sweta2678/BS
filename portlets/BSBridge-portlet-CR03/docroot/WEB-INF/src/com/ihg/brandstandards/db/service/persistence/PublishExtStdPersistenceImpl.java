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

import com.ihg.brandstandards.db.NoSuchPublishExtStdException;
import com.ihg.brandstandards.db.model.PublishExtStd;
import com.ihg.brandstandards.db.model.impl.PublishExtStdImpl;
import com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl;

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
 * The persistence implementation for the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishExtStdPersistence
 * @see PublishExtStdUtil
 * @generated
 */
public class PublishExtStdPersistenceImpl extends BasePersistenceImpl<PublishExtStd>
	implements PublishExtStdPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishExtStdUtil} to access the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishExtStdImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishExtStdModelImpl.FINDER_CACHE_ENABLED,
			PublishExtStdImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishExtStdModelImpl.FINDER_CACHE_ENABLED,
			PublishExtStdImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishExtStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PublishExtStdPersistenceImpl() {
		setModelClass(PublishExtStd.class);
	}

	/**
	 * Caches the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. in the entity cache if it is enabled.
	 *
	 * @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 */
	@Override
	public void cacheResult(PublishExtStd publishExtStd) {
		EntityCacheUtil.putResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishExtStdImpl.class, publishExtStd.getPrimaryKey(),
			publishExtStd);

		publishExtStd.resetOriginalValues();
	}

	/**
	 * Caches the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s in the entity cache if it is enabled.
	 *
	 * @param publishExtStds the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	 */
	@Override
	public void cacheResult(List<PublishExtStd> publishExtStds) {
		for (PublishExtStd publishExtStd : publishExtStds) {
			if (EntityCacheUtil.getResult(
						PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
						PublishExtStdImpl.class, publishExtStd.getPrimaryKey()) == null) {
				cacheResult(publishExtStd);
			}
			else {
				publishExtStd.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishExtStdImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishExtStdImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishExtStd publishExtStd) {
		EntityCacheUtil.removeResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishExtStdImpl.class, publishExtStd.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PublishExtStd> publishExtStds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishExtStd publishExtStd : publishExtStds) {
			EntityCacheUtil.removeResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
				PublishExtStdImpl.class, publishExtStd.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key. Does not add the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. to the database.
	 *
	 * @param stdId the primary key for the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 */
	@Override
	public PublishExtStd create(long stdId) {
		PublishExtStd publishExtStd = new PublishExtStdImpl();

		publishExtStd.setNew(true);
		publishExtStd.setPrimaryKey(stdId);

		return publishExtStd;
	}

	/**
	 * Removes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishExtStdException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishExtStd remove(long stdId)
		throws NoSuchPublishExtStdException, SystemException {
		return remove((Serializable)stdId);
	}

	/**
	 * Removes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishExtStdException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishExtStd remove(Serializable primaryKey)
		throws NoSuchPublishExtStdException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishExtStd publishExtStd = (PublishExtStd)session.get(PublishExtStdImpl.class,
					primaryKey);

			if (publishExtStd == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishExtStdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishExtStd);
		}
		catch (NoSuchPublishExtStdException nsee) {
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
	protected PublishExtStd removeImpl(PublishExtStd publishExtStd)
		throws SystemException {
		publishExtStd = toUnwrappedModel(publishExtStd);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishExtStd)) {
				publishExtStd = (PublishExtStd)session.get(PublishExtStdImpl.class,
						publishExtStd.getPrimaryKeyObj());
			}

			if (publishExtStd != null) {
				session.delete(publishExtStd);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishExtStd != null) {
			clearCache(publishExtStd);
		}

		return publishExtStd;
	}

	@Override
	public PublishExtStd updateImpl(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws SystemException {
		publishExtStd = toUnwrappedModel(publishExtStd);

		boolean isNew = publishExtStd.isNew();

		Session session = null;

		try {
			session = openSession();

			if (publishExtStd.isNew()) {
				session.save(publishExtStd);

				publishExtStd.setNew(false);
			}
			else {
				session.merge(publishExtStd);
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

		EntityCacheUtil.putResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishExtStdImpl.class, publishExtStd.getPrimaryKey(),
			publishExtStd);

		return publishExtStd;
	}

	protected PublishExtStd toUnwrappedModel(PublishExtStd publishExtStd) {
		if (publishExtStd instanceof PublishExtStdImpl) {
			return publishExtStd;
		}

		PublishExtStdImpl publishExtStdImpl = new PublishExtStdImpl();

		publishExtStdImpl.setNew(publishExtStd.isNew());
		publishExtStdImpl.setPrimaryKey(publishExtStd.getPrimaryKey());

		publishExtStdImpl.setCompDate(publishExtStd.getCompDate());
		publishExtStdImpl.setStdId(publishExtStd.getStdId());
		publishExtStdImpl.setParentId(publishExtStd.getParentId());
		publishExtStdImpl.setTitle(publishExtStd.getTitle());
		publishExtStdImpl.setExpiredIds(publishExtStd.getExpiredIds());
		publishExtStdImpl.setRegionCode(publishExtStd.getRegionCode());
		publishExtStdImpl.setIsGlobal(publishExtStd.getIsGlobal());
		publishExtStdImpl.setFramework(publishExtStd.getFramework());

		return publishExtStdImpl;
	}

	/**
	 * Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishExtStdException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishExtStd findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishExtStdException, SystemException {
		PublishExtStd publishExtStd = fetchByPrimaryKey(primaryKey);

		if (publishExtStd == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishExtStdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishExtStd;
	}

	/**
	 * Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishExtStdException} if it could not be found.
	 *
	 * @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishExtStdException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishExtStd findByPrimaryKey(long stdId)
		throws NoSuchPublishExtStdException, SystemException {
		return findByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables., or <code>null</code> if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishExtStd fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishExtStd publishExtStd = (PublishExtStd)EntityCacheUtil.getResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
				PublishExtStdImpl.class, primaryKey);

		if (publishExtStd == _nullPublishExtStd) {
			return null;
		}

		if (publishExtStd == null) {
			Session session = null;

			try {
				session = openSession();

				publishExtStd = (PublishExtStd)session.get(PublishExtStdImpl.class,
						primaryKey);

				if (publishExtStd != null) {
					cacheResult(publishExtStd);
				}
				else {
					EntityCacheUtil.putResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
						PublishExtStdImpl.class, primaryKey, _nullPublishExtStd);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishExtStdModelImpl.ENTITY_CACHE_ENABLED,
					PublishExtStdImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishExtStd;
	}

	/**
	 * Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables., or <code>null</code> if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishExtStd fetchByPrimaryKey(long stdId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	 *
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishExtStd> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	 * @param end the upper bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s (not inclusive)
	 * @return the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishExtStd> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	 * @param end the upper bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishExtStd> findAll(int start, int end,
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

		List<PublishExtStd> list = (List<PublishExtStd>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHEXTSTD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHEXTSTD;

				if (pagination) {
					sql = sql.concat(PublishExtStdModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishExtStd>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishExtStd>(list);
				}
				else {
					list = (List<PublishExtStd>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishExtStd publishExtStd : findAll()) {
			remove(publishExtStd);
		}
	}

	/**
	 * Returns the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	 *
	 * @return the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHEXTSTD);

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
	 * Initializes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishExtStd")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishExtStd>> listenersList = new ArrayList<ModelListener<PublishExtStd>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishExtStd>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishExtStdImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHEXTSTD = "SELECT publishExtStd FROM PublishExtStd publishExtStd";
	private static final String _SQL_COUNT_PUBLISHEXTSTD = "SELECT COUNT(publishExtStd) FROM PublishExtStd publishExtStd";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishExtStd.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishExtStd exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishExtStdPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"compDate", "stdId", "parentId", "title", "expiredIds",
				"regionCode", "isGlobal", "framework"
			});
	private static PublishExtStd _nullPublishExtStd = new PublishExtStdImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishExtStd> toCacheModel() {
				return _nullPublishExtStdCacheModel;
			}
		};

	private static CacheModel<PublishExtStd> _nullPublishExtStdCacheModel = new CacheModel<PublishExtStd>() {
			@Override
			public PublishExtStd toEntityModel() {
				return _nullPublishExtStd;
			}
		};
}