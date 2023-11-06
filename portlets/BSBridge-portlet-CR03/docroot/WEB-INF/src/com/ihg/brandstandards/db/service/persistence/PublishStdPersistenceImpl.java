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

import com.ihg.brandstandards.db.NoSuchPublishStdException;
import com.ihg.brandstandards.db.model.PublishStd;
import com.ihg.brandstandards.db.model.impl.PublishStdImpl;
import com.ihg.brandstandards.db.model.impl.PublishStdModelImpl;

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
 * The persistence implementation for the publish std service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishStdPersistence
 * @see PublishStdUtil
 * @generated
 */
public class PublishStdPersistenceImpl extends BasePersistenceImpl<PublishStd>
	implements PublishStdPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishStdUtil} to access the publish std persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishStdImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHFORSTDID = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBypublishForStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PublishStdModelImpl.PUBLISHID_COLUMN_BITMASK |
			PublishStdModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHFORSTDID = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublishForStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the publish std where publishId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the matching publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findBypublishForStdId(long publishId, long stdId)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchBypublishForStdId(publishId, stdId);

		if (publishStd == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(", stdId=");
			msg.append(stdId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishStdException(msg.toString());
		}

		return publishStd;
	}

	/**
	 * Returns the publish std where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBypublishForStdId(long publishId, long stdId)
		throws SystemException {
		return fetchBypublishForStdId(publishId, stdId, true);
	}

	/**
	 * Returns the publish std where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBypublishForStdId(long publishId, long stdId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishId, stdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
					finderArgs, this);
		}

		if (result instanceof PublishStd) {
			PublishStd publishStd = (PublishStd)result;

			if ((publishId != publishStd.getPublishId()) ||
					(stdId != publishStd.getStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PUBLISHSTD_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHFORSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHFORSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(stdId);

				List<PublishStd> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishStdPersistenceImpl.fetchBypublishForStdId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishStd publishStd = list.get(0);

					result = publishStd;

					cacheResult(publishStd);

					if ((publishStd.getPublishId() != publishId) ||
							(publishStd.getStdId() != stdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
							finderArgs, publishStd);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
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
			return (PublishStd)result;
		}
	}

	/**
	 * Removes the publish std where publishId = &#63; and stdId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the publish std that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd removeBypublishForStdId(long publishId, long stdId)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = findBypublishForStdId(publishId, stdId);

		return remove(publishStd);
	}

	/**
	 * Returns the number of publish stds where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the number of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishForStdId(long publishId, long stdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHFORSTDID;

		Object[] finderArgs = new Object[] { publishId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLISHSTD_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHFORSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHFORSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

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

	private static final String _FINDER_COLUMN_PUBLISHFORSTDID_PUBLISHID_2 = "publishStd.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHFORSTDID_STDID_2 = "publishStd.stdId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHSTDID = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBypublishStdId",
			new String[] { Long.class.getName() },
			PublishStdModelImpl.PUBLISHSTDVERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHSTDID = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypublishStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the publish std where publishStdVerId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	 *
	 * @param publishStdVerId the publish std ver ID
	 * @return the matching publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findBypublishStdId(long publishStdVerId)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchBypublishStdId(publishStdVerId);

		if (publishStd == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishStdVerId=");
			msg.append(publishStdVerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishStdException(msg.toString());
		}

		return publishStd;
	}

	/**
	 * Returns the publish std where publishStdVerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishStdVerId the publish std ver ID
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBypublishStdId(long publishStdVerId)
		throws SystemException {
		return fetchBypublishStdId(publishStdVerId, true);
	}

	/**
	 * Returns the publish std where publishStdVerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishStdVerId the publish std ver ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBypublishStdId(long publishStdVerId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishStdVerId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID,
					finderArgs, this);
		}

		if (result instanceof PublishStd) {
			PublishStd publishStd = (PublishStd)result;

			if ((publishStdVerId != publishStd.getPublishStdVerId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHSTD_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHSTDID_PUBLISHSTDVERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishStdVerId);

				List<PublishStd> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishStdPersistenceImpl.fetchBypublishStdId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishStd publishStd = list.get(0);

					result = publishStd;

					cacheResult(publishStd);

					if ((publishStd.getPublishStdVerId() != publishStdVerId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID,
							finderArgs, publishStd);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID,
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
			return (PublishStd)result;
		}
	}

	/**
	 * Removes the publish std where publishStdVerId = &#63; from the database.
	 *
	 * @param publishStdVerId the publish std ver ID
	 * @return the publish std that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd removeBypublishStdId(long publishStdVerId)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = findBypublishStdId(publishStdVerId);

		return remove(publishStd);
	}

	/**
	 * Returns the number of publish stds where publishStdVerId = &#63;.
	 *
	 * @param publishStdVerId the publish std ver ID
	 * @return the number of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishStdId(long publishStdVerId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHSTDID;

		Object[] finderArgs = new Object[] { publishStdVerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHSTD_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHSTDID_PUBLISHSTDVERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishStdVerId);

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

	private static final String _FINDER_COLUMN_PUBLISHSTDID_PUBLISHSTDVERID_2 = "publishStd.publishStdVerId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_STDTYP = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystdTyp",
			new String[] { String.class.getName() },
			PublishStdModelImpl.STDTYP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDTYP = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdTyp",
			new String[] { String.class.getName() });

	/**
	 * Returns the publish std where stdTyp = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	 *
	 * @param stdTyp the std typ
	 * @return the matching publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findBystdTyp(String stdTyp)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchBystdTyp(stdTyp);

		if (publishStd == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdTyp=");
			msg.append(stdTyp);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishStdException(msg.toString());
		}

		return publishStd;
	}

	/**
	 * Returns the publish std where stdTyp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdTyp the std typ
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBystdTyp(String stdTyp) throws SystemException {
		return fetchBystdTyp(stdTyp, true);
	}

	/**
	 * Returns the publish std where stdTyp = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdTyp the std typ
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBystdTyp(String stdTyp, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdTyp };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDTYP,
					finderArgs, this);
		}

		if (result instanceof PublishStd) {
			PublishStd publishStd = (PublishStd)result;

			if (!Validator.equals(stdTyp, publishStd.getStdTyp())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHSTD_WHERE);

			boolean bindStdTyp = false;

			if (stdTyp == null) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_1);
			}
			else if (stdTyp.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_3);
			}
			else {
				bindStdTyp = true;

				query.append(_FINDER_COLUMN_STDTYP_STDTYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStdTyp) {
					qPos.add(stdTyp);
				}

				List<PublishStd> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishStdPersistenceImpl.fetchBystdTyp(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishStd publishStd = list.get(0);

					result = publishStd;

					cacheResult(publishStd);

					if ((publishStd.getStdTyp() == null) ||
							!publishStd.getStdTyp().equals(stdTyp)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP,
							finderArgs, publishStd);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDTYP,
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
			return (PublishStd)result;
		}
	}

	/**
	 * Removes the publish std where stdTyp = &#63; from the database.
	 *
	 * @param stdTyp the std typ
	 * @return the publish std that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd removeBystdTyp(String stdTyp)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = findBystdTyp(stdTyp);

		return remove(publishStd);
	}

	/**
	 * Returns the number of publish stds where stdTyp = &#63;.
	 *
	 * @param stdTyp the std typ
	 * @return the number of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdTyp(String stdTyp) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDTYP;

		Object[] finderArgs = new Object[] { stdTyp };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHSTD_WHERE);

			boolean bindStdTyp = false;

			if (stdTyp == null) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_1);
			}
			else if (stdTyp.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_3);
			}
			else {
				bindStdTyp = true;

				query.append(_FINDER_COLUMN_STDTYP_STDTYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStdTyp) {
					qPos.add(stdTyp);
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

	private static final String _FINDER_COLUMN_STDTYP_STDTYP_1 = "publishStd.stdTyp IS NULL";
	private static final String _FINDER_COLUMN_STDTYP_STDTYP_2 = "publishStd.stdTyp = ?";
	private static final String _FINDER_COLUMN_STDTYP_STDTYP_3 = "(publishStd.stdTyp IS NULL OR publishStd.stdTyp = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_STATUS = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystatus",
			new String[] { String.class.getName() },
			PublishStdModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { String.class.getName() });

	/**
	 * Returns the publish std where status = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	 *
	 * @param status the status
	 * @return the matching publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findBystatus(String status)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchBystatus(status);

		if (publishStd == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishStdException(msg.toString());
		}

		return publishStd;
	}

	/**
	 * Returns the publish std where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBystatus(String status) throws SystemException {
		return fetchBystatus(status, true);
	}

	/**
	 * Returns the publish std where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchBystatus(String status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STATUS,
					finderArgs, this);
		}

		if (result instanceof PublishStd) {
			PublishStd publishStd = (PublishStd)result;

			if (!Validator.equals(status, publishStd.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHSTD_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				List<PublishStd> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishStdPersistenceImpl.fetchBystatus(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishStd publishStd = list.get(0);

					result = publishStd;

					cacheResult(publishStd);

					if ((publishStd.getStatus() == null) ||
							!publishStd.getStatus().equals(status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
							finderArgs, publishStd);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS,
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
			return (PublishStd)result;
		}
	}

	/**
	 * Removes the publish std where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the publish std that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd removeBystatus(String status)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = findBystatus(status);

		return remove(publishStd);
	}

	/**
	 * Returns the number of publish stds where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystatus(String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHSTD_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "publishStd.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "publishStd.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(publishStd.status IS NULL OR publishStd.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTPUBLISHID =
		new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparentPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTPUBLISHID =
		new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, PublishStdImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparentPublishId",
			new String[] { Long.class.getName() },
			PublishStdModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTPUBLISHID = new FinderPath(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentPublishId", new String[] { Long.class.getName() });

	/**
	 * Returns all the publish stds where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStd> findByparentPublishId(long parentId)
		throws SystemException {
		return findByparentPublishId(parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publish stds where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of publish stds
	 * @param end the upper bound of the range of publish stds (not inclusive)
	 * @return the range of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStd> findByparentPublishId(long parentId, int start,
		int end) throws SystemException {
		return findByparentPublishId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish stds where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of publish stds
	 * @param end the upper bound of the range of publish stds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStd> findByparentPublishId(long parentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTPUBLISHID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTPUBLISHID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<PublishStd> list = (List<PublishStd>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishStd publishStd : list) {
				if ((parentId != publishStd.getParentId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PUBLISHSTD_WHERE);

			query.append(_FINDER_COLUMN_PARENTPUBLISHID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishStdModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<PublishStd>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishStd>(list);
				}
				else {
					list = (List<PublishStd>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first publish std in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findByparentPublishId_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchByparentPublishId_First(parentId,
				orderByComparator);

		if (publishStd != null) {
			return publishStd;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishStdException(msg.toString());
	}

	/**
	 * Returns the first publish std in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchByparentPublishId_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishStd> list = findByparentPublishId(parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publish std in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findByparentPublishId_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchByparentPublishId_Last(parentId,
				orderByComparator);

		if (publishStd != null) {
			return publishStd;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishStdException(msg.toString());
	}

	/**
	 * Returns the last publish std in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish std, or <code>null</code> if a matching publish std could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchByparentPublishId_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentPublishId(parentId);

		if (count == 0) {
			return null;
		}

		List<PublishStd> list = findByparentPublishId(parentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publish stds before and after the current publish std in the ordered set where parentId = &#63;.
	 *
	 * @param publishStdVerId the primary key of the current publish std
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd[] findByparentPublishId_PrevAndNext(
		long publishStdVerId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = findByPrimaryKey(publishStdVerId);

		Session session = null;

		try {
			session = openSession();

			PublishStd[] array = new PublishStdImpl[3];

			array[0] = getByparentPublishId_PrevAndNext(session, publishStd,
					parentId, orderByComparator, true);

			array[1] = publishStd;

			array[2] = getByparentPublishId_PrevAndNext(session, publishStd,
					parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishStd getByparentPublishId_PrevAndNext(Session session,
		PublishStd publishStd, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHSTD_WHERE);

		query.append(_FINDER_COLUMN_PARENTPUBLISHID_PARENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PublishStdModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishStd);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishStd> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publish stds where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentPublishId(long parentId)
		throws SystemException {
		for (PublishStd publishStd : findByparentPublishId(parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishStd);
		}
	}

	/**
	 * Returns the number of publish stds where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentPublishId(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTPUBLISHID;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHSTD_WHERE);

			query.append(_FINDER_COLUMN_PARENTPUBLISHID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTPUBLISHID_PARENTID_2 = "publishStd.parentId = ?";

	public PublishStdPersistenceImpl() {
		setModelClass(PublishStd.class);
	}

	/**
	 * Caches the publish std in the entity cache if it is enabled.
	 *
	 * @param publishStd the publish std
	 */
	@Override
	public void cacheResult(PublishStd publishStd) {
		EntityCacheUtil.putResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdImpl.class, publishStd.getPrimaryKey(), publishStd);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
			new Object[] { publishStd.getPublishId(), publishStd.getStdId() },
			publishStd);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID,
			new Object[] { publishStd.getPublishStdVerId() }, publishStd);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP,
			new Object[] { publishStd.getStdTyp() }, publishStd);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
			new Object[] { publishStd.getStatus() }, publishStd);

		publishStd.resetOriginalValues();
	}

	/**
	 * Caches the publish stds in the entity cache if it is enabled.
	 *
	 * @param publishStds the publish stds
	 */
	@Override
	public void cacheResult(List<PublishStd> publishStds) {
		for (PublishStd publishStd : publishStds) {
			if (EntityCacheUtil.getResult(
						PublishStdModelImpl.ENTITY_CACHE_ENABLED,
						PublishStdImpl.class, publishStd.getPrimaryKey()) == null) {
				cacheResult(publishStd);
			}
			else {
				publishStd.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publish stds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishStdImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishStdImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publish std.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishStd publishStd) {
		EntityCacheUtil.removeResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdImpl.class, publishStd.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publishStd);
	}

	@Override
	public void clearCache(List<PublishStd> publishStds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishStd publishStd : publishStds) {
			EntityCacheUtil.removeResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
				PublishStdImpl.class, publishStd.getPrimaryKey());

			clearUniqueFindersCache(publishStd);
		}
	}

	protected void cacheUniqueFindersCache(PublishStd publishStd) {
		if (publishStd.isNew()) {
			Object[] args = new Object[] {
					publishStd.getPublishId(), publishStd.getStdId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHFORSTDID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
				args, publishStd);

			args = new Object[] { publishStd.getPublishStdVerId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHSTDID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID, args,
				publishStd);

			args = new Object[] { publishStd.getStdTyp() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDTYP, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP, args,
				publishStd);

			args = new Object[] { publishStd.getStatus() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
				publishStd);
		}
		else {
			PublishStdModelImpl publishStdModelImpl = (PublishStdModelImpl)publishStd;

			if ((publishStdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHFORSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishStd.getPublishId(), publishStd.getStdId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHFORSTDID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
					args, publishStd);
			}

			if ((publishStdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishStd.getPublishStdVerId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHSTDID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID,
					args, publishStd);
			}

			if ((publishStdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDTYP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishStd.getStdTyp() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDTYP, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP, args,
					publishStd);
			}

			if ((publishStdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishStd.getStatus() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
					publishStd);
			}
		}
	}

	protected void clearUniqueFindersCache(PublishStd publishStd) {
		PublishStdModelImpl publishStdModelImpl = (PublishStdModelImpl)publishStd;

		Object[] args = new Object[] {
				publishStd.getPublishId(), publishStd.getStdId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHFORSTDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID, args);

		if ((publishStdModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHFORSTDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					publishStdModelImpl.getOriginalPublishId(),
					publishStdModelImpl.getOriginalStdId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHFORSTDID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHFORSTDID,
				args);
		}

		args = new Object[] { publishStd.getPublishStdVerId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID, args);

		if ((publishStdModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHSTDID.getColumnBitmask()) != 0) {
			args = new Object[] { publishStdModelImpl.getOriginalPublishStdVerId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTDID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHSTDID, args);
		}

		args = new Object[] { publishStd.getStdTyp() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDTYP, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDTYP, args);

		if ((publishStdModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDTYP.getColumnBitmask()) != 0) {
			args = new Object[] { publishStdModelImpl.getOriginalStdTyp() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDTYP, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDTYP, args);
		}

		args = new Object[] { publishStd.getStatus() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);

		if ((publishStdModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
			args = new Object[] { publishStdModelImpl.getOriginalStatus() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);
		}
	}

	/**
	 * Creates a new publish std with the primary key. Does not add the publish std to the database.
	 *
	 * @param publishStdVerId the primary key for the new publish std
	 * @return the new publish std
	 */
	@Override
	public PublishStd create(long publishStdVerId) {
		PublishStd publishStd = new PublishStdImpl();

		publishStd.setNew(true);
		publishStd.setPrimaryKey(publishStdVerId);

		return publishStd;
	}

	/**
	 * Removes the publish std with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishStdVerId the primary key of the publish std
	 * @return the publish std that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd remove(long publishStdVerId)
		throws NoSuchPublishStdException, SystemException {
		return remove((Serializable)publishStdVerId);
	}

	/**
	 * Removes the publish std with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publish std
	 * @return the publish std that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd remove(Serializable primaryKey)
		throws NoSuchPublishStdException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishStd publishStd = (PublishStd)session.get(PublishStdImpl.class,
					primaryKey);

			if (publishStd == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishStdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishStd);
		}
		catch (NoSuchPublishStdException nsee) {
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
	protected PublishStd removeImpl(PublishStd publishStd)
		throws SystemException {
		publishStd = toUnwrappedModel(publishStd);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishStd)) {
				publishStd = (PublishStd)session.get(PublishStdImpl.class,
						publishStd.getPrimaryKeyObj());
			}

			if (publishStd != null) {
				session.delete(publishStd);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishStd != null) {
			clearCache(publishStd);
		}

		return publishStd;
	}

	@Override
	public PublishStd updateImpl(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws SystemException {
		publishStd = toUnwrappedModel(publishStd);

		boolean isNew = publishStd.isNew();

		PublishStdModelImpl publishStdModelImpl = (PublishStdModelImpl)publishStd;

		Session session = null;

		try {
			session = openSession();

			if (publishStd.isNew()) {
				session.save(publishStd);

				publishStd.setNew(false);
			}
			else {
				session.merge(publishStd);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishStdModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publishStdModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTPUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishStdModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTPUBLISHID,
					args);

				args = new Object[] { publishStdModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTPUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
			PublishStdImpl.class, publishStd.getPrimaryKey(), publishStd);

		clearUniqueFindersCache(publishStd);
		cacheUniqueFindersCache(publishStd);

		return publishStd;
	}

	protected PublishStd toUnwrappedModel(PublishStd publishStd) {
		if (publishStd instanceof PublishStdImpl) {
			return publishStd;
		}

		PublishStdImpl publishStdImpl = new PublishStdImpl();

		publishStdImpl.setNew(publishStd.isNew());
		publishStdImpl.setPrimaryKey(publishStd.getPrimaryKey());

		publishStdImpl.setPublishStdVerId(publishStd.getPublishStdVerId());
		publishStdImpl.setStdId(publishStd.getStdId());
		publishStdImpl.setParentId(publishStd.getParentId());
		publishStdImpl.setStdTyp(publishStd.getStdTyp());
		publishStdImpl.setTitle(publishStd.getTitle());
		publishStdImpl.setDescription(publishStd.getDescription());
		publishStdImpl.setAuthor(publishStd.getAuthor());
		publishStdImpl.setBusinessOwner(publishStd.getBusinessOwner());
		publishStdImpl.setEffectiveDate(publishStd.getEffectiveDate());
		publishStdImpl.setImplDate(publishStd.getImplDate());
		publishStdImpl.setWaiver(publishStd.getWaiver());
		publishStdImpl.setStatus(publishStd.getStatus());
		publishStdImpl.setCategory(publishStd.getCategory());
		publishStdImpl.setCreatedBy(publishStd.getCreatedBy());
		publishStdImpl.setChange(publishStd.getChange());
		publishStdImpl.setIsGlobal(publishStd.getIsGlobal());
		publishStdImpl.setRegionCode(publishStd.getRegionCode());
		publishStdImpl.setNotes(publishStd.getNotes());
		publishStdImpl.setFramework(publishStd.getFramework());
		publishStdImpl.setInternalReference(publishStd.getInternalReference());
		publishStdImpl.setOrderNumber(publishStd.getOrderNumber());
		publishStdImpl.setStatusIdentifier(publishStd.getStatusIdentifier());
		publishStdImpl.setRegionIdentifier(publishStd.getRegionIdentifier());
		publishStdImpl.setPublishId(publishStd.getPublishId());
		publishStdImpl.setCreatorId(publishStd.getCreatorId());
		publishStdImpl.setCreatedDate(publishStd.getCreatedDate());
		publishStdImpl.setUpdatedBy(publishStd.getUpdatedBy());
		publishStdImpl.setUpdatedDate(publishStd.getUpdatedDate());

		return publishStdImpl;
	}

	/**
	 * Returns the publish std with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish std
	 * @return the publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishStdException, SystemException {
		PublishStd publishStd = fetchByPrimaryKey(primaryKey);

		if (publishStd == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishStdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishStd;
	}

	/**
	 * Returns the publish std with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	 *
	 * @param publishStdVerId the primary key of the publish std
	 * @return the publish std
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd findByPrimaryKey(long publishStdVerId)
		throws NoSuchPublishStdException, SystemException {
		return findByPrimaryKey((Serializable)publishStdVerId);
	}

	/**
	 * Returns the publish std with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish std
	 * @return the publish std, or <code>null</code> if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishStd publishStd = (PublishStd)EntityCacheUtil.getResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
				PublishStdImpl.class, primaryKey);

		if (publishStd == _nullPublishStd) {
			return null;
		}

		if (publishStd == null) {
			Session session = null;

			try {
				session = openSession();

				publishStd = (PublishStd)session.get(PublishStdImpl.class,
						primaryKey);

				if (publishStd != null) {
					cacheResult(publishStd);
				}
				else {
					EntityCacheUtil.putResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
						PublishStdImpl.class, primaryKey, _nullPublishStd);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishStdModelImpl.ENTITY_CACHE_ENABLED,
					PublishStdImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishStd;
	}

	/**
	 * Returns the publish std with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishStdVerId the primary key of the publish std
	 * @return the publish std, or <code>null</code> if a publish std with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStd fetchByPrimaryKey(long publishStdVerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishStdVerId);
	}

	/**
	 * Returns all the publish stds.
	 *
	 * @return the publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStd> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publish stds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish stds
	 * @param end the upper bound of the range of publish stds (not inclusive)
	 * @return the range of publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStd> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish stds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish stds
	 * @param end the upper bound of the range of publish stds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publish stds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStd> findAll(int start, int end,
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

		List<PublishStd> list = (List<PublishStd>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHSTD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHSTD;

				if (pagination) {
					sql = sql.concat(PublishStdModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishStd>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishStd>(list);
				}
				else {
					list = (List<PublishStd>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the publish stds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishStd publishStd : findAll()) {
			remove(publishStd);
		}
	}

	/**
	 * Returns the number of publish stds.
	 *
	 * @return the number of publish stds
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHSTD);

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
	 * Initializes the publish std persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishStd")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishStd>> listenersList = new ArrayList<ModelListener<PublishStd>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishStd>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishStdImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHSTD = "SELECT publishStd FROM PublishStd publishStd";
	private static final String _SQL_SELECT_PUBLISHSTD_WHERE = "SELECT publishStd FROM PublishStd publishStd WHERE ";
	private static final String _SQL_COUNT_PUBLISHSTD = "SELECT COUNT(publishStd) FROM PublishStd publishStd";
	private static final String _SQL_COUNT_PUBLISHSTD_WHERE = "SELECT COUNT(publishStd) FROM PublishStd publishStd WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishStd.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishStd exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishStd exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishStdPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishStdVerId", "stdId", "parentId", "stdTyp", "title",
				"description", "author", "businessOwner", "effectiveDate",
				"implDate", "waiver", "status", "category", "createdBy",
				"change", "isGlobal", "regionCode", "notes", "framework",
				"internalReference", "orderNumber", "statusIdentifier",
				"regionIdentifier", "publishId", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static PublishStd _nullPublishStd = new PublishStdImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishStd> toCacheModel() {
				return _nullPublishStdCacheModel;
			}
		};

	private static CacheModel<PublishStd> _nullPublishStdCacheModel = new CacheModel<PublishStd>() {
			@Override
			public PublishStd toEntityModel() {
				return _nullPublishStd;
			}
		};
}