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

import com.ihg.brandstandards.db.model.FlagCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the flag category service. This utility wraps {@link FlagCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see FlagCategoryPersistence
 * @see FlagCategoryPersistenceImpl
 * @generated
 */
public class FlagCategoryUtil {
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
	public static void clearCache(FlagCategory flagCategory) {
		getPersistence().clearCache(flagCategory);
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
	public static List<FlagCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlagCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlagCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlagCategory update(FlagCategory flagCategory)
		throws SystemException {
		return getPersistence().update(flagCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlagCategory update(FlagCategory flagCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(flagCategory, serviceContext);
	}

	/**
	* Returns all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @return the matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findByparentCatId(
		long parentCatId, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentCatId(parentCatId, activeInd);
	}

	/**
	* Returns a range of all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findByparentCatId(
		long parentCatId, java.lang.String activeInd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentCatId(parentCatId, activeInd, start, end);
	}

	/**
	* Returns an ordered range of all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findByparentCatId(
		long parentCatId, java.lang.String activeInd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentCatId(parentCatId, activeInd, start, end,
			orderByComparator);
	}

	/**
	* Returns the first flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory findByparentCatId_First(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentCatId_First(parentCatId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the first flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory fetchByparentCatId_First(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentCatId_First(parentCatId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the last flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory findByparentCatId_Last(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentCatId_Last(parentCatId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the last flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory fetchByparentCatId_Last(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentCatId_Last(parentCatId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the flag categories before and after the current flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param flagCategoryPK the primary key of the current flag category
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory[] findByparentCatId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK,
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentCatId_PrevAndNext(flagCategoryPK, parentCatId,
			activeInd, orderByComparator);
	}

	/**
	* Removes all the flag categories where parentCatId = &#63; and activeInd = &#63; from the database.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentCatId(long parentCatId,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByparentCatId(parentCatId, activeInd);
	}

	/**
	* Returns the number of flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @return the number of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentCatId(long parentCatId,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByparentCatId(parentCatId, activeInd);
	}

	/**
	* Returns all the flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @return the matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findBycatOrField(
		java.lang.String catOrField, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycatOrField(catOrField, activeInd);
	}

	/**
	* Returns a range of all the flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findBycatOrField(
		java.lang.String catOrField, java.lang.String activeInd, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycatOrField(catOrField, activeInd, start, end);
	}

	/**
	* Returns an ordered range of all the flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findBycatOrField(
		java.lang.String catOrField, java.lang.String activeInd, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycatOrField(catOrField, activeInd, start, end,
			orderByComparator);
	}

	/**
	* Returns the first flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory findBycatOrField_First(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycatOrField_First(catOrField, activeInd,
			orderByComparator);
	}

	/**
	* Returns the first flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory fetchBycatOrField_First(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycatOrField_First(catOrField, activeInd,
			orderByComparator);
	}

	/**
	* Returns the last flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory findBycatOrField_Last(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycatOrField_Last(catOrField, activeInd,
			orderByComparator);
	}

	/**
	* Returns the last flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory fetchBycatOrField_Last(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycatOrField_Last(catOrField, activeInd,
			orderByComparator);
	}

	/**
	* Returns the flag categories before and after the current flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param flagCategoryPK the primary key of the current flag category
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory[] findBycatOrField_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK,
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycatOrField_PrevAndNext(flagCategoryPK, catOrField,
			activeInd, orderByComparator);
	}

	/**
	* Removes all the flag categories where catOrField = &#63; and activeInd = &#63; from the database.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycatOrField(java.lang.String catOrField,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycatOrField(catOrField, activeInd);
	}

	/**
	* Returns the number of flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @return the number of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycatOrField(java.lang.String catOrField,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycatOrField(catOrField, activeInd);
	}

	/**
	* Caches the flag category in the entity cache if it is enabled.
	*
	* @param flagCategory the flag category
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory) {
		getPersistence().cacheResult(flagCategory);
	}

	/**
	* Caches the flag categories in the entity cache if it is enabled.
	*
	* @param flagCategories the flag categories
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.FlagCategory> flagCategories) {
		getPersistence().cacheResult(flagCategories);
	}

	/**
	* Creates a new flag category with the primary key. Does not add the flag category to the database.
	*
	* @param flagCategoryPK the primary key for the new flag category
	* @return the new flag category
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory create(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK) {
		return getPersistence().create(flagCategoryPK);
	}

	/**
	* Removes the flag category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory remove(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(flagCategoryPK);
	}

	public static com.ihg.brandstandards.db.model.FlagCategory updateImpl(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flagCategory);
	}

	/**
	* Returns the flag category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchFlagCategoryException} if it could not be found.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(flagCategoryPK);
	}

	/**
	* Returns the flag category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category, or <code>null</code> if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(flagCategoryPK);
	}

	/**
	* Returns all the flag categories.
	*
	* @return the flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the flag categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the flag categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flag categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flag categories.
	*
	* @return the number of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlagCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlagCategoryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					FlagCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(FlagCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FlagCategoryPersistence persistence) {
	}

	private static FlagCategoryPersistence _persistence;
}