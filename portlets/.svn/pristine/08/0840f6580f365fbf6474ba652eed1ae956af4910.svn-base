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

import com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException;
import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;
import com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryImpl;
import com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl;

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
 * The persistence implementation for the attachments standards country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsCountryPersistence
 * @see AttachmentsStandardsCountryUtil
 * @generated
 */
public class AttachmentsStandardsCountryPersistenceImpl
	extends BasePersistenceImpl<AttachmentsStandardsCountry>
	implements AttachmentsStandardsCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttachmentsStandardsCountryUtil} to access the attachments standards country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttachmentsStandardsCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTACHMENTID =
		new FinderPath(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByattachmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID =
		new FinderPath(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByattachmentId",
			new String[] { Long.class.getName() },
			AttachmentsStandardsCountryModelImpl.ATTACHMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHMENTID = new FinderPath(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByattachmentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the attachments standards countries where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching attachments standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandardsCountry> findByattachmentId(
		long attachmentId) throws SystemException {
		return findByattachmentId(attachmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standards countries where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachments standards countries
	 * @param end the upper bound of the range of attachments standards countries (not inclusive)
	 * @return the range of matching attachments standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandardsCountry> findByattachmentId(
		long attachmentId, int start, int end) throws SystemException {
		return findByattachmentId(attachmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standards countries where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of attachments standards countries
	 * @param end the upper bound of the range of attachments standards countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandardsCountry> findByattachmentId(
		long attachmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID;
			finderArgs = new Object[] { attachmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTACHMENTID;
			finderArgs = new Object[] {
					attachmentId,
					
					start, end, orderByComparator
				};
		}

		List<AttachmentsStandardsCountry> list = (List<AttachmentsStandardsCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttachmentsStandardsCountry attachmentsStandardsCountry : list) {
				if ((attachmentId != attachmentsStandardsCountry.getAttachmentId())) {
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

			query.append(_SQL_SELECT_ATTACHMENTSSTANDARDSCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttachmentsStandardsCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				if (!pagination) {
					list = (List<AttachmentsStandardsCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandardsCountry>(list);
				}
				else {
					list = (List<AttachmentsStandardsCountry>)QueryUtil.list(q,
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
	 * Returns the first attachments standards country in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards country
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a matching attachments standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry findByattachmentId_First(
		long attachmentId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		AttachmentsStandardsCountry attachmentsStandardsCountry = fetchByattachmentId_First(attachmentId,
				orderByComparator);

		if (attachmentsStandardsCountry != null) {
			return attachmentsStandardsCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsCountryException(msg.toString());
	}

	/**
	 * Returns the first attachments standards country in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachments standards country, or <code>null</code> if a matching attachments standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry fetchByattachmentId_First(
		long attachmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AttachmentsStandardsCountry> list = findByattachmentId(attachmentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attachments standards country in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards country
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a matching attachments standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry findByattachmentId_Last(
		long attachmentId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		AttachmentsStandardsCountry attachmentsStandardsCountry = fetchByattachmentId_Last(attachmentId,
				orderByComparator);

		if (attachmentsStandardsCountry != null) {
			return attachmentsStandardsCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttachmentsStandardsCountryException(msg.toString());
	}

	/**
	 * Returns the last attachments standards country in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachments standards country, or <code>null</code> if a matching attachments standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry fetchByattachmentId_Last(
		long attachmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByattachmentId(attachmentId);

		if (count == 0) {
			return null;
		}

		List<AttachmentsStandardsCountry> list = findByattachmentId(attachmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attachments standards countries before and after the current attachments standards country in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentsStandardsCountryPK the primary key of the current attachments standards country
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachments standards country
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry[] findByattachmentId_PrevAndNext(
		AttachmentsStandardsCountryPK attachmentsStandardsCountryPK,
		long attachmentId, OrderByComparator orderByComparator)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		AttachmentsStandardsCountry attachmentsStandardsCountry = findByPrimaryKey(attachmentsStandardsCountryPK);

		Session session = null;

		try {
			session = openSession();

			AttachmentsStandardsCountry[] array = new AttachmentsStandardsCountryImpl[3];

			array[0] = getByattachmentId_PrevAndNext(session,
					attachmentsStandardsCountry, attachmentId,
					orderByComparator, true);

			array[1] = attachmentsStandardsCountry;

			array[2] = getByattachmentId_PrevAndNext(session,
					attachmentsStandardsCountry, attachmentId,
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

	protected AttachmentsStandardsCountry getByattachmentId_PrevAndNext(
		Session session,
		AttachmentsStandardsCountry attachmentsStandardsCountry,
		long attachmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTACHMENTSSTANDARDSCOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

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
			query.append(AttachmentsStandardsCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(attachmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attachmentsStandardsCountry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttachmentsStandardsCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attachments standards countries where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByattachmentId(long attachmentId)
		throws SystemException {
		for (AttachmentsStandardsCountry attachmentsStandardsCountry : findByattachmentId(
				attachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attachmentsStandardsCountry);
		}
	}

	/**
	 * Returns the number of attachments standards countries where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching attachments standards countries
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

			query.append(_SQL_COUNT_ATTACHMENTSSTANDARDSCOUNTRY_WHERE);

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

	private static final String _FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2 = "attachmentsStandardsCountry.id.attachmentId = ?";

	public AttachmentsStandardsCountryPersistenceImpl() {
		setModelClass(AttachmentsStandardsCountry.class);
	}

	/**
	 * Caches the attachments standards country in the entity cache if it is enabled.
	 *
	 * @param attachmentsStandardsCountry the attachments standards country
	 */
	@Override
	public void cacheResult(
		AttachmentsStandardsCountry attachmentsStandardsCountry) {
		EntityCacheUtil.putResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			attachmentsStandardsCountry.getPrimaryKey(),
			attachmentsStandardsCountry);

		attachmentsStandardsCountry.resetOriginalValues();
	}

	/**
	 * Caches the attachments standards countries in the entity cache if it is enabled.
	 *
	 * @param attachmentsStandardsCountries the attachments standards countries
	 */
	@Override
	public void cacheResult(
		List<AttachmentsStandardsCountry> attachmentsStandardsCountries) {
		for (AttachmentsStandardsCountry attachmentsStandardsCountry : attachmentsStandardsCountries) {
			if (EntityCacheUtil.getResult(
						AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
						AttachmentsStandardsCountryImpl.class,
						attachmentsStandardsCountry.getPrimaryKey()) == null) {
				cacheResult(attachmentsStandardsCountry);
			}
			else {
				attachmentsStandardsCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attachments standards countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AttachmentsStandardsCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AttachmentsStandardsCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attachments standards country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		AttachmentsStandardsCountry attachmentsStandardsCountry) {
		EntityCacheUtil.removeResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			attachmentsStandardsCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<AttachmentsStandardsCountry> attachmentsStandardsCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttachmentsStandardsCountry attachmentsStandardsCountry : attachmentsStandardsCountries) {
			EntityCacheUtil.removeResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
				AttachmentsStandardsCountryImpl.class,
				attachmentsStandardsCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new attachments standards country with the primary key. Does not add the attachments standards country to the database.
	 *
	 * @param attachmentsStandardsCountryPK the primary key for the new attachments standards country
	 * @return the new attachments standards country
	 */
	@Override
	public AttachmentsStandardsCountry create(
		AttachmentsStandardsCountryPK attachmentsStandardsCountryPK) {
		AttachmentsStandardsCountry attachmentsStandardsCountry = new AttachmentsStandardsCountryImpl();

		attachmentsStandardsCountry.setNew(true);
		attachmentsStandardsCountry.setPrimaryKey(attachmentsStandardsCountryPK);

		return attachmentsStandardsCountry;
	}

	/**
	 * Removes the attachments standards country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	 * @return the attachments standards country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry remove(
		AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		return remove((Serializable)attachmentsStandardsCountryPK);
	}

	/**
	 * Removes the attachments standards country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attachments standards country
	 * @return the attachments standards country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry remove(Serializable primaryKey)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AttachmentsStandardsCountry attachmentsStandardsCountry = (AttachmentsStandardsCountry)session.get(AttachmentsStandardsCountryImpl.class,
					primaryKey);

			if (attachmentsStandardsCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttachmentsStandardsCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attachmentsStandardsCountry);
		}
		catch (NoSuchAttachmentsStandardsCountryException nsee) {
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
	protected AttachmentsStandardsCountry removeImpl(
		AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws SystemException {
		attachmentsStandardsCountry = toUnwrappedModel(attachmentsStandardsCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attachmentsStandardsCountry)) {
				attachmentsStandardsCountry = (AttachmentsStandardsCountry)session.get(AttachmentsStandardsCountryImpl.class,
						attachmentsStandardsCountry.getPrimaryKeyObj());
			}

			if (attachmentsStandardsCountry != null) {
				session.delete(attachmentsStandardsCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attachmentsStandardsCountry != null) {
			clearCache(attachmentsStandardsCountry);
		}

		return attachmentsStandardsCountry;
	}

	@Override
	public AttachmentsStandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws SystemException {
		attachmentsStandardsCountry = toUnwrappedModel(attachmentsStandardsCountry);

		boolean isNew = attachmentsStandardsCountry.isNew();

		AttachmentsStandardsCountryModelImpl attachmentsStandardsCountryModelImpl =
			(AttachmentsStandardsCountryModelImpl)attachmentsStandardsCountry;

		Session session = null;

		try {
			session = openSession();

			if (attachmentsStandardsCountry.isNew()) {
				session.save(attachmentsStandardsCountry);

				attachmentsStandardsCountry.setNew(false);
			}
			else {
				session.merge(attachmentsStandardsCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!AttachmentsStandardsCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((attachmentsStandardsCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attachmentsStandardsCountryModelImpl.getOriginalAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID,
					args);

				args = new Object[] {
						attachmentsStandardsCountryModelImpl.getAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			AttachmentsStandardsCountryImpl.class,
			attachmentsStandardsCountry.getPrimaryKey(),
			attachmentsStandardsCountry);

		return attachmentsStandardsCountry;
	}

	protected AttachmentsStandardsCountry toUnwrappedModel(
		AttachmentsStandardsCountry attachmentsStandardsCountry) {
		if (attachmentsStandardsCountry instanceof AttachmentsStandardsCountryImpl) {
			return attachmentsStandardsCountry;
		}

		AttachmentsStandardsCountryImpl attachmentsStandardsCountryImpl = new AttachmentsStandardsCountryImpl();

		attachmentsStandardsCountryImpl.setNew(attachmentsStandardsCountry.isNew());
		attachmentsStandardsCountryImpl.setPrimaryKey(attachmentsStandardsCountry.getPrimaryKey());

		attachmentsStandardsCountryImpl.setAttachmentId(attachmentsStandardsCountry.getAttachmentId());
		attachmentsStandardsCountryImpl.setCountryCode(attachmentsStandardsCountry.getCountryCode());
		attachmentsStandardsCountryImpl.setLocaleCode(attachmentsStandardsCountry.getLocaleCode());
		attachmentsStandardsCountryImpl.setCreatorId(attachmentsStandardsCountry.getCreatorId());
		attachmentsStandardsCountryImpl.setCreatedDate(attachmentsStandardsCountry.getCreatedDate());
		attachmentsStandardsCountryImpl.setUpdatedBy(attachmentsStandardsCountry.getUpdatedBy());
		attachmentsStandardsCountryImpl.setUpdatedDate(attachmentsStandardsCountry.getUpdatedDate());

		return attachmentsStandardsCountryImpl;
	}

	/**
	 * Returns the attachments standards country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachments standards country
	 * @return the attachments standards country
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		AttachmentsStandardsCountry attachmentsStandardsCountry = fetchByPrimaryKey(primaryKey);

		if (attachmentsStandardsCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttachmentsStandardsCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attachmentsStandardsCountry;
	}

	/**
	 * Returns the attachments standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException} if it could not be found.
	 *
	 * @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	 * @return the attachments standards country
	 * @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry findByPrimaryKey(
		AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws NoSuchAttachmentsStandardsCountryException, SystemException {
		return findByPrimaryKey((Serializable)attachmentsStandardsCountryPK);
	}

	/**
	 * Returns the attachments standards country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attachments standards country
	 * @return the attachments standards country, or <code>null</code> if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		AttachmentsStandardsCountry attachmentsStandardsCountry = (AttachmentsStandardsCountry)EntityCacheUtil.getResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
				AttachmentsStandardsCountryImpl.class, primaryKey);

		if (attachmentsStandardsCountry == _nullAttachmentsStandardsCountry) {
			return null;
		}

		if (attachmentsStandardsCountry == null) {
			Session session = null;

			try {
				session = openSession();

				attachmentsStandardsCountry = (AttachmentsStandardsCountry)session.get(AttachmentsStandardsCountryImpl.class,
						primaryKey);

				if (attachmentsStandardsCountry != null) {
					cacheResult(attachmentsStandardsCountry);
				}
				else {
					EntityCacheUtil.putResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
						AttachmentsStandardsCountryImpl.class, primaryKey,
						_nullAttachmentsStandardsCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AttachmentsStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
					AttachmentsStandardsCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attachmentsStandardsCountry;
	}

	/**
	 * Returns the attachments standards country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	 * @return the attachments standards country, or <code>null</code> if a attachments standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttachmentsStandardsCountry fetchByPrimaryKey(
		AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)attachmentsStandardsCountryPK);
	}

	/**
	 * Returns all the attachments standards countries.
	 *
	 * @return the attachments standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandardsCountry> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attachments standards countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments standards countries
	 * @param end the upper bound of the range of attachments standards countries (not inclusive)
	 * @return the range of attachments standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandardsCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attachments standards countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments standards countries
	 * @param end the upper bound of the range of attachments standards countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachments standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttachmentsStandardsCountry> findAll(int start, int end,
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

		List<AttachmentsStandardsCountry> list = (List<AttachmentsStandardsCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATTACHMENTSSTANDARDSCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTACHMENTSSTANDARDSCOUNTRY;

				if (pagination) {
					sql = sql.concat(AttachmentsStandardsCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttachmentsStandardsCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttachmentsStandardsCountry>(list);
				}
				else {
					list = (List<AttachmentsStandardsCountry>)QueryUtil.list(q,
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
	 * Removes all the attachments standards countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AttachmentsStandardsCountry attachmentsStandardsCountry : findAll()) {
			remove(attachmentsStandardsCountry);
		}
	}

	/**
	 * Returns the number of attachments standards countries.
	 *
	 * @return the number of attachments standards countries
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

				Query q = session.createQuery(_SQL_COUNT_ATTACHMENTSSTANDARDSCOUNTRY);

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
	 * Initializes the attachments standards country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.AttachmentsStandardsCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AttachmentsStandardsCountry>> listenersList = new ArrayList<ModelListener<AttachmentsStandardsCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AttachmentsStandardsCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AttachmentsStandardsCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATTACHMENTSSTANDARDSCOUNTRY = "SELECT attachmentsStandardsCountry FROM AttachmentsStandardsCountry attachmentsStandardsCountry";
	private static final String _SQL_SELECT_ATTACHMENTSSTANDARDSCOUNTRY_WHERE = "SELECT attachmentsStandardsCountry FROM AttachmentsStandardsCountry attachmentsStandardsCountry WHERE ";
	private static final String _SQL_COUNT_ATTACHMENTSSTANDARDSCOUNTRY = "SELECT COUNT(attachmentsStandardsCountry) FROM AttachmentsStandardsCountry attachmentsStandardsCountry";
	private static final String _SQL_COUNT_ATTACHMENTSSTANDARDSCOUNTRY_WHERE = "SELECT COUNT(attachmentsStandardsCountry) FROM AttachmentsStandardsCountry attachmentsStandardsCountry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attachmentsStandardsCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttachmentsStandardsCountry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AttachmentsStandardsCountry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AttachmentsStandardsCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"attachmentId", "countryCode", "localeCode", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static AttachmentsStandardsCountry _nullAttachmentsStandardsCountry = new AttachmentsStandardsCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AttachmentsStandardsCountry> toCacheModel() {
				return _nullAttachmentsStandardsCountryCacheModel;
			}
		};

	private static CacheModel<AttachmentsStandardsCountry> _nullAttachmentsStandardsCountryCacheModel =
		new CacheModel<AttachmentsStandardsCountry>() {
			@Override
			public AttachmentsStandardsCountry toEntityModel() {
				return _nullAttachmentsStandardsCountry;
			}
		};
}