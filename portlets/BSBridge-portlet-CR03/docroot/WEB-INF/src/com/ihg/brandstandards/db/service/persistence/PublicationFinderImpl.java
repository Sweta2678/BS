package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.impl.PublicationImpl;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class PublicationFinderImpl extends BasePersistenceImpl<Publication> implements PublicationFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(PublicationFinderImpl.class);
    /**
     * @param query This is a String type object
     * @return List<Publish> This method returns List of Publish object
     */
    public List<Publication> getPublishRecords (String query) 
    {
        List<Publication> publishRecords = new ArrayList<Publication>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("p", PublicationImpl.class);
            publishRecords = sqlQuery.list();
        } catch (ORMException e) {
            LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return publishRecords;
    }
    
    public Publication createPublication() throws SystemException
    {
        Session session = null;
        Publication publication = null;
        
        try
        {
            session = openSession();
            final String query = "SELECT PUBLISH_ID_SEQ.nextval AS PUBLISH_ID, " +
                                 "0 AS PUBLISH_VER_ID, 'ACTIVE' AS PUBLISH_STAT_CD, 'BRIDGE' AS PUBLISH_ENVIRONMENT_NM, NULL AS CHAIN_CD, " +
                                 "NULL AS PUBLISHED_LOCALE_LIST_TXT, NULL CREAT_USR_ID, " +
                                 "SYSDATE AS CREAT_TS, NULL AS LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS, NULL AS PUBLISH_DT, NULL AS PUBLISH_CONTENT_TYP, 0 AS PRNT_PUBLISH_ID, NULL AS VLD_XLAT_IND FROM dual";
            if (LOG.isDebugEnabled()) {
                LOG.debug("New Publication : " + query);
            }
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("Publication", PublicationImpl.class);
            List<Publication> pubLstList = sqlQuery.list();
            publication = pubLstList.get(0);
            publication.setPrimaryKey(publication.getPublishId());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return publication;
    }

    public List<String> fetchUniquePublishedBrandCodes()
    {
        List<String> allUniqueRecords = Collections.emptyList();
        Session session = null;
        try
        {
            session = openSession();
            final String query = "SELECT DISTINCT CHAIN_CD FROM PUBLISH";
            if (LOG.isDebugEnabled()) {
                LOG.debug("Distinct Published brand codes: " + query);
            }
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            allUniqueRecords = (List<String>)sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error("Error while fetching unique records : " + e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return allUniqueRecords;
    }

}
