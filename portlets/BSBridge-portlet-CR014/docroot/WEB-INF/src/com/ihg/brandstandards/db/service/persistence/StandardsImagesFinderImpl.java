package com.ihg.brandstandards.db.service.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.impl.StandardsImagesImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class StandardsImagesFinderImpl extends BasePersistenceImpl<StandardsImages> implements StandardsImagesFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsImagesFinderImpl.class);
    public static final String DEFUALT_LOCALE = "en_GB";
    
    public List<String> getStandardsImagesCount(long imageId) throws SystemException
    {
        List<String> arlStandardsImagesCount = new ArrayList<String>();
        String strRS = "";
        Connection conn = null;
        try
        {
            DataSource ds = getDataSource();
            conn = ds.getConnection();

            String strQuery = "select count(si.std_id) as count,s.std_typ as std_typ from std s, std_image si where s.std_id = si.std_id and si.image_id =? group by s.std_typ ";
            PreparedStatement stmt = conn.prepareStatement(strQuery);
            stmt.setLong(1, imageId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                LOG.debug("count " + rs.getInt("count") + "std type " + rs.getString("std_typ"));
                strRS = rs.getInt("count") + "," + rs.getString("std_typ");
                arlStandardsImagesCount.add(strRS);
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
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
        return arlStandardsImagesCount;
    }
	
	/**
	 * Get Standards images translation by stdId, regionId and locales
	 * 
	 * @param stdId
	 * @param regionId
	 * @param secondLocales
	 * @return List of StandardsImages
	 */
	public List<StandardsImages> getStandardImagesByStdIdAndRgnIdAndLocale(long stdId, String regionId, List<String> secondLocales)
	{
		 	List<StandardsImages>  standardsImages = null;
	        Session session = null;
	        StringBuilder query = new StringBuilder();
	        try
	        {
	        	 if (Validator.isNotNull(stdId))
	             {
		            session = openSession();
		            
		            	query.append(" With lang as (select ctry_nm_cd from Brndstnd_Ctry where rgn_id in ( " );
		            	query.append(regionId);
		            	query.append(") ) ,  image as (select STD_IMAGE_ID from Std_image where std_id = ");
		            	query.append(stdId); 
		            	query.append(" and locale_cd in ('").append(DEFUALT_LOCALE).append("')), ");
		            	query.append(" translation as (select  distinct a.STD_IMAGE_ID from image a, Std_image_Ctry b ");
		                query.append(" where a.STD_IMAGE_ID = b.STD_IMAGE_ID and b.ctry_nm_cd in (select ctry_nm_cd from lang)) " ); 
		                query.append(" (select * from Std_image where PRNT_STD_IMAGE_ID in (select STD_IMAGE_ID from translation) " );
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
		                    LOG.debug("query for related Std Images ::" + query.toString());
		                }
		            SQLQuery q = session.createSQLQuery(query.toString());
		            q.addEntity("StandardsImages", StandardsImagesImpl.class);
		            q.setCacheable(false);
		            standardsImages = (List<StandardsImages>) q.list();
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
	        return standardsImages;
	}
}
