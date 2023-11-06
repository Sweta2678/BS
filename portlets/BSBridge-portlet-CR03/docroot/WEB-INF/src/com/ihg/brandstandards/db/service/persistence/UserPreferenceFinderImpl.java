package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.UserPreference;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class UserPreferenceFinderImpl extends BasePersistenceImpl<UserPreference> implements UserPreferenceFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferenceFinderImpl.class);
    private static final String ENV_PROPERTY_NAME = "app.environment.type";

    public long getUserPreferencePK()
    {
        long userPreferenceId = 0;
        Session session = null;

        List<UserPreference> arlUserPreference = new ArrayList<UserPreference>();
        UserPreference userPref = null;
        try
        {
            String query = "select PUBLISH_USR_PREF_ID_SEQ.nextval as PREF_ID from dual";
            //" , USR_ID,LOCALE_CD, BUIL_TYP, CHAIN_CD, RPT_TYP, rpt_paper_size, ITEMS_PER_PAGE," +
            //" INFO_DISP, UNSUBSCRIBE_CMT_EML, CTRY_NM_CD, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS, PDF_LOCALE_CD, MODULE_NM
            //        " from dual";
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            // q.addEntity("UserPreference", UserPreferenceImpl.class);
            List arlUserPref = q.list();
            // userPref = (UserPreference)arlUserPreference.get(0);
            // userPreferenceId = userPref.getPreferenceId();
            for (int i = 0; i < arlUserPref.size(); i++)
            {
                BigDecimal bd = (BigDecimal) arlUserPref.get(i);
                userPreferenceId = bd.longValue();
            }
            LOG.debug("the value of preference Id in userpreferencefinderimpl is " + userPreferenceId);

        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            closeSession(session);
        }
        return userPreferenceId;
    }
}
