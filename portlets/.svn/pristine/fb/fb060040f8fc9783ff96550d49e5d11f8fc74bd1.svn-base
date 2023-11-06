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

import com.ihg.brandstandards.db.NoSuchFlagCategoryException;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.impl.FlagCategoryImpl;
import com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl;

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
 * The persistence implementation for the flag category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see FlagCategoryPersistence
 * @see FlagCategoryUtil
 * @generated
 */
public class FlagCategoryPersistenceImpl extends BasePersistenceImpl<FlagCategory>
	implements FlagCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlagCategoryUtil} to access the flag category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlagCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, FlagCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, FlagCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTCATID =
		new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, FlagCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparentCatId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATID =
		new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, FlagCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparentCatId",
			new String[] { Long.class.getName(), String.class.getName() },
			FlagCategoryModelImpl.PARENTCATID_COLUMN_BITMASK |
			FlagCategoryModelImpl.ACTIVEIND_COLUMN_BITMASK |
			FlagCategoryModelImpl.ORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTCATID = new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByparentCatId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @return the matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findByparentCatId(long parentCatId,
		String activeInd) throws SystemException {
		return findByparentCatId(parentCatId, activeInd, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of flag categories
	 * @param end the upper bound of the range of flag categories (not inclusive)
	 * @return the range of matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findByparentCatId(long parentCatId,
		String activeInd, int start, int end) throws SystemException {
		return findByparentCatId(parentCatId, activeInd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of flag categories
	 * @param end the upper bound of the range of flag categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findByparentCatId(long parentCatId,
		String activeInd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATID;
			finderArgs = new Object[] { parentCatId, activeInd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTCATID;
			finderArgs = new Object[] {
					parentCatId, activeInd,
					
					start, end, orderByComparator
				};
		}

		List<FlagCategory> list = (List<FlagCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlagCategory flagCategory : list) {
				if ((parentCatId != flagCategory.getParentCatId()) ||
						!Validator.equals(activeInd, flagCategory.getActiveInd())) {
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

			query.append(_SQL_SELECT_FLAGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTCATID_PARENTCATID_2);

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlagCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentCatId);

				if (bindActiveInd) {
					qPos.add(activeInd);
				}

				if (!pagination) {
					list = (List<FlagCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlagCategory>(list);
				}
				else {
					list = (List<FlagCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory findByparentCatId_First(long parentCatId,
		String activeInd, OrderByComparator orderByComparator)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = fetchByparentCatId_First(parentCatId,
				activeInd, orderByComparator);

		if (flagCategory != null) {
			return flagCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentCatId=");
		msg.append(parentCatId);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlagCategoryException(msg.toString());
	}

	/**
	 * Returns the first flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flag category, or <code>null</code> if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory fetchByparentCatId_First(long parentCatId,
		String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlagCategory> list = findByparentCatId(parentCatId, activeInd, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory findByparentCatId_Last(long parentCatId,
		String activeInd, OrderByComparator orderByComparator)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = fetchByparentCatId_Last(parentCatId,
				activeInd, orderByComparator);

		if (flagCategory != null) {
			return flagCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentCatId=");
		msg.append(parentCatId);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlagCategoryException(msg.toString());
	}

	/**
	 * Returns the last flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flag category, or <code>null</code> if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory fetchByparentCatId_Last(long parentCatId,
		String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByparentCatId(parentCatId, activeInd);

		if (count == 0) {
			return null;
		}

		List<FlagCategory> list = findByparentCatId(parentCatId, activeInd,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flag categories before and after the current flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param flagCategoryPK the primary key of the current flag category
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory[] findByparentCatId_PrevAndNext(
		FlagCategoryPK flagCategoryPK, long parentCatId, String activeInd,
		OrderByComparator orderByComparator)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = findByPrimaryKey(flagCategoryPK);

		Session session = null;

		try {
			session = openSession();

			FlagCategory[] array = new FlagCategoryImpl[3];

			array[0] = getByparentCatId_PrevAndNext(session, flagCategory,
					parentCatId, activeInd, orderByComparator, true);

			array[1] = flagCategory;

			array[2] = getByparentCatId_PrevAndNext(session, flagCategory,
					parentCatId, activeInd, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlagCategory getByparentCatId_PrevAndNext(Session session,
		FlagCategory flagCategory, long parentCatId, String activeInd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLAGCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTCATID_PARENTCATID_2);

		boolean bindActiveInd = false;

		if (activeInd == null) {
			query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_1);
		}
		else if (activeInd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_3);
		}
		else {
			bindActiveInd = true;

			query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_2);
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
			query.append(FlagCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentCatId);

		if (bindActiveInd) {
			qPos.add(activeInd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flagCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlagCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flag categories where parentCatId = &#63; and activeInd = &#63; from the database.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentCatId(long parentCatId, String activeInd)
		throws SystemException {
		for (FlagCategory flagCategory : findByparentCatId(parentCatId,
				activeInd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flagCategory);
		}
	}

	/**
	 * Returns the number of flag categories where parentCatId = &#63; and activeInd = &#63;.
	 *
	 * @param parentCatId the parent cat ID
	 * @param activeInd the active ind
	 * @return the number of matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentCatId(long parentCatId, String activeInd)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTCATID;

		Object[] finderArgs = new Object[] { parentCatId, activeInd };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLAGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTCATID_PARENTCATID_2);

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_PARENTCATID_ACTIVEIND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentCatId);

				if (bindActiveInd) {
					qPos.add(activeInd);
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

	private static final String _FINDER_COLUMN_PARENTCATID_PARENTCATID_2 = "flagCategory.parentCatId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTCATID_ACTIVEIND_1 = "flagCategory.id.activeInd IS NULL";
	private static final String _FINDER_COLUMN_PARENTCATID_ACTIVEIND_2 = "flagCategory.id.activeInd = ?";
	private static final String _FINDER_COLUMN_PARENTCATID_ACTIVEIND_3 = "(flagCategory.id.activeInd IS NULL OR flagCategory.id.activeInd = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATORFIELD =
		new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, FlagCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycatOrField",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATORFIELD =
		new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, FlagCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycatOrField",
			new String[] { String.class.getName(), String.class.getName() },
			FlagCategoryModelImpl.CATORFIELD_COLUMN_BITMASK |
			FlagCategoryModelImpl.ACTIVEIND_COLUMN_BITMASK |
			FlagCategoryModelImpl.ORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATORFIELD = new FinderPath(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycatOrField",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the flag categories where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @return the matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findBycatOrField(String catOrField,
		String activeInd) throws SystemException {
		return findBycatOrField(catOrField, activeInd, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flag categories where catOrField = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of flag categories
	 * @param end the upper bound of the range of flag categories (not inclusive)
	 * @return the range of matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findBycatOrField(String catOrField,
		String activeInd, int start, int end) throws SystemException {
		return findBycatOrField(catOrField, activeInd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flag categories where catOrField = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of flag categories
	 * @param end the upper bound of the range of flag categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findBycatOrField(String catOrField,
		String activeInd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATORFIELD;
			finderArgs = new Object[] { catOrField, activeInd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATORFIELD;
			finderArgs = new Object[] {
					catOrField, activeInd,
					
					start, end, orderByComparator
				};
		}

		List<FlagCategory> list = (List<FlagCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlagCategory flagCategory : list) {
				if (!Validator.equals(catOrField, flagCategory.getCatOrField()) ||
						!Validator.equals(activeInd, flagCategory.getActiveInd())) {
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

			query.append(_SQL_SELECT_FLAGCATEGORY_WHERE);

			boolean bindCatOrField = false;

			if (catOrField == null) {
				query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_1);
			}
			else if (catOrField.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_3);
			}
			else {
				bindCatOrField = true;

				query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_2);
			}

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlagCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCatOrField) {
					qPos.add(catOrField);
				}

				if (bindActiveInd) {
					qPos.add(activeInd);
				}

				if (!pagination) {
					list = (List<FlagCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlagCategory>(list);
				}
				else {
					list = (List<FlagCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory findBycatOrField_First(String catOrField,
		String activeInd, OrderByComparator orderByComparator)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = fetchBycatOrField_First(catOrField,
				activeInd, orderByComparator);

		if (flagCategory != null) {
			return flagCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catOrField=");
		msg.append(catOrField);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlagCategoryException(msg.toString());
	}

	/**
	 * Returns the first flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flag category, or <code>null</code> if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory fetchBycatOrField_First(String catOrField,
		String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlagCategory> list = findBycatOrField(catOrField, activeInd, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory findBycatOrField_Last(String catOrField,
		String activeInd, OrderByComparator orderByComparator)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = fetchBycatOrField_Last(catOrField,
				activeInd, orderByComparator);

		if (flagCategory != null) {
			return flagCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catOrField=");
		msg.append(catOrField);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlagCategoryException(msg.toString());
	}

	/**
	 * Returns the last flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flag category, or <code>null</code> if a matching flag category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory fetchBycatOrField_Last(String catOrField,
		String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBycatOrField(catOrField, activeInd);

		if (count == 0) {
			return null;
		}

		List<FlagCategory> list = findBycatOrField(catOrField, activeInd,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flag categories before and after the current flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param flagCategoryPK the primary key of the current flag category
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory[] findBycatOrField_PrevAndNext(
		FlagCategoryPK flagCategoryPK, String catOrField, String activeInd,
		OrderByComparator orderByComparator)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = findByPrimaryKey(flagCategoryPK);

		Session session = null;

		try {
			session = openSession();

			FlagCategory[] array = new FlagCategoryImpl[3];

			array[0] = getBycatOrField_PrevAndNext(session, flagCategory,
					catOrField, activeInd, orderByComparator, true);

			array[1] = flagCategory;

			array[2] = getBycatOrField_PrevAndNext(session, flagCategory,
					catOrField, activeInd, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlagCategory getBycatOrField_PrevAndNext(Session session,
		FlagCategory flagCategory, String catOrField, String activeInd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLAGCATEGORY_WHERE);

		boolean bindCatOrField = false;

		if (catOrField == null) {
			query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_1);
		}
		else if (catOrField.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_3);
		}
		else {
			bindCatOrField = true;

			query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_2);
		}

		boolean bindActiveInd = false;

		if (activeInd == null) {
			query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_1);
		}
		else if (activeInd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_3);
		}
		else {
			bindActiveInd = true;

			query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_2);
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
			query.append(FlagCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCatOrField) {
			qPos.add(catOrField);
		}

		if (bindActiveInd) {
			qPos.add(activeInd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flagCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlagCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flag categories where catOrField = &#63; and activeInd = &#63; from the database.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycatOrField(String catOrField, String activeInd)
		throws SystemException {
		for (FlagCategory flagCategory : findBycatOrField(catOrField,
				activeInd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flagCategory);
		}
	}

	/**
	 * Returns the number of flag categories where catOrField = &#63; and activeInd = &#63;.
	 *
	 * @param catOrField the cat or field
	 * @param activeInd the active ind
	 * @return the number of matching flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycatOrField(String catOrField, String activeInd)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATORFIELD;

		Object[] finderArgs = new Object[] { catOrField, activeInd };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLAGCATEGORY_WHERE);

			boolean bindCatOrField = false;

			if (catOrField == null) {
				query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_1);
			}
			else if (catOrField.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_3);
			}
			else {
				bindCatOrField = true;

				query.append(_FINDER_COLUMN_CATORFIELD_CATORFIELD_2);
			}

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_CATORFIELD_ACTIVEIND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCatOrField) {
					qPos.add(catOrField);
				}

				if (bindActiveInd) {
					qPos.add(activeInd);
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

	private static final String _FINDER_COLUMN_CATORFIELD_CATORFIELD_1 = "flagCategory.catOrField IS NULL AND ";
	private static final String _FINDER_COLUMN_CATORFIELD_CATORFIELD_2 = "flagCategory.catOrField = ? AND ";
	private static final String _FINDER_COLUMN_CATORFIELD_CATORFIELD_3 = "(flagCategory.catOrField IS NULL OR flagCategory.catOrField = '') AND ";
	private static final String _FINDER_COLUMN_CATORFIELD_ACTIVEIND_1 = "flagCategory.id.activeInd IS NULL";
	private static final String _FINDER_COLUMN_CATORFIELD_ACTIVEIND_2 = "flagCategory.id.activeInd = ?";
	private static final String _FINDER_COLUMN_CATORFIELD_ACTIVEIND_3 = "(flagCategory.id.activeInd IS NULL OR flagCategory.id.activeInd = '')";

	public FlagCategoryPersistenceImpl() {
		setModelClass(FlagCategory.class);
	}

	/**
	 * Caches the flag category in the entity cache if it is enabled.
	 *
	 * @param flagCategory the flag category
	 */
	@Override
	public void cacheResult(FlagCategory flagCategory) {
		EntityCacheUtil.putResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryImpl.class, flagCategory.getPrimaryKey(), flagCategory);

		flagCategory.resetOriginalValues();
	}

	/**
	 * Caches the flag categories in the entity cache if it is enabled.
	 *
	 * @param flagCategories the flag categories
	 */
	@Override
	public void cacheResult(List<FlagCategory> flagCategories) {
		for (FlagCategory flagCategory : flagCategories) {
			if (EntityCacheUtil.getResult(
						FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
						FlagCategoryImpl.class, flagCategory.getPrimaryKey()) == null) {
				cacheResult(flagCategory);
			}
			else {
				flagCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flag categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlagCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlagCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flag category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlagCategory flagCategory) {
		EntityCacheUtil.removeResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryImpl.class, flagCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlagCategory> flagCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlagCategory flagCategory : flagCategories) {
			EntityCacheUtil.removeResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
				FlagCategoryImpl.class, flagCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flag category with the primary key. Does not add the flag category to the database.
	 *
	 * @param flagCategoryPK the primary key for the new flag category
	 * @return the new flag category
	 */
	@Override
	public FlagCategory create(FlagCategoryPK flagCategoryPK) {
		FlagCategory flagCategory = new FlagCategoryImpl();

		flagCategory.setNew(true);
		flagCategory.setPrimaryKey(flagCategoryPK);

		return flagCategory;
	}

	/**
	 * Removes the flag category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flagCategoryPK the primary key of the flag category
	 * @return the flag category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory remove(FlagCategoryPK flagCategoryPK)
		throws NoSuchFlagCategoryException, SystemException {
		return remove((Serializable)flagCategoryPK);
	}

	/**
	 * Removes the flag category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flag category
	 * @return the flag category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory remove(Serializable primaryKey)
		throws NoSuchFlagCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlagCategory flagCategory = (FlagCategory)session.get(FlagCategoryImpl.class,
					primaryKey);

			if (flagCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlagCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flagCategory);
		}
		catch (NoSuchFlagCategoryException nsee) {
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
	protected FlagCategory removeImpl(FlagCategory flagCategory)
		throws SystemException {
		flagCategory = toUnwrappedModel(flagCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flagCategory)) {
				flagCategory = (FlagCategory)session.get(FlagCategoryImpl.class,
						flagCategory.getPrimaryKeyObj());
			}

			if (flagCategory != null) {
				session.delete(flagCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flagCategory != null) {
			clearCache(flagCategory);
		}

		return flagCategory;
	}

	@Override
	public FlagCategory updateImpl(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory)
		throws SystemException {
		flagCategory = toUnwrappedModel(flagCategory);

		boolean isNew = flagCategory.isNew();

		FlagCategoryModelImpl flagCategoryModelImpl = (FlagCategoryModelImpl)flagCategory;

		Session session = null;

		try {
			session = openSession();

			if (flagCategory.isNew()) {
				session.save(flagCategory);

				flagCategory.setNew(false);
			}
			else {
				session.merge(flagCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlagCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flagCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flagCategoryModelImpl.getOriginalParentCatId(),
						flagCategoryModelImpl.getOriginalActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTCATID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATID,
					args);

				args = new Object[] {
						flagCategoryModelImpl.getParentCatId(),
						flagCategoryModelImpl.getActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTCATID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATID,
					args);
			}

			if ((flagCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATORFIELD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flagCategoryModelImpl.getOriginalCatOrField(),
						flagCategoryModelImpl.getOriginalActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATORFIELD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATORFIELD,
					args);

				args = new Object[] {
						flagCategoryModelImpl.getCatOrField(),
						flagCategoryModelImpl.getActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATORFIELD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATORFIELD,
					args);
			}
		}

		EntityCacheUtil.putResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FlagCategoryImpl.class, flagCategory.getPrimaryKey(), flagCategory);

		return flagCategory;
	}

	protected FlagCategory toUnwrappedModel(FlagCategory flagCategory) {
		if (flagCategory instanceof FlagCategoryImpl) {
			return flagCategory;
		}

		FlagCategoryImpl flagCategoryImpl = new FlagCategoryImpl();

		flagCategoryImpl.setNew(flagCategory.isNew());
		flagCategoryImpl.setPrimaryKey(flagCategory.getPrimaryKey());

		flagCategoryImpl.setFlagCatId(flagCategory.getFlagCatId());
		flagCategoryImpl.setActiveInd(flagCategory.getActiveInd());
		flagCategoryImpl.setParentCatId(flagCategory.getParentCatId());
		flagCategoryImpl.setCatOrField(flagCategory.getCatOrField());
		flagCategoryImpl.setTxtValue(flagCategory.getTxtValue());
		flagCategoryImpl.setOrderNumber(flagCategory.getOrderNumber());
		flagCategoryImpl.setCreatorId(flagCategory.getCreatorId());
		flagCategoryImpl.setCreatedDate(flagCategory.getCreatedDate());
		flagCategoryImpl.setUpdatedBy(flagCategory.getUpdatedBy());
		flagCategoryImpl.setUpdatedDate(flagCategory.getUpdatedDate());

		return flagCategoryImpl;
	}

	/**
	 * Returns the flag category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flag category
	 * @return the flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlagCategoryException, SystemException {
		FlagCategory flagCategory = fetchByPrimaryKey(primaryKey);

		if (flagCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlagCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flagCategory;
	}

	/**
	 * Returns the flag category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchFlagCategoryException} if it could not be found.
	 *
	 * @param flagCategoryPK the primary key of the flag category
	 * @return the flag category
	 * @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory findByPrimaryKey(FlagCategoryPK flagCategoryPK)
		throws NoSuchFlagCategoryException, SystemException {
		return findByPrimaryKey((Serializable)flagCategoryPK);
	}

	/**
	 * Returns the flag category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flag category
	 * @return the flag category, or <code>null</code> if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlagCategory flagCategory = (FlagCategory)EntityCacheUtil.getResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
				FlagCategoryImpl.class, primaryKey);

		if (flagCategory == _nullFlagCategory) {
			return null;
		}

		if (flagCategory == null) {
			Session session = null;

			try {
				session = openSession();

				flagCategory = (FlagCategory)session.get(FlagCategoryImpl.class,
						primaryKey);

				if (flagCategory != null) {
					cacheResult(flagCategory);
				}
				else {
					EntityCacheUtil.putResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
						FlagCategoryImpl.class, primaryKey, _nullFlagCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlagCategoryModelImpl.ENTITY_CACHE_ENABLED,
					FlagCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flagCategory;
	}

	/**
	 * Returns the flag category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param flagCategoryPK the primary key of the flag category
	 * @return the flag category, or <code>null</code> if a flag category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagCategory fetchByPrimaryKey(FlagCategoryPK flagCategoryPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)flagCategoryPK);
	}

	/**
	 * Returns all the flag categories.
	 *
	 * @return the flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flag categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flag categories
	 * @param end the upper bound of the range of flag categories (not inclusive)
	 * @return the range of flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flag categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flag categories
	 * @param end the upper bound of the range of flag categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flag categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagCategory> findAll(int start, int end,
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

		List<FlagCategory> list = (List<FlagCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLAGCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLAGCATEGORY;

				if (pagination) {
					sql = sql.concat(FlagCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlagCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlagCategory>(list);
				}
				else {
					list = (List<FlagCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flag categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlagCategory flagCategory : findAll()) {
			remove(flagCategory);
		}
	}

	/**
	 * Returns the number of flag categories.
	 *
	 * @return the number of flag categories
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

				Query q = session.createQuery(_SQL_COUNT_FLAGCATEGORY);

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
	 * Initializes the flag category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.FlagCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlagCategory>> listenersList = new ArrayList<ModelListener<FlagCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlagCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlagCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLAGCATEGORY = "SELECT flagCategory FROM FlagCategory flagCategory";
	private static final String _SQL_SELECT_FLAGCATEGORY_WHERE = "SELECT flagCategory FROM FlagCategory flagCategory WHERE ";
	private static final String _SQL_COUNT_FLAGCATEGORY = "SELECT COUNT(flagCategory) FROM FlagCategory flagCategory";
	private static final String _SQL_COUNT_FLAGCATEGORY_WHERE = "SELECT COUNT(flagCategory) FROM FlagCategory flagCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flagCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlagCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlagCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlagCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"flagCatId", "activeInd", "parentCatId", "catOrField",
				"txtValue", "orderNumber", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static FlagCategory _nullFlagCategory = new FlagCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlagCategory> toCacheModel() {
				return _nullFlagCategoryCacheModel;
			}
		};

	private static CacheModel<FlagCategory> _nullFlagCategoryCacheModel = new CacheModel<FlagCategory>() {
			@Override
			public FlagCategory toEntityModel() {
				return _nullFlagCategory;
			}
		};
}