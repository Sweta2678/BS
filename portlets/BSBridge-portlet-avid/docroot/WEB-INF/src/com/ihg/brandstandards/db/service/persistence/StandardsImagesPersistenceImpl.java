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

import com.ihg.brandstandards.db.NoSuchStandardsImagesException;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.impl.StandardsImagesImpl;
import com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl;

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
 * The persistence implementation for the standards images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsImagesPersistence
 * @see StandardsImagesUtil
 * @generated
 */
public class StandardsImagesPersistenceImpl extends BasePersistenceImpl<StandardsImages>
	implements StandardsImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsImagesUtil} to access the standards images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByimageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEID =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByimageId",
			new String[] { Long.class.getName() },
			StandardsImagesModelImpl.IMAGEID_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByimageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards imageses where imageId = &#63;.
	 *
	 * @param imageId the image ID
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByimageId(long imageId)
		throws SystemException {
		return findByimageId(imageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where imageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageId the image ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByimageId(long imageId, int start, int end)
		throws SystemException {
		return findByimageId(imageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where imageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageId the image ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByimageId(long imageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEID;
			finderArgs = new Object[] { imageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEID;
			finderArgs = new Object[] { imageId, start, end, orderByComparator };
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((imageId != standardsImages.getImageId())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_IMAGEID_IMAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(imageId);

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where imageId = &#63;.
	 *
	 * @param imageId the image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByimageId_First(long imageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByimageId_First(imageId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageId=");
		msg.append(imageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where imageId = &#63;.
	 *
	 * @param imageId the image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByimageId_First(long imageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsImages> list = findByimageId(imageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where imageId = &#63;.
	 *
	 * @param imageId the image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByimageId_Last(long imageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByimageId_Last(imageId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageId=");
		msg.append(imageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where imageId = &#63;.
	 *
	 * @param imageId the image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByimageId_Last(long imageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByimageId(imageId);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByimageId(imageId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where imageId = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param imageId the image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByimageId_PrevAndNext(long stdImageId,
		long imageId, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByimageId_PrevAndNext(session, standardsImages,
					imageId, orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByimageId_PrevAndNext(session, standardsImages,
					imageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsImages getByimageId_PrevAndNext(Session session,
		StandardsImages standardsImages, long imageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_IMAGEID_IMAGEID_2);

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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(imageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where imageId = &#63; from the database.
	 *
	 * @param imageId the image ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByimageId(long imageId) throws SystemException {
		for (StandardsImages standardsImages : findByimageId(imageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where imageId = &#63;.
	 *
	 * @param imageId the image ID
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByimageId(long imageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMAGEID;

		Object[] finderArgs = new Object[] { imageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_IMAGEID_IMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(imageId);

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

	private static final String _FINDER_COLUMN_IMAGEID_IMAGEID_2 = "standardsImages.imageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByImageIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByImageIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			StandardsImagesModelImpl.IMAGEID_COLUMN_BITMASK |
			StandardsImagesModelImpl.STDID_COLUMN_BITMASK |
			StandardsImagesModelImpl.LOCALECODE_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEIDSTDIDLOCALECD = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByImageIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByImageIdStdIdLocaleCd(long imageId,
		long stdId, String localeCode) throws SystemException {
		return findByImageIdStdIdLocaleCd(imageId, stdId, localeCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByImageIdStdIdLocaleCd(long imageId,
		long stdId, String localeCode, int start, int end)
		throws SystemException {
		return findByImageIdStdIdLocaleCd(imageId, stdId, localeCode, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByImageIdStdIdLocaleCd(long imageId,
		long stdId, String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD;
			finderArgs = new Object[] { imageId, stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD;
			finderArgs = new Object[] {
					imageId, stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((imageId != standardsImages.getImageId()) ||
						(stdId != standardsImages.getStdId()) ||
						!Validator.equals(localeCode,
							standardsImages.getLocaleCode())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_IMAGEID_2);

			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(imageId);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByImageIdStdIdLocaleCd_First(long imageId,
		long stdId, String localeCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByImageIdStdIdLocaleCd_First(imageId,
				stdId, localeCode, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageId=");
		msg.append(imageId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByImageIdStdIdLocaleCd_First(long imageId,
		long stdId, String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsImages> list = findByImageIdStdIdLocaleCd(imageId, stdId,
				localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByImageIdStdIdLocaleCd_Last(long imageId,
		long stdId, String localeCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByImageIdStdIdLocaleCd_Last(imageId,
				stdId, localeCode, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageId=");
		msg.append(imageId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByImageIdStdIdLocaleCd_Last(long imageId,
		long stdId, String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByImageIdStdIdLocaleCd(imageId, stdId, localeCode);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByImageIdStdIdLocaleCd(imageId, stdId,
				localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByImageIdStdIdLocaleCd_PrevAndNext(
		long stdImageId, long imageId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByImageIdStdIdLocaleCd_PrevAndNext(session,
					standardsImages, imageId, stdId, localeCode,
					orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByImageIdStdIdLocaleCd_PrevAndNext(session,
					standardsImages, imageId, stdId, localeCode,
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

	protected StandardsImages getByImageIdStdIdLocaleCd_PrevAndNext(
		Session session, StandardsImages standardsImages, long imageId,
		long stdId, String localeCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_IMAGEID_2);

		query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_2);
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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(imageId);

		qPos.add(stdId);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByImageIdStdIdLocaleCd(long imageId, long stdId,
		String localeCode) throws SystemException {
		for (StandardsImages standardsImages : findByImageIdStdIdLocaleCd(
				imageId, stdId, localeCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param imageId the image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByImageIdStdIdLocaleCd(long imageId, long stdId,
		String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMAGEIDSTDIDLOCALECD;

		Object[] finderArgs = new Object[] { imageId, stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_IMAGEID_2);

			query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(imageId);

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

	private static final String _FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_IMAGEID_2 = "standardsImages.imageId = ? AND ";
	private static final String _FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_STDID_2 = "standardsImages.stdId = ? AND ";
	private static final String _FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_1 =
		"standardsImages.localeCode IS NULL";
	private static final String _FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_2 =
		"standardsImages.localeCode = ?";
	private static final String _FINDER_COLUMN_IMAGEIDSTDIDLOCALECD_LOCALECODE_3 =
		"(standardsImages.localeCode IS NULL OR standardsImages.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			StandardsImagesModelImpl.STDID_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards imageses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByStdId(long stdId, int start, int end)
		throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByStdId(long stdId, int start, int end,
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

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((stdId != standardsImages.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByStdId_First(stdId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsImages> list = findByStdId(stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByStdId_Last(stdId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByStdId_PrevAndNext(long stdImageId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByStdId_PrevAndNext(session, standardsImages, stdId,
					orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByStdId_PrevAndNext(session, standardsImages, stdId,
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

	protected StandardsImages getByStdId_PrevAndNext(Session session,
		StandardsImages standardsImages, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (StandardsImages standardsImages : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standards imageses
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

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardsImages.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTSSTDID =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByparentsStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDID =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparentsStdId",
			new String[] { Long.class.getName() },
			StandardsImagesModelImpl.STDID_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTSSTDID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByparentsStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards imageses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByparentsStdId(long stdId)
		throws SystemException {
		return findByparentsStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the standards imageses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByparentsStdId(long stdId, int start,
		int end) throws SystemException {
		return findByparentsStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByparentsStdId(long stdId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDID;
			finderArgs = new Object[] { stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTSSTDID;
			finderArgs = new Object[] { stdId, start, end, orderByComparator };
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((stdId != standardsImages.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTSSTDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByparentsStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByparentsStdId_First(stdId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByparentsStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsImages> list = findByparentsStdId(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByparentsStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByparentsStdId_Last(stdId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByparentsStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentsStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByparentsStdId(stdId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where stdId = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByparentsStdId_PrevAndNext(long stdImageId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByparentsStdId_PrevAndNext(session, standardsImages,
					stdId, orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByparentsStdId_PrevAndNext(session, standardsImages,
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

	protected StandardsImages getByparentsStdId_PrevAndNext(Session session,
		StandardsImages standardsImages, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_PARENTSSTDID_STDID_2);

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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentsStdId(long stdId) throws SystemException {
		for (StandardsImages standardsImages : findByparentsStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentsStdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTSSTDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTSSTDID_STDID_2);

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

	private static final String _FINDER_COLUMN_PARENTSSTDID_STDID_2 = "standardsImages.stdId = ? AND standardsImages.stdImageId=standardsImages.parentImageId";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByparentsStdIdLocaleCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByparentsStdIdLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() },
			StandardsImagesModelImpl.STDID_COLUMN_BITMASK |
			StandardsImagesModelImpl.LOCALECODE_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTSSTDIDLOCALECODE = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentsStdIdLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards imageses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByparentsStdIdLocaleCode(long stdId,
		String localeCode) throws SystemException {
		return findByparentsStdIdLocaleCode(stdId, localeCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByparentsStdIdLocaleCode(long stdId,
		String localeCode, int start, int end) throws SystemException {
		return findByparentsStdIdLocaleCode(stdId, localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByparentsStdIdLocaleCode(long stdId,
		String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE;
			finderArgs = new Object[] { stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE;
			finderArgs = new Object[] {
					stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((stdId != standardsImages.getStdId()) ||
						!Validator.equals(localeCode,
							standardsImages.getLocaleCode())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
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
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByparentsStdIdLocaleCode_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByparentsStdIdLocaleCode_First(stdId,
				localeCode, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByparentsStdIdLocaleCode_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsImages> list = findByparentsStdIdLocaleCode(stdId,
				localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByparentsStdIdLocaleCode_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByparentsStdIdLocaleCode_Last(stdId,
				localeCode, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByparentsStdIdLocaleCode_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByparentsStdIdLocaleCode(stdId, localeCode);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByparentsStdIdLocaleCode(stdId,
				localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByparentsStdIdLocaleCode_PrevAndNext(
		long stdImageId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByparentsStdIdLocaleCode_PrevAndNext(session,
					standardsImages, stdId, localeCode, orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByparentsStdIdLocaleCode_PrevAndNext(session,
					standardsImages, stdId, localeCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsImages getByparentsStdIdLocaleCode_PrevAndNext(
		Session session, StandardsImages standardsImages, long stdId,
		String localeCode, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_2);
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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentsStdIdLocaleCode(long stdId, String localeCode)
		throws SystemException {
		for (StandardsImages standardsImages : findByparentsStdIdLocaleCode(
				stdId, localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentsStdIdLocaleCode(long stdId, String localeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTSSTDIDLOCALECODE;

		Object[] finderArgs = new Object[] { stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_2);
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

	private static final String _FINDER_COLUMN_PARENTSSTDIDLOCALECODE_STDID_2 = "standardsImages.stdId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_1 =
		"standardsImages.localeCode IS NULL AND standardsImages.stdImageId=standardsImages.parentImageId";
	private static final String _FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_2 =
		"standardsImages.localeCode = ? AND standardsImages.stdImageId=standardsImages.parentImageId";
	private static final String _FINDER_COLUMN_PARENTSSTDIDLOCALECODE_LOCALECODE_3 =
		"(standardsImages.localeCode IS NULL OR standardsImages.localeCode = '') AND standardsImages.stdImageId=standardsImages.parentImageId";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentImageIdStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentImageIdStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			StandardsImagesModelImpl.PARENTIMAGEID_COLUMN_BITMASK |
			StandardsImagesModelImpl.STDID_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentImageIdStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the standards imageses where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentImageIdStdId(long parentImageId,
		long stdId) throws SystemException {
		return findByParentImageIdStdId(parentImageId, stdId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where parentImageId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentImageIdStdId(long parentImageId,
		long stdId, int start, int end) throws SystemException {
		return findByParentImageIdStdId(parentImageId, stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where parentImageId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentImageIdStdId(long parentImageId,
		long stdId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID;
			finderArgs = new Object[] { parentImageId, stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID;
			finderArgs = new Object[] {
					parentImageId, stdId,
					
					start, end, orderByComparator
				};
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((parentImageId != standardsImages.getParentImageId()) ||
						(stdId != standardsImages.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDID_PARENTIMAGEID_2);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentImageId);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByParentImageIdStdId_First(long parentImageId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByParentImageIdStdId_First(parentImageId,
				stdId, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentImageId=");
		msg.append(parentImageId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByParentImageIdStdId_First(long parentImageId,
		long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsImages> list = findByParentImageIdStdId(parentImageId,
				stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByParentImageIdStdId_Last(long parentImageId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByParentImageIdStdId_Last(parentImageId,
				stdId, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentImageId=");
		msg.append(parentImageId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByParentImageIdStdId_Last(long parentImageId,
		long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentImageIdStdId(parentImageId, stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByParentImageIdStdId(parentImageId,
				stdId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByParentImageIdStdId_PrevAndNext(
		long stdImageId, long parentImageId, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByParentImageIdStdId_PrevAndNext(session,
					standardsImages, parentImageId, stdId, orderByComparator,
					true);

			array[1] = standardsImages;

			array[2] = getByParentImageIdStdId_PrevAndNext(session,
					standardsImages, parentImageId, stdId, orderByComparator,
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

	protected StandardsImages getByParentImageIdStdId_PrevAndNext(
		Session session, StandardsImages standardsImages, long parentImageId,
		long stdId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDID_PARENTIMAGEID_2);

		query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDID_STDID_2);

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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentImageId);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where parentImageId = &#63; and stdId = &#63; from the database.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentImageIdStdId(long parentImageId, long stdId)
		throws SystemException {
		for (StandardsImages standardsImages : findByParentImageIdStdId(
				parentImageId, stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where parentImageId = &#63; and stdId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentImageIdStdId(long parentImageId, long stdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDID;

		Object[] finderArgs = new Object[] { parentImageId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDID_PARENTIMAGEID_2);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentImageId);

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

	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDID_PARENTIMAGEID_2 =
		"standardsImages.parentImageId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDID_STDID_2 = "standardsImages.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentImageIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentImageIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			StandardsImagesModelImpl.PARENTIMAGEID_COLUMN_BITMASK |
			StandardsImagesModelImpl.STDID_COLUMN_BITMASK |
			StandardsImagesModelImpl.LOCALECODE_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDIDLOCALECD =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentImageIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, String localeCode)
		throws SystemException {
		return findByParentImageIdStdIdLocaleCd(parentImageId, stdId,
			localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, String localeCode, int start, int end)
		throws SystemException {
		return findByParentImageIdStdIdLocaleCd(parentImageId, stdId,
			localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD;
			finderArgs = new Object[] { parentImageId, stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD;
			finderArgs = new Object[] {
					parentImageId, stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((parentImageId != standardsImages.getParentImageId()) ||
						(stdId != standardsImages.getStdId()) ||
						!Validator.equals(localeCode,
							standardsImages.getLocaleCode())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_PARENTIMAGEID_2);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentImageId);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByParentImageIdStdIdLocaleCd_First(
		long parentImageId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByParentImageIdStdIdLocaleCd_First(parentImageId,
				stdId, localeCode, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentImageId=");
		msg.append(parentImageId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByParentImageIdStdIdLocaleCd_First(
		long parentImageId, long stdId, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsImages> list = findByParentImageIdStdIdLocaleCd(parentImageId,
				stdId, localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByParentImageIdStdIdLocaleCd_Last(
		long parentImageId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByParentImageIdStdIdLocaleCd_Last(parentImageId,
				stdId, localeCode, orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentImageId=");
		msg.append(parentImageId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByParentImageIdStdIdLocaleCd_Last(
		long parentImageId, long stdId, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentImageIdStdIdLocaleCd(parentImageId, stdId,
				localeCode);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByParentImageIdStdIdLocaleCd(parentImageId,
				stdId, localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByParentImageIdStdIdLocaleCd_PrevAndNext(
		long stdImageId, long parentImageId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByParentImageIdStdIdLocaleCd_PrevAndNext(session,
					standardsImages, parentImageId, stdId, localeCode,
					orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByParentImageIdStdIdLocaleCd_PrevAndNext(session,
					standardsImages, parentImageId, stdId, localeCode,
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

	protected StandardsImages getByParentImageIdStdIdLocaleCd_PrevAndNext(
		Session session, StandardsImages standardsImages, long parentImageId,
		long stdId, String localeCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_PARENTIMAGEID_2);

		query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_2);
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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentImageId);

		qPos.add(stdId);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentImageIdStdIdLocaleCd(long parentImageId,
		long stdId, String localeCode) throws SystemException {
		for (StandardsImages standardsImages : findByParentImageIdStdIdLocaleCd(
				parentImageId, stdId, localeCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentImageIdStdIdLocaleCd(long parentImageId,
		long stdId, String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDIDLOCALECD;

		Object[] finderArgs = new Object[] { parentImageId, stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_PARENTIMAGEID_2);

			query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentImageId);

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

	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_PARENTIMAGEID_2 =
		"standardsImages.parentImageId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_STDID_2 =
		"standardsImages.stdId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_1 =
		"standardsImages.localeCode IS NULL";
	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_2 =
		"standardsImages.localeCode = ?";
	private static final String _FINDER_COLUMN_PARENTIMAGEIDSTDIDLOCALECD_LOCALECODE_3 =
		"(standardsImages.localeCode IS NULL OR standardsImages.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED,
			StandardsImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			StandardsImagesModelImpl.PARENTIMAGEID_COLUMN_BITMASK |
			StandardsImagesModelImpl.IMAGESORTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards imageses where parentImageId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @return the matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentId(long parentImageId)
		throws SystemException {
		return findByParentId(parentImageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses where parentImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentImageId the parent image ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentId(long parentImageId, int start,
		int end) throws SystemException {
		return findByParentId(parentImageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses where parentImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentImageId the parent image ID
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findByParentId(long parentImageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentImageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] {
					parentImageId,
					
					start, end, orderByComparator
				};
		}

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsImages standardsImages : list) {
				if ((parentImageId != standardsImages.getParentImageId())) {
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

			query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTIMAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentImageId);

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Returns the first standards images in the ordered set where parentImageId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByParentId_First(long parentImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByParentId_First(parentImageId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentImageId=");
		msg.append(parentImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the first standards images in the ordered set where parentImageId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByParentId_First(long parentImageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsImages> list = findByParentId(parentImageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards images in the ordered set where parentImageId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByParentId_Last(long parentImageId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByParentId_Last(parentImageId,
				orderByComparator);

		if (standardsImages != null) {
			return standardsImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentImageId=");
		msg.append(parentImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsImagesException(msg.toString());
	}

	/**
	 * Returns the last standards images in the ordered set where parentImageId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByParentId_Last(long parentImageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentId(parentImageId);

		if (count == 0) {
			return null;
		}

		List<StandardsImages> list = findByParentId(parentImageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards imageses before and after the current standards images in the ordered set where parentImageId = &#63;.
	 *
	 * @param stdImageId the primary key of the current standards images
	 * @param parentImageId the parent image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages[] findByParentId_PrevAndNext(long stdImageId,
		long parentImageId, OrderByComparator orderByComparator)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = findByPrimaryKey(stdImageId);

		Session session = null;

		try {
			session = openSession();

			StandardsImages[] array = new StandardsImagesImpl[3];

			array[0] = getByParentId_PrevAndNext(session, standardsImages,
					parentImageId, orderByComparator, true);

			array[1] = standardsImages;

			array[2] = getByParentId_PrevAndNext(session, standardsImages,
					parentImageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsImages getByParentId_PrevAndNext(Session session,
		StandardsImages standardsImages, long parentImageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSIMAGES_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENTIMAGEID_2);

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
			query.append(StandardsImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentImageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards imageses where parentImageId = &#63; from the database.
	 *
	 * @param parentImageId the parent image ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentId(long parentImageId) throws SystemException {
		for (StandardsImages standardsImages : findByParentId(parentImageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses where parentImageId = &#63;.
	 *
	 * @param parentImageId the parent image ID
	 * @return the number of matching standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentId(long parentImageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { parentImageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentImageId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTIMAGEID_2 = "standardsImages.parentImageId = ?";

	public StandardsImagesPersistenceImpl() {
		setModelClass(StandardsImages.class);
	}

	/**
	 * Caches the standards images in the entity cache if it is enabled.
	 *
	 * @param standardsImages the standards images
	 */
	@Override
	public void cacheResult(StandardsImages standardsImages) {
		EntityCacheUtil.putResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesImpl.class, standardsImages.getPrimaryKey(),
			standardsImages);

		standardsImages.resetOriginalValues();
	}

	/**
	 * Caches the standards imageses in the entity cache if it is enabled.
	 *
	 * @param standardsImageses the standards imageses
	 */
	@Override
	public void cacheResult(List<StandardsImages> standardsImageses) {
		for (StandardsImages standardsImages : standardsImageses) {
			if (EntityCacheUtil.getResult(
						StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
						StandardsImagesImpl.class,
						standardsImages.getPrimaryKey()) == null) {
				cacheResult(standardsImages);
			}
			else {
				standardsImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsImages standardsImages) {
		EntityCacheUtil.removeResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesImpl.class, standardsImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsImages> standardsImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsImages standardsImages : standardsImageses) {
			EntityCacheUtil.removeResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
				StandardsImagesImpl.class, standardsImages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards images with the primary key. Does not add the standards images to the database.
	 *
	 * @param stdImageId the primary key for the new standards images
	 * @return the new standards images
	 */
	@Override
	public StandardsImages create(long stdImageId) {
		StandardsImages standardsImages = new StandardsImagesImpl();

		standardsImages.setNew(true);
		standardsImages.setPrimaryKey(stdImageId);

		return standardsImages;
	}

	/**
	 * Removes the standards images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdImageId the primary key of the standards images
	 * @return the standards images that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages remove(long stdImageId)
		throws NoSuchStandardsImagesException, SystemException {
		return remove((Serializable)stdImageId);
	}

	/**
	 * Removes the standards images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards images
	 * @return the standards images that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages remove(Serializable primaryKey)
		throws NoSuchStandardsImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsImages standardsImages = (StandardsImages)session.get(StandardsImagesImpl.class,
					primaryKey);

			if (standardsImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsImages);
		}
		catch (NoSuchStandardsImagesException nsee) {
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
	protected StandardsImages removeImpl(StandardsImages standardsImages)
		throws SystemException {
		standardsImages = toUnwrappedModel(standardsImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsImages)) {
				standardsImages = (StandardsImages)session.get(StandardsImagesImpl.class,
						standardsImages.getPrimaryKeyObj());
			}

			if (standardsImages != null) {
				session.delete(standardsImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsImages != null) {
			clearCache(standardsImages);
		}

		return standardsImages;
	}

	@Override
	public StandardsImages updateImpl(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws SystemException {
		standardsImages = toUnwrappedModel(standardsImages);

		boolean isNew = standardsImages.isNew();

		StandardsImagesModelImpl standardsImagesModelImpl = (StandardsImagesModelImpl)standardsImages;

		Session session = null;

		try {
			session = openSession();

			if (standardsImages.isNew()) {
				session.save(standardsImages);

				standardsImages.setNew(false);
			}
			else {
				session.merge(standardsImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEID,
					args);

				args = new Object[] { standardsImagesModelImpl.getImageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEID,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalImageId(),
						standardsImagesModelImpl.getOriginalStdId(),
						standardsImagesModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD,
					args);

				args = new Object[] {
						standardsImagesModelImpl.getImageId(),
						standardsImagesModelImpl.getStdId(),
						standardsImagesModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEIDSTDIDLOCALECD,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { standardsImagesModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTSSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDID,
					args);

				args = new Object[] { standardsImagesModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTSSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDID,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalStdId(),
						standardsImagesModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTSSTDIDLOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE,
					args);

				args = new Object[] {
						standardsImagesModelImpl.getStdId(),
						standardsImagesModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTSSTDIDLOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTSSTDIDLOCALECODE,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalParentImageId(),
						standardsImagesModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID,
					args);

				args = new Object[] {
						standardsImagesModelImpl.getParentImageId(),
						standardsImagesModelImpl.getStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDID,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalParentImageId(),
						standardsImagesModelImpl.getOriginalStdId(),
						standardsImagesModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD,
					args);

				args = new Object[] {
						standardsImagesModelImpl.getParentImageId(),
						standardsImagesModelImpl.getStdId(),
						standardsImagesModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIMAGEIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIMAGEIDSTDIDLOCALECD,
					args);
			}

			if ((standardsImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsImagesModelImpl.getOriginalParentImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { standardsImagesModelImpl.getParentImageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImagesImpl.class, standardsImages.getPrimaryKey(),
			standardsImages);

		return standardsImages;
	}

	protected StandardsImages toUnwrappedModel(StandardsImages standardsImages) {
		if (standardsImages instanceof StandardsImagesImpl) {
			return standardsImages;
		}

		StandardsImagesImpl standardsImagesImpl = new StandardsImagesImpl();

		standardsImagesImpl.setNew(standardsImages.isNew());
		standardsImagesImpl.setPrimaryKey(standardsImages.getPrimaryKey());

		standardsImagesImpl.setStdImageId(standardsImages.getStdImageId());
		standardsImagesImpl.setParentImageId(standardsImages.getParentImageId());
		standardsImagesImpl.setImageId(standardsImages.getImageId());
		standardsImagesImpl.setStdId(standardsImages.getStdId());
		standardsImagesImpl.setLocaleCode(standardsImages.getLocaleCode());
		standardsImagesImpl.setImageTitle(standardsImages.getImageTitle());
		standardsImagesImpl.setImageSortOrder(standardsImages.getImageSortOrder());
		standardsImagesImpl.setCreatorId(standardsImages.getCreatorId());
		standardsImagesImpl.setCreatedDate(standardsImages.getCreatedDate());
		standardsImagesImpl.setUpdatedBy(standardsImages.getUpdatedBy());
		standardsImagesImpl.setUpdatedDate(standardsImages.getUpdatedDate());

		return standardsImagesImpl;
	}

	/**
	 * Returns the standards images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards images
	 * @return the standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsImagesException, SystemException {
		StandardsImages standardsImages = fetchByPrimaryKey(primaryKey);

		if (standardsImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsImages;
	}

	/**
	 * Returns the standards images with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsImagesException} if it could not be found.
	 *
	 * @param stdImageId the primary key of the standards images
	 * @return the standards images
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages findByPrimaryKey(long stdImageId)
		throws NoSuchStandardsImagesException, SystemException {
		return findByPrimaryKey((Serializable)stdImageId);
	}

	/**
	 * Returns the standards images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards images
	 * @return the standards images, or <code>null</code> if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsImages standardsImages = (StandardsImages)EntityCacheUtil.getResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
				StandardsImagesImpl.class, primaryKey);

		if (standardsImages == _nullStandardsImages) {
			return null;
		}

		if (standardsImages == null) {
			Session session = null;

			try {
				session = openSession();

				standardsImages = (StandardsImages)session.get(StandardsImagesImpl.class,
						primaryKey);

				if (standardsImages != null) {
					cacheResult(standardsImages);
				}
				else {
					EntityCacheUtil.putResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
						StandardsImagesImpl.class, primaryKey,
						_nullStandardsImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsImagesModelImpl.ENTITY_CACHE_ENABLED,
					StandardsImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsImages;
	}

	/**
	 * Returns the standards images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdImageId the primary key of the standards images
	 * @return the standards images, or <code>null</code> if a standards images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsImages fetchByPrimaryKey(long stdImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdImageId);
	}

	/**
	 * Returns all the standards imageses.
	 *
	 * @return the standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @return the range of standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards imageses
	 * @param end the upper bound of the range of standards imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsImages> findAll(int start, int end,
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

		List<StandardsImages> list = (List<StandardsImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSIMAGES;

				if (pagination) {
					sql = sql.concat(StandardsImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsImages>(list);
				}
				else {
					list = (List<StandardsImages>)QueryUtil.list(q,
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
	 * Removes all the standards imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsImages standardsImages : findAll()) {
			remove(standardsImages);
		}
	}

	/**
	 * Returns the number of standards imageses.
	 *
	 * @return the number of standards imageses
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSIMAGES);

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
	 * Initializes the standards images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsImages>> listenersList = new ArrayList<ModelListener<StandardsImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSIMAGES = "SELECT standardsImages FROM StandardsImages standardsImages";
	private static final String _SQL_SELECT_STANDARDSIMAGES_WHERE = "SELECT standardsImages FROM StandardsImages standardsImages WHERE ";
	private static final String _SQL_COUNT_STANDARDSIMAGES = "SELECT COUNT(standardsImages) FROM StandardsImages standardsImages";
	private static final String _SQL_COUNT_STANDARDSIMAGES_WHERE = "SELECT COUNT(standardsImages) FROM StandardsImages standardsImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsImagesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdImageId", "parentImageId", "imageId", "stdId", "localeCode",
				"imageTitle", "imageSortOrder", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static StandardsImages _nullStandardsImages = new StandardsImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsImages> toCacheModel() {
				return _nullStandardsImagesCacheModel;
			}
		};

	private static CacheModel<StandardsImages> _nullStandardsImagesCacheModel = new CacheModel<StandardsImages>() {
			@Override
			public StandardsImages toEntityModel() {
				return _nullStandardsImages;
			}
		};
}