package com.ihg.brandstandards.db.service.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.model.impl.StandardsCountryChainImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class StandardsCountryChainFinderImpl  extends BasePersistenceImpl<StandardsCountryChain> implements StandardsCountryChainFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsCountryChainFinderImpl.class);
    
    /**
     * Update Compliance Deadline for specified countries or whole region.
     * @param stdId standard id
     * @param compDatesMap country code / compliance deadline map
     * @param brandCode brand code
     * @param regionCode region code
     * @throws SystemException 
     */
    public String updateComplianceDeadline(Long stdId, Map<String, Date> compDatesMap, String brandCode, String regionCode) throws SystemException
    {
        String result;
        StringBuilder query = new StringBuilder();
        query.append("DECLARE ");
        query.append(" l_std_id NUMBER := ?; ");
        query.append(" l_rgn_cd VARCHAR2(4) := ?; ");
        query.append(" l_brand_cd VARCHAR2(2) := ?; ");
        query.append(" l_publish_std_ver_id NUMBER; ");
        query.append("BEGIN ");
        query.append(" SELECT publish_std_ver_id ");
        query.append(" INTO l_publish_std_ver_id ");
        query.append(" FROM publish_std ");
        query.append(" WHERE std_id = l_std_id ");
        query.append(" AND publish_id = (SELECT publish_id  ");
        query.append("     FROM publish ");
        query.append("     WHERE publish_stat_cd =  'ACTIVE' ");
        query.append("     AND publish_environment_nm = 'PRODUCTION' ");
        query.append("     AND chain_cd = l_brand_cd); ");
        
        
        // Update all countries with same date
        if (compDatesMap.size() == 1 && compDatesMap.get("compDateAll") != null)
        {
            String dateStr = BridgeConstants.DEFAULT_DATE_FORMATTER.format(compDatesMap.get("compDateAll"));
            query.append(" UPDATE std_ctry_chain ");
            query.append(" SET cmply_dt = to_date('").append(dateStr).append("', 'DD MON YYYY') ");
            query.append(" WHERE std_id = l_std_id ");
            query.append(" AND rgn_cd = l_rgn_cd ");
            query.append(" AND chain_cd = l_brand_cd; ");
            
            query.append(" UPDATE publish_ctry_std ");
            query.append(" SET std_cmply_deadline_dt = to_date('").append(dateStr).append("', 'DD MON YYYY') ");
            query.append(" WHERE publish_std_ver_id = l_publish_std_ver_id ");
            query.append(" AND ctry_nm_cd IN (SELECT bc.ctry_nm_cd ");
            query.append("     FROM brndstnd_ctry bc, brndstnd_rgn br ");
            query.append("     WHERE bc.rgn_id = br.rgn_id ");
            query.append("     AND br.rgn_cd = l_rgn_cd); ");
        }
        // Update country with specific date
        else
        {
            for (Map.Entry<String, Date> entry : compDatesMap.entrySet())
            {
                String dateStr = BridgeConstants.DEFAULT_DATE_FORMATTER.format(entry.getValue());
                query.append(" UPDATE std_ctry_chain ");
                query.append(" SET cmply_dt = to_date('").append(dateStr).append("', 'DD MON YYYY') ");
                query.append(" WHERE std_id = l_std_id ");
                query.append(" AND chain_cd = l_brand_cd ");
                query.append(" AND ctry_nm_cd = '").append(entry.getKey()).append("'; ");
                
                query.append(" UPDATE publish_ctry_std ");
                query.append(" SET std_cmply_deadline_dt = to_date('").append(dateStr).append("', 'DD MON YYYY') ");
                query.append(" WHERE publish_std_ver_id = l_publish_std_ver_id ");
                query.append(" AND ctry_nm_cd = '").append(entry.getKey()).append("'; ");
            }
        }
        query.append(" COMMIT; ");
        query.append("END; ");

        LOG.debug("Update Compliance Date Query : " + query.toString());
        
        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query.toString());
            colstmt.setLong(1, stdId);
            colstmt.setString(2, regionCode);
            colstmt.setString(3, brandCode);
            int ret = colstmt.executeUpdate();
            if (ret == 0)
            {
                result = BridgeConstants.SUCCESS_MSG;
            }
            else 
            {
                result = BridgeConstants.ERROR_MSG;
            }
        }
        catch (SQLException e)
        {
            LOG.debug("Failed Query : " + query.toString());
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        return result;
    }
    
    
    
    public  String getDefaultComplianceDate(long stdId,String chainCD,String regionCd)
    {
    	String regionDate = "" ;
    	try
        {
    	Session session = null;
        StringBuffer query = new StringBuffer();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
         
        query.append("Select DISTINCT sc.CMPLY_DT from STD_CTRY_CHAIN sc where sc.STD_ID='");
        
        query.append(stdId);
        query.append("' AND sc.CHAIN_CD='");
        query.append(chainCD);
        query.append("'");
        if(Validator.isNotNull(regionCd)){
        	  query.append(" AND sc.RGN_CD='");
        	  query.append(regionCd);
        	  query.append("'");
        }
        query.append(" AND sc.CMPLY_DT IS NOT NULL");
        query.append(" AND sc.CTRY_NM_CD IN (Select CTRY_NM_CD from BRNDSTND_CTRY)");
        query.append(" AND sc.RGN_CD=(Select RGN_CD from BRNDSTND_RGN where RGN_ID=(Select RGN_ID from BRNDSTND_CTRY where CTRY_NM_CD = sc.CTRY_NM_CD))");
        session = openSession();
        SQLQuery q = session.createSQLQuery(query.toString());
        q.setCacheable(false);
       /// q.addEntity("StandardsCountryChain", StandardsCountryChainImpl.class);
        
        List<Object> countrychaninList  = (List<Object>)q.list();
        if(countrychaninList.size()==1){
        	regionDate =  df.format(countrychaninList.get(0));
        }
        }catch(Exception e){
        	LOG.error("Error in fetching default compliance date for edit compliance deadline page " + e.getMessage());
        }
        return regionDate;
        
    }
    public  String getDefaulExpiryDate(long stdId,String chainCD,String regionCd)
    {
    	String regionDate = "" ;
    	try
        {
    	Session session = null;
        StringBuffer query = new StringBuffer();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        query.append("Select DISTINCT sc.EXPR_DT from STD_CTRY_CHAIN sc where sc.STD_ID='");
        
        query.append(stdId);
        query.append("' AND sc.CHAIN_CD='");
        query.append(chainCD);
        query.append("'");
        if(Validator.isNotNull(regionCd)){
        	  query.append(" AND sc.RGN_CD='");
        	  query.append(regionCd);
        	  query.append("'");
        }
        query.append(" AND sc.EXPR_DT IS NOT NULL");
        query.append(" AND sc.CTRY_NM_CD IN (Select CTRY_NM_CD from BRNDSTND_CTRY)");
        query.append(" AND sc.RGN_CD=(Select RGN_CD from BRNDSTND_RGN where RGN_ID=(Select RGN_ID from BRNDSTND_CTRY where CTRY_NM_CD = sc.CTRY_NM_CD))");
        session = openSession();
        SQLQuery q = session.createSQLQuery(query.toString());
        q.setCacheable(false);
      //  q.addEntity("StandardsCountryChain", StandardsCountryChainImpl.class);
        
        List<Object> countrychaninList  = (List<Object>)q.list();
        if(countrychaninList.size()==1){
        	regionDate =  df.format(countrychaninList.get(0));
        }
    }catch(Exception e){
    	LOG.error("Error in fetching default expiry date for edit compliance deadline page " + e.getMessage());
    }
        return regionDate;
    }
    private void closeConnection(Connection conn, Statement colstmt)
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
