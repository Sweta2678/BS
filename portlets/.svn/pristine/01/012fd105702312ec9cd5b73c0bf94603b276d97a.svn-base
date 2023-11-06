package com.ihg.brandstandards.db.service.persistence;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hsqldb.types.Types;

import com.ihg.brandstandards.db.model.StandardsCompliance;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceImpl;
import com.ihg.brandstandards.util.AdminQueryUtils;
import com.ihg.brandstandards.util.QueryUtils;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class StandardsComplianceFinderImpl extends BasePersistenceImpl<StandardsCompliance> implements StandardsComplianceFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(StandardsComplianceFinderImpl.class);
	
	public void saveStandardCompliance(long stdId, String chainCode, String ruleDate, String complianceExpiry, String stdCompliance) throws SystemException
	{
		List<StandardsCompliance> arlStandardsCompliance = new ArrayList<StandardsCompliance>();
		String query = QueryUtils.saveOrUpdateCompliance(stdId, chainCode, ruleDate, complianceExpiry, stdCompliance, true);
		if (LOG.isDebugEnabled())
		{
		    LOG.debug(query);
		}
		Session session = null;
		Connection conn = null;
        CallableStatement colstmt = null;
    	try
    	{
    		 conn = getDataSource().getConnection();
             colstmt = conn.prepareCall(query);
             colstmt.executeQuery();
		
    	}
    	catch(Exception e)
    	{
            LOG.debug(query);
    		LOG.error("Failde execute query", e);
    	}
    	finally
        {
            closeConnection(conn, colstmt);
        }
	}
	
	 private void closeConnection(Connection conn, CallableStatement colstmt)
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
	 
	 public StandardsCompliance createOraSequence() throws SystemException
	    {
	        Session session = null;
	        StandardsCompliance stdCompliance = null;
	        try
	        {
	            session = openSession();
	            final String query = "SELECT STD_CMPLY_ID_SEQ.nextval AS STD_CMPLY_ID, " +
	                                 " NULL STD_ID, NULL CTRY_NM_CD, NULL CHAIN_CD, NULL CMPLY_EXPR_DT, NULL CMPLY_EXPR_RULE_CD, NULL CMPLY_RULE_MO_QTY, NULL RULE_DT_CD, " +
	                                 " NULL CREAT_USR_ID, SYSDATE CREAT_TS, NULL LST_UPDT_USR_ID, SYSDATE LST_UPDT_TS FROM dual";
	            
	            final SQLQuery sqlQuery = session.createSQLQuery(query);
	            sqlQuery.addEntity("StandardsCompliance", StandardsComplianceImpl.class);
	            @SuppressWarnings("unchecked")
	            List<StandardsCompliance> list = (List<StandardsCompliance>) sqlQuery.list();
	            stdCompliance = (StandardsCompliance) (list.get(0));

	            stdCompliance.setPrimaryKey(stdCompliance.getStdComplianceId());
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
	        return stdCompliance;
	    }
	 
	 public void saveStandardsCompliance(StandardsCompliance stdCompliance) throws SystemException
	 {
		 Session session = null;
		 Connection conn = null;
		// java.util.Date compExpDate = null;
		 PreparedStatement pstmt = null;
		 String query = " insert into STD_CMPLY (STD_ID, CTRY_NM_CD, CHAIN_CD, CMPLY_EXPR_DT, CMPLY_EXPR_RULE_CD, CMPLY_RULE_MO_QTY, RULE_DT_CD, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS, STD_CMPLY_ID) " +
		 				" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		 try
    	{
			 
			 //compExpDate = stdCompliance.getComplianceExpiryDate();
    		 conn = getDataSource().getConnection();
    		 pstmt = conn.prepareStatement(query);
    		 pstmt.setLong(1, stdCompliance.getStdId());
    		 pstmt.setString(2, stdCompliance.getCountryCode());
    		 pstmt.setString(3,stdCompliance.getChainCode());
    		 if(stdCompliance.getComplianceExpiryDate()!=null)
    		 {
    			 pstmt.setDate(4, new java.sql.Date(stdCompliance.getComplianceExpiryDate().getTime()));
    		 }
    		 else
    		 {
    			 pstmt.setNull(4, Types.NULL);
    		 }
    		 pstmt.setString(5, stdCompliance.getComplianceExpiryRule());
    		 pstmt.setLong(6, stdCompliance.getComplianceRuleMonths());
    		 pstmt.setString(7, stdCompliance.getRuleDate());
    		 pstmt.setString(8, stdCompliance.getCreatorId());
    		 pstmt.setDate(9, new java.sql.Date(stdCompliance.getCreatedDate().getTime()));
    		 pstmt.setString(10, stdCompliance.getUpdatedBy());
    		 pstmt.setDate(11, new java.sql.Date(stdCompliance.getUpdatedDate().getTime()));
    		 conn.commit();
    	}
    	catch(Exception e)
    	{
    	    LOG.error(StackTraceUtil.getStackTrace(e));
    	}
    	finally
        {
    		if (pstmt != null)
	        {
	            try
	            {
	                pstmt.close();
	            }
	            catch (SQLException e)
	            {
	                LOG.error(e);//StackTraceUtil.getStackTrace(e));
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
	 
	 public String assignExpiryDateToCountry(String fromCountryCode, String toCountryCode){
		 
		 String query = AdminQueryUtils.assignExpiryDateToCountry(fromCountryCode, toCountryCode);
		 String status = "success";
		 if (LOG.isDebugEnabled())
			{
			    LOG.debug(query);
			}
			Session session = null;
			Connection conn = null;
	        CallableStatement colstmt = null;
	    	try
	    	{
	    		 conn = getDataSource().getConnection();
	             colstmt = conn.prepareCall(query);
	             colstmt.executeQuery();
			
	    	}
	    	catch(Exception e)
	    	{
	    		status = "fail";
	            LOG.debug(query);
	    		LOG.error("Failde execute query", e);
	    	}
	    	finally
	        {
	            closeConnection(conn, colstmt);
	        }
	    	return status;
	 }
	 
	 public String assignComplianceDateToCountry(String fromCountryCode, String toCountryCode){
		 
		String query = AdminQueryUtils.assignComplianceDateToCountry(fromCountryCode, toCountryCode);
		String status = "success";
		if (LOG.isDebugEnabled())
		{
		    LOG.debug(query);
		}
		Session session = null;
		Connection conn = null;
        CallableStatement colstmt = null;
    	try
    	{
    		 conn = getDataSource().getConnection();
             colstmt = conn.prepareCall(query);
             colstmt.executeQuery();
		
    	}
    	catch(Exception e)
    	{
    		status = "fail";
            LOG.debug(query);
    		LOG.error("Failde execute query", e);
    	}
    	finally
        {
            closeConnection(conn, colstmt);
        }
    	return status;
	 }
	 
	public String deleteComplianceExpiryDateAttribute(String ctryNameCode, String cmplExprRuleCd){
	
		StringBuffer query  = new StringBuffer();
		String status = "success";
		query.append("DELETE FROM STD_CMPLY SC WHERE SC.RULE_DT_CD = 'D' ");
		query.append("AND SC.CTRY_NM_CD = ");
		query.append("'"+ctryNameCode+"' ");
		query.append("AND SC.CMPLY_EXPR_RULE_CD = ");
		query.append("'"+cmplExprRuleCd+"'");
		
	    if(LOG.isDebugEnabled()){
	    	LOG.debug("delete country compliance/expiry date attribute query: " + query.toString());
	    }
	    Session session = null;
	    try {
	    	session = openSession();
	        SQLQuery q = session.createSQLQuery(query.toString());
	        q.executeUpdate();
	    } catch(Exception e) 
	    {
	    	status = "fail";
	        LOG.error("Failed to delete country compliance/expiry date attribute", e);
	    }
	    finally
	    {
	        if (session != null)
	        {
	            closeSession(session);
	        }
	    }
		return status;
	}
}
