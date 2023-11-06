package com.ihg.brandstandards.bridge.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * All custom queries for Bridge portlet are written here.
 * @author AkhaniC
 *
 */
public class ProgressQueryUtils extends BridgeQueryUtils
{
    
	public static final Log LOG = LogFactoryUtil.getLog(ProgressQueryUtils.class);
   
    /**
     * @param publishId
     * @param rgnId
     * @return
     */
    public static String getOverAllProgressQuery(long publishId, long regionId)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT CAT, CNT FROM ( ");
        
        // Discontinued/Insight Required
        query.append("SELECT 'DISCONTINUED' AS CAT, count(*) AS CNT, 1 AS DISP_NO FROM ( ");
        query.append("SELECT s.std_id, s.std_typ, s.title_txt, st.stat_cd, s.rgn_cd, s.GBL_RGN_IND ");
        query.append("FROM publish p, bridge_publish bp, std s, chain_std cs, stat st ");
        query.append("WHERE p.publish_id = ");
        query.append(publishId);
        query.append(" AND p.publish_id = bp.publish_id ");
        query.append("AND p.chain_cd = cs.chain_cd ");
        query.append("AND bp.std_id = cs.std_id ");
        query.append("AND bp.unpublish_ind = 'N' ");
        query.append("AND bp.rgn_id = ");
        query.append(regionId);
        query.append(" AND cs.stat_id = st.stat_id ");
        query.append("AND s.std_id = bp.std_id ");
        query.append("AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        /*if(regionId == 1){
        	query.append(" UNION SELECT s.std_id, s.std_typ, s.title_txt, st.stat_cd, s.rgn_cd, s.GBL_RGN_IND ");
        	query.append(" FROM publish p, BRIDGE_GBL_PUBLISH bp, std s, chain_std cs, stat st WHERE p.publish_id =");
            query.append(publishId);
        	query.append(" AND p.publish_id = bp.publish_id AND p.chain_cd = cs.chain_cd AND bp.std_id = cs.std_id "); 
        	query.append(" AND bp.MUST_PUBLISH_IND = 'Y' AND cs.stat_id = st.stat_id AND s.std_id = bp.std_id AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        }*/
        query.append(")");
        
        // Unattributed Brand
        query.append(" UNION ");
        query.append("SELECT 'UNATTRIBUTE_BRAND' AS CAT, count(*) AS CNT, 2 AS DISP_NO FROM (");
        query.append(" SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
        query.append(" AND RGN_ID=").append(regionId);
        query.append(" MINUS SELECT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs");
        query.append(" WHERE bp.PUBLISH_ID=p.PUBLISH_ID AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y'");
        query.append(" AND bp.UNPUBLISH_IND='N' AND p.PUBLISH_ID=").append(publishId);
        query.append(" AND bp.RGN_ID=").append(regionId);
        /*if(regionId == 1){
    		//Count Unattributed Brand from Global Must Publish standards as well.
	        query.append(" UNION  SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
	        query.append(" MINUS SELECT bgp.std_id FROM BRIDGE_GBL_PUBLISH bgp, Publish p, chain_std cs"); 
	        query.append(" WHERE bgp.PUBLISH_ID = p.PUBLISH_ID AND bgp.std_id = cs.std_id AND cs.chain_cd = p.CHAIN_CD AND cs.actv_ind = 'Y'");
	        query.append(" AND bgp.MUST_PUBLISH_IND='Y' AND p.PUBLISH_ID=").append(publishId);
        }*/
        query.append(") ");
        
        // Unattributed Region
        query.append(" UNION ");
        query.append("SELECT 'UNATTRIBUTE_REGION' AS CAT, count(*) AS CNT, 3 AS DISP_NO FROM (");
        query.append(" SELECT DISTINCT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs WHERE bp.PUBLISH_ID=p.PUBLISH_ID");
    	query.append(" AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
        query.append(" AND bp.RGN_ID=").append(regionId);
        query.append(" MINUS SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, CTRY_STD cs, BRNDSTND_CTRY bc");
        query.append(" WHERE bp.STD_ID=cs.STD_ID AND cs.CTRY_NM_CD=bc.CTRY_NM_CD");
        query.append(" AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
        query.append(" AND bp.RGN_ID=").append(regionId);
        query.append(" AND bc.RGN_ID=").append(regionId);
        query.append(") ");
        
        // Override
        query.append(" UNION ");
        query.append("SELECT 'OVERRIDE' AS CAT, count(*) AS CNT, 4 AS DISP_NO FROM ( ");
        query.append("SELECT DISTINCT b.std_id ");
        query.append("FROM bridge_publish b, bridge_publish_ctry bc ");
        query.append("WHERE b.publish_id = ");
        query.append(publishId);
        query.append(" AND b.rgn_id = ");
        query.append(regionId);
        query.append(" AND b.bridge_publish_id = bc.bridge_publish_id ");
        query.append("AND b.unpublish_ind = 'N' ");
        query.append("AND bc.publish_ind = 'N') ");
        
        // Global Must
        query.append(" UNION ");
        query.append(" SELECT 'GLBL_MUST' AS CAT, count(*) AS CNT, 5 AS DISP_NO FROM (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'Y' AND PUBLISH_ID = ");
        query.append(publishId);
        query.append(" AND STD_ID IN (SELECT DISTINCT std_id FROM CTRY_STD ");
        query.append(" WHERE ctry_nm_cd IN (SELECT DISTINCT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ");
        query.append(regionId).append(")) ");
        
        query.append(" MINUS SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID = ");
        query.append(publishId);
        query.append(" AND RGN_ID = ");
        query.append(regionId);
        query.append(")");
        
        // Global NOT IN Must
        query.append(" UNION ");
        query.append(" SELECT 'GLBL_NOT_IN_MUST' AS CAT, count(*) AS CNT, 6 AS DISP_NO FROM (");
        query.append(" SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, STD s WHERE bp.STD_ID=s.STD_ID");
        query.append(" AND s.RGN_CD='GLBL' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
        query.append(" AND bp.RGN_ID=").append(regionId);
        query.append(" MINUS SELECT DISTINCT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
        query.append(")");
        
        // Global Must Not
        query.append(" UNION ");
        query.append("SELECT 'GLBL_MUST_NOT' AS CAT, count(*) AS CNT, 7 AS DISP_NO FROM (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID = ");
        query.append(publishId);
        query.append(" AND RGN_ID = ");
        query.append(regionId);
        query.append(" AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'N' AND PUBLISH_ID = ");
        query.append(publishId);
        query.append(")) ");
        
        // SELECT_STATE COUNT QUERY
        query.append(" UNION ");
        query.append("SELECT 'SELECT_STATE' AS CAT, count(*) AS CNT, 8 AS DISP_NO FROM ( ");
        query.append("SELECT DISTINCT b.std_id ");
        query.append("FROM bridge_publish b, bridge_publish_ctry bc ");
        query.append("WHERE b.bridge_publish_id = bc.bridge_publish_id ");
        query.append("AND b.unpublish_ind = 'N' ");
        query.append("AND b.publish_id = ");
        query.append(publishId);
        query.append(" AND b.rgn_id = ");
        query.append(regionId);
        query.append(" AND bc.bridge_publish_stat_cd = '");
        query.append(BSCommonConstants.BRIDGE_STATUS_CD_SEL);
        query.append("') ");
        
        // MISSING_XREF COUNT QUERY
        query.append(" UNION ");
        query.append("SELECT 'MISSING_XREF' AS CAT, count(*) AS CNT, 9 AS DISP_NO FROM (");
        query.append(" SELECT DISTINCT sx.REFERRING_STD_ID FROM STD_XREF sx, STD s, CHAIN_STD cs, STAT st");
        query.append(" WHERE sx.REFERENCED_STD_ID = s.STD_ID AND s.STD_ID = cs.STD_ID AND cs.STAT_ID = st.STAT_ID");
        query.append(" AND st.STAT_CD NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') AND s.STAT_DESC != 'DELETED'");
        query.append(" AND s.STD_ID IN (SELECT DISTINCT STD_ID FROM CTRY_STD WHERE CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID=");
        query.append(regionId);
        query.append(")) AND cs.ACTV_IND='Y' AND cs.CHAIN_CD=(SELECT CHAIN_CD FROM PUBLISH WHERE PUBLISH_ID=");
        query.append(publishId);
        query.append(") AND sx.REFERRING_STD_ID IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=");
        query.append(publishId);
        query.append(" AND RGN_ID=");
        query.append(regionId);
        query.append(") AND sx.REFERENCED_STD_ID NOT IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=");
        query.append(publishId);
        query.append(" AND RGN_ID=");
        query.append(regionId);
        query.append(")) ");
        
        query.append(") order by DISP_NO");
        return query.toString();
    }
    
    /**
     * @param publishId
     * @return
     */
    public static String getAllRGNOverAllProgressQuery(long publishId)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT CAT, CNT FROM (");
        
        // Discontinued/Insight Required
        query.append("SELECT 'DISCONTINUED' AS CAT, count(*) AS CNT, 1 AS DISP_NO FROM ( ");
        query.append("SELECT s.std_id, s.std_typ, s.title_txt, st.stat_cd, s.rgn_cd, s.GBL_RGN_IND ");
        query.append("FROM publish p, bridge_publish bp, std s, chain_std cs, stat st ");
        query.append("WHERE p.publish_id = ");
        query.append(publishId);
        query.append(" AND p.publish_id = bp.publish_id ");
        query.append("AND p.chain_cd = cs.chain_cd ");
        query.append("AND bp.std_id = cs.std_id ");
        query.append("AND bp.unpublish_ind = 'N' ");
        query.append("AND cs.stat_id = st.stat_id ");
        query.append("AND s.std_id = bp.std_id ");
        query.append("AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
    		//Count Discontinued from Global Must Publish standards as well.
        query.append(" UNION SELECT s.std_id, s.std_typ, s.title_txt, st.stat_cd, s.rgn_cd, s.GBL_RGN_IND ");
    	query.append(" FROM publish p, BRIDGE_GBL_PUBLISH bp, std s, chain_std cs, stat st WHERE p.publish_id =");
        query.append(publishId);
    	query.append(" AND p.publish_id = bp.publish_id AND p.chain_cd = cs.chain_cd AND bp.std_id = cs.std_id "); 
    	query.append(" AND bp.MUST_PUBLISH_IND = 'Y' AND cs.stat_id = st.stat_id AND s.std_id = bp.std_id AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ'))");
        
        // Unattributed Brand
        query.append(" UNION ");
        query.append("SELECT 'UNATTRIBUTE_BRAND' AS CAT, count(*) AS CNT, 2 AS DISP_NO FROM ( ");
        for(int rgnId=2; rgnId <= 5; rgnId++){
        	if(rgnId > 2){
        		query.append(" UNION");
        	}
	        query.append(" SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
	        query.append(" AND RGN_ID=").append(rgnId);
	        query.append(" MINUS SELECT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs");
	        query.append(" WHERE bp.PUBLISH_ID=p.PUBLISH_ID AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y'");
	        query.append(" AND bp.UNPUBLISH_IND='N' AND p.PUBLISH_ID=").append(publishId);
	        query.append(" AND bp.RGN_ID=").append(rgnId);
        }
        	//Count Unattributed Brand from Global Must Publish standards as well.
        query.append(" UNION  SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
        query.append(" MINUS SELECT bgp.std_id FROM BRIDGE_GBL_PUBLISH bgp, Publish p, chain_std cs"); 
        query.append(" WHERE bgp.PUBLISH_ID = p.PUBLISH_ID AND bgp.std_id = cs.std_id AND cs.chain_cd = p.CHAIN_CD AND cs.actv_ind = 'Y'");
        query.append(" AND bgp.MUST_PUBLISH_IND='Y' AND p.PUBLISH_ID=").append(publishId);
        query.append(")");
        
        // Unattributed Region
        query.append(" UNION ");
        query.append("SELECT 'UNATTRIBUTE_REGION' AS CAT, count(*) AS CNT, 3 AS DISP_NO FROM (");
        for(int rgnId=2; rgnId <= 5; rgnId++){
        	if(rgnId > 2){
        		query.append(" UNION");
        	}
        	query.append(" (SELECT DISTINCT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs WHERE bp.PUBLISH_ID=p.PUBLISH_ID");
        	query.append(" AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
	        query.append(" AND bp.RGN_ID=").append(rgnId);
	        query.append(" MINUS SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, CTRY_STD cs, BRNDSTND_CTRY bc");
	        query.append(" WHERE bp.STD_ID=cs.STD_ID AND cs.CTRY_NM_CD=bc.CTRY_NM_CD");
	        query.append(" AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
	        query.append(" AND bp.RGN_ID=").append(rgnId);
	        query.append(" AND bc.RGN_ID=").append(rgnId);
            query.append(")");
        }
        query.append(")");
        
        // Override
        query.append(" UNION ");
        query.append("SELECT 'OVERRIDE' AS CAT, count(*) AS CNT, 4 AS DISP_NO FROM ( ");
        query.append("SELECT DISTINCT b.std_id, b.rgn_id ");
        query.append("FROM bridge_publish b, bridge_publish_ctry bc ");
        query.append("WHERE b.publish_id = ");
        query.append(publishId);
        query.append(" AND b.bridge_publish_id = bc.bridge_publish_id ");
        query.append("AND b.unpublish_ind = 'N' ");
        query.append("AND bc.publish_ind = 'N' ");
        query.append(")");
        
        // Global Must Publish Count Query
        query.append(" UNION ");
        query.append("SELECT 'GLBL_MUST' AS CAT, count(*) AS CNT, 5 AS DISP_NO FROM (");
        for(int rgnId=2; rgnId <= 5; rgnId++){
        	if(rgnId > 2){
        		query.append(" UNION");
        	}
	        query.append(" (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
	        query.append(" AND STD_ID IN (SELECT DISTINCT std_id FROM CTRY_STD");
	        query.append(" WHERE ctry_nm_cd IN (SELECT DISTINCT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id=").append(rgnId).append("))");
	        query.append(" MINUS SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
	        query.append(" AND RGN_ID=").append(rgnId).append(")");
        }
        query.append(")");
        
        // Global Not In Must Query
        query.append(" UNION ");
        query.append("SELECT 'GLBL_NOT_IN_MUST' AS CAT, count(*) AS CNT, 6 AS DISP_NO FROM (");
        for(int rgnId=2; rgnId <= 5; rgnId++){
        	if(rgnId > 2){
        		query.append(" UNION");
        	}
        	query.append(" (SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, STD s WHERE bp.STD_ID=s.STD_ID");
        	query.append(" AND s.rgn_cd='GLBL' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
        	query.append(" AND bp.RGN_ID=").append(rgnId);
        	query.append(" MINUS SELECT DISTINCT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId).append(")");
    	}
        query.append(")");
        
        // Global Must NOT Publish Count Query
        query.append(" UNION ");
        query.append("SELECT 'GLBL_MUST_NOT' AS CAT, count(*) AS CNT, 7 AS DISP_NO FROM (");
        for(int rgnId=2; rgnId <= 5; rgnId++){
        	if(rgnId > 2){
        		query.append(" UNION");
        	}
	        query.append(" (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
	        query.append(" AND RGN_ID=").append(rgnId);
	        query.append(" AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='N' AND PUBLISH_ID=").append(publishId).append(")) ");
        }
        query.append(")");
        
        // SELECT STATE COUNT QUERY
        query.append(" UNION ");
        query.append("SELECT 'SELECT_STATE' AS CAT, count(*) AS CNT, 8 AS DISP_NO FROM ( ");
        query.append("SELECT DISTINCT b.std_id ");
        query.append("FROM bridge_publish b, bridge_publish_ctry bc ");
        query.append("WHERE b.bridge_publish_id = bc.bridge_publish_id ");
        query.append("AND b.unpublish_ind = 'N' ");
        query.append("AND b.publish_id = ");
        query.append(publishId);
        query.append(" AND bc.bridge_publish_stat_cd = '");
        query.append(BSCommonConstants.BRIDGE_STATUS_CD_SEL);
        query.append("') ");
        
        // MISSING_XREF COUNT QUERY
        query.append(" UNION ");
        query.append("SELECT 'MISSING_XREF' AS CAT, count(*) AS CNT, 9 AS DISP_NO FROM (");
        for(int rgnId=2; rgnId <= 5; rgnId++){
        	if(rgnId > 2){
        		query.append(" UNION");
        	}
        	query.append(" (SELECT DISTINCT sx.REFERRING_STD_ID FROM STD_XREF sx, STD s, CHAIN_STD cs, STAT st");
            query.append(" WHERE sx.REFERENCED_STD_ID = s.STD_ID AND s.STD_ID = cs.STD_ID AND cs.STAT_ID = st.STAT_ID");
            query.append(" AND st.STAT_CD NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') AND s.STAT_DESC != 'DELETED'");
            query.append(" AND s.STD_ID IN (SELECT DISTINCT STD_ID FROM CTRY_STD WHERE CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID=").append(rgnId);
            query.append(")) AND cs.ACTV_IND='Y' AND cs.CHAIN_CD=(SELECT CHAIN_CD FROM PUBLISH WHERE PUBLISH_ID=").append(publishId);
            query.append(") AND sx.REFERRING_STD_ID IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
            query.append(" AND RGN_ID=").append(rgnId);
            query.append(") AND sx.REFERENCED_STD_ID NOT IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
            query.append(" AND RGN_ID=").append(rgnId).append("))");
        }
        query.append(")");
                
        query.append(") order by DISP_NO");
        return query.toString();
    }

    /**
     * Get query for Compliance progress.
     * @param publishId
     * @return
     */
    public static String getComplianceProgressQuery(long publishId, long regionId, String chainCode, Date publishDate, boolean allRegions)
    {
        String dateStr = new SimpleDateFormat("dd MMM yyyy").format(publishDate);
        StringBuilder query = new StringBuilder();
        query.append("SELECT CAT, CNT FROM ( ");
        
        query.append(" SELECT 'EXPIRED' AS CAT, COUNT(*) AS CNT, 1 AS DISP_NO FROM (");
        query.append(" SELECT DISTINCT sc.std_id,");
        query.append(" NVL((SELECT decode(std_id, NULL, 'N', 'Y')");
        query.append(" FROM std_ctry_chain");
        query.append(" WHERE std_id = sc.std_id");
        query.append(" AND chain_cd = sc.chain_cd");
        query.append(" AND ctry_nm_cd = sc.ctry_nm_cd), 'N') is_published");
        query.append(" FROM bridge_publish b, std_cmply sc ");
        query.append(" WHERE b.publish_id = ").append(publishId);
        query.append(" AND b.std_id = sc.std_id");
        query.append(" AND b.unpublish_ind = 'N'");
        query.append(" AND sc.chain_cd = '").append(chainCode).append("'");
        query.append(" AND sc.CMPLY_EXPR_RULE_CD = 'E' AND sc.RULE_DT_CD = 'D' AND sc.cmply_expr_dt IS NOT NULL");
        query.append(" AND sc.cmply_expr_dt <= to_date('").append(dateStr).append("', 'DD MON YYYY')");
        if (!allRegions) {
            query.append(" AND b.rgn_id=").append(regionId);
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id=").append(regionId).append(")");
        } else {
        	query.append(" AND b.rgn_id IN (2, 3, 4, 5)");
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id IN (2, 3, 4, 5))");
        }
        query.append(")");
        query.append(" WHERE is_published = 'N' ");
       
        query.append(" UNION");
        
        query.append(" SELECT 'COMPLIANCE' AS CAT, COUNT(*) AS CNT, 2 AS DISP_NO FROM (");
        query.append(" SELECT DISTINCT sc.std_id,");
        query.append(" NVL((SELECT decode(std_id, NULL, 'N', 'Y')");
        query.append(" FROM std_ctry_chain");
        query.append(" WHERE std_id = sc.std_id");
        query.append(" AND chain_cd = sc.chain_cd");
        query.append(" AND ctry_nm_cd = sc.ctry_nm_cd), 'N') is_published ");
        query.append(" FROM bridge_publish b, std_cmply sc ");
        query.append(" WHERE b.publish_id = ").append(publishId);
        query.append(" AND b.std_id = sc.std_id");
        query.append(" AND b.unpublish_ind = 'N'");
        query.append(" AND sc.chain_cd = '").append(chainCode).append("'");
        query.append(" AND sc.CMPLY_EXPR_RULE_CD = 'C' AND sc.RULE_DT_CD = 'D'");
        query.append(" AND sc.cmply_expr_dt IS NOT NULL AND sc.cmply_expr_dt > SYSDATE");
        query.append(" AND sc.cmply_expr_dt < to_date('").append(dateStr).append("', 'DD MON YYYY')");
        if (!allRegions) {
            query.append(" AND b.rgn_id = ").append(regionId);
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id=").append(regionId).append(")");
        } else {
        	query.append(" AND b.rgn_id IN (2, 3, 4, 5)");
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id IN (2, 3, 4, 5))");
        }
        query.append(")");
        query.append(" WHERE is_published = 'N'");
        
        query.append(") ORDER BY DISP_NO");
        return query.toString();
    }
    
    /**
     * Get query for Notification progress.
     */
    public static String getNotificationsProgressQuery(long publishId, long regionId){
    	 StringBuilder query = new StringBuilder();
         query.append("SELECT CAT, CNT FROM (SELECT 'NOTIF' AS CAT, COUNT(*) AS CNT, 1 AS DISP_NO FROM (");
         query.append(" SELECT ERR_NOTIFICATION_ID FROM ERR_NOTIFICATION WHERE PUBLISH_ID=").append(publishId);
         query.append(" AND RGN_ID=").append(regionId);
         query.append(" AND COMPONENT_NM='").append(BSCommonConstants.ERR_NOTIFICATION_COMPONENT_BRIDGE_NOTIFICATION).append("'");
         query.append(" AND STAT_CD='").append(BridgeConstants.QUEUE_NEW_STATUS).append("'))");
         
         return query.toString();
    }
    
    /**
     * This method will return the Index Translation count query for Index Translation Progress/Summary section.  
     * @return String SQL Query.
     */
    public static String getIndexTranslationProgressQuery(boolean allRegions)
    {
        StringBuilder cntQuery = new StringBuilder();
        cntQuery.append("DECLARE ");
        cntQuery.append(" TYPE LOCALE_COUNTS IS RECORD (locale_cd VARCHAR2(5), cnt NUMBER); ");
        cntQuery.append(" TYPE locale_cnt_type IS TABLE OF LOCALE_COUNTS; ");
        cntQuery.append(" l_locale_counts locale_cnt_type := locale_cnt_type(); ");
        cntQuery.append(" l_publish_id NUMBER := ?; ");
        cntQuery.append(" l_chain_cd VARCHAR2(2) := ?; ");
        cntQuery.append(" l_rgn_cd VARCHAR2(5) := ?; ");
        cntQuery.append(" l_locale_cd VARCHAR2(5); ");
        cntQuery.append(" l_nfields PLS_INTEGER  := 1; ");
        cntQuery.append(" l_cnt NUMBER; ");
        cntQuery.append(" l_locale_cnt_out VARCHAR2(500); ");
        cntQuery.append(" CURSOR l_rgn_locale IS  ");
        cntQuery.append("  SELECT DISTINCT l.locale_cd "); 
        cntQuery.append("  FROM brndstnd_locale l, brndstnd_rgn_locale rl, brndstnd_rgn r "); 
        cntQuery.append("  WHERE l.actv_ind = 'Y' ");
        cntQuery.append("  AND l.locale_cd = rl.locale_cd ");  
        cntQuery.append("  AND r.rgn_id = rl.rgn_id ");
        cntQuery.append("  AND l.locale_cd != 'en_GB' ");
        if (!allRegions)
        {
            cntQuery.append("  AND r.rgn_cd = l_rgn_cd ");
        }
        cntQuery.append(" ; ");
        
        cntQuery.append(" CURSOR l_tax_cur IS "); 
        cntQuery.append("  SELECT DISTINCT T.TAXONOMY_ID ");
        cntQuery.append("  FROM TAXONOMY T ");
        cntQuery.append("  WHERE t.taxonomy_id > 1 ");
        cntQuery.append("  START WITH T.TAXONOMY_ID IN (SELECT DISTINCT ts.taxonomy_id ");
        cntQuery.append("   FROM bridge_publish bp, taxonomy_std ts ");
        cntQuery.append("   WHERE bp.publish_id = l_publish_id ");
        cntQuery.append("   AND bp.unpublish_ind = 'N' ");
        cntQuery.append("   AND bp.std_id = ts.std_id) ");
        cntQuery.append("  CONNECT BY NOCYCLE PRIOR T.PRNT_TAXONOMY_ID = T.TAXONOMY_ID; ");
        cntQuery.append(" l_ids number_table := number_table(); ");
        cntQuery.append(" l_id_indx INTEGER := 1; ");

        cntQuery.append("BEGIN ");
        
        cntQuery.append(" FOR rec IN l_tax_cur LOOP ");
        cntQuery.append("  l_ids.EXTEND; ");
        cntQuery.append("  l_ids(l_id_indx) := rec.TAXONOMY_ID; ");
        cntQuery.append("  l_id_indx        := l_id_indx + 1; ");
        cntQuery.append(" END LOOP; ");

        cntQuery.append(" FOR rec IN l_rgn_locale LOOP ");
        cntQuery.append("  l_locale_cd := rec.locale_cd; ");
        
        cntQuery.append("  WITH ");
        cntQuery.append("  TAX_PUBLISH AS ( ");
        cntQuery.append("   SELECT t.taxonomy_id, t.title_txt AS title, xt.title_txt AS title_xlat, "); 
        cntQuery.append("   DECODE(xt.title_txt, NULL, 'N', 'No Translation Found', 'N', 'Y') AS title_xlat_exist ");
        cntQuery.append("   FROM taxonomy t, taxonomy_xlat xt ");
        cntQuery.append("   WHERE t.taxonomy_id = xt.taxonomy_id(+) ");
        cntQuery.append("   AND l_locale_cd = xt.LOCALE_CD(+) ");
        cntQuery.append("   AND t.taxonomy_id IN (SELECT COLUMN_VALUE FROM TABLE(l_ids)) ");
        cntQuery.append("   ), ");
        
        cntQuery.append("  TAX_MISSING_XLAT AS ( ");
        cntQuery.append("   SELECT taxonomy_id ");
        cntQuery.append("   FROM TAX_PUBLISH ");
        cntQuery.append("   WHERE title_xlat_exist = 'N' ");
        cntQuery.append("  ) ");
        
        cntQuery.append("  (SELECT count(*) INTO l_cnt FROM TAX_MISSING_XLAT); ");
        
        cntQuery.append("  l_locale_counts.EXTEND; ");
        cntQuery.append("  l_locale_counts(l_nfields).locale_cd := rec.locale_cd; ");
        cntQuery.append("  l_locale_counts(l_nfields).cnt := l_cnt; ");
        cntQuery.append("  l_nfields := l_nfields + 1; ");
        cntQuery.append(" END LOOP; ");
        
        cntQuery.append(" FOR i IN l_locale_counts.FIRST..l_locale_counts.LAST LOOP "); 
        cntQuery.append("  IF i > 1 THEN  ");
        cntQuery.append("   l_locale_cnt_out := l_locale_cnt_out || ';'; "); 
        cntQuery.append("  END IF; ");
        cntQuery.append("  l_locale_cnt_out := l_locale_cnt_out || l_locale_counts(i).locale_cd || ':' || l_locale_counts(i).cnt; "); 
        cntQuery.append(" END LOOP;  ");
        cntQuery.append(" ? := l_locale_cnt_out; ");
        cntQuery.append("END; ");
        return cntQuery.toString();
    }
    
    /**
     * Declare section for Content, Attachment, Link, and Image Progress queries. 
     * @param allRegions indicator for all regions or global
     * @param cntQuery string buffer
     */
    public static void appendContentAttachLinkImageDeclare(boolean allRegions, StringBuilder cntQuery)
    {
        cntQuery.append("DECLARE ");
        cntQuery.append(" TYPE LOCALE_COUNTS IS RECORD (locale_cd VARCHAR2(5), cnt NUMBER); ");
        cntQuery.append(" TYPE locale_cnt_type IS TABLE OF LOCALE_COUNTS; ");
        cntQuery.append(" l_locale_counts locale_cnt_type := locale_cnt_type(); ");
        cntQuery.append(" l_publish_id NUMBER := ?; ");
        cntQuery.append(" l_rgn_id NUMBER := ?; ");
        cntQuery.append(" l_rgn_cd VARCHAR2(5) := ?; ");
        cntQuery.append(" l_locale_cnt_out VARCHAR2(500); ");
        cntQuery.append(" l_std_id NUMBER; ");

        cntQuery.append(" l_nfields PLS_INTEGER  := 1; ");
        cntQuery.append(" l_locale_cur SYS_REFCURSOR; ");
        cntQuery.append(" l_count PLS_INTEGER  := 0; ");
        cntQuery.append(" l_locale_cd VARCHAR2(10); ");
    
        // Fetch Locales for a Region
        cntQuery.append(" CURSOR l_rgn_locale IS ");
        cntQuery.append("   SELECT DISTINCT l.locale_cd "); 
        cntQuery.append("   FROM brndstnd_locale l, brndstnd_rgn_locale rl, brndstnd_rgn r ");
        cntQuery.append("   WHERE l.actv_ind = 'Y' ");
        cntQuery.append("   AND l.locale_cd = rl.locale_cd ");
        cntQuery.append("   AND r.rgn_id = rl.rgn_id ");
        cntQuery.append("   AND l.locale_cd != 'en_GB' ");
        if(!allRegions){
            cntQuery.append("   AND r.rgn_cd = l_rgn_cd");
        }
        cntQuery.append(";");
    }

    /**
     * This method will return the Missing language Translation count query for Translation Progress section.  
     * @param allRegions boolean to specify consider all regions.
     * @return String SQL Query.
     */
    public static String getContentTranslationProgressQuery(boolean allRegions)
    {
        StringBuilder cntQuery = new StringBuilder();
//        appendContentAttachLinkImageDeclare(allRegions, cntQuery);
        
        cntQuery.append("DECLARE ");
        cntQuery.append(" TYPE LOCALE_COUNTS IS RECORD (locale_cd VARCHAR2(5), cnt NUMBER); ");
        cntQuery.append(" TYPE locale_cnt_type IS TABLE OF LOCALE_COUNTS; ");
        cntQuery.append(" l_locale_counts locale_cnt_type := locale_cnt_type(); ");
        cntQuery.append(" l_publish_id NUMBER := ?; ");
        cntQuery.append(" l_rgn_id NUMBER := ?; ");
        cntQuery.append(" l_rgn_cd VARCHAR2(5) := ?; ");
        cntQuery.append(" l_locale_cnt_out VARCHAR2(500); ");
        cntQuery.append(" l_nfields PLS_INTEGER  := 1; ");
        cntQuery.append(" l_locale_cur SYS_REFCURSOR; ");
        cntQuery.append(" l_count PLS_INTEGER  := 0; ");
        cntQuery.append(" l_locale_cd VARCHAR2(10); ");
        
        //FUNCTION getMissingGlblCnt()
        cntQuery.append(" FUNCTION getMissingGlblCnt (p_publish_id IN NUMBER, p_locale_cd IN VARCHAR2, p_rgn_id IN NUMBER) RETURN NUMBER AS ");
        cntQuery.append(" l_count NUMBER := 0; ");
        cntQuery.append(" BEGIN ");
        cntQuery.append(" WITH ");
        cntQuery.append(" STD_SPEC_IDS AS ( SELECT distinct s.std_id ");
        cntQuery.append(" FROM BRIDGE_PUBLISH bp, std s ");
        cntQuery.append(" WHERE bp.publish_id = p_publish_id ");
        cntQuery.append(" AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append(" AND s.std_id = bp.std_id ");
        cntQuery.append(" AND s.std_typ != 'GDLN' ");
        cntQuery.append(" AND s.stat_desc != 'DELETED' ");
        //cntQuery.append(" AND s.gbl_rgn_ind = 'G' ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" STD_SPEC_CNT AS (SELECT count(*) AS cnt FROM STD_SPEC_IDS), ");
        cntQuery.append(" STD_SPEC_XLAT_CNT AS ( ");
        cntQuery.append(" SELECT COUNT(*) AS cnt FROM "); 
        cntQuery.append(" ( SELECT distinct sx.std_id ");
        cntQuery.append(" FROM std_xlat sx ");
        cntQuery.append(" WHERE sx.TITLE_TXT_VLD_IND = 'Y' ");
        cntQuery.append(" AND sx.TITLE_TXT IS NOT NULL");
        cntQuery.append(" AND sx.locale_cd = p_locale_cd  ");
        cntQuery.append(" AND sx.std_id IN (SELECT std_id FROM STD_SPEC_IDS) ) ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" GDLN_IDS AS ( SELECT distinct s.std_id ");
        cntQuery.append(" FROM BRIDGE_PUBLISH bp, std s ");
        cntQuery.append(" WHERE bp.publish_id = p_publish_id ");
        cntQuery.append(" AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append(" AND s.std_id = bp.std_id ");
        cntQuery.append(" AND s.std_typ = 'GDLN' ");
        cntQuery.append(" AND s.stat_desc != 'DELETED' ");
        //cntQuery.append(" AND s.gbl_rgn_ind = 'G' ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" GDLN_CNT AS (SELECT count(*) AS cnt FROM GDLN_IDS), ");
        cntQuery.append(" GDLN_XLAT_CNT AS ( ");
        cntQuery.append(" SELECT COUNT(*) AS cnt FROM ");
        cntQuery.append(" ( SELECT distinct sx.std_id "); 
        cntQuery.append(" FROM std_xlat sx ");
        cntQuery.append(" WHERE sx.STD_DESC_VLD_IND = 'Y' "); 
        cntQuery.append(" AND sx.STD_DESC IS NOT NULL");
        cntQuery.append(" AND sx.locale_cd = p_locale_cd ");
        cntQuery.append(" AND sx.std_id IN (SELECT std_id FROM GDLN_IDS) ) ");
        cntQuery.append(" ), ");
        cntQuery.append(" TOTAL_CNT AS (SELECT (SELECT cnt FROM STD_SPEC_CNT) - (SELECT cnt FROM STD_SPEC_XLAT_CNT) + (SELECT cnt FROM GDLN_CNT) - (SELECT cnt FROM GDLN_XLAT_CNT) AS cnt FROM dual ) ");
        cntQuery.append(" SELECT * INTO l_count FROM TOTAL_CNT; ");
        cntQuery.append(" RETURN l_count; ");
        cntQuery.append(" END getMissingGlblCnt; ");

        //FUNCTION getMissingTraslRgnCnt()
        cntQuery.append(" FUNCTION getMissingTraslRgnCnt (p_publish_id IN NUMBER, p_locale_cd IN VARCHAR2, p_rgn_id IN NUMBER) RETURN NUMBER AS ");
        cntQuery.append(" l_count NUMBER := 0; ");
        cntQuery.append(" BEGIN ");
        cntQuery.append(" WITH ");
        cntQuery.append(" STD_SPEC_IDS AS ( SELECT distinct s.std_id ");
        cntQuery.append(" FROM BRIDGE_PUBLISH bp, std s ");
        cntQuery.append(" WHERE bp.publish_id = p_publish_id ");
        cntQuery.append(" AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append(" AND s.std_id = bp.std_id ");
        cntQuery.append(" AND s.std_typ != 'GDLN' ");
        cntQuery.append(" AND s.stat_desc != 'DELETED' ");
        //cntQuery.append(" AND s.gbl_rgn_ind != 'G' ");
        cntQuery.append(" AND bp.rgn_id = p_rgn_id ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" STD_SPEC_CNT AS (SELECT count(*) AS cnt FROM STD_SPEC_IDS), ");
        cntQuery.append(" STD_SPEC_XLAT_CNT AS ( ");
        cntQuery.append(" SELECT COUNT(*) AS cnt FROM ");
        cntQuery.append(" ( SELECT distinct sx.std_id "); 
        cntQuery.append(" FROM std_xlat sx ");
        cntQuery.append(" WHERE sx.TITLE_TXT_VLD_IND = 'Y' ");
        cntQuery.append(" AND sx.TITLE_TXT IS NOT NULL");
        cntQuery.append(" AND sx.locale_cd = p_locale_cd ");
        cntQuery.append(" AND sx.std_id IN (SELECT std_id FROM STD_SPEC_IDS) ) ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" GDLN_IDS AS ( SELECT distinct s.std_id ");
        cntQuery.append(" FROM BRIDGE_PUBLISH bp, std s ");
        cntQuery.append(" WHERE bp.publish_id = p_publish_id ");
        cntQuery.append(" AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append(" AND s.std_id = bp.std_id ");
        cntQuery.append(" AND s.std_typ = 'GDLN' ");
        cntQuery.append(" AND s.stat_desc != 'DELETED' ");
        //cntQuery.append(" AND s.gbl_rgn_ind != 'G' ");
        cntQuery.append(" AND bp.rgn_id = p_rgn_id ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" GDLN_CNT AS (SELECT count(*) AS cnt FROM GDLN_IDS), ");
        cntQuery.append(" GDLN_XLAT_CNT AS ( ");
        cntQuery.append(" SELECT COUNT(*) AS cnt FROM ");
        cntQuery.append(" ( SELECT distinct sx.std_id "); 
        cntQuery.append(" FROM std_xlat sx ");
        cntQuery.append(" WHERE sx.STD_DESC_VLD_IND = 'Y' "); 
        cntQuery.append(" AND sx.STD_DESC IS NOT NULL");
        cntQuery.append(" AND sx.locale_cd = p_locale_cd ");
        cntQuery.append(" AND sx.std_id IN (SELECT std_id FROM GDLN_IDS) ) ");
        cntQuery.append(" ), ");
        
        cntQuery.append(" TOTAL_CNT AS (SELECT (SELECT cnt FROM STD_SPEC_CNT) - (SELECT cnt FROM STD_SPEC_XLAT_CNT) + (SELECT cnt FROM GDLN_CNT) - (SELECT cnt FROM GDLN_XLAT_CNT) AS cnt FROM dual ) ");
        cntQuery.append(" SELECT * INTO l_count FROM TOTAL_CNT; ");
        cntQuery.append(" return l_count; ");
        cntQuery.append(" END getMissingTraslRgnCnt; ");

        cntQuery.append("BEGIN ");

        cntQuery.append(" IF l_rgn_id = 1 THEN ");
        cntQuery.append("  OPEN l_locale_cur FOR "); 
        cntQuery.append("   SELECT DISTINCT l.locale_cd ");
        cntQuery.append("   FROM brndstnd_locale l, brndstnd_rgn_locale rl, brndstnd_rgn r "); 
        cntQuery.append("   WHERE l.actv_ind = 'Y' ");
        cntQuery.append("   AND l.locale_cd  = rl.locale_cd ");
        cntQuery.append("   AND r.rgn_id = rl.rgn_id ");
        cntQuery.append("   AND l.locale_cd != 'en_GB'; ");
        cntQuery.append("  LOOP ");
        cntQuery.append("   FETCH l_locale_cur INTO l_locale_cd; ");
        cntQuery.append("   EXIT WHEN l_locale_cur%NOTFOUND; ");
        cntQuery.append("   l_count := getMissingGlblCnt(l_publish_id, l_locale_cd, 1); ");
        cntQuery.append("   l_locale_counts.EXTEND; ");
        cntQuery.append("   l_locale_counts(l_nfields).locale_cd := l_locale_cd; ");
        cntQuery.append("   l_locale_counts(l_nfields).cnt       := l_count; ");
        cntQuery.append("   l_nfields                            := l_nfields + 1; ");
        cntQuery.append("  END LOOP; ");
        cntQuery.append("  CLOSE l_locale_cur; ");
        
        /*cntQuery.append("  FOR rgnId IN 2..5 LOOP ");
        cntQuery.append("    OPEN l_locale_cur FOR "); 
        cntQuery.append("     SELECT DISTINCT l.locale_cd ");
        cntQuery.append("     FROM brndstnd_locale l, brndstnd_rgn_locale rl, brndstnd_rgn r "); 
        cntQuery.append("     WHERE l.actv_ind = 'Y' ");
        cntQuery.append("     AND l.locale_cd  = rl.locale_cd ");
        cntQuery.append("     AND r.rgn_id = rl.rgn_id ");
        cntQuery.append("     AND r.rgn_id = rgnId ");
        cntQuery.append("     AND l.locale_cd != 'en_GB'; ");
        cntQuery.append("    LOOP ");
        cntQuery.append("     FETCH l_locale_cur INTO l_locale_cd; ");
        cntQuery.append("     EXIT WHEN l_locale_cur%NOTFOUND; ");
        cntQuery.append("     l_count := getMissingTraslRgnCnt (l_publish_id, l_locale_cd, rgnId); ");
        cntQuery.append("      FOR i IN l_locale_counts.FIRST..l_locale_counts.LAST ");
        cntQuery.append("      LOOP ");
        cntQuery.append("        IF l_locale_counts(i).locale_cd = l_locale_cd THEN ");
        cntQuery.append("         l_locale_counts(i).cnt := l_locale_counts(i).cnt + l_count; ");
        cntQuery.append("        END IF; ");
        cntQuery.append("      END LOOP; "); 
        cntQuery.append("    END LOOP; ");
        cntQuery.append("    CLOSE l_locale_cur; ");
        cntQuery.append("  END LOOP; ");*/
        
        cntQuery.append(" ELSE ");
        cntQuery.append("  OPEN l_locale_cur FOR "); 
        cntQuery.append("   SELECT DISTINCT l.locale_cd ");
        cntQuery.append("   FROM brndstnd_locale l, brndstnd_rgn_locale rl, brndstnd_rgn r ");
        cntQuery.append("   WHERE l.actv_ind = 'Y' ");
        cntQuery.append("   AND l.locale_cd  = rl.locale_cd ");
        cntQuery.append("   AND r.rgn_id     = rl.rgn_id ");
        cntQuery.append("   AND r.rgn_id = l_rgn_id ");
        cntQuery.append("   AND l.locale_cd != 'en_GB' ; ");
        cntQuery.append("  LOOP ");
        cntQuery.append("   FETCH l_locale_cur INTO l_locale_cd; ");
        cntQuery.append("   EXIT WHEN l_locale_cur%NOTFOUND; ");
        cntQuery.append("   l_count := getMissingTraslRgnCnt(l_publish_id, l_locale_cd, l_rgn_id); ");
        cntQuery.append("   l_locale_counts.EXTEND; ");
        cntQuery.append("   l_locale_counts(l_nfields).locale_cd := l_locale_cd; ");
        cntQuery.append("   l_locale_counts(l_nfields).cnt       := l_count; ");
        cntQuery.append("   l_nfields                            := l_nfields + 1; ");
        cntQuery.append("  END LOOP; ");
        cntQuery.append("  CLOSE l_locale_cur; ");
        cntQuery.append(" END IF; ");
            
        //-- print counters
        cntQuery.append("   FOR i IN l_locale_counts.FIRST..l_locale_counts.LAST LOOP ");
        cntQuery.append("       IF i > 1 THEN ");
        cntQuery.append("           l_locale_cnt_out := l_locale_cnt_out || ';'; ");
        cntQuery.append("       END IF; ");
        cntQuery.append("       l_locale_cnt_out := l_locale_cnt_out || l_locale_counts(i).locale_cd || ':' || l_locale_counts(i).cnt; ");
        cntQuery.append("   END LOOP; ");
        
        cntQuery.append("   ? := l_locale_cnt_out; ");
        cntQuery.append("END; ");
        
        return cntQuery.toString();
    }

    /**
     * This method will return the Missing Attachment language Translation count query for Translation Progress section.  
     * @param allRegions boolean to specify consider all regions.
     * @return String SQL Query.
     */
    public static String getAttachTranslationProgressQuery(boolean allRegions)
    {
        StringBuilder cntQuery = new StringBuilder();
        appendContentAttachLinkImageDeclare(allRegions, cntQuery);
        
        cntQuery.append(" l_chain_cd VARCHAR2(2) := ?; ");
    
        cntQuery.append("BEGIN ");
        // Init locale counters
        cntQuery.append(" FOR rec IN l_rgn_locale LOOP ");
        cntQuery.append(" WITH ");
        cntQuery.append(" STD_SPEC_IDS AS ( SELECT DISTINCT s.std_id, sa.std_attachement_id, sa.prnt_std_attachment_id ");
        cntQuery.append("   FROM BRIDGE_PUBLISH bp, std s, std_attachment sa, std_attachment_chain sah ");
        cntQuery.append("   WHERE bp.publish_id = l_publish_id "); 
        cntQuery.append("   AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append("   AND s.std_id = bp.std_id ");
        cntQuery.append("   AND s.std_id = sa.std_id ");
        cntQuery.append("   AND sa.std_attachement_id = sah.std_attachement_id ");
        cntQuery.append("   AND sa.std_attachement_id = sa.prnt_std_attachment_id "); 
        cntQuery.append("   AND sah.chain_cd = l_chain_cd ");
        cntQuery.append("   AND sa.locale_cd = 'en_GB' ");
        cntQuery.append("   AND s.stat_desc != 'DELETED' ");
        if(!allRegions){
            cntQuery.append("  AND bp.rgn_id = l_rgn_id ");
        } 
        cntQuery.append(" ), ");
        cntQuery.append(" STD_SPEC_CNT AS (SELECT count(*) AS cnt FROM STD_SPEC_IDS), ");
        cntQuery.append(" STD_SPEC_XLAT_CNT AS ( ");
        cntQuery.append("   SELECT COUNT(*) AS cnt FROM ");
        cntQuery.append("   ( SELECT DISTINCT sa.std_id, sa.std_attachement_id ");
        cntQuery.append("   FROM std_attachment sa, STD_SPEC_IDS s "); 
        cntQuery.append("   WHERE sa.std_id = s.std_id ");
        cntQuery.append("   AND sa.prnt_std_attachment_id = s.prnt_std_attachment_id ");
        cntQuery.append("   AND sa.locale_cd = rec.locale_cd) "); 
        cntQuery.append(" ), ");
        cntQuery.append(" TOTAL_CNT AS (SELECT (SELECT cnt FROM STD_SPEC_CNT) - (SELECT cnt FROM STD_SPEC_XLAT_CNT) AS cnt FROM dual ) ");
        cntQuery.append(" SELECT * INTO l_count FROM TOTAL_CNT; ");
        
        cntQuery.append("   l_locale_counts.EXTEND; ");
        cntQuery.append("   l_locale_counts(l_nfields).locale_cd := rec.locale_cd; ");
        cntQuery.append("   l_locale_counts(l_nfields).cnt := l_count; ");
        cntQuery.append("   l_nfields := l_nfields + 1; ");
        cntQuery.append(" END LOOP; ");

        //-- print counters
        cntQuery.append("   FOR i IN l_locale_counts.FIRST..l_locale_counts.LAST LOOP ");
        cntQuery.append("       IF i > 1 THEN ");
        cntQuery.append("           l_locale_cnt_out := l_locale_cnt_out || ';'; ");
        cntQuery.append("       END IF; ");
        cntQuery.append("       l_locale_cnt_out := l_locale_cnt_out || l_locale_counts(i).locale_cd || ':' || l_locale_counts(i).cnt; ");
        cntQuery.append("   END LOOP; ");
        
        cntQuery.append("   ? := l_locale_cnt_out; ");
        cntQuery.append("END; ");
        
        return cntQuery.toString();
    }

    /**
     * This method will return the Missing Links language Translation count query for Translation Progress section.  
     * @param allRegions boolean to specify consider all regions.
     * @return String SQL Query.
     */
    public static String getLinksTranslationProgressQuery(boolean allRegions)
    {
        StringBuilder cntQuery = new StringBuilder();
        appendContentAttachLinkImageDeclare(allRegions, cntQuery);
        
        cntQuery.append(" l_chain_cd VARCHAR2(2) := ?; ");
        
        cntQuery.append("BEGIN ");
        // Init locale counters
        cntQuery.append(" FOR rec IN l_rgn_locale LOOP ");
        cntQuery.append(" WITH ");
        cntQuery.append(" STD_SPEC_IDS AS ( SELECT DISTINCT s.std_id, sl.std_extl_link_id, sl.prnt_std_extl_link_id ");
        cntQuery.append("   FROM BRIDGE_PUBLISH bp, std s, std_extl_link sl, std_extl_link_chain slc ");
        cntQuery.append("   WHERE bp.publish_id = l_publish_id "); 
        cntQuery.append("   AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append("   AND s.std_id = bp.std_id ");
        cntQuery.append("   AND s.std_id = sl.std_id ");
        cntQuery.append("   AND sl.std_extl_link_id = slc.std_extl_link_id ");
        cntQuery.append("   AND sl.std_extl_link_id = sl.prnt_std_extl_link_id "); 
        cntQuery.append("   AND slc.chain_cd = l_chain_cd ");
        cntQuery.append("   AND sl.locale_cd = 'en_GB' ");
        cntQuery.append("   AND s.stat_desc != 'DELETED' ");
        if(!allRegions){
            cntQuery.append("  AND bp.rgn_id = l_rgn_id ");
        } 
        cntQuery.append(" ), ");
        cntQuery.append(" STD_SPEC_CNT AS (SELECT count(*) AS cnt FROM STD_SPEC_IDS), ");
        cntQuery.append(" STD_SPEC_XLAT_CNT AS ( ");
        cntQuery.append("   SELECT COUNT(*) AS cnt FROM ");
        cntQuery.append("   ( SELECT DISTINCT sl.std_id, sl.std_extl_link_id ");
        cntQuery.append("   FROM std_extl_link sl, STD_SPEC_IDS s "); 
        cntQuery.append("   WHERE sl.std_id = s.std_id ");
        cntQuery.append("   AND sl.prnt_std_extl_link_id = s.prnt_std_extl_link_id ");
        cntQuery.append("   AND sl.locale_cd = rec.locale_cd) "); 
        cntQuery.append(" ), ");
        cntQuery.append(" TOTAL_CNT AS (SELECT (SELECT cnt FROM STD_SPEC_CNT) - (SELECT cnt FROM STD_SPEC_XLAT_CNT) AS cnt FROM dual ) ");
        cntQuery.append(" SELECT * INTO l_count FROM TOTAL_CNT; ");
        
        cntQuery.append("   l_locale_counts.EXTEND; ");
        cntQuery.append("   l_locale_counts(l_nfields).locale_cd := rec.locale_cd; ");
        cntQuery.append("   l_locale_counts(l_nfields).cnt := l_count; ");
        cntQuery.append("   l_nfields := l_nfields + 1; ");
        cntQuery.append(" END LOOP; ");
        
        //-- print counters
        cntQuery.append("   FOR i IN l_locale_counts.FIRST..l_locale_counts.LAST LOOP ");
        cntQuery.append("       IF i > 1 THEN ");
        cntQuery.append("           l_locale_cnt_out := l_locale_cnt_out || ';'; ");
        cntQuery.append("       END IF; ");
        cntQuery.append("       l_locale_cnt_out := l_locale_cnt_out || l_locale_counts(i).locale_cd || ':' || l_locale_counts(i).cnt; ");
        cntQuery.append("   END LOOP; ");
        
        cntQuery.append("   ? := l_locale_cnt_out; ");
        
        cntQuery.append("END; ");
        
        return cntQuery.toString();
    }

    /**
     * This method will return the Missing Attachment language Translation count query for Translation Progress section.  
     * @param allRegions boolean to specify consider all regions.
     * @return String SQL Query.
     */
    public static String getImageTranslationProgressQuery(boolean allRegions)
    {
        StringBuilder cntQuery = new StringBuilder();
        appendContentAttachLinkImageDeclare(allRegions, cntQuery);
        
        cntQuery.append(" l_chain_cd VARCHAR2(2) := ?; ");
        
        cntQuery.append("BEGIN ");
        // Init locale counters
        cntQuery.append(" FOR rec IN l_rgn_locale LOOP ");
        cntQuery.append(" WITH ");
        cntQuery.append(" STD_SPEC_IDS AS ( SELECT DISTINCT s.std_id, si.std_image_id, si.prnt_std_image_id ");
        cntQuery.append("   FROM BRIDGE_PUBLISH bp, std s, std_image si, std_image_chain sic ");
        cntQuery.append("   WHERE bp.publish_id = l_publish_id "); 
        cntQuery.append("   AND bp.UNPUBLISH_IND = 'N' ");
        cntQuery.append("   AND s.std_id = bp.std_id ");
        cntQuery.append("   AND s.std_id = si.std_id ");
        cntQuery.append("   AND si.std_image_id = sic.std_image_id ");
        cntQuery.append("   AND si.std_image_id = si.prnt_std_image_id "); 
        cntQuery.append("   AND sic.chain_cd = l_chain_cd ");
        cntQuery.append("   AND si.locale_cd = 'en_GB' ");
        cntQuery.append("   AND s.stat_desc != 'DELETED' ");
        if(!allRegions){
            cntQuery.append("  AND bp.rgn_id = l_rgn_id ");
        } 
        cntQuery.append(" ), ");
        cntQuery.append(" STD_SPEC_CNT AS (SELECT count(*) AS cnt FROM STD_SPEC_IDS), ");
        cntQuery.append(" STD_SPEC_XLAT_CNT AS ( ");
        cntQuery.append("   SELECT COUNT(*) AS cnt FROM ");
        cntQuery.append("   ( SELECT DISTINCT si.std_id, si.std_image_id ");
        cntQuery.append("   FROM std_image si, STD_SPEC_IDS s "); 
        cntQuery.append("   WHERE si.std_id = s.std_id ");
        cntQuery.append("   AND si.prnt_std_image_id = s.prnt_std_image_id ");
        cntQuery.append("   AND si.locale_cd = rec.locale_cd) "); 
        cntQuery.append(" ), ");
        cntQuery.append(" TOTAL_CNT AS (SELECT (SELECT cnt FROM STD_SPEC_CNT) - (SELECT cnt FROM STD_SPEC_XLAT_CNT) AS cnt FROM dual ) ");
        cntQuery.append(" SELECT * INTO l_count FROM TOTAL_CNT; ");
        
        cntQuery.append("   l_locale_counts.EXTEND; ");
        cntQuery.append("   l_locale_counts(l_nfields).locale_cd := rec.locale_cd; ");
        cntQuery.append("   l_locale_counts(l_nfields).cnt := l_count; ");
        cntQuery.append("   l_nfields := l_nfields + 1; ");
        cntQuery.append(" END LOOP; ");
        
        //-- print counters
        cntQuery.append("   FOR i IN l_locale_counts.FIRST..l_locale_counts.LAST LOOP ");
        cntQuery.append("       IF i > 1 THEN ");
        cntQuery.append("           l_locale_cnt_out := l_locale_cnt_out || ';'; ");
        cntQuery.append("       END IF; ");
        cntQuery.append("       l_locale_cnt_out := l_locale_cnt_out || l_locale_counts(i).locale_cd || ':' || l_locale_counts(i).cnt; ");
        cntQuery.append("   END LOOP; ");
        
        cntQuery.append("   ? := l_locale_cnt_out; ");
        
        cntQuery.append("END; ");
        
        return cntQuery.toString();
    }

    /**
     * This method will generate query to get Standards for Progress View Details based on the request.
     * @param publishId The publish id.
     * @param regionId The region id.
     * @param statIndText The status indicator text.
     * @return
     */
    public static String getProgressViewDetailsQuery(long publishId, long regionId, String chainCode, Date publishDate, String localeCode, String statIndText)
    {
        StringBuilder query;
        
        if(BridgeConstants.STAT_IND_DISCONTINUED.equalsIgnoreCase(statIndText))
        {
            query = getProgressDiscontinuedViewDetail(publishId, regionId, statIndText);
        }
        else if(BridgeConstants.STAT_IND_UNATTRIBUTE_BRAND.equalsIgnoreCase(statIndText))
        {
            query = getProgressUnattributeBrandViewDetail(publishId, regionId, statIndText);
        }
        else if(BridgeConstants.STAT_IND_UNATTRIBUTE_REGION.equalsIgnoreCase(statIndText))
        {
            query = getProgressUnattributeRegionViewDetail(publishId, regionId, statIndText);
        }
        else if(BridgeConstants.STAT_IND_OVERRIDDEN.equalsIgnoreCase(statIndText))
        {
            query = getProgressOverriddenViewDetail(publishId, regionId, statIndText);
        }
        else if(BridgeConstants.STAT_IND_GLBL_MUST.equalsIgnoreCase(statIndText))
        {
            query = getProgressGlobalMustViewDetail(publishId, regionId, statIndText);
        }
        else if(BridgeConstants.STAT_IND_GLBL_NOT_IN_MUST.equalsIgnoreCase(statIndText))
        {
            query = getProgressGlobalNotInMustViewDetail(publishId, regionId, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_GLBL_MUST_NOT.equalsIgnoreCase(statIndText))
        {
            query = getProgressGlobalMustNotViewDetail(publishId, regionId, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_SELECT_STATE.equalsIgnoreCase(statIndText))
        {
            query = getProgressSelectStateViewDetail(publishId, regionId, statIndText);
        }
        else if(BridgeConstants.STAT_IND_MISS_XREF.equalsIgnoreCase(statIndText))
        {
            query = getProgressMissingXrefViewDetail(publishId, regionId, statIndText);
        }  
        else if(BridgeConstants.STAT_IND_EXPIRED_DATE.equalsIgnoreCase(statIndText))
        {
            query = getProgressExpiredDateViewDetail(publishId, regionId, chainCode, publishDate, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_COMPLIANCE_DATE.equalsIgnoreCase(statIndText))
        {
            query = getProgressComplianceDateViewDetail(publishId, regionId, chainCode, publishDate, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_NOFITICATION.equalsIgnoreCase(statIndText))
        {
            query = getProgressNotificationViewDetail(publishId, regionId);
        } 
        else if(BridgeConstants.STAT_IND_ALL_NOFITICATION.equalsIgnoreCase(statIndText))
        {
            query = getProgressAllNotificationViewDetail(publishId, regionId);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_INDEX.equalsIgnoreCase(statIndText))
        {
            query = getProgressIndexTranslationViewDetail(publishId, regionId, localeCode, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_CONTENT.equalsIgnoreCase(statIndText))
        {
            query = getProgressContentTranslationViewDetail(publishId, regionId, chainCode, localeCode, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_ATTACH.equalsIgnoreCase(statIndText))
        {
            query = getProgressAttachmentTranslationViewDetail(publishId, regionId, chainCode, localeCode, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_LINKS.equalsIgnoreCase(statIndText))
        {
            query = getProgressLinksTranslationViewDetail(publishId, regionId, chainCode, localeCode, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_IMAGES.equalsIgnoreCase(statIndText))
        {
            query = getProgressImagesTranslationViewDetail(publishId, regionId, chainCode, localeCode, statIndText);
        } 
        else if(BridgeConstants.STAT_IND_ALL.equalsIgnoreCase(statIndText))
        {
            query = getAllProgressViewDetails(publishId, regionId, chainCode, publishDate);
        } 
        else
        {
            query = new StringBuilder();
            LOG.error("Unknown Progress Details type: " + statIndText);
        }
        
        return query.toString();
    }
    
    public static StringBuilder getAllProgressViewDetails(long publishId, long regionId, String chainCode, Date publishDate)
    {
        String dateStr = new SimpleDateFormat("dd MMM yyyy").format(publishDate);
        StringBuilder query = new StringBuilder();
        query.append("WITH ");
        query.append("BR_STD AS (SELECT bp.bridge_publish_id, bp.std_id, bp.rgn_id, p.chain_cd, p.publish_id, bp.unpublish_ind");
        query.append(" FROM bridge_publish bp, publish p");
        query.append(" WHERE bp.publish_id = p.publish_id");
        query.append(" AND p.publish_id = ").append(publishId);
        query.append(" AND bp.rgn_id = ").append(regionId).append("), ");
//        query.append("BR_UNPUB_STD AS (SELECT bp.bridge_publish_id, bp.std_id, bp.rgn_id, bp.chain_cd, bp.publish_id");
//        query.append(" FROM BR_STD bp");
//        query.append(" WHERE bp.unpublish_ind = 'Y' ), ");
        query.append("BR_PUB_STD AS (SELECT bp.bridge_publish_id, bp.std_id, bp.rgn_id, bp.chain_cd, bp.publish_id");
        query.append(" FROM BR_STD bp");
        query.append(" WHERE bp.unpublish_ind = 'N' ), ");
        query.append("DISCONTINUED_STD AS (");
        query.append(" SELECT bp.std_id, 'Discontinued or Insight' AS stat_desc");
        query.append(" FROM BR_PUB_STD bp, chain_std cs, stat st");
        query.append(" WHERE bp.std_id = cs.std_id");
        query.append(" AND bp.chain_cd = cs.chain_cd");
        query.append(" AND cs.stat_id = st.stat_id");
        query.append(" AND cs.actv_ind = 'Y'");
        query.append(" AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')), ");
        query.append("UNATTRIBUTE_BRAND AS (");
        query.append(" SELECT std_id, 'Unattributed Brand' AS stat_desc"); 
        query.append(" FROM (SELECT std_id");
        query.append(" FROM BR_PUB_STD");
        query.append(" MINUS");
        query.append(" SELECT bp.std_id"); 
        query.append(" FROM BR_PUB_STD bp, chain_std cs");
        query.append(" WHERE bp.std_id = cs.std_id");
        query.append(" AND bp.chain_cd = cs.chain_cd");
        query.append(" AND cs.actv_ind = 'Y')");
        query.append(" WHERE std_id NOT IN (SELECT std_id FROM DISCONTINUED_STD)), ");
        query.append("EXCLUDE_STD_1 AS (");
        query.append(" SELECT std_id FROM DISCONTINUED_STD");
        query.append(" UNION ");
        query.append(" SELECT std_id FROM UNATTRIBUTE_BRAND), ");
        query.append("UNATTRIBUTE_RGN AS (");
        query.append(" SELECT std_id, 'Unattributed Region' AS stat_desc"); 
        query.append(" FROM (");
        query.append(" SELECT bp.std_id");
        query.append(" FROM BR_PUB_STD bp, chain_std cs"); 
        query.append(" WHERE bp.std_id = cs.std_id"); 
        query.append(" AND bp.chain_cd = cs.chain_cd"); 
        query.append(" AND cs.actv_ind = 'Y'");
        query.append(" MINUS"); 
        query.append(" SELECT DISTINCT bp.std_id");
        query.append(" FROM BR_PUB_STD bp, ctry_std cs");
        query.append(" WHERE bp.std_id = cs.std_id"); 
        query.append(" AND cs.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = bp.rgn_id))");
        query.append(" WHERE std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_1)), ");
        query.append("EXCLUDE_STD_2 AS (");
        query.append(" SELECT std_id FROM EXCLUDE_STD_1");
        query.append(" UNION"); 
        query.append(" SELECT std_id FROM UNATTRIBUTE_RGN), ");
        query.append("BR_GBL_PUB AS (SELECT bridge_gbl_publish_id, std_id, must_publish_ind FROM BRIDGE_GBL_PUBLISH WHERE publish_id = ");
        query.append(publishId).append("), ");
        query.append("GLOBAL_MUST AS (");
        query.append(" SELECT std_id, 'Global Must' AS stat_desc"); 
        query.append(" FROM (");
        query.append(" SELECT bp.std_id");
        query.append(" FROM BR_GBL_PUB bp, ctry_std cs");
        query.append(" WHERE bp.must_publish_ind = 'Y'"); 
        query.append(" AND bp.std_id = cs.std_id");
        query.append(" AND cs.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ").append(regionId).append(")");
        query.append(" MINUS ");
        query.append(" SELECT std_id"); 
        query.append(" FROM BR_PUB_STD)");
        query.append(" WHERE std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_2)");
//        query.append(" AND std_id NOT IN (SELECT std_id FROM BR_UNPUB_STD)), ");
        query.append(" ), ");
        query.append("EXCLUDE_STD_3 AS (");
        query.append(" SELECT std_id FROM EXCLUDE_STD_2");
        query.append(" UNION"); 
        query.append(" SELECT std_id FROM GLOBAL_MUST), ");
        query.append("GLOBAL_NOT_IN_MUST AS (");
        query.append(" SELECT std_id, 'Global Not In Must' AS stat_desc"); 
        query.append(" FROM (");
        query.append(" SELECT bp.std_id");
        query.append(" FROM BR_PUB_STD bp, STD s"); 
        query.append(" WHERE bp.std_id = s.std_id");
        query.append(" AND s.rgn_cd = 'GLBL' ");
        query.append(" MINUS ");
        query.append(" SELECT std_id FROM BR_GBL_PUB WHERE must_publish_ind = 'Y')");
        query.append(" WHERE std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_3) ");
//        query.append(" AND std_id NOT IN (SELECT std_id FROM BR_UNPUB_STD)), ");
        query.append(" ), ");
        query.append("EXCLUDE_STD_4 AS (");
        query.append(" SELECT std_id FROM EXCLUDE_STD_3");
        query.append(" UNION ");
        query.append(" SELECT std_id FROM GLOBAL_NOT_IN_MUST), ");
        query.append("GLOBAL_MUST_NOT AS (");
        query.append(" SELECT bp.std_id, 'Global Must Not' AS stat_desc");
        query.append(" FROM BR_PUB_STD bp, BR_GBL_PUB bgp");
        query.append(" WHERE bp.std_id = bgp.std_id");
        query.append(" AND bgp.must_publish_ind = 'N'");
        query.append(" AND bp.std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_4)), ");
        query.append("EXCLUDE_STD_5 AS (");
        query.append(" SELECT std_id FROM EXCLUDE_STD_4");
        query.append(" UNION ");
        query.append(" SELECT std_id FROM GLOBAL_MUST_NOT), ");
        query.append("SELECT_STATE_ISSUES AS (");
        query.append(" SELECT std_id, 'Select State' AS stat_desc"); 
        query.append(" FROM BR_PUB_STD bp, BRIDGE_PUBLISH_CTRY bpc ");
        query.append(" WHERE bp.BRIDGE_PUBLISH_ID = bpc.BRIDGE_PUBLISH_ID"); 
        query.append(" AND bpc.BRIDGE_PUBLISH_STAT_CD = 'SELECT'");
        query.append(" AND std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_5)), "); 
        query.append("EXCLUDE_STD_6 AS (");
        query.append(" SELECT std_id FROM EXCLUDE_STD_5");
        query.append(" UNION ");
        query.append(" SELECT std_id FROM SELECT_STATE_ISSUES), ");
        query.append("EXPIRED_STD AS (");
        query.append(" SELECT * FROM (SELECT sc.std_id, 'Expired Date' AS stat_desc,");
        query.append(" NVL((SELECT decode(std_id, NULL, 'N', 'Y')");
        query.append(" FROM std_ctry_chain");
        query.append(" WHERE std_id = sc.std_id");
        query.append(" AND chain_cd = sc.chain_cd");
        query.append(" AND ctry_nm_cd = sc.ctry_nm_cd), 'N') is_published");
        query.append(" FROM BR_PUB_STD b, std_cmply sc ");
        query.append(" WHERE b.std_id = sc.std_id ");
        query.append(" AND sc.chain_cd = b.chain_cd ");
        query.append(" AND sc.CMPLY_EXPR_RULE_CD = 'E' ");
        query.append(" AND sc.RULE_DT_CD = 'D' ");
        query.append(" AND sc.cmply_expr_dt IS NOT NULL"); 
        query.append(" AND sc.cmply_expr_dt <= to_date('").append(dateStr).append("', 'DD MON YYYY')"); 
        query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ").append(regionId).append("))");
        query.append(" WHERE is_published = 'N'");
        query.append(" AND std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_6)), "); 
        query.append("EXCLUDE_STD_7 AS (");
        query.append(" SELECT std_id FROM EXCLUDE_STD_6");
        query.append(" UNION ");
        query.append(" SELECT std_id FROM EXPIRED_STD), ");
        query.append("COMPLIANCE_STD AS (");
        query.append(" SELECT * FROM (SELECT sc.std_id, 'Compliance Date' AS stat_desc,");
        query.append(" NVL((SELECT decode(std_id, NULL, 'N', 'Y')");
        query.append(" FROM std_ctry_chain");
        query.append(" WHERE std_id = sc.std_id");
        query.append(" AND chain_cd = sc.chain_cd");
        query.append(" AND ctry_nm_cd = sc.ctry_nm_cd), 'N') is_published");
        query.append(" FROM BR_PUB_STD b, std_cmply sc ");
        query.append(" WHERE b.std_id = sc.std_id ");
        query.append(" AND sc.chain_cd = b.chain_cd ");
        query.append(" AND ((sc.CMPLY_EXPR_RULE_CD = 'C'"); 
        query.append(" AND sc.RULE_DT_CD = 'D' ");
        query.append(" AND sc.cmply_expr_dt IS NOT NULL"); 
        query.append(" AND sc.cmply_expr_dt < to_date('").append(dateStr).append("', 'DD MON YYYY'))"); 
        query.append(" OR (sc.CMPLY_EXPR_RULE_CD = 'C' ");
        query.append(" AND sc.RULE_DT_CD = 'R' ");
        query.append(" AND sc.cmply_expr_dt IS NOT NULL"); 
        query.append(" AND sc.cmply_expr_dt < add_months(to_date('").append(dateStr).append("', 'DD MON YYYY'), NVL(sc.cmply_rule_mo_qty, 0))))"); 
        query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ").append(regionId).append("))");
        query.append(" WHERE is_published = 'N'");
        query.append(" AND std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_7)), "); 
        query.append("SELECTED_STD_IDS AS (");
        query.append(" SELECT std_id, stat_desc, remove_ind"); 
        query.append(" FROM");
        query.append(" (");
        query.append("   SELECT std_id, stat_desc, 1 remove_ind FROM DISCONTINUED_STD");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 1 remove_ind FROM UNATTRIBUTE_BRAND");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 1 remove_ind FROM UNATTRIBUTE_RGN");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 0 remove_ind FROM GLOBAL_MUST");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 1 remove_ind FROM GLOBAL_NOT_IN_MUST");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 1 remove_ind FROM GLOBAL_MUST_NOT");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 0 remove_ind FROM SELECT_STATE_ISSUES");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 0 remove_ind FROM EXPIRED_STD");
        query.append("   UNION ");
        query.append("   SELECT std_id, stat_desc, 0 remove_ind FROM COMPLIANCE_STD");
        query.append(" )");
        query.append(" UNION ");
        query.append(" SELECT prnt_std_id, '' stat_desc, 0 remove_ind ");
        query.append(" FROM STD ");
        query.append(" WHERE std_id IN (SELECT std_id FROM EXCLUDE_STD_7)");
        query.append(" AND prnt_std_id NOT IN (SELECT std_id FROM EXCLUDE_STD_7) ");
//        query.append(" AND std_id NOT IN (SELECT std_id FROM BR_UNPUB_STD)), ");
        query.append(" ), ");
        query.append("SELECTED_STD_REC AS ( ");
        query.append(" SELECT s.std_id, s.prnt_std_id, s.std_typ, s.title_txt, s.std_desc, ss.stat_desc, ");
        query.append(" nvl((SELECT disp_order_nbr FROM std_display_order WHERE std_id = s.std_id AND rgn_cd = rgn.rgn_cd");
        query.append(" AND chain_cd = '").append(chainCode).append("'), 0) disp_order_nbr, ss.remove_ind"); 
        query.append(" FROM STD s, SELECTED_STD_IDS ss,");
        query.append(" (SELECT rgn_cd FROM brndstnd_rgn WHERE rgn_id = ").append(regionId).append(") rgn");
        query.append(" WHERE s.std_id = ss.std_id), ");
        query.append("CMS_TAXONOMY AS ( ");
        query.append(" SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT,"); 
        query.append(" SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH ");
        query.append(" FROM TAXONOMY T WHERE T.TAXONOMY_ID > 1 START WITH T.TAXONOMY_ID = 1 ");
        query.append(" CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID), ");
        query.append("DIRECT_MATCH AS ( ");
        query.append(" SELECT tax.indx_order, tax.taxonomy_id, tax.prnt_taxonomy_id, tax.lvl, tax.hier_lvl_nbr, tax.path, tax.taxonomy_desc,"); 
        query.append(" tax.title_txt as index_title, ssr.prnt_std_id, ssr.std_id, ssr.std_typ, ssr.title_txt, ssr.std_desc, ssr.stat_desc, ssr.disp_order_nbr, ssr.remove_ind");
        query.append(" FROM cms_taxonomy tax, taxonomy_std tstd, selected_std_rec ssr ");
        query.append(" WHERE tax.taxonomy_id = tstd.taxonomy_id ");
        query.append(" AND (tstd.std_id = ssr.std_id OR tstd.std_id = ssr.prnt_std_id)) ");
        
        query.append("(SELECT * FROM DIRECT_MATCH ");
        query.append("UNION ");
        query.append("SELECT DISTINCT tax.indx_order, tax.taxonomy_id, tax.prnt_taxonomy_id, tax.lvl, tax.hier_lvl_nbr, tax.path, tax.taxonomy_desc, "); 
        query.append("tax.title_txt as index_title, ssr.prnt_std_id, ssr.std_id, ssr.std_typ, ssr.title_txt, ssr.std_desc, ssr.stat_desc, ssr.disp_order_nbr, ssr.remove_ind ");
        query.append("FROM cms_taxonomy tax, taxonomy_std tstd, selected_std_rec ssr ");
        query.append("WHERE tax.taxonomy_id = tstd.taxonomy_id ");
        query.append("AND tstd.std_id IN (SELECT std_id FROM direct_match WHERE std_id = prnt_std_id) "); 
        query.append("AND tstd.std_id = ssr.std_id) ");
        
        return query;
    }

    public static void appendProgressViewDetailCommonQuery(long publishId, long regionId, StringBuilder query)
    {
        query.append("SELECTED_STD_REC AS ( ");
        query.append("SELECT s.std_id, s.prnt_std_id, s.std_typ, s.title_txt, s.std_desc, ss.stat_desc, s.disp_order_nbr ");
        query.append("FROM STD s, SELECTED_STD_IDS ss WHERE s.STD_ID = ss.STD_ID), ");
        
        query.append(" DISP_ORDER AS (SELECT disp.disp_order_nbr, disp.std_id from std_display_order disp where disp.std_id in (select std_id from SELECTED_STD_REC) ");
        query.append(" AND disp.rgn_cd=(SELECT RGN_CD FROM BRNDSTND_RGN WHERE RGN_ID=").append(regionId);
        query.append(") AND disp.chain_cd = (SELECT CHAIN_CD FROM PUBLISH WHERE PUBLISH_ID=").append(publishId).append(")),");
        
        query.append("CMS_TAXONOMY AS ( ");
        query.append("SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, ");
        query.append("SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH ");
        query.append("FROM TAXONOMY T WHERE T.TAXONOMY_ID > 1 START WITH T.TAXONOMY_ID = 1 ");
        query.append("CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID), ");
        
        query.append("DIRECT_MATCH AS ( ");
        query.append("SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE, ");
        query.append("SSR.prnt_std_id, SSR.std_id, SSR.std_typ, SSR.title_txt, SSR.std_desc, SSR.stat_desc, COALESCE(DISP.disp_order_nbr, 0) disp_order_nbr ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, SELECTED_STD_REC SSR, DISP_ORDER DISP ");
        query.append("WHERE TAX.TAXONOMY_ID=TSTD.TAXONOMY_ID AND SSR.std_id = SSR.prnt_std_id AND TSTD.STD_ID = SSR.prnt_std_id AND SSR.std_id = DISP.std_id(+)) ");
        
        query.append("(SELECT * FROM DIRECT_MATCH ");
        query.append("UNION ");
        query.append("SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE, ");
        query.append("SSR.prnt_std_id, SSR.std_id, SSR.std_typ, SSR.title_txt, SSR.std_desc, SSR.stat_desc, COALESCE(DISP.disp_order_nbr, 0) disp_order_nbr ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, SELECTED_STD_REC SSR, DISP_ORDER DISP ");
        query.append("WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID AND TSTD.STD_ID IN (SELECT prnt_std_id FROM DIRECT_MATCH ) AND TSTD.STD_ID = SSR.prnt_std_id AND SSR.std_id = DISP.std_id(+))) ");
    }

    public static StringBuilder getProgressDiscontinuedViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH ");
        query.append("DISCONTINUED_STD AS ( ");
        query.append("SELECT s.std_id ");
        query.append("FROM publish p, bridge_publish bp, std s, chain_std cs, stat st ");
        query.append("WHERE p.publish_id = ").append(publishId).append(" ");
        query.append("AND p.publish_id = bp.publish_id ");
        query.append("AND p.chain_cd = cs.chain_cd ");
        query.append("AND bp.std_id = cs.std_id ");
        query.append("AND bp.unpublish_ind = 'N' ");
        query.append("AND cs.stat_id = st.stat_id ");
        query.append("AND s.std_id = bp.std_id ");
        if(regionId != 1)
        {
            query.append("AND bp.rgn_id = ").append(regionId).append(" ");
        }
        query.append("AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        if(regionId == 1){
        	query.append(" UNION SELECT s.std_id FROM publish p, BRIDGE_GBL_PUBLISH bp, std s, chain_std cs, stat st WHERE p.publish_id =");
            query.append(publishId);
        	query.append(" AND p.publish_id = bp.publish_id AND p.chain_cd = cs.chain_cd AND bp.std_id = cs.std_id "); 
        	query.append(" AND bp.MUST_PUBLISH_IND = 'Y' AND cs.stat_id = st.stat_id AND s.std_id = bp.std_id AND st.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        }
        query.append("),");
        
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM DISCONTINUED_STD");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM DISCONTINUED_STD)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM DISCONTINUED_STD)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }

    public static StringBuilder getProgressUnattributeBrandViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM (WITH UNATTRIBUTE_STD AS (");
        query.append(" SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
        if(regionId != 1) {
        	query.append(" AND RGN_ID=").append(regionId);
        }
        query.append(" MINUS SELECT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs");
        query.append(" WHERE bp.PUBLISH_ID=p.PUBLISH_ID AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y'");
        query.append(" AND bp.UNPUBLISH_IND='N' AND p.PUBLISH_ID=").append(publishId);
        if(regionId != 1) {
            query.append(" AND bp.RGN_ID=").append(regionId);
        }
        if(regionId == 1) {
        	//Count Unattributed Brand from Global Must Publish standards as well.
	        query.append(" UNION  SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
	        query.append(" MINUS SELECT bgp.std_id FROM BRIDGE_GBL_PUBLISH bgp, Publish p, chain_std cs"); 
	        query.append(" WHERE bgp.PUBLISH_ID = p.PUBLISH_ID AND bgp.std_id = cs.std_id AND cs.chain_cd = p.CHAIN_CD AND cs.actv_ind = 'Y'");
	        query.append(" AND bgp.MUST_PUBLISH_IND='Y' AND p.PUBLISH_ID=").append(publishId);
        }
        query.append("), ");
        
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM UNATTRIBUTE_STD");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM UNATTRIBUTE_STD)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM UNATTRIBUTE_STD)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressUnattributeRegionViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM (WITH UNATTRIBUTE_STD AS (");
        if(regionId != 1) {
        	query.append(" SELECT DISTINCT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs WHERE bp.PUBLISH_ID=p.PUBLISH_ID");
        	query.append(" AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
	        query.append(" AND bp.RGN_ID=").append(regionId);
	        query.append(" MINUS SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, CTRY_STD cs, BRNDSTND_CTRY bc");
	        query.append(" WHERE bp.STD_ID=cs.STD_ID AND cs.CTRY_NM_CD=bc.CTRY_NM_CD");
	        query.append(" AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
	        query.append(" AND bp.RGN_ID=").append(regionId);
	        query.append(" AND bc.RGN_ID=").append(regionId);
        } else {
        	for(int rgnId=2; rgnId <= 5; rgnId++){
            	if(rgnId > 2){
            		query.append(" UNION");
            	}
    	        query.append(" (SELECT DISTINCT bp.std_id FROM BRIDGE_PUBLISH bp, Publish p, chain_std cs WHERE bp.PUBLISH_ID=p.PUBLISH_ID");
    	        query.append(" AND bp.std_id=cs.std_id AND cs.chain_cd=p.CHAIN_CD AND cs.actv_ind='Y' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
    	        query.append(" AND bp.RGN_ID=").append(rgnId);
    	        query.append(" MINUS SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, CTRY_STD cs, BRNDSTND_CTRY bc");
    	        query.append(" WHERE bp.STD_ID=cs.STD_ID AND cs.CTRY_NM_CD=bc.CTRY_NM_CD");
    	        query.append(" AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
    	        query.append(" AND bp.RGN_ID=").append(rgnId);
    	        query.append(" AND bc.RGN_ID=").append(rgnId);
                query.append(")");
            }
        }
        query.append("), ");
        
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM UNATTRIBUTE_STD");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM UNATTRIBUTE_STD)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM UNATTRIBUTE_STD)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }

    public static StringBuilder getProgressGlobalMustViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH GLOBAL_MUST AS (");
        if(regionId == 1) {
        	for(int rgnId=2; rgnId <= 5; rgnId++){
            	if(rgnId > 2){
            		query.append(" UNION");
            	}
	        	query.append(" (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
	            query.append(" AND STD_ID IN (SELECT DISTINCT std_id FROM CTRY_STD");
	            query.append(" WHERE ctry_nm_cd IN (SELECT DISTINCT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id=").append(rgnId).append("))");
	            query.append(" MINUS SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=").append(publishId);
	            query.append(" AND RGN_ID=").append(rgnId).append(")");
        	}
            query.append("), ");
        } else {
	    	query.append("SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'Y' AND PUBLISH_ID = ");
	        query.append(publishId);
	        query.append(" AND STD_ID IN (SELECT DISTINCT std_id FROM CTRY_STD ");
	        query.append(" WHERE ctry_nm_cd IN (SELECT DISTINCT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ");
	        query.append(regionId).append(")) ");
	        query.append(" MINUS SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID = ");
	        query.append(publishId);
	        query.append(" AND RGN_ID = ");
	        query.append(regionId);
	        query.append(" ),");
        }
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM GLOBAL_MUST");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM GLOBAL_MUST)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM GLOBAL_MUST)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressGlobalNotInMustViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH GLOBAL_NOT_IN_MUST AS (");
        if(regionId == 1) {
        	for(int rgnId=2; rgnId <= 5; rgnId++){
            	if(rgnId > 2){
            		query.append(" UNION");
            	}
            	query.append(" (SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, STD s WHERE bp.STD_ID=s.STD_ID");
            	query.append(" AND s.rgn_cd='GLBL' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
            	query.append(" AND bp.RGN_ID=").append(rgnId);
            	query.append(" MINUS SELECT DISTINCT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId).append(")");
        	}
            query.append("),");
        } else {
        	query.append("SELECT DISTINCT bp.STD_ID FROM BRIDGE_PUBLISH bp, STD s WHERE bp.STD_ID=s.STD_ID");
        	query.append(" AND s.rgn_cd='GLBL' AND bp.UNPUBLISH_IND='N' AND bp.PUBLISH_ID=").append(publishId);
        	query.append(" AND bp.RGN_ID=").append(regionId);
        	query.append(" MINUS SELECT DISTINCT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND='Y' AND PUBLISH_ID=").append(publishId);
	        query.append("),");
        }
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM GLOBAL_NOT_IN_MUST");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM GLOBAL_NOT_IN_MUST)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM GLOBAL_NOT_IN_MUST)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressGlobalMustNotViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH GLOBAL_MUST_NOT AS (");
        if(regionId == 1){
        	query.append("(SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append(" AND RGN_ID = 2 AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append(")) ");
            
            query.append("UNION (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append(" AND RGN_ID = 3 AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append("))");
            
            query.append(" UNION (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID=");
            query.append(publishId);
            query.append(" AND RGN_ID = 4 AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append("))");
            
            query.append(" UNION (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append(" AND RGN_ID = 5 AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'N' AND PUBLISH_ID = ");
            query.append(publishId);
            query.append(")) ), ");
        } else {
	        query.append(" SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID=");
	        query.append(publishId);
	        query.append(" AND RGN_ID = ");
	        query.append(regionId);
	        query.append(" AND STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = 'N' AND PUBLISH_ID=");
	        query.append(publishId);
	        query.append(") ),");
        }
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM GLOBAL_MUST_NOT");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM GLOBAL_MUST_NOT)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM GLOBAL_MUST_NOT)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressSelectStateViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH ");
        query.append("SELECT_STATE_ISSUES AS (");
        query.append(" SELECT DISTINCT STD_ID, 'SELECT_STATE' AS ISSUE_DESC FROM BRIDGE_PUBLISH bp, BRIDGE_PUBLISH_CTRY bpc ");
        query.append(" WHERE bp.BRIDGE_PUBLISH_ID=bpc.BRIDGE_PUBLISH_ID AND bp.UNPUBLISH_IND = 'N' AND bp.PUBLISH_ID = ");
        query.append(publishId);
        if(regionId != 1) {
        	query.append(" AND bp.RGN_ID = ").append(regionId);
        }
        query.append(" AND bpc.BRIDGE_PUBLISH_STAT_CD = '");
        query.append(BSCommonConstants.BRIDGE_STATUS_CD_SEL);
        query.append("'), ");
        
        query.append("SELECTED_STD_IDS AS ( ");
        query.append("SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM SELECT_STATE_ISSUES ");
        query.append("UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM SELECT_STATE_ISSUES) ");
        query.append("AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM SELECT_STATE_ISSUES)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressOverriddenViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH OVERRIDDEN_STD AS ( ");
        query.append("SELECT b.std_id ");
        query.append("FROM bridge_publish b, bridge_publish_ctry bc ");
        query.append("WHERE b.publish_id = ");
        query.append(publishId);
        if(regionId != 1) {
        	query.append(" AND b.rgn_id = ");
        	query.append(regionId);
        }
        query.append(" AND b.bridge_publish_id = bc.bridge_publish_id ");
        query.append("AND b.unpublish_ind = 'N' ");
        query.append("AND bc.publish_ind = 'N'), ");
        
        query.append("SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM OVERRIDDEN_STD");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM OVERRIDDEN_STD)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM OVERRIDDEN_STD)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressMissingXrefViewDetail(long publishId, long regionId, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH");
        query.append(" XREF_ISSUES AS (");
        if(regionId != 1) {
	        query.append("SELECT STD_ID, 'MISSING_XREF' AS ISSUE_DESC FROM (SELECT DISTINCT sx.REFERRING_STD_ID AS STD_ID FROM STD_XREF sx, STD s, CHAIN_STD cs, STAT st");
	        query.append(" WHERE sx.REFERENCED_STD_ID = s.STD_ID AND s.STD_ID = cs.STD_ID AND cs.STAT_ID = st.STAT_ID");
	        query.append(" AND st.STAT_CD NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') AND s.STAT_DESC != 'DELETED'");
	        query.append(" AND s.STD_ID IN (SELECT DISTINCT STD_ID FROM CTRY_STD WHERE CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID=");
	        query.append(regionId);
	        query.append(")) AND cs.ACTV_IND='Y' AND cs.CHAIN_CD=(SELECT CHAIN_CD FROM PUBLISH WHERE PUBLISH_ID=");
	        query.append(publishId);
	        query.append(") AND sx.REFERRING_STD_ID IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=");
	        query.append(publishId);
	        query.append(" AND RGN_ID=");
	        query.append(regionId);
	        query.append(") AND sx.REFERENCED_STD_ID NOT IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=");
	        query.append(publishId);
	        query.append(" AND RGN_ID=");
	        query.append(regionId);
	        query.append("))");
        } else {
        	query.append("SELECT STD_ID, 'MISSING_XREF' AS ISSUE_DESC FROM (");
        	for(int rgnId=2; rgnId <= 5; rgnId++){
            	if(rgnId > 2){
            		query.append(" UNION");
            	}
            	query.append(" (SELECT DISTINCT sx.REFERRING_STD_ID AS STD_ID FROM STD_XREF sx, STD s, CHAIN_STD cs, STAT st");
                query.append(" WHERE sx.REFERENCED_STD_ID = s.STD_ID AND s.STD_ID = cs.STD_ID AND cs.STAT_ID = st.STAT_ID");
                query.append(" AND st.STAT_CD NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') AND s.STAT_DESC != 'DELETED'");
                query.append(" AND s.STD_ID IN (SELECT DISTINCT STD_ID FROM CTRY_STD WHERE CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID=");
                query.append(rgnId);
                query.append(")) AND cs.ACTV_IND='Y' AND cs.CHAIN_CD=(SELECT CHAIN_CD FROM PUBLISH WHERE PUBLISH_ID=");
                query.append(publishId);
                query.append(") AND sx.REFERRING_STD_ID IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=");
                query.append(publishId);
                query.append(" AND RGN_ID=");
                query.append(rgnId);
                query.append(") AND sx.REFERENCED_STD_ID NOT IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND='N' AND PUBLISH_ID=");
                query.append(publishId);
                query.append(" AND RGN_ID=");
                query.append(rgnId);
                query.append("))");
            }
            query.append(")");
        }
        query.append("),");
        
        query.append("SELECTED_STD_IDS AS ( ");
        query.append("SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM XREF_ISSUES ");
        query.append("UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM XREF_ISSUES) ");
        query.append("AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM XREF_ISSUES)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }

    public static StringBuilder getProgressComplianceDateViewDetail(long publishId, long regionId, String chainCode, Date publishDate, 
            String statIndText)
    {
        StringBuilder query = new StringBuilder();
        String dateStr = new SimpleDateFormat("dd MMM yyyy").format(publishDate);
        query.append("SELECT * FROM ( WITH");
        query.append(" COMPLIANCE_STD AS (");
        query.append(" SELECT * FROM (SELECT DISTINCT sc.std_id,");
        query.append(" NVL((SELECT decode(std_id, NULL, 'N', 'Y')");
        query.append(" FROM std_ctry_chain");
        query.append(" WHERE std_id = sc.std_id");
        query.append(" AND chain_cd = sc.chain_cd");
        query.append(" AND ctry_nm_cd = sc.ctry_nm_cd), 'N') is_published");
        query.append(" FROM bridge_publish b, std_cmply sc ");
        query.append(" WHERE b.publish_id = ").append(publishId);
        query.append(" AND b.std_id = sc.std_id ");
        query.append(" AND b.unpublish_ind = 'N' ");
        query.append(" AND sc.chain_cd = '").append(chainCode).append("' ");
        query.append(" AND sc.CMPLY_EXPR_RULE_CD = 'C' AND sc.RULE_DT_CD = 'D'");
        query.append(" AND sc.cmply_expr_dt IS NOT NULL AND sc.cmply_expr_dt > SYSDATE");
        query.append(" AND sc.cmply_expr_dt < to_date('").append(dateStr).append("', 'DD MON YYYY') ");
        if(regionId != 1) {
        	query.append(" AND b.rgn_id = ").append(regionId);
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id=").append(regionId).append(")");
        } else {
        	query.append(" AND b.rgn_id IN (2, 3, 4, 5)");
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id IN (2, 3, 4, 5))");
        }
        query.append(" )");
        query.append(" WHERE is_published = 'N'), ");
        
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM COMPLIANCE_STD");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM COMPLIANCE_STD)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM COMPLIANCE_STD)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }
    
    public static StringBuilder getProgressNotificationViewDetail(long publishId, long regionId)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT e.err_notification_id, e.publish_id, e.ref_id AS STD_ID, s.std_typ,");
        query.append(" CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS TITLE_TXT, e.err_title_txt, e.err_desc,");
        query.append(" to_char(e.creat_ts, 'DD Mon YYYY') AS CREAT_TS, 'NEW' AS stat_cd, e.component_nm, e.severity_lvl_cd");
        query.append(" FROM err_notification e, STD s WHERE e.publish_id=").append(publishId);
        query.append(" AND e.rgn_id=").append(regionId); 
        query.append(" AND e.component_nm='").append(BSCommonConstants.ERR_NOTIFICATION_COMPONENT_BRIDGE_NOTIFICATION).append("'");
        query.append(" AND e.stat_cd='").append(BridgeConstants.QUEUE_NEW_STATUS).append("'"); 
        query.append(" AND e.ref_id=s.std_id ORDER BY e.creat_ts DESC");
        return query;
    }
    
    public static StringBuilder getProgressAllNotificationViewDetail(long publishId, long regionId)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT e.err_notification_id, e.publish_id, e.ref_id AS STD_ID, s.std_typ,");
        query.append(" CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS TITLE_TXT, e.err_title_txt, e.err_desc,");
        query.append(" to_char(e.creat_ts, 'DD Mon YYYY') AS CREAT_TS, DECODE(e.stat_cd, 'COMPLETE', 'Acknowledged', e.stat_cd) AS stat_cd, e.component_nm, e.severity_lvl_cd");
        query.append(" FROM err_notification e, STD s WHERE e.publish_id=").append(publishId);
        query.append(" AND e.rgn_id=").append(regionId); 
        query.append(" AND e.component_nm='").append(BSCommonConstants.ERR_NOTIFICATION_COMPONENT_BRIDGE_NOTIFICATION).append("'");
        //query.append(" AND e.stat_cd='").append(BridgeConstants.QUEUE_NEW_STATUS).append("'"); 
        query.append(" AND e.ref_id=s.std_id ORDER BY e.creat_ts DESC");
        return query;
    }

    public static StringBuilder getProgressExpiredDateViewDetail(long publishId, long regionId, String chainCode, Date publishDate, 
            String statIndText)
    {
        StringBuilder query = new StringBuilder();
        String dateStr = new SimpleDateFormat("dd MMM yyyy").format(publishDate);
        query.append("SELECT * FROM ( WITH");
        query.append(" EXPIRED_STD AS (");
        query.append(" SELECT * FROM (SELECT DISTINCT sc.std_id,");
        query.append(" NVL((SELECT decode(std_id, NULL, 'N', 'Y')");
        query.append(" FROM std_ctry_chain");
        query.append(" WHERE std_id = sc.std_id");
        query.append(" AND chain_cd = sc.chain_cd");
        query.append(" AND ctry_nm_cd = sc.ctry_nm_cd), 'N') is_published");
        query.append(" FROM bridge_publish b, std_cmply sc ");
        query.append(" WHERE b.publish_id = ").append(publishId);
        query.append(" AND b.std_id = sc.std_id ");
        query.append(" AND b.unpublish_ind = 'N' ");
        query.append(" AND sc.chain_cd = '").append(chainCode).append("' ");
        query.append(" AND sc.CMPLY_EXPR_RULE_CD = 'E' AND sc.RULE_DT_CD = 'D' AND sc.cmply_expr_dt IS NOT NULL ");
        query.append(" AND sc.cmply_expr_dt <= to_date('").append(dateStr).append("', 'DD MON YYYY') ");
        if(regionId != 1) {
        	query.append(" AND b.rgn_id = ").append(regionId);
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id=").append(regionId).append(")");
        } else {
        	query.append(" AND b.rgn_id IN (2, 3, 4, 5)");
            query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM BRNDSTND_CTRY WHERE rgn_id IN (2, 3, 4, 5))");
        }
        query.append(" )");
        query.append(" WHERE is_published = 'N'), ");
        
        query.append(" SELECTED_STD_IDS AS (");
        query.append(" SELECT STD_ID, '");
        query.append(statIndText);
        query.append("' AS stat_desc FROM EXPIRED_STD");
        query.append(" UNION SELECT PRNT_STD_ID, '' AS stat_desc FROM STD WHERE STD_ID IN (SELECT STD_ID FROM EXPIRED_STD)");
        query.append(" AND PRNT_STD_ID NOT IN (SELECT STD_ID FROM EXPIRED_STD)),");
        
        appendProgressViewDetailCommonQuery(publishId, regionId, query);
        return query;
    }

    public static StringBuilder getProgressIndexTranslationViewDetail(long publishId, long regionId, String localeCode, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("WITH "); 
        query.append("TAX_IDS AS ( ");
        query.append(" SELECT DISTINCT T.TAXONOMY_ID ");
        query.append(" FROM TAXONOMY T ");
        query.append(" WHERE t.taxonomy_id > 1 ");
        query.append(" START WITH T.TAXONOMY_ID IN ( ");
        query.append("  SELECT DISTINCT ts.taxonomy_id ");
        query.append("  FROM bridge_publish bp, taxonomy_std ts ");
        query.append("  WHERE bp.publish_id = ").append(publishId).append(" ");
        query.append("  AND bp.unpublish_ind = 'N' ");
        query.append("  AND bp.std_id = ts.std_id ) ");
        query.append(" CONNECT BY NOCYCLE PRIOR T.PRNT_TAXONOMY_ID = T.TAXONOMY_ID), ");
        query.append("TAX_MATCH AS ( SELECT indx_order, taxonomy_id, prnt_taxonomy_id, LVL, HIER_LVL_NBR, PATH, TAXONOMY_DESC, title_txt, ");
        query.append("0 AS prnt_publish_id, 0 AS std_id, '' AS std_typ, '' AS std_title, ");
        query.append("'' AS std_desc, '").append(statIndText).append("' AS STAT_DESC, 0 AS DISP_ORDER_NBR, "); 
        query.append("DECODE(title_xlat, 'No Translation Found', NULL, title_xlat) AS title_xlat, ");
        query.append(" DECODE(title_xlat, NULL, 'N', 'No Translation Found', 'N', 'Y') AS title_xlat_exist ");
        query.append(" FROM ( ");
        query.append("  SELECT ROWNUM AS indx_order, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, t.taxonomy_id, t.prnt_taxonomy_id, t.title_txt, "); 
        query.append("  SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH, t.TAXONOMY_DESC, ");
        query.append("  (SELECT title_txt FROM taxonomy_xlat xt WHERE t.taxonomy_id = xt.taxonomy_id ");
        query.append("  AND '").append(localeCode).append("' = xt.LOCALE_CD(+)) AS title_xlat ");
        query.append("  FROM TAXONOMY T ");
        query.append("  WHERE t.taxonomy_id > 1 ");
        query.append("  START WITH T.TAXONOMY_ID = 1 ");
        query.append("  CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ) ");
        query.append(" WHERE taxonomy_id IN (SELECT TAXONOMY_ID FROM TAX_IDS) ) ");
        query.append("( SELECT * FROM TAX_MATCH WHERE title_xlat_exist = 'N' ) ");
        
        return query;
    }

    public static StringBuilder getProgressContentTranslationViewDetail(long publishId, long regionId, String chainCode, String localeCode, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ( WITH ");
        query.append("STD_REC AS (SELECT DISTINCT bp.std_id, s.prnt_std_id, s.std_typ, ");
        query.append("CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS TITLE_TXT, S.STD_DESC, ");
        query.append("s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, ");
        query.append("(SELECT LISTAGG(fc.flag_catgy_val, ', ') WITHIN GROUP (ORDER BY fs.std_id) AS FLAG_TITLE "); 
        query.append("  FROM FLAG_STD fs, flag_catgy fc ");
        query.append("  WHERE fs.flag_catgy_id = fc.flag_catgy_id "); 
        query.append("  AND fc.prnt_flag_catgy_id = 30 "); 
        query.append("  AND fs.std_id = bp.std_id ");
        query.append("  GROUP BY fs.std_id) manual_type, s.rgn_cd ");
        query.append("FROM BRIDGE_PUBLISH bp, std s ");
        query.append("WHERE bp.publish_id = ").append(publishId).append(" ");
        query.append("AND bp.UNPUBLISH_IND = 'N' ");
        query.append("AND s.std_id = bp.std_id ");
        query.append("AND s.stat_desc != 'DELETED' ");
        if (regionId != 1)
        {
            query.append("AND bp.rgn_id = ").append(regionId);
            //query.append(" AND s.gbl_rgn_ind   != 'G'");
        }
        query.append(" ), ");
        
        query.append("rec_xlat AS ( ");
        query.append(" SELECT s.std_id, s.prnt_std_id, CASE WHEN S.STD_TYP = 'GDLN' THEN sx.std_desc ELSE sx.title_txt END AS title_xlat, sx.std_desc ");
        query.append(" FROM std_xlat sx, std_rec s ");
        query.append(" WHERE s.std_id = sx.std_id ");
        query.append(" AND ((s.std_typ != 'GDLN' AND sx.TITLE_TXT_VLD_IND = 'Y' AND sx.title_txt IS NOT NULL) OR ");
        query.append("      (s.std_typ = 'GDLN' AND sx.STD_DESC_VLD_IND  = 'Y' AND sx.std_desc IS NOT NULL)) ");
        query.append(" AND sx.locale_cd = '").append(localeCode).append("' "); 
        query.append(" ), ");
        query.append("rec_no_xlat AS ( ");
        query.append("   SELECT std_id, title_txt AS title  FROM std_rec ");
        query.append("   WHERE std_id NOT IN (SELECT std_id FROM rec_xlat) ");
        query.append(" ), ");
        
        query.append("CMS_TAXONOMY AS ( ");
        query.append("SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, ");
        query.append("SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH ");
        query.append("FROM TAXONOMY T WHERE T.TAXONOMY_ID > 1 START WITH T.TAXONOMY_ID=1 ");
        query.append("CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID), ");

        query.append("DIRECT_MATCH AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT, "); 
        query.append("s.prnt_std_id, s.std_id, s.std_typ, ");
        query.append("CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS STD_TITLE, S.STD_DESC, ");
        query.append("'").append(statIndText).append("' bridge_std_stat, ");
        query.append("(SELECT NVL((SELECT DISP_ORDER_NBR FROM std_display_order WHERE STD_ID=s.std_id AND CHAIN_CD='");
        query.append(chainCode);
        query.append("' AND RGN_CD=(SELECT RGN_CD FROM BRNDSTND_RGN WHERE RGN_ID=");
        query.append(regionId);
        query.append(")), 0) FROM DUAL) disp_order_nbr, ");
        query.append("(SELECT title_xlat FROM rec_xlat WHERE std_id = s.std_id) AS rec_title_xlat, ");
        query.append("s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, s.manual_type, ");
        query.append("nox.title AS rec_title, s.rgn_cd ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, std_rec s, rec_no_xlat nox ");
        query.append("WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID ");
        query.append("AND TSTD.STD_ID = s.prnt_std_id AND s.std_id = nox.std_id ), ");

        query.append("MISSING_PRNT AS (SELECT s.std_id, s.prnt_std_id, s.std_typ, "); 
        query.append("CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS STD_TITLE, S.STD_DESC, ");
        query.append("'' bridge_std_stat, ");
        query.append("(SELECT NVL((SELECT DISP_ORDER_NBR FROM std_display_order WHERE STD_ID=s.std_id AND CHAIN_CD='");
        query.append(chainCode);
        query.append("' AND RGN_CD=(SELECT RGN_CD FROM BRNDSTND_RGN WHERE RGN_ID=");
        query.append(regionId);
        query.append(")), 0) FROM DUAL) disp_order_nbr, ");
        query.append("s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, ");
        query.append("(SELECT LISTAGG(fc.flag_catgy_val, ', ') WITHIN GROUP (ORDER BY fs.std_id) AS FLAG_TITLE "); 
        query.append("  FROM FLAG_STD fs, flag_catgy fc ");
        query.append("  WHERE fs.flag_catgy_id = fc.flag_catgy_id "); 
        query.append("  AND fc.prnt_flag_catgy_id = 30 "); 
        query.append("  AND fs.std_id = s.std_id ");
        query.append("  GROUP BY fs.std_id) manual_type, s.rgn_cd ");
        query.append("FROM STD s WHERE std_id IN ( "); 
        query.append("SELECT prnt_std_id FROM DIRECT_MATCH WHERE STD_ID!=PRNT_STD_ID ");
        query.append(" MINUS SELECT prnt_std_id FROM DIRECT_MATCH WHERE STD_ID = prnt_std_id)) ");

        query.append("(SELECT * FROM DIRECT_MATCH ");
        query.append(" UNION ");
        query.append(" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT, ");
        query.append(" s.prnt_std_id, s.std_id, s.std_typ, s.std_title, S.STD_DESC, s.bridge_std_stat, s.disp_order_nbr, '' AS title_xlat, ");
        query.append(" s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, s.manual_type, '' AS rec_title, s.rgn_cd ");
        query.append(" FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, MISSING_PRNT s ");
        query.append(" WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID AND TSTD.STD_ID = s.prnt_std_id ) ) ");
        
        return query;
    }

    public static StringBuilder getProgressAttachmentTranslationViewDetail(long publishId, long regionId, String chainCode, String localeCode, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        appendProgressTranslationViewDetailStdRecCommonQuery(publishId, regionId, query);
        
        //-- Find main attachment - NOT require translation. Children should be translated.
        query.append("main_rec AS (SELECT sa.std_attachement_id, sa.prnt_std_attachment_id, sa.std_id, sa.locale_cd, sa.xlat_ind, ");
        query.append("(sa.attachment_title_txt || ':::' || sa.attachment_path_txt) AS title ");
        query.append(" FROM std_attachment sa, std_attachment_chain sah, std_rec rec ");
        query.append(" WHERE sa.std_attachement_id = sa.prnt_std_attachment_id ");
        query.append(" AND sa.std_attachement_id = sah.std_attachement_id ");
        query.append(" AND sah.chain_cd = '").append(chainCode).append("' ");
        query.append(" AND sa.std_id = rec.std_id ");
        query.append(" AND sa.locale_cd = 'en_GB'), ");
        //-- find translated attachments 
        query.append("rec_xlat AS (SELECT sa.std_attachement_id, sa.prnt_std_attachment_id, sa.std_id, sa.locale_cd, sa.xlat_ind, ");
        query.append("(sa.attachment_title_txt || ':::' || sa.attachment_path_txt) AS title_xlat ");
        query.append(" FROM std_attachment sa, main_rec ma ");
        query.append(" WHERE sa.prnt_std_attachment_id = ma.prnt_std_attachment_id "); 
        query.append(" AND sa.locale_cd = '").append(localeCode).append("'), ");
        //-- Find missing attachment translations for a locale
        query.append("rec_no_xlat AS (SELECT distinct ma.std_id, ma.std_attachement_id, ma.prnt_std_attachment_id, ma.title "); 
        query.append(" FROM main_rec ma ");
        query.append(" WHERE ma.prnt_std_attachment_id NOT IN (SELECT prnt_std_attachment_id FROM rec_xlat) "); 
        query.append(" ), ");
        
        appendProgressTranslationViewDetailCommonQuery(regionId, chainCode, localeCode, statIndText, query);
        return query;
    }

    public static StringBuilder getProgressLinksTranslationViewDetail(long publishId, long regionId, String chainCode, String localeCode, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        appendProgressTranslationViewDetailStdRecCommonQuery(publishId, regionId, query);
        
        //-- Find main External Links - NOT require translation. Children should be translated.
        query.append("main_rec AS (SELECT sl.std_extl_link_id, sl.prnt_std_extl_link_id, sl.std_id, sl.locale_cd, sl.xlat_ind, ");
        query.append("(sl.link_title_txt || ':::' || sl.url_txt) AS title ");
        query.append(" FROM std_extl_link sl, std_extl_link_chain slc, std_rec rec ");
        query.append(" WHERE sl.std_extl_link_id = sl.prnt_std_extl_link_id ");
        query.append(" AND sl.std_extl_link_id = slc.std_extl_link_id");
        query.append(" AND slc.chain_cd = '").append(chainCode).append("'");
        query.append(" AND sl.std_id = rec.std_id ");
        query.append(" AND sl.locale_cd = 'en_GB'), ");
        //-- find translated External Links 
        query.append("rec_xlat AS (SELECT sl.std_extl_link_id, sl.prnt_std_extl_link_id, sl.std_id, sl.locale_cd, sl.xlat_ind, ");
        query.append("(sl.link_title_txt || ':::' || sl.url_txt) AS title_xlat ");
        query.append(" FROM std_extl_link sl, main_rec ml ");
        query.append(" WHERE sl.prnt_std_extl_link_id = ml.prnt_std_extl_link_id ");
        query.append(" AND sl.locale_cd = '").append(localeCode).append("'), ");
        //-- Find missing External Links translations for a locale
        query.append("rec_no_xlat AS (SELECT distinct ml.std_id, ml.std_extl_link_id, ml.prnt_std_extl_link_id, ml.title ");
        query.append(" FROM main_rec ml ");
        query.append(" WHERE ml.prnt_std_extl_link_id NOT IN (SELECT prnt_std_extl_link_id FROM rec_xlat) ");
        query.append(" ), ");
        
        appendProgressTranslationViewDetailCommonQuery(regionId, chainCode, localeCode, statIndText, query);
        return query;
    }

    public static StringBuilder getProgressImagesTranslationViewDetail(long publishId, long regionId, String chainCode, String localeCode, String statIndText)
    {
        StringBuilder query = new StringBuilder();
        appendProgressTranslationViewDetailStdRecCommonQuery(publishId, regionId, query);
        
        //-- Find main images - NOT require translation. Children should be translated.
        query.append("main_rec AS (SELECT si.std_image_id, si.prnt_std_image_id, si.std_id, si.locale_cd, ");
        query.append("(si.image_title_txt || ':::' || si.image_id) AS title ");
        query.append(" FROM std_image si, std_image_chain sic, std_rec rec ");
        query.append(" WHERE si.std_image_id = si.prnt_std_image_id ");
        query.append(" AND si.std_image_id  = sic.std_image_id");
        query.append(" AND sic.chain_cd = '").append(chainCode).append("'");
        query.append(" AND si.std_id = rec.std_id ");
        query.append(" AND si.locale_cd = 'en_GB'), ");
        //-- find translated images 
        query.append("rec_xlat AS (SELECT si.std_image_id, si.prnt_std_image_id, si.std_id, si.image_title_txt AS title_xlat, si.locale_cd ");
        query.append(" FROM std_image si, main_rec mi ");
        query.append(" WHERE si.prnt_std_image_id = mi.prnt_std_image_id ");
        query.append(" AND si.locale_cd = '").append(localeCode).append("'), ");
        //-- Find missing Image translations for a locale
        query.append("rec_no_xlat AS (SELECT distinct mi.std_id, mi.std_image_id, mi.prnt_std_image_id, mi.title ");
        query.append(" FROM main_rec mi ");
        query.append(" WHERE mi.prnt_std_image_id NOT IN (SELECT prnt_std_image_id FROM rec_xlat) ");
        query.append(" ), ");

        appendProgressTranslationViewDetailCommonQuery(regionId, chainCode, localeCode, statIndText, query);
        return query;
    }

    public static void appendProgressTranslationViewDetailStdRecCommonQuery(long publishId, long regionId, StringBuilder query)
    {
        query.append("SELECT * FROM ( WITH ");
        query.append("STD_REC AS (SELECT bp.std_id, s.prnt_std_id, s.std_typ, ");
        query.append("CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS TITLE_TXT, S.STD_DESC, ");
        query.append("s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, ");
        query.append("(SELECT LISTAGG(fc.flag_catgy_val, ', ') WITHIN GROUP (ORDER BY fs.std_id) AS FLAG_TITLE "); 
        query.append("  FROM FLAG_STD fs, flag_catgy fc ");
        query.append("  WHERE fs.flag_catgy_id = fc.flag_catgy_id "); 
        query.append("  AND fc.prnt_flag_catgy_id = 30 "); 
        query.append("  AND fs.std_id = bp.std_id ");
        query.append("  GROUP BY fs.std_id) manual_type, s.rgn_cd ");
        query.append("FROM BRIDGE_PUBLISH bp, std s ");
        query.append("WHERE bp.publish_id = ").append(publishId).append(" ");
        query.append("AND bp.UNPUBLISH_IND = 'N' ");
        query.append("AND s.std_id = bp.std_id ");
        query.append("AND s.stat_desc != 'DELETED' ");
        if (regionId != 1)
        {
            query.append("AND bp.rgn_id = ").append(regionId);
        }
        query.append(" ), ");
    }

    public static void appendProgressTranslationViewDetailCommonQuery(long regionId, String chainCode, String localeCode, String statIndText, StringBuilder query)
    {
        query.append("xlat_std_rec AS (SELECT rec.std_id, ");
        query.append(" (SELECT count(*) FROM rec_no_xlat WHERE std_id = rec.std_id) AS xlat_exist ");
        query.append(" FROM std_rec rec ");
        query.append(" WHERE rec.std_id IN (SELECT std_id FROM rec_no_xlat)), ");

        query.append("CMS_TAXONOMY AS ( ");
        query.append("SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, ");
        query.append("SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH ");
        query.append("FROM TAXONOMY T WHERE T.TAXONOMY_ID > 1 START WITH T.TAXONOMY_ID=1 ");
        query.append("CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID), ");

        query.append("DIRECT_MATCH AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT, "); 
        query.append("s.prnt_std_id, s.std_id, s.std_typ, ");
        query.append("CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS STD_TITLE, S.STD_DESC, ");
        query.append("'").append(statIndText).append("' bridge_std_stat, ");
        query.append("(SELECT NVL((SELECT DISP_ORDER_NBR FROM std_display_order WHERE STD_ID=s.std_id AND CHAIN_CD='");
        query.append(chainCode);
        query.append("' AND RGN_CD=(SELECT RGN_CD FROM BRNDSTND_RGN WHERE RGN_ID=");
        query.append(regionId);
        query.append(")), 0) FROM DUAL) disp_order_nbr, ");
        query.append("rxt.title_xlat, s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, s.manual_type, ");
        query.append("nox.title AS rec_title, s.rgn_cd ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, std_rec s, xlat_std_rec rec, rec_no_xlat nox, (SELECT STD_ID, title_xlat FROM rec_xlat) rxt ");
        query.append("WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID ");
        query.append("AND TSTD.STD_ID = s.prnt_std_id AND s.std_id = rec.std_id AND s.std_id = nox.std_id(+) AND s.std_id = rxt.std_id(+)), ");

        query.append("MISSING_PRNT AS (SELECT s.std_id, s.prnt_std_id, s.std_typ, "); 
        query.append("CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT END AS STD_TITLE, S.STD_DESC, '' bridge_std_stat, ");
        query.append("(SELECT NVL((SELECT DISP_ORDER_NBR FROM std_display_order WHERE STD_ID=s.std_id AND CHAIN_CD='");
        query.append(chainCode);
        query.append("' AND RGN_CD=(SELECT RGN_CD FROM BRNDSTND_RGN WHERE RGN_ID=");
        query.append(regionId);
        query.append(")), 0) FROM DUAL) disp_order_nbr, ");
        query.append("s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, ");
        query.append("(SELECT LISTAGG(fc.flag_catgy_val, ', ') WITHIN GROUP (ORDER BY fs.std_id) AS FLAG_TITLE "); 
        query.append("  FROM FLAG_STD fs, flag_catgy fc ");
        query.append("  WHERE fs.flag_catgy_id = fc.flag_catgy_id "); 
        query.append("  AND fc.prnt_flag_catgy_id = 30 "); 
        query.append("  AND fs.std_id = s.std_id ");
        query.append("  GROUP BY fs.std_id) manual_type, s.rgn_cd ");
        query.append("FROM STD s WHERE std_id IN ( "); 
        query.append("SELECT prnt_std_id FROM DIRECT_MATCH WHERE STD_ID NOT IN (SELECT PRNT_STD_ID FROM DIRECT_MATCH) ");
        query.append(" MINUS SELECT prnt_std_id FROM DIRECT_MATCH WHERE STD_ID = prnt_std_id)) ");

        query.append("(SELECT * FROM DIRECT_MATCH ");
        query.append(" UNION ");
        query.append(" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT, ");
        query.append(" s.prnt_std_id, s.std_id, s.std_typ, s.std_title, S.STD_DESC, s.bridge_std_stat, s.disp_order_nbr, '' AS title_xlat, ");
        query.append(" s.area_catgy_cd, s.gbl_rgn_ind, s.framework_std_ind, s.manual_type, '' AS rec_title, s.rgn_cd ");
        query.append(" FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, MISSING_PRNT s ");
        query.append(" WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID AND TSTD.STD_ID = s.prnt_std_id ) ) ");
    }

    
    /**
     * This method will generate query to get Standards for Translation View Details based on the request.
     * @param publishId The publish id.
     * @param regionId The region id.
     * @param localeCode The locale code.
     * @return
     */
    public static String getTranslationViewDetailsQuery(long publishId, long regionId, String localeCode)
    {
        StringBuilder query = new StringBuilder();
        query.append("WITH ");
        query.append("locale AS (SELECT '").append(localeCode).append("' AS locale_cd from dual), ");
        //-- std_is to be published
        query.append("std_rec AS (SELECT bp.std_id, s.prnt_std_id, s.std_typ, s.disp_order_nbr "); 
        query.append("    FROM BRIDGE_PUBLISH bp, std s "); 
        query.append("    WHERE bp.publish_id = ").append(publishId);
        query.append("    AND bp.UNPUBLISH_IND = 'N'"); 
        query.append("    AND s.std_id = bp.std_id ");
        query.append("    AND s.stat_desc != 'DELETED' ");
        query.append("    AND bp.rgn_id = ").append(regionId).append(" ), ");
        //-- Find main attachment - NOT require translation. Children should be translated.
        query.append("main_attach AS (SELECT sa.std_attachement_id, sa.prnt_std_attachment_id, sa.std_id, sa.locale_cd, sa.xlat_ind ");
        query.append("    FROM std_attachment sa, std_rec rec ");
        query.append("    WHERE sa.std_attachement_id = sa.prnt_std_attachment_id ");
        query.append("    AND sa.std_id = rec.std_id ");
        query.append("    AND sa.locale_cd = 'en_GB'), ");
        //-- find translated attachments 
        query.append("main_attach_xlat AS (SELECT sa.std_attachement_id, sa.prnt_std_attachment_id, sa.std_id, sa.locale_cd, sa.xlat_ind ");
        query.append("    FROM std_attachment sa, main_attach ma, locale l ");
        query.append("    WHERE sa.prnt_std_attachment_id = ma.prnt_std_attachment_id ");
        query.append("    AND sa.locale_cd = l.locale_cd), ");
        //-- Find missing attachment translations for a locale
        query.append("attach_no_xlat AS (SELECT ma.std_id, COUNT(ma.std_id) AS loc_cnt ");
        query.append("    FROM main_attach ma ");
        query.append("    WHERE ma.prnt_std_attachment_id NOT IN (SELECT prnt_std_attachment_id FROM main_attach_xlat) ");
        query.append("    GROUP BY ma.std_id ), ");
        //-- Find main images - NOT require translation. Children should be translated.
        query.append("main_image AS (SELECT si.std_image_id, si.prnt_std_image_id, si.std_id, si.locale_cd ");
        query.append("    FROM std_image si, std_rec rec ");
        query.append("    WHERE si.std_image_id = si.prnt_std_image_id ");
        query.append("    AND si.std_id = rec.std_id ");
        query.append("    AND si.locale_cd = 'en_GB'), ");
        //-- find translated images 
        query.append("main_image_xlat AS (SELECT si.std_image_id, si.prnt_std_image_id, si.std_id, si.locale_cd ");
        query.append("    FROM std_image si, main_image mi, locale l ");
        query.append("    WHERE si.prnt_std_image_id = mi.prnt_std_image_id ");
        query.append("    AND si.locale_cd = l.locale_cd), ");
        //-- Find missing Image translations for a locale
        query.append("image_no_xlat AS (SELECT mi.std_id, COUNT(mi.std_id) AS loc_cnt ");
        query.append("    FROM main_image mi ");
        query.append("    WHERE mi.prnt_std_image_id NOT IN (SELECT prnt_std_image_id FROM main_image_xlat) ");
        query.append("    GROUP BY mi.std_id ), ");
        //-- Find main External Links - NOT require translation. Children should be translated.
        query.append("main_link AS (SELECT sl.std_extl_link_id, sl.prnt_std_extl_link_id, sl.std_id, sl.locale_cd, sl.xlat_ind "); 
        query.append("    FROM std_extl_link sl, std_rec rec ");
        query.append("    WHERE sl.std_extl_link_id = sl.prnt_std_extl_link_id ");
        query.append("    AND sl.std_id = rec.std_id ");
        query.append("    AND sl.locale_cd = 'en_GB'), ");
        //-- find translated External Links 
        query.append("main_link_xlat AS (SELECT sl.std_extl_link_id, sl.prnt_std_extl_link_id, sl.std_id, sl.locale_cd, sl.xlat_ind "); 
        query.append("    FROM std_extl_link sl, main_link ml, locale l ");
        query.append("    WHERE sl.prnt_std_extl_link_id = ml.prnt_std_extl_link_id ");
        query.append("    AND sl.locale_cd = l.locale_cd), ");
        //-- Find missing External Links translations for a locale
        query.append("link_no_xlat AS (SELECT ml.std_id, COUNT(ml.std_id) AS loc_cnt ");
        query.append("    FROM main_link ml ");
        query.append("    WHERE ml.prnt_std_extl_link_id NOT IN (SELECT prnt_std_extl_link_id FROM main_link_xlat) ");
        query.append("    GROUP BY ml.std_id ), ");
        //-- Find Standards/Specifications/Guidelines with transled Title
        query.append("std_rec_no_xlat AS ( ");
        query.append("    SELECT std_id, COUNT(std_id) AS loc_cnt ");
        query.append("    FROM ( ");
        query.append("        SELECT s.std_id ");
        query.append("        FROM std_xlat sx, std s, std_rec rec, locale l ");  
        query.append("        WHERE s.std_id = sx.std_id ");
        query.append("        AND ((s.std_typ != 'GDLN' AND sx.TITLE_TXT_VLD_IND = 'N') OR ");          
        query.append("             (s.std_typ = 'GDLN' AND sx.STD_DESC_VLD_IND = 'N')) ");
        query.append("        AND sx.locale_cd = l.locale_cd ");
        query.append("        AND s.std_id = rec.std_id ");
        query.append("        UNION ");
        query.append("        SELECT std_id ");  
        query.append("        FROM std ");
        query.append("        WHERE stat_desc != 'DELETED' "); 
        query.append("        AND std_id IN (SELECT std_id FROM std_rec) ");   
        query.append("        AND std_id NOT IN ( SELECT std_id ");
        query.append("                            FROM std_xlat ");  
        query.append("                            WHERE std_id IN (SELECT std_id FROM std_rec) ");     
        query.append("        AND locale_cd IN (SELECT locale_cd FROM locale)) ");
        query.append("    ) GROUP BY std_id ), ");
        //-- Find Standards/Specifications/Guidelines unique std ids
        query.append("unique_xlat_std_id AS (SELECT std_id FROM attach_no_xlat ");
        query.append("    UNION ");
        query.append("    SELECT std_id FROM image_no_xlat ");
        query.append("    UNION ");
        query.append("    SELECT std_id FROM link_no_xlat ");
        query.append("    UNION ");
        query.append("    SELECT std_id FROM std_rec_no_xlat ), ");
        
        query.append("xlat_std_rec AS (SELECT rec.std_id, ");
        query.append("    (SELECT count(*) FROM std_rec_no_xlat WHERE std_id = rec.std_id) AS title_xlat, ");
        query.append("    (SELECT count(*) FROM attach_no_xlat WHERE std_id = rec.std_id) AS attach_xlat, ");
        query.append("    (SELECT count(*) from image_no_xlat where std_id = rec.std_id) AS img_xlat, ");
        query.append("    (SELECT count(*) from link_no_xlat where std_id = rec.std_id) AS lnk_xlat ");
        query.append("    FROM std_rec rec ");
        query.append("    WHERE rec.std_id IN (SELECT std_id FROM unique_xlat_std_id)), ");
        
        query.append(" CMS_TAXONOMY AS (");
        query.append(" SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT,");
        query.append(" SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH");
        query.append(" FROM TAXONOMY T WHERE T.TAXONOMY_ID > 1 START WITH T.TAXONOMY_ID=1");
        query.append(" CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID),");
        
        query.append("DIRECT_MATCH AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, s.std_id, s.prnt_std_id, s.std_typ, s.disp_order_nbr, "); 
        query.append("rec.title_xlat, rec.attach_xlat, rec.img_xlat, rec.lnk_xlat ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, std_rec s, xlat_std_rec rec ");
        query.append("WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID ");
        query.append("AND TSTD.STD_ID = s.prnt_std_id ");
        query.append("AND s.std_id = rec.std_id ),");
        
        query.append("MISSING_PRNT AS (SELECT s.std_id, s.prnt_std_id, s.std_typ, s.disp_order_nbr ");
        query.append("FROM STD s WHERE std_id IN ( ");
        query.append("SELECT prnt_std_id FROM DIRECT_MATCH WHERE STD_ID NOT IN (SELECT PRNT_STD_ID FROM DIRECT_MATCH) ");
        query.append(" MINUS SELECT prnt_std_id FROM DIRECT_MATCH WHERE STD_ID = prnt_std_id))");
        
        query.append(" (SELECT * FROM DIRECT_MATCH UNION ");
        query.append(" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, s.std_id, s.prnt_std_id, s.std_typ, s.disp_order_nbr, "); 
        query.append(" 0 AS title_xlat, 0 AS attach_xlat, 0 AS img_xlat, 0 AS lnk_xlat ");
        query.append(" FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, MISSING_PRNT s");
        query.append(" WHERE TAX.TAXONOMY_ID=TSTD.TAXONOMY_ID AND TSTD.STD_ID = s.prnt_std_id)");
        
        return query.toString();
    }

    

}
