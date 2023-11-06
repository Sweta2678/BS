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

import com.ihg.brandstandards.db.NoSuchStandardsTranslateException;
import com.ihg.brandstandards.db.model.StandardsTranslate;
import com.ihg.brandstandards.db.model.impl.StandardsTranslateImpl;
import com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl;

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
 * The persistence implementation for the standards translate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsTranslatePersistence
 * @see StandardsTranslateUtil
 * @generated
 */
public class StandardsTranslatePersistenceImpl extends BasePersistenceImpl<StandardsTranslate>
	implements StandardsTranslatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsTranslateUtil} to access the standards translate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsTranslateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateModelImpl.FINDER_CACHE_ENABLED,
			StandardsTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateModelImpl.FINDER_CACHE_ENABLED,
			StandardsTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateModelImpl.FINDER_CACHE_ENABLED,
			StandardsTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateModelImpl.FINDER_CACHE_ENABLED,
			StandardsTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			StandardsTranslateModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards translates where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standards translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsTranslate> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards translates where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards translates
	 * @param end the upper bound of the range of standards translates (not inclusive)
	 * @return the range of matching standards translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsTranslate> findByStdId(long stdId, int start, int end)
		throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards translates where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards translates
	 * @param end the upper bound of the range of standards translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsTranslate> findByStdId(long stdId, int start, int end,
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

		List<StandardsTranslate> list = (List<StandardsTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsTranslate standardsTranslate : list) {
				if ((stdId != standardsTranslate.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsTranslateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsTranslate>(list);
				}
				else {
					list = (List<StandardsTranslate>)QueryUtil.list(q,
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
	 * Returns the first standards translate in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards translate
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a matching standards translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsTranslateException, SystemException {
		StandardsTranslate standardsTranslate = fetchByStdId_First(stdId,
				orderByComparator);

		if (standardsTranslate != null) {
			return standardsTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsTranslateException(msg.toString());
	}

	/**
	 * Returns the first standards translate in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards translate, or <code>null</code> if a matching standards translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsTranslate> list = findByStdId(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards translate in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards translate
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a matching standards translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsTranslateException, SystemException {
		StandardsTranslate standardsTranslate = fetchByStdId_Last(stdId,
				orderByComparator);

		if (standardsTranslate != null) {
			return standardsTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsTranslateException(msg.toString());
	}

	/**
	 * Returns the last standards translate in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards translate, or <code>null</code> if a matching standards translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsTranslate> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards translates before and after the current standards translate in the ordered set where stdId = &#63;.
	 *
	 * @param standardsTranslatePK the primary key of the current standards translate
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards translate
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate[] findByStdId_PrevAndNext(
		StandardsTranslatePK standardsTranslatePK, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsTranslateException, SystemException {
		StandardsTranslate standardsTranslate = findByPrimaryKey(standardsTranslatePK);

		Session session = null;

		try {
			session = openSession();

			StandardsTranslate[] array = new StandardsTranslateImpl[3];

			array[0] = getByStdId_PrevAndNext(session, standardsTranslate,
					stdId, orderByComparator, true);

			array[1] = standardsTranslate;

			array[2] = getByStdId_PrevAndNext(session, standardsTranslate,
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

	protected StandardsTranslate getByStdId_PrevAndNext(Session session,
		StandardsTranslate standardsTranslate, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSTRANSLATE_WHERE);

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
			query.append(StandardsTranslateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsTranslate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsTranslate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards translates where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (StandardsTranslate standardsTranslate : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsTranslate);
		}
	}

	/**
	 * Returns the number of standards translates where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standards translates
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

			query.append(_SQL_COUNT_STANDARDSTRANSLATE_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardsTranslate.id.stdId = ?";

	public StandardsTranslatePersistenceImpl() {
		setModelClass(StandardsTranslate.class);
	}

	/**
	 * Caches the standards translate in the entity cache if it is enabled.
	 *
	 * @param standardsTranslate the standards translate
	 */
	@Override
	public void cacheResult(StandardsTranslate standardsTranslate) {
		EntityCacheUtil.putResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateImpl.class, standardsTranslate.getPrimaryKey(),
			standardsTranslate);

		standardsTranslate.resetOriginalValues();
	}

	/**
	 * Caches the standards translates in the entity cache if it is enabled.
	 *
	 * @param standardsTranslates the standards translates
	 */
	@Override
	public void cacheResult(List<StandardsTranslate> standardsTranslates) {
		for (StandardsTranslate standardsTranslate : standardsTranslates) {
			if (EntityCacheUtil.getResult(
						StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
						StandardsTranslateImpl.class,
						standardsTranslate.getPrimaryKey()) == null) {
				cacheResult(standardsTranslate);
			}
			else {
				standardsTranslate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards translates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsTranslateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsTranslateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards translate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsTranslate standardsTranslate) {
		EntityCacheUtil.removeResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateImpl.class, standardsTranslate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsTranslate> standardsTranslates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsTranslate standardsTranslate : standardsTranslates) {
			EntityCacheUtil.removeResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
				StandardsTranslateImpl.class, standardsTranslate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards translate with the primary key. Does not add the standards translate to the database.
	 *
	 * @param standardsTranslatePK the primary key for the new standards translate
	 * @return the new standards translate
	 */
	@Override
	public StandardsTranslate create(StandardsTranslatePK standardsTranslatePK) {
		StandardsTranslate standardsTranslate = new StandardsTranslateImpl();

		standardsTranslate.setNew(true);
		standardsTranslate.setPrimaryKey(standardsTranslatePK);

		return standardsTranslate;
	}

	/**
	 * Removes the standards translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsTranslatePK the primary key of the standards translate
	 * @return the standards translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate remove(StandardsTranslatePK standardsTranslatePK)
		throws NoSuchStandardsTranslateException, SystemException {
		return remove((Serializable)standardsTranslatePK);
	}

	/**
	 * Removes the standards translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards translate
	 * @return the standards translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate remove(Serializable primaryKey)
		throws NoSuchStandardsTranslateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsTranslate standardsTranslate = (StandardsTranslate)session.get(StandardsTranslateImpl.class,
					primaryKey);

			if (standardsTranslate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsTranslate);
		}
		catch (NoSuchStandardsTranslateException nsee) {
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
	protected StandardsTranslate removeImpl(
		StandardsTranslate standardsTranslate) throws SystemException {
		standardsTranslate = toUnwrappedModel(standardsTranslate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsTranslate)) {
				standardsTranslate = (StandardsTranslate)session.get(StandardsTranslateImpl.class,
						standardsTranslate.getPrimaryKeyObj());
			}

			if (standardsTranslate != null) {
				session.delete(standardsTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsTranslate != null) {
			clearCache(standardsTranslate);
		}

		return standardsTranslate;
	}

	@Override
	public StandardsTranslate updateImpl(
		com.ihg.brandstandards.db.model.StandardsTranslate standardsTranslate)
		throws SystemException {
		standardsTranslate = toUnwrappedModel(standardsTranslate);

		boolean isNew = standardsTranslate.isNew();

		StandardsTranslateModelImpl standardsTranslateModelImpl = (StandardsTranslateModelImpl)standardsTranslate;

		Session session = null;

		try {
			session = openSession();

			if (standardsTranslate.isNew()) {
				session.save(standardsTranslate);

				standardsTranslate.setNew(false);
			}
			else {
				session.merge(standardsTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsTranslateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsTranslateModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { standardsTranslateModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
			StandardsTranslateImpl.class, standardsTranslate.getPrimaryKey(),
			standardsTranslate);

		return standardsTranslate;
	}

	protected StandardsTranslate toUnwrappedModel(
		StandardsTranslate standardsTranslate) {
		if (standardsTranslate instanceof StandardsTranslateImpl) {
			return standardsTranslate;
		}

		StandardsTranslateImpl standardsTranslateImpl = new StandardsTranslateImpl();

		standardsTranslateImpl.setNew(standardsTranslate.isNew());
		standardsTranslateImpl.setPrimaryKey(standardsTranslate.getPrimaryKey());

		standardsTranslateImpl.setStdId(standardsTranslate.getStdId());
		standardsTranslateImpl.setLocaleCode(standardsTranslate.getLocaleCode());
		standardsTranslateImpl.setTitle(standardsTranslate.getTitle());
		standardsTranslateImpl.setDescription(standardsTranslate.getDescription());
		standardsTranslateImpl.setNote(standardsTranslate.getNote());
		standardsTranslateImpl.setComment(standardsTranslate.getComment());
		standardsTranslateImpl.setCreatorId(standardsTranslate.getCreatorId());
		standardsTranslateImpl.setCreatedDate(standardsTranslate.getCreatedDate());
		standardsTranslateImpl.setUpdatedBy(standardsTranslate.getUpdatedBy());
		standardsTranslateImpl.setUpdatedDate(standardsTranslate.getUpdatedDate());
		standardsTranslateImpl.setIsValidTxt(standardsTranslate.getIsValidTxt());
		standardsTranslateImpl.setIsValidCntxt(standardsTranslate.getIsValidCntxt());

		return standardsTranslateImpl;
	}

	/**
	 * Returns the standards translate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards translate
	 * @return the standards translate
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsTranslateException, SystemException {
		StandardsTranslate standardsTranslate = fetchByPrimaryKey(primaryKey);

		if (standardsTranslate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsTranslate;
	}

	/**
	 * Returns the standards translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsTranslateException} if it could not be found.
	 *
	 * @param standardsTranslatePK the primary key of the standards translate
	 * @return the standards translate
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate findByPrimaryKey(
		StandardsTranslatePK standardsTranslatePK)
		throws NoSuchStandardsTranslateException, SystemException {
		return findByPrimaryKey((Serializable)standardsTranslatePK);
	}

	/**
	 * Returns the standards translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards translate
	 * @return the standards translate, or <code>null</code> if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsTranslate standardsTranslate = (StandardsTranslate)EntityCacheUtil.getResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
				StandardsTranslateImpl.class, primaryKey);

		if (standardsTranslate == _nullStandardsTranslate) {
			return null;
		}

		if (standardsTranslate == null) {
			Session session = null;

			try {
				session = openSession();

				standardsTranslate = (StandardsTranslate)session.get(StandardsTranslateImpl.class,
						primaryKey);

				if (standardsTranslate != null) {
					cacheResult(standardsTranslate);
				}
				else {
					EntityCacheUtil.putResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
						StandardsTranslateImpl.class, primaryKey,
						_nullStandardsTranslate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsTranslateModelImpl.ENTITY_CACHE_ENABLED,
					StandardsTranslateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsTranslate;
	}

	/**
	 * Returns the standards translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsTranslatePK the primary key of the standards translate
	 * @return the standards translate, or <code>null</code> if a standards translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsTranslate fetchByPrimaryKey(
		StandardsTranslatePK standardsTranslatePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsTranslatePK);
	}

	/**
	 * Returns all the standards translates.
	 *
	 * @return the standards translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsTranslate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards translates
	 * @param end the upper bound of the range of standards translates (not inclusive)
	 * @return the range of standards translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsTranslate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards translates
	 * @param end the upper bound of the range of standards translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsTranslate> findAll(int start, int end,
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

		List<StandardsTranslate> list = (List<StandardsTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSTRANSLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSTRANSLATE;

				if (pagination) {
					sql = sql.concat(StandardsTranslateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsTranslate>(list);
				}
				else {
					list = (List<StandardsTranslate>)QueryUtil.list(q,
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
	 * Removes all the standards translates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsTranslate standardsTranslate : findAll()) {
			remove(standardsTranslate);
		}
	}

	/**
	 * Returns the number of standards translates.
	 *
	 * @return the number of standards translates
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSTRANSLATE);

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
	 * Initializes the standards translate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsTranslate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsTranslate>> listenersList = new ArrayList<ModelListener<StandardsTranslate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsTranslate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsTranslateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSTRANSLATE = "SELECT standardsTranslate FROM StandardsTranslate standardsTranslate";
	private static final String _SQL_SELECT_STANDARDSTRANSLATE_WHERE = "SELECT standardsTranslate FROM StandardsTranslate standardsTranslate WHERE ";
	private static final String _SQL_COUNT_STANDARDSTRANSLATE = "SELECT COUNT(standardsTranslate) FROM StandardsTranslate standardsTranslate";
	private static final String _SQL_COUNT_STANDARDSTRANSLATE_WHERE = "SELECT COUNT(standardsTranslate) FROM StandardsTranslate standardsTranslate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsTranslate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsTranslate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsTranslate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsTranslatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "localeCode", "title", "description", "note", "comment",
				"creatorId", "createdDate", "updatedBy", "updatedDate",
				"isValidTxt", "isValidCntxt"
			});
	private static StandardsTranslate _nullStandardsTranslate = new StandardsTranslateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsTranslate> toCacheModel() {
				return _nullStandardsTranslateCacheModel;
			}
		};

	private static CacheModel<StandardsTranslate> _nullStandardsTranslateCacheModel =
		new CacheModel<StandardsTranslate>() {
			@Override
			public StandardsTranslate toEntityModel() {
				return _nullStandardsTranslate;
			}
		};
}