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

import com.ihg.brandstandards.db.NoSuchStandardsChainImagesException;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.impl.StandardsChainImagesImpl;
import com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl;

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
 * The persistence implementation for the standards chain images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsChainImagesPersistence
 * @see StandardsChainImagesUtil
 * @generated
 */
public class StandardsChainImagesPersistenceImpl extends BasePersistenceImpl<StandardsChainImages>
	implements StandardsChainImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsChainImagesUtil} to access the standards chain images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsChainImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsChainImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsChainImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIMAGEID =
		new FinderPath(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsChainImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystdImageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID =
		new FinderPath(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsChainImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystdImageId",
			new String[] { Long.class.getName() },
			StandardsChainImagesModelImpl.STDIMAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIMAGEID = new FinderPath(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdImageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards chain imageses where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @return the matching standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsChainImages> findBystdImageId(long stdImageId)
		throws SystemException {
		return findBystdImageId(stdImageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards chain imageses where stdImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdImageId the std image ID
	 * @param start the lower bound of the range of standards chain imageses
	 * @param end the upper bound of the range of standards chain imageses (not inclusive)
	 * @return the range of matching standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsChainImages> findBystdImageId(long stdImageId,
		int start, int end) throws SystemException {
		return findBystdImageId(stdImageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards chain imageses where stdImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdImageId the std image ID
	 * @param start the lower bound of the range of standards chain imageses
	 * @param end the upper bound of the range of standards chain imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsChainImages> findBystdImageId(long stdImageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID;
			finderArgs = new Object[] { stdImageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIMAGEID;
			finderArgs = new Object[] { stdImageId, start, end, orderByComparator };
		}

		List<StandardsChainImages> list = (List<StandardsChainImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsChainImages standardsChainImages : list) {
				if ((stdImageId != standardsChainImages.getStdImageId())) {
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

			query.append(_SQL_SELECT_STANDARDSCHAINIMAGES_WHERE);

			query.append(_FINDER_COLUMN_STDIMAGEID_STDIMAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsChainImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdImageId);

				if (!pagination) {
					list = (List<StandardsChainImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsChainImages>(list);
				}
				else {
					list = (List<StandardsChainImages>)QueryUtil.list(q,
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
	 * Returns the first standards chain images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards chain images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a matching standards chain images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages findBystdImageId_First(long stdImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsChainImagesException, SystemException {
		StandardsChainImages standardsChainImages = fetchBystdImageId_First(stdImageId,
				orderByComparator);

		if (standardsChainImages != null) {
			return standardsChainImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdImageId=");
		msg.append(stdImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsChainImagesException(msg.toString());
	}

	/**
	 * Returns the first standards chain images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards chain images, or <code>null</code> if a matching standards chain images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages fetchBystdImageId_First(long stdImageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsChainImages> list = findBystdImageId(stdImageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards chain images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards chain images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a matching standards chain images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages findBystdImageId_Last(long stdImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsChainImagesException, SystemException {
		StandardsChainImages standardsChainImages = fetchBystdImageId_Last(stdImageId,
				orderByComparator);

		if (standardsChainImages != null) {
			return standardsChainImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdImageId=");
		msg.append(stdImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsChainImagesException(msg.toString());
	}

	/**
	 * Returns the last standards chain images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards chain images, or <code>null</code> if a matching standards chain images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages fetchBystdImageId_Last(long stdImageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystdImageId(stdImageId);

		if (count == 0) {
			return null;
		}

		List<StandardsChainImages> list = findBystdImageId(stdImageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards chain imageses before and after the current standards chain images in the ordered set where stdImageId = &#63;.
	 *
	 * @param standardsChainImagesPK the primary key of the current standards chain images
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards chain images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages[] findBystdImageId_PrevAndNext(
		StandardsChainImagesPK standardsChainImagesPK, long stdImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsChainImagesException, SystemException {
		StandardsChainImages standardsChainImages = findByPrimaryKey(standardsChainImagesPK);

		Session session = null;

		try {
			session = openSession();

			StandardsChainImages[] array = new StandardsChainImagesImpl[3];

			array[0] = getBystdImageId_PrevAndNext(session,
					standardsChainImages, stdImageId, orderByComparator, true);

			array[1] = standardsChainImages;

			array[2] = getBystdImageId_PrevAndNext(session,
					standardsChainImages, stdImageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsChainImages getBystdImageId_PrevAndNext(
		Session session, StandardsChainImages standardsChainImages,
		long stdImageId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCHAINIMAGES_WHERE);

		query.append(_FINDER_COLUMN_STDIMAGEID_STDIMAGEID_2);

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
			query.append(StandardsChainImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdImageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsChainImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsChainImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards chain imageses where stdImageId = &#63; from the database.
	 *
	 * @param stdImageId the std image ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdImageId(long stdImageId) throws SystemException {
		for (StandardsChainImages standardsChainImages : findBystdImageId(
				stdImageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsChainImages);
		}
	}

	/**
	 * Returns the number of standards chain imageses where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @return the number of matching standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdImageId(long stdImageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIMAGEID;

		Object[] finderArgs = new Object[] { stdImageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSCHAINIMAGES_WHERE);

			query.append(_FINDER_COLUMN_STDIMAGEID_STDIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdImageId);

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

	private static final String _FINDER_COLUMN_STDIMAGEID_STDIMAGEID_2 = "standardsChainImages.id.stdImageId = ?";

	public StandardsChainImagesPersistenceImpl() {
		setModelClass(StandardsChainImages.class);
	}

	/**
	 * Caches the standards chain images in the entity cache if it is enabled.
	 *
	 * @param standardsChainImages the standards chain images
	 */
	@Override
	public void cacheResult(StandardsChainImages standardsChainImages) {
		EntityCacheUtil.putResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesImpl.class,
			standardsChainImages.getPrimaryKey(), standardsChainImages);

		standardsChainImages.resetOriginalValues();
	}

	/**
	 * Caches the standards chain imageses in the entity cache if it is enabled.
	 *
	 * @param standardsChainImageses the standards chain imageses
	 */
	@Override
	public void cacheResult(List<StandardsChainImages> standardsChainImageses) {
		for (StandardsChainImages standardsChainImages : standardsChainImageses) {
			if (EntityCacheUtil.getResult(
						StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
						StandardsChainImagesImpl.class,
						standardsChainImages.getPrimaryKey()) == null) {
				cacheResult(standardsChainImages);
			}
			else {
				standardsChainImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards chain imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsChainImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsChainImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards chain images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsChainImages standardsChainImages) {
		EntityCacheUtil.removeResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesImpl.class, standardsChainImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsChainImages> standardsChainImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsChainImages standardsChainImages : standardsChainImageses) {
			EntityCacheUtil.removeResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
				StandardsChainImagesImpl.class,
				standardsChainImages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards chain images with the primary key. Does not add the standards chain images to the database.
	 *
	 * @param standardsChainImagesPK the primary key for the new standards chain images
	 * @return the new standards chain images
	 */
	@Override
	public StandardsChainImages create(
		StandardsChainImagesPK standardsChainImagesPK) {
		StandardsChainImages standardsChainImages = new StandardsChainImagesImpl();

		standardsChainImages.setNew(true);
		standardsChainImages.setPrimaryKey(standardsChainImagesPK);

		return standardsChainImages;
	}

	/**
	 * Removes the standards chain images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsChainImagesPK the primary key of the standards chain images
	 * @return the standards chain images that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages remove(
		StandardsChainImagesPK standardsChainImagesPK)
		throws NoSuchStandardsChainImagesException, SystemException {
		return remove((Serializable)standardsChainImagesPK);
	}

	/**
	 * Removes the standards chain images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards chain images
	 * @return the standards chain images that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages remove(Serializable primaryKey)
		throws NoSuchStandardsChainImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsChainImages standardsChainImages = (StandardsChainImages)session.get(StandardsChainImagesImpl.class,
					primaryKey);

			if (standardsChainImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsChainImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsChainImages);
		}
		catch (NoSuchStandardsChainImagesException nsee) {
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
	protected StandardsChainImages removeImpl(
		StandardsChainImages standardsChainImages) throws SystemException {
		standardsChainImages = toUnwrappedModel(standardsChainImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsChainImages)) {
				standardsChainImages = (StandardsChainImages)session.get(StandardsChainImagesImpl.class,
						standardsChainImages.getPrimaryKeyObj());
			}

			if (standardsChainImages != null) {
				session.delete(standardsChainImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsChainImages != null) {
			clearCache(standardsChainImages);
		}

		return standardsChainImages;
	}

	@Override
	public StandardsChainImages updateImpl(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws SystemException {
		standardsChainImages = toUnwrappedModel(standardsChainImages);

		boolean isNew = standardsChainImages.isNew();

		StandardsChainImagesModelImpl standardsChainImagesModelImpl = (StandardsChainImagesModelImpl)standardsChainImages;

		Session session = null;

		try {
			session = openSession();

			if (standardsChainImages.isNew()) {
				session.save(standardsChainImages);

				standardsChainImages.setNew(false);
			}
			else {
				session.merge(standardsChainImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsChainImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsChainImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsChainImagesModelImpl.getOriginalStdImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIMAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID,
					args);

				args = new Object[] {
						standardsChainImagesModelImpl.getStdImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIMAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsChainImagesImpl.class,
			standardsChainImages.getPrimaryKey(), standardsChainImages);

		return standardsChainImages;
	}

	protected StandardsChainImages toUnwrappedModel(
		StandardsChainImages standardsChainImages) {
		if (standardsChainImages instanceof StandardsChainImagesImpl) {
			return standardsChainImages;
		}

		StandardsChainImagesImpl standardsChainImagesImpl = new StandardsChainImagesImpl();

		standardsChainImagesImpl.setNew(standardsChainImages.isNew());
		standardsChainImagesImpl.setPrimaryKey(standardsChainImages.getPrimaryKey());

		standardsChainImagesImpl.setStdImageId(standardsChainImages.getStdImageId());
		standardsChainImagesImpl.setChainCode(standardsChainImages.getChainCode());
		standardsChainImagesImpl.setCreatorId(standardsChainImages.getCreatorId());
		standardsChainImagesImpl.setCreatedDate(standardsChainImages.getCreatedDate());
		standardsChainImagesImpl.setUpdatedBy(standardsChainImages.getUpdatedBy());
		standardsChainImagesImpl.setUpdatedDate(standardsChainImages.getUpdatedDate());

		return standardsChainImagesImpl;
	}

	/**
	 * Returns the standards chain images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards chain images
	 * @return the standards chain images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsChainImagesException, SystemException {
		StandardsChainImages standardsChainImages = fetchByPrimaryKey(primaryKey);

		if (standardsChainImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsChainImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsChainImages;
	}

	/**
	 * Returns the standards chain images with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsChainImagesException} if it could not be found.
	 *
	 * @param standardsChainImagesPK the primary key of the standards chain images
	 * @return the standards chain images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages findByPrimaryKey(
		StandardsChainImagesPK standardsChainImagesPK)
		throws NoSuchStandardsChainImagesException, SystemException {
		return findByPrimaryKey((Serializable)standardsChainImagesPK);
	}

	/**
	 * Returns the standards chain images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards chain images
	 * @return the standards chain images, or <code>null</code> if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsChainImages standardsChainImages = (StandardsChainImages)EntityCacheUtil.getResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
				StandardsChainImagesImpl.class, primaryKey);

		if (standardsChainImages == _nullStandardsChainImages) {
			return null;
		}

		if (standardsChainImages == null) {
			Session session = null;

			try {
				session = openSession();

				standardsChainImages = (StandardsChainImages)session.get(StandardsChainImagesImpl.class,
						primaryKey);

				if (standardsChainImages != null) {
					cacheResult(standardsChainImages);
				}
				else {
					EntityCacheUtil.putResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
						StandardsChainImagesImpl.class, primaryKey,
						_nullStandardsChainImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsChainImagesModelImpl.ENTITY_CACHE_ENABLED,
					StandardsChainImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsChainImages;
	}

	/**
	 * Returns the standards chain images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsChainImagesPK the primary key of the standards chain images
	 * @return the standards chain images, or <code>null</code> if a standards chain images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsChainImages fetchByPrimaryKey(
		StandardsChainImagesPK standardsChainImagesPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsChainImagesPK);
	}

	/**
	 * Returns all the standards chain imageses.
	 *
	 * @return the standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsChainImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards chain imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards chain imageses
	 * @param end the upper bound of the range of standards chain imageses (not inclusive)
	 * @return the range of standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsChainImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards chain imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards chain imageses
	 * @param end the upper bound of the range of standards chain imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards chain imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsChainImages> findAll(int start, int end,
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

		List<StandardsChainImages> list = (List<StandardsChainImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCHAINIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCHAINIMAGES;

				if (pagination) {
					sql = sql.concat(StandardsChainImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsChainImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsChainImages>(list);
				}
				else {
					list = (List<StandardsChainImages>)QueryUtil.list(q,
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
	 * Removes all the standards chain imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsChainImages standardsChainImages : findAll()) {
			remove(standardsChainImages);
		}
	}

	/**
	 * Returns the number of standards chain imageses.
	 *
	 * @return the number of standards chain imageses
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCHAINIMAGES);

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
	 * Initializes the standards chain images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsChainImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsChainImages>> listenersList = new ArrayList<ModelListener<StandardsChainImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsChainImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsChainImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCHAINIMAGES = "SELECT standardsChainImages FROM StandardsChainImages standardsChainImages";
	private static final String _SQL_SELECT_STANDARDSCHAINIMAGES_WHERE = "SELECT standardsChainImages FROM StandardsChainImages standardsChainImages WHERE ";
	private static final String _SQL_COUNT_STANDARDSCHAINIMAGES = "SELECT COUNT(standardsChainImages) FROM StandardsChainImages standardsChainImages";
	private static final String _SQL_COUNT_STANDARDSCHAINIMAGES_WHERE = "SELECT COUNT(standardsChainImages) FROM StandardsChainImages standardsChainImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsChainImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsChainImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsChainImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsChainImagesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdImageId", "chainCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static StandardsChainImages _nullStandardsChainImages = new StandardsChainImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsChainImages> toCacheModel() {
				return _nullStandardsChainImagesCacheModel;
			}
		};

	private static CacheModel<StandardsChainImages> _nullStandardsChainImagesCacheModel =
		new CacheModel<StandardsChainImages>() {
			@Override
			public StandardsChainImages toEntityModel() {
				return _nullStandardsChainImages;
			}
		};
}