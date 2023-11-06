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

import com.ihg.brandstandards.db.NoSuchGEMRoleException;
import com.ihg.brandstandards.db.model.GEMRole;
import com.ihg.brandstandards.db.model.impl.GEMRoleImpl;
import com.ihg.brandstandards.db.model.impl.GEMRoleModelImpl;

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
 * The persistence implementation for the g e m role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMRolePersistence
 * @see GEMRoleUtil
 * @generated
 */
public class GEMRolePersistenceImpl extends BasePersistenceImpl<GEMRole>
	implements GEMRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMRoleUtil} to access the g e m role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleModelImpl.FINDER_CACHE_ENABLED, GEMRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleModelImpl.FINDER_CACHE_ENABLED, GEMRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GEMGRPCODE = new FinderPath(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleModelImpl.FINDER_CACHE_ENABLED, GEMRoleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGemGrpCode",
			new String[] { String.class.getName() },
			GEMRoleModelImpl.GEMGRPCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GEMGRPCODE = new FinderPath(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGemGrpCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the g e m role where gemGrpCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMRoleException} if it could not be found.
	 *
	 * @param gemGrpCode the gem grp code
	 * @return the matching g e m role
	 * @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a matching g e m role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole findByGemGrpCode(String gemGrpCode)
		throws NoSuchGEMRoleException, SystemException {
		GEMRole gemRole = fetchByGemGrpCode(gemGrpCode);

		if (gemRole == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("gemGrpCode=");
			msg.append(gemGrpCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMRoleException(msg.toString());
		}

		return gemRole;
	}

	/**
	 * Returns the g e m role where gemGrpCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param gemGrpCode the gem grp code
	 * @return the matching g e m role, or <code>null</code> if a matching g e m role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole fetchByGemGrpCode(String gemGrpCode)
		throws SystemException {
		return fetchByGemGrpCode(gemGrpCode, true);
	}

	/**
	 * Returns the g e m role where gemGrpCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param gemGrpCode the gem grp code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m role, or <code>null</code> if a matching g e m role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole fetchByGemGrpCode(String gemGrpCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { gemGrpCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GEMGRPCODE,
					finderArgs, this);
		}

		if (result instanceof GEMRole) {
			GEMRole gemRole = (GEMRole)result;

			if (!Validator.equals(gemGrpCode, gemRole.getGemGrpCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GEMROLE_WHERE);

			boolean bindGemGrpCode = false;

			if (gemGrpCode == null) {
				query.append(_FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_1);
			}
			else if (gemGrpCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_3);
			}
			else {
				bindGemGrpCode = true;

				query.append(_FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemGrpCode) {
					qPos.add(gemGrpCode.toLowerCase());
				}

				List<GEMRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMGRPCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMRolePersistenceImpl.fetchByGemGrpCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMRole gemRole = list.get(0);

					result = gemRole;

					cacheResult(gemRole);

					if ((gemRole.getGemGrpCode() == null) ||
							!gemRole.getGemGrpCode().equals(gemGrpCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMGRPCODE,
							finderArgs, gemRole);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMGRPCODE,
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
			return (GEMRole)result;
		}
	}

	/**
	 * Removes the g e m role where gemGrpCode = &#63; from the database.
	 *
	 * @param gemGrpCode the gem grp code
	 * @return the g e m role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole removeByGemGrpCode(String gemGrpCode)
		throws NoSuchGEMRoleException, SystemException {
		GEMRole gemRole = findByGemGrpCode(gemGrpCode);

		return remove(gemRole);
	}

	/**
	 * Returns the number of g e m roles where gemGrpCode = &#63;.
	 *
	 * @param gemGrpCode the gem grp code
	 * @return the number of matching g e m roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGemGrpCode(String gemGrpCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GEMGRPCODE;

		Object[] finderArgs = new Object[] { gemGrpCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMROLE_WHERE);

			boolean bindGemGrpCode = false;

			if (gemGrpCode == null) {
				query.append(_FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_1);
			}
			else if (gemGrpCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_3);
			}
			else {
				bindGemGrpCode = true;

				query.append(_FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemGrpCode) {
					qPos.add(gemGrpCode.toLowerCase());
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

	private static final String _FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_1 = "gemRole.gemGrpCode IS NULL";
	private static final String _FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_2 = "lower(gemRole.gemGrpCode) = ?";
	private static final String _FINDER_COLUMN_GEMGRPCODE_GEMGRPCODE_3 = "(gemRole.gemGrpCode IS NULL OR gemRole.gemGrpCode = '')";

	public GEMRolePersistenceImpl() {
		setModelClass(GEMRole.class);
	}

	/**
	 * Caches the g e m role in the entity cache if it is enabled.
	 *
	 * @param gemRole the g e m role
	 */
	@Override
	public void cacheResult(GEMRole gemRole) {
		EntityCacheUtil.putResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleImpl.class, gemRole.getPrimaryKey(), gemRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMGRPCODE,
			new Object[] { gemRole.getGemGrpCode() }, gemRole);

		gemRole.resetOriginalValues();
	}

	/**
	 * Caches the g e m roles in the entity cache if it is enabled.
	 *
	 * @param gemRoles the g e m roles
	 */
	@Override
	public void cacheResult(List<GEMRole> gemRoles) {
		for (GEMRole gemRole : gemRoles) {
			if (EntityCacheUtil.getResult(
						GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
						GEMRoleImpl.class, gemRole.getPrimaryKey()) == null) {
				cacheResult(gemRole);
			}
			else {
				gemRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMRole gemRole) {
		EntityCacheUtil.removeResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleImpl.class, gemRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemRole);
	}

	@Override
	public void clearCache(List<GEMRole> gemRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMRole gemRole : gemRoles) {
			EntityCacheUtil.removeResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
				GEMRoleImpl.class, gemRole.getPrimaryKey());

			clearUniqueFindersCache(gemRole);
		}
	}

	protected void cacheUniqueFindersCache(GEMRole gemRole) {
		if (gemRole.isNew()) {
			Object[] args = new Object[] { gemRole.getGemGrpCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEMGRPCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMGRPCODE, args,
				gemRole);
		}
		else {
			GEMRoleModelImpl gemRoleModelImpl = (GEMRoleModelImpl)gemRole;

			if ((gemRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GEMGRPCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { gemRole.getGemGrpCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEMGRPCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMGRPCODE,
					args, gemRole);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMRole gemRole) {
		GEMRoleModelImpl gemRoleModelImpl = (GEMRoleModelImpl)gemRole;

		Object[] args = new Object[] { gemRole.getGemGrpCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMGRPCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMGRPCODE, args);

		if ((gemRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GEMGRPCODE.getColumnBitmask()) != 0) {
			args = new Object[] { gemRoleModelImpl.getOriginalGemGrpCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMGRPCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMGRPCODE, args);
		}
	}

	/**
	 * Creates a new g e m role with the primary key. Does not add the g e m role to the database.
	 *
	 * @param gemGrpId the primary key for the new g e m role
	 * @return the new g e m role
	 */
	@Override
	public GEMRole create(long gemGrpId) {
		GEMRole gemRole = new GEMRoleImpl();

		gemRole.setNew(true);
		gemRole.setPrimaryKey(gemGrpId);

		return gemRole;
	}

	/**
	 * Removes the g e m role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gemGrpId the primary key of the g e m role
	 * @return the g e m role that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole remove(long gemGrpId)
		throws NoSuchGEMRoleException, SystemException {
		return remove((Serializable)gemGrpId);
	}

	/**
	 * Removes the g e m role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m role
	 * @return the g e m role that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole remove(Serializable primaryKey)
		throws NoSuchGEMRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMRole gemRole = (GEMRole)session.get(GEMRoleImpl.class, primaryKey);

			if (gemRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemRole);
		}
		catch (NoSuchGEMRoleException nsee) {
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
	protected GEMRole removeImpl(GEMRole gemRole) throws SystemException {
		gemRole = toUnwrappedModel(gemRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemRole)) {
				gemRole = (GEMRole)session.get(GEMRoleImpl.class,
						gemRole.getPrimaryKeyObj());
			}

			if (gemRole != null) {
				session.delete(gemRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemRole != null) {
			clearCache(gemRole);
		}

		return gemRole;
	}

	@Override
	public GEMRole updateImpl(com.ihg.brandstandards.db.model.GEMRole gemRole)
		throws SystemException {
		gemRole = toUnwrappedModel(gemRole);

		boolean isNew = gemRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemRole.isNew()) {
				session.save(gemRole);

				gemRole.setNew(false);
			}
			else {
				session.merge(gemRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
			GEMRoleImpl.class, gemRole.getPrimaryKey(), gemRole);

		clearUniqueFindersCache(gemRole);
		cacheUniqueFindersCache(gemRole);

		return gemRole;
	}

	protected GEMRole toUnwrappedModel(GEMRole gemRole) {
		if (gemRole instanceof GEMRoleImpl) {
			return gemRole;
		}

		GEMRoleImpl gemRoleImpl = new GEMRoleImpl();

		gemRoleImpl.setNew(gemRole.isNew());
		gemRoleImpl.setPrimaryKey(gemRole.getPrimaryKey());

		gemRoleImpl.setGemGrpId(gemRole.getGemGrpId());
		gemRoleImpl.setRegionId(gemRole.getRegionId());
		gemRoleImpl.setChainCode(gemRole.getChainCode());
		gemRoleImpl.setGemGrpCode(gemRole.getGemGrpCode());
		gemRoleImpl.setOwnerGrpId(gemRole.getOwnerGrpId());
		gemRoleImpl.setOwnerGrpName(gemRole.getOwnerGrpName());
		gemRoleImpl.setBusOwnerName(gemRole.getBusOwnerName());
		gemRoleImpl.setDeligate1Name(gemRole.getDeligate1Name());
		gemRoleImpl.setDeligate2Name(gemRole.getDeligate2Name());
		gemRoleImpl.setCreatorId(gemRole.getCreatorId());
		gemRoleImpl.setCreatedDate(gemRole.getCreatedDate());
		gemRoleImpl.setUpdatedBy(gemRole.getUpdatedBy());
		gemRoleImpl.setUpdatedDate(gemRole.getUpdatedDate());

		return gemRoleImpl;
	}

	/**
	 * Returns the g e m role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m role
	 * @return the g e m role
	 * @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMRoleException, SystemException {
		GEMRole gemRole = fetchByPrimaryKey(primaryKey);

		if (gemRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemRole;
	}

	/**
	 * Returns the g e m role with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMRoleException} if it could not be found.
	 *
	 * @param gemGrpId the primary key of the g e m role
	 * @return the g e m role
	 * @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole findByPrimaryKey(long gemGrpId)
		throws NoSuchGEMRoleException, SystemException {
		return findByPrimaryKey((Serializable)gemGrpId);
	}

	/**
	 * Returns the g e m role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m role
	 * @return the g e m role, or <code>null</code> if a g e m role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMRole gemRole = (GEMRole)EntityCacheUtil.getResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
				GEMRoleImpl.class, primaryKey);

		if (gemRole == _nullGEMRole) {
			return null;
		}

		if (gemRole == null) {
			Session session = null;

			try {
				session = openSession();

				gemRole = (GEMRole)session.get(GEMRoleImpl.class, primaryKey);

				if (gemRole != null) {
					cacheResult(gemRole);
				}
				else {
					EntityCacheUtil.putResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
						GEMRoleImpl.class, primaryKey, _nullGEMRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMRoleModelImpl.ENTITY_CACHE_ENABLED,
					GEMRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemRole;
	}

	/**
	 * Returns the g e m role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gemGrpId the primary key of the g e m role
	 * @return the g e m role, or <code>null</code> if a g e m role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMRole fetchByPrimaryKey(long gemGrpId) throws SystemException {
		return fetchByPrimaryKey((Serializable)gemGrpId);
	}

	/**
	 * Returns all the g e m roles.
	 *
	 * @return the g e m roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m roles
	 * @param end the upper bound of the range of g e m roles (not inclusive)
	 * @return the range of g e m roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMRole> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m roles
	 * @param end the upper bound of the range of g e m roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMRole> findAll(int start, int end,
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

		List<GEMRole> list = (List<GEMRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMROLE;

				if (pagination) {
					sql = sql.concat(GEMRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMRole>(list);
				}
				else {
					list = (List<GEMRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMRole gemRole : findAll()) {
			remove(gemRole);
		}
	}

	/**
	 * Returns the number of g e m roles.
	 *
	 * @return the number of g e m roles
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

				Query q = session.createQuery(_SQL_COUNT_GEMROLE);

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
	 * Initializes the g e m role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMRole>> listenersList = new ArrayList<ModelListener<GEMRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMROLE = "SELECT gemRole FROM GEMRole gemRole";
	private static final String _SQL_SELECT_GEMROLE_WHERE = "SELECT gemRole FROM GEMRole gemRole WHERE ";
	private static final String _SQL_COUNT_GEMROLE = "SELECT COUNT(gemRole) FROM GEMRole gemRole";
	private static final String _SQL_COUNT_GEMROLE_WHERE = "SELECT COUNT(gemRole) FROM GEMRole gemRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMRolePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"gemGrpId", "regionId", "chainCode", "gemGrpCode", "ownerGrpId",
				"ownerGrpName", "busOwnerName", "deligate1Name", "deligate2Name",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GEMRole _nullGEMRole = new GEMRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMRole> toCacheModel() {
				return _nullGEMRoleCacheModel;
			}
		};

	private static CacheModel<GEMRole> _nullGEMRoleCacheModel = new CacheModel<GEMRole>() {
			@Override
			public GEMRole toEntityModel() {
				return _nullGEMRole;
			}
		};
}