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

import com.ihg.brandstandards.db.NoSuchStandardsComplianceException;
import com.ihg.brandstandards.db.model.StandardsCompliance;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceImpl;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl;

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
 * The persistence implementation for the standards compliance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCompliancePersistence
 * @see StandardsComplianceUtil
 * @generated
 */
public class StandardsCompliancePersistenceImpl extends BasePersistenceImpl<StandardsCompliance>
	implements StandardsCompliancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsComplianceUtil} to access the standards compliance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsComplianceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDCHAIN = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdChain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDCHAIN =
		new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdChain",
			new String[] { Long.class.getName(), String.class.getName() },
			StandardsComplianceModelImpl.STDID_COLUMN_BITMASK |
			StandardsComplianceModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDCHAIN = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdChain",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards compliances where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the matching standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCompliance> findByStdChain(long stdId, String chainCode)
		throws SystemException {
		return findByStdChain(stdId, chainCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards compliances where stdId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of standards compliances
	 * @param end the upper bound of the range of standards compliances (not inclusive)
	 * @return the range of matching standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCompliance> findByStdChain(long stdId,
		String chainCode, int start, int end) throws SystemException {
		return findByStdChain(stdId, chainCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards compliances where stdId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of standards compliances
	 * @param end the upper bound of the range of standards compliances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCompliance> findByStdChain(long stdId,
		String chainCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDCHAIN;
			finderArgs = new Object[] { stdId, chainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDCHAIN;
			finderArgs = new Object[] {
					stdId, chainCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsCompliance> list = (List<StandardsCompliance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCompliance standardsCompliance : list) {
				if ((stdId != standardsCompliance.getStdId()) ||
						!Validator.equals(chainCode,
							standardsCompliance.getChainCode())) {
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

			query.append(_SQL_SELECT_STANDARDSCOMPLIANCE_WHERE);

			query.append(_FINDER_COLUMN_STDCHAIN_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsComplianceModelImpl.ORDER_BY_JPQL);
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
					list = (List<StandardsCompliance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCompliance>(list);
				}
				else {
					list = (List<StandardsCompliance>)QueryUtil.list(q,
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
	 * Returns the first standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards compliance
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance findByStdChain_First(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsComplianceException, SystemException {
		StandardsCompliance standardsCompliance = fetchByStdChain_First(stdId,
				chainCode, orderByComparator);

		if (standardsCompliance != null) {
			return standardsCompliance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsComplianceException(msg.toString());
	}

	/**
	 * Returns the first standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance fetchByStdChain_First(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsCompliance> list = findByStdChain(stdId, chainCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards compliance
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance findByStdChain_Last(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsComplianceException, SystemException {
		StandardsCompliance standardsCompliance = fetchByStdChain_Last(stdId,
				chainCode, orderByComparator);

		if (standardsCompliance != null) {
			return standardsCompliance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsComplianceException(msg.toString());
	}

	/**
	 * Returns the last standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance fetchByStdChain_Last(long stdId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStdChain(stdId, chainCode);

		if (count == 0) {
			return null;
		}

		List<StandardsCompliance> list = findByStdChain(stdId, chainCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards compliances before and after the current standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdComplianceId the primary key of the current standards compliance
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards compliance
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance[] findByStdChain_PrevAndNext(
		long stdComplianceId, long stdId, String chainCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsComplianceException, SystemException {
		StandardsCompliance standardsCompliance = findByPrimaryKey(stdComplianceId);

		Session session = null;

		try {
			session = openSession();

			StandardsCompliance[] array = new StandardsComplianceImpl[3];

			array[0] = getByStdChain_PrevAndNext(session, standardsCompliance,
					stdId, chainCode, orderByComparator, true);

			array[1] = standardsCompliance;

			array[2] = getByStdChain_PrevAndNext(session, standardsCompliance,
					stdId, chainCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsCompliance getByStdChain_PrevAndNext(Session session,
		StandardsCompliance standardsCompliance, long stdId, String chainCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCOMPLIANCE_WHERE);

		query.append(_FINDER_COLUMN_STDCHAIN_STDID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_2);
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
			query.append(StandardsComplianceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCompliance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCompliance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards compliances where stdId = &#63; and chainCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdChain(long stdId, String chainCode)
		throws SystemException {
		for (StandardsCompliance standardsCompliance : findByStdChain(stdId,
				chainCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsCompliance);
		}
	}

	/**
	 * Returns the number of standards compliances where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the number of matching standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdChain(long stdId, String chainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDCHAIN;

		Object[] finderArgs = new Object[] { stdId, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSCOMPLIANCE_WHERE);

			query.append(_FINDER_COLUMN_STDCHAIN_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDCHAIN_CHAINCODE_2);
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

	private static final String _FINDER_COLUMN_STDCHAIN_STDID_2 = "standardsCompliance.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDCHAIN_CHAINCODE_1 = "standardsCompliance.chainCode IS NULL";
	private static final String _FINDER_COLUMN_STDCHAIN_CHAINCODE_2 = "standardsCompliance.chainCode = ?";
	private static final String _FINDER_COLUMN_STDCHAIN_CHAINCODE_3 = "(standardsCompliance.chainCode IS NULL OR standardsCompliance.chainCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByStdChainCountry",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			StandardsComplianceModelImpl.STDID_COLUMN_BITMASK |
			StandardsComplianceModelImpl.CHAINCODE_COLUMN_BITMASK |
			StandardsComplianceModelImpl.COUNTRYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDCHAINCOUNTRY = new FinderPath(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStdChainCountry",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param countryCode the country code
	 * @return the matching standards compliance
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance findByStdChainCountry(long stdId,
		String chainCode, String countryCode)
		throws NoSuchStandardsComplianceException, SystemException {
		StandardsCompliance standardsCompliance = fetchByStdChainCountry(stdId,
				chainCode, countryCode);

		if (standardsCompliance == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(", countryCode=");
			msg.append(countryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsComplianceException(msg.toString());
		}

		return standardsCompliance;
	}

	/**
	 * Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param countryCode the country code
	 * @return the matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance fetchByStdChainCountry(long stdId,
		String chainCode, String countryCode) throws SystemException {
		return fetchByStdChainCountry(stdId, chainCode, countryCode, true);
	}

	/**
	 * Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param countryCode the country code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance fetchByStdChainCountry(long stdId,
		String chainCode, String countryCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId, chainCode, countryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
					finderArgs, this);
		}

		if (result instanceof StandardsCompliance) {
			StandardsCompliance standardsCompliance = (StandardsCompliance)result;

			if ((stdId != standardsCompliance.getStdId()) ||
					!Validator.equals(chainCode,
						standardsCompliance.getChainCode()) ||
					!Validator.equals(countryCode,
						standardsCompliance.getCountryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_STANDARDSCOMPLIANCE_WHERE);

			query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_2);
			}

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_2);
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

				if (bindCountryCode) {
					qPos.add(countryCode);
				}

				List<StandardsCompliance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsCompliancePersistenceImpl.fetchByStdChainCountry(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsCompliance standardsCompliance = list.get(0);

					result = standardsCompliance;

					cacheResult(standardsCompliance);

					if ((standardsCompliance.getStdId() != stdId) ||
							(standardsCompliance.getChainCode() == null) ||
							!standardsCompliance.getChainCode().equals(chainCode) ||
							(standardsCompliance.getCountryCode() == null) ||
							!standardsCompliance.getCountryCode()
													.equals(countryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
							finderArgs, standardsCompliance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
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
			return (StandardsCompliance)result;
		}
	}

	/**
	 * Removes the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param countryCode the country code
	 * @return the standards compliance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance removeByStdChainCountry(long stdId,
		String chainCode, String countryCode)
		throws NoSuchStandardsComplianceException, SystemException {
		StandardsCompliance standardsCompliance = findByStdChainCountry(stdId,
				chainCode, countryCode);

		return remove(standardsCompliance);
	}

	/**
	 * Returns the number of standards compliances where stdId = &#63; and chainCode = &#63; and countryCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param countryCode the country code
	 * @return the number of matching standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdChainCountry(long stdId, String chainCode,
		String countryCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDCHAINCOUNTRY;

		Object[] finderArgs = new Object[] { stdId, chainCode, countryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSCOMPLIANCE_WHERE);

			query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_2);
			}

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_2);
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

	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_STDID_2 = "standardsCompliance.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_1 = "standardsCompliance.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_2 = "standardsCompliance.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_CHAINCODE_3 = "(standardsCompliance.chainCode IS NULL OR standardsCompliance.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_1 = "standardsCompliance.countryCode IS NULL";
	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_2 = "standardsCompliance.countryCode = ?";
	private static final String _FINDER_COLUMN_STDCHAINCOUNTRY_COUNTRYCODE_3 = "(standardsCompliance.countryCode IS NULL OR standardsCompliance.countryCode = '')";

	public StandardsCompliancePersistenceImpl() {
		setModelClass(StandardsCompliance.class);
	}

	/**
	 * Caches the standards compliance in the entity cache if it is enabled.
	 *
	 * @param standardsCompliance the standards compliance
	 */
	@Override
	public void cacheResult(StandardsCompliance standardsCompliance) {
		EntityCacheUtil.putResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceImpl.class, standardsCompliance.getPrimaryKey(),
			standardsCompliance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
			new Object[] {
				standardsCompliance.getStdId(),
				standardsCompliance.getChainCode(),
				standardsCompliance.getCountryCode()
			}, standardsCompliance);

		standardsCompliance.resetOriginalValues();
	}

	/**
	 * Caches the standards compliances in the entity cache if it is enabled.
	 *
	 * @param standardsCompliances the standards compliances
	 */
	@Override
	public void cacheResult(List<StandardsCompliance> standardsCompliances) {
		for (StandardsCompliance standardsCompliance : standardsCompliances) {
			if (EntityCacheUtil.getResult(
						StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
						StandardsComplianceImpl.class,
						standardsCompliance.getPrimaryKey()) == null) {
				cacheResult(standardsCompliance);
			}
			else {
				standardsCompliance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards compliances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsComplianceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsComplianceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards compliance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsCompliance standardsCompliance) {
		EntityCacheUtil.removeResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceImpl.class, standardsCompliance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsCompliance);
	}

	@Override
	public void clearCache(List<StandardsCompliance> standardsCompliances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsCompliance standardsCompliance : standardsCompliances) {
			EntityCacheUtil.removeResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
				StandardsComplianceImpl.class,
				standardsCompliance.getPrimaryKey());

			clearUniqueFindersCache(standardsCompliance);
		}
	}

	protected void cacheUniqueFindersCache(
		StandardsCompliance standardsCompliance) {
		if (standardsCompliance.isNew()) {
			Object[] args = new Object[] {
					standardsCompliance.getStdId(),
					standardsCompliance.getChainCode(),
					standardsCompliance.getCountryCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDCHAINCOUNTRY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
				args, standardsCompliance);
		}
		else {
			StandardsComplianceModelImpl standardsComplianceModelImpl = (StandardsComplianceModelImpl)standardsCompliance;

			if ((standardsComplianceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCompliance.getStdId(),
						standardsCompliance.getChainCode(),
						standardsCompliance.getCountryCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDCHAINCOUNTRY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
					args, standardsCompliance);
			}
		}
	}

	protected void clearUniqueFindersCache(
		StandardsCompliance standardsCompliance) {
		StandardsComplianceModelImpl standardsComplianceModelImpl = (StandardsComplianceModelImpl)standardsCompliance;

		Object[] args = new Object[] {
				standardsCompliance.getStdId(),
				standardsCompliance.getChainCode(),
				standardsCompliance.getCountryCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDCHAINCOUNTRY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY, args);

		if ((standardsComplianceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY.getColumnBitmask()) != 0) {
			args = new Object[] {
					standardsComplianceModelImpl.getOriginalStdId(),
					standardsComplianceModelImpl.getOriginalChainCode(),
					standardsComplianceModelImpl.getOriginalCountryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDCHAINCOUNTRY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDCHAINCOUNTRY,
				args);
		}
	}

	/**
	 * Creates a new standards compliance with the primary key. Does not add the standards compliance to the database.
	 *
	 * @param stdComplianceId the primary key for the new standards compliance
	 * @return the new standards compliance
	 */
	@Override
	public StandardsCompliance create(long stdComplianceId) {
		StandardsCompliance standardsCompliance = new StandardsComplianceImpl();

		standardsCompliance.setNew(true);
		standardsCompliance.setPrimaryKey(stdComplianceId);

		return standardsCompliance;
	}

	/**
	 * Removes the standards compliance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdComplianceId the primary key of the standards compliance
	 * @return the standards compliance that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance remove(long stdComplianceId)
		throws NoSuchStandardsComplianceException, SystemException {
		return remove((Serializable)stdComplianceId);
	}

	/**
	 * Removes the standards compliance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards compliance
	 * @return the standards compliance that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance remove(Serializable primaryKey)
		throws NoSuchStandardsComplianceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsCompliance standardsCompliance = (StandardsCompliance)session.get(StandardsComplianceImpl.class,
					primaryKey);

			if (standardsCompliance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsComplianceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsCompliance);
		}
		catch (NoSuchStandardsComplianceException nsee) {
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
	protected StandardsCompliance removeImpl(
		StandardsCompliance standardsCompliance) throws SystemException {
		standardsCompliance = toUnwrappedModel(standardsCompliance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsCompliance)) {
				standardsCompliance = (StandardsCompliance)session.get(StandardsComplianceImpl.class,
						standardsCompliance.getPrimaryKeyObj());
			}

			if (standardsCompliance != null) {
				session.delete(standardsCompliance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsCompliance != null) {
			clearCache(standardsCompliance);
		}

		return standardsCompliance;
	}

	@Override
	public StandardsCompliance updateImpl(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws SystemException {
		standardsCompliance = toUnwrappedModel(standardsCompliance);

		boolean isNew = standardsCompliance.isNew();

		StandardsComplianceModelImpl standardsComplianceModelImpl = (StandardsComplianceModelImpl)standardsCompliance;

		Session session = null;

		try {
			session = openSession();

			if (standardsCompliance.isNew()) {
				session.save(standardsCompliance);

				standardsCompliance.setNew(false);
			}
			else {
				session.merge(standardsCompliance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsComplianceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsComplianceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDCHAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsComplianceModelImpl.getOriginalStdId(),
						standardsComplianceModelImpl.getOriginalChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDCHAIN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDCHAIN,
					args);

				args = new Object[] {
						standardsComplianceModelImpl.getStdId(),
						standardsComplianceModelImpl.getChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDCHAIN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDCHAIN,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceImpl.class, standardsCompliance.getPrimaryKey(),
			standardsCompliance);

		clearUniqueFindersCache(standardsCompliance);
		cacheUniqueFindersCache(standardsCompliance);

		return standardsCompliance;
	}

	protected StandardsCompliance toUnwrappedModel(
		StandardsCompliance standardsCompliance) {
		if (standardsCompliance instanceof StandardsComplianceImpl) {
			return standardsCompliance;
		}

		StandardsComplianceImpl standardsComplianceImpl = new StandardsComplianceImpl();

		standardsComplianceImpl.setNew(standardsCompliance.isNew());
		standardsComplianceImpl.setPrimaryKey(standardsCompliance.getPrimaryKey());

		standardsComplianceImpl.setStdComplianceId(standardsCompliance.getStdComplianceId());
		standardsComplianceImpl.setStdId(standardsCompliance.getStdId());
		standardsComplianceImpl.setCountryCode(standardsCompliance.getCountryCode());
		standardsComplianceImpl.setChainCode(standardsCompliance.getChainCode());
		standardsComplianceImpl.setComplianceExpiryDate(standardsCompliance.getComplianceExpiryDate());
		standardsComplianceImpl.setComplianceExpiryRule(standardsCompliance.getComplianceExpiryRule());
		standardsComplianceImpl.setComplianceRuleMonths(standardsCompliance.getComplianceRuleMonths());
		standardsComplianceImpl.setRuleDate(standardsCompliance.getRuleDate());
		standardsComplianceImpl.setCreatorId(standardsCompliance.getCreatorId());
		standardsComplianceImpl.setCreatedDate(standardsCompliance.getCreatedDate());
		standardsComplianceImpl.setUpdatedBy(standardsCompliance.getUpdatedBy());
		standardsComplianceImpl.setUpdatedDate(standardsCompliance.getUpdatedDate());

		return standardsComplianceImpl;
	}

	/**
	 * Returns the standards compliance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards compliance
	 * @return the standards compliance
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsComplianceException, SystemException {
		StandardsCompliance standardsCompliance = fetchByPrimaryKey(primaryKey);

		if (standardsCompliance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsComplianceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsCompliance;
	}

	/**
	 * Returns the standards compliance with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceException} if it could not be found.
	 *
	 * @param stdComplianceId the primary key of the standards compliance
	 * @return the standards compliance
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance findByPrimaryKey(long stdComplianceId)
		throws NoSuchStandardsComplianceException, SystemException {
		return findByPrimaryKey((Serializable)stdComplianceId);
	}

	/**
	 * Returns the standards compliance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards compliance
	 * @return the standards compliance, or <code>null</code> if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsCompliance standardsCompliance = (StandardsCompliance)EntityCacheUtil.getResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
				StandardsComplianceImpl.class, primaryKey);

		if (standardsCompliance == _nullStandardsCompliance) {
			return null;
		}

		if (standardsCompliance == null) {
			Session session = null;

			try {
				session = openSession();

				standardsCompliance = (StandardsCompliance)session.get(StandardsComplianceImpl.class,
						primaryKey);

				if (standardsCompliance != null) {
					cacheResult(standardsCompliance);
				}
				else {
					EntityCacheUtil.putResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
						StandardsComplianceImpl.class, primaryKey,
						_nullStandardsCompliance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsComplianceModelImpl.ENTITY_CACHE_ENABLED,
					StandardsComplianceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsCompliance;
	}

	/**
	 * Returns the standards compliance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdComplianceId the primary key of the standards compliance
	 * @return the standards compliance, or <code>null</code> if a standards compliance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCompliance fetchByPrimaryKey(long stdComplianceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdComplianceId);
	}

	/**
	 * Returns all the standards compliances.
	 *
	 * @return the standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCompliance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards compliances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards compliances
	 * @param end the upper bound of the range of standards compliances (not inclusive)
	 * @return the range of standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCompliance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards compliances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards compliances
	 * @param end the upper bound of the range of standards compliances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards compliances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCompliance> findAll(int start, int end,
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

		List<StandardsCompliance> list = (List<StandardsCompliance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCOMPLIANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCOMPLIANCE;

				if (pagination) {
					sql = sql.concat(StandardsComplianceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsCompliance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCompliance>(list);
				}
				else {
					list = (List<StandardsCompliance>)QueryUtil.list(q,
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
	 * Removes all the standards compliances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsCompliance standardsCompliance : findAll()) {
			remove(standardsCompliance);
		}
	}

	/**
	 * Returns the number of standards compliances.
	 *
	 * @return the number of standards compliances
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCOMPLIANCE);

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
	 * Initializes the standards compliance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsCompliance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsCompliance>> listenersList = new ArrayList<ModelListener<StandardsCompliance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsCompliance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsComplianceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCOMPLIANCE = "SELECT standardsCompliance FROM StandardsCompliance standardsCompliance";
	private static final String _SQL_SELECT_STANDARDSCOMPLIANCE_WHERE = "SELECT standardsCompliance FROM StandardsCompliance standardsCompliance WHERE ";
	private static final String _SQL_COUNT_STANDARDSCOMPLIANCE = "SELECT COUNT(standardsCompliance) FROM StandardsCompliance standardsCompliance";
	private static final String _SQL_COUNT_STANDARDSCOMPLIANCE_WHERE = "SELECT COUNT(standardsCompliance) FROM StandardsCompliance standardsCompliance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsCompliance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsCompliance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsCompliance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsCompliancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdComplianceId", "stdId", "countryCode", "chainCode",
				"complianceExpiryDate", "complianceExpiryRule",
				"complianceRuleMonths", "RuleDate", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static StandardsCompliance _nullStandardsCompliance = new StandardsComplianceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsCompliance> toCacheModel() {
				return _nullStandardsComplianceCacheModel;
			}
		};

	private static CacheModel<StandardsCompliance> _nullStandardsComplianceCacheModel =
		new CacheModel<StandardsCompliance>() {
			@Override
			public StandardsCompliance toEntityModel() {
				return _nullStandardsCompliance;
			}
		};
}