package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.util.AdminQueryUtils;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class CountryStandardsFinderImpl extends BasePersistenceImpl<CountryStandards> implements CountryStandardsFinder
{

	private static final Log LOG = LogFactoryUtil.getLog(StandardsComplianceFinderImpl.class);
	
	public String assignStandardsAttributToCountry(String fromCountryCode, String toCountryCode){
		
		String query = AdminQueryUtils.assignStandardsAttributToCountry(fromCountryCode, toCountryCode);
		String status = "success";
		if (LOG.isDebugEnabled())
		{
		    LOG.debug(query);
		}
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
	
	public String deleteCountryStandardAttribute(String ctryNameCode){
		
		StringBuffer query  = new StringBuffer();
		String status = "success";
		query.append("DELETE FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+ctryNameCode+"'");
		
		
	    if(LOG.isDebugEnabled()){
	    	LOG.debug("delete country standards attribute query: " + query.toString());
	    }
	    Session session = null;
	    try {
	    	session = openSession();
	        SQLQuery q = session.createSQLQuery(query.toString());
	        q.executeUpdate();
	    } catch(Exception e) 
	    {
	    	status = "fail";
	        LOG.error("Failed to delete country standards attribute", e);
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
	
	public int getCommonStdCount(String fromCountryCode, String toCountryCode)
	{
		
		String query = AdminQueryUtils.commonStdCount(fromCountryCode, toCountryCode);
		int count;
		Session session = null;
		session = openSession();
		LOG.info("Query common standards count of given countries: "+ query.toString());
		SQLQuery countryQuery = session.createSQLQuery(query.toString());
		
		countryQuery.setCacheable(false);
		
		count = ((BigDecimal)countryQuery.list().get(0)).intValue();
		
		return count;
	}
}
