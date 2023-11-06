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

import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.JobQueue;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.JobQueueLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.JobQueueFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * The implementation of the job queue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.JobQueueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.JobQueueLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil
 */
public class JobQueueLocalServiceImpl extends JobQueueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil} to access the job queue local service.
	 */
    private static final Log LOG = LogFactoryUtil.getLog(JobQueueLocalServiceImpl.class);

    public boolean insertJobQueueUsingOraSequence(String jobOwner, String jobType, String metaData, String linkURL, String notificationEmail, String createUserId) throws SystemException
    {
    	return jobQueueFinder.insertJobQueueUsingOraSequence(jobOwner, jobType, metaData, linkURL, notificationEmail, createUserId);
    }
    
    /**
     * This method will add an entry to JOB_QUEUE table.
     * 
     * @param jobType This is a String object
     * @param metaData This is a String object
     * @param screenName This is a String object
     * @param notificationEmail This is a String object
     */
    public void addNewJobRequest(String jobType, String metaData, String screenName, String notificationEmail)
    {
        try
        {
            JobQueue jobQueue = JobQueueLocalServiceUtil.createJobQueue(CounterLocalServiceUtil.increment(JobQueue.class.getName()));
            jobQueue.setNew(true);
            jobQueue.setJobOwner(screenName);
            jobQueue.setJobType(jobType);
            jobQueue.setMetadata(metaData);
            jobQueue.setLink("");
            jobQueue.setNotificationEmail(notificationEmail);
            jobQueue.setStatus(BridgeConstants.JOB_STATUS_NEW);
            jobQueue.setCreatorId(screenName);
            jobQueue.setCreatedDate(DateUtil.newDate(System.currentTimeMillis()));
            jobQueue.setUpdatedBy(screenName);
            jobQueue.setUpdatedDate(DateUtil.newDate(System.currentTimeMillis()));
            jobQueuePersistence.update(jobQueue);
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Entry added to JobQueue table successfully. JobQueu Entry Id:::" + jobQueue.getJobId());
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
    }
    
    public JobQueue addJobQueue(String jobOwner, String jobType, String metadata, String link, String notificationEmail,
            Date startTime, Date endTime, String status, String createdBy, Date createDate, String updatedBy, Date updateDate)
            throws PortalException, SystemException
    {

        JobQueue jobQueue = JobQueueLocalServiceUtil.createJobQueue(CounterLocalServiceUtil.increment(JobQueue.class.getName()));
        jobQueue.setNew(true);
        jobQueue.setJobOwner(jobOwner);
        jobQueue.setJobType(jobType);
        jobQueue.setMetadata(metadata);
        jobQueue.setLink(link);
        jobQueue.setNotificationEmail(notificationEmail);
        jobQueue.setStartTime(startTime);
        jobQueue.setEndTime(endTime);
        jobQueue.setStatus(status);
        jobQueue.setCreatorId(createdBy);
        jobQueue.setCreatedDate(createDate);
        jobQueue.setUpdatedBy(updatedBy);
        jobQueue.setUpdatedDate(updateDate);
        jobQueuePersistence.update(jobQueue);

        return jobQueue;
    }

    public JobQueue updateJobQueue(long jobQueueId, String jobOwner, String jobType, String metadata, String link,
            String notificationEmail, Date startTime, Date endTime, String status, String updatedBy)
            throws PortalException, SystemException
    {

        JobQueue jobQueue = jobQueuePersistence.findByPrimaryKey(jobQueueId);
        jobQueue.setJobOwner(jobOwner);
        jobQueue.setJobType(jobType);
        jobQueue.setMetadata(metadata);
        jobQueue.setLink(link);
        jobQueue.setNotificationEmail(notificationEmail);
        jobQueue.setStartTime(startTime);
        jobQueue.setEndTime(endTime);
        jobQueue.setStatus(status);
        jobQueue.setUpdatedBy(updatedBy);
        jobQueue.setUpdatedDate(new Date());
        jobQueuePersistence.update(jobQueue);

        return jobQueue;
    }
    
    public JobQueue updateJobQueueStatus(long jobQueueId, String link, Date startTime, Date endTime, String status)
            throws PortalException, SystemException
    {
        JobQueue jobQueue = jobQueuePersistence.findByPrimaryKey(jobQueueId);
        if (link != null && !(link.isEmpty()))
        {
            jobQueue.setLink(link);
        }
        if (startTime != null)
        {
            jobQueue.setStartTime(startTime);
        }
        if (endTime != null)
        {
            jobQueue.setEndTime(endTime);
        }
        if (status != null && !(status.isEmpty()))
        {
            jobQueue.setStatus(status);
        }
        jobQueue.setUpdatedDate(new Date());
        jobQueuePersistence.update(jobQueue);

        return jobQueue;
    }

    public List<JobQueue> getJobQueuesByOwnerAndType(String jobOwner, String jobType) throws SystemException
    {
        List<JobQueue> jobQueues = jobQueuePersistence.findByJobOwnerAndType(jobOwner, jobType);
        return jobQueues;
    }
    
    public List<JobQueue> getJobQueuesByOwnerTypeAndStatus(String jobOwner, String jobType, String status) throws SystemException
    {
        List<JobQueue> jobQueues = jobQueuePersistence.findByJobOwnerTypeAndStatus(jobOwner, jobType, status);
        return jobQueues;
    }

    public List<JobQueue> getJobQueuesByType(String jobType) throws SystemException
    {
        List<JobQueue> jobQueues = jobQueuePersistence.findByJobType(jobType);
        return jobQueues;
    }
    
    public List<JobQueue> getJobQueuesByTypeAndStatus(String jobType, String status) throws SystemException
    {
        List<JobQueue> jobQueues = jobQueuePersistence.findByJobTypeAndStatus(jobType, status);
        return jobQueues;
    }

    public List<JobQueue> getJobQueuesByOwner(String jobOwner) throws SystemException
    {
        List<JobQueue> jobQueues = jobQueuePersistence.findByJobOwner(jobOwner);
        return jobQueues;
    }
    
    public List<JobQueue> getJobQueuesByOwnerAndStatus(String jobOwner, String status) throws SystemException
    {
        List<JobQueue> jobQueues = jobQueuePersistence.findByJobOwnerAndStatus(jobOwner, status);
        return jobQueues;
    }

    public List<String> getUniqueJobQueTypes() throws SystemException
    {
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JobQueue.class, portletClassLoader);
        dynamicQuery.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("jobType")));

        @SuppressWarnings("unchecked")
        List<String> jobQueueTypes = (List<String>) JobQueueLocalServiceUtil.dynamicQuery(dynamicQuery);
        return jobQueueTypes;
    }

    /**
     * This method will return file stored in liferay as byte array.
     * @param fileEntryId
     * @return
     */
    public byte[] getFileAsByteStream(long fileEntryId)
    {
        DLFileEntry dlFileEntry = null;
        InputStream inputStream = null;
        ByteArrayOutputStream output = null;
        byte[] dlFileByte = new byte[0];
        try
        {
            dlFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
            inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(dlFileEntry.getUserId(), dlFileEntry.getFileEntryId(), StringPool.BLANK);
            byte[] buffer = new byte[8192];
            output = new ByteArrayOutputStream();
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1)
            {
                output.write(buffer, 0, bytesRead);
            }
            dlFileByte = output.toByteArray();
        }
        catch (Exception e)
        {
            LOG.error("Failed to get DLFileEntry with fileEntryId:"+fileEntryId, e);
        }
        return dlFileByte;
    }
    
    public byte[] getImageAsByteStream(long igImageId, boolean getLargeImage)
    {
        byte[] igImageBytes = new byte[0];
        try
        {
            long imageId = 0;
            DLFileEntry igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(igImageId);
            if(igImage != null && getLargeImage){
                imageId = igImage.getLargeImageId(); 
            }
            else if(igImage != null ){
                imageId = igImage.getSmallImageId();
            }
            if(imageId > 0){
                Image image = ImageLocalServiceUtil.getImage(imageId);
                if(image != null){
                    int height = image.getHeight();
                    int width = image.getWidth();
        
                    if ((height >= image.getHeight()) && (width >= image.getWidth())) {
                        return image.getTextObj();
                    }
        
                    try {
                        ImageBag imageBag = ImageToolUtil.read(image.getTextObj());
        
                        RenderedImage renderedImage = ImageToolUtil.scale(
                            imageBag.getRenderedImage(), height, width);
        
                        igImageBytes = ImageToolUtil.getBytes(
                            renderedImage, imageBag.getType());
                    }
                    catch (Exception e) {
                        LOG.warn("Error scaling image " + image.getImageId(), e);
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("Failed to get IGImage with fileEntryId:"+igImageId, e);
        }
        return igImageBytes;
    }

    /**
     * This method will verify if there is already a record with same metadata and type for a user which is not processed completely (Check for both NEW & IN_PROGRESS).
     * @param xmlMetadata The Job XML Metadata.
     * @param jobOwner The Job Owner.
     * @param jobType The Job Type
     * @return
     */
    public boolean isJobQueueExistWithSameMetadata(String xmlMetadata, String jobOwner, String jobType)
    {
        return jobQueueFinder.isJobQueueExistWithSameMetadata(xmlMetadata, jobOwner, jobType);
    }
    
    /**
     * This method will verify if there is already a record with same metadata and type for a user which is not processed completely.
     * @param xmlMetadata The Job XML Metadata.
     * @param jobOwner The Job Owner. you can pass % if don't want to compare with owner.
     * @param jobType The Job Type
     * @param jobStatus The comma separated statuses.
     * @return
     */
    public boolean isJobQueueExistWithSameMetadata(String xmlMetadata, String jobOwner, String jobType, String jobStatus)
    {
        return jobQueueFinder.isJobQueueExistWithSameMetadata(xmlMetadata, jobOwner, jobType, jobStatus);
    }
    
    public List<JobQueue> getJobQueuesExceptFullManuals()
    {
        return new ArrayList<JobQueue>();
    }

    public void clearCache(){
    	try {
			jobQueuePersistence.clearCache();
		} catch (Exception e) {
			LOG.error("Failed to clear the cache for JobQueue");
		}
    }
}