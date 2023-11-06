package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.StandardsDisplayOrderExt;
import com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Finder for Standards + associated Indexes.
 * 
 * @author KryvorA
 * 
 */
public class StandardsDisplayOrderExtFinderImpl extends BasePersistenceImpl<StandardsDisplayOrderExt> implements StandardsDisplayOrderExtFinder
{
    
	private static final Log LOG = LogFactoryUtil.getLog(StandardsDisplayOrderExtFinderImpl.class);
	
	/**
     * Get standard display order by region and chain code. 
     * @param chainCode
     * @param regionCode
     * @return 
     * @throws SystemException
     */
    public List<StandardsDisplayOrderExt> getStandardsOrderByChnCodeAndRgnCode(long taxonomyId,  String chainCode, String regionCode) throws SystemException
    {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT s.std_id, ");
        sql.append("CASE WHEN S.STD_TYP = 'GDLN' THEN ");
        sql.append("    S.STD_DESC ");
        sql.append("ELSE ");
        sql.append("    S.TITLE_TXT ");
        sql.append("END AS TITLE_TXT, ");
        sql.append("s.GBL_RGN_IND, s.FRAMEWORK_STD_IND,  ");
        sql.append(" CS.CHAIN_CD, S.RGN_CD, ");
        sql.append("nvl((SELECT sdo.DISP_ORDER_NBR ");
        sql.append("     FROM std_display_order sdo ");
        sql.append("     WHERE sdo.std_id = s.std_id ");
        sql.append("     AND sdo.RGN_CD = '").append(regionCode).append("' ");
        sql.append("     AND sdo.CHAIN_CD = '").append(chainCode).append("'), 1000) AS DISP_ORDER_NBR ");
        sql.append(" FROM STD s, stat st, chain_std cs ");
        sql.append(" WHERE s.stat_desc != 'DELETED' ");
        sql.append(" AND s.std_id IN (SELECT STD_ID FROM TAXONOMY_STD WHERE TAXONOMY_ID = ").append(taxonomyId).append(")");
        sql.append(" AND st.stat_id = cs.stat_id ");
        sql.append(" AND s.std_id = cs.std_id ");
        sql.append(" AND S.RGN_CD in ('").append(regionCode).append("', 'GLBL') ");
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Region Code: " + regionCode);
        }
        if(!"GLBL".equals(regionCode))
        {
        	sql.append(" AND '").append(regionCode).append("' in ( select br.rgn_cd as rgn_cd from ctry_std cs, brndstnd_ctry bc, brndstnd_rgn br  ");
        	sql.append("	where std_id = s.std_id and cs.ctry_nm_cd = bc.ctry_nm_cd and bc.rgn_id = br.rgn_id group by br.rgn_cd) ");
        	if (LOG.isDebugEnabled())
            {
                LOG.debug("Region Code: else part");
            }
        }
        sql.append(" AND cs.CHAIN_CD = '").append(chainCode).append("' ");
        sql.append(" AND cs.ACTV_IND = 'Y' AND st.stat_cd NOT IN ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD') ");
        
        LOG.debug("Standard order  query: " + sql);
        List<StandardsDisplayOrderExt> standardsDisplayOrderExt = Collections.emptyList();
        Session session = null;
        List<StandardsDisplayOrderExt> standardsDisplayOrderResultSet = new ArrayList<StandardsDisplayOrderExt>();
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.setCacheable(false);
            q.addEntity("StandardsDisplayOrderExt", StandardsDisplayOrderExtImpl.class);
            standardsDisplayOrderExt = q.list();
            
            standardsDisplayOrderResultSet.addAll(standardsDisplayOrderExt);
            Collections.sort(standardsDisplayOrderResultSet, new StandardsDisplayOrderCompartor());
        }
        catch (Exception e)
        {
            LOG.debug("CMS Failed on Query: " + sql);
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return standardsDisplayOrderResultSet;
    }

}

/**
 * Standards Display order compartor
 * @author krunal.patel
 *
 */
class StandardsDisplayOrderCompartor implements Comparator<StandardsDisplayOrderExt>
{
	 
    public int compare(StandardsDisplayOrderExt sd1, StandardsDisplayOrderExt sd2) 
    {
        if (sd1.getDisplayOrder() == sd2.getDisplayOrder())
        {
            return 0;
        } 
        else if (sd1.getDisplayOrder() > sd2.getDisplayOrder())
        {
            return 1;
        }
        else 
        {
        	return -1;
        }
    }
}

