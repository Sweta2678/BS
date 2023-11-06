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

import com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;
import com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryImpl;
import com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl;

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
 * The persistence implementation for the external link standards country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsCountryPersistence
 * @see ExternalLinkStandardsCountryUtil
 * @generated
 */
public class ExternalLinkStandardsCountryPersistenceImpl
	extends BasePersistenceImpl<ExternalLinkStandardsCountry>
	implements ExternalLinkStandardsCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExternalLinkStandardsCountryUtil} to access the external link standards country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExternalLinkStandardsCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXTLINKID =
		new FinderPath(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByextLinkId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXTLINKID =
		new FinderPath(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByextLinkId",
			new String[] { Long.class.getName() },
			ExternalLinkStandardsCountryModelImpl.EXTLINKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXTLINKID = new FinderPath(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByextLinkId", new String[] { Long.class.getName() });

	/**
	 * Returns all the external link standards countries where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @return the matching external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandardsCountry> findByextLinkId(long extLinkId)
		throws SystemException {
		return findByextLinkId(extLinkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the external link standards countries where extLinkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extLinkId the ext link ID
	 * @param start the lower bound of the range of external link standards countries
	 * @param end the upper bound of the range of external link standards countries (not inclusive)
	 * @return the range of matching external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandardsCountry> findByextLinkId(long extLinkId,
		int start, int end) throws SystemException {
		return findByextLinkId(extLinkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standards countries where extLinkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extLinkId the ext link ID
	 * @param start the lower bound of the range of external link standards countries
	 * @param end the upper bound of the range of external link standards countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandardsCountry> findByextLinkId(long extLinkId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXTLINKID;
			finderArgs = new Object[] { extLinkId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXTLINKID;
			finderArgs = new Object[] { extLinkId, start, end, orderByComparator };
		}

		List<ExternalLinkStandardsCountry> list = (List<ExternalLinkStandardsCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandardsCountry externalLinkStandardsCountry : list) {
				if ((extLinkId != externalLinkStandardsCountry.getExtLinkId())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDSCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_EXTLINKID_EXTLINKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(extLinkId);

				if (!pagination) {
					list = (List<ExternalLinkStandardsCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandardsCountry>(list);
				}
				else {
					list = (List<ExternalLinkStandardsCountry>)QueryUtil.list(q,
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
	 * Returns the first external link standards country in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards country
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a matching external link standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry findByextLinkId_First(long extLinkId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		ExternalLinkStandardsCountry externalLinkStandardsCountry = fetchByextLinkId_First(extLinkId,
				orderByComparator);

		if (externalLinkStandardsCountry != null) {
			return externalLinkStandardsCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extLinkId=");
		msg.append(extLinkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsCountryException(msg.toString());
	}

	/**
	 * Returns the first external link standards country in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards country, or <code>null</code> if a matching external link standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry fetchByextLinkId_First(long extLinkId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ExternalLinkStandardsCountry> list = findByextLinkId(extLinkId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards country in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards country
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a matching external link standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry findByextLinkId_Last(long extLinkId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		ExternalLinkStandardsCountry externalLinkStandardsCountry = fetchByextLinkId_Last(extLinkId,
				orderByComparator);

		if (externalLinkStandardsCountry != null) {
			return externalLinkStandardsCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extLinkId=");
		msg.append(extLinkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsCountryException(msg.toString());
	}

	/**
	 * Returns the last external link standards country in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards country, or <code>null</code> if a matching external link standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry fetchByextLinkId_Last(long extLinkId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByextLinkId(extLinkId);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandardsCountry> list = findByextLinkId(extLinkId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standards countries before and after the current external link standards country in the ordered set where extLinkId = &#63;.
	 *
	 * @param externalLinkStandardsCountryPK the primary key of the current external link standards country
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards country
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry[] findByextLinkId_PrevAndNext(
		ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK,
		long extLinkId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		ExternalLinkStandardsCountry externalLinkStandardsCountry = findByPrimaryKey(externalLinkStandardsCountryPK);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandardsCountry[] array = new ExternalLinkStandardsCountryImpl[3];

			array[0] = getByextLinkId_PrevAndNext(session,
					externalLinkStandardsCountry, extLinkId, orderByComparator,
					true);

			array[1] = externalLinkStandardsCountry;

			array[2] = getByextLinkId_PrevAndNext(session,
					externalLinkStandardsCountry, extLinkId, orderByComparator,
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

	protected ExternalLinkStandardsCountry getByextLinkId_PrevAndNext(
		Session session,
		ExternalLinkStandardsCountry externalLinkStandardsCountry,
		long extLinkId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDSCOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_EXTLINKID_EXTLINKID_2);

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
			query.append(ExternalLinkStandardsCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(extLinkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandardsCountry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandardsCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standards countries where extLinkId = &#63; from the database.
	 *
	 * @param extLinkId the ext link ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByextLinkId(long extLinkId) throws SystemException {
		for (ExternalLinkStandardsCountry externalLinkStandardsCountry : findByextLinkId(
				extLinkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandardsCountry);
		}
	}

	/**
	 * Returns the number of external link standards countries where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @return the number of matching external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByextLinkId(long extLinkId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXTLINKID;

		Object[] finderArgs = new Object[] { extLinkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDSCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_EXTLINKID_EXTLINKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(extLinkId);

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

	private static final String _FINDER_COLUMN_EXTLINKID_EXTLINKID_2 = "externalLinkStandardsCountry.id.extLinkId = ?";

	public ExternalLinkStandardsCountryPersistenceImpl() {
		setModelClass(ExternalLinkStandardsCountry.class);
	}

	/**
	 * Caches the external link standards country in the entity cache if it is enabled.
	 *
	 * @param externalLinkStandardsCountry the external link standards country
	 */
	@Override
	public void cacheResult(
		ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		EntityCacheUtil.putResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			externalLinkStandardsCountry.getPrimaryKey(),
			externalLinkStandardsCountry);

		externalLinkStandardsCountry.resetOriginalValues();
	}

	/**
	 * Caches the external link standards countries in the entity cache if it is enabled.
	 *
	 * @param externalLinkStandardsCountries the external link standards countries
	 */
	@Override
	public void cacheResult(
		List<ExternalLinkStandardsCountry> externalLinkStandardsCountries) {
		for (ExternalLinkStandardsCountry externalLinkStandardsCountry : externalLinkStandardsCountries) {
			if (EntityCacheUtil.getResult(
						ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
						ExternalLinkStandardsCountryImpl.class,
						externalLinkStandardsCountry.getPrimaryKey()) == null) {
				cacheResult(externalLinkStandardsCountry);
			}
			else {
				externalLinkStandardsCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all external link standards countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExternalLinkStandardsCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExternalLinkStandardsCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the external link standards country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		EntityCacheUtil.removeResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			externalLinkStandardsCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ExternalLinkStandardsCountry> externalLinkStandardsCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExternalLinkStandardsCountry externalLinkStandardsCountry : externalLinkStandardsCountries) {
			EntityCacheUtil.removeResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
				ExternalLinkStandardsCountryImpl.class,
				externalLinkStandardsCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new external link standards country with the primary key. Does not add the external link standards country to the database.
	 *
	 * @param externalLinkStandardsCountryPK the primary key for the new external link standards country
	 * @return the new external link standards country
	 */
	@Override
	public ExternalLinkStandardsCountry create(
		ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK) {
		ExternalLinkStandardsCountry externalLinkStandardsCountry = new ExternalLinkStandardsCountryImpl();

		externalLinkStandardsCountry.setNew(true);
		externalLinkStandardsCountry.setPrimaryKey(externalLinkStandardsCountryPK);

		return externalLinkStandardsCountry;
	}

	/**
	 * Removes the external link standards country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param externalLinkStandardsCountryPK the primary key of the external link standards country
	 * @return the external link standards country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry remove(
		ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		return remove((Serializable)externalLinkStandardsCountryPK);
	}

	/**
	 * Removes the external link standards country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the external link standards country
	 * @return the external link standards country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry remove(Serializable primaryKey)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandardsCountry externalLinkStandardsCountry = (ExternalLinkStandardsCountry)session.get(ExternalLinkStandardsCountryImpl.class,
					primaryKey);

			if (externalLinkStandardsCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExternalLinkStandardsCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(externalLinkStandardsCountry);
		}
		catch (NoSuchExternalLinkStandardsCountryException nsee) {
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
	protected ExternalLinkStandardsCountry removeImpl(
		ExternalLinkStandardsCountry externalLinkStandardsCountry)
		throws SystemException {
		externalLinkStandardsCountry = toUnwrappedModel(externalLinkStandardsCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(externalLinkStandardsCountry)) {
				externalLinkStandardsCountry = (ExternalLinkStandardsCountry)session.get(ExternalLinkStandardsCountryImpl.class,
						externalLinkStandardsCountry.getPrimaryKeyObj());
			}

			if (externalLinkStandardsCountry != null) {
				session.delete(externalLinkStandardsCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (externalLinkStandardsCountry != null) {
			clearCache(externalLinkStandardsCountry);
		}

		return externalLinkStandardsCountry;
	}

	@Override
	public ExternalLinkStandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry externalLinkStandardsCountry)
		throws SystemException {
		externalLinkStandardsCountry = toUnwrappedModel(externalLinkStandardsCountry);

		boolean isNew = externalLinkStandardsCountry.isNew();

		ExternalLinkStandardsCountryModelImpl externalLinkStandardsCountryModelImpl =
			(ExternalLinkStandardsCountryModelImpl)externalLinkStandardsCountry;

		Session session = null;

		try {
			session = openSession();

			if (externalLinkStandardsCountry.isNew()) {
				session.save(externalLinkStandardsCountry);

				externalLinkStandardsCountry.setNew(false);
			}
			else {
				session.merge(externalLinkStandardsCountry);
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
				!ExternalLinkStandardsCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((externalLinkStandardsCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXTLINKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsCountryModelImpl.getOriginalExtLinkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXTLINKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXTLINKID,
					args);

				args = new Object[] {
						externalLinkStandardsCountryModelImpl.getExtLinkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXTLINKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXTLINKID,
					args);
			}
		}

		EntityCacheUtil.putResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsCountryImpl.class,
			externalLinkStandardsCountry.getPrimaryKey(),
			externalLinkStandardsCountry);

		return externalLinkStandardsCountry;
	}

	protected ExternalLinkStandardsCountry toUnwrappedModel(
		ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		if (externalLinkStandardsCountry instanceof ExternalLinkStandardsCountryImpl) {
			return externalLinkStandardsCountry;
		}

		ExternalLinkStandardsCountryImpl externalLinkStandardsCountryImpl = new ExternalLinkStandardsCountryImpl();

		externalLinkStandardsCountryImpl.setNew(externalLinkStandardsCountry.isNew());
		externalLinkStandardsCountryImpl.setPrimaryKey(externalLinkStandardsCountry.getPrimaryKey());

		externalLinkStandardsCountryImpl.setExtLinkId(externalLinkStandardsCountry.getExtLinkId());
		externalLinkStandardsCountryImpl.setCountryCode(externalLinkStandardsCountry.getCountryCode());
		externalLinkStandardsCountryImpl.setCreatorId(externalLinkStandardsCountry.getCreatorId());
		externalLinkStandardsCountryImpl.setCreatedDate(externalLinkStandardsCountry.getCreatedDate());
		externalLinkStandardsCountryImpl.setUpdatedBy(externalLinkStandardsCountry.getUpdatedBy());
		externalLinkStandardsCountryImpl.setUpdatedDate(externalLinkStandardsCountry.getUpdatedDate());

		return externalLinkStandardsCountryImpl;
	}

	/**
	 * Returns the external link standards country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the external link standards country
	 * @return the external link standards country
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		ExternalLinkStandardsCountry externalLinkStandardsCountry = fetchByPrimaryKey(primaryKey);

		if (externalLinkStandardsCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExternalLinkStandardsCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return externalLinkStandardsCountry;
	}

	/**
	 * Returns the external link standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException} if it could not be found.
	 *
	 * @param externalLinkStandardsCountryPK the primary key of the external link standards country
	 * @return the external link standards country
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry findByPrimaryKey(
		ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws NoSuchExternalLinkStandardsCountryException, SystemException {
		return findByPrimaryKey((Serializable)externalLinkStandardsCountryPK);
	}

	/**
	 * Returns the external link standards country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the external link standards country
	 * @return the external link standards country, or <code>null</code> if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ExternalLinkStandardsCountry externalLinkStandardsCountry = (ExternalLinkStandardsCountry)EntityCacheUtil.getResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
				ExternalLinkStandardsCountryImpl.class, primaryKey);

		if (externalLinkStandardsCountry == _nullExternalLinkStandardsCountry) {
			return null;
		}

		if (externalLinkStandardsCountry == null) {
			Session session = null;

			try {
				session = openSession();

				externalLinkStandardsCountry = (ExternalLinkStandardsCountry)session.get(ExternalLinkStandardsCountryImpl.class,
						primaryKey);

				if (externalLinkStandardsCountry != null) {
					cacheResult(externalLinkStandardsCountry);
				}
				else {
					EntityCacheUtil.putResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
						ExternalLinkStandardsCountryImpl.class, primaryKey,
						_nullExternalLinkStandardsCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExternalLinkStandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
					ExternalLinkStandardsCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return externalLinkStandardsCountry;
	}

	/**
	 * Returns the external link standards country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param externalLinkStandardsCountryPK the primary key of the external link standards country
	 * @return the external link standards country, or <code>null</code> if a external link standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandardsCountry fetchByPrimaryKey(
		ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)externalLinkStandardsCountryPK);
	}

	/**
	 * Returns all the external link standards countries.
	 *
	 * @return the external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandardsCountry> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standards countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external link standards countries
	 * @param end the upper bound of the range of external link standards countries (not inclusive)
	 * @return the range of external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandardsCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standards countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external link standards countries
	 * @param end the upper bound of the range of external link standards countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of external link standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandardsCountry> findAll(int start, int end,
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

		List<ExternalLinkStandardsCountry> list = (List<ExternalLinkStandardsCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXTERNALLINKSTANDARDSCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTERNALLINKSTANDARDSCOUNTRY;

				if (pagination) {
					sql = sql.concat(ExternalLinkStandardsCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExternalLinkStandardsCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandardsCountry>(list);
				}
				else {
					list = (List<ExternalLinkStandardsCountry>)QueryUtil.list(q,
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
	 * Removes all the external link standards countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ExternalLinkStandardsCountry externalLinkStandardsCountry : findAll()) {
			remove(externalLinkStandardsCountry);
		}
	}

	/**
	 * Returns the number of external link standards countries.
	 *
	 * @return the number of external link standards countries
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

				Query q = session.createQuery(_SQL_COUNT_EXTERNALLINKSTANDARDSCOUNTRY);

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
	 * Initializes the external link standards country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExternalLinkStandardsCountry>> listenersList = new ArrayList<ModelListener<ExternalLinkStandardsCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExternalLinkStandardsCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExternalLinkStandardsCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXTERNALLINKSTANDARDSCOUNTRY = "SELECT externalLinkStandardsCountry FROM ExternalLinkStandardsCountry externalLinkStandardsCountry";
	private static final String _SQL_SELECT_EXTERNALLINKSTANDARDSCOUNTRY_WHERE = "SELECT externalLinkStandardsCountry FROM ExternalLinkStandardsCountry externalLinkStandardsCountry WHERE ";
	private static final String _SQL_COUNT_EXTERNALLINKSTANDARDSCOUNTRY = "SELECT COUNT(externalLinkStandardsCountry) FROM ExternalLinkStandardsCountry externalLinkStandardsCountry";
	private static final String _SQL_COUNT_EXTERNALLINKSTANDARDSCOUNTRY_WHERE = "SELECT COUNT(externalLinkStandardsCountry) FROM ExternalLinkStandardsCountry externalLinkStandardsCountry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "externalLinkStandardsCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExternalLinkStandardsCountry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExternalLinkStandardsCountry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExternalLinkStandardsCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"extLinkId", "countryCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static ExternalLinkStandardsCountry _nullExternalLinkStandardsCountry =
		new ExternalLinkStandardsCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExternalLinkStandardsCountry> toCacheModel() {
				return _nullExternalLinkStandardsCountryCacheModel;
			}
		};

	private static CacheModel<ExternalLinkStandardsCountry> _nullExternalLinkStandardsCountryCacheModel =
		new CacheModel<ExternalLinkStandardsCountry>() {
			@Override
			public ExternalLinkStandardsCountry toEntityModel() {
				return _nullExternalLinkStandardsCountry;
			}
		};
}