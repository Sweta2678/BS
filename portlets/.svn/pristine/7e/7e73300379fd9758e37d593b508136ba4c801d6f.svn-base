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

import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.HistManualsLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.HistManualsFinderUtil;
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
 * The implementation of the hist manuals local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.HistManualsLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.HistManualsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil
 */
public class HistManualsLocalServiceImpl extends HistManualsLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil} to access the hist manuals local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(HistManualsLocalServiceImpl.class);

    public List<HistManuals> getManuals() throws SystemException
    {
        List<HistManuals> arlManuals = new ArrayList<HistManuals>();
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(HistManuals.class, portletClassLoader);
            Criterion criterion = null;
            criterion = RestrictionsFactoryUtil.ne("status", "DELETED");
            dynamicQuery.add(criterion);

            // To order data
            Order defaultOrder = OrderFactoryUtil.desc("createdDate");
            dynamicQuery.addOrder(defaultOrder);
            arlManuals = HistManualsLocalServiceUtil.dynamicQuery(dynamicQuery);
            //LOG.debug("The size of standards list in getStandards() is "+arlStandards.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlManuals;
    }

    public int getManualsCount() throws SystemException
    {
        int count = 0;
        count = getManuals().size();
        return count;
    }

    public List<HistManuals> findHistoricalManualsByFilter(List<String> brand, List<String> region, List<String> manualType)
            throws SystemException
    {
        return HistManualsFinderUtil.findHistoricalManualsByFilter(brand, region, manualType);
    }

    public void clearCache()
    {
        try
        {
            histManualsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}