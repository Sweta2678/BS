package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.impl.GlossaryImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Find Standards based on search criteria.
 * 
 * @author KhandeN
 * 
 */
public class GlossaryFinderImpl extends BasePersistenceImpl<Glossary> implements GlossaryFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryFinderImpl.class);
    
    public List<Glossary> getGlossaryIdByBrandCode(String brandCode)
    {
    	String query = "select * from glossary where glossary_id in (select unique(g.glossary_id) from glossary g,glossary_rgn_nav gr where g.glossary_id=gr.glossary_id and gr.chain_cd= ?)";
    	List<Glossary> list = new ArrayList<Glossary>();
    	Session session = null;
        try
        {
            session = openSession();
        	SQLQuery q = session.createSQLQuery(query.toString());
        	q.setCacheable(false);
        	q.addEntity("Glossary", GlossaryImpl.class);
        	
        	QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(brandCode);
            list = (List<Glossary>) q.list(); 
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
        return  list;
    }
}
