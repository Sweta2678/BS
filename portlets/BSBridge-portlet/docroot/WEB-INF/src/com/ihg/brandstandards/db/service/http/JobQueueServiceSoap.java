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

package com.ihg.brandstandards.db.service.http;

import com.ihg.brandstandards.db.service.JobQueueServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.ihg.brandstandards.db.service.JobQueueServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.ihg.brandstandards.db.model.JobQueueSoap}.
 * If the method in the service utility returns a
 * {@link com.ihg.brandstandards.db.model.JobQueue}, that is translated to a
 * {@link com.ihg.brandstandards.db.model.JobQueueSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Mummanedi
 * @see JobQueueServiceHttp
 * @see com.ihg.brandstandards.db.model.JobQueueSoap
 * @see com.ihg.brandstandards.db.service.JobQueueServiceUtil
 * @generated
 */
public class JobQueueServiceSoap {
	public static com.ihg.brandstandards.db.model.JobQueueSoap addJobQueue(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws RemoteException {
		try {
			com.ihg.brandstandards.db.model.JobQueue returnValue = JobQueueServiceUtil.addJobQueue(jobOwner,
					jobType, metadata, link, notificationEmail, startTime,
					endTime, status, createdBy, createDate, updatedBy,
					updateDate);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap updateJobQueue(
		long jobQueueId, java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metadata, java.lang.String link,
		java.lang.String notificationEmail, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status,
		java.lang.String updatedBy) throws RemoteException {
		try {
			com.ihg.brandstandards.db.model.JobQueue returnValue = JobQueueServiceUtil.updateJobQueue(jobQueueId,
					jobOwner, jobType, metadata, link, notificationEmail,
					startTime, endTime, status, updatedBy);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap updateJobQueueStatus(
		long jobQueueId, java.lang.String link, java.util.Date startTime,
		java.util.Date endTime, java.lang.String status)
		throws RemoteException {
		try {
			com.ihg.brandstandards.db.model.JobQueue returnValue = JobQueueServiceUtil.updateJobQueueStatus(jobQueueId,
					link, startTime, endTime, status);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteJobQueue(long jobQueueId)
		throws RemoteException {
		try {
			JobQueueServiceUtil.deleteJobQueue(jobQueueId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getAllJobQueues()
		throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getAllJobQueues();

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getJobQueuesExceptFullManuals()
		throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getJobQueuesExceptFullManuals();

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getJobQueuesByOwnerAndType(
		java.lang.String jobOwner, java.lang.String jobType)
		throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getJobQueuesByOwnerAndType(jobOwner, jobType);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getJobQueuesByOwnerTypeAndStatus(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String status) throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getJobQueuesByOwnerTypeAndStatus(jobOwner,
					jobType, status);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getJobQueuesByType(
		java.lang.String jobType) throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getJobQueuesByType(jobType);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getJobQueuesByTypeAndStatus(
		java.lang.String jobType, java.lang.String status)
		throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getJobQueuesByTypeAndStatus(jobType, status);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.ihg.brandstandards.db.model.JobQueueSoap[] getJobQueuesByOwner(
		java.lang.String jobOwner) throws RemoteException {
		try {
			java.util.List<com.ihg.brandstandards.db.model.JobQueue> returnValue =
				JobQueueServiceUtil.getJobQueuesByOwner(jobOwner);

			return com.ihg.brandstandards.db.model.JobQueueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String[] getUniqueJobQueTypes()
		throws RemoteException {
		try {
			java.util.List<java.lang.String> returnValue = JobQueueServiceUtil.getUniqueJobQueTypes();

			return returnValue.toArray(new java.lang.String[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static byte[] getFileAsByteStream(long fileEntryId)
		throws RemoteException {
		try {
			byte[] returnValue = JobQueueServiceUtil.getFileAsByteStream(fileEntryId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static byte[] getImageAsByteStream(long imageId,
		boolean getLargeImage) throws RemoteException {
		try {
			byte[] returnValue = JobQueueServiceUtil.getImageAsByteStream(imageId,
					getLargeImage);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(JobQueueServiceSoap.class);
}