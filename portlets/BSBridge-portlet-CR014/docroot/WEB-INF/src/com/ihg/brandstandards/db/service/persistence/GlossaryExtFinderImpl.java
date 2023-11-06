package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.GlossaryExt;
import com.ihg.brandstandards.db.model.impl.GlossaryExtImpl;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class GlossaryExtFinderImpl extends BasePersistenceImpl<GlossaryExt> implements GlossaryExtFinder 
{
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryExtFinderImpl.class);
	 /**
     * Method gives list of glossary Exts object by passing Brandcode and visible char as parameter.
     * 
     * @param brandCode User selected Brand code.
     * @param visibleChar Selected char passed as starting char to get glossary.
     * 
     * @return {@link List} Returns List of GlossaryExt object.
     */
	public List<GlossaryExt> getGlossaryByBrandCodeAndVisibleChar(String brandCode, String visibleChar)
    {
        String query = "select unique(gls.glossary_id), gls.glossary_term_txt, gls.actv_ind, gls.glossary_term_desc, grn2.regions, grn2.chains" +
        			" from glossary gls, glossary_rgn_nav grn, " +
        			" (SELECT GLSRN.GLOSSARY_ID, LISTAGG(RGN.RGN_NM, ', ') WITHIN GROUP (ORDER BY GLSRN.GLOSSARY_ID) AS REGIONS, " + 
        			"  LISTAGG(GLSRN.CHAIN_CD, ', ') WITHIN GROUP (ORDER BY GLSRN.GLOSSARY_ID) AS CHAINS FROM GLOSSARY_RGN_NAV GLSRN, BRNDSTND_RGN RGN WHERE RGN.RGN_ID= GLSRN.RGN_ID  GROUP BY GLOSSARY_ID) grn2 " +
        			" where grn.glossary_id = gls.glossary_id and grn.glossary_id = grn2.glossary_id ";
        
        			//Brand code is Global and visible char is All
        			if (!BSCommonConstants.ALL_BRAND.equalsIgnoreCase(brandCode))
        			{
        				query += " and grn.chain_cd = ? ";
        			} 
        			if (!visibleChar.equals("ALL"))
        			{
        				query+= " and grn.navigation_item_txt = ?";
        			}
        			query +=" group by (gls.glossary_id,gls.glossary_term_txt, gls.actv_ind, gls.glossary_term_desc, grn2.regions, grn2.chains) order by gls.glossary_term_txt";

		Session session = null;
		List<GlossaryExt> list = new ArrayList<GlossaryExt>();
        try
        {
            session = openSession();
        	SQLQuery q = session.createSQLQuery(query.toString());
        	q.setCacheable(false);
        	q.addEntity("GlossaryExt", GlossaryExtImpl.class);
        	
        	QueryPos qPos = QueryPos.getInstance(q);
            
        	if (!BSCommonConstants.ALL_BRAND.equalsIgnoreCase(brandCode))
        	{
        		qPos.add(brandCode);
    		} 
    		if (!visibleChar.equals("ALL"))
    		{
    			qPos.add(visibleChar.toUpperCase());
    		}
          
    		list = (List<GlossaryExt>) q.list(); 
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
