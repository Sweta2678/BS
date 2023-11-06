package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.custom.model.CountryList;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.impl.BridgePublishPreviewImpl;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgePublishPreviewFinderImpl extends BasePersistenceImpl<BridgePublishPreview> implements BridgePublishPreviewFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishPreviewFinderImpl.class);
    
    
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    public List<BridgePublishPreview> getBridgePublishPreview(String chainCd, long regionCd) throws SystemException {
        return null;//getBridgePublishPreview(chainCd, regionCd, null, null, null, null, null);
    }

  
    
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    @SuppressWarnings("unchecked")
    public List<BridgePublishPreview> getBridgePublishPreview(String groupName, String chainCd, long regionId, String filterIds, String searchIds, String selByState, 
			String locale, long bridgePublishId, String groupType) {
       
    	List<BridgePublishPreview> statusExs = new LinkedList<BridgePublishPreview>();
    	String region = StringPool.BLANK; 
    	//Get region code from region table
    	StandardsRegion stdRegion = null;
    	try {
    		stdRegion = StandardsRegionLocalServiceUtil.getStandardsRegion(regionId);
			region = stdRegion.getRegionCode();
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
        
        if(filterIds!=null && !"".equals(filterIds.trim()))
        {
            filterIds = filterIds.replace(" ", ", ");
        }
        StringBuilder selectClause = new StringBuilder();
        StringBuilder fromClause = new StringBuilder();
        StringBuilder whereClause = new StringBuilder();
        StringBuilder countryClause = new StringBuilder(" SELECT ctry_nm_cd from UNIQUE_CTRY ");
        
        //Taxonomy
        selectClause.append(" WITH TAX AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH ");
        selectClause.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, ");
        selectClause.append(" T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' &#062; '), 29) AS PATH ");
        selectClause.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ) TAX), ");
        //Active Bridge Publication
        selectClause.append("CURR_BRIDGE  AS ( SELECT PUBLISH_ID, PUBLISH_DT, CHAIN_CD FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' AND PUBLISH_STAT_CD = 'ACTIVE' AND CHAIN_CD = '");
        selectClause.append(chainCd);
        selectClause.append("'), ");
        //Active Production Publication
        selectClause.append("CURR_PROD  AS ( SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'PRODUCTION' AND PUBLISH_STAT_CD = 'ACTIVE' AND CHAIN_CD = '");
        selectClause.append(chainCd);
        selectClause.append("' ), ");
        //Get Group and countries
        selectClause.append(" BRIDGE_UNIQUE_GROUP AS ( SELECT unique_grp_id from unique_grp where GRP_NM = '");
        selectClause.append(groupName);
        selectClause.append("' AND publish_id in (select publish_id from curr_bridge) AND rgn_id = ");
        selectClause.append(regionId);
        selectClause.append( " AND UNIQUE_GRP_TYP_CD = '");
        selectClause.append(groupType);
        selectClause.append("' ), ");
        //countries
        selectClause.append(" UNIQUE_CTRY AS (SELECT distinct CTRY_NM_CD FROM unique_grp_ctry ");
        selectClause.append(" where unique_grp_id in (select unique_grp_id from BRIDGE_UNIQUE_GROUP) ), ");
        //standard ids
        selectClause.append(" STD_VAL AS (SELECT STD_ID FROM unique_grp_std where UNIQUE_GRP_ID in ");
        selectClause.append(" (select UNIQUE_GRP_ID from BRIDGE_UNIQUE_GROUP)), ");
        // Status
        selectClause.append(" XREF_STAT AS ( SELECT stat_id, stat_cd from stat where stat_cd in ");
        selectClause.append(" ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD', 'INST_RQ')), ");
        
        
        if (Validator.isNull(selByState)) {
        
	        selectClause.append(" CMS_STD AS (SELECT a.STD_ID, a.PRNT_STD_ID,");
	        selectClause.append(" (SELECT sd.disp_order_nbr FROM std_display_order sd ");
	        selectClause.append(" WHERE sd.chain_cd = '");
	        selectClause.append(chainCd);
	        selectClause.append("' AND sd.rgn_cd = '");
	        selectClause.append(region);
	        selectClause.append("' AND sd.std_id = a.std_id) AS disp_order_nbr, ");
	        selectClause.append(" CASE WHEN a.STD_TYP = 'GDLN' THEN a.STD_DESC ELSE a.TITLE_TXT END TITLE_TXT, ");
	        selectClause.append(" a.std_typ FROM STD a, STD_VAL c ");
	        selectClause.append(" WHERE  a.std_id = c.std_id ");
	        if(searchIds!=null && !"".equals(searchIds.trim()))
	        {
	        	searchIds = searchIds.replace(" ", ", ");
	        	selectClause.append(" AND a.prnt_std_id in (SELECT prnt_std_id from std where std_id in ( ");
	        	selectClause.append(searchIds);
	        	selectClause.append(" ))), ");
	        } else {
	        	selectClause.append(" ), ");
	        }
	        
	        //Display Order
	       /* selectClause.append(" DISPLAY_ORDER AS (select std_id, COALESCE(disp_order_nbr,0) as disp_order_nbr from std_display_order where chain_cd = '");
	        selectClause.append(chainCd);
	        selectClause.append("' AND rgn_cd = '");
	        selectClause.append(region);
	        selectClause.append("' AND std_id in (select std_id from CMS_STD)),  ");*/
	        
	        
	        //Mandatory Images
	        selectClause.append(" CUR_IMG_CNT AS (SELECT unique SI.STD_ID, SI.std_image_id from ");
	        selectClause.append(" CMS_STD S, STD_IMAGE SI, STD_IMAGE_CHAIN SIC ");
	        selectClause.append(", std_image_ctry sctry WHERE SI.STD_ID = S.STD_ID AND ");
	        selectClause.append(" SI.STD_IMAGE_ID = SIC.STD_IMAGE_ID and SI.STD_IMAGE_ID = sctry.std_image_id and SIC.CHAIN_CD = '");
	        selectClause.append(chainCd);
	        selectClause.append("' AND sctry.ctry_nm_cd in (");
	        
	        selectClause.append(countryClause);
	        selectClause.append(") and si.locale_cd = '");
	        selectClause.append(locale);
	        selectClause.append("'), ");
	        //Attachment
	        selectClause.append(" CUR_ATTCH_CNT AS (SELECT unique SI.STD_ID, SI.STD_ATTACHEMENT_ID ");
	        selectClause.append(" from CMS_STD S, STD_ATTACHMENT SI, STD_ATTACHMENT_CHAIN SIC ");
	        selectClause.append(", std_attachment_ctry sctry WHERE SI.STD_ID = S.STD_ID AND ");
	        selectClause.append(" SI.STD_ATTACHEMENT_ID = SIC.STD_ATTACHEMENT_ID and SI.STD_ATTACHEMENT_ID = sctry.STD_ATTACHEMENT_ID and SIC.CHAIN_CD = '");
	        selectClause.append(chainCd);
	        selectClause.append("' AND sctry.ctry_nm_cd in (");
	        selectClause.append(countryClause);
	        selectClause.append(") and si.locale_cd = '");
	        selectClause.append(locale);
	        selectClause.append("'), ");
	        //Links
	        selectClause.append(" CUR_LINK_CNT AS (SELECT unique SI.STD_ID, SI.std_extl_link_id ");
	        selectClause.append(" from CMS_STD S, std_extl_link SI, std_extl_link_chain SIC ");
	        selectClause.append(", std_link_ctry sctry WHERE SI.STD_ID = S.STD_ID AND ");
	        selectClause.append(" SI.std_extl_link_id = SIC.std_extl_link_id and SI.std_extl_link_id = sctry.std_extl_link_id and SIC.CHAIN_CD = '");
	        selectClause.append(chainCd);
	        selectClause.append("' AND sctry.ctry_nm_cd in (");
	        selectClause.append(countryClause);
	        selectClause.append(") and si.locale_cd = '");
	        selectClause.append(locale);
	        selectClause.append("'), ");
	        //Hotel Lifecycle Attributes 
	        selectClause.append(" HOTEL_ATTR AS (Select std_id,  listagg(flag_catgy_id, ',') within GROUP (ORDER BY std_id) AS attr from ");
	        selectClause.append(" flag_std where  std_id in (select std_id from CMS_STD) and flag_catgy_id in ");
	        selectClause.append("(select flag_catgy_id from flag_catgy where prnt_flag_catgy_id = 91 and actv_ind = 'Y') group by std_id), ");
	        //Cross References
	        selectClause.append(" STD_REF AS (select sx.referring_std_id, listagg(sx.referenced_std_id, ',') ");
	        selectClause.append(" within GROUP (ORDER BY sx.referenced_std_id) AS stdReference FROM STD_XREF SX ");
	        selectClause.append(" , chain_std cs WHERE ");
	        selectClause.append(" sx.referring_std_id in (select std_id from CMS_STD) AND referenced_std_id in ");
	        selectClause.append(" (select std_id from CMS_STD MINUS SELECT std_id  FROM std  WHERE std_id = referenced_std_id AND stat_desc = 'DELETED') ");
	        selectClause.append(" AND cs.chain_cd = '");
	        selectClause.append(chainCd);
	        selectClause.append("' AND cs.std_id = sx.referenced_std_id ");
	        selectClause.append(" AND cs.stat_id not in (select stat_id from XREF_STAT) ");
	        selectClause.append(" group by sx.referring_std_id), ");
	        //Standard Compliance
	        
	    	selectClause.append(" NEW_STD_RULE_EXPRY AS ( ");
	    	selectClause.append("SELECT DISTINCT sc.std_id,  "); 
	    	selectClause.append(" CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
	    	selectClause.append("  CASE WHEN sc.rule_dt_cd = 'R' THEN ");
	    	selectClause.append(" CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
	    	selectClause.append(" sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(p.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') ");
	    	selectClause.append(" END ");
	    	selectClause.append(" WHEN sc.cmply_expr_dt > p.publish_dt THEN ");
	    	selectClause.append(" 'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
	    	selectClause.append(" END ");
	    	selectClause.append(" WHEN sc.cmply_expr_rule_cd = 'E' THEN ");
	    	selectClause.append(" CASE WHEN sc.cmply_expr_dt > p.publish_dt THEN ");
	    	selectClause.append(" 'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
	    	selectClause.append(" END END cmply_expr_date FROM std_cmply sc, CURR_BRIDGE p WHERE sc.chain_cd = p.chain_cd ");
	    	selectClause.append(" AND sc.std_id in (select std_id from CMS_STD) ");
	    	selectClause.append(" AND sc.ctry_nm_cd NOT IN (SELECT ctry_nm_cd FROM std_ctry_chain ");
	    	selectClause.append(" WHERE chain_cd = '");
	    	selectClause.append(chainCd);
	    	selectClause.append("' AND std_id = sc.std_id ");
	    	selectClause.append(" )  AND sc.ctry_nm_cd IN ( ");
	    	selectClause.append(countryClause);
	    	selectClause.append(" )), ");
	    	selectClause.append(" PUB_STD_CMPLY_EXPRY AS (SELECT DISTINCT sc.std_id, ");
	    	selectClause.append("  CASE WHEN sc.cmply_dt IS NOT NULL THEN CASE WHEN sc.cmply_dt > SYSDATE THEN ");
	    	selectClause.append(" to_char(sc.cmply_dt, 'DD Mon YYYY') END WHEN sc.expr_dt IS NOT NULL THEN ");
	    	selectClause.append(" CASE WHEN sc.expr_dt > SYSDATE THEN 'Expires | ' || to_char(sc.expr_dt, 'DD Mon YYYY') ");
	    	selectClause.append(" END  END cmply_expr_date ");
	    	selectClause.append(" FROM std_ctry_chain sc, CMS_STD cs WHERE sc.std_id = cs.std_id ");
	    	selectClause.append("  AND sc.chain_cd = '");
	    	selectClause.append(chainCd);
	    	selectClause.append("' AND sc.ctry_nm_cd in  ( ");
	    	selectClause.append(countryClause);
	    	selectClause.append(" )), STD_TOTAL AS (SELECT * FROM NEW_STD_RULE_EXPRY   UNION ALL SELECT * FROM PUB_STD_CMPLY_EXPRY) ");
	       
	        //OBSM Title Difference
	        selectClause.append(", SELECTED_STD AS (SELECT PS.STD_ID, PS.PRNT_STD_ID, PS.DISP_ORDER_NBR, ");
	        selectClause.append(" CASE WHEN PS.STD_TYP = 'GDLN' THEN PS.STD_DESC ELSE ");
	        selectClause.append(" PS.TITLE_TXT END TITLE_TXT FROM CURR_PROD CP, PUBLISH_STD PS, CMS_STD CS ");
	        selectClause.append(" WHERE CP.PUBLISH_ID = PS.PUBLISH_ID AND PS.STD_ID = CS.STD_ID AND PS.RGN_CD IN ('GLBL', '");
	        selectClause.append(region);
	        selectClause.append("') )");
        } else {
        	generateFilterByQuery(selectClause, selByState, chainCd, countryClause, locale, regionId, region, searchIds);
        }
        
        //Image count
        selectClause.append(", IMG_CNT AS (SELECT SI.STD_ID, 1 AS imageCount FROM ");
        selectClause.append(" CUR_IMG_CNT SI GROUP BY SI.STD_ID), ");
       
        //Attachment count
        selectClause.append(" ATTCH_CNT AS (SELECT SI.STD_ID, 1 AS attchCount from CUR_ATTCH_CNT SI ");
        selectClause.append(" GROUP BY SI.STD_ID), ");
        
        //Links count
        selectClause.append(" LINK_CNT AS (SELECT SI.STD_ID, 1 AS linkCount from CUR_LINK_CNT SI ");
        selectClause.append(" GROUP BY SI.STD_ID) ");
        
        selectClause.append("(SELECT TAX.TITLE_TXT AS TAX_TITLE_TXT, TAX.PATH, TAX.INDX_ORDER, TAX.TAXONOMY_ID,");
        selectClause.append(" TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, cs.PRNT_STD_ID, cs.STD_ID, cs.TITLE_TXT AS TITLE,");
        selectClause.append(" NVL(cs.DISP_ORDER_NBR,0) DISP_ORDER_NBR, cs.STD_TYP, ss.TITLE_TXT AS CURR_TITLE, HA.attr,");
        
        // selectClause.append(" , CASE WHEN ss.TITLE_TXT IS NULL THEN 'NEW' WHEN ss.TITLE_TXT != cs.TITLE_TXT THEN 'UPDATE' ELSE 'NO_CHANGE' END  STATUS ");
        // instead of above calculation of status we can directly get it from BRIDGE_PUBLISH_CTRY table. changes part of Edit State - State Scenarios
        selectClause.append(" NVL( (SELECT CASE WHEN BPC.BRIDGE_PUBLISH_STAT_CD='SELECT' THEN '' ELSE");
        selectClause.append(" BPC.BRIDGE_PUBLISH_STAT_CD END AS STATUS FROM BRIDGE_PUBLISH BP,BRIDGE_PUBLISH_CTRY BPC, CURR_BRIDGE CB"); 
        selectClause.append(" WHERE BPC.BRIDGE_PUBLISH_ID = BP.BRIDGE_PUBLISH_ID AND BPC.CTRY_NM_CD IN (" +countryClause+ ") AND BP.STD_ID=CS.STD_ID AND BP.RGN_ID = " +regionId + " AND BP.PUBLISH_ID=CB.PUBLISH_ID "); 
        selectClause.append(" GROUP BY BP.STD_ID, BPC.BRIDGE_PUBLISH_STAT_CD),'') AS STATUS ");	
    	selectClause.append(" , NVL(IC.imageCount,0) IMG_ATCH,  NVL(AC.attchCount,0) STD_ATCH ");
    	selectClause.append(" , sr.stdReference ");
    	selectClause.append(", sc.cmply_expr_date, NVL(lc.linkCount, 0) linkCount ");

    	if(!BrandStandardsUtil.IsNullOrBlank(selByState) && ("NEW".equals(selByState) || "UPDATE".equals(selByState))) {
    		fromClause.append(" FROM TAX, CMS_STD cs, SELECTED_STD ss, TAXONOMY_STD TS, HOTEL_ATTR HA, IMG_CNT IC, ATTCH_CNT AC, STD_REF SR, STD_TOTAL SC, LINK_CNT LC ");
    	} else {
    		fromClause.append(" FROM TAX, CMS_STD cs, SELECTED_STD ss, TAXONOMY_STD TS, HOTEL_ATTR HA, IMG_CNT IC, ATTCH_CNT AC, STD_REF SR, STD_TOTAL SC, LINK_CNT LC ");
    	}
        whereClause.append(" WHERE TS.TAXONOMY_ID = TAX.TAXONOMY_ID ");
        whereClause.append(" AND TS.STD_ID = cs.PRNT_STD_ID AND cs.STD_ID  = ss.STD_ID (+) ");
        //whereClause.append(" AND cs.STD_ID = do.STD_ID (+) ");
        
        // Status filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "NEW".equals(selByState)) { 
        	//whereClause.append(" AND ss.TITLE_TXT IS NULL ");
        } else if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "UPDATE".equals(selByState)) { 
        	//whereClause.append(" AND cs.TITLE_TXT!= ss.TITLE_TXT ");
        }
        // Images filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "IMAGES".equals(selByState)) {
        	whereClause.append(" AND cs.STD_ID = IC.STD_ID (+) ");
        } else {
        	whereClause.append(" AND cs.STD_ID = IC.STD_ID (+) ");
        }
        // Attachments filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "ATTACHMENTS".equals(selByState)) {
        	whereClause.append(" AND cs.STD_ID = AC.STD_ID (+) ");
        } else {
        	whereClause.append(" AND cs.STD_ID = AC.STD_Id (+) ");
        }
        // Links filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "LINKS".equals(selByState)) {
        	whereClause.append(" AND cs.STD_ID  = LC.STD_ID (+)  ");
        } else {
        	whereClause.append(" AND cs.STD_ID  = LC.STD_ID (+) ");
        }
        // Reference filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState)) {
        	whereClause.append(" AND cs.STD_ID = SR.STD_ID (+) ");
        } else {
        	whereClause.append(" AND cs.STD_ID = SR.referring_std_id (+) ");
        }
        // Hotel Lifecycle filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "HOTEL_LIFECYCLE".equals(selByState)) {
        	whereClause.append(" AND cs.STD_ID = HA.STD_ID (+) ");	
        } else {
        	whereClause.append(" AND cs.STD_ID = HA.STD_ID (+) ");
        }
        // Future Compliance filter by
        if(!BrandStandardsUtil.IsNullOrBlank(selByState) && "COMPLIANCE".equals(selByState)) {
        	whereClause.append(" AND cs.STD_ID = SC.STD_ID (+)  ");
        } else {
        	whereClause.append(" AND cs.STD_ID = SC.STD_ID (+) ");
        }

        StringBuilder queryString = selectClause.append(fromClause).append(whereClause); 
        queryString.append(")");
        
        if (LOG.isDebugEnabled()) {
        	LOG.debug("query string is ::::"+ queryString.toString());
        }
        
        Session session = null;
        try {
        	session = openSession();
	        SQLQuery query = session.createSQLQuery(queryString.toString());
	        if (LOG.isDebugEnabled()) {
	        	LOG.debug("before query execution :"+ new Date());
	        }
	        List results = query.list();
	        if (LOG.isDebugEnabled()) {
	        	LOG.debug("after query execution :"+ new Date());
	        }
	        BridgePublishPreview bridgePreview = null;
	        if (Validator.isNotNull(results) && results.size() > 0) {
	        for (int i=0; i < results.size(); i++) {
	        	Object[] obj = (Object[]) results.get(i);
	        	bridgePreview = new BridgePublishPreviewImpl();
	        	bridgePreview.setTaxonomyTitle((String) obj[0]);
	        	bridgePreview.setPath((String) obj[1]);
	        	bridgePreview.setIndexOrder(((BigDecimal) obj[2]).longValue());
	        	bridgePreview.setTaxonomyId(((BigDecimal) obj[3]).longValue());
	        	bridgePreview.setParentTaxonomyId(((BigDecimal) obj[4]).longValue());
	        	bridgePreview.setLevel(((BigDecimal) obj[5]).longValue());
	        	bridgePreview.setIndexOrder(((BigDecimal) obj[6]).longValue());
	        	bridgePreview.setParentStdId(((BigDecimal) obj[7]).longValue());
	        	bridgePreview.setStdId(((BigDecimal) obj[8]).longValue());
	        	bridgePreview.setTitle((String) obj[9]);	
	        	bridgePreview.setDisplayOrder(((BigDecimal) obj[10]).longValue());
	        	bridgePreview.setType((String) obj[11]);
	        	bridgePreview.setCurrentTitle((String) obj[12]);
	        	bridgePreview.setHotelAttributes((String) obj[13]);
	        	bridgePreview.setStatus((String) obj[14]);
	        	bridgePreview.setImageCount(((BigDecimal) obj[15]).longValue());
	        	bridgePreview.setAttachmentCount(((BigDecimal) obj[16]).longValue() + ((BigDecimal) obj[19]).longValue());//last
	        	bridgePreview.setStdReference((String) obj[17]);
	        	bridgePreview.setComplianceDate((String) obj[18]);
	        	
	        	statusExs.add(bridgePreview);
	        } 
	        }
	        if (LOG.isDebugEnabled()) {
	        	LOG.debug("after result generated :"+ new Date());
	        }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
        	if (session != null) {
        		closeSession(session);
        	}
            
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Connection closed :"+new Date());
        }
        return statusExs;
    }
    
    public List<BridgePublishPreview> getStandardsById(String stdIds, String brand, boolean isMust) throws SystemException
    {
        List<BridgePublishPreview> ls = new ArrayList<BridgePublishPreview>();
    	Session session = null;
    	
    	StringBuilder query = new StringBuilder();
    	query.append("SELECT * FROM ( WITH ");
    	query.append("TAXONOMI AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH ");
    	query.append("FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' &#062; '), 29) AS PATH "); 
    	query.append("FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ) TAX), ");
    			                    
    	query.append("STD_LST AS (SELECT S1.STD_ID, S1.PRNT_STD_ID, CASE WHEN S1.TITLE_TXT='GDLN' THEN S1.STD_DESC WHEN S1.TITLE_TXT!='GDLN' THEN S1.TITLE_TXT END AS TITLE, S1.STD_TYP,");
    	query.append(" NVL((SELECT BGP.PUBLISH_ID FROM BRIDGE_GBL_PUBLISH BGP, PUBLISH P WHERE P.PUBLISH_ENVIRONMENT_NM = 'BRIDGE' AND BGP.MUST_PUBLISH_IND='");
    	query.append(isMust ? "Y" : "N");
    	query.append("' AND BGP.PUBLISH_ID = P.PUBLISH_ID AND P.PUBLISH_STAT_CD = 'ACTIVE' AND P.CHAIN_CD = '");
    	query.append(brand);
    	query.append("' AND  S1.STD_ID = BGP.STD_ID), -1) AS CURR_TITLE, S1.DISP_ORDER_NBR ");
    	query.append("FROM  STD S, CHAIN_STD CS, STD S1 ");
    	query.append("WHERE S.STAT_DESC!='DELETED' AND CS.ACTV_IND='Y' AND CS.STD_ID=S1.STD_ID AND CS.CHAIN_CD='");
    	query.append(brand);
    	query.append("' "); 
    	query.append("AND ((S.STD_TYP!='STD' AND (S1.STD_ID=S.PRNT_STD_ID OR S1.STD_ID=S.STD_ID)) OR (S.STD_TYP='STD' AND (S1.PRNT_STD_ID=S.STD_ID) )) AND  S.STD_ID IN (");
    	query.append(stdIds);
    	query.append(") AND S1.RGN_CD = 'GLBL') ");
    			         
    	query.append("SELECT SL.*, T.PATH, T.TITLE_TXT AS TAX_TITLE_TXT, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.INDX_ORDER, T.LVL, T.HIER_LVL_NBR, 'N/A' AS STATUS, 0 AS IMG_ATCH, 0 AS STD_ATCH, 0 AS STD_XREF, 0 AS HTL_LFCCL, 0 AS STD_CMPLY, '' AS HTL_ATTR, '' AS STD_CMPLY_DATE, '' AS STD_REFERENCE from TAXONOMI T, ");
    	query.append(" TAXONOMY_STD TS, STD_LST SL WHERE T.TAXONOMY_ID=TS.TAXONOMY_ID AND TS.STD_ID =SL.PRNT_STD_ID)");
        try
        {
            session = openSession();
            LOG.debug("Query Find By Id : " + query.toString());
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("BridgePublishPreview", BridgePublishPreviewImpl.class);
            q.setCacheable(false);
            ls = (List<BridgePublishPreview>) q.list();
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
        return ls;
    }
    
    /**
     * 
     * @param query
     * @return List<CountryList>
     */
    public List<CountryList> getGroupsByCountryStatus (String query) 
    {
        List<CountryList> countryLists = new ArrayList<CountryList>();
        Session session = null;
        try
        {
            session = openSession();
            LOG.debug("Query Find By Id : " + query.toString());
            SQLQuery q = session.createSQLQuery(query.toString());
            List results = q.list();
            if (results != null)
            {
                for (int i = 0; i < results.size(); i++)
                {
                    CountryList countryList = new CountryList();
                    Object[] obj = (Object[]) results.get(i);
                    countryList.setCountryList((String) obj[1]);
                    countryList.setStatus((String) obj[2]);
                    countryList.setComplianceDate((String) obj[3]);
                    countryList.setStdId(((BigDecimal) obj[0]).longValue());
                    countryLists.add(countryList);
                }
            }
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
    	return countryLists;
    }
    
    /**
     * 
     * @param query
     * @return String
     */
    private String generateFilterByQuery (StringBuilder selectClause, String filterBy, String chainCd, StringBuilder countryClause, 
    		String locale, long regionId, String regionCd, String searchIds) {
    	
    	if ("NEW".equals(filterBy) || "UPDATE".equals(filterBy)) {
    		
            //filter by status
            if ("NEW".equals(filterBy)) {
            	selectClause.append(" FILTER_STD AS (SELECT BP.STD_ID"); 
        		selectClause.append(" 	FROM BRIDGE_PUBLISH BP, BRIDGE_PUBLISH_CTRY BPC, CURR_BRIDGE CB, STD_VAL cs ");
        		selectClause.append(" 	WHERE BPC.BRIDGE_PUBLISH_ID = BP.BRIDGE_PUBLISH_ID"); 
        		selectClause.append(" 	AND BPC.BRIDGE_PUBLISH_STAT_CD='NEW' AND BPC.CTRY_NM_CD IN ( SELECT ctry_nm_cd from UNIQUE_CTRY)"); 
        		selectClause.append(" 	AND BP.STD_ID=CS.STD_ID AND BP.RGN_ID = ");
        		selectClause.append(regionId);
        		selectClause.append(" AND BP.PUBLISH_ID = CB.PUBLISH_ID ");
        		selectClause.append(" GROUP BY BP.STD_ID, BPC.BRIDGE_PUBLISH_STAT_CD), ");
        		
        		//Standards
        		getStandardDetailsQuery(selectClause, searchIds, "FILTER_STD", regionId, regionCd, chainCd);
        		
            } else if ("UPDATE".equals(filterBy)) {
            	selectClause.append(" FILTER_STD AS (SELECT BP.STD_ID"); 
        		selectClause.append(" 	FROM BRIDGE_PUBLISH BP, BRIDGE_PUBLISH_CTRY BPC, CURR_BRIDGE CB, STD_VAL cs ");
        		selectClause.append(" 	WHERE BPC.BRIDGE_PUBLISH_ID = BP.BRIDGE_PUBLISH_ID"); 
        		selectClause.append(" 	AND BPC.BRIDGE_PUBLISH_STAT_CD='UPDATE' AND BPC.CTRY_NM_CD IN ( SELECT ctry_nm_cd from UNIQUE_CTRY)"); 
        		selectClause.append(" 	AND BP.STD_ID = CS.STD_ID AND BP.RGN_ID = ");
        		selectClause.append(regionId);
        		selectClause.append(" AND BP.PUBLISH_ID = CB.PUBLISH_ID ");
        		selectClause.append(" GROUP BY BP.STD_ID, BPC.BRIDGE_PUBLISH_STAT_CD), ");
        		//Standards
        		getStandardDetailsQuery(selectClause, searchIds, "FILTER_STD", regionId, regionCd, chainCd);
            }
            
            //OBSM Title Difference
    		getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
    		selectClause.append(", ");
            //Mandatory Images
   			getImagesQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
   			selectClause.append(", ");
   			//Attachment
   			getAttachmentQuery(selectClause, chainCd, countryClause, "CMS_STD", locale);
   			selectClause.append(", ");
   			
   			//External Links
   			getLinksQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
   			selectClause.append(", ");
   		
   			//Hotel Lifecycle Attributes 
   			getHotelLifeCycleAttributeQuery(selectClause, "CMS_STD");
            selectClause.append(", ");
           //Cross References
           getCrossReferenceQuery(selectClause, chainCd, "CMS_STD");
           selectClause.append(", ");
           //Standard Compliance
           getComplianceQuery(selectClause, chainCd, countryClause, "CMS_STD");
          
           
   	} else if ("IMAGES".equals(filterBy)) {
   			//Mandatory Images
   			getImagesQuery(selectClause, chainCd, "STD", countryClause, locale);
   			selectClause.append(", ");
   			
   			//Standards
   			getStandardDetailsQuery(selectClause, searchIds, "CUR_IMG_CNT", regionId, regionCd, chainCd);
    		
   			//Display Order
            /*getDisplayOrderQuery(selectClause, regionCd, chainCd, "CMS_STD");
            selectClause.append(", ");*/
            
            //Attachment
            getAttachmentQuery(selectClause, chainCd, countryClause, "CMS_STD", locale);
            selectClause.append(", ");
            //External Links
            getLinksQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
    		
    		//Hotel Lifecycle Attributes 
            getHotelLifeCycleAttributeQuery(selectClause, "CMS_STD");
            selectClause.append(", ");
            //Cross References
            getCrossReferenceQuery(selectClause, chainCd, "CMS_STD");
            selectClause.append(", ");
            //Standard Compliance
            getComplianceQuery(selectClause, chainCd, countryClause, "CMS_STD");
            selectClause.append(", ");
            //OBSM Title Difference
            getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
            
    	} else if ("LINKS".equals(filterBy)) {
    		
    		//External Links
            getLinksQuery(selectClause, chainCd, "STD", countryClause, locale);
            selectClause.append(", ");
            
            //Standards
            getStandardDetailsQuery(selectClause, searchIds, "CUR_LINK_CNT", regionId, regionCd, chainCd);
            
            //Display Order
            /*getDisplayOrderQuery(selectClause, regionCd, chainCd, "CMS_STD");
            selectClause.append(", ");*/
            
            //Mandatory Images
            getImagesQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
    		
            //Attachment
            getAttachmentQuery(selectClause, chainCd, countryClause, "CMS_STD", locale);
            selectClause.append(", ");
    		
    		//Hotel Lifecycle Attributes 
            getHotelLifeCycleAttributeQuery(selectClause, "CMS_STD");
            selectClause.append(", ");
            //Cross References
            getCrossReferenceQuery(selectClause, chainCd, "CMS_STD");
            selectClause.append(", ");
            //Standard Compliance
            getComplianceQuery(selectClause, chainCd, countryClause, "CMS_STD");
            selectClause.append(", ");
            //OBSM Title Difference
            getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
            
    	} else if ("HOTEL_LIFECYCLE".equals(filterBy)) {
    		
            
    		//Hotel Lifecycle Attributes 
    		getHotelLifeCycleAttributeQuery(selectClause, "STD_VAL");
            selectClause.append(", ");
            
    		//Standards
            getStandardDetailsQuery(selectClause, searchIds, "HOTEL_ATTR", regionId, regionCd, chainCd);
            
            //Display Order
            /*getDisplayOrderQuery(selectClause, regionCd, chainCd, "CMS_STD");
            selectClause.append(", ");*/
            
            //External Links
            getLinksQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
            //Mandatory Images
            getImagesQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
    		
            //Attachment
            getAttachmentQuery(selectClause, chainCd, countryClause, "CMS_STD", locale);
            selectClause.append(", ");
    		
            //Cross References
            getCrossReferenceQuery(selectClause, chainCd, "CMS_STD");
            selectClause.append(", ");
            //Standard Compliance
            getComplianceQuery(selectClause, chainCd, countryClause, "CMS_STD");
            selectClause.append(", ");
            //OBSM Title Difference
            getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
            
    	} else if ("COMPLIANCE".equals(filterBy)) {
    		
    		//Standard Compliance
            getComplianceQuery(selectClause, chainCd, countryClause, "STD_VAL");
            selectClause.append(", ");
    		//Standards
            getStandardDetailsQuery(selectClause, searchIds, "STD_TOTAL", regionId, regionCd, chainCd);
            //Display Order
            /*getDisplayOrderQuery(selectClause, regionCd, chainCd, "CMS_STD");
            selectClause.append(", ");*/
            //External Links
            getLinksQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
            //Mandatory Images
            getImagesQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
    		
    		///Attachment
            getAttachmentQuery(selectClause, chainCd, countryClause, "CMS_STD", locale);
            selectClause.append(", ");
    		
    		//Hotel Lifecycle Attributes 
            getHotelLifeCycleAttributeQuery(selectClause, "CMS_STD");
            selectClause.append(", ");
          //Cross References
            getCrossReferenceQuery(selectClause, chainCd, "CMS_STD");
            selectClause.append(", ");
            //OBSM Title Difference
            getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
            
    	} else if ("ATTACHMENTS".equals(filterBy)) {
    		
    		//Attachment
            getAttachmentQuery(selectClause, chainCd, countryClause, "STD", locale);
            selectClause.append(", ");
            
            //Standards
            getStandardDetailsQuery(selectClause, searchIds, "CUR_ATTCH_CNT", regionId, regionCd, chainCd);
            //Display Order
            /*getDisplayOrderQuery(selectClause, regionCd, chainCd, "CMS_STD");
            selectClause.append(", ");*/            
            //External Links
            getLinksQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
            //Mandatory Images
            getImagesQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
            
    		
    		//Hotel Lifecycle Attributes 
            getHotelLifeCycleAttributeQuery(selectClause, "CMS_STD");
            selectClause.append(", ");
            //Cross References
            getCrossReferenceQuery(selectClause, chainCd, "CMS_STD");
            selectClause.append(", ");
          //Standard Compliance
            getComplianceQuery(selectClause, chainCd, countryClause, "CMS_STD");
            selectClause.append(", ");
            //OBSM Title Difference
            getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
            
    	} else if ("REFERENCES".equals(filterBy)) {
    		
    		 //Cross References
    		selectClause.append(" BRIDGE_IDS AS (select std_id from bridge_publish where publish_id in ");
    		selectClause.append(" (select publish_id from ");
            selectClause.append(" CURR_BRIDGE) and rgn_id = ");
            selectClause.append(regionId);
            selectClause.append("  and unpublish_ind = 'N' AND std_id in ");
            selectClause.append(" ( select std_id from ");
            selectClause.append("STD_VAL");
            selectClause.append(" )), ");
    		getCrossReferenceQuery(selectClause, chainCd, "BRIDGE_IDS");
    		selectClause.append(", ");
            //Standards
            getStandardDetailsQuery(selectClause, searchIds, "STD_REF", regionId, regionCd, chainCd);
            //Display Order
            /*getDisplayOrderQuery(selectClause, regionCd, chainCd, "CMS_STD");
            selectClause.append(", ");*/
            //External Links
            getLinksQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
    		//Mandatory Images
            getImagesQuery(selectClause, chainCd, "CMS_STD", countryClause, locale);
            selectClause.append(", ");
    		//Attachment
            getAttachmentQuery(selectClause, chainCd, countryClause, "CMS_STD", locale);
            selectClause.append(", ");
    		//Hotel Lifecycle Attributes 
            getHotelLifeCycleAttributeQuery(selectClause, "CMS_STD");
            selectClause.append(", ");
            //Standard Compliance
            getComplianceQuery(selectClause, chainCd, countryClause, "CMS_STD");
            selectClause.append(", ");
            //OBSM Title Difference
            getPublishStandardsQuery(selectClause, "CMS_STD", regionCd);
            
    	}
    	
    	return selectClause.toString();
    }
    /**
     * 
     * @param query
     * @param tableName
     * @return StringBuilder
     */
    private StringBuilder getCrossReferenceQuery (StringBuilder selectClause, String chainCd, String tableName) {
    	//Cross References
        selectClause.append(" STD_REF AS (select sx.referring_std_id as STD_ID, listagg(sx.referenced_std_id, ',') ");
        selectClause.append(" within GROUP (ORDER BY sx.referenced_std_id) AS stdReference FROM STD_XREF SX ");
        selectClause.append(" , chain_std cs WHERE ");
        selectClause.append(" sx.referring_std_id in (select std_id from ");
        selectClause.append(tableName);
        selectClause.append(" ) AND referenced_std_id in ");
        selectClause.append(" (select std_id from ");
        selectClause.append(tableName);
        selectClause.append( " MINUS SELECT std_id  FROM std  WHERE std_id = referenced_std_id AND stat_desc = 'DELETED') ");
        selectClause.append(" AND cs.chain_cd = '");
        selectClause.append(chainCd);
        selectClause.append("'  AND cs.std_id = sx.referenced_std_id ");
        selectClause.append(" AND cs.stat_id not in (select stat_id from XREF_STAT) ");
        selectClause.append(" group by sx.referring_std_id) ");
    	return selectClause;
    }
    
    /**
     * 
     * @param selectClause
     * @param chainCd
     * @param countryClause
     * @param tableName
     * @return StringBuilder
     */
    private StringBuilder getComplianceQuery (StringBuilder selectClause, String chainCd, StringBuilder countryClause,
    		String tableName) {
    	
    	//Find rules and comliance/expiry date per country
    	selectClause.append(" NEW_STD_RULE_EXPRY AS ( ");
    	selectClause.append("SELECT DISTINCT sc.std_id,  "); 
    	selectClause.append(" CASE WHEN sc.cmply_expr_rule_cd = 'C' THEN ");
    	selectClause.append("  CASE WHEN sc.rule_dt_cd = 'R' THEN ");
    	selectClause.append(" CASE WHEN sc.cmply_rule_mo_qty > 0 THEN ");
    	selectClause.append(" sc.cmply_rule_mo_qty || 'm | ' || to_char(add_months(p.publish_dt, sc.cmply_rule_mo_qty), 'DD Mon YYYY') ");
    	selectClause.append(" END ");
    	selectClause.append(" WHEN sc.cmply_expr_dt > p.publish_dt THEN ");
    	selectClause.append(" 'Exact | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
    	selectClause.append(" END ");
    	selectClause.append(" WHEN sc.cmply_expr_rule_cd = 'E' THEN ");
    	selectClause.append(" CASE WHEN sc.cmply_expr_dt > p.publish_dt THEN ");
    	selectClause.append(" 'Expires | ' || to_char(sc.cmply_expr_dt, 'DD Mon YYYY') ");
    	selectClause.append(" END END cmply_expr_date FROM std_cmply sc, CURR_BRIDGE p WHERE sc.chain_cd = p.chain_cd ");
    	selectClause.append(" AND sc.std_id in (select std_id from  ");
    	selectClause.append(tableName);
    	selectClause.append(" ) AND sc.ctry_nm_cd NOT IN (SELECT ctry_nm_cd FROM std_ctry_chain ");
    	selectClause.append(" WHERE chain_cd = '");
    	selectClause.append(chainCd);
    	selectClause.append("' AND std_id = sc.std_id ");
    	selectClause.append(" )  AND sc.ctry_nm_cd IN ( ");
    	selectClause.append(countryClause);
    	selectClause.append(" )), ");
    	
    	selectClause.append(" PUB_STD_CMPLY_EXPRY AS (SELECT distinct sc.std_id, ");
    	selectClause.append("  CASE WHEN sc.cmply_dt IS NOT NULL THEN CASE WHEN sc.cmply_dt > SYSDATE THEN ");
    	selectClause.append(" to_char(sc.cmply_dt, 'DD Mon YYYY') END WHEN sc.expr_dt IS NOT NULL THEN ");
    	selectClause.append(" CASE WHEN sc.expr_dt > SYSDATE THEN 'Expires | ' || to_char(sc.expr_dt, 'DD Mon YYYY') ");
    	selectClause.append(" END  END cmply_expr_date ");
    	selectClause.append(" FROM std_ctry_chain sc,   ");
    	selectClause.append(tableName);
    	selectClause.append(" cs WHERE sc.std_id = cs.std_id ");
    	selectClause.append(" AND sc.chain_cd = '");
    	selectClause.append(chainCd);
    	selectClause.append("' AND sc.ctry_nm_cd in  ( ");
    	selectClause.append(countryClause);
    	selectClause.append(" )), STD_TOTAL AS (SELECT * FROM NEW_STD_RULE_EXPRY WHERE cmply_expr_date IS NOT NULL  UNION ALL ");
    	selectClause.append(" SELECT * FROM PUB_STD_CMPLY_EXPRY WHERE cmply_expr_date IS NOT NULL ) ");
        return selectClause;
    }
    
    private StringBuilder getAttachmentQuery (StringBuilder selectClause, String chainCd, StringBuilder countryClause, 
    		String tableName, String locale) {
    	//Attachment
        selectClause.append(" CUR_ATTCH_CNT AS (SELECT unique SI.STD_ID, S.PRNT_STD_ID, SI.STD_ATTACHEMENT_ID from ");
        selectClause.append(tableName);
        selectClause.append(" S, STD_ATTACHMENT SI, STD_ATTACHMENT_CHAIN SIC ");
        selectClause.append(", std_attachment_ctry sctry WHERE SI.STD_ID = S.STD_ID AND ");
        selectClause.append(" SI.STD_ATTACHEMENT_ID = SIC.STD_ATTACHEMENT_ID and SI.STD_ATTACHEMENT_ID = sctry.STD_ATTACHEMENT_ID and SIC.CHAIN_CD = '");
        selectClause.append(chainCd);
        selectClause.append("' AND sctry.ctry_nm_cd in (");
        selectClause.append(countryClause);
        if ("STD".equals(tableName)) {
        	selectClause.append(") and S.STD_ID in (select STD_ID from STD_VAL) and si.locale_cd = '");
        } else {
        	selectClause.append(") and si.locale_cd = '");
        }
        selectClause.append(locale);
        selectClause.append("') ");
        return selectClause;
    }
    
    /**
     * 
     * @param selectClause
     * @param chainCd
     * @param tableName
     * @param countryClause
     * @param locale
     * @return StringBuilder
     */
    private StringBuilder getLinksQuery (StringBuilder selectClause, String chainCd, String tableName, StringBuilder 
    		countryClause, String locale) {
    	//Links
        selectClause.append(" CUR_LINK_CNT AS (SELECT unique SI.STD_ID, S.PRNT_STD_ID, SI.std_extl_link_id from ");
        selectClause.append(tableName);
        selectClause.append(" S, std_extl_link SI, std_extl_link_chain SIC ");
        selectClause.append(", std_link_ctry sctry WHERE SI.STD_ID = S.STD_ID AND ");
        selectClause.append(" SI.std_extl_link_id = SIC.std_extl_link_id and SI.std_extl_link_id = sctry.std_extl_link_id and SIC.CHAIN_CD = '");
        selectClause.append(chainCd);
        selectClause.append("' AND sctry.ctry_nm_cd in (");
        selectClause.append(countryClause);
        if ("STD".equals(tableName)) {
        	selectClause.append(") and S.STD_ID in (select STD_ID from STD_VAL) and si.locale_cd = '");
        } else {
        	selectClause.append(") and si.locale_cd = '");
        }
        selectClause.append(locale);
        selectClause.append("') ");
    	return selectClause;
    }
    
    /**
     * 
     * @param selectClause
     * @param chainCd
     * @param tableName
     * @param countryClause
     * @param locale
     * @return StringBuilder
     */
    private StringBuilder getImagesQuery (StringBuilder selectClause, String chainCd, String tableName, StringBuilder 
    		countryClause, String locale) {
    	//Mandatory Images
        selectClause.append(" CUR_IMG_CNT AS (SELECT unique SI.STD_ID, S.PRNT_STD_ID, SI.std_image_id from ");
        selectClause.append(tableName);
        selectClause.append(" S, STD_IMAGE SI, STD_IMAGE_CHAIN SIC ");
        selectClause.append(", std_image_ctry sctry WHERE SI.STD_ID = S.STD_ID AND ");
        selectClause.append(" SI.STD_IMAGE_ID = SIC.STD_IMAGE_ID and SI.STD_IMAGE_ID = sctry.std_image_id and SIC.CHAIN_CD = '");
        selectClause.append(chainCd);
        selectClause.append("' AND S.STD_ID in (select STD_ID from STD_VAL) AND sctry.ctry_nm_cd in (");
        
        selectClause.append(countryClause);
        if ("STD".equals(tableName)) {
        	selectClause.append(") and S.STD_ID in (select STD_ID from STD_VAL) and si.locale_cd = '");
        } else {
        	selectClause.append(") and si.locale_cd = '");
        }
        selectClause.append(locale);
        selectClause.append("') ");
        return selectClause;
    }
    
    /**
     * @param selectClause
     * @param tableName
     * @return StringBuilder
     */
    private StringBuilder getHotelLifeCycleAttributeQuery (StringBuilder selectClause, String tableName) {
    	//Hotel Lifecycle Attributes 
    	selectClause.append(" HOTEL_ATTR AS (Select std_id,  listagg(flag_catgy_id, ',') within GROUP ");
    	selectClause.append(" (ORDER BY std_id) AS attr from ");
    	selectClause.append(" flag_std where  std_id in (select std_id from ");
    	selectClause.append(tableName);
    	selectClause.append(" ) and flag_catgy_id in ");
    	selectClause.append("(select flag_catgy_id from flag_catgy where prnt_flag_catgy_id = 91 ");
    	selectClause.append(" and actv_ind = 'Y') group by std_id) ");
    	return selectClause;
    }
    
    /**
     * 
     * @param selectClause
     * @param searchIds
     * @param tableName
     * @param regionId
     * @return StringBuilder
     */
    private StringBuilder getStandardDetailsQuery (StringBuilder selectClause, String searchIds, String tableName, 
    		long regionId, String regionCd, String chainCd) {
    	//Standards
    	selectClause.append(" ALL_STD AS (SELECT a.STD_ID, a.PRNT_STD_ID,");
        selectClause.append(" (SELECT sd.disp_order_nbr FROM std_display_order sd ");
        selectClause.append(" WHERE sd.chain_cd = '");
        selectClause.append(chainCd);
        selectClause.append("' AND sd.rgn_cd = '");
        selectClause.append(regionCd);
        selectClause.append("' AND sd.std_id = a.std_id) AS disp_order_nbr, ");
        selectClause.append(" CASE WHEN a.STD_TYP = 'GDLN' THEN a.STD_DESC ELSE a.TITLE_TXT END TITLE_TXT, ");
        selectClause.append(" a.std_typ FROM STD a, ");
        selectClause.append(tableName);
        selectClause.append(" c WHERE a.STD_ID = c.STD_ID ");
        
        if(searchIds!=null && !"".equals(searchIds.trim()))
        {
        	searchIds = searchIds.replace(" ", ", ");
        	selectClause.append(" AND a.prnt_std_id in (SELECT prnt_std_id from std where std_id in ( ");
        	selectClause.append(searchIds);
        	selectClause.append(" ))), ");
        } else {
        	selectClause.append(" ), ");
        }
        
        selectClause.append(" CMS_STD AS ( SELECT * FROM ALL_STD UNION SELECT a.STD_ID, a.PRNT_STD_ID,");
        selectClause.append(" (SELECT sd.disp_order_nbr FROM std_display_order sd ");
        selectClause.append(" WHERE sd.chain_cd = '");
        selectClause.append(chainCd);
        selectClause.append("' AND sd.rgn_cd = '");
        selectClause.append(regionCd);
        selectClause.append("' AND sd.std_id = a.std_id) AS disp_order_nbr, ");
        selectClause.append(" CASE WHEN a.STD_TYP = 'GDLN' THEN a.STD_DESC ELSE a.TITLE_TXT END TITLE_TXT, ");
        selectClause.append(" a.std_typ FROM STD a, ALL_STD c ");
        selectClause.append("  WHERE a.STD_ID = c.PRNT_STD_ID AND a.STD_ID NOT IN (SELECT STD_ID FROM ALL_STD)  ");
        
        
        /*if ("STD_REF".equals(tableName)) {
        	selectClause.append("(select std_id from BRIDGE_IDS)");
        } else {
	        selectClause.append(" (select std_id from bridge_publish where publish_id in (select publish_id from ");
	        selectClause.append(" CURR_BRIDGE) and rgn_id = ");
	        selectClause.append(regionId);
	        selectClause.append("  and unpublish_ind = 'N' AND std_id in ");
	        selectClause.append(" ( select std_id from ");
	        selectClause.append(tableName);
	        selectClause.append(" )) ");
        }*/
        if(searchIds!=null && !"".equals(searchIds.trim()))
        {
        	selectClause.append(" AND a.prnt_std_id in (SELECT prnt_std_id from std where std_id in ( ");
        	selectClause.append(searchIds);
        	selectClause.append(" ))), ");
        } else {
        	selectClause.append(" ), ");
        }
        return selectClause;
    }
    
    /**
     * 
     * @param selectClause
     * @param tableName
     * @return StringBuilder
     */
    private StringBuilder getPublishStandardsQuery (StringBuilder selectClause, String tableName, String regionCd) {
    	
    	//OBSM Title Difference
        selectClause.append(" SELECTED_STD AS (SELECT PS.STD_ID, PS.PRNT_STD_ID, PS.DISP_ORDER_NBR, ");
        selectClause.append(" CASE WHEN PS.STD_TYP = 'GDLN' THEN PS.STD_DESC ELSE PS.TITLE_TXT END TITLE_TXT ");
        selectClause.append(" FROM CURR_PROD CP, PUBLISH_STD PS, ");
        selectClause.append(tableName);
        selectClause.append(" cs ");
        selectClause.append(" WHERE CP.PUBLISH_ID = PS.PUBLISH_ID AND PS.STD_ID = cs.STD_ID AND PS.RGN_CD IN ('GLBL', '");
        selectClause.append(regionCd);
        selectClause.append("') )");
    	return selectClause;
    }
    
    /**
     * 
     * @param selectClause
     * @param region
     * @param chainCd
     * @param tableName
     * @return StringBuilder
     */
    private StringBuilder getDisplayOrderQuery (StringBuilder selectClause, String region, String chainCd, String tableName) {
    	//Display Order
        selectClause.append(" DISPLAY_ORDER AS (select std_id, disp_order_nbr from std_display_order where chain_cd = '");
        selectClause.append(chainCd);
        selectClause.append("' AND rgn_cd = '");
        selectClause.append(region);
        selectClause.append("' AND std_id in (select std_id from ");
        selectClause.append(tableName);
        selectClause.append(" )) ");
    	return selectClause;
    }
  
}
