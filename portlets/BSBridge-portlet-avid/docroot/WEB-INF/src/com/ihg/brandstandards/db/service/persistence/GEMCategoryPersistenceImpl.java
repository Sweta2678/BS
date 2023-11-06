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

import com.ihg.brandstandards.db.NoSuchGEMCategoryException;
import com.ihg.brandstandards.db.model.GEMCategory;
import com.ihg.brandstandards.db.model.impl.GEMCategoryImpl;
import com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl;

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
 * The persistence implementation for the g e m category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMCategoryPersistence
 * @see GEMCategoryUtil
 * @generated
 */
public class GEMCategoryPersistenceImpl extends BasePersistenceImpl<GEMCategory>
	implements GEMCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMCategoryUtil} to access the g e m category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CMSCATEGORYID = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCMSCategoryId",
			new String[] { Long.class.getName() },
			GEMCategoryModelImpl.CMSCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CMSCATEGORYID = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCMSCategoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the g e m category where cmsCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	 *
	 * @param cmsCategoryId the cms category ID
	 * @return the matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByCMSCategoryId(long cmsCategoryId)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByCMSCategoryId(cmsCategoryId);

		if (gemCategory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cmsCategoryId=");
			msg.append(cmsCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMCategoryException(msg.toString());
		}

		return gemCategory;
	}

	/**
	 * Returns the g e m category where cmsCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cmsCategoryId the cms category ID
	 * @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByCMSCategoryId(long cmsCategoryId)
		throws SystemException {
		return fetchByCMSCategoryId(cmsCategoryId, true);
	}

	/**
	 * Returns the g e m category where cmsCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cmsCategoryId the cms category ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByCMSCategoryId(long cmsCategoryId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cmsCategoryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof GEMCategory) {
			GEMCategory gemCategory = (GEMCategory)result;

			if ((cmsCategoryId != gemCategory.getCmsCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CMSCATEGORYID_CMSCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmsCategoryId);

				List<GEMCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMCategoryPersistenceImpl.fetchByCMSCategoryId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMCategory gemCategory = list.get(0);

					result = gemCategory;

					cacheResult(gemCategory);

					if ((gemCategory.getCmsCategoryId() != cmsCategoryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
							finderArgs, gemCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
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
			return (GEMCategory)result;
		}
	}

	/**
	 * Removes the g e m category where cmsCategoryId = &#63; from the database.
	 *
	 * @param cmsCategoryId the cms category ID
	 * @return the g e m category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory removeByCMSCategoryId(long cmsCategoryId)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = findByCMSCategoryId(cmsCategoryId);

		return remove(gemCategory);
	}

	/**
	 * Returns the number of g e m categories where cmsCategoryId = &#63;.
	 *
	 * @param cmsCategoryId the cms category ID
	 * @return the number of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCMSCategoryId(long cmsCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CMSCATEGORYID;

		Object[] finderArgs = new Object[] { cmsCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CMSCATEGORYID_CMSCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmsCategoryId);

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

	private static final String _FINDER_COLUMN_CMSCATEGORYID_CMSCATEGORYID_2 = "gemCategory.cmsCategoryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GEMCATEGORYID = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGEMCategoryId",
			new String[] { String.class.getName() },
			GEMCategoryModelImpl.GEMCATEGORYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GEMCATEGORYID = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGEMCategoryId",
			new String[] { String.class.getName() });

	/**
	 * Returns the g e m category where gemCategoryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	 *
	 * @param gemCategoryCode the gem category code
	 * @return the matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByGEMCategoryId(String gemCategoryCode)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByGEMCategoryId(gemCategoryCode);

		if (gemCategory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("gemCategoryCode=");
			msg.append(gemCategoryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMCategoryException(msg.toString());
		}

		return gemCategory;
	}

	/**
	 * Returns the g e m category where gemCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param gemCategoryCode the gem category code
	 * @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByGEMCategoryId(String gemCategoryCode)
		throws SystemException {
		return fetchByGEMCategoryId(gemCategoryCode, true);
	}

	/**
	 * Returns the g e m category where gemCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param gemCategoryCode the gem category code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByGEMCategoryId(String gemCategoryCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { gemCategoryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof GEMCategory) {
			GEMCategory gemCategory = (GEMCategory)result;

			if (!Validator.equals(gemCategoryCode,
						gemCategory.getGemCategoryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

			boolean bindGemCategoryCode = false;

			if (gemCategoryCode == null) {
				query.append(_FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_1);
			}
			else if (gemCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_3);
			}
			else {
				bindGemCategoryCode = true;

				query.append(_FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemCategoryCode) {
					qPos.add(gemCategoryCode);
				}

				List<GEMCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMCategoryPersistenceImpl.fetchByGEMCategoryId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMCategory gemCategory = list.get(0);

					result = gemCategory;

					cacheResult(gemCategory);

					if ((gemCategory.getGemCategoryCode() == null) ||
							!gemCategory.getGemCategoryCode()
											.equals(gemCategoryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
							finderArgs, gemCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
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
			return (GEMCategory)result;
		}
	}

	/**
	 * Removes the g e m category where gemCategoryCode = &#63; from the database.
	 *
	 * @param gemCategoryCode the gem category code
	 * @return the g e m category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory removeByGEMCategoryId(String gemCategoryCode)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = findByGEMCategoryId(gemCategoryCode);

		return remove(gemCategory);
	}

	/**
	 * Returns the number of g e m categories where gemCategoryCode = &#63;.
	 *
	 * @param gemCategoryCode the gem category code
	 * @return the number of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGEMCategoryId(String gemCategoryCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GEMCATEGORYID;

		Object[] finderArgs = new Object[] { gemCategoryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMCATEGORY_WHERE);

			boolean bindGemCategoryCode = false;

			if (gemCategoryCode == null) {
				query.append(_FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_1);
			}
			else if (gemCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_3);
			}
			else {
				bindGemCategoryCode = true;

				query.append(_FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemCategoryCode) {
					qPos.add(gemCategoryCode);
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

	private static final String _FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_1 = "gemCategory.gemCategoryCode IS NULL";
	private static final String _FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_2 = "gemCategory.gemCategoryCode = ?";
	private static final String _FINDER_COLUMN_GEMCATEGORYID_GEMCATEGORYCODE_3 = "(gemCategory.gemCategoryCode IS NULL OR gemCategory.gemCategoryCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GEMPRNTCATEGORYID =
		new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGemPrntCategoryId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEMPRNTCATEGORYID =
		new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGemPrntCategoryId", new String[] { String.class.getName() },
			GEMCategoryModelImpl.GEMPRNTCATEGORYID_COLUMN_BITMASK |
			GEMCategoryModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GEMPRNTCATEGORYID = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGemPrntCategoryId", new String[] { String.class.getName() });

	/**
	 * Returns all the g e m categories where gemPrntCategoryId = &#63;.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @return the matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findByGemPrntCategoryId(String gemPrntCategoryId)
		throws SystemException {
		return findByGemPrntCategoryId(gemPrntCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m categories where gemPrntCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param start the lower bound of the range of g e m categories
	 * @param end the upper bound of the range of g e m categories (not inclusive)
	 * @return the range of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findByGemPrntCategoryId(String gemPrntCategoryId,
		int start, int end) throws SystemException {
		return findByGemPrntCategoryId(gemPrntCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m categories where gemPrntCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param start the lower bound of the range of g e m categories
	 * @param end the upper bound of the range of g e m categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findByGemPrntCategoryId(String gemPrntCategoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEMPRNTCATEGORYID;
			finderArgs = new Object[] { gemPrntCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GEMPRNTCATEGORYID;
			finderArgs = new Object[] {
					gemPrntCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<GEMCategory> list = (List<GEMCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMCategory gemCategory : list) {
				if (!Validator.equals(gemPrntCategoryId,
							gemCategory.getGemPrntCategoryId())) {
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

			query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

			boolean bindGemPrntCategoryId = false;

			if (gemPrntCategoryId == null) {
				query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_1);
			}
			else if (gemPrntCategoryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_3);
			}
			else {
				bindGemPrntCategoryId = true;

				query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemPrntCategoryId) {
					qPos.add(gemPrntCategoryId);
				}

				if (!pagination) {
					list = (List<GEMCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMCategory>(list);
				}
				else {
					list = (List<GEMCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m category in the ordered set where gemPrntCategoryId = &#63;.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByGemPrntCategoryId_First(String gemPrntCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByGemPrntCategoryId_First(gemPrntCategoryId,
				orderByComparator);

		if (gemCategory != null) {
			return gemCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gemPrntCategoryId=");
		msg.append(gemPrntCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMCategoryException(msg.toString());
	}

	/**
	 * Returns the first g e m category in the ordered set where gemPrntCategoryId = &#63;.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByGemPrntCategoryId_First(
		String gemPrntCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMCategory> list = findByGemPrntCategoryId(gemPrntCategoryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m category in the ordered set where gemPrntCategoryId = &#63;.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByGemPrntCategoryId_Last(String gemPrntCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByGemPrntCategoryId_Last(gemPrntCategoryId,
				orderByComparator);

		if (gemCategory != null) {
			return gemCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gemPrntCategoryId=");
		msg.append(gemPrntCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMCategoryException(msg.toString());
	}

	/**
	 * Returns the last g e m category in the ordered set where gemPrntCategoryId = &#63;.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByGemPrntCategoryId_Last(String gemPrntCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGemPrntCategoryId(gemPrntCategoryId);

		if (count == 0) {
			return null;
		}

		List<GEMCategory> list = findByGemPrntCategoryId(gemPrntCategoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m categories before and after the current g e m category in the ordered set where gemPrntCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current g e m category
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory[] findByGemPrntCategoryId_PrevAndNext(long categoryId,
		String gemPrntCategoryId, OrderByComparator orderByComparator)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			GEMCategory[] array = new GEMCategoryImpl[3];

			array[0] = getByGemPrntCategoryId_PrevAndNext(session, gemCategory,
					gemPrntCategoryId, orderByComparator, true);

			array[1] = gemCategory;

			array[2] = getByGemPrntCategoryId_PrevAndNext(session, gemCategory,
					gemPrntCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMCategory getByGemPrntCategoryId_PrevAndNext(Session session,
		GEMCategory gemCategory, String gemPrntCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

		boolean bindGemPrntCategoryId = false;

		if (gemPrntCategoryId == null) {
			query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_1);
		}
		else if (gemPrntCategoryId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_3);
		}
		else {
			bindGemPrntCategoryId = true;

			query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_2);
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
			query.append(GEMCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGemPrntCategoryId) {
			qPos.add(gemPrntCategoryId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m categories where gemPrntCategoryId = &#63; from the database.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGemPrntCategoryId(String gemPrntCategoryId)
		throws SystemException {
		for (GEMCategory gemCategory : findByGemPrntCategoryId(
				gemPrntCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemCategory);
		}
	}

	/**
	 * Returns the number of g e m categories where gemPrntCategoryId = &#63;.
	 *
	 * @param gemPrntCategoryId the gem prnt category ID
	 * @return the number of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGemPrntCategoryId(String gemPrntCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GEMPRNTCATEGORYID;

		Object[] finderArgs = new Object[] { gemPrntCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMCATEGORY_WHERE);

			boolean bindGemPrntCategoryId = false;

			if (gemPrntCategoryId == null) {
				query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_1);
			}
			else if (gemPrntCategoryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_3);
			}
			else {
				bindGemPrntCategoryId = true;

				query.append(_FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemPrntCategoryId) {
					qPos.add(gemPrntCategoryId);
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

	private static final String _FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_1 =
		"gemCategory.gemPrntCategoryId IS NULL";
	private static final String _FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_2 =
		"gemCategory.gemPrntCategoryId = ?";
	private static final String _FINDER_COLUMN_GEMPRNTCATEGORYID_GEMPRNTCATEGORYID_3 =
		"(gemCategory.gemPrntCategoryId IS NULL OR gemCategory.gemPrntCategoryId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryName",
			new String[] { String.class.getName() },
			GEMCategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK |
			GEMCategoryModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the g e m categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findByCategoryName(String categoryName)
		throws SystemException {
		return findByCategoryName(categoryName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of g e m categories
	 * @param end the upper bound of the range of g e m categories (not inclusive)
	 * @return the range of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findByCategoryName(String categoryName, int start,
		int end) throws SystemException {
		return findByCategoryName(categoryName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m categories where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of g e m categories
	 * @param end the upper bound of the range of g e m categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findByCategoryName(String categoryName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] { categoryName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] {
					categoryName,
					
					start, end, orderByComparator
				};
		}

		List<GEMCategory> list = (List<GEMCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMCategory gemCategory : list) {
				if (!Validator.equals(categoryName,
							gemCategory.getCategoryName())) {
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

			query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

				if (!pagination) {
					list = (List<GEMCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMCategory>(list);
				}
				else {
					list = (List<GEMCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByCategoryName_First(String categoryName,
		OrderByComparator orderByComparator)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByCategoryName_First(categoryName,
				orderByComparator);

		if (gemCategory != null) {
			return gemCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryName=");
		msg.append(categoryName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMCategoryException(msg.toString());
	}

	/**
	 * Returns the first g e m category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByCategoryName_First(String categoryName,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMCategory> list = findByCategoryName(categoryName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByCategoryName_Last(String categoryName,
		OrderByComparator orderByComparator)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByCategoryName_Last(categoryName,
				orderByComparator);

		if (gemCategory != null) {
			return gemCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryName=");
		msg.append(categoryName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMCategoryException(msg.toString());
	}

	/**
	 * Returns the last g e m category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByCategoryName_Last(String categoryName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryName(categoryName);

		if (count == 0) {
			return null;
		}

		List<GEMCategory> list = findByCategoryName(categoryName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m categories before and after the current g e m category in the ordered set where categoryName = &#63;.
	 *
	 * @param categoryId the primary key of the current g e m category
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory[] findByCategoryName_PrevAndNext(long categoryId,
		String categoryName, OrderByComparator orderByComparator)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			GEMCategory[] array = new GEMCategoryImpl[3];

			array[0] = getByCategoryName_PrevAndNext(session, gemCategory,
					categoryName, orderByComparator, true);

			array[1] = gemCategory;

			array[2] = getByCategoryName_PrevAndNext(session, gemCategory,
					categoryName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMCategory getByCategoryName_PrevAndNext(Session session,
		GEMCategory gemCategory, String categoryName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

		boolean bindCategoryName = false;

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
		}
		else if (categoryName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
		}
		else {
			bindCategoryName = true;

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
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
			query.append(GEMCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoryName) {
			qPos.add(categoryName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m categories where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryName(String categoryName)
		throws SystemException {
		for (GEMCategory gemCategory : findByCategoryName(categoryName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemCategory);
		}
	}

	/**
	 * Returns the number of g e m categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryName(String categoryName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYNAME;

		Object[] finderArgs = new Object[] { categoryName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoryName) {
					qPos.add(categoryName);
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

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1 = "gemCategory.categoryName IS NULL";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 = "gemCategory.categoryName = ?";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 = "(gemCategory.categoryName IS NULL OR gemCategory.categoryName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, GEMCategoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGEMCategoryIdAndName",
			new String[] { String.class.getName(), String.class.getName() },
			GEMCategoryModelImpl.GEMCATEGORYCODE_COLUMN_BITMASK |
			GEMCategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GEMCATEGORYIDANDNAME = new FinderPath(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGEMCategoryIdAndName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the g e m category where gemCategoryCode = &#63; and categoryName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	 *
	 * @param gemCategoryCode the gem category code
	 * @param categoryName the category name
	 * @return the matching g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByGEMCategoryIdAndName(String gemCategoryCode,
		String categoryName) throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByGEMCategoryIdAndName(gemCategoryCode,
				categoryName);

		if (gemCategory == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("gemCategoryCode=");
			msg.append(gemCategoryCode);

			msg.append(", categoryName=");
			msg.append(categoryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMCategoryException(msg.toString());
		}

		return gemCategory;
	}

	/**
	 * Returns the g e m category where gemCategoryCode = &#63; and categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param gemCategoryCode the gem category code
	 * @param categoryName the category name
	 * @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByGEMCategoryIdAndName(String gemCategoryCode,
		String categoryName) throws SystemException {
		return fetchByGEMCategoryIdAndName(gemCategoryCode, categoryName, true);
	}

	/**
	 * Returns the g e m category where gemCategoryCode = &#63; and categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param gemCategoryCode the gem category code
	 * @param categoryName the category name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByGEMCategoryIdAndName(String gemCategoryCode,
		String categoryName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { gemCategoryCode, categoryName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
					finderArgs, this);
		}

		if (result instanceof GEMCategory) {
			GEMCategory gemCategory = (GEMCategory)result;

			if (!Validator.equals(gemCategoryCode,
						gemCategory.getGemCategoryCode()) ||
					!Validator.equals(categoryName,
						gemCategory.getCategoryName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GEMCATEGORY_WHERE);

			boolean bindGemCategoryCode = false;

			if (gemCategoryCode == null) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_1);
			}
			else if (gemCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_3);
			}
			else {
				bindGemCategoryCode = true;

				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_2);
			}

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemCategoryCode) {
					qPos.add(gemCategoryCode);
				}

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

				List<GEMCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMCategoryPersistenceImpl.fetchByGEMCategoryIdAndName(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMCategory gemCategory = list.get(0);

					result = gemCategory;

					cacheResult(gemCategory);

					if ((gemCategory.getGemCategoryCode() == null) ||
							!gemCategory.getGemCategoryCode()
											.equals(gemCategoryCode) ||
							(gemCategory.getCategoryName() == null) ||
							!gemCategory.getCategoryName().equals(categoryName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
							finderArgs, gemCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
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
			return (GEMCategory)result;
		}
	}

	/**
	 * Removes the g e m category where gemCategoryCode = &#63; and categoryName = &#63; from the database.
	 *
	 * @param gemCategoryCode the gem category code
	 * @param categoryName the category name
	 * @return the g e m category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory removeByGEMCategoryIdAndName(String gemCategoryCode,
		String categoryName) throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = findByGEMCategoryIdAndName(gemCategoryCode,
				categoryName);

		return remove(gemCategory);
	}

	/**
	 * Returns the number of g e m categories where gemCategoryCode = &#63; and categoryName = &#63;.
	 *
	 * @param gemCategoryCode the gem category code
	 * @param categoryName the category name
	 * @return the number of matching g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGEMCategoryIdAndName(String gemCategoryCode,
		String categoryName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GEMCATEGORYIDANDNAME;

		Object[] finderArgs = new Object[] { gemCategoryCode, categoryName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMCATEGORY_WHERE);

			boolean bindGemCategoryCode = false;

			if (gemCategoryCode == null) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_1);
			}
			else if (gemCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_3);
			}
			else {
				bindGemCategoryCode = true;

				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_2);
			}

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGemCategoryCode) {
					qPos.add(gemCategoryCode);
				}

				if (bindCategoryName) {
					qPos.add(categoryName);
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

	private static final String _FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_1 =
		"gemCategory.gemCategoryCode IS NULL AND ";
	private static final String _FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_2 =
		"gemCategory.gemCategoryCode = ? AND ";
	private static final String _FINDER_COLUMN_GEMCATEGORYIDANDNAME_GEMCATEGORYCODE_3 =
		"(gemCategory.gemCategoryCode IS NULL OR gemCategory.gemCategoryCode = '') AND ";
	private static final String _FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_1 =
		"gemCategory.categoryName IS NULL";
	private static final String _FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_2 =
		"gemCategory.categoryName = ?";
	private static final String _FINDER_COLUMN_GEMCATEGORYIDANDNAME_CATEGORYNAME_3 =
		"(gemCategory.categoryName IS NULL OR gemCategory.categoryName = '')";

	public GEMCategoryPersistenceImpl() {
		setModelClass(GEMCategory.class);
	}

	/**
	 * Caches the g e m category in the entity cache if it is enabled.
	 *
	 * @param gemCategory the g e m category
	 */
	@Override
	public void cacheResult(GEMCategory gemCategory) {
		EntityCacheUtil.putResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryImpl.class, gemCategory.getPrimaryKey(), gemCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
			new Object[] { gemCategory.getCmsCategoryId() }, gemCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
			new Object[] { gemCategory.getGemCategoryCode() }, gemCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
			new Object[] {
				gemCategory.getGemCategoryCode(), gemCategory.getCategoryName()
			}, gemCategory);

		gemCategory.resetOriginalValues();
	}

	/**
	 * Caches the g e m categories in the entity cache if it is enabled.
	 *
	 * @param gemCategories the g e m categories
	 */
	@Override
	public void cacheResult(List<GEMCategory> gemCategories) {
		for (GEMCategory gemCategory : gemCategories) {
			if (EntityCacheUtil.getResult(
						GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
						GEMCategoryImpl.class, gemCategory.getPrimaryKey()) == null) {
				cacheResult(gemCategory);
			}
			else {
				gemCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMCategory gemCategory) {
		EntityCacheUtil.removeResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryImpl.class, gemCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemCategory);
	}

	@Override
	public void clearCache(List<GEMCategory> gemCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMCategory gemCategory : gemCategories) {
			EntityCacheUtil.removeResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
				GEMCategoryImpl.class, gemCategory.getPrimaryKey());

			clearUniqueFindersCache(gemCategory);
		}
	}

	protected void cacheUniqueFindersCache(GEMCategory gemCategory) {
		if (gemCategory.isNew()) {
			Object[] args = new Object[] { gemCategory.getCmsCategoryId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CMSCATEGORYID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID, args,
				gemCategory);

			args = new Object[] { gemCategory.getGemCategoryCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEMCATEGORYID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID, args,
				gemCategory);

			args = new Object[] {
					gemCategory.getGemCategoryCode(),
					gemCategory.getCategoryName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEMCATEGORYIDANDNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
				args, gemCategory);
		}
		else {
			GEMCategoryModelImpl gemCategoryModelImpl = (GEMCategoryModelImpl)gemCategory;

			if ((gemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CMSCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { gemCategory.getCmsCategoryId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CMSCATEGORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
					args, gemCategory);
			}

			if ((gemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GEMCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { gemCategory.getGemCategoryCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEMCATEGORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
					args, gemCategory);
			}

			if ((gemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemCategory.getGemCategoryCode(),
						gemCategory.getCategoryName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEMCATEGORYIDANDNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
					args, gemCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMCategory gemCategory) {
		GEMCategoryModelImpl gemCategoryModelImpl = (GEMCategoryModelImpl)gemCategory;

		Object[] args = new Object[] { gemCategory.getCmsCategoryId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMSCATEGORYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID, args);

		if ((gemCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CMSCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] { gemCategoryModelImpl.getOriginalCmsCategoryId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMSCATEGORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CMSCATEGORYID,
				args);
		}

		args = new Object[] { gemCategory.getGemCategoryCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMCATEGORYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID, args);

		if ((gemCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GEMCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemCategoryModelImpl.getOriginalGemCategoryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMCATEGORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMCATEGORYID,
				args);
		}

		args = new Object[] {
				gemCategory.getGemCategoryCode(), gemCategory.getCategoryName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMCATEGORYIDANDNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
			args);

		if ((gemCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemCategoryModelImpl.getOriginalGemCategoryCode(),
					gemCategoryModelImpl.getOriginalCategoryName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMCATEGORYIDANDNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEMCATEGORYIDANDNAME,
				args);
		}
	}

	/**
	 * Creates a new g e m category with the primary key. Does not add the g e m category to the database.
	 *
	 * @param categoryId the primary key for the new g e m category
	 * @return the new g e m category
	 */
	@Override
	public GEMCategory create(long categoryId) {
		GEMCategory gemCategory = new GEMCategoryImpl();

		gemCategory.setNew(true);
		gemCategory.setPrimaryKey(categoryId);

		return gemCategory;
	}

	/**
	 * Removes the g e m category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the g e m category
	 * @return the g e m category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory remove(long categoryId)
		throws NoSuchGEMCategoryException, SystemException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the g e m category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m category
	 * @return the g e m category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory remove(Serializable primaryKey)
		throws NoSuchGEMCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMCategory gemCategory = (GEMCategory)session.get(GEMCategoryImpl.class,
					primaryKey);

			if (gemCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemCategory);
		}
		catch (NoSuchGEMCategoryException nsee) {
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
	protected GEMCategory removeImpl(GEMCategory gemCategory)
		throws SystemException {
		gemCategory = toUnwrappedModel(gemCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemCategory)) {
				gemCategory = (GEMCategory)session.get(GEMCategoryImpl.class,
						gemCategory.getPrimaryKeyObj());
			}

			if (gemCategory != null) {
				session.delete(gemCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemCategory != null) {
			clearCache(gemCategory);
		}

		return gemCategory;
	}

	@Override
	public GEMCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMCategory gemCategory)
		throws SystemException {
		gemCategory = toUnwrappedModel(gemCategory);

		boolean isNew = gemCategory.isNew();

		GEMCategoryModelImpl gemCategoryModelImpl = (GEMCategoryModelImpl)gemCategory;

		Session session = null;

		try {
			session = openSession();

			if (gemCategory.isNew()) {
				session.save(gemCategory);

				gemCategory.setNew(false);
			}
			else {
				session.merge(gemCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEMPRNTCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemCategoryModelImpl.getOriginalGemPrntCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMPRNTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEMPRNTCATEGORYID,
					args);

				args = new Object[] { gemCategoryModelImpl.getGemPrntCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEMPRNTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEMPRNTCATEGORYID,
					args);
			}

			if ((gemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemCategoryModelImpl.getOriginalCategoryName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);

				args = new Object[] { gemCategoryModelImpl.getCategoryName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMCategoryImpl.class, gemCategory.getPrimaryKey(), gemCategory);

		clearUniqueFindersCache(gemCategory);
		cacheUniqueFindersCache(gemCategory);

		return gemCategory;
	}

	protected GEMCategory toUnwrappedModel(GEMCategory gemCategory) {
		if (gemCategory instanceof GEMCategoryImpl) {
			return gemCategory;
		}

		GEMCategoryImpl gemCategoryImpl = new GEMCategoryImpl();

		gemCategoryImpl.setNew(gemCategory.isNew());
		gemCategoryImpl.setPrimaryKey(gemCategory.getPrimaryKey());

		gemCategoryImpl.setCategoryId(gemCategory.getCategoryId());
		gemCategoryImpl.setCmsCategoryId(gemCategory.getCmsCategoryId());
		gemCategoryImpl.setGemCategoryCode(gemCategory.getGemCategoryCode());
		gemCategoryImpl.setGemPrntCategoryId(gemCategory.getGemPrntCategoryId());
		gemCategoryImpl.setCategoryName(gemCategory.getCategoryName());
		gemCategoryImpl.setCategoryViewType(gemCategory.getCategoryViewType());
		gemCategoryImpl.setCategoryAnsAll(gemCategory.getCategoryAnsAll());
		gemCategoryImpl.setDuplicatable(gemCategory.getDuplicatable());
		gemCategoryImpl.setDisplayOrderNumber(gemCategory.getDisplayOrderNumber());
		gemCategoryImpl.setCreatorId(gemCategory.getCreatorId());
		gemCategoryImpl.setCreatedDate(gemCategory.getCreatedDate());
		gemCategoryImpl.setUpdatedBy(gemCategory.getUpdatedBy());
		gemCategoryImpl.setUpdatedDate(gemCategory.getUpdatedDate());

		return gemCategoryImpl;
	}

	/**
	 * Returns the g e m category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m category
	 * @return the g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMCategoryException, SystemException {
		GEMCategory gemCategory = fetchByPrimaryKey(primaryKey);

		if (gemCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemCategory;
	}

	/**
	 * Returns the g e m category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the g e m category
	 * @return the g e m category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory findByPrimaryKey(long categoryId)
		throws NoSuchGEMCategoryException, SystemException {
		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the g e m category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m category
	 * @return the g e m category, or <code>null</code> if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMCategory gemCategory = (GEMCategory)EntityCacheUtil.getResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
				GEMCategoryImpl.class, primaryKey);

		if (gemCategory == _nullGEMCategory) {
			return null;
		}

		if (gemCategory == null) {
			Session session = null;

			try {
				session = openSession();

				gemCategory = (GEMCategory)session.get(GEMCategoryImpl.class,
						primaryKey);

				if (gemCategory != null) {
					cacheResult(gemCategory);
				}
				else {
					EntityCacheUtil.putResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
						GEMCategoryImpl.class, primaryKey, _nullGEMCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMCategoryModelImpl.ENTITY_CACHE_ENABLED,
					GEMCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemCategory;
	}

	/**
	 * Returns the g e m category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the g e m category
	 * @return the g e m category, or <code>null</code> if a g e m category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the g e m categories.
	 *
	 * @return the g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m categories
	 * @param end the upper bound of the range of g e m categories (not inclusive)
	 * @return the range of g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m categories
	 * @param end the upper bound of the range of g e m categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCategory> findAll(int start, int end,
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

		List<GEMCategory> list = (List<GEMCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMCATEGORY;

				if (pagination) {
					sql = sql.concat(GEMCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMCategory>(list);
				}
				else {
					list = (List<GEMCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMCategory gemCategory : findAll()) {
			remove(gemCategory);
		}
	}

	/**
	 * Returns the number of g e m categories.
	 *
	 * @return the number of g e m categories
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

				Query q = session.createQuery(_SQL_COUNT_GEMCATEGORY);

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
	 * Initializes the g e m category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMCategory>> listenersList = new ArrayList<ModelListener<GEMCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMCATEGORY = "SELECT gemCategory FROM GEMCategory gemCategory";
	private static final String _SQL_SELECT_GEMCATEGORY_WHERE = "SELECT gemCategory FROM GEMCategory gemCategory WHERE ";
	private static final String _SQL_COUNT_GEMCATEGORY = "SELECT COUNT(gemCategory) FROM GEMCategory gemCategory";
	private static final String _SQL_COUNT_GEMCATEGORY_WHERE = "SELECT COUNT(gemCategory) FROM GEMCategory gemCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"categoryId", "cmsCategoryId", "gemCategoryCode",
				"gemPrntCategoryId", "categoryName", "categoryViewType",
				"categoryAnsAll", "duplicatable", "displayOrderNumber",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GEMCategory _nullGEMCategory = new GEMCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMCategory> toCacheModel() {
				return _nullGEMCategoryCacheModel;
			}
		};

	private static CacheModel<GEMCategory> _nullGEMCategoryCacheModel = new CacheModel<GEMCategory>() {
			@Override
			public GEMCategory toEntityModel() {
				return _nullGEMCategory;
			}
		};
}