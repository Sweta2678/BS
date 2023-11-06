
package com.ihg.brandstandards.db.service.persistence;
import java.util.LinkedList;
import java.util.List;

import com.ihg.brandstandards.db.model.BridgePublishCountryStateEx;
import com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgePublishCountryStateExFinderImpl extends BasePersistenceImpl<BridgePublishCountryStateEx> implements BridgePublishCountryStateExFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishCountryStateExFinderImpl.class);
    
    public static long GLBL_CD = 1;
    
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    @SuppressWarnings("unchecked")
    public List<BridgePublishCountryStateEx> getBridgePublishCountryStateEx(String chainCd, long regionId) throws SystemException {
        
        StringBuffer query = new StringBuffer("SELECT * FROM (WITH ");
        query.append("CURR_PUBLISH AS ( SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_ENVIRONMENT_NM = 'BRIDGE' AND PUBLISH_STAT_CD = 'ACTIVE' ");
        query.append("AND CHAIN_CD = '").append(chainCd).append("'), ");
        query.append("CURR_BRIDGE_PUBLISH AS ( SELECT BRIDGE_PUBLISH_ID, STD_ID, RGN_ID FROM BRIDGE_PUBLISH BP, ");
        query.append("CURR_PUBLISH CP WHERE BP.RGN_ID IN (").append(GLBL_CD).append(", ").append(regionId).append(") ");
        query.append("AND BP.PUBLISH_ID = CP.PUBLISH_ID AND UNPUBLISH_IND = 'N'), ");
        query.append("BRIDGE_PUB_CTRY AS (SELECT BPC.BRIDGE_PUBLISH_ID, BPC.CTRY_NM_CD, BPC.BRIDGE_PUBLISH_STAT_CD ");
        query.append("FROM BRIDGE_PUBLISH_CTRY BPC, BRNDSTND_CTRY BC, ");
        query.append("CURR_BRIDGE_PUBLISH CBP WHERE BPC.BRIDGE_PUBLISH_ID = CBP.BRIDGE_PUBLISH_ID ");
        query.append("AND BPC.CTRY_NM_CD = BC.CTRY_NM_CD AND BC.RGN_ID = ").append(regionId).append(" ), ");
        query.append("SELECTED_STD AS (SELECT S.STD_ID, S.STD_TYP, S.PRNT_STD_ID, ");
        query.append("CASE s.std_typ when 'GDLN' then S.STD_DESC ELSE S.TITLE_TXT END AS TITLE_TXT, CBP.BRIDGE_PUBLISH_ID ");
        query.append("FROM STD S, CURR_BRIDGE_PUBLISH CBP WHERE S.STD_ID = CBP.STD_ID) ");
        query.append("SELECT SELECTED_STD.PRNT_STD_ID AS PRNT_STD_ID, SELECTED_STD.STD_ID AS STD_ID, BPC.CTRY_NM_CD, BPC.BRIDGE_PUBLISH_STAT_CD, ");
        query.append("SELECTED_STD.STD_TYP AS STD_TYP, BPC.BRIDGE_PUBLISH_ID AS BRIDGE_PUBLISH_ID ");
        query.append("FROM SELECTED_STD, BRIDGE_PUB_CTRY BPC ");
        query.append("WHERE SELECTED_STD.BRIDGE_PUBLISH_ID = BPC.BRIDGE_PUBLISH_ID ");
        query.append("GROUP BY SELECTED_STD.PRNT_STD_ID, SELECTED_STD.STD_ID,  SELECTED_STD.STD_TYP, ");
        query.append("SELECTED_STD.STD_ID,  BPC.BRIDGE_PUBLISH_ID, BPC.CTRY_NM_CD, BPC.BRIDGE_PUBLISH_STAT_CD order by SELECTED_STD.STD_ID) ");
        if (LOG.isDebugEnabled())
        {
            LOG.debug(query);
        }
        
        List<BridgePublishCountryStateEx> statusExs = new LinkedList<BridgePublishCountryStateEx>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            sqlQuery.addEntity("publishStandards", BridgePublishCountryStateExImpl.class);
            statusExs = sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.debug("Failed Query: " + query.toString());
            LOG.error(StackTraceUtil.getStackTrace(e));
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