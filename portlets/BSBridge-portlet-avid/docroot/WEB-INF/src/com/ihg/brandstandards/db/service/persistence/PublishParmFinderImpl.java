package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.PublishParm;
import com.ihg.brandstandards.db.model.impl.PublishParmImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

public class PublishParmFinderImpl extends BasePersistenceImpl<PublishParm> implements PublishParmFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishParmFinderImpl.class);
    
    public PublishParm createPublishParam() throws SystemException
    {
        Session session = null;
        PublishParm publishParm = null;
        
        try
        {
            session = openSession();
            final String query = "SELECT PUBLISH_PARM_ID_SEQ.nextval AS PUBLISH_PARM_ID, " +
                                 "0 AS PUBLISH_ID, NULL AS PARM_NM, NULL AS PARM_VAL, " +
                                 "NULL CREAT_USR_ID, SYSDATE AS CREAT_TS, NULL AS LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS FROM dual";
            if (LOG.isDebugEnabled()) {
                LOG.debug("New Publication : " + query);
            }
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("PublishParm", PublishParmImpl.class);
            List<PublishParm> pubParmList = sqlQuery.list();
            publishParm = pubParmList.get(0);
            publishParm.setPrimaryKey(publishParm.getPublishParmId());
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
        return publishParm;
    }
}
