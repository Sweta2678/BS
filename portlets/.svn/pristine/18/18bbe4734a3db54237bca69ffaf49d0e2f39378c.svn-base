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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for JobQueue. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.JobQueueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see JobQueueLocalService
 * @see com.ihg.brandstandards.db.service.base.JobQueueLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.JobQueueLocalServiceImpl
 * @generated
 */
public class JobQueueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.JobQueueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the job queue to the database. Also notifies the appropriate model listeners.
	*
	* @param jobQueue the job queue
	* @return the job queue that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.JobQueue addJobQueue(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJobQueue(jobQueue);
	}

	/**
	* Creates a new job queue with the primary key. Does not add the job queue to the database.
	*
	* @param jobId the primary key for the new job queue
	* @return the new job queue
	*/
	public static com.ihg.brandstandards.db.model.JobQueue createJobQueue(
		long jobId) {
		return getService().createJobQueue(jobId);
	}

	/**
	* Deletes the job queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue that was removed
	* @throws PortalException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.JobQueue deleteJobQueue(
		long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJobQueue(jobId);
	}

	/**
	* Deletes the job queue from the database. Also notifies the appropriate model listeners.
	*
	* @param jobQueue the job queue
	* @return the job queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.JobQueue deleteJobQueue(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJobQueue(jobQueue);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.brandstandards.db.model.JobQueue fetchJobQueue(
		long jobId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchJobQueue(jobId);
	}

	/**
	* Returns the job queue with the primary key.
	*
	* @param jobId the primary key of the job queue
	* @return the job queue
	* @throws PortalException if a job queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.JobQueue getJobQueue(
		long jobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueue(jobId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueues(start, end);
	}

	/**
	* Returns the number of job queues.
	*
	* @return the number of job queues
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobQueuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueuesCount();
	}

	/**
	* Updates the job queue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobQueue the job queue
	* @return the job queue that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.JobQueue updateJobQueue(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJobQueue(jobQueue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static boolean insertJobQueueUsingOraSequence(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metaData, java.lang.String linkURL,
		java.lang.String notificationEmail, java.lang.String createUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .insertJobQueueUsingOraSequence(jobOwner, jobType, metaData,
			linkURL, notificationEmail, createUserId);
	}

	/**
	* This method will add an entry to JOB_QUEUE table.
	*
	* @param jobType This is a String object
	* @param metaData This is a String object
	* @param screenName This is a String object
	* @param notificationEmail This is a String object
	*/
	public static void addNewJobRequest(java.lang.String jobType,
		java.lang.String metaData, java.lang.String screenName,
		java.lang.String notificationEmail) {
		getService()
			.addNewJobRequest(jobType, metaData, screenName, notificationEmail);
	}

	public static com.ihg.brandstandards.db.model.JobQueue addJobQueue(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addJobQueue(jobOwner, jobType, metadata, link,
			notificationEmail, startTime, endTime, status, createdBy,
			createDate, updatedBy, updateDate);
	}

	public static com.ihg.brandstandards.db.model.JobQueue updateJobQueue(
		long jobQueueId, java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateJobQueue(jobQueueId, jobOwner, jobType, metadata,
			link, notificationEmail, startTime, endTime, status, updatedBy);
	}

	public static com.ihg.brandstandards.db.model.JobQueue updateJobQueueStatus(
		long jobQueueId, java.lang.String link, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateJobQueueStatus(jobQueueId, link, startTime, endTime,
			status);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueuesByOwnerAndType(jobOwner, jobType);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobQueuesByOwnerTypeAndStatus(jobOwner, jobType, status);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByType(
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueuesByType(jobType);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByTypeAndStatus(
		java.lang.String jobType, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueuesByTypeAndStatus(jobType, status);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwner(
		java.lang.String jobOwner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueuesByOwner(jobOwner);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerAndStatus(
		java.lang.String jobOwner, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobQueuesByOwnerAndStatus(jobOwner, status);
	}

	public static java.util.List<java.lang.String> getUniqueJobQueTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueJobQueTypes();
	}

	/**
	* This method will return file stored in liferay as byte array.
	*
	* @param fileEntryId
	* @return
	*/
	public static byte[] getFileAsByteStream(long fileEntryId) {
		return getService().getFileAsByteStream(fileEntryId);
	}

	public static byte[] getImageAsByteStream(long igImageId,
		boolean getLargeImage) {
		return getService().getImageAsByteStream(igImageId, getLargeImage);
	}

	/**
	* This method will verify if there is already a record with same metadata and type for a user which is not processed completely (Check for both NEW & IN_PROGRESS).
	*
	* @param xmlMetadata The Job XML Metadata.
	* @param jobOwner The Job Owner.
	* @param jobType The Job Type
	* @return
	*/
	public static boolean isJobQueueExistWithSameMetadata(
		java.lang.String xmlMetadata, java.lang.String jobOwner,
		java.lang.String jobType) {
		return getService()
				   .isJobQueueExistWithSameMetadata(xmlMetadata, jobOwner,
			jobType);
	}

	/**
	* This method will verify if there is already a record with same metadata and type for a user which is not processed completely.
	*
	* @param xmlMetadata The Job XML Metadata.
	* @param jobOwner The Job Owner. you can pass % if don't want to compare with owner.
	* @param jobType The Job Type
	* @param jobStatus The comma separated statuses.
	* @return
	*/
	public static boolean isJobQueueExistWithSameMetadata(
		java.lang.String xmlMetadata, java.lang.String jobOwner,
		java.lang.String jobType, java.lang.String jobStatus) {
		return getService()
				   .isJobQueueExistWithSameMetadata(xmlMetadata, jobOwner,
			jobType, jobStatus);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesExceptFullManuals() {
		return getService().getJobQueuesExceptFullManuals();
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearService() {
		_service = null;
	}

	public static JobQueueLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JobQueueLocalService.class.getName());

			if (invokableLocalService instanceof JobQueueLocalService) {
				_service = (JobQueueLocalService)invokableLocalService;
			}
			else {
				_service = new JobQueueLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(JobQueueLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JobQueueLocalService service) {
	}

	private static JobQueueLocalService _service;
}