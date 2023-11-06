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

import com.ihg.brandstandards.db.model.StandardsStatus;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsStatusPersistenceImpl
 * @see StandardsStatusUtil
 * @generated
 */
public interface StandardsStatusPersistence extends BasePersistence<StandardsStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsStatusUtil} to access the standards status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards statuses where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findByRegionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards statuses where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @return the range of matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findByRegionId(
		long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards statuses where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findByRegionId(
		long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards status in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus findByRegionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards status in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards status, or <code>null</code> if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus fetchByRegionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards status in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus findByRegionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards status in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards status, or <code>null</code> if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus fetchByRegionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards statuses before and after the current standards status in the ordered set where regionId = &#63;.
	*
	* @param statusId the primary key of the current standards status
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus[] findByRegionId_PrevAndNext(
		long statusId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards statuses where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRegionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards statuses where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByRegionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards statuses where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @return the matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findByStatusCode(
		java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards statuses where statusCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCode the status code
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @return the range of matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findByStatusCode(
		java.lang.String statusCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards statuses where statusCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCode the status code
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findByStatusCode(
		java.lang.String statusCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards status in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus findByStatusCode_First(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards status in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards status, or <code>null</code> if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus fetchByStatusCode_First(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards status in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus findByStatusCode_Last(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards status in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards status, or <code>null</code> if a matching standards status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus fetchByStatusCode_Last(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards statuses before and after the current standards status in the ordered set where statusCode = &#63;.
	*
	* @param statusId the primary key of the current standards status
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus[] findByStatusCode_PrevAndNext(
		long statusId, java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards statuses where statusCode = &#63; from the database.
	*
	* @param statusCode the status code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusCode(java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards statuses where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @return the number of matching standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusCode(java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards status in the entity cache if it is enabled.
	*
	* @param standardsStatus the standards status
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsStatus standardsStatus);

	/**
	* Caches the standards statuses in the entity cache if it is enabled.
	*
	* @param standardsStatuses the standards statuses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> standardsStatuses);

	/**
	* Creates a new standards status with the primary key. Does not add the standards status to the database.
	*
	* @param statusId the primary key for the new standards status
	* @return the new standards status
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus create(long statusId);

	/**
	* Removes the standards status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statusId the primary key of the standards status
	* @return the standards status that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus remove(long statusId)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsStatus updateImpl(
		com.ihg.brandstandards.db.model.StandardsStatus standardsStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards status with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsStatusException} if it could not be found.
	*
	* @param statusId the primary key of the standards status
	* @return the standards status
	* @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus findByPrimaryKey(
		long statusId)
		throws com.ihg.brandstandards.db.NoSuchStandardsStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param statusId the primary key of the standards status
	* @return the standards status, or <code>null</code> if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsStatus fetchByPrimaryKey(
		long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards statuses.
	*
	* @return the standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @return the range of standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards statuses.
	*
	* @return the number of standards statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}