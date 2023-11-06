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

import com.ihg.brandstandards.db.NoSuchPublishCountryStandardException;
import com.ihg.brandstandards.db.model.PublishCountryStandard;
import com.ihg.brandstandards.db.model.impl.PublishCountryStandardImpl;
import com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl;

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
 * The persistence implementation for the publish country standard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishCountryStandardPersistence
 * @see PublishCountryStandardUtil
 * @generated
 */
public class PublishCountryStandardPersistenceImpl extends BasePersistenceImpl<PublishCountryStandard>
	implements PublishCountryStandardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishCountryStandardUtil} to access the publish country standard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishCountryStandardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED,
			PublishCountryStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED,
			PublishCountryStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED,
			PublishCountryStandardImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypublishVerIdCountry",
			new String[] { Long.class.getName(), String.class.getName() },
			PublishCountryStandardModelImpl.PUBLISHVERID_COLUMN_BITMASK |
			PublishCountryStandardModelImpl.COUNTRYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHVERIDCOUNTRY = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublishVerIdCountry",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the publish country standard where publishVerId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishCountryStandardException} if it could not be found.
	 *
	 * @param publishVerId the publish ver ID
	 * @param countryCode the country code
	 * @return the matching publish country standard
	 * @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a matching publish country standard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard findBypublishVerIdCountry(long publishVerId,
		String countryCode)
		throws NoSuchPublishCountryStandardException, SystemException {
		PublishCountryStandard publishCountryStandard = fetchBypublishVerIdCountry(publishVerId,
				countryCode);

		if (publishCountryStandard == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishVerId=");
			msg.append(publishVerId);

			msg.append(", countryCode=");
			msg.append(countryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishCountryStandardException(msg.toString());
		}

		return publishCountryStandard;
	}

	/**
	 * Returns the publish country standard where publishVerId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishVerId the publish ver ID
	 * @param countryCode the country code
	 * @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard fetchBypublishVerIdCountry(
		long publishVerId, String countryCode) throws SystemException {
		return fetchBypublishVerIdCountry(publishVerId, countryCode, true);
	}

	/**
	 * Returns the publish country standard where publishVerId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishVerId the publish ver ID
	 * @param countryCode the country code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard fetchBypublishVerIdCountry(
		long publishVerId, String countryCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { publishVerId, countryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
					finderArgs, this);
		}

		if (result instanceof PublishCountryStandard) {
			PublishCountryStandard publishCountryStandard = (PublishCountryStandard)result;

			if ((publishVerId != publishCountryStandard.getPublishVerId()) ||
					!Validator.equals(countryCode,
						publishCountryStandard.getCountryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PUBLISHCOUNTRYSTANDARD_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_PUBLISHVERID_2);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishVerId);

				if (bindCountryCode) {
					qPos.add(countryCode);
				}

				List<PublishCountryStandard> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishCountryStandardPersistenceImpl.fetchBypublishVerIdCountry(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishCountryStandard publishCountryStandard = list.get(0);

					result = publishCountryStandard;

					cacheResult(publishCountryStandard);

					if ((publishCountryStandard.getPublishVerId() != publishVerId) ||
							(publishCountryStandard.getCountryCode() == null) ||
							!publishCountryStandard.getCountryCode()
													   .equals(countryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
							finderArgs, publishCountryStandard);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
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
			return (PublishCountryStandard)result;
		}
	}

	/**
	 * Removes the publish country standard where publishVerId = &#63; and countryCode = &#63; from the database.
	 *
	 * @param publishVerId the publish ver ID
	 * @param countryCode the country code
	 * @return the publish country standard that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard removeBypublishVerIdCountry(
		long publishVerId, String countryCode)
		throws NoSuchPublishCountryStandardException, SystemException {
		PublishCountryStandard publishCountryStandard = findBypublishVerIdCountry(publishVerId,
				countryCode);

		return remove(publishCountryStandard);
	}

	/**
	 * Returns the number of publish country standards where publishVerId = &#63; and countryCode = &#63;.
	 *
	 * @param publishVerId the publish ver ID
	 * @param countryCode the country code
	 * @return the number of matching publish country standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishVerIdCountry(long publishVerId, String countryCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHVERIDCOUNTRY;

		Object[] finderArgs = new Object[] { publishVerId, countryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLISHCOUNTRYSTANDARD_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_PUBLISHVERID_2);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishVerId);

				if (bindCountryCode) {
					qPos.add(countryCode);
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

	private static final String _FINDER_COLUMN_PUBLISHVERIDCOUNTRY_PUBLISHVERID_2 =
		"publishCountryStandard.publishVerId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_1 =
		"publishCountryStandard.countryCode IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_2 =
		"publishCountryStandard.countryCode = ?";
	private static final String _FINDER_COLUMN_PUBLISHVERIDCOUNTRY_COUNTRYCODE_3 =
		"(publishCountryStandard.countryCode IS NULL OR publishCountryStandard.countryCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED,
			PublishCountryStandardImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypublishCountryStdId",
			new String[] { String.class.getName() },
			PublishCountryStandardModelImpl.PUBLISHCOUNTRYSTDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHCOUNTRYSTDID = new FinderPath(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublishCountryStdId",
			new String[] { String.class.getName() });

	/**
	 * Returns the publish country standard where publishCountryStdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishCountryStandardException} if it could not be found.
	 *
	 * @param publishCountryStdId the publish country std ID
	 * @return the matching publish country standard
	 * @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a matching publish country standard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard findBypublishCountryStdId(
		String publishCountryStdId)
		throws NoSuchPublishCountryStandardException, SystemException {
		PublishCountryStandard publishCountryStandard = fetchBypublishCountryStdId(publishCountryStdId);

		if (publishCountryStandard == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishCountryStdId=");
			msg.append(publishCountryStdId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishCountryStandardException(msg.toString());
		}

		return publishCountryStandard;
	}

	/**
	 * Returns the publish country standard where publishCountryStdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishCountryStdId the publish country std ID
	 * @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard fetchBypublishCountryStdId(
		String publishCountryStdId) throws SystemException {
		return fetchBypublishCountryStdId(publishCountryStdId, true);
	}

	/**
	 * Returns the publish country standard where publishCountryStdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishCountryStdId the publish country std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard fetchBypublishCountryStdId(
		String publishCountryStdId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { publishCountryStdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
					finderArgs, this);
		}

		if (result instanceof PublishCountryStandard) {
			PublishCountryStandard publishCountryStandard = (PublishCountryStandard)result;

			if (!Validator.equals(publishCountryStdId,
						publishCountryStandard.getPublishCountryStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHCOUNTRYSTANDARD_WHERE);

			boolean bindPublishCountryStdId = false;

			if (publishCountryStdId == null) {
				query.append(_FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_1);
			}
			else if (publishCountryStdId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_3);
			}
			else {
				bindPublishCountryStdId = true;

				query.append(_FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishCountryStdId) {
					qPos.add(publishCountryStdId);
				}

				List<PublishCountryStandard> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishCountryStandardPersistenceImpl.fetchBypublishCountryStdId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishCountryStandard publishCountryStandard = list.get(0);

					result = publishCountryStandard;

					cacheResult(publishCountryStandard);

					if ((publishCountryStandard.getPublishCountryStdId() == null) ||
							!publishCountryStandard.getPublishCountryStdId()
													   .equals(publishCountryStdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
							finderArgs, publishCountryStandard);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
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
			return (PublishCountryStandard)result;
		}
	}

	/**
	 * Removes the publish country standard where publishCountryStdId = &#63; from the database.
	 *
	 * @param publishCountryStdId the publish country std ID
	 * @return the publish country standard that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard removeBypublishCountryStdId(
		String publishCountryStdId)
		throws NoSuchPublishCountryStandardException, SystemException {
		PublishCountryStandard publishCountryStandard = findBypublishCountryStdId(publishCountryStdId);

		return remove(publishCountryStandard);
	}

	/**
	 * Returns the number of publish country standards where publishCountryStdId = &#63;.
	 *
	 * @param publishCountryStdId the publish country std ID
	 * @return the number of matching publish country standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishCountryStdId(String publishCountryStdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHCOUNTRYSTDID;

		Object[] finderArgs = new Object[] { publishCountryStdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHCOUNTRYSTANDARD_WHERE);

			boolean bindPublishCountryStdId = false;

			if (publishCountryStdId == null) {
				query.append(_FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_1);
			}
			else if (publishCountryStdId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_3);
			}
			else {
				bindPublishCountryStdId = true;

				query.append(_FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishCountryStdId) {
					qPos.add(publishCountryStdId);
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

	private static final String _FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_1 =
		"publishCountryStandard.publishCountryStdId IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_2 =
		"publishCountryStandard.publishCountryStdId = ?";
	private static final String _FINDER_COLUMN_PUBLISHCOUNTRYSTDID_PUBLISHCOUNTRYSTDID_3 =
		"(publishCountryStandard.publishCountryStdId IS NULL OR publishCountryStandard.publishCountryStdId = '')";

	public PublishCountryStandardPersistenceImpl() {
		setModelClass(PublishCountryStandard.class);
	}

	/**
	 * Caches the publish country standard in the entity cache if it is enabled.
	 *
	 * @param publishCountryStandard the publish country standard
	 */
	@Override
	public void cacheResult(PublishCountryStandard publishCountryStandard) {
		EntityCacheUtil.putResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardImpl.class,
			publishCountryStandard.getPrimaryKey(), publishCountryStandard);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
			new Object[] {
				publishCountryStandard.getPublishVerId(),
				publishCountryStandard.getCountryCode()
			}, publishCountryStandard);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
			new Object[] { publishCountryStandard.getPublishCountryStdId() },
			publishCountryStandard);

		publishCountryStandard.resetOriginalValues();
	}

	/**
	 * Caches the publish country standards in the entity cache if it is enabled.
	 *
	 * @param publishCountryStandards the publish country standards
	 */
	@Override
	public void cacheResult(
		List<PublishCountryStandard> publishCountryStandards) {
		for (PublishCountryStandard publishCountryStandard : publishCountryStandards) {
			if (EntityCacheUtil.getResult(
						PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
						PublishCountryStandardImpl.class,
						publishCountryStandard.getPrimaryKey()) == null) {
				cacheResult(publishCountryStandard);
			}
			else {
				publishCountryStandard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publish country standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishCountryStandardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishCountryStandardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publish country standard.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishCountryStandard publishCountryStandard) {
		EntityCacheUtil.removeResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardImpl.class,
			publishCountryStandard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publishCountryStandard);
	}

	@Override
	public void clearCache(List<PublishCountryStandard> publishCountryStandards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishCountryStandard publishCountryStandard : publishCountryStandards) {
			EntityCacheUtil.removeResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
				PublishCountryStandardImpl.class,
				publishCountryStandard.getPrimaryKey());

			clearUniqueFindersCache(publishCountryStandard);
		}
	}

	protected void cacheUniqueFindersCache(
		PublishCountryStandard publishCountryStandard) {
		if (publishCountryStandard.isNew()) {
			Object[] args = new Object[] {
					publishCountryStandard.getPublishVerId(),
					publishCountryStandard.getCountryCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHVERIDCOUNTRY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
				args, publishCountryStandard);

			args = new Object[] { publishCountryStandard.getPublishCountryStdId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHCOUNTRYSTDID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
				args, publishCountryStandard);
		}
		else {
			PublishCountryStandardModelImpl publishCountryStandardModelImpl = (PublishCountryStandardModelImpl)publishCountryStandard;

			if ((publishCountryStandardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishCountryStandard.getPublishVerId(),
						publishCountryStandard.getCountryCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHVERIDCOUNTRY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
					args, publishCountryStandard);
			}

			if ((publishCountryStandardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishCountryStandard.getPublishCountryStdId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHCOUNTRYSTDID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
					args, publishCountryStandard);
			}
		}
	}

	protected void clearUniqueFindersCache(
		PublishCountryStandard publishCountryStandard) {
		PublishCountryStandardModelImpl publishCountryStandardModelImpl = (PublishCountryStandardModelImpl)publishCountryStandard;

		Object[] args = new Object[] {
				publishCountryStandard.getPublishVerId(),
				publishCountryStandard.getCountryCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHVERIDCOUNTRY,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
			args);

		if ((publishCountryStandardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY.getColumnBitmask()) != 0) {
			args = new Object[] {
					publishCountryStandardModelImpl.getOriginalPublishVerId(),
					publishCountryStandardModelImpl.getOriginalCountryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHVERIDCOUNTRY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHVERIDCOUNTRY,
				args);
		}

		args = new Object[] { publishCountryStandard.getPublishCountryStdId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHCOUNTRYSTDID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
			args);

		if ((publishCountryStandardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					publishCountryStandardModelImpl.getOriginalPublishCountryStdId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHCOUNTRYSTDID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHCOUNTRYSTDID,
				args);
		}
	}

	/**
	 * Creates a new publish country standard with the primary key. Does not add the publish country standard to the database.
	 *
	 * @param publishCountryStdId the primary key for the new publish country standard
	 * @return the new publish country standard
	 */
	@Override
	public PublishCountryStandard create(String publishCountryStdId) {
		PublishCountryStandard publishCountryStandard = new PublishCountryStandardImpl();

		publishCountryStandard.setNew(true);
		publishCountryStandard.setPrimaryKey(publishCountryStdId);

		return publishCountryStandard;
	}

	/**
	 * Removes the publish country standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishCountryStdId the primary key of the publish country standard
	 * @return the publish country standard that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a publish country standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard remove(String publishCountryStdId)
		throws NoSuchPublishCountryStandardException, SystemException {
		return remove((Serializable)publishCountryStdId);
	}

	/**
	 * Removes the publish country standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publish country standard
	 * @return the publish country standard that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a publish country standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard remove(Serializable primaryKey)
		throws NoSuchPublishCountryStandardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishCountryStandard publishCountryStandard = (PublishCountryStandard)session.get(PublishCountryStandardImpl.class,
					primaryKey);

			if (publishCountryStandard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishCountryStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishCountryStandard);
		}
		catch (NoSuchPublishCountryStandardException nsee) {
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
	protected PublishCountryStandard removeImpl(
		PublishCountryStandard publishCountryStandard)
		throws SystemException {
		publishCountryStandard = toUnwrappedModel(publishCountryStandard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishCountryStandard)) {
				publishCountryStandard = (PublishCountryStandard)session.get(PublishCountryStandardImpl.class,
						publishCountryStandard.getPrimaryKeyObj());
			}

			if (publishCountryStandard != null) {
				session.delete(publishCountryStandard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishCountryStandard != null) {
			clearCache(publishCountryStandard);
		}

		return publishCountryStandard;
	}

	@Override
	public PublishCountryStandard updateImpl(
		com.ihg.brandstandards.db.model.PublishCountryStandard publishCountryStandard)
		throws SystemException {
		publishCountryStandard = toUnwrappedModel(publishCountryStandard);

		boolean isNew = publishCountryStandard.isNew();

		Session session = null;

		try {
			session = openSession();

			if (publishCountryStandard.isNew()) {
				session.save(publishCountryStandard);

				publishCountryStandard.setNew(false);
			}
			else {
				session.merge(publishCountryStandard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishCountryStandardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
			PublishCountryStandardImpl.class,
			publishCountryStandard.getPrimaryKey(), publishCountryStandard);

		clearUniqueFindersCache(publishCountryStandard);
		cacheUniqueFindersCache(publishCountryStandard);

		return publishCountryStandard;
	}

	protected PublishCountryStandard toUnwrappedModel(
		PublishCountryStandard publishCountryStandard) {
		if (publishCountryStandard instanceof PublishCountryStandardImpl) {
			return publishCountryStandard;
		}

		PublishCountryStandardImpl publishCountryStandardImpl = new PublishCountryStandardImpl();

		publishCountryStandardImpl.setNew(publishCountryStandard.isNew());
		publishCountryStandardImpl.setPrimaryKey(publishCountryStandard.getPrimaryKey());

		publishCountryStandardImpl.setPublishCountryStdId(publishCountryStandard.getPublishCountryStdId());
		publishCountryStandardImpl.setPublishVerId(publishCountryStandard.getPublishVerId());
		publishCountryStandardImpl.setCountryCode(publishCountryStandard.getCountryCode());
		publishCountryStandardImpl.setExpiredRefTxt(publishCountryStandard.getExpiredRefTxt());
		publishCountryStandardImpl.setPublishStatCode(publishCountryStandard.getPublishStatCode());
		publishCountryStandardImpl.setStdComplyDeadlineDate(publishCountryStandard.getStdComplyDeadlineDate());
		publishCountryStandardImpl.setOrderNumber(publishCountryStandard.getOrderNumber());
		publishCountryStandardImpl.setCreatorId(publishCountryStandard.getCreatorId());
		publishCountryStandardImpl.setCreatedDate(publishCountryStandard.getCreatedDate());
		publishCountryStandardImpl.setUpdatedBy(publishCountryStandard.getUpdatedBy());
		publishCountryStandardImpl.setUpdatedDate(publishCountryStandard.getUpdatedDate());

		return publishCountryStandardImpl;
	}

	/**
	 * Returns the publish country standard with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish country standard
	 * @return the publish country standard
	 * @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a publish country standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishCountryStandardException, SystemException {
		PublishCountryStandard publishCountryStandard = fetchByPrimaryKey(primaryKey);

		if (publishCountryStandard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishCountryStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishCountryStandard;
	}

	/**
	 * Returns the publish country standard with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishCountryStandardException} if it could not be found.
	 *
	 * @param publishCountryStdId the primary key of the publish country standard
	 * @return the publish country standard
	 * @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a publish country standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard findByPrimaryKey(String publishCountryStdId)
		throws NoSuchPublishCountryStandardException, SystemException {
		return findByPrimaryKey((Serializable)publishCountryStdId);
	}

	/**
	 * Returns the publish country standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish country standard
	 * @return the publish country standard, or <code>null</code> if a publish country standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishCountryStandard publishCountryStandard = (PublishCountryStandard)EntityCacheUtil.getResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
				PublishCountryStandardImpl.class, primaryKey);

		if (publishCountryStandard == _nullPublishCountryStandard) {
			return null;
		}

		if (publishCountryStandard == null) {
			Session session = null;

			try {
				session = openSession();

				publishCountryStandard = (PublishCountryStandard)session.get(PublishCountryStandardImpl.class,
						primaryKey);

				if (publishCountryStandard != null) {
					cacheResult(publishCountryStandard);
				}
				else {
					EntityCacheUtil.putResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
						PublishCountryStandardImpl.class, primaryKey,
						_nullPublishCountryStandard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishCountryStandardModelImpl.ENTITY_CACHE_ENABLED,
					PublishCountryStandardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishCountryStandard;
	}

	/**
	 * Returns the publish country standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishCountryStdId the primary key of the publish country standard
	 * @return the publish country standard, or <code>null</code> if a publish country standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishCountryStandard fetchByPrimaryKey(String publishCountryStdId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishCountryStdId);
	}

	/**
	 * Returns all the publish country standards.
	 *
	 * @return the publish country standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishCountryStandard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publish country standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish country standards
	 * @param end the upper bound of the range of publish country standards (not inclusive)
	 * @return the range of publish country standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishCountryStandard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish country standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish country standards
	 * @param end the upper bound of the range of publish country standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publish country standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishCountryStandard> findAll(int start, int end,
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

		List<PublishCountryStandard> list = (List<PublishCountryStandard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHCOUNTRYSTANDARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHCOUNTRYSTANDARD;

				if (pagination) {
					sql = sql.concat(PublishCountryStandardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishCountryStandard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishCountryStandard>(list);
				}
				else {
					list = (List<PublishCountryStandard>)QueryUtil.list(q,
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
	 * Removes all the publish country standards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishCountryStandard publishCountryStandard : findAll()) {
			remove(publishCountryStandard);
		}
	}

	/**
	 * Returns the number of publish country standards.
	 *
	 * @return the number of publish country standards
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHCOUNTRYSTANDARD);

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
	 * Initializes the publish country standard persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishCountryStandard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishCountryStandard>> listenersList = new ArrayList<ModelListener<PublishCountryStandard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishCountryStandard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishCountryStandardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHCOUNTRYSTANDARD = "SELECT publishCountryStandard FROM PublishCountryStandard publishCountryStandard";
	private static final String _SQL_SELECT_PUBLISHCOUNTRYSTANDARD_WHERE = "SELECT publishCountryStandard FROM PublishCountryStandard publishCountryStandard WHERE ";
	private static final String _SQL_COUNT_PUBLISHCOUNTRYSTANDARD = "SELECT COUNT(publishCountryStandard) FROM PublishCountryStandard publishCountryStandard";
	private static final String _SQL_COUNT_PUBLISHCOUNTRYSTANDARD_WHERE = "SELECT COUNT(publishCountryStandard) FROM PublishCountryStandard publishCountryStandard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishCountryStandard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishCountryStandard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishCountryStandard exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishCountryStandardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishCountryStdId", "publishVerId", "countryCode",
				"expiredRefTxt", "publishStatCode", "stdComplyDeadlineDate",
				"orderNumber", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static PublishCountryStandard _nullPublishCountryStandard = new PublishCountryStandardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishCountryStandard> toCacheModel() {
				return _nullPublishCountryStandardCacheModel;
			}
		};

	private static CacheModel<PublishCountryStandard> _nullPublishCountryStandardCacheModel =
		new CacheModel<PublishCountryStandard>() {
			@Override
			public PublishCountryStandard toEntityModel() {
				return _nullPublishCountryStandard;
			}
		};
}