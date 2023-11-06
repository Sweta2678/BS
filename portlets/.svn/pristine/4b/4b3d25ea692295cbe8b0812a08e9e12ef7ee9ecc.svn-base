package com.ihg.brandstandards.util;

public class QueryUtils
{
    public static final String ACTIVE_ALL_LANG_QUERY = "SELECT LOCALE_CD, LOCALE_NM FROM BRNDSTND_LOCALE WHERE ACTV_IND = 'Y' ORDER BY DISP_ORDER_NBR ASC";
    public static final String ACTIVE_ALL_SECOND_LANG_QUERY = "SELECT LOCALE_CD, LOCALE_NM FROM BRNDSTND_LOCALE WHERE ACTV_IND = 'Y' AND LOCALE_CD != 'en_GB' ORDER BY DISP_ORDER_NBR ASC";

    /**
     * This method will return the query to get all active languages for a region.
     * 
     * @param regionCd The region code.
     * @return String SQL Query.
     */
    public static String getActiveLangsByRegion(String regionCd)
    {
        StringBuffer query = new StringBuffer();
        query.append("SELECT LOCALE_CD, LOCALE_NM FROM BRNDSTND_LOCALE WHERE ACTV_IND = 'Y' AND LOCALE_CD in");
        query.append(" (SELECT LOCALE_CD FROM BRNDSTND_RGN_LOCALE WHERE RGN_ID =");
        query.append(" (SELECT RGN_ID FROM BRNDSTND_RGN WHERE RGN_CD = '");
        query.append(regionCd);
        query.append("' AND PRNT_RGN_ID IS NULL )) ORDER BY DISP_ORDER_NBR ASC");

        return query.toString();
    }

    /**
     * This method will return the query to get all active languages for a region except English UK(en_GB) language.
     * 
     * @param regionCd The region code.
     * @return String SQL Query.
     */
    public static String getActiveSecondLangsByRegion(String regionCd)
    {
        StringBuffer query = new StringBuffer();
        query.append("SELECT LOCALE_CD, LOCALE_NM FROM BRNDSTND_LOCALE WHERE ACTV_IND = 'Y' AND LOCALE_CD != 'en_GB'");
        query.append(" AND LOCALE_CD IN (SELECT LOCALE_CD FROM BRNDSTND_RGN_LOCALE WHERE RGN_ID =");
        query.append(" (SELECT RGN_ID FROM BRNDSTND_RGN WHERE RGN_CD = '");
        query.append(regionCd);
        query.append("' AND PRNT_RGN_ID IS NULL)) ORDER BY DISP_ORDER_NBR ASC");

        return query.toString();
    }
    
    /**
     * This method will return the query to get all active languages for all region except English UK(en_GB) language.
     * 
     * @param regionIds The comma separated region IDs.
     * @return String SQL Query.
     */
    public static String getAllRegionActiveSecondLangs(String regionIds)
    {
        StringBuffer query = new StringBuffer();
        query.append("SELECT LOCALE_CD, LOCALE_NM FROM BRNDSTND_LOCALE WHERE ACTV_IND = 'Y' AND LOCALE_CD != 'en_GB'");
        query.append(" AND LOCALE_CD IN (SELECT DISTINCT LOCALE_CD FROM BRNDSTND_RGN_LOCALE WHERE RGN_ID  IN (");
        query.append(regionIds);
        query.append("')) ORDER BY DISP_ORDER_NBR ASC");

        return query.toString();
    }
    
    public static String getCompliance(long stdId, String chainCode)
    {
    	StringBuffer query = new StringBuffer();
    	query.append("	  SELECT DISTINCT sc.std_id, br.rgn_cd, sc.cmply_expr_rule_cd, sc.cmply_expr_dt, sc.cmply_rule_mo_qty, sc.rule_dt_cd,  sc.cmply_expr_dt AS expr_dt,	");
    	query.append("	  CASE 	");
    	query.append("	    WHEN sc.cmply_expr_rule_cd = 'C' THEN	");
    	query.append("	        CASE WHEN sc.rule_dt_cd = 'R' THEN	");
    	query.append("	            to_char(nvl(sc.cmply_rule_mo_qty, 0)) 	");
    	query.append("	        ELSE	");
    	query.append("	            to_char(sc.cmply_expr_dt, 'DD Mon YYYY')	");
    	query.append("	        END	");
    	query.append("	    END cmply_dt_str,	");
    	query.append("	    CASE 	");
    	query.append("	    WHEN sc.cmply_expr_rule_cd = 'E' THEN 	");
    	query.append("	       to_char(sc.cmply_expr_dt, 'DD Mon YYYY')	");
    	query.append("	    END expr_dt_str	");
    	query.append("	  FROM std s, std_cmply sc, BRNDstnd_ctry bc, brndstnd_rgn br	");
    	query.append("	  where 	");
    	query.append("	  s.std_id = sc.std_id and	");
    	query.append("	  sc.ctry_nm_cd = bc.ctry_nm_cd and	");
    	query.append("	  bc.rgn_id = br.rgn_id  AND 	");
    	query.append("	  s.stat_desc != 'DELETED' AND 	");
    	query.append("	  s.std_typ != 'GDLN' 	AND ");
    	query.append("	  s.std_id = "+stdId+" AND ");
    	query.append("	  sc.std_idchain_cd = '"+chainCode+"'  ");
    	query.append("	  order by sc.std_id	");

    	return query.toString();
    }
    
    public static String saveOrUpdateCompliance(long stdId, String chainCode, String ruleDate, String complianceExpiry, String stdCompliance, boolean isSave)
    {
    	StringBuffer query = new StringBuffer();
    	query.append("DECLARE ");
    	query.append("  TYPE ctry_compliance IS RECORD (ctry_cd VARCHAR2(5), compliance VARCHAR2(10)); ");
    	query.append("  TYPE ctry_comp_type IS TABLE OF ctry_compliance; ");
    	query.append("  l_ctry_comp ctry_comp_type := ctry_comp_type(); ");
    	query.append("  TYPE datasarray IS VARRAY(2) OF VARCHAR2(20); ");
    	query.append("  l_array datasarray := datasarray();	 ");
    	query.append("  l_nfields PLS_INTEGER := 1; ");
    	query.append("  v_str VARCHAR2(4000) := '" + stdCompliance + "'; ");
    	query.append("  v_token_1    VARCHAR2(30); ");
    	query.append("  v_token_2    VARCHAR2(4); ");
    	query.append("  i            INTEGER := 1; ");
    	query.append("  j            INTEGER := 1; ");
    	query.append("  l_chain_cd   VARCHAR2(5) := '" + chainCode + "'; ");
    	query.append("  l_std_id     NUMBER := 21; ");
    	//query.append("  l_ruleDate   VARCHAR2(10) := '" + ruleDate + "'; ");
    	query.append("  l_ruleDate   VARCHAR2(10) := 'R'; ");
    	query.append("  l_complexp   VARCHAR2(10) := '" + complianceExpiry + "'; ");
    	
    	query.append("  FUNCTION get_token( p_input_string IN VARCHAR2, "); //-- input string 
    	query.append("                      p_token_number IN INTEGER, "); //-- token number    
    	query.append("                      p_delimiter    IN VARCHAR2 DEFAULT ';' "); //-- separator character   
    	query.append("                      ) RETURN VARCHAR2 AS ");
    	query.append("    v_temp_string VARCHAR2(32767) := p_delimiter || p_input_string; ");
    	query.append("    v_pos1 INTEGER; ");
    	query.append("    v_pos2 INTEGER; ");
    	query.append("  BEGIN ");
    	query.append("    v_pos1 := INSTR( v_temp_string, p_delimiter, 1, p_token_number ); ");
    	query.append("    IF v_pos1 > 0 THEN 	 ");
    	query.append("      v_pos2 := INSTR( v_temp_string, p_delimiter, 1, p_token_number + 1); ");
    	query.append("      IF v_pos2 = 0 THEN ");
    	query.append("        v_pos2 := LENGTH( v_temp_string ) + 1; ");
    	query.append("      END IF ; 	 ");
    	query.append("      RETURN( SUBSTR( v_temp_string, v_pos1+1, v_pos2 - v_pos1-1 ) ); ");
    	query.append("    ELSE ");
    	query.append("      RETURN NULL; ");
    	query.append("    END IF; ");
    	query.append("  EXCEPTION WHEN OTHERS THEN ");
    	query.append("    RAISE; ");
    	query.append("  END get_token; ");
    	
    	query.append(" 	BEGIN ");
    	query.append(" 	  l_array.extend; ");
    	query.append("    l_array.EXTEND; ");
    	query.append(" 	  LOOP ");
    	query.append("      v_token_1 := get_token(v_str, i, ';'); ");
    	query.append("      EXIT WHEN v_token_1 IS NULL; ");
//    	query.append(" 	--        dbms_output.put_line('first token: ' || v_token_1); 	 ");
//    	query.append(" 	        --str_arr(i) := v_token; 	 ");
    	query.append("      j := 1;	");
    	query.append("      LOOP ");
    	query.append("        v_token_2 := get_token(v_token_1, j, '='); ");
    	query.append("        EXIT WHEN v_token_2 IS NULL; ");
//    	query.append(" 	--            dbms_output.put_line('second token: ' || v_token_2 || ' j = ' || j); 	 ");
    	query.append("        l_array(j) := v_token_2; ");
    	query.append("        j := j + 1; ");
    	query.append("      END LOOP; ");

    	query.append("      l_ctry_comp.EXTEND; ");
    	query.append("      l_ctry_comp(l_nfields).ctry_cd := l_array(1); ");
    	query.append("      l_ctry_comp(l_nfields).compliance := l_array(2); ");
    	query.append("      l_nfields                        := l_nfields + 1; ");
    	query.append("      i := i + 1; ");
    	query.append("    END LOOP; ");

    	query.append("    FOR i IN l_ctry_comp.FIRST..l_ctry_comp.LAST ");
    	query.append(" 	  LOOP ");
//    	query.append(" 	        --dbms_output.put_line(l_ctry_comp(i).ctry_cd || ' === ' || l_ctry_comp(i).compliance);	 ");
    	if(isSave)
    	{
    		query.append("      INSERT INTO std_cmply(std_cmply_id, std_id, ctry_nm_cd, chain_cd, cmply_expr_dt, cmply_expr_rule_cd, cmply_rule_mo_qty, rule_dt_cd, ");
    		query.append("      creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ");
    		query.append("      values(STD_CMPLY_ID_SEQ.nextval, l_std_id, l_ctry_comp(i).ctry_cd, l_chain_cd, NULL, l_complexp, l_ctry_comp(i).compliance, l_ruleDate, '12345', SYSDATE, '12345', SYSDATE); ");
    	}
    	else
    	{
    		query.append("      UPDATE std_cmply (std_cmply_id, std_id, ctry_nm_cd, chain_cd, cmply_expr_dt, cmply_expr_rule_cd, cmply_rule_mo_qty, rule_dt_cd, ");
    		query.append("      creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ");
    		query.append("      values(STD_CMPLY_ID_SEQ.nextval, l_std_id, l_ctry_comp(i).ctry_cd, l_chain_cd, NULL, l_complexp, l_ctry_comp(i).compliance, l_ruleDate, '12345', SYSDATE, '12345', SYSDATE); ");
    	}
    	query.append("  END LOOP; ");
    	query.append("END; ");

    	return query.toString();
    }    
    
}
