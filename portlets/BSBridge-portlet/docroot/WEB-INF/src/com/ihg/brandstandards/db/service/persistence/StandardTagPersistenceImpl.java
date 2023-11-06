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

import com.ihg.brandstandards.db.NoSuchStandardTagException;
import com.ihg.brandstandards.db.model.StandardTag;
import com.ihg.brandstandards.db.model.impl.StandardTagImpl;
import com.ihg.brandstandards.db.model.impl.StandardTagModelImpl;

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
 * The persistence implementation for the standard tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardTagPersistence
 * @see StandardTagUtil
 * @generated
 */
public class StandardTagPersistenceImpl extends BasePersistenceImpl<StandardTag>
	implements StandardTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardTagUtil} to access the standard tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystdId",
			new String[] { Long.class.getName() },
			StandardTagModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standard tags where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findBystdId(long stdId) throws SystemException {
		return findBystdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standard tags where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standard tags
	 * @param end the upper bound of the range of standard tags (not inclusive)
	 * @return the range of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findBystdId(long stdId, int start, int end)
		throws SystemException {
		return findBystdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standard tags where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standard tags
	 * @param end the upper bound of the range of standard tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findBystdId(long stdId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<StandardTag> list = (List<StandardTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardTag standardTag : list) {
				if ((stdId != standardTag.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDTAG_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardTag>(list);
				}
				else {
					list = (List<StandardTag>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first standard tag in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findBystdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = fetchBystdId_First(stdId, orderByComparator);

		if (standardTag != null) {
			return standardTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardTagException(msg.toString());
	}

	/**
	 * Returns the first standard tag in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standard tag, or <code>null</code> if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchBystdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardTag> list = findBystdId(stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standard tag in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findBystdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = fetchBystdId_Last(stdId, orderByComparator);

		if (standardTag != null) {
			return standardTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardTagException(msg.toString());
	}

	/**
	 * Returns the last standard tag in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standard tag, or <code>null</code> if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchBystdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardTag> list = findBystdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standard tags before and after the current standard tag in the ordered set where stdId = &#63;.
	 *
	 * @param standardTagPK the primary key of the current standard tag
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag[] findBystdId_PrevAndNext(StandardTagPK standardTagPK,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = findByPrimaryKey(standardTagPK);

		Session session = null;

		try {
			session = openSession();

			StandardTag[] array = new StandardTagImpl[3];

			array[0] = getBystdId_PrevAndNext(session, standardTag, stdId,
					orderByComparator, true);

			array[1] = standardTag;

			array[2] = getBystdId_PrevAndNext(session, standardTag, stdId,
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

	protected StandardTag getBystdId_PrevAndNext(Session session,
		StandardTag standardTag, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDTAG_WHERE);

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
			query.append(StandardTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standard tags where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdId(long stdId) throws SystemException {
		for (StandardTag standardTag : findBystdId(stdId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standardTag);
		}
	}

	/**
	 * Returns the number of standard tags where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDTAG_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardTag.id.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytag",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytag",
			new String[] { String.class.getName() },
			StandardTagModelImpl.TAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAG = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytag",
			new String[] { String.class.getName() });

	/**
	 * Returns all the standard tags where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findBytag(String tag) throws SystemException {
		return findBytag(tag, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standard tags where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of standard tags
	 * @param end the upper bound of the range of standard tags (not inclusive)
	 * @return the range of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findBytag(String tag, int start, int end)
		throws SystemException {
		return findBytag(tag, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standard tags where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of standard tags
	 * @param end the upper bound of the range of standard tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findBytag(String tag, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { tag };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { tag, start, end, orderByComparator };
		}

		List<StandardTag> list = (List<StandardTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardTag standardTag : list) {
				if (!Validator.equals(tag, standardTag.getTag())) {
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

			query.append(_SQL_SELECT_STANDARDTAG_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_TAG_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAG_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_TAG_TAG_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTag) {
					qPos.add(tag);
				}

				if (!pagination) {
					list = (List<StandardTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardTag>(list);
				}
				else {
					list = (List<StandardTag>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first standard tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findBytag_First(String tag,
		OrderByComparator orderByComparator)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = fetchBytag_First(tag, orderByComparator);

		if (standardTag != null) {
			return standardTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tag=");
		msg.append(tag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardTagException(msg.toString());
	}

	/**
	 * Returns the first standard tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standard tag, or <code>null</code> if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchBytag_First(String tag,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardTag> list = findBytag(tag, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standard tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findBytag_Last(String tag,
		OrderByComparator orderByComparator)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = fetchBytag_Last(tag, orderByComparator);

		if (standardTag != null) {
			return standardTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tag=");
		msg.append(tag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardTagException(msg.toString());
	}

	/**
	 * Returns the last standard tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standard tag, or <code>null</code> if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchBytag_Last(String tag,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytag(tag);

		if (count == 0) {
			return null;
		}

		List<StandardTag> list = findBytag(tag, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standard tags before and after the current standard tag in the ordered set where tag = &#63;.
	 *
	 * @param standardTagPK the primary key of the current standard tag
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag[] findBytag_PrevAndNext(StandardTagPK standardTagPK,
		String tag, OrderByComparator orderByComparator)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = findByPrimaryKey(standardTagPK);

		Session session = null;

		try {
			session = openSession();

			StandardTag[] array = new StandardTagImpl[3];

			array[0] = getBytag_PrevAndNext(session, standardTag, tag,
					orderByComparator, true);

			array[1] = standardTag;

			array[2] = getBytag_PrevAndNext(session, standardTag, tag,
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

	protected StandardTag getBytag_PrevAndNext(Session session,
		StandardTag standardTag, String tag,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDTAG_WHERE);

		boolean bindTag = false;

		if (tag == null) {
			query.append(_FINDER_COLUMN_TAG_TAG_1);
		}
		else if (tag.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TAG_TAG_3);
		}
		else {
			bindTag = true;

			query.append(_FINDER_COLUMN_TAG_TAG_2);
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
			query.append(StandardTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTag) {
			qPos.add(tag);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standard tags where tag = &#63; from the database.
	 *
	 * @param tag the tag
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytag(String tag) throws SystemException {
		for (StandardTag standardTag : findBytag(tag, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standardTag);
		}
	}

	/**
	 * Returns the number of standard tags where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the number of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytag(String tag) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAG;

		Object[] finderArgs = new Object[] { tag };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDTAG_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_TAG_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAG_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_TAG_TAG_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTag) {
					qPos.add(tag);
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

	private static final String _FINDER_COLUMN_TAG_TAG_1 = "standardTag.id.tag IS NULL";
	private static final String _FINDER_COLUMN_TAG_TAG_2 = "standardTag.id.tag = ?";
	private static final String _FINDER_COLUMN_TAG_TAG_3 = "(standardTag.id.tag IS NULL OR standardTag.id.tag = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_STDIDWITHTAG = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, StandardTagImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystdIdWithTag",
			new String[] { Long.class.getName(), String.class.getName() },
			StandardTagModelImpl.STDID_COLUMN_BITMASK |
			StandardTagModelImpl.TAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDWITHTAG = new FinderPath(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdIdWithTag",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the standard tag where stdId = &#63; and tag = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardTagException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param tag the tag
	 * @return the matching standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findBystdIdWithTag(long stdId, String tag)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = fetchBystdIdWithTag(stdId, tag);

		if (standardTag == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", tag=");
			msg.append(tag);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardTagException(msg.toString());
		}

		return standardTag;
	}

	/**
	 * Returns the standard tag where stdId = &#63; and tag = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param tag the tag
	 * @return the matching standard tag, or <code>null</code> if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchBystdIdWithTag(long stdId, String tag)
		throws SystemException {
		return fetchBystdIdWithTag(stdId, tag, true);
	}

	/**
	 * Returns the standard tag where stdId = &#63; and tag = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param tag the tag
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standard tag, or <code>null</code> if a matching standard tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchBystdIdWithTag(long stdId, String tag,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { stdId, tag };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG,
					finderArgs, this);
		}

		if (result instanceof StandardTag) {
			StandardTag standardTag = (StandardTag)result;

			if ((stdId != standardTag.getStdId()) ||
					!Validator.equals(tag, standardTag.getTag())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STANDARDTAG_WHERE);

			query.append(_FINDER_COLUMN_STDIDWITHTAG_STDID_2);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_STDIDWITHTAG_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDWITHTAG_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_STDIDWITHTAG_TAG_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindTag) {
					qPos.add(tag);
				}

				List<StandardTag> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardTagPersistenceImpl.fetchBystdIdWithTag(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardTag standardTag = list.get(0);

					result = standardTag;

					cacheResult(standardTag);

					if ((standardTag.getStdId() != stdId) ||
							(standardTag.getTag() == null) ||
							!standardTag.getTag().equals(tag)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG,
							finderArgs, standardTag);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG,
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
			return (StandardTag)result;
		}
	}

	/**
	 * Removes the standard tag where stdId = &#63; and tag = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param tag the tag
	 * @return the standard tag that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag removeBystdIdWithTag(long stdId, String tag)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = findBystdIdWithTag(stdId, tag);

		return remove(standardTag);
	}

	/**
	 * Returns the number of standard tags where stdId = &#63; and tag = &#63;.
	 *
	 * @param stdId the std ID
	 * @param tag the tag
	 * @return the number of matching standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdIdWithTag(long stdId, String tag)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDWITHTAG;

		Object[] finderArgs = new Object[] { stdId, tag };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDTAG_WHERE);

			query.append(_FINDER_COLUMN_STDIDWITHTAG_STDID_2);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_STDIDWITHTAG_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDWITHTAG_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_STDIDWITHTAG_TAG_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindTag) {
					qPos.add(tag);
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

	private static final String _FINDER_COLUMN_STDIDWITHTAG_STDID_2 = "standardTag.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDWITHTAG_TAG_1 = "standardTag.id.tag IS NULL";
	private static final String _FINDER_COLUMN_STDIDWITHTAG_TAG_2 = "standardTag.id.tag = ?";
	private static final String _FINDER_COLUMN_STDIDWITHTAG_TAG_3 = "(standardTag.id.tag IS NULL OR standardTag.id.tag = '')";

	public StandardTagPersistenceImpl() {
		setModelClass(StandardTag.class);
	}

	/**
	 * Caches the standard tag in the entity cache if it is enabled.
	 *
	 * @param standardTag the standard tag
	 */
	@Override
	public void cacheResult(StandardTag standardTag) {
		EntityCacheUtil.putResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagImpl.class, standardTag.getPrimaryKey(), standardTag);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG,
			new Object[] { standardTag.getStdId(), standardTag.getTag() },
			standardTag);

		standardTag.resetOriginalValues();
	}

	/**
	 * Caches the standard tags in the entity cache if it is enabled.
	 *
	 * @param standardTags the standard tags
	 */
	@Override
	public void cacheResult(List<StandardTag> standardTags) {
		for (StandardTag standardTag : standardTags) {
			if (EntityCacheUtil.getResult(
						StandardTagModelImpl.ENTITY_CACHE_ENABLED,
						StandardTagImpl.class, standardTag.getPrimaryKey()) == null) {
				cacheResult(standardTag);
			}
			else {
				standardTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standard tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standard tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardTag standardTag) {
		EntityCacheUtil.removeResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagImpl.class, standardTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardTag);
	}

	@Override
	public void clearCache(List<StandardTag> standardTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardTag standardTag : standardTags) {
			EntityCacheUtil.removeResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
				StandardTagImpl.class, standardTag.getPrimaryKey());

			clearUniqueFindersCache(standardTag);
		}
	}

	protected void cacheUniqueFindersCache(StandardTag standardTag) {
		if (standardTag.isNew()) {
			Object[] args = new Object[] {
					standardTag.getStdId(), standardTag.getTag()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDWITHTAG, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG, args,
				standardTag);
		}
		else {
			StandardTagModelImpl standardTagModelImpl = (StandardTagModelImpl)standardTag;

			if ((standardTagModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDIDWITHTAG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardTag.getStdId(), standardTag.getTag()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDIDWITHTAG,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG,
					args, standardTag);
			}
		}
	}

	protected void clearUniqueFindersCache(StandardTag standardTag) {
		StandardTagModelImpl standardTagModelImpl = (StandardTagModelImpl)standardTag;

		Object[] args = new Object[] {
				standardTag.getStdId(), standardTag.getTag()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDWITHTAG, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG, args);

		if ((standardTagModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDIDWITHTAG.getColumnBitmask()) != 0) {
			args = new Object[] {
					standardTagModelImpl.getOriginalStdId(),
					standardTagModelImpl.getOriginalTag()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDWITHTAG, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDIDWITHTAG, args);
		}
	}

	/**
	 * Creates a new standard tag with the primary key. Does not add the standard tag to the database.
	 *
	 * @param standardTagPK the primary key for the new standard tag
	 * @return the new standard tag
	 */
	@Override
	public StandardTag create(StandardTagPK standardTagPK) {
		StandardTag standardTag = new StandardTagImpl();

		standardTag.setNew(true);
		standardTag.setPrimaryKey(standardTagPK);

		return standardTag;
	}

	/**
	 * Removes the standard tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardTagPK the primary key of the standard tag
	 * @return the standard tag that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag remove(StandardTagPK standardTagPK)
		throws NoSuchStandardTagException, SystemException {
		return remove((Serializable)standardTagPK);
	}

	/**
	 * Removes the standard tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standard tag
	 * @return the standard tag that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag remove(Serializable primaryKey)
		throws NoSuchStandardTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardTag standardTag = (StandardTag)session.get(StandardTagImpl.class,
					primaryKey);

			if (standardTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardTag);
		}
		catch (NoSuchStandardTagException nsee) {
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
	protected StandardTag removeImpl(StandardTag standardTag)
		throws SystemException {
		standardTag = toUnwrappedModel(standardTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardTag)) {
				standardTag = (StandardTag)session.get(StandardTagImpl.class,
						standardTag.getPrimaryKeyObj());
			}

			if (standardTag != null) {
				session.delete(standardTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardTag != null) {
			clearCache(standardTag);
		}

		return standardTag;
	}

	@Override
	public StandardTag updateImpl(
		com.ihg.brandstandards.db.model.StandardTag standardTag)
		throws SystemException {
		standardTag = toUnwrappedModel(standardTag);

		boolean isNew = standardTag.isNew();

		StandardTagModelImpl standardTagModelImpl = (StandardTagModelImpl)standardTag;

		Session session = null;

		try {
			session = openSession();

			if (standardTag.isNew()) {
				session.save(standardTag);

				standardTag.setNew(false);
			}
			else {
				session.merge(standardTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardTagModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { standardTagModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((standardTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardTagModelImpl.getOriginalTag()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);

				args = new Object[] { standardTagModelImpl.getTag() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
			StandardTagImpl.class, standardTag.getPrimaryKey(), standardTag);

		clearUniqueFindersCache(standardTag);
		cacheUniqueFindersCache(standardTag);

		return standardTag;
	}

	protected StandardTag toUnwrappedModel(StandardTag standardTag) {
		if (standardTag instanceof StandardTagImpl) {
			return standardTag;
		}

		StandardTagImpl standardTagImpl = new StandardTagImpl();

		standardTagImpl.setNew(standardTag.isNew());
		standardTagImpl.setPrimaryKey(standardTag.getPrimaryKey());

		standardTagImpl.setStdId(standardTag.getStdId());
		standardTagImpl.setTag(standardTag.getTag());
		standardTagImpl.setCreatorId(standardTag.getCreatorId());
		standardTagImpl.setCreatedDate(standardTag.getCreatedDate());
		standardTagImpl.setUpdatedBy(standardTag.getUpdatedBy());
		standardTagImpl.setUpdatedDate(standardTag.getUpdatedDate());

		return standardTagImpl;
	}

	/**
	 * Returns the standard tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standard tag
	 * @return the standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardTagException, SystemException {
		StandardTag standardTag = fetchByPrimaryKey(primaryKey);

		if (standardTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardTag;
	}

	/**
	 * Returns the standard tag with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardTagException} if it could not be found.
	 *
	 * @param standardTagPK the primary key of the standard tag
	 * @return the standard tag
	 * @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag findByPrimaryKey(StandardTagPK standardTagPK)
		throws NoSuchStandardTagException, SystemException {
		return findByPrimaryKey((Serializable)standardTagPK);
	}

	/**
	 * Returns the standard tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standard tag
	 * @return the standard tag, or <code>null</code> if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardTag standardTag = (StandardTag)EntityCacheUtil.getResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
				StandardTagImpl.class, primaryKey);

		if (standardTag == _nullStandardTag) {
			return null;
		}

		if (standardTag == null) {
			Session session = null;

			try {
				session = openSession();

				standardTag = (StandardTag)session.get(StandardTagImpl.class,
						primaryKey);

				if (standardTag != null) {
					cacheResult(standardTag);
				}
				else {
					EntityCacheUtil.putResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
						StandardTagImpl.class, primaryKey, _nullStandardTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardTagModelImpl.ENTITY_CACHE_ENABLED,
					StandardTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardTag;
	}

	/**
	 * Returns the standard tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardTagPK the primary key of the standard tag
	 * @return the standard tag, or <code>null</code> if a standard tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardTag fetchByPrimaryKey(StandardTagPK standardTagPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardTagPK);
	}

	/**
	 * Returns all the standard tags.
	 *
	 * @return the standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standard tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standard tags
	 * @param end the upper bound of the range of standard tags (not inclusive)
	 * @return the range of standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standard tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standard tags
	 * @param end the upper bound of the range of standard tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standard tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardTag> findAll(int start, int end,
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

		List<StandardTag> list = (List<StandardTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDTAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDTAG;

				if (pagination) {
					sql = sql.concat(StandardTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardTag>(list);
				}
				else {
					list = (List<StandardTag>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the standard tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardTag standardTag : findAll()) {
			remove(standardTag);
		}
	}

	/**
	 * Returns the number of standard tags.
	 *
	 * @return the number of standard tags
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDTAG);

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
	 * Initializes the standard tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardTag>> listenersList = new ArrayList<ModelListener<StandardTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDTAG = "SELECT standardTag FROM StandardTag standardTag";
	private static final String _SQL_SELECT_STANDARDTAG_WHERE = "SELECT standardTag FROM StandardTag standardTag WHERE ";
	private static final String _SQL_COUNT_STANDARDTAG = "SELECT COUNT(standardTag) FROM StandardTag standardTag";
	private static final String _SQL_COUNT_STANDARDTAG_WHERE = "SELECT COUNT(standardTag) FROM StandardTag standardTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardTagPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "tag", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static StandardTag _nullStandardTag = new StandardTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardTag> toCacheModel() {
				return _nullStandardTagCacheModel;
			}
		};

	private static CacheModel<StandardTag> _nullStandardTagCacheModel = new CacheModel<StandardTag>() {
			@Override
			public StandardTag toEntityModel() {
				return _nullStandardTag;
			}
		};
}