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

import com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException;
import com.ihg.brandstandards.db.model.GEMTemplateCategory;
import com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl;

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
 * The persistence implementation for the g e m template category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateCategoryPersistence
 * @see GEMTemplateCategoryUtil
 * @generated
 */
public class GEMTemplateCategoryPersistenceImpl extends BasePersistenceImpl<GEMTemplateCategory>
	implements GEMTemplateCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMTemplateCategoryUtil} to access the g e m template category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMTemplateCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			GEMTemplateCategoryModelImpl.TEMPLATEID_COLUMN_BITMASK |
			GEMTemplateCategoryModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m template categories where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the matching g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateCategory> findByTemplateId(long templateId)
		throws SystemException {
		return findByTemplateId(templateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m template categories where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of g e m template categories
	 * @param end the upper bound of the range of g e m template categories (not inclusive)
	 * @return the range of matching g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateCategory> findByTemplateId(long templateId,
		int start, int end) throws SystemException {
		return findByTemplateId(templateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m template categories where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of g e m template categories
	 * @param end the upper bound of the range of g e m template categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateCategory> findByTemplateId(long templateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId, start, end, orderByComparator };
		}

		List<GEMTemplateCategory> list = (List<GEMTemplateCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplateCategory gemTemplateCategory : list) {
				if ((templateId != gemTemplateCategory.getTemplateId())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATECATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (!pagination) {
					list = (List<GEMTemplateCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplateCategory>(list);
				}
				else {
					list = (List<GEMTemplateCategory>)QueryUtil.list(q,
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
	 * Returns the first g e m template category in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a matching g e m template category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory findByTemplateId_First(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		GEMTemplateCategory gemTemplateCategory = fetchByTemplateId_First(templateId,
				orderByComparator);

		if (gemTemplateCategory != null) {
			return gemTemplateCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateCategoryException(msg.toString());
	}

	/**
	 * Returns the first g e m template category in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template category, or <code>null</code> if a matching g e m template category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory fetchByTemplateId_First(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMTemplateCategory> list = findByTemplateId(templateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template category in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a matching g e m template category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory findByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		GEMTemplateCategory gemTemplateCategory = fetchByTemplateId_Last(templateId,
				orderByComparator);

		if (gemTemplateCategory != null) {
			return gemTemplateCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateCategoryException(msg.toString());
	}

	/**
	 * Returns the last g e m template category in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template category, or <code>null</code> if a matching g e m template category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory fetchByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(templateId);

		if (count == 0) {
			return null;
		}

		List<GEMTemplateCategory> list = findByTemplateId(templateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m template categories before and after the current g e m template category in the ordered set where templateId = &#63;.
	 *
	 * @param templateCatgyId the primary key of the current g e m template category
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory[] findByTemplateId_PrevAndNext(
		long templateCatgyId, long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		GEMTemplateCategory gemTemplateCategory = findByPrimaryKey(templateCatgyId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplateCategory[] array = new GEMTemplateCategoryImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session,
					gemTemplateCategory, templateId, orderByComparator, true);

			array[1] = gemTemplateCategory;

			array[2] = getByTemplateId_PrevAndNext(session,
					gemTemplateCategory, templateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMTemplateCategory getByTemplateId_PrevAndNext(Session session,
		GEMTemplateCategory gemTemplateCategory, long templateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATECATEGORY_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

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
			query.append(GEMTemplateCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplateCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplateCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m template categories where templateId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateId(long templateId) throws SystemException {
		for (GEMTemplateCategory gemTemplateCategory : findByTemplateId(
				templateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemTemplateCategory);
		}
	}

	/**
	 * Returns the number of g e m template categories where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the number of matching g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateId(long templateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEID;

		Object[] finderArgs = new Object[] { templateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMTEMPLATECATEGORY_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

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

	private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "gemTemplateCategory.templateId = ?";

	public GEMTemplateCategoryPersistenceImpl() {
		setModelClass(GEMTemplateCategory.class);
	}

	/**
	 * Caches the g e m template category in the entity cache if it is enabled.
	 *
	 * @param gemTemplateCategory the g e m template category
	 */
	@Override
	public void cacheResult(GEMTemplateCategory gemTemplateCategory) {
		EntityCacheUtil.putResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class, gemTemplateCategory.getPrimaryKey(),
			gemTemplateCategory);

		gemTemplateCategory.resetOriginalValues();
	}

	/**
	 * Caches the g e m template categories in the entity cache if it is enabled.
	 *
	 * @param gemTemplateCategories the g e m template categories
	 */
	@Override
	public void cacheResult(List<GEMTemplateCategory> gemTemplateCategories) {
		for (GEMTemplateCategory gemTemplateCategory : gemTemplateCategories) {
			if (EntityCacheUtil.getResult(
						GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateCategoryImpl.class,
						gemTemplateCategory.getPrimaryKey()) == null) {
				cacheResult(gemTemplateCategory);
			}
			else {
				gemTemplateCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m template categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMTemplateCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMTemplateCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m template category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMTemplateCategory gemTemplateCategory) {
		EntityCacheUtil.removeResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class, gemTemplateCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMTemplateCategory> gemTemplateCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMTemplateCategory gemTemplateCategory : gemTemplateCategories) {
			EntityCacheUtil.removeResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateCategoryImpl.class,
				gemTemplateCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m template category with the primary key. Does not add the g e m template category to the database.
	 *
	 * @param templateCatgyId the primary key for the new g e m template category
	 * @return the new g e m template category
	 */
	@Override
	public GEMTemplateCategory create(long templateCatgyId) {
		GEMTemplateCategory gemTemplateCategory = new GEMTemplateCategoryImpl();

		gemTemplateCategory.setNew(true);
		gemTemplateCategory.setPrimaryKey(templateCatgyId);

		return gemTemplateCategory;
	}

	/**
	 * Removes the g e m template category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateCatgyId the primary key of the g e m template category
	 * @return the g e m template category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory remove(long templateCatgyId)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		return remove((Serializable)templateCatgyId);
	}

	/**
	 * Removes the g e m template category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m template category
	 * @return the g e m template category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory remove(Serializable primaryKey)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMTemplateCategory gemTemplateCategory = (GEMTemplateCategory)session.get(GEMTemplateCategoryImpl.class,
					primaryKey);

			if (gemTemplateCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMTemplateCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemTemplateCategory);
		}
		catch (NoSuchGEMTemplateCategoryException nsee) {
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
	protected GEMTemplateCategory removeImpl(
		GEMTemplateCategory gemTemplateCategory) throws SystemException {
		gemTemplateCategory = toUnwrappedModel(gemTemplateCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemTemplateCategory)) {
				gemTemplateCategory = (GEMTemplateCategory)session.get(GEMTemplateCategoryImpl.class,
						gemTemplateCategory.getPrimaryKeyObj());
			}

			if (gemTemplateCategory != null) {
				session.delete(gemTemplateCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemTemplateCategory != null) {
			clearCache(gemTemplateCategory);
		}

		return gemTemplateCategory;
	}

	@Override
	public GEMTemplateCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory)
		throws SystemException {
		gemTemplateCategory = toUnwrappedModel(gemTemplateCategory);

		boolean isNew = gemTemplateCategory.isNew();

		GEMTemplateCategoryModelImpl gemTemplateCategoryModelImpl = (GEMTemplateCategoryModelImpl)gemTemplateCategory;

		Session session = null;

		try {
			session = openSession();

			if (gemTemplateCategory.isNew()) {
				session.save(gemTemplateCategory);

				gemTemplateCategory.setNew(false);
			}
			else {
				session.merge(gemTemplateCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMTemplateCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemTemplateCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateCategoryModelImpl.getOriginalTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] { gemTemplateCategoryModelImpl.getTemplateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateCategoryImpl.class, gemTemplateCategory.getPrimaryKey(),
			gemTemplateCategory);

		return gemTemplateCategory;
	}

	protected GEMTemplateCategory toUnwrappedModel(
		GEMTemplateCategory gemTemplateCategory) {
		if (gemTemplateCategory instanceof GEMTemplateCategoryImpl) {
			return gemTemplateCategory;
		}

		GEMTemplateCategoryImpl gemTemplateCategoryImpl = new GEMTemplateCategoryImpl();

		gemTemplateCategoryImpl.setNew(gemTemplateCategory.isNew());
		gemTemplateCategoryImpl.setPrimaryKey(gemTemplateCategory.getPrimaryKey());

		gemTemplateCategoryImpl.setTemplateCatgyId(gemTemplateCategory.getTemplateCatgyId());
		gemTemplateCategoryImpl.setTemplateId(gemTemplateCategory.getTemplateId());
		gemTemplateCategoryImpl.setCategoryId(gemTemplateCategory.getCategoryId());
		gemTemplateCategoryImpl.setCategoryViewType(gemTemplateCategory.getCategoryViewType());
		gemTemplateCategoryImpl.setCategoryAnsAll(gemTemplateCategory.getCategoryAnsAll());
		gemTemplateCategoryImpl.setDuplicatable(gemTemplateCategory.getDuplicatable());
		gemTemplateCategoryImpl.setDisplayOrderNumber(gemTemplateCategory.getDisplayOrderNumber());
		gemTemplateCategoryImpl.setCreatorId(gemTemplateCategory.getCreatorId());
		gemTemplateCategoryImpl.setCreatedDate(gemTemplateCategory.getCreatedDate());
		gemTemplateCategoryImpl.setUpdatedBy(gemTemplateCategory.getUpdatedBy());
		gemTemplateCategoryImpl.setUpdatedDate(gemTemplateCategory.getUpdatedDate());

		return gemTemplateCategoryImpl;
	}

	/**
	 * Returns the g e m template category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template category
	 * @return the g e m template category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		GEMTemplateCategory gemTemplateCategory = fetchByPrimaryKey(primaryKey);

		if (gemTemplateCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMTemplateCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemTemplateCategory;
	}

	/**
	 * Returns the g e m template category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException} if it could not be found.
	 *
	 * @param templateCatgyId the primary key of the g e m template category
	 * @return the g e m template category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory findByPrimaryKey(long templateCatgyId)
		throws NoSuchGEMTemplateCategoryException, SystemException {
		return findByPrimaryKey((Serializable)templateCatgyId);
	}

	/**
	 * Returns the g e m template category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template category
	 * @return the g e m template category, or <code>null</code> if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMTemplateCategory gemTemplateCategory = (GEMTemplateCategory)EntityCacheUtil.getResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateCategoryImpl.class, primaryKey);

		if (gemTemplateCategory == _nullGEMTemplateCategory) {
			return null;
		}

		if (gemTemplateCategory == null) {
			Session session = null;

			try {
				session = openSession();

				gemTemplateCategory = (GEMTemplateCategory)session.get(GEMTemplateCategoryImpl.class,
						primaryKey);

				if (gemTemplateCategory != null) {
					cacheResult(gemTemplateCategory);
				}
				else {
					EntityCacheUtil.putResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateCategoryImpl.class, primaryKey,
						_nullGEMTemplateCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMTemplateCategoryModelImpl.ENTITY_CACHE_ENABLED,
					GEMTemplateCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemTemplateCategory;
	}

	/**
	 * Returns the g e m template category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateCatgyId the primary key of the g e m template category
	 * @return the g e m template category, or <code>null</code> if a g e m template category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateCategory fetchByPrimaryKey(long templateCatgyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)templateCatgyId);
	}

	/**
	 * Returns all the g e m template categories.
	 *
	 * @return the g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m template categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template categories
	 * @param end the upper bound of the range of g e m template categories (not inclusive)
	 * @return the range of g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m template categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template categories
	 * @param end the upper bound of the range of g e m template categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m template categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateCategory> findAll(int start, int end,
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

		List<GEMTemplateCategory> list = (List<GEMTemplateCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMTEMPLATECATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMTEMPLATECATEGORY;

				if (pagination) {
					sql = sql.concat(GEMTemplateCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMTemplateCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplateCategory>(list);
				}
				else {
					list = (List<GEMTemplateCategory>)QueryUtil.list(q,
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
	 * Removes all the g e m template categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMTemplateCategory gemTemplateCategory : findAll()) {
			remove(gemTemplateCategory);
		}
	}

	/**
	 * Returns the number of g e m template categories.
	 *
	 * @return the number of g e m template categories
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

				Query q = session.createQuery(_SQL_COUNT_GEMTEMPLATECATEGORY);

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
	 * Initializes the g e m template category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMTemplateCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMTemplateCategory>> listenersList = new ArrayList<ModelListener<GEMTemplateCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMTemplateCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMTemplateCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMTEMPLATECATEGORY = "SELECT gemTemplateCategory FROM GEMTemplateCategory gemTemplateCategory";
	private static final String _SQL_SELECT_GEMTEMPLATECATEGORY_WHERE = "SELECT gemTemplateCategory FROM GEMTemplateCategory gemTemplateCategory WHERE ";
	private static final String _SQL_COUNT_GEMTEMPLATECATEGORY = "SELECT COUNT(gemTemplateCategory) FROM GEMTemplateCategory gemTemplateCategory";
	private static final String _SQL_COUNT_GEMTEMPLATECATEGORY_WHERE = "SELECT COUNT(gemTemplateCategory) FROM GEMTemplateCategory gemTemplateCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemTemplateCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMTemplateCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMTemplateCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMTemplateCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"templateCatgyId", "templateId", "categoryId",
				"categoryViewType", "categoryAnsAll", "duplicatable",
				"displayOrderNumber", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static GEMTemplateCategory _nullGEMTemplateCategory = new GEMTemplateCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMTemplateCategory> toCacheModel() {
				return _nullGEMTemplateCategoryCacheModel;
			}
		};

	private static CacheModel<GEMTemplateCategory> _nullGEMTemplateCategoryCacheModel =
		new CacheModel<GEMTemplateCategory>() {
			@Override
			public GEMTemplateCategory toEntityModel() {
				return _nullGEMTemplateCategory;
			}
		};
}