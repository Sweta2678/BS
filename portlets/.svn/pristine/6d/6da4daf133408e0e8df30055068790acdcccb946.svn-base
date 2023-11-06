package com.ihg.brandstandards.db.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.journal.model.JournalArticle;

public class BrandArticleFinderImpl extends BasePersistenceImpl<JournalArticle> implements BrandArticleFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BrandArticleFinderImpl.class);
	
	/**
     * Method returns associated stds
     */ 
	private static SessionFactory sessionFactory  = null;
    public List getAssociatedStds(String query)
    {
        Session session = null;
        SQLQuery sqlQuery = null;
        try
        {
            //session = openSession();

            if (sessionFactory == null)
            {
                sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
            }
            session = sessionFactory.openSession();
            sqlQuery = session.createSQLQuery(query);
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        finally
        {
            closeSession(session);
        }

        return sqlQuery.list();
    }
}
