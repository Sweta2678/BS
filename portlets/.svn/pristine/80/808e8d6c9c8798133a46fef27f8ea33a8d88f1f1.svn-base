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

import com.ihg.brandstandards.db.NoSuchErrNotificationException;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.model.impl.ErrNotificationImpl;
import com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl;

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
 * The persistence implementation for the err notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ErrNotificationPersistence
 * @see ErrNotificationUtil
 * @generated
 */
public class ErrNotificationPersistenceImpl extends BasePersistenceImpl<ErrNotification>
	implements ErrNotificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ErrNotificationUtil} to access the err notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ErrNotificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycomponentNameAndPublishId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycomponentNameAndPublishId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			ErrNotificationModelImpl.COMPONENTNAME_COLUMN_BITMASK |
			ErrNotificationModelImpl.PUBLISHID_COLUMN_BITMASK |
			ErrNotificationModelImpl.REFERENCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPONENTNAMEANDPUBLISHID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycomponentNameAndPublishId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @return the matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findBycomponentNameAndPublishId(
		String componentName, long publishId, long referenceId)
		throws SystemException {
		return findBycomponentNameAndPublishId(componentName, publishId,
			referenceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @return the range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findBycomponentNameAndPublishId(
		String componentName, long publishId, long referenceId, int start,
		int end) throws SystemException {
		return findBycomponentNameAndPublishId(componentName, publishId,
			referenceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findBycomponentNameAndPublishId(
		String componentName, long publishId, long referenceId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID;
			finderArgs = new Object[] { componentName, publishId, referenceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID;
			finderArgs = new Object[] {
					componentName, publishId, referenceId,
					
					start, end, orderByComparator
				};
		}

		List<ErrNotification> list = (List<ErrNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ErrNotification errNotification : list) {
				if (!Validator.equals(componentName,
							errNotification.getComponentName()) ||
						(publishId != errNotification.getPublishId()) ||
						(referenceId != errNotification.getReferenceId())) {
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

			query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_REFERENCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				qPos.add(publishId);

				qPos.add(referenceId);

				if (!pagination) {
					list = (List<ErrNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ErrNotification>(list);
				}
				else {
					list = (List<ErrNotification>)QueryUtil.list(q,
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
	 * Returns the first err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findBycomponentNameAndPublishId_First(
		String componentName, long publishId, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchBycomponentNameAndPublishId_First(componentName,
				publishId, referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", publishId=");
		msg.append(publishId);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the first err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchBycomponentNameAndPublishId_First(
		String componentName, long publishId, long referenceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ErrNotification> list = findBycomponentNameAndPublishId(componentName,
				publishId, referenceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findBycomponentNameAndPublishId_Last(
		String componentName, long publishId, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchBycomponentNameAndPublishId_Last(componentName,
				publishId, referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", publishId=");
		msg.append(publishId);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchBycomponentNameAndPublishId_Last(
		String componentName, long publishId, long referenceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycomponentNameAndPublishId(componentName, publishId,
				referenceId);

		if (count == 0) {
			return null;
		}

		List<ErrNotification> list = findBycomponentNameAndPublishId(componentName,
				publishId, referenceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param notificationId the primary key of the current err notification
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification[] findBycomponentNameAndPublishId_PrevAndNext(
		long notificationId, String componentName, long publishId,
		long referenceId, OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			ErrNotification[] array = new ErrNotificationImpl[3];

			array[0] = getBycomponentNameAndPublishId_PrevAndNext(session,
					errNotification, componentName, publishId, referenceId,
					orderByComparator, true);

			array[1] = errNotification;

			array[2] = getBycomponentNameAndPublishId_PrevAndNext(session,
					errNotification, componentName, publishId, referenceId,
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

	protected ErrNotification getBycomponentNameAndPublishId_PrevAndNext(
		Session session, ErrNotification errNotification, String componentName,
		long publishId, long referenceId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

		boolean bindComponentName = false;

		if (componentName == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_1);
		}
		else if (componentName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_3);
		}
		else {
			bindComponentName = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_2);
		}

		query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_PUBLISHID_2);

		query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_REFERENCEID_2);

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
			query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindComponentName) {
			qPos.add(componentName);
		}

		qPos.add(publishId);

		qPos.add(referenceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(errNotification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ErrNotification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63; from the database.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycomponentNameAndPublishId(String componentName,
		long publishId, long referenceId) throws SystemException {
		for (ErrNotification errNotification : findBycomponentNameAndPublishId(
				componentName, publishId, referenceId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(errNotification);
		}
	}

	/**
	 * Returns the number of err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param publishId the publish ID
	 * @param referenceId the reference ID
	 * @return the number of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycomponentNameAndPublishId(String componentName,
		long publishId, long referenceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPONENTNAMEANDPUBLISHID;

		Object[] finderArgs = new Object[] { componentName, publishId, referenceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_REFERENCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				qPos.add(publishId);

				qPos.add(referenceId);

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

	private static final String _FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_1 =
		"errNotification.componentName IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_2 =
		"errNotification.componentName = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_COMPONENTNAME_3 =
		"(errNotification.componentName IS NULL OR errNotification.componentName = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_PUBLISHID_2 =
		"errNotification.publishId = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDPUBLISHID_REFERENCEID_2 =
		"errNotification.referenceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByComponentNameAndReferenceId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByComponentNameAndReferenceId",
			new String[] { String.class.getName(), Long.class.getName() },
			ErrNotificationModelImpl.COMPONENTNAME_COLUMN_BITMASK |
			ErrNotificationModelImpl.REFERENCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPONENTNAMEANDREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByComponentNameAndReferenceId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the err notifications where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @return the matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameAndReferenceId(
		String componentName, long referenceId) throws SystemException {
		return findByComponentNameAndReferenceId(componentName, referenceId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the err notifications where componentName = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @return the range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameAndReferenceId(
		String componentName, long referenceId, int start, int end)
		throws SystemException {
		return findByComponentNameAndReferenceId(componentName, referenceId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the err notifications where componentName = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameAndReferenceId(
		String componentName, long referenceId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID;
			finderArgs = new Object[] { componentName, referenceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID;
			finderArgs = new Object[] {
					componentName, referenceId,
					
					start, end, orderByComparator
				};
		}

		List<ErrNotification> list = (List<ErrNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ErrNotification errNotification : list) {
				if (!Validator.equals(componentName,
							errNotification.getComponentName()) ||
						(referenceId != errNotification.getReferenceId())) {
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

			query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_REFERENCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				qPos.add(referenceId);

				if (!pagination) {
					list = (List<ErrNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ErrNotification>(list);
				}
				else {
					list = (List<ErrNotification>)QueryUtil.list(q,
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
	 * Returns the first err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByComponentNameAndReferenceId_First(
		String componentName, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByComponentNameAndReferenceId_First(componentName,
				referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the first err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByComponentNameAndReferenceId_First(
		String componentName, long referenceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ErrNotification> list = findByComponentNameAndReferenceId(componentName,
				referenceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByComponentNameAndReferenceId_Last(
		String componentName, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByComponentNameAndReferenceId_Last(componentName,
				referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByComponentNameAndReferenceId_Last(
		String componentName, long referenceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByComponentNameAndReferenceId(componentName,
				referenceId);

		if (count == 0) {
			return null;
		}

		List<ErrNotification> list = findByComponentNameAndReferenceId(componentName,
				referenceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param notificationId the primary key of the current err notification
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification[] findByComponentNameAndReferenceId_PrevAndNext(
		long notificationId, String componentName, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			ErrNotification[] array = new ErrNotificationImpl[3];

			array[0] = getByComponentNameAndReferenceId_PrevAndNext(session,
					errNotification, componentName, referenceId,
					orderByComparator, true);

			array[1] = errNotification;

			array[2] = getByComponentNameAndReferenceId_PrevAndNext(session,
					errNotification, componentName, referenceId,
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

	protected ErrNotification getByComponentNameAndReferenceId_PrevAndNext(
		Session session, ErrNotification errNotification, String componentName,
		long referenceId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

		boolean bindComponentName = false;

		if (componentName == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_1);
		}
		else if (componentName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_3);
		}
		else {
			bindComponentName = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_2);
		}

		query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_REFERENCEID_2);

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
			query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindComponentName) {
			qPos.add(componentName);
		}

		qPos.add(referenceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(errNotification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ErrNotification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the err notifications where componentName = &#63; and referenceId = &#63; from the database.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByComponentNameAndReferenceId(String componentName,
		long referenceId) throws SystemException {
		for (ErrNotification errNotification : findByComponentNameAndReferenceId(
				componentName, referenceId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(errNotification);
		}
	}

	/**
	 * Returns the number of err notifications where componentName = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param referenceId the reference ID
	 * @return the number of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByComponentNameAndReferenceId(String componentName,
		long referenceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPONENTNAMEANDREFERENCEID;

		Object[] finderArgs = new Object[] { componentName, referenceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_REFERENCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				qPos.add(referenceId);

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

	private static final String _FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_1 =
		"errNotification.componentName IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_2 =
		"errNotification.componentName = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_COMPONENTNAME_3 =
		"(errNotification.componentName IS NULL OR errNotification.componentName = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMEANDREFERENCEID_REFERENCEID_2 =
		"errNotification.referenceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByComponentNameStatusReferenceId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByComponentNameStatusReferenceId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			ErrNotificationModelImpl.COMPONENTNAME_COLUMN_BITMASK |
			ErrNotificationModelImpl.STATUS_COLUMN_BITMASK |
			ErrNotificationModelImpl.REFERENCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByComponentNameStatusReferenceId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @return the matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameStatusReferenceId(
		String componentName, String status, long referenceId)
		throws SystemException {
		return findByComponentNameStatusReferenceId(componentName, status,
			referenceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @return the range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameStatusReferenceId(
		String componentName, String status, long referenceId, int start,
		int end) throws SystemException {
		return findByComponentNameStatusReferenceId(componentName, status,
			referenceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameStatusReferenceId(
		String componentName, String status, long referenceId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID;
			finderArgs = new Object[] { componentName, status, referenceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID;
			finderArgs = new Object[] {
					componentName, status, referenceId,
					
					start, end, orderByComparator
				};
		}

		List<ErrNotification> list = (List<ErrNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ErrNotification errNotification : list) {
				if (!Validator.equals(componentName,
							errNotification.getComponentName()) ||
						!Validator.equals(status, errNotification.getStatus()) ||
						(referenceId != errNotification.getReferenceId())) {
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

			query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_REFERENCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(referenceId);

				if (!pagination) {
					list = (List<ErrNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ErrNotification>(list);
				}
				else {
					list = (List<ErrNotification>)QueryUtil.list(q,
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
	 * Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByComponentNameStatusReferenceId_First(
		String componentName, String status, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByComponentNameStatusReferenceId_First(componentName,
				status, referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", status=");
		msg.append(status);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByComponentNameStatusReferenceId_First(
		String componentName, String status, long referenceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ErrNotification> list = findByComponentNameStatusReferenceId(componentName,
				status, referenceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByComponentNameStatusReferenceId_Last(
		String componentName, String status, long referenceId,
		OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByComponentNameStatusReferenceId_Last(componentName,
				status, referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", status=");
		msg.append(status);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByComponentNameStatusReferenceId_Last(
		String componentName, String status, long referenceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByComponentNameStatusReferenceId(componentName,
				status, referenceId);

		if (count == 0) {
			return null;
		}

		List<ErrNotification> list = findByComponentNameStatusReferenceId(componentName,
				status, referenceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param notificationId the primary key of the current err notification
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification[] findByComponentNameStatusReferenceId_PrevAndNext(
		long notificationId, String componentName, String status,
		long referenceId, OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			ErrNotification[] array = new ErrNotificationImpl[3];

			array[0] = getByComponentNameStatusReferenceId_PrevAndNext(session,
					errNotification, componentName, status, referenceId,
					orderByComparator, true);

			array[1] = errNotification;

			array[2] = getByComponentNameStatusReferenceId_PrevAndNext(session,
					errNotification, componentName, status, referenceId,
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

	protected ErrNotification getByComponentNameStatusReferenceId_PrevAndNext(
		Session session, ErrNotification errNotification, String componentName,
		String status, long referenceId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

		boolean bindComponentName = false;

		if (componentName == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_1);
		}
		else if (componentName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_3);
		}
		else {
			bindComponentName = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_2);
		}

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_2);
		}

		query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_REFERENCEID_2);

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
			query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindComponentName) {
			qPos.add(componentName);
		}

		if (bindStatus) {
			qPos.add(status);
		}

		qPos.add(referenceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(errNotification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ErrNotification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63; from the database.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByComponentNameStatusReferenceId(String componentName,
		String status, long referenceId) throws SystemException {
		for (ErrNotification errNotification : findByComponentNameStatusReferenceId(
				componentName, status, referenceId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(errNotification);
		}
	}

	/**
	 * Returns the number of err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param referenceId the reference ID
	 * @return the number of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByComponentNameStatusReferenceId(String componentName,
		String status, long referenceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSREFERENCEID;

		Object[] finderArgs = new Object[] { componentName, status, referenceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_REFERENCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				qPos.add(referenceId);

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

	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_1 =
		"errNotification.componentName IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_2 =
		"errNotification.componentName = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_COMPONENTNAME_3 =
		"(errNotification.componentName IS NULL OR errNotification.componentName = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_1 =
		"errNotification.status IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_2 =
		"errNotification.status = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_STATUS_3 =
		"(errNotification.status IS NULL OR errNotification.status = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSREFERENCEID_REFERENCEID_2 =
		"errNotification.referenceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByComponentNameStatusUserReferenceId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED,
			ErrNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByComponentNameStatusUserReferenceId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			ErrNotificationModelImpl.COMPONENTNAME_COLUMN_BITMASK |
			ErrNotificationModelImpl.STATUS_COLUMN_BITMASK |
			ErrNotificationModelImpl.CREATORID_COLUMN_BITMASK |
			ErrNotificationModelImpl.REFERENCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSUSERREFERENCEID =
		new FinderPath(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByComponentNameStatusUserReferenceId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @return the matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameStatusUserReferenceId(
		String componentName, String status, String creatorId, long referenceId)
		throws SystemException {
		return findByComponentNameStatusUserReferenceId(componentName, status,
			creatorId, referenceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @return the range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameStatusUserReferenceId(
		String componentName, String status, String creatorId,
		long referenceId, int start, int end) throws SystemException {
		return findByComponentNameStatusUserReferenceId(componentName, status,
			creatorId, referenceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findByComponentNameStatusUserReferenceId(
		String componentName, String status, String creatorId,
		long referenceId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID;
			finderArgs = new Object[] {
					componentName, status, creatorId, referenceId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID;
			finderArgs = new Object[] {
					componentName, status, creatorId, referenceId,
					
					start, end, orderByComparator
				};
		}

		List<ErrNotification> list = (List<ErrNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ErrNotification errNotification : list) {
				if (!Validator.equals(componentName,
							errNotification.getComponentName()) ||
						!Validator.equals(status, errNotification.getStatus()) ||
						!Validator.equals(creatorId,
							errNotification.getCreatorId()) ||
						(referenceId != errNotification.getReferenceId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_2);
			}

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_REFERENCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				qPos.add(referenceId);

				if (!pagination) {
					list = (List<ErrNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ErrNotification>(list);
				}
				else {
					list = (List<ErrNotification>)QueryUtil.list(q,
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
	 * Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByComponentNameStatusUserReferenceId_First(
		String componentName, String status, String creatorId,
		long referenceId, OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByComponentNameStatusUserReferenceId_First(componentName,
				status, creatorId, referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", status=");
		msg.append(status);

		msg.append(", creatorId=");
		msg.append(creatorId);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByComponentNameStatusUserReferenceId_First(
		String componentName, String status, String creatorId,
		long referenceId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ErrNotification> list = findByComponentNameStatusUserReferenceId(componentName,
				status, creatorId, referenceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByComponentNameStatusUserReferenceId_Last(
		String componentName, String status, String creatorId,
		long referenceId, OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByComponentNameStatusUserReferenceId_Last(componentName,
				status, creatorId, referenceId, orderByComparator);

		if (errNotification != null) {
			return errNotification;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentName=");
		msg.append(componentName);

		msg.append(", status=");
		msg.append(status);

		msg.append(", creatorId=");
		msg.append(creatorId);

		msg.append(", referenceId=");
		msg.append(referenceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchErrNotificationException(msg.toString());
	}

	/**
	 * Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByComponentNameStatusUserReferenceId_Last(
		String componentName, String status, String creatorId,
		long referenceId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByComponentNameStatusUserReferenceId(componentName,
				status, creatorId, referenceId);

		if (count == 0) {
			return null;
		}

		List<ErrNotification> list = findByComponentNameStatusUserReferenceId(componentName,
				status, creatorId, referenceId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param notificationId the primary key of the current err notification
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification[] findByComponentNameStatusUserReferenceId_PrevAndNext(
		long notificationId, String componentName, String status,
		String creatorId, long referenceId, OrderByComparator orderByComparator)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			ErrNotification[] array = new ErrNotificationImpl[3];

			array[0] = getByComponentNameStatusUserReferenceId_PrevAndNext(session,
					errNotification, componentName, status, creatorId,
					referenceId, orderByComparator, true);

			array[1] = errNotification;

			array[2] = getByComponentNameStatusUserReferenceId_PrevAndNext(session,
					errNotification, componentName, status, creatorId,
					referenceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ErrNotification getByComponentNameStatusUserReferenceId_PrevAndNext(
		Session session, ErrNotification errNotification, String componentName,
		String status, String creatorId, long referenceId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ERRNOTIFICATION_WHERE);

		boolean bindComponentName = false;

		if (componentName == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_1);
		}
		else if (componentName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_3);
		}
		else {
			bindComponentName = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_2);
		}

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_2);
		}

		boolean bindCreatorId = false;

		if (creatorId == null) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_1);
		}
		else if (creatorId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_3);
		}
		else {
			bindCreatorId = true;

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_2);
		}

		query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_REFERENCEID_2);

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
			query.append(ErrNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindComponentName) {
			qPos.add(componentName);
		}

		if (bindStatus) {
			qPos.add(status);
		}

		if (bindCreatorId) {
			qPos.add(creatorId);
		}

		qPos.add(referenceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(errNotification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ErrNotification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63; from the database.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByComponentNameStatusUserReferenceId(
		String componentName, String status, String creatorId, long referenceId)
		throws SystemException {
		for (ErrNotification errNotification : findByComponentNameStatusUserReferenceId(
				componentName, status, creatorId, referenceId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(errNotification);
		}
	}

	/**
	 * Returns the number of err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	 *
	 * @param componentName the component name
	 * @param status the status
	 * @param creatorId the creator ID
	 * @param referenceId the reference ID
	 * @return the number of matching err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByComponentNameStatusUserReferenceId(String componentName,
		String status, String creatorId, long referenceId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSUSERREFERENCEID;

		Object[] finderArgs = new Object[] {
				componentName, status, creatorId, referenceId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ERRNOTIFICATION_WHERE);

			boolean bindComponentName = false;

			if (componentName == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_1);
			}
			else if (componentName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_2);
			}

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_2);
			}

			query.append(_FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_REFERENCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindComponentName) {
					qPos.add(componentName);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				qPos.add(referenceId);

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

	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_1 =
		"errNotification.componentName IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_2 =
		"errNotification.componentName = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_COMPONENTNAME_3 =
		"(errNotification.componentName IS NULL OR errNotification.componentName = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_1 =
		"errNotification.status IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_2 =
		"errNotification.status = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_STATUS_3 =
		"(errNotification.status IS NULL OR errNotification.status = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_1 =
		"errNotification.creatorId IS NULL AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_2 =
		"errNotification.creatorId = ? AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_CREATORID_3 =
		"(errNotification.creatorId IS NULL OR errNotification.creatorId = '') AND ";
	private static final String _FINDER_COLUMN_COMPONENTNAMESTATUSUSERREFERENCEID_REFERENCEID_2 =
		"errNotification.referenceId = ?";

	public ErrNotificationPersistenceImpl() {
		setModelClass(ErrNotification.class);
	}

	/**
	 * Caches the err notification in the entity cache if it is enabled.
	 *
	 * @param errNotification the err notification
	 */
	@Override
	public void cacheResult(ErrNotification errNotification) {
		EntityCacheUtil.putResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationImpl.class, errNotification.getPrimaryKey(),
			errNotification);

		errNotification.resetOriginalValues();
	}

	/**
	 * Caches the err notifications in the entity cache if it is enabled.
	 *
	 * @param errNotifications the err notifications
	 */
	@Override
	public void cacheResult(List<ErrNotification> errNotifications) {
		for (ErrNotification errNotification : errNotifications) {
			if (EntityCacheUtil.getResult(
						ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
						ErrNotificationImpl.class,
						errNotification.getPrimaryKey()) == null) {
				cacheResult(errNotification);
			}
			else {
				errNotification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all err notifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ErrNotificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ErrNotificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the err notification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ErrNotification errNotification) {
		EntityCacheUtil.removeResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationImpl.class, errNotification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ErrNotification> errNotifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ErrNotification errNotification : errNotifications) {
			EntityCacheUtil.removeResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
				ErrNotificationImpl.class, errNotification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new err notification with the primary key. Does not add the err notification to the database.
	 *
	 * @param notificationId the primary key for the new err notification
	 * @return the new err notification
	 */
	@Override
	public ErrNotification create(long notificationId) {
		ErrNotification errNotification = new ErrNotificationImpl();

		errNotification.setNew(true);
		errNotification.setPrimaryKey(notificationId);

		return errNotification;
	}

	/**
	 * Removes the err notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationId the primary key of the err notification
	 * @return the err notification that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification remove(long notificationId)
		throws NoSuchErrNotificationException, SystemException {
		return remove((Serializable)notificationId);
	}

	/**
	 * Removes the err notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the err notification
	 * @return the err notification that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification remove(Serializable primaryKey)
		throws NoSuchErrNotificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ErrNotification errNotification = (ErrNotification)session.get(ErrNotificationImpl.class,
					primaryKey);

			if (errNotification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchErrNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(errNotification);
		}
		catch (NoSuchErrNotificationException nsee) {
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
	protected ErrNotification removeImpl(ErrNotification errNotification)
		throws SystemException {
		errNotification = toUnwrappedModel(errNotification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(errNotification)) {
				errNotification = (ErrNotification)session.get(ErrNotificationImpl.class,
						errNotification.getPrimaryKeyObj());
			}

			if (errNotification != null) {
				session.delete(errNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (errNotification != null) {
			clearCache(errNotification);
		}

		return errNotification;
	}

	@Override
	public ErrNotification updateImpl(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws SystemException {
		errNotification = toUnwrappedModel(errNotification);

		boolean isNew = errNotification.isNew();

		ErrNotificationModelImpl errNotificationModelImpl = (ErrNotificationModelImpl)errNotification;

		Session session = null;

		try {
			session = openSession();

			if (errNotification.isNew()) {
				session.save(errNotification);

				errNotification.setNew(false);
			}
			else {
				session.merge(errNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ErrNotificationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((errNotificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						errNotificationModelImpl.getOriginalComponentName(),
						errNotificationModelImpl.getOriginalPublishId(),
						errNotificationModelImpl.getOriginalReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMEANDPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID,
					args);

				args = new Object[] {
						errNotificationModelImpl.getComponentName(),
						errNotificationModelImpl.getPublishId(),
						errNotificationModelImpl.getReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMEANDPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDPUBLISHID,
					args);
			}

			if ((errNotificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						errNotificationModelImpl.getOriginalComponentName(),
						errNotificationModelImpl.getOriginalReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMEANDREFERENCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID,
					args);

				args = new Object[] {
						errNotificationModelImpl.getComponentName(),
						errNotificationModelImpl.getReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMEANDREFERENCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMEANDREFERENCEID,
					args);
			}

			if ((errNotificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						errNotificationModelImpl.getOriginalComponentName(),
						errNotificationModelImpl.getOriginalStatus(),
						errNotificationModelImpl.getOriginalReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSREFERENCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID,
					args);

				args = new Object[] {
						errNotificationModelImpl.getComponentName(),
						errNotificationModelImpl.getStatus(),
						errNotificationModelImpl.getReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSREFERENCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSREFERENCEID,
					args);
			}

			if ((errNotificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						errNotificationModelImpl.getOriginalComponentName(),
						errNotificationModelImpl.getOriginalStatus(),
						errNotificationModelImpl.getOriginalCreatorId(),
						errNotificationModelImpl.getOriginalReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSUSERREFERENCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID,
					args);

				args = new Object[] {
						errNotificationModelImpl.getComponentName(),
						errNotificationModelImpl.getStatus(),
						errNotificationModelImpl.getCreatorId(),
						errNotificationModelImpl.getReferenceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPONENTNAMESTATUSUSERREFERENCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTNAMESTATUSUSERREFERENCEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
			ErrNotificationImpl.class, errNotification.getPrimaryKey(),
			errNotification);

		return errNotification;
	}

	protected ErrNotification toUnwrappedModel(ErrNotification errNotification) {
		if (errNotification instanceof ErrNotificationImpl) {
			return errNotification;
		}

		ErrNotificationImpl errNotificationImpl = new ErrNotificationImpl();

		errNotificationImpl.setNew(errNotification.isNew());
		errNotificationImpl.setPrimaryKey(errNotification.getPrimaryKey());

		errNotificationImpl.setNotificationId(errNotification.getNotificationId());
		errNotificationImpl.setComponentName(errNotification.getComponentName());
		errNotificationImpl.setReferenceId(errNotification.getReferenceId());
		errNotificationImpl.setSeverity(errNotification.getSeverity());
		errNotificationImpl.setTitle(errNotification.getTitle());
		errNotificationImpl.setDescription(errNotification.getDescription());
		errNotificationImpl.setStatus(errNotification.getStatus());
		errNotificationImpl.setPublishId(errNotification.getPublishId());
		errNotificationImpl.setRegionId(errNotification.getRegionId());
		errNotificationImpl.setCreatorId(errNotification.getCreatorId());
		errNotificationImpl.setCreatedDate(errNotification.getCreatedDate());
		errNotificationImpl.setUpdatedBy(errNotification.getUpdatedBy());
		errNotificationImpl.setUpdatedDate(errNotification.getUpdatedDate());

		return errNotificationImpl;
	}

	/**
	 * Returns the err notification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the err notification
	 * @return the err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchErrNotificationException, SystemException {
		ErrNotification errNotification = fetchByPrimaryKey(primaryKey);

		if (errNotification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchErrNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return errNotification;
	}

	/**
	 * Returns the err notification with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchErrNotificationException} if it could not be found.
	 *
	 * @param notificationId the primary key of the err notification
	 * @return the err notification
	 * @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification findByPrimaryKey(long notificationId)
		throws NoSuchErrNotificationException, SystemException {
		return findByPrimaryKey((Serializable)notificationId);
	}

	/**
	 * Returns the err notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the err notification
	 * @return the err notification, or <code>null</code> if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ErrNotification errNotification = (ErrNotification)EntityCacheUtil.getResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
				ErrNotificationImpl.class, primaryKey);

		if (errNotification == _nullErrNotification) {
			return null;
		}

		if (errNotification == null) {
			Session session = null;

			try {
				session = openSession();

				errNotification = (ErrNotification)session.get(ErrNotificationImpl.class,
						primaryKey);

				if (errNotification != null) {
					cacheResult(errNotification);
				}
				else {
					EntityCacheUtil.putResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
						ErrNotificationImpl.class, primaryKey,
						_nullErrNotification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ErrNotificationModelImpl.ENTITY_CACHE_ENABLED,
					ErrNotificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return errNotification;
	}

	/**
	 * Returns the err notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the err notification
	 * @return the err notification, or <code>null</code> if a err notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ErrNotification fetchByPrimaryKey(long notificationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificationId);
	}

	/**
	 * Returns all the err notifications.
	 *
	 * @return the err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the err notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @return the range of err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the err notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of err notifications
	 * @param end the upper bound of the range of err notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of err notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ErrNotification> findAll(int start, int end,
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

		List<ErrNotification> list = (List<ErrNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ERRNOTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ERRNOTIFICATION;

				if (pagination) {
					sql = sql.concat(ErrNotificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ErrNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ErrNotification>(list);
				}
				else {
					list = (List<ErrNotification>)QueryUtil.list(q,
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
	 * Removes all the err notifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ErrNotification errNotification : findAll()) {
			remove(errNotification);
		}
	}

	/**
	 * Returns the number of err notifications.
	 *
	 * @return the number of err notifications
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

				Query q = session.createQuery(_SQL_COUNT_ERRNOTIFICATION);

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
	 * Initializes the err notification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.ErrNotification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ErrNotification>> listenersList = new ArrayList<ModelListener<ErrNotification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ErrNotification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ErrNotificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ERRNOTIFICATION = "SELECT errNotification FROM ErrNotification errNotification";
	private static final String _SQL_SELECT_ERRNOTIFICATION_WHERE = "SELECT errNotification FROM ErrNotification errNotification WHERE ";
	private static final String _SQL_COUNT_ERRNOTIFICATION = "SELECT COUNT(errNotification) FROM ErrNotification errNotification";
	private static final String _SQL_COUNT_ERRNOTIFICATION_WHERE = "SELECT COUNT(errNotification) FROM ErrNotification errNotification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "errNotification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ErrNotification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ErrNotification exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ErrNotificationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"notificationId", "componentName", "referenceId", "severity",
				"title", "description", "status", "publishId", "regionId",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static ErrNotification _nullErrNotification = new ErrNotificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ErrNotification> toCacheModel() {
				return _nullErrNotificationCacheModel;
			}
		};

	private static CacheModel<ErrNotification> _nullErrNotificationCacheModel = new CacheModel<ErrNotification>() {
			@Override
			public ErrNotification toEntityModel() {
				return _nullErrNotification;
			}
		};
}