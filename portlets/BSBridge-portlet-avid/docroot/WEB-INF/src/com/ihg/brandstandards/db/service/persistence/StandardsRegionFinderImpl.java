package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.impl.StandardsRegionImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.List;

public class StandardsRegionFinderImpl extends BasePersistenceImpl<StandardsRegion>
implements StandardsRegionFinder
{

private static final Log LOG = LogFactoryUtil.getLog(StandardsFinderImpl.class);
	
	public List<StandardsRegion> getSubRegionsListByParentId(long parentRegionId){
		
		List<StandardsRegion> standardsSubRegionsList = new ArrayList<StandardsRegion>();
		
		Session session = null;
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM BRNDSTND_RGN BR ");
		query.append("WHERE BR.PRNT_RGN_ID = ");
		query.append(parentRegionId);
		try
		{
			session = openSession();
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("StandardsRegion", StandardsRegionImpl.class);
			standardsSubRegionsList = q.list();
		}
		catch(Exception e){
			LOG.error(StackTraceUtil.getStackTrace(e));
		}
		finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
		
		return standardsSubRegionsList;
	}
	
	public List<StandardsRegion> getStandardsParentRegionsList(){
		
		List<StandardsRegion> standardsSubRegionsList = new ArrayList<StandardsRegion>();
		
		Session session = null;
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM BRNDSTND_RGN BR ");
		query.append("WHERE BR.PRNT_RGN_ID IS NULL ");
		try
		{
			session = openSession();
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("StandardsRegion", StandardsRegionImpl.class);
			standardsSubRegionsList = q.list();
		}
		catch(Exception e){
			LOG.error(StackTraceUtil.getStackTrace(e));
		}
		finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
		
		return standardsSubRegionsList;
	}
	
}
