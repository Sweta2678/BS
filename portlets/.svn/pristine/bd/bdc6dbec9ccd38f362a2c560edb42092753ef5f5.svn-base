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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobQueueService}.
 *
 * @author Mummanedi
 * @see JobQueueService
 * @generated
 */
public class JobQueueServiceWrapper implements JobQueueService,
	ServiceWrapper<JobQueueService> {
	public JobQueueServiceWrapper(JobQueueService jobQueueService) {
		_jobQueueService = jobQueueService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jobQueueService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jobQueueService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jobQueueService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.ihg.brandstandards.db.model.JobQueue addJobQueue(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.addJobQueue(jobOwner, jobType, metadata, link,
			notificationEmail, startTime, endTime, status, createdBy,
			createDate, updatedBy, updateDate);
	}

	@Override
	public com.ihg.brandstandards.db.model.JobQueue updateJobQueue(
		long jobQueueId, java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.updateJobQueue(jobQueueId, jobOwner, jobType,
			metadata, link, notificationEmail, startTime, endTime, status,
			updatedBy);
	}

	@Override
	public com.ihg.brandstandards.db.model.JobQueue updateJobQueueStatus(
		long jobQueueId, java.lang.String link, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.updateJobQueueStatus(jobQueueId, link,
			startTime, endTime, status);
	}

	@Override
	public void deleteJobQueue(long jobQueueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_jobQueueService.deleteJobQueue(jobQueueId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getAllJobQueues()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getAllJobQueues();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesExceptFullManuals() {
		return _jobQueueService.getJobQueuesExceptFullManuals();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getJobQueuesByOwnerAndType(jobOwner, jobType);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getJobQueuesByOwnerTypeAndStatus(jobOwner,
			jobType, status);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByType(
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getJobQueuesByType(jobType);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByTypeAndStatus(
		java.lang.String jobType, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getJobQueuesByTypeAndStatus(jobType, status);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesByOwner(
		java.lang.String jobOwner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getJobQueuesByOwner(jobOwner);
	}

	@Override
	public java.util.List<java.lang.String> getUniqueJobQueTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobQueueService.getUniqueJobQueTypes();
	}

	@Override
	public byte[] getFileAsByteStream(long fileEntryId) {
		return _jobQueueService.getFileAsByteStream(fileEntryId);
	}

	@Override
	public byte[] getImageAsByteStream(long imageId, boolean getLargeImage) {
		return _jobQueueService.getImageAsByteStream(imageId, getLargeImage);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JobQueueService getWrappedJobQueueService() {
		return _jobQueueService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJobQueueService(JobQueueService jobQueueService) {
		_jobQueueService = jobQueueService;
	}

	@Override
	public JobQueueService getWrappedService() {
		return _jobQueueService;
	}

	@Override
	public void setWrappedService(JobQueueService jobQueueService) {
		_jobQueueService = jobQueueService;
	}

	private JobQueueService _jobQueueService;
}