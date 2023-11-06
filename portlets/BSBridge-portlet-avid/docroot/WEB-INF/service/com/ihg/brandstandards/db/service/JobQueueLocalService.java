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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for JobQueue. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mummanedi
 * @see JobQueueLocalServiceUtil
 * @see com.ihg.brandstandards.db.service.base.JobQueueLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.JobQueueLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface JobQueueLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobQueueLocalServiceUtil} to access the job queue local service. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.JobQueueLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the job queue to the database. Also notifies the appropriate model listeners.
	*
	* @param jobQueue the job queue
	* @return the job queue that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue addJobQueue(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new job queue with the primary key. Does not add the job queue to the database.
	*
	* @param jobId the primary key for the new job queue
	* @return the new job queue
	*/
	public com.ihg.brandstandards.db.model.JobQueue createJobQueue(long jobId);

	/**
	* Deletes the job queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue that was removed
	* @throws PortalException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue deleteJobQueue(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the job queue from the database. Also notifies the appropriate model listeners.
	*
	* @param jobQueue the job queue
	* @return the job queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue deleteJobQueue(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.JobQueue fetchJobQueue(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job queue with the primary key.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue
	* @throws PortalException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.JobQueue getJobQueue(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job queues.
	*
	* @return the number of job queues
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getJobQueuesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the job queue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobQueue the job queue
	* @return the job queue that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.JobQueue updateJobQueue(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public boolean insertJobQueueUsingOraSequence(java.lang.String jobOwner,
		java.lang.String jobType, java.lang.String metaData,
		java.lang.String linkURL, java.lang.String notificationEmail,
		java.lang.String createUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This method will add an entry to JOB_QUEUE table.
	*
	* @param jobType This is a String object
	* @param metaData This is a String object
	* @param screenName This is a String object
	* @param notificationEmail This is a String object
	*/
	public void addNewJobRequest(java.lang.String jobType,
		java.lang.String metaData, java.lang.String screenName,
		java.lang.String notificationEmail);

	public com.ihg.brandstandards.db.model.JobQueue addJobQueue(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.JobQueue updateJobQueue(
		long jobQueueId, java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.JobQueue updateJobQueueStatus(
		long jobQueueId, java.lang.String link, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByType(
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByTypeAndStatus(
		java.lang.String jobType, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwner(
		java.lang.String jobOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerAndStatus(
		java.lang.String jobOwner, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getUniqueJobQueTypes()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This method will return file stored in liferay as byte array.
	*
	* @param fileEntryId
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public byte[] getFileAsByteStream(long fileEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public byte[] getImageAsByteStream(long igImageId, boolean getLargeImage);

	/**
	* This method will verify if there is already a record with same metadata and type for a user which is not processed completely (Check for both NEW & IN_PROGRESS).
	*
	* @param xmlMetadata The Job XML Metadata.
	* @param jobOwner The Job Owner.
	* @param jobType The Job Type
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isJobQueueExistWithSameMetadata(
		java.lang.String xmlMetadata, java.lang.String jobOwner,
		java.lang.String jobType);

	/**
	* This method will verify if there is already a record with same metadata and type for a user which is not processed completely.
	*
	* @param xmlMetadata The Job XML Metadata.
	* @param jobOwner The Job Owner. you can pass % if don't want to compare with owner.
	* @param jobType The Job Type
	* @param jobStatus The comma separated statuses.
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isJobQueueExistWithSameMetadata(
		java.lang.String xmlMetadata, java.lang.String jobOwner,
		java.lang.String jobType, java.lang.String jobStatus);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesExceptFullManuals();

	public void clearCache();
}