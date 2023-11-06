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

import com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.impl.BridgePublishPreviewImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl;

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
 * The persistence implementation for the bridge publish preview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishPreviewPersistence
 * @see BridgePublishPreviewUtil
 * @generated
 */
public class BridgePublishPreviewPersistenceImpl extends BasePersistenceImpl<BridgePublishPreview>
	implements BridgePublishPreviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishPreviewUtil} to access the bridge publish preview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishPreviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishPreviewModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishPreviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishPreviewModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishPreviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishPreviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BridgePublishPreviewPersistenceImpl() {
		setModelClass(BridgePublishPreview.class);
	}

	/**
	 * Caches the bridge publish preview in the entity cache if it is enabled.
	 *
	 * @param bridgePublishPreview the bridge publish preview
	 */
	@Override
	public void cacheResult(BridgePublishPreview bridgePublishPreview) {
		EntityCacheUtil.putResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishPreviewImpl.class,
			bridgePublishPreview.getPrimaryKey(), bridgePublishPreview);

		bridgePublishPreview.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish previews in the entity cache if it is enabled.
	 *
	 * @param bridgePublishPreviews the bridge publish previews
	 */
	@Override
	public void cacheResult(List<BridgePublishPreview> bridgePublishPreviews) {
		for (BridgePublishPreview bridgePublishPreview : bridgePublishPreviews) {
			if (EntityCacheUtil.getResult(
						BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishPreviewImpl.class,
						bridgePublishPreview.getPrimaryKey()) == null) {
				cacheResult(bridgePublishPreview);
			}
			else {
				bridgePublishPreview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish previews.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishPreviewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishPreviewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish preview.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublishPreview bridgePublishPreview) {
		EntityCacheUtil.removeResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishPreviewImpl.class, bridgePublishPreview.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BridgePublishPreview> bridgePublishPreviews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishPreview bridgePublishPreview : bridgePublishPreviews) {
			EntityCacheUtil.removeResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishPreviewImpl.class,
				bridgePublishPreview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bridge publish preview with the primary key. Does not add the bridge publish preview to the database.
	 *
	 * @param stdId the primary key for the new bridge publish preview
	 * @return the new bridge publish preview
	 */
	@Override
	public BridgePublishPreview create(long stdId) {
		BridgePublishPreview bridgePublishPreview = new BridgePublishPreviewImpl();

		bridgePublishPreview.setNew(true);
		bridgePublishPreview.setPrimaryKey(stdId);

		return bridgePublishPreview;
	}

	/**
	 * Removes the bridge publish preview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdId the primary key of the bridge publish preview
	 * @return the bridge publish preview that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException if a bridge publish preview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishPreview remove(long stdId)
		throws NoSuchBridgePublishPreviewException, SystemException {
		return remove((Serializable)stdId);
	}

	/**
	 * Removes the bridge publish preview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish preview
	 * @return the bridge publish preview that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException if a bridge publish preview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishPreview remove(Serializable primaryKey)
		throws NoSuchBridgePublishPreviewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishPreview bridgePublishPreview = (BridgePublishPreview)session.get(BridgePublishPreviewImpl.class,
					primaryKey);

			if (bridgePublishPreview == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishPreviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishPreview);
		}
		catch (NoSuchBridgePublishPreviewException nsee) {
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
	protected BridgePublishPreview removeImpl(
		BridgePublishPreview bridgePublishPreview) throws SystemException {
		bridgePublishPreview = toUnwrappedModel(bridgePublishPreview);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishPreview)) {
				bridgePublishPreview = (BridgePublishPreview)session.get(BridgePublishPreviewImpl.class,
						bridgePublishPreview.getPrimaryKeyObj());
			}

			if (bridgePublishPreview != null) {
				session.delete(bridgePublishPreview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishPreview != null) {
			clearCache(bridgePublishPreview);
		}

		return bridgePublishPreview;
	}

	@Override
	public BridgePublishPreview updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview)
		throws SystemException {
		bridgePublishPreview = toUnwrappedModel(bridgePublishPreview);

		boolean isNew = bridgePublishPreview.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishPreview.isNew()) {
				session.save(bridgePublishPreview);

				bridgePublishPreview.setNew(false);
			}
			else {
				session.merge(bridgePublishPreview);
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

		EntityCacheUtil.putResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishPreviewImpl.class,
			bridgePublishPreview.getPrimaryKey(), bridgePublishPreview);

		return bridgePublishPreview;
	}

	protected BridgePublishPreview toUnwrappedModel(
		BridgePublishPreview bridgePublishPreview) {
		if (bridgePublishPreview instanceof BridgePublishPreviewImpl) {
			return bridgePublishPreview;
		}

		BridgePublishPreviewImpl bridgePublishPreviewImpl = new BridgePublishPreviewImpl();

		bridgePublishPreviewImpl.setNew(bridgePublishPreview.isNew());
		bridgePublishPreviewImpl.setPrimaryKey(bridgePublishPreview.getPrimaryKey());

		bridgePublishPreviewImpl.setStdId(bridgePublishPreview.getStdId());
		bridgePublishPreviewImpl.setTaxonomyTitle(bridgePublishPreview.getTaxonomyTitle());
		bridgePublishPreviewImpl.setTitle(bridgePublishPreview.getTitle());
		bridgePublishPreviewImpl.setPath(bridgePublishPreview.getPath());
		bridgePublishPreviewImpl.setParentStdId(bridgePublishPreview.getParentStdId());
		bridgePublishPreviewImpl.setCurrentTitle(bridgePublishPreview.getCurrentTitle());
		bridgePublishPreviewImpl.setType(bridgePublishPreview.getType());
		bridgePublishPreviewImpl.setDisplayOrder(bridgePublishPreview.getDisplayOrder());
		bridgePublishPreviewImpl.setTaxonomyId(bridgePublishPreview.getTaxonomyId());
		bridgePublishPreviewImpl.setParentTaxonomyId(bridgePublishPreview.getParentTaxonomyId());
		bridgePublishPreviewImpl.setIndexOrder(bridgePublishPreview.getIndexOrder());
		bridgePublishPreviewImpl.setLevel(bridgePublishPreview.getLevel());
		bridgePublishPreviewImpl.setLevelSortOrder(bridgePublishPreview.getLevelSortOrder());
		bridgePublishPreviewImpl.setStatus(bridgePublishPreview.getStatus());
		bridgePublishPreviewImpl.setImageCount(bridgePublishPreview.getImageCount());
		bridgePublishPreviewImpl.setAttachmentCount(bridgePublishPreview.getAttachmentCount());
		bridgePublishPreviewImpl.setXRefCount(bridgePublishPreview.getXRefCount());
		bridgePublishPreviewImpl.setHotelLifeCycle(bridgePublishPreview.getHotelLifeCycle());
		bridgePublishPreviewImpl.setComplianceCount(bridgePublishPreview.getComplianceCount());
		bridgePublishPreviewImpl.setHotelAttributes(bridgePublishPreview.getHotelAttributes());
		bridgePublishPreviewImpl.setComplianceDate(bridgePublishPreview.getComplianceDate());
		bridgePublishPreviewImpl.setStdReference(bridgePublishPreview.getStdReference());

		return bridgePublishPreviewImpl;
	}

	/**
	 * Returns the bridge publish preview with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish preview
	 * @return the bridge publish preview
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException if a bridge publish preview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishPreview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishPreviewException, SystemException {
		BridgePublishPreview bridgePublishPreview = fetchByPrimaryKey(primaryKey);

		if (bridgePublishPreview == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishPreviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishPreview;
	}

	/**
	 * Returns the bridge publish preview with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException} if it could not be found.
	 *
	 * @param stdId the primary key of the bridge publish preview
	 * @return the bridge publish preview
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException if a bridge publish preview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishPreview findByPrimaryKey(long stdId)
		throws NoSuchBridgePublishPreviewException, SystemException {
		return findByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns the bridge publish preview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish preview
	 * @return the bridge publish preview, or <code>null</code> if a bridge publish preview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishPreview fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublishPreview bridgePublishPreview = (BridgePublishPreview)EntityCacheUtil.getResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishPreviewImpl.class, primaryKey);

		if (bridgePublishPreview == _nullBridgePublishPreview) {
			return null;
		}

		if (bridgePublishPreview == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishPreview = (BridgePublishPreview)session.get(BridgePublishPreviewImpl.class,
						primaryKey);

				if (bridgePublishPreview != null) {
					cacheResult(bridgePublishPreview);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishPreviewImpl.class, primaryKey,
						_nullBridgePublishPreview);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishPreviewModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishPreviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishPreview;
	}

	/**
	 * Returns the bridge publish preview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdId the primary key of the bridge publish preview
	 * @return the bridge publish preview, or <code>null</code> if a bridge publish preview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishPreview fetchByPrimaryKey(long stdId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns all the bridge publish previews.
	 *
	 * @return the bridge publish previews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishPreview> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish previews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish previews
	 * @param end the upper bound of the range of bridge publish previews (not inclusive)
	 * @return the range of bridge publish previews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishPreview> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish previews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish previews
	 * @param end the upper bound of the range of bridge publish previews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish previews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishPreview> findAll(int start, int end,
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

		List<BridgePublishPreview> list = (List<BridgePublishPreview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHPREVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHPREVIEW;

				if (pagination) {
					sql = sql.concat(BridgePublishPreviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishPreview>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishPreview>(list);
				}
				else {
					list = (List<BridgePublishPreview>)QueryUtil.list(q,
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
	 * Removes all the bridge publish previews from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishPreview bridgePublishPreview : findAll()) {
			remove(bridgePublishPreview);
		}
	}

	/**
	 * Returns the number of bridge publish previews.
	 *
	 * @return the number of bridge publish previews
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHPREVIEW);

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
	 * Initializes the bridge publish preview persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishPreview")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishPreview>> listenersList = new ArrayList<ModelListener<BridgePublishPreview>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishPreview>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishPreviewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHPREVIEW = "SELECT bridgePublishPreview FROM BridgePublishPreview bridgePublishPreview";
	private static final String _SQL_COUNT_BRIDGEPUBLISHPREVIEW = "SELECT COUNT(bridgePublishPreview) FROM BridgePublishPreview bridgePublishPreview";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishPreview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishPreview exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishPreviewPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "taxonomyTitle", "title", "path", "parentStdId",
				"currentTitle", "type", "displayOrder", "taxonomyId",
				"parentTaxonomyId", "indexOrder", "level", "levelSortOrder",
				"status", "imageCount", "attachmentCount", "xRefCount",
				"hotelLifeCycle", "complianceCount", "hotelAttributes",
				"complianceDate", "stdReference"
			});
	private static BridgePublishPreview _nullBridgePublishPreview = new BridgePublishPreviewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishPreview> toCacheModel() {
				return _nullBridgePublishPreviewCacheModel;
			}
		};

	private static CacheModel<BridgePublishPreview> _nullBridgePublishPreviewCacheModel =
		new CacheModel<BridgePublishPreview>() {
			@Override
			public BridgePublishPreview toEntityModel() {
				return _nullBridgePublishPreview;
			}
		};
}