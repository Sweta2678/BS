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

import com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException;
import com.ihg.brandstandards.db.model.GlossaryRegionNav;
import com.ihg.brandstandards.db.model.impl.GlossaryRegionNavImpl;
import com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl;

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
 * The persistence implementation for the glossary region nav service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryRegionNavPersistence
 * @see GlossaryRegionNavUtil
 * @generated
 */
public class GlossaryRegionNavPersistenceImpl extends BasePersistenceImpl<GlossaryRegionNav>
	implements GlossaryRegionNavPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GlossaryRegionNavUtil} to access the glossary region nav persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GlossaryRegionNavImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByglossaryIdAndRegionId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByglossaryIdAndRegionId",
			new String[] { Long.class.getName(), Long.class.getName() },
			GlossaryRegionNavModelImpl.GLOSSARYID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.REGIONID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.NAVITEMTEXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYIDANDREGIONID = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByglossaryIdAndRegionId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the glossary region navs where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @return the matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryIdAndRegionId(
		long glossaryId, long regionId) throws SystemException {
		return findByglossaryIdAndRegionId(glossaryId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary region navs where glossaryId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @return the range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryIdAndRegionId(
		long glossaryId, long regionId, int start, int end)
		throws SystemException {
		return findByglossaryIdAndRegionId(glossaryId, regionId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the glossary region navs where glossaryId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryIdAndRegionId(
		long glossaryId, long regionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID;
			finderArgs = new Object[] { glossaryId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID;
			finderArgs = new Object[] {
					glossaryId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<GlossaryRegionNav> list = (List<GlossaryRegionNav>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryRegionNav glossaryRegionNav : list) {
				if ((glossaryId != glossaryRegionNav.getGlossaryId()) ||
						(regionId != glossaryRegionNav.getRegionId())) {
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

			query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYIDANDREGIONID_GLOSSARYID_2);

			query.append(_FINDER_COLUMN_GLOSSARYIDANDREGIONID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryRegionNav>(list);
				}
				else {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
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
	 * Returns the first glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryIdAndRegionId_First(
		long glossaryId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryIdAndRegionId_First(glossaryId,
				regionId, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the first glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryIdAndRegionId_First(
		long glossaryId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<GlossaryRegionNav> list = findByglossaryIdAndRegionId(glossaryId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryIdAndRegionId_Last(long glossaryId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryIdAndRegionId_Last(glossaryId,
				regionId, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the last glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryIdAndRegionId_Last(
		long glossaryId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByglossaryIdAndRegionId(glossaryId, regionId);

		if (count == 0) {
			return null;
		}

		List<GlossaryRegionNav> list = findByglossaryIdAndRegionId(glossaryId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary region navs before and after the current glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryRgnNavId the primary key of the current glossary region nav
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav[] findByglossaryIdAndRegionId_PrevAndNext(
		long glossaryRgnNavId, long glossaryId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = findByPrimaryKey(glossaryRgnNavId);

		Session session = null;

		try {
			session = openSession();

			GlossaryRegionNav[] array = new GlossaryRegionNavImpl[3];

			array[0] = getByglossaryIdAndRegionId_PrevAndNext(session,
					glossaryRegionNav, glossaryId, regionId, orderByComparator,
					true);

			array[1] = glossaryRegionNav;

			array[2] = getByglossaryIdAndRegionId_PrevAndNext(session,
					glossaryRegionNav, glossaryId, regionId, orderByComparator,
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

	protected GlossaryRegionNav getByglossaryIdAndRegionId_PrevAndNext(
		Session session, GlossaryRegionNav glossaryRegionNav, long glossaryId,
		long regionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

		query.append(_FINDER_COLUMN_GLOSSARYIDANDREGIONID_GLOSSARYID_2);

		query.append(_FINDER_COLUMN_GLOSSARYIDANDREGIONID_REGIONID_2);

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
			query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(glossaryId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryRegionNav);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryRegionNav> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary region navs where glossaryId = &#63; and regionId = &#63; from the database.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByglossaryIdAndRegionId(long glossaryId, long regionId)
		throws SystemException {
		for (GlossaryRegionNav glossaryRegionNav : findByglossaryIdAndRegionId(
				glossaryId, regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(glossaryRegionNav);
		}
	}

	/**
	 * Returns the number of glossary region navs where glossaryId = &#63; and regionId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @return the number of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryIdAndRegionId(long glossaryId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYIDANDREGIONID;

		Object[] finderArgs = new Object[] { glossaryId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYIDANDREGIONID_GLOSSARYID_2);

			query.append(_FINDER_COLUMN_GLOSSARYIDANDREGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

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

	private static final String _FINDER_COLUMN_GLOSSARYIDANDREGIONID_GLOSSARYID_2 =
		"glossaryRegionNav.glossaryId = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYIDANDREGIONID_REGIONID_2 = "glossaryRegionNav.regionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByglossaryIdRegionIdChainCode",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			GlossaryRegionNavModelImpl.GLOSSARYID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.REGIONID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYIDREGIONIDCHAINCODE =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByglossaryIdRegionIdChainCode",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException} if it could not be found.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @return the matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, String chainCode)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryIdRegionIdChainCode(glossaryId,
				regionId, chainCode);

		if (glossaryRegionNav == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("glossaryId=");
			msg.append(glossaryId);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGlossaryRegionNavException(msg.toString());
		}

		return glossaryRegionNav;
	}

	/**
	 * Returns the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @return the matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, String chainCode)
		throws SystemException {
		return fetchByglossaryIdRegionIdChainCode(glossaryId, regionId,
			chainCode, true);
	}

	/**
	 * Returns the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, String chainCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { glossaryId, regionId, chainCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
					finderArgs, this);
		}

		if (result instanceof GlossaryRegionNav) {
			GlossaryRegionNav glossaryRegionNav = (GlossaryRegionNav)result;

			if ((glossaryId != glossaryRegionNav.getGlossaryId()) ||
					(regionId != glossaryRegionNav.getRegionId()) ||
					!Validator.equals(chainCode,
						glossaryRegionNav.getChainCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_GLOSSARYID_2);

			query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_REGIONID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				qPos.add(regionId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				List<GlossaryRegionNav> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GlossaryRegionNavPersistenceImpl.fetchByglossaryIdRegionIdChainCode(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GlossaryRegionNav glossaryRegionNav = list.get(0);

					result = glossaryRegionNav;

					cacheResult(glossaryRegionNav);

					if ((glossaryRegionNav.getGlossaryId() != glossaryId) ||
							(glossaryRegionNav.getRegionId() != regionId) ||
							(glossaryRegionNav.getChainCode() == null) ||
							!glossaryRegionNav.getChainCode().equals(chainCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
							finderArgs, glossaryRegionNav);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
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
			return (GlossaryRegionNav)result;
		}
	}

	/**
	 * Removes the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; from the database.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @return the glossary region nav that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav removeByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, String chainCode)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = findByglossaryIdRegionIdChainCode(glossaryId,
				regionId, chainCode);

		return remove(glossaryRegionNav);
	}

	/**
	 * Returns the number of glossary region navs where glossaryId = &#63; and regionId = &#63; and chainCode = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @return the number of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryIdRegionIdChainCode(long glossaryId,
		long regionId, String chainCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYIDREGIONIDCHAINCODE;

		Object[] finderArgs = new Object[] { glossaryId, regionId, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_GLOSSARYID_2);

			query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_REGIONID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				qPos.add(regionId);

				if (bindChainCode) {
					qPos.add(chainCode);
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

	private static final String _FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_GLOSSARYID_2 =
		"glossaryRegionNav.glossaryId = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_REGIONID_2 =
		"glossaryRegionNav.regionId = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_1 =
		"glossaryRegionNav.chainCode IS NULL";
	private static final String _FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_2 =
		"glossaryRegionNav.chainCode = ?";
	private static final String _FINDER_COLUMN_GLOSSARYIDREGIONIDCHAINCODE_CHAINCODE_3 =
		"(glossaryRegionNav.chainCode IS NULL OR glossaryRegionNav.chainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYREGIONID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByglossaryRegionId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYREGIONID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByglossaryRegionId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			GlossaryRegionNavModelImpl.REGIONID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.CHAINCODE_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.ACTIVEIND_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.NAVITEMTEXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYREGIONID = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByglossaryRegionId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @return the matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryRegionId(long regionId,
		String chainCode, String activeInd, String navItemText)
		throws SystemException {
		return findByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @return the range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryRegionId(long regionId,
		String chainCode, String activeInd, String navItemText, int start,
		int end) throws SystemException {
		return findByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText, start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryRegionId(long regionId,
		String chainCode, String activeInd, String navItemText, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYREGIONID;
			finderArgs = new Object[] {
					regionId, chainCode, activeInd, navItemText
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYREGIONID;
			finderArgs = new Object[] {
					regionId, chainCode, activeInd, navItemText,
					
					start, end, orderByComparator
				};
		}

		List<GlossaryRegionNav> list = (List<GlossaryRegionNav>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryRegionNav glossaryRegionNav : list) {
				if ((regionId != glossaryRegionNav.getRegionId()) ||
						!Validator.equals(chainCode,
							glossaryRegionNav.getChainCode()) ||
						!Validator.equals(activeInd,
							glossaryRegionNav.getActiveInd()) ||
						!Validator.equals(navItemText,
							glossaryRegionNav.getNavItemText())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_REGIONID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_2);
			}

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_2);
			}

			boolean bindNavItemText = false;

			if (navItemText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_1);
			}
			else if (navItemText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_3);
			}
			else {
				bindNavItemText = true;

				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindActiveInd) {
					qPos.add(activeInd);
				}

				if (bindNavItemText) {
					qPos.add(navItemText.toLowerCase());
				}

				if (!pagination) {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryRegionNav>(list);
				}
				else {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
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
	 * Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryRegionId_First(long regionId,
		String chainCode, String activeInd, String navItemText,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryRegionId_First(regionId,
				chainCode, activeInd, navItemText, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(", navItemText=");
		msg.append(navItemText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryRegionId_First(long regionId,
		String chainCode, String activeInd, String navItemText,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlossaryRegionNav> list = findByglossaryRegionId(regionId,
				chainCode, activeInd, navItemText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryRegionId_Last(long regionId,
		String chainCode, String activeInd, String navItemText,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryRegionId_Last(regionId,
				chainCode, activeInd, navItemText, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(", navItemText=");
		msg.append(navItemText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryRegionId_Last(long regionId,
		String chainCode, String activeInd, String navItemText,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByglossaryRegionId(regionId, chainCode, activeInd,
				navItemText);

		if (count == 0) {
			return null;
		}

		List<GlossaryRegionNav> list = findByglossaryRegionId(regionId,
				chainCode, activeInd, navItemText, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary region navs before and after the current glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param glossaryRgnNavId the primary key of the current glossary region nav
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav[] findByglossaryRegionId_PrevAndNext(
		long glossaryRgnNavId, long regionId, String chainCode,
		String activeInd, String navItemText,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = findByPrimaryKey(glossaryRgnNavId);

		Session session = null;

		try {
			session = openSession();

			GlossaryRegionNav[] array = new GlossaryRegionNavImpl[3];

			array[0] = getByglossaryRegionId_PrevAndNext(session,
					glossaryRegionNav, regionId, chainCode, activeInd,
					navItemText, orderByComparator, true);

			array[1] = glossaryRegionNav;

			array[2] = getByglossaryRegionId_PrevAndNext(session,
					glossaryRegionNav, regionId, chainCode, activeInd,
					navItemText, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlossaryRegionNav getByglossaryRegionId_PrevAndNext(
		Session session, GlossaryRegionNav glossaryRegionNav, long regionId,
		String chainCode, String activeInd, String navItemText,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

		query.append(_FINDER_COLUMN_GLOSSARYREGIONID_REGIONID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_2);
		}

		boolean bindActiveInd = false;

		if (activeInd == null) {
			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_1);
		}
		else if (activeInd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_3);
		}
		else {
			bindActiveInd = true;

			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_2);
		}

		boolean bindNavItemText = false;

		if (navItemText == null) {
			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_1);
		}
		else if (navItemText.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_3);
		}
		else {
			bindNavItemText = true;

			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_2);
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
			query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(regionId);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindActiveInd) {
			qPos.add(activeInd);
		}

		if (bindNavItemText) {
			qPos.add(navItemText.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryRegionNav);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryRegionNav> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByglossaryRegionId(long regionId, String chainCode,
		String activeInd, String navItemText) throws SystemException {
		for (GlossaryRegionNav glossaryRegionNav : findByglossaryRegionId(
				regionId, chainCode, activeInd, navItemText, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(glossaryRegionNav);
		}
	}

	/**
	 * Returns the number of glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param navItemText the nav item text
	 * @return the number of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryRegionId(long regionId, String chainCode,
		String activeInd, String navItemText) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYREGIONID;

		Object[] finderArgs = new Object[] {
				regionId, chainCode, activeInd, navItemText
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYREGIONID_REGIONID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_2);
			}

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_2);
			}

			boolean bindNavItemText = false;

			if (navItemText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_1);
			}
			else if (navItemText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_3);
			}
			else {
				bindNavItemText = true;

				query.append(_FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindActiveInd) {
					qPos.add(activeInd);
				}

				if (bindNavItemText) {
					qPos.add(navItemText.toLowerCase());
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

	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_REGIONID_2 = "glossaryRegionNav.regionId = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_1 = "glossaryRegionNav.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_2 = "glossaryRegionNav.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_CHAINCODE_3 = "(glossaryRegionNav.chainCode IS NULL OR glossaryRegionNav.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_1 = "glossaryRegionNav.activeInd IS NULL AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_2 = "glossaryRegionNav.activeInd = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_ACTIVEIND_3 = "(glossaryRegionNav.activeInd IS NULL OR glossaryRegionNav.activeInd = '') AND ";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_1 = "glossaryRegionNav.navItemText IS NULL";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_2 = "lower(glossaryRegionNav.navItemText) = ?";
	private static final String _FINDER_COLUMN_GLOSSARYREGIONID_NAVITEMTEXT_3 = "(glossaryRegionNav.navItemText IS NULL OR glossaryRegionNav.navItemText = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByallGlossaryRegionId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByallGlossaryRegionId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			GlossaryRegionNavModelImpl.REGIONID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.CHAINCODE_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.ACTIVEIND_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.NAVITEMTEXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLGLOSSARYREGIONID = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByallGlossaryRegionId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @return the matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByallGlossaryRegionId(long regionId,
		String chainCode, String activeInd) throws SystemException {
		return findByallGlossaryRegionId(regionId, chainCode, activeInd,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @return the range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByallGlossaryRegionId(long regionId,
		String chainCode, String activeInd, int start, int end)
		throws SystemException {
		return findByallGlossaryRegionId(regionId, chainCode, activeInd, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByallGlossaryRegionId(long regionId,
		String chainCode, String activeInd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID;
			finderArgs = new Object[] { regionId, chainCode, activeInd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID;
			finderArgs = new Object[] {
					regionId, chainCode, activeInd,
					
					start, end, orderByComparator
				};
		}

		List<GlossaryRegionNav> list = (List<GlossaryRegionNav>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryRegionNav glossaryRegionNav : list) {
				if ((regionId != glossaryRegionNav.getRegionId()) ||
						!Validator.equals(chainCode,
							glossaryRegionNav.getChainCode()) ||
						!Validator.equals(activeInd,
							glossaryRegionNav.getActiveInd())) {
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

			query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_REGIONID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_2);
			}

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindActiveInd) {
					qPos.add(activeInd);
				}

				if (!pagination) {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryRegionNav>(list);
				}
				else {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
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
	 * Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByallGlossaryRegionId_First(long regionId,
		String chainCode, String activeInd, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByallGlossaryRegionId_First(regionId,
				chainCode, activeInd, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByallGlossaryRegionId_First(long regionId,
		String chainCode, String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		List<GlossaryRegionNav> list = findByallGlossaryRegionId(regionId,
				chainCode, activeInd, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByallGlossaryRegionId_Last(long regionId,
		String chainCode, String activeInd, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByallGlossaryRegionId_Last(regionId,
				chainCode, activeInd, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByallGlossaryRegionId_Last(long regionId,
		String chainCode, String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByallGlossaryRegionId(regionId, chainCode, activeInd);

		if (count == 0) {
			return null;
		}

		List<GlossaryRegionNav> list = findByallGlossaryRegionId(regionId,
				chainCode, activeInd, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary region navs before and after the current glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param glossaryRgnNavId the primary key of the current glossary region nav
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav[] findByallGlossaryRegionId_PrevAndNext(
		long glossaryRgnNavId, long regionId, String chainCode,
		String activeInd, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = findByPrimaryKey(glossaryRgnNavId);

		Session session = null;

		try {
			session = openSession();

			GlossaryRegionNav[] array = new GlossaryRegionNavImpl[3];

			array[0] = getByallGlossaryRegionId_PrevAndNext(session,
					glossaryRegionNav, regionId, chainCode, activeInd,
					orderByComparator, true);

			array[1] = glossaryRegionNav;

			array[2] = getByallGlossaryRegionId_PrevAndNext(session,
					glossaryRegionNav, regionId, chainCode, activeInd,
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

	protected GlossaryRegionNav getByallGlossaryRegionId_PrevAndNext(
		Session session, GlossaryRegionNav glossaryRegionNav, long regionId,
		String chainCode, String activeInd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

		query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_REGIONID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_2);
		}

		boolean bindActiveInd = false;

		if (activeInd == null) {
			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_1);
		}
		else if (activeInd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_3);
		}
		else {
			bindActiveInd = true;

			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_2);
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
			query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(regionId);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindActiveInd) {
			qPos.add(activeInd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryRegionNav);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryRegionNav> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByallGlossaryRegionId(long regionId, String chainCode,
		String activeInd) throws SystemException {
		for (GlossaryRegionNav glossaryRegionNav : findByallGlossaryRegionId(
				regionId, chainCode, activeInd, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(glossaryRegionNav);
		}
	}

	/**
	 * Returns the number of glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	 *
	 * @param regionId the region ID
	 * @param chainCode the chain code
	 * @param activeInd the active ind
	 * @return the number of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByallGlossaryRegionId(long regionId, String chainCode,
		String activeInd) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLGLOSSARYREGIONID;

		Object[] finderArgs = new Object[] { regionId, chainCode, activeInd };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_REGIONID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_2);
			}

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindActiveInd) {
					qPos.add(activeInd);
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

	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_REGIONID_2 = "glossaryRegionNav.regionId = ? AND ";
	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_1 = "glossaryRegionNav.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_2 = "glossaryRegionNav.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_CHAINCODE_3 = "(glossaryRegionNav.chainCode IS NULL OR glossaryRegionNav.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_1 = "glossaryRegionNav.activeInd IS NULL";
	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_2 = "glossaryRegionNav.activeInd = ?";
	private static final String _FINDER_COLUMN_ALLGLOSSARYREGIONID_ACTIVEIND_3 = "(glossaryRegionNav.activeInd IS NULL OR glossaryRegionNav.activeInd = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByglossaryByChainCode",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByglossaryByChainCode",
			new String[] { String.class.getName(), String.class.getName() },
			GlossaryRegionNavModelImpl.CHAINCODE_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.NAVITEMTEXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYBYCHAINCODE = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByglossaryByChainCode",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the glossary region navs where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @return the matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryByChainCode(String chainCode,
		String navItemText) throws SystemException {
		return findByglossaryByChainCode(chainCode, navItemText,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary region navs where chainCode = &#63; and navItemText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @return the range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryByChainCode(String chainCode,
		String navItemText, int start, int end) throws SystemException {
		return findByglossaryByChainCode(chainCode, navItemText, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the glossary region navs where chainCode = &#63; and navItemText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryByChainCode(String chainCode,
		String navItemText, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE;
			finderArgs = new Object[] { chainCode, navItemText };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE;
			finderArgs = new Object[] {
					chainCode, navItemText,
					
					start, end, orderByComparator
				};
		}

		List<GlossaryRegionNav> list = (List<GlossaryRegionNav>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryRegionNav glossaryRegionNav : list) {
				if (!Validator.equals(chainCode,
							glossaryRegionNav.getChainCode()) ||
						!Validator.equals(navItemText,
							glossaryRegionNav.getNavItemText())) {
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

			query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_2);
			}

			boolean bindNavItemText = false;

			if (navItemText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_1);
			}
			else if (navItemText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_3);
			}
			else {
				bindNavItemText = true;

				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindNavItemText) {
					qPos.add(navItemText.toLowerCase());
				}

				if (!pagination) {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryRegionNav>(list);
				}
				else {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
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
	 * Returns the first glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryByChainCode_First(String chainCode,
		String navItemText, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryByChainCode_First(chainCode,
				navItemText, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", navItemText=");
		msg.append(navItemText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the first glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryByChainCode_First(
		String chainCode, String navItemText,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlossaryRegionNav> list = findByglossaryByChainCode(chainCode,
				navItemText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryByChainCode_Last(String chainCode,
		String navItemText, OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryByChainCode_Last(chainCode,
				navItemText, orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", navItemText=");
		msg.append(navItemText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the last glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryByChainCode_Last(String chainCode,
		String navItemText, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByglossaryByChainCode(chainCode, navItemText);

		if (count == 0) {
			return null;
		}

		List<GlossaryRegionNav> list = findByglossaryByChainCode(chainCode,
				navItemText, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary region navs before and after the current glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param glossaryRgnNavId the primary key of the current glossary region nav
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav[] findByglossaryByChainCode_PrevAndNext(
		long glossaryRgnNavId, String chainCode, String navItemText,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = findByPrimaryKey(glossaryRgnNavId);

		Session session = null;

		try {
			session = openSession();

			GlossaryRegionNav[] array = new GlossaryRegionNavImpl[3];

			array[0] = getByglossaryByChainCode_PrevAndNext(session,
					glossaryRegionNav, chainCode, navItemText,
					orderByComparator, true);

			array[1] = glossaryRegionNav;

			array[2] = getByglossaryByChainCode_PrevAndNext(session,
					glossaryRegionNav, chainCode, navItemText,
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

	protected GlossaryRegionNav getByglossaryByChainCode_PrevAndNext(
		Session session, GlossaryRegionNav glossaryRegionNav, String chainCode,
		String navItemText, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_2);
		}

		boolean bindNavItemText = false;

		if (navItemText == null) {
			query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_1);
		}
		else if (navItemText.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_3);
		}
		else {
			bindNavItemText = true;

			query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_2);
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
			query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindNavItemText) {
			qPos.add(navItemText.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryRegionNav);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryRegionNav> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary region navs where chainCode = &#63; and navItemText = &#63; from the database.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByglossaryByChainCode(String chainCode, String navItemText)
		throws SystemException {
		for (GlossaryRegionNav glossaryRegionNav : findByglossaryByChainCode(
				chainCode, navItemText, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(glossaryRegionNav);
		}
	}

	/**
	 * Returns the number of glossary region navs where chainCode = &#63; and navItemText = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param navItemText the nav item text
	 * @return the number of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryByChainCode(String chainCode, String navItemText)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYBYCHAINCODE;

		Object[] finderArgs = new Object[] { chainCode, navItemText };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GLOSSARYREGIONNAV_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_2);
			}

			boolean bindNavItemText = false;

			if (navItemText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_1);
			}
			else if (navItemText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_3);
			}
			else {
				bindNavItemText = true;

				query.append(_FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (bindNavItemText) {
					qPos.add(navItemText.toLowerCase());
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

	private static final String _FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_1 = "glossaryRegionNav.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_2 = "glossaryRegionNav.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYBYCHAINCODE_CHAINCODE_3 = "(glossaryRegionNav.chainCode IS NULL OR glossaryRegionNav.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_1 =
		"glossaryRegionNav.navItemText IS NULL";
	private static final String _FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_2 =
		"lower(glossaryRegionNav.navItemText) = ?";
	private static final String _FINDER_COLUMN_GLOSSARYBYCHAINCODE_NAVITEMTEXT_3 =
		"(glossaryRegionNav.navItemText IS NULL OR glossaryRegionNav.navItemText = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByglossaryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID =
		new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED,
			GlossaryRegionNavImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByglossaryId",
			new String[] { Long.class.getName() },
			GlossaryRegionNavModelImpl.GLOSSARYID_COLUMN_BITMASK |
			GlossaryRegionNavModelImpl.NAVITEMTEXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYID = new FinderPath(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByglossaryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the glossary region navs where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @return the matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryId(long glossaryId)
		throws SystemException {
		return findByglossaryId(glossaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary region navs where glossaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @return the range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryId(long glossaryId, int start,
		int end) throws SystemException {
		return findByglossaryId(glossaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary region navs where glossaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findByglossaryId(long glossaryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID;
			finderArgs = new Object[] { glossaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYID;
			finderArgs = new Object[] { glossaryId, start, end, orderByComparator };
		}

		List<GlossaryRegionNav> list = (List<GlossaryRegionNav>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryRegionNav glossaryRegionNav : list) {
				if ((glossaryId != glossaryRegionNav.getGlossaryId())) {
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

			query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				if (!pagination) {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryRegionNav>(list);
				}
				else {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
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
	 * Returns the first glossary region nav in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryId_First(long glossaryId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryId_First(glossaryId,
				orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the first glossary region nav in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryId_First(long glossaryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlossaryRegionNav> list = findByglossaryId(glossaryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary region nav in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByglossaryId_Last(long glossaryId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByglossaryId_Last(glossaryId,
				orderByComparator);

		if (glossaryRegionNav != null) {
			return glossaryRegionNav;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryRegionNavException(msg.toString());
	}

	/**
	 * Returns the last glossary region nav in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByglossaryId_Last(long glossaryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByglossaryId(glossaryId);

		if (count == 0) {
			return null;
		}

		List<GlossaryRegionNav> list = findByglossaryId(glossaryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary region navs before and after the current glossary region nav in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryRgnNavId the primary key of the current glossary region nav
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav[] findByglossaryId_PrevAndNext(
		long glossaryRgnNavId, long glossaryId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = findByPrimaryKey(glossaryRgnNavId);

		Session session = null;

		try {
			session = openSession();

			GlossaryRegionNav[] array = new GlossaryRegionNavImpl[3];

			array[0] = getByglossaryId_PrevAndNext(session, glossaryRegionNav,
					glossaryId, orderByComparator, true);

			array[1] = glossaryRegionNav;

			array[2] = getByglossaryId_PrevAndNext(session, glossaryRegionNav,
					glossaryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlossaryRegionNav getByglossaryId_PrevAndNext(Session session,
		GlossaryRegionNav glossaryRegionNav, long glossaryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYREGIONNAV_WHERE);

		query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

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
			query.append(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(glossaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryRegionNav);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryRegionNav> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary region navs where glossaryId = &#63; from the database.
	 *
	 * @param glossaryId the glossary ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByglossaryId(long glossaryId) throws SystemException {
		for (GlossaryRegionNav glossaryRegionNav : findByglossaryId(
				glossaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(glossaryRegionNav);
		}
	}

	/**
	 * Returns the number of glossary region navs where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @return the number of matching glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryId(long glossaryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYID;

		Object[] finderArgs = new Object[] { glossaryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOSSARYREGIONNAV_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

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

	private static final String _FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2 = "glossaryRegionNav.glossaryId = ?";

	public GlossaryRegionNavPersistenceImpl() {
		setModelClass(GlossaryRegionNav.class);
	}

	/**
	 * Caches the glossary region nav in the entity cache if it is enabled.
	 *
	 * @param glossaryRegionNav the glossary region nav
	 */
	@Override
	public void cacheResult(GlossaryRegionNav glossaryRegionNav) {
		EntityCacheUtil.putResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavImpl.class, glossaryRegionNav.getPrimaryKey(),
			glossaryRegionNav);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
			new Object[] {
				glossaryRegionNav.getGlossaryId(),
				glossaryRegionNav.getRegionId(),
				glossaryRegionNav.getChainCode()
			}, glossaryRegionNav);

		glossaryRegionNav.resetOriginalValues();
	}

	/**
	 * Caches the glossary region navs in the entity cache if it is enabled.
	 *
	 * @param glossaryRegionNavs the glossary region navs
	 */
	@Override
	public void cacheResult(List<GlossaryRegionNav> glossaryRegionNavs) {
		for (GlossaryRegionNav glossaryRegionNav : glossaryRegionNavs) {
			if (EntityCacheUtil.getResult(
						GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryRegionNavImpl.class,
						glossaryRegionNav.getPrimaryKey()) == null) {
				cacheResult(glossaryRegionNav);
			}
			else {
				glossaryRegionNav.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all glossary region navs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GlossaryRegionNavImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GlossaryRegionNavImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the glossary region nav.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GlossaryRegionNav glossaryRegionNav) {
		EntityCacheUtil.removeResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavImpl.class, glossaryRegionNav.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(glossaryRegionNav);
	}

	@Override
	public void clearCache(List<GlossaryRegionNav> glossaryRegionNavs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GlossaryRegionNav glossaryRegionNav : glossaryRegionNavs) {
			EntityCacheUtil.removeResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryRegionNavImpl.class, glossaryRegionNav.getPrimaryKey());

			clearUniqueFindersCache(glossaryRegionNav);
		}
	}

	protected void cacheUniqueFindersCache(GlossaryRegionNav glossaryRegionNav) {
		if (glossaryRegionNav.isNew()) {
			Object[] args = new Object[] {
					glossaryRegionNav.getGlossaryId(),
					glossaryRegionNav.getRegionId(),
					glossaryRegionNav.getChainCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOSSARYIDREGIONIDCHAINCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
				args, glossaryRegionNav);
		}
		else {
			GlossaryRegionNavModelImpl glossaryRegionNavModelImpl = (GlossaryRegionNavModelImpl)glossaryRegionNav;

			if ((glossaryRegionNavModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryRegionNav.getGlossaryId(),
						glossaryRegionNav.getRegionId(),
						glossaryRegionNav.getChainCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOSSARYIDREGIONIDCHAINCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
					args, glossaryRegionNav);
			}
		}
	}

	protected void clearUniqueFindersCache(GlossaryRegionNav glossaryRegionNav) {
		GlossaryRegionNavModelImpl glossaryRegionNavModelImpl = (GlossaryRegionNavModelImpl)glossaryRegionNav;

		Object[] args = new Object[] {
				glossaryRegionNav.getGlossaryId(),
				glossaryRegionNav.getRegionId(),
				glossaryRegionNav.getChainCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYIDREGIONIDCHAINCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
			args);

		if ((glossaryRegionNavModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					glossaryRegionNavModelImpl.getOriginalGlossaryId(),
					glossaryRegionNavModelImpl.getOriginalRegionId(),
					glossaryRegionNavModelImpl.getOriginalChainCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYIDREGIONIDCHAINCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYIDREGIONIDCHAINCODE,
				args);
		}
	}

	/**
	 * Creates a new glossary region nav with the primary key. Does not add the glossary region nav to the database.
	 *
	 * @param glossaryRgnNavId the primary key for the new glossary region nav
	 * @return the new glossary region nav
	 */
	@Override
	public GlossaryRegionNav create(long glossaryRgnNavId) {
		GlossaryRegionNav glossaryRegionNav = new GlossaryRegionNavImpl();

		glossaryRegionNav.setNew(true);
		glossaryRegionNav.setPrimaryKey(glossaryRgnNavId);

		return glossaryRegionNav;
	}

	/**
	 * Removes the glossary region nav with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param glossaryRgnNavId the primary key of the glossary region nav
	 * @return the glossary region nav that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav remove(long glossaryRgnNavId)
		throws NoSuchGlossaryRegionNavException, SystemException {
		return remove((Serializable)glossaryRgnNavId);
	}

	/**
	 * Removes the glossary region nav with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the glossary region nav
	 * @return the glossary region nav that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav remove(Serializable primaryKey)
		throws NoSuchGlossaryRegionNavException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GlossaryRegionNav glossaryRegionNav = (GlossaryRegionNav)session.get(GlossaryRegionNavImpl.class,
					primaryKey);

			if (glossaryRegionNav == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlossaryRegionNavException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(glossaryRegionNav);
		}
		catch (NoSuchGlossaryRegionNavException nsee) {
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
	protected GlossaryRegionNav removeImpl(GlossaryRegionNav glossaryRegionNav)
		throws SystemException {
		glossaryRegionNav = toUnwrappedModel(glossaryRegionNav);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(glossaryRegionNav)) {
				glossaryRegionNav = (GlossaryRegionNav)session.get(GlossaryRegionNavImpl.class,
						glossaryRegionNav.getPrimaryKeyObj());
			}

			if (glossaryRegionNav != null) {
				session.delete(glossaryRegionNav);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (glossaryRegionNav != null) {
			clearCache(glossaryRegionNav);
		}

		return glossaryRegionNav;
	}

	@Override
	public GlossaryRegionNav updateImpl(
		com.ihg.brandstandards.db.model.GlossaryRegionNav glossaryRegionNav)
		throws SystemException {
		glossaryRegionNav = toUnwrappedModel(glossaryRegionNav);

		boolean isNew = glossaryRegionNav.isNew();

		GlossaryRegionNavModelImpl glossaryRegionNavModelImpl = (GlossaryRegionNavModelImpl)glossaryRegionNav;

		Session session = null;

		try {
			session = openSession();

			if (glossaryRegionNav.isNew()) {
				session.save(glossaryRegionNav);

				glossaryRegionNav.setNew(false);
			}
			else {
				session.merge(glossaryRegionNav);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GlossaryRegionNavModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((glossaryRegionNavModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryRegionNavModelImpl.getOriginalGlossaryId(),
						glossaryRegionNavModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYIDANDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID,
					args);

				args = new Object[] {
						glossaryRegionNavModelImpl.getGlossaryId(),
						glossaryRegionNavModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYIDANDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYIDANDREGIONID,
					args);
			}

			if ((glossaryRegionNavModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryRegionNavModelImpl.getOriginalRegionId(),
						glossaryRegionNavModelImpl.getOriginalChainCode(),
						glossaryRegionNavModelImpl.getOriginalActiveInd(),
						glossaryRegionNavModelImpl.getOriginalNavItemText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYREGIONID,
					args);

				args = new Object[] {
						glossaryRegionNavModelImpl.getRegionId(),
						glossaryRegionNavModelImpl.getChainCode(),
						glossaryRegionNavModelImpl.getActiveInd(),
						glossaryRegionNavModelImpl.getNavItemText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYREGIONID,
					args);
			}

			if ((glossaryRegionNavModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryRegionNavModelImpl.getOriginalRegionId(),
						glossaryRegionNavModelImpl.getOriginalChainCode(),
						glossaryRegionNavModelImpl.getOriginalActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLGLOSSARYREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID,
					args);

				args = new Object[] {
						glossaryRegionNavModelImpl.getRegionId(),
						glossaryRegionNavModelImpl.getChainCode(),
						glossaryRegionNavModelImpl.getActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLGLOSSARYREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLGLOSSARYREGIONID,
					args);
			}

			if ((glossaryRegionNavModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryRegionNavModelImpl.getOriginalChainCode(),
						glossaryRegionNavModelImpl.getOriginalNavItemText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYBYCHAINCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE,
					args);

				args = new Object[] {
						glossaryRegionNavModelImpl.getChainCode(),
						glossaryRegionNavModelImpl.getNavItemText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYBYCHAINCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYBYCHAINCODE,
					args);
			}

			if ((glossaryRegionNavModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryRegionNavModelImpl.getOriginalGlossaryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID,
					args);

				args = new Object[] { glossaryRegionNavModelImpl.getGlossaryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID,
					args);
			}
		}

		EntityCacheUtil.putResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryRegionNavImpl.class, glossaryRegionNav.getPrimaryKey(),
			glossaryRegionNav);

		clearUniqueFindersCache(glossaryRegionNav);
		cacheUniqueFindersCache(glossaryRegionNav);

		return glossaryRegionNav;
	}

	protected GlossaryRegionNav toUnwrappedModel(
		GlossaryRegionNav glossaryRegionNav) {
		if (glossaryRegionNav instanceof GlossaryRegionNavImpl) {
			return glossaryRegionNav;
		}

		GlossaryRegionNavImpl glossaryRegionNavImpl = new GlossaryRegionNavImpl();

		glossaryRegionNavImpl.setNew(glossaryRegionNav.isNew());
		glossaryRegionNavImpl.setPrimaryKey(glossaryRegionNav.getPrimaryKey());

		glossaryRegionNavImpl.setGlossaryRgnNavId(glossaryRegionNav.getGlossaryRgnNavId());
		glossaryRegionNavImpl.setGlossaryId(glossaryRegionNav.getGlossaryId());
		glossaryRegionNavImpl.setRegionId(glossaryRegionNav.getRegionId());
		glossaryRegionNavImpl.setNavItemText(glossaryRegionNav.getNavItemText());
		glossaryRegionNavImpl.setActiveInd(glossaryRegionNav.getActiveInd());
		glossaryRegionNavImpl.setChainCode(glossaryRegionNav.getChainCode());
		glossaryRegionNavImpl.setCreatorId(glossaryRegionNav.getCreatorId());
		glossaryRegionNavImpl.setCreatedDate(glossaryRegionNav.getCreatedDate());
		glossaryRegionNavImpl.setUpdatedBy(glossaryRegionNav.getUpdatedBy());
		glossaryRegionNavImpl.setUpdatedDate(glossaryRegionNav.getUpdatedDate());

		return glossaryRegionNavImpl;
	}

	/**
	 * Returns the glossary region nav with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary region nav
	 * @return the glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlossaryRegionNavException, SystemException {
		GlossaryRegionNav glossaryRegionNav = fetchByPrimaryKey(primaryKey);

		if (glossaryRegionNav == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlossaryRegionNavException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return glossaryRegionNav;
	}

	/**
	 * Returns the glossary region nav with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException} if it could not be found.
	 *
	 * @param glossaryRgnNavId the primary key of the glossary region nav
	 * @return the glossary region nav
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav findByPrimaryKey(long glossaryRgnNavId)
		throws NoSuchGlossaryRegionNavException, SystemException {
		return findByPrimaryKey((Serializable)glossaryRgnNavId);
	}

	/**
	 * Returns the glossary region nav with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary region nav
	 * @return the glossary region nav, or <code>null</code> if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GlossaryRegionNav glossaryRegionNav = (GlossaryRegionNav)EntityCacheUtil.getResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryRegionNavImpl.class, primaryKey);

		if (glossaryRegionNav == _nullGlossaryRegionNav) {
			return null;
		}

		if (glossaryRegionNav == null) {
			Session session = null;

			try {
				session = openSession();

				glossaryRegionNav = (GlossaryRegionNav)session.get(GlossaryRegionNavImpl.class,
						primaryKey);

				if (glossaryRegionNav != null) {
					cacheResult(glossaryRegionNav);
				}
				else {
					EntityCacheUtil.putResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryRegionNavImpl.class, primaryKey,
						_nullGlossaryRegionNav);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GlossaryRegionNavModelImpl.ENTITY_CACHE_ENABLED,
					GlossaryRegionNavImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return glossaryRegionNav;
	}

	/**
	 * Returns the glossary region nav with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param glossaryRgnNavId the primary key of the glossary region nav
	 * @return the glossary region nav, or <code>null</code> if a glossary region nav with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryRegionNav fetchByPrimaryKey(long glossaryRgnNavId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)glossaryRgnNavId);
	}

	/**
	 * Returns all the glossary region navs.
	 *
	 * @return the glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary region navs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @return the range of glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary region navs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossary region navs
	 * @param end the upper bound of the range of glossary region navs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of glossary region navs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryRegionNav> findAll(int start, int end,
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

		List<GlossaryRegionNav> list = (List<GlossaryRegionNav>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GLOSSARYREGIONNAV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOSSARYREGIONNAV;

				if (pagination) {
					sql = sql.concat(GlossaryRegionNavModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryRegionNav>(list);
				}
				else {
					list = (List<GlossaryRegionNav>)QueryUtil.list(q,
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
	 * Removes all the glossary region navs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GlossaryRegionNav glossaryRegionNav : findAll()) {
			remove(glossaryRegionNav);
		}
	}

	/**
	 * Returns the number of glossary region navs.
	 *
	 * @return the number of glossary region navs
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

				Query q = session.createQuery(_SQL_COUNT_GLOSSARYREGIONNAV);

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
	 * Initializes the glossary region nav persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GlossaryRegionNav")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GlossaryRegionNav>> listenersList = new ArrayList<ModelListener<GlossaryRegionNav>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GlossaryRegionNav>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GlossaryRegionNavImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GLOSSARYREGIONNAV = "SELECT glossaryRegionNav FROM GlossaryRegionNav glossaryRegionNav";
	private static final String _SQL_SELECT_GLOSSARYREGIONNAV_WHERE = "SELECT glossaryRegionNav FROM GlossaryRegionNav glossaryRegionNav WHERE ";
	private static final String _SQL_COUNT_GLOSSARYREGIONNAV = "SELECT COUNT(glossaryRegionNav) FROM GlossaryRegionNav glossaryRegionNav";
	private static final String _SQL_COUNT_GLOSSARYREGIONNAV_WHERE = "SELECT COUNT(glossaryRegionNav) FROM GlossaryRegionNav glossaryRegionNav WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "glossaryRegionNav.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GlossaryRegionNav exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GlossaryRegionNav exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GlossaryRegionNavPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"glossaryRgnNavId", "glossaryId", "regionId", "navItemText",
				"activeInd", "chainCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static GlossaryRegionNav _nullGlossaryRegionNav = new GlossaryRegionNavImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GlossaryRegionNav> toCacheModel() {
				return _nullGlossaryRegionNavCacheModel;
			}
		};

	private static CacheModel<GlossaryRegionNav> _nullGlossaryRegionNavCacheModel =
		new CacheModel<GlossaryRegionNav>() {
			@Override
			public GlossaryRegionNav toEntityModel() {
				return _nullGlossaryRegionNav;
			}
		};
}