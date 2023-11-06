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

import com.ihg.brandstandards.db.NoSuchStandardsRegionException;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.impl.StandardsRegionImpl;
import com.ihg.brandstandards.db.model.impl.StandardsRegionModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the standards region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionPersistence
 * @see StandardsRegionUtil
 * @generated
 */
public class StandardsRegionPersistenceImpl extends BasePersistenceImpl<StandardsRegion>
	implements StandardsRegionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsRegionUtil} to access the standards region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsRegionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_REGIONID = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByregionId", new String[] { Long.class.getName() },
			StandardsRegionModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONID = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByregionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the standards region where regionId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionException} if it could not be found.
	 *
	 * @param regionId the region ID
	 * @return the matching standards region
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a matching standards region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion findByregionId(long regionId)
		throws NoSuchStandardsRegionException, SystemException {
		StandardsRegion standardsRegion = fetchByregionId(regionId);

		if (standardsRegion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("regionId=");
			msg.append(regionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsRegionException(msg.toString());
		}

		return standardsRegion;
	}

	/**
	 * Returns the standards region where regionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param regionId the region ID
	 * @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion fetchByregionId(long regionId)
		throws SystemException {
		return fetchByregionId(regionId, true);
	}

	/**
	 * Returns the standards region where regionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param regionId the region ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion fetchByregionId(long regionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { regionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGIONID,
					finderArgs, this);
		}

		if (result instanceof StandardsRegion) {
			StandardsRegion standardsRegion = (StandardsRegion)result;

			if ((regionId != standardsRegion.getRegionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDSREGION_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				List<StandardsRegion> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsRegionPersistenceImpl.fetchByregionId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsRegion standardsRegion = list.get(0);

					result = standardsRegion;

					cacheResult(standardsRegion);

					if ((standardsRegion.getRegionId() != regionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONID,
							finderArgs, standardsRegion);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONID,
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
			return (StandardsRegion)result;
		}
	}

	/**
	 * Removes the standards region where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @return the standards region that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion removeByregionId(long regionId)
		throws NoSuchStandardsRegionException, SystemException {
		StandardsRegion standardsRegion = findByregionId(regionId);

		return remove(standardsRegion);
	}

	/**
	 * Returns the number of standards regions where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching standards regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByregionId(long regionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONID;

		Object[] finderArgs = new Object[] { regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSREGION_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_REGIONID_REGIONID_2 = "standardsRegion.regionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_REGIONCODE = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByRegionCode", new String[] { String.class.getName() },
			StandardsRegionModelImpl.REGIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONCODE = new FinderPath(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegionCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the standards region where regionCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionException} if it could not be found.
	 *
	 * @param regionCode the region code
	 * @return the matching standards region
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a matching standards region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion findByRegionCode(String regionCode)
		throws NoSuchStandardsRegionException, SystemException {
		StandardsRegion standardsRegion = fetchByRegionCode(regionCode);

		if (standardsRegion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("regionCode=");
			msg.append(regionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsRegionException(msg.toString());
		}

		return standardsRegion;
	}

	/**
	 * Returns the standards region where regionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param regionCode the region code
	 * @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion fetchByRegionCode(String regionCode)
		throws SystemException {
		return fetchByRegionCode(regionCode, true);
	}

	/**
	 * Returns the standards region where regionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param regionCode the region code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion fetchByRegionCode(String regionCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { regionCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGIONCODE,
					finderArgs, this);
		}

		if (result instanceof StandardsRegion) {
			StandardsRegion standardsRegion = (StandardsRegion)result;

			if (!Validator.equals(regionCode, standardsRegion.getRegionCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDSREGION_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				List<StandardsRegion> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsRegionPersistenceImpl.fetchByRegionCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsRegion standardsRegion = list.get(0);

					result = standardsRegion;

					cacheResult(standardsRegion);

					if ((standardsRegion.getRegionCode() == null) ||
							!standardsRegion.getRegionCode().equals(regionCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODE,
							finderArgs, standardsRegion);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONCODE,
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
			return (StandardsRegion)result;
		}
	}

	/**
	 * Removes the standards region where regionCode = &#63; from the database.
	 *
	 * @param regionCode the region code
	 * @return the standards region that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion removeByRegionCode(String regionCode)
		throws NoSuchStandardsRegionException, SystemException {
		StandardsRegion standardsRegion = findByRegionCode(regionCode);

		return remove(standardsRegion);
	}

	/**
	 * Returns the number of standards regions where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @return the number of matching standards regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionCode(String regionCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONCODE;

		Object[] finderArgs = new Object[] { regionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSREGION_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

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

	private static final String _FINDER_COLUMN_REGIONCODE_REGIONCODE_1 = "standardsRegion.regionCode IS NULL";
	private static final String _FINDER_COLUMN_REGIONCODE_REGIONCODE_2 = "standardsRegion.regionCode = ?";
	private static final String _FINDER_COLUMN_REGIONCODE_REGIONCODE_3 = "(standardsRegion.regionCode IS NULL OR standardsRegion.regionCode = '')";

	public StandardsRegionPersistenceImpl() {
		setModelClass(StandardsRegion.class);
	}

	/**
	 * Caches the standards region in the entity cache if it is enabled.
	 *
	 * @param standardsRegion the standards region
	 */
	@Override
	public void cacheResult(StandardsRegion standardsRegion) {
		EntityCacheUtil.putResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionImpl.class, standardsRegion.getPrimaryKey(),
			standardsRegion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONID,
			new Object[] { standardsRegion.getRegionId() }, standardsRegion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODE,
			new Object[] { standardsRegion.getRegionCode() }, standardsRegion);

		standardsRegion.resetOriginalValues();
	}

	/**
	 * Caches the standards regions in the entity cache if it is enabled.
	 *
	 * @param standardsRegions the standards regions
	 */
	@Override
	public void cacheResult(List<StandardsRegion> standardsRegions) {
		for (StandardsRegion standardsRegion : standardsRegions) {
			if (EntityCacheUtil.getResult(
						StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
						StandardsRegionImpl.class,
						standardsRegion.getPrimaryKey()) == null) {
				cacheResult(standardsRegion);
			}
			else {
				standardsRegion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards regions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsRegionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsRegionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards region.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsRegion standardsRegion) {
		EntityCacheUtil.removeResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionImpl.class, standardsRegion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsRegion);
	}

	@Override
	public void clearCache(List<StandardsRegion> standardsRegions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsRegion standardsRegion : standardsRegions) {
			EntityCacheUtil.removeResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
				StandardsRegionImpl.class, standardsRegion.getPrimaryKey());

			clearUniqueFindersCache(standardsRegion);
		}
	}

	protected void cacheUniqueFindersCache(StandardsRegion standardsRegion) {
		if (standardsRegion.isNew()) {
			Object[] args = new Object[] { standardsRegion.getRegionId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONID, args,
				standardsRegion);

			args = new Object[] { standardsRegion.getRegionCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODE, args,
				standardsRegion);
		}
		else {
			StandardsRegionModelImpl standardsRegionModelImpl = (StandardsRegionModelImpl)standardsRegion;

			if ((standardsRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standardsRegion.getRegionId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONID, args,
					standardsRegion);
			}

			if ((standardsRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REGIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standardsRegion.getRegionCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODE,
					args, standardsRegion);
			}
		}
	}

	protected void clearUniqueFindersCache(StandardsRegion standardsRegion) {
		StandardsRegionModelImpl standardsRegionModelImpl = (StandardsRegionModelImpl)standardsRegion;

		Object[] args = new Object[] { standardsRegion.getRegionId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONID, args);

		if ((standardsRegionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REGIONID.getColumnBitmask()) != 0) {
			args = new Object[] { standardsRegionModelImpl.getOriginalRegionId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONID, args);
		}

		args = new Object[] { standardsRegion.getRegionCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONCODE, args);

		if ((standardsRegionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REGIONCODE.getColumnBitmask()) != 0) {
			args = new Object[] { standardsRegionModelImpl.getOriginalRegionCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONCODE, args);
		}
	}

	/**
	 * Creates a new standards region with the primary key. Does not add the standards region to the database.
	 *
	 * @param regionId the primary key for the new standards region
	 * @return the new standards region
	 */
	@Override
	public StandardsRegion create(long regionId) {
		StandardsRegion standardsRegion = new StandardsRegionImpl();

		standardsRegion.setNew(true);
		standardsRegion.setPrimaryKey(regionId);

		return standardsRegion;
	}

	/**
	 * Removes the standards region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param regionId the primary key of the standards region
	 * @return the standards region that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a standards region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion remove(long regionId)
		throws NoSuchStandardsRegionException, SystemException {
		return remove((Serializable)regionId);
	}

	/**
	 * Removes the standards region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards region
	 * @return the standards region that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a standards region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion remove(Serializable primaryKey)
		throws NoSuchStandardsRegionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsRegion standardsRegion = (StandardsRegion)session.get(StandardsRegionImpl.class,
					primaryKey);

			if (standardsRegion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsRegion);
		}
		catch (NoSuchStandardsRegionException nsee) {
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
	protected StandardsRegion removeImpl(StandardsRegion standardsRegion)
		throws SystemException {
		standardsRegion = toUnwrappedModel(standardsRegion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsRegion)) {
				standardsRegion = (StandardsRegion)session.get(StandardsRegionImpl.class,
						standardsRegion.getPrimaryKeyObj());
			}

			if (standardsRegion != null) {
				session.delete(standardsRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsRegion != null) {
			clearCache(standardsRegion);
		}

		return standardsRegion;
	}

	@Override
	public StandardsRegion updateImpl(
		com.ihg.brandstandards.db.model.StandardsRegion standardsRegion)
		throws SystemException {
		standardsRegion = toUnwrappedModel(standardsRegion);

		boolean isNew = standardsRegion.isNew();

		Session session = null;

		try {
			session = openSession();

			if (standardsRegion.isNew()) {
				session.save(standardsRegion);

				standardsRegion.setNew(false);
			}
			else {
				session.merge(standardsRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsRegionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionImpl.class, standardsRegion.getPrimaryKey(),
			standardsRegion);

		clearUniqueFindersCache(standardsRegion);
		cacheUniqueFindersCache(standardsRegion);

		return standardsRegion;
	}

	protected StandardsRegion toUnwrappedModel(StandardsRegion standardsRegion) {
		if (standardsRegion instanceof StandardsRegionImpl) {
			return standardsRegion;
		}

		StandardsRegionImpl standardsRegionImpl = new StandardsRegionImpl();

		standardsRegionImpl.setNew(standardsRegion.isNew());
		standardsRegionImpl.setPrimaryKey(standardsRegion.getPrimaryKey());

		standardsRegionImpl.setRegionId(standardsRegion.getRegionId());
		standardsRegionImpl.setRegionCode(standardsRegion.getRegionCode());
		standardsRegionImpl.setRegionType(standardsRegion.getRegionType());
		standardsRegionImpl.setRegionName(standardsRegion.getRegionName());
		standardsRegionImpl.setIsActive(standardsRegion.getIsActive());
		standardsRegionImpl.setCreatorId(standardsRegion.getCreatorId());
		standardsRegionImpl.setCreatedDate(standardsRegion.getCreatedDate());
		standardsRegionImpl.setUpdatedBy(standardsRegion.getUpdatedBy());
		standardsRegionImpl.setUpdatedDate(standardsRegion.getUpdatedDate());
		standardsRegionImpl.setParentRegionId(standardsRegion.getParentRegionId());

		return standardsRegionImpl;
	}

	/**
	 * Returns the standards region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards region
	 * @return the standards region
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a standards region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsRegionException, SystemException {
		StandardsRegion standardsRegion = fetchByPrimaryKey(primaryKey);

		if (standardsRegion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsRegion;
	}

	/**
	 * Returns the standards region with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionException} if it could not be found.
	 *
	 * @param regionId the primary key of the standards region
	 * @return the standards region
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a standards region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion findByPrimaryKey(long regionId)
		throws NoSuchStandardsRegionException, SystemException {
		return findByPrimaryKey((Serializable)regionId);
	}

	/**
	 * Returns the standards region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards region
	 * @return the standards region, or <code>null</code> if a standards region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsRegion standardsRegion = (StandardsRegion)EntityCacheUtil.getResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
				StandardsRegionImpl.class, primaryKey);

		if (standardsRegion == _nullStandardsRegion) {
			return null;
		}

		if (standardsRegion == null) {
			Session session = null;

			try {
				session = openSession();

				standardsRegion = (StandardsRegion)session.get(StandardsRegionImpl.class,
						primaryKey);

				if (standardsRegion != null) {
					cacheResult(standardsRegion);
				}
				else {
					EntityCacheUtil.putResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
						StandardsRegionImpl.class, primaryKey,
						_nullStandardsRegion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsRegionModelImpl.ENTITY_CACHE_ENABLED,
					StandardsRegionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsRegion;
	}

	/**
	 * Returns the standards region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param regionId the primary key of the standards region
	 * @return the standards region, or <code>null</code> if a standards region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegion fetchByPrimaryKey(long regionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)regionId);
	}

	/**
	 * Returns all the standards regions.
	 *
	 * @return the standards regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards regions
	 * @param end the upper bound of the range of standards regions (not inclusive)
	 * @return the range of standards regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards regions
	 * @param end the upper bound of the range of standards regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegion> findAll(int start, int end,
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

		List<StandardsRegion> list = (List<StandardsRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSREGION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSREGION;

				if (pagination) {
					sql = sql.concat(StandardsRegionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsRegion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsRegion>(list);
				}
				else {
					list = (List<StandardsRegion>)QueryUtil.list(q,
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
	 * Removes all the standards regions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsRegion standardsRegion : findAll()) {
			remove(standardsRegion);
		}
	}

	/**
	 * Returns the number of standards regions.
	 *
	 * @return the number of standards regions
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSREGION);

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
	 * Initializes the standards region persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsRegion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsRegion>> listenersList = new ArrayList<ModelListener<StandardsRegion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsRegion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsRegionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSREGION = "SELECT standardsRegion FROM StandardsRegion standardsRegion";
	private static final String _SQL_SELECT_STANDARDSREGION_WHERE = "SELECT standardsRegion FROM StandardsRegion standardsRegion WHERE ";
	private static final String _SQL_COUNT_STANDARDSREGION = "SELECT COUNT(standardsRegion) FROM StandardsRegion standardsRegion";
	private static final String _SQL_COUNT_STANDARDSREGION_WHERE = "SELECT COUNT(standardsRegion) FROM StandardsRegion standardsRegion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsRegion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsRegion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsRegion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsRegionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"regionId", "regionCode", "regionType", "regionName", "isActive",
				"creatorId", "createdDate", "updatedBy", "updatedDate",
				"parentRegionId"
			});
	private static StandardsRegion _nullStandardsRegion = new StandardsRegionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsRegion> toCacheModel() {
				return _nullStandardsRegionCacheModel;
			}
		};

	private static CacheModel<StandardsRegion> _nullStandardsRegionCacheModel = new CacheModel<StandardsRegion>() {
			@Override
			public StandardsRegion toEntityModel() {
				return _nullStandardsRegion;
			}
		};
}