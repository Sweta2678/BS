package com.ihg.brandstandards.db.service.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.custom.model.BridgeProgressCount;
import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;
import com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgeProgressDiscrepancyFinderImpl extends BasePersistenceImpl<BridgeProgressDiscrepancy> implements BridgeProgressDiscrepancyFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(BridgeProgressDiscrepancyFinderImpl.class);

	public void deleteDeactivatedBridgePublishProgress(List<Long> deactivatedBridgePublishIds) {
		
		if(Validator.isNotNull(deactivatedBridgePublishIds) && deactivatedBridgePublishIds.size()>0){
			
			StringBuffer query  = new StringBuffer("DELETE FROM BRIDGE_PUB_PROG_DISCREPANCY WHERE PUBLISH_ID NOT IN (").append( StringUtils.join(deactivatedBridgePublishIds, ",")).append(")");
	    	
	        if(LOG.isDebugEnabled()){
	        	LOG.debug("BridgeProgressDiscrepancy query: " + query.toString());
	        }
	        Session session = null;
	        try {
	        	session = openSession();
	            SQLQuery q = session.createSQLQuery(query.toString());
	            q.executeUpdate();
	        } catch(Exception e) {
	        	LOG.debug("Failed deleteBridgeProgressDiscrepancy query: " + query.toString());
	            LOG.error("Failed to delete BridgeProgressDiscrepancy", e);
	        }
	        finally
	        {
	            if (session != null)
	            {
	                closeSession(session);
	            }
	        }
		}
	}
	
	
	public void addBridgeProgressValues(final List<BridgeProgressCount> progressDiscrepancy,final String screenName, DataSource datasource){

		Session session = null;
		try{
			
			LOG.info(" Start query excution before delete : "+ new Date());
		session = openSession();
		
		if(progressDiscrepancy != null && progressDiscrepancy.size() > 0){
			
			 StringBuffer query  = new StringBuffer("DELETE FROM BRIDGE_PUB_PROG_DISCREPANCY WHERE PUBLISH_ID=").append(progressDiscrepancy.get(0).getPublishId());
			
			 SQLQuery q = session.createSQLQuery(query.toString());
	         q.executeUpdate();
			
			for(BridgeProgressCount record  : progressDiscrepancy){
				
				BridgeProgressDiscrepancy bpd = new BridgeProgressDiscrepancyImpl();				 
				
				bpd.setProgressCategoryId(record.getCategoryId());
				bpd.setProgressSubCategoryId(record.getSubCategoryId());
				bpd.setPublishId(record.getPublishId());
				bpd.setRegionId(record.getRegionId());
				bpd.setErrorCount(record.getErrorCount());
				bpd.setCreatorId(screenName);
				bpd.setCreatedDate(new Date());
				bpd.setUpdatedBy(screenName);
				bpd.setUpdatedDate(new Date());
				
				session.save(bpd);
			}					
			
		}
		LOG.info(" End query excution before delete : "+ new Date());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			closeSession(session);
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
	
}
