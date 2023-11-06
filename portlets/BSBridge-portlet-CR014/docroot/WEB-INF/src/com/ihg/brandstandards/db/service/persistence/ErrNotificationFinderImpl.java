package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.model.impl.ErrNotificationImpl;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

public class ErrNotificationFinderImpl extends BasePersistenceImpl<ErrNotification> implements ErrNotificationFinder 
{
    private static final Log LOG = LogFactoryUtil.getLog(ErrNotificationFinderImpl.class);
    
    public ErrNotification createErrNotificationOraSequence() throws SystemException
    {
        Session session = null;
        ErrNotification notification = null;
        try
        {
            session = openSession();
            final String query = "SELECT err_notification_id_seq.nextval AS err_notification_id, NULL component_nm, 0 ref_id, NULL severity_lvl_cd, " +
//                                 "NULL err_title_txt, NULL err_desc, NULL chain_cd, 0 publish_id, 0 rgn_id, " +
                                 "NULL err_title_txt, NULL err_desc, 'NEW' stat_cd, 0 publish_id, 0 rgn_id, " +
                                 "NULL creat_usr_id, SYSDATE creat_ts, NULL lst_updt_usr_id, SYSDATE lst_updt_ts FROM dual";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("ErrNotification", ErrNotificationImpl.class);
            @SuppressWarnings("unchecked")
            List<ErrNotification> list = (List<ErrNotification>) sqlQuery.list();
            notification = (ErrNotification) (list.get(0));
            notification.setPrimaryKey(notification.getNotificationId() );
        }
        catch (Exception e)
        {
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return notification;
    }
    
    public boolean acknowledgeNotifications(String notifcationIds){
    	Session session = null;
        boolean acknowledgeStatus = true;
        try
        {
            session = openSession();
            final String query = "UPDATE ERR_NOTIFICATION SET STAT_CD='"+BridgeConstants.QUEUE_STATUS_COMPLETE+"' WHERE ERR_NOTIFICATION_ID IN ("+notifcationIds+")";
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.executeUpdate();
        }
        catch (Exception e)
        {
        	acknowledgeStatus = false;
            LOG.error("Failed Acknowledge Notification for Ids"+notifcationIds, e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return acknowledgeStatus;
    }

    public List<ErrNotification> getUnprocessedNewNotifications(String componentName) throws SystemException
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT err_notification_id, component_nm, ref_id, severity_lvl_cd, ");
        query.append("err_title_txt, err_desc, stat_cd, publish_id, rgn_id, ");
        query.append("creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts ");
        query.append("FROM err_notification ");
        query.append("WHERE component_nm = '").append(componentName).append("' ");  
        query.append("AND stat_cd = '").append(BSCommonConstants.ERR_NOTIFICATION_STATUS_NEW).append("' ");
        query.append("AND creat_ts < (SYSTIMESTAMP - numtodsinterval(1, 'hour'))");

        Session session = null;
        List<ErrNotification> notifications = null;
        try
        {
            session = openSession();
            final SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            sqlQuery.addEntity("ErrNotification", ErrNotificationImpl.class);
            notifications = (List<ErrNotification>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return notifications;
    }
}
