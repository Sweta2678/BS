package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;
import com.ihg.brandstandards.util.AdminQueryUtils;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class ExternalLinkStandardsCountryFinderImpl extends BasePersistenceImpl<ExternalLinkStandardsCountry>
implements ExternalLinkStandardsCountryFinder
{

	private static final Log LOG = LogFactoryUtil.getLog(StandardsComplianceFinderImpl.class);
	
	public String assignLinkAttributeToCountry(String fromCountryCode, String toCountryCode){
		
		String query = AdminQueryUtils.assignLinkAttributeToCountry(fromCountryCode, toCountryCode);
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
	
	public String deleteCountryExtLinkAttribute(String ctryNameCode){
		
		StringBuffer query  = new StringBuffer();
		String status = "success";
		query.append("DELETE FROM STD_LINK_CTRY SL WHERE SL.CTRY_NM_CD = ");
		query.append("'"+ctryNameCode+"'");
		
		
	    if(LOG.isDebugEnabled()){
	    	LOG.debug("delete country external link attribute query: " + query.toString());
	    }
	    Session session = null;
	    try {
	    	session = openSession();
	        SQLQuery q = session.createSQLQuery(query.toString());
	        q.executeUpdate();
	    } catch(Exception e) 
	    {
	    	status = "fail";
	        LOG.error("Failed to delete country external link attribute", e);
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
