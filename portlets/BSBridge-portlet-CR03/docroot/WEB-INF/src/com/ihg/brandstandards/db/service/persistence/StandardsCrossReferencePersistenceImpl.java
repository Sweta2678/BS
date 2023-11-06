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

import com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException;
import com.ihg.brandstandards.db.model.StandardsCrossReference;
import com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceImpl;
import com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the standards cross reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCrossReferencePersistence
 * @see StandardsCrossReferenceUtil
 * @generated
 */
public class StandardsCrossReferencePersistenceImpl extends BasePersistenceImpl<StandardsCrossReference>
	implements StandardsCrossReferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsCrossReferenceUtil} to access the standards cross reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsCrossReferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			StandardsCrossReferenceModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards cross references where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards cross references where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards cross references
	 * @param end the upper bound of the range of standards cross references (not inclusive)
	 * @return the range of matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findByStdId(long stdId, int start,
		int end) throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards cross references where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards cross references
	 * @param end the upper bound of the range of standards cross references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findByStdId(long stdId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId, start, end, orderByComparator };
		}

		List<StandardsCrossReference> list = (List<StandardsCrossReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCrossReference standardsCrossReference : list) {
				if ((stdId != standardsCrossReference.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSCROSSREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCrossReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsCrossReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCrossReference>(list);
				}
				else {
					list = (List<StandardsCrossReference>)QueryUtil.list(q,
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
	 * Returns the first standards cross reference in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = fetchByStdId_First(stdId,
				orderByComparator);

		if (standardsCrossReference != null) {
			return standardsCrossReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCrossReferenceException(msg.toString());
	}

	/**
	 * Returns the first standards cross reference in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsCrossReference> list = findByStdId(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards cross reference in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = fetchByStdId_Last(stdId,
				orderByComparator);

		if (standardsCrossReference != null) {
			return standardsCrossReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCrossReferenceException(msg.toString());
	}

	/**
	 * Returns the last standards cross reference in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsCrossReference> list = findByStdId(stdId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards cross references before and after the current standards cross reference in the ordered set where stdId = &#63;.
	 *
	 * @param standardsCrossReferencePK the primary key of the current standards cross reference
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference[] findByStdId_PrevAndNext(
		StandardsCrossReferencePK standardsCrossReferencePK, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = findByPrimaryKey(standardsCrossReferencePK);

		Session session = null;

		try {
			session = openSession();

			StandardsCrossReference[] array = new StandardsCrossReferenceImpl[3];

			array[0] = getByStdId_PrevAndNext(session, standardsCrossReference,
					stdId, orderByComparator, true);

			array[1] = standardsCrossReference;

			array[2] = getByStdId_PrevAndNext(session, standardsCrossReference,
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

	protected StandardsCrossReference getByStdId_PrevAndNext(Session session,
		StandardsCrossReference standardsCrossReference, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCROSSREFERENCE_WHERE);

		query.append(_FINDER_COLUMN_STDID_STDID_2);

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
			query.append(StandardsCrossReferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCrossReference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCrossReference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards cross references where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (StandardsCrossReference standardsCrossReference : findByStdId(
				stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsCrossReference);
		}
	}

	/**
	 * Returns the number of standards cross references where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSCROSSREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardsCrossReference.id.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REFSTDID = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrefStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFSTDID =
		new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrefStdId",
			new String[] { Long.class.getName() },
			StandardsCrossReferenceModelImpl.XREFSTDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REFSTDID = new FinderPath(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrefStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards cross references where xrefStdId = &#63;.
	 *
	 * @param xrefStdId the xref std ID
	 * @return the matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findByrefStdId(long xrefStdId)
		throws SystemException {
		return findByrefStdId(xrefStdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the standards cross references where xrefStdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param xrefStdId the xref std ID
	 * @param start the lower bound of the range of standards cross references
	 * @param end the upper bound of the range of standards cross references (not inclusive)
	 * @return the range of matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findByrefStdId(long xrefStdId,
		int start, int end) throws SystemException {
		return findByrefStdId(xrefStdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards cross references where xrefStdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param xrefStdId the xref std ID
	 * @param start the lower bound of the range of standards cross references
	 * @param end the upper bound of the range of standards cross references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findByrefStdId(long xrefStdId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFSTDID;
			finderArgs = new Object[] { xrefStdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REFSTDID;
			finderArgs = new Object[] { xrefStdId, start, end, orderByComparator };
		}

		List<StandardsCrossReference> list = (List<StandardsCrossReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCrossReference standardsCrossReference : list) {
				if ((xrefStdId != standardsCrossReference.getXrefStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSCROSSREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_REFSTDID_XREFSTDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCrossReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(xrefStdId);

				if (!pagination) {
					list = (List<StandardsCrossReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCrossReference>(list);
				}
				else {
					list = (List<StandardsCrossReference>)QueryUtil.list(q,
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
	 * Returns the first standards cross reference in the ordered set where xrefStdId = &#63;.
	 *
	 * @param xrefStdId the xref std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference findByrefStdId_First(long xrefStdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = fetchByrefStdId_First(xrefStdId,
				orderByComparator);

		if (standardsCrossReference != null) {
			return standardsCrossReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("xrefStdId=");
		msg.append(xrefStdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCrossReferenceException(msg.toString());
	}

	/**
	 * Returns the first standards cross reference in the ordered set where xrefStdId = &#63;.
	 *
	 * @param xrefStdId the xref std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference fetchByrefStdId_First(long xrefStdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsCrossReference> list = findByrefStdId(xrefStdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards cross reference in the ordered set where xrefStdId = &#63;.
	 *
	 * @param xrefStdId the xref std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference findByrefStdId_Last(long xrefStdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = fetchByrefStdId_Last(xrefStdId,
				orderByComparator);

		if (standardsCrossReference != null) {
			return standardsCrossReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("xrefStdId=");
		msg.append(xrefStdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCrossReferenceException(msg.toString());
	}

	/**
	 * Returns the last standards cross reference in the ordered set where xrefStdId = &#63;.
	 *
	 * @param xrefStdId the xref std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference fetchByrefStdId_Last(long xrefStdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByrefStdId(xrefStdId);

		if (count == 0) {
			return null;
		}

		List<StandardsCrossReference> list = findByrefStdId(xrefStdId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards cross references before and after the current standards cross reference in the ordered set where xrefStdId = &#63;.
	 *
	 * @param standardsCrossReferencePK the primary key of the current standards cross reference
	 * @param xrefStdId the xref std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference[] findByrefStdId_PrevAndNext(
		StandardsCrossReferencePK standardsCrossReferencePK, long xrefStdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = findByPrimaryKey(standardsCrossReferencePK);

		Session session = null;

		try {
			session = openSession();

			StandardsCrossReference[] array = new StandardsCrossReferenceImpl[3];

			array[0] = getByrefStdId_PrevAndNext(session,
					standardsCrossReference, xrefStdId, orderByComparator, true);

			array[1] = standardsCrossReference;

			array[2] = getByrefStdId_PrevAndNext(session,
					standardsCrossReference, xrefStdId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsCrossReference getByrefStdId_PrevAndNext(
		Session session, StandardsCrossReference standardsCrossReference,
		long xrefStdId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCROSSREFERENCE_WHERE);

		query.append(_FINDER_COLUMN_REFSTDID_XREFSTDID_2);

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
			query.append(StandardsCrossReferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(xrefStdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCrossReference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCrossReference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards cross references where xrefStdId = &#63; from the database.
	 *
	 * @param xrefStdId the xref std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrefStdId(long xrefStdId) throws SystemException {
		for (StandardsCrossReference standardsCrossReference : findByrefStdId(
				xrefStdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsCrossReference);
		}
	}

	/**
	 * Returns the number of standards cross references where xrefStdId = &#63;.
	 *
	 * @param xrefStdId the xref std ID
	 * @return the number of matching standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrefStdId(long xrefStdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REFSTDID;

		Object[] finderArgs = new Object[] { xrefStdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSCROSSREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_REFSTDID_XREFSTDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(xrefStdId);

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

	private static final String _FINDER_COLUMN_REFSTDID_XREFSTDID_2 = "standardsCrossReference.id.xrefStdId = ?";

	public StandardsCrossReferencePersistenceImpl() {
		setModelClass(StandardsCrossReference.class);
	}

	/**
	 * Caches the standards cross reference in the entity cache if it is enabled.
	 *
	 * @param standardsCrossReference the standards cross reference
	 */
	@Override
	public void cacheResult(StandardsCrossReference standardsCrossReference) {
		EntityCacheUtil.putResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			standardsCrossReference.getPrimaryKey(), standardsCrossReference);

		standardsCrossReference.resetOriginalValues();
	}

	/**
	 * Caches the standards cross references in the entity cache if it is enabled.
	 *
	 * @param standardsCrossReferences the standards cross references
	 */
	@Override
	public void cacheResult(
		List<StandardsCrossReference> standardsCrossReferences) {
		for (StandardsCrossReference standardsCrossReference : standardsCrossReferences) {
			if (EntityCacheUtil.getResult(
						StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCrossReferenceImpl.class,
						standardsCrossReference.getPrimaryKey()) == null) {
				cacheResult(standardsCrossReference);
			}
			else {
				standardsCrossReference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards cross references.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsCrossReferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsCrossReferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards cross reference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsCrossReference standardsCrossReference) {
		EntityCacheUtil.removeResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			standardsCrossReference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StandardsCrossReference> standardsCrossReferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsCrossReference standardsCrossReference : standardsCrossReferences) {
			EntityCacheUtil.removeResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCrossReferenceImpl.class,
				standardsCrossReference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards cross reference with the primary key. Does not add the standards cross reference to the database.
	 *
	 * @param standardsCrossReferencePK the primary key for the new standards cross reference
	 * @return the new standards cross reference
	 */
	@Override
	public StandardsCrossReference create(
		StandardsCrossReferencePK standardsCrossReferencePK) {
		StandardsCrossReference standardsCrossReference = new StandardsCrossReferenceImpl();

		standardsCrossReference.setNew(true);
		standardsCrossReference.setPrimaryKey(standardsCrossReferencePK);

		return standardsCrossReference;
	}

	/**
	 * Removes the standards cross reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCrossReferencePK the primary key of the standards cross reference
	 * @return the standards cross reference that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference remove(
		StandardsCrossReferencePK standardsCrossReferencePK)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		return remove((Serializable)standardsCrossReferencePK);
	}

	/**
	 * Removes the standards cross reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards cross reference
	 * @return the standards cross reference that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference remove(Serializable primaryKey)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsCrossReference standardsCrossReference = (StandardsCrossReference)session.get(StandardsCrossReferenceImpl.class,
					primaryKey);

			if (standardsCrossReference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsCrossReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsCrossReference);
		}
		catch (NoSuchStandardsCrossReferenceException nsee) {
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
	protected StandardsCrossReference removeImpl(
		StandardsCrossReference standardsCrossReference)
		throws SystemException {
		standardsCrossReference = toUnwrappedModel(standardsCrossReference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsCrossReference)) {
				standardsCrossReference = (StandardsCrossReference)session.get(StandardsCrossReferenceImpl.class,
						standardsCrossReference.getPrimaryKeyObj());
			}

			if (standardsCrossReference != null) {
				session.delete(standardsCrossReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsCrossReference != null) {
			clearCache(standardsCrossReference);
		}

		return standardsCrossReference;
	}

	@Override
	public StandardsCrossReference updateImpl(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference)
		throws SystemException {
		standardsCrossReference = toUnwrappedModel(standardsCrossReference);

		boolean isNew = standardsCrossReference.isNew();

		StandardsCrossReferenceModelImpl standardsCrossReferenceModelImpl = (StandardsCrossReferenceModelImpl)standardsCrossReference;

		Session session = null;

		try {
			session = openSession();

			if (standardsCrossReference.isNew()) {
				session.save(standardsCrossReference);

				standardsCrossReference.setNew(false);
			}
			else {
				session.merge(standardsCrossReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsCrossReferenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsCrossReferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCrossReferenceModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { standardsCrossReferenceModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((standardsCrossReferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCrossReferenceModelImpl.getOriginalXrefStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFSTDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFSTDID,
					args);

				args = new Object[] {
						standardsCrossReferenceModelImpl.getXrefStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFSTDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFSTDID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCrossReferenceImpl.class,
			standardsCrossReference.getPrimaryKey(), standardsCrossReference);

		return standardsCrossReference;
	}

	protected StandardsCrossReference toUnwrappedModel(
		StandardsCrossReference standardsCrossReference) {
		if (standardsCrossReference instanceof StandardsCrossReferenceImpl) {
			return standardsCrossReference;
		}

		StandardsCrossReferenceImpl standardsCrossReferenceImpl = new StandardsCrossReferenceImpl();

		standardsCrossReferenceImpl.setNew(standardsCrossReference.isNew());
		standardsCrossReferenceImpl.setPrimaryKey(standardsCrossReference.getPrimaryKey());

		standardsCrossReferenceImpl.setStdId(standardsCrossReference.getStdId());
		standardsCrossReferenceImpl.setXrefStdId(standardsCrossReference.getXrefStdId());
		standardsCrossReferenceImpl.setDispOrderNumber(standardsCrossReference.getDispOrderNumber());
		standardsCrossReferenceImpl.setCreatorId(standardsCrossReference.getCreatorId());
		standardsCrossReferenceImpl.setCreatedDate(standardsCrossReference.getCreatedDate());
		standardsCrossReferenceImpl.setUpdatedBy(standardsCrossReference.getUpdatedBy());
		standardsCrossReferenceImpl.setUpdatedDate(standardsCrossReference.getUpdatedDate());

		return standardsCrossReferenceImpl;
	}

	/**
	 * Returns the standards cross reference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards cross reference
	 * @return the standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		StandardsCrossReference standardsCrossReference = fetchByPrimaryKey(primaryKey);

		if (standardsCrossReference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsCrossReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsCrossReference;
	}

	/**
	 * Returns the standards cross reference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException} if it could not be found.
	 *
	 * @param standardsCrossReferencePK the primary key of the standards cross reference
	 * @return the standards cross reference
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference findByPrimaryKey(
		StandardsCrossReferencePK standardsCrossReferencePK)
		throws NoSuchStandardsCrossReferenceException, SystemException {
		return findByPrimaryKey((Serializable)standardsCrossReferencePK);
	}

	/**
	 * Returns the standards cross reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards cross reference
	 * @return the standards cross reference, or <code>null</code> if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsCrossReference standardsCrossReference = (StandardsCrossReference)EntityCacheUtil.getResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCrossReferenceImpl.class, primaryKey);

		if (standardsCrossReference == _nullStandardsCrossReference) {
			return null;
		}

		if (standardsCrossReference == null) {
			Session session = null;

			try {
				session = openSession();

				standardsCrossReference = (StandardsCrossReference)session.get(StandardsCrossReferenceImpl.class,
						primaryKey);

				if (standardsCrossReference != null) {
					cacheResult(standardsCrossReference);
				}
				else {
					EntityCacheUtil.putResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCrossReferenceImpl.class, primaryKey,
						_nullStandardsCrossReference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsCrossReferenceModelImpl.ENTITY_CACHE_ENABLED,
					StandardsCrossReferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsCrossReference;
	}

	/**
	 * Returns the standards cross reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsCrossReferencePK the primary key of the standards cross reference
	 * @return the standards cross reference, or <code>null</code> if a standards cross reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCrossReference fetchByPrimaryKey(
		StandardsCrossReferencePK standardsCrossReferencePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsCrossReferencePK);
	}

	/**
	 * Returns all the standards cross references.
	 *
	 * @return the standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards cross references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards cross references
	 * @param end the upper bound of the range of standards cross references (not inclusive)
	 * @return the range of standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards cross references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards cross references
	 * @param end the upper bound of the range of standards cross references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards cross references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCrossReference> findAll(int start, int end,
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

		List<StandardsCrossReference> list = (List<StandardsCrossReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCROSSREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCROSSREFERENCE;

				if (pagination) {
					sql = sql.concat(StandardsCrossReferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsCrossReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCrossReference>(list);
				}
				else {
					list = (List<StandardsCrossReference>)QueryUtil.list(q,
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
	 * Removes all the standards cross references from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsCrossReference standardsCrossReference : findAll()) {
			remove(standardsCrossReference);
		}
	}

	/**
	 * Returns the number of standards cross references.
	 *
	 * @return the number of standards cross references
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCROSSREFERENCE);

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
	 * Initializes the standards cross reference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsCrossReference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsCrossReference>> listenersList = new ArrayList<ModelListener<StandardsCrossReference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsCrossReference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsCrossReferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCROSSREFERENCE = "SELECT standardsCrossReference FROM StandardsCrossReference standardsCrossReference";
	private static final String _SQL_SELECT_STANDARDSCROSSREFERENCE_WHERE = "SELECT standardsCrossReference FROM StandardsCrossReference standardsCrossReference WHERE ";
	private static final String _SQL_COUNT_STANDARDSCROSSREFERENCE = "SELECT COUNT(standardsCrossReference) FROM StandardsCrossReference standardsCrossReference";
	private static final String _SQL_COUNT_STANDARDSCROSSREFERENCE_WHERE = "SELECT COUNT(standardsCrossReference) FROM StandardsCrossReference standardsCrossReference WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsCrossReference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsCrossReference exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsCrossReference exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsCrossReferencePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "xrefStdId", "dispOrderNumber", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static StandardsCrossReference _nullStandardsCrossReference = new StandardsCrossReferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsCrossReference> toCacheModel() {
				return _nullStandardsCrossReferenceCacheModel;
			}
		};

	private static CacheModel<StandardsCrossReference> _nullStandardsCrossReferenceCacheModel =
		new CacheModel<StandardsCrossReference>() {
			@Override
			public StandardsCrossReference toEntityModel() {
				return _nullStandardsCrossReference;
			}
		};
}