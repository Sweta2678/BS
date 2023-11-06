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
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for JobQueue. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.JobQueueServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mummanedi
 * @see JobQueueService
 * @see com.ihg.brandstandards.db.service.base.JobQueueServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.JobQueueServiceImpl
 * @generated
 */
public class JobQueueServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.JobQueueServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static void deleteJobQueue(long jobQueueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJobQueue(jobQueueId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getAllJobQueues()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllJobQueues();
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesExceptFullManuals() {
		return getService().getJobQueuesExceptFullManuals();
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

	public static java.util.List<java.lang.String> getUniqueJobQueTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueJobQueTypes();
	}

	public static byte[] getFileAsByteStream(long fileEntryId) {
		return getService().getFileAsByteStream(fileEntryId);
	}

	public static byte[] getImageAsByteStream(long imageId,
		boolean getLargeImage) {
		return getService().getImageAsByteStream(imageId, getLargeImage);
	}

	public static void clearService() {
		_service = null;
	}

	public static JobQueueService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JobQueueService.class.getName());

			if (invokableService instanceof JobQueueService) {
				_service = (JobQueueService)invokableService;
			}
			else {
				_service = new JobQueueServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(JobQueueServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JobQueueService service) {
	}

	private static JobQueueService _service;
}