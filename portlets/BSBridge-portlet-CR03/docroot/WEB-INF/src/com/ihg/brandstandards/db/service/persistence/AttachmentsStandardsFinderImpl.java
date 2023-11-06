/**
 * 
 */
package com.ihg.brandstandards.db.service.persistence;

import java.util.List;

import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.impl.AttachmentsStandardsImpl;
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
public class AttachmentsStandardsFinderImpl extends BasePersistenceImpl<AttachmentsStandards> implements AttachmentsStandardsFinder 
{
	private static final Log LOG = LogFactoryUtil.getLog(AttachmentsStandardsFinderImpl.class);
	public static final String DEFUALT_LOCALE = "en_GB";
	
	/**
	 * Get Standards attachment translations by stdId, regionId and locales
	 * 
	 * @param stdId
	 * @param regionId
	 * @param secondLocales
	 * @return List of ExternalLinkStandards
	 */
	public List<AttachmentsStandards> getStandardAttachmentsByStdIdAndRgnIdAndLocale(long stdId, String regionId, List<String> secondLocales)
	{
		 	List<AttachmentsStandards>  attachmentsStandards = null;
	        Session session = null;
	        StringBuilder query = new StringBuilder();
	        try
	        {
	        	 if (Validator.isNotNull(stdId))
	             {
		            session = openSession();
		            
		            	query.append(" With lang as (select ctry_nm_cd from Brndstnd_Ctry where rgn_id in ( " );
		            	query.append(regionId);
		            	query.append(") ) ,  attach as (select STD_ATTACHEMENT_ID from Std_Attachment where std_id = ");
		            	query.append(stdId); 
		            	query.append(" and locale_cd in ('").append(DEFUALT_LOCALE).append("')), ");
		            	query.append(" translation as (select  distinct a.STD_ATTACHEMENT_ID from attach a, Std_Attachment_Ctry b ");
		                query.append(" where a.STD_ATTACHEMENT_ID = b.STD_ATTACHEMENT_ID and b.ctry_nm_cd in (select ctry_nm_cd from lang)) " ); 
		                query.append(" (select * from Std_Attachment where PRNT_STD_ATTACHMENT_ID in (select STD_ATTACHEMENT_ID from translation) " );
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
		                    LOG.debug("query for related attachments ::" + query.toString());
		                }
		            SQLQuery q = session.createSQLQuery(query.toString());
		            q.addEntity("AttachmentsStandards", AttachmentsStandardsImpl.class);
		            q.setCacheable(false);
		            attachmentsStandards = (List<AttachmentsStandards>) q.list();
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
	        return attachmentsStandards;
	}
	
}
