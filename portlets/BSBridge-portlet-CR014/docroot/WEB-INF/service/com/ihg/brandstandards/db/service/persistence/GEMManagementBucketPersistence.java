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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m management bucket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementBucketPersistenceImpl
 * @see GEMManagementBucketUtil
 * @generated
 */
public interface GEMManagementBucketPersistence extends BasePersistence<GEMManagementBucket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMManagementBucketUtil} to access the g e m management bucket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g e m management buckets where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentId(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.GEMManagementBucket[] findByDepartmentId_PrevAndNext(
		long bucketId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m management buckets where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m management buckets where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @return the matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, java.lang.String activeInd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, java.lang.String activeInd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentIdAndStatus_First(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentIdAndStatus_First(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.GEMManagementBucket findByDepartmentIdAndStatus_Last(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket fetchByDepartmentIdAndStatus_Last(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.GEMManagementBucket[] findByDepartmentIdAndStatus_PrevAndNext(
		long bucketId, long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m management buckets where departmentId = &#63; and activeInd = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentIdAndStatus(long departmentId,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	*
	* @param departmentId the department ID
	* @param activeInd the active ind
	* @return the number of matching g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentIdAndStatus(long departmentId,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m management bucket in the entity cache if it is enabled.
	*
	* @param gemManagementBucket the g e m management bucket
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMManagementBucket gemManagementBucket);

	/**
	* Caches the g e m management buckets in the entity cache if it is enabled.
	*
	* @param gemManagementBuckets the g e m management buckets
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> gemManagementBuckets);

	/**
	* Creates a new g e m management bucket with the primary key. Does not add the g e m management bucket to the database.
	*
	* @param bucketId the primary key for the new g e m management bucket
	* @return the new g e m management bucket
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket create(
		long bucketId);

	/**
	* Removes the g e m management bucket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bucketId the primary key of the g e m management bucket
	* @return the g e m management bucket that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket remove(
		long bucketId)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMManagementBucket updateImpl(
		com.ihg.brandstandards.db.model.GEMManagementBucket gemManagementBucket)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m management bucket with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementBucketException} if it could not be found.
	*
	* @param bucketId the primary key of the g e m management bucket
	* @return the g e m management bucket
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket findByPrimaryKey(
		long bucketId)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m management bucket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bucketId the primary key of the g e m management bucket
	* @return the g e m management bucket, or <code>null</code> if a g e m management bucket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementBucket fetchByPrimaryKey(
		long bucketId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m management buckets.
	*
	* @return the g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementBucket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m management buckets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m management buckets.
	*
	* @return the number of g e m management buckets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}