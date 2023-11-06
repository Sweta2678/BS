package com.ihg.brandstandards.db.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.db.model.BridgePublishLang;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgePublishLangFinderImpl extends BasePersistenceImpl<BridgePublishLang> implements BridgePublishLangFinder
{
    
	 private static final Log LOG = LogFactoryUtil.getLog(BridgePublishLangFinderImpl.class);
	/**
     * 
     * @param query
     * @return String
     */
    public Map<String, String> getAllLanguagesForPublication(long publishId)
    {
        String query = BridgeQueryUtils.getAllLanguagesForPublication(publishId);
        
        Map<String, String> publicationDetails = new HashMap<String, String>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            List result = sqlQuery.list();
            if (result != null && result.size() > 0)
            {
                for (int i = 0; i < result.size(); i++)
                {
                    Object[] obj = (Object[]) result.get(i);
                    publicationDetails.put("" + obj[0], (String) obj[1]);
                }
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Languages :::" + publicationDetails);
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
        return publicationDetails;
    }
}
