package com.ihg.brandstandards.db.service.persistence;

import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.bridge.util.ProgressQueryUtils;
import com.ihg.brandstandards.db.model.BridgeGlobalPublish;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;
import com.ihg.brandstandards.db.model.MustPublish;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryImpl;
import com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishImpl;
import com.ihg.brandstandards.db.model.impl.MustPublishImpl;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Find Standards based on search criteria.
 * 
 * @author KhandeN
 * 
 */
public class BridgeGlobalPublishFinderImpl extends BasePersistenceImpl<Standards> implements BridgeGlobalPublishFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgeGlobalPublishFinderImpl.class);
    
    public List<MustPublish> getMustPublishStandardsByIdsAndBrand(String stdIdsByCommaSeprated, String brand, boolean mustPublish)
            throws SystemException
    {
    	String query = null;
    	if(mustPublish) {
    		query = BridgeQueryUtils.getMustPublishStandardsByIdsOrBrandQuery(stdIdsByCommaSeprated, brand);
    	} else {
    		query = BridgeQueryUtils.getMustNotPublishStandardsByIdsOrBrandQuery(stdIdsByCommaSeprated, brand);
    	}

        Session session = null;
        List<MustPublish> list = null;
        
        try {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("MustPublish", MustPublishImpl.class);
            q.setCacheable(false);
            list = (List<MustPublish>) q.list();
        }
        catch (Exception e) {
            list = new ArrayList<MustPublish>();
            LOG.debug("Failed Global Must or Must Not Query from BridgeGlobalPublishFinderImpl : " + query);
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally {
            if (session != null) {
                closeSession(session);
            }
        }
        
       return list;
    }
    
    public BridgeGlobalPublish getNewBridgeGlobalPublish()
    {
    	Session session = null;
    	BridgeGlobalPublish bridgeGlobalPublish = null;
    	StringBuilder query = new StringBuilder();
    	query.append("SELECT BRIDGE_GBL_PUBLISH_ID_SEQ.nextval AS BRIDGE_GBL_PUBLISH_ID, ");
    	query.append("0 AS PUBLISH_ID, 0 AS STD_ID, 'Y' AS MUST_PUBLISH_IND, NULL AS CREAT_USR_ID, ");
        query.append("SYSDATE AS CREAT_TS, NULL AS LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS FROM dual");
        
        try {
            session = openSession();
            final SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            sqlQuery.addEntity("BridgeGlobalPublishCountry", BridgeGlobalPublishImpl.class);
            List<BridgeGlobalPublish> countryList = (List<BridgeGlobalPublish>) sqlQuery.list();
            bridgeGlobalPublish = countryList.get(0);
            bridgeGlobalPublish.setPrimaryKey(bridgeGlobalPublish.getGlobalPublishId());
        }
        catch (Exception e) {
            LOG.debug("New Publication : " + query);
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return bridgeGlobalPublish;
    }
    
    public BridgeGlobalPublishCountry getNewBridgeGlobalPublishCountry()
    {
    	Session session = null;
    	BridgeGlobalPublishCountry bridgeGlobalPublishCountry = null;
    	StringBuilder query = new StringBuilder();
    	query.append("SELECT BRIDGE_GBL_PUBLISH_CTRY_ID_SEQ.nextval AS BRIDGE_GBL_PUBLISH_CTRY_ID, ");
    	query.append("1 AS BRIDGE_GBL_PUBLISH_ID, NULL AS CTRY_NM_CD, 'Y' AS PUBLISH_IND, NULL AS CREAT_USR_ID, ");
        query.append("SYSDATE AS CREAT_TS, NULL AS LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS FROM dual");
        
        try {
            session = openSession();
            final SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            sqlQuery.addEntity("BridgeGlobalPublishCountry", BridgeGlobalPublishCountryImpl.class);
            List<BridgeGlobalPublishCountry> countryList = (List<BridgeGlobalPublishCountry>) sqlQuery.list();
            bridgeGlobalPublishCountry = countryList.get(0);
            bridgeGlobalPublishCountry.setPrimaryKey(bridgeGlobalPublishCountry.getGlobalPublishCtryId());
        }
        catch (Exception e) {
            LOG.debug("New Publication : " + query);
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return bridgeGlobalPublishCountry;
    }
    
    public Map<String, Long> getTotalIssuesforMustpublish(String isMustPublish,long publishId, String brand )
    {
    	Map<String, Long> overAllIssue = new HashMap<String, Long>();
        String query =  BridgeQueryUtils.getIssueCountForMustPublishQuery(isMustPublish, publishId, brand);
        LOG.info("MustPublish Issue Count Query : " + query);  
        Session session = null;
        try
        {
            long startTime = new Date().getTime();
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            List results = sqlQuery.list();
            if(results != null && results.size() == 2)
            {
                Object[] obj = (Object[]) results.get(0);
                overAllIssue.put(BridgeConstants.COUNT_GLOBAL_MUST_BRAND, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(1);
                overAllIssue.put(BridgeConstants.COUNT_GLOBAL_MUST_REGION, ((BigDecimal) obj[1]).longValue());
            }
            LOG.debug("getOverallProgress: publishId = " + publishId + " brand = " + brand + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
        }
        catch (ORMException e)
        {
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return overAllIssue;
    }
	
	public List<BridgeGlobalPublishCountry> getCountriesByGlobalPublishIdAndRegionId(long bridgeGlobalPublishId, long regionId)
    {
        Session session = null;
        List<BridgeGlobalPublishCountry> countrylist = new ArrayList<BridgeGlobalPublishCountry>();
        String query = BridgeQueryUtils.getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionIdQuery(bridgeGlobalPublishId, regionId);

        try
        {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("BridgeGlobalPublishCountry", BridgeGlobalPublishCountryImpl.class);
            sqlQuery.setCacheable(false);
            countrylist = (List<BridgeGlobalPublishCountry>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return countrylist;
    }

	public void importGlobalMustPublishStandards(long publishId, String chainCode, String screenName, String stdIds) throws SystemException {
		Connection conn = null;
        CallableStatement colstmt = null;
        String mustImportQuery = ProgressQueryUtils.getGlobalMustPublishImportProcedure();
        try {
            long startTime = new Date().getTime();
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(mustImportQuery);
            colstmt.setLong(1, publishId);
            colstmt.setString(2, screenName);
            colstmt.setString(3, chainCode);
            Reader reader = new StringReader(stdIds);
            colstmt.setCharacterStream(4, reader, stdIds.length());
            colstmt.executeQuery();
            LOG.debug("Global Must Publish Import: publishId = " + publishId + " chainCode = " + chainCode + " query exceution time is " + (new Date().getTime() - startTime) + " mls");
        } catch (SQLException e) {
            LOG.debug("Global Must Publish Import Failed Query : " + mustImportQuery);
            LOG.error(e);
            throw new SystemException(e);
        }
        finally {
            closeConnection(conn, colstmt);
        }
	}
	
	private void closeConnection(Connection conn, CallableStatement colstmt) {
        if (colstmt != null) {
            try {
                colstmt.close();
            } catch (SQLException e) {
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
