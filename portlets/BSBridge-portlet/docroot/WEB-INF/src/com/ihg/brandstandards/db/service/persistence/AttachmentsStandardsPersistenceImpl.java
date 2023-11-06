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

import com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.impl.AttachmentsStandardsImpl;
import com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl;

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
 * The persistence implementation for the attachments standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsPersistence
 * @see AttachmentsStandardsUtil
 * @generated
 */
public class AttachmentsStandardsPersistenceImpl extends BasePersistenceImpl<AttachmentsStandards>
	implements AttachmentsStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttachmentsStandardsUtil} to access the attachments standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttachmentsStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			AttachmentsStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the attachments standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @return the range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByStdId(long stdId, int start, int end)
		throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByStdId(long stdId, int start,
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

		List<AttachmentsStandards> list = (List<AttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachmentsStandards attachmentsStandards : list) {
				if ((stdId != attachmentsStandards.getStdId())) {
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

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandards>(list);
				}
				else {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
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
	 * Returns the first attachments standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByStdId_First(stdId,
				orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the first attachments standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AttachmentsStandards> list = findByStdId(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachments standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByStdId_Last(stdId,
				orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the last attachments standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<AttachmentsStandards> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachments standardses before and after the current attachments standards in the ordered set where stdId = &#63;.
	 *
	 * @param attachmentsStandardsPK the primary key of the current attachments standards
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards[] findByStdId_PrevAndNext(
		AttachmentsStandardsPK attachmentsStandardsPK, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByPrimaryKey(attachmentsStandardsPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentsStandards[] array = new AttachmentsStandardsImpl[3];

			array[0] = getByStdId_PrevAndNext(session, attachmentsStandards,
					stdId, orderByComparator, true);

			array[1] = attachmentsStandards;

			array[2] = getByStdId_PrevAndNext(session, attachmentsStandards,
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

	protected AttachmentsStandards getByStdId_PrevAndNext(Session session,
		AttachmentsStandards attachmentsStandards, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

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
			query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachmentsStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachmentsStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachments standardses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (AttachmentsStandards attachmentsStandards : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attachmentsStandards);
		}
	}

	/**
	 * Returns the number of attachments standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching attachments standardses
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

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "attachmentsStandards.stdId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ATTACHMENTID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByattachmentId", new String[] { Long.class.getName() },
			AttachmentsStandardsModelImpl.ATTACHMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHMENTID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByattachmentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the attachments standards where attachmentId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByattachmentId(long attachmentId)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByattachmentId(attachmentId);

		if (attachmentsStandards == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("attachmentId=");
			msg.append(attachmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAttachmentsStandardsException(msg.toString());
		}

		return attachmentsStandards;
	}

	/**
	 * Returns the attachments standards where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByattachmentId(long attachmentId)
		throws SystemException {
		return fetchByattachmentId(attachmentId, true);
	}

	/**
	 * Returns the attachments standards where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByattachmentId(long attachmentId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { attachmentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ATTACHMENTID,
					finderArgs, this);
		}

		if (result instanceof AttachmentsStandards) {
			AttachmentsStandards attachmentsStandards = (AttachmentsStandards)result;

			if ((attachmentId != attachmentsStandards.getAttachmentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				List<AttachmentsStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTACHMENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AttachmentsStandardsPersistenceImpl.fetchByattachmentId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AttachmentsStandards attachmentsStandards = list.get(0);

					result = attachmentsStandards;

					cacheResult(attachmentsStandards);

					if ((attachmentsStandards.getAttachmentId() != attachmentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTACHMENTID,
							finderArgs, attachmentsStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTACHMENTID,
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
			return (AttachmentsStandards)result;
		}
	}

	/**
	 * Removes the attachments standards where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the attachments standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards removeByattachmentId(long attachmentId)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByattachmentId(attachmentId);

		return remove(attachmentsStandards);
	}

	/**
	 * Returns the number of attachments standardses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByattachmentId(long attachmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTACHMENTID;

		Object[] finderArgs = new Object[] { attachmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

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

	private static final String _FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2 = "attachmentsStandards.id.attachmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTATTACHMENTID =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparentAttachmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTATTACHMENTID =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByparentAttachmentId", new String[] { Long.class.getName() },
			AttachmentsStandardsModelImpl.PARENTATTACHMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTATTACHMENTID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentAttachmentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the attachments standardses where parentAttachmentId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @return the matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId) throws SystemException {
		return findByparentAttachmentId(parentAttachmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standardses where parentAttachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @return the range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId, int start, int end) throws SystemException {
		return findByparentAttachmentId(parentAttachmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standardses where parentAttachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTATTACHMENTID;
			finderArgs = new Object[] { parentAttachmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTATTACHMENTID;
			finderArgs = new Object[] {
					parentAttachmentId,
					
					start, end, orderByComparator
				};
		}

		List<AttachmentsStandards> list = (List<AttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachmentsStandards attachmentsStandards : list) {
				if ((parentAttachmentId != attachmentsStandards.getParentAttachmentId())) {
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

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTATTACHMENTID_PARENTATTACHMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentAttachmentId);

				if (!pagination) {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandards>(list);
				}
				else {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
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
	 * Returns the first attachments standards in the ordered set where parentAttachmentId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByparentAttachmentId_First(
		long parentAttachmentId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByparentAttachmentId_First(parentAttachmentId,
				orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentAttachmentId=");
		msg.append(parentAttachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the first attachments standards in the ordered set where parentAttachmentId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByparentAttachmentId_First(
		long parentAttachmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AttachmentsStandards> list = findByparentAttachmentId(parentAttachmentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachments standards in the ordered set where parentAttachmentId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByparentAttachmentId_Last(
		long parentAttachmentId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByparentAttachmentId_Last(parentAttachmentId,
				orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentAttachmentId=");
		msg.append(parentAttachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the last attachments standards in the ordered set where parentAttachmentId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByparentAttachmentId_Last(
		long parentAttachmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByparentAttachmentId(parentAttachmentId);

		if (count == 0) {
			return null;
		}

		List<AttachmentsStandards> list = findByparentAttachmentId(parentAttachmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachments standardses before and after the current attachments standards in the ordered set where parentAttachmentId = &#63;.
	 *
	 * @param attachmentsStandardsPK the primary key of the current attachments standards
	 * @param parentAttachmentId the parent attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards[] findByparentAttachmentId_PrevAndNext(
		AttachmentsStandardsPK attachmentsStandardsPK, long parentAttachmentId,
		OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByPrimaryKey(attachmentsStandardsPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentsStandards[] array = new AttachmentsStandardsImpl[3];

			array[0] = getByparentAttachmentId_PrevAndNext(session,
					attachmentsStandards, parentAttachmentId,
					orderByComparator, true);

			array[1] = attachmentsStandards;

			array[2] = getByparentAttachmentId_PrevAndNext(session,
					attachmentsStandards, parentAttachmentId,
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

	protected AttachmentsStandards getByparentAttachmentId_PrevAndNext(
		Session session, AttachmentsStandards attachmentsStandards,
		long parentAttachmentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTATTACHMENTID_PARENTATTACHMENTID_2);

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
			query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentAttachmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachmentsStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachmentsStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachments standardses where parentAttachmentId = &#63; from the database.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentAttachmentId(long parentAttachmentId)
		throws SystemException {
		for (AttachmentsStandards attachmentsStandards : findByparentAttachmentId(
				parentAttachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attachmentsStandards);
		}
	}

	/**
	 * Returns the number of attachments standardses where parentAttachmentId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @return the number of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentAttachmentId(long parentAttachmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTATTACHMENTID;

		Object[] finderArgs = new Object[] { parentAttachmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTATTACHMENTID_PARENTATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentAttachmentId);

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

	private static final String _FINDER_COLUMN_PARENTATTACHMENTID_PARENTATTACHMENTID_2 =
		"attachmentsStandards.parentAttachmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByparentIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByparentIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AttachmentsStandardsModelImpl.PARENTATTACHMENTID_COLUMN_BITMASK |
			AttachmentsStandardsModelImpl.STDID_COLUMN_BITMASK |
			AttachmentsStandardsModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, String localeCode)
		throws SystemException {
		return findByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
			localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @return the range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, String localeCode, int start,
		int end) throws SystemException {
		return findByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
			localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, String localeCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD;
			finderArgs = new Object[] { parentAttachmentId, stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD;
			finderArgs = new Object[] {
					parentAttachmentId, stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<AttachmentsStandards> list = (List<AttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachmentsStandards attachmentsStandards : list) {
				if ((parentAttachmentId != attachmentsStandards.getParentAttachmentId()) ||
						(stdId != attachmentsStandards.getStdId()) ||
						!Validator.equals(localeCode,
							attachmentsStandards.getLocaleCode())) {
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

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTATTACHMENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentAttachmentId);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandards>(list);
				}
				else {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
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
	 * Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByparentIdStdIdLocaleCd_First(
		long parentAttachmentId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByparentIdStdIdLocaleCd_First(parentAttachmentId,
				stdId, localeCode, orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentAttachmentId=");
		msg.append(parentAttachmentId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByparentIdStdIdLocaleCd_First(
		long parentAttachmentId, long stdId, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<AttachmentsStandards> list = findByparentIdStdIdLocaleCd(parentAttachmentId,
				stdId, localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByparentIdStdIdLocaleCd_Last(
		long parentAttachmentId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByparentIdStdIdLocaleCd_Last(parentAttachmentId,
				stdId, localeCode, orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentAttachmentId=");
		msg.append(parentAttachmentId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByparentIdStdIdLocaleCd_Last(
		long parentAttachmentId, long stdId, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
				localeCode);

		if (count == 0) {
			return null;
		}

		List<AttachmentsStandards> list = findByparentIdStdIdLocaleCd(parentAttachmentId,
				stdId, localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachments standardses before and after the current attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param attachmentsStandardsPK the primary key of the current attachments standards
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards[] findByparentIdStdIdLocaleCd_PrevAndNext(
		AttachmentsStandardsPK attachmentsStandardsPK, long parentAttachmentId,
		long stdId, String localeCode, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByPrimaryKey(attachmentsStandardsPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentsStandards[] array = new AttachmentsStandardsImpl[3];

			array[0] = getByparentIdStdIdLocaleCd_PrevAndNext(session,
					attachmentsStandards, parentAttachmentId, stdId,
					localeCode, orderByComparator, true);

			array[1] = attachmentsStandards;

			array[2] = getByparentIdStdIdLocaleCd_PrevAndNext(session,
					attachmentsStandards, parentAttachmentId, stdId,
					localeCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttachmentsStandards getByparentIdStdIdLocaleCd_PrevAndNext(
		Session session, AttachmentsStandards attachmentsStandards,
		long parentAttachmentId, long stdId, String localeCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTATTACHMENTID_2);

		query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2);
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
			query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentAttachmentId);

		qPos.add(stdId);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachmentsStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachmentsStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentIdStdIdLocaleCd(long parentAttachmentId,
		long stdId, String localeCode) throws SystemException {
		for (AttachmentsStandards attachmentsStandards : findByparentIdStdIdLocaleCd(
				parentAttachmentId, stdId, localeCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(attachmentsStandards);
		}
	}

	/**
	 * Returns the number of attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentIdStdIdLocaleCd(long parentAttachmentId,
		long stdId, String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD;

		Object[] finderArgs = new Object[] { parentAttachmentId, stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTATTACHMENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentAttachmentId);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
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

	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTATTACHMENTID_2 =
		"attachmentsStandards.parentAttachmentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2 = "attachmentsStandards.stdId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1 =
		"attachmentsStandards.id.localeCode IS NULL";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2 =
		"attachmentsStandards.id.localeCode = ?";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3 =
		"(attachmentsStandards.id.localeCode IS NULL OR attachmentsStandards.id.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDLOCALECD =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdIdLocaleCd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdIdLocaleCd",
			new String[] { Long.class.getName(), String.class.getName() },
			AttachmentsStandardsModelImpl.STDID_COLUMN_BITMASK |
			AttachmentsStandardsModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDLOCALECD = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdIdLocaleCd",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByStdIdLocaleCd(long stdId,
		String localeCode) throws SystemException {
		return findByStdIdLocaleCd(stdId, localeCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @return the range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByStdIdLocaleCd(long stdId,
		String localeCode, int start, int end) throws SystemException {
		return findByStdIdLocaleCd(stdId, localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByStdIdLocaleCd(long stdId,
		String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD;
			finderArgs = new Object[] { stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDLOCALECD;
			finderArgs = new Object[] {
					stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<AttachmentsStandards> list = (List<AttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachmentsStandards attachmentsStandards : list) {
				if ((stdId != attachmentsStandards.getStdId()) ||
						!Validator.equals(localeCode,
							attachmentsStandards.getLocaleCode())) {
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

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandards>(list);
				}
				else {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
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
	 * Returns the first attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByStdIdLocaleCd_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByStdIdLocaleCd_First(stdId,
				localeCode, orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the first attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByStdIdLocaleCd_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<AttachmentsStandards> list = findByStdIdLocaleCd(stdId,
				localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByStdIdLocaleCd_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByStdIdLocaleCd_Last(stdId,
				localeCode, orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the last attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByStdIdLocaleCd_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStdIdLocaleCd(stdId, localeCode);

		if (count == 0) {
			return null;
		}

		List<AttachmentsStandards> list = findByStdIdLocaleCd(stdId,
				localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachments standardses before and after the current attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param attachmentsStandardsPK the primary key of the current attachments standards
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards[] findByStdIdLocaleCd_PrevAndNext(
		AttachmentsStandardsPK attachmentsStandardsPK, long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByPrimaryKey(attachmentsStandardsPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentsStandards[] array = new AttachmentsStandardsImpl[3];

			array[0] = getByStdIdLocaleCd_PrevAndNext(session,
					attachmentsStandards, stdId, localeCode, orderByComparator,
					true);

			array[1] = attachmentsStandards;

			array[2] = getByStdIdLocaleCd_PrevAndNext(session,
					attachmentsStandards, stdId, localeCode, orderByComparator,
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

	protected AttachmentsStandards getByStdIdLocaleCd_PrevAndNext(
		Session session, AttachmentsStandards attachmentsStandards, long stdId,
		String localeCode, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDIDLOCALECD_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2);
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
			query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachmentsStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachmentsStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachments standardses where stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdIdLocaleCd(long stdId, String localeCode)
		throws SystemException {
		for (AttachmentsStandards attachmentsStandards : findByStdIdLocaleCd(
				stdId, localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attachmentsStandards);
		}
	}

	/**
	 * Returns the number of attachments standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdLocaleCd(long stdId, String localeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDLOCALECD;

		Object[] finderArgs = new Object[] { stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
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

	private static final String _FINDER_COLUMN_STDIDLOCALECD_STDID_2 = "attachmentsStandards.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1 = "attachmentsStandards.id.localeCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2 = "attachmentsStandards.id.localeCode = ?";
	private static final String _FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3 = "(attachmentsStandards.id.localeCode IS NULL OR attachmentsStandards.id.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDID =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentIdStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID =
		new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentIdStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			AttachmentsStandardsModelImpl.PARENTATTACHMENTID_COLUMN_BITMASK |
			AttachmentsStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIDSTDID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentIdStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @return the matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId) throws SystemException {
		return findByParentIdStdId(parentAttachmentId, stdId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @return the range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId, int start, int end)
		throws SystemException {
		return findByParentIdStdId(parentAttachmentId, stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID;
			finderArgs = new Object[] { parentAttachmentId, stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDID;
			finderArgs = new Object[] {
					parentAttachmentId, stdId,
					
					start, end, orderByComparator
				};
		}

		List<AttachmentsStandards> list = (List<AttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachmentsStandards attachmentsStandards : list) {
				if ((parentAttachmentId != attachmentsStandards.getParentAttachmentId()) ||
						(stdId != attachmentsStandards.getStdId())) {
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

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_PARENTATTACHMENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentAttachmentId);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandards>(list);
				}
				else {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
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
	 * Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByParentIdStdId_First(
		long parentAttachmentId, long stdId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByParentIdStdId_First(parentAttachmentId,
				stdId, orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentAttachmentId=");
		msg.append(parentAttachmentId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByParentIdStdId_First(
		long parentAttachmentId, long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AttachmentsStandards> list = findByParentIdStdId(parentAttachmentId,
				stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByParentIdStdId_Last(
		long parentAttachmentId, long stdId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByParentIdStdId_Last(parentAttachmentId,
				stdId, orderByComparator);

		if (attachmentsStandards != null) {
			return attachmentsStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentAttachmentId=");
		msg.append(parentAttachmentId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByParentIdStdId_Last(
		long parentAttachmentId, long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentIdStdId(parentAttachmentId, stdId);

		if (count == 0) {
			return null;
		}

		List<AttachmentsStandards> list = findByParentIdStdId(parentAttachmentId,
				stdId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachments standardses before and after the current attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param attachmentsStandardsPK the primary key of the current attachments standards
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards[] findByParentIdStdId_PrevAndNext(
		AttachmentsStandardsPK attachmentsStandardsPK, long parentAttachmentId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByPrimaryKey(attachmentsStandardsPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentsStandards[] array = new AttachmentsStandardsImpl[3];

			array[0] = getByParentIdStdId_PrevAndNext(session,
					attachmentsStandards, parentAttachmentId, stdId,
					orderByComparator, true);

			array[1] = attachmentsStandards;

			array[2] = getByParentIdStdId_PrevAndNext(session,
					attachmentsStandards, parentAttachmentId, stdId,
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

	protected AttachmentsStandards getByParentIdStdId_PrevAndNext(
		Session session, AttachmentsStandards attachmentsStandards,
		long parentAttachmentId, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTIDSTDID_PARENTATTACHMENTID_2);

		query.append(_FINDER_COLUMN_PARENTIDSTDID_STDID_2);

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
			query.append(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentAttachmentId);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachmentsStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachmentsStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; from the database.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentIdStdId(long parentAttachmentId, long stdId)
		throws SystemException {
		for (AttachmentsStandards attachmentsStandards : findByParentIdStdId(
				parentAttachmentId, stdId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(attachmentsStandards);
		}
	}

	/**
	 * Returns the number of attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	 *
	 * @param parentAttachmentId the parent attachment ID
	 * @param stdId the std ID
	 * @return the number of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentIdStdId(long parentAttachmentId, long stdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIDSTDID;

		Object[] finderArgs = new Object[] { parentAttachmentId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_PARENTATTACHMENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentAttachmentId);

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

	private static final String _FINDER_COLUMN_PARENTIDSTDID_PARENTATTACHMENTID_2 =
		"attachmentsStandards.parentAttachmentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDSTDID_STDID_2 = "attachmentsStandards.stdId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PARENTIDATTACHID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByParentIdAttachId",
			new String[] { Long.class.getName(), Long.class.getName() },
			AttachmentsStandardsModelImpl.ATTACHMENTID_COLUMN_BITMASK |
			AttachmentsStandardsModelImpl.PARENTATTACHMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIDATTACHID = new FinderPath(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentIdAttachId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @param parentAttachmentId the parent attachment ID
	 * @return the matching attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByParentIdAttachId(long attachmentId,
		long parentAttachmentId)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByParentIdAttachId(attachmentId,
				parentAttachmentId);

		if (attachmentsStandards == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("attachmentId=");
			msg.append(attachmentId);

			msg.append(", parentAttachmentId=");
			msg.append(parentAttachmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAttachmentsStandardsException(msg.toString());
		}

		return attachmentsStandards;
	}

	/**
	 * Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param parentAttachmentId the parent attachment ID
	 * @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByParentIdAttachId(long attachmentId,
		long parentAttachmentId) throws SystemException {
		return fetchByParentIdAttachId(attachmentId, parentAttachmentId, true);
	}

	/**
	 * Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param parentAttachmentId the parent attachment ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByParentIdAttachId(long attachmentId,
		long parentAttachmentId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { attachmentId, parentAttachmentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
					finderArgs, this);
		}

		if (result instanceof AttachmentsStandards) {
			AttachmentsStandards attachmentsStandards = (AttachmentsStandards)result;

			if ((attachmentId != attachmentsStandards.getAttachmentId()) ||
					(parentAttachmentId != attachmentsStandards.getParentAttachmentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDATTACHID_ATTACHMENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDATTACHID_PARENTATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				qPos.add(parentAttachmentId);

				List<AttachmentsStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AttachmentsStandardsPersistenceImpl.fetchByParentIdAttachId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AttachmentsStandards attachmentsStandards = list.get(0);

					result = attachmentsStandards;

					cacheResult(attachmentsStandards);

					if ((attachmentsStandards.getAttachmentId() != attachmentId) ||
							(attachmentsStandards.getParentAttachmentId() != parentAttachmentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
							finderArgs, attachmentsStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
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
			return (AttachmentsStandards)result;
		}
	}

	/**
	 * Removes the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @param parentAttachmentId the parent attachment ID
	 * @return the attachments standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards removeByParentIdAttachId(long attachmentId,
		long parentAttachmentId)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = findByParentIdAttachId(attachmentId,
				parentAttachmentId);

		return remove(attachmentsStandards);
	}

	/**
	 * Returns the number of attachments standardses where attachmentId = &#63; and parentAttachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param parentAttachmentId the parent attachment ID
	 * @return the number of matching attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentIdAttachId(long attachmentId,
		long parentAttachmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIDATTACHID;

		Object[] finderArgs = new Object[] { attachmentId, parentAttachmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDATTACHID_ATTACHMENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDATTACHID_PARENTATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				qPos.add(parentAttachmentId);

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

	private static final String _FINDER_COLUMN_PARENTIDATTACHID_ATTACHMENTID_2 = "attachmentsStandards.id.attachmentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDATTACHID_PARENTATTACHMENTID_2 =
		"attachmentsStandards.parentAttachmentId = ?";

	public AttachmentsStandardsPersistenceImpl() {
		setModelClass(AttachmentsStandards.class);
	}

	/**
	 * Caches the attachments standards in the entity cache if it is enabled.
	 *
	 * @param attachmentsStandards the attachments standards
	 */
	@Override
	public void cacheResult(AttachmentsStandards attachmentsStandards) {
		EntityCacheUtil.putResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			attachmentsStandards.getPrimaryKey(), attachmentsStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTACHMENTID,
			new Object[] { attachmentsStandards.getAttachmentId() },
			attachmentsStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
			new Object[] {
				attachmentsStandards.getAttachmentId(),
				attachmentsStandards.getParentAttachmentId()
			}, attachmentsStandards);

		attachmentsStandards.resetOriginalValues();
	}

	/**
	 * Caches the attachments standardses in the entity cache if it is enabled.
	 *
	 * @param attachmentsStandardses the attachments standardses
	 */
	@Override
	public void cacheResult(List<AttachmentsStandards> attachmentsStandardses) {
		for (AttachmentsStandards attachmentsStandards : attachmentsStandardses) {
			if (EntityCacheUtil.getResult(
						AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
						AttachmentsStandardsImpl.class,
						attachmentsStandards.getPrimaryKey()) == null) {
				cacheResult(attachmentsStandards);
			}
			else {
				attachmentsStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attachments standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AttachmentsStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AttachmentsStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attachments standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttachmentsStandards attachmentsStandards) {
		EntityCacheUtil.removeResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsImpl.class, attachmentsStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(attachmentsStandards);
	}

	@Override
	public void clearCache(List<AttachmentsStandards> attachmentsStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttachmentsStandards attachmentsStandards : attachmentsStandardses) {
			EntityCacheUtil.removeResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
				AttachmentsStandardsImpl.class,
				attachmentsStandards.getPrimaryKey());

			clearUniqueFindersCache(attachmentsStandards);
		}
	}

	protected void cacheUniqueFindersCache(
		AttachmentsStandards attachmentsStandards) {
		if (attachmentsStandards.isNew()) {
			Object[] args = new Object[] { attachmentsStandards.getAttachmentId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTACHMENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTACHMENTID, args,
				attachmentsStandards);

			args = new Object[] {
					attachmentsStandards.getAttachmentId(),
					attachmentsStandards.getParentAttachmentId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTIDATTACHID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
				args, attachmentsStandards);
		}
		else {
			AttachmentsStandardsModelImpl attachmentsStandardsModelImpl = (AttachmentsStandardsModelImpl)attachmentsStandards;

			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ATTACHMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandards.getAttachmentId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTACHMENTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTACHMENTID,
					args, attachmentsStandards);
			}

			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PARENTIDATTACHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandards.getAttachmentId(),
						attachmentsStandards.getParentAttachmentId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTIDATTACHID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
					args, attachmentsStandards);
			}
		}
	}

	protected void clearUniqueFindersCache(
		AttachmentsStandards attachmentsStandards) {
		AttachmentsStandardsModelImpl attachmentsStandardsModelImpl = (AttachmentsStandardsModelImpl)attachmentsStandards;

		Object[] args = new Object[] { attachmentsStandards.getAttachmentId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTACHMENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTACHMENTID, args);

		if ((attachmentsStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ATTACHMENTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					attachmentsStandardsModelImpl.getOriginalAttachmentId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTACHMENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTACHMENTID, args);
		}

		args = new Object[] {
				attachmentsStandards.getAttachmentId(),
				attachmentsStandards.getParentAttachmentId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDATTACHID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID, args);

		if ((attachmentsStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PARENTIDATTACHID.getColumnBitmask()) != 0) {
			args = new Object[] {
					attachmentsStandardsModelImpl.getOriginalAttachmentId(),
					attachmentsStandardsModelImpl.getOriginalParentAttachmentId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDATTACHID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PARENTIDATTACHID,
				args);
		}
	}

	/**
	 * Creates a new attachments standards with the primary key. Does not add the attachments standards to the database.
	 *
	 * @param attachmentsStandardsPK the primary key for the new attachments standards
	 * @return the new attachments standards
	 */
	@Override
	public AttachmentsStandards create(
		AttachmentsStandardsPK attachmentsStandardsPK) {
		AttachmentsStandards attachmentsStandards = new AttachmentsStandardsImpl();

		attachmentsStandards.setNew(true);
		attachmentsStandards.setPrimaryKey(attachmentsStandardsPK);

		return attachmentsStandards;
	}

	/**
	 * Removes the attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentsStandardsPK the primary key of the attachments standards
	 * @return the attachments standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards remove(
		AttachmentsStandardsPK attachmentsStandardsPK)
		throws NoSuchAttachmentsStandardsException, SystemException {
		return remove((Serializable)attachmentsStandardsPK);
	}

	/**
	 * Removes the attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attachments standards
	 * @return the attachments standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards remove(Serializable primaryKey)
		throws NoSuchAttachmentsStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AttachmentsStandards attachmentsStandards = (AttachmentsStandards)session.get(AttachmentsStandardsImpl.class,
					primaryKey);

			if (attachmentsStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttachmentsStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attachmentsStandards);
		}
		catch (NoSuchAttachmentsStandardsException nsee) {
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
	protected AttachmentsStandards removeImpl(
		AttachmentsStandards attachmentsStandards) throws SystemException {
		attachmentsStandards = toUnwrappedModel(attachmentsStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attachmentsStandards)) {
				attachmentsStandards = (AttachmentsStandards)session.get(AttachmentsStandardsImpl.class,
						attachmentsStandards.getPrimaryKeyObj());
			}

			if (attachmentsStandards != null) {
				session.delete(attachmentsStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attachmentsStandards != null) {
			clearCache(attachmentsStandards);
		}

		return attachmentsStandards;
	}

	@Override
	public AttachmentsStandards updateImpl(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards)
		throws SystemException {
		attachmentsStandards = toUnwrappedModel(attachmentsStandards);

		boolean isNew = attachmentsStandards.isNew();

		AttachmentsStandardsModelImpl attachmentsStandardsModelImpl = (AttachmentsStandardsModelImpl)attachmentsStandards;

		Session session = null;

		try {
			session = openSession();

			if (attachmentsStandards.isNew()) {
				session.save(attachmentsStandards);

				attachmentsStandards.setNew(false);
			}
			else {
				session.merge(attachmentsStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AttachmentsStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { attachmentsStandardsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTATTACHMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandardsModelImpl.getOriginalParentAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTATTACHMENTID,
					args);

				args = new Object[] {
						attachmentsStandardsModelImpl.getParentAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTATTACHMENTID,
					args);
			}

			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandardsModelImpl.getOriginalParentAttachmentId(),
						attachmentsStandardsModelImpl.getOriginalStdId(),
						attachmentsStandardsModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD,
					args);

				args = new Object[] {
						attachmentsStandardsModelImpl.getParentAttachmentId(),
						attachmentsStandardsModelImpl.getStdId(),
						attachmentsStandardsModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD,
					args);
			}

			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandardsModelImpl.getOriginalStdId(),
						attachmentsStandardsModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD,
					args);

				args = new Object[] {
						attachmentsStandardsModelImpl.getStdId(),
						attachmentsStandardsModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD,
					args);
			}

			if ((attachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandardsModelImpl.getOriginalParentAttachmentId(),
						attachmentsStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID,
					args);

				args = new Object[] {
						attachmentsStandardsModelImpl.getParentAttachmentId(),
						attachmentsStandardsModelImpl.getStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID,
					args);
			}
		}

		EntityCacheUtil.putResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsImpl.class,
			attachmentsStandards.getPrimaryKey(), attachmentsStandards);

		clearUniqueFindersCache(attachmentsStandards);
		cacheUniqueFindersCache(attachmentsStandards);

		return attachmentsStandards;
	}

	protected AttachmentsStandards toUnwrappedModel(
		AttachmentsStandards attachmentsStandards) {
		if (attachmentsStandards instanceof AttachmentsStandardsImpl) {
			return attachmentsStandards;
		}

		AttachmentsStandardsImpl attachmentsStandardsImpl = new AttachmentsStandardsImpl();

		attachmentsStandardsImpl.setNew(attachmentsStandards.isNew());
		attachmentsStandardsImpl.setPrimaryKey(attachmentsStandards.getPrimaryKey());

		attachmentsStandardsImpl.setAttachmentId(attachmentsStandards.getAttachmentId());
		attachmentsStandardsImpl.setLocaleCode(attachmentsStandards.getLocaleCode());
		attachmentsStandardsImpl.setParentAttachmentId(attachmentsStandards.getParentAttachmentId());
		attachmentsStandardsImpl.setStdId(attachmentsStandards.getStdId());
		attachmentsStandardsImpl.setType(attachmentsStandards.getType());
		attachmentsStandardsImpl.setTitle(attachmentsStandards.getTitle());
		attachmentsStandardsImpl.setTranslationIndicator(attachmentsStandards.getTranslationIndicator());
		attachmentsStandardsImpl.setAttachmentPath(attachmentsStandards.getAttachmentPath());
		attachmentsStandardsImpl.setCreatorId(attachmentsStandards.getCreatorId());
		attachmentsStandardsImpl.setCreatedDate(attachmentsStandards.getCreatedDate());
		attachmentsStandardsImpl.setUpdatedBy(attachmentsStandards.getUpdatedBy());
		attachmentsStandardsImpl.setUpdatedDate(attachmentsStandards.getUpdatedDate());

		return attachmentsStandardsImpl;
	}

	/**
	 * Returns the attachments standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachments standards
	 * @return the attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttachmentsStandardsException, SystemException {
		AttachmentsStandards attachmentsStandards = fetchByPrimaryKey(primaryKey);

		if (attachmentsStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttachmentsStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attachmentsStandards;
	}

	/**
	 * Returns the attachments standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	 *
	 * @param attachmentsStandardsPK the primary key of the attachments standards
	 * @return the attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards findByPrimaryKey(
		AttachmentsStandardsPK attachmentsStandardsPK)
		throws NoSuchAttachmentsStandardsException, SystemException {
		return findByPrimaryKey((Serializable)attachmentsStandardsPK);
	}

	/**
	 * Returns the attachments standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachments standards
	 * @return the attachments standards, or <code>null</code> if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AttachmentsStandards attachmentsStandards = (AttachmentsStandards)EntityCacheUtil.getResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
				AttachmentsStandardsImpl.class, primaryKey);

		if (attachmentsStandards == _nullAttachmentsStandards) {
			return null;
		}

		if (attachmentsStandards == null) {
			Session session = null;

			try {
				session = openSession();

				attachmentsStandards = (AttachmentsStandards)session.get(AttachmentsStandardsImpl.class,
						primaryKey);

				if (attachmentsStandards != null) {
					cacheResult(attachmentsStandards);
				}
				else {
					EntityCacheUtil.putResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
						AttachmentsStandardsImpl.class, primaryKey,
						_nullAttachmentsStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
					AttachmentsStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attachmentsStandards;
	}

	/**
	 * Returns the attachments standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentsStandardsPK the primary key of the attachments standards
	 * @return the attachments standards, or <code>null</code> if a attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandards fetchByPrimaryKey(
		AttachmentsStandardsPK attachmentsStandardsPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)attachmentsStandardsPK);
	}

	/**
	 * Returns all the attachments standardses.
	 *
	 * @return the attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @return the range of attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments standardses
	 * @param end the upper bound of the range of attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandards> findAll(int start, int end,
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

		List<AttachmentsStandards> list = (List<AttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATTACHMENTSSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTACHMENTSSTANDARDS;

				if (pagination) {
					sql = sql.concat(AttachmentsStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandards>(list);
				}
				else {
					list = (List<AttachmentsStandards>)QueryUtil.list(q,
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
	 * Removes all the attachments standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AttachmentsStandards attachmentsStandards : findAll()) {
			remove(attachmentsStandards);
		}
	}

	/**
	 * Returns the number of attachments standardses.
	 *
	 * @return the number of attachments standardses
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

				Query q = session.createQuery(_SQL_COUNT_ATTACHMENTSSTANDARDS);

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
	 * Initializes the attachments standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.AttachmentsStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AttachmentsStandards>> listenersList = new ArrayList<ModelListener<AttachmentsStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AttachmentsStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AttachmentsStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATTACHMENTSSTANDARDS = "SELECT attachmentsStandards FROM AttachmentsStandards attachmentsStandards";
	private static final String _SQL_SELECT_ATTACHMENTSSTANDARDS_WHERE = "SELECT attachmentsStandards FROM AttachmentsStandards attachmentsStandards WHERE ";
	private static final String _SQL_COUNT_ATTACHMENTSSTANDARDS = "SELECT COUNT(attachmentsStandards) FROM AttachmentsStandards attachmentsStandards";
	private static final String _SQL_COUNT_ATTACHMENTSSTANDARDS_WHERE = "SELECT COUNT(attachmentsStandards) FROM AttachmentsStandards attachmentsStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attachmentsStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttachmentsStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AttachmentsStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AttachmentsStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"attachmentId", "localeCode", "parentAttachmentId", "stdId",
				"type", "title", "translationIndicator", "attachmentPath",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static AttachmentsStandards _nullAttachmentsStandards = new AttachmentsStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AttachmentsStandards> toCacheModel() {
				return _nullAttachmentsStandardsCacheModel;
			}
		};

	private static CacheModel<AttachmentsStandards> _nullAttachmentsStandardsCacheModel =
		new CacheModel<AttachmentsStandards>() {
			@Override
			public AttachmentsStandards toEntityModel() {
				return _nullAttachmentsStandards;
			}
		};
}