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

import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.impl.ChainStandardsImpl;
import com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl;

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
 * The persistence implementation for the chain standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainStandardsPersistence
 * @see ChainStandardsUtil
 * @generated
 */
public class ChainStandardsPersistenceImpl extends BasePersistenceImpl<ChainStandards>
	implements ChainStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChainStandardsUtil} to access the chain standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChainStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName(), String.class.getName() },
			ChainStandardsModelImpl.STDID_COLUMN_BITMASK |
			ChainStandardsModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the chain standardses where stdId = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @return the matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findByStdId(long stdId, String isActive)
		throws SystemException {
		return findByStdId(stdId, isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chain standardses where stdId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of chain standardses
	 * @param end the upper bound of the range of chain standardses (not inclusive)
	 * @return the range of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findByStdId(long stdId, String isActive,
		int start, int end) throws SystemException {
		return findByStdId(stdId, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain standardses where stdId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of chain standardses
	 * @param end the upper bound of the range of chain standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findByStdId(long stdId, String isActive,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId, isActive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] {
					stdId, isActive,
					
					start, end, orderByComparator
				};
		}

		List<ChainStandards> list = (List<ChainStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChainStandards chainStandards : list) {
				if ((stdId != chainStandards.getStdId()) ||
						!Validator.equals(isActive, chainStandards.getIsActive())) {
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

			query.append(_SQL_SELECT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			boolean bindIsActive = false;

			if (isActive == null) {
				query.append(_FINDER_COLUMN_STDID_ISACTIVE_1);
			}
			else if (isActive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDID_ISACTIVE_3);
			}
			else {
				bindIsActive = true;

				query.append(_FINDER_COLUMN_STDID_ISACTIVE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChainStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindIsActive) {
					qPos.add(isActive);
				}

				if (!pagination) {
					list = (List<ChainStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainStandards>(list);
				}
				else {
					list = (List<ChainStandards>)QueryUtil.list(q,
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
	 * Returns the first chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByStdId_First(long stdId, String isActive,
		OrderByComparator orderByComparator)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByStdId_First(stdId, isActive,
				orderByComparator);

		if (chainStandards != null) {
			return chainStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainStandardsException(msg.toString());
	}

	/**
	 * Returns the first chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByStdId_First(long stdId, String isActive,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChainStandards> list = findByStdId(stdId, isActive, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByStdId_Last(long stdId, String isActive,
		OrderByComparator orderByComparator)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByStdId_Last(stdId, isActive,
				orderByComparator);

		if (chainStandards != null) {
			return chainStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainStandardsException(msg.toString());
	}

	/**
	 * Returns the last chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByStdId_Last(long stdId, String isActive,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId, isActive);

		if (count == 0) {
			return null;
		}

		List<ChainStandards> list = findByStdId(stdId, isActive, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chain standardses before and after the current chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	 *
	 * @param chainStandardsPK the primary key of the current chain standards
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards[] findByStdId_PrevAndNext(
		ChainStandardsPK chainStandardsPK, long stdId, String isActive,
		OrderByComparator orderByComparator)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = findByPrimaryKey(chainStandardsPK);

		Session session = null;

		try {
			session = openSession();

			ChainStandards[] array = new ChainStandardsImpl[3];

			array[0] = getByStdId_PrevAndNext(session, chainStandards, stdId,
					isActive, orderByComparator, true);

			array[1] = chainStandards;

			array[2] = getByStdId_PrevAndNext(session, chainStandards, stdId,
					isActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChainStandards getByStdId_PrevAndNext(Session session,
		ChainStandards chainStandards, long stdId, String isActive,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHAINSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDID_STDID_2);

		boolean bindIsActive = false;

		if (isActive == null) {
			query.append(_FINDER_COLUMN_STDID_ISACTIVE_1);
		}
		else if (isActive.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDID_ISACTIVE_3);
		}
		else {
			bindIsActive = true;

			query.append(_FINDER_COLUMN_STDID_ISACTIVE_2);
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
			query.append(ChainStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (bindIsActive) {
			qPos.add(isActive);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chainStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChainStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chain standardses where stdId = &#63; and isActive = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId, String isActive)
		throws SystemException {
		for (ChainStandards chainStandards : findByStdId(stdId, isActive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chainStandards);
		}
	}

	/**
	 * Returns the number of chain standardses where stdId = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isActive the is active
	 * @return the number of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdId(long stdId, String isActive)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId, isActive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			boolean bindIsActive = false;

			if (isActive == null) {
				query.append(_FINDER_COLUMN_STDID_ISACTIVE_1);
			}
			else if (isActive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDID_ISACTIVE_3);
			}
			else {
				bindIsActive = true;

				query.append(_FINDER_COLUMN_STDID_ISACTIVE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindIsActive) {
					qPos.add(isActive);
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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "chainStandards.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDID_ISACTIVE_1 = "chainStandards.isActive IS NULL";
	private static final String _FINDER_COLUMN_STDID_ISACTIVE_2 = "chainStandards.isActive = ?";
	private static final String _FINDER_COLUMN_STDID_ISACTIVE_3 = "(chainStandards.isActive IS NULL OR chainStandards.isActive = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CHAINCODE = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByChainCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ChainStandardsModelImpl.STDID_COLUMN_BITMASK |
			ChainStandardsModelImpl.CHAINCODE_COLUMN_BITMASK |
			ChainStandardsModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAINCODE = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChainCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchChainStandardsException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param isActive the is active
	 * @return the matching chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByChainCode(long stdId, String chainCode,
		String isActive) throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByChainCode(stdId, chainCode,
				isActive);

		if (chainStandards == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(", isActive=");
			msg.append(isActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchChainStandardsException(msg.toString());
		}

		return chainStandards;
	}

	/**
	 * Returns the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param isActive the is active
	 * @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByChainCode(long stdId, String chainCode,
		String isActive) throws SystemException {
		return fetchByChainCode(stdId, chainCode, isActive, true);
	}

	/**
	 * Returns the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param isActive the is active
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByChainCode(long stdId, String chainCode,
		String isActive, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { stdId, chainCode, isActive };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CHAINCODE,
					finderArgs, this);
		}

		if (result instanceof ChainStandards) {
			ChainStandards chainStandards = (ChainStandards)result;

			if ((stdId != chainStandards.getStdId()) ||
					!Validator.equals(chainCode, chainStandards.getChainCode()) ||
					!Validator.equals(isActive, chainStandards.getIsActive())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_CHAINCODE_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODE_CHAINCODE_2);
			}

			boolean bindIsActive = false;

			if (isActive == null) {
				query.append(_FINDER_COLUMN_CHAINCODE_ISACTIVE_1);
			}
			else if (isActive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODE_ISACTIVE_3);
			}
			else {
				bindIsActive = true;

				query.append(_FINDER_COLUMN_CHAINCODE_ISACTIVE_2);
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

				if (bindIsActive) {
					qPos.add(isActive);
				}

				List<ChainStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ChainStandardsPersistenceImpl.fetchByChainCode(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ChainStandards chainStandards = list.get(0);

					result = chainStandards;

					cacheResult(chainStandards);

					if ((chainStandards.getStdId() != stdId) ||
							(chainStandards.getChainCode() == null) ||
							!chainStandards.getChainCode().equals(chainCode) ||
							(chainStandards.getIsActive() == null) ||
							!chainStandards.getIsActive().equals(isActive)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODE,
							finderArgs, chainStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAINCODE,
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
			return (ChainStandards)result;
		}
	}

	/**
	 * Removes the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param isActive the is active
	 * @return the chain standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards removeByChainCode(long stdId, String chainCode,
		String isActive) throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = findByChainCode(stdId, chainCode,
				isActive);

		return remove(chainStandards);
	}

	/**
	 * Returns the number of chain standardses where stdId = &#63; and chainCode = &#63; and isActive = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param isActive the is active
	 * @return the number of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChainCode(long stdId, String chainCode, String isActive)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHAINCODE;

		Object[] finderArgs = new Object[] { stdId, chainCode, isActive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_CHAINCODE_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODE_CHAINCODE_2);
			}

			boolean bindIsActive = false;

			if (isActive == null) {
				query.append(_FINDER_COLUMN_CHAINCODE_ISACTIVE_1);
			}
			else if (isActive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODE_ISACTIVE_3);
			}
			else {
				bindIsActive = true;

				query.append(_FINDER_COLUMN_CHAINCODE_ISACTIVE_2);
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

				if (bindIsActive) {
					qPos.add(isActive);
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

	private static final String _FINDER_COLUMN_CHAINCODE_STDID_2 = "chainStandards.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_CHAINCODE_CHAINCODE_1 = "chainStandards.id.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_CHAINCODE_CHAINCODE_2 = "chainStandards.id.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_CHAINCODE_CHAINCODE_3 = "(chainStandards.id.chainCode IS NULL OR chainStandards.id.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_CHAINCODE_ISACTIVE_1 = "chainStandards.isActive IS NULL";
	private static final String _FINDER_COLUMN_CHAINCODE_ISACTIVE_2 = "chainStandards.isActive = ?";
	private static final String _FINDER_COLUMN_CHAINCODE_ISACTIVE_3 = "(chainStandards.isActive IS NULL OR chainStandards.isActive = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CHAINCODEALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByChainCodeAll",
			new String[] { Long.class.getName(), String.class.getName() },
			ChainStandardsModelImpl.STDID_COLUMN_BITMASK |
			ChainStandardsModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAINCODEALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChainCodeAll",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the chain standards where stdId = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchChainStandardsException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the matching chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByChainCodeAll(long stdId, String chainCode)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByChainCodeAll(stdId, chainCode);

		if (chainStandards == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchChainStandardsException(msg.toString());
		}

		return chainStandards;
	}

	/**
	 * Returns the chain standards where stdId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByChainCodeAll(long stdId, String chainCode)
		throws SystemException {
		return fetchByChainCodeAll(stdId, chainCode, true);
	}

	/**
	 * Returns the chain standards where stdId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByChainCodeAll(long stdId, String chainCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { stdId, chainCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CHAINCODEALL,
					finderArgs, this);
		}

		if (result instanceof ChainStandards) {
			ChainStandards chainStandards = (ChainStandards)result;

			if ((stdId != chainStandards.getStdId()) ||
					!Validator.equals(chainCode, chainStandards.getChainCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_CHAINCODEALL_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEALL_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEALL_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEALL_CHAINCODE_2);
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

				List<ChainStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODEALL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ChainStandardsPersistenceImpl.fetchByChainCodeAll(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ChainStandards chainStandards = list.get(0);

					result = chainStandards;

					cacheResult(chainStandards);

					if ((chainStandards.getStdId() != stdId) ||
							(chainStandards.getChainCode() == null) ||
							!chainStandards.getChainCode().equals(chainCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODEALL,
							finderArgs, chainStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAINCODEALL,
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
			return (ChainStandards)result;
		}
	}

	/**
	 * Removes the chain standards where stdId = &#63; and chainCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the chain standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards removeByChainCodeAll(long stdId, String chainCode)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = findByChainCodeAll(stdId, chainCode);

		return remove(chainStandards);
	}

	/**
	 * Returns the number of chain standardses where stdId = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param chainCode the chain code
	 * @return the number of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChainCodeAll(long stdId, String chainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHAINCODEALL;

		Object[] finderArgs = new Object[] { stdId, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_CHAINCODEALL_STDID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEALL_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEALL_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEALL_CHAINCODE_2);
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

	private static final String _FINDER_COLUMN_CHAINCODEALL_STDID_2 = "chainStandards.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_CHAINCODEALL_CHAINCODE_1 = "chainStandards.id.chainCode IS NULL";
	private static final String _FINDER_COLUMN_CHAINCODEALL_CHAINCODE_2 = "chainStandards.id.chainCode = ?";
	private static final String _FINDER_COLUMN_CHAINCODEALL_CHAINCODE_3 = "(chainStandards.id.chainCode IS NULL OR chainStandards.id.chainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdIdAll",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDALL =
		new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdIdAll",
			new String[] { Long.class.getName() },
			ChainStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDALL = new FinderPath(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdIdAll",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the chain standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findByStdIdAll(long stdId)
		throws SystemException {
		return findByStdIdAll(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chain standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of chain standardses
	 * @param end the upper bound of the range of chain standardses (not inclusive)
	 * @return the range of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findByStdIdAll(long stdId, int start, int end)
		throws SystemException {
		return findByStdIdAll(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of chain standardses
	 * @param end the upper bound of the range of chain standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findByStdIdAll(long stdId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDALL;
			finderArgs = new Object[] { stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDALL;
			finderArgs = new Object[] { stdId, start, end, orderByComparator };
		}

		List<ChainStandards> list = (List<ChainStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChainStandards chainStandards : list) {
				if ((stdId != chainStandards.getStdId())) {
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

			query.append(_SQL_SELECT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDIDALL_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChainStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<ChainStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainStandards>(list);
				}
				else {
					list = (List<ChainStandards>)QueryUtil.list(q,
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
	 * Returns the first chain standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByStdIdAll_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByStdIdAll_First(stdId,
				orderByComparator);

		if (chainStandards != null) {
			return chainStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainStandardsException(msg.toString());
	}

	/**
	 * Returns the first chain standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByStdIdAll_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChainStandards> list = findByStdIdAll(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chain standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByStdIdAll_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByStdIdAll_Last(stdId,
				orderByComparator);

		if (chainStandards != null) {
			return chainStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainStandardsException(msg.toString());
	}

	/**
	 * Returns the last chain standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain standards, or <code>null</code> if a matching chain standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByStdIdAll_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdIdAll(stdId);

		if (count == 0) {
			return null;
		}

		List<ChainStandards> list = findByStdIdAll(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chain standardses before and after the current chain standards in the ordered set where stdId = &#63;.
	 *
	 * @param chainStandardsPK the primary key of the current chain standards
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards[] findByStdIdAll_PrevAndNext(
		ChainStandardsPK chainStandardsPK, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = findByPrimaryKey(chainStandardsPK);

		Session session = null;

		try {
			session = openSession();

			ChainStandards[] array = new ChainStandardsImpl[3];

			array[0] = getByStdIdAll_PrevAndNext(session, chainStandards,
					stdId, orderByComparator, true);

			array[1] = chainStandards;

			array[2] = getByStdIdAll_PrevAndNext(session, chainStandards,
					stdId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChainStandards getByStdIdAll_PrevAndNext(Session session,
		ChainStandards chainStandards, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHAINSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDIDALL_STDID_2);

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
			query.append(ChainStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chainStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChainStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chain standardses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdIdAll(long stdId) throws SystemException {
		for (ChainStandards chainStandards : findByStdIdAll(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chainStandards);
		}
	}

	/**
	 * Returns the number of chain standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdAll(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDALL;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHAINSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDIDALL_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_STDIDALL_STDID_2 = "chainStandards.id.stdId = ?";

	public ChainStandardsPersistenceImpl() {
		setModelClass(ChainStandards.class);
	}

	/**
	 * Caches the chain standards in the entity cache if it is enabled.
	 *
	 * @param chainStandards the chain standards
	 */
	@Override
	public void cacheResult(ChainStandards chainStandards) {
		EntityCacheUtil.putResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsImpl.class, chainStandards.getPrimaryKey(),
			chainStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODE,
			new Object[] {
				chainStandards.getStdId(), chainStandards.getChainCode(),
				chainStandards.getIsActive()
			}, chainStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODEALL,
			new Object[] {
				chainStandards.getStdId(), chainStandards.getChainCode()
			}, chainStandards);

		chainStandards.resetOriginalValues();
	}

	/**
	 * Caches the chain standardses in the entity cache if it is enabled.
	 *
	 * @param chainStandardses the chain standardses
	 */
	@Override
	public void cacheResult(List<ChainStandards> chainStandardses) {
		for (ChainStandards chainStandards : chainStandardses) {
			if (EntityCacheUtil.getResult(
						ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ChainStandardsImpl.class, chainStandards.getPrimaryKey()) == null) {
				cacheResult(chainStandards);
			}
			else {
				chainStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chain standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChainStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChainStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chain standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChainStandards chainStandards) {
		EntityCacheUtil.removeResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsImpl.class, chainStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(chainStandards);
	}

	@Override
	public void clearCache(List<ChainStandards> chainStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChainStandards chainStandards : chainStandardses) {
			EntityCacheUtil.removeResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ChainStandardsImpl.class, chainStandards.getPrimaryKey());

			clearUniqueFindersCache(chainStandards);
		}
	}

	protected void cacheUniqueFindersCache(ChainStandards chainStandards) {
		if (chainStandards.isNew()) {
			Object[] args = new Object[] {
					chainStandards.getStdId(), chainStandards.getChainCode(),
					chainStandards.getIsActive()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHAINCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODE, args,
				chainStandards);

			args = new Object[] {
					chainStandards.getStdId(), chainStandards.getChainCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHAINCODEALL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODEALL, args,
				chainStandards);
		}
		else {
			ChainStandardsModelImpl chainStandardsModelImpl = (ChainStandardsModelImpl)chainStandards;

			if ((chainStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CHAINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chainStandards.getStdId(), chainStandards.getChainCode(),
						chainStandards.getIsActive()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHAINCODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODE, args,
					chainStandards);
			}

			if ((chainStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CHAINCODEALL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chainStandards.getStdId(), chainStandards.getChainCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHAINCODEALL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHAINCODEALL,
					args, chainStandards);
			}
		}
	}

	protected void clearUniqueFindersCache(ChainStandards chainStandards) {
		ChainStandardsModelImpl chainStandardsModelImpl = (ChainStandardsModelImpl)chainStandards;

		Object[] args = new Object[] {
				chainStandards.getStdId(), chainStandards.getChainCode(),
				chainStandards.getIsActive()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAINCODE, args);

		if ((chainStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CHAINCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					chainStandardsModelImpl.getOriginalStdId(),
					chainStandardsModelImpl.getOriginalChainCode(),
					chainStandardsModelImpl.getOriginalIsActive()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAINCODE, args);
		}

		args = new Object[] {
				chainStandards.getStdId(), chainStandards.getChainCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODEALL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAINCODEALL, args);

		if ((chainStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CHAINCODEALL.getColumnBitmask()) != 0) {
			args = new Object[] {
					chainStandardsModelImpl.getOriginalStdId(),
					chainStandardsModelImpl.getOriginalChainCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODEALL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHAINCODEALL, args);
		}
	}

	/**
	 * Creates a new chain standards with the primary key. Does not add the chain standards to the database.
	 *
	 * @param chainStandardsPK the primary key for the new chain standards
	 * @return the new chain standards
	 */
	@Override
	public ChainStandards create(ChainStandardsPK chainStandardsPK) {
		ChainStandards chainStandards = new ChainStandardsImpl();

		chainStandards.setNew(true);
		chainStandards.setPrimaryKey(chainStandardsPK);

		return chainStandards;
	}

	/**
	 * Removes the chain standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chainStandardsPK the primary key of the chain standards
	 * @return the chain standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards remove(ChainStandardsPK chainStandardsPK)
		throws NoSuchChainStandardsException, SystemException {
		return remove((Serializable)chainStandardsPK);
	}

	/**
	 * Removes the chain standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chain standards
	 * @return the chain standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards remove(Serializable primaryKey)
		throws NoSuchChainStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChainStandards chainStandards = (ChainStandards)session.get(ChainStandardsImpl.class,
					primaryKey);

			if (chainStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChainStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chainStandards);
		}
		catch (NoSuchChainStandardsException nsee) {
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
	protected ChainStandards removeImpl(ChainStandards chainStandards)
		throws SystemException {
		chainStandards = toUnwrappedModel(chainStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chainStandards)) {
				chainStandards = (ChainStandards)session.get(ChainStandardsImpl.class,
						chainStandards.getPrimaryKeyObj());
			}

			if (chainStandards != null) {
				session.delete(chainStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chainStandards != null) {
			clearCache(chainStandards);
		}

		return chainStandards;
	}

	@Override
	public ChainStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws SystemException {
		chainStandards = toUnwrappedModel(chainStandards);

		boolean isNew = chainStandards.isNew();

		ChainStandardsModelImpl chainStandardsModelImpl = (ChainStandardsModelImpl)chainStandards;

		Session session = null;

		try {
			session = openSession();

			if (chainStandards.isNew()) {
				session.save(chainStandards);

				chainStandards.setNew(false);
			}
			else {
				session.merge(chainStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChainStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chainStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chainStandardsModelImpl.getOriginalStdId(),
						chainStandardsModelImpl.getOriginalIsActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] {
						chainStandardsModelImpl.getStdId(),
						chainStandardsModelImpl.getIsActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((chainStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDALL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chainStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDALL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDALL,
					args);

				args = new Object[] { chainStandardsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDALL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDALL,
					args);
			}
		}

		EntityCacheUtil.putResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainStandardsImpl.class, chainStandards.getPrimaryKey(),
			chainStandards);

		clearUniqueFindersCache(chainStandards);
		cacheUniqueFindersCache(chainStandards);

		return chainStandards;
	}

	protected ChainStandards toUnwrappedModel(ChainStandards chainStandards) {
		if (chainStandards instanceof ChainStandardsImpl) {
			return chainStandards;
		}

		ChainStandardsImpl chainStandardsImpl = new ChainStandardsImpl();

		chainStandardsImpl.setNew(chainStandards.isNew());
		chainStandardsImpl.setPrimaryKey(chainStandards.getPrimaryKey());

		chainStandardsImpl.setChainCode(chainStandards.getChainCode());
		chainStandardsImpl.setStdId(chainStandards.getStdId());
		chainStandardsImpl.setStatusId(chainStandards.getStatusId());
		chainStandardsImpl.setIsActive(chainStandards.getIsActive());
		chainStandardsImpl.setLastPublishedDate(chainStandards.getLastPublishedDate());
		chainStandardsImpl.setCreatorId(chainStandards.getCreatorId());
		chainStandardsImpl.setCreatedDate(chainStandards.getCreatedDate());
		chainStandardsImpl.setUpdatedBy(chainStandards.getUpdatedBy());
		chainStandardsImpl.setUpdatedDate(chainStandards.getUpdatedDate());

		return chainStandardsImpl;
	}

	/**
	 * Returns the chain standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chain standards
	 * @return the chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChainStandardsException, SystemException {
		ChainStandards chainStandards = fetchByPrimaryKey(primaryKey);

		if (chainStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChainStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chainStandards;
	}

	/**
	 * Returns the chain standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainStandardsException} if it could not be found.
	 *
	 * @param chainStandardsPK the primary key of the chain standards
	 * @return the chain standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards findByPrimaryKey(ChainStandardsPK chainStandardsPK)
		throws NoSuchChainStandardsException, SystemException {
		return findByPrimaryKey((Serializable)chainStandardsPK);
	}

	/**
	 * Returns the chain standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chain standards
	 * @return the chain standards, or <code>null</code> if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChainStandards chainStandards = (ChainStandards)EntityCacheUtil.getResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ChainStandardsImpl.class, primaryKey);

		if (chainStandards == _nullChainStandards) {
			return null;
		}

		if (chainStandards == null) {
			Session session = null;

			try {
				session = openSession();

				chainStandards = (ChainStandards)session.get(ChainStandardsImpl.class,
						primaryKey);

				if (chainStandards != null) {
					cacheResult(chainStandards);
				}
				else {
					EntityCacheUtil.putResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ChainStandardsImpl.class, primaryKey,
						_nullChainStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChainStandardsModelImpl.ENTITY_CACHE_ENABLED,
					ChainStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chainStandards;
	}

	/**
	 * Returns the chain standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chainStandardsPK the primary key of the chain standards
	 * @return the chain standards, or <code>null</code> if a chain standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainStandards fetchByPrimaryKey(ChainStandardsPK chainStandardsPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)chainStandardsPK);
	}

	/**
	 * Returns all the chain standardses.
	 *
	 * @return the chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chain standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chain standardses
	 * @param end the upper bound of the range of chain standardses (not inclusive)
	 * @return the range of chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chain standardses
	 * @param end the upper bound of the range of chain standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chain standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainStandards> findAll(int start, int end,
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

		List<ChainStandards> list = (List<ChainStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHAINSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHAINSTANDARDS;

				if (pagination) {
					sql = sql.concat(ChainStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChainStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainStandards>(list);
				}
				else {
					list = (List<ChainStandards>)QueryUtil.list(q,
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
	 * Removes all the chain standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChainStandards chainStandards : findAll()) {
			remove(chainStandards);
		}
	}

	/**
	 * Returns the number of chain standardses.
	 *
	 * @return the number of chain standardses
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

				Query q = session.createQuery(_SQL_COUNT_CHAINSTANDARDS);

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
	 * Initializes the chain standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.ChainStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChainStandards>> listenersList = new ArrayList<ModelListener<ChainStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChainStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChainStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHAINSTANDARDS = "SELECT chainStandards FROM ChainStandards chainStandards";
	private static final String _SQL_SELECT_CHAINSTANDARDS_WHERE = "SELECT chainStandards FROM ChainStandards chainStandards WHERE ";
	private static final String _SQL_COUNT_CHAINSTANDARDS = "SELECT COUNT(chainStandards) FROM ChainStandards chainStandards";
	private static final String _SQL_COUNT_CHAINSTANDARDS_WHERE = "SELECT COUNT(chainStandards) FROM ChainStandards chainStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chainStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChainStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChainStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChainStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"chainCode", "stdId", "statusId", "isActive",
				"lastPublishedDate", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static ChainStandards _nullChainStandards = new ChainStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChainStandards> toCacheModel() {
				return _nullChainStandardsCacheModel;
			}
		};

	private static CacheModel<ChainStandards> _nullChainStandardsCacheModel = new CacheModel<ChainStandards>() {
			@Override
			public ChainStandards toEntityModel() {
				return _nullChainStandards;
			}
		};
}