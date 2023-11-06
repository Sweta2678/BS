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
import java.util.List;

import com.ihg.brandstandards.db.model.BusImpactAssmt;
import com.ihg.brandstandards.db.model.impl.BusImpactAssmtImpl;
import com.ihg.brandstandards.db.service.BusImpactAssmtLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.base.BusImpactAssmtLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the bus impact assmt local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.BusImpactAssmtLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BusImpactAssmtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BusImpactAssmtLocalServiceUtil
 */
public class BusImpactAssmtLocalServiceImpl extends BusImpactAssmtLocalServiceBaseImpl
{
    private static final Log LOG = LogFactoryUtil.getLog(BusImpactAssmtLocalServiceImpl.class);
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BusImpactAssmtLocalServiceUtil} to access the bus impact assmt local service.
     */
    public BusImpactAssmt getBusImpactAssmtObject(){
        return new BusImpactAssmtImpl();
    }
    
    public List<BusImpactAssmt> getBusImpactAssmtByStdId(long stdId) throws SystemException
    {
        List<BusImpactAssmt> arlBIA = new ArrayList<BusImpactAssmt>();
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(BusImpactAssmt.class, portletClassLoader);
            Criterion criterion = RestrictionsFactoryUtil.eq("stdId", stdId);

            dynamicQuery.add(criterion);

            // To order data
            final Order defaultOrder = OrderFactoryUtil.asc("busImpactAssmtId");
            dynamicQuery.addOrder(defaultOrder);
            arlBIA = BusImpactAssmtLocalServiceUtil.dynamicQuery(dynamicQuery);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlBIA = new ArrayList<BusImpactAssmt>();
        }
        return arlBIA;
    }

    public void clearCache()
    {
        try
        {
            busImpactAssmtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}