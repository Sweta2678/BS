package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.PublishStd;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class PublishStdFinderImpl extends BasePersistenceImpl<PublishStd> implements PublishStdFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(PublishStdFinderImpl.class);
	
	public List<PublishStd> getStandardsByCountryAndBrand(long publishId, long taxonomyId, String chainCode, String countryCode, String stdType)
    {
        List<PublishStd> arlStandards = new ArrayList<PublishStd>();
        Session session = null;
        try
        {
            session = openSession();
            String strQuery = " SELECT PUBLISH_STD.PUBLISH_STD_VER_ID, PUBLISH_STD.STD_ID, PUBLISH_STD.PRNT_STD_ID, PUBLISH_STD.STD_TYP, PUBLISH_STD.TITLE_TXT, PUBLISH_STD.STD_DESC, PUBLISH_STD.IMPLMNT_DEADLINE_DT, "
                    + " PUBLISH_STD.WAIVER_IND, PUBLISH_STD.PUBLISH_ID, PUBLISH_STD.DISP_ORDER_NBR, PUBLISH.PUBLISH_ID, PUBLISH.CHAIN_CD, PUBLISH.PUBLISH_STAT_CD, PUBLISH_STD.STAT_DESC "
                    + " FROM PUBLISH_STD INNER JOIN PUBLISH_CTRY_STD ON PUBLISH_STD.PUBLISH_STD_VER_ID = PUBLISH_CTRY_STD.PUBLISH_STD_VER_ID "
                    + " INNER JOIN PUBLISH_TAXONOMY_STD ON PUBLISH_STD.PUBLISH_STD_VER_ID = PUBLISH_TAXONOMY_STD.PUBLISH_STD_VER_ID INNER JOIN PUBLISH "
                    + " ON PUBLISH.PUBLISH_ID = PUBLISH_STD.PUBLISH_ID WHERE  PUBLISH.CHAIN_CD = ? AND PUBLISH_CTRY_STD.CTRY_NM_CD = ? "
                    + " AND PUBLISH_STD.STD_TYP=? AND PUBLISH.PUBLISH_STAT_CD = 'ACTIVE'  AND PUBLISH.PUBLISH_ENVIRONMENT_NM= 'PRODUCTION'   ";
            SQLQuery q = session.createSQLQuery(strQuery);
            q.addEntity("publishStandards", PublishStd.class);
            QueryPos queryPos = QueryPos.getInstance(q);
            queryPos.add(publishId);
            queryPos.add(chainCode);
            queryPos.add(countryCode);

            arlStandards = (List<PublishStd>)q.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            closeSession(session);
        }

        return arlStandards;
    }
	
	 /**`
     * Method returns associated stds
     */ 
    public List getAssociatedStds(String query)
    {
        List<?> arlStandards;
        Session session = null;
        SQLQuery sqlQuery = null;
        try
        {
            session = openSession();
            sqlQuery = session.createSQLQuery(query);
            arlStandards = sqlQuery.list();
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
            arlStandards = new ArrayList();
        }
        finally
        {
            closeSession(session);
        }

        return arlStandards;
    }
}
