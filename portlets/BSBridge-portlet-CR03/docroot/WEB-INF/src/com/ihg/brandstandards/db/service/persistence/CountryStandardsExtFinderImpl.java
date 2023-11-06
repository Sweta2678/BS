package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.custom.model.CountryList;
import com.ihg.brandstandards.db.model.CountryStandardsExt;
import com.ihg.brandstandards.db.model.impl.CountryStandardsExtImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class CountryStandardsExtFinderImpl extends BasePersistenceImpl<CountryStandardsExt> implements CountryStandardsExtFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(CountryStandardsExtFinderImpl.class);
            
	public List<CountryStandardsExt> getCountriesByStandard(long stdId) throws SystemException
	{
		List<CountryStandardsExt> arlCountries = new ArrayList<CountryStandardsExt>();
		Session session = null;
		String query = "select cs.std_id, cs.ctry_nm_cd, br.rgn_id, br.rgn_cd, br.rgn_nm from "+
					" brndstnd_rgn br, brndstnd_ctry bc, ctry_std cs where "+
					" cs.ctry_nm_cd = bc.ctry_nm_cd and "+
					" bc.rgn_id = br.rgn_id and " +
					" cs.std_id = "+stdId;
		
		try
		{
			
			session = openSession();
	    	
			SQLQuery q = session.createSQLQuery(query);
			q.addEntity("CountryStandardsExt", CountryStandardsExtImpl.class);
			arlCountries = q.list();
		}
		catch(Exception e)
		{
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
		return arlCountries;
	}
	
	public List<Object> getRegionsCountryCount(long stdId) 
	{
		List<Object> results = null;
		Session session = null;
		String query = "select br.rgn_cd as rgn_cd, count(cs.ctry_nm_cd) as countries " 
		+ " from ctry_std cs, brndstnd_ctry bc, brndstnd_rgn br "  
		+ " where std_id = " + stdId + " and cs.ctry_nm_cd = bc.ctry_nm_cd and bc.rgn_id = br.rgn_id group by br.rgn_cd";
		
		try
		{
			session = openSession();
			SQLQuery q = session.createSQLQuery(query);
			results = q.list();
		}
		catch(Exception e)
		{
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
		return results;
	}
}
