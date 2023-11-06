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

import com.ihg.brandstandards.db.NoSuchStandardsCountryChainException;
import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.model.impl.StandardsCountryChainImpl;
import com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the standards country chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryChainPersistence
 * @see StandardsCountryChainUtil
 * @generated
 */
public class StandardsCountryChainPersistenceImpl extends BasePersistenceImpl<StandardsCountryChain>
	implements StandardsCountryChainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsCountryChainUtil} to access the standards country chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsCountryChainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDDATECHCODE =
		new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystdIdDateChCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDATECHCODE =
		new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystdIdDateChCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName()
			},
			StandardsCountryChainModelImpl.STDID_COLUMN_BITMASK |
			StandardsCountryChainModelImpl.CHAINCODE_COLUMN_BITMASK |
			StandardsCountryChainModelImpl.COMPDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDDATECHCODE = new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBystdIdDateChCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Date.class.getName()
			});

	/**
	 * Returns all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @return the matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findBystdIdDateChCode(long stdId,
		String chainCode, Date compDate) throws SystemException {
		return findBystdIdDateChCode(stdId, chainCode, compDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @return the range of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findBystdIdDateChCode(long stdId,
		String chainCode, Date compDate, int start, int end)
		throws SystemException {
		return findBystdIdDateChCode(stdId, chainCode, compDate, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findBystdIdDateChCode(long stdId,
		String chainCode, Date compDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDATECHCODE;
			finderArgs = new Object[] { stdId, chainCode, compDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDDATECHCODE;
			finderArgs = new Object[] {
					stdId, chainCode, compDate,
					
					start, end, orderByComparator
				};
		}

		List<StandardsCountryChain> list = (List<StandardsCountryChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCountryChain standardsCountryChain : list) {
				if ((stdId != standardsCountryChain.getStdId()) ||
						!Validator.equals(chainCode,
							standardsCountryChain.getChainCode()) ||
						!Validator.equals(compDate,
							standardsCountryChain.getCompDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDDATECHCODE_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_2);
			}

			boolean bindCompDate = false;

			if (compDate == null) {
				query.append(_FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_1);
			}
			else {
				bindCompDate = true;

				query.append(_FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
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

				if (bindCompDate) {
					qPos.add(CalendarUtil.getTimestamp(compDate));
				}

				if (!pagination) {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryChain>(list);
				}
				else {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
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
	 * Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findBystdIdDateChCode_First(long stdId,
		String chainCode, Date compDate, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchBystdIdDateChCode_First(stdId,
				chainCode, compDate, orderByComparator);

		if (standardsCountryChain != null) {
			return standardsCountryChain;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", compDate=");
		msg.append(compDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryChainException(msg.toString());
	}

	/**
	 * Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchBystdIdDateChCode_First(long stdId,
		String chainCode, Date compDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsCountryChain> list = findBystdIdDateChCode(stdId,
				chainCode, compDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findBystdIdDateChCode_Last(long stdId,
		String chainCode, Date compDate, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchBystdIdDateChCode_Last(stdId,
				chainCode, compDate, orderByComparator);

		if (standardsCountryChain != null) {
			return standardsCountryChain;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", compDate=");
		msg.append(compDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryChainException(msg.toString());
	}

	/**
	 * Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchBystdIdDateChCode_Last(long stdId,
		String chainCode, Date compDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBystdIdDateChCode(stdId, chainCode, compDate);

		if (count == 0) {
			return null;
		}

		List<StandardsCountryChain> list = findBystdIdDateChCode(stdId,
				chainCode, compDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards country chains before and after the current standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param standardsCountryChainPK the primary key of the current standards country chain
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain[] findBystdIdDateChCode_PrevAndNext(
		StandardsCountryChainPK standardsCountryChainPK, long stdId,
		String chainCode, Date compDate, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = findByPrimaryKey(standardsCountryChainPK);

		Session session = null;

		try {
			session = openSession();

			StandardsCountryChain[] array = new StandardsCountryChainImpl[3];

			array[0] = getBystdIdDateChCode_PrevAndNext(session,
					standardsCountryChain, stdId, chainCode, compDate,
					orderByComparator, true);

			array[1] = standardsCountryChain;

			array[2] = getBystdIdDateChCode_PrevAndNext(session,
					standardsCountryChain, stdId, chainCode, compDate,
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

	protected StandardsCountryChain getBystdIdDateChCode_PrevAndNext(
		Session session, StandardsCountryChain standardsCountryChain,
		long stdId, String chainCode, Date compDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE);

		query.append(_FINDER_COLUMN_STDIDDATECHCODE_STDID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_2);
		}

		boolean bindCompDate = false;

		if (compDate == null) {
			query.append(_FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_1);
		}
		else {
			bindCompDate = true;

			query.append(_FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_2);
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
			query.append(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
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

		if (bindCompDate) {
			qPos.add(CalendarUtil.getTimestamp(compDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCountryChain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCountryChain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdIdDateChCode(long stdId, String chainCode,
		Date compDate) throws SystemException {
		for (StandardsCountryChain standardsCountryChain : findBystdIdDateChCode(
				stdId, chainCode, compDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standardsCountryChain);
		}
	}

	/**
	 * Returns the number of standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param compDate the comp date
	 * @return the number of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdIdDateChCode(long stdId, String chainCode,
		Date compDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDDATECHCODE;

		Object[] finderArgs = new Object[] { stdId, chainCode, compDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSCOUNTRYCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDDATECHCODE_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_2);
			}

			boolean bindCompDate = false;

			if (compDate == null) {
				query.append(_FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_1);
			}
			else {
				bindCompDate = true;

				query.append(_FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_2);
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

				if (bindCompDate) {
					qPos.add(CalendarUtil.getTimestamp(compDate));
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

	private static final String _FINDER_COLUMN_STDIDDATECHCODE_STDID_2 = "standardsCountryChain.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_1 = "standardsCountryChain.id.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_2 = "standardsCountryChain.id.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_STDIDDATECHCODE_CHAINCODE_3 = "(standardsCountryChain.id.chainCode IS NULL OR standardsCountryChain.id.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_1 = "standardsCountryChain.compDate IS NULL";
	private static final String _FINDER_COLUMN_STDIDDATECHCODE_COMPDATE_2 = "standardsCountryChain.compDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDCHAINREGION =
		new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdIdChainRegion",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAINREGION =
		new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStdIdChainRegion",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			StandardsCountryChainModelImpl.STDID_COLUMN_BITMASK |
			StandardsCountryChainModelImpl.CHAINCODE_COLUMN_BITMASK |
			StandardsCountryChainModelImpl.REGIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDCHAINREGION = new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStdIdChainRegion",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findByStdIdChainRegion(long stdId,
		String chainCode, String regionCode) throws SystemException {
		return findByStdIdChainRegion(stdId, chainCode, regionCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @return the range of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findByStdIdChainRegion(long stdId,
		String chainCode, String regionCode, int start, int end)
		throws SystemException {
		return findByStdIdChainRegion(stdId, chainCode, regionCode, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findByStdIdChainRegion(long stdId,
		String chainCode, String regionCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAINREGION;
			finderArgs = new Object[] { stdId, chainCode, regionCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDCHAINREGION;
			finderArgs = new Object[] {
					stdId, chainCode, regionCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsCountryChain> list = (List<StandardsCountryChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCountryChain standardsCountryChain : list) {
				if ((stdId != standardsCountryChain.getStdId()) ||
						!Validator.equals(chainCode,
							standardsCountryChain.getChainCode()) ||
						!Validator.equals(regionCode,
							standardsCountryChain.getRegionCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHAINREGION_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_2);
			}

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryChain>(list);
				}
				else {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
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
	 * Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findByStdIdChainRegion_First(long stdId,
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchByStdIdChainRegion_First(stdId,
				chainCode, regionCode, orderByComparator);

		if (standardsCountryChain != null) {
			return standardsCountryChain;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", regionCode=");
		msg.append(regionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryChainException(msg.toString());
	}

	/**
	 * Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchByStdIdChainRegion_First(long stdId,
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsCountryChain> list = findByStdIdChainRegion(stdId,
				chainCode, regionCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findByStdIdChainRegion_Last(long stdId,
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchByStdIdChainRegion_Last(stdId,
				chainCode, regionCode, orderByComparator);

		if (standardsCountryChain != null) {
			return standardsCountryChain;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", regionCode=");
		msg.append(regionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryChainException(msg.toString());
	}

	/**
	 * Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchByStdIdChainRegion_Last(long stdId,
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStdIdChainRegion(stdId, chainCode, regionCode);

		if (count == 0) {
			return null;
		}

		List<StandardsCountryChain> list = findByStdIdChainRegion(stdId,
				chainCode, regionCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards country chains before and after the current standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param standardsCountryChainPK the primary key of the current standards country chain
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain[] findByStdIdChainRegion_PrevAndNext(
		StandardsCountryChainPK standardsCountryChainPK, long stdId,
		String chainCode, String regionCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = findByPrimaryKey(standardsCountryChainPK);

		Session session = null;

		try {
			session = openSession();

			StandardsCountryChain[] array = new StandardsCountryChainImpl[3];

			array[0] = getByStdIdChainRegion_PrevAndNext(session,
					standardsCountryChain, stdId, chainCode, regionCode,
					orderByComparator, true);

			array[1] = standardsCountryChain;

			array[2] = getByStdIdChainRegion_PrevAndNext(session,
					standardsCountryChain, stdId, chainCode, regionCode,
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

	protected StandardsCountryChain getByStdIdChainRegion_PrevAndNext(
		Session session, StandardsCountryChain standardsCountryChain,
		long stdId, String chainCode, String regionCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE);

		query.append(_FINDER_COLUMN_STDIDCHAINREGION_STDID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_2);
		}

		boolean bindRegionCode = false;

		if (regionCode == null) {
			query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_1);
		}
		else if (regionCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_3);
		}
		else {
			bindRegionCode = true;

			query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_2);
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
			query.append(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
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

		if (bindRegionCode) {
			qPos.add(regionCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCountryChain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCountryChain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdIdChainRegion(long stdId, String chainCode,
		String regionCode) throws SystemException {
		for (StandardsCountryChain standardsCountryChain : findByStdIdChainRegion(
				stdId, chainCode, regionCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standardsCountryChain);
		}
	}

	/**
	 * Returns the number of standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param regionCode the region code
	 * @return the number of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdChainRegion(long stdId, String chainCode,
		String regionCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDCHAINREGION;

		Object[] finderArgs = new Object[] { stdId, chainCode, regionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSCOUNTRYCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHAINREGION_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_2);
			}

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_2);
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

	private static final String _FINDER_COLUMN_STDIDCHAINREGION_STDID_2 = "standardsCountryChain.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_1 = "standardsCountryChain.id.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_2 = "standardsCountryChain.id.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINREGION_CHAINCODE_3 = "(standardsCountryChain.id.chainCode IS NULL OR standardsCountryChain.id.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_1 = "standardsCountryChain.regionCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_2 = "standardsCountryChain.regionCode = ?";
	private static final String _FINDER_COLUMN_STDIDCHAINREGION_REGIONCODE_3 = "(standardsCountryChain.regionCode IS NULL OR standardsCountryChain.regionCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDCHAIN =
		new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdIdChain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAIN =
		new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdIdChain",
			new String[] { Long.class.getName(), String.class.getName() },
			StandardsCountryChainModelImpl.STDID_COLUMN_BITMASK |
			StandardsCountryChainModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDCHAIN = new FinderPath(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdIdChain",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards country chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findByStdIdChain(long stdId,
		String chainCode) throws SystemException {
		return findByStdIdChain(stdId, chainCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @return the range of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findByStdIdChain(long stdId,
		String chainCode, int start, int end) throws SystemException {
		return findByStdIdChain(stdId, chainCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards country chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findByStdIdChain(long stdId,
		String chainCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAIN;
			finderArgs = new Object[] { stdId, chainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDCHAIN;
			finderArgs = new Object[] {
					stdId, chainCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsCountryChain> list = (List<StandardsCountryChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCountryChain standardsCountryChain : list) {
				if ((stdId != standardsCountryChain.getStdId()) ||
						!Validator.equals(chainCode,
							standardsCountryChain.getChainCode())) {
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

			query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHAIN_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
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
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryChain>(list);
				}
				else {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
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
	 * Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findByStdIdChain_First(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchByStdIdChain_First(stdId,
				chainCode, orderByComparator);

		if (standardsCountryChain != null) {
			return standardsCountryChain;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryChainException(msg.toString());
	}

	/**
	 * Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchByStdIdChain_First(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsCountryChain> list = findByStdIdChain(stdId, chainCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findByStdIdChain_Last(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchByStdIdChain_Last(stdId,
				chainCode, orderByComparator);

		if (standardsCountryChain != null) {
			return standardsCountryChain;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryChainException(msg.toString());
	}

	/**
	 * Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchByStdIdChain_Last(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStdIdChain(stdId, chainCode);

		if (count == 0) {
			return null;
		}

		List<StandardsCountryChain> list = findByStdIdChain(stdId, chainCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards country chains before and after the current standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param standardsCountryChainPK the primary key of the current standards country chain
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain[] findByStdIdChain_PrevAndNext(
		StandardsCountryChainPK standardsCountryChainPK, long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = findByPrimaryKey(standardsCountryChainPK);

		Session session = null;

		try {
			session = openSession();

			StandardsCountryChain[] array = new StandardsCountryChainImpl[3];

			array[0] = getByStdIdChain_PrevAndNext(session,
					standardsCountryChain, stdId, chainCode, orderByComparator,
					true);

			array[1] = standardsCountryChain;

			array[2] = getByStdIdChain_PrevAndNext(session,
					standardsCountryChain, stdId, chainCode, orderByComparator,
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

	protected StandardsCountryChain getByStdIdChain_PrevAndNext(
		Session session, StandardsCountryChain standardsCountryChain,
		long stdId, String chainCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE);

		query.append(_FINDER_COLUMN_STDIDCHAIN_STDID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_2);
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
			query.append(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCountryChain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCountryChain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards country chains where stdId = &#63; and chainCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdIdChain(long stdId, String chainCode)
		throws SystemException {
		for (StandardsCountryChain standardsCountryChain : findByStdIdChain(
				stdId, chainCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsCountryChain);
		}
	}

	/**
	 * Returns the number of standards country chains where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the number of matching standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdChain(long stdId, String chainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDCHAIN;

		Object[] finderArgs = new Object[] { stdId, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSCOUNTRYCHAIN_WHERE);

			query.append(_FINDER_COLUMN_STDIDCHAIN_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDIDCHAIN_CHAINCODE_2);
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

	private static final String _FINDER_COLUMN_STDIDCHAIN_STDID_2 = "standardsCountryChain.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDCHAIN_CHAINCODE_1 = "standardsCountryChain.id.chainCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDCHAIN_CHAINCODE_2 = "standardsCountryChain.id.chainCode = ?";
	private static final String _FINDER_COLUMN_STDIDCHAIN_CHAINCODE_3 = "(standardsCountryChain.id.chainCode IS NULL OR standardsCountryChain.id.chainCode = '')";

	public StandardsCountryChainPersistenceImpl() {
		setModelClass(StandardsCountryChain.class);
	}

	/**
	 * Caches the standards country chain in the entity cache if it is enabled.
	 *
	 * @param standardsCountryChain the standards country chain
	 */
	@Override
	public void cacheResult(StandardsCountryChain standardsCountryChain) {
		EntityCacheUtil.putResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			standardsCountryChain.getPrimaryKey(), standardsCountryChain);

		standardsCountryChain.resetOriginalValues();
	}

	/**
	 * Caches the standards country chains in the entity cache if it is enabled.
	 *
	 * @param standardsCountryChains the standards country chains
	 */
	@Override
	public void cacheResult(List<StandardsCountryChain> standardsCountryChains) {
		for (StandardsCountryChain standardsCountryChain : standardsCountryChains) {
			if (EntityCacheUtil.getResult(
						StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryChainImpl.class,
						standardsCountryChain.getPrimaryKey()) == null) {
				cacheResult(standardsCountryChain);
			}
			else {
				standardsCountryChain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards country chains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsCountryChainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsCountryChainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards country chain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsCountryChain standardsCountryChain) {
		EntityCacheUtil.removeResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			standardsCountryChain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsCountryChain> standardsCountryChains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsCountryChain standardsCountryChain : standardsCountryChains) {
			EntityCacheUtil.removeResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryChainImpl.class,
				standardsCountryChain.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards country chain with the primary key. Does not add the standards country chain to the database.
	 *
	 * @param standardsCountryChainPK the primary key for the new standards country chain
	 * @return the new standards country chain
	 */
	@Override
	public StandardsCountryChain create(
		StandardsCountryChainPK standardsCountryChainPK) {
		StandardsCountryChain standardsCountryChain = new StandardsCountryChainImpl();

		standardsCountryChain.setNew(true);
		standardsCountryChain.setPrimaryKey(standardsCountryChainPK);

		return standardsCountryChain;
	}

	/**
	 * Removes the standards country chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCountryChainPK the primary key of the standards country chain
	 * @return the standards country chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain remove(
		StandardsCountryChainPK standardsCountryChainPK)
		throws NoSuchStandardsCountryChainException, SystemException {
		return remove((Serializable)standardsCountryChainPK);
	}

	/**
	 * Removes the standards country chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards country chain
	 * @return the standards country chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain remove(Serializable primaryKey)
		throws NoSuchStandardsCountryChainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsCountryChain standardsCountryChain = (StandardsCountryChain)session.get(StandardsCountryChainImpl.class,
					primaryKey);

			if (standardsCountryChain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsCountryChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsCountryChain);
		}
		catch (NoSuchStandardsCountryChainException nsee) {
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
	protected StandardsCountryChain removeImpl(
		StandardsCountryChain standardsCountryChain) throws SystemException {
		standardsCountryChain = toUnwrappedModel(standardsCountryChain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsCountryChain)) {
				standardsCountryChain = (StandardsCountryChain)session.get(StandardsCountryChainImpl.class,
						standardsCountryChain.getPrimaryKeyObj());
			}

			if (standardsCountryChain != null) {
				session.delete(standardsCountryChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsCountryChain != null) {
			clearCache(standardsCountryChain);
		}

		return standardsCountryChain;
	}

	@Override
	public StandardsCountryChain updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain)
		throws SystemException {
		standardsCountryChain = toUnwrappedModel(standardsCountryChain);

		boolean isNew = standardsCountryChain.isNew();

		StandardsCountryChainModelImpl standardsCountryChainModelImpl = (StandardsCountryChainModelImpl)standardsCountryChain;

		Session session = null;

		try {
			session = openSession();

			if (standardsCountryChain.isNew()) {
				session.save(standardsCountryChain);

				standardsCountryChain.setNew(false);
			}
			else {
				session.merge(standardsCountryChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsCountryChainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsCountryChainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDATECHCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCountryChainModelImpl.getOriginalStdId(),
						standardsCountryChainModelImpl.getOriginalChainCode(),
						standardsCountryChainModelImpl.getOriginalCompDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDDATECHCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDATECHCODE,
					args);

				args = new Object[] {
						standardsCountryChainModelImpl.getStdId(),
						standardsCountryChainModelImpl.getChainCode(),
						standardsCountryChainModelImpl.getCompDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDDATECHCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDATECHCODE,
					args);
			}

			if ((standardsCountryChainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAINREGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCountryChainModelImpl.getOriginalStdId(),
						standardsCountryChainModelImpl.getOriginalChainCode(),
						standardsCountryChainModelImpl.getOriginalRegionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHAINREGION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAINREGION,
					args);

				args = new Object[] {
						standardsCountryChainModelImpl.getStdId(),
						standardsCountryChainModelImpl.getChainCode(),
						standardsCountryChainModelImpl.getRegionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHAINREGION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAINREGION,
					args);
			}

			if ((standardsCountryChainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCountryChainModelImpl.getOriginalStdId(),
						standardsCountryChainModelImpl.getOriginalChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAIN,
					args);

				args = new Object[] {
						standardsCountryChainModelImpl.getStdId(),
						standardsCountryChainModelImpl.getChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDCHAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDCHAIN,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryChainImpl.class,
			standardsCountryChain.getPrimaryKey(), standardsCountryChain);

		return standardsCountryChain;
	}

	protected StandardsCountryChain toUnwrappedModel(
		StandardsCountryChain standardsCountryChain) {
		if (standardsCountryChain instanceof StandardsCountryChainImpl) {
			return standardsCountryChain;
		}

		StandardsCountryChainImpl standardsCountryChainImpl = new StandardsCountryChainImpl();

		standardsCountryChainImpl.setNew(standardsCountryChain.isNew());
		standardsCountryChainImpl.setPrimaryKey(standardsCountryChain.getPrimaryKey());

		standardsCountryChainImpl.setStdId(standardsCountryChain.getStdId());
		standardsCountryChainImpl.setCountryCode(standardsCountryChain.getCountryCode());
		standardsCountryChainImpl.setChainCode(standardsCountryChain.getChainCode());
		standardsCountryChainImpl.setRegionCode(standardsCountryChain.getRegionCode());
		standardsCountryChainImpl.setCompDate(standardsCountryChain.getCompDate());
		standardsCountryChainImpl.setExprDate(standardsCountryChain.getExprDate());
		standardsCountryChainImpl.setExpiredIds(standardsCountryChain.getExpiredIds());
		standardsCountryChainImpl.setCreatorId(standardsCountryChain.getCreatorId());
		standardsCountryChainImpl.setCreatedDate(standardsCountryChain.getCreatedDate());
		standardsCountryChainImpl.setUpdatedBy(standardsCountryChain.getUpdatedBy());
		standardsCountryChainImpl.setUpdatedDate(standardsCountryChain.getUpdatedDate());

		return standardsCountryChainImpl;
	}

	/**
	 * Returns the standards country chain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country chain
	 * @return the standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsCountryChainException, SystemException {
		StandardsCountryChain standardsCountryChain = fetchByPrimaryKey(primaryKey);

		if (standardsCountryChain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsCountryChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsCountryChain;
	}

	/**
	 * Returns the standards country chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryChainException} if it could not be found.
	 *
	 * @param standardsCountryChainPK the primary key of the standards country chain
	 * @return the standards country chain
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain findByPrimaryKey(
		StandardsCountryChainPK standardsCountryChainPK)
		throws NoSuchStandardsCountryChainException, SystemException {
		return findByPrimaryKey((Serializable)standardsCountryChainPK);
	}

	/**
	 * Returns the standards country chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country chain
	 * @return the standards country chain, or <code>null</code> if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsCountryChain standardsCountryChain = (StandardsCountryChain)EntityCacheUtil.getResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryChainImpl.class, primaryKey);

		if (standardsCountryChain == _nullStandardsCountryChain) {
			return null;
		}

		if (standardsCountryChain == null) {
			Session session = null;

			try {
				session = openSession();

				standardsCountryChain = (StandardsCountryChain)session.get(StandardsCountryChainImpl.class,
						primaryKey);

				if (standardsCountryChain != null) {
					cacheResult(standardsCountryChain);
				}
				else {
					EntityCacheUtil.putResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryChainImpl.class, primaryKey,
						_nullStandardsCountryChain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsCountryChainModelImpl.ENTITY_CACHE_ENABLED,
					StandardsCountryChainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsCountryChain;
	}

	/**
	 * Returns the standards country chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsCountryChainPK the primary key of the standards country chain
	 * @return the standards country chain, or <code>null</code> if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain fetchByPrimaryKey(
		StandardsCountryChainPK standardsCountryChainPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsCountryChainPK);
	}

	/**
	 * Returns all the standards country chains.
	 *
	 * @return the standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @return the range of standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards country chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> findAll(int start, int end,
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

		List<StandardsCountryChain> list = (List<StandardsCountryChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCOUNTRYCHAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCOUNTRYCHAIN;

				if (pagination) {
					sql = sql.concat(StandardsCountryChainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryChain>(list);
				}
				else {
					list = (List<StandardsCountryChain>)QueryUtil.list(q,
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
	 * Removes all the standards country chains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsCountryChain standardsCountryChain : findAll()) {
			remove(standardsCountryChain);
		}
	}

	/**
	 * Returns the number of standards country chains.
	 *
	 * @return the number of standards country chains
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCOUNTRYCHAIN);

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
	 * Initializes the standards country chain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsCountryChain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsCountryChain>> listenersList = new ArrayList<ModelListener<StandardsCountryChain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsCountryChain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsCountryChainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCOUNTRYCHAIN = "SELECT standardsCountryChain FROM StandardsCountryChain standardsCountryChain";
	private static final String _SQL_SELECT_STANDARDSCOUNTRYCHAIN_WHERE = "SELECT standardsCountryChain FROM StandardsCountryChain standardsCountryChain WHERE ";
	private static final String _SQL_COUNT_STANDARDSCOUNTRYCHAIN = "SELECT COUNT(standardsCountryChain) FROM StandardsCountryChain standardsCountryChain";
	private static final String _SQL_COUNT_STANDARDSCOUNTRYCHAIN_WHERE = "SELECT COUNT(standardsCountryChain) FROM StandardsCountryChain standardsCountryChain WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsCountryChain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsCountryChain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsCountryChain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsCountryChainPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "countryCode", "chainCode", "regionCode", "compDate",
				"exprDate", "expiredIds", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static StandardsCountryChain _nullStandardsCountryChain = new StandardsCountryChainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsCountryChain> toCacheModel() {
				return _nullStandardsCountryChainCacheModel;
			}
		};

	private static CacheModel<StandardsCountryChain> _nullStandardsCountryChainCacheModel =
		new CacheModel<StandardsCountryChain>() {
			@Override
			public StandardsCountryChain toEntityModel() {
				return _nullStandardsCountryChain;
			}
		};
}