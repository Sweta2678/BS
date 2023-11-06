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

import com.ihg.brandstandards.db.NoSuchGEMTriggerException;
import com.ihg.brandstandards.db.model.GEMTrigger;
import com.ihg.brandstandards.db.model.impl.GEMTriggerImpl;
import com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl;

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
 * The persistence implementation for the g e m trigger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTriggerPersistence
 * @see GEMTriggerUtil
 * @generated
 */
public class GEMTriggerPersistenceImpl extends BasePersistenceImpl<GEMTrigger>
	implements GEMTriggerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMTriggerUtil} to access the g e m trigger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMTriggerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, GEMTriggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, GEMTriggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, GEMTriggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, GEMTriggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishId",
			new String[] { Long.class.getName() },
			GEMTriggerModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m triggers where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTrigger> findByPublishId(long publishId)
		throws SystemException {
		return findByPublishId(publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the g e m triggers where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m triggers
	 * @param end the upper bound of the range of g e m triggers (not inclusive)
	 * @return the range of matching g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTrigger> findByPublishId(long publishId, int start, int end)
		throws SystemException {
		return findByPublishId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m triggers where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m triggers
	 * @param end the upper bound of the range of g e m triggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTrigger> findByPublishId(long publishId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID;
			finderArgs = new Object[] { publishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID;
			finderArgs = new Object[] { publishId, start, end, orderByComparator };
		}

		List<GEMTrigger> list = (List<GEMTrigger>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTrigger gemTrigger : list) {
				if ((publishId != gemTrigger.getPublishId())) {
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

			query.append(_SQL_SELECT_GEMTRIGGER_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTriggerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<GEMTrigger>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTrigger>(list);
				}
				else {
					list = (List<GEMTrigger>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m trigger in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m trigger
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger findByPublishId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTriggerException, SystemException {
		GEMTrigger gemTrigger = fetchByPublishId_First(publishId,
				orderByComparator);

		if (gemTrigger != null) {
			return gemTrigger;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTriggerException(msg.toString());
	}

	/**
	 * Returns the first g e m trigger in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger fetchByPublishId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMTrigger> list = findByPublishId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m trigger in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m trigger
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger findByPublishId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTriggerException, SystemException {
		GEMTrigger gemTrigger = fetchByPublishId_Last(publishId,
				orderByComparator);

		if (gemTrigger != null) {
			return gemTrigger;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTriggerException(msg.toString());
	}

	/**
	 * Returns the last g e m trigger in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger fetchByPublishId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(publishId);

		if (count == 0) {
			return null;
		}

		List<GEMTrigger> list = findByPublishId(publishId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m triggers before and after the current g e m trigger in the ordered set where publishId = &#63;.
	 *
	 * @param triggerId the primary key of the current g e m trigger
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m trigger
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger[] findByPublishId_PrevAndNext(long triggerId,
		long publishId, OrderByComparator orderByComparator)
		throws NoSuchGEMTriggerException, SystemException {
		GEMTrigger gemTrigger = findByPrimaryKey(triggerId);

		Session session = null;

		try {
			session = openSession();

			GEMTrigger[] array = new GEMTriggerImpl[3];

			array[0] = getByPublishId_PrevAndNext(session, gemTrigger,
					publishId, orderByComparator, true);

			array[1] = gemTrigger;

			array[2] = getByPublishId_PrevAndNext(session, gemTrigger,
					publishId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMTrigger getByPublishId_PrevAndNext(Session session,
		GEMTrigger gemTrigger, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTRIGGER_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

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
			query.append(GEMTriggerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTrigger);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTrigger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m triggers where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long publishId) throws SystemException {
		for (GEMTrigger gemTrigger : findByPublishId(publishId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemTrigger);
		}
	}

	/**
	 * Returns the number of g e m triggers where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishId(long publishId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHID;

		Object[] finderArgs = new Object[] { publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMTRIGGER_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_PUBLISHID_PUBLISHID_2 = "gemTrigger.publishId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION = new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, GEMTriggerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPublishIdAndQuestion",
			new String[] { Long.class.getName(), String.class.getName() },
			GEMTriggerModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMTriggerModelImpl.QUESTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDQUESTION = new FinderPath(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndQuestion",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the g e m trigger where publishId = &#63; and question = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTriggerException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param question the question
	 * @return the matching g e m trigger
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger findByPublishIdAndQuestion(long publishId, String question)
		throws NoSuchGEMTriggerException, SystemException {
		GEMTrigger gemTrigger = fetchByPublishIdAndQuestion(publishId, question);

		if (gemTrigger == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(", question=");
			msg.append(question);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMTriggerException(msg.toString());
		}

		return gemTrigger;
	}

	/**
	 * Returns the g e m trigger where publishId = &#63; and question = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param question the question
	 * @return the matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger fetchByPublishIdAndQuestion(long publishId,
		String question) throws SystemException {
		return fetchByPublishIdAndQuestion(publishId, question, true);
	}

	/**
	 * Returns the g e m trigger where publishId = &#63; and question = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param question the question
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger fetchByPublishIdAndQuestion(long publishId,
		String question, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishId, question };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
					finderArgs, this);
		}

		if (result instanceof GEMTrigger) {
			GEMTrigger gemTrigger = (GEMTrigger)result;

			if ((publishId != gemTrigger.getPublishId()) ||
					!Validator.equals(question, gemTrigger.getQuestion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GEMTRIGGER_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_PUBLISHID_2);

			boolean bindQuestion = false;

			if (question == null) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_1);
			}
			else if (question.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_3);
			}
			else {
				bindQuestion = true;

				query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindQuestion) {
					qPos.add(question);
				}

				List<GEMTrigger> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMTriggerPersistenceImpl.fetchByPublishIdAndQuestion(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMTrigger gemTrigger = list.get(0);

					result = gemTrigger;

					cacheResult(gemTrigger);

					if ((gemTrigger.getPublishId() != publishId) ||
							(gemTrigger.getQuestion() == null) ||
							!gemTrigger.getQuestion().equals(question)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
							finderArgs, gemTrigger);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
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
			return (GEMTrigger)result;
		}
	}

	/**
	 * Removes the g e m trigger where publishId = &#63; and question = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param question the question
	 * @return the g e m trigger that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger removeByPublishIdAndQuestion(long publishId,
		String question) throws NoSuchGEMTriggerException, SystemException {
		GEMTrigger gemTrigger = findByPublishIdAndQuestion(publishId, question);

		return remove(gemTrigger);
	}

	/**
	 * Returns the number of g e m triggers where publishId = &#63; and question = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param question the question
	 * @return the number of matching g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndQuestion(long publishId, String question)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDQUESTION;

		Object[] finderArgs = new Object[] { publishId, question };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMTRIGGER_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_PUBLISHID_2);

			boolean bindQuestion = false;

			if (question == null) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_1);
			}
			else if (question.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_3);
			}
			else {
				bindQuestion = true;

				query.append(_FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindQuestion) {
					qPos.add(question);
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

	private static final String _FINDER_COLUMN_PUBLISHIDANDQUESTION_PUBLISHID_2 = "gemTrigger.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_1 = "gemTrigger.question IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_2 = "gemTrigger.question = ?";
	private static final String _FINDER_COLUMN_PUBLISHIDANDQUESTION_QUESTION_3 = "(gemTrigger.question IS NULL OR gemTrigger.question = '')";

	public GEMTriggerPersistenceImpl() {
		setModelClass(GEMTrigger.class);
	}

	/**
	 * Caches the g e m trigger in the entity cache if it is enabled.
	 *
	 * @param gemTrigger the g e m trigger
	 */
	@Override
	public void cacheResult(GEMTrigger gemTrigger) {
		EntityCacheUtil.putResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerImpl.class, gemTrigger.getPrimaryKey(), gemTrigger);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
			new Object[] { gemTrigger.getPublishId(), gemTrigger.getQuestion() },
			gemTrigger);

		gemTrigger.resetOriginalValues();
	}

	/**
	 * Caches the g e m triggers in the entity cache if it is enabled.
	 *
	 * @param gemTriggers the g e m triggers
	 */
	@Override
	public void cacheResult(List<GEMTrigger> gemTriggers) {
		for (GEMTrigger gemTrigger : gemTriggers) {
			if (EntityCacheUtil.getResult(
						GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
						GEMTriggerImpl.class, gemTrigger.getPrimaryKey()) == null) {
				cacheResult(gemTrigger);
			}
			else {
				gemTrigger.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m triggers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMTriggerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMTriggerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m trigger.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMTrigger gemTrigger) {
		EntityCacheUtil.removeResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerImpl.class, gemTrigger.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemTrigger);
	}

	@Override
	public void clearCache(List<GEMTrigger> gemTriggers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMTrigger gemTrigger : gemTriggers) {
			EntityCacheUtil.removeResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
				GEMTriggerImpl.class, gemTrigger.getPrimaryKey());

			clearUniqueFindersCache(gemTrigger);
		}
	}

	protected void cacheUniqueFindersCache(GEMTrigger gemTrigger) {
		if (gemTrigger.isNew()) {
			Object[] args = new Object[] {
					gemTrigger.getPublishId(), gemTrigger.getQuestion()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDQUESTION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
				args, gemTrigger);
		}
		else {
			GEMTriggerModelImpl gemTriggerModelImpl = (GEMTriggerModelImpl)gemTrigger;

			if ((gemTriggerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTrigger.getPublishId(), gemTrigger.getQuestion()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDQUESTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
					args, gemTrigger);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMTrigger gemTrigger) {
		GEMTriggerModelImpl gemTriggerModelImpl = (GEMTriggerModelImpl)gemTrigger;

		Object[] args = new Object[] {
				gemTrigger.getPublishId(), gemTrigger.getQuestion()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDQUESTION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
			args);

		if ((gemTriggerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemTriggerModelImpl.getOriginalPublishId(),
					gemTriggerModelImpl.getOriginalQuestion()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDQUESTION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDANDQUESTION,
				args);
		}
	}

	/**
	 * Creates a new g e m trigger with the primary key. Does not add the g e m trigger to the database.
	 *
	 * @param triggerId the primary key for the new g e m trigger
	 * @return the new g e m trigger
	 */
	@Override
	public GEMTrigger create(long triggerId) {
		GEMTrigger gemTrigger = new GEMTriggerImpl();

		gemTrigger.setNew(true);
		gemTrigger.setPrimaryKey(triggerId);

		return gemTrigger;
	}

	/**
	 * Removes the g e m trigger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param triggerId the primary key of the g e m trigger
	 * @return the g e m trigger that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger remove(long triggerId)
		throws NoSuchGEMTriggerException, SystemException {
		return remove((Serializable)triggerId);
	}

	/**
	 * Removes the g e m trigger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m trigger
	 * @return the g e m trigger that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger remove(Serializable primaryKey)
		throws NoSuchGEMTriggerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMTrigger gemTrigger = (GEMTrigger)session.get(GEMTriggerImpl.class,
					primaryKey);

			if (gemTrigger == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMTriggerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemTrigger);
		}
		catch (NoSuchGEMTriggerException nsee) {
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
	protected GEMTrigger removeImpl(GEMTrigger gemTrigger)
		throws SystemException {
		gemTrigger = toUnwrappedModel(gemTrigger);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemTrigger)) {
				gemTrigger = (GEMTrigger)session.get(GEMTriggerImpl.class,
						gemTrigger.getPrimaryKeyObj());
			}

			if (gemTrigger != null) {
				session.delete(gemTrigger);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemTrigger != null) {
			clearCache(gemTrigger);
		}

		return gemTrigger;
	}

	@Override
	public GEMTrigger updateImpl(
		com.ihg.brandstandards.db.model.GEMTrigger gemTrigger)
		throws SystemException {
		gemTrigger = toUnwrappedModel(gemTrigger);

		boolean isNew = gemTrigger.isNew();

		GEMTriggerModelImpl gemTriggerModelImpl = (GEMTriggerModelImpl)gemTrigger;

		Session session = null;

		try {
			session = openSession();

			if (gemTrigger.isNew()) {
				session.save(gemTrigger);

				gemTrigger.setNew(false);
			}
			else {
				session.merge(gemTrigger);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMTriggerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemTriggerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTriggerModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] { gemTriggerModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
			GEMTriggerImpl.class, gemTrigger.getPrimaryKey(), gemTrigger);

		clearUniqueFindersCache(gemTrigger);
		cacheUniqueFindersCache(gemTrigger);

		return gemTrigger;
	}

	protected GEMTrigger toUnwrappedModel(GEMTrigger gemTrigger) {
		if (gemTrigger instanceof GEMTriggerImpl) {
			return gemTrigger;
		}

		GEMTriggerImpl gemTriggerImpl = new GEMTriggerImpl();

		gemTriggerImpl.setNew(gemTrigger.isNew());
		gemTriggerImpl.setPrimaryKey(gemTrigger.getPrimaryKey());

		gemTriggerImpl.setTriggerId(gemTrigger.getTriggerId());
		gemTriggerImpl.setPublishDeptId(gemTrigger.getPublishDeptId());
		gemTriggerImpl.setPublishId(gemTrigger.getPublishId());
		gemTriggerImpl.setQuestion(gemTrigger.getQuestion());
		gemTriggerImpl.setCreatorId(gemTrigger.getCreatorId());
		gemTriggerImpl.setCreatedDate(gemTrigger.getCreatedDate());
		gemTriggerImpl.setUpdatedBy(gemTrigger.getUpdatedBy());
		gemTriggerImpl.setUpdatedDate(gemTrigger.getUpdatedDate());

		return gemTriggerImpl;
	}

	/**
	 * Returns the g e m trigger with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m trigger
	 * @return the g e m trigger
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMTriggerException, SystemException {
		GEMTrigger gemTrigger = fetchByPrimaryKey(primaryKey);

		if (gemTrigger == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMTriggerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemTrigger;
	}

	/**
	 * Returns the g e m trigger with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTriggerException} if it could not be found.
	 *
	 * @param triggerId the primary key of the g e m trigger
	 * @return the g e m trigger
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger findByPrimaryKey(long triggerId)
		throws NoSuchGEMTriggerException, SystemException {
		return findByPrimaryKey((Serializable)triggerId);
	}

	/**
	 * Returns the g e m trigger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m trigger
	 * @return the g e m trigger, or <code>null</code> if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMTrigger gemTrigger = (GEMTrigger)EntityCacheUtil.getResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
				GEMTriggerImpl.class, primaryKey);

		if (gemTrigger == _nullGEMTrigger) {
			return null;
		}

		if (gemTrigger == null) {
			Session session = null;

			try {
				session = openSession();

				gemTrigger = (GEMTrigger)session.get(GEMTriggerImpl.class,
						primaryKey);

				if (gemTrigger != null) {
					cacheResult(gemTrigger);
				}
				else {
					EntityCacheUtil.putResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
						GEMTriggerImpl.class, primaryKey, _nullGEMTrigger);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMTriggerModelImpl.ENTITY_CACHE_ENABLED,
					GEMTriggerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemTrigger;
	}

	/**
	 * Returns the g e m trigger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param triggerId the primary key of the g e m trigger
	 * @return the g e m trigger, or <code>null</code> if a g e m trigger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTrigger fetchByPrimaryKey(long triggerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)triggerId);
	}

	/**
	 * Returns all the g e m triggers.
	 *
	 * @return the g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTrigger> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m triggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m triggers
	 * @param end the upper bound of the range of g e m triggers (not inclusive)
	 * @return the range of g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTrigger> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m triggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m triggers
	 * @param end the upper bound of the range of g e m triggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m triggers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTrigger> findAll(int start, int end,
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

		List<GEMTrigger> list = (List<GEMTrigger>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMTRIGGER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMTRIGGER;

				if (pagination) {
					sql = sql.concat(GEMTriggerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMTrigger>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTrigger>(list);
				}
				else {
					list = (List<GEMTrigger>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m triggers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMTrigger gemTrigger : findAll()) {
			remove(gemTrigger);
		}
	}

	/**
	 * Returns the number of g e m triggers.
	 *
	 * @return the number of g e m triggers
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

				Query q = session.createQuery(_SQL_COUNT_GEMTRIGGER);

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
	 * Initializes the g e m trigger persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMTrigger")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMTrigger>> listenersList = new ArrayList<ModelListener<GEMTrigger>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMTrigger>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMTriggerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMTRIGGER = "SELECT gemTrigger FROM GEMTrigger gemTrigger";
	private static final String _SQL_SELECT_GEMTRIGGER_WHERE = "SELECT gemTrigger FROM GEMTrigger gemTrigger WHERE ";
	private static final String _SQL_COUNT_GEMTRIGGER = "SELECT COUNT(gemTrigger) FROM GEMTrigger gemTrigger";
	private static final String _SQL_COUNT_GEMTRIGGER_WHERE = "SELECT COUNT(gemTrigger) FROM GEMTrigger gemTrigger WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemTrigger.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMTrigger exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMTrigger exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMTriggerPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"triggerId", "publishDeptId", "publishId", "question",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GEMTrigger _nullGEMTrigger = new GEMTriggerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMTrigger> toCacheModel() {
				return _nullGEMTriggerCacheModel;
			}
		};

	private static CacheModel<GEMTrigger> _nullGEMTriggerCacheModel = new CacheModel<GEMTrigger>() {
			@Override
			public GEMTrigger toEntityModel() {
				return _nullGEMTrigger;
			}
		};
}