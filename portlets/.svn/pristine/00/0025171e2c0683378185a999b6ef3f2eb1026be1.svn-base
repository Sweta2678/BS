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

import com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException;
import com.ihg.brandstandards.db.model.TaxonomyStandards;
import com.ihg.brandstandards.db.model.impl.TaxonomyStandardsImpl;
import com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl;

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
 * The persistence implementation for the taxonomy standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyStandardsPersistence
 * @see TaxonomyStandardsUtil
 * @generated
 */
public class TaxonomyStandardsPersistenceImpl extends BasePersistenceImpl<TaxonomyStandards>
	implements TaxonomyStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxonomyStandardsUtil} to access the taxonomy standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxonomyStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsModelImpl.FINDER_CACHE_ENABLED,
			TaxonomyStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsModelImpl.FINDER_CACHE_ENABLED,
			TaxonomyStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STDID = new FinderPath(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsModelImpl.FINDER_CACHE_ENABLED,
			TaxonomyStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByStdId", new String[] { Long.class.getName() },
			TaxonomyStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the taxonomy standards where stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @return the matching taxonomy standards
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a matching taxonomy standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards findByStdId(long stdId)
		throws NoSuchTaxonomyStandardsException, SystemException {
		TaxonomyStandards taxonomyStandards = fetchByStdId(stdId);

		if (taxonomyStandards == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaxonomyStandardsException(msg.toString());
		}

		return taxonomyStandards;
	}

	/**
	 * Returns the taxonomy standards where stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @return the matching taxonomy standards, or <code>null</code> if a matching taxonomy standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards fetchByStdId(long stdId) throws SystemException {
		return fetchByStdId(stdId, true);
	}

	/**
	 * Returns the taxonomy standards where stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching taxonomy standards, or <code>null</code> if a matching taxonomy standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards fetchByStdId(long stdId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDID,
					finderArgs, this);
		}

		if (result instanceof TaxonomyStandards) {
			TaxonomyStandards taxonomyStandards = (TaxonomyStandards)result;

			if ((stdId != taxonomyStandards.getStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAXONOMYSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				List<TaxonomyStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TaxonomyStandardsPersistenceImpl.fetchByStdId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TaxonomyStandards taxonomyStandards = list.get(0);

					result = taxonomyStandards;

					cacheResult(taxonomyStandards);

					if ((taxonomyStandards.getStdId() != stdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
							finderArgs, taxonomyStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID,
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
			return (TaxonomyStandards)result;
		}
	}

	/**
	 * Removes the taxonomy standards where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @return the taxonomy standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards removeByStdId(long stdId)
		throws NoSuchTaxonomyStandardsException, SystemException {
		TaxonomyStandards taxonomyStandards = findByStdId(stdId);

		return remove(taxonomyStandards);
	}

	/**
	 * Returns the number of taxonomy standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching taxonomy standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAXONOMYSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "taxonomyStandards.stdId = ?";

	public TaxonomyStandardsPersistenceImpl() {
		setModelClass(TaxonomyStandards.class);
	}

	/**
	 * Caches the taxonomy standards in the entity cache if it is enabled.
	 *
	 * @param taxonomyStandards the taxonomy standards
	 */
	@Override
	public void cacheResult(TaxonomyStandards taxonomyStandards) {
		EntityCacheUtil.putResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsImpl.class, taxonomyStandards.getPrimaryKey(),
			taxonomyStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
			new Object[] { taxonomyStandards.getStdId() }, taxonomyStandards);

		taxonomyStandards.resetOriginalValues();
	}

	/**
	 * Caches the taxonomy standardses in the entity cache if it is enabled.
	 *
	 * @param taxonomyStandardses the taxonomy standardses
	 */
	@Override
	public void cacheResult(List<TaxonomyStandards> taxonomyStandardses) {
		for (TaxonomyStandards taxonomyStandards : taxonomyStandardses) {
			if (EntityCacheUtil.getResult(
						TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyStandardsImpl.class,
						taxonomyStandards.getPrimaryKey()) == null) {
				cacheResult(taxonomyStandards);
			}
			else {
				taxonomyStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all taxonomy standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaxonomyStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaxonomyStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the taxonomy standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxonomyStandards taxonomyStandards) {
		EntityCacheUtil.removeResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsImpl.class, taxonomyStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(taxonomyStandards);
	}

	@Override
	public void clearCache(List<TaxonomyStandards> taxonomyStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxonomyStandards taxonomyStandards : taxonomyStandardses) {
			EntityCacheUtil.removeResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyStandardsImpl.class, taxonomyStandards.getPrimaryKey());

			clearUniqueFindersCache(taxonomyStandards);
		}
	}

	protected void cacheUniqueFindersCache(TaxonomyStandards taxonomyStandards) {
		if (taxonomyStandards.isNew()) {
			Object[] args = new Object[] { taxonomyStandards.getStdId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID, args,
				taxonomyStandards);
		}
		else {
			TaxonomyStandardsModelImpl taxonomyStandardsModelImpl = (TaxonomyStandardsModelImpl)taxonomyStandards;

			if ((taxonomyStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { taxonomyStandards.getStdId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID, args,
					taxonomyStandards);
			}
		}
	}

	protected void clearUniqueFindersCache(TaxonomyStandards taxonomyStandards) {
		TaxonomyStandardsModelImpl taxonomyStandardsModelImpl = (TaxonomyStandardsModelImpl)taxonomyStandards;

		Object[] args = new Object[] { taxonomyStandards.getStdId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID, args);

		if ((taxonomyStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDID.getColumnBitmask()) != 0) {
			args = new Object[] { taxonomyStandardsModelImpl.getOriginalStdId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID, args);
		}
	}

	/**
	 * Creates a new taxonomy standards with the primary key. Does not add the taxonomy standards to the database.
	 *
	 * @param stdId the primary key for the new taxonomy standards
	 * @return the new taxonomy standards
	 */
	@Override
	public TaxonomyStandards create(long stdId) {
		TaxonomyStandards taxonomyStandards = new TaxonomyStandardsImpl();

		taxonomyStandards.setNew(true);
		taxonomyStandards.setPrimaryKey(stdId);

		return taxonomyStandards;
	}

	/**
	 * Removes the taxonomy standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdId the primary key of the taxonomy standards
	 * @return the taxonomy standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards remove(long stdId)
		throws NoSuchTaxonomyStandardsException, SystemException {
		return remove((Serializable)stdId);
	}

	/**
	 * Removes the taxonomy standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the taxonomy standards
	 * @return the taxonomy standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards remove(Serializable primaryKey)
		throws NoSuchTaxonomyStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaxonomyStandards taxonomyStandards = (TaxonomyStandards)session.get(TaxonomyStandardsImpl.class,
					primaryKey);

			if (taxonomyStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxonomyStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxonomyStandards);
		}
		catch (NoSuchTaxonomyStandardsException nsee) {
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
	protected TaxonomyStandards removeImpl(TaxonomyStandards taxonomyStandards)
		throws SystemException {
		taxonomyStandards = toUnwrappedModel(taxonomyStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxonomyStandards)) {
				taxonomyStandards = (TaxonomyStandards)session.get(TaxonomyStandardsImpl.class,
						taxonomyStandards.getPrimaryKeyObj());
			}

			if (taxonomyStandards != null) {
				session.delete(taxonomyStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxonomyStandards != null) {
			clearCache(taxonomyStandards);
		}

		return taxonomyStandards;
	}

	@Override
	public TaxonomyStandards updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards)
		throws SystemException {
		taxonomyStandards = toUnwrappedModel(taxonomyStandards);

		boolean isNew = taxonomyStandards.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taxonomyStandards.isNew()) {
				session.save(taxonomyStandards);

				taxonomyStandards.setNew(false);
			}
			else {
				session.merge(taxonomyStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaxonomyStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyStandardsImpl.class, taxonomyStandards.getPrimaryKey(),
			taxonomyStandards);

		clearUniqueFindersCache(taxonomyStandards);
		cacheUniqueFindersCache(taxonomyStandards);

		return taxonomyStandards;
	}

	protected TaxonomyStandards toUnwrappedModel(
		TaxonomyStandards taxonomyStandards) {
		if (taxonomyStandards instanceof TaxonomyStandardsImpl) {
			return taxonomyStandards;
		}

		TaxonomyStandardsImpl taxonomyStandardsImpl = new TaxonomyStandardsImpl();

		taxonomyStandardsImpl.setNew(taxonomyStandards.isNew());
		taxonomyStandardsImpl.setPrimaryKey(taxonomyStandards.getPrimaryKey());

		taxonomyStandardsImpl.setStdId(taxonomyStandards.getStdId());
		taxonomyStandardsImpl.setTaxId(taxonomyStandards.getTaxId());
		taxonomyStandardsImpl.setCreatorId(taxonomyStandards.getCreatorId());
		taxonomyStandardsImpl.setCreatedDate(taxonomyStandards.getCreatedDate());
		taxonomyStandardsImpl.setUpdatedBy(taxonomyStandards.getUpdatedBy());
		taxonomyStandardsImpl.setUpdatedDate(taxonomyStandards.getUpdatedDate());

		return taxonomyStandardsImpl;
	}

	/**
	 * Returns the taxonomy standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the taxonomy standards
	 * @return the taxonomy standards
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxonomyStandardsException, SystemException {
		TaxonomyStandards taxonomyStandards = fetchByPrimaryKey(primaryKey);

		if (taxonomyStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxonomyStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxonomyStandards;
	}

	/**
	 * Returns the taxonomy standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException} if it could not be found.
	 *
	 * @param stdId the primary key of the taxonomy standards
	 * @return the taxonomy standards
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards findByPrimaryKey(long stdId)
		throws NoSuchTaxonomyStandardsException, SystemException {
		return findByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns the taxonomy standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the taxonomy standards
	 * @return the taxonomy standards, or <code>null</code> if a taxonomy standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaxonomyStandards taxonomyStandards = (TaxonomyStandards)EntityCacheUtil.getResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyStandardsImpl.class, primaryKey);

		if (taxonomyStandards == _nullTaxonomyStandards) {
			return null;
		}

		if (taxonomyStandards == null) {
			Session session = null;

			try {
				session = openSession();

				taxonomyStandards = (TaxonomyStandards)session.get(TaxonomyStandardsImpl.class,
						primaryKey);

				if (taxonomyStandards != null) {
					cacheResult(taxonomyStandards);
				}
				else {
					EntityCacheUtil.putResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyStandardsImpl.class, primaryKey,
						_nullTaxonomyStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaxonomyStandardsModelImpl.ENTITY_CACHE_ENABLED,
					TaxonomyStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxonomyStandards;
	}

	/**
	 * Returns the taxonomy standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdId the primary key of the taxonomy standards
	 * @return the taxonomy standards, or <code>null</code> if a taxonomy standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyStandards fetchByPrimaryKey(long stdId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns all the taxonomy standardses.
	 *
	 * @return the taxonomy standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the taxonomy standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of taxonomy standardses
	 * @param end the upper bound of the range of taxonomy standardses (not inclusive)
	 * @return the range of taxonomy standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the taxonomy standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of taxonomy standardses
	 * @param end the upper bound of the range of taxonomy standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of taxonomy standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyStandards> findAll(int start, int end,
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

		List<TaxonomyStandards> list = (List<TaxonomyStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAXONOMYSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXONOMYSTANDARDS;

				if (pagination) {
					sql = sql.concat(TaxonomyStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxonomyStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaxonomyStandards>(list);
				}
				else {
					list = (List<TaxonomyStandards>)QueryUtil.list(q,
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
	 * Removes all the taxonomy standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaxonomyStandards taxonomyStandards : findAll()) {
			remove(taxonomyStandards);
		}
	}

	/**
	 * Returns the number of taxonomy standardses.
	 *
	 * @return the number of taxonomy standardses
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

				Query q = session.createQuery(_SQL_COUNT_TAXONOMYSTANDARDS);

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
	 * Initializes the taxonomy standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.TaxonomyStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaxonomyStandards>> listenersList = new ArrayList<ModelListener<TaxonomyStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaxonomyStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaxonomyStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAXONOMYSTANDARDS = "SELECT taxonomyStandards FROM TaxonomyStandards taxonomyStandards";
	private static final String _SQL_SELECT_TAXONOMYSTANDARDS_WHERE = "SELECT taxonomyStandards FROM TaxonomyStandards taxonomyStandards WHERE ";
	private static final String _SQL_COUNT_TAXONOMYSTANDARDS = "SELECT COUNT(taxonomyStandards) FROM TaxonomyStandards taxonomyStandards";
	private static final String _SQL_COUNT_TAXONOMYSTANDARDS_WHERE = "SELECT COUNT(taxonomyStandards) FROM TaxonomyStandards taxonomyStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxonomyStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxonomyStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaxonomyStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaxonomyStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "taxId", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static TaxonomyStandards _nullTaxonomyStandards = new TaxonomyStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaxonomyStandards> toCacheModel() {
				return _nullTaxonomyStandardsCacheModel;
			}
		};

	private static CacheModel<TaxonomyStandards> _nullTaxonomyStandardsCacheModel =
		new CacheModel<TaxonomyStandards>() {
			@Override
			public TaxonomyStandards toEntityModel() {
				return _nullTaxonomyStandards;
			}
		};
}