package com.ihg.brandstandards.db.service.persistence;

import java.io.Reader;
import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.CMSSearchCriteria;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.impl.PublishQueueImpl;
import com.ihg.brandstandards.db.model.impl.StandardsExtImpl;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.util.StandardsListUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Helper class for schedule publishing process.
 * @author kryvora
 *
 */
public class PublishQueueFinderImpl extends BasePersistenceImpl<PublishQueue> implements PublishQueueFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishQueueFinderImpl.class);

    /**
     * Creates PublishQueue object and set PUBLISH_ID from Oracle sequence.
     * 
     * @return PublishQueue object
     */
    @SuppressWarnings("unchecked")
    public PublishQueue getNewPublishQueue() throws SystemException
    {
        Session session = null;
        PublishQueue queue = null;
        try
        {
            session = openSession();
            final String query = "SELECT PUBLISH_QUEUE_ID_SEQ.nextval AS PUBLISH_QUEUE_ID, " +
                                 "NULL NOTIFICATION_EMAIL_ID, NULL PUBLISH_FILE_TXT, NULL PUBLISH_ENVIRONMENT_NM, " +
                                 "SYSDATE SCHED_PUBLISH_TS, NULL QUEUE_STAT_CD, NULL CHAIN_CD, NULL SCHED_STRT_TS, " +
                                 "NULL SCHED_END_TS, NULL EXPT_PROD_PUBLISH_DT, 0 PUBLISH_ID, NULL LOCALE_LIST_TXT, NULL CREAT_USR_ID, " +
                                 "SYSDATE CREAT_TS, NULL LST_UPDT_USR_ID, SYSDATE LST_UPDT_TS FROM dual";
            LOG.debug("NewPublishQueue Query : " + query);
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("PublishQueue", PublishQueueImpl.class);
            List<PublishQueue> arlResults = (List<PublishQueue>) sqlQuery.list();
            queue = (PublishQueue) (arlResults.get(0));
            LOG.debug("New PublishQueue id : " + queue.getPrimaryKey() + " ::: " + queue.getPublishQueueId());
            queue.setPrimaryKey(queue.getPublishQueueId());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return queue;
    }
    
    /**
     * Creates PublishQueue object and set PUBLISH_ID from Oracle sequence.
     * 
     * @return PublishQueue object
     */
    @SuppressWarnings("unchecked")
    public PublishQueue clonePublishQueue(long publishQueueId) throws SystemException
    {
        Session session = null;
        PublishQueue queue = null;
        try
        {
            session = openSession();
            final String query = "SELECT PUBLISH_QUEUE_ID_SEQ.nextval AS PUBLISH_QUEUE_ID, " +
                                 "NOTIFICATION_EMAIL_ID, PUBLISH_FILE_TXT, PUBLISH_ENVIRONMENT_NM, " +
                                 "SCHED_PUBLISH_TS, QUEUE_STAT_CD, CHAIN_CD, NULL SCHED_STRT_TS, " +
                                 "NULL SCHED_END_TS, EXPT_PROD_PUBLISH_DT, PUBLISH_ID, LOCALE_LIST_TXT, CREAT_USR_ID, " +
                                 "SYSDATE CREAT_TS, LST_UPDT_USR_ID, SYSDATE LST_UPDT_TS " +
                                 "FROM publish_queue " +
                                 "WHERE PUBLISH_QUEUE_ID = " + publishQueueId + " ";
            LOG.debug("Clone PublishQueue Query : " + query);
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("PublishQueue", PublishQueueImpl.class);
            List results = sqlQuery.list();
            if (results != null &&  !results.isEmpty()) {
            	List<PublishQueue> arlResults = (List<PublishQueue>) results;
            	queue = (PublishQueue) (arlResults.get(0));
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return queue;
    }

    /**
     * Run validation in database procedure for Standard IDs to be published.
     * @param stdIds Standard IDs
     * @param chainCd brand code
     * @return SUCCESS or error message
     * @throws SystemException exception
     */
    public String validateStdIds(final String stdIds, final String chainCd) throws SystemException
    {
        String respMsg = null;
        Connection conn = null;
        CallableStatement colstmt = null;

        try
        {
            conn = getDataSource().getConnection();
            String query = "{call brandstandardspublish.validateRecordIds(?, ?, ?, ?)}";
            LOG.debug("Validate STD_ID Query : " + query);
            colstmt = conn.prepareCall(query);
            colstmt.setString(1, stdIds);
            colstmt.setString(2, chainCd);
            colstmt.registerOutParameter(3, Types.INTEGER);
            colstmt.registerOutParameter(4, Types.CLOB);
            colstmt.executeQuery();

            int errCd = colstmt.getInt(3);
            respMsg = colstmt.getString(4);
            if (errCd > 0)
            {
                LOG.info("Standard IDs validation failed: " + respMsg);
            }
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (colstmt != null)
            {
                try
                {
                    colstmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }

        return respMsg;
    }
    
    /**
     * Fetch records for an environment.
     * @param envType
     * @param count
     * @return list of records
     * @throws SystemException exception
     */
    @SuppressWarnings("unchecked")
    public List<PublishQueue> findPublishQueueByEnvironment(String envType, int count) throws SystemException 
    {
        Session session = null;
        List<PublishQueue> records = null;
        try
        {
            session = openSession();
            final String query = "SELECT * FROM (" +
                                 "SELECT PUBLISH_QUEUE_ID, NOTIFICATION_EMAIL_ID, PUBLISH_FILE_TXT, PUBLISH_ENVIRONMENT_NM, " +
                                 "SCHED_PUBLISH_TS, QUEUE_STAT_CD, CHAIN_CD, SCHED_STRT_TS, " +
                                 "SCHED_END_TS, EXPT_PROD_PUBLISH_DT, PUBLISH_ID, LOCALE_LIST_TXT, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS " +
                                 "FROM publish_queue " +
                                 "where upper(publish_environment_nm) = '" + envType.toUpperCase() + "' " +
//                                 "AND QUEUE_STAT_CD != 'DELETED' " + 
//                                 "AND rownum <= " + count + " " +
                                 "order by creat_ts DESC, publish_queue_id desc)" +
                                 "WHERE rownum <= " + count + " ";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("PublishQueue", PublishQueueImpl.class);
            records = (List<PublishQueue>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return records;
    }

    /**
     * Fetch records for an environment.
     * @param envType
     * @param count
     * @return list of records
     * @throws SystemException exception
     */
    public int updatePublishQueueStatus(long publishQueueId, String status) throws SystemException 
    {
        Session session = null;
        int count = 0;
        try
        {
            session = openSession();
            final String query = "UPDATE PUBLISH_QUEUE SET QUEUE_STAT_CD = '" + status + "' " +
                                 "WHERE PUBLISH_QUEUE_ID = " + publishQueueId + " ";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            count = sqlQuery.executeUpdate();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return count;
    }
    
    /**
     * Get list of countries for the publication.
     * @param publishId publish id
     * @param publishQueueId publish queue id
     * @param environment "STAGING" or "PRODUCTION"
     * @param userId user id
     * @return SUCCESS or error message
     * @throws SystemException exception
     */
    public String getCountriesForPublication(final long publishId, final long publishQueueId, final String environment, final String userId) throws SystemException
    {
        String respMsg = null;
        Connection conn = null;
        CallableStatement colstmt = null;

        try
        {
            conn = getDataSource().getConnection();
            String query = "{call brandstandardspublish.find_published_countries(?, ?, ?, ?, ?)}";
            LOG.debug("Get countries for publication Query : " + query);
            colstmt = conn.prepareCall(query);
            colstmt.setLong(1, publishId);
            colstmt.setLong(2, publishQueueId);
            colstmt.setString(3, environment);
            colstmt.setString(4, userId);
            colstmt.registerOutParameter(5, Types.VARCHAR);
            colstmt.executeQuery();
            respMsg = colstmt.getString(5);
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (colstmt != null)
            {
                try
                {
                    colstmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }

        return respMsg;
    }
    
    /**
     * Create request to generate full manuals and add it to queue.
     * @param publishQueueId publish queue id
     * @param environment environment: "Staging" or "Production"
     * @throws SystemException exception
     */
    public void createManuals(long publishQueueId, String environment) throws SystemException
    {
        try
        {
            try
            {
                PublishQueueLocalServiceUtil.clearCache();
            }
            catch (Exception e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            try
            {
            	PublicationLocalServiceUtil.clearCache();
            }
            catch (Exception e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            
            PublishQueue queue = PublishQueueLocalServiceUtil.getPublishQueue(publishQueueId);
            Publication publish = PublicationLocalServiceUtil.getPublication(queue.getPublishId());
            String countriesString = getCountriesForPublication(queue.getPublishId(), publishQueueId, environment, queue.getCreatorId());
            LOG.debug("createManuals: PUBLISH_ID = " + queue.getPublishId() + " PUBLISH_QUEUE_ID = " + publishQueueId + 
                    " ENVIRONMENT = " + environment + " CHAIN_CD = " + publish.getChainCode());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            StringBuilder metadata = new StringBuilder();
            metadata.append("<metadata>");
            metadata.append("<type>FULL_MANUAL_PDF</type>");
            metadata.append("<params>");
            metadata.append("<param name=\"PUBLISH_ID\">" + queue.getPublishId() + "</param>");
            metadata.append("<param name=\"PUBLISH_QUEUE_ID\">" + publishQueueId + "</param>");
            metadata.append("<param name=\"ENVIRONMENT\">" + environment + "</param>");
            metadata.append("<param name=\"LOCALE_LST\">" + publish.getPublishLocaleList() + "</param>");
            metadata.append("<param name=\"COUNTRY_LST\">" + countriesString + "</param>");
            metadata.append("<param name=\"STD_ID\">" + queue.getPublishFileText() + "</param>");
            metadata.append("<param name=\"USER_NAME\">" + publish.getCreatorId() + "</param>");
            metadata.append("<param name=\"CHAIN_CD\">" + publish.getChainCode() + "</param>");
            metadata.append("<param name=\"MANUAL_TYPE\">" + publish.getPublishContentType() + "</param>");
            Date createDate = publish.getCreatedDate();
            String dateStr = dateFormat.format(createDate);
            metadata.append("<param name=\"PUBLISH_DATE\">" + dateStr + "</param>");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(createDate);
            calendar.add(Calendar.YEAR, 1);
            dateStr = dateFormat.format(calendar.getTime());
            metadata.append("<param name=\"EXPIRATION_DATE\">" + dateStr + "</param>");
            metadata.append("</params>");
            metadata.append("</metadata>");
            
            Connection conn = null;
            CallableStatement colstmt = null;
            try
            {
                conn = getDataSource().getConnection();
                String query = "INSERT INTO job_queue(job_id, job_owner, job_typ, metadata_txt, link_txt, " +  
                               "notification_email_id, strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) " + 
                               "VALUES (job_id_seq.nextval, ?, 'FULL_MANUAL_PDF', ?, NULL, " +
                               "?, NULL, NULL, 'NEW', ?, SYSDATE, ?, SYSDATE)";
                LOG.debug("Validate STD_ID Query : " + query);
                colstmt = conn.prepareCall(query);
                colstmt.setString(1, publish.getCreatorId());
                colstmt.setString(2, metadata.toString());
                colstmt.setString(3, queue.getNotificationEmailId());
                colstmt.setString(4, publish.getCreatorId());
                colstmt.setString(5, publish.getCreatorId());
                colstmt.executeQuery();
            }
            catch (SQLException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
                throw new SystemException(e);
            }
            finally
            {
                if (colstmt != null)
                {
                    try
                    {
                        colstmt.close();
                    }
                    catch (SQLException e)
                    {
                        LOG.error(StackTraceUtil.getStackTrace(e));
                    }
                }
                if (conn != null)
                {
                    try
                    {
                        conn.close();
                    }
                    catch (SQLException e)
                    {
                        LOG.error(StackTraceUtil.getStackTrace(e));
                    }
                }
            }

        }
        catch (PortalException p)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(p));
            throw new SystemException(p);
        }
    }
    
    /**
     * Create request to generate report and add it to queue.
     * @param metaData report metadata
     * @param userId user id
     * @param emailAddr email
     * @throws SystemException exception
     */
    public void createReport(final String metaData, final String userId, final String emailAddr) throws SystemException
    {
    	createReport(metaData, userId, emailAddr, null, BridgeConstants.REPORT_TYPE_XLS_RERORT);
    }
    
    /**
     * Create request to generate report and add it to queue.
     * @param metaData report metadata
     * @param userId user id
     * @param emailAddr email
     * @throws SystemException exception
     */
    public void createReport(final String metaData, final String userId, final String emailAddr, final String link, final String jobType) throws SystemException
    {
        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            String query = "INSERT INTO job_queue(job_id, job_owner, metadata_txt, " +  
                           "notification_email_id, strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts, link_txt, job_typ) " + 
                           "VALUES (job_id_seq.nextval, ?, ?, ?, NULL, NULL, 'NEW', ?, SYSDATE, ?, SYSDATE, ";
            query = link!=null ? query +  "?" : query + "NULL";
            query = query + ", '" + jobType + "')";
            LOG.debug("Create Report Query : " + query);
            conn = getDataSource().getConnection();
            
            colstmt = conn.prepareCall(query);
            colstmt.setString(1, userId);
            colstmt.setString(2, metaData);
            colstmt.setString(3, emailAddr);
            colstmt.setString(4, userId);
            colstmt.setString(5, userId);
            if (link != null)
            {
            	colstmt.setString(6, link);
            }
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (colstmt != null)
            {
                try
                {
                    colstmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
    }
    
    /**
     * Get Standards Records.
     */
    public List<StandardsExt> getStandards(final Map<String, ?> criteriaMap) throws SystemException
    {
        final CMSSearchCriteria criteria = (CMSSearchCriteria) criteriaMap.get("StandardsSearchCriteria");
        List<StandardsExt> standards = null;
        ReportConfig config = ReportConfigLoader.getReportConfig(criteria.getReportId());

        try
        {
            standards = getRecords(config, criteria.getPublishId());
        }
        catch (Exception e)
        {
            throw new SystemException(e);
        }

        standards = postProcessingReport(config, standards);
        return standards;
    }

    /**
     * Fetch all records without filtering.
     * 
     * @param config report configuration
     * @return list of records
     */
    private List<StandardsExt> getRecords(ReportConfig config, long publishId)
    {
        final StringBuilder query = buildSelectClause();
        final StringBuilder from = buildFromClause();
        final StringBuilder where = buildWhereClause();
        
        // name="Publish New/Update All Regions"
        if ("100".equals(config.getId()))
        {
            query.append(", ");
            query.append("NVL(CS.PUBLISH_STAT_CD, 'NO_CHANGE') AS STD_PUBLISH_STAT_CD ");
            
            where.append("AND S.publish_id = " + publishId + " ");
        }
        // name="Publish Removed Standard/Specification/Guideline"
        else if ("101".equals(config.getId())) 
        {
            query.append(", ");
            query.append("NVL(CS.PUBLISH_STAT_CD, 'NO_CHANGE') AS STD_PUBLISH_STAT_CD ");

            from.append(", ");
            from.append("(SELECT prev.publish_id ");
            from.append("FROM publish p, publish prev ");
            from.append("WHERE p.publish_environment_nm = prev.publish_environment_nm ");
            from.append("AND p.chain_cd = prev.chain_cd ");
            from.append("AND prev.publish_stat_cd = 'ARCHIVE' ");
            from.append("AND p.publish_environment_nm = 'STAGING' ");
            from.append("AND p.publish_id = " + publishId + ") prev_publish ");
            
            where.append("AND S.publish_id = prev_publish.publish_id ");
            where.append("AND s.std_id IN ( SELECT std_id ");
            where.append("FROM stage_std ");
            where.append("WHERE publish_id = prev_publish.publish_id ");
            where.append("AND std_id NOT IN (SELECT std_id ");
            where.append("FROM stage_std ");
            where.append("WHERE publish_id = " + publishId + ")) ");
        }
        // name="Publish New/Updated Attachment"
        else if ("102".equals(config.getId())) 
        {
            query.append(", ");
            query.append("STD_ATTACH.chg_stat_cd AS STD_PUBLISH_STAT_CD ");
            //STD_ATTACH.ATTACH_PATH

            from.append(", ");
            from.append("(SELECT att.STAGE_STD_VER_ID, att.locale_cd, att.chg_stat_cd, LISTAGG(att.ATTACHMENT_PATH_TXT, ', ') ");
            from.append("WITHIN GROUP (ORDER BY att.STAGE_STD_VER_ID, att.locale_cd, att.chg_stat_cd) AS ATTACH_PATH ");
            from.append("FROM stage_std_attachment att WHERE att.chg_stat_cd != 'NO_CHANGE' ");
            from.append("GROUP BY att.STAGE_STD_VER_ID, att.locale_cd, att.chg_stat_cd) STD_ATTACH ");
            
            where.append("AND S.publish_id = " + publishId + " ");
            where.append("AND S.STAGE_STD_VER_ID = STD_ATTACH.STAGE_STD_VER_ID ");

        }
        // name="Compliance Deadlines"
        else if ("103".equals(config.getId())) 
        {
            query.append(", ");
            query.append("to_char(CMPLY_DT.expected_cmply_dt, 'DD-MON-YY HH24:MI:SS') AS STD_PUBLISH_STAT_CD ");

            from.append(", ");
            from.append("( SELECT * FROM ( ");
            from.append("SELECT s.std_id, ADD_MONTHS( pq.expt_prod_publish_dt, nvl(rc.cmply_rule_mo_nbr, 0) ) AS expected_cmply_dt ");
            from.append("FROM std_rgn_chain rc, stage_std s, publish p, publish_queue pq ");
            from.append("WHERE p.publish_id = " + publishId + " ");
            from.append("AND s.publish_id = p.publish_id ");
            from.append("AND pq.publish_environment_nm = 'STAGING' ");
            from.append("and pq.publish_id = p.publish_id ");
            from.append("AND s.std_id = rc.std_id ");
            from.append("and rc.chain_cd = p.chain_cd ");
            from.append("ORDER BY rc.rgn_cd DESC) ");
            from.append("UNION ");
            from.append("SELECT s.std_id, pq.expt_prod_publish_dt AS expected_cmply_dt ");
            from.append("FROM stage_std s, publish p, publish_queue pq  ");
            from.append("WHERE p.publish_id = " + publishId + "  ");
            from.append("AND pq.publish_environment_nm = 'STAGING' ");
            from.append("and pq.publish_id = p.publish_id  ");
            from.append("AND s.publish_id = p.publish_id  ");
            from.append(") CMPLY_DT ");
            
            where.append("AND S.publish_id = " + publishId + " ");
            where.append("AND s.std_id = CMPLY_DT.std_id ");
        }
        // Expiry Rules
        else if ("104".equals(config.getId())) 
        {
            query.append(", ");
            query.append("to_char(CMPLY_DT.expected_cmply_dt, 'DD-MON-YY HH24:MI:SS') AS STD_PUBLISH_STAT_CD ");

            from.append(", ");
            from.append("( SELECT * FROM ( ");
            from.append("SELECT s.std_id, ADD_MONTHS( pq.expt_prod_publish_dt, nvl(rc.cmply_rule_mo_nbr, 0) ) AS expected_cmply_dt ");
            from.append("FROM std_rgn_chain rc, stage_std s, publish p, publish_queue pq ");
            from.append("WHERE p.publish_id = " + publishId + " ");
            from.append("AND s.publish_id = p.publish_id ");
            from.append("AND pq.publish_environment_nm = 'STAGING' ");
            from.append("and pq.publish_id = p.publish_id ");
            from.append("AND s.std_id = rc.std_id ");
            from.append("and rc.chain_cd = p.chain_cd ");
            from.append("ORDER BY rc.rgn_cd DESC) ");
            from.append("UNION ");
            from.append("SELECT s.std_id, pq.expt_prod_publish_dt AS expected_cmply_dt ");
            from.append("FROM stage_std s, publish p, publish_queue pq  ");
            from.append("WHERE p.publish_id = " + publishId + "  ");
            from.append("AND pq.publish_environment_nm = 'STAGING' ");
            from.append("and pq.publish_id = p.publish_id  ");
            from.append("AND s.publish_id = p.publish_id  ");
            from.append(") CMPLY_DT ");
            
            where.append("AND S.publish_id = " + publishId + " ");
            where.append("AND s.std_id = CMPLY_DT.std_id ");
        }
        else 
        {
            LOG.error("Unknown Publication report: " + config.getId());
        }

        query.append(from);
        query.append(where);

        LOG.debug("Get all Published Standards Query : " + query);
        List<StandardsExt> list = runQuery(query.toString());

        return list;
    }


    /**
     * Run provided query.
     * 
     * @param query - query
     * @return list of records
     */
    @SuppressWarnings("unchecked")
    private List<StandardsExt> runQuery(final String query)
    {
        Session session = null;
        List<StandardsExt> result = new ArrayList<StandardsExt>();
        try
        {
            session = openSession();
            final SQLQuery qry = session.createSQLQuery(query);
            qry.addEntity("StandardsExt", StandardsExtImpl.class);
            result = (List<StandardsExt>) qry.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return result;
    }

    /**
     * Post processing of the report.
     * 
     * @param config report configuration
     * @param list list of records
     * @return list
     */
    private List<StandardsExt> postProcessingReport(ReportConfig config, List<StandardsExt> list)
    {
        final List<StandardsExt> standards = new ArrayList<StandardsExt>();
        if (!StandardsListUtil.isNullOrBlank(list))
        {
            Map<Long, StandardsExt> statChngMap = new HashMap<Long, StandardsExt>();
            for (StandardsExt std : list)
            {
                StandardsExt rec = statChngMap.get(std.getStdId());
                if (rec == null)
                {
                    statChngMap.put(std.getStdId(), std);
                    rec = statChngMap.get(std.getStdId());
                    rec.setCountryChngStat(new HashMap<String, String>());
                }
                Map<String, String> ctryMap = rec.getCountryChngStat();
                ctryMap.put(std.getStdCountryCd(), std.getStdPubStatCd());
            }
            
            for (Map.Entry<Long, StandardsExt> entry : statChngMap.entrySet() )
            {
                standards.add(entry.getValue());
            }
        }
        return standards;
    }

    /**
     * Build SELECT clause to fetch Standards and associated Indexes.
     * 
     * @return select clause of the query
     */
    private StringBuilder buildSelectClause()
    {
        final StringBuilder query = new StringBuilder();
        query.append(" SELECT DISTINCT ");
        query.append(" TAX.STAGE_TAXONOMY_ID AS INDX_TAXONOMY_ID, ");
        query.append(" TAX.TAXONOMY_ID AS ORIG_INDX_TAXONOMY_ID, ");
        query.append(" TAX.PRNT_STAGE_TAXOMOMY_ID AS INDX_PRNT_TAXONOMY_ID, ");
        query.append(" TAX.TITLE_TXT AS INDX_TITLE_TXT, ");
        query.append(" TAX.TLEVEL AS INDX_LEVEL, ");
        query.append(" TAX.HIER_LVL_NBR AS INDX_HIER_LVL_NBR, ");
        query.append(" TAX.PATH AS INDX_PATH, ");
        query.append(" S.STAGE_STD_VER_ID AS STD_ID, ");
        query.append(" S.PRNT_STD_ID AS STD_PRNT_STD_ID, ");
        query.append(" S.STD_ID AS STD_ORIG_STD_ID, ");
        query.append(" CS.CTRY_NM_CD AS STD_CTRY_CD, ");
//        query.append(" NVL(CS.PUBLISH_STAT_CD, 'NO_CHANGE') AS STD_PUBLISH_STAT_CD, ");
        query.append(" S.STD_TYP, ");
        query.append(" CASE WHEN S.STD_TYP = 'GDLN' THEN ");
        query.append("     S.STD_DESC ");
        query.append(" ELSE ");
        query.append("     S.TITLE_TXT ");
        query.append(" END AS STD_TITLE_TXT, ");
        query.append(" S.STD_DESC, ");
        query.append(" S.STAT_DESC AS STD_STAT_DESC, ");
        query.append(" S.DISP_ORDER_NBR, ");
        query.append(" S.BUS_OWNER_NM AS STD_BUS_OWNER_NM, ");
        query.append(" S.AUTHOR_NM_TXT AS STD_AUTHOR_NM, ");
        query.append(" S.AREA_CATGY_CD AS STD_AREA_CATGY_CD, ");
        query.append(" S.CHNG_DESC AS STD_CHNG_DESC, ");
        query.append(" S.CREATOR_SCRN_NM AS STD_CREATOR_SCRN_NM, ");
        query.append(" DECODE(S.GBL_RGN_IND, 'N', NVL((SELECT CTRY_NM_CD FROM STAGE_CTRY_STD WHERE STAGE_STD_VER_ID = S.STAGE_STD_VER_ID and ROWNUM = 1), 'N'), S.GBL_RGN_IND) AS STD_GBL_RGN_IND, ");
        query.append(" S.RGN_CD AS STD_RGN_CD, ");
        query.append(" S.FRAMEWORK_STD_IND, ");
        query.append(" S.STD_MGR_ID, ");
        query.append(" S.LST_UPDT_TS AS STD_LST_UPDT_TS, ");
        query.append(" 0 WORKFLOW_ACTV_LOG_ID, '0' STD_MANUAL_FLG, 'none' STD_CORP_DEPMNT_FLG, 'none' STD_BRAND_CD, 0 BI_ASSMT_ID, ");
        query.append(" NULL AUDIT_LOG_TXT, NULL AUDIT_LOG_TITLE_TXT, NULL AUDIT_LOG_UPD_TS, NULL AUDIT_LOG_CURRENT_STAT_CD, NULL AUDIT_LOG_PREV_STAT_CD, ");
        query.append(" NULL MNL_TITLE, NULL SEC_LANG_INDX_TITLE, NULL SEC_LANG_INDX_DESC, NULL SEC_LANG_INDX_IMG_PATH, NULL SEC_LANG_STD_TITLE, ");
        query.append(" NULL SEC_LANG_STD_DESC, NULL BI_CHG_FROM_RGN, NULL BI_RGN_CD, NULL BI_PROFIT_LOSS_IMPACT_CD, NULL BI_CAP_EXPENSE_IMPACT_CD, ");
        query.append(" NULL BI_IMPLMNT_TIMESCALE_CD, NULL BI_DESC, NULL BI_CHAIN_CD, '' REFERENCED_STD_ID, 'none' AUDIT_BRAND, NULL EXPIRES, ");
        query.append(" 0 GLBL_RUL, 0 AMEA_RUL, 0 AMER_RUL, 0 EURO_RUL, 0 GC_RUL, ");
        query.append(" 0 STD_IMG_CNT, NULL STD_IMG_TITLE ");

        return query;
    }

    /**
     * Build FROM clause to fetch Standards and associated Indexes.
     * 
     * @return FROM clause of the query
     */
    private StringBuilder buildFromClause()
    {
        final StringBuilder query = new StringBuilder();
        query.append(" FROM ");
        query.append(" (SELECT T.STAGE_TAXONOMY_ID, T.TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID, T.TITLE_TXT, (LEVEL - 1) AS TLEVEL, T.HIER_LVL_NBR, ");
        query.append("  SUBSTR(SYS_CONNECT_BY_PATH(TITLE_TXT, ' -> '), 21) AS PATH ");
        query.append("  FROM STAGE_TAXONOMY T ");
        query.append(" START WITH T.STAGE_TAXONOMY_ID = 1 ");
        query.append(" CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID ");
        query.append(" ) TAX, ");
        query.append(" STAGE_STD S, STAGE_TAXONOMY_STD TS, STAGE_CTRY_STD CS ");

        return query;
    }

    /**
     * Build WHERE clause to fetch Standards and associated Indexes.
     * 
     * @return WHEER clause of the query
     */
    private StringBuilder buildWhereClause()
    {
        final StringBuilder query = new StringBuilder();
        query.append(" WHERE TS.TAXONOMY_ID = TAX.STAGE_TAXONOMY_ID ");
        query.append(" AND (TS.STAGE_STD_VER_ID = S.STAGE_STD_VER_ID OR TS.STAGE_STD_VER_ID = S.PRNT_STD_ID) ");
        query.append(" AND S.STAGE_STD_VER_ID = CS.STAGE_STD_VER_ID ");

        return query;
    }

    
    /**
     * Fetch locale for a Brand.
     * @param brand brand code
     * @return list of locale
     * @throws SystemException exception
     */
    public Map<String, String> getLocalesByStdId(final List<Long> stdIds, final String brand) throws SystemException
    {
        Map<String, String> locales = new HashMap<String, String>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            String stdIdLst = StringUtils.join(stdIds, ',');
            
            final StringBuilder query = new StringBuilder();
            query.append("SELECT DISTINCT locale_cd, locale_nm FROM ( ");
            query.append("WITH pub_std_id AS (SELECT COLUMN_VALUE AS STD_ID FROM TABLE(brandstandardspublish.delimclob_to_num_table(?))) ");
            query.append("SELECT sa.locale_cd, bl.locale_nm FROM std s, std_attachment sa, pub_std_id ps, brndstnd_locale bl ");
            query.append("WHERE s.std_id = sa.std_id AND sa.locale_cd = bl.locale_cd AND s.std_id = ps.std_id ");
            query.append("UNION ");
            query.append("SELECT se.locale_cd, bl.locale_nm FROM std s, std_extl_link se, pub_std_id ps, brndstnd_locale bl ");
            query.append("WHERE s.std_id = se.std_id AND se.locale_cd = bl.locale_cd AND s.std_id = ps.std_id ");
            query.append("UNION ");
            query.append("SELECT si.locale_cd, bl.locale_nm FROM std s, std_image si, pub_std_id ps, brndstnd_locale bl ");
            query.append("WHERE s.std_id = si.std_id AND si.locale_cd = bl.locale_cd AND s.std_id = ps.std_id ");
            query.append("UNION ");
            query.append("SELECT sx.locale_cd, bl.locale_nm FROM std s, std_xlat sx, pub_std_id ps, brndstnd_locale bl ");
            query.append("WHERE s.std_id = sx.std_id AND sx.locale_cd = bl.locale_cd AND s.std_id = ps.std_id ");
            query.append("UNION ");
            query.append("SELECT tx.locale_cd, bl.locale_nm FROM taxonomy t, taxonomy_xlat tx, brndstnd_locale bl ");
            query.append("WHERE t.taxonomy_id = tx.taxonomy_id AND tx.locale_cd = bl.locale_cd ");
            query.append("AND t.taxonomy_id IN (SELECT ts.taxonomy_id FROM taxonomy_std ts, pub_std_id ps WHERE ts.std_id = ps.std_id) )");
            
            LOG.debug("Get Locale Query : " + query);
            
            conn = getDataSource().getConnection();
            stmt = conn.prepareStatement(query.toString());
            stmt.setString(1, stdIdLst);
//            Clob clob = conn.createClob();
//            clob.setString(1, stdIdLst); 
//            stmt.setClob(1, clob);
            
            Reader reader = new StringReader(stdIdLst);
            stmt.setCharacterStream(1, reader, stdIdLst.length());
            stmt.setClob(1, reader);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                String key = rs.getString("locale_cd");
                String value = rs.getString("locale_nm");
                locales.put(key, value);
            }
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
        
        return locales;
    }
    

    /**
     * Fetch locale for a Brand.
     * @param brand brand code
     * @return list of locale
     * @throws SystemException exception
     */
    public Map<String, String> getLocalesByBrand(String brand) throws SystemException
    {
        Map<String, String> locales = new HashMap<String, String>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            String selectLocaleString = "(SELECT s.std_id FROM std s, chain_std cs WHERE s.std_id = cs.std_id AND cs.chain_cd = ? ) ";
            final StringBuilder query = new StringBuilder();
            query.append("SELECT cd.locale_cd, loc.locale_nm FROM (");
            query.append("SELECT DISTINCT locale_cd FROM std_xlat where std_id in ").append(selectLocaleString);
            query.append("UNION SELECT DISTINCT locale_cd FROM std_attachment where std_id in ").append(selectLocaleString);
            query.append("UNION SELECT DISTINCT locale_cd FROM std_extl_link where std_id in ").append(selectLocaleString);
            query.append("UNION SELECT DISTINCT locale_cd FROM std_image where std_id in ").append(selectLocaleString);
            query.append(") cd, BRNDSTND_LOCALE loc WHERE loc.locale_cd = cd.locale_cd ");
            
            LOG.debug("Get Locale Query : " + query);

            conn = getDataSource().getConnection();
            stmt = conn.prepareStatement(query.toString());
            stmt.setString(1, brand);
            stmt.setString(2, brand);
            stmt.setString(3, brand);
            stmt.setString(4, brand);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                String key = rs.getString("locale_cd");
                String value = rs.getString("locale_nm");
                locales.put(key, value);
            }
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
        
        return locales;
    }
}
