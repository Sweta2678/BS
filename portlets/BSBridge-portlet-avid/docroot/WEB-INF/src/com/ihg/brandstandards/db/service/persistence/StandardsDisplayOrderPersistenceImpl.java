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

import com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException;
import com.ihg.brandstandards.db.model.StandardsDisplayOrder;
import com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderImpl;
import com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl;

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
 * The persistence implementation for the standards display order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderPersistence
 * @see StandardsDisplayOrderUtil
 * @generated
 */
public class StandardsDisplayOrderPersistenceImpl extends BasePersistenceImpl<StandardsDisplayOrder>
	implements StandardsDisplayOrderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsDisplayOrderUtil} to access the standards display order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsDisplayOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE = new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByStdIdChainIdRegionCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			StandardsDisplayOrderModelImpl.STDID_COLUMN_BITMASK |
			StandardsDisplayOrderModelImpl.CHAINCODE_COLUMN_BITMASK |
			StandardsDisplayOrderModelImpl.REGIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDCHAINIDREGIONCODE = new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStdIdChainIdRegionCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the matching standards display order
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder findByStdIdChainIdRegionCode(long stdId,
		String chainCode, String regionCode)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		StandardsDisplayOrder standardsDisplayOrder = fetchByStdIdChainIdRegionCode(stdId,
				chainCode, regionCode);

		if (standardsDisplayOrder == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(", regionCode=");
			msg.append(regionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsDisplayOrderException(msg.toString());
		}

		return standardsDisplayOrder;
	}

	/**
	 * Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the matching standards display order, or <code>null</code> if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder fetchByStdIdChainIdRegionCode(long stdId,
		String chainCode, String regionCode) throws SystemException {
		return fetchByStdIdChainIdRegionCode(stdId, chainCode, regionCode, true);
	}

	/**
	 * Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards display order, or <code>null</code> if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder fetchByStdIdChainIdRegionCode(long stdId,
		String chainCode, String regionCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId, chainCode, regionCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
					finderArgs, this);
		}

		if (result instanceof StandardsDisplayOrder) {
			StandardsDisplayOrder standardsDisplayOrder = (StandardsDisplayOrder)result;

			if ((stdId != standardsDisplayOrder.getStdId()) ||
					!Validator.equals(chainCode,
						standardsDisplayOrder.getChainCode()) ||
					!Validator.equals(regionCode,
						standardsDisplayOrder.getRegionCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STANDARDSDISPLAYORDER_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_2);
			}

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				List<StandardsDisplayOrder> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsDisplayOrderPersistenceImpl.fetchByStdIdChainIdRegionCode(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsDisplayOrder standardsDisplayOrder = list.get(0);

					result = standardsDisplayOrder;

					cacheResult(standardsDisplayOrder);

					if ((standardsDisplayOrder.getStdId() != stdId) ||
							(standardsDisplayOrder.getChainCode() == null) ||
							!standardsDisplayOrder.getChainCode()
													  .equals(chainCode) ||
							(standardsDisplayOrder.getRegionCode() == null) ||
							!standardsDisplayOrder.getRegionCode()
													  .equals(regionCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
							finderArgs, standardsDisplayOrder);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
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
			return (StandardsDisplayOrder)result;
		}
	}

	/**
	 * Removes the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the standards display order that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder removeByStdIdChainIdRegionCode(long stdId,
		String chainCode, String regionCode)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		StandardsDisplayOrder standardsDisplayOrder = findByStdIdChainIdRegionCode(stdId,
				chainCode, regionCode);

		return remove(standardsDisplayOrder);
	}

	/**
	 * Returns the number of standards display orders where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the number of matching standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdChainIdRegionCode(long stdId, String chainCode,
		String regionCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDCHAINIDREGIONCODE;

		Object[] finderArgs = new Object[] { stdId, chainCode, regionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSDISPLAYORDER_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_2);
			}

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

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

	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_STDID_2 = "standardsDisplayOrder.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_1 =
		"standardsDisplayOrder.id.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_2 =
		"standardsDisplayOrder.id.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_CHAINCODE_3 =
		"(standardsDisplayOrder.id.chainCode IS NULL OR standardsDisplayOrder.id.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_1 =
		"standardsDisplayOrder.id.regionCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_2 =
		"standardsDisplayOrder.id.regionCode = ?";
	private static final String _FINDER_COLUMN_STDIDCHAINIDREGIONCODE_REGIONCODE_3 =
		"(standardsDisplayOrder.id.regionCode IS NULL OR standardsDisplayOrder.id.regionCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAINCODEREGIONCODE =
		new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChainCodeRegionCode",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEREGIONCODE =
		new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChainCodeRegionCode",
			new String[] { String.class.getName(), String.class.getName() },
			StandardsDisplayOrderModelImpl.CHAINCODE_COLUMN_BITMASK |
			StandardsDisplayOrderModelImpl.REGIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAINCODEREGIONCODE = new FinderPath(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChainCodeRegionCode",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the matching standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrder> findByChainCodeRegionCode(
		String chainCode, String regionCode) throws SystemException {
		return findByChainCodeRegionCode(chainCode, regionCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param start the lower bound of the range of standards display orders
	 * @param end the upper bound of the range of standards display orders (not inclusive)
	 * @return the range of matching standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrder> findByChainCodeRegionCode(
		String chainCode, String regionCode, int start, int end)
		throws SystemException {
		return findByChainCodeRegionCode(chainCode, regionCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param start the lower bound of the range of standards display orders
	 * @param end the upper bound of the range of standards display orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrder> findByChainCodeRegionCode(
		String chainCode, String regionCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEREGIONCODE;
			finderArgs = new Object[] { chainCode, regionCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAINCODEREGIONCODE;
			finderArgs = new Object[] {
					chainCode, regionCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsDisplayOrder> list = (List<StandardsDisplayOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsDisplayOrder standardsDisplayOrder : list) {
				if (!Validator.equals(chainCode,
							standardsDisplayOrder.getChainCode()) ||
						!Validator.equals(regionCode,
							standardsDisplayOrder.getRegionCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STANDARDSDISPLAYORDER_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_2);
			}

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsDisplayOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				if (!pagination) {
					list = (List<StandardsDisplayOrder>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsDisplayOrder>(list);
				}
				else {
					list = (List<StandardsDisplayOrder>)QueryUtil.list(q,
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
	 * Returns the first standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards display order
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder findByChainCodeRegionCode_First(
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		StandardsDisplayOrder standardsDisplayOrder = fetchByChainCodeRegionCode_First(chainCode,
				regionCode, orderByComparator);

		if (standardsDisplayOrder != null) {
			return standardsDisplayOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", regionCode=");
		msg.append(regionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsDisplayOrderException(msg.toString());
	}

	/**
	 * Returns the first standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards display order, or <code>null</code> if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder fetchByChainCodeRegionCode_First(
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsDisplayOrder> list = findByChainCodeRegionCode(chainCode,
				regionCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards display order
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder findByChainCodeRegionCode_Last(
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		StandardsDisplayOrder standardsDisplayOrder = fetchByChainCodeRegionCode_Last(chainCode,
				regionCode, orderByComparator);

		if (standardsDisplayOrder != null) {
			return standardsDisplayOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", regionCode=");
		msg.append(regionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsDisplayOrderException(msg.toString());
	}

	/**
	 * Returns the last standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards display order, or <code>null</code> if a matching standards display order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder fetchByChainCodeRegionCode_Last(
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByChainCodeRegionCode(chainCode, regionCode);

		if (count == 0) {
			return null;
		}

		List<StandardsDisplayOrder> list = findByChainCodeRegionCode(chainCode,
				regionCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards display orders before and after the current standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param standardsDisplayOrderPK the primary key of the current standards display order
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards display order
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder[] findByChainCodeRegionCode_PrevAndNext(
		StandardsDisplayOrderPK standardsDisplayOrderPK, String chainCode,
		String regionCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		StandardsDisplayOrder standardsDisplayOrder = findByPrimaryKey(standardsDisplayOrderPK);

		Session session = null;

		try {
			session = openSession();

			StandardsDisplayOrder[] array = new StandardsDisplayOrderImpl[3];

			array[0] = getByChainCodeRegionCode_PrevAndNext(session,
					standardsDisplayOrder, chainCode, regionCode,
					orderByComparator, true);

			array[1] = standardsDisplayOrder;

			array[2] = getByChainCodeRegionCode_PrevAndNext(session,
					standardsDisplayOrder, chainCode, regionCode,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsDisplayOrder getByChainCodeRegionCode_PrevAndNext(
		Session session, StandardsDisplayOrder standardsDisplayOrder,
		String chainCode, String regionCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSDISPLAYORDER_WHERE);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_2);
		}

		boolean bindRegionCode = false;

		if (regionCode == null) {
			query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_1);
		}
		else if (regionCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_3);
		}
		else {
			bindRegionCode = true;

			query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_2);
		}

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
			query.append(StandardsDisplayOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindRegionCode) {
			qPos.add(regionCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsDisplayOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsDisplayOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards display orders where chainCode = &#63; and regionCode = &#63; from the database.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByChainCodeRegionCode(String chainCode, String regionCode)
		throws SystemException {
		for (StandardsDisplayOrder standardsDisplayOrder : findByChainCodeRegionCode(
				chainCode, regionCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(standardsDisplayOrder);
		}
	}

	/**
	 * Returns the number of standards display orders where chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the number of matching standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChainCodeRegionCode(String chainCode, String regionCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHAINCODEREGIONCODE;

		Object[] finderArgs = new Object[] { chainCode, regionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSDISPLAYORDER_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_2);
			}

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

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

	private static final String _FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_1 = "standardsDisplayOrder.id.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_2 = "standardsDisplayOrder.id.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_CHAINCODEREGIONCODE_CHAINCODE_3 = "(standardsDisplayOrder.id.chainCode IS NULL OR standardsDisplayOrder.id.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_1 = "standardsDisplayOrder.id.regionCode IS NULL";
	private static final String _FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_2 = "standardsDisplayOrder.id.regionCode = ?";
	private static final String _FINDER_COLUMN_CHAINCODEREGIONCODE_REGIONCODE_3 = "(standardsDisplayOrder.id.regionCode IS NULL OR standardsDisplayOrder.id.regionCode = '')";

	public StandardsDisplayOrderPersistenceImpl() {
		setModelClass(StandardsDisplayOrder.class);
	}

	/**
	 * Caches the standards display order in the entity cache if it is enabled.
	 *
	 * @param standardsDisplayOrder the standards display order
	 */
	@Override
	public void cacheResult(StandardsDisplayOrder standardsDisplayOrder) {
		EntityCacheUtil.putResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			standardsDisplayOrder.getPrimaryKey(), standardsDisplayOrder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
			new Object[] {
				standardsDisplayOrder.getStdId(),
				standardsDisplayOrder.getChainCode(),
				standardsDisplayOrder.getRegionCode()
			}, standardsDisplayOrder);

		standardsDisplayOrder.resetOriginalValues();
	}

	/**
	 * Caches the standards display orders in the entity cache if it is enabled.
	 *
	 * @param standardsDisplayOrders the standards display orders
	 */
	@Override
	public void cacheResult(List<StandardsDisplayOrder> standardsDisplayOrders) {
		for (StandardsDisplayOrder standardsDisplayOrder : standardsDisplayOrders) {
			if (EntityCacheUtil.getResult(
						StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
						StandardsDisplayOrderImpl.class,
						standardsDisplayOrder.getPrimaryKey()) == null) {
				cacheResult(standardsDisplayOrder);
			}
			else {
				standardsDisplayOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards display orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsDisplayOrderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsDisplayOrderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards display order.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsDisplayOrder standardsDisplayOrder) {
		EntityCacheUtil.removeResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			standardsDisplayOrder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsDisplayOrder);
	}

	@Override
	public void clearCache(List<StandardsDisplayOrder> standardsDisplayOrders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsDisplayOrder standardsDisplayOrder : standardsDisplayOrders) {
			EntityCacheUtil.removeResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
				StandardsDisplayOrderImpl.class,
				standardsDisplayOrder.getPrimaryKey());

			clearUniqueFindersCache(standardsDisplayOrder);
		}
	}

	protected void cacheUniqueFindersCache(
		StandardsDisplayOrder standardsDisplayOrder) {
		if (standardsDisplayOrder.isNew()) {
			Object[] args = new Object[] {
					standardsDisplayOrder.getStdId(),
					standardsDisplayOrder.getChainCode(),
					standardsDisplayOrder.getRegionCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDCHAINIDREGIONCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
				args, standardsDisplayOrder);
		}
		else {
			StandardsDisplayOrderModelImpl standardsDisplayOrderModelImpl = (StandardsDisplayOrderModelImpl)standardsDisplayOrder;

			if ((standardsDisplayOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsDisplayOrder.getStdId(),
						standardsDisplayOrder.getChainCode(),
						standardsDisplayOrder.getRegionCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDCHAINIDREGIONCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
					args, standardsDisplayOrder);
			}
		}
	}

	protected void clearUniqueFindersCache(
		StandardsDisplayOrder standardsDisplayOrder) {
		StandardsDisplayOrderModelImpl standardsDisplayOrderModelImpl = (StandardsDisplayOrderModelImpl)standardsDisplayOrder;

		Object[] args = new Object[] {
				standardsDisplayOrder.getStdId(),
				standardsDisplayOrder.getChainCode(),
				standardsDisplayOrder.getRegionCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHAINIDREGIONCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
			args);

		if ((standardsDisplayOrderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					standardsDisplayOrderModelImpl.getOriginalStdId(),
					standardsDisplayOrderModelImpl.getOriginalChainCode(),
					standardsDisplayOrderModelImpl.getOriginalRegionCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHAINIDREGIONCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDCHAINIDREGIONCODE,
				args);
		}
	}

	/**
	 * Creates a new standards display order with the primary key. Does not add the standards display order to the database.
	 *
	 * @param standardsDisplayOrderPK the primary key for the new standards display order
	 * @return the new standards display order
	 */
	@Override
	public StandardsDisplayOrder create(
		StandardsDisplayOrderPK standardsDisplayOrderPK) {
		StandardsDisplayOrder standardsDisplayOrder = new StandardsDisplayOrderImpl();

		standardsDisplayOrder.setNew(true);
		standardsDisplayOrder.setPrimaryKey(standardsDisplayOrderPK);

		return standardsDisplayOrder;
	}

	/**
	 * Removes the standards display order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsDisplayOrderPK the primary key of the standards display order
	 * @return the standards display order that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder remove(
		StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		return remove((Serializable)standardsDisplayOrderPK);
	}

	/**
	 * Removes the standards display order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards display order
	 * @return the standards display order that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder remove(Serializable primaryKey)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsDisplayOrder standardsDisplayOrder = (StandardsDisplayOrder)session.get(StandardsDisplayOrderImpl.class,
					primaryKey);

			if (standardsDisplayOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsDisplayOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsDisplayOrder);
		}
		catch (NoSuchStandardsDisplayOrderException nsee) {
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
	protected StandardsDisplayOrder removeImpl(
		StandardsDisplayOrder standardsDisplayOrder) throws SystemException {
		standardsDisplayOrder = toUnwrappedModel(standardsDisplayOrder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsDisplayOrder)) {
				standardsDisplayOrder = (StandardsDisplayOrder)session.get(StandardsDisplayOrderImpl.class,
						standardsDisplayOrder.getPrimaryKeyObj());
			}

			if (standardsDisplayOrder != null) {
				session.delete(standardsDisplayOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsDisplayOrder != null) {
			clearCache(standardsDisplayOrder);
		}

		return standardsDisplayOrder;
	}

	@Override
	public StandardsDisplayOrder updateImpl(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder)
		throws SystemException {
		standardsDisplayOrder = toUnwrappedModel(standardsDisplayOrder);

		boolean isNew = standardsDisplayOrder.isNew();

		StandardsDisplayOrderModelImpl standardsDisplayOrderModelImpl = (StandardsDisplayOrderModelImpl)standardsDisplayOrder;

		Session session = null;

		try {
			session = openSession();

			if (standardsDisplayOrder.isNew()) {
				session.save(standardsDisplayOrder);

				standardsDisplayOrder.setNew(false);
			}
			else {
				session.merge(standardsDisplayOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsDisplayOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsDisplayOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEREGIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsDisplayOrderModelImpl.getOriginalChainCode(),
						standardsDisplayOrderModelImpl.getOriginalRegionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODEREGIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEREGIONCODE,
					args);

				args = new Object[] {
						standardsDisplayOrderModelImpl.getChainCode(),
						standardsDisplayOrderModelImpl.getRegionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODEREGIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEREGIONCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
			StandardsDisplayOrderImpl.class,
			standardsDisplayOrder.getPrimaryKey(), standardsDisplayOrder);

		clearUniqueFindersCache(standardsDisplayOrder);
		cacheUniqueFindersCache(standardsDisplayOrder);

		return standardsDisplayOrder;
	}

	protected StandardsDisplayOrder toUnwrappedModel(
		StandardsDisplayOrder standardsDisplayOrder) {
		if (standardsDisplayOrder instanceof StandardsDisplayOrderImpl) {
			return standardsDisplayOrder;
		}

		StandardsDisplayOrderImpl standardsDisplayOrderImpl = new StandardsDisplayOrderImpl();

		standardsDisplayOrderImpl.setNew(standardsDisplayOrder.isNew());
		standardsDisplayOrderImpl.setPrimaryKey(standardsDisplayOrder.getPrimaryKey());

		standardsDisplayOrderImpl.setStdId(standardsDisplayOrder.getStdId());
		standardsDisplayOrderImpl.setRegionCode(standardsDisplayOrder.getRegionCode());
		standardsDisplayOrderImpl.setChainCode(standardsDisplayOrder.getChainCode());
		standardsDisplayOrderImpl.setDisplayOrder(standardsDisplayOrder.getDisplayOrder());
		standardsDisplayOrderImpl.setCreatorId(standardsDisplayOrder.getCreatorId());
		standardsDisplayOrderImpl.setCreatedDate(standardsDisplayOrder.getCreatedDate());
		standardsDisplayOrderImpl.setUpdatedBy(standardsDisplayOrder.getUpdatedBy());
		standardsDisplayOrderImpl.setUpdatedDate(standardsDisplayOrder.getUpdatedDate());

		return standardsDisplayOrderImpl;
	}

	/**
	 * Returns the standards display order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards display order
	 * @return the standards display order
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		StandardsDisplayOrder standardsDisplayOrder = fetchByPrimaryKey(primaryKey);

		if (standardsDisplayOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsDisplayOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsDisplayOrder;
	}

	/**
	 * Returns the standards display order with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException} if it could not be found.
	 *
	 * @param standardsDisplayOrderPK the primary key of the standards display order
	 * @return the standards display order
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder findByPrimaryKey(
		StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws NoSuchStandardsDisplayOrderException, SystemException {
		return findByPrimaryKey((Serializable)standardsDisplayOrderPK);
	}

	/**
	 * Returns the standards display order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards display order
	 * @return the standards display order, or <code>null</code> if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsDisplayOrder standardsDisplayOrder = (StandardsDisplayOrder)EntityCacheUtil.getResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
				StandardsDisplayOrderImpl.class, primaryKey);

		if (standardsDisplayOrder == _nullStandardsDisplayOrder) {
			return null;
		}

		if (standardsDisplayOrder == null) {
			Session session = null;

			try {
				session = openSession();

				standardsDisplayOrder = (StandardsDisplayOrder)session.get(StandardsDisplayOrderImpl.class,
						primaryKey);

				if (standardsDisplayOrder != null) {
					cacheResult(standardsDisplayOrder);
				}
				else {
					EntityCacheUtil.putResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
						StandardsDisplayOrderImpl.class, primaryKey,
						_nullStandardsDisplayOrder);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsDisplayOrderModelImpl.ENTITY_CACHE_ENABLED,
					StandardsDisplayOrderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsDisplayOrder;
	}

	/**
	 * Returns the standards display order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsDisplayOrderPK the primary key of the standards display order
	 * @return the standards display order, or <code>null</code> if a standards display order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsDisplayOrder fetchByPrimaryKey(
		StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsDisplayOrderPK);
	}

	/**
	 * Returns all the standards display orders.
	 *
	 * @return the standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards display orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards display orders
	 * @param end the upper bound of the range of standards display orders (not inclusive)
	 * @return the range of standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards display orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards display orders
	 * @param end the upper bound of the range of standards display orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards display orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsDisplayOrder> findAll(int start, int end,
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

		List<StandardsDisplayOrder> list = (List<StandardsDisplayOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSDISPLAYORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSDISPLAYORDER;

				if (pagination) {
					sql = sql.concat(StandardsDisplayOrderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsDisplayOrder>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsDisplayOrder>(list);
				}
				else {
					list = (List<StandardsDisplayOrder>)QueryUtil.list(q,
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
	 * Removes all the standards display orders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsDisplayOrder standardsDisplayOrder : findAll()) {
			remove(standardsDisplayOrder);
		}
	}

	/**
	 * Returns the number of standards display orders.
	 *
	 * @return the number of standards display orders
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSDISPLAYORDER);

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
	 * Initializes the standards display order persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsDisplayOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsDisplayOrder>> listenersList = new ArrayList<ModelListener<StandardsDisplayOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsDisplayOrder>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsDisplayOrderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSDISPLAYORDER = "SELECT standardsDisplayOrder FROM StandardsDisplayOrder standardsDisplayOrder";
	private static final String _SQL_SELECT_STANDARDSDISPLAYORDER_WHERE = "SELECT standardsDisplayOrder FROM StandardsDisplayOrder standardsDisplayOrder WHERE ";
	private static final String _SQL_COUNT_STANDARDSDISPLAYORDER = "SELECT COUNT(standardsDisplayOrder) FROM StandardsDisplayOrder standardsDisplayOrder";
	private static final String _SQL_COUNT_STANDARDSDISPLAYORDER_WHERE = "SELECT COUNT(standardsDisplayOrder) FROM StandardsDisplayOrder standardsDisplayOrder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsDisplayOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsDisplayOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsDisplayOrder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsDisplayOrderPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "regionCode", "chainCode", "displayOrder", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static StandardsDisplayOrder _nullStandardsDisplayOrder = new StandardsDisplayOrderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsDisplayOrder> toCacheModel() {
				return _nullStandardsDisplayOrderCacheModel;
			}
		};

	private static CacheModel<StandardsDisplayOrder> _nullStandardsDisplayOrderCacheModel =
		new CacheModel<StandardsDisplayOrder>() {
			@Override
			public StandardsDisplayOrder toEntityModel() {
				return _nullStandardsDisplayOrder;
			}
		};
}