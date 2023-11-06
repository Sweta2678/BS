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

import com.ihg.brandstandards.db.model.JobQueue;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the job queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see JobQueuePersistenceImpl
 * @see JobQueueUtil
 * @generated
 */
public interface JobQueuePersistence extends BasePersistence<JobQueue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobQueueUtil} to access the job queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the job queue where jobId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchJobQueueException} if it could not be found.
	*
	* @param jobId the job ID
	* @return the matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobId(long jobId)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queue where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param jobId the job ID
	* @return the matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobId(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queue where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param jobId the job ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobId(long jobId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the job queue where jobId = &#63; from the database.
	*
	* @param jobId the job ID
	* @return the job queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue removeByJobId(long jobId)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobId = &#63;.
	*
	* @param jobId the job ID
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobId(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues where jobOwner = &#63;.
	*
	* @param jobOwner the job owner
	* @return the matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwner(
		java.lang.String jobOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues where jobOwner = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwner(
		java.lang.String jobOwner, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues where jobOwner = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwner(
		java.lang.String jobOwner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63;.
	*
	* @param jobOwner the job owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwner_First(
		java.lang.String jobOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63;.
	*
	* @param jobOwner the job owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwner_First(
		java.lang.String jobOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63;.
	*
	* @param jobOwner the job owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwner_Last(
		java.lang.String jobOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63;.
	*
	* @param jobOwner the job owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwner_Last(
		java.lang.String jobOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63;.
	*
	* @param jobId the primary key of the current job queue
	* @param jobOwner the job owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue[] findByJobOwner_PrevAndNext(
		long jobId, java.lang.String jobOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues where jobOwner = &#63; from the database.
	*
	* @param jobOwner the job owner
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobOwner(java.lang.String jobOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobOwner = &#63;.
	*
	* @param jobOwner the job owner
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobOwner(java.lang.String jobOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues where jobOwner = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @return the matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerAndStatus(
		java.lang.String jobOwner, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues where jobOwner = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param status the status
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerAndStatus(
		java.lang.String jobOwner, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues where jobOwner = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param status the status
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerAndStatus(
		java.lang.String jobOwner, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwnerAndStatus_First(
		java.lang.String jobOwner, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwnerAndStatus_First(
		java.lang.String jobOwner, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwnerAndStatus_Last(
		java.lang.String jobOwner, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwnerAndStatus_Last(
		java.lang.String jobOwner, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	*
	* @param jobId the primary key of the current job queue
	* @param jobOwner the job owner
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue[] findByJobOwnerAndStatus_PrevAndNext(
		long jobId, java.lang.String jobOwner, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues where jobOwner = &#63; and status = &#63; from the database.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobOwnerAndStatus(java.lang.String jobOwner,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobOwner = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param status the status
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobOwnerAndStatus(java.lang.String jobOwner,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues where jobType = &#63;.
	*
	* @param jobType the job type
	* @return the matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobType(
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues where jobType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobType the job type
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobType(
		java.lang.String jobType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues where jobType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobType the job type
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobType(
		java.lang.String jobType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobType_First(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobType_First(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobType_Last(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobType_Last(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queues before and after the current job queue in the ordered set where jobType = &#63;.
	*
	* @param jobId the primary key of the current job queue
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue[] findByJobType_PrevAndNext(
		long jobId, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues where jobType = &#63; from the database.
	*
	* @param jobType the job type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobType(java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobType = &#63;.
	*
	* @param jobType the job type
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobType(java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues where jobType = &#63; and status = &#63;.
	*
	* @param jobType the job type
	* @param status the status
	* @return the matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobTypeAndStatus(
		java.lang.String jobType, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues where jobType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobType the job type
	* @param status the status
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobTypeAndStatus(
		java.lang.String jobType, java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues where jobType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobType the job type
	* @param status the status
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobTypeAndStatus(
		java.lang.String jobType, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobType = &#63; and status = &#63;.
	*
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobTypeAndStatus_First(
		java.lang.String jobType, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobType = &#63; and status = &#63;.
	*
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobTypeAndStatus_First(
		java.lang.String jobType, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobType = &#63; and status = &#63;.
	*
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobTypeAndStatus_Last(
		java.lang.String jobType, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobType = &#63; and status = &#63;.
	*
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobTypeAndStatus_Last(
		java.lang.String jobType, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queues before and after the current job queue in the ordered set where jobType = &#63; and status = &#63;.
	*
	* @param jobId the primary key of the current job queue
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue[] findByJobTypeAndStatus_PrevAndNext(
		long jobId, java.lang.String jobType, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues where jobType = &#63; and status = &#63; from the database.
	*
	* @param jobType the job type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobTypeAndStatus(java.lang.String jobType,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobType = &#63; and status = &#63;.
	*
	* @param jobType the job type
	* @param status the status
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobTypeAndStatus(java.lang.String jobType,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @return the matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues where jobOwner = &#63; and jobType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues where jobOwner = &#63; and jobType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwnerAndType_First(
		java.lang.String jobOwner, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwnerAndType_First(
		java.lang.String jobOwner, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwnerAndType_Last(
		java.lang.String jobOwner, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwnerAndType_Last(
		java.lang.String jobOwner, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobId the primary key of the current job queue
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue[] findByJobOwnerAndType_PrevAndNext(
		long jobId, java.lang.String jobOwner, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues where jobOwner = &#63; and jobType = &#63; from the database.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobOwnerAndType(java.lang.String jobOwner,
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobOwner = &#63; and jobType = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobOwnerAndType(java.lang.String jobOwner,
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @return the matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findByJobOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwnerTypeAndStatus_First(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwnerTypeAndStatus_First(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByJobOwnerTypeAndStatus_Last(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByJobOwnerTypeAndStatus_Last(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobId the primary key of the current job queue
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue[] findByJobOwnerTypeAndStatus_PrevAndNext(
		long jobId, java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63; from the database.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobOwnerTypeAndStatus(java.lang.String jobOwner,
		java.lang.String jobType, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	*
	* @param jobOwner the job owner
	* @param jobType the job type
	* @param status the status
	* @return the number of matching job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobOwnerTypeAndStatus(java.lang.String jobOwner,
		java.lang.String jobType, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the job queue in the entity cache if it is enabled.
	*
	* @param jobQueue the job queue
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.JobQueue jobQueue);

	/**
	* Caches the job queues in the entity cache if it is enabled.
	*
	* @param jobQueues the job queues
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.JobQueue> jobQueues);

	/**
	* Creates a new job queue with the primary key. Does not add the job queue to the database.
	*
	* @param jobId the primary key for the new job queue
	* @return the new job queue
	*/
	public com.ihg.brandstandards.db.model.JobQueue create(long jobId);

	/**
	* Removes the job queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue that was removed
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue remove(long jobId)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.JobQueue updateImpl(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queue with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchJobQueueException} if it could not be found.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue
	* @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue findByPrimaryKey(long jobId)
		throws com.ihg.brandstandards.db.NoSuchJobQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue, or <code>null</code> if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue fetchByPrimaryKey(
		long jobId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job queues.
	*
	* @return the job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @return the range of job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job queues
	* @param end the upper bound of the range of job queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job queues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues.
	*
	* @return the number of job queues
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}