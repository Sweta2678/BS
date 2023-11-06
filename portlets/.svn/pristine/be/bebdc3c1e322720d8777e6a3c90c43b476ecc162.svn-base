package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.impl.StandardsLocaleImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class StandardsLocaleFinderImpl  extends BasePersistenceImpl<StandardsLocale> implements StandardsLocaleFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(StandardsLocaleFinderImpl.class);
	
	public List<StandardsLocale> getLanguagesByRegion(String regionCode) throws SystemException
	{
		List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>();
		Session session = null;
		 try
        {
            session = openSession();
            String strQuery = "SELECT BRNDSTND_LOCALE.LOCALE_CD, BRNDSTND_LOCALE.LOCALE_NM, BRNDSTND_LOCALE.CTRY_CD, BRNDSTND_LOCALE.LANG_CD, BRNDSTND_LOCALE.DISP_ORDER_NBR, " +
            		" BRNDSTND_LOCALE.ACTV_IND, BRNDSTND_LOCALE.CREAT_USR_ID, BRNDSTND_LOCALE.CREAT_TS, BRNDSTND_LOCALE.LST_UPDT_TS, BRNDSTND_LOCALE.LST_UPDT_USR_ID " +
            		" FROM BRNDSTND_LOCALE INNER JOIN BRNDSTND_RGN_LOCALE ON BRNDSTND_LOCALE.LOCALE_CD = BRNDSTND_RGN_LOCALE.LOCALE_CD INNER JOIN BRNDSTND_RGN " +
            		" ON BRNDSTND_RGN.RGN_ID = BRNDSTND_RGN_LOCALE.RGN_ID where BRNDSTND_RGN.RGN_CD=?";
            SQLQuery q = session.createSQLQuery(strQuery);
            q.addEntity("bsLocale", StandardsLocaleImpl.class);
            QueryPos queryPos = QueryPos.getInstance(q);
            queryPos.add(regionCode);
            arlLanguages = q.list();
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
		return arlLanguages;
	}
	
	public Map<String, String> getActiveLanguages(String sqlQuery)
    {
        //String sqlQuery = "SELECT LOCALE_CD, LOCALE_NM FROM BRNDSTND_LOCALE WHERE ACTV_IND='Y' ORDER BY DISP_ORDER_NBR ASC";
        Map<String, String> activeLangs = new LinkedHashMap<String, String>();
        List<Object> results = new ArrayList<Object>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sqlQuery);
            results = (List<Object>) q.list();
            if (LOG.isDebugEnabled())
            {
                //LOG.debug("Active Language Query:" + sqlQuery + "\n Result:" + (results != null ? results : "null"));
            }
            if (results != null)
            {
                for (Object locale : results)
                {
                    Object[] obj = (Object[]) locale;
                    activeLangs.put((String) obj[0], (String) obj[1]);
                }
            }
        }
        catch (Exception e)
        {
            LOG.debug("Active Language Query: " + sqlQuery);
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return activeLangs;
    }
}
