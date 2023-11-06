package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.model.impl.StandardsCountryExtImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Finder for Standards + associated Indexes.
 * 
 * @author KryvorA
 * 
 */
public class StandardsCountryExtFinderImpl extends BasePersistenceImpl<StandardsCountryExt> implements StandardsCountryExtFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsCountryExtFinderImpl.class);
    
    public List<StandardsCountryExt> getCountryListByStdIdAndRegionId(long stdId, long regionId , long publishId) throws SystemException
    {
    	Session session = null;
    	StringBuffer query = new StringBuffer();
    	query.append("SELECT ROWNUM, BGPC.CTRY_NM_CD, BGPC.PUBLISH_IND AS CTRY_FLAG FROM BRIDGE_GBL_PUBLISH BGP, BRIDGE_GBL_PUBLISH_CTRY BGPC , BRNDSTND_CTRY BRD_CNT ");
    	query.append("WHERE BRD_CNT.RGN_ID=" + regionId+ " AND BRD_CNT.CTRY_NM_CD = BGPC.CTRY_NM_CD AND BGPC.BRIDGE_GBL_PUBLISH_ID = BGP.BRIDGE_GBL_PUBLISH_ID ");
    	query.append("AND BGP.PUBLISH_ID =" +  publishId + " AND BGP.STD_ID = " + stdId);
    	List<StandardsCountryExt> list = new ArrayList<StandardsCountryExt>();
        try {
            session = openSession();
            if(LOG.isDebugEnabled()) {
            	LOG.info("Query MustPublish country popup - StandardsCountryExtFinderImpl: " + query.toString());
            }
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("StandardsCountryExt",  StandardsCountryExtImpl.class);
            q.setCacheable(false);
            list = (List<StandardsCountryExt>)q.list();
        } catch (Exception e) {
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return list;
    }
    
    public List<StandardsCountryExt> getCountryListByStdIdAndRegionIdForMyPublication(long stdId, long regionId, long publishId) throws SystemException
    {
    	Session session = null;
    	StringBuffer query = new StringBuffer();
    	query.append("SELECT ROWNUM, BPC.CTRY_NM_CD,BPC.PUBLISH_IND AS CTRY_FLAG  FROM BRIDGE_PUBLISH BP, BRIDGE_PUBLISH_CTRY BPC ");
    	query.append("WHERE BPC.BRIDGE_PUBLISH_ID=BP.BRIDGE_PUBLISH_ID AND BP.PUBLISH_ID=" + publishId + " AND BP.RGN_ID=" + regionId + " AND BP.STD_ID=" + stdId + " AND BP.UNPUBLISH_IND='N'");
        session = openSession();
        if(LOG.isDebugEnabled()) {
        	LOG.info("Query Mypubilcation country popup - StandardsCountryExtFinderImpl: " + query.toString());
        }
        SQLQuery q = session.createSQLQuery(query.toString());
        q.addEntity("StandardsCountryExt",  StandardsCountryExtImpl.class);
        q.setCacheable(false);
        List<StandardsCountryExt> list = (List<StandardsCountryExt>)q.list();
        return list;
    }
    
    public List<StandardsCountryExt> getRegionBasedCountryStatus(long stdId, String chainCd, long regionId) throws SystemException
    {
    	Session session = null;
    	StringBuilder query = new StringBuilder();
    	query.append("WITH ACTIVE_OBSM_CNTRY AS ");
    	query.append("(SELECT pcs.ctry_nm_cd FROM publish_ctry_std pcs, publish_std ps, publish p WHERE p.publish_id = ps.publish_id AND pcs.publish_std_ver_id = ps.publish_std_ver_id AND ");
    	query.append("ps.std_id = ").append(stdId).append(" AND ");
    	query.append("p.chain_cd = '").append(chainCd).append("' AND ");
    	query.append("p.publish_environment_nm = 'PRODUCTION' AND ");
    	query.append("p.publish_stat_cd = 'ACTIVE'");
    	query.append("),");
    	
    	query.append("CURRENT_BRIDGE_CNTRY AS ");
    	query.append("(SELECT cs.ctry_nm_cd FROM ctry_std cs, brndstnd_ctry bc WHERE cs.std_id = ").append(stdId).append(" AND bc.rgn_id = ").append(regionId).append(" AND cs.ctry_nm_cd = bc.ctry_nm_cd");
    	query.append("),");
    	
    	query.append("ALL_RGN_CNTRY AS ");
    	query.append("(SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ").append(regionId);
    	query.append("),");
    	
    	query.append("NEW_STATUS AS ");
    	query.append("(SELECT cbc.ctry_nm_cd FROM CURRENT_BRIDGE_CNTRY cbc MINUS SELECT aoc.ctry_nm_cd FROM ACTIVE_OBSM_CNTRY aoc");
    	query.append("),");
    	
    	query.append("PUBLISHED AS ");
    	query.append("(SELECT aoc.ctry_nm_cd FROM ACTIVE_OBSM_CNTRY aoc INTERSECT SELECT cbc.ctry_nm_cd FROM CURRENT_BRIDGE_CNTRY cbc");
		query.append("),");
		
		query.append("UNPUBLISHED_STATUS AS ");
		query.append("(SELECT aoc.ctry_nm_cd FROM ACTIVE_OBSM_CNTRY aoc MINUS SELECT cbc.ctry_nm_cd FROM CURRENT_BRIDGE_CNTRY cbc");
		query.append("),");
		
		query.append("NOT_ATTRIBUTED_STATUS AS ");
		query.append("(SELECT arc.ctry_nm_cd FROM ALL_RGN_CNTRY arc MINUS SELECT cbc.ctry_nm_cd FROM CURRENT_BRIDGE_CNTRY cbc MINUS SELECT aoc.ctry_nm_cd FROM ACTIVE_OBSM_CNTRY aoc");
		query.append("),");
		
		query.append("TOTAL_COUNTRY AS ");
		query.append("(SELECT CTRY_NM_CD, 'New' as CTRY_FLAG FROM NEW_STATUS ");
		query.append("UNION ");
		query.append("SELECT CTRY_NM_CD, 'Published' as CTRY_FLAG FROM PUBLISHED ");
		query.append("UNION ");
		query.append("SELECT CTRY_NM_CD, 'Unpublished' as CTRY_FLAG FROM UNPUBLISHED_STATUS ");
		query.append("UNION ");
		query.append("SELECT CTRY_NM_CD, 'Not Attributed' as CTRY_FLAG FROM NOT_ATTRIBUTED_STATUS");
		query.append(") ");
		
		query.append("SELECT ROWNUM, CTRY_NM_CD, CTRY_FLAG FROM TOTAL_COUNTRY");
    	
		session = openSession();
		if(LOG.isDebugEnabled()) {
        	LOG.info("Query Unpublish Country attribution - StandardsCountryExtFinderImpl: " + query.toString());
		}
        SQLQuery q = session.createSQLQuery(query.toString());
        q.addEntity("StandardsCountryExt",  StandardsCountryExtImpl.class);
        q.setCacheable(false);
        List<StandardsCountryExt> list = (List<StandardsCountryExt>)q.list();
        return list;
    }
    
    public String getRegionCodeByCountryCode(String ctryCode) {
    	
    	String regionCode = "GLBL";
    	Session session = null;
    	StringBuilder query = new StringBuilder();
    	try {
    		if(Validator.isNotNull(ctryCode)) {
    			session = openSession();
    			query.append("SELECT BR.RGN_CD FROM BRNDSTND_RGN BR ");
    			query.append("WHERE BR.RGN_ID = ( ");
    			query.append("SELECT BC.RGN_ID FROM BRNDSTND_CTRY BC WHERE BC.CTRY_NM_CD = ");
    			query.append("'" +ctryCode+ "'");
    			query.append(" )");
    			
    			SQLQuery q = session.createSQLQuery(query.toString());
    			q.setCacheable(false);
    			Object obj = q.list().get(0);
    			regionCode = obj.toString();
    		}
    	} catch(Exception e) {
    		StackTraceUtil.getStackTrace(e);
    	} finally {
    		if(session != null) {
    			closeSession(session);
    		}
    	}
    	
    	return regionCode;
    }
    
    public List<StandardsCountryExt> getCountryRegionList(){
    	
    	Session session = null;
    	StringBuffer query = new StringBuffer();
    	query.append(" SELECT ROWNUM, CTR.CTRY_NM_CD, RGN.RGN_CD, RGN.RGN_ID, 'Y' AS CTRY_FLAG,");
    	query.append(" (SELECT BR.RGN_CD FROM BRNDSTND_RGN BR WHERE BR.RGN_ID = CTR.SUB_RGN_ID) AS SUB_REGION_ID");
    	query.append(" FROM BRNDSTND_CTRY CTR, BRNDSTND_RGN RGN WHERE CTR.RGN_ID=RGN.RGN_ID AND RGN.ACTV_IND = 'Y' ");
    	query.append(" ORDER BY RGN.RGN_CD, CTR.CTRY_NM_CD ");
    	
    	session = openSession();
    	if(LOG.isDebugEnabled()) {
        	LOG.info("Query All Country and Its Regions - StandardsCountryExtFinderImpl: "+ query.toString());
    	}
    	SQLQuery countryQuery = session.createSQLQuery(query.toString());
    	
    	//countryQuery.addEntity("StandardsCountryExt", StandardsCountryExtImpl.class);
    	countryQuery.setCacheable(false);
    	
    	List<Object[]> countryRegionListObj = countryQuery.list();
    	
    	List<StandardsCountryExt> countryRegionList = new ArrayList<StandardsCountryExt>();
    	
    	for (Object[] lstQueryResult : countryRegionListObj) {
    		StandardsCountryExt countryRegionDetail = new StandardsCountryExtImpl();
    		countryRegionDetail.setCountryCode(getCountryRegionValue(lstQueryResult, 1));
    		countryRegionDetail.setRegionCode(getCountryRegionValue(lstQueryResult, 2));
    		countryRegionDetail.setRegionId(Long.parseLong(getCountryRegionValue(lstQueryResult, 3)));
    		if(!getCountryRegionValue(lstQueryResult, 5).isEmpty()){
    			countryRegionDetail.setSubRegionCode(getCountryRegionValue(lstQueryResult, 5));
    		}
    		
    		countryRegionList.add(countryRegionDetail);
    	}
    	
    	return countryRegionList;
    }
    
    private String getCountryRegionValue(Object countryRegionData[], int pos) {
		String value = "";
		if (countryRegionData != null && countryRegionData.length > pos
				&& countryRegionData[pos] != null) {
			value = countryRegionData[pos].toString();
		}
		return value;
	}
    
    public List<String> getCountryListByRegionCode(String regionCode){
    	
    	Session session = null;
    	StringBuffer query = new StringBuffer();
    	List<String> countryList = new ArrayList<String>();
    	query.append(" SELECT BC.CTRY_NM_CD FROM BRNDSTND_CTRY BC WHERE BC.RGN_ID = ");
    	query.append(" (SELECT BR.RGN_ID FROM BRNDSTND_RGN BR WHERE BR.PRNT_RGN_ID IS NULL AND");
    	query.append(" BR.RGN_CD = ");
    	query.append("'" +regionCode+"' ) ");
    	query.append(" ORDER BY BC.CTRY_NM_CD");
    	
    	try {
    		session = openSession();
        	SQLQuery countryQuery = session.createSQLQuery(query.toString());
        	countryQuery.setCacheable(false);
        	countryList = (List<String>)countryQuery.list();
    	} catch(Exception e) {
    		LOG.info("Query All Country By Region Code - StandardsCountryExtFinderImpl: "+ query.toString());
    		StackTraceUtil.getStackTrace(e);
    	}
    	
    	return countryList;
    }
    
    public List<String> getCountryListBySubRegionCode(String subRegionCode){
    	
    	Session session = null;
    	StringBuffer query = new StringBuffer();
    	List<String> countryList = new ArrayList<String>();
    	query.append(" SELECT BC.CTRY_NM_CD FROM BRNDSTND_CTRY BC WHERE BC.SUB_RGN_ID =");
    	query.append(" (SELECT BR.RGN_ID FROM BRNDSTND_RGN BR WHERE BR.PRNT_RGN_ID IS NOT NULL AND");
    	query.append(" BR.RGN_CD = ");
    	query.append("'" +subRegionCode+"' ) ");
    	query.append(" ORDER BY BC.CTRY_NM_CD");
    	
    	try {
    		session = openSession();
    		SQLQuery countryQuery = session.createSQLQuery(query.toString());
        	countryQuery.setCacheable(false);
        	countryList = (List<String>)countryQuery.list();
    	} catch(Exception e){
    		LOG.info("Query All Country By Sub Region Code - StandardsCountryExtFinderImpl: "+ query.toString());
    		StackTraceUtil.getStackTrace(e);
    	}
    	return countryList;
    }
    
    public List<String> getAllStdCountryList(){
    	
    	Session session =null;
    	StringBuffer query = new StringBuffer();
    	List<String> countryList = new ArrayList<String>();
    	query.append("SELECT DISTINCT BC.CTRY_NM_CD FROM BRNDSTND_CTRY BC ORDER BY BC.CTRY_NM_CD ");
    	
    	try {
    		session = openSession();
    		SQLQuery countryQuery = session.createSQLQuery(query.toString());
        	countryQuery.setCacheable(false);
        	countryList = (List<String>)countryQuery.list();
    	} catch(Exception e) {
    		LOG.info("Query All Country StandardsCountryExtFinderImpl: "+ query.toString());
    		StackTraceUtil.getStackTrace(e);
    	}
    	
    	return countryList;
    }
}
