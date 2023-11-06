/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.util;

import java.util.ArrayList;
import java.util.List;

import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.liferay.portal.kernel.util.StringPool;

/**
 * <a href="WCOQueryUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Lakshminarayana Mummanedi
 */
public final class WCOQueryUtil
{
    public static final String UPDATE = "'UPDATE'";
    public static final String NEW = "'NEW'";
    public static final String NEW_AND_UPDATE = "'NEW', 'UPDATE'";

    /**
     * private constructor to restrict the instantiation as it a utility class.
     */
    private WCOQueryUtil()
    {
        // private constructor to restrict the instantiation as it a utility class.
    }

    /**
     * Fetch all indexes for the Brand based on Publish Id for Production.
     * 
     * @author: Lakshminarayana Mummanedi.
     * @param selPublishId -Selected Publish Id.
     * @param prevPublishId -Previous Publish Id of selected publish.
     * @return AllIndex SQL Query.
     */
    public static String getWCOAllIndexQueryProd(String selPublishId, String prevPublishId)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("WITH");

        builder.append(" SEL_PUBLISH_TAXONOMY AS (SELECT T.TAXONOMY_ID, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID,");
        builder.append(" T.TAXONOMY_DESC, T.TITLE_TXT, T.HIER_LVL_NBR, T.PUBLISH_ID");
        builder.append(" FROM PUBLISH_TAXONOMY T WHERE T.publish_id = ");
        builder.append(selPublishId);
        builder.append(" OR T.publish_id=0),");

        builder.append(" PREV_PUBLISH_TAXONOMY AS (SELECT T.TAXONOMY_ID, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID,");
        builder.append(" T.TAXONOMY_DESC, T.TITLE_TXT, T.HIER_LVL_NBR,");
        builder.append(" DECODE(T.PUBLISH_ID, NULL, ");
        builder.append(selPublishId);
        builder.append(", ");
        builder.append(selPublishId);
        builder.append(" ) AS PUBLISH_ID");
        builder.append(" FROM PUBLISH_TAXONOMY T WHERE T.publish_id = ");
        builder.append(prevPublishId);
        builder.append(" AND T.taxonomy_id IN");
        builder.append(" (SELECT TAXONOMY_ID FROM PUBLISH_TAXONOMY WHERE publish_id=");
        builder.append(prevPublishId);
        builder.append(" MINUS SELECT TAXONOMY_ID FROM PUBLISH_TAXONOMY WHERE publish_id=");
        builder.append(selPublishId);
        builder.append(" )),");

        builder.append(" FINAL_PUBLISH_TAXONOMY AS");
        builder.append(" (SELECT * FROM SEL_PUBLISH_TAXONOMY UNION SELECT * FROM PREV_PUBLISH_TAXONOMY)");

        builder.append(" (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PUBLISH_TAXONOMY_ID, TAX.PRNT_PUBLISH_TAXONOMY_ID, TAX.LVL,");
        builder.append(" TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE FROM (");
        builder.append(" SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID,");
        builder.append(" T.TAXONOMY_DESC, T.TITLE_TXT, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
        builder.append(" SUBSTR(SYS_CONNECT_BY_PATH(  t.title_txt , ' &#8594; '),  31) AS PATH");
        builder.append(" FROM FINAL_PUBLISH_TAXONOMY T WHERE T.publish_id = ");
        builder.append(selPublishId);
        builder.append(" START WITH T.TAXONOMY_ID = 1 ");
        builder.append(" CONNECT BY PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID ORDER SIBLINGS BY T.HIER_LVL_NBR ) TAX)");

        return builder.toString();
    }

    /**
     * Fetch all indexes for the Brand based on Publish Id for Staging.
     * 
     * @author: Lakshminarayana Mummanedi.
     * @param selPublishId -Selected Publish Id.
     * @param prevPublishId -Previous Publish Id of selected publish.
     * @return AllIndex SQL Query.
     */
    public static String getWCOAllIndexQueryStage(String selPublishId, String prevPublishId)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("WITH");

        builder.append(" SEL_STAGE_TAXONOMY AS (SELECT T.TAXONOMY_ID, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID,");
        builder.append(" T.TAXONOMY_DESC, T.TITLE_TXT, T.HIER_LVL_NBR, T.PUBLISH_ID");
        builder.append(" FROM STAGE_TAXONOMY T WHERE T.publish_id = ");
        builder.append(selPublishId);
        builder.append(" OR T.publish_id=0),");

        builder.append(" PREV_STAGE_TAXONOMY AS (SELECT T.TAXONOMY_ID, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID,");
        builder.append(" T.TAXONOMY_DESC, T.TITLE_TXT, T.HIER_LVL_NBR,");
        builder.append(" DECODE(T.PUBLISH_ID, NULL, ");
        builder.append(selPublishId);
        builder.append(", ");
        builder.append(selPublishId);
        builder.append(" ) AS PUBLISH_ID");
        builder.append(" FROM STAGE_TAXONOMY T WHERE T.publish_id = ");
        builder.append(prevPublishId);
        builder.append(" AND T.taxonomy_id IN");
        builder.append(" (SELECT TAXONOMY_ID FROM STAGE_TAXONOMY WHERE publish_id=");
        builder.append(prevPublishId);
        builder.append(" MINUS SELECT TAXONOMY_ID FROM STAGE_TAXONOMY WHERE publish_id=");
        builder.append(selPublishId);
        builder.append(" )),");

        builder.append(" FINAL_STAGE_TAXONOMY AS");
        builder.append(" (SELECT * FROM SEL_STAGE_TAXONOMY UNION SELECT * FROM PREV_STAGE_TAXONOMY)");

        builder.append(" (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.STAGE_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID, TAX.PRNT_STAGE_TAXONOMY_ID AS PRNT_PUBLISH_TAXONOMY_ID, TAX.LVL,");
        builder.append(" TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE FROM (");
        builder.append(" SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXONOMY_ID,");
        builder.append(" T.TAXONOMY_DESC, T.TITLE_TXT, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
        builder.append(" SUBSTR(SYS_CONNECT_BY_PATH(  t.title_txt , ' &#8594; '),  31) AS PATH");
        builder.append(" FROM FINAL_STAGE_TAXONOMY T WHERE T.publish_id = ");
        builder.append(selPublishId);
        builder.append(" START WITH T.TAXONOMY_ID = 1 ");
        builder.append(" CONNECT BY PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXONOMY_ID ORDER SIBLINGS BY T.HIER_LVL_NBR ) TAX)");

        return builder.toString();
    }

    /**
     * This method will generate search query to display standards on the What Changed On screen.
     * 
     * @param localeCode This is a String object
     * @param chainCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @param selPublishId This is a String object
     * @param prevPublishId This is a String object
     * @return String
     */
    public static String getWCOSearchQueryProd(String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria, String selPublishId, String prevPublishId)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlHotelLocations = criteria.getLocHotel();
        List<String> arlGuestJourney = criteria.getGuestJourney();

        String textSearchType = criteria.getTextSearchType();
        boolean filterByNew = criteria.isFilterByNew();
        boolean filterByTextUpdate = criteria.isFilterByTextUpdate();
        boolean filterByComplianceUpdate = criteria.isFilterByComplianceUpdate();
        boolean filterByLifecycleUpdate = criteria.isFilterByLifecycleUpdate();

        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();

        sqlQuery1.append("WITH ");
        sqlQuery1.append(getProdTaxonomyTempTable("TAXONOMY", selPublishId, localeCode));
        sqlQuery1.append(StringPool.COMMA);
        
        sqlQuery1.append(" LIFECYCLE_FLAGS AS (SELECT flag_catgy_id FROM flag_catgy WHERE prnt_flag_catgy_id=91 AND actv_ind='Y' ORDER BY disp_order_nbr),");
        
        sqlQuery1.append(" SEL_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(selPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(prevPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH_STD AS (SELECT ps.PUBLISH_STD_VER_ID, ps.prnt_std_id, (SELECT STD_ID FROM PUBLISH_STD WHERE PUBLISH_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.STD_ID, ps.STD_TYP,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.TITLE_TXT), NULL, TRIM(ps.TITLE_TXT), TRIM(sx.TITLE_TXT)) AS TITLE_TXT,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.STD_DESC), NULL, TRIM(ps.STD_DESC), TRIM(sx.STD_DESC)) AS STD_DESC,");
        sqlQuery1.append(" 	CASE WHEN TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > pp.PUBLISH_DT THEN");
        sqlQuery1.append("	pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.PUBLISH_STD_VER_ID)");
        sqlQuery1.append(" 		FROM PUBLISH_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.PUBLISH_STD_VER_ID = pfs.PUBLISH_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.PUBLISH_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM PREV_PUBLISH pp, PUBLISH_STD ps, PUBLISH_CTRY_STD PCS, PUBLISH_STD_XLAT SX");
        sqlQuery1.append(" 	WHERE pp.PUBLISH_ID = ps.PUBLISH_ID");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id=pcs.publish_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd='").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id=sx.publish_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("'= sx.locale_cd(+)),");
        
        sqlQuery1.append(" SEL_PUBLISH_STD AS (SELECT ps.publish_std_ver_id, ps.prnt_std_id, (SELECT STD_ID FROM PUBLISH_STD WHERE PUBLISH_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.std_id, ps.std_typ,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.title_txt), NULL, TRIM(ps.title_txt), TRIM(sx.title_txt)) AS title_txt,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.std_desc), NULL, TRIM(ps.std_desc), TRIM(sx.std_desc)) AS std_desc,");
        sqlQuery1.append("	CASE WHEN (TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > sp.PUBLISH_DT AND pcs.std_cmply_deadline_dt > SYSDATE) THEN pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt,");
        sqlQuery1.append(" 	pcs.ctry_nm_cd, sx.locale_cd, pcs.publish_stat_cd AS stat_desc, pcs.disp_order_nbr,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.PUBLISH_STD_VER_ID)");
        sqlQuery1.append(" 		FROM PUBLISH_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.PUBLISH_STD_VER_ID = pfs.PUBLISH_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.PUBLISH_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM SEL_PUBLISH sp, PUBLISH_STD ps, PUBLISH_STD_XLAT SX, PUBLISH_CTRY_STD pcs WHERE sp.PUBLISH_ID = ps.PUBLISH_ID");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id = pcs.publish_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd = '").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id = sx.publish_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("' = sx.locale_cd(+)),");

        sqlQuery1.append(" ALL_PUB_CHANGES AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PUBLISH_TAXONOMY_ID, TAX.PRNT_PUBLISH_TAXONOMY_ID,");
        sqlQuery1.append(" 	TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE,");
        sqlQuery1.append(" 	ps.publish_std_ver_id, ps.prnt_std_id, ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc,");
        sqlQuery1.append(" 	ps.cmply_dt, ps.expr_dt, ps.HLC_FLAG_ID, ps.DISP_ORDER_NBR, prevps.TITLE_TXT AS PREV_TITLE_TXT, prevps.STD_DESC AS PREV_STD_DESC,");
        sqlQuery1.append("	prevps.cmply_dt AS PREV_CMPLY_DT, prevps.expr_dt AS PREV_EXPR_DT, prevps.HLC_FLAG_ID AS PREV_HLC_FLAG_ID,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc = 'UPDATE' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN");
        sqlQuery1.append("	    CASE WHEN ps.std_desc =prevps.std_desc THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  ELSE");
        sqlQuery1.append("	    CASE WHEN ps.title_txt = prevps.TITLE_TXT THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS TITLE_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt))");
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'CMPLY_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS CMPLY_CHANGE,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'EXPR_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS EXPR_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'HLC_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS HLC_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.std_desc = prevps.std_desc)) THEN"); 
        sqlQuery1.append("	    	CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  ELSE"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.title_txt = prevps.TITLE_TXT)) THEN"); 
        sqlQuery1.append("	      CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt)) THEN");
        sqlQuery1.append("	        CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt)) THEN"); 
        sqlQuery1.append("	          CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'"); 
        sqlQuery1.append("	          ELSE 'CHANGED' END");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	      ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE"); 
        sqlQuery1.append("	  CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NULL) THEN 'NEW'");
        sqlQuery1.append("	  ELSE ps.stat_desc END");
        sqlQuery1.append("	END AS CHANGED_STAT");
        
        sqlQuery1.append(" FROM TAXONOMY TAX, PUBLISH_TAXONOMY_STD PTS, PREV_PUBLISH_STD prevps, SEL_PUBLISH_STD PS");
        sqlQuery1.append(" WHERE pts.taxonomy_id = TAX.PUBLISH_TAXONOMY_ID AND ps.STD_ID = prevps.STD_ID(+)");
        sqlQuery1.append(" AND (pts.publish_std_ver_id = ps.publish_std_ver_id OR pts.publish_std_ver_id = ps.prnt_std_id)),");
        
        sqlQuery1.append(" DIRECT_MATCH AS (SELECT ps.* FROM ALL_PUB_CHANGES ps WHERE (");
        if(filterByNew){
        	sqlQuery1.append(" ps.CHANGED_STAT = 'NEW'");
        	if(filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate){
        		sqlQuery1.append(" OR");
            } else {
            	sqlQuery1.append(")");
            }
        }
        
        if(filterByTextUpdate && !filterByComplianceUpdate && !filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.TITLE_CHANGE='TEXT_CHANGE'))");
        } else if(!filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
        } else if(!filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.HLC_CHANGE='HLC_CHANGE'))");
        } else if(filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
        } else if(filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
        } else if(!filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
        } else if(filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" ps.CHANGED_STAT = 'CHANGED')");
        }
        
        if (!StandardsListUtil.isNullOrBlank(idCriteria) && StandardsListUtil.isNullOrBlank(searchCriteria)) {
        	sqlQuery1.append(" AND (ps.STD_ID IN (");
            for (int i = 0; i < idCriteria.size(); i++) {
            	sqlQuery1.append(idCriteria.get(i));
            	if (i != idCriteria.size() - 1) {
            		sqlQuery1.append(StringPool.COMMA);
                }
            }
            sqlQuery1.append("))");
        }
        
        sqlQuery2.append(") (SELECT * FROM DIRECT_MATCH UNION ");
        sqlQuery2.append(" SELECT apc.INDX_ORDER, apc.TAXONOMY_ID, apc.PUBLISH_TAXONOMY_ID, apc.PRNT_PUBLISH_TAXONOMY_ID, apc.LVL, apc.HIER_LVL_NBR, apc.PUBLISH_ID, apc.PATH, apc.TAXONOMY_DESC, apc.INDEX_TITLE,"); 
        sqlQuery2.append(" apc.publish_std_ver_id, apc.prnt_std_id, apc.std_id, apc.std_typ, apc.title_txt, apc.std_desc, apc.stat_desc, apc.cmply_dt, apc.expr_dt, apc.HLC_FLAG_ID, apc.DISP_ORDER_NBR,"); 
        sqlQuery2.append(" apc.PREV_TITLE_TXT, apc.PREV_STD_DESC, apc.PREV_CMPLY_DT, apc.PREV_EXPR_DT, apc.PREV_HLC_FLAG_ID, apc.TITLE_CHANGE, apc.CMPLY_CHANGE, apc.EXPR_CHANGE, apc.HLC_CHANGE, apc.CHANGED_STAT"); 
        sqlQuery2.append(" FROM ALL_PUB_CHANGES apc WHERE apc.prnt_std_id IN (SELECT DISTINCT prnt_std_id FROM DIRECT_MATCH)");
        sqlQuery2.append(" AND apc.publish_std_ver_id NOT IN (SELECT publish_std_ver_id FROM DIRECT_MATCH))");

        if (!StandardsListUtil.isNullOrBlank(searchCriteria)) {
            if (QueryUtils.SEARCH_OPTION_ANY.equals(textSearchType) || QueryUtils.SEARCH_OPTION_EXACT.equals(textSearchType)) {
                StringBuilder search = new StringBuilder(" AND (");
                search.append("(ps.std_typ = 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(") OR");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(") OR");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(")");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(")");
                }
                if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
                	search.append(" OR (ps.STD_ID IN (");
                    for (int i = 0; i < idCriteria.size(); i++) {
                    	search.append(idCriteria.get(i));
                    	if (i != idCriteria.size() - 1) {
                    		search.append(StringPool.COMMA);
                        }
                    }
                    search.append("))");
                }
                search.append(")");

                sqlQuery3.append(search);
            } else {
              StringBuilder search = new StringBuilder(" AND (");
              search.append("(ps.std_typ = 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(") OR");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(") OR");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(")");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(")");
              }
              if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
              	search.append(" OR (ps.STD_ID IN (");
                  for (int i = 0; i < idCriteria.size(); i++) {
                  	search.append(idCriteria.get(i));
                  	if (i != idCriteria.size() - 1) {
                  		search.append(StringPool.COMMA);
                      }
                  }
                  search.append("))");
              }
              search.append(")");

              sqlQuery3.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        		!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
            StringBuilder flagQuery = new StringBuilder(" PS.PUBLISH_STD_VER_ID IN (select pubs.publish_std_ver_id from publish_flag_std pfs, publish_std pubs");
            flagQuery.append(" where pubs.publish_std_ver_id = pfs.publish_std_ver_id and pubs.publish_id = ").append(selPublishId);

            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle)) {
                hotelLifeCycleClause.add(QueryUtils.getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String hotelLifeCycleQuery = QueryUtils.buildFlagsQuery(flagQuery, hotelLifeCycleClause);
                clauses.add(new StringBuilder(hotelLifeCycleQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism)) {
                specialismClause.add(QueryUtils.getWhereClause(arlSpecialism, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String specialismQuery = QueryUtils.buildFlagsQuery(flagQuery, specialismClause);
                clauses.add(new StringBuilder(specialismQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability)) {
                hotelDeptClause.add(QueryUtils.getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id",
                        QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                String deptQuery = QueryUtils.buildFlagsQuery(flagQuery, hotelDeptClause);
                clauses.add(new StringBuilder(deptQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney)) {
                guestJourneyClause.add(QueryUtils.getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String guestQuery = QueryUtils.buildFlagsQuery(flagQuery, guestJourneyClause);
                clauses.add(new StringBuilder(guestQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
                hotelLocClause.add(QueryUtils.getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String locnQuery = QueryUtils.buildFlagsQuery(flagQuery, hotelLocClause);
                clauses.add(new StringBuilder(locnQuery));
            }
        }

        return QueryUtils.buildQuery(sqlQuery1, sqlQuery2, sqlQuery3, tables, clauses);
    }
    
    /**
     * This method will generate search query to display standards on the What Changed On screen.
     * 
     * @param localeCode This is a String object
     * @param chainCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @param selPublishId This is a String object
     * @param prevPublishId This is a String object
     * @return String
     */
    public static String getWCORemovedSearchQueryProd(String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria, String selPublishId, String prevPublishId)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> selClauses = new ArrayList<StringBuilder>();
        List<StringBuilder> prevClauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
		List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlHotelLocations = criteria.getLocHotel();
        List<String> arlGuestJourney = criteria.getGuestJourney();

        String textSearchType = criteria.getTextSearchType();
        boolean filterByNew = criteria.isFilterByNew();
        boolean filterByTextUpdate = criteria.isFilterByTextUpdate();
        boolean filterByComplianceUpdate = criteria.isFilterByComplianceUpdate();
        boolean filterByLifecycleUpdate = criteria.isFilterByLifecycleUpdate();
        boolean filterByRemoved = criteria.isFilterByRemoved();
        boolean directMatchSearch = false;
        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();
        StringBuilder sqlQuery4 = new StringBuilder();

        sqlQuery1.append("WITH ");
        sqlQuery1.append(getProdTaxonomyTempTable("SEL_PUB_TAXONOMY", selPublishId, localeCode));
        sqlQuery1.append(StringPool.COMMA);
        sqlQuery1.append(getProdTaxonomyTempTable("PREV_PUB_TAXONOMY", prevPublishId, localeCode));
        sqlQuery1.append(StringPool.COMMA);
        sqlQuery1.append(getProdRemovedTaxonomyTempTable());
        sqlQuery1.append(StringPool.COMMA);
                
        sqlQuery1.append(" LIFECYCLE_FLAGS AS (SELECT flag_catgy_id FROM flag_catgy WHERE prnt_flag_catgy_id=91 AND actv_ind='Y' ORDER BY disp_order_nbr),");
        
        sqlQuery1.append(" SEL_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(selPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(prevPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH_STD AS (SELECT ps.PUBLISH_STD_VER_ID, ps.prnt_std_id, (SELECT STD_ID FROM PUBLISH_STD WHERE PUBLISH_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.STD_ID, ps.STD_TYP,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.TITLE_TXT), NULL, TRIM(ps.TITLE_TXT), TRIM(sx.TITLE_TXT)) AS TITLE_TXT,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.STD_DESC), NULL, TRIM(ps.STD_DESC), TRIM(sx.STD_DESC)) AS STD_DESC,");
        sqlQuery1.append(" 	CASE WHEN TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > pp.PUBLISH_DT THEN");
        sqlQuery1.append("	pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt, pcs.publish_stat_cd AS stat_desc, pcs.disp_order_nbr,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.PUBLISH_STD_VER_ID)");
        sqlQuery1.append(" 		FROM PUBLISH_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.PUBLISH_STD_VER_ID = pfs.PUBLISH_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.PUBLISH_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM PREV_PUBLISH pp, PUBLISH_STD ps, PUBLISH_CTRY_STD PCS, PUBLISH_STD_XLAT SX");
        sqlQuery1.append(" 	WHERE pp.PUBLISH_ID = ps.PUBLISH_ID");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id=pcs.publish_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd='").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id=sx.publish_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("'= sx.locale_cd(+)),");
        
        sqlQuery1.append(" SEL_PUBLISH_STD AS (SELECT ps.publish_std_ver_id, (SELECT STD_ID FROM PUBLISH_STD WHERE PUBLISH_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.prnt_std_id, ps.std_id, ps.std_typ,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.title_txt), NULL, TRIM(ps.title_txt), TRIM(sx.title_txt)) AS title_txt,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.std_desc), NULL, TRIM(ps.std_desc), TRIM(sx.std_desc)) AS std_desc,");
        sqlQuery1.append("	CASE WHEN (TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > sp.PUBLISH_DT AND pcs.std_cmply_deadline_dt > SYSDATE) THEN pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt,");
        sqlQuery1.append(" 	pcs.ctry_nm_cd, sx.locale_cd, pcs.publish_stat_cd AS stat_desc, pcs.disp_order_nbr,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.PUBLISH_STD_VER_ID)");
        sqlQuery1.append(" 		FROM PUBLISH_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.PUBLISH_STD_VER_ID = pfs.PUBLISH_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.PUBLISH_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM SEL_PUBLISH sp, PUBLISH_STD ps, PUBLISH_STD_XLAT SX, PUBLISH_CTRY_STD pcs WHERE sp.PUBLISH_ID = ps.PUBLISH_ID");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id = pcs.publish_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd = '").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.publish_std_ver_id = sx.publish_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("' = sx.locale_cd(+)),");

        sqlQuery1.append("	PREV_PUBLISH_TAXONOMY_STD AS (SELECT DISTINCT pts.PUBLISH_STD_VER_ID, pts.TAXONOMY_ID FROM PUBLISH_TAXONOMY_STD pts, PREV_PUBLISH_STD pps WHERE pts.publish_std_ver_id = pps.prnt_std_id),");
        
        sqlQuery1.append("	SEL_PUBLISH_TAXONOMY_STD AS (SELECT DISTINCT pts.PUBLISH_STD_VER_ID, pts.TAXONOMY_ID FROM PUBLISH_TAXONOMY_STD pts, SEL_PUBLISH_STD sps WHERE pts.publish_std_ver_id = sps.prnt_std_id),");
        
        sqlQuery1.append("  ALL_PUB_CHANGES AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.SEL_PUBLISH_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID, TAX.PRNT_PUBLISH_TAXONOMY_ID,");
        sqlQuery1.append(" 	TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE,");
        sqlQuery1.append(" 	ps.publish_std_ver_id, ps.prnt_std_id, ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc,");
        sqlQuery1.append(" 	ps.cmply_dt, ps.expr_dt, ps.HLC_FLAG_ID, ps.DISP_ORDER_NBR, prevps.TITLE_TXT AS PREV_TITLE_TXT, prevps.STD_DESC AS PREV_STD_DESC,");
        sqlQuery1.append("	prevps.cmply_dt AS PREV_CMPLY_DT, prevps.expr_dt AS PREV_EXPR_DT, prevps.HLC_FLAG_ID AS PREV_HLC_FLAG_ID,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc = 'UPDATE' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN");
        sqlQuery1.append("	    CASE WHEN ps.std_desc =prevps.std_desc THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  ELSE");
        sqlQuery1.append("	    CASE WHEN ps.title_txt = prevps.TITLE_TXT THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS TITLE_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt))");
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'CMPLY_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS CMPLY_CHANGE,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'EXPR_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS EXPR_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'HLC_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS HLC_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.std_desc = prevps.std_desc)) THEN"); 
        sqlQuery1.append("	    	CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  ELSE"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.title_txt = prevps.TITLE_TXT)) THEN"); 
        sqlQuery1.append("	      CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt)) THEN");
        sqlQuery1.append("	        CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt)) THEN"); 
        sqlQuery1.append("	          CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'"); 
        sqlQuery1.append("	          ELSE 'CHANGED' END");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	      ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE"); 
        sqlQuery1.append("	  CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NULL) THEN 'NEW'");
        sqlQuery1.append("	  ELSE ps.stat_desc END");
        sqlQuery1.append("	END AS CHANGED_STAT,");
        sqlQuery1.append(" DECODE(prevps.prnt_std_id, NULL, ps.prnt_std_id, prevps.prnt_std_id) AS prev_prnt_std_id, ps.MAIN_PRNT_STD_ID");
        sqlQuery1.append(" FROM TAXONOMY TAX, SEL_PUBLISH_TAXONOMY_STD PTS, PREV_PUBLISH_STD prevps, SEL_PUBLISH_STD PS");
        sqlQuery1.append(" WHERE pts.taxonomy_id = TAX.SEL_PUBLISH_TAXONOMY_ID AND ps.STD_ID = prevps.STD_ID(+)");
        sqlQuery1.append(" AND pts.publish_std_ver_id = ps.prnt_std_id),");
        //sqlQuery1.append(" AND (pts.publish_std_ver_id = ps.publish_std_ver_id OR pts.publish_std_ver_id = ps.prnt_std_id)),");
        
        if(filterByNew || filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate){
        	directMatchSearch = true;
	        sqlQuery1.append(" DIRECT_MATCH AS (SELECT ps.* FROM ALL_PUB_CHANGES ps WHERE (");
	        
	        if(filterByNew){
	        	sqlQuery1.append(" ps.CHANGED_STAT = 'NEW'");
	        	if(filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate){
	        		sqlQuery1.append(" OR");
	            } else {
	            	sqlQuery1.append(")");
	            }
	        }
	        
	        if(filterByTextUpdate && !filterByComplianceUpdate && !filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.TITLE_CHANGE='TEXT_CHANGE'))");
	        } else if(!filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
	        } else if(!filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.HLC_CHANGE='HLC_CHANGE'))");
	        } else if(filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
	        } else if(filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
	        } else if(!filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
	        } else if(filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" ps.CHANGED_STAT = 'CHANGED')");
	        }
	        
	        if (!StandardsListUtil.isNullOrBlank(idCriteria) && StandardsListUtil.isNullOrBlank(searchCriteria)) {
	        	sqlQuery1.append(" AND (ps.STD_ID IN (");
	            for (int i = 0; i < idCriteria.size(); i++) {
	            	sqlQuery1.append(idCriteria.get(i));
	            	if (i != idCriteria.size() - 1) {
	            		sqlQuery1.append(StringPool.COMMA);
	                }
	            }
	            sqlQuery1.append("))");
	        }
	        
	        sqlQuery2.append("),");
        }
        
        sqlQuery2.append(" RMD_SEARCH_STD AS (SELECT ps.STD_ID, ps.PRNT_STD_ID, ps.MAIN_PRNT_STD_ID FROM PREV_PUBLISH_STD ps WHERE ps.STD_ID NOT IN (SELECT STD_ID FROM SEL_PUBLISH_STD sps)");
        if (!StandardsListUtil.isNullOrBlank(idCriteria) && StandardsListUtil.isNullOrBlank(searchCriteria)) {
        	sqlQuery2.append(" AND (ps.STD_ID IN (");
            for (int i = 0; i < idCriteria.size(); i++) {
            	sqlQuery2.append(idCriteria.get(i));
            	if (i != idCriteria.size() - 1) {
            		sqlQuery2.append(StringPool.COMMA);
                }
            }
            sqlQuery2.append("))");
        }
        sqlQuery3.append("),");
        
        sqlQuery3.append("	ALL_RMD_STD AS (SELECT ps.STD_ID, ps.PRNT_STD_ID, ps.MAIN_PRNT_STD_ID FROM PREV_PUBLISH_STD ps WHERE ps.STD_ID NOT IN (SELECT STD_ID FROM SEL_PUBLISH_STD sps)),");
        
        sqlQuery3.append("	RMD_STD AS (SELECT * FROM ALL_RMD_STD WHERE");
        if(filterByRemoved && (filterByNew || filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate)){
        	sqlQuery3.append(" PRNT_STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM RMD_SEARCH_STD) OR MAIN_PRNT_STD_ID IN (SELECT DISTINCT MAIN_PRNT_STD_ID FROM DIRECT_MATCH)),");
        } else if(!filterByRemoved && (filterByNew || filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate)){
        	sqlQuery3.append("	MAIN_PRNT_STD_ID IN (SELECT DISTINCT MAIN_PRNT_STD_ID FROM DIRECT_MATCH)),");
        } else {
        	sqlQuery3.append("	PRNT_STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM RMD_SEARCH_STD)),");
        }
        
        sqlQuery3.append(" 	RMD_PRNT_CHILD_PREV_STDS AS (SELECT STD_ID, PRNT_STD_ID, MAIN_PRNT_STD_ID FROM PREV_PUBLISH_STD WHERE PRNT_STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM RMD_STD)");
        sqlQuery3.append(" 		AND STD_ID NOT IN (SELECT DISTINCT STD_ID FROM RMD_STD)),"); 
        
        sqlQuery3.append(" 	RMD_PRNT_CHILD_CUR_STDS AS (SELECT STD_ID, PRNT_STD_ID, MAIN_PRNT_STD_ID FROM SEL_PUBLISH_STD WHERE PRNT_STD_ID IN (");
        sqlQuery3.append(" 	SELECT DISTINCT PRNT_STD_ID FROM SEL_PUBLISH_STD WHERE STD_ID IN (SELECT STD_ID FROM RMD_PRNT_CHILD_PREV_STDS))),");
                
        sqlQuery3.append(" RMD_MISS_PUB_CHANGES AS (SELECT * FROM ALL_PUB_CHANGES WHERE STD_ID IN (SELECT STD_ID FROM RMD_PRNT_CHILD_CUR_STDS))");
        
        sqlQuery3.append(" SELECT * FROM RMD_MISS_PUB_CHANGES UNION");
        sqlQuery3.append(" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.SEL_PUBLISH_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID, TAX.PRNT_PUBLISH_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC,"); 
        sqlQuery3.append("   TAX.TITLE_TXT AS INDEX_TITLE, pps.publish_std_ver_id,");
        sqlQuery3.append("   DECODE((SELECT PRNT_STD_ID FROM RMD_PRNT_CHILD_CUR_STDS WHERE STD_ID=pps.MAIN_PRNT_STD_ID), NULL, pps.prnt_std_id,");
        sqlQuery3.append("	(SELECT PRNT_STD_ID FROM RMD_PRNT_CHILD_CUR_STDS WHERE STD_ID=pps.MAIN_PRNT_STD_ID)) AS prnt_std_id,");
        sqlQuery3.append("	 pps.std_id, pps.std_typ, pps.title_txt, pps.std_desc, 'REMOVED' AS stat_desc, NULL AS cmply_dt, NULL AS expr_dt, NULL AS HLC_FLAG_ID,");  
        sqlQuery3.append("   pps.DISP_ORDER_NBR, NULL AS PREV_TITLE_TXT, NULL AS PREV_STD_DESC,	NULL AS PREV_CMPLY_DT, NULL AS PREV_EXPR_DT, NULL AS PREV_HLC_FLAG_ID,");
        sqlQuery3.append("   NULL AS TITLE_CHANGE, NULL AS CMPLY_CHANGE, NULL AS EXPR_CHANGE, NULL AS HLC_CHANGE, 'REMOVED' AS CHANGED_STAT,");
        sqlQuery3.append("   pps.prnt_std_id AS prev_prnt_std_id, pps.MAIN_PRNT_STD_ID");
        sqlQuery3.append("   FROM TAXONOMY TAX, PREV_PUBLISH_TAXONOMY_STD PTS, PREV_PUBLISH_STD pps, RMD_STD rs");
        sqlQuery3.append("   WHERE pts.taxonomy_id = TAX.PUBLISH_TAXONOMY_ID");
        sqlQuery3.append("   AND pps.STD_ID=rs.STD_ID AND pts.publish_std_ver_id = pps.prnt_std_id"); 
        //sqlQuery3.append("   AND  (pts.publish_std_ver_id = pps.publish_std_ver_id OR pts.publish_std_ver_id = pps.prnt_std_id)"); 

        if (!StandardsListUtil.isNullOrBlank(searchCriteria)) {
            if (QueryUtils.SEARCH_OPTION_ANY.equals(textSearchType) || QueryUtils.SEARCH_OPTION_EXACT.equals(textSearchType)) {
                StringBuilder search = new StringBuilder(" AND (");
                search.append("(ps.std_typ = 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(") OR");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(") OR");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(")");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(")");
                }
                if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
                	search.append(" OR (ps.STD_ID IN (");
                    for (int i = 0; i < idCriteria.size(); i++) {
                    	search.append(idCriteria.get(i));
                    	if (i != idCriteria.size() - 1) {
                    		search.append(StringPool.COMMA);
                        }
                    }
                    search.append("))");
                }
                search.append(")");

                sqlQuery4.append(search);
            } else {
              StringBuilder search = new StringBuilder(" AND (");
              search.append("(ps.std_typ = 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(") OR");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(") OR");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(")");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(")");
              }
              if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
            	  search.append(" OR (ps.STD_ID IN (");
            	  for (int i = 0; i < idCriteria.size(); i++) {
            		  search.append(idCriteria.get(i));
            		  if (i != idCriteria.size() - 1) {
            			  search.append(StringPool.COMMA);
            		  }
            	  }
            	  search.append("))");
              }
              search.append(")");

              sqlQuery4.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        		!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
        	StringBuilder selFlagQuery = new StringBuilder(" PS.PUBLISH_STD_VER_ID IN (select pubs.publish_std_ver_id from publish_flag_std pfs, SEL_PUBLISH_STD pubs");
        	selFlagQuery.append(" where pubs.publish_std_ver_id = pfs.publish_std_ver_id");
            
        	StringBuilder prevFlagQuery = new StringBuilder(" PS.PUBLISH_STD_VER_ID IN (select pubs.publish_std_ver_id from publish_flag_std pfs, PREV_PUBLISH_STD pubs");
        	prevFlagQuery.append(" where pubs.publish_std_ver_id = pfs.publish_std_ver_id");
            
            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle)) {
                hotelLifeCycleClause.add(QueryUtils.getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, hotelLifeCycleClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, hotelLifeCycleClause)));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism)) {
                specialismClause.add(QueryUtils.getWhereClause(arlSpecialism, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, specialismClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, specialismClause)));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability)) {
                hotelDeptClause.add(QueryUtils.getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id",
                        QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, hotelDeptClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, hotelDeptClause)));
            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney)) {
                guestJourneyClause.add(QueryUtils.getWhereClause(arlGuestJourney, "pfs.flag_catgy_id",
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, guestJourneyClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, guestJourneyClause)));
            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
                hotelLocClause.add(QueryUtils.getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, hotelLocClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, hotelLocClause)));
            }
        }

        return buildWCORemovedQuery(sqlQuery1, sqlQuery2, sqlQuery3, sqlQuery4, tables, selClauses, prevClauses, directMatchSearch);
    }

    /**
     * This method will generate search query to display standards on the What Changed On screen.
     * 
     * @param localeCode This is a String object
     * @param chainCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @param selPublishId This is a String object
     * @param prevPublishId This is a String object
     * @return String
     */
    public static String getWCOSearchQueryStage(String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria, String selPublishId, String prevPublishId)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlHotelLocations = criteria.getLocHotel();
        List<String> arlGuestJourney = criteria.getGuestJourney();
        
        String textSearchType = criteria.getTextSearchType();
        boolean filterByNew = criteria.isFilterByNew();
        boolean filterByTextUpdate = criteria.isFilterByTextUpdate();
        boolean filterByComplianceUpdate = criteria.isFilterByComplianceUpdate();
        boolean filterByLifecycleUpdate = criteria.isFilterByLifecycleUpdate();

        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();

        sqlQuery1.append("WITH ");
        sqlQuery1.append(getStageTaxonomyTempTable("TAXONOMY", selPublishId, localeCode));
        sqlQuery1.append(StringPool.COMMA);
        
        sqlQuery1.append(" LIFECYCLE_FLAGS AS (SELECT flag_catgy_id FROM flag_catgy WHERE prnt_flag_catgy_id=91 AND actv_ind='Y' ORDER BY disp_order_nbr),");
        
        sqlQuery1.append(" SEL_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(selPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(prevPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH_STD AS (SELECT ps.STAGE_STD_VER_ID, ps.prnt_std_id, (SELECT STD_ID FROM STAGE_STD WHERE STAGE_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.STD_ID, ps.STD_TYP,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.TITLE_TXT), NULL, TRIM(ps.TITLE_TXT), TRIM(sx.TITLE_TXT)) AS TITLE_TXT,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.STD_DESC), NULL, TRIM(ps.STD_DESC), TRIM(sx.STD_DESC)) AS STD_DESC,");
        sqlQuery1.append(" 	CASE WHEN TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > pp.PUBLISH_DT THEN");
        sqlQuery1.append("	pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.STAGE_STD_VER_ID)");
        sqlQuery1.append(" 		FROM STAGE_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.STAGE_STD_VER_ID = pfs.STAGE_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.STAGE_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM PREV_PUBLISH pp, STAGE_STD ps, STAGE_CTRY_STD PCS, STAGE_STD_XLAT SX");
        sqlQuery1.append(" 	WHERE pp.PUBLISH_ID = ps.PUBLISH_ID");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id=pcs.stage_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd='").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id=sx.stage_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("'= sx.locale_cd(+)),");
        
        sqlQuery1.append(" SEL_PUBLISH_STD AS (SELECT ps.STAGE_STD_VER_ID, ps.prnt_std_id, (SELECT STD_ID FROM STAGE_STD WHERE STAGE_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.std_id, ps.std_typ,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.title_txt), NULL, TRIM(ps.title_txt), TRIM(sx.title_txt)) AS title_txt,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.std_desc), NULL, TRIM(ps.std_desc), TRIM(sx.std_desc)) AS std_desc,");
        sqlQuery1.append("	CASE WHEN (TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > sp.PUBLISH_DT AND pcs.std_cmply_deadline_dt > SYSDATE) THEN pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt,");
        sqlQuery1.append(" 	pcs.ctry_nm_cd, sx.locale_cd, pcs.publish_stat_cd AS stat_desc, pcs.disp_order_nbr,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.STAGE_STD_VER_ID)");
        sqlQuery1.append(" 		FROM STAGE_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.STAGE_STD_VER_ID = pfs.STAGE_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.STAGE_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM SEL_PUBLISH sp, STAGE_STD ps, STAGE_STD_XLAT SX, STAGE_CTRY_STD pcs");
        sqlQuery1.append(" 	WHERE sp.PUBLISH_ID = ps.publish_id");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id = pcs.stage_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd = '").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id = sx.stage_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("' = sx.locale_cd(+)),");
        
        sqlQuery1.append(" ALL_PUB_CHANGES AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.STAGE_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID, TAX.PRNT_STAGE_TAXONOMY_ID AS PRNT_PUBLISH_TAXONOMY_ID,");
        sqlQuery1.append(" 	TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE,");
        sqlQuery1.append(" 	ps.STAGE_STD_VER_ID AS publish_std_ver_id, ps.prnt_std_id, ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc,");
        sqlQuery1.append(" 	ps.cmply_dt, ps.expr_dt, ps.HLC_FLAG_ID, ps.DISP_ORDER_NBR, prevps.TITLE_TXT AS PREV_TITLE_TXT, prevps.STD_DESC AS PREV_STD_DESC,");
        sqlQuery1.append("	prevps.cmply_dt AS PREV_CMPLY_DT, prevps.expr_dt AS PREV_EXPR_DT, prevps.HLC_FLAG_ID AS PREV_HLC_FLAG_ID,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc = 'UPDATE' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN");
        sqlQuery1.append("	    CASE WHEN ps.std_desc =prevps.std_desc THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  ELSE");
        sqlQuery1.append("	    CASE WHEN ps.title_txt = prevps.TITLE_TXT THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS TITLE_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt))");
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'CMPLY_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS CMPLY_CHANGE,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'EXPR_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS EXPR_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'HLC_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS HLC_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.std_desc = prevps.std_desc)) THEN"); 
        sqlQuery1.append("	    	CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  ELSE"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.title_txt = prevps.TITLE_TXT)) THEN"); 
        sqlQuery1.append("	      CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt)) THEN");
        sqlQuery1.append("	        CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt)) THEN"); 
        sqlQuery1.append("	          CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'"); 
        sqlQuery1.append("	          ELSE 'CHANGED' END");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	      ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE"); 
        sqlQuery1.append("	  CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NULL) THEN 'NEW'");
        sqlQuery1.append("	  ELSE ps.stat_desc END"); 
        sqlQuery1.append("	END AS CHANGED_STAT");
        
        sqlQuery1.append(" FROM TAXONOMY TAX, STAGE_TAXONOMY_STD PTS, PREV_PUBLISH_STD prevps, SEL_PUBLISH_STD PS");
        sqlQuery1.append(" WHERE pts.taxonomy_id = TAX.STAGE_TAXONOMY_ID AND ps.STD_ID = prevps.STD_ID(+)");
        sqlQuery1.append(" AND (pts.stage_std_ver_id = ps.stage_std_ver_id OR pts.stage_std_ver_id = ps.prnt_std_id)),");
        
        sqlQuery1.append(" DIRECT_MATCH AS (SELECT * FROM ALL_PUB_CHANGES ps WHERE (");
        if(filterByNew){
        	sqlQuery1.append(" ps.CHANGED_STAT = 'NEW'");
        	if(filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate){
        		sqlQuery1.append(" OR");
            } else {
            	sqlQuery1.append(")");
            }
        }
        
        if(filterByTextUpdate && !filterByComplianceUpdate && !filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.TITLE_CHANGE='TEXT_CHANGE'))");
        } else if(!filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
        } else if(!filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.HLC_CHANGE='HLC_CHANGE'))");
        } else if(filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
        } else if(filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
        } else if(!filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
        } else if(filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
        	sqlQuery1.append(" ps.CHANGED_STAT = 'CHANGED')");
        }
        
        if (!StandardsListUtil.isNullOrBlank(idCriteria) && StandardsListUtil.isNullOrBlank(searchCriteria)) {
        	sqlQuery1.append(" AND (ps.STD_ID IN (");
            for (int i = 0; i < idCriteria.size(); i++) {
            	sqlQuery1.append(idCriteria.get(i));
            	if (i != idCriteria.size() - 1) {
            		sqlQuery1.append(StringPool.COMMA);
                }
            }
            sqlQuery1.append("))");
        }
        
        sqlQuery2.append(") ( SELECT * FROM DIRECT_MATCH UNION ");
        sqlQuery2.append(" SELECT apc.INDX_ORDER, apc.TAXONOMY_ID, apc.PUBLISH_TAXONOMY_ID, apc.PRNT_PUBLISH_TAXONOMY_ID, apc.LVL, apc.HIER_LVL_NBR, apc.PUBLISH_ID, apc.PATH, apc.TAXONOMY_DESC, apc.INDEX_TITLE,"); 
        sqlQuery2.append(" apc.publish_std_ver_id, apc.prnt_std_id, apc.std_id, apc.std_typ, apc.title_txt, apc.std_desc, apc.stat_desc, apc.cmply_dt, apc.expr_dt, apc.HLC_FLAG_ID, apc.DISP_ORDER_NBR,"); 
        sqlQuery2.append(" apc.PREV_TITLE_TXT, apc.PREV_STD_DESC, apc.PREV_CMPLY_DT, apc.PREV_EXPR_DT, apc.PREV_HLC_FLAG_ID, apc.TITLE_CHANGE, apc.CMPLY_CHANGE, apc.EXPR_CHANGE, apc.HLC_CHANGE, apc.CHANGED_STAT"); 
        sqlQuery2.append(" FROM ALL_PUB_CHANGES apc WHERE apc.prnt_std_id IN (SELECT DISTINCT prnt_std_id FROM DIRECT_MATCH)");
        sqlQuery2.append(" AND apc.publish_std_ver_id NOT IN (SELECT publish_std_ver_id FROM DIRECT_MATCH))");

        if (!StandardsListUtil.isNullOrBlank(searchCriteria)) {
            if (QueryUtils.SEARCH_OPTION_ANY.equals(textSearchType) || QueryUtils.SEARCH_OPTION_EXACT.equals(textSearchType)) {
                StringBuilder search = new StringBuilder(" AND ( ");
                search.append("(ps.std_typ = 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(") OR");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(") OR");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(")");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(")");
                }
                if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
                	search.append(" OR (ps.STD_ID IN (");
                    for (int i = 0; i < idCriteria.size(); i++) {
                    	search.append(idCriteria.get(i));
                    	if (i != idCriteria.size() - 1) {
                    		search.append(StringPool.COMMA);
                        }
                    }
                    search.append("))");
                }
                search.append(")");

                sqlQuery3.append(search);
            } else {
              StringBuilder search = new StringBuilder(" AND ( ");
              search.append("(ps.std_typ = 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(") OR");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(") OR");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(")");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(")");
              }
              if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
                	search.append(" OR (ps.STD_ID IN (");
                    for (int i = 0; i < idCriteria.size(); i++) {
                    	search.append(idCriteria.get(i));
                    	if (i != idCriteria.size() - 1) {
                    		search.append(StringPool.COMMA);
                        }
                    }
                    search.append("))");
                }
              search.append(")");

              sqlQuery3.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        		!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
            StringBuilder flagQuery = new StringBuilder(" PS.PUBLISH_STD_VER_ID IN (select pubs.stage_std_ver_id from stage_flag_std pfs, stage_std pubs");
            flagQuery.append(" where pubs.stage_std_ver_id = pfs.stage_std_ver_id and pubs.PUBLISH_ID = ").append(selPublishId);

            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle)) {
                hotelLifeCycleClause.add(QueryUtils.getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String hotelLifeCycleQuery = QueryUtils.buildFlagsQuery(flagQuery, hotelLifeCycleClause);
                clauses.add(new StringBuilder(hotelLifeCycleQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism)) {
                specialismClause.add(QueryUtils.getWhereClause(arlSpecialism, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String specialismQuery = QueryUtils.buildFlagsQuery(flagQuery, specialismClause);
                clauses.add(new StringBuilder(specialismQuery));
            }

            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability)) {
                hotelDeptClause.add(QueryUtils.getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id",
                        QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                String deptQuery = QueryUtils.buildFlagsQuery(flagQuery, hotelDeptClause);
                clauses.add(new StringBuilder(deptQuery));

            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney)) {
                guestJourneyClause.add(QueryUtils.getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String guestQuery = QueryUtils.buildFlagsQuery(flagQuery, guestJourneyClause);
                clauses.add(new StringBuilder(guestQuery));

            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
                hotelLocClause.add(QueryUtils.getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", QueryUtils.COLUMN_TYPE_NUMBER_START,
                        QueryUtils.COLUMN_TYPE_NUMBER_END));
                String locnQuery = QueryUtils.buildFlagsQuery(flagQuery, hotelLocClause);
                clauses.add(new StringBuilder(locnQuery));
            }
        }

        return QueryUtils.buildQuery(sqlQuery1, sqlQuery2, sqlQuery3, tables, clauses);
    }

    /**
     * This method will generate search query to display standards on the What Changed On screen.
     * 
     * @param localeCode This is a String object
     * @param chainCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @param selPublishId This is a String object
     * @param prevPublishId This is a String object
     * @return String
     */
    public static String getWCORemovedSearchQueryStage(String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria, String selPublishId, String prevPublishId)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> selClauses = new ArrayList<StringBuilder>();
        List<StringBuilder> prevClauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
		List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlHotelLocations = criteria.getLocHotel();
        List<String> arlGuestJourney = criteria.getGuestJourney();
        
        String textSearchType = criteria.getTextSearchType();
        boolean filterByNew = criteria.isFilterByNew();
        boolean filterByTextUpdate = criteria.isFilterByTextUpdate();
        boolean filterByComplianceUpdate = criteria.isFilterByComplianceUpdate();
        boolean filterByLifecycleUpdate = criteria.isFilterByLifecycleUpdate();
        boolean filterByRemoved = criteria.isFilterByRemoved();
        boolean directMatchSearch = false;
        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();
        StringBuilder sqlQuery4 = new StringBuilder();

        sqlQuery1.append("WITH ");
        sqlQuery1.append(getStageTaxonomyTempTable("SEL_PUB_TAXONOMY", selPublishId, localeCode));
        sqlQuery1.append(StringPool.COMMA);
        sqlQuery1.append(getStageTaxonomyTempTable("PREV_PUB_TAXONOMY", prevPublishId, localeCode));
        sqlQuery1.append(StringPool.COMMA);
        sqlQuery1.append(getStageRemovedTaxonomyTempTable());
        sqlQuery1.append(StringPool.COMMA);

        sqlQuery1.append(" LIFECYCLE_FLAGS AS (SELECT flag_catgy_id FROM flag_catgy WHERE prnt_flag_catgy_id=91 AND actv_ind='Y' ORDER BY disp_order_nbr),");
        
        sqlQuery1.append(" SEL_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(selPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(prevPublishId).append("),");
        
        sqlQuery1.append(" PREV_PUBLISH_STD AS (SELECT ps.STAGE_STD_VER_ID, ps.prnt_std_id, (SELECT STD_ID FROM STAGE_STD WHERE STAGE_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.STD_ID, ps.STD_TYP,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.TITLE_TXT), NULL, TRIM(ps.TITLE_TXT), TRIM(sx.TITLE_TXT)) AS TITLE_TXT,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.STD_DESC), NULL, TRIM(ps.STD_DESC), TRIM(sx.STD_DESC)) AS STD_DESC,");
        sqlQuery1.append(" 	CASE WHEN TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > pp.PUBLISH_DT THEN");
        sqlQuery1.append("	pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt, pcs.publish_stat_cd AS stat_desc, pcs.disp_order_nbr,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.STAGE_STD_VER_ID)");
        sqlQuery1.append(" 		FROM STAGE_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.STAGE_STD_VER_ID = pfs.STAGE_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.STAGE_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM PREV_PUBLISH pp, STAGE_STD ps, STAGE_CTRY_STD PCS, STAGE_STD_XLAT SX");
        sqlQuery1.append(" 	WHERE pp.PUBLISH_ID = ps.PUBLISH_ID");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id=pcs.stage_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd='").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id=sx.stage_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("'= sx.locale_cd(+)),");
        
        sqlQuery1.append(" SEL_PUBLISH_STD AS (SELECT ps.STAGE_STD_VER_ID, ps.prnt_std_id, (SELECT STD_ID FROM STAGE_STD WHERE STAGE_STD_VER_ID=ps.prnt_std_id) AS MAIN_PRNT_STD_ID, ps.std_id, ps.std_typ,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.title_txt), NULL, TRIM(ps.title_txt), TRIM(sx.title_txt)) AS title_txt,");
        sqlQuery1.append(" 	DECODE(TRIM(sx.std_desc), NULL, TRIM(ps.std_desc), TRIM(sx.std_desc)) AS std_desc,");
        sqlQuery1.append("	CASE WHEN (TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > sp.PUBLISH_DT AND pcs.std_cmply_deadline_dt > SYSDATE) THEN pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt, pcs.expr_dt,");
        sqlQuery1.append(" 	pcs.ctry_nm_cd, sx.locale_cd, pcs.publish_stat_cd AS stat_desc, pcs.disp_order_nbr,");
        sqlQuery1.append(" 	(SELECT LISTAGG(pfs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY  pfs.STAGE_STD_VER_ID)");
        sqlQuery1.append(" 		FROM STAGE_FLAG_STD pfs, LIFECYCLE_FLAGS lf");
        sqlQuery1.append(" 		WHERE ps.STAGE_STD_VER_ID = pfs.STAGE_STD_VER_ID AND pfs.flag_catgy_id=lf.flag_catgy_id");
        sqlQuery1.append(" 		GROUP BY pfs.STAGE_STD_VER_ID) AS HLC_FLAG_ID");
        sqlQuery1.append(" 	FROM SEL_PUBLISH sp, STAGE_STD ps, STAGE_STD_XLAT SX, STAGE_CTRY_STD pcs");
        sqlQuery1.append(" 	WHERE sp.PUBLISH_ID = ps.publish_id");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id = pcs.stage_std_ver_id");
        sqlQuery1.append(" 	AND pcs.ctry_nm_cd = '").append(countryCode).append("'");
        sqlQuery1.append(" 	AND ps.stage_std_ver_id = sx.stage_std_ver_id(+)");
        sqlQuery1.append(" 	AND '").append(localeCode).append("' = sx.locale_cd(+)),");
        
        sqlQuery1.append("	PREV_STAGE_TAXONOMY_STD AS (SELECT DISTINCT pts.STAGE_STD_VER_ID, pts.TAXONOMY_ID FROM STAGE_TAXONOMY_STD pts, PREV_PUBLISH_STD pps WHERE pts.STAGE_STD_VER_ID = pps.prnt_std_id),");
        
        sqlQuery1.append("	SEL_STAGE_TAXONOMY_STD AS (SELECT DISTINCT pts.STAGE_STD_VER_ID, pts.TAXONOMY_ID FROM STAGE_TAXONOMY_STD pts, SEL_PUBLISH_STD sps WHERE pts.STAGE_STD_VER_ID = sps.prnt_std_id),");
        
        sqlQuery1.append(" ALL_PUB_CHANGES AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.SEL_STAGE_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID, TAX.PRNT_STAGE_TAXONOMY_ID AS PRNT_PUBLISH_TAXONOMY_ID,");
        sqlQuery1.append(" 	TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC, TAX.TITLE_TXT AS INDEX_TITLE,");
        sqlQuery1.append(" 	ps.STAGE_STD_VER_ID AS publish_std_ver_id, ps.prnt_std_id, ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc,");
        sqlQuery1.append(" 	ps.cmply_dt, ps.expr_dt, ps.HLC_FLAG_ID, ps.DISP_ORDER_NBR, prevps.TITLE_TXT AS PREV_TITLE_TXT, prevps.STD_DESC AS PREV_STD_DESC,");
        sqlQuery1.append("	prevps.cmply_dt AS PREV_CMPLY_DT, prevps.expr_dt AS PREV_EXPR_DT, prevps.HLC_FLAG_ID AS PREV_HLC_FLAG_ID,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc = 'UPDATE' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN");
        sqlQuery1.append("	    CASE WHEN ps.std_desc =prevps.std_desc THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  ELSE");
        sqlQuery1.append("	    CASE WHEN ps.title_txt = prevps.TITLE_TXT THEN 'NO_CHANGE' ELSE 'TEXT_CHANGE' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS TITLE_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt))");
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'CMPLY_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS CMPLY_CHANGE,");
        
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND ps.std_typ != 'GDLN' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'EXPR_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS EXPR_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID))"); 
        sqlQuery1.append("	  THEN 'NO_CHANGE' ELSE 'HLC_CHANGE' END");
        sqlQuery1.append("	ELSE 'NO_CHANGE' END AS HLC_CHANGE,");
        	
        sqlQuery1.append("	CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NOT NULL) THEN");
        sqlQuery1.append("	  CASE WHEN ps.std_typ='GDLN' THEN"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.std_desc = prevps.std_desc)) THEN"); 
        sqlQuery1.append("	    	CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  ELSE"); 
        sqlQuery1.append("	    CASE WHEN (ps.stat_desc = 'NO_CHANGE' OR (ps.stat_desc = 'UPDATE' AND ps.title_txt = prevps.TITLE_TXT)) THEN"); 
        sqlQuery1.append("	      CASE WHEN (DECODE(ps.cmply_dt, NULL, 'NULL', ps.cmply_dt)  = DECODE(prevps.cmply_dt, NULL, 'NULL', prevps.cmply_dt)) THEN");
        sqlQuery1.append("	        CASE WHEN (DECODE(ps.expr_dt, NULL, 'NULL', ps.expr_dt) = DECODE(prevps.expr_dt, NULL, 'NULL', prevps.expr_dt)) THEN"); 
        sqlQuery1.append("	          CASE WHEN (DECODE(ps.HLC_FLAG_ID, NULL, 'NULL', ps.HLC_FLAG_ID) = DECODE(prevps.HLC_FLAG_ID, NULL, 'NULL', prevps.HLC_FLAG_ID)) THEN 'NO_CHANGE'"); 
        sqlQuery1.append("	          ELSE 'CHANGED' END");
        sqlQuery1.append("	        ELSE 'CHANGED' END");
        sqlQuery1.append("	      ELSE 'CHANGED' END");
        sqlQuery1.append("	    ELSE 'CHANGED' END");
        sqlQuery1.append("	  END");
        sqlQuery1.append("	ELSE"); 
        sqlQuery1.append("	  CASE WHEN (").append(prevPublishId).append(" > 0 AND ps.stat_desc != 'NEW' AND prevps.STD_ID IS NULL) THEN 'NEW'");
        sqlQuery1.append("	  ELSE ps.stat_desc END"); 
        sqlQuery1.append("	END AS CHANGED_STAT,");
        sqlQuery1.append(" DECODE(prevps.prnt_std_id, NULL, ps.prnt_std_id, prevps.prnt_std_id) AS prev_prnt_std_id, ps.MAIN_PRNT_STD_ID");
        sqlQuery1.append(" FROM TAXONOMY TAX, SEL_STAGE_TAXONOMY_STD PTS, PREV_PUBLISH_STD prevps, SEL_PUBLISH_STD PS");
        sqlQuery1.append(" WHERE pts.taxonomy_id = TAX.SEL_STAGE_TAXONOMY_ID AND ps.STD_ID = prevps.STD_ID(+)");
        sqlQuery1.append(" AND pts.stage_std_ver_id = ps.prnt_std_id),");
        
        if(filterByNew || filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate){
        	directMatchSearch = true;
	        sqlQuery1.append(" DIRECT_MATCH AS (SELECT ps.* FROM ALL_PUB_CHANGES ps WHERE (");
	        
	        if(filterByNew){
	        	sqlQuery1.append(" ps.CHANGED_STAT = 'NEW'");
	        	if(filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate){
	        		sqlQuery1.append(" OR");
	            } else {
	            	sqlQuery1.append(")");
	            }
	        }
	        
	        if(filterByTextUpdate && !filterByComplianceUpdate && !filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.TITLE_CHANGE='TEXT_CHANGE'))");
	        } else if(!filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
	        } else if(!filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND ps.HLC_CHANGE='HLC_CHANGE'))");
	        } else if(filterByTextUpdate && filterByComplianceUpdate && !filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE')))");
	        } else if(filterByTextUpdate && !filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.TITLE_CHANGE='TEXT_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
	        } else if(!filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" (ps.CHANGED_STAT = 'CHANGED' AND (ps.CMPLY_CHANGE='CMPLY_CHANGE' OR ps.EXPR_CHANGE='EXPR_CHANGE' OR ps.HLC_CHANGE='HLC_CHANGE')))");
	        } else if(filterByTextUpdate && filterByComplianceUpdate && filterByLifecycleUpdate) {
	        	sqlQuery1.append(" ps.CHANGED_STAT = 'CHANGED')");
	        }
	        
	        if (!StandardsListUtil.isNullOrBlank(idCriteria) && StandardsListUtil.isNullOrBlank(searchCriteria)) {
	        	sqlQuery1.append(" AND (ps.STD_ID IN (");
	            for (int i = 0; i < idCriteria.size(); i++) {
	            	sqlQuery1.append(idCriteria.get(i));
	            	if (i != idCriteria.size() - 1) {
	            		sqlQuery1.append(StringPool.COMMA);
	                }
	            }
	            sqlQuery1.append("))");
	        }
	        
	        sqlQuery2.append("),");
        }
        
        sqlQuery2.append(" RMD_SEARCH_STD AS (SELECT ps.STD_ID, ps.PRNT_STD_ID, ps.MAIN_PRNT_STD_ID FROM PREV_PUBLISH_STD ps WHERE ps.STD_ID NOT IN (SELECT STD_ID FROM SEL_PUBLISH_STD sps)");
        if (!StandardsListUtil.isNullOrBlank(idCriteria) && StandardsListUtil.isNullOrBlank(searchCriteria)) {
        	sqlQuery2.append(" AND (ps.STD_ID IN (");
            for (int i = 0; i < idCriteria.size(); i++) {
            	sqlQuery2.append(idCriteria.get(i));
            	if (i != idCriteria.size() - 1) {
            		sqlQuery2.append(StringPool.COMMA);
                }
            }
            sqlQuery2.append("))");
        }
        sqlQuery3.append("),");
        
        sqlQuery3.append("	ALL_RMD_STD AS (SELECT ps.STD_ID, ps.PRNT_STD_ID, ps.MAIN_PRNT_STD_ID FROM PREV_PUBLISH_STD ps WHERE ps.STD_ID NOT IN (SELECT STD_ID FROM SEL_PUBLISH_STD sps)),");
        
        sqlQuery3.append("	RMD_STD AS (SELECT * FROM ALL_RMD_STD WHERE");
        if(filterByRemoved && (filterByNew || filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate)){
        	sqlQuery3.append(" PRNT_STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM RMD_SEARCH_STD) OR MAIN_PRNT_STD_ID IN (SELECT DISTINCT MAIN_PRNT_STD_ID FROM DIRECT_MATCH)),");
        } else if(!filterByRemoved && (filterByNew || filterByTextUpdate || filterByComplianceUpdate || filterByLifecycleUpdate)){
        	sqlQuery3.append("	MAIN_PRNT_STD_ID IN (SELECT DISTINCT MAIN_PRNT_STD_ID FROM DIRECT_MATCH)),");
        } else {
        	sqlQuery3.append("	PRNT_STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM RMD_SEARCH_STD)),");
        }
        
        sqlQuery3.append(" 	RMD_PRNT_CHILD_PREV_STDS AS (SELECT STD_ID, PRNT_STD_ID, MAIN_PRNT_STD_ID FROM PREV_PUBLISH_STD WHERE PRNT_STD_ID IN (SELECT DISTINCT PRNT_STD_ID FROM RMD_STD)");
        sqlQuery3.append(" 		AND STD_ID NOT IN (SELECT DISTINCT STD_ID FROM RMD_STD)),"); 
        
        sqlQuery3.append(" 	RMD_PRNT_CHILD_CUR_STDS AS (SELECT STD_ID, PRNT_STD_ID, MAIN_PRNT_STD_ID FROM SEL_PUBLISH_STD WHERE PRNT_STD_ID IN (");
        sqlQuery3.append(" 	SELECT DISTINCT PRNT_STD_ID FROM SEL_PUBLISH_STD WHERE STD_ID IN (SELECT STD_ID FROM RMD_PRNT_CHILD_PREV_STDS))),");
                
        sqlQuery3.append(" RMD_MISS_PUB_CHANGES AS (SELECT * FROM ALL_PUB_CHANGES WHERE STD_ID IN (SELECT STD_ID FROM RMD_PRNT_CHILD_CUR_STDS))");
        
        sqlQuery3.append(" SELECT * FROM RMD_MISS_PUB_CHANGES UNION");
        sqlQuery3.append(" SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.SEL_STAGE_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID, TAX.PRNT_STAGE_TAXONOMY_ID AS PRNT_PUBLISH_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.PATH, TAX.TAXONOMY_DESC,"); 
        sqlQuery3.append("   TAX.TITLE_TXT AS INDEX_TITLE, pps.stage_std_ver_id AS publish_std_ver_id,");
        sqlQuery3.append("   DECODE((SELECT PRNT_STD_ID FROM RMD_PRNT_CHILD_CUR_STDS WHERE STD_ID=pps.MAIN_PRNT_STD_ID), NULL, pps.prnt_std_id,");
        sqlQuery3.append("	(SELECT PRNT_STD_ID FROM RMD_PRNT_CHILD_CUR_STDS WHERE STD_ID=pps.MAIN_PRNT_STD_ID)) AS prnt_std_id,");
        sqlQuery3.append("	 pps.std_id, pps.std_typ, pps.title_txt, pps.std_desc, 'REMOVED' AS stat_desc, NULL AS cmply_dt, NULL AS expr_dt, NULL AS HLC_FLAG_ID,");  
        sqlQuery3.append("   pps.DISP_ORDER_NBR, NULL AS PREV_TITLE_TXT, NULL AS PREV_STD_DESC,	NULL AS PREV_CMPLY_DT, NULL AS PREV_EXPR_DT, NULL AS PREV_HLC_FLAG_ID,");
        sqlQuery3.append("   NULL AS TITLE_CHANGE, NULL AS CMPLY_CHANGE, NULL AS EXPR_CHANGE, NULL AS HLC_CHANGE, 'REMOVED' AS CHANGED_STAT,");
        sqlQuery3.append("   pps.prnt_std_id AS prev_prnt_std_id, pps.MAIN_PRNT_STD_ID");
        sqlQuery3.append("   FROM TAXONOMY TAX, PREV_STAGE_TAXONOMY_STD PTS, PREV_PUBLISH_STD pps, RMD_STD rs");
        sqlQuery3.append("   WHERE pts.taxonomy_id = TAX.STAGE_TAXONOMY_ID");
        sqlQuery3.append("   AND pps.STD_ID = rs.STD_ID AND pts.stage_std_ver_id = pps.prnt_std_id"); 
        
        if (!StandardsListUtil.isNullOrBlank(searchCriteria)) {
            if (QueryUtils.SEARCH_OPTION_ANY.equals(textSearchType) || QueryUtils.SEARCH_OPTION_EXACT.equals(textSearchType)) {
                StringBuilder search = new StringBuilder(" AND (");
                search.append("(ps.std_typ = 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) OR");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) OR");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(QueryUtils.getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" )");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(QueryUtils.getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" )");
                }
                if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
                	search.append(" OR (ps.STD_ID IN (");
                    for (int i = 0; i < idCriteria.size(); i++) {
                    	search.append(idCriteria.get(i));
                    	if (i != idCriteria.size() - 1) {
                    		search.append(StringPool.COMMA);
                        }
                    }
                    search.append("))");
                }
                search.append(")");

                sqlQuery4.append(search);
            } else {
              StringBuilder search = new StringBuilder(" AND (");
              search.append("(ps.std_typ = 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) OR");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) OR");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(QueryUtils.getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" )");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria)) {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(QueryUtils.getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          QueryUtils.COLUMN_TYPE_STRING_MATCH_START, QueryUtils.COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" )");
              }
              if (!StandardsListUtil.isNullOrBlank(idCriteria)) {
            	  search.append(" OR (ps.STD_ID IN (");
            	  for (int i = 0; i < idCriteria.size(); i++) {
            		  search.append(idCriteria.get(i));
            		  if (i != idCriteria.size() - 1) {
            			  search.append(StringPool.COMMA);
            		  }
            	  }
            	  search.append("))");
              }
              search.append(")");

              sqlQuery4.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        	!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney) ||
            !StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
        	StringBuilder selFlagQuery = new StringBuilder(" PS.PUBLISH_STD_VER_ID IN (select pubs.stage_std_ver_id from stage_flag_std pfs, SEL_PUBLISH_STD pubs");
        	selFlagQuery.append(" where pubs.stage_std_ver_id = pfs.stage_std_ver_id");
            
            StringBuilder prevFlagQuery = new StringBuilder(" PS.STAGE_STD_VER_ID IN (select pubs.stage_std_ver_id from stage_flag_std pfs, PREV_PUBLISH_STD pubs");
            prevFlagQuery.append(" where pubs.stage_std_ver_id = pfs.stage_std_ver_id");
            
            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle)) {
                hotelLifeCycleClause.add(QueryUtils.getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, hotelLifeCycleClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, hotelLifeCycleClause)));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism)) {
                specialismClause.add(QueryUtils.getWhereClause(arlSpecialism, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, specialismClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, specialismClause)));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability)) {
                hotelDeptClause.add(QueryUtils.getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id",
                        QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, hotelDeptClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, hotelDeptClause)));

            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney)) {
                guestJourneyClause.add(QueryUtils.getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, guestJourneyClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, guestJourneyClause)));

            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations)) {
                hotelLocClause.add(QueryUtils.getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", 
                		QueryUtils.COLUMN_TYPE_NUMBER_START, QueryUtils.COLUMN_TYPE_NUMBER_END));
                selClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(selFlagQuery, hotelLocClause)));
                prevClauses.add(new StringBuilder(QueryUtils.buildFlagsQuery(prevFlagQuery, hotelLocClause)));
            }
        }

        return buildWCORemovedQuery(sqlQuery1, sqlQuery2, sqlQuery3, sqlQuery4, tables, selClauses, prevClauses, directMatchSearch);
    }
    
    /**
     * This method will return SQL with Taxonomy table based on the production tables.
     * 
     * @param tempTableName -Temporary table name
     * @param publishId -Publish Id
     * @param localeCode -Locale Code
     * @return SQL
     */
    public static String getProdTaxonomyTempTable(String tempTableName, String publishId, String localeCode)
    {
        StringBuilder sql = new StringBuilder();
        if (QueryUtils.DEFAULT_LOCALE.equalsIgnoreCase(localeCode))
        {
            sql.append(tempTableName);
            sql.append(" AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PUBLISH_TAXONOMY_ID, TAX.PRNT_PUBLISH_TAXONOMY_ID, ");
            sql.append(" TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.TITLE_TXT, TAX.PATH, TAX.TAXONOMY_DESC");
            sql.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PUBLISH_TAXONOMY_ID,");
            sql.append(" T.PRNT_PUBLISH_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
            sql.append(" T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH");
            sql.append(" FROM PUBLISH_TAXONOMY T WHERE T.publish_id = ");
            sql.append(publishId);
            sql.append(" START WITH T.TAXONOMY_ID = 1");
            sql.append(" CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID) TAX)");
        }
        else
        {
            sql.append(tempTableName);
            sql.append(" AS (SELECT TAX_DEF.INDX_ORDER, TAX_PREF.TAXONOMY_ID, TAX_DEF.PUBLISH_TAXONOMY_ID,");
            sql.append(" TAX_DEF.PRNT_PUBLISH_TAXONOMY_ID, TAX_DEF.LVL, TAX_DEF.HIER_LVL_NBR, TAX_DEF.PUBLISH_ID,");
            sql.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.TITLE_TXT, TAX_PREF.TITLE_TXT) AS TITLE_TXT,");
            sql.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.PATH, TAX_PREF.PATH) AS PATH,");
            sql.append(" decode(TAX_PREF.TAXONOMY_DESC, NULL, TAX_DEF.TAXONOMY_DESC, TAX_PREF.TAXONOMY_DESC) AS TAXONOMY_DESC");
            sql.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID, ");
            sql.append(" (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID, ");
            sql.append(" (SELECT DECODE(ptx.TAXONOMY_DESC, NULL, t.TAXONOMY_DESC, 'No Translation Found', ");
            sql.append(" t.TAXONOMY_DESC, '', t.TAXONOMY_DESC, ptx.TAXONOMY_DESC) FROM PUBLISH_TAXONOMY_XLAT ptx");
            sql.append(" WHERE t.publish_taxonomy_id = ptx.publish_taxonomy_id(+) AND ptx.locale_cd = '");
            sql.append(localeCode);
            sql.append("' ) AS TAXONOMY_DESC, ");
            sql.append(" (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt) ");
            sql.append(" FROM PUBLISH_TAXONOMY_XLAT ptx WHERE t.publish_taxonomy_id = ptx.publish_taxonomy_id(+) AND ptx.locale_cd = '");
            sql.append(localeCode);
            sql.append("' ) AS TITLE_TXT, ");
            sql.append(" SUBSTR(SYS_CONNECT_BY_PATH(   (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', ");
            sql.append(" t.title_txt, '', t.title_txt, ptx.title_txt) AS title ");
            sql.append(" FROM PUBLISH_TAXONOMY_XLAT ptx ");
            sql.append(" WHERE t.publish_taxonomy_id   = ptx.publish_taxonomy_id(+) AND ptx.locale_cd = '");
            sql.append(localeCode);
            sql.append("' ) , ' &#8594; '),  19) AS PATH ");
            sql.append(" FROM PUBLISH_TAXONOMY T WHERE T.publish_id = ");
            sql.append(publishId);
            sql.append(" START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID ) TAX_PREF,");
            sql.append(" (SELECT ROWNUM AS INDX_ORDER, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID,");
            sql.append(" (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
            sql.append(" T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt , ' &#8594; '), 31) AS PATH");
            sql.append(" FROM PUBLISH_TAXONOMY T ");
            sql.append(" WHERE T.publish_id = ");
            sql.append(publishId);
            sql.append(" START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID ) TAX_DEF");
            sql.append(" WHERE TAX_DEF.PUBLISH_TAXONOMY_ID = TAX_PREF.PUBLISH_TAXONOMY_ID )");
        }
        return sql.toString();
    }

    /**
     * This method will return SQL with Taxonomy table based on the staging tables.
     * 
     * @param tempTableName -Temporary table name
     * @param publishId -Publish Id
     * @param localeCode -Locale Code
     * @return SQL
     */
    public static String getStageTaxonomyTempTable(String tempTableName, String publishId, String localeCode)
    {
        StringBuilder sql = new StringBuilder();
        if (QueryUtils.DEFAULT_LOCALE.equalsIgnoreCase(localeCode))
        {
            sql.append(tempTableName);
            sql.append(" AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.STAGE_TAXONOMY_ID, TAX.PRNT_STAGE_TAXONOMY_ID,");
            sql.append(" TAX.LVL, TAX.HIER_LVL_NBR, TAX.PUBLISH_ID, TAX.TITLE_TXT, TAX.PATH, TAX.TAXONOMY_DESC");
            sql.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.STAGE_TAXONOMY_ID,");
            sql.append(" T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
            sql.append(" T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH");
            sql.append(" FROM STAGE_TAXONOMY T WHERE T.publish_id = ");
            sql.append(publishId);
            sql.append(" START WITH T.TAXONOMY_ID = 1");
            sql.append(" CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID) TAX)");
        }
        else
        {
            sql.append(tempTableName);
            sql.append(" AS (SELECT TAX_DEF.INDX_ORDER, TAX_PREF.TAXONOMY_ID, TAX_DEF.STAGE_TAXONOMY_ID, TAX_DEF.PRNT_STAGE_TAXONOMY_ID,");
            sql.append(" TAX_DEF.LVL, TAX_DEF.HIER_LVL_NBR, TAX_DEF.PUBLISH_ID,");
            sql.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.TITLE_TXT, TAX_PREF.TITLE_TXT) AS TITLE_TXT,");
            sql.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.PATH, TAX_PREF.PATH) AS PATH,");
            sql.append(" decode(TAX_PREF.TAXONOMY_DESC, NULL, TAX_DEF.TAXONOMY_DESC, TAX_PREF.TAXONOMY_DESC) AS TAXONOMY_DESC");
            sql.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID,");
            sql.append(" (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
            sql.append(" (SELECT DECODE(ptx.TAXONOMY_DESC, NULL, t.TAXONOMY_DESC, 'No Translation Found', t.TAXONOMY_DESC, '', t.TAXONOMY_DESC, ptx.TAXONOMY_DESC)");
            sql.append(" FROM STAGE_TAXONOMY_XLAT ptx");
            sql.append(" WHERE t.stage_taxonomy_id = ptx.stage_taxonomy_id(+) AND ptx.locale_cd = '");
            sql.append(localeCode);
            sql.append("' ) AS TAXONOMY_DESC,");
            sql.append(" (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt)");
            sql.append(" FROM STAGE_TAXONOMY_XLAT ptx");
            sql.append(" WHERE t.stage_taxonomy_id   = ptx.stage_taxonomy_id(+) AND ptx.locale_cd = '");
            sql.append(localeCode);
            sql.append("' ) AS TITLE_TXT,");
            sql.append(" SUBSTR(SYS_CONNECT_BY_PATH( (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt) AS title");
            sql.append(" FROM STAGE_TAXONOMY_XLAT ptx");
            sql.append(" WHERE t.stage_taxonomy_id   = ptx.stage_taxonomy_id(+) AND ptx.locale_cd = '");
            sql.append(localeCode);
            sql.append("') , ' &#8594; '),  19) AS PATH");
            sql.append(" FROM STAGE_TAXONOMY T WHERE T.publish_id = ");
            sql.append(publishId);
            sql.append(" START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID ) TAX_PREF,");
            sql.append(" (SELECT ROWNUM AS INDX_ORDER, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID,");
            sql.append(" (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.PUBLISH_ID,");
            sql.append(" T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt , ' &#8594; '), 31) AS PATH");
            sql.append(" FROM STAGE_TAXONOMY T WHERE T.publish_id = ");
            sql.append(publishId);
            sql.append(" START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID ) TAX_DEF");
            sql.append(" WHERE TAX_DEF.STAGE_TAXONOMY_ID = TAX_PREF.STAGE_TAXONOMY_ID)");
        }
        return sql.toString();
    }

    /**
     * This method will return taxonomy table for removed query based on production tables.
     * 
     * @return SQL
     */
    public static String getProdRemovedTaxonomyTempTable()
    {
        StringBuilder sql = new StringBuilder();
        sql.append(" TAXONOMY AS (SELECT");
        sql.append(" DECODE(STAX.INDX_ORDER, NULL, RTAX.INDX_ORDER, STAX.INDX_ORDER) AS INDX_ORDER,");
        sql.append(" DECODE(STAX.TAXONOMY_ID, NULL, RTAX.TAXONOMY_ID, STAX.TAXONOMY_ID) AS TAXONOMY_ID,");
        sql.append(" RTAX.PUBLISH_TAXONOMY_ID AS PUBLISH_TAXONOMY_ID,");
        sql.append(" DECODE(STAX.PUBLISH_TAXONOMY_ID, NULL, RTAX.PUBLISH_TAXONOMY_ID, STAX.PUBLISH_TAXONOMY_ID) AS SEL_PUBLISH_TAXONOMY_ID,");
        sql.append(" DECODE(STAX.PRNT_PUBLISH_TAXONOMY_ID, NULL, RTAX.PRNT_PUBLISH_TAXONOMY_ID, STAX.PRNT_PUBLISH_TAXONOMY_ID) AS PRNT_PUBLISH_TAXONOMY_ID,");
        sql.append(" DECODE(STAX.LVL, NULL, RTAX.LVL, STAX.LVL) AS LVL,");
        sql.append(" DECODE(STAX.HIER_LVL_NBR, NULL, RTAX.HIER_LVL_NBR, STAX.HIER_LVL_NBR) AS HIER_LVL_NBR,");
        sql.append(" DECODE(STAX.PUBLISH_ID, NULL, RTAX.PUBLISH_ID, STAX.PUBLISH_ID) AS PUBLISH_ID,");
        sql.append(" DECODE(STAX.TITLE_TXT, NULL, RTAX.TITLE_TXT, STAX.TITLE_TXT) AS TITLE_TXT,");
        sql.append(" DECODE(STAX.PATH, NULL, RTAX.PATH, STAX.PATH) AS PATH,");
        sql.append(" DECODE(STAX.TAXONOMY_DESC, NULL, RTAX.TAXONOMY_DESC, STAX.TAXONOMY_DESC) AS TAXONOMY_DESC");
        sql.append(" FROM SEL_PUB_TAXONOMY STAX, PREV_PUB_TAXONOMY RTAX WHERE RTAX.TAXONOMY_ID = STAX.TAXONOMY_ID(+) )");

        return sql.toString();
    }

    /**
     * This method will return taxonomy table for removed query based on staging tables.
     * 
     * @return SQL
     */
    public static String getStageRemovedTaxonomyTempTable()
    {
        StringBuilder sql = new StringBuilder();
        sql.append(" TAXONOMY AS (SELECT");
        sql.append(" DECODE(STAX.INDX_ORDER, NULL, RTAX.INDX_ORDER, STAX.INDX_ORDER) AS INDX_ORDER,");
        sql.append(" DECODE(STAX.TAXONOMY_ID, NULL, RTAX.TAXONOMY_ID, STAX.TAXONOMY_ID) AS TAXONOMY_ID,");
        sql.append(" RTAX.STAGE_TAXONOMY_ID AS STAGE_TAXONOMY_ID,");
        sql.append(" DECODE(STAX.STAGE_TAXONOMY_ID, NULL, RTAX.STAGE_TAXONOMY_ID, STAX.STAGE_TAXONOMY_ID) AS SEL_STAGE_TAXONOMY_ID,");
        sql.append(" DECODE(STAX.PRNT_STAGE_TAXONOMY_ID, NULL, RTAX.PRNT_STAGE_TAXONOMY_ID, STAX.PRNT_STAGE_TAXONOMY_ID) AS PRNT_STAGE_TAXONOMY_ID,");
        sql.append(" DECODE(STAX.LVL, NULL, RTAX.LVL, STAX.LVL) AS LVL,");
        sql.append(" DECODE(STAX.HIER_LVL_NBR, NULL, RTAX.HIER_LVL_NBR, STAX.HIER_LVL_NBR) AS HIER_LVL_NBR,");
        sql.append(" DECODE(STAX.PUBLISH_ID, NULL, RTAX.PUBLISH_ID, STAX.PUBLISH_ID) AS PUBLISH_ID,");
        sql.append(" DECODE(STAX.TITLE_TXT, NULL, RTAX.TITLE_TXT, STAX.TITLE_TXT) AS TITLE_TXT,");
        sql.append(" DECODE(STAX.PATH, NULL, RTAX.PATH, STAX.PATH) AS PATH,");
        sql.append(" DECODE(STAX.TAXONOMY_DESC, NULL, RTAX.TAXONOMY_DESC, STAX.TAXONOMY_DESC) AS TAXONOMY_DESC");

        sql.append(" FROM SEL_PUB_TAXONOMY STAX, PREV_PUB_TAXONOMY RTAX WHERE RTAX.TAXONOMY_ID = STAX.TAXONOMY_ID(+) )");

        return sql.toString();
    }

    public static String buildWCORemovedQuery(StringBuilder selectQuery1, StringBuilder selectQuery2, StringBuilder selectQuery3, StringBuilder selectQuery4,
            List<StringBuilder> tables, List<StringBuilder> selClauses, List<StringBuilder> prevClauses, boolean directMatchSearch)
    {
        StringBuilder sqlQuery = selectQuery1;
        boolean appendComma = false;
        if(directMatchSearch) {
	        if (!tables.isEmpty())
	        {
	            sqlQuery.append(" ,");
	
	            for (StringBuilder table : tables)
	            {
	                if (appendComma)
	                {
	                    sqlQuery.append(" ,");
	                }
	                appendComma = true;
	                sqlQuery.append(" ").append(table);
	            }
	        }
	        sqlQuery.append(selectQuery4);
	        if (!selClauses.isEmpty())
	        {
	            sqlQuery.append(QueryUtils.SPACE_AND_SPACE);
	            boolean appendAnd = false;
	            for (StringBuilder clause : selClauses)
	            {
	                if (appendAnd)
	                {
	                    sqlQuery.append(QueryUtils.SPACE_AND_SPACE);
	                }
	                appendAnd = true;
	                sqlQuery.append(" ").append(clause);
	            }
	        }
        }
        sqlQuery.append(selectQuery2);
        appendComma = false;
        if (!tables.isEmpty())
        {
            sqlQuery.append(" ,");

            for (StringBuilder table : tables)
            {
                if (appendComma)
                {
                    sqlQuery.append(" ,");
                }
                appendComma = true;
                sqlQuery.append(" ").append(table);
            }
        }
        sqlQuery.append(selectQuery4);
        if (!prevClauses.isEmpty())
        {
            sqlQuery.append(QueryUtils.SPACE_AND_SPACE);
            boolean appendAnd = false;
            for (StringBuilder clause : prevClauses)
            {
                if (appendAnd)
                {
                    sqlQuery.append(QueryUtils.SPACE_AND_SPACE);
                }
                appendAnd = true;
                sqlQuery.append(" ").append(clause);
            }
        }
        sqlQuery.append(selectQuery3);
        return sqlQuery.toString();
    }
}
