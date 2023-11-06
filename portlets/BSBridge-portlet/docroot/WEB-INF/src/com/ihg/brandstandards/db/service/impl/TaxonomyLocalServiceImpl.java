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

import java.util.List;

import com.ihg.brandstandards.db.NoSuchTaxonomyException;
import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.TaxonomyLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.TaxonomyFinderUtil;
import com.ihg.brandstandards.db.service.persistence.TaxonomyUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the taxonomy local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.TaxonomyLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.TaxonomyLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil
 */
public class TaxonomyLocalServiceImpl extends TaxonomyLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil} to access the taxonomy local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(TaxonomyLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            taxonomyPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<Taxonomy> getTaxonomiesByCreatorId(String creatorId) throws SystemException
    {
        return TaxonomyUtil.findBycreatorId(creatorId);
    }

    public List<Taxonomy> getTaxonomiesByParentId(long parentId) throws SystemException
    {
        return TaxonomyUtil.findByparentId(parentId);
    }

    public Taxonomy getTaxonomyByTaxId(long taxId) throws SystemException, NoSuchTaxonomyException
    {
        return TaxonomyUtil.findBytaxId(taxId);
    }

    public List<Taxonomy> getTreeItems() throws SystemException
    {
        ClassLoader classLoader = com.liferay.portal.kernel.util.PortalClassLoaderUtil.getClassLoader();
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Taxonomy.class, classLoader);
        com.liferay.portal.kernel.dao.orm.Criterion crit = PropertyFactoryUtil.forName("parentId").eq(-1);
        dynamicQuery.add(crit);
        @SuppressWarnings("unchecked")
        final List<Taxonomy> taxonomies = (List<Taxonomy>) TaxonomyLocalServiceUtil.dynamicQuery(dynamicQuery);
        return taxonomies;
    }

    public Taxonomy addTaxonomy(Taxonomy newTaxonomy) throws SystemException
    {
        Taxonomy taxonomy = taxonomyPersistence.create(counterLocalService.increment(Taxonomy.class.getName()));
        taxonomy.setParentId(newTaxonomy.getParentId());
        taxonomy.setPosition(newTaxonomy.getPosition());
        taxonomy.setTitle(newTaxonomy.getTitle());
        taxonomy.setDesc(newTaxonomy.getDesc());
        taxonomy.setImageLoc(newTaxonomy.getImageLoc());
        taxonomy.setCreatedBy(newTaxonomy.getCreatedBy());
        taxonomy.setCreatorId(newTaxonomy.getCreatorId());
        taxonomy.setCreatedDate(newTaxonomy.getCreatedDate());
        taxonomy.setUpdatedBy(newTaxonomy.getUpdatedBy());
        taxonomy.setUpdatedDate(newTaxonomy.getUpdatedDate());
        return taxonomyPersistence.update(taxonomy);
    }

    public void updateTaxonomyPosition(Taxonomy taxonomyObj, Taxonomy taxonomyRef, long pos) throws SystemException
    {
        TaxonomyFinderUtil.updateTaxonomyPosition(taxonomyObj, taxonomyRef, pos);
    }

    public int getTaxonomyCountByPid(long parentId) throws SystemException
    {
        int count = 0;
        try
        {
            count = (TaxonomyLocalServiceUtil.getTaxonomiesByParentId(parentId)).size();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return count;
    }

    public List<Taxonomy> getTaxonomiesById(long Id) throws SystemException
    {
        final List<Taxonomy> taxonomies = (List<Taxonomy>) TaxonomyLocalServiceUtil.getTaxonomiesByParentId(Id);
        return taxonomies;
    }
}