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

import com.ihg.brandstandards.db.NoSuchGEMManagementIdException;
import com.ihg.brandstandards.db.model.GEMManagementId;
import com.ihg.brandstandards.db.model.impl.GEMManagementIdImpl;
import com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl;

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
 * The persistence implementation for the g e m management ID service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementIdPersistence
 * @see GEMManagementIdUtil
 * @generated
 */
public class GEMManagementIdPersistenceImpl extends BasePersistenceImpl<GEMManagementId>
	implements GEMManagementIdPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMManagementIdUtil} to access the g e m management ID persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMManagementIdImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementIdImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementIdImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE = new FinderPath(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementIdImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCountryCodeAndChainCode",
			new String[] { String.class.getName(), String.class.getName() },
			GEMManagementIdModelImpl.COUNTRYCODE_COLUMN_BITMASK |
			GEMManagementIdModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYCODEANDCHAINCODE = new FinderPath(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryCodeAndChainCode",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the g e m management ID where countryCode = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementIdException} if it could not be found.
	 *
	 * @param countryCode the country code
	 * @param chainCode the chain code
	 * @return the matching g e m management ID
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a matching g e m management ID could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId findByCountryCodeAndChainCode(String countryCode,
		String chainCode)
		throws NoSuchGEMManagementIdException, SystemException {
		GEMManagementId gemManagementId = fetchByCountryCodeAndChainCode(countryCode,
				chainCode);

		if (gemManagementId == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("countryCode=");
			msg.append(countryCode);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMManagementIdException(msg.toString());
		}

		return gemManagementId;
	}

	/**
	 * Returns the g e m management ID where countryCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param countryCode the country code
	 * @param chainCode the chain code
	 * @return the matching g e m management ID, or <code>null</code> if a matching g e m management ID could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId fetchByCountryCodeAndChainCode(String countryCode,
		String chainCode) throws SystemException {
		return fetchByCountryCodeAndChainCode(countryCode, chainCode, true);
	}

	/**
	 * Returns the g e m management ID where countryCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param countryCode the country code
	 * @param chainCode the chain code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m management ID, or <code>null</code> if a matching g e m management ID could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId fetchByCountryCodeAndChainCode(String countryCode,
		String chainCode, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { countryCode, chainCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
					finderArgs, this);
		}

		if (result instanceof GEMManagementId) {
			GEMManagementId gemManagementId = (GEMManagementId)result;

			if (!Validator.equals(countryCode, gemManagementId.getCountryCode()) ||
					!Validator.equals(chainCode, gemManagementId.getChainCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GEMMANAGEMENTID_WHERE);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryCode) {
					qPos.add(countryCode);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				List<GEMManagementId> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMManagementIdPersistenceImpl.fetchByCountryCodeAndChainCode(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMManagementId gemManagementId = list.get(0);

					result = gemManagementId;

					cacheResult(gemManagementId);

					if ((gemManagementId.getCountryCode() == null) ||
							!gemManagementId.getCountryCode().equals(countryCode) ||
							(gemManagementId.getChainCode() == null) ||
							!gemManagementId.getChainCode().equals(chainCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
							finderArgs, gemManagementId);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
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
			return (GEMManagementId)result;
		}
	}

	/**
	 * Removes the g e m management ID where countryCode = &#63; and chainCode = &#63; from the database.
	 *
	 * @param countryCode the country code
	 * @param chainCode the chain code
	 * @return the g e m management ID that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId removeByCountryCodeAndChainCode(String countryCode,
		String chainCode)
		throws NoSuchGEMManagementIdException, SystemException {
		GEMManagementId gemManagementId = findByCountryCodeAndChainCode(countryCode,
				chainCode);

		return remove(gemManagementId);
	}

	/**
	 * Returns the number of g e m management IDs where countryCode = &#63; and chainCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param chainCode the chain code
	 * @return the number of matching g e m management IDs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryCodeAndChainCode(String countryCode,
		String chainCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYCODEANDCHAINCODE;

		Object[] finderArgs = new Object[] { countryCode, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMMANAGEMENTID_WHERE);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryCode) {
					qPos.add(countryCode);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
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

	private static final String _FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_1 =
		"gemManagementId.countryCode IS NULL AND ";
	private static final String _FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_2 =
		"gemManagementId.countryCode = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_COUNTRYCODE_3 =
		"(gemManagementId.countryCode IS NULL OR gemManagementId.countryCode = '') AND ";
	private static final String _FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_1 =
		"gemManagementId.chainCode IS NULL";
	private static final String _FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_2 =
		"gemManagementId.chainCode = ?";
	private static final String _FINDER_COLUMN_COUNTRYCODEANDCHAINCODE_CHAINCODE_3 =
		"(gemManagementId.chainCode IS NULL OR gemManagementId.chainCode = '')";

	public GEMManagementIdPersistenceImpl() {
		setModelClass(GEMManagementId.class);
	}

	/**
	 * Caches the g e m management ID in the entity cache if it is enabled.
	 *
	 * @param gemManagementId the g e m management ID
	 */
	@Override
	public void cacheResult(GEMManagementId gemManagementId) {
		EntityCacheUtil.putResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdImpl.class, gemManagementId.getPrimaryKey(),
			gemManagementId);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
			new Object[] {
				gemManagementId.getCountryCode(), gemManagementId.getChainCode()
			}, gemManagementId);

		gemManagementId.resetOriginalValues();
	}

	/**
	 * Caches the g e m management IDs in the entity cache if it is enabled.
	 *
	 * @param gemManagementIds the g e m management IDs
	 */
	@Override
	public void cacheResult(List<GEMManagementId> gemManagementIds) {
		for (GEMManagementId gemManagementId : gemManagementIds) {
			if (EntityCacheUtil.getResult(
						GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
						GEMManagementIdImpl.class,
						gemManagementId.getPrimaryKey()) == null) {
				cacheResult(gemManagementId);
			}
			else {
				gemManagementId.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m management IDs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMManagementIdImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMManagementIdImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m management ID.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMManagementId gemManagementId) {
		EntityCacheUtil.removeResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdImpl.class, gemManagementId.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemManagementId);
	}

	@Override
	public void clearCache(List<GEMManagementId> gemManagementIds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMManagementId gemManagementId : gemManagementIds) {
			EntityCacheUtil.removeResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
				GEMManagementIdImpl.class, gemManagementId.getPrimaryKey());

			clearUniqueFindersCache(gemManagementId);
		}
	}

	protected void cacheUniqueFindersCache(GEMManagementId gemManagementId) {
		if (gemManagementId.isNew()) {
			Object[] args = new Object[] {
					gemManagementId.getCountryCode(),
					gemManagementId.getChainCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYCODEANDCHAINCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
				args, gemManagementId);
		}
		else {
			GEMManagementIdModelImpl gemManagementIdModelImpl = (GEMManagementIdModelImpl)gemManagementId;

			if ((gemManagementIdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemManagementId.getCountryCode(),
						gemManagementId.getChainCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYCODEANDCHAINCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
					args, gemManagementId);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMManagementId gemManagementId) {
		GEMManagementIdModelImpl gemManagementIdModelImpl = (GEMManagementIdModelImpl)gemManagementId;

		Object[] args = new Object[] {
				gemManagementId.getCountryCode(), gemManagementId.getChainCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYCODEANDCHAINCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
			args);

		if ((gemManagementIdModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemManagementIdModelImpl.getOriginalCountryCode(),
					gemManagementIdModelImpl.getOriginalChainCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYCODEANDCHAINCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYCODEANDCHAINCODE,
				args);
		}
	}

	/**
	 * Creates a new g e m management ID with the primary key. Does not add the g e m management ID to the database.
	 *
	 * @param managementId the primary key for the new g e m management ID
	 * @return the new g e m management ID
	 */
	@Override
	public GEMManagementId create(long managementId) {
		GEMManagementId gemManagementId = new GEMManagementIdImpl();

		gemManagementId.setNew(true);
		gemManagementId.setPrimaryKey(managementId);

		return gemManagementId;
	}

	/**
	 * Removes the g e m management ID with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param managementId the primary key of the g e m management ID
	 * @return the g e m management ID that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a g e m management ID with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId remove(long managementId)
		throws NoSuchGEMManagementIdException, SystemException {
		return remove((Serializable)managementId);
	}

	/**
	 * Removes the g e m management ID with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m management ID
	 * @return the g e m management ID that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a g e m management ID with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId remove(Serializable primaryKey)
		throws NoSuchGEMManagementIdException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMManagementId gemManagementId = (GEMManagementId)session.get(GEMManagementIdImpl.class,
					primaryKey);

			if (gemManagementId == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMManagementIdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemManagementId);
		}
		catch (NoSuchGEMManagementIdException nsee) {
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
	protected GEMManagementId removeImpl(GEMManagementId gemManagementId)
		throws SystemException {
		gemManagementId = toUnwrappedModel(gemManagementId);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemManagementId)) {
				gemManagementId = (GEMManagementId)session.get(GEMManagementIdImpl.class,
						gemManagementId.getPrimaryKeyObj());
			}

			if (gemManagementId != null) {
				session.delete(gemManagementId);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemManagementId != null) {
			clearCache(gemManagementId);
		}

		return gemManagementId;
	}

	@Override
	public GEMManagementId updateImpl(
		com.ihg.brandstandards.db.model.GEMManagementId gemManagementId)
		throws SystemException {
		gemManagementId = toUnwrappedModel(gemManagementId);

		boolean isNew = gemManagementId.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemManagementId.isNew()) {
				session.save(gemManagementId);

				gemManagementId.setNew(false);
			}
			else {
				session.merge(gemManagementId);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMManagementIdModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementIdImpl.class, gemManagementId.getPrimaryKey(),
			gemManagementId);

		clearUniqueFindersCache(gemManagementId);
		cacheUniqueFindersCache(gemManagementId);

		return gemManagementId;
	}

	protected GEMManagementId toUnwrappedModel(GEMManagementId gemManagementId) {
		if (gemManagementId instanceof GEMManagementIdImpl) {
			return gemManagementId;
		}

		GEMManagementIdImpl gemManagementIdImpl = new GEMManagementIdImpl();

		gemManagementIdImpl.setNew(gemManagementId.isNew());
		gemManagementIdImpl.setPrimaryKey(gemManagementId.getPrimaryKey());

		gemManagementIdImpl.setManagementId(gemManagementId.getManagementId());
		gemManagementIdImpl.setChainCode(gemManagementId.getChainCode());
		gemManagementIdImpl.setCountryCode(gemManagementId.getCountryCode());
		gemManagementIdImpl.setValue(gemManagementId.getValue());
		gemManagementIdImpl.setCreatorId(gemManagementId.getCreatorId());
		gemManagementIdImpl.setCreatedDate(gemManagementId.getCreatedDate());
		gemManagementIdImpl.setUpdatedBy(gemManagementId.getUpdatedBy());
		gemManagementIdImpl.setUpdatedDate(gemManagementId.getUpdatedDate());

		return gemManagementIdImpl;
	}

	/**
	 * Returns the g e m management ID with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m management ID
	 * @return the g e m management ID
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a g e m management ID with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMManagementIdException, SystemException {
		GEMManagementId gemManagementId = fetchByPrimaryKey(primaryKey);

		if (gemManagementId == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMManagementIdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemManagementId;
	}

	/**
	 * Returns the g e m management ID with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementIdException} if it could not be found.
	 *
	 * @param managementId the primary key of the g e m management ID
	 * @return the g e m management ID
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a g e m management ID with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId findByPrimaryKey(long managementId)
		throws NoSuchGEMManagementIdException, SystemException {
		return findByPrimaryKey((Serializable)managementId);
	}

	/**
	 * Returns the g e m management ID with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m management ID
	 * @return the g e m management ID, or <code>null</code> if a g e m management ID with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMManagementId gemManagementId = (GEMManagementId)EntityCacheUtil.getResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
				GEMManagementIdImpl.class, primaryKey);

		if (gemManagementId == _nullGEMManagementId) {
			return null;
		}

		if (gemManagementId == null) {
			Session session = null;

			try {
				session = openSession();

				gemManagementId = (GEMManagementId)session.get(GEMManagementIdImpl.class,
						primaryKey);

				if (gemManagementId != null) {
					cacheResult(gemManagementId);
				}
				else {
					EntityCacheUtil.putResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
						GEMManagementIdImpl.class, primaryKey,
						_nullGEMManagementId);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMManagementIdModelImpl.ENTITY_CACHE_ENABLED,
					GEMManagementIdImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemManagementId;
	}

	/**
	 * Returns the g e m management ID with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param managementId the primary key of the g e m management ID
	 * @return the g e m management ID, or <code>null</code> if a g e m management ID with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementId fetchByPrimaryKey(long managementId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)managementId);
	}

	/**
	 * Returns all the g e m management IDs.
	 *
	 * @return the g e m management IDs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementId> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m management IDs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m management IDs
	 * @param end the upper bound of the range of g e m management IDs (not inclusive)
	 * @return the range of g e m management IDs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementId> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m management IDs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m management IDs
	 * @param end the upper bound of the range of g e m management IDs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m management IDs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementId> findAll(int start, int end,
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

		List<GEMManagementId> list = (List<GEMManagementId>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMANAGEMENTID);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMANAGEMENTID;

				if (pagination) {
					sql = sql.concat(GEMManagementIdModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMManagementId>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMManagementId>(list);
				}
				else {
					list = (List<GEMManagementId>)QueryUtil.list(q,
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
	 * Removes all the g e m management IDs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMManagementId gemManagementId : findAll()) {
			remove(gemManagementId);
		}
	}

	/**
	 * Returns the number of g e m management IDs.
	 *
	 * @return the number of g e m management IDs
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

				Query q = session.createQuery(_SQL_COUNT_GEMMANAGEMENTID);

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
	 * Initializes the g e m management ID persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMManagementId")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMManagementId>> listenersList = new ArrayList<ModelListener<GEMManagementId>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMManagementId>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMManagementIdImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMANAGEMENTID = "SELECT gemManagementId FROM GEMManagementId gemManagementId";
	private static final String _SQL_SELECT_GEMMANAGEMENTID_WHERE = "SELECT gemManagementId FROM GEMManagementId gemManagementId WHERE ";
	private static final String _SQL_COUNT_GEMMANAGEMENTID = "SELECT COUNT(gemManagementId) FROM GEMManagementId gemManagementId";
	private static final String _SQL_COUNT_GEMMANAGEMENTID_WHERE = "SELECT COUNT(gemManagementId) FROM GEMManagementId gemManagementId WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemManagementId.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMManagementId exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMManagementId exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMManagementIdPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"managementId", "chainCode", "countryCode", "value", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMManagementId _nullGEMManagementId = new GEMManagementIdImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMManagementId> toCacheModel() {
				return _nullGEMManagementIdCacheModel;
			}
		};

	private static CacheModel<GEMManagementId> _nullGEMManagementIdCacheModel = new CacheModel<GEMManagementId>() {
			@Override
			public GEMManagementId toEntityModel() {
				return _nullGEMManagementId;
			}
		};
}