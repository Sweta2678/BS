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

import com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsImpl;
import com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl;

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
 * The persistence implementation for the external link standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsPersistence
 * @see ExternalLinkStandardsUtil
 * @generated
 */
public class ExternalLinkStandardsPersistenceImpl extends BasePersistenceImpl<ExternalLinkStandards>
	implements ExternalLinkStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExternalLinkStandardsUtil} to access the external link standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExternalLinkStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			ExternalLinkStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the external link standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByStdId(long stdId, int start,
		int end) throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByStdId(long stdId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((stdId != externalLinkStandards.getStdId())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByStdId_First(stdId,
				orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ExternalLinkStandards> list = findByStdId(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByStdId_Last(stdId,
				orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findByStdId_PrevAndNext(long extLinkId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getByStdId_PrevAndNext(session, externalLinkStandards,
					stdId, orderByComparator, true);

			array[1] = externalLinkStandards;

			array[2] = getByStdId_PrevAndNext(session, externalLinkStandards,
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

	protected ExternalLinkStandards getByStdId_PrevAndNext(Session session,
		ExternalLinkStandards externalLinkStandards, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching external link standardses
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

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "externalLinkStandards.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTEXTLINKID =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentExtLinkId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTEXTLINKID =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentExtLinkId",
			new String[] { Long.class.getName() },
			ExternalLinkStandardsModelImpl.PARENTEXTLINKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTEXTLINKID = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentExtLinkId", new String[] { Long.class.getName() });

	/**
	 * Returns all the external link standardses where parentExtLinkId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId) throws SystemException {
		return findByParentExtLinkId(parentExtLinkId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses where parentExtLinkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId, int start, int end) throws SystemException {
		return findByParentExtLinkId(parentExtLinkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where parentExtLinkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTEXTLINKID;
			finderArgs = new Object[] { parentExtLinkId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTEXTLINKID;
			finderArgs = new Object[] {
					parentExtLinkId,
					
					start, end, orderByComparator
				};
		}

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((parentExtLinkId != externalLinkStandards.getParentExtLinkId())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTEXTLINKID_PARENTEXTLINKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentExtLinkId);

				if (!pagination) {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where parentExtLinkId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByParentExtLinkId_First(
		long parentExtLinkId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByParentExtLinkId_First(parentExtLinkId,
				orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentExtLinkId=");
		msg.append(parentExtLinkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where parentExtLinkId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByParentExtLinkId_First(
		long parentExtLinkId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ExternalLinkStandards> list = findByParentExtLinkId(parentExtLinkId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where parentExtLinkId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByParentExtLinkId_Last(
		long parentExtLinkId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByParentExtLinkId_Last(parentExtLinkId,
				orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentExtLinkId=");
		msg.append(parentExtLinkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where parentExtLinkId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByParentExtLinkId_Last(
		long parentExtLinkId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentExtLinkId(parentExtLinkId);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findByParentExtLinkId(parentExtLinkId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param parentExtLinkId the parent ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findByParentExtLinkId_PrevAndNext(
		long extLinkId, long parentExtLinkId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getByParentExtLinkId_PrevAndNext(session,
					externalLinkStandards, parentExtLinkId, orderByComparator,
					true);

			array[1] = externalLinkStandards;

			array[2] = getByParentExtLinkId_PrevAndNext(session,
					externalLinkStandards, parentExtLinkId, orderByComparator,
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

	protected ExternalLinkStandards getByParentExtLinkId_PrevAndNext(
		Session session, ExternalLinkStandards externalLinkStandards,
		long parentExtLinkId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTEXTLINKID_PARENTEXTLINKID_2);

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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentExtLinkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where parentExtLinkId = &#63; from the database.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentExtLinkId(long parentExtLinkId)
		throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findByParentExtLinkId(
				parentExtLinkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where parentExtLinkId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @return the number of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentExtLinkId(long parentExtLinkId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTEXTLINKID;

		Object[] finderArgs = new Object[] { parentExtLinkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTEXTLINKID_PARENTEXTLINKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentExtLinkId);

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

	private static final String _FINDER_COLUMN_PARENTEXTLINKID_PARENTEXTLINKID_2 =
		"externalLinkStandards.parentExtLinkId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByparentIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByparentIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ExternalLinkStandardsModelImpl.PARENTEXTLINKID_COLUMN_BITMASK |
			ExternalLinkStandardsModelImpl.STDID_COLUMN_BITMASK |
			ExternalLinkStandardsModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentIdStdIdLocaleCd",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, String localeCode)
		throws SystemException {
		return findByparentIdStdIdLocaleCd(parentExtLinkId, stdId, localeCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, String localeCode, int start, int end)
		throws SystemException {
		return findByparentIdStdIdLocaleCd(parentExtLinkId, stdId, localeCode,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, String localeCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD;
			finderArgs = new Object[] { parentExtLinkId, stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD;
			finderArgs = new Object[] {
					parentExtLinkId, stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((parentExtLinkId != externalLinkStandards.getParentExtLinkId()) ||
						(stdId != externalLinkStandards.getStdId()) ||
						!Validator.equals(localeCode,
							externalLinkStandards.getLocaleCode())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTEXTLINKID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentExtLinkId);

				qPos.add(stdId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByparentIdStdIdLocaleCd_First(
		long parentExtLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByparentIdStdIdLocaleCd_First(parentExtLinkId,
				stdId, localeCode, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentExtLinkId=");
		msg.append(parentExtLinkId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByparentIdStdIdLocaleCd_First(
		long parentExtLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<ExternalLinkStandards> list = findByparentIdStdIdLocaleCd(parentExtLinkId,
				stdId, localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByparentIdStdIdLocaleCd_Last(
		long parentExtLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByparentIdStdIdLocaleCd_Last(parentExtLinkId,
				stdId, localeCode, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentExtLinkId=");
		msg.append(parentExtLinkId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByparentIdStdIdLocaleCd_Last(
		long parentExtLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentIdStdIdLocaleCd(parentExtLinkId, stdId,
				localeCode);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findByparentIdStdIdLocaleCd(parentExtLinkId,
				stdId, localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findByparentIdStdIdLocaleCd_PrevAndNext(
		long extLinkId, long parentExtLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getByparentIdStdIdLocaleCd_PrevAndNext(session,
					externalLinkStandards, parentExtLinkId, stdId, localeCode,
					orderByComparator, true);

			array[1] = externalLinkStandards;

			array[2] = getByparentIdStdIdLocaleCd_PrevAndNext(session,
					externalLinkStandards, parentExtLinkId, stdId, localeCode,
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

	protected ExternalLinkStandards getByparentIdStdIdLocaleCd_PrevAndNext(
		Session session, ExternalLinkStandards externalLinkStandards,
		long parentExtLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTEXTLINKID_2);

		query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2);
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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentExtLinkId);

		qPos.add(stdId);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentIdStdIdLocaleCd(long parentExtLinkId, long stdId,
		String localeCode) throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findByparentIdStdIdLocaleCd(
				parentExtLinkId, stdId, localeCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentIdStdIdLocaleCd(long parentExtLinkId, long stdId,
		String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD;

		Object[] finderArgs = new Object[] { parentExtLinkId, stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTEXTLINKID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentExtLinkId);

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

	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_PARENTEXTLINKID_2 =
		"externalLinkStandards.parentExtLinkId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_STDID_2 = "externalLinkStandards.stdId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_1 =
		"externalLinkStandards.localeCode IS NULL";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_2 =
		"externalLinkStandards.localeCode = ?";
	private static final String _FINDER_COLUMN_PARENTIDSTDIDLOCALECD_LOCALECODE_3 =
		"(externalLinkStandards.localeCode IS NULL OR externalLinkStandards.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDLOCALECD =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdIdLocaleCd",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdIdLocaleCd",
			new String[] { Long.class.getName(), String.class.getName() },
			ExternalLinkStandardsModelImpl.STDID_COLUMN_BITMASK |
			ExternalLinkStandardsModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDLOCALECD = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdIdLocaleCd",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByStdIdLocaleCd(long stdId,
		String localeCode) throws SystemException {
		return findByStdIdLocaleCd(stdId, localeCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByStdIdLocaleCd(long stdId,
		String localeCode, int start, int end) throws SystemException {
		return findByStdIdLocaleCd(stdId, localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByStdIdLocaleCd(long stdId,
		String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD;
			finderArgs = new Object[] { stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDLOCALECD;
			finderArgs = new Object[] {
					stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((stdId != externalLinkStandards.getStdId()) ||
						!Validator.equals(localeCode,
							externalLinkStandards.getLocaleCode())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
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
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByStdIdLocaleCd_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByStdIdLocaleCd_First(stdId,
				localeCode, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByStdIdLocaleCd_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<ExternalLinkStandards> list = findByStdIdLocaleCd(stdId,
				localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByStdIdLocaleCd_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByStdIdLocaleCd_Last(stdId,
				localeCode, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByStdIdLocaleCd_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStdIdLocaleCd(stdId, localeCode);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findByStdIdLocaleCd(stdId,
				localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findByStdIdLocaleCd_PrevAndNext(
		long extLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getByStdIdLocaleCd_PrevAndNext(session,
					externalLinkStandards, stdId, localeCode,
					orderByComparator, true);

			array[1] = externalLinkStandards;

			array[2] = getByStdIdLocaleCd_PrevAndNext(session,
					externalLinkStandards, stdId, localeCode,
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

	protected ExternalLinkStandards getByStdIdLocaleCd_PrevAndNext(
		Session session, ExternalLinkStandards externalLinkStandards,
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

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDIDLOCALECD_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2);
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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdIdLocaleCd(long stdId, String localeCode)
		throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findByStdIdLocaleCd(
				stdId, localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdIdLocaleCd(long stdId, String localeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDLOCALECD;

		Object[] finderArgs = new Object[] { stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDIDLOCALECD_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2);
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

	private static final String _FINDER_COLUMN_STDIDLOCALECD_STDID_2 = "externalLinkStandards.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_1 = "externalLinkStandards.localeCode IS NULL";
	private static final String _FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_2 = "externalLinkStandards.localeCode = ?";
	private static final String _FINDER_COLUMN_STDIDLOCALECD_LOCALECODE_3 = "(externalLinkStandards.localeCode IS NULL OR externalLinkStandards.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDID =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentIdStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentIdStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ExternalLinkStandardsModelImpl.PARENTEXTLINKID_COLUMN_BITMASK |
			ExternalLinkStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIDSTDID = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentIdStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId) throws SystemException {
		return findByParentIdStdId(parentExtLinkId, stdId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId, int start, int end)
		throws SystemException {
		return findByParentIdStdId(parentExtLinkId, stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID;
			finderArgs = new Object[] { parentExtLinkId, stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDSTDID;
			finderArgs = new Object[] {
					parentExtLinkId, stdId,
					
					start, end, orderByComparator
				};
		}

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((parentExtLinkId != externalLinkStandards.getParentExtLinkId()) ||
						(stdId != externalLinkStandards.getStdId())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_PARENTEXTLINKID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentExtLinkId);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByParentIdStdId_First(
		long parentExtLinkId, long stdId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByParentIdStdId_First(parentExtLinkId,
				stdId, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentExtLinkId=");
		msg.append(parentExtLinkId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByParentIdStdId_First(
		long parentExtLinkId, long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ExternalLinkStandards> list = findByParentIdStdId(parentExtLinkId,
				stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByParentIdStdId_Last(
		long parentExtLinkId, long stdId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByParentIdStdId_Last(parentExtLinkId,
				stdId, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentExtLinkId=");
		msg.append(parentExtLinkId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByParentIdStdId_Last(
		long parentExtLinkId, long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentIdStdId(parentExtLinkId, stdId);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findByParentIdStdId(parentExtLinkId,
				stdId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findByParentIdStdId_PrevAndNext(
		long extLinkId, long parentExtLinkId, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getByParentIdStdId_PrevAndNext(session,
					externalLinkStandards, parentExtLinkId, stdId,
					orderByComparator, true);

			array[1] = externalLinkStandards;

			array[2] = getByParentIdStdId_PrevAndNext(session,
					externalLinkStandards, parentExtLinkId, stdId,
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

	protected ExternalLinkStandards getByParentIdStdId_PrevAndNext(
		Session session, ExternalLinkStandards externalLinkStandards,
		long parentExtLinkId, long stdId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTIDSTDID_PARENTEXTLINKID_2);

		query.append(_FINDER_COLUMN_PARENTIDSTDID_STDID_2);

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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentExtLinkId);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; from the database.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentIdStdId(long parentExtLinkId, long stdId)
		throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findByParentIdStdId(
				parentExtLinkId, stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	 *
	 * @param parentExtLinkId the parent ext link ID
	 * @param stdId the std ID
	 * @return the number of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentIdStdId(long parentExtLinkId, long stdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIDSTDID;

		Object[] finderArgs = new Object[] { parentExtLinkId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_PARENTEXTLINKID_2);

			query.append(_FINDER_COLUMN_PARENTIDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentExtLinkId);

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

	private static final String _FINDER_COLUMN_PARENTIDSTDID_PARENTEXTLINKID_2 = "externalLinkStandards.parentExtLinkId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDSTDID_STDID_2 = "externalLinkStandards.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDPARENTS =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystdParents",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTS =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystdParents",
			new String[] { Long.class.getName() },
			ExternalLinkStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDPARENTS = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdParents",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the external link standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findBystdParents(long stdId)
		throws SystemException {
		return findBystdParents(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the external link standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findBystdParents(long stdId, int start,
		int end) throws SystemException {
		return findBystdParents(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findBystdParents(long stdId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTS;
			finderArgs = new Object[] { stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDPARENTS;
			finderArgs = new Object[] { stdId, start, end, orderByComparator };
		}

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((stdId != externalLinkStandards.getStdId())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDPARENTS_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findBystdParents_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchBystdParents_First(stdId,
				orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchBystdParents_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ExternalLinkStandards> list = findBystdParents(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findBystdParents_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchBystdParents_Last(stdId,
				orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchBystdParents_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystdParents(stdId);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findBystdParents(stdId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findBystdParents_PrevAndNext(
		long extLinkId, long stdId, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getBystdParents_PrevAndNext(session,
					externalLinkStandards, stdId, orderByComparator, true);

			array[1] = externalLinkStandards;

			array[2] = getBystdParents_PrevAndNext(session,
					externalLinkStandards, stdId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExternalLinkStandards getBystdParents_PrevAndNext(
		Session session, ExternalLinkStandards externalLinkStandards,
		long stdId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDPARENTS_STDID_2);

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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdParents(long stdId) throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findBystdParents(
				stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdParents(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDPARENTS;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDPARENTS_STDID_2);

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

	private static final String _FINDER_COLUMN_STDPARENTS_STDID_2 = "externalLinkStandards.stdId = ? AND externalLinkStandards.parentExtLinkId=externalLinkStandards.extLinkId";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDPARENTSLOCALECODE =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystdParentsLocaleCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTSLOCALECODE =
		new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBystdParentsLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() },
			ExternalLinkStandardsModelImpl.STDID_COLUMN_BITMASK |
			ExternalLinkStandardsModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDPARENTSLOCALECODE = new FinderPath(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBystdParentsLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findBystdParentsLocaleCode(long stdId,
		String localeCode) throws SystemException {
		return findBystdParentsLocaleCode(stdId, localeCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findBystdParentsLocaleCode(long stdId,
		String localeCode, int start, int end) throws SystemException {
		return findBystdParentsLocaleCode(stdId, localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findBystdParentsLocaleCode(long stdId,
		String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTSLOCALECODE;
			finderArgs = new Object[] { stdId, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDPARENTSLOCALECODE;
			finderArgs = new Object[] {
					stdId, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ExternalLinkStandards externalLinkStandards : list) {
				if ((stdId != externalLinkStandards.getStdId()) ||
						!Validator.equals(localeCode,
							externalLinkStandards.getLocaleCode())) {
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

			query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
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
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findBystdParentsLocaleCode_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchBystdParentsLocaleCode_First(stdId,
				localeCode, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchBystdParentsLocaleCode_First(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<ExternalLinkStandards> list = findBystdParentsLocaleCode(stdId,
				localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findBystdParentsLocaleCode_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchBystdParentsLocaleCode_Last(stdId,
				localeCode, orderByComparator);

		if (externalLinkStandards != null) {
			return externalLinkStandards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchBystdParentsLocaleCode_Last(long stdId,
		String localeCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBystdParentsLocaleCode(stdId, localeCode);

		if (count == 0) {
			return null;
		}

		List<ExternalLinkStandards> list = findBystdParentsLocaleCode(stdId,
				localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param extLinkId the primary key of the current external link standards
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards[] findBystdParentsLocaleCode_PrevAndNext(
		long extLinkId, long stdId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = findByPrimaryKey(extLinkId);

		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards[] array = new ExternalLinkStandardsImpl[3];

			array[0] = getBystdParentsLocaleCode_PrevAndNext(session,
					externalLinkStandards, stdId, localeCode,
					orderByComparator, true);

			array[1] = externalLinkStandards;

			array[2] = getBystdParentsLocaleCode_PrevAndNext(session,
					externalLinkStandards, stdId, localeCode,
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

	protected ExternalLinkStandards getBystdParentsLocaleCode_PrevAndNext(
		Session session, ExternalLinkStandards externalLinkStandards,
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

		query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_STDID_2);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_2);
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
			query.append(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(externalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external link standardses where stdId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdParentsLocaleCode(long stdId, String localeCode)
		throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findBystdParentsLocaleCode(
				stdId, localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses where stdId = &#63; and localeCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param localeCode the locale code
	 * @return the number of matching external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdParentsLocaleCode(long stdId, String localeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDPARENTSLOCALECODE;

		Object[] finderArgs = new Object[] { stdId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_STDID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_2);
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

	private static final String _FINDER_COLUMN_STDPARENTSLOCALECODE_STDID_2 = "externalLinkStandards.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_1 =
		"externalLinkStandards.localeCode IS NULL AND externalLinkStandards.parentExtLinkId=externalLinkStandards.extLinkId";
	private static final String _FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_2 =
		"externalLinkStandards.localeCode = ? AND externalLinkStandards.parentExtLinkId=externalLinkStandards.extLinkId";
	private static final String _FINDER_COLUMN_STDPARENTSLOCALECODE_LOCALECODE_3 =
		"(externalLinkStandards.localeCode IS NULL OR externalLinkStandards.localeCode = '') AND externalLinkStandards.parentExtLinkId=externalLinkStandards.extLinkId";

	public ExternalLinkStandardsPersistenceImpl() {
		setModelClass(ExternalLinkStandards.class);
	}

	/**
	 * Caches the external link standards in the entity cache if it is enabled.
	 *
	 * @param externalLinkStandards the external link standards
	 */
	@Override
	public void cacheResult(ExternalLinkStandards externalLinkStandards) {
		EntityCacheUtil.putResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			externalLinkStandards.getPrimaryKey(), externalLinkStandards);

		externalLinkStandards.resetOriginalValues();
	}

	/**
	 * Caches the external link standardses in the entity cache if it is enabled.
	 *
	 * @param externalLinkStandardses the external link standardses
	 */
	@Override
	public void cacheResult(List<ExternalLinkStandards> externalLinkStandardses) {
		for (ExternalLinkStandards externalLinkStandards : externalLinkStandardses) {
			if (EntityCacheUtil.getResult(
						ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ExternalLinkStandardsImpl.class,
						externalLinkStandards.getPrimaryKey()) == null) {
				cacheResult(externalLinkStandards);
			}
			else {
				externalLinkStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all external link standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExternalLinkStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExternalLinkStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the external link standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExternalLinkStandards externalLinkStandards) {
		EntityCacheUtil.removeResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			externalLinkStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExternalLinkStandards> externalLinkStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExternalLinkStandards externalLinkStandards : externalLinkStandardses) {
			EntityCacheUtil.removeResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ExternalLinkStandardsImpl.class,
				externalLinkStandards.getPrimaryKey());
		}
	}

	/**
	 * Creates a new external link standards with the primary key. Does not add the external link standards to the database.
	 *
	 * @param extLinkId the primary key for the new external link standards
	 * @return the new external link standards
	 */
	@Override
	public ExternalLinkStandards create(long extLinkId) {
		ExternalLinkStandards externalLinkStandards = new ExternalLinkStandardsImpl();

		externalLinkStandards.setNew(true);
		externalLinkStandards.setPrimaryKey(extLinkId);

		return externalLinkStandards;
	}

	/**
	 * Removes the external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param extLinkId the primary key of the external link standards
	 * @return the external link standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards remove(long extLinkId)
		throws NoSuchExternalLinkStandardsException, SystemException {
		return remove((Serializable)extLinkId);
	}

	/**
	 * Removes the external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the external link standards
	 * @return the external link standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards remove(Serializable primaryKey)
		throws NoSuchExternalLinkStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExternalLinkStandards externalLinkStandards = (ExternalLinkStandards)session.get(ExternalLinkStandardsImpl.class,
					primaryKey);

			if (externalLinkStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExternalLinkStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(externalLinkStandards);
		}
		catch (NoSuchExternalLinkStandardsException nsee) {
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
	protected ExternalLinkStandards removeImpl(
		ExternalLinkStandards externalLinkStandards) throws SystemException {
		externalLinkStandards = toUnwrappedModel(externalLinkStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(externalLinkStandards)) {
				externalLinkStandards = (ExternalLinkStandards)session.get(ExternalLinkStandardsImpl.class,
						externalLinkStandards.getPrimaryKeyObj());
			}

			if (externalLinkStandards != null) {
				session.delete(externalLinkStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (externalLinkStandards != null) {
			clearCache(externalLinkStandards);
		}

		return externalLinkStandards;
	}

	@Override
	public ExternalLinkStandards updateImpl(
		com.ihg.brandstandards.db.model.ExternalLinkStandards externalLinkStandards)
		throws SystemException {
		externalLinkStandards = toUnwrappedModel(externalLinkStandards);

		boolean isNew = externalLinkStandards.isNew();

		ExternalLinkStandardsModelImpl externalLinkStandardsModelImpl = (ExternalLinkStandardsModelImpl)externalLinkStandards;

		Session session = null;

		try {
			session = openSession();

			if (externalLinkStandards.isNew()) {
				session.save(externalLinkStandards);

				externalLinkStandards.setNew(false);
			}
			else {
				session.merge(externalLinkStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExternalLinkStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { externalLinkStandardsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTEXTLINKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalParentExtLinkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTEXTLINKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTEXTLINKID,
					args);

				args = new Object[] {
						externalLinkStandardsModelImpl.getParentExtLinkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTEXTLINKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTEXTLINKID,
					args);
			}

			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalParentExtLinkId(),
						externalLinkStandardsModelImpl.getOriginalStdId(),
						externalLinkStandardsModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD,
					args);

				args = new Object[] {
						externalLinkStandardsModelImpl.getParentExtLinkId(),
						externalLinkStandardsModelImpl.getStdId(),
						externalLinkStandardsModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDIDLOCALECD,
					args);
			}

			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalStdId(),
						externalLinkStandardsModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD,
					args);

				args = new Object[] {
						externalLinkStandardsModelImpl.getStdId(),
						externalLinkStandardsModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDLOCALECD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDLOCALECD,
					args);
			}

			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalParentExtLinkId(),
						externalLinkStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID,
					args);

				args = new Object[] {
						externalLinkStandardsModelImpl.getParentExtLinkId(),
						externalLinkStandardsModelImpl.getStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDSTDID,
					args);
			}

			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDPARENTS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTS,
					args);

				args = new Object[] { externalLinkStandardsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDPARENTS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTS,
					args);
			}

			if ((externalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTSLOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						externalLinkStandardsModelImpl.getOriginalStdId(),
						externalLinkStandardsModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDPARENTSLOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTSLOCALECODE,
					args);

				args = new Object[] {
						externalLinkStandardsModelImpl.getStdId(),
						externalLinkStandardsModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDPARENTSLOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDPARENTSLOCALECODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ExternalLinkStandardsImpl.class,
			externalLinkStandards.getPrimaryKey(), externalLinkStandards);

		return externalLinkStandards;
	}

	protected ExternalLinkStandards toUnwrappedModel(
		ExternalLinkStandards externalLinkStandards) {
		if (externalLinkStandards instanceof ExternalLinkStandardsImpl) {
			return externalLinkStandards;
		}

		ExternalLinkStandardsImpl externalLinkStandardsImpl = new ExternalLinkStandardsImpl();

		externalLinkStandardsImpl.setNew(externalLinkStandards.isNew());
		externalLinkStandardsImpl.setPrimaryKey(externalLinkStandards.getPrimaryKey());

		externalLinkStandardsImpl.setExtLinkId(externalLinkStandards.getExtLinkId());
		externalLinkStandardsImpl.setParentExtLinkId(externalLinkStandards.getParentExtLinkId());
		externalLinkStandardsImpl.setStdId(externalLinkStandards.getStdId());
		externalLinkStandardsImpl.setUrl(externalLinkStandards.getUrl());
		externalLinkStandardsImpl.setTitle(externalLinkStandards.getTitle());
		externalLinkStandardsImpl.setTranslationIndicator(externalLinkStandards.getTranslationIndicator());
		externalLinkStandardsImpl.setLocaleCode(externalLinkStandards.getLocaleCode());
		externalLinkStandardsImpl.setCreatorId(externalLinkStandards.getCreatorId());
		externalLinkStandardsImpl.setCreatedDate(externalLinkStandards.getCreatedDate());
		externalLinkStandardsImpl.setUpdatedBy(externalLinkStandards.getUpdatedBy());
		externalLinkStandardsImpl.setUpdatedDate(externalLinkStandards.getUpdatedDate());

		return externalLinkStandardsImpl;
	}

	/**
	 * Returns the external link standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the external link standards
	 * @return the external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExternalLinkStandardsException, SystemException {
		ExternalLinkStandards externalLinkStandards = fetchByPrimaryKey(primaryKey);

		if (externalLinkStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExternalLinkStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return externalLinkStandards;
	}

	/**
	 * Returns the external link standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException} if it could not be found.
	 *
	 * @param extLinkId the primary key of the external link standards
	 * @return the external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards findByPrimaryKey(long extLinkId)
		throws NoSuchExternalLinkStandardsException, SystemException {
		return findByPrimaryKey((Serializable)extLinkId);
	}

	/**
	 * Returns the external link standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the external link standards
	 * @return the external link standards, or <code>null</code> if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ExternalLinkStandards externalLinkStandards = (ExternalLinkStandards)EntityCacheUtil.getResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ExternalLinkStandardsImpl.class, primaryKey);

		if (externalLinkStandards == _nullExternalLinkStandards) {
			return null;
		}

		if (externalLinkStandards == null) {
			Session session = null;

			try {
				session = openSession();

				externalLinkStandards = (ExternalLinkStandards)session.get(ExternalLinkStandardsImpl.class,
						primaryKey);

				if (externalLinkStandards != null) {
					cacheResult(externalLinkStandards);
				}
				else {
					EntityCacheUtil.putResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ExternalLinkStandardsImpl.class, primaryKey,
						_nullExternalLinkStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
					ExternalLinkStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return externalLinkStandards;
	}

	/**
	 * Returns the external link standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param extLinkId the primary key of the external link standards
	 * @return the external link standards, or <code>null</code> if a external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExternalLinkStandards fetchByPrimaryKey(long extLinkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)extLinkId);
	}

	/**
	 * Returns all the external link standardses.
	 *
	 * @return the external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external link standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @return the range of external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the external link standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of external link standardses
	 * @param end the upper bound of the range of external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExternalLinkStandards> findAll(int start, int end,
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

		List<ExternalLinkStandards> list = (List<ExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXTERNALLINKSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTERNALLINKSTANDARDS;

				if (pagination) {
					sql = sql.concat(ExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExternalLinkStandards>(list);
				}
				else {
					list = (List<ExternalLinkStandards>)QueryUtil.list(q,
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
	 * Removes all the external link standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ExternalLinkStandards externalLinkStandards : findAll()) {
			remove(externalLinkStandards);
		}
	}

	/**
	 * Returns the number of external link standardses.
	 *
	 * @return the number of external link standardses
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

				Query q = session.createQuery(_SQL_COUNT_EXTERNALLINKSTANDARDS);

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
	 * Initializes the external link standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.ExternalLinkStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExternalLinkStandards>> listenersList = new ArrayList<ModelListener<ExternalLinkStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExternalLinkStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExternalLinkStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXTERNALLINKSTANDARDS = "SELECT externalLinkStandards FROM ExternalLinkStandards externalLinkStandards";
	private static final String _SQL_SELECT_EXTERNALLINKSTANDARDS_WHERE = "SELECT externalLinkStandards FROM ExternalLinkStandards externalLinkStandards WHERE ";
	private static final String _SQL_COUNT_EXTERNALLINKSTANDARDS = "SELECT COUNT(externalLinkStandards) FROM ExternalLinkStandards externalLinkStandards";
	private static final String _SQL_COUNT_EXTERNALLINKSTANDARDS_WHERE = "SELECT COUNT(externalLinkStandards) FROM ExternalLinkStandards externalLinkStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "externalLinkStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExternalLinkStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExternalLinkStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExternalLinkStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"extLinkId", "parentExtLinkId", "stdId", "url", "title",
				"translationIndicator", "localeCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static ExternalLinkStandards _nullExternalLinkStandards = new ExternalLinkStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExternalLinkStandards> toCacheModel() {
				return _nullExternalLinkStandardsCacheModel;
			}
		};

	private static CacheModel<ExternalLinkStandards> _nullExternalLinkStandardsCacheModel =
		new CacheModel<ExternalLinkStandards>() {
			@Override
			public ExternalLinkStandards toEntityModel() {
				return _nullExternalLinkStandards;
			}
		};
}