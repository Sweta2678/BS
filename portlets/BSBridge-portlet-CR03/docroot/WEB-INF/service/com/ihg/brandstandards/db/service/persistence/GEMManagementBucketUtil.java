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

import com.ihg.brandstandards.db.model.GEMManagementBucket;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m management bucket service. This utility wraps {@link GEMManagementBucketPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementBucketPersistence
 * @see GEMManagementBucketPersistenceImpl
 * @generated
 */
public class GEMManagementBucketUtil {
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
	public static void clearCache(GEMManagementBucket gemManagementBucket) {
		getPersistence().clearCache(gemManagementBucket);
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
	public static List<GEMManagementBucket> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMManagementBucket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMManagementBucket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMManagementBucket update(
		GEMManagementBucket gemManagementBucket) throws SystemException {
		return getPersistence().update(gemManagementBucket);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMManagementBucket update(
		GEMManagementBucket gemManagementBucket, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemManagementBucket, serviceContext);
	}

	/**
	* Returns all the g e m management buckets where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId(departmentId);
	}

	/**
	* Returns a range of all the g e m management buckets where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of g e m management buckets
	* @param end the upper bound of the range of g e m management buckets (not inclusive)
	* @return the range of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentId(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId(departmentId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m management buckets where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of g e m management buckets
	* @param end the upper bound of the range of g e m management buckets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId(departmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_First(departmentId, orderByComparator);
	}

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentId_First(departmentId, orderByComparator);
	}

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentId_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the g e m management buckets before and after the current g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param bucketId the primary key of the current g e m management bucket
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket[] findByDepartmentId_PrevAndNext(
		long bucketId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_PrevAndNext(bucketId, departmentId,
			orderByComparator);
	}

	/**
	* Removes all the g e m management buckets where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentId(departmentId);
	}

	/**
	* Returns the number of g e m management buckets where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartmentId(departmentId);
	}

	/**
	* Returns all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @return the matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentIdAndStatus(departmentId, activeInd);
	}

	/**
	* Returns a range of all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param start the lower bound of the range of g e m management buckets
	* @param end the upper bound of the range of g e m management buckets (not inclusive)
	* @return the range of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, java.lang.String activeInd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentIdAndStatus(departmentId, activeInd, start,
			end);
	}

	/**
	* Returns an ordered range of all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param start the lower bound of the range of g e m management buckets
	* @param end the upper bound of the range of g e m management buckets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, java.lang.String activeInd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentIdAndStatus(departmentId, activeInd, start,
			end, orderByComparator);
	}

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentIdAndStatus_First(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentIdAndStatus_First(departmentId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentIdAndStatus_First(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentIdAndStatus_First(departmentId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentIdAndStatus_Last(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentIdAndStatus_Last(departmentId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentIdAndStatus_Last(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentIdAndStatus_Last(departmentId, activeInd,
			orderByComparator);
	}

	/**
	* Returns the g e m management buckets before and after the current g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param bucketId the primary key of the current g e m management bucket
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket[] findByDepartmentIdAndStatus_PrevAndNext(
		long bucketId, long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentIdAndStatus_PrevAndNext(bucketId,
			departmentId, activeInd, orderByComparator);
	}

	/**
	* Removes all the g e m management buckets where departmentId = &#63; and activeInd = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentIdAndStatus(long departmentId,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentIdAndStatus(departmentId, activeInd);
	}

	/**
	* Returns the number of g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @return the number of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentIdAndStatus(long departmentId,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentIdAndStatus(departmentId, activeInd);
	}

	/**
	* Caches the g e m management bucket in the entity cache if it is enabled.
	*
	* @param gemManagementBucket the g e m management bucket
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMManagementBucket gemManagementBucket) {
		getPersistence().cacheResult(gemManagementBucket);
	}

	/**
	* Caches the g e m management buckets in the entity cache if it is enabled.
	*
	* @param gemManagementBuckets the g e m management buckets
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> gemManagementBuckets) {
		getPersistence().cacheResult(gemManagementBuckets);
	}

	/**
	* Creates a new g e m management bucket with the primary key. Does not add the g e m management bucket to the database.
	*
	* @param bucketId the primary key for the new g e m management bucket
	* @return the new g e m management bucket
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket create(
		long bucketId) {
		return getPersistence().create(bucketId);
	}

	/**
	* Removes the g e m management bucket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bucketId the primary key of the g e m management bucket
	* @return the g e m management bucket that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket remove(
		long bucketId)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bucketId);
	}

	public static com.ihg.brandstandards.db.model.GEMManagementBucket updateImpl(
		com.ihg.brandstandards.db.model.GEMManagementBucket gemManagementBucket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemManagementBucket);
	}

	/**
	* Returns the g e m management bucket with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementBucketException} if it could not be found.
	*
	* @param bucketId the primary key of the g e m management bucket
	* @return the g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket findByPrimaryKey(
		long bucketId)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bucketId);
	}

	/**
	* Returns the g e m management bucket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bucketId the primary key of the g e m management bucket
	* @return the g e m management bucket, or <code>null</code> if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMManagementBucket fetchByPrimaryKey(
		long bucketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bucketId);
	}

	/**
	* Returns all the g e m management buckets.
	*
	* @return the g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m management buckets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m management buckets
	* @param end the upper bound of the range of g e m management buckets (not inclusive)
	* @return the range of g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m management buckets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m management buckets
	* @param end the upper bound of the range of g e m management buckets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m management buckets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m management buckets.
	*
	* @return the number of g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMManagementBucketPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMManagementBucketPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMManagementBucketPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMManagementBucketUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMManagementBucketPersistence persistence) {
	}

	private static GEMManagementBucketPersistence _persistence;
}