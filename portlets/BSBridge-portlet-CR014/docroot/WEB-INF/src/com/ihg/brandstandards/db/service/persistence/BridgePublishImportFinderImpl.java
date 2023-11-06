package com.ihg.brandstandards.db.service.persistence;

import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.db.model.BridgePublishImport;
import com.ihg.brandstandards.db.model.impl.BridgePublishImportImpl;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


public class BridgePublishImportFinderImpl extends BasePersistenceImpl<BridgePublishImport> implements BridgePublishImportFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishImportFinderImpl.class);

    public BridgePublishImport createOraSequence() throws SystemException
    {
        Session session = null;
        BridgePublishImport pubImport = null;
        try
        {
            session = openSession();
            final String query = "SELECT BRIDGE_PUB_IMPORT_ID_SEQ.nextval AS BRIDGE_PUBLICATION_IMPORT_ID, " +
                                 "-1 PUBLISH_ID, NULL STD_ID, 'N' SELECTION_ID, 0 RGN_ID, NULL VLD_STAT_CD, " +
                                 "NULL CREAT_USR_ID, SYSDATE CREAT_TS, NULL LST_UPDT_USR_ID, SYSDATE LST_UPDT_TS FROM dual";
//            if (LOG.isDebugEnabled())
//            {
//                LOG.debug("BridgePublishImport Query : " + query);
//            }
            
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("BridgePublishImport", BridgePublishImportImpl.class);
            @SuppressWarnings("unchecked")
            List<BridgePublishImport> list = (List<BridgePublishImport>) sqlQuery.list();
            pubImport = (BridgePublishImport) (list.get(0));
//            if (LOG.isDebugEnabled())
//            {
//                LOG.debug("New BridgePublishImport id : " + pubImport.getPrimaryKey() + " ::: " + pubImport.getPublishImportId());
//            }
            pubImport.setPrimaryKey(pubImport.getPublishImportId());
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
        return pubImport;
    }
    
    public int addBridgePublishImport(List<Long> stdIds, long publishId, String chainCode, long rgnId, String screenName) throws SystemException
    {
    	long startTime = new Date().getTime();
        String ids = StringUtils.join(stdIds, ',');
        String query = BridgeQueryUtils.getAddByImportProcedure();
        if (LOG.isDebugEnabled())
            LOG.debug("addBridgePublishImport: query = " + query + " \n for publishId = " + publishId + " rgnId = " + rgnId + " ids = " + ids );

        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query);
            colstmt.setLong(1, publishId);
            colstmt.setLong(2, rgnId);
            colstmt.setString(3, chainCode);
            colstmt.setString(4, screenName); 
            Reader reader = new StringReader(ids);
            colstmt.setCharacterStream(5, reader, ids.length());
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            if (LOG.isDebugEnabled())
                LOG.debug("ERROR occur on Insert bridge_publish_import Query : " + query);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        if (LOG.isDebugEnabled())
            LOG.debug("addBridgePublishImport: import took = " + (new Date().getTime() - startTime) + " ms");
        
        return stdIds.size();
    }
    
    public void updateBridgePublishImport(long publishId, List<Long> mustPublish, List<Long> mustNotPublish, List<Long> unPublish, 
            List<Long> wrongBrand, List<Long> wrongRgn, List<Long> doPublish, List<Long> discont ,List<Long> missing, List<Long> orphan) throws SystemException
    {
        long startTime = new Date().getTime();
        StringBuilder query = new StringBuilder();
        query.append("DECLARE ");
        query.append("  l_publish_id NUMBER := ?; ");
        query.append("  l_must_publish CLOB := ?; ");
        query.append("  l_must_not_publish CLOB := ?; ");
        query.append("  l_un_publish CLOB := ?; ");
        query.append("  l_wrong_brand CLOB := ?; ");
        query.append("  l_wrong_rgn CLOB := ?; ");
        query.append("  l_do_publish CLOB := ?; ");
        query.append("  l_discontinued CLOB := ?; ");
        query.append("  l_missing CLOB := ?; ");
        query.append("  l_orphan CLOB := ?; ");
        query.append("  l_stat_must VARCHAR2(20) := 'GLBLMST'; ");
        query.append("  l_stat_must_ind VARCHAR2(1) := 'Y'; ");
        query.append("  l_stat_must_not VARCHAR2(20) := 'GLBLMSTNOT'; ");
        query.append("  l_stat_must_not_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_unpublish VARCHAR2(20) := 'UNPUBLISH'; "); 
        query.append("  l_stat_unpublish_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_no_brand VARCHAR2(20) := 'NOTBRND'; ");
        query.append("  l_stat_no_brand_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_no_rgn VARCHAR2(20) := 'NOTRGN'; ");
        query.append("  l_stat_no_rgn_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_discontinued VARCHAR2(20) := 'DISCONT'; ");
        query.append("  l_stat_discontinued_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_missing VARCHAR2(20) := 'MISSING'; ");
        query.append("  l_stat_missing_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_orphan VARCHAR2(20) := 'ORPHAN'; ");
        query.append("  l_stat_orphan_ind VARCHAR2(1) := 'N'; ");
        query.append("  l_stat_ind_default VARCHAR2(1) := 'Y'; ");
        query.append("BEGIN ");
        query.append("  IF l_must_publish IS NOT NULL AND DBMS_LOB.getlength(l_must_publish) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_must, selection_id = l_stat_must_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_must_publish))); ");
        query.append("  END IF; ");

        query.append("  IF l_must_not_publish IS NOT NULL AND DBMS_LOB.getlength(l_must_not_publish) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_must_not, selection_id = l_stat_must_not_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_must_not_publish))); ");
        query.append("  END IF; ");

        query.append("  IF l_un_publish IS NOT NULL AND DBMS_LOB.getlength(l_un_publish) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_unpublish, selection_id = l_stat_unpublish_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_un_publish))); ");
        query.append("  END IF; ");

        query.append("  IF l_wrong_brand IS NOT NULL AND DBMS_LOB.getlength(l_wrong_brand) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_no_brand, selection_id = l_stat_no_brand_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_wrong_brand))); ");
        query.append("  END IF; ");

        query.append("  IF l_wrong_rgn IS NOT NULL AND DBMS_LOB.getlength(l_wrong_rgn) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_no_rgn, selection_id = l_stat_no_rgn_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_wrong_rgn))); ");
        query.append("  END IF; ");

        query.append("  IF l_do_publish IS NOT NULL AND DBMS_LOB.getlength(l_do_publish) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = NULL, selection_id = l_stat_ind_default ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_do_publish))); ");
        query.append("  END IF; ");
        
        query.append("  IF l_discontinued IS NOT NULL AND DBMS_LOB.getlength(l_discontinued) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_discontinued, selection_id = l_stat_discontinued_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_discontinued))); ");
        query.append("  END IF; ");
        
        query.append("  IF l_missing IS NOT NULL AND DBMS_LOB.getlength(l_missing) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_missing, selection_id = l_stat_missing_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_missing))); ");
        query.append("  END IF; ");
        
        query.append("  IF l_orphan IS NOT NULL AND DBMS_LOB.getlength(l_orphan) > 0 THEN ");
        query.append("    UPDATE bridge_publish_import SET vld_stat_cd = l_stat_orphan, selection_id = l_stat_orphan_ind ");
        query.append("    WHERE bridge_publication_import_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_orphan))); ");
        query.append("  END IF; ");
        query.append("END; ");
        
        if (LOG.isDebugEnabled())
            LOG.debug("addBridgePublishImport: query = " + query.toString() + " \n for publishId = " + publishId +
                " mustPublish = " + mustPublish.size() + " mustNotPublish = " + mustNotPublish.size() + " unPublish = " + unPublish.size() + 
                " wrongBrand = " + wrongBrand.size() + " wrongRgn = " + wrongRgn.size() + " doPublish = " + doPublish.size() );

        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query.toString());
            colstmt.setLong(1, publishId);
            
            String mustPublishId = StringUtils.join(mustPublish, ',');
            Reader readerMust = new StringReader(mustPublishId);
            colstmt.setCharacterStream(2, readerMust, mustPublishId.length());
            
            String mustNotPublishId = StringUtils.join(mustNotPublish, ',');
            Reader readerMustNot = new StringReader(mustNotPublishId);
            colstmt.setCharacterStream(3, readerMustNot, mustNotPublishId.length());

            String unPublishId = StringUtils.join(unPublish, ',');
            Reader readerUnpub = new StringReader(unPublishId);
            colstmt.setCharacterStream(4, readerUnpub, unPublishId.length());
            
            String wrongBrandId = StringUtils.join(wrongBrand, ',');
            Reader readerWrongBr = new StringReader(wrongBrandId);
            colstmt.setCharacterStream(5, readerWrongBr, wrongBrandId.length());
            
            String wrongRgnId = StringUtils.join(wrongRgn, ',');
            Reader readerWrongRg = new StringReader(wrongRgnId);
            colstmt.setCharacterStream(6, readerWrongRg, wrongRgnId.length());
            
            String doPublishId = StringUtils.join(doPublish, ',');
            Reader readerDoPub = new StringReader(doPublishId);
            colstmt.setCharacterStream(7, readerDoPub, doPublishId.length());
            
            String discontinuedId = StringUtils.join(discont, ',');
            Reader readerDiscontinued = new StringReader(discontinuedId);
            colstmt.setCharacterStream(8, readerDiscontinued, discontinuedId.length());
            
            String missingId = StringUtils.join(missing, ',');
            Reader readerMissing = new StringReader(missingId);
            colstmt.setCharacterStream(9, readerMissing, missingId.length());
            
            String orphanId = StringUtils.join(orphan, ',');
            Reader readerOrphan = new StringReader(orphanId);
            colstmt.setCharacterStream(10, readerOrphan, orphanId.length());
            
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            if (LOG.isDebugEnabled())
                LOG.debug("ERROR occur on UPDATE bridge_publish_import Query : " + query);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        if (LOG.isDebugEnabled())
            LOG.debug("addBridgePublishImport: import took = " + (new Date().getTime() - startTime) + " ms");
    }
    
    public void setBridgePublishForImport(long publishId, long rgnId, Map<Long, String> importSelection) throws SystemException
    {
        long startTime = new Date().getTime();
        List<Long> selected = new ArrayList<Long>();
        List<Long> unselected = new ArrayList<Long>();
        for (Entry<Long, String> entry : importSelection.entrySet())
        {
            if ("Y".equals(entry.getValue()))
            {
                selected.add(entry.getKey());
            }
            else
            {
                unselected.add(entry.getKey());
            }
        }        
        
        StringBuilder query = new StringBuilder();
        query.append("BEGIN ");

        if (!selected.isEmpty())
        {
            getSTDSelectionUpdateQuery(publishId, rgnId, selected, query, "Y");
        }
        if (!unselected.isEmpty())
        {
            getSTDSelectionUpdateQuery(publishId, rgnId, unselected, query, "N");
        }
        query.append("END; ");
        
        if (LOG.isDebugEnabled())
            LOG.debug("setBridgePublishForImport: query = " + query);

        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            pstmt = conn.prepareStatement(query.toString());
            pstmt.execute();
        }
        catch (SQLException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            if (LOG.isDebugEnabled())
                LOG.debug("ERROR occur on update bridge_publish_import Query : " + query);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, pstmt);
        }
        
        if (LOG.isDebugEnabled())
            LOG.debug("setBridgePublishForImport: update took = " + (new Date().getTime() - startTime) + " ms");
    }

    private void getSTDSelectionUpdateQuery(long publishId, long rgnId, List<Long> stdIds, StringBuilder query, String selection)
    {
        query.append("UPDATE bridge_publish_import SET selection_id = '").append(selection).append("', lst_updt_ts = SYSDATE ");
        query.append("WHERE publish_id = ").append(publishId).append(" ");
        query.append("AND rgn_id = ").append(rgnId).append(" ");
        query.append("AND std_id IN (");
        boolean addMore = false;
        int cnt = 0;
        StringBuilder std_ids = new StringBuilder();
        for (long id : stdIds)
        {
            if (cnt > 0)
            {
                std_ids.append(",");
            }
            std_ids.append(id);
            if (cnt >= 950)
            {
                std_ids.append(") OR std_id IN (");
                addMore = false;
                cnt = 0;
            } 
            else
            {
                cnt++;
            }
        }
        query.append(std_ids);
        query.append(" ); ");
        query.append("COMMIT; ");
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
    
    public int getBridgeImportedRecordsCount(long publishId, long regionId)
    {
        String query = "SELECT count(*) FROM bridge_publish_import WHERE publish_id = " + publishId + " AND rgn_id = " + regionId;
        Session session = null;
        int cnt = 0;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            List<BigDecimal> count = q.list();
            
            if(count != null && count.size() > 0)
            {
                BigDecimal stdCount = (BigDecimal) count.get(0);
                cnt = stdCount.intValue();
            }
        }
        catch (ORMException orm)
        {
            LOG.error("Catch ORMException: ", orm);
        }
        catch (Exception e)
        {
            LOG.error("Catch Exception: ", e);
        }
        finally
        {
            closeSession(session);
        }
        return cnt;
    }
    
    public void deleteBridgeImportByPublishIdAndRegionId(long publishId, long regionId) throws SystemException
    {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	try
    	{
    		conn = getDataSource().getConnection();
    		String query = "delete from BRIDGE_PUBLISH_IMPORT WHERE PUBLISH_ID = "+publishId+" AND RGN_ID = "+regionId;
    		pstmt = conn.prepareStatement(query);
    		pstmt.execute();
    	}
    	catch(SQLException oe)
    	{
    		LOG.error(StackTraceUtil.getStackTrace(oe));
    	}
    	finally
        {
    		  closeConnection(conn, pstmt);
        }
    }
    
    private void closeConnection(Connection conn, PreparedStatement pstmt)
    {
        if (pstmt != null)
        {
            try
            {
            	pstmt.close();
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
    
    public List<Long> getStandardsByRegion(long publishId, long regionId) throws SystemException
    {
        long startTime = new Date().getTime();
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT DISTINCT std_id ");
        query.append("FROM CTRY_STD ");
        query.append("WHERE std_id IN (SELECT std_id FROM bridge_publish_import WHERE publish_id = ").append(publishId);
        query.append(" AND rgn_id = ").append(regionId).append(") ");
        query.append(" AND ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ");
        query.append(regionId);
        query.append(" ) ");
        
        if (LOG.isDebugEnabled())
            LOG.debug("getStandardsByRegion: query = " + query.toString());

        List<Long> rgnStdId = new ArrayList<Long>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            List<BigDecimal> ids = q.list();
            
            for(BigDecimal id : ids)
            {
                rgnStdId.add(id.longValue());
            }
        }
        catch (ORMException orm)
        {
            LOG.error("Catch ORMException: ", orm);
        }
        catch (Exception e)
        {
            LOG.error("Catch Exception: ", e);
        }
        finally
        {
            closeSession(session);
        }
        
        if (LOG.isDebugEnabled())
            LOG.debug("getStandardsByRegion: found " + rgnStdId.size() + " records, query execution took = " + (new Date().getTime() - startTime) + " ms");
//        LOG.debug("\n getStandardsByRegion: std_id = " + rgnStdId);
       return rgnStdId;
    }

    public long getMyPublicationIssuesCount(long publishId, long regionId, String vldStatusExclude){
    	long issuesCount = 0;
    	String issueCountQuery = BridgeQueryUtils.getAddByImportIssuesCount(publishId, regionId, vldStatusExclude);
    	Session session = null;
        try {
        	 session = openSession();
             SQLQuery q = session.createSQLQuery(issueCountQuery);
             List results = q.list();
             if(results != null && results.size() > 0){
            	 BigDecimal stdCount = (BigDecimal) results.get(0);
            	 issuesCount = stdCount.longValue();
             }
        } catch(Exception e) {
        	LOG.debug("locked standards count query: " + issueCountQuery);
            LOG.error("Failed to get locked standards count", e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return issuesCount;
    }
    
    public List<Long> getDiscountinuedStandards(List<Long> stdIds, String chainCode)
    {
    		long startTime = new Date().getTime();
	        
	        StringBuilder query = new StringBuilder();
	        query.append("SELECT CS.STD_ID FROM CHAIN_STD CS, STAT STT WHERE STT.STAT_CD IN ('INST_RQ','D_FOR_REF','D_NOT_RQ','D_NOT_RQ') AND STT.STAT_ID = CS.STAT_ID ");
	        if (stdIds.size() > 1000)
	        {
	            query.append("AND ( ");
	            
	            for (int from = 0; from < stdIds.size(); from += 1000)
	            {
	                if (from > 0)
	                {
	                    query.append(" OR ");
	                }
	                int to = from + 999 > stdIds.size() - 1 ? stdIds.size() - 1 : from + 999;
	                String stdIdStr = StringUtils.join(stdIds.subList(from, to), ',');
	                query.append(" CS.STD_ID IN (").append(stdIdStr).append(") ");
	            }
	            
	            query.append(" ) AND CS.CHAIN_CD='" +chainCode+ "'");
	        }
	        else 
	        {
	            query.append("AND CS.STD_ID IN (");
	            query.append(StringUtils.join(stdIds, ','));
	            query.append(") AND CS.CHAIN_CD='" +chainCode+ "'");
	        }
	        
	//        LOG.debug("getStandardsByRegion: query = " + query.toString());
	
	        List<Long> rgnStdId = new ArrayList<Long>();
	        Session session = null;
	        try
	        {
	            session = openSession();
	            SQLQuery q = session.createSQLQuery(query.toString());
	            List<BigDecimal> ids = q.list();
	            
	            for(BigDecimal id : ids)
	            {
	                rgnStdId.add(id.longValue());
	            }
	        }
	        catch (ORMException orm)
	        {
	            LOG.error("Catch ORMException: ", orm);
	        }
	        catch (Exception e)
	        {
	            LOG.error("Catch Exception: ", e);
	        }
	        finally
	        {
	            closeSession(session);
	        }
	        
	        if (LOG.isDebugEnabled())
	            LOG.debug("getStandardsByRegion: found " + rgnStdId.size() + " records, query execution took = " + (new Date().getTime() - startTime) + " ms");
	//        LOG.debug("\n getStandardsByRegion: std_id = " + rgnStdId);
	       return rgnStdId;
    }

    /**
     * Update Global and Regional Standard countries based on CMS changes (add/remove countries).
     * @param publishId - Bridge draft publication id
     * @param stdId - standard id
     * @param cmsRegionId - Standard region on CMS
     * @param userScreenName - user name
     */
    public void updateGlobalRegionalStdCountries(long publishId, long stdId, long cmsRegionId, String userScreenName)
    {
        long startTime = new Date().getTime();
        String query = BridgeQueryUtils.getUpdateGlobalRegionalStdCountriesQuery(publishId, stdId, cmsRegionId, userScreenName);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("updateGlobalRegionalStdCountries: query = " + query + " \n for publishId = " + publishId + " cmsRegionId = " + cmsRegionId + " stdId = " + stdId);
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.execute();
        }
        catch(SQLException oe)
        {
            LOG.error(StackTraceUtil.getStackTrace(oe));
            if (LOG.isDebugEnabled())
                LOG.debug("ERROR occur on updateGlobalRegionalStdCountries: Query: " + query);
        }
        finally
        {
              closeConnection(conn, pstmt);
        }
        
        LOG.debug("updateGlobalRegionalStdCountries: update took = " + (new Date().getTime() - startTime) + " ms");
    }

    /**
     * Update Global and Regional Standard countries states based on CMS changes (title change).
     * @param publishId - Bridge draft publication id
     * @param stdId - standard id
     * @param cmsRegionId - Standard region on CMS
     * @param userScreenName - user name
     */
    public void updateStdCountriesState(long publishId, long stdId, long cmsRegionId, String userScreenName)
    {
        long startTime = new Date().getTime();
        String query = BridgeQueryUtils.getUpdateStdCountriesStateQuery(publishId, stdId, cmsRegionId, userScreenName);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("updateStdCountriesState: query = " + query + " \n for publishId = " + publishId + " cmsRegionId = " + cmsRegionId + " stdId = " + stdId);
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.execute();
        }
        catch(SQLException oe)
        {
            LOG.error(StackTraceUtil.getStackTrace(oe));
            if (LOG.isDebugEnabled())
                LOG.debug("ERROR occur on updateStdCountriesState: Query: " + query);
        }
        finally
        {
              closeConnection(conn, pstmt);
        }
        
        LOG.debug("updateStdCountriesState: update took = " + (new Date().getTime() - startTime) + " ms");
    }

    /**
     * Get count of standards which are ready do be added to My Publication. 
     * @param publishId bridge publication id
     * @param rgnId region id
     * @return count
     */
    public long getSTDToBeAddedCount(long publishId, long rgnId)
    {
        long count = 0L;
        String query = BridgeQueryUtils.getSTDToBeAddedCountQuery(publishId, rgnId);
        
        Session session = null;
        try {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            count = GetterUtil.getLong(q.uniqueResult().toString());
            
            if (LOG.isDebugEnabled()) {
                LOG.debug("Total standards :" + count);
            }
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
        return count;
    }
}
