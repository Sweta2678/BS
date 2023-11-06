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

import com.ihg.brandstandards.db.NoSuchUserPreferenceException;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.model.impl.UserPreferenceImpl;
import com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl;

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
 * The persistence implementation for the user preference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UserPreferencePersistence
 * @see UserPreferenceUtil
 * @generated
 */
public class UserPreferencePersistenceImpl extends BasePersistenceImpl<UserPreference>
	implements UserPreferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserPreferenceUtil} to access the user preference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserPreferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserPreferenceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PREFERENCEID = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserPreferenceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypreferenceId", new String[] { Long.class.getName() },
			UserPreferenceModelImpl.PREFERENCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PREFERENCEID = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypreferenceId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user preference where preferenceId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	 *
	 * @param preferenceId the preference ID
	 * @return the matching user preference
	 * @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a matching user preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference findBypreferenceId(long preferenceId)
		throws NoSuchUserPreferenceException, SystemException {
		UserPreference userPreference = fetchBypreferenceId(preferenceId);

		if (userPreference == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("preferenceId=");
			msg.append(preferenceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserPreferenceException(msg.toString());
		}

		return userPreference;
	}

	/**
	 * Returns the user preference where preferenceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param preferenceId the preference ID
	 * @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference fetchBypreferenceId(long preferenceId)
		throws SystemException {
		return fetchBypreferenceId(preferenceId, true);
	}

	/**
	 * Returns the user preference where preferenceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param preferenceId the preference ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference fetchBypreferenceId(long preferenceId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { preferenceId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PREFERENCEID,
					finderArgs, this);
		}

		if (result instanceof UserPreference) {
			UserPreference userPreference = (UserPreference)result;

			if ((preferenceId != userPreference.getPreferenceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_PREFERENCEID_PREFERENCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(preferenceId);

				List<UserPreference> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PREFERENCEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserPreferencePersistenceImpl.fetchBypreferenceId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserPreference userPreference = list.get(0);

					result = userPreference;

					cacheResult(userPreference);

					if ((userPreference.getPreferenceId() != preferenceId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PREFERENCEID,
							finderArgs, userPreference);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PREFERENCEID,
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
			return (UserPreference)result;
		}
	}

	/**
	 * Removes the user preference where preferenceId = &#63; from the database.
	 *
	 * @param preferenceId the preference ID
	 * @return the user preference that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference removeBypreferenceId(long preferenceId)
		throws NoSuchUserPreferenceException, SystemException {
		UserPreference userPreference = findBypreferenceId(preferenceId);

		return remove(userPreference);
	}

	/**
	 * Returns the number of user preferences where preferenceId = &#63;.
	 *
	 * @param preferenceId the preference ID
	 * @return the number of matching user preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypreferenceId(long preferenceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PREFERENCEID;

		Object[] finderArgs = new Object[] { preferenceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_PREFERENCEID_PREFERENCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(preferenceId);

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

	private static final String _FINDER_COLUMN_PREFERENCEID_PREFERENCEID_2 = "userPreference.preferenceId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDMODULE = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserPreferenceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndModule",
			new String[] { Long.class.getName(), String.class.getName() },
			UserPreferenceModelImpl.USERID_COLUMN_BITMASK |
			UserPreferenceModelImpl.MODULENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDMODULE = new FinderPath(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndModule",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the user preference where userId = &#63; and moduleName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param moduleName the module name
	 * @return the matching user preference
	 * @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a matching user preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference findByUserIdAndModule(long userId, String moduleName)
		throws NoSuchUserPreferenceException, SystemException {
		UserPreference userPreference = fetchByUserIdAndModule(userId,
				moduleName);

		if (userPreference == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", moduleName=");
			msg.append(moduleName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserPreferenceException(msg.toString());
		}

		return userPreference;
	}

	/**
	 * Returns the user preference where userId = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param moduleName the module name
	 * @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference fetchByUserIdAndModule(long userId, String moduleName)
		throws SystemException {
		return fetchByUserIdAndModule(userId, moduleName, true);
	}

	/**
	 * Returns the user preference where userId = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param moduleName the module name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference fetchByUserIdAndModule(long userId,
		String moduleName, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, moduleName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
					finderArgs, this);
		}

		if (result instanceof UserPreference) {
			UserPreference userPreference = (UserPreference)result;

			if ((userId != userPreference.getUserId()) ||
					!Validator.equals(moduleName, userPreference.getModuleName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDMODULE_USERID_2);

			boolean bindModuleName = false;

			if (moduleName == null) {
				query.append(_FINDER_COLUMN_USERIDANDMODULE_MODULENAME_1);
			}
			else if (moduleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDMODULE_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				query.append(_FINDER_COLUMN_USERIDANDMODULE_MODULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindModuleName) {
					qPos.add(moduleName);
				}

				List<UserPreference> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserPreferencePersistenceImpl.fetchByUserIdAndModule(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserPreference userPreference = list.get(0);

					result = userPreference;

					cacheResult(userPreference);

					if ((userPreference.getUserId() != userId) ||
							(userPreference.getModuleName() == null) ||
							!userPreference.getModuleName().equals(moduleName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
							finderArgs, userPreference);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
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
			return (UserPreference)result;
		}
	}

	/**
	 * Removes the user preference where userId = &#63; and moduleName = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param moduleName the module name
	 * @return the user preference that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference removeByUserIdAndModule(long userId, String moduleName)
		throws NoSuchUserPreferenceException, SystemException {
		UserPreference userPreference = findByUserIdAndModule(userId, moduleName);

		return remove(userPreference);
	}

	/**
	 * Returns the number of user preferences where userId = &#63; and moduleName = &#63;.
	 *
	 * @param userId the user ID
	 * @param moduleName the module name
	 * @return the number of matching user preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndModule(long userId, String moduleName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDMODULE;

		Object[] finderArgs = new Object[] { userId, moduleName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDMODULE_USERID_2);

			boolean bindModuleName = false;

			if (moduleName == null) {
				query.append(_FINDER_COLUMN_USERIDANDMODULE_MODULENAME_1);
			}
			else if (moduleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDMODULE_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				query.append(_FINDER_COLUMN_USERIDANDMODULE_MODULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindModuleName) {
					qPos.add(moduleName);
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

	private static final String _FINDER_COLUMN_USERIDANDMODULE_USERID_2 = "userPreference.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDMODULE_MODULENAME_1 = "userPreference.moduleName IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDMODULE_MODULENAME_2 = "userPreference.moduleName = ?";
	private static final String _FINDER_COLUMN_USERIDANDMODULE_MODULENAME_3 = "(userPreference.moduleName IS NULL OR userPreference.moduleName = '')";

	public UserPreferencePersistenceImpl() {
		setModelClass(UserPreference.class);
	}

	/**
	 * Caches the user preference in the entity cache if it is enabled.
	 *
	 * @param userPreference the user preference
	 */
	@Override
	public void cacheResult(UserPreference userPreference) {
		EntityCacheUtil.putResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceImpl.class, userPreference.getPrimaryKey(),
			userPreference);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PREFERENCEID,
			new Object[] { userPreference.getPreferenceId() }, userPreference);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
			new Object[] {
				userPreference.getUserId(), userPreference.getModuleName()
			}, userPreference);

		userPreference.resetOriginalValues();
	}

	/**
	 * Caches the user preferences in the entity cache if it is enabled.
	 *
	 * @param userPreferences the user preferences
	 */
	@Override
	public void cacheResult(List<UserPreference> userPreferences) {
		for (UserPreference userPreference : userPreferences) {
			if (EntityCacheUtil.getResult(
						UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
						UserPreferenceImpl.class, userPreference.getPrimaryKey()) == null) {
				cacheResult(userPreference);
			}
			else {
				userPreference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user preferences.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserPreferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserPreferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user preference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserPreference userPreference) {
		EntityCacheUtil.removeResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceImpl.class, userPreference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userPreference);
	}

	@Override
	public void clearCache(List<UserPreference> userPreferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserPreference userPreference : userPreferences) {
			EntityCacheUtil.removeResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
				UserPreferenceImpl.class, userPreference.getPrimaryKey());

			clearUniqueFindersCache(userPreference);
		}
	}

	protected void cacheUniqueFindersCache(UserPreference userPreference) {
		if (userPreference.isNew()) {
			Object[] args = new Object[] { userPreference.getPreferenceId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PREFERENCEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PREFERENCEID, args,
				userPreference);

			args = new Object[] {
					userPreference.getUserId(), userPreference.getModuleName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDMODULE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
				args, userPreference);
		}
		else {
			UserPreferenceModelImpl userPreferenceModelImpl = (UserPreferenceModelImpl)userPreference;

			if ((userPreferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PREFERENCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userPreference.getPreferenceId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PREFERENCEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PREFERENCEID,
					args, userPreference);
			}

			if ((userPreferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDMODULE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userPreference.getUserId(),
						userPreference.getModuleName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDMODULE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
					args, userPreference);
			}
		}
	}

	protected void clearUniqueFindersCache(UserPreference userPreference) {
		UserPreferenceModelImpl userPreferenceModelImpl = (UserPreferenceModelImpl)userPreference;

		Object[] args = new Object[] { userPreference.getPreferenceId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFERENCEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PREFERENCEID, args);

		if ((userPreferenceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PREFERENCEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					userPreferenceModelImpl.getOriginalPreferenceId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PREFERENCEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PREFERENCEID, args);
		}

		args = new Object[] {
				userPreference.getUserId(), userPreference.getModuleName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDMODULE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE, args);

		if ((userPreferenceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDMODULE.getColumnBitmask()) != 0) {
			args = new Object[] {
					userPreferenceModelImpl.getOriginalUserId(),
					userPreferenceModelImpl.getOriginalModuleName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDMODULE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDMODULE,
				args);
		}
	}

	/**
	 * Creates a new user preference with the primary key. Does not add the user preference to the database.
	 *
	 * @param preferenceId the primary key for the new user preference
	 * @return the new user preference
	 */
	@Override
	public UserPreference create(long preferenceId) {
		UserPreference userPreference = new UserPreferenceImpl();

		userPreference.setNew(true);
		userPreference.setPrimaryKey(preferenceId);

		return userPreference;
	}

	/**
	 * Removes the user preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param preferenceId the primary key of the user preference
	 * @return the user preference that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference remove(long preferenceId)
		throws NoSuchUserPreferenceException, SystemException {
		return remove((Serializable)preferenceId);
	}

	/**
	 * Removes the user preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user preference
	 * @return the user preference that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference remove(Serializable primaryKey)
		throws NoSuchUserPreferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserPreference userPreference = (UserPreference)session.get(UserPreferenceImpl.class,
					primaryKey);

			if (userPreference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserPreferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userPreference);
		}
		catch (NoSuchUserPreferenceException nsee) {
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
	protected UserPreference removeImpl(UserPreference userPreference)
		throws SystemException {
		userPreference = toUnwrappedModel(userPreference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userPreference)) {
				userPreference = (UserPreference)session.get(UserPreferenceImpl.class,
						userPreference.getPrimaryKeyObj());
			}

			if (userPreference != null) {
				session.delete(userPreference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userPreference != null) {
			clearCache(userPreference);
		}

		return userPreference;
	}

	@Override
	public UserPreference updateImpl(
		com.ihg.brandstandards.db.model.UserPreference userPreference)
		throws SystemException {
		userPreference = toUnwrappedModel(userPreference);

		boolean isNew = userPreference.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userPreference.isNew()) {
				session.save(userPreference);

				userPreference.setNew(false);
			}
			else {
				session.merge(userPreference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserPreferenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserPreferenceImpl.class, userPreference.getPrimaryKey(),
			userPreference);

		clearUniqueFindersCache(userPreference);
		cacheUniqueFindersCache(userPreference);

		return userPreference;
	}

	protected UserPreference toUnwrappedModel(UserPreference userPreference) {
		if (userPreference instanceof UserPreferenceImpl) {
			return userPreference;
		}

		UserPreferenceImpl userPreferenceImpl = new UserPreferenceImpl();

		userPreferenceImpl.setNew(userPreference.isNew());
		userPreferenceImpl.setPrimaryKey(userPreference.getPrimaryKey());

		userPreferenceImpl.setPreferenceId(userPreference.getPreferenceId());
		userPreferenceImpl.setUserId(userPreference.getUserId());
		userPreferenceImpl.setLangCode(userPreference.getLangCode());
		userPreferenceImpl.setPdfLangCode(userPreference.getPdfLangCode());
		userPreferenceImpl.setBuildType(userPreference.getBuildType());
		userPreferenceImpl.setChainCode(userPreference.getChainCode());
		userPreferenceImpl.setReportType(userPreference.getReportType());
		userPreferenceImpl.setPaperSize(userPreference.getPaperSize());
		userPreferenceImpl.setItemsPerPage(userPreference.getItemsPerPage());
		userPreferenceImpl.setInfoDisplay(userPreference.getInfoDisplay());
		userPreferenceImpl.setCountryCode(userPreference.getCountryCode());
		userPreferenceImpl.setUnsubscribeEmail(userPreference.getUnsubscribeEmail());
		userPreferenceImpl.setModuleName(userPreference.getModuleName());
		userPreferenceImpl.setCreatorId(userPreference.getCreatorId());
		userPreferenceImpl.setCreatedDate(userPreference.getCreatedDate());
		userPreferenceImpl.setUpdatedBy(userPreference.getUpdatedBy());
		userPreferenceImpl.setUpdatedDate(userPreference.getUpdatedDate());

		return userPreferenceImpl;
	}

	/**
	 * Returns the user preference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user preference
	 * @return the user preference
	 * @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserPreferenceException, SystemException {
		UserPreference userPreference = fetchByPrimaryKey(primaryKey);

		if (userPreference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserPreferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userPreference;
	}

	/**
	 * Returns the user preference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	 *
	 * @param preferenceId the primary key of the user preference
	 * @return the user preference
	 * @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference findByPrimaryKey(long preferenceId)
		throws NoSuchUserPreferenceException, SystemException {
		return findByPrimaryKey((Serializable)preferenceId);
	}

	/**
	 * Returns the user preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user preference
	 * @return the user preference, or <code>null</code> if a user preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserPreference userPreference = (UserPreference)EntityCacheUtil.getResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
				UserPreferenceImpl.class, primaryKey);

		if (userPreference == _nullUserPreference) {
			return null;
		}

		if (userPreference == null) {
			Session session = null;

			try {
				session = openSession();

				userPreference = (UserPreference)session.get(UserPreferenceImpl.class,
						primaryKey);

				if (userPreference != null) {
					cacheResult(userPreference);
				}
				else {
					EntityCacheUtil.putResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
						UserPreferenceImpl.class, primaryKey,
						_nullUserPreference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserPreferenceModelImpl.ENTITY_CACHE_ENABLED,
					UserPreferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userPreference;
	}

	/**
	 * Returns the user preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param preferenceId the primary key of the user preference
	 * @return the user preference, or <code>null</code> if a user preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserPreference fetchByPrimaryKey(long preferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)preferenceId);
	}

	/**
	 * Returns all the user preferences.
	 *
	 * @return the user preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserPreference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user preferences
	 * @param end the upper bound of the range of user preferences (not inclusive)
	 * @return the range of user preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserPreference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user preferences
	 * @param end the upper bound of the range of user preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserPreference> findAll(int start, int end,
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

		List<UserPreference> list = (List<UserPreference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERPREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPREFERENCE;

				if (pagination) {
					sql = sql.concat(UserPreferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserPreference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserPreference>(list);
				}
				else {
					list = (List<UserPreference>)QueryUtil.list(q,
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
	 * Removes all the user preferences from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserPreference userPreference : findAll()) {
			remove(userPreference);
		}
	}

	/**
	 * Returns the number of user preferences.
	 *
	 * @return the number of user preferences
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

				Query q = session.createQuery(_SQL_COUNT_USERPREFERENCE);

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
	 * Initializes the user preference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UserPreference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserPreference>> listenersList = new ArrayList<ModelListener<UserPreference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserPreference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserPreferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERPREFERENCE = "SELECT userPreference FROM UserPreference userPreference";
	private static final String _SQL_SELECT_USERPREFERENCE_WHERE = "SELECT userPreference FROM UserPreference userPreference WHERE ";
	private static final String _SQL_COUNT_USERPREFERENCE = "SELECT COUNT(userPreference) FROM UserPreference userPreference";
	private static final String _SQL_COUNT_USERPREFERENCE_WHERE = "SELECT COUNT(userPreference) FROM UserPreference userPreference WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userPreference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserPreference exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserPreference exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserPreferencePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"preferenceId", "userId", "langCode", "pdfLangCode", "buildType",
				"chainCode", "reportType", "paperSize", "itemsPerPage",
				"infoDisplay", "CountryCode", "unsubscribeEmail", "moduleName",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static UserPreference _nullUserPreference = new UserPreferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserPreference> toCacheModel() {
				return _nullUserPreferenceCacheModel;
			}
		};

	private static CacheModel<UserPreference> _nullUserPreferenceCacheModel = new CacheModel<UserPreference>() {
			@Override
			public UserPreference toEntityModel() {
				return _nullUserPreference;
			}
		};
}