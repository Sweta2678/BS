package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.model.impl.PublicationImpl;
import com.ihg.brandstandards.db.model.impl.PublishDeptImpl;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class PublishDeptFinderImpl extends BasePersistenceImpl<PublishDept> implements PublishDeptFinder {

	private static final Log LOG = LogFactoryUtil.getLog(PublishDeptFinderImpl.class);

	/**
	 * @param departmentId
	 * @param brandCode
	 * @return Publication 
	 */
	public Publication getAcitveDepartmentPublication (long departmentId, String brandCode) {
		List<Publication> publishRecords = new ArrayList<Publication>();
		Publication activePublication = null;
        String query = BridgeQueryUtils.getDepartmentPublication(departmentId, brandCode, "GEM_CMS");
		Session session = null;
        try
        {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("p", PublicationImpl.class);
            publishRecords = sqlQuery.list();
            if (publishRecords.size() > 0) {
            	activePublication = publishRecords.get(0);
            }
        } catch (ORMException e) {
            LOG.error(e.getMessage(), e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return activePublication;
	}
	
	/**
	 * 
	 * @return PublishDept
	 * @throws SystemException
	 */
	public PublishDept createDeptPublication() throws SystemException
    {
        Session session = null;
        PublishDept publication = null;
        
        try
        {
            session = openSession();
            StringBuffer query = new StringBuffer("SELECT GEM_PUBLISH_DEPT_ID_SEQ.nextval AS GEM_PUBLISH_DEPT_ID, ");
            query.append("0 AS GEM_DEPT_ID, 0 AS PUBLISH_ID, NULL CREAT_USR_ID, ");        
            query.append(" SYSDATE AS CREAT_TS, NULL AS LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS FROM dual");
            if (LOG.isDebugEnabled()) {
                LOG.debug("New Department Publication : " + query.toString());
            }
            final SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            sqlQuery.addEntity("PublishDept", PublishDeptImpl.class);
            List<PublishDept> pubLstList = sqlQuery.list();
            publication = pubLstList.get(0);
            publication.setPrimaryKey(publication.getPublishDeptId());
            
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
}
