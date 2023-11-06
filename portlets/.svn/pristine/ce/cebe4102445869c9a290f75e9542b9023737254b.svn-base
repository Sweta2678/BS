package com.ihg.brandstandards.db.service.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.model.impl.TaxonomyImpl;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Update XML Tree.
 * 
 * @author SengarA
 * 
 */
public class TaxonomyFinderImpl extends BasePersistenceImpl<Taxonomy> implements TaxonomyFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(TaxonomyFinderImpl.class);

    /**
     * Insert Admin Tree XML into XML table.
     * 
     * @param treeId - id on tree
     * @return success/failure
     * @throws SystemException - exception.
     */
    public String insertAdminTreeXML(final long treeId) throws SystemException
    {
        String qryExe = "failure";
        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall("{call PROCXML}");
            final int count = colstmt.executeUpdate();
            if(LOG.isDebugEnabled()){
                LOG.debug("Index Admin Tree XML====>>" + count);
            }
            if (count == 1)
            {
                qryExe = "success";
            }
            return qryExe;
        }
        catch (Exception e)
        {
            throw new SystemException(e);
        }
        finally
        {
            if (colstmt != null)
            {
                try
                {
                    colstmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
    }

    public void updateTaxonomyPosition(Taxonomy taxonomyObj, Taxonomy taxonomyRef, long pos) throws SystemException
    {
        StringBuilder query1 = new StringBuilder();
        Session session = openSession();

        query1.append("SELECT * ");
        query1.append(" FROM Taxonomy tax ");
        query1.append(" WHERE  tax.prnt_taxonomy_id = ?  order by tax.hier_lvl_nbr asc ");

        long taxCountByPid = TaxonomyLocalServiceUtil.getTaxonomyCountByPid(taxonomyObj.getParentId());

        // List<Taxonomy> taxonomies =TaxonomyLocalServiceUtil.getTaxonomiesByParentId(taxonomyObj.getTaxId());

        if (pos >= taxCountByPid)
        {
            pos = taxCountByPid;
        }

        try
        {
            if (taxonomyObj.getParentId() == taxonomyRef.getTaxId())//ordering under same parent
            {
            	long counter = 0;
            	SQLQuery q1 = session.createSQLQuery(query1.toString());
                q1.addEntity("Taxonomy", TaxonomyImpl.class);
                QueryPos queryPos1 = QueryPos.getInstance(q1);
                queryPos1.add(taxonomyObj.getParentId());

                List<Taxonomy> list1 = (List<Taxonomy>) q1.list();
            	
            	for (Taxonomy tax : list1) {
            		long num = counter;
            		if (tax.getTaxId() == taxonomyObj.getTaxId()) {
            			if (taxonomyObj.getPosition() < pos){
            				tax.setPosition(pos - 1);
            			} else {
            				tax.setPosition(pos);
            			}
            			
            		} else if (tax.getPosition() > taxonomyObj.getPosition() && tax.getPosition() < pos){
            			tax.setPosition(num - 1);
            		} else if (tax.getPosition() < taxonomyObj.getPosition() && tax.getPosition() >= pos){
            			tax.setPosition(num + 1);
            		} else {
            			tax.setPosition(num);
            		}
            		tax.setUpdatedDate(new Date());
            		counter++;
            	}
            }
            else
            //ordering on different parents
            {
                if (taxonomyObj.getTaxId() == taxonomyRef.getTaxId())//for delete node re-indexing 
                {
                    SQLQuery q3 = session.createSQLQuery(query1.toString());
                    q3.addEntity("Taxonomy", TaxonomyImpl.class);
                    QueryPos queryPos3 = QueryPos.getInstance(q3);

                    queryPos3.add(taxonomyObj.getParentId());

                    List<Taxonomy> list3 = (List<Taxonomy>) q3.list();

                    for (Taxonomy tax3 : list3)
                    {
                        if (tax3.getPosition() > taxonomyObj.getPosition()) {
                        	tax3.setPosition(tax3.getPosition() - 1);
                        	tax3.setUpdatedDate(new Date());
                        }
                    }
                }
                else
                {
                    SQLQuery q3 = session.createSQLQuery(query1.toString());
                    q3.addEntity("Taxonomy", TaxonomyImpl.class);
                    QueryPos queryPos3 = QueryPos.getInstance(q3);

                    queryPos3.add(taxonomyObj.getParentId());

                    List<Taxonomy> list3 = (List<Taxonomy>) q3.list();

                    for (Taxonomy tax3 : list3)
                    {
                    	if (tax3.getPosition() > taxonomyObj.getPosition()) {
                    		tax3.setPosition(tax3.getPosition() - 1);
                    		tax3.setUpdatedDate(new Date());
                    	}
                    }

                    SQLQuery q4 = session.createSQLQuery(query1.toString());
                    q4.addEntity("Taxonomy", TaxonomyImpl.class);
                    QueryPos queryPos4 = QueryPos.getInstance(q4);

                    queryPos4.add(taxonomyRef.getTaxId());

                    List<Taxonomy> list4 = (List<Taxonomy>) q4.list();

                    for (Taxonomy tax4 : list4)
                    {
                        if (pos <= tax4.getPosition()) {
                        	tax4.setPosition(tax4.getPosition() + 1);
                        	tax4.setUpdatedDate(new Date());
                        }
                    }
                    session.flush();
                }
            }

        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);

        }
        finally
        {
            closeSession(session);
        }
    }

}
