package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.impl.StandardsExtImpl;
import com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class SpreadSheetAttributeUpdateFinderImpl extends BasePersistenceImpl<SpreadSheetAttributeUpdate> 
implements SpreadSheetAttributeUpdateFinder{
	
	private static final Log LOG = LogFactoryUtil.getLog(SpreadSheetAttributeUpdateFinderImpl.class);
	
	/**
	 * @param allStdIds List object
	 * @param stdIdsMap Map object
	 * @param user User object
	 * @param region String object
	 * @param environment String object
	 * @author Chintan Akhani
	 */
    public String recordsNotAvailable (List<Long> allStdIds, Map<String, List<Long>> stdIdsMap, User user, String region, String environment) {
        String msg = null; 
        Connection connection = null;
         ResultSet resultSet = null;
         CallableStatement statement = null ;
         long starttime = System.currentTimeMillis();
         try {
                LOG.info("recordsNotAvailable query start time :"+starttime);
                Long[] stdIds = allStdIds.toArray(new Long[allStdIds.size()]);
                String standardIds = StringUtils.join(stdIds,',');
                connection = getDataSource().getConnection();
                String query = "{call brandstandardspublish.attr_std_exist(?, ?, ?, ?)}";
                if (LOG.isDebugEnabled()) 
                {
                    LOG.debug("Validate STD_ID Query : " + query);
                }
                statement = connection.prepareCall(query);
                statement.setString(1, standardIds);
                statement.setString(2, region);
                statement.registerOutParameter(3, Types.INTEGER);
                statement.registerOutParameter(4, Types.CLOB);
                statement.executeQuery();
                int errCd = statement.getInt(3);
                msg = statement.getString(4);
                if (LOG.isDebugEnabled()) 
                {
                    LOG.debug("Errcd ::" + errCd + "Msg ::" + msg);
                }
                if (errCd == 0) 
                {
                    msg = null;
                } else 
                {
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("Error occured.  Email sent :::");
                    }
                    //Send an email notification
                   SpreadSheetAttributeUpdateLocalServiceUtil.sendEmailNotification(user.getUserId(), environment, 
                          BSCommonConstants.ATTRIBUTE_EMAIL_NOTIFICATION_FAIL, msg, null, "NA");
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            } finally
            {
                releaseDBResources(connection, statement, resultSet);
                
            }
         long endTime = System.currentTimeMillis();   
         LOG.info("recordsNotAvailable query end time :"+endTime);
         LOG.info("total recordsNotAvailable query time :"+(float)(endTime - starttime) / 1000.0F);
         return msg;
    }
    
    /**
     * 
     * @param standardIds
     * @return
     */
    public List getStandardDetails (List<Long> standardIds) {
        
        long starttime = System.currentTimeMillis();
        LOG.info("getStandardDetails query start time :"+starttime);
        Long[] stdIds = standardIds.toArray(new Long[standardIds.size()]);
        String ids = StringUtils.join(stdIds,',');
        
        Connection connection = null;
        ResultSet resultSet = null;
        List<StandardsExt> stdAttributes = new ArrayList<StandardsExt>();
        CallableStatement statement = null ;
        try {
            connection = getDataSource().getConnection();// dataSource.getConnection();
            String query = "{call brandstandardspublish.get_attr_std_details(?, ?)}";
           statement = connection.prepareCall(query);
           statement.setString(1, ids);
           statement.registerOutParameter(2, -10);
           statement.executeQuery();
           resultSet = (ResultSet) statement.getObject(2);
           StandardsExt attributes = null;
            while (resultSet.next()) {
                attributes = new StandardsExtImpl();
                attributes.setStdId(resultSet.getLong("STD_ID"));
                attributes.setStdPrntId(resultSet.getLong("PRNT_STD_ID"));
                attributes.setStdType(resultSet.getString("STD_TYP"));
                attributes.setStdTitle(resultSet.getString("STD_TITLE_TEXT"));
                attributes.setStdCategory(resultSet.getString("AREA_CATGY_CD"));
                attributes.setStdRegionCode(resultSet.getString("rgn_cd"));
                attributes.setStdDescription(resultSet.getString("STD_DESC"));
                attributes.setIndexId(resultSet.getLong("TAXONOMY_ID"));
                attributes.setIndexLevelSortOrder(resultSet.getLong("HIER_LVL_NBR"));
                attributes.setIndexLevel(Long.parseLong(resultSet.getString("INDX_LEVEL")));
                attributes.setIndexPath(resultSet.getString("PATH"));
                attributes.setIndexOrder(resultSet.getLong("INDX_ORDER"));
                attributes.setStdOrderNumber(resultSet.getLong("DISP_ORDER_NBR"));
                attributes.setIndexPrntId(resultSet.getLong("PRNT_TAXONOMY_ID"));
                if (Validator.isNotNull(resultSet.getString("flags"))) {
                    attributes.setFlags(getArrayListFromString(resultSet.getString("flags")));
                }
                attributes.setAuditLogId(0l);
                attributes.setStdManual(resultSet.getString("STD_MNL_TITLE"));
                attributes.setStdCorporateDepartment("");
                attributes.setStdBrandCd("");
                attributes.setBiImpactAssmntId(0l);
                attributes.setStdCountryCd("");
                //attributes.setBrands(resultSet.getString("CHN_LIST"));
                //attributes.setCountries(resultSet.getString("COUNTRY_NAME"));
                stdAttributes.add(attributes);
            }
            long endTime = System.currentTimeMillis();   
            LOG.info("getStandardDetails query end time :"+endTime);
            LOG.info("total getStandardDetails query time :"+(float)(endTime - starttime) / 1000.0F);   
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            releaseDBResources(connection, statement, resultSet);
        }
        
        return stdAttributes;
    }
    
    private static List<Long> getArrayListFromString (String flags) {
        List<Long> flagList = new ArrayList<Long>();
        if (Validator.isNotNull(flags)) {
            String[] flagArray = flags.split(",");
            for (String flag : flagArray) {
                flagList.add(Long.parseLong(flag));
            }
        }
        return flagList;
    }
    private static void releaseDBResources(Connection conn, Statement stmt, ResultSet rs)
   {
       if (rs != null)
       {
           try
           {
               rs.close();
           } catch (SQLException e) {
            LOG.error("Exception on close statement", e);
           }
       }
       if (stmt != null)
       {
           try
           {
               stmt.close();
           } catch (SQLException e) {
            LOG.error("Exception on close statement", e);
           }
       }
       if (conn != null)
       {
           try
           {
               conn.close();
           } catch (SQLException e) {
            LOG.error("Exception on close connection", e);
           }
       }
   }
    
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    public List<Long> getFlagStdId (long stdId) {
        long starttime = System.currentTimeMillis();
        LOG.info("getFlagStdId query end time :"+starttime);
        List<Long> flagStdIds = new LinkedList<Long>();
        Session session = null;
        try
        {
            session = openSession();
            StringBuffer stringBuffer = new StringBuffer("Select FLAG_CATGY_ID from FLAG_STD where STD_ID = ");
            stringBuffer.append(stdId);
            SQLQuery query = session.createSQLQuery(stringBuffer.toString());
            query.addScalar("FLAG_CATGY_ID", Type.LONG);
            flagStdIds = query.list();
            long endTime = System.currentTimeMillis();   
            LOG.info("getFlagStdId query end time :"+endTime);
            LOG.info("total getFlagStdId query time :"+(float)(endTime - starttime) / 1000.0F);
        }
        catch (Exception e)
        {
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return flagStdIds;
    }
    
    /**
     * @return Map<String,Long> This method returns Map object
     */
    public Map<String,Long> getFlagCategories () {
        long starttime = System.currentTimeMillis();
        LOG.info("getFlagCategories query end time :"+starttime);
        Map<String,Long> flagCategories = new HashMap<String, Long>();
        Session session = null;
        try
        {
            session = openSession();
            StringBuffer stringBuffer = new StringBuffer("Select FLAG_CATGY_ID,FLAG_CATGY_VAL from FLAG_CATGY");
            SQLQuery query = session.createSQLQuery(stringBuffer.toString());
            List results = query.list();
            if (Validator.isNotNull(results)) {
                for (int i = 0; i < results.size(); i++) {
                    Object[] obj = (Object[]) results.get(i);
                    long flagId = ((BigDecimal) obj[0]).longValue();
                    String flagName = (String) obj[1];
                    flagCategories.put(flagName, flagId);
                }
            }
            long endTime = System.currentTimeMillis();   
            LOG.info("getFlagCategories query end time :"+endTime);
            LOG.info("total getFlagCategories query time :"+(float)(endTime - starttime) / 1000.0F);
        }
        catch (Exception e)
        {
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return flagCategories;
    }
    
    /**
     * 
     * @param standardIds
     * @return Map<Long,List<Long>>
     */
    public Map<Long,List<Long>> getStandardFlagCaterogies (List<Long> standardIds) {
        
        Map<Long,List<Long>> stdFlagIds = new HashMap<Long, List<Long>>();
        Connection conn = null;
       CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            Long[] stdIds = standardIds.toArray(new Long[standardIds.size()]);
            String ids = StringUtils.join(stdIds,',');
            String query = "{call brandstandardspublish.get_attr_std_details(?, ?)}";
            
            conn = getDataSource().getConnection();
            stmt = conn.prepareCall(query);
            stmt.setString(1, ids);
            stmt.registerOutParameter(2, -10);
            stmt.executeQuery();
            rs = (ResultSet) stmt.getObject(2);
            while (rs.next())
            {
                stdFlagIds.put(rs.getLong("STD_ID"), getArrayListFromString(rs.getString("flags")));
            }
        } catch (SQLException e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
        } finally {
            releaseDBResources(conn, stmt, rs);
        }
        return stdFlagIds;
    }
    
    /**
     * @param userId
     * @param environment
     * @param template
     * @param message
     * @param log
     * @param requestId
     * @throws SystemException
     */
   public void sendEmailNotification(long userId, String environment, String template, String message, String log, String requestId) throws SystemException
   {
       try
       {
           User user = null;
           try{
        	   user = UserLocalServiceUtil.getUser(userId);
           }
           catch(Exception e){
        	   LOG.error("No such user exists with user id: "+userId);
           }
        				   
           StringBuilder metadata = new StringBuilder();
           metadata.append("<metadata>");
           metadata.append("<type>"+template+"</type>");
           metadata.append("<params>");
           metadata.append("<param name=\"ENVIRONMENT\">" + environment + "</param>");
           if (Validator.isNull(log)) {
            metadata.append("<param name=\"USER_NAME\">" + user.getFirstName() + "</param>");
           } else {
            metadata.append("<param name=\"ERROR_LOG\">" + log + "</param>");
           }
           metadata.append("<param name=\"REQUEST_ID\">"+requestId+"</param>");
           if (Validator.isNotNull(message)) {
            metadata.append("<param name=\"ERROR_MESSAGE\">"+message+"</param>");
           }
           metadata.append("</params>");
           metadata.append("</metadata>");
           Connection conn = null;
           CallableStatement colstmt = null;
           try
           {
               conn = getDataSource().getConnection();
               String query = "INSERT INTO job_queue(job_id, job_owner, job_typ, metadata_txt, link_txt, " +  
                              "notification_email_id, strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) " + 
                              "VALUES (job_id_seq.nextval, ?, 'EMAIL_NOTIFICATION', ?, NULL, " +
                              "?, NULL, NULL, 'NEW', ?, SYSDATE, ?, SYSDATE)";
               LOG.debug("Validate STD_ID Query : " + query);
               colstmt = conn.prepareCall(query);
               colstmt.setString(1, user.getScreenName());
               colstmt.setString(2, metadata.toString());
               colstmt.setString(3, user.getEmailAddress());
               colstmt.setString(4, ""+userId);
               colstmt.setString(5, ""+userId);
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
       catch (Exception p)
       {
           LOG.error(ExceptionUtils.getFullStackTrace(p));
           throw new SystemException(p);
       }
   }
   
   /**
    * @param user
    * @param metadata
    * @param jobType
    * @throws SystemException
    */
   public boolean addToJobQueue(User user, String metadata, String jobType) throws SystemException
   {
       Connection conn = null;
       CallableStatement colstmt = null;
       boolean isRequestAdded = false;
       try
       {
           conn = getDataSource().getConnection();
           String query = "INSERT INTO job_queue(job_id, job_owner, job_typ, metadata_txt, link_txt, " +  
                          "notification_email_id, strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) " + 
                          "VALUES (job_id_seq.nextval, ?, '"+jobType+"', ?, NULL, " +
                          "?, NULL, NULL, 'NEW', ?, SYSDATE, ?, SYSDATE)";
           LOG.debug("Validate STD_ID Query : " + query);
           colstmt = conn.prepareCall(query);
           colstmt.setString(1, user.getScreenName());
           colstmt.setString(2, metadata.toString());
           colstmt.setString(3, user.getEmailAddress());
           colstmt.setString(4, ""+user.getUserId());
           colstmt.setString(5, ""+user.getUserId());
           colstmt.executeQuery();
           isRequestAdded = true;
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
       return isRequestAdded; 
   }
	
}
