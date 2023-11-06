package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.model.impl.TaxonomyExtImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Fetch Indexes from database.
 * 
 * @author KhandeN
 * 
 */
public class TaxonomyExtFinderImpl extends BasePersistenceImpl<TaxonomyExt> implements TaxonomyExtFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(TaxonomyExtFinderImpl.class);

    /**
     * Fetch all Indexes for specified Standard from database.
     * 
     * @param standardsId - Standard Id
     * @return - List of Indexes
     * @throws SystemException - exception
     */
    @SuppressWarnings("unchecked")
    public List<TaxonomyExt> getIndexPathByStandardsId(final long standardsId) throws SystemException
    {
        Session session = null;
        List<TaxonomyExt> arlResults = new ArrayList<TaxonomyExt>();
        try
        {
            session = openSession();
            final String query = " SELECT * FROM ( SELECT 0 AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, T.TAXONOMY_DESC, T.IMAGE_PATH_TXT, LEVEL AS LVL, T.HIER_LVL_NBR," 
                    + " SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' -> '), 21) AS PATH"
                    + " FROM TAXONOMY T START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID "
                    + " ORDER BY T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.HIER_LVL_NBR) TAX, TAXONOMY_STD TS WHERE TAX.TAXONOMY_ID = TS.TAXONOMY_ID  AND TS.STD_ID = ?";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            final QueryPos qPos = QueryPos.getInstance(sqlQuery);
            sqlQuery.addEntity("TaxonomyExt", TaxonomyExtImpl.class);
            qPos.add(standardsId);
            arlResults = (List<TaxonomyExt>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            closeSession(session);
        }
        return arlResults;
    }

    /**
     * Fetch all Indexes from database.
     * 
     * @return - list of Indexes
     * @throws SystemException - exception
     */
    @SuppressWarnings("unchecked")
    public List<TaxonomyExt> getAllIndexes() throws SystemException
    {
        Session session = null;
        List<TaxonomyExt> arlResults = new ArrayList<TaxonomyExt>();
        try
        {
            session = openSession();
            final String query = " SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, T.TAXONOMY_DESC, T.IMAGE_PATH_TXT, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' -> '), 21) AS PATH " + 
                    " FROM TAXONOMY T " + 
                    " START WITH T.TAXONOMY_ID = 1 " + 
                    " CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID " + 
                    " ORDER SIBLINGS BY T.HIER_LVL_NBR ";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("TaxonomyExt", TaxonomyExtImpl.class);
            arlResults = (List<TaxonomyExt>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            closeSession(session);
        }
        return arlResults;
    }
    
    /**
     * Fetch all Indexes from database.
     * @return - list of Indexes
     * @throws SystemException - exception
     */
    @SuppressWarnings("unchecked")
    public List<TaxonomyExt> getAllIndexesOdrByIdxId() throws SystemException
    {
        Session session  = null;
        List<TaxonomyExt> arlResults = new ArrayList<TaxonomyExt>();
        try
        {
            session = openSession();
            final String query = "  SELECT ROWNUM AS INDX_ORDER, T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, T.TAXONOMY_DESC, T.IMAGE_PATH_TXT, (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' -> '), 21) AS PATH " +
                                " FROM TAXONOMY T " +
                                " START WITH T.TAXONOMY_ID = 1 " +
                                " CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID " +
                                " ORDER BY T.TAXONOMY_ID";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("TaxonomyExt", TaxonomyExtImpl.class);
            arlResults = (List<TaxonomyExt>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            closeSession(session);
        }
        return arlResults;
    }
    
	/*public List<Object> getBrandDesc(long taxId, String brand) throws SystemException
    {
    	LOG.debug("reached taxonomyExtFinderImpl to execute custom query...");
    	Session session  = null;
        List<Object> arlResults = null;
        try
        {
            session = openSession();
            StringBuffer query = new StringBuffer("SELECT BX.BRAND_TAXONOMY_ID FROM BRAND_TAXONOMY BX WHERE BX.TAXONOMY_ID=");
            query.append(taxId);
            query.append(" AND BX.CHAIN_CD='");
            query.append(brand);
            query.append("'");
            
            LOG.debug("query: "+query.toString());
            SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            arlResults = sqlQuery.list();
            LOG.debug("arlResults: "+(arlResults != null ? arlResults.size() : "Null Results"));
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlResults;
    }*/
}
