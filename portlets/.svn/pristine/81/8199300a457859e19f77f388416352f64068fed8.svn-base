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

import com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException;
import com.ihg.brandstandards.db.model.UserSearchCriteria;
import com.ihg.brandstandards.db.model.impl.UserSearchCriteriaImpl;
import com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl;

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
 * The persistence implementation for the user search criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UserSearchCriteriaPersistence
 * @see UserSearchCriteriaUtil
 * @generated
 */
public class UserSearchCriteriaPersistenceImpl extends BasePersistenceImpl<UserSearchCriteria>
	implements UserSearchCriteriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserSearchCriteriaUtil} to access the user search criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserSearchCriteriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED,
			UserSearchCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED,
			UserSearchCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SEARCHNAME = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED,
			UserSearchCriteriaImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySearchName",
			new String[] { String.class.getName(), String.class.getName() },
			UserSearchCriteriaModelImpl.CREATORID_COLUMN_BITMASK |
			UserSearchCriteriaModelImpl.SEARCHNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHNAME = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySearchName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the user search criteria where creatorId = &#63; and searchName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException} if it could not be found.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the matching user search criteria
	 * @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a matching user search criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria findBySearchName(String creatorId,
		String searchName)
		throws NoSuchUserSearchCriteriaException, SystemException {
		UserSearchCriteria userSearchCriteria = fetchBySearchName(creatorId,
				searchName);

		if (userSearchCriteria == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("creatorId=");
			msg.append(creatorId);

			msg.append(", searchName=");
			msg.append(searchName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSearchCriteriaException(msg.toString());
		}

		return userSearchCriteria;
	}

	/**
	 * Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria fetchBySearchName(String creatorId,
		String searchName) throws SystemException {
		return fetchBySearchName(creatorId, searchName, true);
	}

	/**
	 * Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria fetchBySearchName(String creatorId,
		String searchName, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { creatorId, searchName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEARCHNAME,
					finderArgs, this);
		}

		if (result instanceof UserSearchCriteria) {
			UserSearchCriteria userSearchCriteria = (UserSearchCriteria)result;

			if (!Validator.equals(creatorId, userSearchCriteria.getCreatorId()) ||
					!Validator.equals(searchName,
						userSearchCriteria.getSearchName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERSEARCHCRITERIA_WHERE);

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_SEARCHNAME_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAME_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_SEARCHNAME_CREATORID_2);
			}

			boolean bindSearchName = false;

			if (searchName == null) {
				query.append(_FINDER_COLUMN_SEARCHNAME_SEARCHNAME_1);
			}
			else if (searchName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAME_SEARCHNAME_3);
			}
			else {
				bindSearchName = true;

				query.append(_FINDER_COLUMN_SEARCHNAME_SEARCHNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				if (bindSearchName) {
					qPos.add(searchName);
				}

				List<UserSearchCriteria> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserSearchCriteriaPersistenceImpl.fetchBySearchName(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserSearchCriteria userSearchCriteria = list.get(0);

					result = userSearchCriteria;

					cacheResult(userSearchCriteria);

					if ((userSearchCriteria.getCreatorId() == null) ||
							!userSearchCriteria.getCreatorId().equals(creatorId) ||
							(userSearchCriteria.getSearchName() == null) ||
							!userSearchCriteria.getSearchName()
												   .equals(searchName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAME,
							finderArgs, userSearchCriteria);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHNAME,
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
			return (UserSearchCriteria)result;
		}
	}

	/**
	 * Removes the user search criteria where creatorId = &#63; and searchName = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the user search criteria that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria removeBySearchName(String creatorId,
		String searchName)
		throws NoSuchUserSearchCriteriaException, SystemException {
		UserSearchCriteria userSearchCriteria = findBySearchName(creatorId,
				searchName);

		return remove(userSearchCriteria);
	}

	/**
	 * Returns the number of user search criterias where creatorId = &#63; and searchName = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the number of matching user search criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchName(String creatorId, String searchName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHNAME;

		Object[] finderArgs = new Object[] { creatorId, searchName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSEARCHCRITERIA_WHERE);

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_SEARCHNAME_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAME_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_SEARCHNAME_CREATORID_2);
			}

			boolean bindSearchName = false;

			if (searchName == null) {
				query.append(_FINDER_COLUMN_SEARCHNAME_SEARCHNAME_1);
			}
			else if (searchName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAME_SEARCHNAME_3);
			}
			else {
				bindSearchName = true;

				query.append(_FINDER_COLUMN_SEARCHNAME_SEARCHNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				if (bindSearchName) {
					qPos.add(searchName);
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

	private static final String _FINDER_COLUMN_SEARCHNAME_CREATORID_1 = "userSearchCriteria.creatorId IS NULL AND ";
	private static final String _FINDER_COLUMN_SEARCHNAME_CREATORID_2 = "userSearchCriteria.creatorId = ? AND ";
	private static final String _FINDER_COLUMN_SEARCHNAME_CREATORID_3 = "(userSearchCriteria.creatorId IS NULL OR userSearchCriteria.creatorId = '') AND ";
	private static final String _FINDER_COLUMN_SEARCHNAME_SEARCHNAME_1 = "userSearchCriteria.searchName IS NULL";
	private static final String _FINDER_COLUMN_SEARCHNAME_SEARCHNAME_2 = "userSearchCriteria.searchName = ?";
	private static final String _FINDER_COLUMN_SEARCHNAME_SEARCHNAME_3 = "(userSearchCriteria.searchName IS NULL OR userSearchCriteria.searchName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED,
			UserSearchCriteriaImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySearchNameCreatorId",
			new String[] { String.class.getName(), String.class.getName() },
			UserSearchCriteriaModelImpl.CREATORID_COLUMN_BITMASK |
			UserSearchCriteriaModelImpl.SEARCHNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHNAMECREATORID = new FinderPath(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchNameCreatorId",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the user search criteria where creatorId = &#63; and searchName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException} if it could not be found.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the matching user search criteria
	 * @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a matching user search criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria findBySearchNameCreatorId(String creatorId,
		String searchName)
		throws NoSuchUserSearchCriteriaException, SystemException {
		UserSearchCriteria userSearchCriteria = fetchBySearchNameCreatorId(creatorId,
				searchName);

		if (userSearchCriteria == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("creatorId=");
			msg.append(creatorId);

			msg.append(", searchName=");
			msg.append(searchName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSearchCriteriaException(msg.toString());
		}

		return userSearchCriteria;
	}

	/**
	 * Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria fetchBySearchNameCreatorId(String creatorId,
		String searchName) throws SystemException {
		return fetchBySearchNameCreatorId(creatorId, searchName, true);
	}

	/**
	 * Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria fetchBySearchNameCreatorId(String creatorId,
		String searchName, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { creatorId, searchName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
					finderArgs, this);
		}

		if (result instanceof UserSearchCriteria) {
			UserSearchCriteria userSearchCriteria = (UserSearchCriteria)result;

			if (!Validator.equals(creatorId, userSearchCriteria.getCreatorId()) ||
					!Validator.equals(searchName,
						userSearchCriteria.getSearchName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERSEARCHCRITERIA_WHERE);

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_2);
			}

			boolean bindSearchName = false;

			if (searchName == null) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_1);
			}
			else if (searchName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_3);
			}
			else {
				bindSearchName = true;

				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				if (bindSearchName) {
					qPos.add(searchName);
				}

				List<UserSearchCriteria> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserSearchCriteriaPersistenceImpl.fetchBySearchNameCreatorId(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserSearchCriteria userSearchCriteria = list.get(0);

					result = userSearchCriteria;

					cacheResult(userSearchCriteria);

					if ((userSearchCriteria.getCreatorId() == null) ||
							!userSearchCriteria.getCreatorId().equals(creatorId) ||
							(userSearchCriteria.getSearchName() == null) ||
							!userSearchCriteria.getSearchName()
												   .equals(searchName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
							finderArgs, userSearchCriteria);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
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
			return (UserSearchCriteria)result;
		}
	}

	/**
	 * Removes the user search criteria where creatorId = &#63; and searchName = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the user search criteria that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria removeBySearchNameCreatorId(String creatorId,
		String searchName)
		throws NoSuchUserSearchCriteriaException, SystemException {
		UserSearchCriteria userSearchCriteria = findBySearchNameCreatorId(creatorId,
				searchName);

		return remove(userSearchCriteria);
	}

	/**
	 * Returns the number of user search criterias where creatorId = &#63; and searchName = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param searchName the search name
	 * @return the number of matching user search criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchNameCreatorId(String creatorId, String searchName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHNAMECREATORID;

		Object[] finderArgs = new Object[] { creatorId, searchName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSEARCHCRITERIA_WHERE);

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_2);
			}

			boolean bindSearchName = false;

			if (searchName == null) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_1);
			}
			else if (searchName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_3);
			}
			else {
				bindSearchName = true;

				query.append(_FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				if (bindSearchName) {
					qPos.add(searchName);
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

	private static final String _FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_1 = "userSearchCriteria.creatorId IS NULL AND ";
	private static final String _FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_2 = "userSearchCriteria.creatorId = ? AND ";
	private static final String _FINDER_COLUMN_SEARCHNAMECREATORID_CREATORID_3 = "(userSearchCriteria.creatorId IS NULL OR userSearchCriteria.creatorId = '') AND ";
	private static final String _FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_1 = "userSearchCriteria.searchName IS NULL";
	private static final String _FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_2 = "userSearchCriteria.searchName = ?";
	private static final String _FINDER_COLUMN_SEARCHNAMECREATORID_SEARCHNAME_3 = "(userSearchCriteria.searchName IS NULL OR userSearchCriteria.searchName = '')";

	public UserSearchCriteriaPersistenceImpl() {
		setModelClass(UserSearchCriteria.class);
	}

	/**
	 * Caches the user search criteria in the entity cache if it is enabled.
	 *
	 * @param userSearchCriteria the user search criteria
	 */
	@Override
	public void cacheResult(UserSearchCriteria userSearchCriteria) {
		EntityCacheUtil.putResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaImpl.class, userSearchCriteria.getPrimaryKey(),
			userSearchCriteria);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAME,
			new Object[] {
				userSearchCriteria.getCreatorId(),
				userSearchCriteria.getSearchName()
			}, userSearchCriteria);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
			new Object[] {
				userSearchCriteria.getCreatorId(),
				userSearchCriteria.getSearchName()
			}, userSearchCriteria);

		userSearchCriteria.resetOriginalValues();
	}

	/**
	 * Caches the user search criterias in the entity cache if it is enabled.
	 *
	 * @param userSearchCriterias the user search criterias
	 */
	@Override
	public void cacheResult(List<UserSearchCriteria> userSearchCriterias) {
		for (UserSearchCriteria userSearchCriteria : userSearchCriterias) {
			if (EntityCacheUtil.getResult(
						UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						UserSearchCriteriaImpl.class,
						userSearchCriteria.getPrimaryKey()) == null) {
				cacheResult(userSearchCriteria);
			}
			else {
				userSearchCriteria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user search criterias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserSearchCriteriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserSearchCriteriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user search criteria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSearchCriteria userSearchCriteria) {
		EntityCacheUtil.removeResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaImpl.class, userSearchCriteria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userSearchCriteria);
	}

	@Override
	public void clearCache(List<UserSearchCriteria> userSearchCriterias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSearchCriteria userSearchCriteria : userSearchCriterias) {
			EntityCacheUtil.removeResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				UserSearchCriteriaImpl.class, userSearchCriteria.getPrimaryKey());

			clearUniqueFindersCache(userSearchCriteria);
		}
	}

	protected void cacheUniqueFindersCache(
		UserSearchCriteria userSearchCriteria) {
		if (userSearchCriteria.isNew()) {
			Object[] args = new Object[] {
					userSearchCriteria.getCreatorId(),
					userSearchCriteria.getSearchName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAME, args,
				userSearchCriteria);

			args = new Object[] {
					userSearchCriteria.getCreatorId(),
					userSearchCriteria.getSearchName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHNAMECREATORID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
				args, userSearchCriteria);
		}
		else {
			UserSearchCriteriaModelImpl userSearchCriteriaModelImpl = (UserSearchCriteriaModelImpl)userSearchCriteria;

			if ((userSearchCriteriaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SEARCHNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSearchCriteria.getCreatorId(),
						userSearchCriteria.getSearchName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAME,
					args, userSearchCriteria);
			}

			if ((userSearchCriteriaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSearchCriteria.getCreatorId(),
						userSearchCriteria.getSearchName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHNAMECREATORID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
					args, userSearchCriteria);
			}
		}
	}

	protected void clearUniqueFindersCache(
		UserSearchCriteria userSearchCriteria) {
		UserSearchCriteriaModelImpl userSearchCriteriaModelImpl = (UserSearchCriteriaModelImpl)userSearchCriteria;

		Object[] args = new Object[] {
				userSearchCriteria.getCreatorId(),
				userSearchCriteria.getSearchName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHNAME, args);

		if ((userSearchCriteriaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SEARCHNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					userSearchCriteriaModelImpl.getOriginalCreatorId(),
					userSearchCriteriaModelImpl.getOriginalSearchName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHNAME, args);
		}

		args = new Object[] {
				userSearchCriteria.getCreatorId(),
				userSearchCriteria.getSearchName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHNAMECREATORID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
			args);

		if ((userSearchCriteriaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID.getColumnBitmask()) != 0) {
			args = new Object[] {
					userSearchCriteriaModelImpl.getOriginalCreatorId(),
					userSearchCriteriaModelImpl.getOriginalSearchName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHNAMECREATORID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHNAMECREATORID,
				args);
		}
	}

	/**
	 * Creates a new user search criteria with the primary key. Does not add the user search criteria to the database.
	 *
	 * @param userSearchId the primary key for the new user search criteria
	 * @return the new user search criteria
	 */
	@Override
	public UserSearchCriteria create(long userSearchId) {
		UserSearchCriteria userSearchCriteria = new UserSearchCriteriaImpl();

		userSearchCriteria.setNew(true);
		userSearchCriteria.setPrimaryKey(userSearchId);

		return userSearchCriteria;
	}

	/**
	 * Removes the user search criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userSearchId the primary key of the user search criteria
	 * @return the user search criteria that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a user search criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria remove(long userSearchId)
		throws NoSuchUserSearchCriteriaException, SystemException {
		return remove((Serializable)userSearchId);
	}

	/**
	 * Removes the user search criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user search criteria
	 * @return the user search criteria that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a user search criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria remove(Serializable primaryKey)
		throws NoSuchUserSearchCriteriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserSearchCriteria userSearchCriteria = (UserSearchCriteria)session.get(UserSearchCriteriaImpl.class,
					primaryKey);

			if (userSearchCriteria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserSearchCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSearchCriteria);
		}
		catch (NoSuchUserSearchCriteriaException nsee) {
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
	protected UserSearchCriteria removeImpl(
		UserSearchCriteria userSearchCriteria) throws SystemException {
		userSearchCriteria = toUnwrappedModel(userSearchCriteria);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userSearchCriteria)) {
				userSearchCriteria = (UserSearchCriteria)session.get(UserSearchCriteriaImpl.class,
						userSearchCriteria.getPrimaryKeyObj());
			}

			if (userSearchCriteria != null) {
				session.delete(userSearchCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userSearchCriteria != null) {
			clearCache(userSearchCriteria);
		}

		return userSearchCriteria;
	}

	@Override
	public UserSearchCriteria updateImpl(
		com.ihg.brandstandards.db.model.UserSearchCriteria userSearchCriteria)
		throws SystemException {
		userSearchCriteria = toUnwrappedModel(userSearchCriteria);

		boolean isNew = userSearchCriteria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userSearchCriteria.isNew()) {
				session.save(userSearchCriteria);

				userSearchCriteria.setNew(false);
			}
			else {
				session.merge(userSearchCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserSearchCriteriaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			UserSearchCriteriaImpl.class, userSearchCriteria.getPrimaryKey(),
			userSearchCriteria);

		clearUniqueFindersCache(userSearchCriteria);
		cacheUniqueFindersCache(userSearchCriteria);

		return userSearchCriteria;
	}

	protected UserSearchCriteria toUnwrappedModel(
		UserSearchCriteria userSearchCriteria) {
		if (userSearchCriteria instanceof UserSearchCriteriaImpl) {
			return userSearchCriteria;
		}

		UserSearchCriteriaImpl userSearchCriteriaImpl = new UserSearchCriteriaImpl();

		userSearchCriteriaImpl.setNew(userSearchCriteria.isNew());
		userSearchCriteriaImpl.setPrimaryKey(userSearchCriteria.getPrimaryKey());

		userSearchCriteriaImpl.setUserSearchId(userSearchCriteria.getUserSearchId());
		userSearchCriteriaImpl.setSearchName(userSearchCriteria.getSearchName());
		userSearchCriteriaImpl.setSearchCriteria(userSearchCriteria.getSearchCriteria());
		userSearchCriteriaImpl.setCreatorId(userSearchCriteria.getCreatorId());
		userSearchCriteriaImpl.setCreatedDate(userSearchCriteria.getCreatedDate());
		userSearchCriteriaImpl.setUpdatedBy(userSearchCriteria.getUpdatedBy());
		userSearchCriteriaImpl.setUpdatedDate(userSearchCriteria.getUpdatedDate());
		userSearchCriteriaImpl.setModuleName(userSearchCriteria.getModuleName());

		return userSearchCriteriaImpl;
	}

	/**
	 * Returns the user search criteria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user search criteria
	 * @return the user search criteria
	 * @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a user search criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserSearchCriteriaException, SystemException {
		UserSearchCriteria userSearchCriteria = fetchByPrimaryKey(primaryKey);

		if (userSearchCriteria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserSearchCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userSearchCriteria;
	}

	/**
	 * Returns the user search criteria with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException} if it could not be found.
	 *
	 * @param userSearchId the primary key of the user search criteria
	 * @return the user search criteria
	 * @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a user search criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria findByPrimaryKey(long userSearchId)
		throws NoSuchUserSearchCriteriaException, SystemException {
		return findByPrimaryKey((Serializable)userSearchId);
	}

	/**
	 * Returns the user search criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user search criteria
	 * @return the user search criteria, or <code>null</code> if a user search criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserSearchCriteria userSearchCriteria = (UserSearchCriteria)EntityCacheUtil.getResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				UserSearchCriteriaImpl.class, primaryKey);

		if (userSearchCriteria == _nullUserSearchCriteria) {
			return null;
		}

		if (userSearchCriteria == null) {
			Session session = null;

			try {
				session = openSession();

				userSearchCriteria = (UserSearchCriteria)session.get(UserSearchCriteriaImpl.class,
						primaryKey);

				if (userSearchCriteria != null) {
					cacheResult(userSearchCriteria);
				}
				else {
					EntityCacheUtil.putResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						UserSearchCriteriaImpl.class, primaryKey,
						_nullUserSearchCriteria);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserSearchCriteriaModelImpl.ENTITY_CACHE_ENABLED,
					UserSearchCriteriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userSearchCriteria;
	}

	/**
	 * Returns the user search criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userSearchId the primary key of the user search criteria
	 * @return the user search criteria, or <code>null</code> if a user search criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSearchCriteria fetchByPrimaryKey(long userSearchId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userSearchId);
	}

	/**
	 * Returns all the user search criterias.
	 *
	 * @return the user search criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserSearchCriteria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user search criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user search criterias
	 * @param end the upper bound of the range of user search criterias (not inclusive)
	 * @return the range of user search criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserSearchCriteria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user search criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user search criterias
	 * @param end the upper bound of the range of user search criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user search criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserSearchCriteria> findAll(int start, int end,
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

		List<UserSearchCriteria> list = (List<UserSearchCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERSEARCHCRITERIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSEARCHCRITERIA;

				if (pagination) {
					sql = sql.concat(UserSearchCriteriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserSearchCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserSearchCriteria>(list);
				}
				else {
					list = (List<UserSearchCriteria>)QueryUtil.list(q,
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
	 * Removes all the user search criterias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserSearchCriteria userSearchCriteria : findAll()) {
			remove(userSearchCriteria);
		}
	}

	/**
	 * Returns the number of user search criterias.
	 *
	 * @return the number of user search criterias
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

				Query q = session.createQuery(_SQL_COUNT_USERSEARCHCRITERIA);

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
	 * Initializes the user search criteria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UserSearchCriteria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserSearchCriteria>> listenersList = new ArrayList<ModelListener<UserSearchCriteria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserSearchCriteria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserSearchCriteriaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERSEARCHCRITERIA = "SELECT userSearchCriteria FROM UserSearchCriteria userSearchCriteria";
	private static final String _SQL_SELECT_USERSEARCHCRITERIA_WHERE = "SELECT userSearchCriteria FROM UserSearchCriteria userSearchCriteria WHERE ";
	private static final String _SQL_COUNT_USERSEARCHCRITERIA = "SELECT COUNT(userSearchCriteria) FROM UserSearchCriteria userSearchCriteria";
	private static final String _SQL_COUNT_USERSEARCHCRITERIA_WHERE = "SELECT COUNT(userSearchCriteria) FROM UserSearchCriteria userSearchCriteria WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSearchCriteria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSearchCriteria exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserSearchCriteria exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserSearchCriteriaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"userSearchId", "searchName", "searchCriteria", "creatorId",
				"createdDate", "updatedBy", "updatedDate", "moduleName"
			});
	private static UserSearchCriteria _nullUserSearchCriteria = new UserSearchCriteriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSearchCriteria> toCacheModel() {
				return _nullUserSearchCriteriaCacheModel;
			}
		};

	private static CacheModel<UserSearchCriteria> _nullUserSearchCriteriaCacheModel =
		new CacheModel<UserSearchCriteria>() {
			@Override
			public UserSearchCriteria toEntityModel() {
				return _nullUserSearchCriteria;
			}
		};
}