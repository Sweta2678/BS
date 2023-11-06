/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.model.impl.WorkflowImpl;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.WorkflowLocalServiceBaseImpl;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the workflow local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.WorkflowLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.WorkflowLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil
 */
public class WorkflowLocalServiceImpl extends WorkflowLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil} to access the workflow local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(WorkflowLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            workflowPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public Workflow getWorkflowObject(){
        return new WorkflowImpl();
    }
    
    @SuppressWarnings("unchecked")
    public List<Workflow> getLogByObjectId(long objectId) throws SystemException
    {
        List<Workflow> arlLogs = new ArrayList<Workflow>();
        try
        {
            LOG.debug("value of object id in WorkflowLocalServiceImpl is " + objectId);
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            Criterion objCriterion = RestrictionsFactoryUtil.eq("objectId", objectId);
            dynamicQuery.add(objCriterion);

            // To order data
            final Order defaultOrder = OrderFactoryUtil.asc("updatedDate");
            dynamicQuery.addOrder(defaultOrder);
            arlLogs = (List<Workflow>)WorkflowLocalServiceUtil.dynamicQuery(dynamicQuery);
            LOG.debug("THe size of logs list in WorkflowLocalServiceImpl is " + arlLogs.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlLogs;
    }

    @SuppressWarnings("unchecked")
    public List<Workflow> getLogBySTDObjectId(long objectId) throws SystemException
    {
        List<Workflow> arlLogs = new ArrayList<Workflow>();
        try
        {
            LOG.debug("value of object id in WorkflowLocalServiceImpl is " + objectId);
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            Criterion objCriterion = RestrictionsFactoryUtil.eq("objectId", objectId);
            dynamicQuery.add(objCriterion);

            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STANDARDS_TRANSLATE_OBJ_TYPE));
            dynamicQuery.add(disjunction);

            // To order data
            final Order defaultOrder = OrderFactoryUtil.asc("updatedDate");
            dynamicQuery.addOrder(defaultOrder);
            arlLogs = (List<Workflow>)WorkflowLocalServiceUtil.dynamicQuery(dynamicQuery);
            LOG.debug("THe size of logs list in WorkflowLocalServiceImpl is " + arlLogs.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlLogs;
    }

    /**
     * Fetch last audit log entry.
     * 
     * @param stdId standard id
     * @return Workflow
     */
    @SuppressWarnings("unchecked")
    public Workflow getLastLogBySTDObjectId(long stdId) throws SystemException
    {
        List<Workflow> arlLogs = new ArrayList<Workflow>();
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dqSub = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            Disjunction dsjSub = RestrictionsFactoryUtil.disjunction();
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            dqSub.add(dsjSub);
            dqSub.add(RestrictionsFactoryUtil.eq("objectId", stdId));
            dqSub.setProjection(ProjectionFactoryUtil.max("createdDate"));

            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            Criterion objCriterion = RestrictionsFactoryUtil.eq("objectId", stdId);
            dynamicQuery.add(objCriterion);
            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            dynamicQuery.add(disjunction);
            dynamicQuery.add(PropertyFactoryUtil.forName("createdDate").eq(dqSub));

            arlLogs = (List<Workflow>)WorkflowLocalServiceUtil.dynamicQuery(dynamicQuery);
            LOG.debug("THe size of logs list in WorkflowLocalServiceImpl is " + arlLogs.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        Workflow wrkfl = (arlLogs != null && !arlLogs.isEmpty()) ? arlLogs.get(0) : null;
        return wrkfl;
    }

    /**
     * Fetch last audit log entry.
     * 
     * @param stdId standard id
     * @param brandCd Brand
     * @return Workflow
     */
    @SuppressWarnings("unchecked")
    public Workflow getLastLogBySTDObjectId(long stdId, String brandCd) throws SystemException
    {
        List<Workflow> arlLogs = new ArrayList<Workflow>();
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dqSub = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            Disjunction dsjSub = RestrictionsFactoryUtil.disjunction();
            dqSub.add(RestrictionsFactoryUtil.eq("objectId", stdId));
            dqSub.add(RestrictionsFactoryUtil.eq("chainCode", brandCd));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            dqSub.add(dsjSub);
            dqSub.setProjection(ProjectionFactoryUtil.max("createdDate"));

            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            dynamicQuery.add(RestrictionsFactoryUtil.eq("objectId", stdId));
            dynamicQuery.add(RestrictionsFactoryUtil.eq("chainCode", brandCd));
            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            dynamicQuery.add(disjunction);
            dynamicQuery.add(PropertyFactoryUtil.forName("createdDate").eq(dqSub));

            arlLogs = (List<Workflow>)WorkflowLocalServiceUtil.dynamicQuery(dynamicQuery);
            LOG.debug("THe size of logs list in WorkflowLocalServiceImpl is " + arlLogs.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        Workflow wrkfl = (arlLogs != null && !arlLogs.isEmpty()) ? arlLogs.get(0) : null;
        return wrkfl;
    }

    /**
     * Fetch last audit log entry.
     * 
     * @param stdId standard id
     * @param brandCd Brand
     * @return Workflow
     */
    @SuppressWarnings("unchecked")
    public List<Workflow> getLastLogByStdIdBrand(long stdId, Collection<Object> brandCd) throws SystemException
    {
        List<Workflow> arlLogs = new ArrayList<Workflow>();
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dqSub = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            Disjunction dsjSub = RestrictionsFactoryUtil.disjunction();
            dqSub.add(RestrictionsFactoryUtil.eq("objectId", stdId));
            dqSub.add(PropertyFactoryUtil.forName("chainCode").in(brandCd));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            dsjSub.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            dqSub.add(dsjSub);
            dqSub.setProjection(ProjectionFactoryUtil.max("createdDate"));

            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workflow.class, portletClassLoader);
            dynamicQuery.add(RestrictionsFactoryUtil.eq("objectId", stdId));
            dynamicQuery.add(PropertyFactoryUtil.forName("chainCode").in(brandCd));
            //            dynamicQuery.add(RestrictionsFactoryUtil.eq("chainCode", brandCd));
            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_STANDARD));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_SPEC));
            disjunction.add(RestrictionsFactoryUtil.eq("objectType", BSCommonConstants.STD_TYPE_GDLN));
            dynamicQuery.add(disjunction);
            dynamicQuery.add(PropertyFactoryUtil.forName("createdDate").eq(dqSub));

            arlLogs = (List<Workflow>)WorkflowLocalServiceUtil.dynamicQuery(dynamicQuery);
            LOG.debug("THe size of logs list in WorkflowLocalServiceImpl is " + arlLogs.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlLogs;
    }
}