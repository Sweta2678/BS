package com.ihg.brandstandards.bridge.util;

import java.util.List;

import com.ihg.brandstandards.util.QueryUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * All custom queries for Bridge portlet are written here.
 * @author AkhaniC
 *
 */
public class BridgeQueryUtils extends QueryUtils
{
    
	private static final Log LOG = LogFactoryUtil.getLog(BridgeQueryUtils.class);
	/**
     * 
     * @param brandCode String object
     * @return String
     */
    public static String getAllPublicationRecords (String brandCode) 
    {
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT p.publish_id, p.publish_ver_id, p.publish_stat_cd, p.publish_environment_nm, p.chain_cd, p.published_locale_list_txt, "); 
        query.append("p.creat_usr_id, p.creat_ts, p.lst_updt_usr_id, p.lst_updt_ts, p.publish_dt, p.publish_content_typ, p.prnt_publish_id, p.vld_xlat_ind ");
        query.append("FROM publish p WHERE p.chain_cd = '").append(brandCode);
        query.append("' AND (p.publish_environment_nm = 'PRODUCTION' ");
        query.append("OR (p.publish_environment_nm IN ('STAGING', 'BRIDGE') AND p.publish_stat_cd = 'ACTIVE')) ");
        query.append("UNION "); 
        query.append("SELECT p.publish_id, p.publish_ver_id, p.publish_stat_cd, p.publish_environment_nm, p.chain_cd, p.published_locale_list_txt, ");  
        query.append("p.creat_usr_id, p.creat_ts, p.lst_updt_usr_id, p.lst_updt_ts, p.publish_dt, p.publish_content_typ, p.prnt_publish_id, p.vld_xlat_ind "); 
        query.append("FROM ( ");
        query.append("SELECT p.publish_id, p.publish_ver_id, p.publish_stat_cd, p.publish_environment_nm, p.chain_cd, p.published_locale_list_txt, ");  
        query.append("p.creat_usr_id, p.creat_ts, p.lst_updt_usr_id, p.lst_updt_ts, p.publish_dt, p.publish_content_typ, p.prnt_publish_id, p.vld_xlat_ind ");
        query.append("FROM publish p "); 
        query.append("WHERE publish_environment_nm = 'BRIDGE' AND publish_stat_cd = 'ARCHIVE' AND chain_cd = '").append(brandCode).append("' ");
        query.append("ORDER BY creat_ts DESC) p ");
        query.append("WHERE rownum = 1 ");
        query.append(" UNION ");
        query.append(" (select publish_queue_id AS PUBLISH_ID , 0 as publish_ver_id, queue_stat_cd AS PUBLISH_STAT_CD, ");
        query.append("publish_environment_nm, chain_cd, locale_list_txt AS PUBLISHED_LOCALE_LIST_TXT, creat_usr_id, creat_ts, ");
        query.append("lst_updt_usr_id, lst_updt_ts, expt_prod_publish_dt AS PUBLISH_DT, null as PUBLISH_CONTENT_TYP, 0 AS PRNT_PUBLISH_ID, NULL AS vld_xlat_ind ");
        query.append("from publish_queue where chain_cd = '");
        query.append(brandCode);
        query.append("' and publish_environment_nm = 'STAGING' and queue_stat_cd = 'NEW') ");
        return query.toString();
    }
    
    /**
     * 
     * @param publishId
     * @return String
     */
    public static String getAllLanguagesForPublication (long publishId) 
    {
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT bl.rgn_id, listagg(bl.locale_cd,',') WITHIN GROUP (ORDER BY bl.bridge_publish_lang_id) AS lang ");
        query.append("FROM bridge_publish_lang bl WHERE bl.rgn_id IN ");
        query.append("(SELECT DISTINCT rgn_id FROM bridge_publish WHERE publish_id = ").append(publishId).append(") ");
        query.append("AND bl.publish_id = ").append(publishId).append(" group by bl.rgn_id");
        return query.toString();
    }
    
    /**
     * 
     * @param publishId
     * @return String
     */
    public static String getAllStdIdForPublication (long publishId) 
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT UNIQUE STD_ID FROM bridge_publish WHERE publish_id = ");
        query.append(publishId);
        return query.toString();
    }
    
    /**
     * @return String All Index Query
     */
    public static String getCMSAllIndexQuery()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL,");
        builder.append(" TAX.HIER_LVL_NBR, 0 PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE ");
        builder.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, ");
        builder.append(" T.PRNT_TAXONOMY_ID,T.TAXONOMY_DESC, T.TITLE_TXT, (LEVEL - 1) AS LVL, ");
        builder.append(" T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(  t.title_txt , ' &#8594; '),  31) AS PATH ");
        builder.append(" FROM TAXONOMY T ");
        builder.append(" WHERE T.TAXONOMY_ID > 1 ");
        builder.append(" START WITH T.TAXONOMY_ID = 1 ");
        builder.append(" CONNECT BY PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ORDER SIBLINGS BY T.HIER_LVL_NBR ) TAX");
        return builder.toString();
    }

    /**
     * This method will generate query to get Standards for Progress View Details based on the request.
     * @param publishId The publish id.
     * @param regionId The region id.
     * @param statIndText The status indicator text.
     * @return
     */
    public static String getUnpublishStandardsQuery(long publishId, long regionId, String chainCode, String regionCode, String stdIds)
    {
        StringBuilder query = new StringBuilder();
        
        query.append("WITH BRIDGE_DETAILS AS (");
        query.append("SELECT S.STD_ID, BP.UNPUBLISH_IND, S.RGN_CD, S.PRNT_STD_ID, S.STD_TYP, S.GBL_RGN_IND, S.FRAMEWORK_STD_IND, S.TITLE_TXT, S.STD_DESC, S.DISP_ORDER_NBR ");
        query.append("FROM BRIDGE_PUBLISH BP, STD S ");
        query.append("WHERE BP.PUBLISH_ID = ").append(publishId).append(" ");
        query.append("AND BP.STD_ID = S.STD_ID ");
        query.append("AND BP.RGN_ID = ").append(regionId).append(" ");
        if (!Validator.isNull(stdIds)) 
    	{
            query.append("AND S.STD_ID IN (SELECT STD_ID FROM STD WHERE PRNT_STD_ID IN (SELECT PRNT_STD_ID FROM STD WHERE STD_ID IN (");
            String[] ids = stdIds.split(StringPool.SPACE);
            for (int i=0; i < ids.length;i++) {
                query.append(GetterUtil.getLong(ids[i]));
                if (i != (ids.length - 1)) {
                    query.append(",");
                }
            }
            query.append(")))");

    	}
        query.append("), ");
        
        query.append("OBSM_DETAILS AS (");
        query.append("SELECT P.PUBLISH_ID ");
        query.append("FROM PUBLISH P ");
        query.append("WHERE P.CHAIN_CD = '").append(chainCode).append("' ");
        query.append("AND P.PUBLISH_ENVIRONMENT_NM = 'PRODUCTION'").append(" ");
        query.append("AND P.PUBLISH_STAT_CD = 'ACTIVE'").append("), ");
        
        query.append("REGION_CTRY AS (");
        query.append("SELECT CTRY_NM_CD ");
        query.append("FROM BRNDSTND_CTRY ");
        query.append("WHERE RGN_ID = ").append(regionId).append("), ");
        
        query.append("REGION_CTRY_STD AS (");
        query.append("SELECT BD.STD_ID, RC.CTRY_NM_CD ");
        query.append("FROM BRIDGE_DETAILS BD, REGION_CTRY RC ");
        query.append("WHERE BD.UNPUBLISH_IND = 'N'").append("), ");
        
        query.append("ACTIVE_OBSM_CNTRY AS (");
        query.append("SELECT PCS.CTRY_NM_CD, PS.STD_ID ");
        query.append("FROM PUBLISH_CTRY_STD PCS, PUBLISH_STD PS, OBSM_DETAILS OD, BRIDGE_DETAILS BD ");
        query.append("WHERE OD.PUBLISH_ID = PS.PUBLISH_ID ");
        query.append("AND PCS.PUBLISH_STD_VER_ID = PS.PUBLISH_STD_VER_ID ");
        query.append("AND BD.STD_ID = PS.STD_ID ");
        query.append("AND PCS.CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM REGION_CTRY) ");
        query.append("AND BD.UNPUBLISH_IND ='N'").append("), ");
        
        query.append("CTRY_STD_IDS AS (");
        query.append("SELECT CS.CTRY_NM_CD, CS.STD_ID, BD.UNPUBLISH_IND ");
        query.append("FROM CTRY_STD CS, BRIDGE_DETAILS BD ");
        query.append("WHERE BD.STD_ID = CS.STD_ID ");
        query.append("AND CS.CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM REGION_CTRY)").append("),");
        
        query.append("CURRENT_BRIDGE_CNTRY AS (");
        query.append("SELECT CSI.CTRY_NM_CD, CSI.STD_ID ");
        query.append("FROM CTRY_STD_IDS CSI ");
        query.append("WHERE CSI.UNPUBLISH_IND = 'N'").append("), ");
        
        query.append("UNPUBLISHED_STATUS AS (");
        query.append("SELECT AOC.STD_ID, AOC.CTRY_NM_CD FROM ACTIVE_OBSM_CNTRY AOC ");
        query.append("MINUS SELECT CBC.STD_ID, CBC.CTRY_NM_CD FROM CURRENT_BRIDGE_CNTRY CBC").append("), ");
        
        query.append("NOT_ATTRIBUTED_STATUS AS (");
        query.append("SELECT RCS.STD_ID, RCS.CTRY_NM_CD FROM REGION_CTRY_STD RCS ");
        query.append("MINUS SELECT CBC.STD_ID, CBC.CTRY_NM_CD FROM CURRENT_BRIDGE_CNTRY CBC ");
        query.append("MINUS SELECT AOC.STD_ID, AOC.CTRY_NM_CD FROM ACTIVE_OBSM_CNTRY AOC").append("), ");
        
        query.append("MY_PUBLICATION_WITH_CTRY_DIFF AS (");
        query.append("SELECT US.STD_ID, US.CTRY_NM_CD FROM UNPUBLISHED_STATUS US ");
        query.append("UNION SELECT NAS.STD_ID, NAS.CTRY_NM_CD FROM NOT_ATTRIBUTED_STATUS NAS").append("), ");
        /*query.append("SELECT AOC.STD_ID ");
        query.append("FROM ACTIVE_OBSM_CNTRY AOC, CURRENT_BRIDGE_CNTRY CBC ");
        query.append("WHERE CBC.STD_ID = AOC.STD_ID ");
        query.append("AND AOC.CTRY_CDS != CBC.CTRY_CDS ").append("), ");*/
        
        query.append("STD_DETAILS AS (");
        query.append("SELECT CSI.STD_ID ");
        query.append("FROM CTRY_STD_IDS CSI WHERE CSI.UNPUBLISH_IND ='Y' ");
        query.append("UNION ");
        query.append("SELECT STD_ID FROM MY_PUBLICATION_WITH_CTRY_DIFF").append("), ");
        
        query.append("BRIDGE_GBL_PUBLISH_RECORDS AS (");
        query.append("SELECT STD_ID, MUST_PUBLISH_IND ");
        query.append("FROM BRIDGE_GBL_PUBLISH ");
        query.append("WHERE PUBLISH_ID = ").append(publishId).append("), ");
        
        query.append("GLBL_NOT_IN_MUST AS (");
        query.append("SELECT BD.STD_ID ");
        query.append("FROM STD_DETAILS SD, BRIDGE_DETAILS BD ");
        query.append("WHERE SD.STD_ID = BD.STD_ID ");
        query.append("AND BD.RGN_CD = 'GLBL' ");
        query.append("AND SD.STD_ID NOT IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH_RECORDS WHERE MUST_PUBLISH_IND='Y')").append("), ");
        
        query.append("NOT_RGN AS (");
        query.append("SELECT STD_ID ");
        query.append("FROM STD_DETAILS ");
        query.append("WHERE STD_ID NOT IN (SELECT DISTINCT CSI.STD_ID FROM CTRY_STD_IDS CSI)").append("), ");
        
        query.append("NOT_BRND AS (");
        query.append("SELECT STD_ID ");
        query.append("FROM STD_DETAILS ");
        query.append("WHERE STD_ID NOT IN (SELECT DISTINCT CS.STD_ID FROM CHAIN_STD CS WHERE CS.CHAIN_CD = '").append(chainCode).append("' AND CS.ACTV_IND = 'Y')").append("), ");
        
        /*query.append("UNPUBLISH_MUST_NOT_STDS AS (");
        query.append("SELECT STD_ID ");
        query.append("FROM STD_DETAILS ");
        query.append("WHERE STD_ID IN (SELECT STD_ID FROM BRIDGE_GBL_PUBLISH_RECORDS WHERE MUST_PUBLISH_IND='N' )")
        query.append("AND STD_ID NOT IN (SELECT STD_ID FROM GLBL_NOT_IN_MUST)").append("), ");*/
        
        query.append("UNPUBLISH_STDS AS (");
        query.append("SELECT STD_ID ");
        query.append("FROM STD_DETAILS ");
        query.append("WHERE STD_ID NOT IN (SELECT STD_ID FROM GLBL_NOT_IN_MUST UNION SELECT STD_ID FROM NOT_RGN UNION SELECT STD_ID FROM NOT_BRND UNION SELECT STD_ID FROM MY_PUBLICATION_WITH_CTRY_DIFF)").append("), ");
        
        query.append("SELECTED_STD_IDS AS (");
        query.append("SELECT STD_ID, 'GLBL_NOT_IN_MUST' AS STAT_DESC FROM GLBL_NOT_IN_MUST UNION ");
        //query.append("SELECT STD_ID, 'MUST_NOT' AS STAT_DESC FROM UNPUBLISH_MUST_NOT_STDS UNION ");
        query.append("SELECT STD_ID, 'UNPUBLISH' AS STAT_DESC FROM UNPUBLISH_STDS UNION ");
        query.append("SELECT STD_ID, 'MOVED_CTRY_DIFF' AS STAT_DESC FROM MY_PUBLICATION_WITH_CTRY_DIFF UNION ");
        query.append("SELECT PRNT_STD_ID, '' AS STAT_DESC FROM BRIDGE_DETAILS BD ");
        query.append("WHERE BD.STD_ID IN (SELECT STD_ID FROM UNPUBLISH_STDS UNION SELECT STD_ID FROM MY_PUBLICATION_WITH_CTRY_DIFF UNION SELECT STD_ID FROM GLBL_NOT_IN_MUST) ");
        query.append("AND BD.PRNT_STD_ID NOT IN (SELECT STD_ID FROM MY_PUBLICATION_WITH_CTRY_DIFF) ");
        query.append("AND BD.PRNT_STD_ID NOT IN (SELECT STD_ID FROM UNPUBLISH_STDS) ");
        query.append("AND BD.PRNT_STD_ID NOT IN (SELECT STD_ID FROM GLBL_NOT_IN_MUST)").append("), ");
        
        query.append("RGN_CTRY AS (");
        query.append("SELECT COUNT(*) CMS_CTRY_CNT FROM REGION_CTRY").append("), ");
        
        query.append("STD_CTRY_CNT AS (");
        query.append("SELECT CMSCTRY.STD_ID, CASE WHEN CMSCTRY.BRG_CTRY_CNT > 0 THEN CASE WHEN CMS.CMS_CTRY_CNT = CMSCTRY.BRG_CTRY_CNT THEN 'btn-primary' ELSE 'btn-info' END END AS STD_RGN_COLOR ");
        query.append("FROM (SELECT COUNT(CSI.CTRY_NM_CD) AS BRG_CTRY_CNT, CSI.STD_ID AS STD_ID FROM CTRY_STD_IDS CSI, SELECTED_STD_IDS SSI WHERE SSI.STD_ID = CSI.STD_ID GROUP BY CSI.STD_ID ) CMSCTRY, RGN_CTRY CMS").append("), ");
        
        query.append("SELECTED_STD_REC AS (");
        query.append("SELECT BD.STD_ID, BD.PRNT_STD_ID, BD.STD_TYP, BD.RGN_CD, BD.GBL_RGN_IND, BD.FRAMEWORK_STD_IND, BD.TITLE_TXT, BD.STD_DESC, SS.STAT_DESC, BD.DISP_ORDER_NBR ");
        query.append("FROM BRIDGE_DETAILS BD, SELECTED_STD_IDS SS ");
        query.append("WHERE BD.STD_ID = SS.STD_ID").append("), ");
        
        query.append("DISP_ORDER AS (");
        query.append("SELECT DISP.DISP_ORDER_NBR, DISP.STD_ID ");
        query.append("FROM STD_DISPLAY_ORDER DISP ");
        query.append("WHERE DISP.STD_ID IN (SELECT STD_ID FROM SELECTED_STD_REC) ");
        query.append("AND DISP.RGN_CD = '").append(regionCode).append("' ");
        query.append("AND DISP.CHAIN_CD = '").append(chainCode).append("'").append("), ");
        
        query.append("CMS_TAXONOMY AS (");
        query.append("SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' &#8594; '), 31) AS PATH ");
        query.append("FROM TAXONOMY T ");
        query.append("WHERE T.TAXONOMY_ID > 1 ");
        query.append("START WITH T.TAXONOMY_ID = 1 ");
        query.append("CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID").append("), ");
        
        query.append("DIRECT_MATCH AS (");
        query.append("SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE, SSR.PRNT_STD_ID, SSR.STD_ID, SSR.STD_TYP, SSR.RGN_CD, SSR.GBL_RGN_IND, SSR.FRAMEWORK_STD_IND, SSR.TITLE_TXT, SSR.STD_DESC, SSR.STAT_DESC, COALESCE(DISP.DISP_ORDER_NBR, 0) DISP_ORDER_NBR, SR.STD_RGN_COLOR ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, SELECTED_STD_REC SSR, DISP_ORDER DISP, STD_CTRY_CNT SR ");
        query.append("WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID ");
        query.append("AND SSR.STD_ID = SSR.PRNT_STD_ID ");
        query.append("AND TSTD.STD_ID = SSR.PRNT_STD_ID ");
        query.append("AND SSR.STD_ID = DISP.STD_ID(+) ");
        query.append("AND SSR.STD_ID = SR.STD_ID(+)").append(") ");
        
        query.append("(SELECT * FROM DIRECT_MATCH UNION ");
        query.append("SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE, SSR.PRNT_STD_ID, SSR.STD_ID, SSR.STD_TYP, SSR.RGN_CD, SSR.GBL_RGN_IND, SSR.FRAMEWORK_STD_IND, SSR.TITLE_TXT, SSR.STD_DESC, SSR.STAT_DESC, COALESCE(DISP.DISP_ORDER_NBR, 0) DISP_ORDER_NBR, SR.STD_RGN_COLOR ");
        query.append("FROM CMS_TAXONOMY TAX, TAXONOMY_STD TSTD, SELECTED_STD_REC SSR, DISP_ORDER DISP, STD_CTRY_CNT SR ");
        query.append("WHERE TAX.TAXONOMY_ID = TSTD.TAXONOMY_ID ");
        query.append("AND TSTD.STD_ID IN (SELECT PRNT_STD_ID FROM DIRECT_MATCH) ");
        query.append("AND TSTD.STD_ID = SSR.PRNT_STD_ID ");
        query.append("AND SSR.STD_ID = DISP.STD_ID(+) ");
        query.append("AND SSR.STD_ID = SR.STD_ID(+))");
        
        LOG.info("Un Publish  query is :"+query.toString());
       
        return query.toString();
    }
    
    /**
     * 
     * @param brandCode String object
     * @param environment String object
     * @param status String object
     * @return String
     */
    public static String getPublishQueueRecords (String brandCode, String environment, String status) 
    {
        
        StringBuffer query = new StringBuffer();
        query.append("select * from publish_queue pq where pq.chain_cd = '");
        query.append(brandCode).append("' and pq.publish_environment_nm = '");
        query.append(environment).append("' ");
        if (Validator.isNotNull(status)) {
        	String[] statusList = status.split(StringPool.COMMA);
        	query.append("and pq.queue_stat_cd in (");
        	for (int i = 0; i < statusList.length; i++ ) {
        		if (i != 0) {
        			query.append(" , ");
        		}
        		query.append("'").append(statusList[i]).append("'");
        	}
        	query.append(")");
    	}
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Publish queue query is :"+query.toString());
        }
        return query.toString();
    }
    
    /**
     * 
     * @param publishId
     * @param brandCode
     * @param regionId
     * @param screenName
     * @param stdIds
     * @return
     */
    public static String updateUnpublishedToPublishedRecords(long publishId, String brandCode, long regionId, String screenName, String stdIds) {
        StringBuilder query = new StringBuilder();
		query.append("DECLARE");
		query.append(" l_chain_cd VARCHAR2(5) := '");
		query.append(brandCode);
		query.append("';");
		query.append(" l_bridge_draft_id NUMBER := ");
		query.append(publishId);
		query.append(";");
		query.append(" l_rgn_id NUMBER := ");
		query.append(regionId);
		query.append(";");
		query.append(" l_user_id VARCHAR2(50) := '");
		query.append(screenName);
		query.append("';");
		query.append(" l_std_id_lst VARCHAR2(4000) := '");
		query.append(stdIds);
		query.append("';");
		query.append(" l_publish_id NUMBER;");
		query.append(" l_chng_stat_cd VARCHAR2(50);");
		query.append(" l_std_ids number_table;");
		query.append(" l_bridge_ctry_id NUMBER;");
		query.append(" l_bridge_publish_id NUMBER;");
		query.append(" l_pub_std_id NUMBER;");
		query.append(" l_std_id NUMBER;");
		query.append(" l_ctry_mn VARCHAR2(3);");
		query.append(" l_stat_cd VARCHAR2(20);");
		query.append(" l_cur SYS_REFCURSOR;");
		query.append(" l_new_ctry_cur SYS_REFCURSOR;");
		query.append(" l_std_cur SYS_REFCURSOR;");
		query.append(" l_cur_std_id NUMBER;");
		query.append(" l_cnt NUMBER;");
		query.append(" l_sel_rec VARCHAR2(700) := ");
		query.append("  'SELECT ps.publish_std_ver_id, ps.STD_ID, cs.ctry_nm_cd, ' || ");
		query.append("  'CASE WHEN ps.std_typ=''GDLN'' THEN ' || ");
		query.append("  'CASE WHEN (TRIM(ps.std_desc) = TRIM(s.std_desc)) THEN ''NO_CHANGE'' ELSE ''UPDATE'' END ELSE ' || ");
		query.append("  'CASE WHEN (TRIM(ps.title_txt) = TRIM(s.TITLE_TXT)) THEN ''NO_CHANGE'' ELSE ''UPDATE'' END END AS publish_stat_cd ' || ");
		query.append("  'FROM publish_std ps, publish_ctry_std cs, STD s ' || ");
		query.append("  'WHERE ps.publish_std_ver_id = cs.publish_std_ver_id AND ps.std_id = s.std_id ' || ");
		query.append("  'AND ps.publish_id = :pub_id ' ||");
		query.append("  'AND ps.std_id IN (:std_ids) ' || ");
		query.append("  'AND cs.ctry_nm_cd IN (SELECT bc.ctry_nm_cd FROM brndstnd_ctry bc, ctry_std cs ' || ");
		query.append("  'WHERE bc.ctry_nm_cd = cs.ctry_nm_cd AND cs.std_id IN (:std_ids) AND bc.rgn_id = :rgn_id)'; ");
		query.append(" l_ins_ctry VARCHAR2(500) :=");
		query.append("  'INSERT INTO bridge_publish_ctry(bridge_publish_ctry_id, bridge_publish_id, ctry_nm_cd, ' || ");
		query.append("  'bridge_publish_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
		query.append("  'VALUES(:ctry_id_seq, :brg_pub_id, :ctry_nm, :stat_cd, :cr_usr_id, :cr_ts, :upd_usr_id, :upd_ts) '; ");
		query.append(" l_exist VARCHAR2(150) := 'SELECT count(*) FROM bridge_publish_ctry WHERE bridge_publish_id = :br_pub_id AND ctry_nm_cd = :ctry_nm'; ");
		query.append(" l_upd_stat VARCHAR2(200) := 'UPDATE bridge_publish_ctry SET bridge_publish_stat_cd = :chng_stat, lst_updt_ts = SYSDATE, publish_ind=''Y'' WHERE bridge_publish_id = :br_pub_id AND ctry_nm_cd = :ctry_nm'; ");
		query.append(" l_new_ctry VARCHAR2(200) := ");
		query.append("  'SELECT ctry_nm_cd FROM ctry_std cs WHERE std_id = :std_id ' || ");
		query.append("  'AND ctry_nm_cd NOT IN (SELECT ctry_nm_cd FROM publish_ctry_std ' || ");
		query.append("  'WHERE publish_std_ver_id = :std_ver_id) ';");
		query.append(" l_brg_rec_exist VARCHAR2(150) := 'SELECT count(*) FROM bridge_publish WHERE publish_id = :pub_id AND std_id = :std_id AND rgn_id = :rgnId'; ");
		//query.append(" l_brg_unpublish_rec VARCHAR2(150) := 'SELECT count(*) FROM bridge_publish WHERE publish_id = :pub_id AND std_id = :std_id AND rgn_id = :rgnId AND unpublish_ind=''Y'''; ");
		query.append(" l_ins_brg_sql VARCHAR2(500) := ");
		query.append("  'INSERT INTO bridge_publish(bridge_publish_id, publish_id, std_id, rgn_id, ' || ");
		query.append("  'unpublish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
		query.append("  'VALUES(:bridgePubId, :pubId, :stdId, :rgnId, :unpubInd, :crUsrId, :crTs, :lstUpdtUsrId, :lstUpdtTs) '; ");
		query.append("BEGIN");
		query.append(" l_publish_id := brandstandardspublish.getLatestPublishedId(l_chain_cd);");
		query.append(" l_std_ids := brandstandardspublish.delimclob_to_num_table(l_std_id_lst);");
		query.append(" IF l_publish_id > 0 THEN");
		query.append("  IF l_std_ids IS NOT NULL AND l_std_ids.COUNT > 0 THEN");
		
		// -- Looping standard one by one
		query.append("  	OPEN l_std_cur FOR SELECT std_id FROM STD WHERE STD_ID IN (SELECT COLUMN_VALUE FROM TABLE(l_std_ids));");
		query.append("  	LOOP");
		query.append("  		FETCH l_std_cur INTO l_cur_std_id;");
		query.append("  		EXIT WHEN l_std_cur%NOTFOUND;");
		
		// -- Existing Countries
		query.append("   OPEN l_cur FOR l_sel_rec");
		query.append("   USING l_publish_id, l_cur_std_id, l_cur_std_id, l_rgn_id;");
		query.append("   LOOP");
		query.append("    FETCH l_cur INTO l_pub_std_id, l_std_id, l_ctry_mn, l_chng_stat_cd;");
		query.append("    EXIT WHEN l_cur%NOTFOUND;");
		//query.append("    EXECUTE IMMEDIATE l_brg_unpublish_rec INTO l_cnt USING l_bridge_draft_id, l_std_id, l_rgn_id;");
		//query.append("    IF(l_cnt > 0) THEN");
		query.append("    EXECUTE IMMEDIATE l_brg_rec_exist INTO l_cnt USING l_bridge_draft_id, l_std_id, l_rgn_id;");
		query.append("    IF l_cnt = 0 THEN");
		query.append("     SELECT bridge_publish_id_seq.nextval INTO l_bridge_publish_id FROM dual;");
		query.append("     EXECUTE IMMEDIATE l_ins_brg_sql USING l_bridge_publish_id, l_bridge_draft_id, l_std_id, l_rgn_id, 'N', l_user_id, SYSDATE, l_user_id, SYSDATE;");
		query.append("    ELSE");
		query.append("     SELECT bridge_publish_id INTO l_bridge_publish_id FROM bridge_publish WHERE publish_id=l_bridge_draft_id AND std_id=l_std_id AND rgn_id=l_rgn_id;");
		query.append("     UPDATE bridge_publish SET unpublish_ind='N', lst_updt_ts=SYSDATE WHERE bridge_publish_id=l_bridge_publish_id;");
		query.append("    END IF;");
		query.append("    EXECUTE IMMEDIATE l_exist INTO l_cnt USING l_bridge_publish_id, l_ctry_mn;");
        query.append("    SELECT l_chng_stat_cd INTO l_stat_cd FROM dual;");
		query.append("    IF l_cnt = 0 THEN");
		query.append("     EXECUTE IMMEDIATE l_ins_ctry USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, l_stat_cd, l_user_id, SYSDATE, l_user_id, SYSDATE;");
		query.append("    ELSE");
		query.append("     EXECUTE IMMEDIATE l_upd_stat USING l_stat_cd, l_bridge_publish_id, l_ctry_mn;");
		query.append("    END IF;");
		// -- New Countries
		query.append("    OPEN l_new_ctry_cur FOR l_new_ctry USING l_std_id, l_pub_std_id;");
		query.append("    LOOP");
		query.append("     FETCH l_new_ctry_cur INTO l_ctry_mn;");
		query.append("     EXIT WHEN l_new_ctry_cur%NOTFOUND;");
		query.append("     EXECUTE IMMEDIATE l_exist INTO l_cnt USING l_bridge_publish_id, l_ctry_mn;");
		query.append("     IF l_cnt = 0 THEN");
		query.append("      EXECUTE IMMEDIATE l_ins_ctry USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, 'NEW', l_user_id, SYSDATE, l_user_id, SYSDATE;");
		query.append("     ELSE"); 
		query.append("       UPDATE bridge_publish_ctry SET lst_updt_ts=SYSDATE, publish_ind='Y' WHERE bridge_publish_id = l_bridge_publish_id;");
		query.append("     END IF;");
		query.append("    END LOOP;");
		query.append("    IF l_new_ctry_cur IS NOT NULL THEN");
		query.append("     CLOSE l_new_ctry_cur;");
		query.append("    END IF;");
		//query.append("    END IF;");
		// -- END Of New Countries
		query.append("   END LOOP;");
		query.append("   IF l_cur IS NOT NULL THEN");
		query.append("    CLOSE l_cur;");
		query.append("   END IF;");
		//-- END Of Existing Countries
		
		query.append("  	END LOOP;");
		query.append("  	IF l_std_cur IS NOT NULL THEN");
		query.append("  		CLOSE l_std_cur;");
		query.append("  	END IF;");
		//-- END Of STD loop
		
		query.append("  END IF;");
		query.append(" ELSE ");
		query.append("  IF l_std_ids IS NOT NULL AND l_std_ids.COUNT > 0 THEN");
		query.append("   l_stat_cd := 'NEW';");
		
		// -- Looping standard one by one
		query.append("  	OPEN l_std_cur FOR SELECT std_id FROM STD WHERE STD_ID IN (SELECT COLUMN_VALUE FROM TABLE(l_std_ids));");
		query.append("  	LOOP");
		query.append("  		FETCH l_std_cur INTO l_cur_std_id;");
		query.append("  		EXIT WHEN l_std_cur%NOTFOUND;");
		
		// -- Existing Countries
		query.append("   OPEN l_cur FOR l_sel_rec USING l_publish_id, l_cur_std_id, l_cur_std_id, l_rgn_id;");
		query.append("   LOOP");
		query.append("    FETCH l_cur INTO l_pub_std_id, l_std_id, l_ctry_mn, l_chng_stat_cd;");
		query.append("    EXIT WHEN l_cur%NOTFOUND;");
		query.append("    EXECUTE IMMEDIATE l_brg_rec_exist INTO l_cnt USING l_bridge_draft_id, l_std_id, l_rgn_id;");
		query.append("    IF l_cnt = 0 THEN");
		query.append("     SELECT bridge_publish_id_seq.nextval INTO l_bridge_publish_id FROM dual;");
		query.append("     EXECUTE IMMEDIATE l_ins_brg_sql USING l_bridge_publish_id, l_bridge_draft_id, l_std_id, l_rgn_id, 'N', l_user_id, SYSDATE, l_user_id, SYSDATE;");
		query.append("    ELSE");
		query.append("     SELECT bridge_publish_id INTO l_bridge_publish_id FROM bridge_publish WHERE publish_id = l_bridge_draft_id AND std_id = l_std_id AND rgn_id = l_rgn_id;");
		query.append("     UPDATE bridge_publish SET unpublish_ind='N', lst_updt_ts=SYSDATE WHERE bridge_publish_id=l_bridge_publish_id;");
		query.append("    END IF;");
		query.append("    EXECUTE IMMEDIATE l_exist INTO l_cnt USING l_bridge_publish_id, l_ctry_mn;");
		query.append("    IF l_cnt = 0 THEN");
		query.append("     EXECUTE IMMEDIATE l_ins_ctry USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, l_stat_cd, l_user_id, SYSDATE, l_user_id, SYSDATE;");
		query.append("    ELSE"); 
		query.append("     UPDATE bridge_publish_ctry SET lst_updt_ts=SYSDATE, publish_ind='Y' WHERE bridge_publish_id = l_bridge_publish_id;");
		query.append("    END IF;");
		// -- New Countries
		query.append("    OPEN l_new_ctry_cur FOR l_new_ctry USING l_std_id, l_pub_std_id;");
		query.append("    LOOP");
		query.append("     FETCH l_new_ctry_cur INTO l_ctry_mn;");
		query.append("     EXIT WHEN l_new_ctry_cur%NOTFOUND;");
		query.append("     EXECUTE IMMEDIATE l_exist INTO l_cnt USING l_bridge_publish_id, l_ctry_mn;");
		query.append("     IF l_cnt = 0 THEN");
		query.append("      EXECUTE IMMEDIATE l_ins_ctry");
		query.append("      USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, 'NEW', l_user_id, SYSDATE, l_user_id, SYSDATE;");
		query.append("     ELSE"); 
		query.append("     	UPDATE bridge_publish_ctry SET lst_updt_ts = SYSDATE, publish_ind='Y' WHERE bridge_publish_id = l_bridge_publish_id;");
		query.append("     END IF;");
		query.append("    END LOOP;");
		query.append("    IF l_new_ctry_cur IS NOT NULL THEN ");
        query.append("     CLOSE l_new_ctry_cur; ");
		query.append("    END IF;");
		//-- END Of New Countries
		query.append("   END LOOP;");
		query.append("   IF l_cur IS NOT NULL THEN ");
        query.append("    CLOSE l_cur;");
		query.append("   END IF;");
		
		query.append("  	END LOOP;");
		query.append("  	IF l_std_cur IS NOT NULL THEN");
		query.append("  		CLOSE l_std_cur;");
		query.append("  	END IF;");
		//-- END Of STD loop
		
		query.append("  END IF;");
		query.append(" END IF;");
		query.append(" COMMIT;");
		query.append("END;");
		return query.toString();
	}
    
    /**
     * 
     * @param publishId
     * @param brand
     * @param userName
     * @return String
     */
    public static String createPublication (long publishId, String brand, String userName) 
    {
        StringBuilder queryBuffer = new StringBuilder();
    	queryBuffer.append("DECLARE ");
    	queryBuffer.append("  TYPE BRIDGE_RECS IS RECORD ( std_id NUMBER,rgn_lst VARCHAR2(50));");
    	queryBuffer.append("  TYPE bridge_rec_arr IS VARRAY(5000) OF BRIDGE_RECS;");
    	queryBuffer.append("  l_bridge_recs_arr bridge_rec_arr;");
    	queryBuffer.append("  l_chain_cd VARCHAR2(5) := ?;");
    	queryBuffer.append("  l_bridge_pidlish_id NUMBER := ?;");
		queryBuffer.append("  l_usr_id VARCHAR2(50) := ?;");
		queryBuffer.append("  l_last_publish_id NUMBER;");
		queryBuffer.append("  l_cur SYS_REFCURSOR;");
		queryBuffer.append("  l_std_id NUMBER;");
		queryBuffer.append("  l_rgn_id NUMBER;");
		queryBuffer.append("  l_rgn_cd VARCHAR2(4);");
		queryBuffer.append("  l_rgn_lst VARCHAR2(50);");
		queryBuffer.append("  l_unpublish_ind VARCHAR2(1) := 'Y';");
		queryBuffer.append("  l_count BINARY_INTEGER;");
		queryBuffer.append("  l_publish_std_id NUMBER;");
		queryBuffer.append("  l_gbl_rgn_ind VARCHAR2(1);"); 
		queryBuffer.append("  l_array DBMS_UTILITY.LNAME_ARRAY;");
		queryBuffer.append("  l_ins_sql VARCHAR2(500) := ");
		queryBuffer.append("   'INSERT INTO bridge_publish(bridge_publish_id, publish_id, std_id, rgn_id, ' || ");
		queryBuffer.append("   'unpublish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
		queryBuffer.append("   'VALUES(:bridgePubId, :pubId, :stdId, :rgnId, :unpubInd, ' ||");
		queryBuffer.append("   ':crUsrId, :crTs, :lstUpdtUsrId, :lstUpdtTs) ';");
		queryBuffer.append("  l_cur_brdg_publish_id NUMBER;");
		queryBuffer.append("  l_del_brdg_publish_id NUMBER;");
		queryBuffer.append("  l_curr_gem_publish_id NUMBER;");
		queryBuffer.append("  l_cnt NUMBER;");
		queryBuffer.append("BEGIN ");
		queryBuffer.append("  l_last_publish_id := brandstandardspublish.getLatestPublishedId(l_chain_cd); ");
		queryBuffer.append("  IF l_last_publish_id > 0 THEN ");
		queryBuffer.append("    OPEN l_cur FOR ");
		queryBuffer.append("    SELECT s.std_id, STD_REGION.rgn_nm ");
		queryBuffer.append("    FROM publish_std s, ");
		queryBuffer.append("    (SELECT ct.publish_std_ver_id, ");
		queryBuffer.append("    regexp_replace(LISTAGG(brandstandardspublish.get_country_region(ct.ctry_nm_cd), ',') ");
		queryBuffer.append("    WITHIN GROUP (ORDER BY ct.publish_std_ver_id), '([^,]+)(,\\1)+', '\\1')");
		queryBuffer.append("    AS RGN_NM FROM publish_ctry_std ct GROUP BY ct.publish_std_ver_id) STD_REGION ");
		queryBuffer.append("    WHERE s.publish_std_ver_id = STD_REGION.publish_std_ver_id AND s.publish_id = l_last_publish_id; ");
		queryBuffer.append("    LOOP ");
		queryBuffer.append("    FETCH l_cur INTO l_std_id, l_rgn_lst; ");
		queryBuffer.append("    EXIT WHEN l_cur%NOTFOUND; ");
		queryBuffer.append("      dbms_utility.comma_to_table(LIST => l_rgn_lst, tablen => l_count, tab => l_array);");
		queryBuffer.append("      FOR i IN 1 .. l_count ");
		queryBuffer.append("      LOOP ");
		queryBuffer.append("        l_rgn_cd := l_array(i); ");
		queryBuffer.append("        SELECT decode(l_rgn_cd, 'AMER', 2, 'AMEA', 3, 'EURO', 4, 'GC', 5, 0) INTO l_rgn_id FROM dual;");
		queryBuffer.append("        EXECUTE IMMEDIATE l_ins_sql ");
		queryBuffer.append("        USING bridge_publish_id_seq.nextval, l_bridge_pidlish_id, l_std_id, l_rgn_id, l_unpublish_ind, l_usr_id, SYSDATE, l_usr_id, SYSDATE;");
		queryBuffer.append("      END LOOP;");
        queryBuffer.append("    END LOOP;");
		queryBuffer.append("    IF l_cur IS NOT NULL THEN");
		queryBuffer.append("      CLOSE l_cur; ");
		queryBuffer.append("    END IF; ");
        queryBuffer.append("  END IF; ");
        queryBuffer.append("  COMMIT; ");
        
        //Switch GEM Publication to newly created Bridge Publication if the gem publication for this brand is pointing to deleted bridge publication
        queryBuffer.append("  SELECT count(*) INTO l_cnt FROM PUBLISH bp, PUBLISH gp WHERE bp.publish_id=gp.prnt_publish_id AND gp.publish_environment_nm='GEM_CMS'"); 
        queryBuffer.append("  AND gp.publish_stat_cd = 'ACTIVE' AND gp.chain_cd=l_chain_cd AND bp.publish_stat_cd='DELETE';");
        queryBuffer.append("  IF l_cnt > 0 THEN");
        queryBuffer.append("    SELECT PUBLISH_ID INTO l_cur_brdg_publish_id FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='BRIDGE' AND CHAIN_CD=l_chain_cd;");
       // queryBuffer.append("    SELECT PRNT_PUBLISH_ID INTO l_del_brdg_publish_id FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='GEM_CMS' AND CHAIN_CD=l_chain_cd;");
        queryBuffer.append(" IF l_cur_brdg_publish_id > 0 THEN ");  
        queryBuffer.append("    UPDATE PUBLISH SET PRNT_PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID IN ( ");
        queryBuffer.append("    SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='GEM_CMS' AND CHAIN_CD=l_chain_cd AND ");
        queryBuffer.append(" PRNT_PUBLISH_ID IN (SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_STAT_CD='DELETE' AND PUBLISH_ENVIRONMENT_NM='BRIDGE' AND CHAIN_CD=l_chain_cd)); ");
        
        queryBuffer.append(" END IF; ");
       /* queryBuffer.append("    UPDATE GEM_CHAIN_MSRMNT SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_MSRMNT_BUCKET_CHAIN SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_MSRMNT_FORMULA SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_CHAIN_MSRMNT SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_SCOR_PT SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_TEMPLATE SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_TRIGGER SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE GEM_UNIQUE_GRP SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");
        queryBuffer.append("    UPDATE QLTY_LEAD_RPT SET PUBLISH_ID=l_cur_brdg_publish_id WHERE PUBLISH_ID=l_del_brdg_publish_id;");*/
        queryBuffer.append("  	COMMIT;");
        queryBuffer.append("  END IF;");
        
        queryBuffer.append("END; ");
    	
    	return queryBuffer.toString();
    }

    public static String getMyPublicationQuery(String chainCode, String regionId, String regionCode, String stdIds)
    {
        StringBuilder query = new StringBuilder(" WITH ");
    	query.append("CMS_TAX as (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH");
    	query.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT,");
    	query.append(" SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT,  ' &#8594; '), 31) AS PATH");
    	query.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ORDER BY LVL, T.HIER_LVL_NBR) TAX),");
    	query.append(" CURR_PUBLISH AS (SELECT PUBLISH_ID FROM PUBLISH WHERE publish_environment_nm = 'BRIDGE' AND publish_stat_cd = 'ACTIVE' AND CHAIN_CD ='");
    	query.append(chainCode).append("'), ");
    	
    	query.append("CURR_BRIDGE_PUBLISH AS (SELECT bp.bridge_publish_id, bp.std_id, bp.unpublish_ind");
    	query.append(" FROM bridge_publish bp, ");
    	query.append(" (SELECT publish_id, chain_cd FROM publish WHERE publish_environment_nm = 'BRIDGE' AND publish_stat_cd = 'ACTIVE' AND chain_cd ='").append(chainCode).append("') cp");
    	query.append(" WHERE bp.rgn_id = ").append(regionId).append("");
    	query.append(" AND bp.publish_id = cp.publish_id");
    	query.append(" AND bp.unpublish_ind = 'N'), ");
    	query.append("SELECTED_STD AS (SELECT s.std_id, s.std_typ, s.prnt_std_id, CASE WHEN s.std_typ = 'GDLN' THEN s.std_desc ELSE s.title_txt END title,"); 
    	query.append(" s.rgn_cd, ");
    	query.append(regionId);
    	query.append(" rgn_id, '");
    	query.append(chainCode);
    	query.append("' chain_cd, decode(s.rgn_cd, 'GLBL', 'Y', 'N') isglobal, bp.bridge_publish_id, bp.unpublish_ind");
    	query.append(" FROM std s, curr_bridge_publish bp");
    	query.append(" WHERE s.std_id = bp.std_id");
    	
    	if (!Validator.isNull(stdIds)) 
    	{
            query.append(" AND s.std_id IN (SELECT std_id FROM std WHERE prnt_std_id IN (SELECT prnt_std_id FROM std WHERE std_id in (");
            String[] ids = stdIds.split(StringPool.SPACE);
            for (int i=0; i < ids.length;i++) {
                if (i != 0) {
                    query.append(",");
                }
                query.append(GetterUtil.getLong(ids[i]));
            }
            query.append(")))");

    	}
    	query.append("),");
    	query.append("STD_REF AS (SELECT referring_std_id, LISTAGG(referenced_std_id, ', ') WITHIN GROUP (ORDER BY disp_order_nbr, referenced_std_id) AS XREF_LST_STD_ID");
    	query.append(" FROM std_xref");
    	query.append(" WHERE referring_std_id IN (SELECT STD_ID FROM SELECTED_STD)");
    	query.append(" AND referenced_std_id NOT IN (SELECT std_id FROM std WHERE std_id = referenced_std_id AND stat_desc = 'DELETED')");
    	query.append(" AND referenced_std_id IN");
    	query.append(" (SELECT CS.STD_ID");
    	query.append("  FROM CHAIN_STD CS, STAT ST");
    	query.append("  WHERE CS.STAT_ID = ST.STAT_ID");
    	query.append("  AND ST.STAT_CD NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
    	query.append("  AND CS.CHAIN_CD = '");
    	query.append(chainCode);
    	query.append("'  AND CS.STD_ID = referenced_std_id");
    	query.append("  AND CS.ACTV_IND = 'Y')");
    	query.append("  AND referenced_std_id IN");
    	query.append(" (SELECT DISTINCT CS.STD_ID");
    	query.append("  FROM CTRY_STD CS");
    	query.append("  WHERE CS.CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID = ").append(regionId).append(")");
    	query.append("  AND CS.STD_ID = referenced_std_id)");
    	query.append(" GROUP BY referring_std_id), ");
    	query.append("DISPL_OPT AS (SELECT s.std_id, 'UPDATED' shows");
    	query.append(" FROM publish_std s");
    	query.append(" WHERE s.publish_id = (SELECT publish_id FROM publish WHERE publish_environment_nm = 'PRODUCTION' AND publish_stat_cd = 'ACTIVE' AND chain_cd = '").append(chainCode).append("')");
    	query.append(" AND s.std_id IN (SELECT std_id FROM selected_std)), ");
    	query.append("RGN_CTRY AS (SELECT COUNT(*) cms_ctry_cnt FROM brndstnd_ctry bc WHERE bc.rgn_id = ").append(regionId).append("), ");
    	query.append("STD_CTRY_CNT AS");
//        query.append(" (SELECT cbpc.std_id, cbpc.brg_ctry_cnt, COALESCE(cms.cms_ctry_cnt, 0) cms_ctry_cnt");
    	query.append(" (SELECT cbpc.std_id, ");
    	query.append(" CASE WHEN cbpc.brg_ctry_cnt > 0 THEN");
        query.append("   CASE WHEN cms.cms_ctry_cnt = cbpc.brg_ctry_cnt THEN 'btn-primary'");
        query.append("   ELSE 'btn-info' END");
        query.append(" END AS STD_RGN_COLOR");
    	query.append(" FROM (SELECT cbp.std_id, count(bpc.ctry_nm_cd) AS brg_ctry_cnt");
    	query.append("  FROM curr_bridge_publish cbp, bridge_publish_ctry bpc");
    	query.append("  WHERE cbp.bridge_publish_id = bpc.bridge_publish_id(+)");
    	query.append("  AND 'Y' = bpc.publish_ind(+)");
    	query.append("  GROUP BY cbp.std_id) cbpc,");
    	query.append("  RGN_CTRY cms), ");
    	query.append("UNATTRIBUTE_BRAND AS (SELECT std_id FROM selected_std");
    	query.append(" MINUS");
    	query.append(" SELECT bp.std_id");
    	query.append(" FROM selected_std bp, chain_std cs");
    	query.append(" WHERE bp.std_id = cs.std_id");
    	query.append(" AND bp.chain_cd = cs.chain_cd");
    	query.append(" AND cs.actv_ind = 'Y'), ");
    	query.append("UNATTRIBUTE_RGN AS (SELECT bp.std_id");
    	query.append(" FROM selected_std bp, chain_std cs");
    	query.append(" WHERE bp.std_id = cs.std_id");
    	query.append(" AND bp.chain_cd = cs.chain_cd");
    	query.append(" AND cs.actv_ind = 'Y'");
    	query.append(" AND bp.bridge_publish_id not in (select bridge_publish_id from bridge_publish_ctry where ");
    	query.append(" bridge_publish_id = bp.bridge_publish_id)), ");
    	/*query.append(" MINUS");
    	query.append(" SELECT DISTINCT bp.std_id");
    	query.append(" FROM selected_std bp, ctry_std cs");
    	query.append(" WHERE bp.std_id = cs.std_id");
    	query.append(" AND cs.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = bp.rgn_id)), ");*/
    //	query.append(" GLOBAL_MUST as (SELECT std_id FROM bridge_gbl_publish where publish_id in (SELECT publish_id from CURR_PUBLISH)), ");
    	query.append("REMOVE_STAT AS (SELECT std_id FROM unattribute_brand");
    	query.append(" UNION");
    	query.append(" SELECT std_id FROM unattribute_rgn");
    	query.append(" UNION");
    	query.append(" SELECT std_id FROM selected_std");
    	query.append(" WHERE isGlobal = 'N') ");
    	//query.append(" UNION");
    	//query.append(" SELECT std_id FROM selected_std WHERE isGlobal = 'Y' and std_id not in (SELECT std_id FROM global_must))");
//    	query.append(", REMOVE_STAT_DESC AS (");
//    	query.append(" SELECT rs.std_id, 'Unattributed Brand' err_desc");
//    	query.append(" FROM remove_stat rs, unattribute_brand b");
//    	query.append(" WHERE rs.std_id = b.std_id");
//    	query.append(" UNION");
//    	query.append(" SELECT rs.std_id, 'Unattributed Region' err_desc");
//    	query.append(" FROM remove_stat rs, unattribute_rgn r");
//    	query.append(" WHERE rs.std_id = r.std_id");
//    	query.append(" UNION");
//    	query.append(" SELECT std_id, NULL err_desc"); 
//    	query.append(" FROM remove_stat");
//    	query.append(" WHERE std_id NOT IN (SELECT std_id FROM unattribute_brand UNION SELECT std_id FROM unattribute_rgn)) ");
    	query.append(" (SELECT tax.indx_order, tax.taxonomy_id, tax.prnt_taxonomy_id, tax.lvl, tax.hier_lvl_nbr, tax.path AS path,");
    	query.append(" tax.title_txt AS tax_title_txt, s.prnt_std_id, s.bridge_publish_id, s.std_id, s.std_typ, s.title, null std_desc,");
    	query.append(" s.unpublish_ind, xref.xref_lst_std_id, COALESCE(dsp.shows, 'NEW') pub_status,");
    	query.append(" COALESCE((SELECT do.disp_order_nbr FROM std_display_order do WHERE do.std_id = s.std_id AND do.chain_cd = '").append(chainCode).append("'");
    	query.append(" AND do.rgn_cd = '").append(regionCode).append("'), 0) disp_order_nbr,");
    	query.append(" sr.std_rgn_color, decode(rs.std_id, NULL, 'false', 'true') remove, s.rgn_cd, s.isglobal");
//        query.append(" sr.std_rgn_color, decode(rs.std_id, NULL, 'false', 'true') remove, s.rgn_cd, s.isglobal, rs.err_desc");
    	query.append(" FROM cms_tax tax, selected_std s, taxonomy_std ts, std_ref xref, displ_opt dsp, std_ctry_cnt sr, remove_stat rs");
    	query.append(" WHERE tax.taxonomy_Id = ts.taxonomy_id ");
    	query.append(" AND ts.std_id = s.prnt_std_id");
        query.append(" AND s.std_id = xref.referring_std_id(+)");
        query.append(" AND s.std_id = dsp.std_id(+)");
        query.append(" AND s.std_id = rs.std_id(+)");
        query.append(" AND s.std_id = sr.std_id)");
    	return query.toString();
    }
    
    
    public static String getMyPublicationImportQuery(String chainCode, String regionId, String regionCode)
    {
    	StringBuffer query = new StringBuffer();
    	query.append("WITH "); 
    	query.append(" CMS_TAX as (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH "); 
    	query.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, "); 
    	query.append(" SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT,  ' &#8594; '), 31) AS PATH  ");
    	query.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ORDER BY LVL, T.HIER_LVL_NBR) TAX), ");
    	
    	query.append(" CURR_PUBLISH AS (SELECT PUBLISH_ID FROM PUBLISH WHERE publish_environment_nm = 'BRIDGE' AND publish_stat_cd = 'ACTIVE' AND CHAIN_CD = '"+chainCode+"'), ");
    	
    	query.append(" CURR_BRIDGE_PUBLISH AS ( SELECT BRIDGE_PUBLICATION_IMPORT_ID , STD_ID, VLD_STAT_CD FROM BRIDGE_PUBLISH_IMPORT BP, CURR_PUBLISH CP WHERE BP.RGN_ID = "+regionId);
    	query.append(" AND BP.PUBLISH_ID = CP.PUBLISH_ID), "); 
    	
    	query.append(" SELECTED_STD AS (SELECT DISTINCT s.STD_ID, s.STD_TYP, s.PRNT_STD_ID, s.TITLE_TXT, s.STD_DESC, cs.BRIDGE_PUBLICATION_IMPORT_ID, cs.VLD_STAT_CD "); 
    	query.append(" FROM STD s, CURR_BRIDGE_PUBLISH cs WHERE s.STD_ID = cs.std_id AND s.stat_desc != 'DELETED'),");
				
    	query.append(" DISP_ORDER AS (SELECT COALESCE(disp.disp_order_nbr,0) AS disp_order_nbr, disp.std_id from std_display_order disp, SELECTED_STD SS where disp.std_id = ss.std_id"); 
    	query.append(" and disp.chain_cd = '"+chainCode+"' and  disp.rgn_cd = '"+regionCode+"') ");
    	
    	query.append(" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH AS PATH, TAX.TITLE_TXT AS TAX_TITLE_TXT,  " );
    	query.append(" ss.PRNT_STD_ID AS PRNT_STD_ID, ss.BRIDGE_PUBLICATION_IMPORT_ID, ss.STD_ID AS STD_ID, ss.STD_TYP AS STD_TYP, ss.TITLE_TXT AS TITLE, " ); 
    	query.append(" ss.STD_DESC, ss.VLD_STAT_CD, disp.disp_order_nbr ");
    	query.append(" FROM CMS_TAX tax, SELECTED_STD ss, TAXONOMY_STD TS, DISP_ORDER disp ");
    	query.append(" WHERE tax.taxonomy_Id = ts.taxonomy_id and ts.std_id = ss.prnt_std_id and ss.std_id = disp.std_id(+)");
    	
    	return query.toString();
    }
    
    public static String getMyPublicationImportFindMissingQuery(String chainCode, String regionId, String regionCode)
    {
    	StringBuffer query = new StringBuffer();
    	query.append("WITH " );
		query.append("CMS_TAX AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH " );
		query.append("FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, " );  
		query.append("SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT,  ' &#8594; '), 31) AS PATH " );
		query.append("FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ORDER BY LVL, T.HIER_LVL_NBR) TAX), " );
		
		query.append("CURR_PUBLISH AS (SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' AND PUBLISH_STAT_CD = 'ACTIVE' AND CHAIN_CD ='"+chainCode+"'), " );
		
		query.append("CURR_BRIDGE_PUBLISH AS ( SELECT BRIDGE_PUBLICATION_IMPORT_ID , STD_ID, NVL(VLD_STAT_CD,' ') AS VLD_STAT_CD FROM BRIDGE_PUBLISH_IMPORT BP, CURR_PUBLISH CP " );
		query.append("WHERE BP.RGN_ID = "+regionId+" AND BP.PUBLISH_ID = CP.PUBLISH_ID), ");
		
		query.append("PRNT_STD AS (SELECT DISTINCT S.PRNT_STD_ID FROM STD S, CURR_BRIDGE_PUBLISH CS WHERE S.STD_ID = CS.STD_ID  AND S.STAT_DESC != 'DELETED'), " );
		
		query.append("SELECTED_STD AS (SELECT DISTINCT S.STD_ID, S.STD_TYP, S.PRNT_STD_ID, S.TITLE_TXT, S.STD_DESC, " );
	  	  //for make Missing status
	  	query.append("NVL((SELECT CS.BRIDGE_PUBLICATION_IMPORT_ID FROM CURR_BRIDGE_PUBLISH CS  WHERE CS.STD_ID = S.STD_ID), -1) AS BRIDGE_PUBLICATION_IMPORT_ID, " ); 
		query.append("NVL((SELECT CS.VLD_STAT_CD FROM CURR_BRIDGE_PUBLISH CS  WHERE CS.STD_ID = S.STD_ID ), 'MISSING') AS VLD_STAT_CD FROM STD S WHERE " );
		query.append("S.STD_ID  IN (SELECT STD_ID AS STD_ID FROM CURR_BRIDGE_PUBLISH  UNION SELECT PRNT_STD_ID AS STD_ID FROM PRNT_STD)) , " );
		
		query.append("DISP_ORDER AS (SELECT COALESCE(DISP.DISP_ORDER_NBR,0) AS DISP_ORDER_NBR, DISP.STD_ID FROM STD_DISPLAY_ORDER DISP, SELECTED_STD SS WHERE DISP.STD_ID = SS.STD_ID ");
		query.append("AND DISP.CHAIN_CD = '"+chainCode+"' AND  DISP.RGN_CD = '"+regionCode+"') " );
		
		query.append("SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH AS PATH, TAX.TITLE_TXT AS TAX_TITLE_TXT, " );
		query.append("SS.PRNT_STD_ID AS PRNT_STD_ID, SS.BRIDGE_PUBLICATION_IMPORT_ID, SS.STD_ID AS STD_ID, SS.STD_TYP AS STD_TYP, SS.TITLE_TXT AS TITLE,  SS.STD_DESC, ");
		  	//for make orphen status
		query.append("CASE WHEN ((SELECT SS.VLD_STAT_CD FROM SELECTED_STD SS1 WHERE SS1.STD_ID = SS.PRNT_STD_ID AND SS1.VLD_STAT_CD ='MISSING') =  ' ') THEN 'ORPHAN' ");
		query.append("ELSE SS.VLD_STAT_CD END AS VLD_STAT_CD , DISP.DISP_ORDER_NBR  " );
		query.append("FROM CMS_TAX TAX, SELECTED_STD SS, TAXONOMY_STD TS, DISP_ORDER DISP  ");
		query.append("WHERE TAX.TAXONOMY_ID = TS.TAXONOMY_ID AND TS.STD_ID = SS.PRNT_STD_ID AND SS.STD_ID = DISP.STD_ID(+)");
    	
    	return query.toString();
    }

    public static String getStandardCountForPublication (long publishId) {
    	StringBuffer query = new StringBuffer();
    	query.append("select count(*) from bridge_publish where unpublish_ind = 'N' and publish_id = ");
    	query.append(publishId);
    	return query.toString();
    }
    
    public static String updateBridgePublishAndCountryFromImport(long bridgePublishId, long prodPublishId, String brandCode, long regionId, String screenName)
    {
    	StringBuilder query = new StringBuilder();
    	query.append("  DECLARE");
    	query.append("  TYPE br_pub_rec IS RECORD (pub_std_id NUMBER, std_id NUMBER, isglobal NUMBER);");
    	query.append("  TYPE br_pub_rec_type IS TABLE OF br_pub_rec;");
    	query.append("  l_br_pub_rec_tbl br_pub_rec_type;");
    	query.append("  TYPE pub_ctry_rec IS RECORD (std_id NUMBER, ctry_mn VARCHAR2(3), stat_cd VARCHAR2(20), mnl_typ VARCHAR2(25));");
    	query.append("  TYPE pub_ctry_rec_type IS TABLE OF pub_ctry_rec;");
    	query.append("  l_pub_ctry_rec_tbl pub_ctry_rec_type;");
    	query.append("  l_chain_cd VARCHAR2(5) := '").append(brandCode).append("';");  
    	query.append("  l_bridge_draft_id NUMBER := ").append(bridgePublishId).append(";");  
    	query.append("  l_rgn_id NUMBER := ").append(regionId).append(";");  
    	query.append("  l_user_id VARCHAR2(50) := '").append(screenName).append("';");
    	query.append("  l_selection_ind VARCHAR2(1) := 'Y';");
    	query.append("  l_bridge_publish_id NUMBER;");
    	query.append("  l_prod_publish_id NUMBER;");
    	query.append("  l_std_id NUMBER;");  
    	query.append("  l_ctry_mn VARCHAR2(3);");  
    	query.append("  l_stat_cd VARCHAR2(20);"); 
    	query.append("  l_ctry_cur SYS_REFCURSOR;");  
    	query.append("  l_unpublish_ind VARCHAR2(1);");  
    	query.append("  l_cnt NUMBER;");  
    	query.append("  l_isglobal NUMBER;");  
    	query.append("  l_select_sql VARCHAR2(1700);");  
    	query.append("  l_std_mnl_type VARCHAR2(25);");  
    	query.append("  CURSOR l_cur IS"); 
    	query.append("  SELECT BP.BRIDGE_PUBLICATION_IMPORT_ID, BP.STD_ID, (SELECT COUNT(*) FROM bridge_gbl_publish WHERE PUBLISH_ID = BP.PUBLISH_ID AND must_publish_ind = 'Y' AND STD_ID = bp.STD_ID ) isGlobal"); 
    	query.append("  FROM BRIDGE_PUBLISH_IMPORT BP WHERE BP.PUBLISH_ID = l_bridge_draft_id AND BP.SELECTION_ID = l_selection_ind AND BP.RGN_ID = l_rgn_id;");
    	query.append("  l_sel_rec_new_ctry VARCHAR2(1400) := ");
    	query.append("  'SELECT ss.std_id, ss.ctry_nm_cd, ' ||");
    	query.append("  'CASE WHEN ss.std_typ = ''GDLN'' THEN CASE WHEN ss.std_desc = pss.std_desc THEN ''NO_CHANGE'' ' ||");
    	query.append("  '  WHEN ss.std_desc != pss.std_desc THEN ''UPDATE'' ' ||");
    	query.append("  '  ELSE ''NEW'' END ' ||");
    	query.append("  'ELSE CASE WHEN ss.title_txt = pss.title_txt THEN ''NO_CHANGE'' ' ||");
    	query.append("  ' WHEN ss.title_txt != pss.title_txt THEN ''UPDATE'' ' ||");
    	query.append("  ' ELSE ''NEW'' END ' ||");
    	query.append("  'END stat_cd, ss.mnl_typ ' ||");
    	query.append("  'FROM (SELECT s.std_id, s.std_typ, trim(s.title_txt) title_txt, trim(s.std_desc) std_desc, cs.ctry_nm_cd, ' ||");
    	query.append("  '(SELECT NVL((SELECT listagg(f.flag_catgy_id, '','') WITHIN GROUP(ORDER BY f.flag_catgy_id) FROM flag_std f ' ||");
    	query.append("  'WHERE f.std_id = s1.std_id AND f.flag_catgy_id IN (257, 258) GROUP BY f.std_id), ''0'') FROM STD s1 WHERE s1.std_id = s.std_id) AS mnl_typ ' ||");
    	query.append("  ' FROM std s, ctry_std cs, brndstnd_ctry ct ' ||");
    	query.append("  ' WHERE s.std_id = :std_id ' ||");
    	query.append("  ' AND s.std_id = cs.std_id ' ||");
    	query.append("  ' AND :brPubId IS NOT NULL ' ||");
    	query.append("  ' AND ct.ctry_nm_cd = cs.ctry_nm_cd ' ||");
    	query.append("  ' AND ct.rgn_id = :rgn_id) ss, ' ||");
    	query.append("  '(SELECT ps.std_id, pcs.ctry_nm_cd, trim(ps.title_txt) title_txt, trim(ps.std_desc) std_desc ' ||");
    	query.append("  ' FROM publish_std ps, publish_ctry_std pcs ' ||");
    	query.append("  ' WHERE ps.publish_id = :pub_id ' ||");
    	query.append("  ' AND ps.std_id = :std_id ' ||");
    	query.append("  ' AND ps.publish_std_ver_id = pcs.publish_std_ver_id) pss ' ||");
    	query.append("  'WHERE ss.std_id = pss.std_id(+) ' ||");
    	query.append("  'AND ss.ctry_nm_cd = pss.ctry_nm_cd(+)';");
    	query.append("  l_ins_ctry VARCHAR2(400) := ");    
    	query.append("  'INSERT INTO bridge_publish_ctry(bridge_publish_ctry_id, bridge_publish_id, ctry_nm_cd, ' ||");    
    	query.append("  'bridge_publish_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");     
    	query.append("  'VALUES (:ctry_id_seq, :brg_pub_id, :ctry_nm, :stat_cd, :cr_usr_id, :cr_ts, :upd_usr_id, :upd_ts) ';");  
    	query.append("  l_ins_miss_ctry VARCHAR2(500) :="); 
    	query.append("  'INSERT INTO bridge_publish_ctry(bridge_publish_ctry_id, bridge_publish_id, ctry_nm_cd, bridge_publish_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||"); 
    	query.append("  'SELECT :ctry_id_seq, :brg_pub_id, :ctry_nm, :stat_cd, :cr_usr_id, :cr_ts, :upd_usr_id, :upd_ts FROM DUAL ' ||"); 
    	query.append("  'WHERE NOT EXISTS (SELECT BRIDGE_PUBLISH_CTRY_ID FROM bridge_publish_ctry WHERE bridge_publish_id=:brg_pub_id AND ctry_nm_cd=:ctry_nm)';");  
    	query.append("  l_brg_rec_exist VARCHAR2(150) := 'SELECT count(*) FROM bridge_publish WHERE publish_id = :pub_id AND std_id = :std_id and rgn_id = :rgn_id';");   
    	query.append("  l_ins_brg_sql VARCHAR2(300) := ");   
    	query.append("  'INSERT INTO bridge_publish(bridge_publish_id, publish_id, std_id, rgn_id, unpublish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");   
    	query.append("  'VALUES (:bridgePubId, :pubId, :stdId, :rgnId, :unpubInd, :crUsrId, :crTs, :lstUpdtUsrId, :lstUpdtTs) ';");  
    	query.append("  l_updt_brg_pub VARCHAR2(500) := 'UPDATE bridge_publish SET UNPUBLISH_IND = ''N'' where publish_id = :pub_id AND std_id = :std_id and rgn_id = :rgn_id';");  
    	query.append("  l_gbl_ctry VARCHAR2(1700) := ");
    	query.append("  'SELECT ss.std_id, ss.ctry_nm_cd, ' ||");
    	query.append("  'CASE WHEN ss.std_typ = ''GDLN'' THEN CASE WHEN ss.std_desc = pss.std_desc THEN ''NO_CHANGE'' ' ||");
    	query.append("  '  WHEN ss.std_desc != pss.std_desc THEN ''UPDATE'' ' ||");
    	query.append("  '  ELSE ''NEW'' END ' ||");
    	query.append("  'ELSE CASE WHEN ss.title_txt = pss.title_txt THEN ''NO_CHANGE'' ' ||");
    	query.append("  ' WHEN ss.title_txt != pss.title_txt THEN ''UPDATE'' ' ||");
    	query.append("  ' ELSE ''NEW'' END ' ||");
    	query.append("  'END stat_cd, ss.mnl_typ ' ||");
    	query.append("  'FROM (SELECT s.std_id, s.std_typ, trim(s.title_txt) title_txt, trim(s.std_desc) std_desc, cs.ctry_nm_cd, ' ||");
    	query.append("  '(SELECT NVL((SELECT listagg(f.flag_catgy_id, '','') WITHIN GROUP(ORDER BY f.flag_catgy_id) FROM flag_std f ' ||");
    	query.append("  'WHERE f.std_id = s1.std_id AND f.flag_catgy_id IN (257, 258) GROUP BY f.std_id), ''0'') FROM STD s1 WHERE s1.std_id = s.std_id) AS mnl_typ ' ||");
    	query.append("  ' FROM std s, ctry_std cs, brndstnd_ctry ct, bridge_gbl_publish bp, bridge_gbl_publish_ctry bpc ' ||");
    	query.append("  ' WHERE s.std_id = :std_id ' ||");
    	query.append("  ' AND s.std_id = cs.std_id ' ||");
    	query.append("  'AND bp.bridge_gbl_publish_id = bpc.bridge_gbl_publish_id ' ||");
    	query.append("  'AND bp.must_publish_ind = ''Y'' ' ||");
    	query.append("  'AND bp.std_id = s.std_id ' ||");
    	query.append("  'AND bp.publish_id = :brPubId ' ||");
    	query.append("  'AND bpc.publish_ind = ''Y'' ' ||");
    	query.append("  'AND bpc.ctry_nm_cd = cs.ctry_nm_cd ' ||");
    	query.append("  ' AND ct.ctry_nm_cd = cs.ctry_nm_cd ' ||");
    	query.append("  ' AND ct.rgn_id = :rgn_id) ss, ' ||");
    	query.append("  '(SELECT ps.std_id, pcs.ctry_nm_cd, trim(ps.title_txt) title_txt, trim(ps.std_desc) std_desc ' ||");
    	query.append("  ' FROM publish_std ps, publish_ctry_std pcs ' ||");
    	query.append("  ' WHERE ps.publish_id = :pub_id ' ||");
    	query.append("  ' AND ps.std_id = :std_id ' ||");
    	query.append("  ' AND ps.publish_std_ver_id = pcs.publish_std_ver_id) pss ' ||");
    	query.append("  'WHERE ss.std_id = pss.std_id(+) ' ||");
    	query.append("  'AND ss.ctry_nm_cd = pss.ctry_nm_cd(+)';");
    	query.append("  l_build_pub_cnt NUMBER;");
    	query.append("  l_operate_pub_cnt NUMBER;");
    	query.append("  l_prod_pub_cnt NUMBER;");
    	query.append("  l_cur_br_pub_type VARCHAR2(20);");
    	query.append("  BEGIN "); 
    	query.append("  SELECT count(*) INTO l_build_pub_cnt");
    	query.append("  FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND publish_content_typ LIKE '%BUILD_OPERATE' AND CHAIN_CD = l_chain_cd; ");   

    	query.append("  SELECT count(*) INTO l_operate_pub_cnt");
    	query.append("  FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND publish_content_typ = 'OPERATE' AND CHAIN_CD = l_chain_cd;");   

    	query.append("  SELECT count(*) INTO l_prod_pub_cnt");
    	query.append("  FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND CHAIN_CD = l_chain_cd;"); 

    	query.append("  BEGIN");
    	query.append("   SELECT publish_id INTO l_prod_publish_id");
    	query.append("   FROM publish WHERE publish_environment_nm = 'PRODUCTION' AND publish_stat_cd = 'ACTIVE' AND chain_cd = l_chain_cd;");
        query.append("  EXCEPTION WHEN no_data_found THEN l_prod_publish_id := 0;");
        query.append("  END;");
        
    	query.append("  SELECT PUBLISH_CONTENT_TYP INTO l_cur_br_pub_type FROM PUBLISH WHERE publish_id = l_bridge_draft_id;");
        
    	query.append("  OPEN l_cur;");  
    	query.append("  LOOP");   
    	query.append("  FETCH l_cur BULK COLLECT INTO l_br_pub_rec_tbl LIMIT 1000;");    
    	query.append("      IF l_br_pub_rec_tbl.COUNT > 0 THEN  ");   
    	query.append("          FOR indx IN l_br_pub_rec_tbl.FIRST.. l_br_pub_rec_tbl.LAST");
    	query.append("          LOOP ");
    	query.append("              l_isglobal := l_br_pub_rec_tbl(indx).isglobal; ");     
    	query.append("              l_std_id := l_br_pub_rec_tbl(indx).std_id; ");    
    	query.append("              IF l_isglobal > 0 THEN ");
    	query.append("                  l_select_sql := l_gbl_ctry; "); 
    	query.append("              ELSE ");      	
    	query.append("                  l_select_sql := l_sel_rec_new_ctry; ");   
    	query.append("              END IF;");  

    	query.append("              EXECUTE IMMEDIATE l_brg_rec_exist INTO l_cnt USING l_bridge_draft_id, l_std_id, l_rgn_id;");    
                    //-- new record
    	query.append("              IF l_cnt = 0 THEN");        
    	query.append("                  SELECT bridge_publish_id_seq.nextval INTO l_bridge_publish_id FROM dual;");        
    	query.append("                  EXECUTE IMMEDIATE l_ins_brg_sql USING l_bridge_publish_id, l_bridge_draft_id, l_std_id, l_rgn_id, 'N', l_user_id, SYSDATE, l_user_id, SYSDATE;");        
                        
    	query.append("                  OPEN l_ctry_cur FOR l_select_sql USING l_std_id, l_bridge_draft_id, l_rgn_id, l_prod_publish_id, l_std_id;");
    	query.append("                  LOOP");            
    	query.append("                  FETCH l_ctry_cur BULK COLLECT INTO l_pub_ctry_rec_tbl LIMIT 60;");            
    	query.append("                      FOR indx IN l_pub_ctry_rec_tbl.FIRST.. l_pub_ctry_rec_tbl.LAST");            
    	query.append("                      LOOP");              
    	query.append("                          l_std_id := l_pub_ctry_rec_tbl(indx).std_id;");
    	query.append("                          l_ctry_mn := l_pub_ctry_rec_tbl(indx).ctry_mn;");
    	query.append("                          l_stat_cd := l_pub_ctry_rec_tbl(indx).stat_cd;");
    	query.append("                          l_std_mnl_type := l_pub_ctry_rec_tbl(indx).mnl_typ;");
                                //-- atleast one prod publication exists
    	query.append("                          IF l_prod_pub_cnt > 0 THEN");
    	query.append("                              IF l_cur_br_pub_type = 'FULL_BUILD_OPERATE' THEN"); 
    	query.append("                                  IF l_build_pub_cnt = 0 THEN");
                                            //-- calculate based on std manual type
                                            //-- manual type Build only
    	query.append("                                      IF l_std_mnl_type = '257' THEN");
    	query.append("                                            l_stat_cd := 'SELECT';");
    	query.append("                                      END IF;");
    	query.append("                                  END IF;");
    	query.append("                              END IF;");
    	query.append("                          ELSE");
    	query.append("                              l_stat_cd := 'SELECT';"); 
    	query.append("                          END IF;");

    	query.append("                          EXECUTE IMMEDIATE l_ins_ctry");              
    	query.append("                          USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, l_stat_cd, l_user_id, SYSDATE, l_user_id, SYSDATE;");            
    	query.append("                      END LOOP;");            
    	query.append("                      EXIT WHEN l_ctry_cur%NOTFOUND;");        
    	query.append("                  END LOOP;");        
    	query.append("                  IF l_ctry_cur IS NOT NULL THEN");          
    	query.append("                     CLOSE l_ctry_cur;");        
    	query.append("                  END IF;");  
                    //-- existing record
    	query.append("              ELSE");       
    	query.append("                  SELECT bridge_publish_id, unpublish_ind INTO l_bridge_publish_id, l_unpublish_ind FROM bridge_publish WHERE publish_id = l_bridge_draft_id AND std_id = l_std_id AND rgn_id = l_rgn_id;");      
    	query.append("                  IF l_unpublish_ind = 'Y' THEN");         
    	query.append("                      EXECUTE IMMEDIATE l_updt_brg_pub USING l_bridge_draft_id, l_std_id, l_rgn_id;");    
                                                    
    	query.append("                      OPEN l_ctry_cur FOR l_select_sql USING l_std_id, l_bridge_draft_id, l_rgn_id, l_prod_publish_id, l_std_id;");
    	query.append("                      LOOP ");          
    	query.append("                      FETCH l_ctry_cur BULK COLLECT INTO l_pub_ctry_rec_tbl LIMIT 60; ");    
    	query.append("                          FOR indx IN l_pub_ctry_rec_tbl.FIRST.. l_pub_ctry_rec_tbl.LAST "); 
    	query.append("                          LOOP ");   
    	query.append("                              l_std_id := l_pub_ctry_rec_tbl(indx).std_id;");
    	query.append("                              l_ctry_mn := l_pub_ctry_rec_tbl(indx).ctry_mn;");
    	query.append("                              l_stat_cd := l_pub_ctry_rec_tbl(indx).stat_cd;");
    	query.append("                              l_std_mnl_type := l_pub_ctry_rec_tbl(indx).mnl_typ;");
                                
                                    //-- atleast one prod publication exists
    	query.append("                              IF l_prod_pub_cnt > 0 THEN");
    	query.append("                                  IF l_cur_br_pub_type = 'FULL_BUILD_OPERATE' THEN"); 
    	query.append("                                      IF l_build_pub_cnt = 0 THEN");
                                                //-- calculate based on std manual type
                                                //-- manual type Build only
    	query.append("                                          IF l_std_mnl_type = '257' THEN");
    	query.append("                                                l_stat_cd := 'SELECT';");
    	query.append("                                          END IF;");
    	query.append("                                      END IF;");
    	query.append("                                  END IF;");
    	query.append("                              ELSE");
    	query.append("                                  l_stat_cd := 'SELECT';"); 
    	query.append("                              END IF;");

    	query.append("                              EXECUTE IMMEDIATE l_ins_miss_ctry USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, l_stat_cd, l_user_id, SYSDATE, l_user_id, SYSDATE, l_bridge_publish_id, l_ctry_mn;");  
    	query.append("                          END LOOP;"); 
    	query.append("                          EXIT WHEN l_ctry_cur%NOTFOUND;");  
    	query.append("                      END LOOP;");     
    	query.append("                  END IF;");   
    	query.append("              END IF;");    
    	query.append("          END LOOP;");   
    	query.append("      END IF;");    
    	query.append("  EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("  END LOOP;");  
        
    	query.append("  COMMIT;");
    	query.append("  END;");

    	return query.toString();

    }
    
    public static String addStdToBridgeForAddById(long bridgePublishId, long prodPublishId, String brandCode, long regionId, List<Long> stdIds, String screenName)
    {
        StringBuilder query = new StringBuilder();
        query.append("DECLARE");
        query.append("  l_chain_cd VARCHAR2(5) := '").append(brandCode).append("'; ");
        query.append("  l_bridge_draft_id NUMBER := ").append(bridgePublishId).append("; ");
        query.append("  l_rgn_id NUMBER := ").append(regionId).append("; ");
        query.append("  l_user_id VARCHAR2(50) := '").append(screenName).append("'; ");
        query.append("  l_publish_id NUMBER := ").append(prodPublishId).append("; ");
        query.append("  l_bridge_publish_id NUMBER; ");
        query.append("  l_std_id NUMBER; ");
        query.append("  l_ctry_mn VARCHAR2(3); ");
        query.append("  l_stat_cd VARCHAR2(20); "); 
        query.append("  l_pub_stat_cd VARCHAR2(20); "); 
        query.append("  l_ctry_cur SYS_REFCURSOR; ");
        query.append("  CURSOR l_std_id_cur IS ");
        query.append("    SELECT std_id FROM std WHERE std_id IN (");
        boolean addComma = false;
        for (long stdId : stdIds)
        {
            if (addComma)
            {
                query.append(",");
            }
            query.append(stdId);
            addComma = true;
        }
        query.append("); ");        
        query.append("  l_sel_rec_ctry VARCHAR2(1000) :=  ");
        query.append("    'SELECT cs.std_id, cs.ctry_nm_cd, ' || ");
        query.append("    'nvl(( SELECT pcs.PUBLISH_STAT_CD ' || ");
        query.append("    'FROM publish_std s, publish_ctry_std pcs ' || ");
        query.append("    'WHERE s.publish_id = :pub_id ' || ");
        query.append("    'AND s.PUBLISH_STD_VER_ID = pcs.PUBLISH_STD_VER_ID ' || ");
        query.append("    'AND s.std_id = cs.std_id ' || ");
        query.append("    'AND pcs.CTRY_NM_CD = CS.CTRY_NM_CD), ''SELECT'' ) curr_pub_stat ' || ");
        query.append("    'FROM ctry_std cs, brndstnd_ctry bc ' || ");
        query.append("    'WHERE cs.ctry_nm_cd = bc.ctry_nm_cd  ' || ");
        query.append("    'AND cs.std_id = :std_id ' || ");
        query.append("    'AND bc.rgn_id = :rgn_id '; ");
        query.append("  l_ins_brg_sql VARCHAR2(500) := ");
        query.append("    'INSERT INTO bridge_publish(bridge_publish_id, publish_id, std_id, rgn_id, unpublish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        query.append("    'SELECT :bridgePubId, :pubId, :stdId, :rgnId, :unpubInd, :crUsrId, :crTs, :lstUpdtUsrId, :lstUpdtTs from dual '|| ");
        query.append("    'WHERE NOT EXISTS ( SELECT std_id, rgn_id, publish_id from bridge_publish where std_id = :stdId and publish_id = :pub_id and rgn_id = :rgn_id) ';");
        query.append("  l_updt_brg_pub VARCHAR2(500) := 'UPDATE bridge_publish SET UNPUBLISH_IND = ''N'' where publish_id = :pub_id AND std_id = :std_id and rgn_id = :rgn_id';");
        query.append("  l_ins_ctry VARCHAR2(500) := ");
        query.append("    'INSERT INTO bridge_publish_ctry(bridge_publish_ctry_id, bridge_publish_id, ctry_nm_cd, ' ||  ");
        query.append("    'bridge_publish_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||  ");
        query.append("    'SELECT :ctry_id_seq, :brg_pub_id, :ctry_nm, :stat_cd, :cr_usr_id, :cr_ts, :upd_usr_id, :upd_ts from dual '|| "); 
        query.append("    'WHERE NOT EXISTS(SELECT BRIDGE_PUBLISH_ID,ctry_nm_cd FROM BRIDGE_PUBLISH_CTRY WHERE BRIDGE_PUBLISH_ID = :pub_id AND CTRY_NM_CD = :ctry_nm)';  ");
        query.append("BEGIN");
        query.append("  FOR rec IN l_std_id_cur LOOP ");
        query.append("    l_std_id := rec.std_id; ");
        query.append("    SELECT bridge_publish_id_seq.nextval ");
        query.append("    INTO l_bridge_publish_id FROM dual; ");
        query.append("    BEGIN ");
        query.append("      SELECT nvl(bridge_publish_id, 0) ");
        query.append("      INTO l_bridge_publish_id ");
        query.append("      FROM bridge_publish ");
        query.append("      WHERE publish_id = l_bridge_draft_id ");
        query.append("      AND std_id = l_std_id ");
        query.append("      AND rgn_id = l_rgn_id; ");
        query.append("    EXCEPTION WHEN no_data_found THEN ");
        query.append("      l_bridge_publish_id := 0; ");
        query.append("    END; ");
        query.append("    IF l_bridge_publish_id = 0 THEN ");
        query.append("      SELECT bridge_publish_id_seq.nextval ");
        query.append("      INTO l_bridge_publish_id FROM dual; ");
        query.append("      EXECUTE IMMEDIATE l_ins_brg_sql ");
        query.append("      USING l_bridge_publish_id, l_bridge_draft_id, l_std_id, l_rgn_id, 'N', l_user_id, SYSDATE, l_user_id, ");
        query.append("      SYSDATE, l_std_id, l_bridge_draft_id, l_rgn_id; ");
        query.append("    ELSE");
        query.append("        EXECUTE IMMEDIATE l_updt_brg_pub USING l_bridge_draft_id, l_std_id, l_rgn_id;   ");
        query.append("    END IF;");
        query.append("    OPEN l_ctry_cur FOR l_sel_rec_ctry ");
        query.append("    USING l_publish_id, l_std_id, l_rgn_id; ");
        query.append("    LOOP ");
        query.append("      FETCH l_ctry_cur INTO l_std_id, l_ctry_mn, l_stat_cd; ");
        query.append("      EXIT WHEN l_ctry_cur%NOTFOUND; ");
        query.append("      SELECT nvl((SELECT pcs.PUBLISH_STAT_CD FROM publish_std s, publish_ctry_std pcs ");
        query.append("      WHERE s.publish_id = l_publish_id ");
        query.append("      AND s.PUBLISH_STD_VER_ID = pcs.PUBLISH_STD_VER_ID AND s.std_id = l_std_id ");
        query.append("      AND pcs.CTRY_NM_CD = l_ctry_mn), 'NOT_EXIST' ) curr_pub_stat ");
        query.append("      INTO l_pub_stat_cd FROM dual; ");
        query.append("      IF l_pub_stat_cd != 'NOT_EXIST' THEN ");
        query.append("        SELECT CASE WHEN ps.std_typ='GDLN' THEN");
        query.append("        	CASE WHEN TRIM(s.std_desc) = TRIM(ps.std_desc) THEN 'NO_CHANGE' ELSE 'UPDATE' END ELSE");
        query.append("        	CASE WHEN trim(s.title_txt) = trim(ps.title_txt) THEN 'NO_CHANGE' ELSE 'UPDATE' END END");
        query.append("        INTO l_stat_cd ");
        query.append("        FROM std s, publish_std ps ");
        query.append("        WHERE ps.publish_id = l_publish_id ");
        query.append("        AND s.std_id = ps.std_id ");
        query.append("        AND s.std_id = l_std_id; ");
        query.append("      END IF; ");
        query.append("      EXECUTE IMMEDIATE l_ins_ctry ");
        query.append("      USING bridge_publish_ctry_id_seq.nextval, l_bridge_publish_id, l_ctry_mn, l_stat_cd, l_user_id, SYSDATE, ");
        query.append("      l_user_id, SYSDATE, l_bridge_publish_id, l_ctry_mn;");
        query.append("    END LOOP;");
        query.append("    IF l_ctry_cur IS NOT NULL THEN ");
        query.append("      CLOSE l_ctry_cur; ");
        query.append("    END IF; ");
        query.append("  END LOOP; ");
        query.append("  COMMIT;");
        query.append("END;");

        LOG.info("addStdToBridgeForAddById: Query = " + query.toString());
        return query.toString();
    }
    
    public static String getMyPublicationFindByIdQuery(String chainCode, String regionCode, long stdId, long regionId)
    {
    	String query = "select * From(WITH "+ 
				" CMS_TAX as (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH "+ 
				" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, "+ 
				" SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT,  ' &#8594; '), 31) AS PATH  "+
				" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ORDER BY LVL, T.HIER_LVL_NBR) TAX), "+ 
				" CURR_PUBLISH AS (SELECT PUBLISH_ID FROM PUBLISH WHERE publish_environment_nm = 'BRIDGE' AND publish_stat_cd = 'ACTIVE' AND CHAIN_CD = '"+chainCode+"'), "+
				" CURR_BRIDGE_PUBLISH AS ( SELECT BRIDGE_PUBLISH_ID,STD_ID, RGN_ID, UNPUBLISH_IND FROM BRIDGE_PUBLISH BP, CURR_PUBLISH CP WHERE BP.RGN_ID = "+regionId+
				" AND BP.PUBLISH_ID = CP.PUBLISH_ID ), "+ 
				" SELECTED_STD AS (SELECT  STD_ID, STD_TYP, PRNT_STD_ID, TITLE_TXT, STD_DESC FROM STD WHERE STD_ID IN (SELECT STD_ID FROM CURR_BRIDGE_PUBLISH)), "+
				" DISP_ORDER AS (SELECT COALESCE(DISP.DISP_ORDER_NBR,0) AS DISP_ORDER_NBR, DISP.STD_ID FROM STD_DISPLAY_ORDER DISP, SELECTED_STD SS WHERE DISP.STD_ID = SS.STD_ID " +
  			  	" AND DISP.CHAIN_CD = '"+chainCode+"' AND  DISP.RGN_CD = '"+regionCode+"') " +  
				" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH AS PATH, TAX.TITLE_TXT AS TAX_TITLE_TXT,  " +
				" ss.PRNT_STD_ID AS PRNT_STD_ID, BP.BRIDGE_PUBLISH_ID, ss.STD_ID AS STD_ID, ss.STD_TYP AS STD_TYP, ss.TITLE_TXT AS TITLE, ss.STD_DESC, BP.UNPUBLISH_IND, DISP.DISP_ORDER_NBR  "+
				" FROM CMS_TAX tax, SELECTED_STD ss, TAXONOMY_STD TS, CURR_BRIDGE_PUBLISH BP, DISP_ORDER DISP "+
				" WHERE tax.taxonomy_Id = ts.taxonomy_id and ts.std_id = ss.prnt_std_id and SS.STD_ID = BP.STD_ID  AND SS.STD_ID = DISP.STD_ID(+) and ss.PRNT_STD_ID = "+stdId+" " +
				" UNION "+
				" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PATH AS PATH, TAX.TITLE_TXT AS TAX_TITLE_TXT,  "+
				" s.PRNT_STD_ID AS PRNT_STD_ID, 0 AS BRIDGE_PUBLISH_ID, s.STD_ID AS STD_ID, s.STD_TYP AS STD_TYP, s.TITLE_TXT AS TITLE, s.STD_DESC, 'Y' AS UNPUBLISH_IND, DISP.DISP_ORDER_NBR "+  
				" FROM CMS_TAX tax, STD s, TAXONOMY_STD TS,  DISP_ORDER DISP, CHAIN_STD bs, CTRY_STD cs, BRNDSTND_CTRY bc, stat st "+
				" WHERE tax.taxonomy_Id = ts.taxonomy_id and ts.std_id = s.prnt_std_id AND  "+
				" s.std_id = bs.std_id and s.std_id = cs.std_id and cs.ctry_nm_cd = bc.ctry_nm_cd "+ 
				" AND S.STD_ID = DISP.STD_ID(+) AND bs.stat_id = st.stat_id  and s.PRNT_STD_ID = "+stdId+" and bc.rgn_id = "+regionId+" and bs.chain_cd = '"+chainCode+"'" +
				" and bs.actv_ind = 'Y'  and st.stat_cd not in('D_FOR_REF','D_NOT_RQ','D_RPLCD','INST_RQ') AND s.std_id not in (select std_id from CURR_BRIDGE_PUBLISH))";    	
    	return query;
    }
    
    public static String getBridgePublishStandardIdsByParent(String chainCode, long stdId, long regionCode,long publishId)
    {
    	String query = "select distinct bp.std_id from bridge_publish bp, std s where s.std_id = bp.std_id and s.prnt_std_id = "+stdId+" and bp.rgn_id = "+regionCode+" and bp.unpublish_ind = 'N'" +
    			" and bp.publish_id = "+publishId;
    	return query;
    }
    
    public static String getBridgePublishStandardsByIds(String chainCode, long stdId, long regionCode,long publishId, String unPublishInd)
    {
    	String query = "select bp.std_id from bridge_publish bp where bp.std_id = "+stdId+" and bp.rgn_id = "+regionCode+" and bp.unpublish_ind = '"+unPublishInd+"' and bp.publish_id = "+publishId;
    	return query;
    }
    
    public static String getBridgePublishStandardsByStdIds(String chainCode, List<Long> stdIds, long regionId, long publishId, String unPublishInd)
    {
    	StringBuffer query = new StringBuffer("SELECT bp.std_id FROM bridge_publish bp WHERE ");
    	if (stdIds != null && !stdIds.isEmpty()) 
    	{
    		query.append(" bp.std_id in ( ");
    		int i = 0;
    		for (long stdId : stdIds)
    		{
    			if (i > 0) 
    			{
    				query.append(StringPool.COMMA);
    			}
    			query.append(stdId);
    			i++;
    		}
    		query.append(") AND ");
    	}
    	
    	query.append("bp.rgn_id = ").append(regionId).append(" AND bp.unpublish_ind = '").append(unPublishInd);
    	query.append("' AND bp.publish_id = ").append(publishId);
    	return query.toString();
    }
    
    /**
     * @param stdId
     * @return String
     * @author Chintan
     */
    public static String searchStandardsById (long stdId, String chainCode, String regionCode) {
    	 StringBuilder query = new StringBuilder();
     	query.append("WITH SEARCH_STD_IDS AS ( select std_id from STD where prnt_std_id in (SELECT prnt_std_id FROM std where std_id = ");
     	query.append(stdId).append(")),");
     	query.append(" std_details AS (SELECT DISTINCT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.TITLE_TXT,");
     	query.append("TAX.TLEVEL INDX_LEVEL, TAX.HIER_LVL_NBR, TAX.PATH, S.STD_ID,");
     	query.append("S.PRNT_STD_ID, 0 AS STD_ORIG_STD_ID, 'none' AS STD_CTRY_CD, NULL AS STD_PUBLISH_STAT_CD,");
     	query.append("S.STD_TYP, CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT ");
         query.append("END STD_TITLE_TEXT, S.STD_DESC, S.DISP_ORDER_NBR, S.AREA_CATGY_CD, ");
         query.append("S.LST_UPDT_TS, s.rgn_cd, ");
         query.append("(SELECT CASE WHEN s.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') THEN 'DISCONT' ELSE s.stat_cd END ");
         query.append("FROM chain_std cs, stat s WHERE cs.stat_id = s.stat_id AND cs.chain_cd = '").append(chainCode);
         query.append("' AND cs.std_id = s.std_id AND cs.actv_ind = 'Y') status, ");
         query.append("decode((SELECT DISTINCT br.rgn_cd ");
         query.append("FROM ctry_std cs, brndstnd_ctry bc, brndstnd_rgn br ");
         query.append("WHERE cs.ctry_nm_cd = bc.ctry_nm_cd ");
         query.append("AND bc.rgn_id = br.rgn_id ");
         query.append("AND br.rgn_cd = '").append(regionCode).append("' ");
         query.append("AND cs.std_id = s.std_id), NULL, 'NOTRGN', '").append(regionCode).append("') cur_region ");
         query.append("FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, ");
         query.append("(LEVEL - 1) TLEVEL, T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(t.TITLE_TXT, ' -> '), 21) AS PATH,");    
         query.append("T.LST_UPDT_TS FROM TAXONOMY T  START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID");
         query.append(" ORDER SIBLINGS BY T.HIER_LVL_NBR )TAX, STD S, TAXONOMY_STD TS ");
         query.append("WHERE ts.taxonomy_id = tax.taxonomy_id ");
         query.append("AND ts.std_id = s.prnt_std_id AND s.std_id IN (SELECT std_id FROM SEARCH_STD_IDS) order by s.std_typ desc) ");
         query.append(" (SELECT sd.PATH, sd.TAXONOMY_ID,  sd.TITLE_TXT, sd.INDX_LEVEL, sd.STD_ID, sd.PRNT_STD_ID, sd.std_typ, sd.STD_TITLE_TEXT, sd.AREA_CATGY_CD,");
         query.append(" sd.rgn_cd, sd.std_desc, sd.status, sd.cur_region FROM std_details sd)");
         return query.toString();
    }
    
    /**
     * @param stdId
     * @return String
     * @author Chintan
     */
    public static String getStandardsById (long stdId, String chainCode, String regionCode) {
        StringBuilder query = new StringBuilder();
    	query.append("WITH SEARCH_STD_IDS AS ( select std_id from STD where prnt_std_id in (SELECT prnt_std_id FROM std where std_id = ");
    	query.append(stdId).append(")),");
    	query.append("IN_BRAND as (SELECT std_id FROM chain_std WHERE actv_ind = 'Y' AND chain_cd ='"+ chainCode+"' and std_id IN (SELECT STD_ID from SEARCH_STD_IDS)), ");
    	query.append(" std_details AS (SELECT DISTINCT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.TITLE_TXT,");
    	query.append("TAX.TLEVEL INDX_LEVEL, TAX.HIER_LVL_NBR, TAX.PATH, S.STD_ID,");
    	query.append("S.PRNT_STD_ID, 0 AS STD_ORIG_STD_ID, 'none' AS STD_CTRY_CD, NULL AS STD_PUBLISH_STAT_CD,");
    	query.append("S.STD_TYP, CASE WHEN S.STD_TYP = 'GDLN' THEN S.STD_DESC ELSE S.TITLE_TXT ");
        query.append("END STD_TITLE_TEXT, S.STD_DESC, S.DISP_ORDER_NBR, S.AREA_CATGY_CD, ");
        query.append("S.LST_UPDT_TS, s.rgn_cd, ");
        query.append("(SELECT CASE WHEN s.stat_cd IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') THEN 'DISCONT' ELSE s.stat_cd END ");
        query.append("FROM chain_std cs, stat s WHERE cs.stat_id = s.stat_id AND cs.chain_cd = '").append(chainCode);
        query.append("' AND cs.std_id = s.std_id AND cs.actv_ind = 'Y') status, ");
        query.append("decode((SELECT DISTINCT br.rgn_cd ");
        query.append("FROM ctry_std cs, brndstnd_ctry bc, brndstnd_rgn br ");
        query.append("WHERE cs.ctry_nm_cd = bc.ctry_nm_cd ");
        query.append("AND bc.rgn_id = br.rgn_id ");
        query.append("AND br.rgn_cd = '").append(regionCode).append("' ");
        query.append("AND cs.std_id = s.std_id), NULL, 'NOTRGN', '").append(regionCode).append("') cur_region ");
        query.append("FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, ");
        query.append("(LEVEL - 1) TLEVEL, T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(t.TITLE_TXT, ' -> '), 21) AS PATH,");    
        query.append("T.LST_UPDT_TS FROM TAXONOMY T  START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID");
        query.append(" ORDER SIBLINGS BY T.HIER_LVL_NBR )TAX, STD S, TAXONOMY_STD TS ");
        query.append("WHERE ts.taxonomy_id = tax.taxonomy_id ");
        query.append("AND ts.std_id = s.prnt_std_id AND s.std_id IN (SELECT std_id FROM SEARCH_STD_IDS) order by s.std_typ desc) ");
        query.append(" (SELECT sd.PATH, sd.TAXONOMY_ID,  sd.TITLE_TXT, sd.INDX_LEVEL, sd.STD_ID, sd.PRNT_STD_ID, sd.std_typ, sd.STD_TITLE_TEXT, sd.AREA_CATGY_CD,");
        query.append(" sd.rgn_cd, sd.std_desc, sd.status, sd.cur_region FROM std_details sd where sd.std_id in (SELECT STD_ID from IN_BRAND ) and cur_region != 'NOTRGN' and status != 'DISCONT')");
        return query.toString();
    }
    
    /**
     * 
     * @param publishQueueId
     * @param publishId
     * @param emailAddress
     * @return String
     */
    public static String createManuals (long publishQueueId, long publishId, String emailAddress, String userName) {
        StringBuilder query = new StringBuilder();
    	query.append("declare l_queue_id  NUMBER := ").append(publishQueueId).append(";");
        query.append("l_notification_email VARCHAR2(500) :='").append(emailAddress).append("';"); 
        query.append("l_publish_id NUMBER := ").append(publishId).append(";");
        query.append("l_user_nm VARCHAR2(250) := '").append(userName).append("';");
        query.append("l_std_sql VARCHAR2(300);");
        query.append("l_environment VARCHAR2(20);");
        query.append("l_std_ids CLOB;");
        query.append("l_std_cur SYS_REFCURSOR;");
        query.append(" l_sql VARCHAR2(1000) := 'INSERT INTO job_queue(job_id, job_owner, job_typ, metadata_txt, link_txt, ' ||");
        query.append(" 'notification_email_id, strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");
        query.append(" 'VALUES (:job_id, :job_owner, :job_typ, :metadata_txt, :link_txt, :notification_email_id,' ||");
        query.append(" ':strt_ts, :end_ts, :stat_cd, :creat_usr_id, :creat_ts, :lst_updt_usr_id, :lst_updt_ts)';");
        query.append("l_jobId NUMBER;");
        query.append("l_jobOwner VARCHAR2(50);");
        query.append("l_jobType VARCHAR2(30);");
        query.append("l_locale VARCHAR (1200);");
        query.append("l_chain_cd VARCHAR(2);");
        query.append("l_param CLOB;");
        query.append("l_country_lst VARCHAR2(1200);");
        query.append("l_user_id NUMBER;");
        query.append("l_publish_dt TIMESTAMP(6);");
        query.append("l_content_typ VARCHAR2(20);");
        query.append("l_temp_val VARCHAR(5) :=NULL;");
        query.append(" BEGIN ");
        
        query.append(" OPEN l_std_cur FOR ");
        query.append(" SELECT PUBLISH_ENVIRONMENT_NM, CHAIN_CD, PUBLISHED_LOCALE_LIST_TXT, PUBLISH_DT, PUBLISH_CONTENT_TYP, CREAT_USR_ID ");
        query.append(" FROM publish  WHERE publish_id = l_publish_id;");
        query.append(" LOOP ");
        query.append("FETCH l_std_cur INTO l_environment, l_chain_cd, l_locale, l_publish_dt, l_content_typ, l_user_id;");
        query.append(" EXIT WHEN l_std_cur%NOTFOUND;");
        query.append(" END LOOP; ");
        //Country list
        query.append("BRANDSTANDARDSPUBLISH.find_published_countries(l_publish_id, l_queue_id, l_environment, l_user_id, l_country_lst);");
        query.append(" l_param := '<metadata> <type>FULL_MANUAL_PDF</type> <params>' ||");
        query.append(" '<param name=\"PUBLISH_ID\">' || l_publish_id || '</param>' ||");
        query.append(" '<param name=\"PUBLISH_QUEUE_ID\">' || l_queue_id || '</param>' ||");
        query.append(" '<param name=\"ENVIRONMENT\">' || l_environment || '</param>'||");
        query.append(" '<param name=\"LOCALE_LST\">' || l_locale || '</param>' ||");
        query.append(" '<param name=\"COUNTRY_LST\">' || l_country_lst || '</param>' ||");
        query.append(" '<param name=\"STD_ID\">' || l_std_ids || '</param>' ||");
        query.append(" '<param name=\"USER_NAME\">' || l_user_nm || '</param>' ||");
        query.append(" '<param name=\"CHAIN_CD\">' || l_chain_cd || '</param>' ||");
        query.append(" '<param name=\"MANUAL_TYPE\">' || l_content_typ || '</param>' ||");
        query.append(" '<param name=\"PUBLISH_DATE\">'|| to_char(l_publish_dt,'YYYY-MM-DD HH24:MI:SS') ||'</param>' ||"); 
        query.append(" '<param name=\"EXPIRATION_DATE\">'|| to_char(add_months(l_publish_dt, 12),'YYYY-MM-DD HH24:MI:SS')||'</param>' ||");
        query.append(" '</params></metadata>';");
        query.append("  EXECUTE IMMEDIATE l_sql ");
        query.append("  USING job_id_seq.nextval,l_user_id, 'FULL_MANUAL_PDF', l_param, l_temp_val, l_notification_email,");
        query.append("l_temp_val, l_temp_val, 'NEW', l_user_id, SYSDATE, l_user_id, SYSDATE;");
        query.append("  END; ");
        return query.toString();
    }
    
    /**
     * 
     * @param publishId
     * @param regionId
     * @return String
     */
    public static String getMissingReferenceIds (long publishId, long regionId) {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT STD_ID FROM (");
    	query.append(" SELECT STD_ID FROM (SELECT REFERENCED_STD_ID AS STD_ID FROM std_xref");
        query.append(" WHERE REFERRING_STD_ID IN (SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID=");
        query.append(publishId);
        query.append(" AND RGN_ID = ");
        query.append(regionId);
        query.append(" ) MINUS SELECT STD_ID FROM BRIDGE_PUBLISH WHERE UNPUBLISH_IND = 'N' AND PUBLISH_ID= ");
        query.append(publishId);
        query.append(" AND RGN_ID = ");
        query.append(regionId);
        query.append(" ) )");
        return query.toString();
    }
    
    /**
     * Query to get active Bridge Publish Ids for specified standard id.
     * @param stdId standard id
     * @return String
     */
    public static String getBridgePublishIdByStdIdQuery (long stdId) 
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT PUBLISH_ID FROM (");
        query.append("SELECT DISTINCT p.publish_id FROM bridge_publish bp, publish p, chain_std cs ");
        query.append("WHERE p.publish_environment_nm = 'BRIDGE' AND p.publish_stat_cd = 'ACTIVE' ");
        query.append("AND p.publish_id = bp.publish_id AND cs.std_id = bp.std_id ");
        query.append("AND cs.chain_cd = p.chain_cd AND bp.std_id = ").append(stdId).append(" ");
        query.append("UNION ");
        query.append("SELECT DISTINCT p.publish_id FROM bridge_gbl_publish bp, publish p, chain_std cs ");
        query.append("WHERE p.publish_environment_nm = 'BRIDGE' AND p.publish_stat_cd = 'ACTIVE' ");
        query.append("AND p.publish_id = bp.publish_id AND cs.std_id = bp.std_id ");
        query.append("AND cs.chain_cd = p.chain_cd AND bp.std_id = ").append(stdId).append(" ) ");
        return query.toString();
    }
        
    /**
     * 
     * @param publishId
     * @param regionId
     * @param status
     * @return String
     */
    public static String getGroupsByStatus (long publishId, long regionId, String regionCD, String chainCD) {
        StringBuilder query = new StringBuilder();
    	
        query.append(" WITH PUB AS (SELECT p.publish_id, p.chain_cd, p.publish_dt FROM publish p ");
    	query.append(" WHERE p.chain_cd = '");
    	query.append(chainCD);
    	query.append("' AND p.publish_environment_nm = 'BRIDGE' AND p.publish_stat_cd = 'ACTIVE'), ");
        query.append(" STD_CTRY AS ( ");
    	query.append(" SELECT b.std_id, bc.ctry_nm_cd, bc.bridge_publish_stat_cd FROM ");
    	query.append(" bridge_publish b, bridge_publish_ctry bc, PUB p ");
    	query.append(" WHERE b.publish_id = p.publish_id ");
    	//query.append(publishId);
    	query.append(" AND b.bridge_publish_id = bc.bridge_publish_id AND bc.publish_ind = 'Y'  ");
    	//AND s.std_typ = 'STD'
    	query.append(" AND b.unpublish_ind = 'N' AND b.rgn_id = ");
    	query.append(regionId);
    	/*query.append(" AND bc.bridge_publish_stat_cd = '");
    	query.append(status);*/
    	query.append(" ), ");
    	
    	//Find rules and comliance/expiry date per country
    	query.append(" NEW_STD_RULE_EXPRY AS ( ");
    	query.append("SELECT sc.std_id, sc.ctry_nm_cd, ");
    	query.append(" CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
    	query.append(" CASE WHEN sc.rule_dt_cd = 'R' THEN ");
    	query.append(" CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
    	query.append(" sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(p.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') ");
    	query.append("    END ");
    	query.append("   ELSE ");
    	query.append("     'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
    	query.append("   END ");
    	query.append(" WHEN sc.cmply_expr_rule_cd = 'E' THEN ");
    	query.append(" 'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
    	query.append(" END cmply_expr_date FROM std_cmply sc, PUB p WHERE sc.chain_cd = p.chain_cd ");
    	query.append(" AND sc.std_id in (select std_id from STD_CTRY) ");
    	query.append(" AND sc.ctry_nm_cd NOT IN (SELECT ctry_nm_cd FROM std_ctry_chain ");
    	query.append(" WHERE chain_cd = '");
    	query.append(chainCD);
    	query.append("' AND std_id  = sc.std_id) ");
    	query.append(" AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id ");
    	query.append(" = (SELECT rgn_id FROM brndstnd_rgn WHERE rgn_cd = '");
    	query.append(regionCD);
    	query.append("' ))), ");
    	query.append(" PUB_STD_CMPLY_EXPRY AS (SELECT std_id, ctry_nm_cd, ");
    	query.append("  CASE WHEN cmply_dt IS NOT NULL AND cmply_dt > SYSDATE THEN ");
    	query.append(" to_char(cmply_dt, 'DD Mon YYYY') WHEN expr_dt IS NOT NULL AND ");
    	query.append(" expr_dt > SYSDATE THEN 'Expires | ' || to_char(expr_dt, 'DD Mon YYYY') ");
    	query.append(" END  cmply_expr_date ");
    	query.append(" FROM std_ctry_chain WHERE std_id in (select std_id from STD_CTRY) ");
    	query.append(" AND chain_cd = '");
    	query.append(chainCD);
    	query.append("' AND rgn_cd = '");
    	query.append(regionCD);
    	query.append("' ), STD_TOTAL AS (SELECT * FROM NEW_STD_RULE_EXPRY   UNION ALL SELECT * FROM PUB_STD_CMPLY_EXPRY) ");
    	query.append(" SELECT sc.std_id, LISTAGG(sc.ctry_nm_cd, ';') ");
    	query.append(" WITHIN GROUP (ORDER BY sc.std_id) AS ctry_lst, ");
    	query.append(" LISTAGG(sc.ctry_nm_cd  || '::'  || sc.bridge_publish_stat_cd, ';') ");
    	query.append(" WITHIN GROUP (ORDER BY sc.std_id) AS ctry_stat_lst, ");
    	query.append(" LISTAGG(st.ctry_nm_cd  || '::'  || st.cmply_expr_date, ';') WITHIN GROUP "); 
    	query.append(" (ORDER BY st.std_id) AS cmply_expr_date FROM STD_TOTAL st, STD_CTRY sc ");
    	query.append(" WHERE  sc.std_id = st.std_id (+) and  sc.ctry_nm_cd  = st.ctry_nm_cd (+)");
    	query.append(" group BY  sc.std_id");
    	return query.toString();
    }
    
    /**
     * @param stdId This is a long object
     * @param locale This is a String object
     * @param brand This is a String object
     * @param countryCode This is a String object
     * @param criteriaMap This is a Map<String, StandardsSearchCriteria> object
     * @return String
     */
    public static String getSupportingMaterial(long stdId, String locale, String brand, String countryCode)
    {
        StringBuffer query = new StringBuffer();
        if (Validator.isNotNull(stdId))
        {
        	StringBuilder countryClause = new StringBuilder();
            int inc = 0;
            
            for (String ctryCode : countryCode.split(StringPool.SEMICOLON)) {
            	if (inc > 0) {
            		countryClause.append(StringPool.COMMA);
            	}
            	countryClause.append("'").append(ctryCode).append("'");
            	inc++;
            }
        	
        	query.append("WITH ATTACHMENTS AS (SELECT std.STD_ID AS ATTCHSTDID, attch.STD_ATTACHEMENT_ID AS STDATTCHID,");
            query.append(" attch.attachment_typ AS ATTTYPE, attch.attachment_title_txt AS ATTTITLE, ");
            query.append("attch.attachment_path_txt AS ATTPATH, attch.prnt_std_attachment_id AS ATTPRNTID");
            query.append(" ,attch.LOCALE_CD AS ATTLOCALECD, null AS EXTSTDID,null AS EXTLINKID,");
            query.append("null AS EXTTITLE,null AS EXTURL,null AS EXTPRNTID,null AS EXTLOCALECD ");
            query.append("FROM std_attachment attch, STD std, CTRY_STD pcs, std_attachment_chain si, std_attachment_ctry sc ");
            query.append("WHERE attch.STD_ID = std.STD_ID");
            query.append(" AND attch.STD_ID = ");
            query.append(stdId);
            query.append(" AND pcs.STD_ID = ");
            query.append("std.STD_ID AND pcs.ctry_nm_cd in (");
            query.append(countryClause);
            query.append(") AND attch.std_attachement_id = si.std_attachement_id AND attch.std_attachement_id = ");
            query.append(" sc.std_attachement_id  AND sc.ctry_nm_cd  in (");
            query.append(countryClause);
            query.append(" ) AND si.chain_cd = '");
            query.append(brand);
            query.append("' AND (attch.PRNT_STD_ATTACHMENT_ID = attch.STD_ATTACHEMENT_ID or ");
            query.append("attch.locale_cd in ( '").append(locale).append("','");
            query.append("en_GB").append("' ))),  LINKS AS (");
            query.append(" SELECT null AS ATTCHSTDID,null AS STDATTCHID,null AS ATTTYPE,null AS ATTTITLE,null AS ATTPATH,");
            query.append("null AS ATTPRNTID,null AS ATTLOCALECD,");
            query.append(" std.STD_ID, links.STD_EXTL_LINK_ID, links.link_title_txt, links.url_txt, ");
            query.append("links.prnt_std_extl_link_id");
            query.append(",links.LOCALE_CD FROM STD_EXTL_LINK links, STD std, std_extl_link_chain si, std_link_ctry sc, ");
            query.append("CTRY_STD pcs  WHERE links.STD_ID = std.STD_ID");
            query.append("  AND links.STD_ID = ");
            query.append(stdId).append(" AND ");
            query.append("pcs.STD_ID = std.STD_ID AND links.std_extl_link_id = si.std_extl_link_id ");
            query.append(" AND links.std_extl_link_id = sc.std_extl_link_id AND si.chain_cd = '");
            query.append(brand);
            query.append("' AND pcs.ctry_nm_cd in (");
            query.append(countryClause).append(") AND sc.ctry_nm_cd in (");
            query.append(countryClause).append(") AND ");
            query.append("(links.std_extl_link_id = links.prnt_std_extl_link_id or links.locale_cd in ( '");
            query.append(locale).append("','").append("en_GB").append("' ))");
            query.append(") (select * from ATTACHMENTS union select * from links)");
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("ids :::" + stdId + " \n query for std supporting material ::" + query.toString());
        }
        
        return query.toString();
    }

    /**
     * @param stdId This is a long object
     * @param locale This is a String object
     * @param brand This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @return String
     */
    public static String getRelatedImages(long stdId, String locale, String brand, String countryCode)
    {
        StringBuffer query = new StringBuffer();
        if (Validator.isNotNull(stdId))
        {
            StringBuilder countryClause = new StringBuilder();
            int inc = 0;
            
            for (String ctryCode : countryCode.split(StringPool.SEMICOLON)) {
            	if (inc > 0) {
            		countryClause.append(StringPool.COMMA);
            	}
            	countryClause.append("'").append(ctryCode).append("'");
            	inc++;
            }
            query.append("SELECT DISTINCT a.STD_IMAGE_ID, a.IMAGE_ID, a.IMAGE_TITLE_TXT, a.PRNT_STD_IMAGE_ID,");
            query.append(" b.STD_ID, a.LOCALE_CD FROM STD_IMAGE a, ");
            query.append(" STD b, CTRY_STD pcs, std_image_chain si, std_image_ctry sc where a.STD_ID = ");
            query.append(stdId);
            query.append(" and a.std_id = b.std_id and pcs.STD_ID = b.STD_ID and ");
            query.append(" a.std_image_id = si.std_image_id AND a.std_image_id = sc.std_image_id and pcs.ctry_nm_cd in (");
            query.append(countryClause).append(") AND si.chain_cd = '");
            query.append(brand);
            query.append("' and sc.ctry_nm_cd in (");
            query.append(countryClause);
            query.append(") AND (a.STD_IMAGE_ID = a.PRNT_STD_IMAGE_ID or a.LOCALE_CD in ('");
            query.append(locale).append("','").append("en_GB").append("')) ");
           
            if (LOG.isDebugEnabled())
            {
                LOG.debug("query for std image ::" + query.toString());
            }
        }
        return query.toString();
    }
    
    public static String getIssueCountForMustPublishQuery(String isMustPublish, long publishId, String brand )
    {
    	 StringBuffer query = new StringBuffer();
    	 query.append("SELECT CAT, CNT FROM ( ");
    	 
    	 query.append("SELECT 'GLOBAL_MUST_REGION' AS CAT, count(*) AS CNT, 1 AS DISP_NO FROM ( "); 
    	 for (int regionId=2; regionId<=5; regionId++)
    	 {
    		 if (regionId > 2)
    		 {	
    			 query.append(" UNION ");
    		 }
	    	 query.append("SELECT DISTINCT bg.STD_ID FROM BRIDGE_GBL_PUBLISH bg, BRIDGE_GBL_PUBLISH_CTRY bgc");
	    	 query.append(" WHERE bg.bridge_gbl_publish_id=bgc.bridge_gbl_publish_id AND bg.MUST_PUBLISH_IND='Y' AND bg.PUBLISH_ID=");
	    	 query.append(publishId); 
	    	 query.append(" AND bgc.ctry_nm_cd in (SELECT DISTINCT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id=");
	    	 query.append(regionId); 
	    	 query.append(") MINUS "); 
	    	 query.append("SELECT DISTINCT std_id FROM CTRY_STD  WHERE ctry_nm_cd IN (SELECT DISTINCT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id=");
	    	 query.append(regionId);
	    	 query.append(")");
    	 }
    	 /** Adding standard which does not have any country selected */
    	 query.append(" UNION SELECT DISTINCT bg.STD_ID FROM BRIDGE_GBL_PUBLISH bg WHERE bg.MUST_PUBLISH_IND='Y' AND bg.PUBLISH_ID=");
    	 query.append(publishId); 
    	 query.append(" AND bg.bridge_gbl_publish_id NOT IN (");
    	 query.append(" SELECT bg.bridge_gbl_publish_id FROM BRIDGE_GBL_PUBLISH bg, BRIDGE_GBL_PUBLISH_CTRY bgc WHERE bg.MUST_PUBLISH_IND='Y' AND bg.PUBLISH_ID="); 
    	 query.append(publishId); 
    	 query.append(" AND bg.bridge_gbl_publish_id=bgc.bridge_gbl_publish_id");
    	 query.append(" ))");
    	 
    	 query.append(" UNION " );
    	 query.append("SELECT 'GLOBAL_MUST_BRAND' AS CAT, count(*) AS CNT, 2 AS DISP_NO FROM ( ");
    	 query.append("SELECT DISTINCT STD_ID FROM BRIDGE_GBL_PUBLISH WHERE MUST_PUBLISH_IND = '");
    	 query.append(isMustPublish);
    	 query.append("' AND PUBLISH_ID = ");
    	 query.append(publishId);
    	 query.append(" MINUS ");
    	 query.append("SELECT DISTINCT std_id FROM CHAIN_STD WHERE chain_cd ='");
    	 query.append(brand);
    	 query.append("' and actv_ind='Y'");
    	 query.append("))");
    	 return query.toString();
    }
    
    public static String getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionIdQuery(long bridgePublishId, long regionId)
    {
    	StringBuilder query = new StringBuilder("SELECT * FROM  BRIDGE_GBL_PUBLISH_CTRY BGPC WHERE BGPC.CTRY_NM_CD IN ( ");
    	query.append("SELECT BRD_CNT.CTRY_NM_CD FROM BRNDSTND_CTRY BRD_CNT WHERE BRD_CNT.RGN_ID = " + regionId+ " ) AND BGPC.BRIDGE_GBL_PUBLISH_ID= " + bridgePublishId);
    	return query.toString();
    }

    public static String getMustPublishStandardsByIdsOrBrandQuery(String stdIdsByCommaSeprated, String brand){
        StringBuilder query = new StringBuilder("SELECT * FROM ( WITH ");               
    	query.append("TAXONOMI AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH ");
    	query.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, ");
    	query.append(" T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' &#0062; '), 31) AS PATH "); 
    	query.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ) TAX), "); 
    	query.append(" GLB_PUB_STD AS (SELECT BGP.STD_ID, BGP.BRIDGE_GBL_PUBLISH_ID, ");
    	query.append(" CASE WHEN S.TITLE_TXT = 'GDLN' THEN S.STD_DESC WHEN S.TITLE_TXT != 'GDLN' THEN S.TITLE_TXT END as TITLE_TXT, ");
    	query.append(" S.STD_TYP, S.PRNT_STD_ID, S.RGN_CD, S.STAT_DESC, S.DISP_ORDER_NBR, S.GBL_RGN_IND, S.FRAMEWORK_STD_IND ");
    	query.append(" FROM BRIDGE_GBL_PUBLISH BGP, STD S ");
    	query.append(" WHERE S.STD_ID = BGP.STD_ID ");
    	query.append(" AND BGP.MUST_PUBLISH_IND='Y' ");
    	query.append(" AND BGP.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' ");
    	query.append(" AND PUBLISH_STAT_CD='ACTIVE' AND CHAIN_CD = '");
    	query.append(brand);
    	query.append("')),");
    	
    	query.append(" STD_LST AS (SELECT GPS.PRNT_STD_ID, GPS.STD_ID, GPS.BRIDGE_GBL_PUBLISH_ID, GPS.TITLE_TXT AS TITLE, ");
    	query.append(" GPS.STD_TYP AS STD_TYPE, GPS.STAT_DESC, GPS.DISP_ORDER_NBR, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, ");
    	query.append(" T.INDX_ORDER, T.LVL, T.HIER_LVL_NBR, T.PATH, T.TITLE_TXT AS CURR_PATH, GPS.RGN_CD, GPS.GBL_RGN_IND, GPS.FRAMEWORK_STD_IND ");
    	query.append(" FROM TAXONOMI T, GLB_PUB_STD GPS, TAXONOMY_STD TS ");
    	query.append(" WHERE T.TAXONOMY_ID=TS.TAXONOMY_ID AND TS.STD_ID = GPS.PRNT_STD_ID ");
    	if (Validator.isNotNull(stdIdsByCommaSeprated)) { 
            query.append(" AND GPS.STD_ID IN (SELECT std_id FROM std WHERE prnt_std_id IN (SELECT prnt_std_id FROM std WHERE std_id in (");
            query.append(stdIdsByCommaSeprated);
            query.append("))) ");
        }
    	
        query.append("),");
        
        query.append(" STD_CNT AS (SELECT SL.STD_ID, BRD_CNT.RGN_ID, COUNT(BGPC.CTRY_NM_CD) AS S_CNT_COUNT FROM STD_LST SL, ");
        query.append(" BRIDGE_GBL_PUBLISH_CTRY BGPC, BRNDSTND_CTRY BRD_CNT ");
        query.append(" WHERE BRD_CNT.CTRY_NM_CD = BGPC.CTRY_NM_CD AND BGPC.PUBLISH_IND='Y' AND BGPC.BRIDGE_GBL_PUBLISH_ID = SL.BRIDGE_GBL_PUBLISH_ID ");
        query.append(" GROUP BY SL.STD_ID, BRD_CNT.RGN_ID ORDER BY SL.STD_ID, BRD_CNT.RGN_ID), ");
        
        query.append(" RGN_CNT AS (SELECT SL.STD_ID, BRD_CNT.RGN_ID, COUNT(BRD_CNT.CTRY_NM_CD) AS R_CNT_COUNT FROM BRNDSTND_CTRY BRD_CNT, STD_LST SL, ");
        query.append(" CTRY_STD CS WHERE BRD_CNT.CTRY_NM_CD=CS.CTRY_NM_CD AND CS.STD_ID=SL.STD_ID GROUP BY SL.STD_ID, RGN_ID ORDER BY SL.STD_ID, RGN_ID), ");
        
        query.append(" STD_RGN_COUNT AS (SELECT * FROM ( SELECT SCNT.STD_ID AS STD_ID, RCNT.RGN_ID AS RGN_ID, ");
        query.append(" CASE ");
        query.append(" WHEN SCNT.STD_ID=RCNT.STD_ID AND SCNT.RGN_ID=RCNT.RGN_ID AND SCNT.S_CNT_COUNT = RCNT.R_CNT_COUNT THEN 'btn-primary' ");
        query.append(" WHEN SCNT.STD_ID=RCNT.STD_ID AND SCNT.RGN_ID=RCNT.RGN_ID AND SCNT.S_CNT_COUNT < RCNT.R_CNT_COUNT  AND SCNT.S_CNT_COUNT !=0 THEN 'btn-info' ");
        query.append(" END AS COLOR ");
        query.append(" FROM STD_CNT SCNT, RGN_CNT RCNT WHERE SCNT.STD_ID=RCNT.STD_ID) ");
        query.append(" PIVOT ( MIN (COLOR) FOR (RGN_ID) IN (2 AS AMER,3 AS AMEA,4 AS EURO,5 AS GC))), ");
        
        query.append(" DISP_ORDER AS (SELECT disp.std_id, COALESCE(disp.disp_order_nbr,0) as disp_order_nbr ");
        query.append(" FROM std_display_order disp where disp.std_id in (select std_id from std_lst) ");
        query.append(" AND disp.rgn_cd = 'GLBL' and disp.chain_cd = '");
        query.append(brand);
        query.append("')");
        
        query.append(" SELECT SL.PRNT_STD_ID, SL.STD_ID, SL.TITLE, SL.STD_TYPE, SL.STAT_DESC, ORNUM.DISP_ORDER_NBR, ");
        query.append(" SL.TAXONOMY_ID, SL.PRNT_TAXONOMY_ID, SL.INDX_ORDER, ");
        query.append(" SL.LVL, SL.HIER_LVL_NBR, SL.PATH, SL.CURR_PATH, SL.RGN_CD, SL.GBL_RGN_IND, SL.FRAMEWORK_STD_IND, ");
        query.append(" SRC.AMER, SRC.AMEA, SRC.EURO, SRC.GC FROM ");
        query.append(" STD_RGN_COUNT SRC,STD_LST SL, DISP_ORDER ORNUM  WHERE SL.STD_ID = SRC.STD_ID(+) AND SL.STD_ID = ORNUM.STD_ID(+))");
        
        if (LOG.isDebugEnabled()) {
        	LOG.debug(" Query is :::"+query.toString());
        }
        
        return query.toString();
    }
    
    public static String getMustNotPublishStandardsByIdsOrBrandQuery(String stdIdsByCommaSeprated, String brand){
        StringBuilder query = new StringBuilder("SELECT * FROM ( WITH ");               
    	query.append(" TAXONOMI AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH");
    	query.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR,");
    	query.append(" T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' &#0062; '), 31) AS PATH"); 
    	query.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ) TAX),"); 
    	
    	query.append(" GLB_PUB_STD AS (SELECT BGP.STD_ID, BGP.BRIDGE_GBL_PUBLISH_ID, ");
    	query.append(" CASE WHEN S.TITLE_TXT = 'GDLN' THEN S.STD_DESC WHEN S.TITLE_TXT != 'GDLN' THEN S.TITLE_TXT END as TITLE_TXT, ");
    	query.append(" S.STD_TYP, S.PRNT_STD_ID, S.RGN_CD, S.STAT_DESC, S.DISP_ORDER_NBR, S.GBL_RGN_IND, S.FRAMEWORK_STD_IND ");
    	query.append(" FROM BRIDGE_GBL_PUBLISH BGP, STD S ");
    	query.append(" WHERE S.STD_ID = BGP.STD_ID ");
    	query.append(" AND BGP.MUST_PUBLISH_IND='N'");
    	if (Validator.isNotNull(stdIdsByCommaSeprated)) {
    		query.append("AND BGP.STD_ID IN (").append(stdIdsByCommaSeprated).append(")");
    	}
    	query.append(" AND BGP.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' ");
    	query.append(" AND PUBLISH_STAT_CD='ACTIVE' AND CHAIN_CD = '");
    	query.append(brand);
    	query.append("') UNION SELECT BGP.STD_ID, BGP.BRIDGE_GBL_PUBLISH_ID, ");
    	query.append(" CASE WHEN S.TITLE_TXT = 'GDLN' THEN S.STD_DESC WHEN S.TITLE_TXT != 'GDLN' THEN S.TITLE_TXT END as TITLE_TXT, ");
    	query.append(" S.STD_TYP, S.PRNT_STD_ID, S.RGN_CD, S.STAT_DESC, S.DISP_ORDER_NBR, S.GBL_RGN_IND, S.FRAMEWORK_STD_IND ");
    	query.append(" FROM BRIDGE_GBL_PUBLISH BGP, STD S ");
    	query.append(" WHERE S.STD_ID = BGP.STD_ID ");
    	query.append(" AND S.STD_TYP='STD' AND BGP.MUST_PUBLISH_IND='Y'");
    	query.append(" AND BGP.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' ");
    	query.append(" AND PUBLISH_STAT_CD='ACTIVE' AND CHAIN_CD = '");
    	query.append(brand);
    	query.append("') AND BGP.STD_ID IN (SELECT S.PRNT_STD_ID FROM BRIDGE_GBL_PUBLISH BGP, STD S WHERE S.STD_ID=BGP.STD_ID AND BGP.MUST_PUBLISH_IND='N'");
    	if (Validator.isNotNull(stdIdsByCommaSeprated)) {
    		query.append("AND BGP.STD_ID IN (").append(stdIdsByCommaSeprated).append(")");
    	}
    	query.append(" AND BGP.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' ");
    	query.append(" AND PUBLISH_STAT_CD='ACTIVE' AND CHAIN_CD = '");
    	query.append(brand);
    	query.append("'))),");
    	
    	query.append(" STD_LST AS (SELECT GPS.PRNT_STD_ID, GPS.STD_ID, GPS.BRIDGE_GBL_PUBLISH_ID, GPS.TITLE_TXT AS TITLE, ");
    	query.append(" GPS.STD_TYP AS STD_TYPE, GPS.STAT_DESC, GPS.DISP_ORDER_NBR, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, ");
    	query.append(" T.INDX_ORDER, T.LVL, T.HIER_LVL_NBR, T.PATH, T.TITLE_TXT AS CURR_PATH, GPS.RGN_CD, GPS.GBL_RGN_IND, GPS.FRAMEWORK_STD_IND ");
    	query.append(" FROM TAXONOMI T, GLB_PUB_STD GPS, TAXONOMY_STD TS ");
    	query.append(" WHERE T.TAXONOMY_ID=TS.TAXONOMY_ID AND TS.STD_ID = GPS.PRNT_STD_ID ");
        if (Validator.isNotNull(stdIdsByCommaSeprated)) {
            query.append(" AND (GPS.STD_ID IN (");
            query.append(stdIdsByCommaSeprated);
            query.append(") OR GPS.STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM STD WHERE STD_ID in (");
            query.append(stdIdsByCommaSeprated);
            query.append(") ) )"); 
        }
        query.append("),");
        
        query.append(" STD_CNT AS (SELECT SL.STD_ID, BRD_CNT.RGN_ID, COUNT(BGPC.CTRY_NM_CD) AS S_CNT_COUNT FROM STD_LST SL, ");
        query.append(" BRIDGE_GBL_PUBLISH_CTRY BGPC, BRNDSTND_CTRY BRD_CNT ");
        query.append(" WHERE BRD_CNT.CTRY_NM_CD = BGPC.CTRY_NM_CD AND BGPC.BRIDGE_GBL_PUBLISH_ID = SL.BRIDGE_GBL_PUBLISH_ID ");
        query.append(" GROUP BY SL.STD_ID, BRD_CNT.RGN_ID ), ");
        
        query.append(" RGN_CNT AS (SELECT RGN_ID, COUNT(CTRY_NM_CD) AS R_CNT_COUNT FROM BRNDSTND_CTRY BRD_CNT GROUP BY RGN_ID), ");
        
        query.append(" STD_RGN_COUNT AS (SELECT * FROM ( SELECT SCNT.STD_ID AS STD_ID, RCNT.RGN_ID AS RGN_ID, ");
        query.append(" CASE ");
        query.append(" WHEN SCNT.S_CNT_COUNT = RCNT.R_CNT_COUNT THEN 'btn-primary' ");
        query.append(" WHEN SCNT.S_CNT_COUNT < RCNT.R_CNT_COUNT  AND SCNT.S_CNT_COUNT !=0 THEN 'btn-info' ");
        query.append(" END AS COLOR ");
        query.append(" FROM STD_CNT SCNT, RGN_CNT RCNT WHERE SCNT.RGN_ID=RCNT.RGN_ID) ");
        query.append(" PIVOT ( MIN (COLOR) FOR  (RGN_ID) IN (2 AS AMER,3 AS AMEA,4 AS EURO,5 AS GC))), ");
        
        query.append(" DISP_ORDER AS (SELECT disp.std_id, COALESCE(disp.disp_order_nbr, 0) as disp_order_nbr ");
        query.append(" FROM std_display_order disp where disp.std_id in (select std_id from std_lst) ");
        query.append(" AND disp.rgn_cd = 'GLBL' and disp.chain_cd = '");
        query.append(brand);
        query.append("') ");
        
        query.append(" SELECT SL.PRNT_STD_ID, SL.STD_ID, SL.TITLE, SL.STD_TYPE, SL.STAT_DESC, ORNUM.DISP_ORDER_NBR, ");
        query.append(" SL.TAXONOMY_ID, SL.PRNT_TAXONOMY_ID, SL.INDX_ORDER, ");
        query.append(" SL.LVL, SL.HIER_LVL_NBR, SL.PATH, SL.CURR_PATH, SL.RGN_CD, SL.GBL_RGN_IND, SL.FRAMEWORK_STD_IND, ");
        query.append(" SRC.AMER, SRC.AMEA, SRC.EURO, SRC.GC FROM ");
        query.append(" STD_RGN_COUNT SRC,STD_LST SL, DISP_ORDER ORNUM  WHERE SL.STD_ID = SRC.STD_ID(+) AND SL.STD_ID = ORNUM.STD_ID(+))");
        
        return query.toString();
    }
    
    public static String getLatestPublication(String brandCode, String environment, String status)
    {
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT publish_id, publish_ver_id, publish_stat_cd, publish_environment_nm, chain_cd, published_locale_list_txt, "); 
        query.append("creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts, publish_dt, publish_content_typ, prnt_publish_id, vld_xlat_ind ");
        query.append("FROM (SELECT publish_id, publish_ver_id, publish_stat_cd, publish_environment_nm, chain_cd, published_locale_list_txt, "); 
        query.append("creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts, publish_dt, publish_content_typ, prnt_publish_id, vld_xlat_ind ");
        query.append("FROM publish ");
        query.append("WHERE publish_environment_nm = '").append(environment).append("' AND publish_stat_cd = '").append(status).append("' ");
        query.append("AND chain_cd = '").append(brandCode).append("' ");
        query.append("ORDER BY creat_ts DESC) ");
        query.append("WHERE rownum = 1 ");
        
        return query.toString();
    }

    public static String getGlobalMustPublishImportProcedure(){
    	StringBuffer query = new StringBuffer();
    	query.append(" DECLARE ");
    	query.append(" l_publish_id NUMBER := ?;");
    	query.append(" l_usrt_id VARCHAR2(50) := ?;");
    	query.append(" l_chain_cd VARCHAR2(2) := ?;");
    	query.append(" l_std_ids CLOB := ?;");
    	query.append(" l_std_id NUMBER;");
    	query.append(" l_prn_std_id NUMBER;");
    	query.append(" l_std_typ VARCHAR2(4);");
    	query.append(" l_rgn_cd VARCHAR2(4);");
    	query.append(" l_ctry_cd VARCHAR2(3);");
    	query.append(" l_stat_cd VARCHAR2(20);");
    	query.append(" l_pub_ind VARCHAR2(1) := 'Y';");
    	query.append(" l_brg_gbl_id NUMBER;");
    	query.append(" l_brg_gbl_ctry_id NUMBER;");
    	query.append(" l_cur SYS_REFCURSOR;");
    	query.append(" l_ctry_cur SYS_REFCURSOR;");
    	query.append(" l_ins_brg_gbl VARCHAR2(300) := ");
    	query.append(" 		'INSERT INTO bridge_gbl_publish (bridge_gbl_publish_id, publish_id, std_id, must_publish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");
    	query.append(" 		'VALUES(:id, :pubId, :stdId, :pubInd, :crUsr, :crTs, :updUsr, :updTs)';");
        query.append(" l_ins_brg_gbl_ctry VARCHAR2(300) := ");
        query.append(" 		'INSERT INTO bridge_gbl_publish_ctry (bridge_gbl_publish_ctry_id, bridge_gbl_publish_id, ctry_nm_cd, publish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");
        query.append(" 		'VALUES(:id, :brgGblId, :ctryCd, :pubInd, :crUsr, :crTs, :updUsr, :updTs)';");
        
    	query.append(" BEGIN");
    	query.append(" OPEN l_cur FOR ");
    	query.append("    WITH");
    	query.append("    IMPORT_IDS AS (");
    	query.append("    SELECT s.std_id, s.prnt_std_id, s.std_typ, s.rgn_cd");
    	query.append("    FROM std s, chain_std cs, stat st");
    	query.append("    WHERE s.std_id IN (SELECT COLUMN_VALUE FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_std_ids)))");
    	query.append("    AND s.stat_desc != 'DELETED'");
    	query.append("    AND s.std_id = cs.std_id");
    	query.append("    AND cs.chain_cd = l_chain_cd");
    	query.append("    AND st.stat_id = cs.stat_id");
    	query.append("    AND s.rgn_cd = 'GLBL'");//added clause for not to insert regional standards/spec/guideline in must publish screen.
    	query.append("    AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
    	query.append("    AND s.std_id NOT IN (SELECT std_id FROM bridge_gbl_publish WHERE publish_id = l_publish_id)),");
    	query.append("    PRNT_IDS AS (");
    	query.append("    SELECT s.std_id, s.prnt_std_id, s.std_typ, s.rgn_cd");
    	query.append("    FROM std s, IMPORT_IDS ms, chain_std cs, stat st");
    	query.append("    WHERE s.std_id = ms.prnt_std_id");
    	query.append("    AND s.stat_desc != 'DELETED'");
    	query.append("    AND s.std_id = cs.std_id");
    	query.append("    AND cs.chain_cd = l_chain_cd");
    	query.append("    AND st.stat_id = cs.stat_id");
    	query.append("    AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
    	query.append("    AND s.std_id NOT IN (SELECT std_id FROM bridge_gbl_publish WHERE publish_id = l_publish_id))");
    	query.append("    SELECT * FROM IMPORT_IDS");
    	query.append("    UNION");
    	query.append("    SELECT * FROM PRNT_IDS;");
    	query.append(" LOOP");
    	query.append("    FETCH l_cur INTO l_std_id, l_prn_std_id, l_std_typ, l_rgn_cd;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;");
    	query.append("    SELECT bridge_gbl_publish_id_seq.nextval INTO l_brg_gbl_id FROM dual;");
    	query.append("    EXECUTE IMMEDIATE l_ins_brg_gbl");
    	query.append("    USING l_brg_gbl_id, l_publish_id, l_std_id, l_pub_ind, l_usrt_id, SYSDATE, l_usrt_id, SYSDATE;");
    	query.append("    OPEN l_ctry_cur FOR ");
    	query.append("        SELECT ctry_nm_cd FROM ctry_std");
    	query.append("        WHERE std_id = l_std_id;");
    	query.append("    LOOP");
    	query.append("        FETCH l_ctry_cur INTO l_ctry_cd; ");
    	query.append("        EXIT WHEN l_ctry_cur%NOTFOUND;");
    	query.append("        EXECUTE IMMEDIATE l_ins_brg_gbl_ctry");
    	query.append("        USING bridge_gbl_publish_ctry_id_seq.nextval, l_brg_gbl_id, l_ctry_cd, l_pub_ind, l_usrt_id, SYSDATE, l_usrt_id, SYSDATE;");
    	query.append("    END LOOP;");
    	query.append("    IF l_ctry_cur IS NOT NULL THEN ");
    	query.append("        CLOSE l_ctry_cur;");
    	query.append("    END IF;");
    	query.append(" END LOOP;");
    	query.append(" IF l_cur IS NOT NULL THEN ");
    	query.append("    CLOSE l_cur;");
    	query.append(" END IF;");
    	query.append(" COMMIT;");
    	query.append(" END;");
    	
    	return query.toString();
    }

    public static String getStandardComplianceDetails(long stdId, String environment, String brandCd, String regionCode)
    {
        StringBuilder query = new StringBuilder();
        
        query.append("WITH ");
        query.append("PUB AS (SELECT p.publish_id, p.chain_cd, p.publish_dt FROM publish p WHERE p.chain_cd = '");
        query.append(brandCd).append("' AND p.publish_environment_nm = '").append(environment).append("' AND p.publish_stat_cd = 'ACTIVE'), ");
//        -- Find rules and comliance/expiry date per country
        query.append("NEW_STD_RULE_EXPRY AS ( ");
        query.append("  SELECT sc.std_id, sc.ctry_nm_cd, sc.cmply_expr_rule_cd || '_' || sc.rule_dt_cd, ");
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
        query.append("   CASE WHEN sc.rule_dt_cd = 'R' THEN ");
        query.append("    CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
        query.append("     sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(p.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') ");
        query.append("    END ");
        query.append("   ELSE ");
        query.append("   CASE WHEN sc.cmply_expr_dt > p.publish_dt THEN ");
        query.append("     'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
        query.append("  END  END ");
        query.append("  WHEN sc.cmply_expr_rule_cd = 'E' THEN ");
        query.append("   CASE WHEN sc.cmply_expr_dt > p.publish_dt THEN ");
        query.append("     'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
        query.append(" END  END cmply_expr_date ");
        query.append("  FROM std_cmply sc, PUB p ");
        query.append("  WHERE sc.chain_cd = p.chain_cd ");
        query.append("  AND sc.std_id = ").append(stdId).append(" ");
        query.append("  AND sc.ctry_nm_cd NOT IN (SELECT ctry_nm_cd FROM std_ctry_chain ");
        query.append("WHERE chain_cd = '").append(brandCd).append("' AND std_id = ").append(stdId).append(") ");
                                    
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
        {
            query.append("  AND sc.ctry_nm_cd IN ");
            query.append("(SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = (SELECT rgn_id FROM brndstnd_rgn WHERE rgn_cd = '").append(regionCode).append("')) ");
        }
        query.append("), ");
        query.append("PUB_STD_CMPLY_EXPRY AS ( ");
        query.append("  SELECT sc.std_id, sc.ctry_nm_cd, ");
        query.append("  CASE WHEN sc.cmply_dt > p.publish_dt THEN ");
        query.append("      'PUB_CMPL' ");
        query.append("  WHEN sc.expr_dt > p.publish_dt THEN ");
        query.append("     'PUB_EXPR' ");
        query.append("  END cmply_expr_rule_cd, ");
            
        query.append("  CASE WHEN sc.cmply_dt > p.publish_dt THEN ");
//        query.append("      CASE WHEN cmply_dt > SYSDATE THEN ");
        query.append("          to_char(sc.cmply_dt, 'DD Mon YYYY') ");
//        query.append("      END ");
        query.append("  WHEN sc.expr_dt  > p.publish_dt THEN ");
//        query.append("      CASE WHEN expr_dt > SYSDATE THEN ");
        query.append("         'Expires | ' || to_char(sc.expr_dt, 'DD Mon YYYY') ");
//        query.append("     END ");
        query.append("  END cmply_expr_date ");
        query.append("  FROM std_ctry_chain sc ,PUB p ");
        query.append("  WHERE sc.std_id = ").append(stdId).append(" ");
        query.append("  AND sc.chain_cd = p.chain_cd");
            
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
        {
            query.append("   AND rgn_cd = '").append(regionCode).append("' ");
        }
        query.append(" ), ");
        query.append("STD_TOTAL AS ( ");
        query.append("  SELECT * FROM NEW_STD_RULE_EXPRY ");
        query.append("  UNION ");
        query.append("  SELECT * FROM PUB_STD_CMPLY_EXPRY ");
        query.append(") ");
        query.append("SELECT st.* FROM STD_TOTAL st, brndstnd_ctry bc ");
        query.append("WHERE st.ctry_nm_cd = bc.ctry_nm_cd ");
        query.append("AND bc.rgn_id != 1 ");
        query.append("ORDER BY bc.rgn_id, bc.ctry_nm_cd ");

        return query.toString();
    }
    
    public static String getStandardsCompliance(List<Long> stdIds, String stdType, String environment, String brandCd, 
            String regionCode, String fromDate, String toDate)
    {
        StringBuilder query = new StringBuilder();

        query.append("WITH ");
        query.append("PUB AS (SELECT p.publish_id, p.chain_cd, p.publish_dt FROM publish p WHERE p.chain_cd = '");
        query.append(brandCd).append("' AND p.publish_environment_nm = '").append(environment).append("' AND p.publish_stat_cd = 'ACTIVE'), ");
        
        if (BridgeConstants.BRIDGE_ENVIRONMENT.equals(environment))
        {
            query.append("PUB_STD AS (SELECT ps.std_id, p.chain_cd, p.publish_dt FROM bridge_publish ps, PUB p WHERE ps.publish_id = p.publish_id ");
            query.append("AND ps.unpublish_ind = 'N' ");
            if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
            {
                query.append("AND ps.rgn_id = (SELECT rgn_id FROM brndstnd_rgn WHERE rgn_cd='").append(regionCode).append("')");
            }
            query.append(" ), ");
        }
        else
        {
            query.append("PUB_STD AS (SELECT ps.std_id, p.chain_cd, p.publish_dt FROM publish_std ps, PUB p WHERE ps.publish_id = p.publish_id), ");
        }
        
        query.append("TAX AS (SELECT ROWNUM AS tax_sort, t.* ");
        query.append("  FROM (SELECT T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, T.TAXONOMY_DESC, (LEVEL - 1) AS TLEVEL, T.HIER_LVL_NBR, "); 
        query.append("  SUBSTR(SYS_CONNECT_BY_PATH(TITLE_TXT, ' &#8594; '), 31) AS PATH ");
        query.append("  FROM TAXONOMY T  START WITH T.TAXONOMY_ID = 1  CONNECT BY PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID  ORDER SIBLINGS BY T.HIER_LVL_NBR ) t ), ");
        query.append("ALL_PUB_CTRY_STD AS (SELECT s.std_id, s.prnt_std_id, scc.ctry_nm_cd, to_date(TO_CHAR(scc.cmply_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') AS cmply_dt, ");
        query.append("  to_date(to_char(scc.expr_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') AS expr_dt, ");
        query.append("  to_char(scc.cmply_dt, 'DD Mon YYYY') AS cmply_dt_str, ");
        query.append("  to_char(scc.expr_dt, 'DD Mon YYYY') AS expr_dt_str "); 
        query.append("  FROM std s, std_ctry_chain scc, PUB_STD ps ");
        query.append("  WHERE s.std_id = ps.std_id ");
        query.append("  AND s.std_id = scc.std_id ");
        query.append(" AND (scc.cmply_dt > ps.publish_dt OR scc.expr_dt > ps.publish_dt) ");
        query.append("  AND s.stat_desc != 'DELETED' ");
        query.append("  AND s.std_typ != 'GDLN' ");
            
        if (fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty())
        {
            query.append("AND scc.cmply_dt BETWEEN to_date('");
            query.append(fromDate);
            query.append("','DD MON YYYY') AND to_date('");
            query.append(toDate);
            query.append("','DD MON YYYY') ");
        }
        else if (fromDate != null && !fromDate.isEmpty())
        {
            query.append("AND scc.cmply_dt > to_date('");
            query.append(fromDate);
            query.append("','DD MON YYYY') ");
        }
        else if (toDate != null && !toDate.isEmpty())
        {
            query.append("AND scc.cmply_dt < to_date('");
            query.append(toDate);
            query.append("','DD MON YYYY') ");
        }
            
        query.append("  AND scc.chain_cd = ps.chain_cd ");
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
        {
            query.append("  AND scc.rgn_cd = '").append(regionCode).append("' ");
        }
        query.append(" ), ");
        
        if (BridgeConstants.BRIDGE_ENVIRONMENT.equals(environment)) {
        	query.append(" NEW_PUB_CTRY_STD AS (");
        	query.append(" 	SELECT std_id, prnt_std_id, cmply_dt, expr_dt, to_char(cmply_dt, 'DD Mon YYYY') AS cmply_dt_str, to_char(expr_dt, 'DD Mon YYYY') AS expr_dt_str FROM (");
        	query.append("    SELECT DISTINCT sc.std_id, apcs.prnt_std_id,");    
        	query.append("    	CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN");    
        	query.append("    		CASE WHEN sc.rule_dt_cd = 'R' THEN");     
        	query.append("    			CASE WHEN sc.cmply_rule_mo_qty > 0 THEN"); 
        	query.append("      			add_months(ps.publish_dt, NVL(sc.cmply_rule_mo_qty, 0))");   
        	query.append("    			END");    
        	query.append("   		ELSE");      
        	query.append("				CASE WHEN sc.cmply_expr_dt > ps.publish_dt THEN"); 
        	query.append("					to_date(to_char(sc.cmply_expr_dt, 'DD Mon YYYY'), 'DD-MON-YYYY')");
        	query.append("				END");
        	query.append("			END");
        	query.append("		END AS cmply_dt,");
        	query.append("		CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN CASE WHEN sc.cmply_expr_dt > ps.publish_dt THEN to_date(to_char(sc.cmply_expr_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') END END expr_dt");
        	query.append("		FROM PUB_STD ps, std_cmply sc, ALL_PUB_CTRY_STD apcs");  
        	query.append("		WHERE ps.std_id = sc.std_id AND ps.chain_cd = sc.chain_cd AND sc.std_id = apcs.std_id");   
        	query.append("		AND sc.ctry_nm_cd NOT IN (SELECT ctry_nm_cd	FROM ALL_PUB_CTRY_STD WHERE STD_ID=apcs.std_id)");
        	if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode)) {
        		query.append("		AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = (SELECT rgn_id FROM brndstnd_rgn WHERE rgn_cd = '").append(regionCode).append("'))");
        	}
        	query.append("	) WHERE cmply_dt IS NOT NULL OR expr_dt IS NOT NULL");
        	query.append(" ),");
        }
        
        query.append(" ALL_CTRY_STD AS (SELECT DISTINCT std_id, prnt_std_id, cmply_dt, expr_dt, cmply_dt_str, expr_dt_str FROM ALL_PUB_CTRY_STD");
        if (BridgeConstants.BRIDGE_ENVIRONMENT.equals(environment)) {
        	query.append(" UNION SELECT * FROM NEW_PUB_CTRY_STD");
        }
        query.append("), ");
        
        query.append("STAT_STD_CTRY AS ( ");
        query.append("  SELECT DISTINCT acs.std_id, acs.prnt_std_id, CASE WHEN acs.cmply_dt > p.publish_dt THEN acs.cmply_dt END cmply_dt, CASE WHEN acs.expr_dt > p.publish_dt THEN acs.expr_dt END expr_dt , ");
        query.append("  CASE WHEN acs.cmply_dt > p.publish_dt THEN decode(pc.cnt, 1, acs.expr_dt_str, 0, '', decode(acs.expr_dt_str, NULL, '', 'Per Country') ) END expr_dt_str, ");
        query.append("  CASE WHEN acs.cmply_dt > p.publish_dt THEN ");
        query.append("  decode(pc.cnt, 1, acs.cmply_dt_str, 0, '', decode(acs.cmply_dt_str, NULL, '', 'Per Country') ) END cmply_dt_str ");
        query.append("  FROM (SELECT std_id, count(std_id) cnt FROM ALL_CTRY_STD GROUP BY std_id) pc, ");
        query.append("  ALL_CTRY_STD acs, PUB p ");
        query.append("  WHERE acs.std_id = pc.std_id ");
        query.append("  AND (acs.cmply_dt > p.publish_dt OR acs.expr_dt > p.publish_dt) ");
        query.append(" ), ");
        query.append("ALL_STD_CMPLY_RULE_EXP AS ( ");
        query.append("  SELECT * FROM ( ");
        query.append("  SELECT DISTINCT sc.std_id, s.prnt_std_id, ");
        
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN "); 
        query.append("   CASE WHEN sc.rule_dt_cd = 'R' THEN "); 
        query.append("    CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
        query.append("     add_months(ps.publish_dt, NVL(sc.cmply_rule_mo_qty, 0)) "); 
        query.append("    END ");
        query.append("   ELSE "); 
        query.append("    CASE WHEN sc.cmply_expr_dt > ps.publish_dt THEN ");
        query.append("     sc.cmply_expr_dt "); 
        query.append("    END ");
        query.append("   END "); 
        query.append("  END cmply_dt,"); 
        
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN "); 
        query.append(" CASE WHEN sc.cmply_expr_dt > ps.publish_dt THEN  "); 
        query.append("     sc.cmply_expr_dt "); 
        query.append(" END END expr_dt, "); 
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
        query.append("   CASE WHEN sc.rule_dt_cd = 'R' THEN ");
        query.append("    CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
        query.append("     sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(ps.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') ");
        query.append("    END ");
        query.append("   ELSE ");
        query.append("    CASE WHEN sc.cmply_expr_dt > ps.publish_dt THEN ");
        query.append("     'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
        query.append("    END ");
        query.append("   END ");
        query.append("  END cmply_dt_str, ");
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN ");
        query.append(" CASE WHEN sc.cmply_expr_dt > ps.publish_dt THEN ");
        query.append("     'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
        query.append(" END END expr_dt_str ");
        query.append("  FROM std s, std_cmply sc, PUB_STD ps ");
        query.append("  WHERE sc.chain_cd = ps.chain_cd ");
        query.append("  AND sc.std_id = ps.std_id ");
        query.append("  AND s.std_id = sc.std_id ");
        query.append("  AND s.stat_desc != 'DELETED' "); 
        query.append("  AND s.std_typ != 'GDLN' ");
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
        {
            query.append("   AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id= (SELECT rgn_id FROM brndstnd_rgn WHERE rgn_cd='").append(regionCode).append("'))");
        }
        // TODO Validate whether compliance is in std_ctry_chain per country!!! 
        query.append("  AND sc.std_id NOT IN (SELECT std_id FROM ALL_CTRY_STD) ");
        query.append("  AND sc.std_id NOT IN (SELECT scc.STD_ID FROM  std s, std_ctry_chain scc, PUB_STD ps");   
        query.append(" 		WHERE s.std_id = ps.std_id   AND s.std_id = scc.std_id");
        query.append("  	AND s.stat_desc != 'DELETED'   AND s.std_typ != 'GDLN'");  
        query.append("  	AND scc.chain_cd = ps.chain_cd   ");
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode)){
        	query.append("  AND scc.rgn_cd = '").append(regionCode).append("'");
        }
        query.append(")");
        query.append("  ) WHERE (cmply_dt IS NOT NULL AND expr_dt IS NULL) OR ");
        query.append("  (cmply_dt IS NULL AND expr_dt IS NOT NULL) OR (cmply_dt IS NOT NULL AND expr_dt IS NOT NULL) ), ");
        
        query.append("STD_CMPLY_RULE_EXP AS ( ");
        query.append("  SELECT DISTINCT sc.std_id, sc.prnt_std_id, sc.cmply_dt, sc.expr_dt, "); 
        query.append("  decode(pc.cnt, 1, sc.expr_dt_str, 0, '', decode(sc.expr_dt_str, NULL, '', 'Per Country') ) expr_dt_str, ");
        query.append("  decode(pc.cnt, 1, sc.cmply_dt_str, 0, '', decode(sc.cmply_dt_str, NULL, '', 'Per Country') ) cmply_dt_str ");
        query.append("  FROM (SELECT std_id, count(std_id) cnt FROM ALL_STD_CMPLY_RULE_EXP GROUP BY std_id) pc, ");
        query.append("  ALL_STD_CMPLY_RULE_EXP sc ");
        query.append("  WHERE sc.std_id = pc.std_id ");
        
        if (fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty())
        {
            query.append("AND (sc.cmply_dt BETWEEN to_date('").append(fromDate).append("','DD MON YYYY') AND to_date('").append(toDate).append("','DD MON YYYY') OR ");
            query.append(" sc.expr_dt BETWEEN to_date('").append(fromDate).append("','DD MON YYYY') AND to_date('").append(toDate).append("','DD MON YYYY') ) ");
        }
        else if (fromDate != null && !fromDate.isEmpty())
        {
            query.append("AND (sc.cmply_dt > to_date('").append(fromDate).append("','DD MON YYYY') OR ");
            query.append(" sc.expr_dt > to_date('").append(fromDate).append("','DD MON YYYY') ) ");
        }
        else if (toDate != null && !toDate.isEmpty())
        {
            query.append("AND (sc.cmply_dt < to_date('").append(toDate).append("','DD MON YYYY') OR ");
            query.append(" sc.expr_dt < to_date('").append(toDate).append("','DD MON YYYY') ) ");
        }
        query.append(" ), ");
        
        query.append("CMPLY_DATE AS ( ");
        query.append("  SELECT std_id, prnt_std_id, cmply_dt, expr_dt, cmply_dt_str, expr_dt_str FROM STAT_STD_CTRY "); 
        query.append("  UNION ");
        query.append("  SELECT std_id, prnt_std_id, cmply_dt, expr_dt, cmply_dt_str, expr_dt_str FROM STD_CMPLY_RULE_EXP ), ");
        query.append("MISSING_STD AS ( ");
        query.append("  SELECT DISTINCT s.prnt_std_id AS std_id ");
        query.append("  FROM ALL_CTRY_STD s, CMPLY_DATE sc ");
        query.append("  WHERE s.std_id = sc.std_id OR s.std_id = sc.prnt_std_id ");
        query.append("  UNION ");
        query.append("  SELECT DISTINCT s.std_id FROM PUB_STD s, CMPLY_DATE cd ");
        query.append("  WHERE s.std_id = cd.std_id OR s.std_id = cd.prnt_std_id ");
        query.append(") ");
        query.append("SELECT DISTINCT s.std_id, s.prnt_std_id, s.std_typ, s.title_txt, s.std_desc, s.area_catgy_cd, ");
        query.append("s.gbl_rgn_ind, s.rgn_cd, s.framework_std_ind, "); 
        
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
        {
            query.append("nvl((SELECT disp_order_nbr FROM std_display_order WHERE std_id = s.std_id AND chain_cd = '");
            query.append(brandCd).append("' AND rgn_cd = '").append(regionCode).append("'), 0) AS disp_order_nbr, ");
        }
        else 
        {
            query.append("0 AS disp_order_nbr, ");
        }
        query.append("sc.cmply_dt, sc.expr_dt, sc.cmply_dt_str, sc.expr_dt_str, ");
        query.append("t.taxonomy_id, t.prnt_taxonomy_id, t.tax_sort AS index_order, t.title_txt AS index_title, ");
        query.append("t.tlevel AS lvl, t.path, t.hier_lvl_nbr, t.taxonomy_desc ");
        
        query.append("FROM std s, TAXONOMY_STD TS, TAX t, CMPLY_DATE sc, MISSING_STD ms ");
        query.append("WHERE TS.taxonomy_id = t.taxonomy_id ");
        query.append("AND TS.STD_ID = S.PRNT_STD_ID ");
        query.append("AND s.std_typ != 'GDLN' ");
        query.append("AND s.std_id = sc.std_id(+) ");
        query.append("AND (s.std_id = ms.std_id OR s.prnt_std_id = ms.std_id) ");
        query.append("AND s.stat_desc != 'DELETED' ");
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode))
        {
            query.append("  AND s.rgn_cd IN ('GLBL', '").append(regionCode).append("') ");
        }
        
        if (stdIds != null && !stdIds.isEmpty())
        {
            boolean addComma = false;
            StringBuilder stdIdLst = new StringBuilder();
            for (long id : stdIds)
            {
                if(addComma)
                {
                    stdIdLst.append(StringPool.COMMA);
                }
                addComma = true;
                stdIdLst.append(id);
            }
            
            query.append("AND s.prnt_std_id IN (");
            query.append("SELECT prnt_std_id FROM std WHERE std_id IN (");
            query.append(stdIdLst.toString());
            query.append(")) ");
        }
        
        query.append(" AND S.STD_ID IN (SELECT CS.STD_ID FROM CHAIN_STD CS, STAT ST WHERE CS.STD_ID IN (S.STD_ID)  AND CS.STAT_ID = ST.STAT_ID AND CS.CHAIN_CD = '").append(brandCd);
        query.append("' AND CS.ACTV_IND = 'Y' AND ST.STAT_CD NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        query.append(" AND S.STD_ID IN (SELECT DISTINCT CS.STD_ID FROM CTRY_STD CS WHERE STD_ID IN (S.STD_ID)");
        if (regionCode != null && !regionCode.isEmpty() && !"GLBL".equals(regionCode)) {
        	query.append(" AND CS.CTRY_NM_CD IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID=(SELECT rgn_id FROM brndstnd_rgn WHERE rgn_cd='").append(regionCode).append("'))");
        }
        query.append("))");
        
        return query.toString();
    }

    public static String getAddByImportProcedure(){
    	StringBuffer query = new StringBuffer();
    	query.append("DECLARE"); 
    	query.append("  l_publish_id NUMBER := ?;"); 
    	query.append("  l_rgn_id NUMBER := ?;");
    	query.append("  l_chain_cd VARCHAR2(2) := ?;");
    	query.append("  l_usr_id VARCHAR(50) := ?;"); 
    	query.append("  l_std_ids CLOB := ?;");
    	query.append("  l_cur SYS_REFCURSOR;");
    	query.append("  l_std_id NUMBER;"); 
    	query.append("  l_std_id_tbl number_table;");
    	query.append("  l_missing_cur SYS_REFCURSOR;");
    	query.append("  l_missing_std_id_tbl number_table := number_table();");
    	query.append("  l_orphan_cur SYS_REFCURSOR;");
    	query.append("  l_orphan_std_id_tbl number_table := number_table();");
    	query.append("  l_disc_cur_std_id_tbl number_table := number_table();");
    	query.append("  l_id_indx INTEGER;");
    	query.append("  l_std_id_indx INTEGER;");
    	query.append("  l_cnt NUMBER;");
    	query.append("  l_added_std_id_tbl number_table := number_table();");
    	query.append("  l_added_id_indx INTEGER := 1;");
    	query.append("  l_stat_default VARCHAR2(10) := NULL;");

    	query.append("  l_sql VARCHAR2(300) := ");
    	query.append("  	'INSERT INTO bridge_publish_import(bridge_publication_import_id, publish_id, std_id, selection_id, rgn_id, vld_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts)' ||"); 
    	query.append("  	'VALUES(:brPubImpId, :pubId, :stdId, :selId, :rgnId, :statCd, :crUsr, :crTs, :lstUpdUsr, :lstUpdTs)';");
    	query.append("  l_miss_sql      VARCHAR2(500)   := 'INSERT INTO bridge_publish_import(bridge_publication_import_id, publish_id, std_id, selection_id, rgn_id, vld_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts)'"); 
    	query.append("  	|| 'SELECT :brPubImpId, :pubId, :stdId, :selId, :rgnId, :statCd, :crUsr, :crTs, :lstUpdUsr, :lstUpdTs FROM DUAL '");
    	query.append("  	|| ' WHERE NOT EXISTS (SELECT bridge_publication_import_id FROM BRIDGE_PUBLISH_IMPORT WHERE publish_id=:pubId AND STD_ID=:stdId AND RGN_ID=:rgnId)';");

    	query.append(" 	BEGIN"); 
    	query.append("    l_std_id_tbl := brandstandardspublish.delimclob_to_num_table(l_std_ids);");
    	    
    		//######## MISSING records 
    	query.append("    l_id_indx := 1;");
    	query.append("    l_std_id_indx := l_std_id_tbl.COUNT + 1;");
    	query.append("    OPEN l_missing_cur FOR"); 
    	query.append("        SELECT s.std_id");
    	query.append("        FROM std s");
    	query.append("        WHERE s.stat_desc != 'DELETED'");
    	query.append("        AND s.std_id IN (SELECT prnt_std_id FROM std WHERE std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl)))");
    	query.append("        AND s.std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
    	query.append("    LOOP");
    	query.append("        FETCH l_missing_cur INTO l_std_id;");
    	query.append("        EXIT WHEN l_missing_cur%NOTFOUND;");
    	query.append("        l_missing_std_id_tbl.extend;");
    	query.append("        l_missing_std_id_tbl(l_id_indx) := l_std_id;");
    	query.append("        l_id_indx := l_id_indx + 1;");
    	        
    	query.append("        l_std_id_tbl.EXTEND;");
    	query.append("        l_std_id_tbl(l_std_id_indx) := l_std_id;");
    	query.append("        l_std_id_indx := l_std_id_indx + 1;");
    	query.append("    END LOOP;");
    	query.append("    IF l_missing_cur IS NOT NULL THEN");
    	query.append("        CLOSE l_missing_cur;");
    	query.append("    END IF;");
    	    
    		//######### ORPHAN 
    	query.append("    IF l_missing_std_id_tbl.COUNT > 0 THEN");
    	query.append("        l_id_indx := 1;");
    	query.append("        OPEN l_orphan_cur FOR");
    	query.append("            SELECT s.std_id");
    	query.append("            FROM std s");
    	query.append("            WHERE s.prnt_std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_missing_std_id_tbl))");
    	query.append("            AND s.std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
    	query.append("        LOOP");
    	query.append("            FETCH l_orphan_cur INTO l_std_id;");
    	query.append("            EXIT WHEN l_orphan_cur%NOTFOUND;");
    	query.append("            l_orphan_std_id_tbl.extend;");
    	query.append("            l_orphan_std_id_tbl(l_id_indx) := l_std_id;");
    	query.append("            l_id_indx := l_id_indx + 1;");
    	query.append("        END LOOP;");
    	query.append("        IF l_orphan_cur IS NOT NULL THEN");
    	query.append("            CLOSE l_orphan_cur;");
    	query.append("        END IF;");
    	query.append("    END IF;");
    	
    		//###### NOTBRND 'N' +++
    	query.append("    OPEN l_cur FOR");  
    	query.append("        SELECT std_id"); 
    	query.append("        FROM std");
    	query.append("       WHERE std_id NOT IN (");
    	query.append("            SELECT s.std_id");
    	query.append("            FROM std s, chain_std cs");
    	query.append("            WHERE s.std_id = cs.std_id");
    	query.append("            AND cs.chain_cd = l_chain_cd");
    	query.append("            AND cs.actv_ind = 'Y'");
    	query.append("            AND s.stat_desc != 'DELETED'");
    	query.append("            AND s.std_id IN (SELECT COLUMN_VALUE AS std_id FROM TABLE(l_std_id_tbl)))");
    	query.append("        AND std_id IN (SELECT COLUMN_VALUE AS std_id FROM TABLE(l_std_id_tbl));");
    	query.append("    LOOP");
    	query.append("    FETCH l_cur INTO l_std_id;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("        EXECUTE IMMEDIATE l_sql"); 
    	query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'NOTBRND', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 

    	query.append("        l_added_std_id_tbl.extend;");
    	query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("        l_added_id_indx := l_added_id_indx + 1;");
    	query.append("    END LOOP;"); 
    	query.append("    IF l_cur IS NOT NULL THEN"); 
    	query.append("        CLOSE l_cur;"); 
    	query.append("    END IF;"); 
    	 
    		//######## NOTRGN 'N' 
    	query.append("    OPEN l_cur FOR");  
    	query.append("        SELECT s.std_id");
    	query.append("        FROM std s");
    	query.append("        WHERE s.std_id NOT IN"); 
    	query.append("            (SELECT DISTINCT std_id"); 
    	query.append("            FROM ctry_std"); 
    	query.append("            WHERE std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl))");    
    	query.append("            AND ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = l_rgn_id)");
    	query.append("            UNION");
    	query.append("            SELECT COLUMN_VALUE AS std_id FROM TABLE(l_added_std_id_tbl)");
    	query.append("            )");
    	query.append("        AND s.stat_desc != 'DELETED'");
    	query.append("        AND s.std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
    	query.append("    LOOP"); 
    	query.append("    FETCH l_cur INTO l_std_id;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("        EXECUTE IMMEDIATE l_sql"); 
    	query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'NOTRGN', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 

    	query.append("        l_added_std_id_tbl.EXTEND;");
    	query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("        l_added_id_indx := l_added_id_indx + 1;");
    	query.append("    END LOOP;"); 
    	query.append("    IF l_cur IS NOT NULL THEN"); 
    	query.append("        CLOSE l_cur;"); 
    	query.append("    END IF;"); 
    	
    		//######## GLOBAL MUST NOT INCLUDED TO REGION COUNTRIES - INSERT AS NOTRGN 'N'
    	query.append("    OPEN l_cur FOR"); 
    	query.append("    SELECT s.std_id, gbl_notrgn_cnt.CNT FROM std s,");
    	query.append("      (SELECT bgp.STD_ID, NVL(global_not_rgn.CNT, 0) CNT");
    	query.append("        FROM bridge_gbl_publish bgp, (");
    	query.append("          SELECT bp.STD_ID, count (bpc.ctry_nm_cd) AS CNT FROM bridge_gbl_publish bp, bridge_gbl_publish_ctry bpc"); 
    	query.append("          WHERE bp.bridge_gbl_publish_id=bpc.bridge_gbl_publish_id"); 
    	query.append("          AND bp.publish_id = l_publish_id"); 
    	query.append("          AND bp.must_publish_ind = 'Y'"); 
    	query.append("          AND bpc.publish_ind='Y'");
    	query.append("          AND bpc.ctry_nm_cd IN (SELECT CTRY_NM_CD FROM BRNDSTND_CTRY WHERE RGN_ID=l_rgn_id)");
    	query.append("          AND bp.std_id=std_id");
    	query.append("          GROUP BY bp.STD_ID");
    	query.append("        ) global_not_rgn");
    	query.append("        WHERE bgp.publish_id = l_publish_id AND bgp.must_publish_ind = 'Y' AND bgp.STD_ID IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl))");
    	query.append("        AND bgp.STD_ID=global_not_rgn.STD_ID(+)");
    	query.append("    ) gbl_notrgn_cnt  WHERE s.std_id=gbl_notrgn_cnt.STD_ID AND s.stat_desc != 'DELETED'"); 
    	query.append("    AND s.std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl))");
    	query.append("    AND s.std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
        
    	query.append("    LOOP");
    	query.append("      FETCH l_cur INTO l_std_id, l_cnt;");
    	query.append("    EXIT WHEN l_cur%NOTFOUND;");
    	query.append("    IF l_cnt = 0 THEN");
    	query.append("      EXECUTE IMMEDIATE l_sql USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval,");
    	query.append("      l_publish_id, l_std_id, 'N', l_rgn_id, 'NOTRGN', l_usr_id, SYSDATE, l_usr_id, SYSDATE; l_added_std_id_tbl.EXTEND;");
    	query.append("      l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("      l_added_id_indx                     := l_added_id_indx + 1;");
    	query.append("    END IF;");
    	query.append("    END LOOP;");
    	query.append("    IF l_cur IS NOT NULL THEN");
    	query.append("      CLOSE l_cur;");
    	query.append("    END IF;");
    	 
    		//########## GLBLMSTNOT 'N'
    	query.append("    OPEN l_cur FOR");  
    	query.append("        SELECT std_id"); 
    	query.append("        FROM std");  
    	query.append("        WHERE rgn_cd = 'GLBL'");
    	query.append("        AND stat_desc != 'DELETED'");
    	query.append("        AND std_id IN (");
    	query.append("            SELECT std_id");
    	query.append("            FROM bridge_gbl_publish");
    	query.append("            WHERE publish_id = l_publish_id");
    	query.append("            AND must_publish_ind = 'N'");
    	query.append("        )");
    	query.append("        AND std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl))");
    	query.append("        AND std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
    	query.append("    LOOP"); 
    	query.append("    FETCH l_cur INTO l_std_id;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("        EXECUTE IMMEDIATE l_sql"); 
    	query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'GLBLMSTNOT', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 

    	query.append("        l_added_std_id_tbl.EXTEND;");
    	query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("        l_added_id_indx := l_added_id_indx + 1;");
    	query.append("    END LOOP;"); 
    	query.append("    IF l_cur IS NOT NULL THEN"); 
    	query.append("        CLOSE l_cur;"); 
    	query.append("    END IF;"); 
    	
    		//######### GNOTINMUST 'N'
    	query.append("    OPEN l_cur FOR");  
    	query.append("        SELECT std_id"); 
    	query.append("        FROM std");  
    	query.append("        WHERE rgn_cd = 'GLBL'");
    	query.append("        AND stat_desc  != 'DELETED'");
    	query.append("        AND std_id NOT IN (");
    	query.append("            SELECT std_id");
    	query.append("            FROM bridge_gbl_publish");
    	query.append("            WHERE publish_id = l_publish_id");
    	query.append("            AND must_publish_ind = 'Y'");
    	query.append("            UNION");
    	query.append("            SELECT COLUMN_VALUE AS std_id FROM TABLE(l_added_std_id_tbl)");
    	query.append("        )");
    	query.append("        AND std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
    	query.append("    LOOP"); 
    	query.append("    FETCH l_cur INTO l_std_id;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("        EXECUTE IMMEDIATE l_sql"); 
    	query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'GNOTINMUST', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 

    	query.append("        l_added_std_id_tbl.EXTEND;");
    	query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("        l_added_id_indx := l_added_id_indx + 1;");
    	query.append("    END LOOP;"); 
    	query.append("    IF l_cur IS NOT NULL THEN"); 
    	query.append("        CLOSE l_cur;"); 
    	query.append("    END IF;");

		    //########## DISCONT 'N'
    	query.append("    l_id_indx := 1;");
		query.append("    OPEN l_cur FOR");  
		query.append("        SELECT s.std_id"); 
		query.append("        FROM std s, chain_std cs, stat st");
		query.append("        WHERE s.stat_desc != 'DELETED'");
		query.append("        AND cs.chain_cd = l_chain_cd");
		query.append("        AND s.std_id = cs.std_id"); 
		query.append("        AND cs.stat_id = st.stat_id");
		query.append("        AND cs.actv_ind = 'Y'");
		query.append("        AND st.STAT_CD IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
		query.append("        AND s.std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl))");
		query.append("        AND s.std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
		query.append("    LOOP"); 
		query.append("    FETCH l_cur INTO l_std_id;"); 
		query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
		query.append("        EXECUTE IMMEDIATE l_sql"); 
		query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'DISCONT', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 
	
		query.append("        l_added_std_id_tbl.EXTEND;");
		query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
		query.append("        l_added_id_indx := l_added_id_indx + 1;");
		query.append("        l_disc_cur_std_id_tbl.EXTEND;");
		query.append("        l_disc_cur_std_id_tbl(l_id_indx) := l_std_id;");
		query.append("        l_id_indx := l_id_indx + 1;");
		query.append("    END LOOP;"); 
		query.append("    IF l_cur IS NOT NULL THEN"); 
		query.append("        CLOSE l_cur;"); 
		query.append("    END IF;");

	    //######## All Discontinued By Parent insert with 'N' (If Parent id Discontinued then all specification & guidelines will also be discontinued)
		query.append("    IF l_disc_cur_std_id_tbl.COUNT > 0 THEN");
		query.append("        OPEN l_cur FOR");  
		query.append("            SELECT std_id"); 
		query.append("            FROM std");  
		query.append("            WHERE stat_desc != 'DELETED'");
		query.append("            AND  prnt_std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_disc_cur_std_id_tbl))");
		query.append("            AND  std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl))");
		query.append("            AND std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl));"); 
		query.append("        LOOP"); 
		query.append("            FETCH l_cur INTO l_std_id;"); 
		query.append("            EXIT WHEN l_cur%NOTFOUND;"); 
		        
		query.append("            EXECUTE IMMEDIATE l_sql"); 
		query.append("            USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'DISCONT', l_usr_id, SYSDATE, l_usr_id, SYSDATE;");
		query.append("        	  l_added_std_id_tbl.EXTEND;");
		query.append("            l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
		query.append("            l_added_id_indx := l_added_id_indx + 1;");
		query.append("        END LOOP;"); 
		query.append("        IF l_cur IS NOT NULL THEN"); 
		query.append("            CLOSE l_cur;"); 
		query.append("        END IF;"); 
		query.append("    END IF;");
    	
    	    ///########### GLBLMST 'Y'
    	query.append("    OPEN l_cur FOR");  
    	query.append("        SELECT std_id"); 
    	query.append("        FROM std");  
    	query.append("        WHERE stat_desc != 'DELETED'");
    	query.append("        AND std_id IN (");
    	query.append("            SELECT std_id");
    	query.append("            FROM bridge_gbl_publish");
    	query.append("            WHERE publish_id = l_publish_id");
    	query.append("            AND must_publish_ind = 'Y'");
    	query.append("        )");
    	query.append("        AND std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl))");
    	query.append("        AND std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
    	query.append("    LOOP"); 
    	query.append("    FETCH l_cur INTO l_std_id;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("        EXECUTE IMMEDIATE l_sql"); 
    	query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'Y', l_rgn_id, 'GLBLMST', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 
    	    
    	query.append("        l_added_std_id_tbl.EXTEND;");
    	query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("        l_added_id_indx := l_added_id_indx + 1;");
    	query.append("    END LOOP;"); 
    	query.append("    IF l_cur IS NOT NULL THEN"); 
    	query.append("        CLOSE l_cur;"); 
    	query.append("    END IF;");  

		    //########### UNPUBLISH 'Y'
		query.append("    OPEN l_cur FOR");  
		query.append("        SELECT std_id"); 
		query.append("        FROM std");  
		query.append("        WHERE stat_desc != 'DELETED'");
		query.append("        AND std_id IN (");
		query.append("            SELECT std_id");
		query.append("            FROM bridge_publish");
		query.append("            WHERE publish_id = l_publish_id");
		query.append("            AND rgn_id = l_rgn_id");
		query.append("            AND unpublish_ind = 'Y'");
		query.append("        )");
		query.append("        AND std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl))");
		query.append("        AND std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));");
		query.append("    LOOP"); 
		query.append("    FETCH l_cur INTO l_std_id;"); 
		query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
		query.append("        EXECUTE IMMEDIATE l_sql"); 
		query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'Y', l_rgn_id, 'UNPUBLISH', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 
	
		query.append("        l_added_std_id_tbl.EXTEND;");
		query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
		query.append("        l_added_id_indx := l_added_id_indx + 1;");
		query.append("    END LOOP;"); 
		query.append("    IF l_cur IS NOT NULL THEN"); 
		query.append("        CLOSE l_cur;"); 
		query.append("    END IF;");

    	    //########## DEFAULT ALL GOOD 'Y'
    	query.append("    OPEN l_cur FOR");  
    	query.append("    SELECT std_id"); 
    	query.append("    FROM std"); 
    	query.append("    WHERE stat_desc != 'DELETED'");
    	query.append("    AND std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl))");
    	query.append("    AND std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_std_id_tbl));"); 
    	query.append("    LOOP"); 
    	query.append("    FETCH l_cur INTO l_std_id;"); 
    	query.append("    EXIT WHEN l_cur%NOTFOUND;"); 
    	query.append("        EXECUTE IMMEDIATE l_sql"); 
    	query.append("        USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'Y', l_rgn_id, l_stat_default, l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 

    	query.append("        l_added_std_id_tbl.EXTEND;");
    	query.append("        l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("        l_added_id_indx := l_added_id_indx + 1;");
    	query.append("    END LOOP;"); 
    	query.append("    IF l_cur IS NOT NULL THEN"); 
    	query.append("        CLOSE l_cur;"); 
    	query.append("    END IF;"); 
    	    
    	    //########## MISSING what left
    	query.append("    IF l_missing_std_id_tbl.COUNT > 0 THEN");
    	query.append("        FOR i IN l_missing_std_id_tbl.FIRST..l_missing_std_id_tbl.LAST LOOP");
    	query.append("            l_std_id := l_missing_std_id_tbl(i);");
    	query.append("            EXECUTE IMMEDIATE l_miss_sql"); 
    	query.append("            USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_missing_std_id_tbl(i), 'N', l_rgn_id, 'MISSING', l_usr_id, SYSDATE, l_usr_id, SYSDATE, l_publish_id,  l_missing_std_id_tbl(i), l_rgn_id;"); 

    	query.append("            l_added_std_id_tbl.EXTEND;");
    	query.append("            l_added_std_id_tbl(l_added_id_indx) := l_std_id;");
    	query.append("            l_added_id_indx := l_added_id_indx + 1;");
    	query.append("        END LOOP;");
    	query.append("    END IF;");

    	    //######## ORPHAN 'N'
    	query.append("    IF l_orphan_std_id_tbl.COUNT > 0 THEN");
    	query.append("        OPEN l_cur FOR");  
    	query.append("            SELECT std_id"); 
    	query.append("            FROM std");  
    	query.append("            WHERE stat_desc != 'DELETED'");
    	query.append("            AND  std_id IN (SELECT COLUMN_VALUE FROM TABLE(l_orphan_std_id_tbl))");
    	query.append("            AND std_id NOT IN (SELECT COLUMN_VALUE FROM TABLE(l_added_std_id_tbl));"); 
    	query.append("        LOOP"); 
    	query.append("            FETCH l_cur INTO l_std_id;"); 
    	query.append("            EXIT WHEN l_cur%NOTFOUND;"); 
    	        
    	query.append("            EXECUTE IMMEDIATE l_sql"); 
    	query.append("            USING BRIDGE_PUB_IMPORT_ID_SEQ.nextval, l_publish_id, l_std_id, 'N', l_rgn_id, 'ORPHAN', l_usr_id, SYSDATE, l_usr_id, SYSDATE;"); 
    	query.append("        END LOOP;"); 
    	query.append("        IF l_cur IS NOT NULL THEN"); 
    	query.append("            CLOSE l_cur;"); 
    	query.append("        END IF;"); 
    	query.append("    END IF;");
    	
    	query.append("  COMMIT;");
    	query.append(" END;");	
    	
    	return query.toString();
    }

    public static String getAddByImportIssuesCount(long publishId, long regionId, String vldStatusExclude){
    	
	    StringBuffer issueCountQuery  = new StringBuffer("SELECT COUNT(BRIDGE_PUBLICATION_IMPORT_ID) AS ISSUE_COUNT FROM BRIDGE_PUBLISH_IMPORT WHERE PUBLISH_ID=");
		issueCountQuery.append(publishId);
		issueCountQuery.append(" AND RGN_ID=");
		issueCountQuery.append(regionId);
		issueCountQuery.append(" AND VLD_STAT_CD NOT IN (");
		int counter = 0;
		for(String excludeStatus : vldStatusExclude.split(StringPool.COMMA)){
			if(counter > 0){
				issueCountQuery.append(StringPool.COMMA);
			}
			issueCountQuery.append("'");
			issueCountQuery.append(excludeStatus);
			issueCountQuery.append("'");
			counter++;
		}
		issueCountQuery.append(")");
		
		return issueCountQuery.toString();
    }

    public static String getResetPublicationQuery(long bridgePublishId, long regionId, String chainCode, String userScreenName){
    	StringBuilder sql = new StringBuilder();
    	sql.append("DECLARE");
    	sql.append("  l_chain_cd VARCHAR2(5) := '").append(chainCode).append("';");
    	sql.append("  l_bridge_pidlish_id NUMBER := ").append(bridgePublishId).append(";");
    	sql.append("  l_rgn_id NUMBER := ").append(regionId).append(";");
    	sql.append("  l_usr_id VARCHAR2(50) := '").append(userScreenName).append("';");
    	sql.append("  l_last_publish_id NUMBER;");
    	sql.append("  l_cur SYS_REFCURSOR;");
    	sql.append("  l_std_id NUMBER;");
    	sql.append("  l_unpublish_ind VARCHAR2(1) := 'Y';");
    	sql.append("  l_ins_sql VARCHAR2(500) := 'INSERT INTO bridge_publish(bridge_publish_id, publish_id, std_id, rgn_id, unpublish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts)' || ");
    	sql.append("  	' VALUES(:bridgePubId, :pubId, :stdId, :rgnId, :unpubInd, :crUsrId, :crTs, :lstUpdtUsrId, :lstUpdtTs)';");
    	
    	sql.append("BEGIN");
    	sql.append("  DELETE bridge_publish_ctry WHERE bridge_publish_ctry_id IN (SELECT bpc.bridge_publish_ctry_id FROM bridge_publish bp, bridge_publish_ctry bpc");
    	sql.append("    WHERE bp.bridge_publish_id = bpc.bridge_publish_id AND bp.publish_id = l_bridge_pidlish_id AND bp.rgn_id = l_rgn_id);");
    	sql.append("  DELETE bridge_publish_import WHERE publish_id=l_bridge_pidlish_id AND rgn_id=l_rgn_id;");
    	sql.append("  DELETE bridge_publish_lang WHERE publish_id=l_bridge_pidlish_id AND rgn_id=l_rgn_id;");
    	sql.append("  DELETE bridge_publish WHERE publish_id=l_bridge_pidlish_id AND rgn_id=l_rgn_id;");
    	sql.append("  COMMIT;");
    	
    	sql.append("  l_last_publish_id := brandstandardspublish.getLatestPublishedId(l_chain_cd);");
    	sql.append("  IF l_last_publish_id > 0 THEN");
    	sql.append("    OPEN l_cur FOR");
    	sql.append("        SELECT s.std_id FROM std s, chain_std cs, stat st WHERE s.std_id = cs.std_id AND cs.stat_id = st.stat_id");
    	sql.append("        AND cs.chain_cd = l_chain_cd AND st.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD')");
    	sql.append("        AND s.std_id IN ( SELECT std_id FROM (");
    	sql.append("		SELECT distinct s.std_id FROM publish_std s, publish_ctry_std cs WHERE s.PUBLISH_STD_VER_ID=cs.PUBLISH_STD_VER_ID");
    	sql.append("		AND s.publish_id=l_last_publish_id AND cs.CTRY_NM_CD IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = l_rgn_id) order by std_id)");
    	sql.append("		MINUS SELECT std_id FROM (SELECT DISTINCT std_id FROM bridge_publish WHERE publish_id = l_bridge_pidlish_id AND rgn_id = l_rgn_id ORDER BY std_id));");
    	sql.append("    LOOP");
    	sql.append("    FETCH l_cur INTO l_std_id;");
    	sql.append("    EXIT WHEN l_cur%NOTFOUND;");
    	sql.append("        EXECUTE IMMEDIATE l_ins_sql");
    	sql.append("        USING bridge_publish_id_seq.nextval, l_bridge_pidlish_id, l_std_id, l_rgn_id, l_unpublish_ind, l_usr_id, SYSDATE, l_usr_id, SYSDATE;");
    	sql.append("    END LOOP;");
    	sql.append("    IF l_cur IS NOT NULL THEN");
    	sql.append("      CLOSE l_cur;");
    	sql.append("    END IF;");
    	sql.append("  END IF;");
    	sql.append("  COMMIT;");
    	
    	sql.append("END;");
    	
    	return sql.toString();
    }

    public static String getUpdateGlobalRegionalStdCountriesQuery(long publishId, long stdId, long cmsRegionId, String userScreenName)
    {
        StringBuilder sql = new StringBuilder();
        sql.append("DECLARE");
        sql.append("  l_publish_id NUMBER := ").append(publishId).append(";");
        sql.append("  l_std_id NUMBER :=  ").append(stdId).append(";");
        sql.append("  l_cms_rgn_id NUMBER :=  ").append(cmsRegionId).append(";");
        sql.append("  l_user_id VARCHAR2(50) := '").append(userScreenName).append("';");
        sql.append("  CURSOR l_cur IS");
//      -- update countries for records in My Publication. Unpublish records do not have countries
        sql.append("  SELECT bridge_publish_id, rgn_id FROM bridge_publish WHERE publish_id = l_publish_id AND unpublish_ind = 'N' AND std_id = l_std_id;");
        sql.append("  l_pub_ind VARCHAR2(1) := 'Y';");
        sql.append("  l_chain_cd VARCHAR2(5);");
        sql.append("  l_rgn_id NUMBER;");
        sql.append("  l_bridge_gbl_publish_id NUMBER;");
        sql.append("  l_prod_publish_id NUMBER;");
        sql.append("  l_ctry_cd VARCHAR2(3);");
        sql.append("  l_ctry_nm VARCHAR2(100);");
        sql.append("  l_stat_cd VARCHAR2(20);");
        sql.append("  l_ctry_cur SYS_REFCURSOR;");
        sql.append("  l_cur_br_pub_type VARCHAR2(20);");
        sql.append("  l_std_mnl_type VARCHAR2(25);");
        sql.append("  l_build_pub_cnt NUMBER;");
        sql.append("  l_prod_pub_cnt NUMBER;");
        sql.append("  l_glbl_new_ctry VARCHAR2(2000) := NULL;");
        sql.append("  l_glbl_rm_ctry VARCHAR2(2000) := NULL;");
        sql.append("  l_rgn_new_ctry VARCHAR2(2000) := NULL;");
        sql.append("  l_rgn_rm_ctry VARCHAR2(2000) := NULL;");
        sql.append("  l_err_title VARCHAR2(500) := 'Country Changes';");
        sql.append("  l_err_desc VARCHAR2(4000);");
        sql.append("  l_cnt NUMBER;");

        sql.append("  l_gbl_new_ctry_sql VARCHAR2(600) :=");
        sql.append("  'SELECT ctry_nm_cd, NVL((SELECT uex.elem_val FROM ui_elem ue, ui_elem_xlat uex ' || ");
        sql.append("  'WHERE ue.ui_elem_key = (''bs.country.name.cd.'' || lower(ctry_nm_cd)) ' || ");
        sql.append("  'AND ue.ui_elem_id = uex.ui_elem_id AND uex.locale_cd = ''en_GB''), ctry_nm_cd) ctry_nm FROM ( ' || ");
        sql.append("  'SELECT cs.ctry_nm_cd FROM std s, ctry_std cs WHERE s.std_id = cs.std_id AND s.std_id = :stdId ' || ");
        sql.append("  'MINUS ' || ");
        sql.append("  'SELECT bc.ctry_nm_cd FROM bridge_gbl_publish_ctry bc WHERE bridge_gbl_publish_id = ' || ");
        sql.append("  '(SELECT bridge_gbl_publish_id FROM bridge_gbl_publish WHERE publish_id = :pubId AND std_id = :stdId) )';");
        sql.append("  l_gbl_ins_ctry_sql VARCHAR2(300) := ");
        sql.append("  'INSERT INTO bridge_gbl_publish_ctry(bridge_gbl_publish_ctry_id, bridge_gbl_publish_id, ctry_nm_cd, publish_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        sql.append("  'VALUES(:id, :brgGblId, :ctryCd, :pubInd, :usrId, :ts, :usrId, :ts)';");
        sql.append("  l_gbl_rm_ctry_sql VARCHAR2(600) :=");
        sql.append("  'SELECT ctry_nm_cd, NVL((SELECT uex.elem_val FROM ui_elem ue, ui_elem_xlat uex ' || ");
        sql.append("  'WHERE ue.ui_elem_key = (''bs.country.name.cd.'' || lower(ctry_nm_cd)) ' || ");
        sql.append("  'AND ue.ui_elem_id = uex.ui_elem_id AND uex.locale_cd = ''en_GB''), ctry_nm_cd) ctry_nm FROM ( ' || ");
        sql.append("  'SELECT bc.ctry_nm_cd FROM bridge_gbl_publish_ctry bc WHERE bridge_gbl_publish_id = ' || ");
        sql.append("  '(SELECT bridge_gbl_publish_id FROM bridge_gbl_publish WHERE publish_id = :pubId AND std_id = :stdId) ' || ");
        sql.append("  'MINUS ' || ");
        sql.append("  'SELECT cs.ctry_nm_cd FROM std s, ctry_std cs WHERE s.std_id = cs.std_id AND s.std_id = :stdId )';");
        sql.append("  l_gbl_del_ctry_sql VARCHAR2(200) := 'DELETE bridge_gbl_publish_ctry WHERE bridge_gbl_publish_id = :pubId AND ctry_nm_cd = :ctryCd';");
     
        sql.append("  l_ins_ctry_sql VARCHAR2(600) := ");
        sql.append("  'INSERT INTO bridge_publish_ctry(bridge_publish_ctry_id, bridge_publish_id, ctry_nm_cd, ' || ");
        sql.append("  'bridge_publish_stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        sql.append("  'VALUES (:id, :brgPubId, :ctryNm, :statCd, :usrId, :ts, :usrId, :ts)';");
        sql.append("  l_rgn_rm_ctry_sql VARCHAR2(600) :=");
        sql.append("  'SELECT ctry_nm_cd, NVL((SELECT uex.elem_val FROM ui_elem ue, ui_elem_xlat uex ' || ");
        sql.append("  'WHERE ue.ui_elem_key = (''bs.country.name.cd.'' || lower(ctry_nm_cd)) ' || ");
        sql.append("  'AND ue.ui_elem_id = uex.ui_elem_id AND uex.locale_cd = ''en_GB''), ctry_nm_cd) ctry_nm FROM ( ' || ");
        sql.append("  'SELECT bc.ctry_nm_cd FROM bridge_publish_ctry bc WHERE bridge_publish_id = :brPubId ' || ");
        sql.append("  'MINUS ' || ");
        sql.append("  'SELECT cs.ctry_nm_cd FROM std s, ctry_std cs WHERE s.std_id = cs.std_id ' || ");
        sql.append("  'AND cs.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = :rgnId) AND s.std_id = :stdId )';");
        sql.append("  l_rgn_del_ctry_sql VARCHAR2(200) := 'DELETE bridge_publish_ctry WHERE bridge_publish_id = :pubId AND ctry_nm_cd = :ctryCd';");
       
        sql.append("  l_rgn_new_ctry_sql VARCHAR2(1800) := ");
        sql.append("  'SELECT ss.ctry_nm_cd, ' || ");
        sql.append("  ' NVL((SELECT uex.elem_val FROM ui_elem ue, ui_elem_xlat uex ' || ");
        sql.append("  '  WHERE ue.ui_elem_key = (''bs.country.name.cd.'' || lower(ss.ctry_nm_cd)) ' || ");
        sql.append("  '  AND ue.ui_elem_id = uex.ui_elem_id AND uex.locale_cd = ''en_GB''), ss.ctry_nm_cd) ctry_nm, ' || ");
        sql.append("  '  CASE WHEN ss.std_typ = ''GDLN'' THEN CASE WHEN ss.std_desc = pss.std_desc THEN ''NO_CHANGE'' ' || ");
        sql.append("  '    WHEN ss.std_desc != pss.std_desc THEN ''UPDATE'' ' || ");
        sql.append("  '    ELSE ''NEW'' END ' || ");
        sql.append("  '  ELSE CASE WHEN ss.title_txt = pss.title_txt THEN ''NO_CHANGE'' ' || ");
        sql.append("  '    WHEN ss.title_txt != pss.title_txt THEN ''UPDATE'' ' || ");
        sql.append("  '    ELSE ''NEW'' END ' || ");
        sql.append("  '  END stat_cd, ss.mnl_typ ' || ");
        sql.append("  'FROM (SELECT s.std_id, s.std_typ, trim(s.title_txt) title_txt, trim(s.std_desc) std_desc, cs.ctry_nm_cd, ' || ");
        sql.append("  ' (SELECT NVL((SELECT listagg(f.flag_catgy_id, '','') WITHIN GROUP(ORDER BY f.flag_catgy_id) FROM flag_std f ' || ");
        sql.append("  '  WHERE f.std_id = s1.std_id AND f.flag_catgy_id IN (257, 258) GROUP BY f.std_id), ''0'') FROM STD s1 WHERE s1.std_id = s.std_id) AS mnl_typ ' || ");
        sql.append("  '  FROM std s, ctry_std cs, brndstnd_ctry ct ' || ");
        sql.append("  '  WHERE s.std_id = :stdId AND s.std_id = cs.std_id AND ct.ctry_nm_cd = cs.ctry_nm_cd AND ct.rgn_id = :rgnId) ss, ' || ");
        sql.append("  '(SELECT ps.std_id, pcs.ctry_nm_cd, trim(ps.title_txt) title_txt, trim(ps.std_desc) std_desc ' || ");
        sql.append("  ' FROM publish_std ps, publish_ctry_std pcs ' || ");
        sql.append("  ' WHERE ps.publish_id = :prodPubId AND ps.std_id = :stdId AND ps.publish_std_ver_id = pcs.publish_std_ver_id) pss, ' || ");
        sql.append("  '(SELECT cs.ctry_nm_cd FROM std s, ctry_std cs WHERE s.std_id = cs.std_id AND s.std_id = :stdId ' || ");
        sql.append("  ' AND cs.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = :rgnId) ' || ");
        sql.append("  ' MINUS ' || ");
        sql.append("  ' SELECT bc.ctry_nm_cd FROM bridge_publish_ctry bc WHERE bridge_publish_id = :brPubId) new_ctry ' || ");
        sql.append("  ' WHERE ss.std_id = pss.std_id(+) ' || ");
        sql.append("  ' AND ss.ctry_nm_cd = new_ctry.ctry_nm_cd AND ss.ctry_nm_cd = pss.ctry_nm_cd(+)'; ");
        
        sql.append("  l_err_notification_sql VARCHAR2(350) := ");
        sql.append("  'INSERT INTO err_notification(err_notification_id, component_nm, ref_id, severity_lvl_cd, err_title_txt, err_desc, ' || ");
        sql.append("  'publish_id, stat_cd, rgn_id, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        sql.append("  'VALUES(:errId, ''BRIDGE_NOTIFICATION'', :stdId, ''H'', :errTitle, :errDesc, ' || ");
        sql.append("  ':pibId, ''NEW'', :rgnId, :usrId, SYSDATE, :usrId, SYSDATE)'; ");

        sql.append("BEGIN");
//        -- update countries in Global Must
        sql.append("  IF l_cms_rgn_id = 1 THEN");
        sql.append("    BEGIN");
        sql.append("      SELECT bridge_gbl_publish_id INTO l_bridge_gbl_publish_id");
        sql.append("      FROM bridge_gbl_publish WHERE publish_id = l_publish_id AND std_id = l_std_id;");
//            -- find new countries
        sql.append("      OPEN l_ctry_cur FOR l_gbl_new_ctry_sql"); 
        sql.append("      USING l_std_id, l_publish_id, l_std_id;");
        sql.append("      LOOP");
        sql.append("        FETCH l_ctry_cur INTO l_ctry_cd, l_ctry_nm;");
        sql.append("        EXIT WHEN l_ctry_cur%NOTFOUND;");

        sql.append("        IF l_glbl_new_ctry IS NULL THEN");
        sql.append("          l_glbl_new_ctry := l_ctry_nm;");
        sql.append("        ELSE");
        sql.append("          l_glbl_new_ctry := l_glbl_new_ctry || ', ' || l_ctry_nm;");
        sql.append("        END IF;");

        sql.append("        EXECUTE IMMEDIATE l_gbl_ins_ctry_sql");
        sql.append("        USING bridge_gbl_publish_ctry_id_seq.nextval, l_bridge_gbl_publish_id, l_ctry_cd, l_pub_ind, l_user_id, SYSDATE, l_user_id, SYSDATE;");
        sql.append("      END LOOP;");
        sql.append("      CLOSE l_ctry_cur;");
//            -- find removed countries
        sql.append("      OPEN l_ctry_cur FOR l_gbl_rm_ctry_sql"); 
        sql.append("      USING l_publish_id, l_std_id, l_std_id;");
        sql.append("      LOOP");
        sql.append("        FETCH l_ctry_cur INTO l_ctry_cd, l_ctry_nm;");
        sql.append("        EXIT WHEN l_ctry_cur%NOTFOUND;");

        sql.append("        IF l_glbl_rm_ctry IS NULL THEN");
        sql.append("          l_glbl_rm_ctry := l_ctry_nm;");
        sql.append("        ELSE");
        sql.append("          l_glbl_rm_ctry := l_glbl_rm_ctry || ', ' || l_ctry_nm;");
        sql.append("        END IF;");

        sql.append("        EXECUTE IMMEDIATE l_gbl_del_ctry_sql");
        sql.append("        USING l_bridge_gbl_publish_id, l_ctry_cd;");
        sql.append("      END LOOP;");
        sql.append("      CLOSE l_ctry_cur;");
        sql.append("    EXCEPTION WHEN no_data_found THEN NULL;");
        sql.append("    END;");
        
        //-- Insert Global Standard country change notification 
        sql.append("    l_err_desc := NULL;");
        sql.append("    IF l_glbl_new_ctry IS NOT NULL THEN");
        sql.append("      l_err_desc := 'Following countries were added to the Standard: ' || l_glbl_new_ctry;");
        sql.append("    END IF;");
        sql.append("    IF l_glbl_rm_ctry IS NOT NULL THEN");
        sql.append("      IF l_err_desc IS NOT NULL THEN");
        sql.append("        l_err_desc := l_err_desc || ' ' || chr(10) || chr(10);");
        sql.append("      END IF;");
        sql.append("      l_err_desc := l_err_desc || 'Following countries were removed from the Standard: ' || l_glbl_rm_ctry;");
        sql.append("    END IF;");
        sql.append("    IF l_err_desc IS NOT NULL THEN");
        sql.append("      EXECUTE IMMEDIATE l_err_notification_sql");
        sql.append("      USING err_notification_id_seq.nextval, l_std_id, l_err_title, l_err_desc, l_publish_id, l_cms_rgn_id, l_user_id, l_user_id;");
        sql.append("    END IF;");
        sql.append("  END IF;");

        sql.append("  SELECT chain_cd, publish_content_typ INTO l_chain_cd, l_cur_br_pub_type FROM publish WHERE publish_id = l_publish_id;");

        sql.append("  SELECT count(*) INTO l_build_pub_cnt");
        sql.append("  FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND publish_content_typ LIKE '%BUILD_OPERATE' AND CHAIN_CD = l_chain_cd;");    
        
        sql.append("  SELECT count(*) INTO l_prod_pub_cnt");
        sql.append("  FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND CHAIN_CD = l_chain_cd;"); 

        sql.append("  BEGIN");
        sql.append("    SELECT publish_id INTO l_prod_publish_id");
        sql.append("    FROM publish WHERE publish_environment_nm = 'PRODUCTION' AND publish_stat_cd = 'ACTIVE' AND chain_cd = l_chain_cd;");
        sql.append("  EXCEPTION WHEN no_data_found THEN l_prod_publish_id := 0;");
        sql.append("  END;");

//        -- update countries for each region
        sql.append("  FOR rec IN l_cur LOOP");
        sql.append("    l_rgn_new_ctry := NULL;");
        sql.append("    l_rgn_rm_ctry := NULL;");
//            -- find new countries
        sql.append("    OPEN l_ctry_cur FOR l_rgn_new_ctry_sql"); 
        sql.append("    USING l_std_id, rec.rgn_id, l_prod_publish_id, l_std_id, l_std_id, rec.rgn_id, rec.bridge_publish_id;");
        sql.append("    LOOP");
        sql.append("      FETCH l_ctry_cur INTO l_ctry_cd, l_ctry_nm, l_stat_cd, l_std_mnl_type;");
        sql.append("      EXIT WHEN l_ctry_cur%NOTFOUND;");
                
        sql.append("      IF l_prod_pub_cnt > 0 THEN");
        sql.append("        IF l_cur_br_pub_type = 'FULL_BUILD_OPERATE' THEN");
        sql.append("          IF l_build_pub_cnt = 0 THEN");
        sql.append("            IF l_std_mnl_type = '257' THEN");
        sql.append("              l_stat_cd := 'SELECT';");
        sql.append("            END IF;");
        sql.append("          END IF;");
        sql.append("        END IF;");
        sql.append("      ELSE");
        sql.append("        l_stat_cd := 'SELECT';");
        sql.append("      END IF;");

        sql.append("      IF l_rgn_new_ctry IS NULL THEN");
        sql.append("        l_rgn_new_ctry := l_ctry_nm;");
        sql.append("      ELSE");
        sql.append("        l_rgn_new_ctry := l_rgn_new_ctry || ', ' || l_ctry_nm;");
        sql.append("      END IF;");

        sql.append("      EXECUTE IMMEDIATE l_ins_ctry_sql");
        sql.append("      USING bridge_publish_ctry_id_seq.nextval, rec.bridge_publish_id, l_ctry_cd, l_stat_cd, l_user_id, SYSDATE, l_user_id, SYSDATE;");
        sql.append("    END LOOP;");
        sql.append("    CLOSE l_ctry_cur;");
//            -- find removed countries
        sql.append("    OPEN l_ctry_cur FOR l_rgn_rm_ctry_sql"); 
        sql.append("    USING rec.bridge_publish_id, rec.rgn_id, l_std_id;");
        sql.append("    LOOP");
        sql.append("      FETCH l_ctry_cur INTO l_ctry_cd, l_ctry_nm;");
        sql.append("      EXIT WHEN l_ctry_cur%NOTFOUND;");

        sql.append("      IF l_rgn_rm_ctry IS NULL THEN");
        sql.append("        l_rgn_rm_ctry := l_ctry_nm;");
        sql.append("      ELSE");
        sql.append("        l_rgn_rm_ctry := l_rgn_rm_ctry || ', ' || l_ctry_nm;");
        sql.append("      END IF;");

        sql.append("      EXECUTE IMMEDIATE l_rgn_del_ctry_sql");
        sql.append("      USING rec.bridge_publish_id, l_ctry_cd;");
        sql.append("    END LOOP;");
        sql.append("    CLOSE l_ctry_cur;");
        //-- Verify whether region still attributed to this standard
        sql.append("    SELECT count(*) INTO l_cnt FROM bridge_publish_ctry WHERE bridge_publish_id = rec.bridge_publish_id;");
        sql.append("    IF l_cnt = 0 THEN");
        sql.append("      l_rgn_rm_ctry := NULL;");
        sql.append("    END IF;");
        
        //-- Insert Regional Standard country change notification 
        sql.append("    l_err_desc := NULL;");
        sql.append("    IF l_rgn_new_ctry IS NOT NULL THEN");
        sql.append("      l_err_desc := 'Following countries were added to the Standard: ' || l_rgn_new_ctry;");
        sql.append("    END IF;");
        sql.append("    IF l_rgn_rm_ctry IS NOT NULL THEN");
        sql.append("      IF l_err_desc IS NOT NULL THEN");
        sql.append("        l_err_desc := l_err_desc || ' ' || chr(10) || chr(10);");
        sql.append("      END IF;");
        sql.append("      l_err_desc := l_err_desc || 'Following countries were removed from the Standard: ' || l_rgn_rm_ctry;");
        sql.append("    END IF;");
        sql.append("    IF l_err_desc IS NOT NULL THEN");
        sql.append("      EXECUTE IMMEDIATE l_err_notification_sql");
        sql.append("      USING err_notification_id_seq.nextval, l_std_id, l_err_title, l_err_desc, l_publish_id, rec.rgn_id, l_user_id, l_user_id;");
        sql.append("    END IF;");
        sql.append("  END LOOP;");
        sql.append("  COMMIT;");
        sql.append("END;");
        
        return sql.toString();
    }

    public static String getUpdateStdCountriesStateQuery(long publishId, long stdId, long cmsRegionId, String userScreenName)
    {
        StringBuilder sql = new StringBuilder();
        sql.append("DECLARE");
        sql.append("  l_publish_id NUMBER := ").append(publishId).append(";");
        sql.append("  l_std_id NUMBER :=  ").append(stdId).append(";");
        sql.append("  l_user_id VARCHAR2(50) := '").append(userScreenName).append("';");
        sql.append("  CURSOR l_cur IS");
        sql.append("  SELECT bridge_publish_id, rgn_id FROM bridge_publish WHERE publish_id = l_publish_id AND unpublish_ind = 'N' AND std_id = l_std_id;");
        sql.append("  l_chain_cd VARCHAR2(5);");
        sql.append("  l_prod_publish_id NUMBER;");
        sql.append("  l_publish_std_ver_id NUMBER;");
        sql.append("  l_stat_cd VARCHAR2(20);");
        sql.append("  l_ctry_cd VARCHAR2(3);");
        sql.append("  l_ctry_nm VARCHAR2(100);");
        sql.append("  l_cur_br_pub_type VARCHAR2(20);");
        sql.append("  l_build_pub_cnt NUMBER;");
        sql.append("  l_prod_pub_cnt NUMBER;");
        sql.append("  l_ctry_cur SYS_REFCURSOR;");
        sql.append("  l_mnl_typ VARCHAR2(10);");
        sql.append("  l_err_title VARCHAR2(500) := 'Title Change';");
        sql.append("  l_err_desc VARCHAR2(4000);");
        sql.append("  l_obsm_tmp_title VARCHAR2(4000);");
        sql.append("  l_obsm_title VARCHAR2(4000);");
        
        sql.append("  l_std_ctry_stat VARCHAR2(1700) := ");
        sql.append("  'SELECT ss.ctry_nm_cd, ' || ");
        sql.append("  ' NVL((SELECT uex.elem_val FROM ui_elem ue, ui_elem_xlat uex ' || ");
        sql.append("  '  WHERE ue.ui_elem_key = (''bs.country.name.cd.'' || lower(ss.ctry_nm_cd)) ' || ");
        sql.append("  '  AND ue.ui_elem_id = uex.ui_elem_id AND uex.locale_cd = ''en_GB''), ss.ctry_nm_cd) ctry_nm, ' || ");
        sql.append("  '  CASE WHEN ss.std_typ = ''GDLN'' THEN CASE WHEN ss.std_desc = pss.std_desc THEN ''NO_CHANGE'' ' || ");
        sql.append("  '    WHEN ss.std_desc != pss.std_desc THEN ''UPDATE'' ' || ");
        sql.append("  '    ELSE ''NEW'' END ' || ");
        sql.append("  '  ELSE CASE WHEN ss.title_txt = pss.title_txt THEN ''NO_CHANGE'' ' || ");
        sql.append("  '    WHEN ss.title_txt != pss.title_txt THEN ''UPDATE'' ' || ");
        sql.append("  '    ELSE ''NEW'' END ' || ");
        sql.append("  '  END stat_cd, ss.mnl_typ, ' || ");
        sql.append("  '  CASE WHEN ss.std_typ = ''GDLN'' THEN pss.std_desc ELSE pss.title_txt END obsm_title, pss.publish_std_ver_id ' || ");
        sql.append("  'FROM (SELECT s.std_id, s.std_typ, trim(s.title_txt) title_txt, trim(s.std_desc) std_desc, cs.ctry_nm_cd, ' || ");
        sql.append("  ' (SELECT NVL((SELECT listagg(f.flag_catgy_id, '','') WITHIN GROUP(ORDER BY f.flag_catgy_id) FROM flag_std f ' || ");
        sql.append("  '  WHERE f.std_id = s1.std_id AND f.flag_catgy_id IN (257, 258) GROUP BY f.std_id), ''0'') FROM STD s1 WHERE s1.std_id = s.std_id) AS mnl_typ ' || ");
        sql.append("  '  FROM std s, ctry_std cs, brndstnd_ctry ct ' || ");
        sql.append("  '  WHERE s.std_id = :stdId AND s.std_id = cs.std_id AND ct.ctry_nm_cd = cs.ctry_nm_cd AND ct.rgn_id = :rgnId) ss, ' || ");
        sql.append("  '(SELECT ps.std_id, pcs.ctry_nm_cd, trim(ps.title_txt) title_txt, trim(ps.std_desc) std_desc, ps.publish_std_ver_id ' || ");
        sql.append("  ' FROM publish_std ps, publish_ctry_std pcs ' || ");
        sql.append("  ' WHERE ps.publish_id = :prodPubId AND ps.std_id = :stdId AND ps.publish_std_ver_id = pcs.publish_std_ver_id) pss ' || ");
        sql.append("  ' WHERE ss.std_id = pss.std_id(+) ' || ");
        sql.append("  ' AND ss.ctry_nm_cd = pss.ctry_nm_cd(+)'; ");
        
        sql.append("  l_upd_ctry VARCHAR2(200) := 'UPDATE bridge_publish_ctry SET bridge_publish_stat_cd = :newStat, lst_updt_usr_id = :usrId, lst_updt_ts = :ts ' || ");
        sql.append("  'WHERE bridge_publish_id = :brPubId AND ctry_nm_cd = :ctryNm';");
        
        sql.append("  l_err_notification_sql VARCHAR2(350) := ");
        sql.append("  'INSERT INTO err_notification(err_notification_id, component_nm, ref_id, severity_lvl_cd, err_title_txt, err_desc, ' || ");
        sql.append("  'publish_id, stat_cd, rgn_id, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        sql.append("  'VALUES(:errId, ''BRIDGE_NOTIFICATION'', :stdId, ''H'', :errTitle, :errDesc, ' || ");
        sql.append("  ':pibId, ''NEW'', :rgnId, :usrId, SYSDATE, :usrId, SYSDATE)'; ");

        sql.append("BEGIN");
        sql.append("  SELECT chain_cd, publish_content_typ INTO l_chain_cd, l_cur_br_pub_type FROM publish WHERE publish_id = l_publish_id;");

        sql.append("  SELECT count(*) INTO l_build_pub_cnt");
        sql.append("  FROM publish WHERE publish_environment_nm = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND publish_content_typ LIKE '%BUILD_OPERATE' AND chain_cd = l_chain_cd;");    
        
        sql.append("  SELECT count(*) INTO l_prod_pub_cnt");
        sql.append("  FROM publish WHERE publish_environment_nm = 'PRODUCTION' AND publish_stat_cd != 'DELETED' AND chain_cd = l_chain_cd;"); 

        sql.append("  BEGIN");
        sql.append("    SELECT publish_id INTO l_prod_publish_id");
        sql.append("    FROM publish WHERE publish_environment_nm = 'PRODUCTION' AND publish_stat_cd = 'ACTIVE' AND chain_cd = l_chain_cd;");
        sql.append("  EXCEPTION WHEN no_data_found THEN l_prod_publish_id := 0;");
        sql.append("  END;");

//        -- update Status of countries
        sql.append("  FOR rec IN l_cur LOOP");
        sql.append("    l_err_desc := NULL;");
        sql.append("    l_obsm_title := NULL;");
 
        sql.append("    OPEN l_ctry_cur FOR l_std_ctry_stat");
        sql.append("    USING l_std_id, rec.rgn_id, l_prod_publish_id, l_std_id;");
        sql.append("    LOOP");
        sql.append("    FETCH l_ctry_cur INTO l_ctry_cd, l_ctry_nm, l_stat_cd, l_mnl_typ, l_obsm_tmp_title, l_publish_std_ver_id;");
        sql.append("    EXIT WHEN l_ctry_cur%NOTFOUND;");
        sql.append("      IF l_prod_pub_cnt > 0 THEN");
        sql.append("        IF l_cur_br_pub_type = 'FULL_BUILD_OPERATE' THEN");
        sql.append("          IF l_build_pub_cnt = 0 THEN");
        sql.append("            IF l_mnl_typ = '257' THEN");
        sql.append("              l_stat_cd := 'SELECT';");
        sql.append("            END IF;");
        sql.append("          END IF;");
        sql.append("        END IF;");
        sql.append("      ELSE");
        sql.append("        l_stat_cd := 'SELECT';");
        sql.append("      END IF;");

        sql.append("      EXECUTE IMMEDIATE l_upd_ctry");
        sql.append("      USING l_stat_cd, l_user_id, SYSDATE, rec.bridge_publish_id, l_ctry_cd;");
       
      sql.append("        IF l_obsm_tmp_title IS NOT NULL THEN");
      sql.append("          l_obsm_title := l_obsm_tmp_title;");
      sql.append("        END IF;");

        sql.append("    END LOOP;");
        sql.append("    CLOSE l_ctry_cur;");
        
        sql.append("  IF l_publish_std_ver_id > 0 THEN ");
        sql.append("    IF (length(l_obsm_title)) > 1000 THEN ");
        sql.append("      l_err_desc := 'Old Title: ' || substr(l_obsm_title, 1, 1000) || '...';");
        sql.append("    ELSE");
        sql.append("      l_err_desc := 'Old Title: ' || l_obsm_title;");
        sql.append("    END IF;");
       
        //-- Insert Regional Standard country change notification 
        sql.append("    IF l_err_desc IS NOT NULL THEN");
        sql.append("      EXECUTE IMMEDIATE l_err_notification_sql");
        sql.append("      USING err_notification_id_seq.nextval, l_std_id, l_err_title, l_err_desc, l_publish_id, rec.rgn_id, l_user_id, l_user_id;");
        sql.append("    END IF;");
        sql.append("  END IF;");
        
        sql.append("  END LOOP;");
        sql.append("  COMMIT;");
        sql.append("END;");
        
        return sql.toString();
    }
    
    /**
     * 
     * @param bridgePublishId
     * @param stdId
     * @return String
     */
    public static String getDeleteRegionalRecordCountriesQuery(long bridgePublishId, long stdId) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("  DELETE bridge_publish_ctry WHERE bridge_publish_ctry_id IN ");
    	sql.append("(SELECT bpc.bridge_publish_ctry_id FROM bridge_publish bp, bridge_publish_ctry bpc");
    	sql.append("    WHERE bp.bridge_publish_id = bpc.bridge_publish_id AND bp.publish_id = ");
    	sql.append(bridgePublishId);
    	sql.append(" AND bp.std_id = ");
    	sql.append(stdId);
    	sql.append(" )");
    	
    	return sql.toString();
    }
    
    /**
     * Query to get regions for specified standard id and publication.
     * @param publishId publication id
     * @param stdId standard id
     * @return String
     */
    public static String getRegionsByPublishIdAndStdIdQuery (long publishId, long stdId) 
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT DISTINCT RGN_ID FROM ");
        query.append(" BRIDGE_PUBLISH ");
        query.append(" WHERE PUBLISH_ID =  ");
        query.append(publishId);
        query.append(" AND STD_ID = ");
        query.append(stdId);
        return query.toString();
    }

    /**
     * Query to get count of standards which are ready do be added to My Publication. 
     * @param publishId bridge publication id
     * @param rgnId region id
     * @return String
     */
    public static String getSTDToBeAddedCountQuery (long publishId, long rgnId) 
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT count(*) FROM bridge_publish_import WHERE publish_id = ").append(publishId);
        query.append(" AND rgn_id = ").append(rgnId).append(" AND selection_id = 'Y' ");
        return query.toString();
    }
    
    /**
     * 
     * @param brandCode
     * @param environment
     * @return String query.toString
     */
    public static String getBridgePublications (String brandCode, String environment) {
    	StringBuffer query = new StringBuffer("WITH BRIDGE_PUBLISH AS (SELECT p.* FROM PUBLISH p ");
    	query.append(" WHERE p.PUBLISH_ENVIRONMENT_NM='");
    	query.append(environment);
    	query.append("' AND p.PUBLISH_STAT_CD != 'DELETE' AND p.CHAIN_CD='");
        query.append(brandCode);
        query.append("' ORDER BY creat_ts DESC)");
        query.append(" SELECT * FROM BRIDGE_PUBLISH WHERE rownum <= 5 ORDER BY creat_ts DESC");
        return query.toString();
    }
    
    /**
     * @param departmentId
     * @param brandCode
     * @param environment
     * @return String query.toString
     */
    public static String getDepartmentPublication (long departmentId, String brandCode, String environment) {
    	StringBuffer query = new StringBuffer("WITH DEPT_PS AS (SELECT publish_id FROM gem_publish_dept  ");
    	query.append(" WHERE gem_dept_id = ");
    	query.append(departmentId);
    	query.append(") ");
        query.append(" SELECT p.* FROM PUBLISH p where p.PUBLISH_ID in (select PUBLISH_ID from DEPT_PS) AND ");
        query.append(" p.CHAIN_CD = '");
        query.append(brandCode);
        query.append("' AND p.PUBLISH_ENVIRONMENT_NM = '");
        query.append(environment);
        query.append("' AND p.PUBLISH_STAT_CD = 'ACTIVE' ");
        return query.toString();
    }
}
