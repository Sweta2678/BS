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

import com.ihg.brandstandards.db.NoSuchGEMTemplateException;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.impl.GEMTemplateImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl;

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
 * The persistence implementation for the g e m template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplatePersistence
 * @see GEMTemplateUtil
 * @generated
 */
public class GEMTemplatePersistenceImpl extends BasePersistenceImpl<GEMTemplate>
	implements GEMTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMTemplateUtil} to access the g e m template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishId",
			new String[] { Long.class.getName() },
			GEMTemplateModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m templates where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishId(long publishId)
		throws SystemException {
		return findByPublishId(publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the g e m templates where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishId(long publishId, int start, int end)
		throws SystemException {
		return findByPublishId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishId(long publishId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplate gemTemplate : list) {
				if ((publishId != gemTemplate.getPublishId())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m template in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishId_First(publishId,
				orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the first g e m template in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMTemplate> list = findByPublishId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishId_Last(publishId,
				orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(publishId);

		if (count == 0) {
			return null;
		}

		List<GEMTemplate> list = findByPublishId(publishId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63;.
	 *
	 * @param templateId the primary key of the current g e m template
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate[] findByPublishId_PrevAndNext(long templateId,
		long publishId, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplate[] array = new GEMTemplateImpl[3];

			array[0] = getByPublishId_PrevAndNext(session, gemTemplate,
					publishId, orderByComparator, true);

			array[1] = gemTemplate;

			array[2] = getByPublishId_PrevAndNext(session, gemTemplate,
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

	protected GEMTemplate getByPublishId_PrevAndNext(Session session,
		GEMTemplate gemTemplate, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

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
			query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m templates where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long publishId) throws SystemException {
		for (GEMTemplate gemTemplate : findByPublishId(publishId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching g e m templates
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

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_PUBLISHID_PUBLISHID_2 = "gemTemplate.publishId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDRGNID =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishIdAndRgnId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndRgnId",
			new String[] { Long.class.getName(), Long.class.getName() },
			GEMTemplateModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMTemplateModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID = new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndRgnId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the g e m templates where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndRgnId(long publishId,
		long regionId) throws SystemException {
		return findByPublishIdAndRgnId(publishId, regionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m templates where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndRgnId(long publishId,
		long regionId, int start, int end) throws SystemException {
		return findByPublishIdAndRgnId(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndRgnId(long publishId,
		long regionId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID;
			finderArgs = new Object[] { publishId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDRGNID;
			finderArgs = new Object[] {
					publishId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplate gemTemplate : list) {
				if ((publishId != gemTemplate.getPublishId()) ||
						(regionId != gemTemplate.getRegionId())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishIdAndRgnId_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishIdAndRgnId_First(publishId,
				regionId, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishIdAndRgnId_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMTemplate> list = findByPublishIdAndRgnId(publishId, regionId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishIdAndRgnId_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishIdAndRgnId_Last(publishId,
				regionId, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishIdAndRgnId_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndRgnId(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<GEMTemplate> list = findByPublishIdAndRgnId(publishId, regionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param templateId the primary key of the current g e m template
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate[] findByPublishIdAndRgnId_PrevAndNext(long templateId,
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplate[] array = new GEMTemplateImpl[3];

			array[0] = getByPublishIdAndRgnId_PrevAndNext(session, gemTemplate,
					publishId, regionId, orderByComparator, true);

			array[1] = gemTemplate;

			array[2] = getByPublishIdAndRgnId_PrevAndNext(session, gemTemplate,
					publishId, regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMTemplate getByPublishIdAndRgnId_PrevAndNext(Session session,
		GEMTemplate gemTemplate, long publishId, long regionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHID_2);

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
			query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m templates where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndRgnId(long publishId, long regionId)
		throws SystemException {
		for (GEMTemplate gemTemplate : findByPublishIdAndRgnId(publishId,
				regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndRgnId(long publishId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID;

		Object[] finderArgs = new Object[] { publishId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNID_PUBLISHID_2 = "gemTemplate.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNID_REGIONID_2 = "gemTemplate.regionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishIdAndRgnIdAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndRgnIdAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			GEMTemplateModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMTemplateModelImpl.REGIONID_COLUMN_BITMASK |
			GEMTemplateModelImpl.TEMPLATETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNIDANDTYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndRgnIdAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @return the matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndRgnIdAndType(long publishId,
		long regionId, String templateType) throws SystemException {
		return findByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndRgnIdAndType(long publishId,
		long regionId, String templateType, int start, int end)
		throws SystemException {
		return findByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndRgnIdAndType(long publishId,
		long regionId, String templateType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE;
			finderArgs = new Object[] { publishId, regionId, templateType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE;
			finderArgs = new Object[] {
					publishId, regionId, templateType,
					
					start, end, orderByComparator
				};
		}

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplate gemTemplate : list) {
				if ((publishId != gemTemplate.getPublishId()) ||
						(regionId != gemTemplate.getRegionId()) ||
						!Validator.equals(templateType,
							gemTemplate.getTemplateType())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_REGIONID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishIdAndRgnIdAndType_First(long publishId,
		long regionId, String templateType, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishIdAndRgnIdAndType_First(publishId,
				regionId, templateType, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", templateType=");
		msg.append(templateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishIdAndRgnIdAndType_First(long publishId,
		long regionId, String templateType, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMTemplate> list = findByPublishIdAndRgnIdAndType(publishId,
				regionId, templateType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishIdAndRgnIdAndType_Last(long publishId,
		long regionId, String templateType, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishIdAndRgnIdAndType_Last(publishId,
				regionId, templateType, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", templateType=");
		msg.append(templateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishIdAndRgnIdAndType_Last(long publishId,
		long regionId, String templateType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndRgnIdAndType(publishId, regionId,
				templateType);

		if (count == 0) {
			return null;
		}

		List<GEMTemplate> list = findByPublishIdAndRgnIdAndType(publishId,
				regionId, templateType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param templateId the primary key of the current g e m template
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate[] findByPublishIdAndRgnIdAndType_PrevAndNext(
		long templateId, long publishId, long regionId, String templateType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplate[] array = new GEMTemplateImpl[3];

			array[0] = getByPublishIdAndRgnIdAndType_PrevAndNext(session,
					gemTemplate, publishId, regionId, templateType,
					orderByComparator, true);

			array[1] = gemTemplate;

			array[2] = getByPublishIdAndRgnIdAndType_PrevAndNext(session,
					gemTemplate, publishId, regionId, templateType,
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

	protected GEMTemplate getByPublishIdAndRgnIdAndType_PrevAndNext(
		Session session, GEMTemplate gemTemplate, long publishId,
		long regionId, String templateType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_REGIONID_2);

		boolean bindTemplateType = false;

		if (templateType == null) {
			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_1);
		}
		else if (templateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_3);
		}
		else {
			bindTemplateType = true;

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_2);
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
			query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (bindTemplateType) {
			qPos.add(templateType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndRgnIdAndType(long publishId, long regionId,
		String templateType) throws SystemException {
		for (GEMTemplate gemTemplate : findByPublishIdAndRgnIdAndType(
				publishId, regionId, templateType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param templateType the template type
	 * @return the number of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndRgnIdAndType(long publishId, long regionId,
		String templateType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNIDANDTYPE;

		Object[] finderArgs = new Object[] { publishId, regionId, templateType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_REGIONID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (bindTemplateType) {
					qPos.add(templateType);
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

	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_PUBLISHID_2 =
		"gemTemplate.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_REGIONID_2 =
		"gemTemplate.regionId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_1 =
		"gemTemplate.templateType IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_2 =
		"gemTemplate.templateType = ?";
	private static final String _FINDER_COLUMN_PUBLISHIDANDRGNIDANDTYPE_TEMPLATETYPE_3 =
		"(gemTemplate.templateType IS NULL OR gemTemplate.templateType = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTypeAndRegionAndPublication",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			GEMTemplateModelImpl.TEMPLATETYPE_COLUMN_BITMASK |
			GEMTemplateModelImpl.REGIONID_COLUMN_BITMASK |
			GEMTemplateModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATION =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeAndRegionAndPublication",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateException} if it could not be found.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @return the matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByTypeAndRegionAndPublication(String templateType,
		long regionId, long publishId)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByTypeAndRegionAndPublication(templateType,
				regionId, publishId);

		if (gemTemplate == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("templateType=");
			msg.append(templateType);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(", publishId=");
			msg.append(publishId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMTemplateException(msg.toString());
		}

		return gemTemplate;
	}

	/**
	 * Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @return the matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByTypeAndRegionAndPublication(String templateType,
		long regionId, long publishId) throws SystemException {
		return fetchByTypeAndRegionAndPublication(templateType, regionId,
			publishId, true);
	}

	/**
	 * Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByTypeAndRegionAndPublication(String templateType,
		long regionId, long publishId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { templateType, regionId, publishId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
					finderArgs, this);
		}

		if (result instanceof GEMTemplate) {
			GEMTemplate gemTemplate = (GEMTemplate)result;

			if (!Validator.equals(templateType, gemTemplate.getTemplateType()) ||
					(regionId != gemTemplate.getRegionId()) ||
					(publishId != gemTemplate.getPublishId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_2);
			}

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_REGIONID_2);

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				qPos.add(regionId);

				qPos.add(publishId);

				List<GEMTemplate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMTemplatePersistenceImpl.fetchByTypeAndRegionAndPublication(String, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMTemplate gemTemplate = list.get(0);

					result = gemTemplate;

					cacheResult(gemTemplate);

					if ((gemTemplate.getTemplateType() == null) ||
							!gemTemplate.getTemplateType().equals(templateType) ||
							(gemTemplate.getRegionId() != regionId) ||
							(gemTemplate.getPublishId() != publishId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
							finderArgs, gemTemplate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
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
			return (GEMTemplate)result;
		}
	}

	/**
	 * Removes the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; from the database.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @return the g e m template that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate removeByTypeAndRegionAndPublication(
		String templateType, long regionId, long publishId)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByTypeAndRegionAndPublication(templateType,
				regionId, publishId);

		return remove(gemTemplate);
	}

	/**
	 * Returns the number of g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @return the number of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeAndRegionAndPublication(String templateType,
		long regionId, long publishId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATION;

		Object[] finderArgs = new Object[] { templateType, regionId, publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_2);
			}

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_REGIONID_2);

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_1 =
		"gemTemplate.templateType IS NULL AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_2 =
		"gemTemplate.templateType = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_TEMPLATETYPE_3 =
		"(gemTemplate.templateType IS NULL OR gemTemplate.templateType = '') AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_REGIONID_2 =
		"gemTemplate.regionId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATION_PUBLISHID_2 =
		"gemTemplate.publishId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeAndRegionAndPublicationList",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeAndRegionAndPublicationList",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			GEMTemplateModelImpl.TEMPLATETYPE_COLUMN_BITMASK |
			GEMTemplateModelImpl.REGIONID_COLUMN_BITMASK |
			GEMTemplateModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATIONLIST =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeAndRegionAndPublicationList",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @return the matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByTypeAndRegionAndPublicationList(
		String templateType, long regionId, long publishId)
		throws SystemException {
		return findByTypeAndRegionAndPublicationList(templateType, regionId,
			publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByTypeAndRegionAndPublicationList(
		String templateType, long regionId, long publishId, int start, int end)
		throws SystemException {
		return findByTypeAndRegionAndPublicationList(templateType, regionId,
			publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByTypeAndRegionAndPublicationList(
		String templateType, long regionId, long publishId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST;
			finderArgs = new Object[] { templateType, regionId, publishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST;
			finderArgs = new Object[] {
					templateType, regionId, publishId,
					
					start, end, orderByComparator
				};
		}

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplate gemTemplate : list) {
				if (!Validator.equals(templateType,
							gemTemplate.getTemplateType()) ||
						(regionId != gemTemplate.getRegionId()) ||
						(publishId != gemTemplate.getPublishId())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_2);
			}

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_REGIONID_2);

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				qPos.add(regionId);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByTypeAndRegionAndPublicationList_First(
		String templateType, long regionId, long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByTypeAndRegionAndPublicationList_First(templateType,
				regionId, publishId, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateType=");
		msg.append(templateType);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the first g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByTypeAndRegionAndPublicationList_First(
		String templateType, long regionId, long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMTemplate> list = findByTypeAndRegionAndPublicationList(templateType,
				regionId, publishId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByTypeAndRegionAndPublicationList_Last(
		String templateType, long regionId, long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByTypeAndRegionAndPublicationList_Last(templateType,
				regionId, publishId, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateType=");
		msg.append(templateType);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the last g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByTypeAndRegionAndPublicationList_Last(
		String templateType, long regionId, long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeAndRegionAndPublicationList(templateType,
				regionId, publishId);

		if (count == 0) {
			return null;
		}

		List<GEMTemplate> list = findByTypeAndRegionAndPublicationList(templateType,
				regionId, publishId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m templates before and after the current g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateId the primary key of the current g e m template
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate[] findByTypeAndRegionAndPublicationList_PrevAndNext(
		long templateId, String templateType, long regionId, long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplate[] array = new GEMTemplateImpl[3];

			array[0] = getByTypeAndRegionAndPublicationList_PrevAndNext(session,
					gemTemplate, templateType, regionId, publishId,
					orderByComparator, true);

			array[1] = gemTemplate;

			array[2] = getByTypeAndRegionAndPublicationList_PrevAndNext(session,
					gemTemplate, templateType, regionId, publishId,
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

	protected GEMTemplate getByTypeAndRegionAndPublicationList_PrevAndNext(
		Session session, GEMTemplate gemTemplate, String templateType,
		long regionId, long publishId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

		boolean bindTemplateType = false;

		if (templateType == null) {
			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_1);
		}
		else if (templateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_3);
		}
		else {
			bindTemplateType = true;

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_2);
		}

		query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_REGIONID_2);

		query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_PUBLISHID_2);

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
			query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTemplateType) {
			qPos.add(templateType);
		}

		qPos.add(regionId);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63; from the database.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeAndRegionAndPublicationList(String templateType,
		long regionId, long publishId) throws SystemException {
		for (GEMTemplate gemTemplate : findByTypeAndRegionAndPublicationList(
				templateType, regionId, publishId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	 *
	 * @param templateType the template type
	 * @param regionId the region ID
	 * @param publishId the publish ID
	 * @return the number of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeAndRegionAndPublicationList(String templateType,
		long regionId, long publishId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATIONLIST;

		Object[] finderArgs = new Object[] { templateType, regionId, publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_2);
			}

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_REGIONID_2);

			query.append(_FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_1 =
		"gemTemplate.templateType IS NULL AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_2 =
		"gemTemplate.templateType = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_TEMPLATETYPE_3 =
		"(gemTemplate.templateType IS NULL OR gemTemplate.templateType = '') AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_REGIONID_2 =
		"gemTemplate.regionId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDREGIONANDPUBLICATIONLIST_PUBLISHID_2 =
		"gemTemplate.publishId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishIdAndTemplateType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndTemplateType",
			new String[] { Long.class.getName(), String.class.getName() },
			GEMTemplateModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMTemplateModelImpl.TEMPLATETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDTEMPLATETYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndTemplateType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the g e m templates where publishId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @return the matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndTemplateType(long publishId,
		String templateType) throws SystemException {
		return findByPublishIdAndTemplateType(publishId, templateType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m templates where publishId = &#63; and templateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndTemplateType(long publishId,
		String templateType, int start, int end) throws SystemException {
		return findByPublishIdAndTemplateType(publishId, templateType, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates where publishId = &#63; and templateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByPublishIdAndTemplateType(long publishId,
		String templateType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE;
			finderArgs = new Object[] { publishId, templateType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE;
			finderArgs = new Object[] {
					publishId, templateType,
					
					start, end, orderByComparator
				};
		}

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplate gemTemplate : list) {
				if ((publishId != gemTemplate.getPublishId()) ||
						!Validator.equals(templateType,
							gemTemplate.getTemplateType())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_PUBLISHID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishIdAndTemplateType_First(long publishId,
		String templateType, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishIdAndTemplateType_First(publishId,
				templateType, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", templateType=");
		msg.append(templateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the first g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishIdAndTemplateType_First(long publishId,
		String templateType, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMTemplate> list = findByPublishIdAndTemplateType(publishId,
				templateType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPublishIdAndTemplateType_Last(long publishId,
		String templateType, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPublishIdAndTemplateType_Last(publishId,
				templateType, orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", templateType=");
		msg.append(templateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the last g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPublishIdAndTemplateType_Last(long publishId,
		String templateType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndTemplateType(publishId, templateType);

		if (count == 0) {
			return null;
		}

		List<GEMTemplate> list = findByPublishIdAndTemplateType(publishId,
				templateType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	 *
	 * @param templateId the primary key of the current g e m template
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate[] findByPublishIdAndTemplateType_PrevAndNext(
		long templateId, long publishId, String templateType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplate[] array = new GEMTemplateImpl[3];

			array[0] = getByPublishIdAndTemplateType_PrevAndNext(session,
					gemTemplate, publishId, templateType, orderByComparator,
					true);

			array[1] = gemTemplate;

			array[2] = getByPublishIdAndTemplateType_PrevAndNext(session,
					gemTemplate, publishId, templateType, orderByComparator,
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

	protected GEMTemplate getByPublishIdAndTemplateType_PrevAndNext(
		Session session, GEMTemplate gemTemplate, long publishId,
		String templateType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_PUBLISHID_2);

		boolean bindTemplateType = false;

		if (templateType == null) {
			query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_1);
		}
		else if (templateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_3);
		}
		else {
			bindTemplateType = true;

			query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_2);
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
			query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (bindTemplateType) {
			qPos.add(templateType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m templates where publishId = &#63; and templateType = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndTemplateType(long publishId,
		String templateType) throws SystemException {
		for (GEMTemplate gemTemplate : findByPublishIdAndTemplateType(
				publishId, templateType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates where publishId = &#63; and templateType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param templateType the template type
	 * @return the number of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndTemplateType(long publishId,
		String templateType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDTEMPLATETYPE;

		Object[] finderArgs = new Object[] { publishId, templateType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_PUBLISHID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindTemplateType) {
					qPos.add(templateType);
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

	private static final String _FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_PUBLISHID_2 =
		"gemTemplate.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_1 =
		"gemTemplate.templateType IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_2 =
		"gemTemplate.templateType = ?";
	private static final String _FINDER_COLUMN_PUBLISHIDANDTEMPLATETYPE_TEMPLATETYPE_3 =
		"(gemTemplate.templateType IS NULL OR gemTemplate.templateType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATETYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATETYPE =
		new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, GEMTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateType",
			new String[] { String.class.getName() },
			GEMTemplateModelImpl.TEMPLATETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATETYPE = new FinderPath(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the g e m templates where templateType = &#63;.
	 *
	 * @param templateType the template type
	 * @return the matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByTemplateType(String templateType)
		throws SystemException {
		return findByTemplateType(templateType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m templates where templateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateType the template type
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByTemplateType(String templateType, int start,
		int end) throws SystemException {
		return findByTemplateType(templateType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates where templateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateType the template type
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findByTemplateType(String templateType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATETYPE;
			finderArgs = new Object[] { templateType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATETYPE;
			finderArgs = new Object[] {
					templateType,
					
					start, end, orderByComparator
				};
		}

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMTemplate gemTemplate : list) {
				if (!Validator.equals(templateType,
							gemTemplate.getTemplateType())) {
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

			query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m template in the ordered set where templateType = &#63;.
	 *
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByTemplateType_First(String templateType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByTemplateType_First(templateType,
				orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateType=");
		msg.append(templateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the first g e m template in the ordered set where templateType = &#63;.
	 *
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByTemplateType_First(String templateType,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMTemplate> list = findByTemplateType(templateType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m template in the ordered set where templateType = &#63;.
	 *
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByTemplateType_Last(String templateType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByTemplateType_Last(templateType,
				orderByComparator);

		if (gemTemplate != null) {
			return gemTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateType=");
		msg.append(templateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMTemplateException(msg.toString());
	}

	/**
	 * Returns the last g e m template in the ordered set where templateType = &#63;.
	 *
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByTemplateType_Last(String templateType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateType(templateType);

		if (count == 0) {
			return null;
		}

		List<GEMTemplate> list = findByTemplateType(templateType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m templates before and after the current g e m template in the ordered set where templateType = &#63;.
	 *
	 * @param templateId the primary key of the current g e m template
	 * @param templateType the template type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate[] findByTemplateType_PrevAndNext(long templateId,
		String templateType, OrderByComparator orderByComparator)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = findByPrimaryKey(templateId);

		Session session = null;

		try {
			session = openSession();

			GEMTemplate[] array = new GEMTemplateImpl[3];

			array[0] = getByTemplateType_PrevAndNext(session, gemTemplate,
					templateType, orderByComparator, true);

			array[1] = gemTemplate;

			array[2] = getByTemplateType_PrevAndNext(session, gemTemplate,
					templateType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMTemplate getByTemplateType_PrevAndNext(Session session,
		GEMTemplate gemTemplate, String templateType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMTEMPLATE_WHERE);

		boolean bindTemplateType = false;

		if (templateType == null) {
			query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_1);
		}
		else if (templateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_3);
		}
		else {
			bindTemplateType = true;

			query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_2);
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
			query.append(GEMTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTemplateType) {
			qPos.add(templateType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m templates where templateType = &#63; from the database.
	 *
	 * @param templateType the template type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateType(String templateType)
		throws SystemException {
		for (GEMTemplate gemTemplate : findByTemplateType(templateType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates where templateType = &#63;.
	 *
	 * @param templateType the template type
	 * @return the number of matching g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateType(String templateType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATETYPE;

		Object[] finderArgs = new Object[] { templateType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMTEMPLATE_WHERE);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateType) {
					qPos.add(templateType);
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

	private static final String _FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_1 = "gemTemplate.templateType IS NULL";
	private static final String _FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_2 = "gemTemplate.templateType = ?";
	private static final String _FINDER_COLUMN_TEMPLATETYPE_TEMPLATETYPE_3 = "(gemTemplate.templateType IS NULL OR gemTemplate.templateType = '')";

	public GEMTemplatePersistenceImpl() {
		setModelClass(GEMTemplate.class);
	}

	/**
	 * Caches the g e m template in the entity cache if it is enabled.
	 *
	 * @param gemTemplate the g e m template
	 */
	@Override
	public void cacheResult(GEMTemplate gemTemplate) {
		EntityCacheUtil.putResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateImpl.class, gemTemplate.getPrimaryKey(), gemTemplate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
			new Object[] {
				gemTemplate.getTemplateType(), gemTemplate.getRegionId(),
				gemTemplate.getPublishId()
			}, gemTemplate);

		gemTemplate.resetOriginalValues();
	}

	/**
	 * Caches the g e m templates in the entity cache if it is enabled.
	 *
	 * @param gemTemplates the g e m templates
	 */
	@Override
	public void cacheResult(List<GEMTemplate> gemTemplates) {
		for (GEMTemplate gemTemplate : gemTemplates) {
			if (EntityCacheUtil.getResult(
						GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateImpl.class, gemTemplate.getPrimaryKey()) == null) {
				cacheResult(gemTemplate);
			}
			else {
				gemTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMTemplate gemTemplate) {
		EntityCacheUtil.removeResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateImpl.class, gemTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemTemplate);
	}

	@Override
	public void clearCache(List<GEMTemplate> gemTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMTemplate gemTemplate : gemTemplates) {
			EntityCacheUtil.removeResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateImpl.class, gemTemplate.getPrimaryKey());

			clearUniqueFindersCache(gemTemplate);
		}
	}

	protected void cacheUniqueFindersCache(GEMTemplate gemTemplate) {
		if (gemTemplate.isNew()) {
			Object[] args = new Object[] {
					gemTemplate.getTemplateType(), gemTemplate.getRegionId(),
					gemTemplate.getPublishId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
				args, gemTemplate);
		}
		else {
			GEMTemplateModelImpl gemTemplateModelImpl = (GEMTemplateModelImpl)gemTemplate;

			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplate.getTemplateType(), gemTemplate.getRegionId(),
						gemTemplate.getPublishId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
					args, gemTemplate);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMTemplate gemTemplate) {
		GEMTemplateModelImpl gemTemplateModelImpl = (GEMTemplateModelImpl)gemTemplate;

		Object[] args = new Object[] {
				gemTemplate.getTemplateType(), gemTemplate.getRegionId(),
				gemTemplate.getPublishId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
			args);

		if ((gemTemplateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemTemplateModelImpl.getOriginalTemplateType(),
					gemTemplateModelImpl.getOriginalRegionId(),
					gemTemplateModelImpl.getOriginalPublishId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEANDREGIONANDPUBLICATION,
				args);
		}
	}

	/**
	 * Creates a new g e m template with the primary key. Does not add the g e m template to the database.
	 *
	 * @param templateId the primary key for the new g e m template
	 * @return the new g e m template
	 */
	@Override
	public GEMTemplate create(long templateId) {
		GEMTemplate gemTemplate = new GEMTemplateImpl();

		gemTemplate.setNew(true);
		gemTemplate.setPrimaryKey(templateId);

		return gemTemplate;
	}

	/**
	 * Removes the g e m template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the g e m template
	 * @return the g e m template that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate remove(long templateId)
		throws NoSuchGEMTemplateException, SystemException {
		return remove((Serializable)templateId);
	}

	/**
	 * Removes the g e m template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m template
	 * @return the g e m template that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate remove(Serializable primaryKey)
		throws NoSuchGEMTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMTemplate gemTemplate = (GEMTemplate)session.get(GEMTemplateImpl.class,
					primaryKey);

			if (gemTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemTemplate);
		}
		catch (NoSuchGEMTemplateException nsee) {
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
	protected GEMTemplate removeImpl(GEMTemplate gemTemplate)
		throws SystemException {
		gemTemplate = toUnwrappedModel(gemTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemTemplate)) {
				gemTemplate = (GEMTemplate)session.get(GEMTemplateImpl.class,
						gemTemplate.getPrimaryKeyObj());
			}

			if (gemTemplate != null) {
				session.delete(gemTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemTemplate != null) {
			clearCache(gemTemplate);
		}

		return gemTemplate;
	}

	@Override
	public GEMTemplate updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate)
		throws SystemException {
		gemTemplate = toUnwrappedModel(gemTemplate);

		boolean isNew = gemTemplate.isNew();

		GEMTemplateModelImpl gemTemplateModelImpl = (GEMTemplateModelImpl)gemTemplate;

		Session session = null;

		try {
			session = openSession();

			if (gemTemplate.isNew()) {
				session.save(gemTemplate);

				gemTemplate.setNew(false);
			}
			else {
				session.merge(gemTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] { gemTemplateModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}

			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateModelImpl.getOriginalPublishId(),
						gemTemplateModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID,
					args);

				args = new Object[] {
						gemTemplateModelImpl.getPublishId(),
						gemTemplateModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNID,
					args);
			}

			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateModelImpl.getOriginalPublishId(),
						gemTemplateModelImpl.getOriginalRegionId(),
						gemTemplateModelImpl.getOriginalTemplateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE,
					args);

				args = new Object[] {
						gemTemplateModelImpl.getPublishId(),
						gemTemplateModelImpl.getRegionId(),
						gemTemplateModelImpl.getTemplateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDRGNIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDRGNIDANDTYPE,
					args);
			}

			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateModelImpl.getOriginalTemplateType(),
						gemTemplateModelImpl.getOriginalRegionId(),
						gemTemplateModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATIONLIST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST,
					args);

				args = new Object[] {
						gemTemplateModelImpl.getTemplateType(),
						gemTemplateModelImpl.getRegionId(),
						gemTemplateModelImpl.getPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDREGIONANDPUBLICATIONLIST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDREGIONANDPUBLICATIONLIST,
					args);
			}

			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateModelImpl.getOriginalPublishId(),
						gemTemplateModelImpl.getOriginalTemplateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDTEMPLATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE,
					args);

				args = new Object[] {
						gemTemplateModelImpl.getPublishId(),
						gemTemplateModelImpl.getTemplateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDTEMPLATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDTEMPLATETYPE,
					args);
			}

			if ((gemTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemTemplateModelImpl.getOriginalTemplateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATETYPE,
					args);

				args = new Object[] { gemTemplateModelImpl.getTemplateType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATETYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateImpl.class, gemTemplate.getPrimaryKey(), gemTemplate);

		clearUniqueFindersCache(gemTemplate);
		cacheUniqueFindersCache(gemTemplate);

		return gemTemplate;
	}

	protected GEMTemplate toUnwrappedModel(GEMTemplate gemTemplate) {
		if (gemTemplate instanceof GEMTemplateImpl) {
			return gemTemplate;
		}

		GEMTemplateImpl gemTemplateImpl = new GEMTemplateImpl();

		gemTemplateImpl.setNew(gemTemplate.isNew());
		gemTemplateImpl.setPrimaryKey(gemTemplate.getPrimaryKey());

		gemTemplateImpl.setTemplateId(gemTemplate.getTemplateId());
		gemTemplateImpl.setTemplateName(gemTemplate.getTemplateName());
		gemTemplateImpl.setPublishId(gemTemplate.getPublishId());
		gemTemplateImpl.setRegionId(gemTemplate.getRegionId());
		gemTemplateImpl.setTemplateType(gemTemplate.getTemplateType());
		gemTemplateImpl.setCreatorId(gemTemplate.getCreatorId());
		gemTemplateImpl.setCreatedDate(gemTemplate.getCreatedDate());
		gemTemplateImpl.setUpdatedBy(gemTemplate.getUpdatedBy());
		gemTemplateImpl.setUpdatedDate(gemTemplate.getUpdatedDate());

		return gemTemplateImpl;
	}

	/**
	 * Returns the g e m template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template
	 * @return the g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMTemplateException, SystemException {
		GEMTemplate gemTemplate = fetchByPrimaryKey(primaryKey);

		if (gemTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemTemplate;
	}

	/**
	 * Returns the g e m template with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateException} if it could not be found.
	 *
	 * @param templateId the primary key of the g e m template
	 * @return the g e m template
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate findByPrimaryKey(long templateId)
		throws NoSuchGEMTemplateException, SystemException {
		return findByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns the g e m template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template
	 * @return the g e m template, or <code>null</code> if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMTemplate gemTemplate = (GEMTemplate)EntityCacheUtil.getResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateImpl.class, primaryKey);

		if (gemTemplate == _nullGEMTemplate) {
			return null;
		}

		if (gemTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				gemTemplate = (GEMTemplate)session.get(GEMTemplateImpl.class,
						primaryKey);

				if (gemTemplate != null) {
					cacheResult(gemTemplate);
				}
				else {
					EntityCacheUtil.putResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateImpl.class, primaryKey, _nullGEMTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMTemplateModelImpl.ENTITY_CACHE_ENABLED,
					GEMTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemTemplate;
	}

	/**
	 * Returns the g e m template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the g e m template
	 * @return the g e m template, or <code>null</code> if a g e m template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplate fetchByPrimaryKey(long templateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns all the g e m templates.
	 *
	 * @return the g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @return the range of g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m templates
	 * @param end the upper bound of the range of g e m templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplate> findAll(int start, int end,
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

		List<GEMTemplate> list = (List<GEMTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMTEMPLATE;

				if (pagination) {
					sql = sql.concat(GEMTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplate>(list);
				}
				else {
					list = (List<GEMTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMTemplate gemTemplate : findAll()) {
			remove(gemTemplate);
		}
	}

	/**
	 * Returns the number of g e m templates.
	 *
	 * @return the number of g e m templates
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

				Query q = session.createQuery(_SQL_COUNT_GEMTEMPLATE);

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
	 * Initializes the g e m template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMTemplate>> listenersList = new ArrayList<ModelListener<GEMTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMTEMPLATE = "SELECT gemTemplate FROM GEMTemplate gemTemplate";
	private static final String _SQL_SELECT_GEMTEMPLATE_WHERE = "SELECT gemTemplate FROM GEMTemplate gemTemplate WHERE ";
	private static final String _SQL_COUNT_GEMTEMPLATE = "SELECT COUNT(gemTemplate) FROM GEMTemplate gemTemplate";
	private static final String _SQL_COUNT_GEMTEMPLATE_WHERE = "SELECT COUNT(gemTemplate) FROM GEMTemplate gemTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMTemplatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"templateId", "templateName", "publishId", "regionId",
				"templateType", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static GEMTemplate _nullGEMTemplate = new GEMTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMTemplate> toCacheModel() {
				return _nullGEMTemplateCacheModel;
			}
		};

	private static CacheModel<GEMTemplate> _nullGEMTemplateCacheModel = new CacheModel<GEMTemplate>() {
			@Override
			public GEMTemplate toEntityModel() {
				return _nullGEMTemplate;
			}
		};
}