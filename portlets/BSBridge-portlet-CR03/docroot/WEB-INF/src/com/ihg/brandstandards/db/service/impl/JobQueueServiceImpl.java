/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.JobQueue;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.JobQueueServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the job queue remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.JobQueueService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.JobQueueServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.JobQueueServiceUtil
 */
public class JobQueueServiceImpl extends JobQueueServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.JobQueueServiceUtil} to access the job queue remote service.
	 */
    
    public JobQueue addJobQueue(String jobOwner, String jobType, String metadata, String link, String notificationEmail,
            Date startTime, Date endTime, String status, String createdBy, Date createDate, String updatedBy, Date updateDate)
            throws PortalException, SystemException
    {

        return JobQueueLocalServiceUtil.addJobQueue(jobOwner, jobType, metadata, link, notificationEmail, startTime, endTime,
                status, createdBy, createDate, updatedBy, updateDate);
    }

    public JobQueue updateJobQueue(long jobQueueId, String jobOwner, String jobType, String metadata, String link,
            String notificationEmail, Date startTime, Date endTime, String status, String updatedBy) throws PortalException,
            SystemException
    {

        return JobQueueLocalServiceUtil.updateJobQueue(jobQueueId, jobOwner, jobType, metadata, link, notificationEmail,
                startTime, endTime, status, updatedBy);
    }
    
    public JobQueue updateJobQueueStatus(long jobQueueId, String link, Date startTime, Date endTime, String status)
    throws PortalException, SystemException
    {
        return JobQueueLocalServiceUtil.updateJobQueueStatus(jobQueueId, link, startTime, endTime, status);
    }

    public void deleteJobQueue(long jobQueueId) throws PortalException, SystemException
    {
        JobQueueLocalServiceUtil.deleteJobQueue(jobQueueId);
    }

    public List<JobQueue> getAllJobQueues() throws SystemException
    {
        return JobQueueLocalServiceUtil.getJobQueues(-1, -1);
    }
    
    public List<JobQueue> getJobQueuesExceptFullManuals()
    {
        return JobQueueLocalServiceUtil.getJobQueuesExceptFullManuals();
    }

    public List<JobQueue> getJobQueuesByOwnerAndType(String jobOwner, String jobType) throws SystemException
    {
        return JobQueueLocalServiceUtil.getJobQueuesByOwnerAndType(jobOwner, jobType);
    }

    public List<JobQueue> getJobQueuesByOwnerTypeAndStatus(String jobOwner, String jobType, String status) throws SystemException
    {
        return JobQueueLocalServiceUtil.getJobQueuesByOwnerTypeAndStatus(jobOwner, jobType, status);
    }
    
    public List<JobQueue> getJobQueuesByType(String jobType) throws SystemException
    {
        return JobQueueLocalServiceUtil.getJobQueuesByType(jobType);
    }
    
    public List<JobQueue> getJobQueuesByTypeAndStatus(String jobType, String status) throws SystemException
    {
        return JobQueueLocalServiceUtil.getJobQueuesByTypeAndStatus(jobType, status);
    }

    public List<JobQueue> getJobQueuesByOwner(String jobOwner) throws SystemException
    {
        return JobQueueLocalServiceUtil.getJobQueuesByOwner(jobOwner);
    }

    public List<String> getUniqueJobQueTypes() throws SystemException
    {
        return JobQueueLocalServiceUtil.getUniqueJobQueTypes();
    }

    public byte[] getFileAsByteStream(long fileEntryId)
    {
        return JobQueueLocalServiceUtil.getFileAsByteStream(fileEntryId);
    }
    
    public byte[] getImageAsByteStream(long imageId, boolean getLargeImage)
    {
        return JobQueueLocalServiceUtil.getImageAsByteStream(imageId, getLargeImage);
    }
}