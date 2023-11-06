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

import com.ihg.brandstandards.db.NoSuchStandardsRegionChainException;
import com.ihg.brandstandards.db.model.StandardsRegionChain;
import com.ihg.brandstandards.db.model.impl.StandardsRegionChainImpl;
import com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl;

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
 * The persistence implementation for the standards region chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionChainPersistence
 * @see StandardsRegionChainUtil
 * @generated
 */
public class StandardsRegionChainPersistenceImpl extends BasePersistenceImpl<StandardsRegionChain>
	implements StandardsRegionChainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsRegionChainUtil} to access the standards region chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsRegionChainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDCHNCD =
		new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystdIdChnCd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHNCD =
		new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystdIdChnCd",
			new String[] { Long.class.getName(), String.class.getName() },
			StandardsRegionChainModelImpl.STDID_COLUMN_BITMASK |
			StandardsRegionChainModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDCHNCD = new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdIdChnCd",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards region chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the matching standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionChain> findBystdIdChnCd(long stdId,
		String chainCode) throws SystemException {
		return findBystdIdChnCd(stdId, chainCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards region chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of standards region chains
	 * @param end the upper bound of the range of standards region chains (not inclusive)
	 * @return the range of matching standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionChain> findBystdIdChnCd(long stdId,
		String chainCode, int start, int end) throws SystemException {
		return findBystdIdChnCd(stdId, chainCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards region chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of standards region chains
	 * @param end the upper bound of the range of standards region chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionChain> findBystdIdChnCd(long stdId,
		String chainCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHNCD;
			finderArgs = new Object[] { stdId, chainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDCHNCD;
			finderArgs = new Object[] {
					stdId, chainCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsRegionChain> list = (List<StandardsRegionChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsRegionChain standardsRegionChain : list) {
				if ((stdId != standardsRegionChain.getStdId()) ||
						!Validator.equals(chainCode,
							standardsRegionChain.getChainCode())) {
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

			query.append(_SQL_SELECT_STANDARDSREGIONCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHNCD_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsRegionChainModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<StandardsRegionChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsRegionChain>(list);
				}
				else {
					list = (List<StandardsRegionChain>)QueryUtil.list(q,
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
	 * Returns the first standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards region chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain findBystdIdChnCd_First(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsRegionChainException, SystemException {
		StandardsRegionChain standardsRegionChain = fetchBystdIdChnCd_First(stdId,
				chainCode, orderByComparator);

		if (standardsRegionChain != null) {
			return standardsRegionChain;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsRegionChainException(msg.toString());
	}

	/**
	 * Returns the first standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain fetchBystdIdChnCd_First(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsRegionChain> list = findBystdIdChnCd(stdId, chainCode, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards region chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain findBystdIdChnCd_Last(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsRegionChainException, SystemException {
		StandardsRegionChain standardsRegionChain = fetchBystdIdChnCd_Last(stdId,
				chainCode, orderByComparator);

		if (standardsRegionChain != null) {
			return standardsRegionChain;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsRegionChainException(msg.toString());
	}

	/**
	 * Returns the last standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain fetchBystdIdChnCd_Last(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBystdIdChnCd(stdId, chainCode);

		if (count == 0) {
			return null;
		}

		List<StandardsRegionChain> list = findBystdIdChnCd(stdId, chainCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards region chains before and after the current standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param standardsRegionChainPK the primary key of the current standards region chain
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards region chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain[] findBystdIdChnCd_PrevAndNext(
		StandardsRegionChainPK standardsRegionChainPK, long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsRegionChainException, SystemException {
		StandardsRegionChain standardsRegionChain = findByPrimaryKey(standardsRegionChainPK);

		Session session = null;

		try {
			session = openSession();

			StandardsRegionChain[] array = new StandardsRegionChainImpl[3];

			array[0] = getBystdIdChnCd_PrevAndNext(session,
					standardsRegionChain, stdId, chainCode, orderByComparator,
					true);

			array[1] = standardsRegionChain;

			array[2] = getBystdIdChnCd_PrevAndNext(session,
					standardsRegionChain, stdId, chainCode, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsRegionChain getBystdIdChnCd_PrevAndNext(
		Session session, StandardsRegionChain standardsRegionChain, long stdId,
		String chainCode, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSREGIONCHAIN_WHERE);

		query.append(_FINDER_COLUMN_STDIDCHNCD_STDID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_2);
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
			query.append(StandardsRegionChainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsRegionChain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsRegionChain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards region chains where stdId = &#63; and chainCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdIdChnCd(long stdId, String chainCode)
		throws SystemException {
		for (StandardsRegionChain standardsRegionChain : findBystdIdChnCd(
				stdId, chainCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsRegionChain);
		}
	}

	/**
	 * Returns the number of standards region chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the number of matching standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdIdChnCd(long stdId, String chainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDCHNCD;

		Object[] finderArgs = new Object[] { stdId, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSREGIONCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHNCD_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHNCD_CHAINCODE_2);
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

	private static final String _FINDER_COLUMN_STDIDCHNCD_STDID_2 = "standardsRegionChain.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDCHNCD_CHAINCODE_1 = "standardsRegionChain.id.chainCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDCHNCD_CHAINCODE_2 = "standardsRegionChain.id.chainCode = ?";
	private static final String _FINDER_COLUMN_STDIDCHNCD_CHAINCODE_3 = "(standardsRegionChain.id.chainCode IS NULL OR standardsRegionChain.id.chainCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD = new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionChainImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBystdIdRgnCdChnCd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			StandardsRegionChainModelImpl.STDID_COLUMN_BITMASK |
			StandardsRegionChainModelImpl.REGIONCODE_COLUMN_BITMASK |
			StandardsRegionChainModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDRGNCDCHNCD = new FinderPath(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBystdIdRgnCdChnCd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionChainException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param regionCode the region code
	 * @param chainCode the chain code
	 * @return the matching standards region chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain findBystdIdRgnCdChnCd(long stdId,
		String regionCode, String chainCode)
		throws NoSuchStandardsRegionChainException, SystemException {
		StandardsRegionChain standardsRegionChain = fetchBystdIdRgnCdChnCd(stdId,
				regionCode, chainCode);

		if (standardsRegionChain == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", regionCode=");
			msg.append(regionCode);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsRegionChainException(msg.toString());
		}

		return standardsRegionChain;
	}

	/**
	 * Returns the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param regionCode the region code
	 * @param chainCode the chain code
	 * @return the matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain fetchBystdIdRgnCdChnCd(long stdId,
		String regionCode, String chainCode) throws SystemException {
		return fetchBystdIdRgnCdChnCd(stdId, regionCode, chainCode, true);
	}

	/**
	 * Returns the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param regionCode the region code
	 * @param chainCode the chain code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain fetchBystdIdRgnCdChnCd(long stdId,
		String regionCode, String chainCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId, regionCode, chainCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
					finderArgs, this);
		}

		if (result instanceof StandardsRegionChain) {
			StandardsRegionChain standardsRegionChain = (StandardsRegionChain)result;

			if ((stdId != standardsRegionChain.getStdId()) ||
					!Validator.equals(regionCode,
						standardsRegionChain.getRegionCode()) ||
					!Validator.equals(chainCode,
						standardsRegionChain.getChainCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STANDARDSREGIONCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_STDID_2);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				List<StandardsRegionChain> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsRegionChainPersistenceImpl.fetchBystdIdRgnCdChnCd(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsRegionChain standardsRegionChain = list.get(0);

					result = standardsRegionChain;

					cacheResult(standardsRegionChain);

					if ((standardsRegionChain.getStdId() != stdId) ||
							(standardsRegionChain.getRegionCode() == null) ||
							!standardsRegionChain.getRegionCode()
													 .equals(regionCode) ||
							(standardsRegionChain.getChainCode() == null) ||
							!standardsRegionChain.getChainCode()
													 .equals(chainCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
							finderArgs, standardsRegionChain);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
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
			return (StandardsRegionChain)result;
		}
	}

	/**
	 * Removes the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param regionCode the region code
	 * @param chainCode the chain code
	 * @return the standards region chain that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain removeBystdIdRgnCdChnCd(long stdId,
		String regionCode, String chainCode)
		throws NoSuchStandardsRegionChainException, SystemException {
		StandardsRegionChain standardsRegionChain = findBystdIdRgnCdChnCd(stdId,
				regionCode, chainCode);

		return remove(standardsRegionChain);
	}

	/**
	 * Returns the number of standards region chains where stdId = &#63; and regionCode = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param regionCode the region code
	 * @param chainCode the chain code
	 * @return the number of matching standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdIdRgnCdChnCd(long stdId, String regionCode,
		String chainCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDRGNCDCHNCD;

		Object[] finderArgs = new Object[] { stdId, regionCode, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSREGIONCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_STDID_2);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindRegionCode) {
					qPos.add(regionCode);
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

	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_STDID_2 = "standardsRegionChain.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_1 = "standardsRegionChain.id.regionCode IS NULL AND ";
	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_2 = "standardsRegionChain.id.regionCode = ? AND ";
	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_REGIONCODE_3 = "(standardsRegionChain.id.regionCode IS NULL OR standardsRegionChain.id.regionCode = '') AND ";
	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_1 = "standardsRegionChain.id.chainCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_2 = "standardsRegionChain.id.chainCode = ?";
	private static final String _FINDER_COLUMN_STDIDRGNCDCHNCD_CHAINCODE_3 = "(standardsRegionChain.id.chainCode IS NULL OR standardsRegionChain.id.chainCode = '')";

	public StandardsRegionChainPersistenceImpl() {
		setModelClass(StandardsRegionChain.class);
	}

	/**
	 * Caches the standards region chain in the entity cache if it is enabled.
	 *
	 * @param standardsRegionChain the standards region chain
	 */
	@Override
	public void cacheResult(StandardsRegionChain standardsRegionChain) {
		EntityCacheUtil.putResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainImpl.class,
			standardsRegionChain.getPrimaryKey(), standardsRegionChain);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
			new Object[] {
				standardsRegionChain.getStdId(),
				standardsRegionChain.getRegionCode(),
				standardsRegionChain.getChainCode()
			}, standardsRegionChain);

		standardsRegionChain.resetOriginalValues();
	}

	/**
	 * Caches the standards region chains in the entity cache if it is enabled.
	 *
	 * @param standardsRegionChains the standards region chains
	 */
	@Override
	public void cacheResult(List<StandardsRegionChain> standardsRegionChains) {
		for (StandardsRegionChain standardsRegionChain : standardsRegionChains) {
			if (EntityCacheUtil.getResult(
						StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
						StandardsRegionChainImpl.class,
						standardsRegionChain.getPrimaryKey()) == null) {
				cacheResult(standardsRegionChain);
			}
			else {
				standardsRegionChain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards region chains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsRegionChainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsRegionChainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards region chain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsRegionChain standardsRegionChain) {
		EntityCacheUtil.removeResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainImpl.class, standardsRegionChain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsRegionChain);
	}

	@Override
	public void clearCache(List<StandardsRegionChain> standardsRegionChains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsRegionChain standardsRegionChain : standardsRegionChains) {
			EntityCacheUtil.removeResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
				StandardsRegionChainImpl.class,
				standardsRegionChain.getPrimaryKey());

			clearUniqueFindersCache(standardsRegionChain);
		}
	}

	protected void cacheUniqueFindersCache(
		StandardsRegionChain standardsRegionChain) {
		if (standardsRegionChain.isNew()) {
			Object[] args = new Object[] {
					standardsRegionChain.getStdId(),
					standardsRegionChain.getRegionCode(),
					standardsRegionChain.getChainCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDRGNCDCHNCD,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
				args, standardsRegionChain);
		}
		else {
			StandardsRegionChainModelImpl standardsRegionChainModelImpl = (StandardsRegionChainModelImpl)standardsRegionChain;

			if ((standardsRegionChainModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsRegionChain.getStdId(),
						standardsRegionChain.getRegionCode(),
						standardsRegionChain.getChainCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDRGNCDCHNCD,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
					args, standardsRegionChain);
			}
		}
	}

	protected void clearUniqueFindersCache(
		StandardsRegionChain standardsRegionChain) {
		StandardsRegionChainModelImpl standardsRegionChainModelImpl = (StandardsRegionChainModelImpl)standardsRegionChain;

		Object[] args = new Object[] {
				standardsRegionChain.getStdId(),
				standardsRegionChain.getRegionCode(),
				standardsRegionChain.getChainCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDRGNCDCHNCD, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD, args);

		if ((standardsRegionChainModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD.getColumnBitmask()) != 0) {
			args = new Object[] {
					standardsRegionChainModelImpl.getOriginalStdId(),
					standardsRegionChainModelImpl.getOriginalRegionCode(),
					standardsRegionChainModelImpl.getOriginalChainCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDRGNCDCHNCD,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDRGNCDCHNCD,
				args);
		}
	}

	/**
	 * Creates a new standards region chain with the primary key. Does not add the standards region chain to the database.
	 *
	 * @param standardsRegionChainPK the primary key for the new standards region chain
	 * @return the new standards region chain
	 */
	@Override
	public StandardsRegionChain create(
		StandardsRegionChainPK standardsRegionChainPK) {
		StandardsRegionChain standardsRegionChain = new StandardsRegionChainImpl();

		standardsRegionChain.setNew(true);
		standardsRegionChain.setPrimaryKey(standardsRegionChainPK);

		return standardsRegionChain;
	}

	/**
	 * Removes the standards region chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsRegionChainPK the primary key of the standards region chain
	 * @return the standards region chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain remove(
		StandardsRegionChainPK standardsRegionChainPK)
		throws NoSuchStandardsRegionChainException, SystemException {
		return remove((Serializable)standardsRegionChainPK);
	}

	/**
	 * Removes the standards region chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards region chain
	 * @return the standards region chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain remove(Serializable primaryKey)
		throws NoSuchStandardsRegionChainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsRegionChain standardsRegionChain = (StandardsRegionChain)session.get(StandardsRegionChainImpl.class,
					primaryKey);

			if (standardsRegionChain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsRegionChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsRegionChain);
		}
		catch (NoSuchStandardsRegionChainException nsee) {
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
	protected StandardsRegionChain removeImpl(
		StandardsRegionChain standardsRegionChain) throws SystemException {
		standardsRegionChain = toUnwrappedModel(standardsRegionChain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsRegionChain)) {
				standardsRegionChain = (StandardsRegionChain)session.get(StandardsRegionChainImpl.class,
						standardsRegionChain.getPrimaryKeyObj());
			}

			if (standardsRegionChain != null) {
				session.delete(standardsRegionChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsRegionChain != null) {
			clearCache(standardsRegionChain);
		}

		return standardsRegionChain;
	}

	@Override
	public StandardsRegionChain updateImpl(
		com.ihg.brandstandards.db.model.StandardsRegionChain standardsRegionChain)
		throws SystemException {
		standardsRegionChain = toUnwrappedModel(standardsRegionChain);

		boolean isNew = standardsRegionChain.isNew();

		StandardsRegionChainModelImpl standardsRegionChainModelImpl = (StandardsRegionChainModelImpl)standardsRegionChain;

		Session session = null;

		try {
			session = openSession();

			if (standardsRegionChain.isNew()) {
				session.save(standardsRegionChain);

				standardsRegionChain.setNew(false);
			}
			else {
				session.merge(standardsRegionChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsRegionChainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsRegionChainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHNCD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsRegionChainModelImpl.getOriginalStdId(),
						standardsRegionChainModelImpl.getOriginalChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHNCD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHNCD,
					args);

				args = new Object[] {
						standardsRegionChainModelImpl.getStdId(),
						standardsRegionChainModelImpl.getChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHNCD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHNCD,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionChainImpl.class,
			standardsRegionChain.getPrimaryKey(), standardsRegionChain);

		clearUniqueFindersCache(standardsRegionChain);
		cacheUniqueFindersCache(standardsRegionChain);

		return standardsRegionChain;
	}

	protected StandardsRegionChain toUnwrappedModel(
		StandardsRegionChain standardsRegionChain) {
		if (standardsRegionChain instanceof StandardsRegionChainImpl) {
			return standardsRegionChain;
		}

		StandardsRegionChainImpl standardsRegionChainImpl = new StandardsRegionChainImpl();

		standardsRegionChainImpl.setNew(standardsRegionChain.isNew());
		standardsRegionChainImpl.setPrimaryKey(standardsRegionChain.getPrimaryKey());

		standardsRegionChainImpl.setStdId(standardsRegionChain.getStdId());
		standardsRegionChainImpl.setRegionCode(standardsRegionChain.getRegionCode());
		standardsRegionChainImpl.setChainCode(standardsRegionChain.getChainCode());
		standardsRegionChainImpl.setCompDate(standardsRegionChain.getCompDate());
		standardsRegionChainImpl.setExpiredIds(standardsRegionChain.getExpiredIds());
		standardsRegionChainImpl.setComplianceRule(standardsRegionChain.getComplianceRule());
		standardsRegionChainImpl.setCreatorId(standardsRegionChain.getCreatorId());
		standardsRegionChainImpl.setCreatedDate(standardsRegionChain.getCreatedDate());
		standardsRegionChainImpl.setUpdatedBy(standardsRegionChain.getUpdatedBy());
		standardsRegionChainImpl.setUpdatedDate(standardsRegionChain.getUpdatedDate());

		return standardsRegionChainImpl;
	}

	/**
	 * Returns the standards region chain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards region chain
	 * @return the standards region chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsRegionChainException, SystemException {
		StandardsRegionChain standardsRegionChain = fetchByPrimaryKey(primaryKey);

		if (standardsRegionChain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsRegionChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsRegionChain;
	}

	/**
	 * Returns the standards region chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionChainException} if it could not be found.
	 *
	 * @param standardsRegionChainPK the primary key of the standards region chain
	 * @return the standards region chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain findByPrimaryKey(
		StandardsRegionChainPK standardsRegionChainPK)
		throws NoSuchStandardsRegionChainException, SystemException {
		return findByPrimaryKey((Serializable)standardsRegionChainPK);
	}

	/**
	 * Returns the standards region chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards region chain
	 * @return the standards region chain, or <code>null</code> if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsRegionChain standardsRegionChain = (StandardsRegionChain)EntityCacheUtil.getResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
				StandardsRegionChainImpl.class, primaryKey);

		if (standardsRegionChain == _nullStandardsRegionChain) {
			return null;
		}

		if (standardsRegionChain == null) {
			Session session = null;

			try {
				session = openSession();

				standardsRegionChain = (StandardsRegionChain)session.get(StandardsRegionChainImpl.class,
						primaryKey);

				if (standardsRegionChain != null) {
					cacheResult(standardsRegionChain);
				}
				else {
					EntityCacheUtil.putResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
						StandardsRegionChainImpl.class, primaryKey,
						_nullStandardsRegionChain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsRegionChainModelImpl.ENTITY_CACHE_ENABLED,
					StandardsRegionChainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsRegionChain;
	}

	/**
	 * Returns the standards region chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsRegionChainPK the primary key of the standards region chain
	 * @return the standards region chain, or <code>null</code> if a standards region chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionChain fetchByPrimaryKey(
		StandardsRegionChainPK standardsRegionChainPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsRegionChainPK);
	}

	/**
	 * Returns all the standards region chains.
	 *
	 * @return the standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionChain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards region chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards region chains
	 * @param end the upper bound of the range of standards region chains (not inclusive)
	 * @return the range of standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionChain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards region chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards region chains
	 * @param end the upper bound of the range of standards region chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards region chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionChain> findAll(int start, int end,
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

		List<StandardsRegionChain> list = (List<StandardsRegionChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSREGIONCHAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSREGIONCHAIN;

				if (pagination) {
					sql = sql.concat(StandardsRegionChainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsRegionChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsRegionChain>(list);
				}
				else {
					list = (List<StandardsRegionChain>)QueryUtil.list(q,
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
	 * Removes all the standards region chains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsRegionChain standardsRegionChain : findAll()) {
			remove(standardsRegionChain);
		}
	}

	/**
	 * Returns the number of standards region chains.
	 *
	 * @return the number of standards region chains
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSREGIONCHAIN);

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
	 * Initializes the standards region chain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsRegionChain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsRegionChain>> listenersList = new ArrayList<ModelListener<StandardsRegionChain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsRegionChain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsRegionChainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSREGIONCHAIN = "SELECT standardsRegionChain FROM StandardsRegionChain standardsRegionChain";
	private static final String _SQL_SELECT_STANDARDSREGIONCHAIN_WHERE = "SELECT standardsRegionChain FROM StandardsRegionChain standardsRegionChain WHERE ";
	private static final String _SQL_COUNT_STANDARDSREGIONCHAIN = "SELECT COUNT(standardsRegionChain) FROM StandardsRegionChain standardsRegionChain";
	private static final String _SQL_COUNT_STANDARDSREGIONCHAIN_WHERE = "SELECT COUNT(standardsRegionChain) FROM StandardsRegionChain standardsRegionChain WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsRegionChain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsRegionChain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsRegionChain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsRegionChainPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "regionCode", "chainCode", "compDate", "expiredIds",
				"complianceRule", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static StandardsRegionChain _nullStandardsRegionChain = new StandardsRegionChainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsRegionChain> toCacheModel() {
				return _nullStandardsRegionChainCacheModel;
			}
		};

	private static CacheModel<StandardsRegionChain> _nullStandardsRegionChainCacheModel =
		new CacheModel<StandardsRegionChain>() {
			@Override
			public StandardsRegionChain toEntityModel() {
				return _nullStandardsRegionChain;
			}
		};
}