package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.UIElement;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class UIElementFinderImpl extends BasePersistenceImpl<UIElement> implements UIElementFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(UIElementFinderImpl.class);

    public List<Object> searchUIElement(String elementValue, String searchLanguage, String elementKey, String secondLanguage,
            String[] usedIn)
    {
        StringBuffer sqlQuery = new StringBuffer();
        List<Object> results = new ArrayList<Object>();
        Session session = null;
        try
        {
            session = openSession();
            
            sqlQuery.append("SELECT e.UI_ELEM_ID, e.UI_ELEM_KEY, e.TGT_MODULE_NM, t.LOCALE_CD, t.ELEM_VAL FROM UI_ELEM e, UI_ELEM_XLAT t WHERE");
            sqlQuery.append(" e.UI_ELEM_ID = t.UI_ELEM_ID");
            if(Validator.isNotNull(searchLanguage) || Validator.isNotNull(secondLanguage))
            {
                sqlQuery.append(" AND t.LOCALE_CD IN ('en_GB',");
            }
            if(Validator.isNotNull(searchLanguage))
            {
                sqlQuery.append("'");
                sqlQuery.append(searchLanguage);
                sqlQuery.append("'");
            }
            if(Validator.isNotNull(secondLanguage))
            {
                if(Validator.isNotNull(searchLanguage)){
                    sqlQuery.append(",");
                }
                sqlQuery.append("'");
                sqlQuery.append(secondLanguage);
                sqlQuery.append("'");
            }
            sqlQuery.append(") AND e.UI_ELEM_ID IN (");
            sqlQuery.append("SELECT e.UI_ELEM_ID FROM UI_ELEM e, UI_ELEM_XLAT t WHERE");
            sqlQuery.append(" e.UI_ELEM_ID = t.UI_ELEM_ID");

            if (Validator.isNotNull(elementValue))
            {
                sqlQuery.append(" AND t.LOCALE_CD='");
                sqlQuery.append(searchLanguage);
                sqlQuery.append("' AND t.ELEM_VAL like '%");
                sqlQuery.append(elementValue.trim().replaceAll("'", "''"));
                sqlQuery.append("%'");
            }
            if (Validator.isNotNull(elementKey))
            {
                sqlQuery.append(" AND e.UI_ELEM_KEY like '%");
                sqlQuery.append(elementKey.trim().replaceAll("'", "''"));
                sqlQuery.append("%'");
            }
            if (ArrayUtil.isNotEmpty(usedIn) && usedIn.length > 0)
            {
                sqlQuery.append(" AND (");
                int itr = 0;
                for (String module : usedIn)
                {
                    if(itr > 0)
                    {
                        sqlQuery.append(" OR "); 
                    }
                    sqlQuery.append("UPPER(e.TGT_MODULE_NM) like '%");
                    sqlQuery.append(module.trim());
                    sqlQuery.append("%' OR LOWER(e.TGT_MODULE_NM) like '%");
                    sqlQuery.append(module.trim());
                    sqlQuery.append("%'");
                    itr++;
                }
                sqlQuery.append(")");
            }
            sqlQuery.append(") ORDER BY UI_ELEM_KEY ASC");
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            results = (List<Object>) q.list();
            if (LOG.isDebugEnabled())
            {
                //LOG.debug("UI Element Search Query:" + sqlQuery + "\n Result:" + (results != null ? results.size() : "null"));
            }
        }
        catch (Exception e)
        {
            LOG.debug("UI Element Search query: " + sqlQuery);
            LOG.error(e);
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

    public List<String> getElementsKeyList(String sqlQuery){
        List<String> results = new ArrayList<String>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sqlQuery);
            results = (List<String>) q.list();
            if (LOG.isDebugEnabled())
            {
                //LOG.debug("Element Key List Query:" + sqlQuery + "\n Result:" + (results != null ? results.size() : "null"));
            }
            if (results == null)
            {
                results = new ArrayList<String>();
            }
        }
        catch (Exception e)
        {
            LOG.debug("Element Key List Query: " + sqlQuery);
            LOG.error(e);
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

    public Map<String, String> loadUIElements(String localeCode)
    {
        StringBuffer query = new StringBuffer();
        Map<String, String> bsUIElements = new LinkedHashMap<String, String>();
        Session session = null;
        try
        {
            session = openSession();
            
            query.append("SELECT * FROM ( WITH FIRST_LANG AS");
            query.append(" (SELECT E.UI_ELEM_ID, TRIM(E.UI_ELEM_KEY) AS UI_ELEM_KEY, TRIM(T.ELEM_VAL) AS ELEM_VAL FROM UI_ELEM E, UI_ELEM_XLAT T");
            query.append(" WHERE E.UI_ELEM_ID = T.UI_ELEM_ID AND T.LOCALE_CD ='en_GB'),");
            query.append(" SECOND_LANG AS (SELECT E.UI_ELEM_ID, TRIM(E.UI_ELEM_KEY) AS UI_ELEM_KEY, TRIM(T.ELEM_VAL) AS ELEM_VAL");
            query.append(" FROM UI_ELEM E, UI_ELEM_XLAT T WHERE E.UI_ELEM_ID = T.UI_ELEM_ID AND T.LOCALE_CD='");
            query.append(localeCode);
            query.append("')");
            query.append(" SELECT F.UI_ELEM_KEY, DECODE(S.ELEM_VAL, NULL, F.ELEM_VAL, S.ELEM_VAL) AS ELEM_VAL");
            query.append(" FROM FIRST_LANG F, SECOND_LANG S WHERE F.UI_ELEM_KEY = S.UI_ELEM_KEY(+))");

            SQLQuery q = session.createSQLQuery(query.toString());
            @SuppressWarnings("unchecked")
            List<Object> results = (List<Object>) q.list();
            if (results != null && results.size() > 0)
            {
                for (Object element : results)
                {
                    Object[] obj = (Object[]) element;
                    bsUIElements.put((String) obj[0], (String) obj[1]);
                }
            }
            if (LOG.isDebugEnabled())
            {
                //LOG.debug("loadUIElements Query:" + query + "\n Result:" + (results != null ? results.size() : "null"));
            }
        }
        catch (Exception e)
        {
            LOG.debug("loadUIElements query: " + query);
            LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }

        return bsUIElements;
    }

    public Map<String, String> loadUIElements(String localeCode, String moduleUsedIn)
    {
        StringBuffer query = new StringBuffer();
        Map<String, String> bsUIElements = new LinkedHashMap<String, String>();
        Session session = null;
        try
        {
            session = openSession();
                      
            query.append("SELECT * FROM ( WITH FIRST_LANG AS");
            query.append(" (SELECT E.UI_ELEM_ID, TRIM(E.UI_ELEM_KEY) AS UI_ELEM_KEY, TRIM(T.ELEM_VAL) AS ELEM_VAL FROM UI_ELEM E, UI_ELEM_XLAT T");
            query.append(" WHERE E.UI_ELEM_ID = T.UI_ELEM_ID AND T.LOCALE_CD ='en_GB'),");
            query.append(" SECOND_LANG AS (SELECT E.UI_ELEM_ID, TRIM(E.UI_ELEM_KEY) AS UI_ELEM_KEY, TRIM(T.ELEM_VAL) AS ELEM_VAL");
            query.append(" FROM UI_ELEM E, UI_ELEM_XLAT T WHERE E.UI_ELEM_ID = T.UI_ELEM_ID AND T.LOCALE_CD='");
            query.append(localeCode);
            query.append("' AND e.TGT_MODULE_NM like '%");
            query.append(moduleUsedIn);
            query.append("%')");
            query.append(" SELECT F.UI_ELEM_KEY, DECODE(S.ELEM_VAL, NULL, F.ELEM_VAL, S.ELEM_VAL) AS ELEM_VAL");
            query.append(" FROM FIRST_LANG F, SECOND_LANG S WHERE F.UI_ELEM_KEY = S.UI_ELEM_KEY(+))");

            SQLQuery q = session.createSQLQuery(query.toString());
            @SuppressWarnings("unchecked")
            List<Object> results = (List<Object>) q.list();
            if (results != null && results.size() > 0)
            {
                for (Object element : results)
                {
                    Object[] obj = (Object[]) element;
                    bsUIElements.put((String) obj[0], (String) obj[1]);
                }
            }
            if (LOG.isDebugEnabled())
            {
                //LOG.debug("loadUIElements Query:" + query + "\n Result:" + (results != null ? results.size() : "null"));
            }
        }
        catch (Exception e)
        {
            LOG.debug("loadUIElements query: " + query);
            LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return bsUIElements;
    }

    @SuppressWarnings("unchecked")
    public String loadAutoCompleteKeys(String sqlQuery){
        //String sqlQuery = "SELECT UI_ELEM_KEY FROM UI_ELEM";
        StringBuffer sb = new StringBuffer();
        List<String> results = new ArrayList<String>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sqlQuery);
            results = (List<String>) q.list();
            if (LOG.isDebugEnabled())
            {
                //LOG.debug("Auto Complete Query:" + sqlQuery + "\n Result:" + (results != null ? results.size() : "null"));
            }
            if (results != null)
            {
                for (String key : results)
                {
                    sb.append(key);
                    sb.append(",");
                }
            }
        }
        catch (Exception e)
        {
            LOG.debug("Auto Complete Query: " + sqlQuery);
            LOG.error(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return sb.toString();
    }
}
