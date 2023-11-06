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

import com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsImpl;
import com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl;

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
 * The persistence implementation for the chain attachments standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainAttachmentsStandardsPersistence
 * @see ChainAttachmentsStandardsUtil
 * @generated
 */
public class ChainAttachmentsStandardsPersistenceImpl
	extends BasePersistenceImpl<ChainAttachmentsStandards>
	implements ChainAttachmentsStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChainAttachmentsStandardsUtil} to access the chain attachments standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChainAttachmentsStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTACHMENTID =
		new FinderPath(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttachmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID =
		new FinderPath(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttachmentId",
			new String[] { Long.class.getName() },
			ChainAttachmentsStandardsModelImpl.ATTACHMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHMENTID = new FinderPath(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAttachmentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the chain attachments standardses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainAttachmentsStandards> findByAttachmentId(long attachmentId)
		throws SystemException {
		return findByAttachmentId(attachmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chain attachments standardses where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of chain attachments standardses
	 * @param end the upper bound of the range of chain attachments standardses (not inclusive)
	 * @return the range of matching chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainAttachmentsStandards> findByAttachmentId(
		long attachmentId, int start, int end) throws SystemException {
		return findByAttachmentId(attachmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain attachments standardses where attachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attachmentId the attachment ID
	 * @param start the lower bound of the range of chain attachments standardses
	 * @param end the upper bound of the range of chain attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainAttachmentsStandards> findByAttachmentId(
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

		List<ChainAttachmentsStandards> list = (List<ChainAttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChainAttachmentsStandards chainAttachmentsStandards : list) {
				if ((attachmentId != chainAttachmentsStandards.getAttachmentId())) {
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

			query.append(_SQL_SELECT_CHAINATTACHMENTSSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChainAttachmentsStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(attachmentId);

				if (!pagination) {
					list = (List<ChainAttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainAttachmentsStandards>(list);
				}
				else {
					list = (List<ChainAttachmentsStandards>)QueryUtil.list(q,
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
	 * Returns the first chain attachments standards in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a matching chain attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards findByAttachmentId_First(
		long attachmentId, OrderByComparator orderByComparator)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		ChainAttachmentsStandards chainAttachmentsStandards = fetchByAttachmentId_First(attachmentId,
				orderByComparator);

		if (chainAttachmentsStandards != null) {
			return chainAttachmentsStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the first chain attachments standards in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain attachments standards, or <code>null</code> if a matching chain attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards fetchByAttachmentId_First(
		long attachmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ChainAttachmentsStandards> list = findByAttachmentId(attachmentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chain attachments standards in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a matching chain attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards findByAttachmentId_Last(
		long attachmentId, OrderByComparator orderByComparator)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		ChainAttachmentsStandards chainAttachmentsStandards = fetchByAttachmentId_Last(attachmentId,
				orderByComparator);

		if (chainAttachmentsStandards != null) {
			return chainAttachmentsStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attachmentId=");
		msg.append(attachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainAttachmentsStandardsException(msg.toString());
	}

	/**
	 * Returns the last chain attachments standards in the ordered set where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain attachments standards, or <code>null</code> if a matching chain attachments standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards fetchByAttachmentId_Last(
		long attachmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAttachmentId(attachmentId);

		if (count == 0) {
			return null;
		}

		List<ChainAttachmentsStandards> list = findByAttachmentId(attachmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chain attachments standardses before and after the current chain attachments standards in the ordered set where attachmentId = &#63;.
	 *
	 * @param chainAttachmentId the primary key of the current chain attachments standards
	 * @param attachmentId the attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chain attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards[] findByAttachmentId_PrevAndNext(
		long chainAttachmentId, long attachmentId,
		OrderByComparator orderByComparator)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		ChainAttachmentsStandards chainAttachmentsStandards = findByPrimaryKey(chainAttachmentId);

		Session session = null;

		try {
			session = openSession();

			ChainAttachmentsStandards[] array = new ChainAttachmentsStandardsImpl[3];

			array[0] = getByAttachmentId_PrevAndNext(session,
					chainAttachmentsStandards, attachmentId, orderByComparator,
					true);

			array[1] = chainAttachmentsStandards;

			array[2] = getByAttachmentId_PrevAndNext(session,
					chainAttachmentsStandards, attachmentId, orderByComparator,
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

	protected ChainAttachmentsStandards getByAttachmentId_PrevAndNext(
		Session session, ChainAttachmentsStandards chainAttachmentsStandards,
		long attachmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHAINATTACHMENTSSTANDARDS_WHERE);

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
			query.append(ChainAttachmentsStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(attachmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chainAttachmentsStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChainAttachmentsStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chain attachments standardses where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAttachmentId(long attachmentId)
		throws SystemException {
		for (ChainAttachmentsStandards chainAttachmentsStandards : findByAttachmentId(
				attachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chainAttachmentsStandards);
		}
	}

	/**
	 * Returns the number of chain attachments standardses where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAttachmentId(long attachmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTACHMENTID;

		Object[] finderArgs = new Object[] { attachmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHAINATTACHMENTSSTANDARDS_WHERE);

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

	private static final String _FINDER_COLUMN_ATTACHMENTID_ATTACHMENTID_2 = "chainAttachmentsStandards.attachmentId = ?";

	public ChainAttachmentsStandardsPersistenceImpl() {
		setModelClass(ChainAttachmentsStandards.class);
	}

	/**
	 * Caches the chain attachments standards in the entity cache if it is enabled.
	 *
	 * @param chainAttachmentsStandards the chain attachments standards
	 */
	@Override
	public void cacheResult(ChainAttachmentsStandards chainAttachmentsStandards) {
		EntityCacheUtil.putResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			chainAttachmentsStandards.getPrimaryKey(), chainAttachmentsStandards);

		chainAttachmentsStandards.resetOriginalValues();
	}

	/**
	 * Caches the chain attachments standardses in the entity cache if it is enabled.
	 *
	 * @param chainAttachmentsStandardses the chain attachments standardses
	 */
	@Override
	public void cacheResult(
		List<ChainAttachmentsStandards> chainAttachmentsStandardses) {
		for (ChainAttachmentsStandards chainAttachmentsStandards : chainAttachmentsStandardses) {
			if (EntityCacheUtil.getResult(
						ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ChainAttachmentsStandardsImpl.class,
						chainAttachmentsStandards.getPrimaryKey()) == null) {
				cacheResult(chainAttachmentsStandards);
			}
			else {
				chainAttachmentsStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chain attachments standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChainAttachmentsStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChainAttachmentsStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chain attachments standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChainAttachmentsStandards chainAttachmentsStandards) {
		EntityCacheUtil.removeResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			chainAttachmentsStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ChainAttachmentsStandards> chainAttachmentsStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChainAttachmentsStandards chainAttachmentsStandards : chainAttachmentsStandardses) {
			EntityCacheUtil.removeResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ChainAttachmentsStandardsImpl.class,
				chainAttachmentsStandards.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chain attachments standards with the primary key. Does not add the chain attachments standards to the database.
	 *
	 * @param chainAttachmentId the primary key for the new chain attachments standards
	 * @return the new chain attachments standards
	 */
	@Override
	public ChainAttachmentsStandards create(long chainAttachmentId) {
		ChainAttachmentsStandards chainAttachmentsStandards = new ChainAttachmentsStandardsImpl();

		chainAttachmentsStandards.setNew(true);
		chainAttachmentsStandards.setPrimaryKey(chainAttachmentId);

		return chainAttachmentsStandards;
	}

	/**
	 * Removes the chain attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chainAttachmentId the primary key of the chain attachments standards
	 * @return the chain attachments standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards remove(long chainAttachmentId)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		return remove((Serializable)chainAttachmentId);
	}

	/**
	 * Removes the chain attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chain attachments standards
	 * @return the chain attachments standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards remove(Serializable primaryKey)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChainAttachmentsStandards chainAttachmentsStandards = (ChainAttachmentsStandards)session.get(ChainAttachmentsStandardsImpl.class,
					primaryKey);

			if (chainAttachmentsStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChainAttachmentsStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chainAttachmentsStandards);
		}
		catch (NoSuchChainAttachmentsStandardsException nsee) {
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
	protected ChainAttachmentsStandards removeImpl(
		ChainAttachmentsStandards chainAttachmentsStandards)
		throws SystemException {
		chainAttachmentsStandards = toUnwrappedModel(chainAttachmentsStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chainAttachmentsStandards)) {
				chainAttachmentsStandards = (ChainAttachmentsStandards)session.get(ChainAttachmentsStandardsImpl.class,
						chainAttachmentsStandards.getPrimaryKeyObj());
			}

			if (chainAttachmentsStandards != null) {
				session.delete(chainAttachmentsStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chainAttachmentsStandards != null) {
			clearCache(chainAttachmentsStandards);
		}

		return chainAttachmentsStandards;
	}

	@Override
	public ChainAttachmentsStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainAttachmentsStandards chainAttachmentsStandards)
		throws SystemException {
		chainAttachmentsStandards = toUnwrappedModel(chainAttachmentsStandards);

		boolean isNew = chainAttachmentsStandards.isNew();

		ChainAttachmentsStandardsModelImpl chainAttachmentsStandardsModelImpl = (ChainAttachmentsStandardsModelImpl)chainAttachmentsStandards;

		Session session = null;

		try {
			session = openSession();

			if (chainAttachmentsStandards.isNew()) {
				session.save(chainAttachmentsStandards);

				chainAttachmentsStandards.setNew(false);
			}
			else {
				session.merge(chainAttachmentsStandards);
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
				!ChainAttachmentsStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chainAttachmentsStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chainAttachmentsStandardsModelImpl.getOriginalAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID,
					args);

				args = new Object[] {
						chainAttachmentsStandardsModelImpl.getAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTACHMENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainAttachmentsStandardsImpl.class,
			chainAttachmentsStandards.getPrimaryKey(), chainAttachmentsStandards);

		return chainAttachmentsStandards;
	}

	protected ChainAttachmentsStandards toUnwrappedModel(
		ChainAttachmentsStandards chainAttachmentsStandards) {
		if (chainAttachmentsStandards instanceof ChainAttachmentsStandardsImpl) {
			return chainAttachmentsStandards;
		}

		ChainAttachmentsStandardsImpl chainAttachmentsStandardsImpl = new ChainAttachmentsStandardsImpl();

		chainAttachmentsStandardsImpl.setNew(chainAttachmentsStandards.isNew());
		chainAttachmentsStandardsImpl.setPrimaryKey(chainAttachmentsStandards.getPrimaryKey());

		chainAttachmentsStandardsImpl.setChainAttachmentId(chainAttachmentsStandards.getChainAttachmentId());
		chainAttachmentsStandardsImpl.setAttachmentId(chainAttachmentsStandards.getAttachmentId());
		chainAttachmentsStandardsImpl.setLocaleCode(chainAttachmentsStandards.getLocaleCode());
		chainAttachmentsStandardsImpl.setChainCode(chainAttachmentsStandards.getChainCode());
		chainAttachmentsStandardsImpl.setCreatorId(chainAttachmentsStandards.getCreatorId());
		chainAttachmentsStandardsImpl.setCreatedDate(chainAttachmentsStandards.getCreatedDate());
		chainAttachmentsStandardsImpl.setUpdatedBy(chainAttachmentsStandards.getUpdatedBy());
		chainAttachmentsStandardsImpl.setUpdatedDate(chainAttachmentsStandards.getUpdatedDate());

		return chainAttachmentsStandardsImpl;
	}

	/**
	 * Returns the chain attachments standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chain attachments standards
	 * @return the chain attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		ChainAttachmentsStandards chainAttachmentsStandards = fetchByPrimaryKey(primaryKey);

		if (chainAttachmentsStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChainAttachmentsStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chainAttachmentsStandards;
	}

	/**
	 * Returns the chain attachments standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException} if it could not be found.
	 *
	 * @param chainAttachmentId the primary key of the chain attachments standards
	 * @return the chain attachments standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards findByPrimaryKey(long chainAttachmentId)
		throws NoSuchChainAttachmentsStandardsException, SystemException {
		return findByPrimaryKey((Serializable)chainAttachmentId);
	}

	/**
	 * Returns the chain attachments standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chain attachments standards
	 * @return the chain attachments standards, or <code>null</code> if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChainAttachmentsStandards chainAttachmentsStandards = (ChainAttachmentsStandards)EntityCacheUtil.getResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ChainAttachmentsStandardsImpl.class, primaryKey);

		if (chainAttachmentsStandards == _nullChainAttachmentsStandards) {
			return null;
		}

		if (chainAttachmentsStandards == null) {
			Session session = null;

			try {
				session = openSession();

				chainAttachmentsStandards = (ChainAttachmentsStandards)session.get(ChainAttachmentsStandardsImpl.class,
						primaryKey);

				if (chainAttachmentsStandards != null) {
					cacheResult(chainAttachmentsStandards);
				}
				else {
					EntityCacheUtil.putResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ChainAttachmentsStandardsImpl.class, primaryKey,
						_nullChainAttachmentsStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChainAttachmentsStandardsModelImpl.ENTITY_CACHE_ENABLED,
					ChainAttachmentsStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chainAttachmentsStandards;
	}

	/**
	 * Returns the chain attachments standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chainAttachmentId the primary key of the chain attachments standards
	 * @return the chain attachments standards, or <code>null</code> if a chain attachments standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainAttachmentsStandards fetchByPrimaryKey(long chainAttachmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)chainAttachmentId);
	}

	/**
	 * Returns all the chain attachments standardses.
	 *
	 * @return the chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainAttachmentsStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chain attachments standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chain attachments standardses
	 * @param end the upper bound of the range of chain attachments standardses (not inclusive)
	 * @return the range of chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainAttachmentsStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain attachments standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chain attachments standardses
	 * @param end the upper bound of the range of chain attachments standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chain attachments standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainAttachmentsStandards> findAll(int start, int end,
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

		List<ChainAttachmentsStandards> list = (List<ChainAttachmentsStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHAINATTACHMENTSSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHAINATTACHMENTSSTANDARDS;

				if (pagination) {
					sql = sql.concat(ChainAttachmentsStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChainAttachmentsStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainAttachmentsStandards>(list);
				}
				else {
					list = (List<ChainAttachmentsStandards>)QueryUtil.list(q,
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
	 * Removes all the chain attachments standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChainAttachmentsStandards chainAttachmentsStandards : findAll()) {
			remove(chainAttachmentsStandards);
		}
	}

	/**
	 * Returns the number of chain attachments standardses.
	 *
	 * @return the number of chain attachments standardses
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

				Query q = session.createQuery(_SQL_COUNT_CHAINATTACHMENTSSTANDARDS);

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
	 * Initializes the chain attachments standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.ChainAttachmentsStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChainAttachmentsStandards>> listenersList = new ArrayList<ModelListener<ChainAttachmentsStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChainAttachmentsStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChainAttachmentsStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHAINATTACHMENTSSTANDARDS = "SELECT chainAttachmentsStandards FROM ChainAttachmentsStandards chainAttachmentsStandards";
	private static final String _SQL_SELECT_CHAINATTACHMENTSSTANDARDS_WHERE = "SELECT chainAttachmentsStandards FROM ChainAttachmentsStandards chainAttachmentsStandards WHERE ";
	private static final String _SQL_COUNT_CHAINATTACHMENTSSTANDARDS = "SELECT COUNT(chainAttachmentsStandards) FROM ChainAttachmentsStandards chainAttachmentsStandards";
	private static final String _SQL_COUNT_CHAINATTACHMENTSSTANDARDS_WHERE = "SELECT COUNT(chainAttachmentsStandards) FROM ChainAttachmentsStandards chainAttachmentsStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chainAttachmentsStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChainAttachmentsStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChainAttachmentsStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChainAttachmentsStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"chainAttachmentId", "attachmentId", "localeCode", "chainCode",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static ChainAttachmentsStandards _nullChainAttachmentsStandards = new ChainAttachmentsStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChainAttachmentsStandards> toCacheModel() {
				return _nullChainAttachmentsStandardsCacheModel;
			}
		};

	private static CacheModel<ChainAttachmentsStandards> _nullChainAttachmentsStandardsCacheModel =
		new CacheModel<ChainAttachmentsStandards>() {
			@Override
			public ChainAttachmentsStandards toEntityModel() {
				return _nullChainAttachmentsStandards;
			}
		};
}