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

import com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException;
import com.ihg.brandstandards.db.model.GEMTemplateReference;
import com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl;

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
 * The persistence implementation for the g e m template reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateReferencePersistence
 * @see GEMTemplateReferenceUtil
 * @generated
 */
public class GEMTemplateReferencePersistenceImpl extends BasePersistenceImpl<GEMTemplateReference>
	implements GEMTemplateReferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMTemplateReferenceUtil} to access the g e m template reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMTemplateReferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDRGNID =
		new FinderPath(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishIdAndRgnId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID =
		new FinderPath(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndRgnId",
			new String[] { Long.class.getName(), Long.class.getName() },
			GEMTemplateReferenceModelImpl.PUBLISHDEPTID_COLUMN_BITMASK |
			GEMTemplateReferenceModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID = new FinderPath(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndRgnId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @return the matching g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId) throws SystemException {
		return findByPublishIdAndRgnId(publishDeptId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of g e m template references
	 * @param end the upper bound of the range of g e m template references (not inclusive)
	 * @return the range of matching g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId, int start, int end)
		throws SystemException {
		return findByPublishIdAndRgnId(publishDeptId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of g e m template references
	 * @param end the upper bound of the range of g e m template references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID;
			finderArgs = new Object[] { publishDeptId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDRGNID;
			finderArgs = new Object[] {
					publishDeptId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<GEMTemplateReference> list = (List<GEMTemplateReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplateReference gemTemplateReference : list) {
				if ((publishDeptId != gemTemplateReference.getPublishDeptId()) ||
						(regionId != gemTemplateReference.getRegionId())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATEREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHDEPTID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishDeptId);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<GEMTemplateReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplateReference>(list);
				}
				else {
					list = (List<GEMTemplateReference>)QueryUtil.list(q,
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
	 * Returns the first g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template reference
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a matching g e m template reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference findByPublishIdAndRgnId_First(
		long publishDeptId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		GEMTemplateReference gemTemplateReference = fetchByPublishIdAndRgnId_First(publishDeptId,
				regionId, orderByComparator);

		if (gemTemplateReference != null) {
			return gemTemplateReference;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishDeptId=");
		msg.append(publishDeptId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateReferenceException(msg.toString());
	}

	/**
	 * Returns the first g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template reference, or <code>null</code> if a matching g e m template reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference fetchByPublishIdAndRgnId_First(
		long publishDeptId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMTemplateReference> list = findByPublishIdAndRgnId(publishDeptId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template reference
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a matching g e m template reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference findByPublishIdAndRgnId_Last(
		long publishDeptId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		GEMTemplateReference gemTemplateReference = fetchByPublishIdAndRgnId_Last(publishDeptId,
				regionId, orderByComparator);

		if (gemTemplateReference != null) {
			return gemTemplateReference;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishDeptId=");
		msg.append(publishDeptId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateReferenceException(msg.toString());
	}

	/**
	 * Returns the last g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template reference, or <code>null</code> if a matching g e m template reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference fetchByPublishIdAndRgnId_Last(
		long publishDeptId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndRgnId(publishDeptId, regionId);

		if (count == 0) {
			return null;
		}

		List<GEMTemplateReference> list = findByPublishIdAndRgnId(publishDeptId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m template references before and after the current g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param templateRefId the primary key of the current g e m template reference
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template reference
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference[] findByPublishIdAndRgnId_PrevAndNext(
		long templateRefId, long publishDeptId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		GEMTemplateReference gemTemplateReference = findByPrimaryKey(templateRefId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplateReference[] array = new GEMTemplateReferenceImpl[3];

			array[0] = getByPublishIdAndRgnId_PrevAndNext(session,
					gemTemplateReference, publishDeptId, regionId,
					orderByComparator, true);

			array[1] = gemTemplateReference;

			array[2] = getByPublishIdAndRgnId_PrevAndNext(session,
					gemTemplateReference, publishDeptId, regionId,
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

	protected GEMTemplateReference getByPublishIdAndRgnId_PrevAndNext(
		Session session, GEMTemplateReference gemTemplateReference,
		long publishDeptId, long regionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATEREFERENCE_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHDEPTID_2);

		query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2);

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
			query.append(GEMTemplateReferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishDeptId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplateReference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplateReference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m template references where publishDeptId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndRgnId(long publishDeptId, long regionId)
		throws SystemException {
		for (GEMTemplateReference gemTemplateReference : findByPublishIdAndRgnId(
				publishDeptId, regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(gemTemplateReference);
		}
	}

	/**
	 * Returns the number of g e m template references where publishDeptId = &#63; and regionId = &#63;.
	 *
	 * @param publishDeptId the publish dept ID
	 * @param regionId the region ID
	 * @return the number of matching g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndRgnId(long publishDeptId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID;

		Object[] finderArgs = new Object[] { publishDeptId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMTEMPLATEREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHDEPTID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishDeptId);

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHDEPTID_2 =
		"gemTemplateReference.publishDeptId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2 = "gemTemplateReference.regionId = ?";

	public GEMTemplateReferencePersistenceImpl() {
		setModelClass(GEMTemplateReference.class);
	}

	/**
	 * Caches the g e m template reference in the entity cache if it is enabled.
	 *
	 * @param gemTemplateReference the g e m template reference
	 */
	@Override
	public void cacheResult(GEMTemplateReference gemTemplateReference) {
		EntityCacheUtil.putResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class,
			gemTemplateReference.getPrimaryKey(), gemTemplateReference);

		gemTemplateReference.resetOriginalValues();
	}

	/**
	 * Caches the g e m template references in the entity cache if it is enabled.
	 *
	 * @param gemTemplateReferences the g e m template references
	 */
	@Override
	public void cacheResult(List<GEMTemplateReference> gemTemplateReferences) {
		for (GEMTemplateReference gemTemplateReference : gemTemplateReferences) {
			if (EntityCacheUtil.getResult(
						GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateReferenceImpl.class,
						gemTemplateReference.getPrimaryKey()) == null) {
				cacheResult(gemTemplateReference);
			}
			else {
				gemTemplateReference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m template references.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMTemplateReferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMTemplateReferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m template reference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMTemplateReference gemTemplateReference) {
		EntityCacheUtil.removeResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class, gemTemplateReference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMTemplateReference> gemTemplateReferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMTemplateReference gemTemplateReference : gemTemplateReferences) {
			EntityCacheUtil.removeResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateReferenceImpl.class,
				gemTemplateReference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m template reference with the primary key. Does not add the g e m template reference to the database.
	 *
	 * @param templateRefId the primary key for the new g e m template reference
	 * @return the new g e m template reference
	 */
	@Override
	public GEMTemplateReference create(long templateRefId) {
		GEMTemplateReference gemTemplateReference = new GEMTemplateReferenceImpl();

		gemTemplateReference.setNew(true);
		gemTemplateReference.setPrimaryKey(templateRefId);

		return gemTemplateReference;
	}

	/**
	 * Removes the g e m template reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateRefId the primary key of the g e m template reference
	 * @return the g e m template reference that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference remove(long templateRefId)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		return remove((Serializable)templateRefId);
	}

	/**
	 * Removes the g e m template reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m template reference
	 * @return the g e m template reference that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference remove(Serializable primaryKey)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMTemplateReference gemTemplateReference = (GEMTemplateReference)session.get(GEMTemplateReferenceImpl.class,
					primaryKey);

			if (gemTemplateReference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMTemplateReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemTemplateReference);
		}
		catch (NoSuchGEMTemplateReferenceException nsee) {
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
	protected GEMTemplateReference removeImpl(
		GEMTemplateReference gemTemplateReference) throws SystemException {
		gemTemplateReference = toUnwrappedModel(gemTemplateReference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemTemplateReference)) {
				gemTemplateReference = (GEMTemplateReference)session.get(GEMTemplateReferenceImpl.class,
						gemTemplateReference.getPrimaryKeyObj());
			}

			if (gemTemplateReference != null) {
				session.delete(gemTemplateReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemTemplateReference != null) {
			clearCache(gemTemplateReference);
		}

		return gemTemplateReference;
	}

	@Override
	public GEMTemplateReference updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateReference gemTemplateReference)
		throws SystemException {
		gemTemplateReference = toUnwrappedModel(gemTemplateReference);

		boolean isNew = gemTemplateReference.isNew();

		GEMTemplateReferenceModelImpl gemTemplateReferenceModelImpl = (GEMTemplateReferenceModelImpl)gemTemplateReference;

		Session session = null;

		try {
			session = openSession();

			if (gemTemplateReference.isNew()) {
				session.save(gemTemplateReference);

				gemTemplateReference.setNew(false);
			}
			else {
				session.merge(gemTemplateReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMTemplateReferenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemTemplateReferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateReferenceModelImpl.getOriginalPublishDeptId(),
						gemTemplateReferenceModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID,
					args);

				args = new Object[] {
						gemTemplateReferenceModelImpl.getPublishDeptId(),
						gemTemplateReferenceModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateReferenceImpl.class,
			gemTemplateReference.getPrimaryKey(), gemTemplateReference);

		return gemTemplateReference;
	}

	protected GEMTemplateReference toUnwrappedModel(
		GEMTemplateReference gemTemplateReference) {
		if (gemTemplateReference instanceof GEMTemplateReferenceImpl) {
			return gemTemplateReference;
		}

		GEMTemplateReferenceImpl gemTemplateReferenceImpl = new GEMTemplateReferenceImpl();

		gemTemplateReferenceImpl.setNew(gemTemplateReference.isNew());
		gemTemplateReferenceImpl.setPrimaryKey(gemTemplateReference.getPrimaryKey());

		gemTemplateReferenceImpl.setTemplateRefId(gemTemplateReference.getTemplateRefId());
		gemTemplateReferenceImpl.setTemplateId(gemTemplateReference.getTemplateId());
		gemTemplateReferenceImpl.setPublishDeptId(gemTemplateReference.getPublishDeptId());
		gemTemplateReferenceImpl.setRegionId(gemTemplateReference.getRegionId());
		gemTemplateReferenceImpl.setCreatorId(gemTemplateReference.getCreatorId());
		gemTemplateReferenceImpl.setCreatedDate(gemTemplateReference.getCreatedDate());
		gemTemplateReferenceImpl.setUpdatedBy(gemTemplateReference.getUpdatedBy());
		gemTemplateReferenceImpl.setUpdatedDate(gemTemplateReference.getUpdatedDate());

		return gemTemplateReferenceImpl;
	}

	/**
	 * Returns the g e m template reference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template reference
	 * @return the g e m template reference
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		GEMTemplateReference gemTemplateReference = fetchByPrimaryKey(primaryKey);

		if (gemTemplateReference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMTemplateReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemTemplateReference;
	}

	/**
	 * Returns the g e m template reference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException} if it could not be found.
	 *
	 * @param templateRefId the primary key of the g e m template reference
	 * @return the g e m template reference
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference findByPrimaryKey(long templateRefId)
		throws NoSuchGEMTemplateReferenceException, SystemException {
		return findByPrimaryKey((Serializable)templateRefId);
	}

	/**
	 * Returns the g e m template reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template reference
	 * @return the g e m template reference, or <code>null</code> if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMTemplateReference gemTemplateReference = (GEMTemplateReference)EntityCacheUtil.getResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateReferenceImpl.class, primaryKey);

		if (gemTemplateReference == _nullGEMTemplateReference) {
			return null;
		}

		if (gemTemplateReference == null) {
			Session session = null;

			try {
				session = openSession();

				gemTemplateReference = (GEMTemplateReference)session.get(GEMTemplateReferenceImpl.class,
						primaryKey);

				if (gemTemplateReference != null) {
					cacheResult(gemTemplateReference);
				}
				else {
					EntityCacheUtil.putResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateReferenceImpl.class, primaryKey,
						_nullGEMTemplateReference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMTemplateReferenceModelImpl.ENTITY_CACHE_ENABLED,
					GEMTemplateReferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemTemplateReference;
	}

	/**
	 * Returns the g e m template reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateRefId the primary key of the g e m template reference
	 * @return the g e m template reference, or <code>null</code> if a g e m template reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateReference fetchByPrimaryKey(long templateRefId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)templateRefId);
	}

	/**
	 * Returns all the g e m template references.
	 *
	 * @return the g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateReference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m template references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template references
	 * @param end the upper bound of the range of g e m template references (not inclusive)
	 * @return the range of g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateReference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m template references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template references
	 * @param end the upper bound of the range of g e m template references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m template references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateReference> findAll(int start, int end,
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

		List<GEMTemplateReference> list = (List<GEMTemplateReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMTEMPLATEREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMTEMPLATEREFERENCE;

				if (pagination) {
					sql = sql.concat(GEMTemplateReferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMTemplateReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplateReference>(list);
				}
				else {
					list = (List<GEMTemplateReference>)QueryUtil.list(q,
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
	 * Removes all the g e m template references from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMTemplateReference gemTemplateReference : findAll()) {
			remove(gemTemplateReference);
		}
	}

	/**
	 * Returns the number of g e m template references.
	 *
	 * @return the number of g e m template references
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

				Query q = session.createQuery(_SQL_COUNT_GEMTEMPLATEREFERENCE);

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
	 * Initializes the g e m template reference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMTemplateReference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMTemplateReference>> listenersList = new ArrayList<ModelListener<GEMTemplateReference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMTemplateReference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMTemplateReferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMTEMPLATEREFERENCE = "SELECT gemTemplateReference FROM GEMTemplateReference gemTemplateReference";
	private static final String _SQL_SELECT_GEMTEMPLATEREFERENCE_WHERE = "SELECT gemTemplateReference FROM GEMTemplateReference gemTemplateReference WHERE ";
	private static final String _SQL_COUNT_GEMTEMPLATEREFERENCE = "SELECT COUNT(gemTemplateReference) FROM GEMTemplateReference gemTemplateReference";
	private static final String _SQL_COUNT_GEMTEMPLATEREFERENCE_WHERE = "SELECT COUNT(gemTemplateReference) FROM GEMTemplateReference gemTemplateReference WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemTemplateReference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMTemplateReference exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMTemplateReference exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMTemplateReferencePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"templateRefId", "templateId", "publishDeptId", "regionId",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GEMTemplateReference _nullGEMTemplateReference = new GEMTemplateReferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMTemplateReference> toCacheModel() {
				return _nullGEMTemplateReferenceCacheModel;
			}
		};

	private static CacheModel<GEMTemplateReference> _nullGEMTemplateReferenceCacheModel =
		new CacheModel<GEMTemplateReference>() {
			@Override
			public GEMTemplateReference toEntityModel() {
				return _nullGEMTemplateReference;
			}
		};
}