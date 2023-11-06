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

import com.ihg.brandstandards.db.NoSuchGEMStdCategoryException;
import com.ihg.brandstandards.db.model.GEMStdCategory;
import com.ihg.brandstandards.db.model.impl.GEMStdCategoryImpl;
import com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl;

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
 * The persistence implementation for the g e m std category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMStdCategoryPersistence
 * @see GEMStdCategoryUtil
 * @generated
 */
public class GEMStdCategoryPersistenceImpl extends BasePersistenceImpl<GEMStdCategory>
	implements GEMStdCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMStdCategoryUtil} to access the g e m std category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMStdCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STDCATGYMAPPING = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByStdCatgyMapping",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			GEMStdCategoryModelImpl.STDID_COLUMN_BITMASK |
			GEMStdCategoryModelImpl.CATEGORYID_COLUMN_BITMASK |
			GEMStdCategoryModelImpl.TEMPLATETYPE_COLUMN_BITMASK |
			GEMStdCategoryModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDCATGYMAPPING = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStdCatgyMapping",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMStdCategoryException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @return the matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByStdCatgyMapping(long stdId, long categoryId,
		String templateType, String chainCode)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByStdCatgyMapping(stdId,
				categoryId, templateType, chainCode);

		if (gemStdCategory == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(", templateType=");
			msg.append(templateType);

			msg.append(", chainCode=");
			msg.append(chainCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMStdCategoryException(msg.toString());
		}

		return gemStdCategory;
	}

	/**
	 * Returns the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @return the matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByStdCatgyMapping(long stdId, long categoryId,
		String templateType, String chainCode) throws SystemException {
		return fetchByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode, true);
	}

	/**
	 * Returns the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByStdCatgyMapping(long stdId, long categoryId,
		String templateType, String chainCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				stdId, categoryId, templateType, chainCode
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
					finderArgs, this);
		}

		if (result instanceof GEMStdCategory) {
			GEMStdCategory gemStdCategory = (GEMStdCategory)result;

			if ((stdId != gemStdCategory.getStdId()) ||
					(categoryId != gemStdCategory.getCategoryId()) ||
					!Validator.equals(templateType,
						gemStdCategory.getTemplateType()) ||
					!Validator.equals(chainCode, gemStdCategory.getChainCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_STDCATGYMAPPING_STDID_2);

			query.append(_FINDER_COLUMN_STDCATGYMAPPING_CATEGORYID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				qPos.add(categoryId);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				List<GEMStdCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMStdCategoryPersistenceImpl.fetchByStdCatgyMapping(long, long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMStdCategory gemStdCategory = list.get(0);

					result = gemStdCategory;

					cacheResult(gemStdCategory);

					if ((gemStdCategory.getStdId() != stdId) ||
							(gemStdCategory.getCategoryId() != categoryId) ||
							(gemStdCategory.getTemplateType() == null) ||
							!gemStdCategory.getTemplateType()
											   .equals(templateType) ||
							(gemStdCategory.getChainCode() == null) ||
							!gemStdCategory.getChainCode().equals(chainCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
							finderArgs, gemStdCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
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
			return (GEMStdCategory)result;
		}
	}

	/**
	 * Removes the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @return the g e m std category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory removeByStdCatgyMapping(long stdId, long categoryId,
		String templateType, String chainCode)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = findByStdCatgyMapping(stdId,
				categoryId, templateType, chainCode);

		return remove(gemStdCategory);
	}

	/**
	 * Returns the number of g e m std categories where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param stdId the std ID
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @return the number of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdCatgyMapping(long stdId, long categoryId,
		String templateType, String chainCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDCATGYMAPPING;

		Object[] finderArgs = new Object[] {
				stdId, categoryId, templateType, chainCode
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_STDCATGYMAPPING_STDID_2);

			query.append(_FINDER_COLUMN_STDCATGYMAPPING_CATEGORYID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				qPos.add(categoryId);

				if (bindTemplateType) {
					qPos.add(templateType);
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

	private static final String _FINDER_COLUMN_STDCATGYMAPPING_STDID_2 = "gemStdCategory.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_CATEGORYID_2 = "gemStdCategory.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_1 = "gemStdCategory.templateType IS NULL AND ";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_2 = "gemStdCategory.templateType = ? AND ";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_TEMPLATETYPE_3 = "(gemStdCategory.templateType IS NULL OR gemStdCategory.templateType = '') AND ";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_1 = "gemStdCategory.chainCode IS NULL";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_2 = "gemStdCategory.chainCode = ?";
	private static final String _FINDER_COLUMN_STDCATGYMAPPING_CHAINCODE_3 = "(gemStdCategory.chainCode IS NULL OR gemStdCategory.chainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN =
		new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCatgyTemplateAndChain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN =
		new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCatgyTemplateAndChain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			GEMStdCategoryModelImpl.CATEGORYID_COLUMN_BITMASK |
			GEMStdCategoryModelImpl.TEMPLATETYPE_COLUMN_BITMASK |
			GEMStdCategoryModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATGYTEMPLATEANDCHAIN = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCatgyTemplateAndChain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @return the matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCatgyTemplateAndChain(long categoryId,
		String templateType, String chainCode) throws SystemException {
		return findByCatgyTemplateAndChain(categoryId, templateType, chainCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @return the range of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCatgyTemplateAndChain(long categoryId,
		String templateType, String chainCode, int start, int end)
		throws SystemException {
		return findByCatgyTemplateAndChain(categoryId, templateType, chainCode,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCatgyTemplateAndChain(long categoryId,
		String templateType, String chainCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN;
			finderArgs = new Object[] { categoryId, templateType, chainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN;
			finderArgs = new Object[] {
					categoryId, templateType, chainCode,
					
					start, end, orderByComparator
				};
		}

		List<GEMStdCategory> list = (List<GEMStdCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMStdCategory gemStdCategory : list) {
				if ((categoryId != gemStdCategory.getCategoryId()) ||
						!Validator.equals(templateType,
							gemStdCategory.getTemplateType()) ||
						!Validator.equals(chainCode,
							gemStdCategory.getChainCode())) {
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

			query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CATEGORYID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (bindTemplateType) {
					qPos.add(templateType);
				}

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (!pagination) {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMStdCategory>(list);
				}
				else {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
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
	 * Returns the first g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByCatgyTemplateAndChain_First(long categoryId,
		String templateType, String chainCode,
		OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByCatgyTemplateAndChain_First(categoryId,
				templateType, chainCode, orderByComparator);

		if (gemStdCategory != null) {
			return gemStdCategory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", templateType=");
		msg.append(templateType);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMStdCategoryException(msg.toString());
	}

	/**
	 * Returns the first g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByCatgyTemplateAndChain_First(long categoryId,
		String templateType, String chainCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMStdCategory> list = findByCatgyTemplateAndChain(categoryId,
				templateType, chainCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByCatgyTemplateAndChain_Last(long categoryId,
		String templateType, String chainCode,
		OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByCatgyTemplateAndChain_Last(categoryId,
				templateType, chainCode, orderByComparator);

		if (gemStdCategory != null) {
			return gemStdCategory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", templateType=");
		msg.append(templateType);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMStdCategoryException(msg.toString());
	}

	/**
	 * Returns the last g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByCatgyTemplateAndChain_Last(long categoryId,
		String templateType, String chainCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCatgyTemplateAndChain(categoryId, templateType,
				chainCode);

		if (count == 0) {
			return null;
		}

		List<GEMStdCategory> list = findByCatgyTemplateAndChain(categoryId,
				templateType, chainCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m std categories before and after the current g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param gemStdCategoryId the primary key of the current g e m std category
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory[] findByCatgyTemplateAndChain_PrevAndNext(
		long gemStdCategoryId, long categoryId, String templateType,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = findByPrimaryKey(gemStdCategoryId);

		Session session = null;

		try {
			session = openSession();

			GEMStdCategory[] array = new GEMStdCategoryImpl[3];

			array[0] = getByCatgyTemplateAndChain_PrevAndNext(session,
					gemStdCategory, categoryId, templateType, chainCode,
					orderByComparator, true);

			array[1] = gemStdCategory;

			array[2] = getByCatgyTemplateAndChain_PrevAndNext(session,
					gemStdCategory, categoryId, templateType, chainCode,
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

	protected GEMStdCategory getByCatgyTemplateAndChain_PrevAndNext(
		Session session, GEMStdCategory gemStdCategory, long categoryId,
		String templateType, String chainCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CATEGORYID_2);

		boolean bindTemplateType = false;

		if (templateType == null) {
			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_1);
		}
		else if (templateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_3);
		}
		else {
			bindTemplateType = true;

			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_2);
		}

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_2);
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
			query.append(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (bindTemplateType) {
			qPos.add(templateType);
		}

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemStdCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMStdCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCatgyTemplateAndChain(long categoryId,
		String templateType, String chainCode) throws SystemException {
		for (GEMStdCategory gemStdCategory : findByCatgyTemplateAndChain(
				categoryId, templateType, chainCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gemStdCategory);
		}
	}

	/**
	 * Returns the number of g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param templateType the template type
	 * @param chainCode the chain code
	 * @return the number of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCatgyTemplateAndChain(long categoryId,
		String templateType, String chainCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATGYTEMPLATEANDCHAIN;

		Object[] finderArgs = new Object[] { categoryId, templateType, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CATEGORYID_2);

			boolean bindTemplateType = false;

			if (templateType == null) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_1);
			}
			else if (templateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_3);
			}
			else {
				bindTemplateType = true;

				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_2);
			}

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (bindTemplateType) {
					qPos.add(templateType);
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

	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CATEGORYID_2 =
		"gemStdCategory.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_1 =
		"gemStdCategory.templateType IS NULL AND ";
	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_2 =
		"gemStdCategory.templateType = ? AND ";
	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_TEMPLATETYPE_3 =
		"(gemStdCategory.templateType IS NULL OR gemStdCategory.templateType = '') AND ";
	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_1 =
		"gemStdCategory.chainCode IS NULL";
	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_2 =
		"gemStdCategory.chainCode = ?";
	private static final String _FINDER_COLUMN_CATGYTEMPLATEANDCHAIN_CHAINCODE_3 =
		"(gemStdCategory.chainCode IS NULL OR gemStdCategory.chainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATGYANDCHAIN =
		new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCatgyAndChain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYANDCHAIN =
		new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatgyAndChain",
			new String[] { Long.class.getName(), String.class.getName() },
			GEMStdCategoryModelImpl.CATEGORYID_COLUMN_BITMASK |
			GEMStdCategoryModelImpl.CHAINCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATGYANDCHAIN = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatgyAndChain",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @return the matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCatgyAndChain(long categoryId,
		String chainCode) throws SystemException {
		return findByCatgyAndChain(categoryId, chainCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @return the range of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCatgyAndChain(long categoryId,
		String chainCode, int start, int end) throws SystemException {
		return findByCatgyAndChain(categoryId, chainCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCatgyAndChain(long categoryId,
		String chainCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYANDCHAIN;
			finderArgs = new Object[] { categoryId, chainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATGYANDCHAIN;
			finderArgs = new Object[] {
					categoryId, chainCode,
					
					start, end, orderByComparator
				};
		}

		List<GEMStdCategory> list = (List<GEMStdCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMStdCategory gemStdCategory : list) {
				if ((categoryId != gemStdCategory.getCategoryId()) ||
						!Validator.equals(chainCode,
							gemStdCategory.getChainCode())) {
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

			query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATGYANDCHAIN_CATEGORYID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (bindChainCode) {
					qPos.add(chainCode);
				}

				if (!pagination) {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMStdCategory>(list);
				}
				else {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
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
	 * Returns the first g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByCatgyAndChain_First(long categoryId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByCatgyAndChain_First(categoryId,
				chainCode, orderByComparator);

		if (gemStdCategory != null) {
			return gemStdCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMStdCategoryException(msg.toString());
	}

	/**
	 * Returns the first g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByCatgyAndChain_First(long categoryId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMStdCategory> list = findByCatgyAndChain(categoryId, chainCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByCatgyAndChain_Last(long categoryId,
		String chainCode, OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByCatgyAndChain_Last(categoryId,
				chainCode, orderByComparator);

		if (gemStdCategory != null) {
			return gemStdCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(", chainCode=");
		msg.append(chainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMStdCategoryException(msg.toString());
	}

	/**
	 * Returns the last g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByCatgyAndChain_Last(long categoryId,
		String chainCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCatgyAndChain(categoryId, chainCode);

		if (count == 0) {
			return null;
		}

		List<GEMStdCategory> list = findByCatgyAndChain(categoryId, chainCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m std categories before and after the current g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param gemStdCategoryId the primary key of the current g e m std category
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory[] findByCatgyAndChain_PrevAndNext(
		long gemStdCategoryId, long categoryId, String chainCode,
		OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = findByPrimaryKey(gemStdCategoryId);

		Session session = null;

		try {
			session = openSession();

			GEMStdCategory[] array = new GEMStdCategoryImpl[3];

			array[0] = getByCatgyAndChain_PrevAndNext(session, gemStdCategory,
					categoryId, chainCode, orderByComparator, true);

			array[1] = gemStdCategory;

			array[2] = getByCatgyAndChain_PrevAndNext(session, gemStdCategory,
					categoryId, chainCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMStdCategory getByCatgyAndChain_PrevAndNext(Session session,
		GEMStdCategory gemStdCategory, long categoryId, String chainCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATGYANDCHAIN_CATEGORYID_2);

		boolean bindChainCode = false;

		if (chainCode == null) {
			query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_1);
		}
		else if (chainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_3);
		}
		else {
			bindChainCode = true;

			query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_2);
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
			query.append(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (bindChainCode) {
			qPos.add(chainCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemStdCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMStdCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m std categories where categoryId = &#63; and chainCode = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCatgyAndChain(long categoryId, String chainCode)
		throws SystemException {
		for (GEMStdCategory gemStdCategory : findByCatgyAndChain(categoryId,
				chainCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemStdCategory);
		}
	}

	/**
	 * Returns the number of g e m std categories where categoryId = &#63; and chainCode = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param chainCode the chain code
	 * @return the number of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCatgyAndChain(long categoryId, String chainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATGYANDCHAIN;

		Object[] finderArgs = new Object[] { categoryId, chainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATGYANDCHAIN_CATEGORYID_2);

			boolean bindChainCode = false;

			if (chainCode == null) {
				query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_1);
			}
			else if (chainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_3);
			}
			else {
				bindChainCode = true;

				query.append(_FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATGYANDCHAIN_CATEGORYID_2 = "gemStdCategory.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_1 = "gemStdCategory.chainCode IS NULL";
	private static final String _FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_2 = "gemStdCategory.chainCode = ?";
	private static final String _FINDER_COLUMN_CATGYANDCHAIN_CHAINCODE_3 = "(gemStdCategory.chainCode IS NULL OR gemStdCategory.chainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED,
			GEMStdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] { Long.class.getName() },
			GEMStdCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m std categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCategoryId(long categoryId)
		throws SystemException {
		return findByCategoryId(categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m std categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @return the range of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCategoryId(long categoryId, int start,
		int end) throws SystemException {
		return findByCategoryId(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m std categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findByCategoryId(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<GEMStdCategory> list = (List<GEMStdCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMStdCategory gemStdCategory : list) {
				if ((categoryId != gemStdCategory.getCategoryId())) {
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

			query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMStdCategory>(list);
				}
				else {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
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
	 * Returns the first g e m std category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByCategoryId_First(categoryId,
				orderByComparator);

		if (gemStdCategory != null) {
			return gemStdCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMStdCategoryException(msg.toString());
	}

	/**
	 * Returns the first g e m std category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMStdCategory> list = findByCategoryId(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m std category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByCategoryId_Last(categoryId,
				orderByComparator);

		if (gemStdCategory != null) {
			return gemStdCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMStdCategoryException(msg.toString());
	}

	/**
	 * Returns the last g e m std category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryId(categoryId);

		if (count == 0) {
			return null;
		}

		List<GEMStdCategory> list = findByCategoryId(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m std categories before and after the current g e m std category in the ordered set where categoryId = &#63;.
	 *
	 * @param gemStdCategoryId the primary key of the current g e m std category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory[] findByCategoryId_PrevAndNext(
		long gemStdCategoryId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = findByPrimaryKey(gemStdCategoryId);

		Session session = null;

		try {
			session = openSession();

			GEMStdCategory[] array = new GEMStdCategoryImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session, gemStdCategory,
					categoryId, orderByComparator, true);

			array[1] = gemStdCategory;

			array[2] = getByCategoryId_PrevAndNext(session, gemStdCategory,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMStdCategory getByCategoryId_PrevAndNext(Session session,
		GEMStdCategory gemStdCategory, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMSTDCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
			query.append(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemStdCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMStdCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m std categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryId(long categoryId) throws SystemException {
		for (GEMStdCategory gemStdCategory : findByCategoryId(categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemStdCategory);
		}
	}

	/**
	 * Returns the number of g e m std categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryId(long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMSTDCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "gemStdCategory.categoryId = ?";

	public GEMStdCategoryPersistenceImpl() {
		setModelClass(GEMStdCategory.class);
	}

	/**
	 * Caches the g e m std category in the entity cache if it is enabled.
	 *
	 * @param gemStdCategory the g e m std category
	 */
	@Override
	public void cacheResult(GEMStdCategory gemStdCategory) {
		EntityCacheUtil.putResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryImpl.class, gemStdCategory.getPrimaryKey(),
			gemStdCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
			new Object[] {
				gemStdCategory.getStdId(), gemStdCategory.getCategoryId(),
				gemStdCategory.getTemplateType(), gemStdCategory.getChainCode()
			}, gemStdCategory);

		gemStdCategory.resetOriginalValues();
	}

	/**
	 * Caches the g e m std categories in the entity cache if it is enabled.
	 *
	 * @param gemStdCategories the g e m std categories
	 */
	@Override
	public void cacheResult(List<GEMStdCategory> gemStdCategories) {
		for (GEMStdCategory gemStdCategory : gemStdCategories) {
			if (EntityCacheUtil.getResult(
						GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
						GEMStdCategoryImpl.class, gemStdCategory.getPrimaryKey()) == null) {
				cacheResult(gemStdCategory);
			}
			else {
				gemStdCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m std categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMStdCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMStdCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m std category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMStdCategory gemStdCategory) {
		EntityCacheUtil.removeResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryImpl.class, gemStdCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemStdCategory);
	}

	@Override
	public void clearCache(List<GEMStdCategory> gemStdCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMStdCategory gemStdCategory : gemStdCategories) {
			EntityCacheUtil.removeResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
				GEMStdCategoryImpl.class, gemStdCategory.getPrimaryKey());

			clearUniqueFindersCache(gemStdCategory);
		}
	}

	protected void cacheUniqueFindersCache(GEMStdCategory gemStdCategory) {
		if (gemStdCategory.isNew()) {
			Object[] args = new Object[] {
					gemStdCategory.getStdId(), gemStdCategory.getCategoryId(),
					gemStdCategory.getTemplateType(),
					gemStdCategory.getChainCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDCATGYMAPPING,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
				args, gemStdCategory);
		}
		else {
			GEMStdCategoryModelImpl gemStdCategoryModelImpl = (GEMStdCategoryModelImpl)gemStdCategory;

			if ((gemStdCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDCATGYMAPPING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemStdCategory.getStdId(),
						gemStdCategory.getCategoryId(),
						gemStdCategory.getTemplateType(),
						gemStdCategory.getChainCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDCATGYMAPPING,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
					args, gemStdCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMStdCategory gemStdCategory) {
		GEMStdCategoryModelImpl gemStdCategoryModelImpl = (GEMStdCategoryModelImpl)gemStdCategory;

		Object[] args = new Object[] {
				gemStdCategory.getStdId(), gemStdCategory.getCategoryId(),
				gemStdCategory.getTemplateType(), gemStdCategory.getChainCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDCATGYMAPPING, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING, args);

		if ((gemStdCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDCATGYMAPPING.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemStdCategoryModelImpl.getOriginalStdId(),
					gemStdCategoryModelImpl.getOriginalCategoryId(),
					gemStdCategoryModelImpl.getOriginalTemplateType(),
					gemStdCategoryModelImpl.getOriginalChainCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDCATGYMAPPING,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDCATGYMAPPING,
				args);
		}
	}

	/**
	 * Creates a new g e m std category with the primary key. Does not add the g e m std category to the database.
	 *
	 * @param gemStdCategoryId the primary key for the new g e m std category
	 * @return the new g e m std category
	 */
	@Override
	public GEMStdCategory create(long gemStdCategoryId) {
		GEMStdCategory gemStdCategory = new GEMStdCategoryImpl();

		gemStdCategory.setNew(true);
		gemStdCategory.setPrimaryKey(gemStdCategoryId);

		return gemStdCategory;
	}

	/**
	 * Removes the g e m std category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gemStdCategoryId the primary key of the g e m std category
	 * @return the g e m std category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory remove(long gemStdCategoryId)
		throws NoSuchGEMStdCategoryException, SystemException {
		return remove((Serializable)gemStdCategoryId);
	}

	/**
	 * Removes the g e m std category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m std category
	 * @return the g e m std category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory remove(Serializable primaryKey)
		throws NoSuchGEMStdCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMStdCategory gemStdCategory = (GEMStdCategory)session.get(GEMStdCategoryImpl.class,
					primaryKey);

			if (gemStdCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMStdCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemStdCategory);
		}
		catch (NoSuchGEMStdCategoryException nsee) {
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
	protected GEMStdCategory removeImpl(GEMStdCategory gemStdCategory)
		throws SystemException {
		gemStdCategory = toUnwrappedModel(gemStdCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemStdCategory)) {
				gemStdCategory = (GEMStdCategory)session.get(GEMStdCategoryImpl.class,
						gemStdCategory.getPrimaryKeyObj());
			}

			if (gemStdCategory != null) {
				session.delete(gemStdCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemStdCategory != null) {
			clearCache(gemStdCategory);
		}

		return gemStdCategory;
	}

	@Override
	public GEMStdCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory)
		throws SystemException {
		gemStdCategory = toUnwrappedModel(gemStdCategory);

		boolean isNew = gemStdCategory.isNew();

		GEMStdCategoryModelImpl gemStdCategoryModelImpl = (GEMStdCategoryModelImpl)gemStdCategory;

		Session session = null;

		try {
			session = openSession();

			if (gemStdCategory.isNew()) {
				session.save(gemStdCategory);

				gemStdCategory.setNew(false);
			}
			else {
				session.merge(gemStdCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMStdCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemStdCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemStdCategoryModelImpl.getOriginalCategoryId(),
						gemStdCategoryModelImpl.getOriginalTemplateType(),
						gemStdCategoryModelImpl.getOriginalChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATGYTEMPLATEANDCHAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN,
					args);

				args = new Object[] {
						gemStdCategoryModelImpl.getCategoryId(),
						gemStdCategoryModelImpl.getTemplateType(),
						gemStdCategoryModelImpl.getChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATGYTEMPLATEANDCHAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYTEMPLATEANDCHAIN,
					args);
			}

			if ((gemStdCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYANDCHAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemStdCategoryModelImpl.getOriginalCategoryId(),
						gemStdCategoryModelImpl.getOriginalChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATGYANDCHAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYANDCHAIN,
					args);

				args = new Object[] {
						gemStdCategoryModelImpl.getCategoryId(),
						gemStdCategoryModelImpl.getChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATGYANDCHAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATGYANDCHAIN,
					args);
			}

			if ((gemStdCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemStdCategoryModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] { gemStdCategoryModelImpl.getCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			GEMStdCategoryImpl.class, gemStdCategory.getPrimaryKey(),
			gemStdCategory);

		clearUniqueFindersCache(gemStdCategory);
		cacheUniqueFindersCache(gemStdCategory);

		return gemStdCategory;
	}

	protected GEMStdCategory toUnwrappedModel(GEMStdCategory gemStdCategory) {
		if (gemStdCategory instanceof GEMStdCategoryImpl) {
			return gemStdCategory;
		}

		GEMStdCategoryImpl gemStdCategoryImpl = new GEMStdCategoryImpl();

		gemStdCategoryImpl.setNew(gemStdCategory.isNew());
		gemStdCategoryImpl.setPrimaryKey(gemStdCategory.getPrimaryKey());

		gemStdCategoryImpl.setGemStdCategoryId(gemStdCategory.getGemStdCategoryId());
		gemStdCategoryImpl.setStdId(gemStdCategory.getStdId());
		gemStdCategoryImpl.setCategoryId(gemStdCategory.getCategoryId());
		gemStdCategoryImpl.setTemplateType(gemStdCategory.getTemplateType());
		gemStdCategoryImpl.setChainCode(gemStdCategory.getChainCode());
		gemStdCategoryImpl.setCreatorId(gemStdCategory.getCreatorId());
		gemStdCategoryImpl.setCreatedDate(gemStdCategory.getCreatedDate());
		gemStdCategoryImpl.setUpdatedBy(gemStdCategory.getUpdatedBy());
		gemStdCategoryImpl.setUpdatedDate(gemStdCategory.getUpdatedDate());

		return gemStdCategoryImpl;
	}

	/**
	 * Returns the g e m std category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m std category
	 * @return the g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMStdCategoryException, SystemException {
		GEMStdCategory gemStdCategory = fetchByPrimaryKey(primaryKey);

		if (gemStdCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMStdCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemStdCategory;
	}

	/**
	 * Returns the g e m std category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMStdCategoryException} if it could not be found.
	 *
	 * @param gemStdCategoryId the primary key of the g e m std category
	 * @return the g e m std category
	 * @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory findByPrimaryKey(long gemStdCategoryId)
		throws NoSuchGEMStdCategoryException, SystemException {
		return findByPrimaryKey((Serializable)gemStdCategoryId);
	}

	/**
	 * Returns the g e m std category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m std category
	 * @return the g e m std category, or <code>null</code> if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMStdCategory gemStdCategory = (GEMStdCategory)EntityCacheUtil.getResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
				GEMStdCategoryImpl.class, primaryKey);

		if (gemStdCategory == _nullGEMStdCategory) {
			return null;
		}

		if (gemStdCategory == null) {
			Session session = null;

			try {
				session = openSession();

				gemStdCategory = (GEMStdCategory)session.get(GEMStdCategoryImpl.class,
						primaryKey);

				if (gemStdCategory != null) {
					cacheResult(gemStdCategory);
				}
				else {
					EntityCacheUtil.putResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
						GEMStdCategoryImpl.class, primaryKey,
						_nullGEMStdCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMStdCategoryModelImpl.ENTITY_CACHE_ENABLED,
					GEMStdCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemStdCategory;
	}

	/**
	 * Returns the g e m std category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gemStdCategoryId the primary key of the g e m std category
	 * @return the g e m std category, or <code>null</code> if a g e m std category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMStdCategory fetchByPrimaryKey(long gemStdCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)gemStdCategoryId);
	}

	/**
	 * Returns all the g e m std categories.
	 *
	 * @return the g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m std categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @return the range of g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m std categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m std categories
	 * @param end the upper bound of the range of g e m std categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m std categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMStdCategory> findAll(int start, int end,
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

		List<GEMStdCategory> list = (List<GEMStdCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMSTDCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMSTDCATEGORY;

				if (pagination) {
					sql = sql.concat(GEMStdCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMStdCategory>(list);
				}
				else {
					list = (List<GEMStdCategory>)QueryUtil.list(q,
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
	 * Removes all the g e m std categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMStdCategory gemStdCategory : findAll()) {
			remove(gemStdCategory);
		}
	}

	/**
	 * Returns the number of g e m std categories.
	 *
	 * @return the number of g e m std categories
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

				Query q = session.createQuery(_SQL_COUNT_GEMSTDCATEGORY);

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
	 * Initializes the g e m std category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMStdCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMStdCategory>> listenersList = new ArrayList<ModelListener<GEMStdCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMStdCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMStdCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMSTDCATEGORY = "SELECT gemStdCategory FROM GEMStdCategory gemStdCategory";
	private static final String _SQL_SELECT_GEMSTDCATEGORY_WHERE = "SELECT gemStdCategory FROM GEMStdCategory gemStdCategory WHERE ";
	private static final String _SQL_COUNT_GEMSTDCATEGORY = "SELECT COUNT(gemStdCategory) FROM GEMStdCategory gemStdCategory";
	private static final String _SQL_COUNT_GEMSTDCATEGORY_WHERE = "SELECT COUNT(gemStdCategory) FROM GEMStdCategory gemStdCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemStdCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMStdCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMStdCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMStdCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"gemStdCategoryId", "stdId", "categoryId", "templateType",
				"chainCode", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static GEMStdCategory _nullGEMStdCategory = new GEMStdCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMStdCategory> toCacheModel() {
				return _nullGEMStdCategoryCacheModel;
			}
		};

	private static CacheModel<GEMStdCategory> _nullGEMStdCategoryCacheModel = new CacheModel<GEMStdCategory>() {
			@Override
			public GEMStdCategory toEntityModel() {
				return _nullGEMStdCategory;
			}
		};
}