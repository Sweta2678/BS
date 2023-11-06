package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.BridgePublishCountry;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgePublishCountryFinderImpl extends BasePersistenceImpl<BridgePublishCountry> implements BridgePublishCountryFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(BridgePublishCountryFinderImpl.class);

	public void deleteBridgePublishCountries(long bridgePublishId) {
		StringBuffer query  = new StringBuffer("DELETE FROM BRIDGE_PUBLISH_CTRY WHERE bridge_publish_Id=").append(bridgePublishId);
    	
        if(LOG.isDebugEnabled()){
        	LOG.debug("deleteBridgePublishCountries query: " + query.toString());
        }
        Session session = null;
        try {
        	session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.executeUpdate();
        } catch(Exception e) {
        	LOG.debug("Failed deleteBridgePublishCountries query: " + query.toString());
            LOG.error("Failed to delete BridgePublishCountries", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
	}
}
