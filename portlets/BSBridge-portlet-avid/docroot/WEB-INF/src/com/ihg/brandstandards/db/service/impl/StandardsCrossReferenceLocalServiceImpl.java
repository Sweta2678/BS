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

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsCrossReference;
import com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceImpl;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.StandardsCrossReferenceLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * The implementation of the standards cross reference local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsCrossReferenceLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalServiceUtil
 */
public class StandardsCrossReferenceLocalServiceImpl extends StandardsCrossReferenceLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalServiceUtil} to access the standards cross reference local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(StandardsCrossReferenceLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            standardsCrossReferencePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<Standards> getXStandardsOthers(long stdId)
    {
        List<Standards> standards = Collections.emptyList();
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dq0 = DynamicQueryFactoryUtil.forClass(StandardsCrossReference.class, portletClassLoader)
                .setProjection(ProjectionFactoryUtil.property("primaryKey.stdId"))
                .add(PropertyFactoryUtil.forName("primaryKey.xrefStdId").eq(new Long(stdId)));
        DynamicQuery dq1 = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader).add(PropertyFactoryUtil.forName("stdId").in(dq0));
        try
        {
            standards = StandardsLocalServiceUtil.dynamicQuery(dq1);
        }
        catch (SystemException e)
        {
            LOG.error("Error while fetching standards" + e.getMessage());
        }
        return standards;
    }

    public void addCrossReferences(long userId, Date currDate, long stdId, String crossRefIds)
    {
        long[] xRefIds = StringUtil.split(crossRefIds, 1L);
        StandardsCrossReference crossReference = null;
        List<StandardsCrossReference> crossReferences = Collections.emptyList();
        int order = 1;
        try
        {
            crossReferences = standardsCrossReferencePersistence.findByStdId(stdId);
        }
        catch (SystemException e1)
        {
            LOG.error("No Record Exists for edited std" + e1.getMessage());
        }
        for (long id : xRefIds)
        {
            crossReference = new StandardsCrossReferenceImpl();
            crossReference.setStdId(stdId);
            crossReference.setXrefStdId(id);
            crossReference.setCreatorId(String.valueOf(userId));
            crossReference.setCreatedDate(currDate);
            crossReference.setUpdatedBy(String.valueOf(userId));
            crossReference.setUpdatedDate(currDate);
            crossReference.setDispOrderNumber(crossReferences.size() + order++);
            try
            {
                StandardsCrossReferenceLocalServiceUtil.addStandardsCrossReference(crossReference);
            }
            catch (SystemException e)
            {
                LOG.error("Error while adding cross refereces" + e.getMessage());
            }
        }
    }

    public void deleteCrossReferences(long stdId, String crossRefIds)
    {
        long[] xRefIds = StringUtil.split(crossRefIds, 1L);
        for (long id : xRefIds)
        {
            try
            {
                StandardsCrossReferenceLocalServiceUtil.deleteStandardsCrossReference(new StandardsCrossReferencePK(stdId, id));
            }
            catch (SystemException e)
            {
                LOG.error("Error while deleting cross refereces" + e.getMessage());
            }
            catch (PortalException e)
            {
                LOG.error("Error while deleting cross refereces" + e.getMessage());
            }
        }
    }

    public void updateStdOrder(long stdId, String stdIds)
    {
        long[] xRefIds = StringUtil.split(stdIds, 1L);
        int counter = 0;
        for (long id : xRefIds)
        {
            try
            {
                StandardsCrossReference crossReference = standardsCrossReferencePersistence
                        .fetchByPrimaryKey(new StandardsCrossReferencePK(stdId, id));
                crossReference.setDispOrderNumber(++counter);
                StandardsCrossReferenceLocalServiceUtil.updateStandardsCrossReference(crossReference);
            }
            catch (SystemException e)
            {
                LOG.error("Error while deleting cross refereces" + e.getMessage());
            }
        }
    }
}