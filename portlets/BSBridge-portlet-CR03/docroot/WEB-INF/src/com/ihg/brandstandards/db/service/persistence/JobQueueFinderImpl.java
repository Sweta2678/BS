/**
 * © 2013 IHG. All rights reserved.
 */
package com.ihg.brandstandards.db.service.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.JobQueue;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Lakshminarayana Mummanedi
 * @Description This class will have finder methods for JobQueue table.
 */
public class JobQueueFinderImpl extends BasePersistenceImpl<JobQueue> implements JobQueueFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(JobQueueFinderImpl.class);
    
    /**
     * This method will verify if there is already a record with same metadata and type for a user which is not processed completely (Check for both NEW & IN_PROGRESS).
     * 
     */
    public boolean isJobQueueExistWithSameMetadata(String xmlMetadata, String jobOwner, String jobType)
    {
        boolean isJobQueueExistWithSameMetadata = false;
        StringBuffer sqlQuery = new StringBuffer();
        Session session = null;
        try
        {
            session = openSession();
            sqlQuery.append("SELECT count(*) FROM job_queue WHERE JOB_OWNER = '");
            sqlQuery.append(jobOwner);
            sqlQuery.append("' AND JOB_TYP='");
            sqlQuery.append(jobType);
            sqlQuery.append("' AND STAT_CD in ('");
            sqlQuery.append(BSCommonConstants.JOB_STATUS_NEW);
            sqlQuery.append("', '");
            sqlQuery.append(BSCommonConstants.JOB_STATUS_INPROGRESS);
            sqlQuery.append("')");
            sqlQuery.append(" AND METADATA_TXT LIKE '");
            sqlQuery.append(xmlMetadata.replaceAll("'", "''"));
            sqlQuery.append("'");
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            @SuppressWarnings("rawtypes")
            List result = q.list();
            if(LOG.isDebugEnabled())
            {
            	LOG.debug("Job Queue Metadata comparte query: "+sqlQuery);
            	LOG.debug("sqlQuery:"+sqlQuery+"\n Result:"+result);
            }
            if(result != null && result.size() > 0)
            {
                /** result=0 then no record exist. result > 0 means record exist. */
                if(Integer.parseInt(result.get(0).toString()) > 0)
                {
                    isJobQueueExistWithSameMetadata = true;
                }
            }
        }
        catch (Exception e)
        {
        	LOG.debug("Job Queue Metadata comparte query: "+sqlQuery);
        	LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return isJobQueueExistWithSameMetadata;
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
        boolean isJobQueueExistWithSameMetadata = false;
        StringBuffer sqlQuery = new StringBuffer();
        Session session = null;
        try
        {
            session = openSession();
            sqlQuery.append("SELECT count(*) FROM job_queue WHERE JOB_OWNER LIKE '");
            sqlQuery.append(jobOwner);
            sqlQuery.append("' AND JOB_TYP='");
            sqlQuery.append(jobType);
            sqlQuery.append("'");
            if(Validator.isNotNull(jobStatus)){
            	sqlQuery.append("AND STAT_CD in (");
            	String[] statuses = jobStatus.split(StringPool.COMMA);
            	boolean appendComma = false;
            	for(String status: statuses) {
            		if(appendComma){
            			sqlQuery.append(StringPool.COMMA);
            		}
            		sqlQuery.append("'");
            		sqlQuery.append(status);
            		sqlQuery.append("'");
            		appendComma = true;
            	}
            	sqlQuery.append(")");
            }
            sqlQuery.append(" AND METADATA_TXT LIKE '");
            sqlQuery.append(xmlMetadata.replaceAll("'", "''"));
            sqlQuery.append("'");
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            @SuppressWarnings("rawtypes")
            List result = q.list();
            if(LOG.isDebugEnabled())
            {
            	LOG.debug("Job Queue Metadata comparte query: "+sqlQuery);
            	LOG.debug("sqlQuery:"+sqlQuery+"\n Result:"+result);
            }
            if(result != null && result.size() > 0)
            {
                /** result=0 then no record exist. result > 0 means record exist. */
                if(Integer.parseInt(result.get(0).toString()) > 0)
                {
                    isJobQueueExistWithSameMetadata = true;
                }
            }
        }
        catch (Exception e)
        {
        	LOG.debug("Job Queue Metadata comparte query: "+sqlQuery);
        	LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return isJobQueueExistWithSameMetadata;
    }
    
    public List<JobQueue> getJobQueuesExceptFullManuals()
    {
        List<JobQueue> fullManualJobqueues = new ArrayList<JobQueue>();
        Session session = null;
        try
        {
            session = openSession();
            StringBuffer sqlQuery = new StringBuffer();
            sqlQuery.append("SELECT * FROM JOB_QUEUE WHERE JOB_TYP in ('MYDOWNLOADS', 'EMAIL_NOTIFICATION', 'MANUAL_PDF')");
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            @SuppressWarnings("rawtypes")
            List result = q.list();
            if(LOG.isDebugEnabled())
            {
                LOG.debug("sqlQuery:"+sqlQuery+"\n Result:"+result);
            }
            if(result != null && result.size() > 0)
            {
                fullManualJobqueues.addAll(result);
            }
        }
        catch (NumberFormatException e)
        {
            LOG.error(e);
        }
        catch (ORMException e)
        {
            LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return fullManualJobqueues;
    }

    /**
     * This method inserts a Job Queue table entry with parameter data.
     * @param jobOwner Can not be null
     * @param jobType Can not be null
     * @param metaData Can not be null
     * @param linkURL Can be null
     * @param notificationEmail Can not be null
     * @param createUserId Can not be null
     * @return
     * @throws SystemException
     */
    public boolean insertJobQueueUsingOraSequence(String jobOwner, String jobType, String metaData, String linkURL, String notificationEmail, String createUserId) throws SystemException
    {
    	boolean inserted = false;
    	if(Validator.isNull(jobOwner) || Validator.isNull(jobType) || Validator.isNull(metaData) || Validator.isNull(notificationEmail) || Validator.isNull(createUserId) ){
    		if(LOG.isDebugEnabled()){
            	LOG.debug("jobOwner:"+jobOwner+", jobType:"+jobType+", metaData:"+metaData+", notificationEmail:"+notificationEmail+", createUserId:"+createUserId);
            	LOG.debug("jobOwner, jobType, metaData, notificationEmail, createUserId are mandatory. Can not be null or empty.");
    		}
    		throw new SystemException("jobOwner, jobType, metaData, notificationEmail, createUserId are mandatory. Can not be null.");
    	} else {
	        Connection conn = null;
	        CallableStatement colstmt = null;
	        try {
	            StringBuffer query = new StringBuffer("INSERT INTO job_queue(job_id, job_owner, job_typ, metadata_txt, link_txt, notification_email_id,");
	            query.append(" strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts)");
	            query.append(" VALUES (job_id_seq.nextval, ?, ?, ?,");
	            if(Validator.isNull(linkURL)){
	            	query.append(" NULL,");
	            } else {
	            	query.append("'");
	            	query.append(linkURL);
	            	query.append("',");
	            }
	            query.append(" ?, NULL, NULL, 'NEW', ?, SYSDATE, ?, SYSDATE)");
	            if(LOG.isDebugEnabled()){
	            	LOG.debug("Create Job Queue Entry Query : " + query);
	            }
	            
	            conn = getDataSource().getConnection();
	            colstmt = conn.prepareCall(query.toString());
	            colstmt.setString(1, jobOwner);
	            colstmt.setString(2, jobType);
	            colstmt.setString(3, metaData);
	            colstmt.setString(4, notificationEmail);
	            colstmt.setString(5, createUserId);
	            colstmt.setString(6, createUserId);
	            colstmt.executeQuery();
	            inserted = true;
	        } catch (SQLException e) {
	        	LOG.error(e);
	            throw new SystemException(e);
	        } finally {
	            if (colstmt != null) {
	                try {
	                    colstmt.close();
	                } catch (Exception e) {
	                    LOG.error(e);
	                }
	            }
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    LOG.error(e);
	                }
	            }
	        }
    	}
        return inserted;
    }

}
