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

import com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException;
import com.ihg.brandstandards.db.model.PublishTaxonomyExt;
import com.ihg.brandstandards.db.model.impl.PublishTaxonomyExtImpl;
import com.ihg.brandstandards.db.model.impl.PublishTaxonomyExtModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the Custom Query mapping to create index path. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishTaxonomyExtPersistence
 * @see PublishTaxonomyExtUtil
 * @generated
 */
public class PublishTaxonomyExtPersistenceImpl extends BasePersistenceImpl<PublishTaxonomyExt>
	implements PublishTaxonomyExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishTaxonomyExtUtil} to access the Custom Query mapping to create index path. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishTaxonomyExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHTAXID = new FinderPath(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyExtImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypublishTaxId", new String[] { Long.class.getName() },
			PublishTaxonomyExtModelImpl.PUBLISHTAXID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHTAXID = new FinderPath(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypublishTaxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the Custom Query mapping to create index path. where publishTaxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException} if it could not be found.
	 *
	 * @param publishTaxId the publish tax ID
	 * @return the matching Custom Query mapping to create index path.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException if a matching Custom Query mapping to create index path. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt findBypublishTaxId(long publishTaxId)
		throws NoSuchPublishTaxonomyExtException, SystemException {
		PublishTaxonomyExt publishTaxonomyExt = fetchBypublishTaxId(publishTaxId);

		if (publishTaxonomyExt == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishTaxId=");
			msg.append(publishTaxId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishTaxonomyExtException(msg.toString());
		}

		return publishTaxonomyExt;
	}

	/**
	 * Returns the Custom Query mapping to create index path. where publishTaxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishTaxId the publish tax ID
	 * @return the matching Custom Query mapping to create index path., or <code>null</code> if a matching Custom Query mapping to create index path. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt fetchBypublishTaxId(long publishTaxId)
		throws SystemException {
		return fetchBypublishTaxId(publishTaxId, true);
	}

	/**
	 * Returns the Custom Query mapping to create index path. where publishTaxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishTaxId the publish tax ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Custom Query mapping to create index path., or <code>null</code> if a matching Custom Query mapping to create index path. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt fetchBypublishTaxId(long publishTaxId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishTaxId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
					finderArgs, this);
		}

		if (result instanceof PublishTaxonomyExt) {
			PublishTaxonomyExt publishTaxonomyExt = (PublishTaxonomyExt)result;

			if ((publishTaxId != publishTaxonomyExt.getPublishTaxId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHTAXONOMYEXT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHTAXID_PUBLISHTAXID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishTaxId);

				List<PublishTaxonomyExt> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishTaxonomyExtPersistenceImpl.fetchBypublishTaxId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishTaxonomyExt publishTaxonomyExt = list.get(0);

					result = publishTaxonomyExt;

					cacheResult(publishTaxonomyExt);

					if ((publishTaxonomyExt.getPublishTaxId() != publishTaxId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
							finderArgs, publishTaxonomyExt);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PublishTaxonomyExt)result;
		}
	}

	/**
	 * Removes the Custom Query mapping to create index path. where publishTaxId = &#63; from the database.
	 *
	 * @param publishTaxId the publish tax ID
	 * @return the Custom Query mapping to create index path. that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt removeBypublishTaxId(long publishTaxId)
		throws NoSuchPublishTaxonomyExtException, SystemException {
		PublishTaxonomyExt publishTaxonomyExt = findBypublishTaxId(publishTaxId);

		return remove(publishTaxonomyExt);
	}

	/**
	 * Returns the number of Custom Query mapping to create index path.s where publishTaxId = &#63;.
	 *
	 * @param publishTaxId the publish tax ID
	 * @return the number of matching Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishTaxId(long publishTaxId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHTAXID;

		Object[] finderArgs = new Object[] { publishTaxId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHTAXONOMYEXT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHTAXID_PUBLISHTAXID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishTaxId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PUBLISHTAXID_PUBLISHTAXID_2 = "publishTaxonomyExt.publishTaxId = ?";

	public PublishTaxonomyExtPersistenceImpl() {
		setModelClass(PublishTaxonomyExt.class);
	}

	/**
	 * Caches the Custom Query mapping to create index path. in the entity cache if it is enabled.
	 *
	 * @param publishTaxonomyExt the Custom Query mapping to create index path.
	 */
	@Override
	public void cacheResult(PublishTaxonomyExt publishTaxonomyExt) {
		EntityCacheUtil.putResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtImpl.class, publishTaxonomyExt.getPrimaryKey(),
			publishTaxonomyExt);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
			new Object[] { publishTaxonomyExt.getPublishTaxId() },
			publishTaxonomyExt);

		publishTaxonomyExt.resetOriginalValues();
	}

	/**
	 * Caches the Custom Query mapping to create index path.s in the entity cache if it is enabled.
	 *
	 * @param publishTaxonomyExts the Custom Query mapping to create index path.s
	 */
	@Override
	public void cacheResult(List<PublishTaxonomyExt> publishTaxonomyExts) {
		for (PublishTaxonomyExt publishTaxonomyExt : publishTaxonomyExts) {
			if (EntityCacheUtil.getResult(
						PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
						PublishTaxonomyExtImpl.class,
						publishTaxonomyExt.getPrimaryKey()) == null) {
				cacheResult(publishTaxonomyExt);
			}
			else {
				publishTaxonomyExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Custom Query mapping to create index path.s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishTaxonomyExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishTaxonomyExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Custom Query mapping to create index path..
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishTaxonomyExt publishTaxonomyExt) {
		EntityCacheUtil.removeResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtImpl.class, publishTaxonomyExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publishTaxonomyExt);
	}

	@Override
	public void clearCache(List<PublishTaxonomyExt> publishTaxonomyExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishTaxonomyExt publishTaxonomyExt : publishTaxonomyExts) {
			EntityCacheUtil.removeResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
				PublishTaxonomyExtImpl.class, publishTaxonomyExt.getPrimaryKey());

			clearUniqueFindersCache(publishTaxonomyExt);
		}
	}

	protected void cacheUniqueFindersCache(
		PublishTaxonomyExt publishTaxonomyExt) {
		if (publishTaxonomyExt.isNew()) {
			Object[] args = new Object[] { publishTaxonomyExt.getPublishTaxId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID, args,
				publishTaxonomyExt);
		}
		else {
			PublishTaxonomyExtModelImpl publishTaxonomyExtModelImpl = (PublishTaxonomyExtModelImpl)publishTaxonomyExt;

			if ((publishTaxonomyExtModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHTAXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishTaxonomyExt.getPublishTaxId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
					args, publishTaxonomyExt);
			}
		}
	}

	protected void clearUniqueFindersCache(
		PublishTaxonomyExt publishTaxonomyExt) {
		PublishTaxonomyExtModelImpl publishTaxonomyExtModelImpl = (PublishTaxonomyExtModelImpl)publishTaxonomyExt;

		Object[] args = new Object[] { publishTaxonomyExt.getPublishTaxId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID, args);

		if ((publishTaxonomyExtModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHTAXID.getColumnBitmask()) != 0) {
			args = new Object[] {
					publishTaxonomyExtModelImpl.getOriginalPublishTaxId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID, args);
		}
	}

	/**
	 * Creates a new Custom Query mapping to create index path. with the primary key. Does not add the Custom Query mapping to create index path. to the database.
	 *
	 * @param publishTaxId the primary key for the new Custom Query mapping to create index path.
	 * @return the new Custom Query mapping to create index path.
	 */
	@Override
	public PublishTaxonomyExt create(long publishTaxId) {
		PublishTaxonomyExt publishTaxonomyExt = new PublishTaxonomyExtImpl();

		publishTaxonomyExt.setNew(true);
		publishTaxonomyExt.setPrimaryKey(publishTaxId);

		return publishTaxonomyExt;
	}

	/**
	 * Removes the Custom Query mapping to create index path. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishTaxId the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt remove(long publishTaxId)
		throws NoSuchPublishTaxonomyExtException, SystemException {
		return remove((Serializable)publishTaxId);
	}

	/**
	 * Removes the Custom Query mapping to create index path. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt remove(Serializable primaryKey)
		throws NoSuchPublishTaxonomyExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishTaxonomyExt publishTaxonomyExt = (PublishTaxonomyExt)session.get(PublishTaxonomyExtImpl.class,
					primaryKey);

			if (publishTaxonomyExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishTaxonomyExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishTaxonomyExt);
		}
		catch (NoSuchPublishTaxonomyExtException nsee) {
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
	protected PublishTaxonomyExt removeImpl(
		PublishTaxonomyExt publishTaxonomyExt) throws SystemException {
		publishTaxonomyExt = toUnwrappedModel(publishTaxonomyExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishTaxonomyExt)) {
				publishTaxonomyExt = (PublishTaxonomyExt)session.get(PublishTaxonomyExtImpl.class,
						publishTaxonomyExt.getPrimaryKeyObj());
			}

			if (publishTaxonomyExt != null) {
				session.delete(publishTaxonomyExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishTaxonomyExt != null) {
			clearCache(publishTaxonomyExt);
		}

		return publishTaxonomyExt;
	}

	@Override
	public PublishTaxonomyExt updateImpl(
		com.ihg.brandstandards.db.model.PublishTaxonomyExt publishTaxonomyExt)
		throws SystemException {
		publishTaxonomyExt = toUnwrappedModel(publishTaxonomyExt);

		boolean isNew = publishTaxonomyExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (publishTaxonomyExt.isNew()) {
				session.save(publishTaxonomyExt);

				publishTaxonomyExt.setNew(false);
			}
			else {
				session.merge(publishTaxonomyExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishTaxonomyExtModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyExtImpl.class, publishTaxonomyExt.getPrimaryKey(),
			publishTaxonomyExt);

		clearUniqueFindersCache(publishTaxonomyExt);
		cacheUniqueFindersCache(publishTaxonomyExt);

		return publishTaxonomyExt;
	}

	protected PublishTaxonomyExt toUnwrappedModel(
		PublishTaxonomyExt publishTaxonomyExt) {
		if (publishTaxonomyExt instanceof PublishTaxonomyExtImpl) {
			return publishTaxonomyExt;
		}

		PublishTaxonomyExtImpl publishTaxonomyExtImpl = new PublishTaxonomyExtImpl();

		publishTaxonomyExtImpl.setNew(publishTaxonomyExt.isNew());
		publishTaxonomyExtImpl.setPrimaryKey(publishTaxonomyExt.getPrimaryKey());

		publishTaxonomyExtImpl.setPublishTaxId(publishTaxonomyExt.getPublishTaxId());
		publishTaxonomyExtImpl.setPublishParentId(publishTaxonomyExt.getPublishParentId());
		publishTaxonomyExtImpl.setTitle(publishTaxonomyExt.getTitle());
		publishTaxonomyExtImpl.setLvl(publishTaxonomyExt.getLvl());
		publishTaxonomyExtImpl.setPath(publishTaxonomyExt.getPath());
		publishTaxonomyExtImpl.setLevelSortOrder(publishTaxonomyExt.getLevelSortOrder());
		publishTaxonomyExtImpl.setPublishId(publishTaxonomyExt.getPublishId());
		publishTaxonomyExtImpl.setIndexOrder(publishTaxonomyExt.getIndexOrder());

		return publishTaxonomyExtImpl;
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishTaxonomyExtException, SystemException {
		PublishTaxonomyExt publishTaxonomyExt = fetchByPrimaryKey(primaryKey);

		if (publishTaxonomyExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishTaxonomyExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishTaxonomyExt;
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException} if it could not be found.
	 *
	 * @param publishTaxId the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt findByPrimaryKey(long publishTaxId)
		throws NoSuchPublishTaxonomyExtException, SystemException {
		return findByPrimaryKey((Serializable)publishTaxId);
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path., or <code>null</code> if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishTaxonomyExt publishTaxonomyExt = (PublishTaxonomyExt)EntityCacheUtil.getResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
				PublishTaxonomyExtImpl.class, primaryKey);

		if (publishTaxonomyExt == _nullPublishTaxonomyExt) {
			return null;
		}

		if (publishTaxonomyExt == null) {
			Session session = null;

			try {
				session = openSession();

				publishTaxonomyExt = (PublishTaxonomyExt)session.get(PublishTaxonomyExtImpl.class,
						primaryKey);

				if (publishTaxonomyExt != null) {
					cacheResult(publishTaxonomyExt);
				}
				else {
					EntityCacheUtil.putResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
						PublishTaxonomyExtImpl.class, primaryKey,
						_nullPublishTaxonomyExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishTaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
					PublishTaxonomyExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishTaxonomyExt;
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishTaxId the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path., or <code>null</code> if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomyExt fetchByPrimaryKey(long publishTaxId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishTaxId);
	}

	/**
	 * Returns all the Custom Query mapping to create index path.s.
	 *
	 * @return the Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomyExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Custom Query mapping to create index path.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping to create index path.s
	 * @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	 * @return the range of Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomyExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Custom Query mapping to create index path.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping to create index path.s
	 * @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomyExt> findAll(int start, int end,
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

		List<PublishTaxonomyExt> list = (List<PublishTaxonomyExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHTAXONOMYEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHTAXONOMYEXT;

				if (pagination) {
					sql = sql.concat(PublishTaxonomyExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishTaxonomyExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishTaxonomyExt>(list);
				}
				else {
					list = (List<PublishTaxonomyExt>)QueryUtil.list(q,
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
	 * Removes all the Custom Query mapping to create index path.s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishTaxonomyExt publishTaxonomyExt : findAll()) {
			remove(publishTaxonomyExt);
		}
	}

	/**
	 * Returns the number of Custom Query mapping to create index path.s.
	 *
	 * @return the number of Custom Query mapping to create index path.s
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHTAXONOMYEXT);

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
	 * Initializes the Custom Query mapping to create index path. persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishTaxonomyExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishTaxonomyExt>> listenersList = new ArrayList<ModelListener<PublishTaxonomyExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishTaxonomyExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishTaxonomyExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHTAXONOMYEXT = "SELECT publishTaxonomyExt FROM PublishTaxonomyExt publishTaxonomyExt";
	private static final String _SQL_SELECT_PUBLISHTAXONOMYEXT_WHERE = "SELECT publishTaxonomyExt FROM PublishTaxonomyExt publishTaxonomyExt WHERE ";
	private static final String _SQL_COUNT_PUBLISHTAXONOMYEXT = "SELECT COUNT(publishTaxonomyExt) FROM PublishTaxonomyExt publishTaxonomyExt";
	private static final String _SQL_COUNT_PUBLISHTAXONOMYEXT_WHERE = "SELECT COUNT(publishTaxonomyExt) FROM PublishTaxonomyExt publishTaxonomyExt WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishTaxonomyExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishTaxonomyExt exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishTaxonomyExt exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishTaxonomyExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishTaxId", "publishParentId", "title", "lvl", "path",
				"levelSortOrder", "publishId", "indexOrder"
			});
	private static PublishTaxonomyExt _nullPublishTaxonomyExt = new PublishTaxonomyExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishTaxonomyExt> toCacheModel() {
				return _nullPublishTaxonomyExtCacheModel;
			}
		};

	private static CacheModel<PublishTaxonomyExt> _nullPublishTaxonomyExtCacheModel =
		new CacheModel<PublishTaxonomyExt>() {
			@Override
			public PublishTaxonomyExt toEntityModel() {
				return _nullPublishTaxonomyExt;
			}
		};
}