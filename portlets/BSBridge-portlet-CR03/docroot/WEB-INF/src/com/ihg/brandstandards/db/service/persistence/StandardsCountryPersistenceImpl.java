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

import com.ihg.brandstandards.db.NoSuchStandardsCountryException;
import com.ihg.brandstandards.db.model.StandardsCountry;
import com.ihg.brandstandards.db.model.impl.StandardsCountryImpl;
import com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl;

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
 * The persistence implementation for the standards country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryPersistence
 * @see StandardsCountryUtil
 * @generated
 */
public class StandardsCountryPersistenceImpl extends BasePersistenceImpl<StandardsCountry>
	implements StandardsCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsCountryUtil} to access the standards country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID = new FinderPath(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRegionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID =
		new FinderPath(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryModelImpl.FINDER_CACHE_ENABLED,
			StandardsCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegionId",
			new String[] { Long.class.getName() },
			StandardsCountryModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONID = new FinderPath(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards countries where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountry> findByRegionId(long regionId)
		throws SystemException {
		return findByRegionId(regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the standards countries where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of standards countries
	 * @param end the upper bound of the range of standards countries (not inclusive)
	 * @return the range of matching standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountry> findByRegionId(long regionId, int start,
		int end) throws SystemException {
		return findByRegionId(regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards countries where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of standards countries
	 * @param end the upper bound of the range of standards countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountry> findByRegionId(long regionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { regionId, start, end, orderByComparator };
		}

		List<StandardsCountry> list = (List<StandardsCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsCountry standardsCountry : list) {
				if ((regionId != standardsCountry.getRegionId())) {
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

			query.append(_SQL_SELECT_STANDARDSCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<StandardsCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountry>(list);
				}
				else {
					list = (List<StandardsCountry>)QueryUtil.list(q,
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
	 * Returns the first standards country in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a matching standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry findByRegionId_First(long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryException, SystemException {
		StandardsCountry standardsCountry = fetchByRegionId_First(regionId,
				orderByComparator);

		if (standardsCountry != null) {
			return standardsCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryException(msg.toString());
	}

	/**
	 * Returns the first standards country in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards country, or <code>null</code> if a matching standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry fetchByRegionId_First(long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsCountry> list = findByRegionId(regionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards country in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a matching standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry findByRegionId_Last(long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryException, SystemException {
		StandardsCountry standardsCountry = fetchByRegionId_Last(regionId,
				orderByComparator);

		if (standardsCountry != null) {
			return standardsCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsCountryException(msg.toString());
	}

	/**
	 * Returns the last standards country in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards country, or <code>null</code> if a matching standards country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry fetchByRegionId_Last(long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRegionId(regionId);

		if (count == 0) {
			return null;
		}

		List<StandardsCountry> list = findByRegionId(regionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards countries before and after the current standards country in the ordered set where regionId = &#63;.
	 *
	 * @param countryNameCode the primary key of the current standards country
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards country
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry[] findByRegionId_PrevAndNext(
		String countryNameCode, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsCountryException, SystemException {
		StandardsCountry standardsCountry = findByPrimaryKey(countryNameCode);

		Session session = null;

		try {
			session = openSession();

			StandardsCountry[] array = new StandardsCountryImpl[3];

			array[0] = getByRegionId_PrevAndNext(session, standardsCountry,
					regionId, orderByComparator, true);

			array[1] = standardsCountry;

			array[2] = getByRegionId_PrevAndNext(session, standardsCountry,
					regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsCountry getByRegionId_PrevAndNext(Session session,
		StandardsCountry standardsCountry, long regionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSCOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

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
			query.append(StandardsCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsCountry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards countries where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRegionId(long regionId) throws SystemException {
		for (StandardsCountry standardsCountry : findByRegionId(regionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsCountry);
		}
	}

	/**
	 * Returns the number of standards countries where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionId(long regionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONID;

		Object[] finderArgs = new Object[] { regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_REGIONID_REGIONID_2 = "standardsCountry.regionId = ?";

	public StandardsCountryPersistenceImpl() {
		setModelClass(StandardsCountry.class);
	}

	/**
	 * Caches the standards country in the entity cache if it is enabled.
	 *
	 * @param standardsCountry the standards country
	 */
	@Override
	public void cacheResult(StandardsCountry standardsCountry) {
		EntityCacheUtil.putResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImpl.class, standardsCountry.getPrimaryKey(),
			standardsCountry);

		standardsCountry.resetOriginalValues();
	}

	/**
	 * Caches the standards countries in the entity cache if it is enabled.
	 *
	 * @param standardsCountries the standards countries
	 */
	@Override
	public void cacheResult(List<StandardsCountry> standardsCountries) {
		for (StandardsCountry standardsCountry : standardsCountries) {
			if (EntityCacheUtil.getResult(
						StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryImpl.class,
						standardsCountry.getPrimaryKey()) == null) {
				cacheResult(standardsCountry);
			}
			else {
				standardsCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsCountry standardsCountry) {
		EntityCacheUtil.removeResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImpl.class, standardsCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsCountry> standardsCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsCountry standardsCountry : standardsCountries) {
			EntityCacheUtil.removeResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryImpl.class, standardsCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards country with the primary key. Does not add the standards country to the database.
	 *
	 * @param countryNameCode the primary key for the new standards country
	 * @return the new standards country
	 */
	@Override
	public StandardsCountry create(String countryNameCode) {
		StandardsCountry standardsCountry = new StandardsCountryImpl();

		standardsCountry.setNew(true);
		standardsCountry.setPrimaryKey(countryNameCode);

		return standardsCountry;
	}

	/**
	 * Removes the standards country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryNameCode the primary key of the standards country
	 * @return the standards country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry remove(String countryNameCode)
		throws NoSuchStandardsCountryException, SystemException {
		return remove((Serializable)countryNameCode);
	}

	/**
	 * Removes the standards country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards country
	 * @return the standards country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry remove(Serializable primaryKey)
		throws NoSuchStandardsCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsCountry standardsCountry = (StandardsCountry)session.get(StandardsCountryImpl.class,
					primaryKey);

			if (standardsCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsCountry);
		}
		catch (NoSuchStandardsCountryException nsee) {
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
	protected StandardsCountry removeImpl(StandardsCountry standardsCountry)
		throws SystemException {
		standardsCountry = toUnwrappedModel(standardsCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsCountry)) {
				standardsCountry = (StandardsCountry)session.get(StandardsCountryImpl.class,
						standardsCountry.getPrimaryKeyObj());
			}

			if (standardsCountry != null) {
				session.delete(standardsCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsCountry != null) {
			clearCache(standardsCountry);
		}

		return standardsCountry;
	}

	@Override
	public StandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountry standardsCountry)
		throws SystemException {
		standardsCountry = toUnwrappedModel(standardsCountry);

		boolean isNew = standardsCountry.isNew();

		StandardsCountryModelImpl standardsCountryModelImpl = (StandardsCountryModelImpl)standardsCountry;

		Session session = null;

		try {
			session = openSession();

			if (standardsCountry.isNew()) {
				session.save(standardsCountry);

				standardsCountry.setNew(false);
			}
			else {
				session.merge(standardsCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsCountryModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);

				args = new Object[] { standardsCountryModelImpl.getRegionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
			StandardsCountryImpl.class, standardsCountry.getPrimaryKey(),
			standardsCountry);

		return standardsCountry;
	}

	protected StandardsCountry toUnwrappedModel(
		StandardsCountry standardsCountry) {
		if (standardsCountry instanceof StandardsCountryImpl) {
			return standardsCountry;
		}

		StandardsCountryImpl standardsCountryImpl = new StandardsCountryImpl();

		standardsCountryImpl.setNew(standardsCountry.isNew());
		standardsCountryImpl.setPrimaryKey(standardsCountry.getPrimaryKey());

		standardsCountryImpl.setCountryNameCode(standardsCountry.getCountryNameCode());
		standardsCountryImpl.setRegionId(standardsCountry.getRegionId());
		standardsCountryImpl.setCreatorId(standardsCountry.getCreatorId());
		standardsCountryImpl.setCreatedDate(standardsCountry.getCreatedDate());
		standardsCountryImpl.setUpdatedBy(standardsCountry.getUpdatedBy());
		standardsCountryImpl.setUpdatedDate(standardsCountry.getUpdatedDate());
		standardsCountryImpl.setSubRegionId(standardsCountry.getSubRegionId());

		return standardsCountryImpl;
	}

	/**
	 * Returns the standards country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country
	 * @return the standards country
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsCountryException, SystemException {
		StandardsCountry standardsCountry = fetchByPrimaryKey(primaryKey);

		if (standardsCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsCountry;
	}

	/**
	 * Returns the standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryException} if it could not be found.
	 *
	 * @param countryNameCode the primary key of the standards country
	 * @return the standards country
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry findByPrimaryKey(String countryNameCode)
		throws NoSuchStandardsCountryException, SystemException {
		return findByPrimaryKey((Serializable)countryNameCode);
	}

	/**
	 * Returns the standards country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards country
	 * @return the standards country, or <code>null</code> if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsCountry standardsCountry = (StandardsCountry)EntityCacheUtil.getResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
				StandardsCountryImpl.class, primaryKey);

		if (standardsCountry == _nullStandardsCountry) {
			return null;
		}

		if (standardsCountry == null) {
			Session session = null;

			try {
				session = openSession();

				standardsCountry = (StandardsCountry)session.get(StandardsCountryImpl.class,
						primaryKey);

				if (standardsCountry != null) {
					cacheResult(standardsCountry);
				}
				else {
					EntityCacheUtil.putResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
						StandardsCountryImpl.class, primaryKey,
						_nullStandardsCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsCountryModelImpl.ENTITY_CACHE_ENABLED,
					StandardsCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsCountry;
	}

	/**
	 * Returns the standards country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryNameCode the primary key of the standards country
	 * @return the standards country, or <code>null</code> if a standards country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountry fetchByPrimaryKey(String countryNameCode)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)countryNameCode);
	}

	/**
	 * Returns all the standards countries.
	 *
	 * @return the standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards countries
	 * @param end the upper bound of the range of standards countries (not inclusive)
	 * @return the range of standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards countries
	 * @param end the upper bound of the range of standards countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountry> findAll(int start, int end,
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

		List<StandardsCountry> list = (List<StandardsCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCOUNTRY;

				if (pagination) {
					sql = sql.concat(StandardsCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsCountry>(list);
				}
				else {
					list = (List<StandardsCountry>)QueryUtil.list(q,
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
	 * Removes all the standards countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsCountry standardsCountry : findAll()) {
			remove(standardsCountry);
		}
	}

	/**
	 * Returns the number of standards countries.
	 *
	 * @return the number of standards countries
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCOUNTRY);

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
	 * Initializes the standards country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsCountry>> listenersList = new ArrayList<ModelListener<StandardsCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCOUNTRY = "SELECT standardsCountry FROM StandardsCountry standardsCountry";
	private static final String _SQL_SELECT_STANDARDSCOUNTRY_WHERE = "SELECT standardsCountry FROM StandardsCountry standardsCountry WHERE ";
	private static final String _SQL_COUNT_STANDARDSCOUNTRY = "SELECT COUNT(standardsCountry) FROM StandardsCountry standardsCountry";
	private static final String _SQL_COUNT_STANDARDSCOUNTRY_WHERE = "SELECT COUNT(standardsCountry) FROM StandardsCountry standardsCountry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsCountry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsCountry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"countryNameCode", "regionId", "creatorId", "createdDate",
				"updatedBy", "updatedDate", "subRegionId"
			});
	private static StandardsCountry _nullStandardsCountry = new StandardsCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsCountry> toCacheModel() {
				return _nullStandardsCountryCacheModel;
			}
		};

	private static CacheModel<StandardsCountry> _nullStandardsCountryCacheModel = new CacheModel<StandardsCountry>() {
			@Override
			public StandardsCountry toEntityModel() {
				return _nullStandardsCountry;
			}
		};
}