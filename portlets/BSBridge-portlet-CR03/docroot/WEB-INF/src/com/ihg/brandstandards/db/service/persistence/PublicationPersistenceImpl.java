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

import com.ihg.brandstandards.db.NoSuchPublicationException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.impl.PublicationImpl;
import com.ihg.brandstandards.db.model.impl.PublicationModelImpl;

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
 * The persistence implementation for the publication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublicationPersistence
 * @see PublicationUtil
 * @generated
 */
public class PublicationPersistenceImpl extends BasePersistenceImpl<Publication>
	implements PublicationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublicationUtil} to access the publication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublicationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAINCODEANDSTATUS =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChainCodeAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEANDSTATUS =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChainCodeAndStatus",
			new String[] { String.class.getName(), String.class.getName() },
			PublicationModelImpl.CHAINCODE_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHSTATCD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAINCODEANDSTATUS = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChainCodeAndStatus",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the publications where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @return the matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByChainCodeAndStatus(String chainCode,
		String publishStatCd) throws SystemException {
		return findByChainCodeAndStatus(chainCode, publishStatCd,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publications where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @return the range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByChainCodeAndStatus(String chainCode,
		String publishStatCd, int start, int end) throws SystemException {
		return findByChainCodeAndStatus(chainCode, publishStatCd, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the publications where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByChainCodeAndStatus(String chainCode,
		String publishStatCd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEANDSTATUS;
			finderArgs = new Object[] { chainCode, publishStatCd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAINCODEANDSTATUS;
			finderArgs = new Object[] {
					chainCode, publishStatCd,
					
					start, end, orderByComparator
				};
		}

		List<Publication> list = (List<Publication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Publication publication : list) {
				if (!Validator.equals(chainCode, publication.getChainCode()) ||
						!Validator.equals(publishStatCd,
							publication.getPublishStatCd())) {
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

			query.append(_SQL_SELECT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_2);
			}

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublicationModelImpl.ORDER_BY_JPQL);
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

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
				}

				if (!pagination) {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Publication>(list);
				}
				else {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByChainCodeAndStatus_First(String chainCode,
		String publishStatCd, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByChainCodeAndStatus_First(chainCode,
				publishStatCd, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", publishStatCd=");
		msg.append(publishStatCd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the first publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByChainCodeAndStatus_First(String chainCode,
		String publishStatCd, OrderByComparator orderByComparator)
		throws SystemException {
		List<Publication> list = findByChainCodeAndStatus(chainCode,
				publishStatCd, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByChainCodeAndStatus_Last(String chainCode,
		String publishStatCd, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByChainCodeAndStatus_Last(chainCode,
				publishStatCd, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", publishStatCd=");
		msg.append(publishStatCd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the last publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByChainCodeAndStatus_Last(String chainCode,
		String publishStatCd, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByChainCodeAndStatus(chainCode, publishStatCd);

		if (count == 0) {
			return null;
		}

		List<Publication> list = findByChainCodeAndStatus(chainCode,
				publishStatCd, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param publishId the primary key of the current publication
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication[] findByChainCodeAndStatus_PrevAndNext(long publishId,
		String chainCode, String publishStatCd,
		OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = findByPrimaryKey(publishId);

		Session session = null;

		try {
			session = openSession();

			Publication[] array = new PublicationImpl[3];

			array[0] = getByChainCodeAndStatus_PrevAndNext(session,
					publication, chainCode, publishStatCd, orderByComparator,
					true);

			array[1] = publication;

			array[2] = getByChainCodeAndStatus_PrevAndNext(session,
					publication, chainCode, publishStatCd, orderByComparator,
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

	protected Publication getByChainCodeAndStatus_PrevAndNext(Session session,
		Publication publication, String chainCode, String publishStatCd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLICATION_WHERE);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_2);
		}

		boolean bindPublishStatCd = false;

		if (publishStatCd == null) {
			query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_1);
		}
		else if (publishStatCd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_3);
		}
		else {
			bindPublishStatCd = true;

			query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_2);
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
			query.append(PublicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindPublishStatCd) {
			qPos.add(publishStatCd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Publication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publications where chainCode = &#63; and publishStatCd = &#63; from the database.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByChainCodeAndStatus(String chainCode,
		String publishStatCd) throws SystemException {
		for (Publication publication : findByChainCodeAndStatus(chainCode,
				publishStatCd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publication);
		}
	}

	/**
	 * Returns the number of publications where chainCode = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishStatCd the publish stat cd
	 * @return the number of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChainCodeAndStatus(String chainCode, String publishStatCd)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHAINCODEANDSTATUS;

		Object[] finderArgs = new Object[] { chainCode, publishStatCd };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_2);
			}

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_2);
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

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
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

	private static final String _FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_1 = "publication.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_2 = "publication.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_CHAINCODEANDSTATUS_CHAINCODE_3 = "(publication.chainCode IS NULL OR publication.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_1 =
		"publication.publishStatCd IS NULL";
	private static final String _FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_2 =
		"publication.publishStatCd = ?";
	private static final String _FINDER_COLUMN_CHAINCODEANDSTATUS_PUBLISHSTATCD_3 =
		"(publication.publishStatCd IS NULL OR publication.publishStatCd = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPublishStatEnvChn",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PublicationModelImpl.PUBLISHSTATCD_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHENVNAME_COLUMN_BITMASK |
			PublicationModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHSTATENVCHN = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishStatEnvChn",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	 *
	 * @param publishStatCd the publish stat cd
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @return the matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishStatEnvChn(String publishStatCd,
		String publishEnvName, String chainCode)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishStatEnvChn(publishStatCd,
				publishEnvName, chainCode);

		if (publication == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishStatCd=");
			msg.append(publishStatCd);

			msg.append(", publishEnvName=");
			msg.append(publishEnvName);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublicationException(msg.toString());
		}

		return publication;
	}

	/**
	 * Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishStatCd the publish stat cd
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @return the matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishStatEnvChn(String publishStatCd,
		String publishEnvName, String chainCode) throws SystemException {
		return fetchByPublishStatEnvChn(publishStatCd, publishEnvName,
			chainCode, true);
	}

	/**
	 * Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishStatCd the publish stat cd
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishStatEnvChn(String publishStatCd,
		String publishEnvName, String chainCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				publishStatCd, publishEnvName, chainCode
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
					finderArgs, this);
		}

		if (result instanceof Publication) {
			Publication publication = (Publication)result;

			if (!Validator.equals(publishStatCd, publication.getPublishStatCd()) ||
					!Validator.equals(publishEnvName,
						publication.getPublishEnvName()) ||
					!Validator.equals(chainCode, publication.getChainCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PUBLICATION_WHERE);

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
				}

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				List<Publication> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublicationPersistenceImpl.fetchByPublishStatEnvChn(String, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Publication publication = list.get(0);

					result = publication;

					cacheResult(publication);

					if ((publication.getPublishStatCd() == null) ||
							!publication.getPublishStatCd().equals(publishStatCd) ||
							(publication.getPublishEnvName() == null) ||
							!publication.getPublishEnvName()
											.equals(publishEnvName) ||
							(publication.getChainCode() == null) ||
							!publication.getChainCode().equals(chainCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
							finderArgs, publication);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
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
			return (Publication)result;
		}
	}

	/**
	 * Removes the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; from the database.
	 *
	 * @param publishStatCd the publish stat cd
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @return the publication that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication removeByPublishStatEnvChn(String publishStatCd,
		String publishEnvName, String chainCode)
		throws NoSuchPublicationException, SystemException {
		Publication publication = findByPublishStatEnvChn(publishStatCd,
				publishEnvName, chainCode);

		return remove(publication);
	}

	/**
	 * Returns the number of publications where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishStatCd the publish stat cd
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @return the number of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishStatEnvChn(String publishStatCd,
		String publishEnvName, String chainCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHSTATENVCHN;

		Object[] finderArgs = new Object[] {
				publishStatCd, publishEnvName, chainCode
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PUBLICATION_WHERE);

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
				}

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

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

	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_1 =
		"publication.publishStatCd IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_2 =
		"publication.publishStatCd = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHSTATCD_3 =
		"(publication.publishStatCd IS NULL OR publication.publishStatCd = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_1 =
		"publication.publishEnvName IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_2 =
		"publication.publishEnvName = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_PUBLISHENVNAME_3 =
		"(publication.publishEnvName IS NULL OR publication.publishEnvName = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_1 = "publication.chainCode IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_2 = "publication.chainCode = ?";
	private static final String _FINDER_COLUMN_PUBLISHSTATENVCHN_CHAINCODE_3 = "(publication.chainCode IS NULL OR publication.chainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHENVCHN =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishEnvChn",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHENVCHN =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishEnvChn",
			new String[] { String.class.getName(), String.class.getName() },
			PublicationModelImpl.PUBLISHENVNAME_COLUMN_BITMASK |
			PublicationModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHENVCHN = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishEnvChn",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the publications where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @return the matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishEnvChn(String publishEnvName,
		String chainCode) throws SystemException {
		return findByPublishEnvChn(publishEnvName, chainCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publications where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @return the range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishEnvChn(String publishEnvName,
		String chainCode, int start, int end) throws SystemException {
		return findByPublishEnvChn(publishEnvName, chainCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publications where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishEnvChn(String publishEnvName,
		String chainCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHENVCHN;
			finderArgs = new Object[] { publishEnvName, chainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHENVCHN;
			finderArgs = new Object[] {
					publishEnvName, chainCode,
					
					start, end, orderByComparator
				};
		}

		List<Publication> list = (List<Publication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Publication publication : list) {
				if (!Validator.equals(publishEnvName,
							publication.getPublishEnvName()) ||
						!Validator.equals(chainCode, publication.getChainCode())) {
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

			query.append(_SQL_SELECT_PUBLICATION_WHERE);

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (!pagination) {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Publication>(list);
				}
				else {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishEnvChn_First(String publishEnvName,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishEnvChn_First(publishEnvName,
				chainCode, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishEnvName=");
		msg.append(publishEnvName);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the first publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishEnvChn_First(String publishEnvName,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<Publication> list = findByPublishEnvChn(publishEnvName, chainCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishEnvChn_Last(String publishEnvName,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishEnvChn_Last(publishEnvName,
				chainCode, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishEnvName=");
		msg.append(publishEnvName);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the last publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishEnvChn_Last(String publishEnvName,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishEnvChn(publishEnvName, chainCode);

		if (count == 0) {
			return null;
		}

		List<Publication> list = findByPublishEnvChn(publishEnvName, chainCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publications before and after the current publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishId the primary key of the current publication
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication[] findByPublishEnvChn_PrevAndNext(long publishId,
		String publishEnvName, String chainCode,
		OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = findByPrimaryKey(publishId);

		Session session = null;

		try {
			session = openSession();

			Publication[] array = new PublicationImpl[3];

			array[0] = getByPublishEnvChn_PrevAndNext(session, publication,
					publishEnvName, chainCode, orderByComparator, true);

			array[1] = publication;

			array[2] = getByPublishEnvChn_PrevAndNext(session, publication,
					publishEnvName, chainCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Publication getByPublishEnvChn_PrevAndNext(Session session,
		Publication publication, String publishEnvName, String chainCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLICATION_WHERE);

		boolean bindPublishEnvName = false;

		if (publishEnvName == null) {
			query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_1);
		}
		else if (publishEnvName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_3);
		}
		else {
			bindPublishEnvName = true;

			query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_2);
		}

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_2);
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
			query.append(PublicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPublishEnvName) {
			qPos.add(publishEnvName);
		}

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Publication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publications where publishEnvName = &#63; and chainCode = &#63; from the database.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishEnvChn(String publishEnvName, String chainCode)
		throws SystemException {
		for (Publication publication : findByPublishEnvChn(publishEnvName,
				chainCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publication);
		}
	}

	/**
	 * Returns the number of publications where publishEnvName = &#63; and chainCode = &#63;.
	 *
	 * @param publishEnvName the publish env name
	 * @param chainCode the chain code
	 * @return the number of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishEnvChn(String publishEnvName, String chainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHENVCHN;

		Object[] finderArgs = new Object[] { publishEnvName, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLICATION_WHERE);

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

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

	private static final String _FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_1 = "publication.publishEnvName IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_2 = "publication.publishEnvName = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHENVCHN_PUBLISHENVNAME_3 = "(publication.publishEnvName IS NULL OR publication.publishEnvName = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_1 = "publication.chainCode IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_2 = "publication.chainCode = ?";
	private static final String _FINDER_COLUMN_PUBLISHENVCHN_CHAINCODE_3 = "(publication.chainCode IS NULL OR publication.chainCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHOBJECT = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPublishObject",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PublicationModelImpl.CHAINCODE_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHENVNAME_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHSTATCD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHOBJECT = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishObject",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @return the matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishObject(String chainCode,
		String publishEnvName, String publishStatCd)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishObject(chainCode,
				publishEnvName, publishStatCd);

		if (publication == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chainCode=");
			msg.append(chainCode);

			msg.append(", publishEnvName=");
			msg.append(publishEnvName);

			msg.append(", publishStatCd=");
			msg.append(publishStatCd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublicationException(msg.toString());
		}

		return publication;
	}

	/**
	 * Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @return the matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishObject(String chainCode,
		String publishEnvName, String publishStatCd) throws SystemException {
		return fetchByPublishObject(chainCode, publishEnvName, publishStatCd,
			true);
	}

	/**
	 * Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishObject(String chainCode,
		String publishEnvName, String publishStatCd, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				chainCode, publishEnvName, publishStatCd
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
					finderArgs, this);
		}

		if (result instanceof Publication) {
			Publication publication = (Publication)result;

			if (!Validator.equals(chainCode, publication.getChainCode()) ||
					!Validator.equals(publishEnvName,
						publication.getPublishEnvName()) ||
					!Validator.equals(publishStatCd,
						publication.getPublishStatCd())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_2);
			}

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_2);
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

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
				}

				List<Publication> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublicationPersistenceImpl.fetchByPublishObject(String, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Publication publication = list.get(0);

					result = publication;

					cacheResult(publication);

					if ((publication.getChainCode() == null) ||
							!publication.getChainCode().equals(chainCode) ||
							(publication.getPublishEnvName() == null) ||
							!publication.getPublishEnvName()
											.equals(publishEnvName) ||
							(publication.getPublishStatCd() == null) ||
							!publication.getPublishStatCd().equals(publishStatCd)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
							finderArgs, publication);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
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
			return (Publication)result;
		}
	}

	/**
	 * Removes the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; from the database.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @return the publication that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication removeByPublishObject(String chainCode,
		String publishEnvName, String publishStatCd)
		throws NoSuchPublicationException, SystemException {
		Publication publication = findByPublishObject(chainCode,
				publishEnvName, publishStatCd);

		return remove(publication);
	}

	/**
	 * Returns the number of publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @return the number of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishObject(String chainCode, String publishEnvName,
		String publishStatCd) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHOBJECT;

		Object[] finderArgs = new Object[] {
				chainCode, publishEnvName, publishStatCd
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_2);
			}

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_2);
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

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
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

	private static final String _FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_1 = "publication.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_2 = "publication.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_CHAINCODE_3 = "(publication.chainCode IS NULL OR publication.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_1 = "publication.publishEnvName IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_2 = "publication.publishEnvName = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_PUBLISHENVNAME_3 = "(publication.publishEnvName IS NULL OR publication.publishEnvName = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_1 = "publication.publishStatCd IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_2 = "publication.publishStatCd = ?";
	private static final String _FINDER_COLUMN_PUBLISHOBJECT_PUBLISHSTATCD_3 = "(publication.publishStatCd IS NULL OR publication.publishStatCd = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHHISTORY =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishHistory",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHHISTORY =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishHistory",
			new String[] { String.class.getName(), String.class.getName() },
			PublicationModelImpl.CHAINCODE_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHENVNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHHISTORY = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishHistory",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the publications where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @return the matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishHistory(String chainCode,
		String publishEnvName) throws SystemException {
		return findByPublishHistory(chainCode, publishEnvName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publications where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @return the range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishHistory(String chainCode,
		String publishEnvName, int start, int end) throws SystemException {
		return findByPublishHistory(chainCode, publishEnvName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publications where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishHistory(String chainCode,
		String publishEnvName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHHISTORY;
			finderArgs = new Object[] { chainCode, publishEnvName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHHISTORY;
			finderArgs = new Object[] {
					chainCode, publishEnvName,
					
					start, end, orderByComparator
				};
		}

		List<Publication> list = (List<Publication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Publication publication : list) {
				if (!Validator.equals(chainCode, publication.getChainCode()) ||
						!Validator.equals(publishEnvName,
							publication.getPublishEnvName())) {
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

			query.append(_SQL_SELECT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublicationModelImpl.ORDER_BY_JPQL);
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

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (!pagination) {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Publication>(list);
				}
				else {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishHistory_First(String chainCode,
		String publishEnvName, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishHistory_First(chainCode,
				publishEnvName, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", publishEnvName=");
		msg.append(publishEnvName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishHistory_First(String chainCode,
		String publishEnvName, OrderByComparator orderByComparator)
		throws SystemException {
		List<Publication> list = findByPublishHistory(chainCode,
				publishEnvName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishHistory_Last(String chainCode,
		String publishEnvName, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishHistory_Last(chainCode,
				publishEnvName, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", publishEnvName=");
		msg.append(publishEnvName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishHistory_Last(String chainCode,
		String publishEnvName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishHistory(chainCode, publishEnvName);

		if (count == 0) {
			return null;
		}

		List<Publication> list = findByPublishHistory(chainCode,
				publishEnvName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param publishId the primary key of the current publication
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication[] findByPublishHistory_PrevAndNext(long publishId,
		String chainCode, String publishEnvName,
		OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = findByPrimaryKey(publishId);

		Session session = null;

		try {
			session = openSession();

			Publication[] array = new PublicationImpl[3];

			array[0] = getByPublishHistory_PrevAndNext(session, publication,
					chainCode, publishEnvName, orderByComparator, true);

			array[1] = publication;

			array[2] = getByPublishHistory_PrevAndNext(session, publication,
					chainCode, publishEnvName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Publication getByPublishHistory_PrevAndNext(Session session,
		Publication publication, String chainCode, String publishEnvName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLICATION_WHERE);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_2);
		}

		boolean bindPublishEnvName = false;

		if (publishEnvName == null) {
			query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_1);
		}
		else if (publishEnvName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_3);
		}
		else {
			bindPublishEnvName = true;

			query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_2);
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
			query.append(PublicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindPublishEnvName) {
			qPos.add(publishEnvName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Publication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publications where chainCode = &#63; and publishEnvName = &#63; from the database.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishHistory(String chainCode, String publishEnvName)
		throws SystemException {
		for (Publication publication : findByPublishHistory(chainCode,
				publishEnvName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publication);
		}
	}

	/**
	 * Returns the number of publications where chainCode = &#63; and publishEnvName = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @return the number of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishHistory(String chainCode, String publishEnvName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHHISTORY;

		Object[] finderArgs = new Object[] { chainCode, publishEnvName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_2);
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

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
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

	private static final String _FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_1 = "publication.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_2 = "publication.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHHISTORY_CHAINCODE_3 = "(publication.chainCode IS NULL OR publication.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_1 = "publication.publishEnvName IS NULL AND publication.publishStatCd != 'DELETE'";
	private static final String _FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_2 = "publication.publishEnvName = ? AND publication.publishStatCd != 'DELETE'";
	private static final String _FINDER_COLUMN_PUBLISHHISTORY_PUBLISHENVNAME_3 = "(publication.publishEnvName IS NULL OR publication.publishEnvName = '') AND publication.publishStatCd != 'DELETE'";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishInActiveHistory",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY =
		new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, PublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishInActiveHistory",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PublicationModelImpl.CHAINCODE_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHENVNAME_COLUMN_BITMASK |
			PublicationModelImpl.PUBLISHSTATCD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHINACTIVEHISTORY = new FinderPath(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishInActiveHistory",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @return the matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishInActiveHistory(String chainCode,
		String publishEnvName, String publishStatCd) throws SystemException {
		return findByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @return the range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishInActiveHistory(String chainCode,
		String publishEnvName, String publishStatCd, int start, int end)
		throws SystemException {
		return findByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findByPublishInActiveHistory(String chainCode,
		String publishEnvName, String publishStatCd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY;
			finderArgs = new Object[] { chainCode, publishEnvName, publishStatCd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY;
			finderArgs = new Object[] {
					chainCode, publishEnvName, publishStatCd,
					
					start, end, orderByComparator
				};
		}

		List<Publication> list = (List<Publication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Publication publication : list) {
				if (!Validator.equals(chainCode, publication.getChainCode()) ||
						!Validator.equals(publishEnvName,
							publication.getPublishEnvName()) ||
						!Validator.equals(publishStatCd,
							publication.getPublishStatCd())) {
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

			query.append(_SQL_SELECT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_2);
			}

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublicationModelImpl.ORDER_BY_JPQL);
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

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
				}

				if (!pagination) {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Publication>(list);
				}
				else {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishInActiveHistory_First(String chainCode,
		String publishEnvName, String publishStatCd,
		OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishInActiveHistory_First(chainCode,
				publishEnvName, publishStatCd, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", publishEnvName=");
		msg.append(publishEnvName);

		msg.append(", publishStatCd=");
		msg.append(publishStatCd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishInActiveHistory_First(String chainCode,
		String publishEnvName, String publishStatCd,
		OrderByComparator orderByComparator) throws SystemException {
		List<Publication> list = findByPublishInActiveHistory(chainCode,
				publishEnvName, publishStatCd, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPublishInActiveHistory_Last(String chainCode,
		String publishEnvName, String publishStatCd,
		OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPublishInActiveHistory_Last(chainCode,
				publishEnvName, publishStatCd, orderByComparator);

		if (publication != null) {
			return publication;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chainCode=");
		msg.append(chainCode);

		msg.append(", publishEnvName=");
		msg.append(publishEnvName);

		msg.append(", publishStatCd=");
		msg.append(publishStatCd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublicationException(msg.toString());
	}

	/**
	 * Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publication, or <code>null</code> if a matching publication could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPublishInActiveHistory_Last(String chainCode,
		String publishEnvName, String publishStatCd,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishInActiveHistory(chainCode, publishEnvName,
				publishStatCd);

		if (count == 0) {
			return null;
		}

		List<Publication> list = findByPublishInActiveHistory(chainCode,
				publishEnvName, publishStatCd, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param publishId the primary key of the current publication
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication[] findByPublishInActiveHistory_PrevAndNext(
		long publishId, String chainCode, String publishEnvName,
		String publishStatCd, OrderByComparator orderByComparator)
		throws NoSuchPublicationException, SystemException {
		Publication publication = findByPrimaryKey(publishId);

		Session session = null;

		try {
			session = openSession();

			Publication[] array = new PublicationImpl[3];

			array[0] = getByPublishInActiveHistory_PrevAndNext(session,
					publication, chainCode, publishEnvName, publishStatCd,
					orderByComparator, true);

			array[1] = publication;

			array[2] = getByPublishInActiveHistory_PrevAndNext(session,
					publication, chainCode, publishEnvName, publishStatCd,
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

	protected Publication getByPublishInActiveHistory_PrevAndNext(
		Session session, Publication publication, String chainCode,
		String publishEnvName, String publishStatCd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLICATION_WHERE);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_2);
		}

		boolean bindPublishEnvName = false;

		if (publishEnvName == null) {
			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_1);
		}
		else if (publishEnvName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_3);
		}
		else {
			bindPublishEnvName = true;

			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_2);
		}

		boolean bindPublishStatCd = false;

		if (publishStatCd == null) {
			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_1);
		}
		else if (publishStatCd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_3);
		}
		else {
			bindPublishStatCd = true;

			query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_2);
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
			query.append(PublicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (bindPublishEnvName) {
			qPos.add(publishEnvName);
		}

		if (bindPublishStatCd) {
			qPos.add(publishStatCd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Publication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; from the database.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishInActiveHistory(String chainCode,
		String publishEnvName, String publishStatCd) throws SystemException {
		for (Publication publication : findByPublishInActiveHistory(chainCode,
				publishEnvName, publishStatCd, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(publication);
		}
	}

	/**
	 * Returns the number of publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	 *
	 * @param chainCode the chain code
	 * @param publishEnvName the publish env name
	 * @param publishStatCd the publish stat cd
	 * @return the number of matching publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishInActiveHistory(String chainCode,
		String publishEnvName, String publishStatCd) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHINACTIVEHISTORY;

		Object[] finderArgs = new Object[] {
				chainCode, publishEnvName, publishStatCd
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PUBLICATION_WHERE);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_2);
			}

			boolean bindPublishEnvName = false;

			if (publishEnvName == null) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_1);
			}
			else if (publishEnvName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_3);
			}
			else {
				bindPublishEnvName = true;

				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_2);
			}

			boolean bindPublishStatCd = false;

			if (publishStatCd == null) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_1);
			}
			else if (publishStatCd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_3);
			}
			else {
				bindPublishStatCd = true;

				query.append(_FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_2);
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

				if (bindPublishEnvName) {
					qPos.add(publishEnvName);
				}

				if (bindPublishStatCd) {
					qPos.add(publishStatCd);
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

	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_1 =
		"publication.chainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_2 =
		"publication.chainCode = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_CHAINCODE_3 =
		"(publication.chainCode IS NULL OR publication.chainCode = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_1 =
		"publication.publishEnvName IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_2 =
		"publication.publishEnvName = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHENVNAME_3 =
		"(publication.publishEnvName IS NULL OR publication.publishEnvName = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_1 =
		"publication.publishStatCd IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_2 =
		"publication.publishStatCd = ?";
	private static final String _FINDER_COLUMN_PUBLISHINACTIVEHISTORY_PUBLISHSTATCD_3 =
		"(publication.publishStatCd IS NULL OR publication.publishStatCd = '')";

	public PublicationPersistenceImpl() {
		setModelClass(Publication.class);
	}

	/**
	 * Caches the publication in the entity cache if it is enabled.
	 *
	 * @param publication the publication
	 */
	@Override
	public void cacheResult(Publication publication) {
		EntityCacheUtil.putResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationImpl.class, publication.getPrimaryKey(), publication);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
			new Object[] {
				publication.getPublishStatCd(), publication.getPublishEnvName(),
				publication.getChainCode()
			}, publication);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
			new Object[] {
				publication.getChainCode(), publication.getPublishEnvName(),
				publication.getPublishStatCd()
			}, publication);

		publication.resetOriginalValues();
	}

	/**
	 * Caches the publications in the entity cache if it is enabled.
	 *
	 * @param publications the publications
	 */
	@Override
	public void cacheResult(List<Publication> publications) {
		for (Publication publication : publications) {
			if (EntityCacheUtil.getResult(
						PublicationModelImpl.ENTITY_CACHE_ENABLED,
						PublicationImpl.class, publication.getPrimaryKey()) == null) {
				cacheResult(publication);
			}
			else {
				publication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublicationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublicationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publication.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Publication publication) {
		EntityCacheUtil.removeResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationImpl.class, publication.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publication);
	}

	@Override
	public void clearCache(List<Publication> publications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Publication publication : publications) {
			EntityCacheUtil.removeResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
				PublicationImpl.class, publication.getPrimaryKey());

			clearUniqueFindersCache(publication);
		}
	}

	protected void cacheUniqueFindersCache(Publication publication) {
		if (publication.isNew()) {
			Object[] args = new Object[] {
					publication.getPublishStatCd(),
					publication.getPublishEnvName(), publication.getChainCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHSTATENVCHN,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
				args, publication);

			args = new Object[] {
					publication.getChainCode(), publication.getPublishEnvName(),
					publication.getPublishStatCd()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHOBJECT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT, args,
				publication);
		}
		else {
			PublicationModelImpl publicationModelImpl = (PublicationModelImpl)publication;

			if ((publicationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publication.getPublishStatCd(),
						publication.getPublishEnvName(),
						publication.getChainCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHSTATENVCHN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
					args, publication);
			}

			if ((publicationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHOBJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publication.getChainCode(),
						publication.getPublishEnvName(),
						publication.getPublishStatCd()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHOBJECT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
					args, publication);
			}
		}
	}

	protected void clearUniqueFindersCache(Publication publication) {
		PublicationModelImpl publicationModelImpl = (PublicationModelImpl)publication;

		Object[] args = new Object[] {
				publication.getPublishStatCd(), publication.getPublishEnvName(),
				publication.getChainCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTATENVCHN,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
			args);

		if ((publicationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN.getColumnBitmask()) != 0) {
			args = new Object[] {
					publicationModelImpl.getOriginalPublishStatCd(),
					publicationModelImpl.getOriginalPublishEnvName(),
					publicationModelImpl.getOriginalChainCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHSTATENVCHN,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHSTATENVCHN,
				args);
		}

		args = new Object[] {
				publication.getChainCode(), publication.getPublishEnvName(),
				publication.getPublishStatCd()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHOBJECT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT, args);

		if ((publicationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHOBJECT.getColumnBitmask()) != 0) {
			args = new Object[] {
					publicationModelImpl.getOriginalChainCode(),
					publicationModelImpl.getOriginalPublishEnvName(),
					publicationModelImpl.getOriginalPublishStatCd()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHOBJECT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHOBJECT,
				args);
		}
	}

	/**
	 * Creates a new publication with the primary key. Does not add the publication to the database.
	 *
	 * @param publishId the primary key for the new publication
	 * @return the new publication
	 */
	@Override
	public Publication create(long publishId) {
		Publication publication = new PublicationImpl();

		publication.setNew(true);
		publication.setPrimaryKey(publishId);

		return publication;
	}

	/**
	 * Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishId the primary key of the publication
	 * @return the publication that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication remove(long publishId)
		throws NoSuchPublicationException, SystemException {
		return remove((Serializable)publishId);
	}

	/**
	 * Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publication
	 * @return the publication that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication remove(Serializable primaryKey)
		throws NoSuchPublicationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Publication publication = (Publication)session.get(PublicationImpl.class,
					primaryKey);

			if (publication == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publication);
		}
		catch (NoSuchPublicationException nsee) {
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
	protected Publication removeImpl(Publication publication)
		throws SystemException {
		publication = toUnwrappedModel(publication);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publication)) {
				publication = (Publication)session.get(PublicationImpl.class,
						publication.getPrimaryKeyObj());
			}

			if (publication != null) {
				session.delete(publication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publication != null) {
			clearCache(publication);
		}

		return publication;
	}

	@Override
	public Publication updateImpl(
		com.ihg.brandstandards.db.model.Publication publication)
		throws SystemException {
		publication = toUnwrappedModel(publication);

		boolean isNew = publication.isNew();

		PublicationModelImpl publicationModelImpl = (PublicationModelImpl)publication;

		Session session = null;

		try {
			session = openSession();

			if (publication.isNew()) {
				session.save(publication);

				publication.setNew(false);
			}
			else {
				session.merge(publication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublicationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publicationModelImpl.getOriginalChainCode(),
						publicationModelImpl.getOriginalPublishStatCd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEANDSTATUS,
					args);

				args = new Object[] {
						publicationModelImpl.getChainCode(),
						publicationModelImpl.getPublishStatCd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAINCODEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAINCODEANDSTATUS,
					args);
			}

			if ((publicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHENVCHN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publicationModelImpl.getOriginalPublishEnvName(),
						publicationModelImpl.getOriginalChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHENVCHN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHENVCHN,
					args);

				args = new Object[] {
						publicationModelImpl.getPublishEnvName(),
						publicationModelImpl.getChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHENVCHN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHENVCHN,
					args);
			}

			if ((publicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHHISTORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publicationModelImpl.getOriginalChainCode(),
						publicationModelImpl.getOriginalPublishEnvName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHHISTORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHHISTORY,
					args);

				args = new Object[] {
						publicationModelImpl.getChainCode(),
						publicationModelImpl.getPublishEnvName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHHISTORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHHISTORY,
					args);
			}

			if ((publicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publicationModelImpl.getOriginalChainCode(),
						publicationModelImpl.getOriginalPublishEnvName(),
						publicationModelImpl.getOriginalPublishStatCd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHINACTIVEHISTORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY,
					args);

				args = new Object[] {
						publicationModelImpl.getChainCode(),
						publicationModelImpl.getPublishEnvName(),
						publicationModelImpl.getPublishStatCd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHINACTIVEHISTORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHINACTIVEHISTORY,
					args);
			}
		}

		EntityCacheUtil.putResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
			PublicationImpl.class, publication.getPrimaryKey(), publication);

		clearUniqueFindersCache(publication);
		cacheUniqueFindersCache(publication);

		return publication;
	}

	protected Publication toUnwrappedModel(Publication publication) {
		if (publication instanceof PublicationImpl) {
			return publication;
		}

		PublicationImpl publicationImpl = new PublicationImpl();

		publicationImpl.setNew(publication.isNew());
		publicationImpl.setPrimaryKey(publication.getPrimaryKey());

		publicationImpl.setPublishId(publication.getPublishId());
		publicationImpl.setPublishVerId(publication.getPublishVerId());
		publicationImpl.setPublishStatCd(publication.getPublishStatCd());
		publicationImpl.setChainCode(publication.getChainCode());
		publicationImpl.setPublishEnvName(publication.getPublishEnvName());
		publicationImpl.setPublishLocaleList(publication.getPublishLocaleList());
		publicationImpl.setPublishDate(publication.getPublishDate());
		publicationImpl.setPublishContentType(publication.getPublishContentType());
		publicationImpl.setParentPublishId(publication.getParentPublishId());
		publicationImpl.setValidateTranslation(publication.getValidateTranslation());
		publicationImpl.setCreatorId(publication.getCreatorId());
		publicationImpl.setCreatedDate(publication.getCreatedDate());
		publicationImpl.setUpdatedBy(publication.getUpdatedBy());
		publicationImpl.setUpdatedDate(publication.getUpdatedDate());

		return publicationImpl;
	}

	/**
	 * Returns the publication with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publication
	 * @return the publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublicationException, SystemException {
		Publication publication = fetchByPrimaryKey(primaryKey);

		if (publication == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publication;
	}

	/**
	 * Returns the publication with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	 *
	 * @param publishId the primary key of the publication
	 * @return the publication
	 * @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication findByPrimaryKey(long publishId)
		throws NoSuchPublicationException, SystemException {
		return findByPrimaryKey((Serializable)publishId);
	}

	/**
	 * Returns the publication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publication
	 * @return the publication, or <code>null</code> if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Publication publication = (Publication)EntityCacheUtil.getResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
				PublicationImpl.class, primaryKey);

		if (publication == _nullPublication) {
			return null;
		}

		if (publication == null) {
			Session session = null;

			try {
				session = openSession();

				publication = (Publication)session.get(PublicationImpl.class,
						primaryKey);

				if (publication != null) {
					cacheResult(publication);
				}
				else {
					EntityCacheUtil.putResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
						PublicationImpl.class, primaryKey, _nullPublication);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublicationModelImpl.ENTITY_CACHE_ENABLED,
					PublicationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publication;
	}

	/**
	 * Returns the publication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishId the primary key of the publication
	 * @return the publication, or <code>null</code> if a publication with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publication fetchByPrimaryKey(long publishId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishId);
	}

	/**
	 * Returns all the publications.
	 *
	 * @return the publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @return the range of publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publications
	 * @param end the upper bound of the range of publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publication> findAll(int start, int end,
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

		List<Publication> list = (List<Publication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLICATION;

				if (pagination) {
					sql = sql.concat(PublicationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Publication>(list);
				}
				else {
					list = (List<Publication>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the publications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Publication publication : findAll()) {
			remove(publication);
		}
	}

	/**
	 * Returns the number of publications.
	 *
	 * @return the number of publications
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

				Query q = session.createQuery(_SQL_COUNT_PUBLICATION);

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
	 * Initializes the publication persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.Publication")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Publication>> listenersList = new ArrayList<ModelListener<Publication>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Publication>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublicationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLICATION = "SELECT publication FROM Publication publication";
	private static final String _SQL_SELECT_PUBLICATION_WHERE = "SELECT publication FROM Publication publication WHERE ";
	private static final String _SQL_COUNT_PUBLICATION = "SELECT COUNT(publication) FROM Publication publication";
	private static final String _SQL_COUNT_PUBLICATION_WHERE = "SELECT COUNT(publication) FROM Publication publication WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publication.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Publication exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Publication exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublicationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishId", "publishVerId", "publishStatCd", "chainCode",
				"publishEnvName", "publishLocaleList", "publishDate",
				"publishContentType", "parentPublishId", "validateTranslation",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static Publication _nullPublication = new PublicationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Publication> toCacheModel() {
				return _nullPublicationCacheModel;
			}
		};

	private static CacheModel<Publication> _nullPublicationCacheModel = new CacheModel<Publication>() {
			@Override
			public Publication toEntityModel() {
				return _nullPublication;
			}
		};
}