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

import com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException;
import com.ihg.brandstandards.db.model.StandardsCountryImages;
import com.ihg.brandstandards.db.model.impl.StandardsCountryImagesImpl;
import com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl;

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
 * The persistence implementation for the standards country images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryImagesPersistence
 * @see StandardsCountryImagesUtil
 * @generated
 */
public class StandardsCountryImagesPersistenceImpl extends BasePersistenceImpl<StandardsCountryImages>
	implements StandardsCountryImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsCountryImagesUtil} to access the standards country images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsCountryImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIMAGEID =
		new FinderPath(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystdImageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID =
		new FinderPath(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystdImageId",
			new String[] { Long.class.getName() },
			StandardsCountryImagesModelImpl.STDIMAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIMAGEID = new FinderPath(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdImageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards country imageses where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @return the matching standards country imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryImages> findBystdImageId(long stdImageId)
		throws SystemException {
		return findBystdImageId(stdImageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country imageses where stdImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdImageId the std image ID
	 * @param start the lower bound of the range of standards country imageses
	 * @param end the upper bound of the range of standards country imageses (not inclusive)
	 * @return the range of matching standards country imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryImages> findBystdImageId(long stdImageId,
		int start, int end) throws SystemException {
		return findBystdImageId(stdImageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards country imageses where stdImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdImageId the std image ID
	 * @param start the lower bound of the range of standards country imageses
	 * @param end the upper bound of the range of standards country imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards country imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryImages> findBystdImageId(long stdImageId,
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

		List<StandardsCountryImages> list = (List<StandardsCountryImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCountryImages standardsCountryImages : list) {
				if ((stdImageId != standardsCountryImages.getStdImageId())) {
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

			query.append(_SQL_SELECT_STANDARDSCOUNTRYIMAGES_WHERE);

			query.append(_FINDER_COLUMN_STDIMAGEID_STDIMAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCountryImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdImageId);

				if (!pagination) {
					list = (List<StandardsCountryImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryImages>(list);
				}
				else {
					list = (List<StandardsCountryImages>)QueryUtil.list(q,
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
	 * Returns the first standards country images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a matching standards country images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages findBystdImageId_First(long stdImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryImagesException, SystemException {
		StandardsCountryImages standardsCountryImages = fetchBystdImageId_First(stdImageId,
				orderByComparator);

		if (standardsCountryImages != null) {
			return standardsCountryImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdImageId=");
		msg.append(stdImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryImagesException(msg.toString());
	}

	/**
	 * Returns the first standards country images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country images, or <code>null</code> if a matching standards country images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages fetchBystdImageId_First(long stdImageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsCountryImages> list = findBystdImageId(stdImageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards country images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a matching standards country images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages findBystdImageId_Last(long stdImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryImagesException, SystemException {
		StandardsCountryImages standardsCountryImages = fetchBystdImageId_Last(stdImageId,
				orderByComparator);

		if (standardsCountryImages != null) {
			return standardsCountryImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdImageId=");
		msg.append(stdImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryImagesException(msg.toString());
	}

	/**
	 * Returns the last standards country images in the ordered set where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country images, or <code>null</code> if a matching standards country images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages fetchBystdImageId_Last(long stdImageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystdImageId(stdImageId);

		if (count == 0) {
			return null;
		}

		List<StandardsCountryImages> list = findBystdImageId(stdImageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards country imageses before and after the current standards country images in the ordered set where stdImageId = &#63;.
	 *
	 * @param standardsCountryImagesPK the primary key of the current standards country images
	 * @param stdImageId the std image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards country images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages[] findBystdImageId_PrevAndNext(
		StandardsCountryImagesPK standardsCountryImagesPK, long stdImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryImagesException, SystemException {
		StandardsCountryImages standardsCountryImages = findByPrimaryKey(standardsCountryImagesPK);

		Session session = null;

		try {
			session = openSession();

			StandardsCountryImages[] array = new StandardsCountryImagesImpl[3];

			array[0] = getBystdImageId_PrevAndNext(session,
					standardsCountryImages, stdImageId, orderByComparator, true);

			array[1] = standardsCountryImages;

			array[2] = getBystdImageId_PrevAndNext(session,
					standardsCountryImages, stdImageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsCountryImages getBystdImageId_PrevAndNext(
		Session session, StandardsCountryImages standardsCountryImages,
		long stdImageId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCOUNTRYIMAGES_WHERE);

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
			query.append(StandardsCountryImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdImageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCountryImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCountryImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards country imageses where stdImageId = &#63; from the database.
	 *
	 * @param stdImageId the std image ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdImageId(long stdImageId) throws SystemException {
		for (StandardsCountryImages standardsCountryImages : findBystdImageId(
				stdImageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsCountryImages);
		}
	}

	/**
	 * Returns the number of standards country imageses where stdImageId = &#63;.
	 *
	 * @param stdImageId the std image ID
	 * @return the number of matching standards country imageses
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

			query.append(_SQL_COUNT_STANDARDSCOUNTRYIMAGES_WHERE);

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

	private static final String _FINDER_COLUMN_STDIMAGEID_STDIMAGEID_2 = "standardsCountryImages.id.stdImageId = ?";

	public StandardsCountryImagesPersistenceImpl() {
		setModelClass(StandardsCountryImages.class);
	}

	/**
	 * Caches the standards country images in the entity cache if it is enabled.
	 *
	 * @param standardsCountryImages the standards country images
	 */
	@Override
	public void cacheResult(StandardsCountryImages standardsCountryImages) {
		EntityCacheUtil.putResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			standardsCountryImages.getPrimaryKey(), standardsCountryImages);

		standardsCountryImages.resetOriginalValues();
	}

	/**
	 * Caches the standards country imageses in the entity cache if it is enabled.
	 *
	 * @param standardsCountryImageses the standards country imageses
	 */
	@Override
	public void cacheResult(
		List<StandardsCountryImages> standardsCountryImageses) {
		for (StandardsCountryImages standardsCountryImages : standardsCountryImageses) {
			if (EntityCacheUtil.getResult(
						StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryImagesImpl.class,
						standardsCountryImages.getPrimaryKey()) == null) {
				cacheResult(standardsCountryImages);
			}
			else {
				standardsCountryImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards country imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsCountryImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsCountryImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards country images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsCountryImages standardsCountryImages) {
		EntityCacheUtil.removeResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			standardsCountryImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StandardsCountryImages> standardsCountryImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsCountryImages standardsCountryImages : standardsCountryImageses) {
			EntityCacheUtil.removeResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryImagesImpl.class,
				standardsCountryImages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards country images with the primary key. Does not add the standards country images to the database.
	 *
	 * @param standardsCountryImagesPK the primary key for the new standards country images
	 * @return the new standards country images
	 */
	@Override
	public StandardsCountryImages create(
		StandardsCountryImagesPK standardsCountryImagesPK) {
		StandardsCountryImages standardsCountryImages = new StandardsCountryImagesImpl();

		standardsCountryImages.setNew(true);
		standardsCountryImages.setPrimaryKey(standardsCountryImagesPK);

		return standardsCountryImages;
	}

	/**
	 * Removes the standards country images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCountryImagesPK the primary key of the standards country images
	 * @return the standards country images that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages remove(
		StandardsCountryImagesPK standardsCountryImagesPK)
		throws NoSuchStandardsCountryImagesException, SystemException {
		return remove((Serializable)standardsCountryImagesPK);
	}

	/**
	 * Removes the standards country images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards country images
	 * @return the standards country images that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages remove(Serializable primaryKey)
		throws NoSuchStandardsCountryImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsCountryImages standardsCountryImages = (StandardsCountryImages)session.get(StandardsCountryImagesImpl.class,
					primaryKey);

			if (standardsCountryImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsCountryImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsCountryImages);
		}
		catch (NoSuchStandardsCountryImagesException nsee) {
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
	protected StandardsCountryImages removeImpl(
		StandardsCountryImages standardsCountryImages)
		throws SystemException {
		standardsCountryImages = toUnwrappedModel(standardsCountryImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsCountryImages)) {
				standardsCountryImages = (StandardsCountryImages)session.get(StandardsCountryImagesImpl.class,
						standardsCountryImages.getPrimaryKeyObj());
			}

			if (standardsCountryImages != null) {
				session.delete(standardsCountryImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsCountryImages != null) {
			clearCache(standardsCountryImages);
		}

		return standardsCountryImages;
	}

	@Override
	public StandardsCountryImages updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryImages standardsCountryImages)
		throws SystemException {
		standardsCountryImages = toUnwrappedModel(standardsCountryImages);

		boolean isNew = standardsCountryImages.isNew();

		StandardsCountryImagesModelImpl standardsCountryImagesModelImpl = (StandardsCountryImagesModelImpl)standardsCountryImages;

		Session session = null;

		try {
			session = openSession();

			if (standardsCountryImages.isNew()) {
				session.save(standardsCountryImages);

				standardsCountryImages.setNew(false);
			}
			else {
				session.merge(standardsCountryImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsCountryImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsCountryImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCountryImagesModelImpl.getOriginalStdImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIMAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID,
					args);

				args = new Object[] {
						standardsCountryImagesModelImpl.getStdImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIMAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIMAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImagesImpl.class,
			standardsCountryImages.getPrimaryKey(), standardsCountryImages);

		return standardsCountryImages;
	}

	protected StandardsCountryImages toUnwrappedModel(
		StandardsCountryImages standardsCountryImages) {
		if (standardsCountryImages instanceof StandardsCountryImagesImpl) {
			return standardsCountryImages;
		}

		StandardsCountryImagesImpl standardsCountryImagesImpl = new StandardsCountryImagesImpl();

		standardsCountryImagesImpl.setNew(standardsCountryImages.isNew());
		standardsCountryImagesImpl.setPrimaryKey(standardsCountryImages.getPrimaryKey());

		standardsCountryImagesImpl.setStdImageId(standardsCountryImages.getStdImageId());
		standardsCountryImagesImpl.setCountryCode(standardsCountryImages.getCountryCode());
		standardsCountryImagesImpl.setCreatorId(standardsCountryImages.getCreatorId());
		standardsCountryImagesImpl.setCreatedDate(standardsCountryImages.getCreatedDate());
		standardsCountryImagesImpl.setUpdatedBy(standardsCountryImages.getUpdatedBy());
		standardsCountryImagesImpl.setUpdatedDate(standardsCountryImages.getUpdatedDate());

		return standardsCountryImagesImpl;
	}

	/**
	 * Returns the standards country images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country images
	 * @return the standards country images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsCountryImagesException, SystemException {
		StandardsCountryImages standardsCountryImages = fetchByPrimaryKey(primaryKey);

		if (standardsCountryImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsCountryImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsCountryImages;
	}

	/**
	 * Returns the standards country images with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException} if it could not be found.
	 *
	 * @param standardsCountryImagesPK the primary key of the standards country images
	 * @return the standards country images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages findByPrimaryKey(
		StandardsCountryImagesPK standardsCountryImagesPK)
		throws NoSuchStandardsCountryImagesException, SystemException {
		return findByPrimaryKey((Serializable)standardsCountryImagesPK);
	}

	/**
	 * Returns the standards country images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country images
	 * @return the standards country images, or <code>null</code> if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsCountryImages standardsCountryImages = (StandardsCountryImages)EntityCacheUtil.getResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryImagesImpl.class, primaryKey);

		if (standardsCountryImages == _nullStandardsCountryImages) {
			return null;
		}

		if (standardsCountryImages == null) {
			Session session = null;

			try {
				session = openSession();

				standardsCountryImages = (StandardsCountryImages)session.get(StandardsCountryImagesImpl.class,
						primaryKey);

				if (standardsCountryImages != null) {
					cacheResult(standardsCountryImages);
				}
				else {
					EntityCacheUtil.putResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryImagesImpl.class, primaryKey,
						_nullStandardsCountryImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsCountryImagesModelImpl.ENTITY_CACHE_ENABLED,
					StandardsCountryImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsCountryImages;
	}

	/**
	 * Returns the standards country images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsCountryImagesPK the primary key of the standards country images
	 * @return the standards country images, or <code>null</code> if a standards country images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryImages fetchByPrimaryKey(
		StandardsCountryImagesPK standardsCountryImagesPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsCountryImagesPK);
	}

	/**
	 * Returns all the standards country imageses.
	 *
	 * @return the standards country imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards country imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country imageses
	 * @param end the upper bound of the range of standards country imageses (not inclusive)
	 * @return the range of standards country imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards country imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country imageses
	 * @param end the upper bound of the range of standards country imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards country imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryImages> findAll(int start, int end,
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

		List<StandardsCountryImages> list = (List<StandardsCountryImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCOUNTRYIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCOUNTRYIMAGES;

				if (pagination) {
					sql = sql.concat(StandardsCountryImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsCountryImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountryImages>(list);
				}
				else {
					list = (List<StandardsCountryImages>)QueryUtil.list(q,
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
	 * Removes all the standards country imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsCountryImages standardsCountryImages : findAll()) {
			remove(standardsCountryImages);
		}
	}

	/**
	 * Returns the number of standards country imageses.
	 *
	 * @return the number of standards country imageses
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCOUNTRYIMAGES);

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
	 * Initializes the standards country images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsCountryImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsCountryImages>> listenersList = new ArrayList<ModelListener<StandardsCountryImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsCountryImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsCountryImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCOUNTRYIMAGES = "SELECT standardsCountryImages FROM StandardsCountryImages standardsCountryImages";
	private static final String _SQL_SELECT_STANDARDSCOUNTRYIMAGES_WHERE = "SELECT standardsCountryImages FROM StandardsCountryImages standardsCountryImages WHERE ";
	private static final String _SQL_COUNT_STANDARDSCOUNTRYIMAGES = "SELECT COUNT(standardsCountryImages) FROM StandardsCountryImages standardsCountryImages";
	private static final String _SQL_COUNT_STANDARDSCOUNTRYIMAGES_WHERE = "SELECT COUNT(standardsCountryImages) FROM StandardsCountryImages standardsCountryImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsCountryImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsCountryImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsCountryImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsCountryImagesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdImageId", "countryCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static StandardsCountryImages _nullStandardsCountryImages = new StandardsCountryImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsCountryImages> toCacheModel() {
				return _nullStandardsCountryImagesCacheModel;
			}
		};

	private static CacheModel<StandardsCountryImages> _nullStandardsCountryImagesCacheModel =
		new CacheModel<StandardsCountryImages>() {
			@Override
			public StandardsCountryImages toEntityModel() {
				return _nullStandardsCountryImages;
			}
		};
}