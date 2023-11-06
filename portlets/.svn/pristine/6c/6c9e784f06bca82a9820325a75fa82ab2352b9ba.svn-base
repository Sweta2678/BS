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

import com.ihg.brandstandards.db.model.GEMStdCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m std category service. This utility wraps {@link GEMStdCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMStdCategoryPersistence
 * @see GEMStdCategoryPersistenceImpl
 * @generated
 */
public class GEMStdCategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GEMStdCategory gemStdCategory) {
		getPersistence().clearCache(gemStdCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GEMStdCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMStdCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMStdCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMStdCategory update(GEMStdCategory gemStdCategory)
		throws SystemException {
		return getPersistence().update(gemStdCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMStdCategory update(GEMStdCategory gemStdCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemStdCategory, serviceContext);
	}

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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode, retrieveFromCache);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory removeByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode);
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
	public static int countByStdCatgyMapping(long stdId, long categoryId,
		java.lang.String templateType, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode);
	}

	/**
	* Returns all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyTemplateAndChain(categoryId, templateType,
			chainCode);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyTemplateAndChain(categoryId, templateType,
			chainCode, start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyTemplateAndChain(categoryId, templateType,
			chainCode, start, end, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyTemplateAndChain_First(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyTemplateAndChain_First(categoryId, templateType,
			chainCode, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyTemplateAndChain_First(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCatgyTemplateAndChain_First(categoryId,
			templateType, chainCode, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyTemplateAndChain_Last(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyTemplateAndChain_Last(categoryId, templateType,
			chainCode, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyTemplateAndChain_Last(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCatgyTemplateAndChain_Last(categoryId, templateType,
			chainCode, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory[] findByCatgyTemplateAndChain_PrevAndNext(
		long gemStdCategoryId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyTemplateAndChain_PrevAndNext(gemStdCategoryId,
			categoryId, templateType, chainCode, orderByComparator);
	}

	/**
	* Removes all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCatgyTemplateAndChain(long categoryId,
		java.lang.String templateType, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCatgyTemplateAndChain(categoryId, templateType, chainCode);
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
	public static int countByCatgyTemplateAndChain(long categoryId,
		java.lang.String templateType, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCatgyTemplateAndChain(categoryId, templateType,
			chainCode);
	}

	/**
	* Returns all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @return the matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyAndChain(
		long categoryId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatgyAndChain(categoryId, chainCode);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyAndChain(
		long categoryId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyAndChain(categoryId, chainCode, start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyAndChain(
		long categoryId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyAndChain(categoryId, chainCode, start, end,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyAndChain_First(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyAndChain_First(categoryId, chainCode,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyAndChain_First(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCatgyAndChain_First(categoryId, chainCode,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyAndChain_Last(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyAndChain_Last(categoryId, chainCode,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyAndChain_Last(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCatgyAndChain_Last(categoryId, chainCode,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory[] findByCatgyAndChain_PrevAndNext(
		long gemStdCategoryId, long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatgyAndChain_PrevAndNext(gemStdCategoryId,
			categoryId, chainCode, orderByComparator);
	}

	/**
	* Removes all the g e m std categories where categoryId = &#63; and chainCode = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCatgyAndChain(long categoryId,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCatgyAndChain(categoryId, chainCode);
	}

	/**
	* Returns the number of g e m std categories where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @return the number of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCatgyAndChain(long categoryId,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCatgyAndChain(categoryId, chainCode);
	}

	/**
	* Returns all the g e m std categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId, start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId(categoryId, start, end, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_First(categoryId, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_Last(categoryId, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMStdCategory[] findByCategoryId_PrevAndNext(
		long gemStdCategoryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_PrevAndNext(gemStdCategoryId, categoryId,
			orderByComparator);
	}

	/**
	* Removes all the g e m std categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId(categoryId);
	}

	/**
	* Returns the number of g e m std categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	* Caches the g e m std category in the entity cache if it is enabled.
	*
	* @param gemStdCategory the g e m std category
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory) {
		getPersistence().cacheResult(gemStdCategory);
	}

	/**
	* Caches the g e m std categories in the entity cache if it is enabled.
	*
	* @param gemStdCategories the g e m std categories
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> gemStdCategories) {
		getPersistence().cacheResult(gemStdCategories);
	}

	/**
	* Creates a new g e m std category with the primary key. Does not add the g e m std category to the database.
	*
	* @param gemStdCategoryId the primary key for the new g e m std category
	* @return the new g e m std category
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory create(
		long gemStdCategoryId) {
		return getPersistence().create(gemStdCategoryId);
	}

	/**
	* Removes the g e m std category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory remove(
		long gemStdCategoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(gemStdCategoryId);
	}

	public static com.ihg.brandstandards.db.model.GEMStdCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemStdCategory);
	}

	/**
	* Returns the g e m std category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMStdCategoryException} if it could not be found.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory findByPrimaryKey(
		long gemStdCategoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(gemStdCategoryId);
	}

	/**
	* Returns the g e m std category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category, or <code>null</code> if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchByPrimaryKey(
		long gemStdCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(gemStdCategoryId);
	}

	/**
	* Returns all the g e m std categories.
	*
	* @return the g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m std categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m std categories.
	*
	* @return the number of g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMStdCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMStdCategoryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMStdCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMStdCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMStdCategoryPersistence persistence) {
	}

	private static GEMStdCategoryPersistence _persistence;
}