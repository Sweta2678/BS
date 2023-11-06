package com.ihg.brandstandards.db.service.persistence;

import java.util.LinkedList;
import java.util.List;

import com.ihg.brandstandards.db.model.FlagStandards;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class FlagStandardsFinderImpl extends BasePersistenceImpl<FlagStandards> implements FlagStandardsFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(FlagStandardsFinderImpl.class);

    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    public List<Long> getFlagStdId (long stdId) {
        List<Long> flagStdIds = new LinkedList<Long>();
        Session session = null;
        try
        {
            session = openSession();
            StringBuffer stringBuffer = new StringBuffer("Select FLAG_CATGY_ID from FLAG_STD where STD_ID = ");
            stringBuffer.append(stdId);
            SQLQuery query = session.createSQLQuery(stringBuffer.toString());
            query.addScalar("FLAG_CATGY_ID", Type.LONG);
            flagStdIds = query.list();
        }
        catch (Exception e)
        {
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return flagStdIds;
    }
    
    /**
     * @param stdId This is a long type object
     * @return List<Long> This method returns List object
     */
    public List<Long> getFlagIdByStdIdAndCategoryId (long stdId, List<String> categories) {
        List<Long> flagStdIds = new LinkedList<Long>();
        Session session = null;
        try
        {
            session = openSession();
            StringBuffer stringBuffer = new StringBuffer("Select FLAG_CATGY_ID from FLAG_STD where STD_ID = ");
            stringBuffer.append(stdId);
            stringBuffer.append(" AND FLAG_CATGY_ID in (select FLAG_CATGY_ID from FLAG_CATGY where PRNT_FLAG_CATGY_ID in").append(
                    " (select FLAG_CATGY_ID from FLAG_CATGY where FLAG_CATGY_VAL in ( ");
            int i = 0;
            for (String category : categories)
            {
                if (i > 0)
                {
                    stringBuffer.append(",");
                }
                stringBuffer.append("'" + category + "'");
                i++;
            }
            stringBuffer.append(")))");
            SQLQuery query = session.createSQLQuery(stringBuffer.toString());
            query.addScalar("FLAG_CATGY_ID", Type.LONG);
            flagStdIds = query.list();
        }
        catch (Exception e)
        {
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return flagStdIds;
    }
}
