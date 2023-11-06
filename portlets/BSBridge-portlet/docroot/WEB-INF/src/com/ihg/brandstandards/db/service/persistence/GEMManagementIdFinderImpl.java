package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.GEMManagementId;
import com.ihg.brandstandards.db.model.impl.BridgePublishPreviewImpl;
import com.ihg.brandstandards.db.model.impl.GEMManagementIdImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GEMManagementIdFinderImpl extends BasePersistenceImpl<GEMManagementId> implements GEMManagementIdFinder   {

	
    private static final Log LOG = LogFactoryUtil.getLog(GEMManagementIdFinderImpl.class);
    
	/**
	 * 
	 * @param regionId
	 * @param subBrandCode
	 * @return Map<String, Map<Stirng, String>>
	 */
	@SuppressWarnings("unchecked")
	public List<GEMManagementId> getManagementIdsByRegionAndBrand (long regionId, String subBrandCodes) {
    	Session session = null;
    	StringBuilder sbCodes = new StringBuilder(subBrandCodes);
    	if(subBrandCodes!=null && subBrandCodes.length() > 0)
    	{
    		sbCodes = new StringBuilder().append("'").append(subBrandCodes.replace(",", "','")).append("'");
    	}
        List<GEMManagementId> ls = new ArrayList<GEMManagementId>();
		StringBuilder queryClause = new StringBuilder();
        queryClause.append(" SELECT GMI.* FROM GEM_MGT_ID GMI, BRNDSTND_CTRY BC ");
        queryClause.append(" WHERE BC.RGN_ID = ").append(regionId).append(" AND BC.CTRY_NM_CD = GMI.CTRY_NM_CD AND BRAND_CD IN (").append(sbCodes).append(")");
        queryClause.append(" ORDER BY GMI.CTRY_NM_CD, GMI.BRAND_CD ");
        try
        {
            session = openSession();
            LOG.debug("Query Find By REGION ID and SubBrandCodes : " + queryClause.toString());
            SQLQuery q = session.createSQLQuery(queryClause.toString());
            q.addEntity("GEMManagementId", GEMManagementIdImpl.class);
            q.setCacheable(false);
            ls = (List<GEMManagementId>) q.list();
        }
        catch (Exception e)
        {
            LOG.debug("Failed Query : " + queryClause);
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
}
