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

import com.ihg.brandstandards.db.model.GEMCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m category service. This utility wraps {@link GEMCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMCategoryPersistence
 * @see GEMCategoryPersistenceImpl
 * @generated
 */
public class GEMCategoryUtil {
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
	public static void clearCache(GEMCategory gemCategory) {
		getPersistence().clearCache(gemCategory);
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
	public static List<GEMCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMCategory update(GEMCategory gemCategory)
		throws SystemException {
		return getPersistence().update(gemCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMCategory update(GEMCategory gemCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemCategory, serviceContext);
	}

	/**
	* Returns the g e m category where cmsCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	*
	* @param cmsCategoryId the cms category ID
	* @return the matching g e m category
	* @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory findByCMSCategoryId(
		long cmsCategoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMSCategoryId(cmsCategoryId);
	}

	/**
	* Returns the g e m category where cmsCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cmsCategoryId the cms category ID
	* @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByCMSCategoryId(
		long cmsCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCMSCategoryId(cmsCategoryId);
	}

	/**
	* Returns the g e m category where cmsCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cmsCategoryId the cms category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByCMSCategoryId(
		long cmsCategoryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCMSCategoryId(cmsCategoryId, retrieveFromCache);
	}

	/**
	* Removes the g e m category where cmsCategoryId = &#63; from the database.
	*
	* @param cmsCategoryId the cms category ID
	* @return the g e m category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory removeByCMSCategoryId(
		long cmsCategoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCMSCategoryId(cmsCategoryId);
	}

	/**
	* Returns the number of g e m categories where cmsCategoryId = &#63;.
	*
	* @param cmsCategoryId the cms category ID
	* @return the number of matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCMSCategoryId(long cmsCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCMSCategoryId(cmsCategoryId);
	}

	/**
	* Returns the g e m category where gemCategoryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	*
	* @param gemCategoryCode the gem category code
	* @return the matching g e m category
	* @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory findByGEMCategoryId(
		java.lang.String gemCategoryCode)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGEMCategoryId(gemCategoryCode);
	}

	/**
	* Returns the g e m category where gemCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param gemCategoryCode the gem category code
	* @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByGEMCategoryId(
		java.lang.String gemCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGEMCategoryId(gemCategoryCode);
	}

	/**
	* Returns the g e m category where gemCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param gemCategoryCode the gem category code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByGEMCategoryId(
		java.lang.String gemCategoryCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGEMCategoryId(gemCategoryCode, retrieveFromCache);
	}

	/**
	* Removes the g e m category where gemCategoryCode = &#63; from the database.
	*
	* @param gemCategoryCode the gem category code
	* @return the g e m category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory removeByGEMCategoryId(
		java.lang.String gemCategoryCode)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByGEMCategoryId(gemCategoryCode);
	}

	/**
	* Returns the number of g e m categories where gemCategoryCode = &#63;.
	*
	* @param gemCategoryCode the gem category code
	* @return the number of matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGEMCategoryId(java.lang.String gemCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGEMCategoryId(gemCategoryCode);
	}

	/**
	* Returns all the g e m categories where gemPrntCategoryId = &#63;.
	*
	* @param gemPrntCategoryId the gem prnt category ID
	* @return the matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findByGemPrntCategoryId(
		java.lang.String gemPrntCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGemPrntCategoryId(gemPrntCategoryId);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findByGemPrntCategoryId(
		java.lang.String gemPrntCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGemPrntCategoryId(gemPrntCategoryId, start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findByGemPrntCategoryId(
		java.lang.String gemPrntCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGemPrntCategoryId(gemPrntCategoryId, start, end,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMCategory findByGemPrntCategoryId_First(
		java.lang.String gemPrntCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGemPrntCategoryId_First(gemPrntCategoryId,
			orderByComparator);
	}

	/**
	* Returns the first g e m category in the ordered set where gemPrntCategoryId = &#63;.
	*
	* @param gemPrntCategoryId the gem prnt category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByGemPrntCategoryId_First(
		java.lang.String gemPrntCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGemPrntCategoryId_First(gemPrntCategoryId,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMCategory findByGemPrntCategoryId_Last(
		java.lang.String gemPrntCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGemPrntCategoryId_Last(gemPrntCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last g e m category in the ordered set where gemPrntCategoryId = &#63;.
	*
	* @param gemPrntCategoryId the gem prnt category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByGemPrntCategoryId_Last(
		java.lang.String gemPrntCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGemPrntCategoryId_Last(gemPrntCategoryId,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMCategory[] findByGemPrntCategoryId_PrevAndNext(
		long categoryId, java.lang.String gemPrntCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGemPrntCategoryId_PrevAndNext(categoryId,
			gemPrntCategoryId, orderByComparator);
	}

	/**
	* Removes all the g e m categories where gemPrntCategoryId = &#63; from the database.
	*
	* @param gemPrntCategoryId the gem prnt category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGemPrntCategoryId(
		java.lang.String gemPrntCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGemPrntCategoryId(gemPrntCategoryId);
	}

	/**
	* Returns the number of g e m categories where gemPrntCategoryId = &#63;.
	*
	* @param gemPrntCategoryId the gem prnt category ID
	* @return the number of matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGemPrntCategoryId(
		java.lang.String gemPrntCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGemPrntCategoryId(gemPrntCategoryId);
	}

	/**
	* Returns all the g e m categories where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findByCategoryName(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(categoryName);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findByCategoryName(
		java.lang.String categoryName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(categoryName, start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findByCategoryName(
		java.lang.String categoryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(categoryName, start, end,
			orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMCategory findByCategoryName_First(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName_First(categoryName, orderByComparator);
	}

	/**
	* Returns the first g e m category in the ordered set where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByCategoryName_First(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_First(categoryName, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMCategory findByCategoryName_Last(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName_Last(categoryName, orderByComparator);
	}

	/**
	* Returns the last g e m category in the ordered set where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByCategoryName_Last(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_Last(categoryName, orderByComparator);
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
	public static com.ihg.brandstandards.db.model.GEMCategory[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName_PrevAndNext(categoryId, categoryName,
			orderByComparator);
	}

	/**
	* Removes all the g e m categories where categoryName = &#63; from the database.
	*
	* @param categoryName the category name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryName(categoryName);
	}

	/**
	* Returns the number of g e m categories where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryName(categoryName);
	}

	/**
	* Returns the g e m category where gemCategoryCode = &#63; and categoryName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	*
	* @param gemCategoryCode the gem category code
	* @param categoryName the category name
	* @return the matching g e m category
	* @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory findByGEMCategoryIdAndName(
		java.lang.String gemCategoryCode, java.lang.String categoryName)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGEMCategoryIdAndName(gemCategoryCode, categoryName);
	}

	/**
	* Returns the g e m category where gemCategoryCode = &#63; and categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param gemCategoryCode the gem category code
	* @param categoryName the category name
	* @return the matching g e m category, or <code>null</code> if a matching g e m category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByGEMCategoryIdAndName(
		java.lang.String gemCategoryCode, java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGEMCategoryIdAndName(gemCategoryCode, categoryName);
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
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByGEMCategoryIdAndName(
		java.lang.String gemCategoryCode, java.lang.String categoryName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGEMCategoryIdAndName(gemCategoryCode, categoryName,
			retrieveFromCache);
	}

	/**
	* Removes the g e m category where gemCategoryCode = &#63; and categoryName = &#63; from the database.
	*
	* @param gemCategoryCode the gem category code
	* @param categoryName the category name
	* @return the g e m category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory removeByGEMCategoryIdAndName(
		java.lang.String gemCategoryCode, java.lang.String categoryName)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByGEMCategoryIdAndName(gemCategoryCode, categoryName);
	}

	/**
	* Returns the number of g e m categories where gemCategoryCode = &#63; and categoryName = &#63;.
	*
	* @param gemCategoryCode the gem category code
	* @param categoryName the category name
	* @return the number of matching g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGEMCategoryIdAndName(
		java.lang.String gemCategoryCode, java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGEMCategoryIdAndName(gemCategoryCode, categoryName);
	}

	/**
	* Caches the g e m category in the entity cache if it is enabled.
	*
	* @param gemCategory the g e m category
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMCategory gemCategory) {
		getPersistence().cacheResult(gemCategory);
	}

	/**
	* Caches the g e m categories in the entity cache if it is enabled.
	*
	* @param gemCategories the g e m categories
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMCategory> gemCategories) {
		getPersistence().cacheResult(gemCategories);
	}

	/**
	* Creates a new g e m category with the primary key. Does not add the g e m category to the database.
	*
	* @param categoryId the primary key for the new g e m category
	* @return the new g e m category
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the g e m category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the g e m category
	* @return the g e m category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory remove(
		long categoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(categoryId);
	}

	public static com.ihg.brandstandards.db.model.GEMCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMCategory gemCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemCategory);
	}

	/**
	* Returns the g e m category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the g e m category
	* @return the g e m category
	* @throws com.ihg.brandstandards.db.NoSuchGEMCategoryException if a g e m category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory findByPrimaryKey(
		long categoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the g e m category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the g e m category
	* @return the g e m category, or <code>null</code> if a g e m category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the g e m categories.
	*
	* @return the g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m categories.
	*
	* @return the number of g e m categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMCategoryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMCategoryPersistence persistence) {
	}

	private static GEMCategoryPersistence _persistence;
}