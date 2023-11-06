package com.ihg.brandstandards.db.service.persistence;
import java.util.LinkedList;
import java.util.List;

import com.ihg.brandstandards.db.model.BridgePublishStateEx;
import com.ihg.brandstandards.db.model.impl.BridgePublishStateExImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgePublishStateExFinderImpl extends BasePersistenceImpl<BridgePublishStateEx> implements BridgePublishStateExFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishStateExFinderImpl.class);
    public static String BY_CTRY = "BYCNTRY";
    
    public static long GLBL_CD = 1;

    
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    public List<BridgePublishStateEx> getBridgePublishStateEx(String chainCd, long regionCd) throws SystemException {
        return getBridgePublishStateEx(chainCd, regionCd, null, null);
    }
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    @SuppressWarnings("unchecked")
    public List<BridgePublishStateEx> getBridgePublishStateEx(String chainCd, long regionId, String filterState, String filterId) throws SystemException {
        List<BridgePublishStateEx> statusExs = new LinkedList<BridgePublishStateEx>();
        StringBuffer queryString = new StringBuffer("WITH ");
        queryString.append(" CURR_PUBLISH  AS ( SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' AND PUBLISH_STAT_CD = 'ACTIVE' AND CHAIN_CD = '").append(chainCd).append("'), " );
        queryString.append(" CURR_BRIDGE_PUBLISH AS ( SELECT BRIDGE_PUBLISH_ID, STD_ID, RGN_ID FROM BRIDGE_PUBLISH BP, CURR_PUBLISH CP WHERE BP.RGN_ID = ");
        queryString.append(regionId);   
        queryString.append(" AND BP.PUBLISH_ID = CP.PUBLISH_ID AND UNPUBLISH_IND = 'N'), ");
        queryString.append(" BRIDGE_PUB_CTRY AS (SELECT BPC.BRIDGE_PUBLISH_ID, BPC.CTRY_NM_CD, BPC.BRIDGE_PUBLISH_STAT_CD FROM BRIDGE_PUBLISH_CTRY BPC, BRNDSTND_CTRY BC, CURR_BRIDGE_PUBLISH CBP ");
        queryString.append(" WHERE BPC.BRIDGE_PUBLISH_ID = CBP.BRIDGE_PUBLISH_ID AND BPC.CTRY_NM_CD = BC.CTRY_NM_CD AND BC.RGN_ID = ").append(regionId).append("), ");
        queryString.append(" TAXON AS (SELECT TAX.INDX_ORDER, TAX.TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID, TAX.LVL, TAX.HIER_LVL_NBR, TAX.TITLE_TXT, TAX.PATH ");
        queryString.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' &#062; '), 29) AS PATH "); 
        queryString.append(" FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ) TAX), ");
        queryString.append(" SELECTED_STD AS (SELECT S.STD_ID, S.STD_TYP, S.DISP_ORDER_NBR, S.PRNT_STD_ID, CASE s.std_typ when 'GDLN' then S.STD_DESC ELSE S.TITLE_TXT END AS TITLE_TXT, CBP.BRIDGE_PUBLISH_ID, ");
        queryString.append(" NVL((select listagg(f.flag_catgy_id, ',') within group(order by f.flag_catgy_id) from flag_std f where s.std_id=  f.std_id and f.flag_catgy_id in (257, 258) group by f.std_id), '0') AS MNL_TYP ");
        queryString.append(" FROM STD S, CURR_BRIDGE_PUBLISH CBP WHERE S.STD_ID = CBP.STD_ID), ");
        queryString.append(" ORDER_NUM AS (SELECT STD_ID, DISP_ORDER_NBR FROM STD_DISPLAY_ORDER WHERE STD_ID IN (SELECT STD_ID FROM CURR_BRIDGE_PUBLISH) ");
        queryString.append(" AND CHAIN_CD = '" + chainCd + "' AND RGN_CD IN (SELECT RGN_CD FROM BRNDSTND_RGN WHERE RGN_ID = " + regionId + ")),");
        queryString.append(" BRIDGE_STD_STAT AS (SELECT distinct bp.BRIDGE_PUBLISH_ID, decode(bs.cnt, 1, bp.BRIDGE_PUBLISH_STAT_CD, '").append(BY_CTRY).append("') AS STAT_CD ");
        queryString.append("   FROM (SELECT BRIDGE_PUBLISH_ID, count(unique(BRIDGE_PUBLISH_STAT_CD)) cnt ");
        queryString.append("   FROM BRIDGE_PUB_CTRY GROUP BY BRIDGE_PUBLISH_ID) bs , BRIDGE_PUB_CTRY bp WHERE bp.BRIDGE_PUBLISH_ID = bs.BRIDGE_PUBLISH_ID) "); 
        queryString.append(" SELECT TAX.TITLE_TXT AS TAX_TITLE_TXT, TAX.PATH AS PATH, TAX.INDX_ORDER AS INDX_ORDER, TAX.TAXONOMY_ID AS TAXONOMY_ID, TAX.PRNT_TAXONOMY_ID AS PRNT_TAXONOMY_ID, ");
        queryString.append(" TAX.LVL AS LVL, TAX.HIER_LVL_NBR AS HIER_LVL_NBR, ss.PRNT_STD_ID AS PRNT_STD_ID, ss.STD_ID AS STD_ID, NVL(do.DISP_ORDER_NBR, 0) AS DISP_ORDER_NBR, ");
        queryString.append(" ss.STD_TYP AS STD_TYP, ss.TITLE_TXT AS TITLE, ss.BRIDGE_PUBLISH_ID AS BRIDGE_PUBLISH_ID, ss.MNL_TYP, nvl(bss.STAT_CD, 'SELECT') AS STAT_CD, 0 AS STAT_COUNT "); 
        queryString.append(" FROM TAXON TAX, SELECTED_STD ss, TAXONOMY_STD TS, BRIDGE_STD_STAT bss, ORDER_NUM do ");
        queryString.append(" WHERE TS.TAXONOMY_ID = TAX.TAXONOMY_ID ");
        queryString.append(" AND TS.STD_ID = ss.PRNT_STD_ID ");
        queryString.append(" AND ss.BRIDGE_PUBLISH_ID = bss.BRIDGE_PUBLISH_ID(+) AND ss.STD_ID = do.STD_ID(+)");
        

        if(filterId!=null && !"".equals(filterId.trim()))
        {
          filterId = filterId.replace(" ", ", ");
          queryString = queryString.append(" AND SS.PRNT_STD_ID in (select prnt_std_id from std where std_id in("+ filterId +")) ");
        }
        
        LOG.debug(queryString);
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery query = session.createSQLQuery(queryString.toString());
            query.addEntity("publishStandards", BridgePublishStateExImpl.class);
            statusExs = query.list();
        }
        catch (Exception e)
        {
            LOG.debug("Failed Query : " + queryString);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return statusExs;
    }
}
