package com.ihg.brandstandards.gem.util;

import java.util.List;

import com.ihg.brandstandards.custom.gem.model.QualityLeadModel;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class GemQueryUtils {

	private static final Log LOG = LogFactoryUtil.getLog(GemQueryUtils.class);
	
	public static String getGemScoringQuery(long publishDeptId, long parentPublishId, long publishId, long seTemplateId, long regionId, String userName)
	{
		StringBuilder query = new StringBuilder();
        query.append("DECLARE ");
        query.append("l_publish_id NUMBER := ").append(publishId).append("; ");
        query.append("l_publish_dept_id NUMBER := ").append(publishDeptId).append("; ");
        query.append("l_rgn_id NUMBER := ").append(regionId).append("; ");
        query.append("l_usr_id VARCHAR2(50) := '").append(userName).append("'; ");
        query.append("l_template_id NUMBER := ").append(seTemplateId).append("; ");
        query.append("l_severity_id NUMBER; ");
        query.append("l_msrmnt_id NUMBER; ");
        query.append("l_msrmnt_bkt_chain_id NUMBER; ");
        query.append("l_scor_count NUMBER := 0; ");
        
        query.append("CURSOR l_bkt_cur IS SELECT gem_mgt_bucket_id, gem_bucket_nm FROM gem_mgt_bucket WHERE gem_mgt_bucket_id > 0; ");
        query.append("CURSOR l_severity_cur IS SELECT gem_severity_id, gem_severity_nm FROM gem_severity WHERE gem_severity_id > 0; ");
        query.append("CURSOR l_msrmnt_cur IS SELECT gem_msrmnt_id, gem_msrmnt_typ_cd FROM gem_msrmnt WHERE gem_template_id = l_template_id; ");
        query.append("l_ql_cursor SYS_REFCURSOR := NULL; ");
        
        query.append("l_sql VARCHAR2(500) :=  ");
        query.append("'SELECT q.gem_msrmnt_id, q.cnt, (q.cnt * m.gem_msrmnt_multr_qty) final_cnt ' || ");
        query.append("'FROM (SELECT ql.gem_msrmnt_id, count(ql.gem_msrmnt_id) cnt FROM qlty_lead_rpt ql, std s ' || ");
        query.append("'WHERE ql.publish_id = :pubId AND s.std_id = ql.std_id AND s.std_typ = ''STD'' AND ql.gem_severity_id = :svrtyId AND ql.rgn_id = :rgnId ' || "); 
        query.append("'AND ql.gem_msrmnt_id > 0 AND ql.gem_mgt_bucket_id = :bktId GROUP BY ql.gem_msrmnt_id) q, gem_msrmnt m ' || "); 
        query.append("'WHERE q.gem_msrmnt_id = m.gem_msrmnt_id AND m.gem_msrmnt_id = :msrmntId '; ");
        
        query.append("l_ins VARCHAR2(500) := ");
        query.append("'INSERT INTO gem_msrmnt_bucket_chain(gem_msrmnt_bucket_chain_id, gem_mgt_bucket_id, gem_severity_id, ' || ");
        query.append("'gem_msrmnt_id, publish_id, gem_publish_dept_id, rgn_id, gem_sub_rgn_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        query.append("'VALUES(:id, :bktId, :svrtyId, :msrmntId, :pubId, :pubDeptId, :rgnId, :subRgn, :usrId, SYSDATE, :usrId, SYSDATE)'; ");
        
        query.append("l_upd VARCHAR2(200) :=  ");
        query.append("'UPDATE gem_msrmnt_bucket_chain SET gem_sub_rgn_cd = :subRgn, lst_updt_usr_id = :usrId, lst_updt_ts = SYSDATE ' || ");
        query.append("'WHERE gem_msrmnt_bucket_chain_id = :id '; ");

        query.append("l_score_val_ins VARCHAR2(500) := ");
        query.append("'INSERT INTO scoring_val (scoring_val_id, gem_msrmnt_bucket_chain_id, tot_msrmnt_qty, net_msrmnt_qty, ' || ");
        query.append("'non_compliant_msrmnt_qty, non_compliant_msrmnt_pct, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        query.append("'VALUES (:id, 0, :total, :net, :nonCmplQty, :nonCmplPct, :usrtId, SYSDATE, :usrId, SYSDATE)'; ");
        
        query.append("l_score_val_upd VARCHAR2(250) :=  ");
        query.append("'UPDATE scoring_val SET tot_msrmnt_qty = :total, net_msrmnt_qty = :net, non_compliant_msrmnt_qty = :nonCmplQty, ' || ");
        query.append("'non_compliant_msrmnt_pct = :nonCmplPct, lst_updt_usr_id = :usrtId, lst_updt_ts = SYSDATE WHERE scoring_val_id = :id'; ");
        
        query.append("l_scor_pt_ins VARCHAR2(500) := ");
        query.append("'INSERT INTO gem_scor_pt (gem_scor_pt_id, publish_id, gem_publish_dept_id, rgn_id, gem_mgt_bucket_id, gem_severity_id, compliant_qty, ' || ");
        query.append("'compliant_denominator_qty, non_compliant_qty, non_compliant_denominator_qty, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        query.append("'VALUES(:id, :pubId, :pubDeptId, :rgnId, :bktId, :svrtyId, :cmplQty, :cmplyDenQty, :nonCmplyQty, :nonCmplyDenQty, :usrtId, SYSDATE, :usrId, SYSDATE)'; ");
        
        query.append("l_cererity_found BOOLEAN := false; ");
        query.append("l_scor_pt_id NUMBER; ");
        query.append("l_exist_cnt NUMBER; ");
        query.append("l_severity_found BOOLEAN := FALSE; ");
        query.append("l_scor_total NUMBER; ");
        query.append("l_total NUMBER; ");
        query.append("l_total_non_cmpl NUMBER; ");
        query.append("l_total_qs NUMBER; ");
        query.append("l_net NUMBER; ");
        query.append("l_feature_cnt NUMBER; ");
        query.append("l_trigger_cnt NUMBER; ");

        query.append("BEGIN ");
        query.append("  FOR bkt IN l_bkt_cur LOOP ");
        query.append("    FOR svrty IN l_severity_cur LOOP ");
        query.append("      l_total := 0; ");
        query.append("      l_net := 0; ");
        query.append("      l_feature_cnt := 0; ");
        query.append("      l_trigger_cnt := 0; ");
        query.append("      FOR msrmnt IN l_msrmnt_cur LOOP ");
        query.append("        l_cererity_found := FALSE; ");
        query.append("        IF ((msrmnt.gem_msrmnt_typ_cd = 'SEVERITY_OTHER') OR (msrmnt.gem_msrmnt_typ_cd = 'SEVERITY')) THEN ");
        
        query.append("        OPEN l_ql_cursor FOR l_sql ");
        query.append("        USING l_publish_id, svrty.gem_severity_id, l_rgn_id, bkt.gem_mgt_bucket_id, msrmnt.gem_msrmnt_id; ");
        query.append("        LOOP ");
        query.append("          FETCH l_ql_cursor INTO l_msrmnt_id, l_scor_count, l_scor_total; ");
        query.append("          EXIT WHEN l_ql_cursor%NOTFOUND; ");
        query.append("          l_cererity_found := TRUE; ");
        query.append("          l_total := l_total + l_scor_total; ");
        query.append("          l_net := l_net + l_scor_count; ");
            
        query.append("          SELECT nvl((SELECT gem_msrmnt_bucket_chain_id "); 
        query.append("            FROM gem_msrmnt_bucket_chain ");
        query.append("            WHERE publish_id = l_publish_id ");
        query.append("            AND gem_mgt_bucket_id = bkt.gem_mgt_bucket_id ");
        query.append("            AND gem_severity_id = svrty.gem_severity_id ");
        query.append("            AND gem_msrmnt_id = l_msrmnt_id ");
        query.append("            AND rgn_id = l_rgn_id), 0) "); 
        query.append("          INTO l_msrmnt_bkt_chain_id ");
        query.append("          FROM dual; ");
            
        query.append("          IF l_msrmnt_bkt_chain_id > 0 THEN ");
        query.append("            EXECUTE IMMEDIATE l_upd ");
        query.append("            USING to_char(l_scor_count), l_usr_id, l_msrmnt_bkt_chain_id; ");
        query.append("          ELSE ");
        query.append("            EXECUTE IMMEDIATE l_ins ");
        query.append("            USING gem_msrmnt_bucket_chain_id_seq.nextval, bkt.gem_mgt_bucket_id, svrty.gem_severity_id, l_msrmnt_id, ");
        query.append("            l_publish_id, l_publish_dept_id, l_rgn_id, to_char(l_scor_count), l_usr_id, l_usr_id; ");
        query.append("          END IF; ");
        query.append("        END LOOP; ");
        
        query.append("        IF l_ql_cursor IS NOT NULL THEN ");
        query.append("          CLOSE l_ql_cursor; ");
        query.append("        END IF; ");

//    -- Trigger Q's
        query.append("        ELSIF msrmnt.gem_msrmnt_typ_cd = 'SEVERITY_TRIGGET' THEN ");
        query.append("          l_cererity_found := TRUE; ");
        query.append("          SELECT nvl((SELECT gem_msrmnt_bucket_chain_id "); 
        query.append("            FROM gem_msrmnt_bucket_chain ");
        query.append("            WHERE publish_id = l_publish_id ");
        query.append("            AND gem_mgt_bucket_id = bkt.gem_mgt_bucket_id ");
        query.append("            AND gem_severity_id = svrty.gem_severity_id ");
        query.append("            AND gem_msrmnt_id = msrmnt.gem_msrmnt_id ");
        query.append("            AND rgn_id = l_rgn_id), 0) "); 
        query.append("          INTO l_msrmnt_bkt_chain_id ");
        query.append("          FROM dual; ");
            
        query.append("          SELECT count(*) ");
        query.append("          INTO l_scor_count ");
        query.append("          FROM qlty_lead_rpt q, STD s");
        query.append("          WHERE q.std_id = s.std_id AND s.std_typ = 'STD' AND q.publish_id = l_publish_id ");
        query.append("          AND q.rgn_id = l_rgn_id ");
        query.append("          AND q.gem_mgt_bucket_id = bkt.gem_mgt_bucket_id ");
        query.append("          AND q.gem_severity_id = svrty.gem_severity_id ");
        query.append("          AND q.gem_trigger_id > 0; ");
        query.append("          l_trigger_cnt := l_scor_count; ");
            
        query.append("          IF l_msrmnt_bkt_chain_id > 0 THEN ");
        query.append("            EXECUTE IMMEDIATE l_upd ");
        query.append("            USING to_char(l_scor_count), l_usr_id, l_msrmnt_bkt_chain_id; ");
        query.append("          ELSE ");
        query.append("            EXECUTE IMMEDIATE l_ins ");
        query.append("            USING gem_msrmnt_bucket_chain_id_seq.nextval, bkt.gem_mgt_bucket_id, svrty.gem_severity_id, msrmnt.gem_msrmnt_id, ");
        query.append("            l_publish_id, l_publish_dept_id, l_rgn_id, to_char(l_scor_count), l_usr_id, l_usr_id; ");
        query.append("          END IF; ");
            
        query.append("        ELSIF msrmnt.gem_msrmnt_typ_cd = 'SEVERITY_CMPL_DT' THEN ");
        query.append("          l_cererity_found := TRUE; ");
        query.append("          SELECT nvl((SELECT gem_msrmnt_bucket_chain_id "); 
        query.append("            FROM gem_msrmnt_bucket_chain ");
        query.append("            WHERE publish_id = l_publish_id ");
        query.append("            AND gem_mgt_bucket_id = bkt.gem_mgt_bucket_id ");
        query.append("            AND gem_severity_id = svrty.gem_severity_id ");
        query.append("            AND gem_msrmnt_id = msrmnt.gem_msrmnt_id ");
        query.append("            AND rgn_id = l_rgn_id), 0) "); 
        query.append("          INTO l_msrmnt_bkt_chain_id ");
        query.append("          FROM dual; ");

        query.append("          WITH ");
        query.append("          PUB_STD AS (SELECT r.std_id, 1 in_qlty_lead_rpt, r.qlty_lead_rpt_id, r.publish_id, r.gem_mgt_bucket_id, r.gem_severity_id, ");
        query.append("            r.gem_msrmnt_id, r.gem_trigger_id, r.gem_catgy_id, r.disp_order_nbr, r.creat_usr_id, r.creat_ts, r.lst_updt_usr_id, r.lst_updt_ts, ");
        query.append("            r.cmply_due_dy_qty, p.publish_id, p.chain_cd, p.publish_dt, r.rgn_id ");
        query.append("            FROM qlty_lead_rpt r, publish p ");
        query.append("            WHERE p.publish_id = l_publish_id AND r.publish_id = p.publish_id ");
        query.append("            AND r.gem_mgt_bucket_id = bkt.gem_mgt_bucket_id ");
        query.append("            AND r.gem_severity_id = svrty.gem_severity_id ");
        query.append("            AND r.rgn_id = l_rgn_id), ");
        query.append("          STD_NO_GDLN AS (SELECT s.std_id, ps.chain_cd, ps.publish_dt ");
        query.append("            FROM std s, PUB_STD ps ");
        query.append("            WHERE s.std_id = ps.std_id AND s.stat_desc != 'DELETED' AND s.std_typ = 'STD' ");
        query.append("            AND s.std_id IN (SELECT fs.std_id FROM flag_std fs WHERE fs.flag_catgy_id = 258)), ");
        query.append("          ALL_CTRY_STD AS ( SELECT DISTINCT scc.std_id, to_date(TO_CHAR(scc.cmply_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') AS cmply_dt, ");
        query.append("            to_date(to_char(scc.expr_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') AS expr_dt, to_char(scc.cmply_dt, 'DD Mon YYYY') AS cmply_dt_str, ");   
        query.append("            to_char(scc.expr_dt, 'DD Mon YYYY') AS expr_dt_str, ps.publish_dt ");
        query.append("            FROM std_ctry_chain scc, STD_NO_GDLN ps ");
        query.append("            WHERE scc.std_id = ps.std_id ");
        query.append("            AND scc.chain_cd = ps.chain_cd AND scc.rgn_cd = (SELECT rgn_cd FROM brndstnd_rgn WHERE rgn_id = l_rgn_id)), ");
        query.append("          FUT_DT_CNT AS (SELECT std_id, count(std_id) cnt FROM ALL_CTRY_STD WHERE cmply_dt > SYSDATE GROUP BY std_id), ");
        query.append("          PER_CTRY_FUT_DT_STD AS (SELECT * FROM FUT_DT_CNT WHERE cnt > 1), ");
        query.append("          FUT_DT_STD AS (SELECT * FROM FUT_DT_CNT WHERE cnt > 0  AND std_id NOT IN (SELECT std_id FROM PER_CTRY_FUT_DT_STD)), ");
        query.append("          STAT_STD_CTRY AS (SELECT std_id, NULL expr_dt_str, 'Per Country' cmply_dt_str FROM PER_CTRY_FUT_DT_STD ");
        query.append("            UNION ");
        query.append("            SELECT acs.std_id, acs.expr_dt_str, acs.cmply_dt_str ");
        query.append("            FROM FUT_DT_STD pc, ALL_CTRY_STD acs WHERE acs.std_id = pc.std_id AND acs.cmply_dt > SYSDATE), ");
        query.append("          ALL_STD_CMPLY_RULE_EXP AS (SELECT * FROM ( SELECT DISTINCT sc.std_id, ");
        query.append("            CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
        query.append("               CASE WHEN sc.rule_dt_cd = 'R' THEN ");
        query.append("                   CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");   
        query.append("                 add_months(ps.publish_dt, NVL(sc.cmply_rule_mo_qty, 0)) "); 
        query.append("               END ");
        query.append("              ELSE ");
        query.append("               CASE WHEN sc.cmply_expr_dt > SYSDATE THEN ");  
        query.append("                 sc.cmply_expr_dt ");
        query.append("               END ");
        query.append("             END ");
        query.append("            END cmply_dt, ");  
        query.append("            CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN sc.cmply_expr_dt END expr_dt, ");
        query.append("            CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
        query.append("             CASE WHEN sc.rule_dt_cd = 'R' THEN ");
        query.append("              CASE WHEN sc.cmply_rule_mo_qty > 0 THEN "); 
        query.append("                 sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(ps.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') ");  
        query.append("              END ");
        query.append("              ELSE ");
        query.append("              CASE WHEN sc.cmply_expr_dt > SYSDATE THEN ");    
        query.append("                'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') "); 
        query.append("              END ");
        query.append("             END ");
        query.append("            END cmply_dt_str, ");  
        query.append("            CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN ");    
        query.append("             'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') "); 
        query.append("            END expr_dt_str ");
        query.append("            FROM std_cmply sc, STD_NO_GDLN ps ");  
        query.append("            WHERE sc.chain_cd = ps.chain_cd ");
        query.append("            AND sc.std_id = ps.std_id ");
        query.append("            AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = l_rgn_id) ");   
        query.append("            AND sc.std_id NOT IN (SELECT std_id FROM ALL_CTRY_STD)) ");
        query.append("            WHERE (cmply_dt IS NOT NULL AND expr_dt IS NULL) ");
        query.append("            OR (cmply_dt IS NULL AND expr_dt IS NOT NULL) ");
        query.append("            OR (cmply_dt IS NOT NULL AND expr_dt IS NOT NULL) ), "); 
        query.append("          STD_CMPLY_RULE_EXP AS ( ");
        query.append("            SELECT sc.std_id, sc.cmply_dt, sc.expr_dt, decode(pc.cnt, 1, sc.expr_dt_str, 0, '', "); 
        query.append("            decode(sc.expr_dt_str, NULL, '', 'Per Country') ) expr_dt_str, ");
        query.append("            decode(pc.cnt, 1, sc.cmply_dt_str, 0, '', decode(sc.cmply_dt_str, NULL, '', 'Per Country') ) cmply_dt_str ");   
        query.append("            FROM (SELECT std_id, count(std_id) cnt FROM ALL_STD_CMPLY_RULE_EXP GROUP BY std_id) pc, ALL_STD_CMPLY_RULE_EXP sc   WHERE sc.std_id = pc.std_id  ), "); 
        query.append("          CMPLY_DATE AS ( ");
        query.append("            SELECT std_id, cmply_dt_str, expr_dt_str FROM STAT_STD_CTRY ");   
        query.append("            UNION ");
        query.append("            SELECT std_id, cmply_dt_str, expr_dt_str FROM STD_CMPLY_RULE_EXP ) ");
        query.append("          SELECT count(*) INTO l_scor_count FROM CMPLY_DATE; ");
        query.append("          l_feature_cnt := l_scor_count; ");
            
        query.append("          IF l_msrmnt_bkt_chain_id > 0 THEN ");
        query.append("            EXECUTE IMMEDIATE l_upd ");
        query.append("            USING to_char(l_scor_count), l_usr_id, l_msrmnt_bkt_chain_id; ");
        query.append("          ELSE ");
        query.append("            EXECUTE IMMEDIATE l_ins ");
        query.append("            USING gem_msrmnt_bucket_chain_id_seq.nextval, bkt.gem_mgt_bucket_id, svrty.gem_severity_id, msrmnt.gem_msrmnt_id, ");
        query.append("            l_publish_id, l_publish_dept_id, l_rgn_id, to_char(l_scor_count), l_usr_id, l_usr_id; ");
        query.append("          END IF; ");
        query.append("        END IF; ");
    
    //    -- insert row with all 0 for not existing severity
        query.append("        IF l_cererity_found = FALSE THEN ");
        query.append("          SELECT nvl((SELECT gem_msrmnt_bucket_chain_id ");
        query.append("            FROM gem_msrmnt_bucket_chain ");
        query.append("            WHERE publish_id = l_publish_id ");
        query.append("            AND gem_mgt_bucket_id = bkt.gem_mgt_bucket_id ");
        query.append("            AND gem_severity_id = svrty.gem_severity_id ");
        query.append("            AND gem_msrmnt_id = msrmnt.gem_msrmnt_id ");
        query.append("            AND rgn_id = l_rgn_id), 0) ");
        query.append("          INTO l_msrmnt_bkt_chain_id FROM dual; ");
              
        query.append("          IF l_msrmnt_bkt_chain_id > 0 THEN ");
        query.append("            EXECUTE IMMEDIATE l_upd USING '0', l_usr_id, l_msrmnt_bkt_chain_id; ");
        query.append("          ELSE ");
        query.append("            EXECUTE IMMEDIATE l_ins ");
        query.append("            USING gem_msrmnt_bucket_chain_id_seq.nextval, bkt.gem_mgt_bucket_id, svrty.gem_severity_id, msrmnt.gem_msrmnt_id, ");
        query.append("            l_publish_id, l_publish_dept_id, l_rgn_id, '0', l_usr_id, l_usr_id; ");
        query.append("          END IF; ");
        query.append("        END IF; ");
        query.append("      END LOOP; ");
        
        query.append("      SELECT nvl((SELECT gem_scor_pt_id FROM gem_scor_pt ");
        query.append("        WHERE publish_id = l_publish_id AND rgn_id = l_rgn_id "); 
        query.append("        AND gem_mgt_bucket_id = bkt.gem_mgt_bucket_id AND gem_severity_id = svrty.gem_severity_id), 0) ");
        query.append("      INTO l_scor_pt_id FROM dual; ");
                
        query.append("      IF l_scor_pt_id = 0 THEN ");
        query.append("        SELECT gem_scor_pt_id_seq.nextval INTO l_scor_pt_id FROM dual; ");
        query.append("        EXECUTE IMMEDIATE l_scor_pt_ins ");
        query.append("        USING l_scor_pt_id, l_publish_id, l_publish_dept_id, l_rgn_id, bkt.gem_mgt_bucket_id, svrty.gem_severity_id, 0, 0, 0, 0, l_usr_id, l_usr_id; ");
        query.append("      END IF; ");
                
        query.append("      l_total_qs := l_total - l_feature_cnt; ");
        
        query.append("      IF l_total_qs < 0 THEN ");
        query.append("        l_total_qs := 0; ");
        query.append("      END IF; ");
        query.append("      l_total_non_cmpl := ROUND(l_total_qs * 0.15 + 0.49); ");
        
        query.append("      IF ((svrty.gem_severity_nm = 'Auto Fail') AND (l_total_non_cmpl > 0)) THEN ");
        query.append("        l_total_non_cmpl := 1; ");
        query.append("      END IF; ");

        // TODO When Bucket is IHG Way then non-compliant value should be 0
        query.append("      IF (upper(bkt.gem_bucket_nm) = 'IHG WAY') THEN ");
        query.append("        l_total_non_cmpl := 0; ");
        query.append("      END IF; ");

        query.append("      SELECT count(*) INTO l_exist_cnt FROM scoring_val WHERE scoring_val_id = l_scor_pt_id; ");
        query.append("      IF l_exist_cnt > 0 THEN ");
        query.append("        EXECUTE IMMEDIATE l_score_val_upd USING l_total_qs, l_net, l_total_non_cmpl, 0, l_usr_id, l_scor_pt_id; ");
        query.append("      ELSE ");
        query.append("        EXECUTE IMMEDIATE l_score_val_ins ");
        query.append("        USING l_scor_pt_id, l_total_qs, l_net, l_total_non_cmpl, 0, l_usr_id, l_usr_id; ");
        query.append("      END IF; ");
        
        query.append("    END LOOP; ");
        query.append("  END LOOP; ");
    
        query.append("  COMMIT; ");
        query.append("END; ");
        return query.toString();
	}
	
	public static String getGemQLFormRecordsQuery(long bridgePublishId, long gemPublishId, long regionId, String regionCd, String brandCd, String seMnlTypeConfig, String filterRules)
	{
		String glblMust = null; 
        String stdRegion = null;
        String stdIdLst = null;
        String mnlType = null;
        long indexPathId = 0;
        String stdStatus = null; 
        String stdTitle = null;
        String stdCatgy = null;
        String stdOwner = null;
        String stdCmply = null;
        long catgyHead = 0;
        long seRptCatgy = 0;
        long criticality = 0;
        long seSeqNo = 0;
        long question = 0;
        String complDue = null;
        String duplicateInd = null;
        
        if (filterRules != null && !filterRules.isEmpty()) {
            try {
                JSONArray array = JSONFactoryUtil.createJSONArray(filterRules);
                for (int i = 0; i < array.length(); i++) {
                	JSONObject filterObj = array.getJSONObject(i);
                	if(filterObj.getString("field").equals("glblMust")){
                		glblMust = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("glblRgn")){
                		stdRegion = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("stdId")){
                		stdIdLst = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("mnlType")){
                		mnlType = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("path")){
                		String path = filterObj.getString("value");
                		String indexId = Validator.isNotNull(path) ? path.substring(0, path.indexOf("_")) : StringPool.BLANK;
                		indexPathId = Validator.isNotNull(indexId) ? Long.parseLong(indexId) : 0;
                	} else if(filterObj.getString("field").equals("stdStatus")){
                		stdStatus = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("title")){
                		stdTitle = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("catgy")){
                		stdCatgy = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("stdOwner")){
                		stdOwner = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("cmply")){
                		stdCmply = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("catgyHead")){
                		catgyHead = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("seRptCatgy")){
                		seRptCatgy = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("crit")){
                		criticality = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("seSeqNo")){
                		seSeqNo = Math.round(filterObj.getDouble("value"));
                	} else if(filterObj.getString("field").equals("question")){
                		question = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("complDue")){
                		complDue = filterObj.getString("value");
                	}else if(filterObj.getString("field").equals("duplicateInd")){
                		duplicateInd = filterObj.getString("value");
                	}
                }
            } catch (JSONException e) {
                LOG.error("Failed to extract JSON", e);
            }
        } 
        if(Validator.isNull(mnlType)){
    		if (GemConstants.MANUAL_TYPE_OPERATE.equals(seMnlTypeConfig) || GemConstants.MANUAL_TYPE_FULL_BUILD_OPERATE.equals(seMnlTypeConfig)) {
    			mnlType = String.valueOf(GemConstants.MANUAL_TYPE_ID_OPERATE);
            } else if (GemConstants.MANUAL_TYPE_BUILD.equals(seMnlTypeConfig)) {
            	mnlType = String.valueOf(GemConstants.MANUAL_TYPE_ID_BUILD);
            }
        }
		
		
		StringBuilder query = new StringBuilder();
        
        query.append("WITH ");
        query.append(" SEL_FLAGS AS (SELECT flag_catgy_id FROM flag_catgy WHERE flag_catgy_id IN (258, 257) AND actv_ind='Y' ORDER BY disp_order_nbr),");
        query.append(" CUR_TAX AS (SELECT T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, (LEVEL - 1) TLEVEL, T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(TITLE_TXT, ' -> '), 21) PATH");
        query.append("  FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID),");
        query.append(" PUB_STD AS (SELECT q.std_id, q.qlty_lead_rpt_id, q.publish_id, q.gem_mgt_bucket_id, q.gem_severity_id, q.gem_msrmnt_id, q.gem_trigger_id, q.gem_catgy_id,");
        query.append("  q.disp_order_nbr, q.creat_usr_id, q.creat_ts, q.lst_updt_usr_id, q.lst_updt_ts,");
        query.append("  q.cmply_due_dy_qty, p.publish_id, p.chain_cd, p.publish_dt, q.rgn_id, q.gbl_must_measure_std_ind,q.prnt_qlty_lead_rpt_id,q.duplicate_ind");
        query.append("  FROM qlty_lead_rpt q, publish p");
        query.append("  WHERE p.publish_id = ").append(gemPublishId);
        query.append("  AND q.publish_id = p.publish_id"); 
        query.append("  AND q.rgn_id = ").append(regionId);
        
        if(catgyHead > 0) {
            query.append(" AND q.gem_catgy_id=").append(catgyHead);
        }
        if(seRptCatgy > 0) {
            query.append(" AND q.gem_mgt_bucket_id=").append(seRptCatgy);
        }
        if(criticality > 0) {
            query.append(" AND q.gem_severity_id = ").append(criticality);
        }
        if(seSeqNo > 0) {
            query.append(" AND q.disp_order_nbr = ").append(seSeqNo);
        }
        if(question > 0) {
            query.append(" AND q.gem_trigger_id = ").append(question);
        }
        if(Validator.isNotNull(complDue)) {
            query.append(" AND q.cmply_due_dy_qty = ").append(complDue);
        }
        
        if(Validator.isNotNull(duplicateInd)) {
        	 if("Y".equals(duplicateInd)) {
                 query.append(" AND q.duplicate_ind  = 'Y' ");
             } else if("N".equals(duplicateInd)) {
                 query.append(" AND q.duplicate_ind  = 'N' ");
             } 
        	       	          
        }

        if ("MEASURED".equals(stdStatus)) {
            query.append(" AND q.gem_mgt_bucket_id > 0 ");
            query.append(" AND q.gem_severity_id > 0 ");
            query.append(" AND q.gem_catgy_id > 0 ");
        } else if ("NOT_MEASURED".equals(stdStatus)) {
            query.append(" AND (q.gem_mgt_bucket_id = 0");
            query.append(" OR q.gem_severity_id = 0");
            query.append(" OR q.gem_catgy_id = 0)");
        }
        
        if("Y".equals(glblMust)) {
            query.append(" AND q.gbl_must_measure_std_ind = 'Y' ");
        } else if("N".equals(glblMust)) {
            query.append(" AND q.gbl_must_measure_std_ind = 'N' ");
        } 
        
        query.append("),");
        
        query.append(" STD_NO_GDLN AS (SELECT s.std_id, ps.chain_cd, ps.publish_dt ");
        query.append("  FROM std s, PUB_STD ps WHERE s.std_id = ps.std_id AND s.stat_desc != 'DELETED' AND s.std_typ != 'GDLN' ), ");
        query.append(" ALL_CTRY_STD AS (SELECT DISTINCT scc.std_id, to_date(TO_CHAR(scc.cmply_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') AS cmply_dt, ");
        query.append("  to_date(to_char(scc.expr_dt, 'DD Mon YYYY'), 'DD-MON-YYYY') AS expr_dt, to_char(scc.cmply_dt, 'DD Mon YYYY') AS cmply_dt_str, ");   
        query.append("  to_char(scc.expr_dt, 'DD Mon YYYY') AS expr_dt_str, ps.publish_dt ");
        query.append("  FROM std_ctry_chain scc, STD_NO_GDLN ps ");
        query.append("  WHERE scc.std_id = ps.std_id ");
        query.append("  AND scc.chain_cd = ps.chain_cd AND scc.rgn_cd = '").append(regionCd).append("'  ), "); 
        query.append(" FUT_DT_CNT AS (SELECT std_id, count(std_id) cnt FROM ALL_CTRY_STD WHERE cmply_dt > SYSDATE GROUP BY std_id ), "); 
        query.append(" PER_CTRY_FUT_DT_STD AS (SELECT * FROM FUT_DT_CNT WHERE cnt > 1 ), "); 
        query.append(" FUT_DT_STD AS (SELECT * FROM FUT_DT_CNT WHERE cnt > 0 AND std_id NOT IN (SELECT std_id FROM PER_CTRY_FUT_DT_STD) ), "); 
        query.append(" STAT_STD_CTRY AS (SELECT std_id, NULL expr_dt_str, 'Per Country' cmply_dt_str FROM PER_CTRY_FUT_DT_STD "); 
        query.append("  UNION "); 
        query.append("  SELECT acs.std_id, acs.expr_dt_str, acs.cmply_dt_str ");    
        query.append("  FROM FUT_DT_STD pc, ALL_CTRY_STD acs "); 
        query.append("  WHERE acs.std_id = pc.std_id AND acs.cmply_dt > SYSDATE), "); 
        query.append(" ALL_STD_CMPLY_RULE_EXP AS (SELECT * FROM ( ");  
        query.append("  SELECT DISTINCT sc.std_id, ");
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN CASE WHEN sc.rule_dt_cd = 'R' THEN CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
        query.append("   add_months(ps.publish_dt, NVL(sc.cmply_rule_mo_qty, 0)) END ELSE ");
        query.append("  CASE WHEN sc.cmply_expr_dt > SYSDATE THEN sc.cmply_expr_dt END END END cmply_dt, ");
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN sc.cmply_expr_dt END expr_dt, ");
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN CASE WHEN sc.rule_dt_cd = 'R' THEN CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
        query.append("   sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(ps.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') END ELSE ");
        query.append("  CASE WHEN sc.cmply_expr_dt > SYSDATE THEN 'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') END END END cmply_dt_str, ");
        query.append("  CASE WHEN sc.cmply_expr_rule_cd = 'E' THEN 'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') END expr_dt_str ");
        query.append("  FROM std_cmply sc, STD_NO_GDLN ps ");
        query.append("  WHERE sc.chain_cd = ps.chain_cd ");
        query.append("  AND sc.std_id = ps.std_id ");
        query.append("  AND sc.ctry_nm_cd IN (SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ").append(regionId).append(") ");   
        query.append("  AND sc.std_id NOT IN (SELECT std_id FROM ALL_CTRY_STD) ) ");
        query.append("  WHERE (cmply_dt IS NOT NULL AND expr_dt IS NULL) ");
        query.append("  OR (cmply_dt IS NULL AND expr_dt IS NOT NULL) ");
        query.append("  OR (cmply_dt IS NOT NULL AND expr_dt IS NOT NULL) ), "); 
        query.append("  STD_CMPLY_RULE_EXP AS (SELECT DISTINCT sc.std_id, sc.cmply_dt, sc.expr_dt, decode(pc.cnt, 1, sc.expr_dt_str, 0, '', ");
        query.append("  decode(sc.expr_dt_str, NULL, '', 'Per Country') ) expr_dt_str, ");
        query.append("  decode(pc.cnt, 1, sc.cmply_dt_str, 0, '', decode(sc.cmply_dt_str, NULL, '', 'Per Country') ) cmply_dt_str ");   
        query.append("  FROM (SELECT std_id, count(std_id) cnt FROM ALL_STD_CMPLY_RULE_EXP GROUP BY std_id) pc, ALL_STD_CMPLY_RULE_EXP sc   WHERE sc.std_id = pc.std_id), "); 
        query.append(" CMPLY_DATE AS (SELECT std_id, cmply_dt_str, expr_dt_str FROM STAT_STD_CTRY ");
        query.append("  UNION SELECT std_id, cmply_dt_str, expr_dt_str FROM STD_CMPLY_RULE_EXP ) ");
        
        if (stdIdLst != null && !stdIdLst.isEmpty()) {
            query.append(", std_id_crit AS (SELECT std_id FROM std WHERE std_id IN  (").append(stdIdLst).append(") ");
            query.append(" UNION ");
            query.append(" SELECT std_id FROM STD WHERE prnt_std_id IN ( SELECT prnt_std_id FROM std WHERE std_id IN  (").append(stdIdLst).append("))) ");
        }
        
        query.append(" SELECT TAX.TAXONOMY_ID INDX_TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID INDX_PRNT_TAXONOMY_ID, TAX.TITLE_TXT INDX_TITLE_TXT, ");
        query.append("TAX.TLEVEL INDX_LEVEL, TAX.HIER_LVL_NBR INDX_HIER_LVL_NBR, TAX.PATH INDX_PATH, ");
        query.append("s.std_id, s.prnt_std_id, s.std_typ, decode(s.std_typ, 'GDLN', s.std_desc, s.title_txt) title_txt, ");
        query.append("s.rgn_cd, s.gbl_rgn_ind, s.framework_std_ind, ");
        query.append("decode(s.rgn_cd, 'GLBL', ");
        query.append(" decode(s.gbl_rgn_ind, 'G', decode(s.framework_std_ind, 'Y', 'Global'), decode(s.framework_std_ind, 'Y', 'Global')), ");
        query.append(" s.rgn_cd) glbl_or_rgn, ");
        
        query.append("st.stat_cd, st.stat_title_txt, nvl(q.qlty_lead_rpt_id, 0) qlty_lead_rpt_id, ");
        query.append(gemPublishId).append(" publish_id, "); 
        
        query.append("nvl(q.gem_mgt_bucket_id, 0) gem_mgt_bucket_id, (SELECT gem_bucket_nm FROM gem_mgt_bucket WHERE gem_mgt_bucket_id = q.gem_mgt_bucket_id) gem_bucket_nm, ");
        query.append("nvl(q.gem_severity_id, 0) gem_severity_id, (SELECT gem_severity_nm FROM gem_severity WHERE gem_severity_id = q.gem_severity_id) gem_severity_nm, "); 
        query.append("nvl(q.gem_msrmnt_id, 0) gem_msrmnt_id, (SELECT gem_msrmnt_nm FROM gem_msrmnt WHERE gem_msrmnt_id = q.gem_msrmnt_id) gem_msrmnt_nm, ");
        query.append("nvl(q.gem_trigger_id, 0) gem_trigger_id, ");
        query.append("nvl((SELECT trigger_qstn_txt FROM gem_trigger WHERE gem_trigger_id = q.gem_trigger_id AND publish_id = ").append(gemPublishId).append("), 'Not Required') trigger_qstn_txt, ");
        query.append("nvl(q.gem_catgy_id, 0) gem_catgy_id, (SELECT gem_catgy_nm FROM gem_catgy WHERE gem_catgy_id = q.gem_catgy_id) gem_catgy_nm, ");
        query.append("NVL(q.disp_order_nbr, 0) disp_order_nbr, ");
        query.append("nvl((SELECT decode(count(*), 0, 0, 1) FROM bridge_publish ");
        query.append("  WHERE publish_id = ").append(bridgePublishId).append(" AND std_id = s.std_id ");
        if (regionId > 1) {
            query.append("  AND rgn_id = ").append(regionId).append(" ");
        }
        query.append(" ), 0) in_publication, ");
        query.append("q.creat_usr_id, s.bus_owner_nm, s.area_catgy_cd, nvl(q.cmply_due_dy_qty, 0) cmply_due_dy_qty, ");
        query.append("nvl((SELECT gem_cd_desc FROM gem_cd WHERE gem_cd = to_char(q.cmply_due_dy_qty)), '') cmply_due_desc, ");
        query.append("cmply.cmply_dt_str AS cmply_dt, ");
        query.append("(SELECT disp_order_nbr FROM gem_catgy WHERE gem_catgy_id = nvl(q.gem_catgy_id, 0)) catgy_disp_order, ");
        query.append("CASE WHEN s.STD_TYP = 'STD' THEN CASE WHEN NVL(q.disp_order_nbr, 0) <= 0 THEN 1000 ELSE NVL(q.disp_order_nbr, 0) END ELSE NVL(q.disp_order_nbr, 0) END seq_disp_order, ");
        query.append("q.gbl_must_measure_std_ind, ");
        query.append("(SELECT LISTAGG(fs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY fs.STD_ID) FROM FLAG_STD fs, SEL_FLAGS sf"); 		
        query.append(" WHERE s.STD_ID = fs.STD_ID AND fs.flag_catgy_id=sf.flag_catgy_id GROUP BY fs.STD_ID) as FLAG_IDS,q.prnt_qlty_lead_rpt_id,q.duplicate_ind");
        query.append(" FROM std s, chain_std cs, stat st, CUR_TAX TAX, TAXONOMY_STD TS, PUB_STD q, CMPLY_DATE cmply ");
        if (stdIdLst != null && !stdIdLst.isEmpty()) {
            query.append(", std_id_crit sic ");
        }
        
        query.append("WHERE TS.TAXONOMY_ID = TAX.TAXONOMY_ID "); 
        query.append("AND (TS.STD_ID = S.STD_ID OR TS.STD_ID = S.PRNT_STD_ID) ");
        query.append("AND s.std_id = cs.std_id "); 
        query.append("AND cs.stat_id = st.stat_id ");
        query.append("AND s.stat_desc != 'DELETED' ");
        query.append("AND s.std_id IN (SELECT DISTINCT cts.std_id FROM ctry_std cts WHERE cts.ctry_nm_cd IN ");
        query.append("(SELECT ctry_nm_cd FROM brndstnd_ctry WHERE rgn_id = ").append(regionId).append(")) ");
        query.append("AND cs.chain_cd = '").append(brandCd).append("' ");
        query.append("AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') ");
        query.append("AND s.std_id = q.std_id ");
        query.append("AND s.std_id = cmply.std_id(+) ");
        query.append("AND s.std_id IN (SELECT fs.std_id FROM flag_std fs WHERE fs.flag_catgy_id IN (").append(mnlType).append("))");
        
        if (stdIdLst != null && !stdIdLst.isEmpty()) {
            query.append(" AND s.std_id=sic.std_id");
        }
        
        if (Validator.isNotNull(stdOwner)) {
            query.append(" AND s.bus_owner_nm='").append(stdOwner).append("'");
        }
        
        if (Validator.isNotNull(stdRegion)) {
            query.append(" AND s.rgn_cd='").append(stdRegion).append("'");
        }
        if (Validator.isNotNull(stdCatgy)) {
            query.append(" AND s.area_catgy_cd='").append(stdCatgy).append("'");
        }
        if (Validator.isNotNull(stdTitle)) {
            query.append(" AND upper(s.title_txt) LIKE '%").append(stdTitle.toUpperCase()).append("%'");
        }
        if (Validator.isNotNull(stdCmply) && "EXIST".equals(stdCmply)) {
            query.append(" AND cmply.cmply_dt_str IS NOT NULL");
        } else if (Validator.isNotNull(stdCmply) && "NOT_EXIST".equals(stdCmply)) {
        	query.append(" AND cmply.cmply_dt_str IS NULL");
        }
        if (indexPathId > 0) {
            query.append(" AND TAX.TAXONOMY_ID=").append(indexPathId);
        }
        
        query.append(" ORDER BY catgy_disp_order, gem_catgy_id, seq_disp_order, STD_ID DESC, DUPLICATE_IND");
        
        return query.toString(); 
	}
	
	public static String getGemSaveQuery(List<QualityLeadModel> records, long publishDeptId, long parentPublishId, long publishId, long regionId, String userName, boolean isReSequence, boolean isGlobalUser){
		
		StringBuilder query = new StringBuilder();
        query.append("DECLARE"); 
        query.append("  l_rgn_id NUMBER := ").append(regionId).append(";");
        query.append("  l_publish_id NUMBER := ").append(publishId).append(";");
        query.append("  l_publish_dept_id NUMBER := ").append(publishDeptId).append(";");
        //GEM_PUBLISH_DEPT_ID
        query.append("  l_user VARCHAR2(50) := '").append(userName).append("';");
        query.append("  l_tmpl_cd VARCHAR2(10) := 'SE';");
        query.append("  l_chain_cd VARCHAR2(10) := 'EX';");
        query.append("  l_cnt NUMBER;");
        query.append("  l_gem_msrmnt_id NUMBER;");
        query.append("  l_template_id NUMBER;");
        query.append("  l_cur SYS_REFCURSOR;");
        query.append("  l_tmp_rgn_id NUMBER;");
        query.append("  l_qlty_lead_rpt_id NUMBER;");
        query.append("  l_gem_catgy_nm VARCHAR2(100);");
        query.append("  l_sql VARCHAR2(450) :=");
        query.append("    'INSERT INTO qlty_lead_rpt(qlty_lead_rpt_id, publish_id, gem_publish_dept_id, std_id, gem_mgt_bucket_id, gem_severity_id, ' ||");
        query.append("    'gem_msrmnt_id, gem_trigger_id, gem_catgy_id, disp_order_nbr, rgn_id, cmply_due_dy_qty, gbl_must_measure_std_ind, ' ||");
        query.append("    'creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");
        query.append("    'VALUES(:id, :pubId, :publishDeptId, :stdId, :bktId, :svrtId, :msrmntId, :trigId, :catId, :sortOrd, :rgnId, :cmplyDt, :glblMust, :usr, SYSDATE, :usr, SYSDATE)';");
        query.append("  l_sql_updt VARCHAR2(400) :=");
        query.append("    'UPDATE qlty_lead_rpt ' ||");
        query.append("    'SET gem_mgt_bucket_id = :bktId, gem_severity_id = :svrtId, gem_msrmnt_id = :msrmntId, gem_trigger_id = :trigId, ' ||");
        query.append("    'gem_catgy_id = :catId, disp_order_nbr = :sortOrd, rgn_id = :rgnId, cmply_due_dy_qty = :cmplyDt, gbl_must_measure_std_ind = :glblMust, ' ||");
        query.append("    'lst_updt_usr_id = :usr, lst_updt_ts = SYSDATE ' ||");
        query.append("    'WHERE qlty_lead_rpt_id = :qlId'; ");
        query.append("  l_sql_std_catgy VARCHAR2(400) := 'INSERT INTO gem_std_catgy(gem_std_catgy_id, std_id, gem_catgy_id, template_typ_cd, chain_cd, ' || ");
        query.append("    'creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' || ");
        query.append("    'SELECT :gemStdId, :stdId, :catgyId, :tmplCd, :chainCd, :usrId, SYSDATE, :usrId, SYSDATE FROM dual ' || "); 
        query.append("    'WHERE NOT EXISTS (SELECT std_id FROM gem_std_catgy WHERE std_id = :stdId AND gem_catgy_id = :catgyId AND template_typ_cd = :tmplCd AND chain_cd = :chainCd)'; ");
        
        //Re-Sequence related variables
        if(isReSequence) {
	        query.append("  l_seq_itr INTEGER;");
	        query.append("  TYPE qlty_lead_rec IS RECORD (QLTY_LEAD_RPT_ID NUMBER, STD_ID NUMBER, GEM_CATGY_ID NUMBER, GEM_MGT_BUCKET_ID NUMBER, GEM_SEVERITY_ID NUMBER, DISP_ORDER_NBR NUMBER, PRNT_QLTY_LEAD_RPT_ID NUMBER, DUPLICATE_IND CHAR(1), ROW_SEQ NUMBER);");
	        query.append("  TYPE qlty_lead_rec_type IS TABLE OF qlty_lead_rec;");
	        query.append("  l_ql_tbl qlty_lead_rec_type;");
	        query.append("  l_deci_rec_cur SYS_REFCURSOR := NULL;");
	        query.append("  CURSOR l_dest_cat_cur IS SELECT DISTINCT q.GEM_CATGY_ID FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP='STD'");
	        query.append("    AND q.PUBLISH_ID=l_publish_id AND q.RGN_ID=l_rgn_id AND q.GEM_CATGY_ID > 0;");
	        
	        query.append("  l_cat_invalid_seq_stds_cnt_sql VARCHAR2(1000) := 'WITH QL_REC AS (SELECT q.QLTY_LEAD_RPT_ID, q.STD_ID, q.GEM_CATGY_ID, q.GEM_MGT_BUCKET_ID, q.GEM_SEVERITY_ID, q.DISP_ORDER_NBR FROM' ||");
	        query.append("    ' QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''STD'' AND q.PUBLISH_ID=:l_publish_id' ||"); 
	        query.append("    ' AND q.RGN_ID=:l_rgn_id AND q.GEM_CATGY_ID=:catId AND q.DISP_ORDER_NBR > 0 ORDER BY q.DISP_ORDER_NBR, q.STD_ID DESC)' ||");
	        query.append("    ' SELECT count(*) FROM (SELECT QL_REC.*, ROWNUM AS ROW_SEQ FROM QL_REC) WHERE DISP_ORDER_NBR != ROW_SEQ';");
	        
	        query.append("  l_cat_invalid_seq_stds_sql VARCHAR2(1000) := 'WITH QL_REC AS (SELECT q.QLTY_LEAD_RPT_ID, q.STD_ID, q.GEM_CATGY_ID, q.GEM_MGT_BUCKET_ID, q.GEM_SEVERITY_ID, q.DISP_ORDER_NBR, NVL(q.PRNT_QLTY_LEAD_RPT_ID,0) PRNT_QLTY_LEAD_RPT_ID, q.DUPLICATE_IND FROM' ||");
	        query.append("    ' QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''STD'' AND q.PUBLISH_ID=:l_publish_id' ||"); 
	        query.append("    ' AND q.RGN_ID=:l_rgn_id AND q.GEM_CATGY_ID=:catId AND q.DISP_ORDER_NBR > 0 ORDER BY q.DISP_ORDER_NBR, q.STD_ID DESC)' ||");
	        query.append("    ' SELECT * FROM (SELECT QL_REC.*, ROWNUM AS ROW_SEQ FROM QL_REC)';");
	        
	        query.append("  l_updt_seq_under_cat_sql VARCHAR2(350) := 'UPDATE QLTY_LEAD_RPT SET DISP_ORDER_NBR=:seq, GEM_CATGY_ID=:catId, gem_mgt_bucket_id=:buktId' ||"); 
	        query.append("    ' WHERE QLTY_LEAD_RPT_ID IN (SELECT q.QLTY_LEAD_RPT_ID FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.PRNT_STD_ID=:stdId' ||");
	        query.append("    ' AND s.STD_TYP = ''SPEC'' AND q.PUBLISH_ID=:l_publish_id AND q.RGN_ID=:l_rgn_id AND q.QLTY_LEAD_RPT_ID=q.PRNT_QLTY_LEAD_RPT_ID)';");
	        
	        query.append("  l_updt_dupSpec_seq_underCatSql VARCHAR2(350) := 'UPDATE QLTY_LEAD_RPT SET DISP_ORDER_NBR=:seq, GEM_CATGY_ID=:catId, gem_mgt_bucket_id=:buktId' ||"); 
	        query.append("    ' WHERE QLTY_LEAD_RPT_ID IN (SELECT q.QLTY_LEAD_RPT_ID FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.PRNT_STD_ID=:stdId' ||");
	        query.append("    ' AND s.STD_TYP = ''SPEC'' AND q.PUBLISH_ID=:l_publish_id AND q.RGN_ID=:l_rgn_id AND q.PRNT_QLTY_LEAD_RPT_ID=:prntQltyLeadRptId)';");
	        
	        query.append("  l_cat_stds_sql  VARCHAR2(400) := 'SELECT q.QLTY_LEAD_RPT_ID, q.STD_ID, q.GEM_CATGY_ID, q.GEM_MGT_BUCKET_ID, q.GEM_SEVERITY_ID, q.DISP_ORDER_NBR, NVL(q.PRNT_QLTY_LEAD_RPT_ID,0) PRNT_QLTY_LEAD_RPT_ID, q.DUPLICATE_IND, ROWNUM AS ROW_SEQ' ||");
	        query.append("    ' FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''STD'' AND q.PUBLISH_ID=:l_publish_id AND q.RGN_ID=:l_rgn_id AND q.GEM_CATGY_ID=:catId ORDER BY q.DISP_ORDER_NBR, q.STD_ID DESC';");

	        query.append("  l_updt_invalid_specs_config VARCHAR2(650) := 'UPDATE QLTY_LEAD_RPT SET GEM_CATGY_ID=:catId, GEM_MGT_BUCKET_ID=:buktId, GEM_SEVERITY_ID=(CASE WHEN GEM_SEVERITY_ID > 0 THEN :servityId ELSE 0 END), LST_UPDT_USR_ID=:l_user, LST_UPDT_TS=SYSDATE' ||");
	        query.append("    ' WHERE QLTY_LEAD_RPT_ID IN (SELECT q.QLTY_LEAD_RPT_ID FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''SPEC'' AND q.PUBLISH_ID=:l_publish_id AND q.RGN_ID=:l_rgn_id' ||");
	        query.append("    ' AND s.PRNT_STD_ID=:stdID AND q.DUPLICATE_IND=''N'' AND q.QLTY_LEAD_RPT_ID=q.PRNT_QLTY_LEAD_RPT_ID' ||");
	        query.append("    ' AND (q.GEM_CATGY_ID != :catId OR q.GEM_MGT_BUCKET_ID != :buktId OR (q.GEM_SEVERITY_ID > 0 AND q.GEM_SEVERITY_ID != :servityId)))';");

	        query.append("  l_updt_invalid_dupSpecs_config VARCHAR2(650) := 'UPDATE QLTY_LEAD_RPT SET GEM_CATGY_ID=:catId, GEM_MGT_BUCKET_ID=:buktId, GEM_SEVERITY_ID=(CASE WHEN GEM_SEVERITY_ID > 0 THEN :servityId ELSE 0 END), LST_UPDT_USR_ID=:l_user, LST_UPDT_TS=SYSDATE' ||");
	        query.append("    ' WHERE QLTY_LEAD_RPT_ID IN (SELECT q.QLTY_LEAD_RPT_ID FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''SPEC'' AND q.PUBLISH_ID=:l_publish_id AND q.RGN_ID=:l_rgn_id' ||");
	        query.append("    ' AND s.PRNT_STD_ID=:stdId AND q.DUPLICATE_IND=''Y'' AND q.PRNT_QLTY_LEAD_RPT_ID=:prntQltyLeadRptId' ||");
	        query.append("    ' AND (q.GEM_CATGY_ID != :catId OR q.GEM_MGT_BUCKET_ID != :buktId OR (q.GEM_SEVERITY_ID > 0 AND q.GEM_SEVERITY_ID != :servityId)))';");
        }
        
        query.append("BEGIN ");
        
        query.append("  SELECT gem_template_id INTO l_template_id FROM gem_template WHERE rgn_id = l_rgn_id AND publish_id = l_publish_id AND template_typ_cd = 'SE';");
    
        for (QualityLeadModel std : records)
        {
            query.append(" l_gem_msrmnt_id := 0; ");
            query.append(" IF ").append(std.getCategoryId()).append(" > 0 THEN ");
            query.append(" BEGIN ");
            query.append("  SELECT gem_msrmnt_id "); 
            query.append("  INTO l_gem_msrmnt_id ");
            query.append("  FROM gem_msrmnt "); 
            query.append("  WHERE gem_template_id = l_template_id AND gem_msrmnt_nm = ( ");
            query.append("  SELECT c.gem_catgy_nm ");
            query.append("  FROM gem_catgy c, gem_template_catgy tc "); 
            query.append("  WHERE c.gem_catgy_id = tc.gem_catgy_id ");
            query.append("  AND tc.duplicatable_ind = 'Y' "); 
            query.append("  AND tc.gem_template_id = l_template_id "); 
            query.append("  AND c.gem_catgy_id = tc.gem_catgy_id "); 
            query.append("  AND c.gem_catgy_id = ").append(std.getCategoryId()).append("); ");
            query.append(" EXCEPTION WHEN OTHERS THEN l_gem_msrmnt_id := 0; ");
            query.append(" END; ");
            
            query.append(" IF l_gem_msrmnt_id = 0 THEN ");
            query.append(" BEGIN ");
            query.append("   SELECT c.gem_catgy_nm ");
            query.append("   INTO l_gem_catgy_nm ");
            query.append("   FROM gem_catgy c, gem_template_catgy tc, ");
            query.append("   (SELECT gem_prnt_catgy_id, gem_catgy_cd FROM gem_catgy WHERE gem_catgy_id = ").append(std.getCategoryId()).append(") chld ");
            query.append("   WHERE c.gem_catgy_id = tc.gem_catgy_id ");
            query.append("   AND tc.gem_template_id = l_template_id ");
            query.append("   AND tc.duplicatable_ind = 'Y' ");
            query.append("   AND (c.gem_catgy_cd = chld.gem_prnt_catgy_id OR c.gem_catgy_cd = chld.gem_catgy_cd) ");
            query.append("   START WITH c.gem_catgy_cd = chld.gem_prnt_catgy_id ");
            query.append("   CONNECT BY NOCYCLE PRIOR c.gem_catgy_cd = c.gem_prnt_catgy_id ");
            query.append("   AND ROWNUM = 1; ");
            query.append(" EXCEPTION WHEN OTHERS THEN ");
            query.append("   l_gem_catgy_nm := NULL; ");
            query.append(" END; ");
            
            query.append(" SELECT NVL( ");
            query.append("   (SELECT gm.gem_msrmnt_id FROM gem_msrmnt gm WHERE gm.gem_template_id = l_template_id AND gm.gem_msrmnt_nm = l_gem_catgy_nm), "); 
            query.append("   (SELECT gem_msrmnt_id FROM gem_msrmnt WHERE gem_msrmnt_typ_cd = 'SEVERITY_OTHER' AND gem_template_id = l_template_id)) AS gem_msrmnt_id ");
            query.append(" INTO l_gem_msrmnt_id ");
            query.append(" FROM dual; ");

            query.append(" END IF; ");
            query.append(" END IF; ");
            
            if (std.getId() > 0)
            {
                if (isGlobalUser && std.isGlobal() && "Y".equals(std.getGlobalMust()) )
                {
                    // Update across all available regions. Insert if needed.
                    query.append("  OPEN l_cur FOR ");
                    query.append("  SELECT DISTINCT bc.rgn_id  ");
                    query.append("  FROM ctry_std cs, brndstnd_ctry bc ");
                    query.append("  WHERE cs.ctry_nm_cd = bc.ctry_nm_cd ");
                    query.append("  AND cs.std_id = ").append(std.getStdId()).append("; ");
                    query.append("  LOOP ");
                    query.append("    FETCH l_cur INTO l_tmp_rgn_id; ");
                    query.append("    EXIT WHEN l_cur%NOTFOUND; ");
                    query.append("    SELECT count(*) INTO l_cnt FROM qlty_lead_rpt WHERE std_id = ").append(std.getStdId()).append(" AND rgn_id = l_tmp_rgn_id AND publish_id = l_publish_id;");
                    query.append("    IF l_cnt > 0 THEN ");
                    query.append("      SELECT qlty_lead_rpt_id INTO l_qlty_lead_rpt_id FROM qlty_lead_rpt WHERE std_id = ").append(std.getStdId()).append(" AND rgn_id = l_tmp_rgn_id AND publish_id = l_publish_id AND duplicate_ind='N';");
                    query.append("      EXECUTE IMMEDIATE l_sql_updt ");
                    query.append("      USING ").append(std.getBucketId()).append(", ").append(std.getSeverityId()).append(", l_gem_msrmnt_id, ");
                    query.append(       std.getTriggerId()).append(", ").append(std.getCategoryId()).append(", ").append(std.getSeSquence());
                    query.append("      , l_tmp_rgn_id, ").append(std.getComplDueId()).append(", '").append(std.getGlobalMust()).append("', l_user, l_qlty_lead_rpt_id;");
                    query.append("    ELSE ");
                    query.append("      EXECUTE IMMEDIATE l_sql ");
                    query.append("      USING qlty_lead_rpt_id_seq.nextval, l_publish_id, l_publish_dept_id, ").append(std.getStdId()).append(", ").append(std.getBucketId()).append(", ").append(std.getSeverityId());
                    query.append(", l_gem_msrmnt_id, ").append(std.getTriggerId()).append(", ").append(std.getCategoryId()).append(", ").append(std.getSeSquence()).append(" , l_tmp_rgn_id, ");
                    query.append(std.getComplDueId()).append(", '").append(std.getGlobalMust()).append("', l_user, l_user;");
                    query.append("    END IF; ");
                    query.append("  END LOOP;");
                    query.append("  IF l_cur IS NOT NULL THEN");
                    query.append("    CLOSE l_cur; ");
                    query.append("  END IF; ");                
                }
                else 
                {
                    query.append("  EXECUTE IMMEDIATE l_sql_updt ");
                    query.append("  USING ").append(std.getBucketId()).append(", ").append(std.getSeverityId()).append(", l_gem_msrmnt_id, ");
                    query.append(std.getTriggerId()).append(", ").append(std.getCategoryId()).append(", ").append(std.getSeSquence());
                    query.append(", l_rgn_id, ").append(std.getComplDueId()).append(", '").append(std.getGlobalMust()).append("', l_user, ").append(std.getId()).append(";");
                }
            }
            
            if (std.getCategoryId() > 0)
            {
                query.append("  SELECT count(*) INTO l_cnt FROM gem_std_catgy WHERE std_id = ").append(std.getStdId()).append(";");
                query.append("  IF l_cnt > 0 THEN ");
                query.append("    UPDATE gem_std_catgy SET gem_catgy_id = ").append(std.getCategoryId()).append(" WHERE std_id = ").append(std.getStdId()).append(";");
                query.append("  ELSE ");
                query.append("    EXECUTE IMMEDIATE l_sql_std_catgy ");   
                query.append("    USING gem_std_catgy_id_seq.nextval, ").append(std.getStdId()).append(", ").append(std.getCategoryId());
                query.append("  , l_tmpl_cd, l_chain_cd, l_user, l_user, ").append(std.getStdId()).append(", ").append(std.getCategoryId());
                query.append("  , l_tmpl_cd, l_chain_cd;");
                query.append("  END IF; ");
            }
            
        }
        query.append("  COMMIT; ");
        if(isReSequence) {
	        //Re-Sequence related logic
	        query.append("  FOR catgy IN l_dest_cat_cur LOOP");
	        query.append("    EXECUTE IMMEDIATE l_cat_invalid_seq_stds_cnt_sql INTO l_cnt USING l_publish_id, l_rgn_id, catgy.GEM_CATGY_ID;");
	        //--DBMS_OUTPUT.PUT_LINE('Category Id=' || catgy.GEM_CATGY_ID  || '<--> l_cnt-->' || l_cnt);
	        query.append("    IF l_cnt > 0 THEN"); 
	        query.append("      l_seq_itr := 1;");
	        query.append("      OPEN l_deci_rec_cur FOR l_cat_invalid_seq_stds_sql USING l_publish_id, l_rgn_id, catgy.GEM_CATGY_ID;");                  
	        query.append("      LOOP");   
	        query.append("          FETCH l_deci_rec_cur BULK COLLECT INTO l_ql_tbl LIMIT 1000;");
	        query.append("            IF l_ql_tbl.COUNT > 0 THEN");  
	        query.append("              FOR indx IN l_ql_tbl.FIRST.. l_ql_tbl.LAST");          
	        query.append("              LOOP");
	        //--DBMS_OUTPUT.PUT_LINE('==========>Std_id=' || l_ql_tbl(indx).STD_ID || ' <-> Seq No=' || l_seq_itr);
	        query.append("                IF l_ql_tbl(indx).DISP_ORDER_NBR != l_ql_tbl(indx).ROW_SEQ THEN");
	        query.append("                	UPDATE QLTY_LEAD_RPT SET DISP_ORDER_NBR=l_seq_itr WHERE QLTY_LEAD_RPT_ID=l_ql_tbl(indx).QLTY_LEAD_RPT_ID;");
	        query.append("                	IF l_ql_tbl(indx).DUPLICATE_IND='N' THEN");
	        query.append("                		EXECUTE IMMEDIATE l_updt_seq_under_cat_sql USING l_seq_itr, l_ql_tbl(indx).GEM_CATGY_ID, l_ql_tbl(indx).GEM_MGT_BUCKET_ID, l_ql_tbl(indx).STD_ID, l_publish_id, l_rgn_id;");
	        query.append("					ELSE");
	        query.append("						EXECUTE IMMEDIATE l_updt_dupSpec_seq_underCatSql USING l_seq_itr, l_ql_tbl(indx).GEM_CATGY_ID, l_ql_tbl(indx).GEM_MGT_BUCKET_ID, l_ql_tbl(indx).STD_ID, l_publish_id, l_rgn_id, l_ql_tbl(indx).QLTY_LEAD_RPT_ID;");
	        query.append("					END IF;");
	        //--DBMS_OUTPUT.PUT_LINE('Updated Seq No for=>Std_id=' || l_ql_tbl(indx).STD_ID || ' <-> Seq No=' || indx);
	        //ELSE DBMS_OUTPUT.PUT_LINE('Not Updated Seq No for=>Std_id=' || l_ql_tbl(indx).STD_ID || ' <-> Seq No=' || l_ql_tbl(indx).DISP_ORDER_NBR || '!= ' ||l_ql_tbl(indx).ROW_SEQ);
	        query.append("                END IF;");
	        query.append("                l_seq_itr := l_seq_itr + 1;");                
	        query.append("              END LOOP;");
	        query.append("              COMMIT;");
	        query.append("            END IF;");
	        query.append("          EXIT WHEN l_deci_rec_cur%NOTFOUND;");      
	        query.append("      END LOOP;");
	        query.append("      CLOSE l_deci_rec_cur;");
	        query.append("    END IF;");
	        
	        //--Update specifications configuration to match with standard configuration Category heading, SE reporting Category, Q Criticality and SE Sequence No
	        query.append("    OPEN l_deci_rec_cur FOR l_cat_stds_sql USING l_publish_id, l_rgn_id, catgy.GEM_CATGY_ID;");                  
	        query.append("    LOOP");
	        query.append("        FETCH l_deci_rec_cur BULK COLLECT INTO l_ql_tbl LIMIT 1000;");
	        query.append("          IF l_ql_tbl.COUNT > 0 THEN");
	        query.append("            FOR indx IN l_ql_tbl.FIRST.. l_ql_tbl.LAST");
	        query.append("            LOOP");
	        query.append("              IF l_ql_tbl(indx).DUPLICATE_IND = 'N' THEN");
	        query.append("                EXECUTE IMMEDIATE l_updt_invalid_specs_config USING l_ql_tbl(indx).GEM_CATGY_ID, l_ql_tbl(indx).GEM_MGT_BUCKET_ID,");
	        query.append("                l_ql_tbl(indx).GEM_SEVERITY_ID, l_user, l_publish_id, l_rgn_id, l_ql_tbl(indx).STD_ID, l_ql_tbl(indx).GEM_CATGY_ID,");
	        query.append("                l_ql_tbl(indx).GEM_MGT_BUCKET_ID, l_ql_tbl(indx).GEM_SEVERITY_ID;");
	        query.append("              ELSE");
	        query.append("                EXECUTE IMMEDIATE l_updt_invalid_dupSpecs_config USING l_ql_tbl(indx).GEM_CATGY_ID, l_ql_tbl(indx).GEM_MGT_BUCKET_ID,");
	        query.append("                l_ql_tbl(indx).GEM_SEVERITY_ID, l_user, l_publish_id, l_rgn_id, l_ql_tbl(indx).STD_ID, l_ql_tbl(indx).PRNT_QLTY_LEAD_RPT_ID,");
	        query.append("                l_ql_tbl(indx).GEM_CATGY_ID, l_ql_tbl(indx).GEM_MGT_BUCKET_ID, l_ql_tbl(indx).GEM_SEVERITY_ID;");
	        query.append("              END IF;");
	        query.append("            END LOOP;");
	        query.append("            COMMIT;");
	        query.append("          END IF;");
	        query.append("        EXIT WHEN l_deci_rec_cur%NOTFOUND;");
	        query.append("    END LOOP;");
	        query.append("    CLOSE l_deci_rec_cur;"); //--l_deci_rec_cur end
	        
	        query.append("  END LOOP;"); //--Category Loop end
        }
        
        query.append(" END;");
        if(LOG.isDebugEnabled()){
        	LOG.debug("Gem Save Query: " + query.toString());
        }
        return query.toString();
	}

	public static String syncBridgeGEMQlReport(long actvGemDeptId, long actvGemPublishDeptId, long brdgPublishId, long actvGemPublishId, 
			long regionId, String regionCd, String brandCd, String screenName, String userName, String seManualType, 
			String saManualType, String wrManualType)
    {
        StringBuilder query = new StringBuilder();
        StringBuilder manualTypeStr = new StringBuilder(); 
        if (GemConstants.MANUAL_TYPE_OPERATE.equals(seManualType)) {
        	manualTypeStr.append(GemConstants.MANUAL_TYPE_ID_OPERATE).append(")");
        } else if (GemConstants.MANUAL_TYPE_BUILD.equals(seManualType)) {
        	manualTypeStr.append(GemConstants.MANUAL_TYPE_ID_BUILD).append(")");
        } else if (GemConstants.MANUAL_TYPE_FULL_BUILD_OPERATE.equals(seManualType)) {
        	manualTypeStr.append(GemConstants.MANUAL_TYPE_ID_OPERATE).append(",");
        	manualTypeStr.append(GemConstants.MANUAL_TYPE_ID_BUILD);
        	manualTypeStr.append(")");
        }
        
        query.append("DECLARE ");
        query.append("  l_actvGemDeptId NUMBER := ").append(actvGemDeptId).append("; ");
        query.append("  l_actvGemPublishDeptId NUMBER := ").append(actvGemPublishDeptId).append("; ");
        query.append("  l_brdgPublishId NUMBER := ").append(brdgPublishId).append("; ");
        query.append("  l_actvGemPublishId NUMBER := ").append(actvGemPublishId).append("; ");
        query.append("  l_rgn_id NUMBER := ").append(regionId).append("; ");
        query.append("  l_rgn_cd VARCHAR2(4) := '").append(regionCd).append("'; ");
        query.append("  l_chain_cd VARCHAR2(2) := '").append(brandCd).append("'; ");
        query.append("  l_user VARCHAR2(50) := '").append(screenName).append("'; ");
        query.append("  l_user_nm VARCHAR2(250) := '").append(userName).append("';");
        query.append("  l_id NUMBER; ");
        query.append("  l_lst_publish_id NUMBER;");
        query.append("  l_due_date_qty VARCHAR2(20);");
        query.append("  l_gem_mgt_bucket_id NUMBER;");
        query.append("  l_gem_severity_id NUMBER;");
        query.append("  l_gem_msrmnt_id NUMBER;");
        query.append("  l_gem_trigger_id NUMBER;");
        query.append("  l_lst_gem_trigger_id NUMBER;");
        query.append("  l_gem_catgy_id NUMBER;");
        query.append("  l_disp_order_nbr NUMBER;");  
        query.append("  l_cmply_due_dy_qty NUMBER;");
        query.append("  l_gem_se_template_id NUMBER;");
        query.append("  l_gbl_must_measure_std_ind VARCHAR2(1);");
        query.append("  l_brdg_rec_cnt  NUMBER := 0;");
        query.append("  l_qlform_rec_cnt  NUMBER := 0;");
        query.append("  l_sa_grp_regnrt_ind VARCHAR2(1) := 'N';");
        query.append("  l_se_grp_regnrt_ind VARCHAR2(1) := 'N';");
        query.append("  l_msr_std_del_cnt NUMBER := 0;");
        query.append("  l_jobqueue_cnt NUMBER := 0;");
        query.append("  l_job_metadata CLOB;");
        
        //--New Records from Bridge
        query.append("  CURSOR l_new_rec_cur IS ");
        query.append("  WITH STD_NEW_REC AS ("); 
        query.append("  	SELECT DISTINCT s.std_id FROM bridge_publish b, std s, chain_std cs, stat st");
        query.append("  	WHERE b.publish_id = l_brdgPublishId AND s.std_id = b.std_id ");
        query.append("  	AND s.std_id = cs.std_id AND cs.stat_id = st.stat_id ");
        query.append("  	AND s.stat_desc != 'DELETED' AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ') ");
        query.append("      AND s.std_id IN (SELECT fs.std_id FROM flag_std fs WHERE fs.flag_catgy_id in (").append(manualTypeStr).append(")");
        query.append("  	AND cs.chain_cd = l_chain_cd AND b.rgn_id = l_rgn_id ");
        query.append("    MINUS ");
        query.append("  	SELECT std_id FROM qlty_lead_rpt WHERE publish_id = l_actvGemPublishId AND rgn_id = l_rgn_id),");
        query.append("  STD_RGN AS ( ");
        query.append("  	SELECT DISTINCT b.std_id, b.rgn_id FROM bridge_publish b, STD_NEW_REC sn ");
        query.append("  	WHERE b.publish_id = l_brdgPublishId AND b.rgn_id = l_rgn_id AND b.unpublish_ind = 'N' AND b.std_id = sn.std_id)");
        query.append("  SELECT s.std_id, s.rgn_id, nvl(gsc.gem_catgy_id, 0) gem_catgy_id ");
        query.append("  	FROM std_rgn s, gem_std_catgy gsc WHERE s.std_id = gsc.std_id(+); ");
                
        query.append("  l_sql VARCHAR2(700) := 'INSERT INTO qlty_lead_rpt(qlty_lead_rpt_id, publish_id, gem_publish_dept_id, std_id, gem_mgt_bucket_id, gem_severity_id, ' || ");
        query.append("  'gem_msrmnt_id, gem_trigger_id, gem_catgy_id, disp_order_nbr, rgn_id, cmply_due_dy_qty, gbl_must_measure_std_ind, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts,prnt_qlty_lead_rpt_id,duplicate_ind) ' || ");
        query.append("  'SELECT :qId, :pubId, :deptPublishId, :stdId, :bktId, :svrtId, :msrmntId, :trigId, :catId, :sortOrd, :rgnId, :cmplyDt, :glblMust, :usr, SYSDATE, :usr, SYSDATE, :qId, ''N''  FROM dual ' || ");
        query.append("  'WHERE NOT EXISTS (SELECT qlty_lead_rpt_id FROM qlty_lead_rpt WHERE publish_id = :pubId AND std_id = :stdId AND rgn_id = :rgnId)'; ");
        
        query.append(" l_job_queue_sql VARCHAR2(1000) := 'INSERT INTO job_queue(job_id, job_owner, job_typ, metadata_txt, link_txt, ' ||");
        query.append(" 'notification_email_id, strt_ts, end_ts, stat_cd, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");
        query.append(" 'VALUES (:job_id, :job_owner, :job_typ, :metadata_txt, NULL, ''gtbrandstandards@ihg.com'',' ||");
        query.append(" 'NULL, NULL, ''NEW'', :creat_usr_id, SYSDATE, :lst_updt_usr_id, SYSDATE)';");
        
        query.append("  TYPE qlty_lead_rec IS RECORD (QLTY_LEAD_RPT_ID NUMBER, STD_ID NUMBER, GEM_CATGY_ID NUMBER, PRNT_GEM_CATGY_ID NUMBER, GEM_MGT_BUCKET_ID NUMBER, PRNT_GEM_MGT_BUCKET_ID NUMBER, DISP_ORDER_NBR NUMBER, PRNT_DISP_ORDER_NBR NUMBER);");
        query.append("  TYPE qlty_lead_rec_type IS TABLE OF qlty_lead_rec;");
        query.append("  l_ql_tbl qlty_lead_rec_type;");
        query.append("  l_mis_match_rec_cur SYS_REFCURSOR := NULL;");
        query.append("  l_mismatch_cnt  NUMBER := 0;");
        
        query.append("  l_spec_mis_match_stds_cnt_sql VARCHAR2(1000) := 'WITH QL_MIS_MATCH_REC AS (SELECT q.QLTY_LEAD_RPT_ID, q.STD_ID,' ||");
        query.append("    ' q.GEM_CATGY_ID, (SELECT GEM_CATGY_ID FROM QLTY_LEAD_RPT WHERE PUBLISH_ID=:l_pub_id AND RGN_ID=:l_rgn_id AND STD_ID=s.PRNT_STD_ID) AS PRNT_GEM_CATGY_ID,' ||");
        query.append("    ' q.GEM_MGT_BUCKET_ID, (SELECT GEM_MGT_BUCKET_ID FROM QLTY_LEAD_RPT WHERE PUBLISH_ID=:l_pub_id AND RGN_ID=:l_rgn_id AND STD_ID=s.PRNT_STD_ID) AS PRNT_GEM_MGT_BUCKET_ID,' ||");
        query.append("    ' q.DISP_ORDER_NBR, (SELECT DISP_ORDER_NBR FROM QLTY_LEAD_RPT WHERE PUBLISH_ID=:l_pub_id AND RGN_ID=:l_rgn_id AND STD_ID=s.PRNT_STD_ID) AS PRNT_DISP_ORDER_NBR' ||");
        query.append("    ' FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''SPEC'' AND q.PUBLISH_ID=:l_pub_id AND q.RGN_ID=:l_rgn_id)' ||"); 
        query.append("    ' SELECT count(*) FROM QL_MIS_MATCH_REC WHERE GEM_CATGY_ID != PRNT_GEM_CATGY_ID OR GEM_MGT_BUCKET_ID != PRNT_GEM_MGT_BUCKET_ID OR DISP_ORDER_NBR != PRNT_DISP_ORDER_NBR ORDER BY QLTY_LEAD_RPT_ID';");
        
        query.append("  l_spec_mis_match_stds_sql VARCHAR2(1000) := 'WITH QL_MIS_MATCH_REC AS (SELECT q.QLTY_LEAD_RPT_ID, q.STD_ID,' ||");
        query.append("    ' q.GEM_CATGY_ID, (SELECT GEM_CATGY_ID FROM QLTY_LEAD_RPT WHERE PUBLISH_ID=:l_pub_id AND RGN_ID=:l_rgn_id AND STD_ID=s.PRNT_STD_ID) AS PRNT_GEM_CATGY_ID,' ||");
        query.append("    ' q.GEM_MGT_BUCKET_ID, (SELECT GEM_MGT_BUCKET_ID FROM QLTY_LEAD_RPT WHERE PUBLISH_ID=:l_pub_id AND RGN_ID=:l_rgn_id AND STD_ID=s.PRNT_STD_ID) AS PRNT_GEM_MGT_BUCKET_ID,' ||");
        query.append("    ' q.DISP_ORDER_NBR, (SELECT DISP_ORDER_NBR FROM QLTY_LEAD_RPT WHERE PUBLISH_ID=:l_pub_id AND RGN_ID=:l_rgn_id AND STD_ID=s.PRNT_STD_ID) AS PRNT_DISP_ORDER_NBR' ||");
        query.append("    ' FROM QLTY_LEAD_RPT q, STD s WHERE q.STD_ID=s.STD_ID AND s.STD_TYP=''SPEC'' AND q.PUBLISH_ID=:l_pub_id AND q.RGN_ID=:l_rgn_id)' ||"); 
        query.append("    ' SELECT * FROM QL_MIS_MATCH_REC WHERE GEM_CATGY_ID != PRNT_GEM_CATGY_ID OR GEM_MGT_BUCKET_ID != PRNT_GEM_MGT_BUCKET_ID OR DISP_ORDER_NBR != PRNT_DISP_ORDER_NBR ORDER BY QLTY_LEAD_RPT_ID';");
        
        query.append("  l_updt_sql VARCHAR2(350) := 'UPDATE QLTY_LEAD_RPT SET GEM_CATGY_ID=:catId, gem_mgt_bucket_id=:buktId, DISP_ORDER_NBR=:seq, lst_updt_usr_id=:usr, lst_updt_ts=SYSDATE WHERE QLTY_LEAD_RPT_ID=:ql_rpt_id'; "); 
        
        query.append("BEGIN ");
        
        //-- Sync only if Bridge has mare then 50% of QL Form std count
        query.append("  SELECT Count(*) INTO l_brdg_rec_cnt FROM BRIDGE_PUBLISH WHERE publish_id=l_brdgPublishId AND rgn_id=l_rgn_id AND unpublish_ind='N';");
        query.append("  SELECT Count(*) INTO l_qlform_rec_cnt FROM qlty_lead_rpt WHERE publish_id=l_actvGemPublishId AND rgn_id=l_rgn_id;");
        query.append("  IF l_brdg_rec_cnt > ROUND(l_qlform_rec_cnt/2) THEN");  
        
        //--- Selecting Last GEM Publish Id based on dept id and current SE Template Id
        query.append("    BEGIN");
        query.append("  	SELECT publish_id INTO l_lst_publish_id FROM (SELECT publish_id FROM publish WHERE publish_environment_nm IN ('GEM_CMS', 'GEM_OBSM')"); 
        query.append("  	AND chain_cd = l_chain_cd AND publish_stat_cd = 'ARCHIVE' AND ");
        query.append(" publish_id in (SELECT publish_id from GEM_PUBLISH_DEPT where GEM_DEPT_ID = l_actvGemDeptId) ");
        query.append(" ORDER BY creat_ts DESC) WHERE rownum = 1;");
        query.append("  	SELECT gem_template_id INTO l_gem_se_template_id FROM GEM_TEMPLATE WHERE publish_id=l_actvGemPublishId AND rgn_id=l_rgn_id AND template_typ_cd='SE';");
        query.append("    EXCEPTION WHEN OTHERS THEN");
        query.append("      l_lst_publish_id := 0;");    
        query.append("      l_gem_se_template_id := 0;");
        query.append("    END;");
        
        //-- Check if we are deleting any measured standards and re-generate SE Unique Groups if so
        query.append("  SELECT COUNT(*) INTO l_msr_std_del_cnt FROM (SELECT STD_ID FROM qlty_lead_rpt WHERE publish_id=l_actvGemPublishId AND rgn_id=l_rgn_id AND gem_mgt_bucket_id > 0 AND gem_severity_id > 0 AND gem_catgy_id > 0"); 
        query.append("      MINUS SELECT s.std_id FROM bridge_publish b, std s, chain_std cs, stat st");
        query.append("      WHERE b.publish_id=l_brdgPublishId AND b.unpublish_ind = 'N'");
        query.append("      AND s.std_id = b.std_id AND s.std_id = cs.std_id AND cs.stat_id = st.stat_id");
        query.append("      AND s.stat_desc != 'DELETED' AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        query.append("    	AND s.std_id IN (SELECT fs.std_id FROM flag_std fs WHERE fs.flag_catgy_id in (").append(manualTypeStr).append(")");        
        query.append("      AND cs.chain_cd=l_chain_cd AND b.rgn_id=l_rgn_id);");
        
        query.append("  IF l_msr_std_del_cnt > 0 THEN"); 
        query.append("    l_se_grp_regnrt_ind := 'Y';");
        query.append("  END IF;");
        
        //-- Deleting standards from QLFrom which are not in Bridge publication
        query.append("  DELETE qlty_lead_rpt WHERE publish_id = l_actvGemPublishId AND rgn_id = l_rgn_id");
        query.append("  AND std_id IN ("); 
        query.append("  	SELECT std_id FROM qlty_lead_rpt WHERE publish_id = l_actvGemPublishId AND rgn_id = l_rgn_id");
        query.append("    MINUS");
        query.append("  	SELECT s.std_id FROM bridge_publish b, std s, chain_std cs, stat st");
        query.append("  	WHERE b.publish_id = l_brdgPublishId AND b.unpublish_ind = 'N'");
        query.append("  	AND s.std_id = b.std_id AND s.std_id = cs.std_id AND cs.stat_id = st.stat_id");
        query.append("  	AND s.stat_desc != 'DELETED' AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')");
        query.append("    	AND s.std_id IN (SELECT fs.std_id FROM flag_std fs WHERE fs.flag_catgy_id in (").append(manualTypeStr).append(")");
        query.append("  	AND cs.chain_cd = l_chain_cd AND b.rgn_id = l_rgn_id);");
        //--Check deletion count 
        query.append(" 	IF SQL%ROWCOUNT > 0 THEN");
        query.append("  	l_sa_grp_regnrt_ind := 'Y';");
        query.append(" 	END IF;");
        
        //--Selecting default due date for all standards
        query.append("  SELECT gem_cd INTO l_due_date_qty FROM gem_cd WHERE gem_cd_val='").append(GemConstants.QL_FORM_DEFAULT_DUE_DATE).append("';");
        
        //-- Inserting New records from Bridge into QL Form table
        query.append("  FOR rec IN l_new_rec_cur LOOP ");
        query.append("    BEGIN");
        //-- Selecting measurement information from Previous Publication
        query.append("      SELECT gem_mgt_bucket_id, gem_severity_id, gem_trigger_id, gem_catgy_id, disp_order_nbr, cmply_due_dy_qty, gbl_must_measure_std_ind");  
        query.append("      INTO   l_gem_mgt_bucket_id, l_gem_severity_id, l_lst_gem_trigger_id, l_gem_catgy_id, l_disp_order_nbr, l_cmply_due_dy_qty, l_gbl_must_measure_std_ind");
        query.append("      FROM qlty_lead_rpt WHERE publish_id = l_lst_publish_id AND rgn_id = l_rgn_id AND STD_ID = rec.std_id;");
          
        //--Re-Calculate Gem Measurement Id for the current publication
        query.append("      SELECT NVL((SELECT gem_msrmnt_id FROM gem_msrmnt WHERE gem_template_id = l_gem_se_template_id AND gem_msrmnt_nm=");
        query.append("      (SELECT c.gem_catgy_nm FROM gem_catgy c, gem_template_catgy tc WHERE c.gem_catgy_id = tc.gem_catgy_id AND tc.duplicatable_ind = 'Y'"); 
        query.append("      AND (c.gem_prnt_catgy_id = (SELECT DISTINCT c1.gem_prnt_catgy_id FROM gem_catgy c1, gem_template_catgy tc1"); 
        query.append("      WHERE tc1.gem_template_id =l_gem_se_template_id");  
        query.append("      AND c1.gem_catgy_id = tc1.gem_catgy_id"); 
        query.append("      AND c1.gem_catgy_id = rec.gem_catgy_id) OR"); 
        query.append("      c.gem_catgy_cd = (SELECT DISTINCT c1.gem_prnt_catgy_id FROM gem_catgy c1, gem_template_catgy tc1"); 
        query.append("      WHERE tc1.gem_template_id = l_gem_se_template_id"); 
        query.append("      AND c1.gem_catgy_id = tc1.gem_catgy_id AND c1.gem_catgy_id = rec.gem_catgy_id)) AND rownum = 1)),"); 
        query.append("      (SELECT gem_msrmnt_id FROM gem_msrmnt WHERE gem_msrmnt_typ_cd = 'SEVERITY_OTHER' AND gem_template_id = l_gem_se_template_id)) AS gem_msrmnt_id"); 
        query.append("      INTO l_gem_msrmnt_id FROM DUAL;");
        
        //--Re-Calculate Gem Trigger Id for the current publication
        query.append("      SELECT nvl((SELECT gem_trigger_id FROM gem_trigger WHERE publish_id=l_actvGemPublishId AND trigger_qstn_txt=(SELECT trigger_qstn_txt FROM gem_trigger WHERE publish_id=l_lst_publish_id AND gem_trigger_id=l_lst_gem_trigger_id)), 0)");
        query.append("      AS gem_trigger_id INTO l_gem_trigger_id FROM DUAL;");
        
        //--On SQL No Data Found Exception initialize the default
        query.append("    EXCEPTION WHEN OTHERS THEN");
        query.append("      l_gem_mgt_bucket_id := 0;");
        query.append("      l_gem_severity_id := 0;");
        query.append("      l_gem_msrmnt_id := 0;"); 
        query.append("      l_gem_trigger_id := 0;");
        query.append("      l_gem_catgy_id := rec.gem_catgy_id;");
        query.append("      l_disp_order_nbr := 0;");  
        query.append("      l_cmply_due_dy_qty := l_due_date_qty;");   
        query.append("      l_gbl_must_measure_std_ind := 'N';");
        query.append("    END;");
        
        //--Inserting new records into QL Form Table
        query.append("    EXECUTE IMMEDIATE l_sql USING qlty_lead_rpt_id_seq.nextval, l_actvGemPublishId, l_actvGemPublishDeptId, rec.std_id, l_gem_mgt_bucket_id, l_gem_severity_id, l_gem_msrmnt_id,"); 
        query.append("    l_gem_trigger_id, l_gem_catgy_id, l_disp_order_nbr, rec.rgn_id, l_cmply_due_dy_qty, l_gbl_must_measure_std_ind, l_user, l_user, qlty_lead_rpt_id_seq.currval, l_actvGemPublishId, rec.std_id, rec.rgn_id;");
        query.append("	  IF SQL%ROWCOUNT > 0 THEN");
        query.append("    	l_sa_grp_regnrt_ind := 'Y';");
        query.append("    	IF (l_gem_mgt_bucket_id > 0 AND l_gem_severity_id > 0 AND l_gem_catgy_id > 0) THEN");
        query.append("  		l_se_grp_regnrt_ind := 'Y';");
        query.append("    	END IF;");
        query.append("    END IF;");
        query.append("  END LOOP;");
        //--Insert request into Job_queue to re-generate Unique Groups
        query.append("    IF l_sa_grp_regnrt_ind = 'Y' THEN");
        query.append(" 		l_job_metadata := '<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>'||");
        query.append(" 		'<metadata><type>COUNTRY_GROUP</type><params>' ||");
        query.append(" 		'<param name=\"ENVIRONMENT\">GEM</param>'||");
        query.append(" 		'<param name=\"GEM_PUBLISH_ID\">' || l_actvGemPublishId || '</param>' ||");
        query.append(" 		'<param name=\"CHAIN_CD\">' || l_chain_cd || '</param>' ||");
        query.append(" 		'<param name=\"MANUAL_TYPE\">"+saManualType+"</param>' ||");
        query.append(" 		'<param name=\"REGION_CD\">' || l_rgn_cd || '</param>' ||");
        query.append(" 		'<param name=\"REGION_ID\">' || l_rgn_id || '</param>' ||");
        query.append(" 		'<param name=\"GROUP_TYPE\">SA</param>' ||");
        query.append(" 		'<param name=\"USER_NAME\">' || l_user_nm || '</param>' ||");
        query.append(" 		'</params></metadata>';");
        query.append(" 		SELECT COUNT(JOB_ID) INTO l_jobqueue_cnt FROM JOB_QUEUE WHERE STAT_CD = 'NEW' AND metadata_txt LIKE l_job_metadata;");
        query.append(" 		IF l_jobqueue_cnt = 0 THEN");
        query.append("  		EXECUTE IMMEDIATE l_job_queue_sql USING job_id_seq.nextval, l_user, 'COUNTRY_GROUP', l_job_metadata, l_user, l_user;");
        query.append("    	END IF;");
        query.append("    END IF;");
        //Waiver unique groups
        query.append("    IF l_sa_grp_regnrt_ind = 'Y' THEN");
        query.append(" 		l_job_metadata := '<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>'||");
        query.append(" 		'<metadata><type>COUNTRY_GROUP</type><params>' ||");
        query.append(" 		'<param name=\"ENVIRONMENT\">GEM</param>'||");
        query.append(" 		'<param name=\"GEM_PUBLISH_ID\">' || l_actvGemPublishId || '</param>' ||");
        query.append(" 		'<param name=\"CHAIN_CD\">' || l_chain_cd || '</param>' ||");
        query.append(" 		'<param name=\"MANUAL_TYPE\">"+wrManualType+"</param>' ||");
        query.append(" 		'<param name=\"REGION_CD\">' || l_rgn_cd || '</param>' ||");
        query.append(" 		'<param name=\"REGION_ID\">' || l_rgn_id || '</param>' ||");
        query.append(" 		'<param name=\"GROUP_TYPE\">WR</param>' ||");
        query.append(" 		'<param name=\"USER_NAME\">' || l_user_nm || '</param>' ||");
        query.append(" 		'</params></metadata>';");
        query.append(" 		SELECT COUNT(JOB_ID) INTO l_jobqueue_cnt FROM JOB_QUEUE WHERE STAT_CD = 'NEW' AND metadata_txt LIKE l_job_metadata;");
        query.append(" 		IF l_jobqueue_cnt = 0 THEN");
        query.append("  		EXECUTE IMMEDIATE l_job_queue_sql USING job_id_seq.nextval, l_user, 'COUNTRY_GROUP', l_job_metadata, l_user, l_user;");
        query.append("    	END IF;");
        query.append("    END IF;");
        //SE unique groups
        query.append("    IF l_se_grp_regnrt_ind = 'Y' THEN");
        query.append(" 		l_job_metadata := '<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>'||");
        query.append(" 		'<metadata><type>COUNTRY_GROUP</type><params>' ||");
        query.append(" 		'<param name=\"ENVIRONMENT\">GEM</param>'||");
        query.append(" 		'<param name=\"GEM_PUBLISH_ID\">' || l_actvGemPublishId || '</param>' ||");
        query.append(" 		'<param name=\"CHAIN_CD\">' || l_chain_cd || '</param>' ||");
        query.append(" 		'<param name=\"MANUAL_TYPE\">"+seManualType+"</param>' ||");
        query.append(" 		'<param name=\"REGION_CD\">' || l_rgn_cd || '</param>' ||");
        query.append(" 		'<param name=\"REGION_ID\">' || l_rgn_id || '</param>' ||");
        query.append(" 		'<param name=\"GROUP_TYPE\">SE</param>' ||");
        query.append(" 		'<param name=\"USER_NAME\">' || l_user_nm || '</param>' ||");
        query.append(" 		'</params></metadata>';");
        query.append(" 		SELECT COUNT(JOB_ID) INTO l_jobqueue_cnt FROM JOB_QUEUE WHERE STAT_CD = 'NEW' AND metadata_txt LIKE l_job_metadata;");
        query.append(" 		IF l_jobqueue_cnt = 0 THEN");
        query.append("  		EXECUTE IMMEDIATE l_job_queue_sql USING job_id_seq.nextval, l_user, 'COUNTRY_GROUP', l_job_metadata, l_user, l_user;");
        query.append("    	END IF;");
        query.append("    END IF;");
        query.append("  COMMIT;");
        
        query.append("    EXECUTE IMMEDIATE l_spec_mis_match_stds_cnt_sql INTO l_mismatch_cnt USING l_actvGemPublishId, l_rgn_id, l_actvGemPublishId, l_rgn_id, l_actvGemPublishId, l_rgn_id, l_actvGemPublishId, l_rgn_id;");
        //query.append("    DBMS_OUTPUT.PUT_LINE('l_spec_mis_match_stds_cnt=' || l_mismatch_cnt);");
        query.append("    IF l_mismatch_cnt > 0 THEN");
        query.append("      OPEN l_mis_match_rec_cur FOR l_spec_mis_match_stds_sql USING l_actvGemPublishId, l_rgn_id, l_actvGemPublishId, l_rgn_id, l_actvGemPublishId, l_rgn_id, l_actvGemPublishId, l_rgn_id;");                  
        query.append("      LOOP");   
        query.append("          FETCH l_mis_match_rec_cur BULK COLLECT INTO l_ql_tbl LIMIT 1000;");
        query.append("            IF l_ql_tbl.COUNT > 0 THEN");  
        query.append("              FOR indx IN l_ql_tbl.FIRST.. l_ql_tbl.LAST");          
        query.append("              LOOP");
        query.append("                	EXECUTE IMMEDIATE l_updt_sql USING l_ql_tbl(indx).PRNT_GEM_CATGY_ID, l_ql_tbl(indx).PRNT_GEM_MGT_BUCKET_ID, l_ql_tbl(indx).PRNT_DISP_ORDER_NBR, l_user, l_ql_tbl(indx).QLTY_LEAD_RPT_ID;");
        //query.append("                	DBMS_OUTPUT.PUT_LINE('==========>QLTY_LEAD_RPT_ID=' || l_ql_tbl(indx).QLTY_LEAD_RPT_ID || '<->' || l_ql_tbl(indx).STD_ID || '<->' || l_ql_tbl(indx).GEM_CATGY_ID || '<->' || l_ql_tbl(indx).PRNT_GEM_CATGY_ID");
        //query.append("                	|| '<->' || l_ql_tbl(indx).GEM_MGT_BUCKET_ID || '<->' || l_ql_tbl(indx).PRNT_GEM_MGT_BUCKET_ID || '<->' || l_ql_tbl(indx).DISP_ORDER_NBR || '<->' || l_ql_tbl(indx).PRNT_DISP_ORDER_NBR);");
        query.append("              END LOOP;");
        query.append("              COMMIT;");
        query.append("            END IF;");
        query.append("          EXIT WHEN l_mis_match_rec_cur%NOTFOUND;");      
        query.append("      END LOOP;");
        query.append("      CLOSE l_mis_match_rec_cur;");
        query.append("    END IF;");
        
        
        
        query.append("  END IF;");
        query.append("END;");
        
        return query.toString();
    }
	
	/**
	 * 
	 * @param publishId
	 * @return String
	 * Get manual types of report for publication
	 */
	public static String getReportManualTypes (long publishId) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT PARM_NM, PARM_VAL from PUBLISH_PARM where PUBLISH_ID = ");
		query.append(publishId);
		query.append(" AND PARM_NM IN ('SE','SA','WR') ");
		return query.toString();
	}
	
	public static String getGemPathFilterData(long gemPublishId, long regionId) {
		StringBuilder query = new StringBuilder("WITH ");
        query.append(" CMS_TAX AS (SELECT T.TAXONOMY_ID, TRIM(T.TITLE_TXT) AS TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(TITLE_TXT, ' -> '), 21) PATH");
        query.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID)");
        query.append(" SELECT UNIQUE ct.taxonomy_id, ct.TITLE_TXT, ct.PATH FROM qlty_lead_rpt q, TAXONOMY_STD ts, CMS_TAX ct WHERE q.publish_id=").append(gemPublishId);
        query.append(" AND q.rgn_id=").append(regionId).append(" AND q.std_id=ts.std_id AND ts.taxonomy_id=ct.taxonomy_id");
        
        return query.toString();
	}

	public static String getApplicableBrandsByStdId(long deptId, long stdId, long regionId){
    	StringBuffer query = new StringBuffer();
    	
    	query.append("		SELECT p.chain_cd, q.qlty_lead_rpt_id, q.std_id, q.gem_catgy_id, ");
    	query.append(" 				(SELECT gem_catgy_nm FROM gem_catgy WHERE gem_catgy_id = q.gem_catgy_id) gem_catgy_nm, ");
    	query.append("				q.gem_mgt_bucket_id, ");
    	query.append("				(SELECT gem_bucket_nm FROM gem_mgt_bucket WHERE gem_mgt_bucket_id = q.gem_mgt_bucket_id) gem_bucket_nm,	");
    	query.append("				q.gem_severity_id, ");
    	query.append("				(SELECT gem_severity_nm FROM gem_severity WHERE gem_severity_id = q.gem_severity_id) gem_severity_nm ");
    	query.append(" 			FROM qlty_lead_rpt q, publish p WHERE q.publish_id IN ( ");
    	query.append(" 				SELECT p.PUBLISH_ID FROM PUBLISH p, GEM_PUBLISH_DEPT gpd, GEM_DEPT gd, GEM_TEMPLATE gt ");
    	query.append(" 				 	WHERE p.publish_id=gpd.publish_id AND gpd.gem_dept_id=gd.gem_dept_id  ");
    	query.append(" 				 		AND p.PUBLISH_STAT_CD='ACTIVE' AND p.PUBLISH_ENVIRONMENT_NM='GEM_CMS' AND gd.actv_ind='Y'   ");
    	query.append(" 				 		AND gd.gem_dept_id = ").append(deptId);
    	query.append("                      AND gt.publish_id = p.publish_id AND gt.TEMPLATE_TYP_CD='SE' AND gt.rgn_id = ").append(regionId);
    	query.append(" 				) AND q.publish_id=p.publish_id AND q.std_id = ").append(stdId);
    	query.append("				  AND q.rgn_id = ").append(regionId);
    	query.append("				 AND q.duplicate_ind='N'");
    	
    	return query.toString();
    }   
	
	public static String getGemQLDuplicatesRecordsQuery(long bridgePublishId, long gemPublishId, long regionId, String brandCd, String stdIdLst) {
		
		StringBuilder query = new StringBuilder("WITH PRNT_QLTY_IDS AS (SELECT DISTINCT prnt_qlty_lead_rpt_id from qlty_lead_rpt WHERE");
        query.append(" prnt_qlty_lead_rpt_id IS NOT NULL AND prnt_qlty_lead_rpt_id != QLTY_LEAD_RPT_ID AND publish_id =").append(gemPublishId);
        query.append(" AND rgn_id = ").append(regionId).append("),");        
        
        query.append(" PRNT_QLTY_STD_IDS AS (SELECT DISTINCT q.std_id FROM qlty_lead_rpt q, PRNT_QLTY_IDS pid WHERE q.qlty_lead_rpt_id = pid.prnt_qlty_lead_rpt_id),");        
        
        query.append(" ALL_STD AS (SELECT s.std_id,s.prnt_std_id, s.std_typ, s.std_desc,s.title_txt ,s.rgn_cd,s.gbl_rgn_ind,s.framework_std_ind");
        query.append(" from std s,PRNT_QLTY_STD_IDS psid where   s.stat_desc != 'DELETED'");
        query.append(" AND s.prnt_std_id =psid.std_id)");
        
        query.append(" SELECT q.std_id, s.prnt_std_id, s.std_typ, decode(s.std_typ, 'GDLN', s.std_desc, s.title_txt)");
        query.append(" title_txt,s.rgn_cd,decode(s.rgn_cd, 'GLBL', decode(s.gbl_rgn_ind, 'G',decode(s.framework_std_ind, 'Y', 'Global'),");
        query.append(" decode(s.framework_std_ind, 'Y', 'Global')),  s.rgn_cd) glbl_or_rgn,q.qlty_lead_rpt_id, q.publish_id ,q.prnt_qlty_lead_rpt_id,q.duplicate_ind ,st.stat_cd, st.stat_title_txt,");
        query.append(" nvl((SELECT decode(count(*), 0, 0, 1) FROM bridge_publish   WHERE publish_id = ").append(bridgePublishId);
        query.append(" AND std_id = s.std_id   AND rgn_id = ").append(regionId).append("  ), 0) in_publication,q.gbl_must_measure_std_ind,");
        query.append(" nvl(q.gem_catgy_id, 0)gem_catgy_id,(SELECT gem_catgy_nm FROM gem_catgy WHERE gem_catgy_id = q.gem_catgy_id) gem_catgy_nm,");
        query.append(" nvl(q.gem_severity_id, 0) gem_severity_id,(SELECT gem_severity_nm FROM gem_severity WHERE gem_severity_id = q.gem_severity_id) gem_severity_nm,");
        query.append(" nvl(q.gem_mgt_bucket_id, 0) gem_mgt_bucket_id, (SELECT gem_bucket_nm FROM gem_mgt_bucket WHERE gem_mgt_bucket_id = q.gem_mgt_bucket_id) gem_bucket_nm,");
        query.append(" (SELECT gem_bucket_nm FROM gem_mgt_bucket WHERE gem_mgt_bucket_id = q.gem_mgt_bucket_id) gem_bucket_nm,");
        query.append(" (SELECT LISTAGG(fs.flag_catgy_Id, ', ') WITHIN GROUP (ORDER BY fs.STD_ID) FROM FLAG_STD fs,");
        query.append(" (SELECT flag_catgy_id FROM flag_catgy WHERE flag_catgy_id IN (258, 257) AND actv_ind='Y' ORDER BY disp_order_nbr) sf WHERE fs.STD_ID=q.STD_ID AND fs.flag_catgy_id=sf.flag_catgy_id GROUP BY fs.STD_ID) mnlType,");
        query.append(" (SELECT disp_order_nbr FROM gem_catgy WHERE gem_catgy_id = nvl(q.gem_catgy_id, 0)) catgy_disp_order,");
        query.append(" CASE WHEN s.STD_TYP = 'STD' THEN CASE WHEN NVL(q.disp_order_nbr, 0) <= 0 THEN 1000 ELSE NVL(q.disp_order_nbr, 0) END ELSE NVL(q.disp_order_nbr, 0) END seq_disp_order");
        
        query.append(" FROM qlty_lead_rpt q, ALL_STD s, STAT st, chain_std cs WHERE publish_id = ").append(gemPublishId);
        query.append(" AND q.std_id = s.std_id ").append(" AND q.rgn_id =").append(regionId);
        query.append(" AND s.std_id = cs.std_id AND cs.stat_id = st.stat_id AND cs.chain_cd ='").append(brandCd).append("'");
        query.append(" AND st.stat_cd NOT IN('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')"); 
      
        if (stdIdLst != null && !stdIdLst.isEmpty()){
        	query.append(" AND q.std_id IN (Select std_id from std where prnt_std_id IN (").append(stdIdLst).append(")");
        	query.append(" OR prnt_std_id IN( Select prnt_std_id from std where std_id IN (").append(stdIdLst).append(")))");
        }
        query .append(" ORDER BY STD_ID DESC, DUPLICATE_IND");
        return query.toString(); 
	}

}
