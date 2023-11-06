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

import com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException;
import com.ihg.brandstandards.db.model.BridgeGlobalPublish;
import com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishImpl;
import com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl;

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
 * The persistence implementation for the bridge global publish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishPersistence
 * @see BridgeGlobalPublishUtil
 * @generated
 */
public class BridgeGlobalPublishPersistenceImpl extends BasePersistenceImpl<BridgeGlobalPublish>
	implements BridgeGlobalPublishPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgeGlobalPublishUtil} to access the bridge global publish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgeGlobalPublishImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPublishIdAndStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgeGlobalPublishModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgeGlobalPublishModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the bridge global publish where publishId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the matching bridge global publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a matching bridge global publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish findByPublishIdAndStdId(long publishId,
		long stdId) throws NoSuchBridgeGlobalPublishException, SystemException {
		BridgeGlobalPublish bridgeGlobalPublish = fetchByPublishIdAndStdId(publishId,
				stdId);

		if (bridgeGlobalPublish == null) {
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

			throw new NoSuchBridgeGlobalPublishException(msg.toString());
		}

		return bridgeGlobalPublish;
	}

	/**
	 * Returns the bridge global publish where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish fetchByPublishIdAndStdId(long publishId,
		long stdId) throws SystemException {
		return fetchByPublishIdAndStdId(publishId, stdId, true);
	}

	/**
	 * Returns the bridge global publish where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish fetchByPublishIdAndStdId(long publishId,
		long stdId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishId, stdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
					finderArgs, this);
		}

		if (result instanceof BridgeGlobalPublish) {
			BridgeGlobalPublish bridgeGlobalPublish = (BridgeGlobalPublish)result;

			if ((publishId != bridgeGlobalPublish.getPublishId()) ||
					(stdId != bridgeGlobalPublish.getStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(stdId);

				List<BridgeGlobalPublish> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgeGlobalPublishPersistenceImpl.fetchByPublishIdAndStdId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgeGlobalPublish bridgeGlobalPublish = list.get(0);

					result = bridgeGlobalPublish;

					cacheResult(bridgeGlobalPublish);

					if ((bridgeGlobalPublish.getPublishId() != publishId) ||
							(bridgeGlobalPublish.getStdId() != stdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
							finderArgs, bridgeGlobalPublish);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
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
			return (BridgeGlobalPublish)result;
		}
	}

	/**
	 * Removes the bridge global publish where publishId = &#63; and stdId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the bridge global publish that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish removeByPublishIdAndStdId(long publishId,
		long stdId) throws NoSuchBridgeGlobalPublishException, SystemException {
		BridgeGlobalPublish bridgeGlobalPublish = findByPublishIdAndStdId(publishId,
				stdId);

		return remove(bridgeGlobalPublish);
	}

	/**
	 * Returns the number of bridge global publishs where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the number of matching bridge global publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndStdId(long publishId, long stdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID;

		Object[] finderArgs = new Object[] { publishId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEGLOBALPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2 = "bridgeGlobalPublish.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2 = "bridgeGlobalPublish.stdId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByStdIdAndMustPublishInd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			BridgeGlobalPublishModelImpl.STDID_COLUMN_BITMASK |
			BridgeGlobalPublishModelImpl.MUSTPUBLISHIND_COLUMN_BITMASK |
			BridgeGlobalPublishModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDANDMUSTPUBLISHIND = new FinderPath(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStdIdAndMustPublishInd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param mustPublishInd the must publish ind
	 * @param publishId the publish ID
	 * @return the matching bridge global publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a matching bridge global publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish findByStdIdAndMustPublishInd(long stdId,
		String mustPublishInd, long publishId)
		throws NoSuchBridgeGlobalPublishException, SystemException {
		BridgeGlobalPublish bridgeGlobalPublish = fetchByStdIdAndMustPublishInd(stdId,
				mustPublishInd, publishId);

		if (bridgeGlobalPublish == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", mustPublishInd=");
			msg.append(mustPublishInd);

			msg.append(", publishId=");
			msg.append(publishId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgeGlobalPublishException(msg.toString());
		}

		return bridgeGlobalPublish;
	}

	/**
	 * Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param mustPublishInd the must publish ind
	 * @param publishId the publish ID
	 * @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish fetchByStdIdAndMustPublishInd(long stdId,
		String mustPublishInd, long publishId) throws SystemException {
		return fetchByStdIdAndMustPublishInd(stdId, mustPublishInd, publishId,
			true);
	}

	/**
	 * Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param mustPublishInd the must publish ind
	 * @param publishId the publish ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish fetchByStdIdAndMustPublishInd(long stdId,
		String mustPublishInd, long publishId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId, mustPublishInd, publishId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
					finderArgs, this);
		}

		if (result instanceof BridgeGlobalPublish) {
			BridgeGlobalPublish bridgeGlobalPublish = (BridgeGlobalPublish)result;

			if ((stdId != bridgeGlobalPublish.getStdId()) ||
					!Validator.equals(mustPublishInd,
						bridgeGlobalPublish.getMustPublishInd()) ||
					(publishId != bridgeGlobalPublish.getPublishId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_STDID_2);

			boolean bindMustPublishInd = false;

			if (mustPublishInd == null) {
				query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_1);
			}
			else if (mustPublishInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_3);
			}
			else {
				bindMustPublishInd = true;

				query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_2);
			}

			query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindMustPublishInd) {
					qPos.add(mustPublishInd);
				}

				qPos.add(publishId);

				List<BridgeGlobalPublish> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgeGlobalPublishPersistenceImpl.fetchByStdIdAndMustPublishInd(long, String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgeGlobalPublish bridgeGlobalPublish = list.get(0);

					result = bridgeGlobalPublish;

					cacheResult(bridgeGlobalPublish);

					if ((bridgeGlobalPublish.getStdId() != stdId) ||
							(bridgeGlobalPublish.getMustPublishInd() == null) ||
							!bridgeGlobalPublish.getMustPublishInd()
													.equals(mustPublishInd) ||
							(bridgeGlobalPublish.getPublishId() != publishId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
							finderArgs, bridgeGlobalPublish);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
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
			return (BridgeGlobalPublish)result;
		}
	}

	/**
	 * Removes the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param mustPublishInd the must publish ind
	 * @param publishId the publish ID
	 * @return the bridge global publish that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish removeByStdIdAndMustPublishInd(long stdId,
		String mustPublishInd, long publishId)
		throws NoSuchBridgeGlobalPublishException, SystemException {
		BridgeGlobalPublish bridgeGlobalPublish = findByStdIdAndMustPublishInd(stdId,
				mustPublishInd, publishId);

		return remove(bridgeGlobalPublish);
	}

	/**
	 * Returns the number of bridge global publishs where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param mustPublishInd the must publish ind
	 * @param publishId the publish ID
	 * @return the number of matching bridge global publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdAndMustPublishInd(long stdId, String mustPublishInd,
		long publishId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDANDMUSTPUBLISHIND;

		Object[] finderArgs = new Object[] { stdId, mustPublishInd, publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BRIDGEGLOBALPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_STDID_2);

			boolean bindMustPublishInd = false;

			if (mustPublishInd == null) {
				query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_1);
			}
			else if (mustPublishInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_3);
			}
			else {
				bindMustPublishInd = true;

				query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_2);
			}

			query.append(_FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindMustPublishInd) {
					qPos.add(mustPublishInd);
				}

				qPos.add(publishId);

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

	private static final String _FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_STDID_2 = "bridgeGlobalPublish.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_1 =
		"bridgeGlobalPublish.mustPublishInd IS NULL AND ";
	private static final String _FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_2 =
		"bridgeGlobalPublish.mustPublishInd = ? AND ";
	private static final String _FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_MUSTPUBLISHIND_3 =
		"(bridgeGlobalPublish.mustPublishInd IS NULL OR bridgeGlobalPublish.mustPublishInd = '') AND ";
	private static final String _FINDER_COLUMN_STDIDANDMUSTPUBLISHIND_PUBLISHID_2 =
		"bridgeGlobalPublish.publishId = ?";

	public BridgeGlobalPublishPersistenceImpl() {
		setModelClass(BridgeGlobalPublish.class);
	}

	/**
	 * Caches the bridge global publish in the entity cache if it is enabled.
	 *
	 * @param bridgeGlobalPublish the bridge global publish
	 */
	@Override
	public void cacheResult(BridgeGlobalPublish bridgeGlobalPublish) {
		EntityCacheUtil.putResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class, bridgeGlobalPublish.getPrimaryKey(),
			bridgeGlobalPublish);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
			new Object[] {
				bridgeGlobalPublish.getPublishId(),
				bridgeGlobalPublish.getStdId()
			}, bridgeGlobalPublish);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
			new Object[] {
				bridgeGlobalPublish.getStdId(),
				bridgeGlobalPublish.getMustPublishInd(),
				bridgeGlobalPublish.getPublishId()
			}, bridgeGlobalPublish);

		bridgeGlobalPublish.resetOriginalValues();
	}

	/**
	 * Caches the bridge global publishs in the entity cache if it is enabled.
	 *
	 * @param bridgeGlobalPublishs the bridge global publishs
	 */
	@Override
	public void cacheResult(List<BridgeGlobalPublish> bridgeGlobalPublishs) {
		for (BridgeGlobalPublish bridgeGlobalPublish : bridgeGlobalPublishs) {
			if (EntityCacheUtil.getResult(
						BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
						BridgeGlobalPublishImpl.class,
						bridgeGlobalPublish.getPrimaryKey()) == null) {
				cacheResult(bridgeGlobalPublish);
			}
			else {
				bridgeGlobalPublish.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge global publishs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgeGlobalPublishImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgeGlobalPublishImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge global publish.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgeGlobalPublish bridgeGlobalPublish) {
		EntityCacheUtil.removeResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class, bridgeGlobalPublish.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgeGlobalPublish);
	}

	@Override
	public void clearCache(List<BridgeGlobalPublish> bridgeGlobalPublishs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgeGlobalPublish bridgeGlobalPublish : bridgeGlobalPublishs) {
			EntityCacheUtil.removeResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
				BridgeGlobalPublishImpl.class,
				bridgeGlobalPublish.getPrimaryKey());

			clearUniqueFindersCache(bridgeGlobalPublish);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgeGlobalPublish bridgeGlobalPublish) {
		if (bridgeGlobalPublish.isNew()) {
			Object[] args = new Object[] {
					bridgeGlobalPublish.getPublishId(),
					bridgeGlobalPublish.getStdId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
				args, bridgeGlobalPublish);

			args = new Object[] {
					bridgeGlobalPublish.getStdId(),
					bridgeGlobalPublish.getMustPublishInd(),
					bridgeGlobalPublish.getPublishId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDANDMUSTPUBLISHIND,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
				args, bridgeGlobalPublish);
		}
		else {
			BridgeGlobalPublishModelImpl bridgeGlobalPublishModelImpl = (BridgeGlobalPublishModelImpl)bridgeGlobalPublish;

			if ((bridgeGlobalPublishModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeGlobalPublish.getPublishId(),
						bridgeGlobalPublish.getStdId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
					args, bridgeGlobalPublish);
			}

			if ((bridgeGlobalPublishModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeGlobalPublish.getStdId(),
						bridgeGlobalPublish.getMustPublishInd(),
						bridgeGlobalPublish.getPublishId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDANDMUSTPUBLISHIND,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
					args, bridgeGlobalPublish);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgeGlobalPublish bridgeGlobalPublish) {
		BridgeGlobalPublishModelImpl bridgeGlobalPublishModelImpl = (BridgeGlobalPublishModelImpl)bridgeGlobalPublish;

		Object[] args = new Object[] {
				bridgeGlobalPublish.getPublishId(),
				bridgeGlobalPublish.getStdId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
			args);

		if ((bridgeGlobalPublishModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgeGlobalPublishModelImpl.getOriginalPublishId(),
					bridgeGlobalPublishModelImpl.getOriginalStdId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDSTDID,
				args);
		}

		args = new Object[] {
				bridgeGlobalPublish.getStdId(),
				bridgeGlobalPublish.getMustPublishInd(),
				bridgeGlobalPublish.getPublishId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDANDMUSTPUBLISHIND,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
			args);

		if ((bridgeGlobalPublishModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgeGlobalPublishModelImpl.getOriginalStdId(),
					bridgeGlobalPublishModelImpl.getOriginalMustPublishInd(),
					bridgeGlobalPublishModelImpl.getOriginalPublishId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDANDMUSTPUBLISHIND,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDANDMUSTPUBLISHIND,
				args);
		}
	}

	/**
	 * Creates a new bridge global publish with the primary key. Does not add the bridge global publish to the database.
	 *
	 * @param globalPublishId the primary key for the new bridge global publish
	 * @return the new bridge global publish
	 */
	@Override
	public BridgeGlobalPublish create(long globalPublishId) {
		BridgeGlobalPublish bridgeGlobalPublish = new BridgeGlobalPublishImpl();

		bridgeGlobalPublish.setNew(true);
		bridgeGlobalPublish.setPrimaryKey(globalPublishId);

		return bridgeGlobalPublish;
	}

	/**
	 * Removes the bridge global publish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalPublishId the primary key of the bridge global publish
	 * @return the bridge global publish that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish remove(long globalPublishId)
		throws NoSuchBridgeGlobalPublishException, SystemException {
		return remove((Serializable)globalPublishId);
	}

	/**
	 * Removes the bridge global publish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge global publish
	 * @return the bridge global publish that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish remove(Serializable primaryKey)
		throws NoSuchBridgeGlobalPublishException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgeGlobalPublish bridgeGlobalPublish = (BridgeGlobalPublish)session.get(BridgeGlobalPublishImpl.class,
					primaryKey);

			if (bridgeGlobalPublish == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgeGlobalPublishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgeGlobalPublish);
		}
		catch (NoSuchBridgeGlobalPublishException nsee) {
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
	protected BridgeGlobalPublish removeImpl(
		BridgeGlobalPublish bridgeGlobalPublish) throws SystemException {
		bridgeGlobalPublish = toUnwrappedModel(bridgeGlobalPublish);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgeGlobalPublish)) {
				bridgeGlobalPublish = (BridgeGlobalPublish)session.get(BridgeGlobalPublishImpl.class,
						bridgeGlobalPublish.getPrimaryKeyObj());
			}

			if (bridgeGlobalPublish != null) {
				session.delete(bridgeGlobalPublish);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgeGlobalPublish != null) {
			clearCache(bridgeGlobalPublish);
		}

		return bridgeGlobalPublish;
	}

	@Override
	public BridgeGlobalPublish updateImpl(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws SystemException {
		bridgeGlobalPublish = toUnwrappedModel(bridgeGlobalPublish);

		boolean isNew = bridgeGlobalPublish.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bridgeGlobalPublish.isNew()) {
				session.save(bridgeGlobalPublish);

				bridgeGlobalPublish.setNew(false);
			}
			else {
				session.merge(bridgeGlobalPublish);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BridgeGlobalPublishModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishImpl.class, bridgeGlobalPublish.getPrimaryKey(),
			bridgeGlobalPublish);

		clearUniqueFindersCache(bridgeGlobalPublish);
		cacheUniqueFindersCache(bridgeGlobalPublish);

		return bridgeGlobalPublish;
	}

	protected BridgeGlobalPublish toUnwrappedModel(
		BridgeGlobalPublish bridgeGlobalPublish) {
		if (bridgeGlobalPublish instanceof BridgeGlobalPublishImpl) {
			return bridgeGlobalPublish;
		}

		BridgeGlobalPublishImpl bridgeGlobalPublishImpl = new BridgeGlobalPublishImpl();

		bridgeGlobalPublishImpl.setNew(bridgeGlobalPublish.isNew());
		bridgeGlobalPublishImpl.setPrimaryKey(bridgeGlobalPublish.getPrimaryKey());

		bridgeGlobalPublishImpl.setGlobalPublishId(bridgeGlobalPublish.getGlobalPublishId());
		bridgeGlobalPublishImpl.setPublishId(bridgeGlobalPublish.getPublishId());
		bridgeGlobalPublishImpl.setStdId(bridgeGlobalPublish.getStdId());
		bridgeGlobalPublishImpl.setMustPublishInd(bridgeGlobalPublish.getMustPublishInd());
		bridgeGlobalPublishImpl.setCreatorId(bridgeGlobalPublish.getCreatorId());
		bridgeGlobalPublishImpl.setCreatedDate(bridgeGlobalPublish.getCreatedDate());
		bridgeGlobalPublishImpl.setUpdatedBy(bridgeGlobalPublish.getUpdatedBy());
		bridgeGlobalPublishImpl.setUpdatedDate(bridgeGlobalPublish.getUpdatedDate());

		return bridgeGlobalPublishImpl;
	}

	/**
	 * Returns the bridge global publish with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge global publish
	 * @return the bridge global publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgeGlobalPublishException, SystemException {
		BridgeGlobalPublish bridgeGlobalPublish = fetchByPrimaryKey(primaryKey);

		if (bridgeGlobalPublish == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgeGlobalPublishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgeGlobalPublish;
	}

	/**
	 * Returns the bridge global publish with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	 *
	 * @param globalPublishId the primary key of the bridge global publish
	 * @return the bridge global publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish findByPrimaryKey(long globalPublishId)
		throws NoSuchBridgeGlobalPublishException, SystemException {
		return findByPrimaryKey((Serializable)globalPublishId);
	}

	/**
	 * Returns the bridge global publish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge global publish
	 * @return the bridge global publish, or <code>null</code> if a bridge global publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgeGlobalPublish bridgeGlobalPublish = (BridgeGlobalPublish)EntityCacheUtil.getResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
				BridgeGlobalPublishImpl.class, primaryKey);

		if (bridgeGlobalPublish == _nullBridgeGlobalPublish) {
			return null;
		}

		if (bridgeGlobalPublish == null) {
			Session session = null;

			try {
				session = openSession();

				bridgeGlobalPublish = (BridgeGlobalPublish)session.get(BridgeGlobalPublishImpl.class,
						primaryKey);

				if (bridgeGlobalPublish != null) {
					cacheResult(bridgeGlobalPublish);
				}
				else {
					EntityCacheUtil.putResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
						BridgeGlobalPublishImpl.class, primaryKey,
						_nullBridgeGlobalPublish);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgeGlobalPublishModelImpl.ENTITY_CACHE_ENABLED,
					BridgeGlobalPublishImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgeGlobalPublish;
	}

	/**
	 * Returns the bridge global publish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param globalPublishId the primary key of the bridge global publish
	 * @return the bridge global publish, or <code>null</code> if a bridge global publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublish fetchByPrimaryKey(long globalPublishId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)globalPublishId);
	}

	/**
	 * Returns all the bridge global publishs.
	 *
	 * @return the bridge global publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublish> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge global publishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge global publishs
	 * @param end the upper bound of the range of bridge global publishs (not inclusive)
	 * @return the range of bridge global publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublish> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge global publishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge global publishs
	 * @param end the upper bound of the range of bridge global publishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge global publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublish> findAll(int start, int end,
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

		List<BridgeGlobalPublish> list = (List<BridgeGlobalPublish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEGLOBALPUBLISH;

				if (pagination) {
					sql = sql.concat(BridgeGlobalPublishModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgeGlobalPublish>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeGlobalPublish>(list);
				}
				else {
					list = (List<BridgeGlobalPublish>)QueryUtil.list(q,
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
	 * Removes all the bridge global publishs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgeGlobalPublish bridgeGlobalPublish : findAll()) {
			remove(bridgeGlobalPublish);
		}
	}

	/**
	 * Returns the number of bridge global publishs.
	 *
	 * @return the number of bridge global publishs
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEGLOBALPUBLISH);

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
	 * Initializes the bridge global publish persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgeGlobalPublish")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgeGlobalPublish>> listenersList = new ArrayList<ModelListener<BridgeGlobalPublish>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgeGlobalPublish>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgeGlobalPublishImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEGLOBALPUBLISH = "SELECT bridgeGlobalPublish FROM BridgeGlobalPublish bridgeGlobalPublish";
	private static final String _SQL_SELECT_BRIDGEGLOBALPUBLISH_WHERE = "SELECT bridgeGlobalPublish FROM BridgeGlobalPublish bridgeGlobalPublish WHERE ";
	private static final String _SQL_COUNT_BRIDGEGLOBALPUBLISH = "SELECT COUNT(bridgeGlobalPublish) FROM BridgeGlobalPublish bridgeGlobalPublish";
	private static final String _SQL_COUNT_BRIDGEGLOBALPUBLISH_WHERE = "SELECT COUNT(bridgeGlobalPublish) FROM BridgeGlobalPublish bridgeGlobalPublish WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgeGlobalPublish.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgeGlobalPublish exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgeGlobalPublish exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgeGlobalPublishPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"globalPublishId", "publishId", "stdId", "mustPublishInd",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static BridgeGlobalPublish _nullBridgeGlobalPublish = new BridgeGlobalPublishImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgeGlobalPublish> toCacheModel() {
				return _nullBridgeGlobalPublishCacheModel;
			}
		};

	private static CacheModel<BridgeGlobalPublish> _nullBridgeGlobalPublishCacheModel =
		new CacheModel<BridgeGlobalPublish>() {
			@Override
			public BridgeGlobalPublish toEntityModel() {
				return _nullBridgeGlobalPublish;
			}
		};
}