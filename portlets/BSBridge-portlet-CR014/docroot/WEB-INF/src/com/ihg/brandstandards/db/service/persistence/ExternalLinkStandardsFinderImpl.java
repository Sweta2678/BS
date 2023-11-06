/**
 * 
 */
package com.ihg.brandstandards.db.service.persistence;

import java.util.List;

import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author krunalm.patel
 *
 */
public class ExternalLinkStandardsFinderImpl extends BasePersistenceImpl<ExternalLinkStandards> implements ExternalLinkStandardsFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(ExternalLinkStandardsFinderImpl.class);
	public static final String DEFUALT_LOCALE = "en_GB";
	
	/**
	 * Get External Link translations by stdId, regionId and locales
	 * 
	 * @param stdId
	 * @param regionId
	 * @param secondLocales
	 * @return List of ExternalLinkStandards
	 */
	public List<ExternalLinkStandards> getExtLinkStandardsByStdIdAndRgnIdAndLocale(long stdId, String regionId, List<String> secondLocales)
	{
		 	List<ExternalLinkStandards>  externalLinkStandards = null;
	        Session session = null;
	        StringBuilder query = new StringBuilder();
	        try
	        {
	        	 if (Validator.isNotNull(stdId))
	             {
		            session = openSession();
		            
		            	query.append(" With lang as (select ctry_nm_cd from Brndstnd_Ctry where rgn_id in ( " );
		            	query.append(regionId);
		            	query.append(") ) ,  extlink as (select std_extl_link_id from Std_Extl_Link where std_id = ");
		            	query.append(stdId); 
		            	query.append(" and locale_cd in ('").append(DEFUALT_LOCALE).append("')), ");
		            	query.append(" translation as (select  distinct a.std_extl_link_id from extlink a, Std_Link_Ctry b ");
		                query.append(" where a.std_extl_link_id = b.std_extl_link_id and b.ctry_nm_cd in (select ctry_nm_cd from lang)) " ); 
		                query.append(" (select * from std_extl_link where PRNT_STD_EXTL_LINK_ID in (select std_extl_link_id from translation) " );
		                query.append(" and locale_cd in  ( ");
		            
		                int i = 0;
		                for (String locale : secondLocales)
		                {
		                    if (i > 0)
		                    {
		                        query.append(",");
		                    }
		                    query.append("'" + locale + "'");
		                    i++;
		                }
		                query.append(" )) ");
		                if (LOG.isDebugEnabled())
		                {
		                    LOG.debug("query for related links ::" + query.toString());
		                }
		            SQLQuery q = session.createSQLQuery(query.toString());
		            q.addEntity("ExternalLinkStandards", ExternalLinkStandardsImpl.class);
		            q.setCacheable(false);
		            externalLinkStandards = (List<ExternalLinkStandards>) q.list();
	             }
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
	        return externalLinkStandards;
	}

}
