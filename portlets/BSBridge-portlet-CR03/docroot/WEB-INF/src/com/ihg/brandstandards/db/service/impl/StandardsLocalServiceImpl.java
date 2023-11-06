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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.TaxonomyStandards;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.StandardsLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
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
 * The implementation of the standards local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsLocalServiceUtil
 */
public class StandardsLocalServiceImpl extends StandardsLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsLocalServiceUtil} to access the standards local service.
     */private static final Log LOG = LogFactoryUtil.getLog(StandardsLocalServiceImpl.class);

    private static final String RECORD_TYPE = "stdTyp";
    private static final String RECORD_TYPE_STD = "STD";
    private static final String RECORD_TYPE_SPEC = "SPEC";
    private static final String RECORD_TYPE_GDLN = "GDLN";
    private static final String STATUS = "status";

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsLocalServiceUtil} to access the standards local service.
     */

    public void clearCache()
    {
        try
        {
            standardsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    /**
     * Fetch Standards
     * 
     * @param approverFlag
     * @return List of Standards
     */
    public List<Standards> getStandards(final boolean approverFlag, final String brandCode, final String discontFilter)
            throws SystemException
    {
        return standardsFinder.getStdsByBrand(0, brandCode, RECORD_TYPE_STD, false, discontFilter);
    }

    /**
     * Fetch Specifications for the Standard
     * 
     * @return List of Specifications
     */
    public List<Standards> getSpecifications(final long standardsId, final boolean approverFlag, final String brandCode,
            final String discontFilter) throws SystemException
    {
        return getSpecifications(standardsId, false, brandCode, false, discontFilter);
    }

    /**
     * 
     * @param standardsId
     * @param approverFlag
     * @param brandCode
     * @param fetchAll
     * @return
     * @throws SystemException
     */
    public List<Standards> getSpecifications(final long standardsId, final boolean approverFlag, final String brandCode,
            final boolean fetchAll, final String discontFilter) throws SystemException
    {
        return standardsFinder.getStdsByBrand(standardsId, brandCode, RECORD_TYPE_SPEC, fetchAll, discontFilter);
    }

    /**
     * Fetch Guidelines for the Standard
     * 
     * @return List of Guidelines
     */
    public List<Standards> getGuidelines(final long standardsId, final boolean approverFlag, final String brandCode,
            final String discontFilter) throws SystemException
    {
        return getGuidelines(standardsId, false, brandCode, false, discontFilter);
    }

    /**
     * 
     * @param standardsId
     * @param approverFlag
     * @param brandCode
     * @param fetchAll
     * @return
     * @throws SystemException
     */
    public List<Standards> getGuidelines(final long standardsId, final boolean approverFlag, final String brandCode,
            final boolean fetchAll, final String discontFilter) throws SystemException
    {
        return standardsFinder.getStdsByBrand(standardsId, brandCode, RECORD_TYPE_GDLN, fetchAll, discontFilter);
    }

    /**
     * Fetch records count by record type
     * 
     * @return count of records
     */
    public long getStdTypeCount(final String typ) throws SystemException
    {
        long rec = 0;
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader);
            Criterion delCriterion = RestrictionsFactoryUtil.ne(STATUS, "DELETED");
            Criterion criterion = RestrictionsFactoryUtil.eq(RECORD_TYPE, typ);
            dynamicQuery.add(criterion);
            dynamicQuery.add(delCriterion);

            rec = StandardsLocalServiceUtil.dynamicQueryCount(dynamicQuery);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return rec;
    }

    /**
     * Count specified record type for approver
     * 
     * @return count
     */
    public int getStdTypeCount(final String typ, final boolean approver) throws SystemException
    {
        int count = 0;
        try
        {
            count = getStdTypeList(typ, approver).size();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return count;
    }

    /**
     * Fetch records by record type
     * 
     * @return List of records
     */
    public List<Standards> getStdTypeList(final String typ) throws SystemException
    {
        return getStdTypeList(typ, false);
    }

    /**
     * Fetch records by record type for approver
     * 
     * @return List of records
     */
    public List<Standards> getStdTypeList(final String typ, final boolean approver) throws SystemException
    {
        List<Standards> arlStdTyp;
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader);
            Criterion delCriterion = RestrictionsFactoryUtil.ne(STATUS, "DELETED");
            Criterion criterion = RestrictionsFactoryUtil.eq(RECORD_TYPE, typ);
            dynamicQuery.add(criterion);
            dynamicQuery.add(delCriterion);

            arlStdTyp = StandardsLocalServiceUtil.dynamicQuery(dynamicQuery);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStdTyp = new ArrayList<Standards>();
        }
        return arlStdTyp;
    }

    /**
     * Fetch Standards for the filter
     * 
     * @return List of Standards
     */
    public List<Standards> getStandardsAdvancedFilterResults(final Map<String, ?> criteriaMap, final boolean approverFlag,
            final String standardId, final String stdType, final String preferBrand, final String discontFilter)
    {
        List<Standards> arlStandards;

        try
        {
            arlStandards = standardsFinder.getStandardsAdvancedFilterResults(criteriaMap, approverFlag, standardId, stdType,
                    preferBrand, discontFilter);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<Standards>();
        }
        return arlStandards;
    }

    /**
     * Fetch Specifications for the filter
     * 
     * @return List of Specifications
     */
    public List<Standards> getSpecificationsFilterResults(final Map<String, ?> criteriaMap, final boolean approverFlag,
            final String standardId, final String stdType, final String preferBrand, final String discontFilter, List<Long> prntStdIds)
            throws SystemException
    {
        final List<Standards> arlStandards = new ArrayList<Standards>();
        try
        {
            final List<Standards> arlSpecifications = standardsFinder.getStandardsAdvancedFilterResults(criteriaMap,
                    approverFlag, standardId, stdType, preferBrand, discontFilter);
            
            List<Long> missingStdIdList = new ArrayList<Long>();
            
            for (Standards standards : arlSpecifications)
            {
                final long standardsId = standards.getParentId();
                if (!prntStdIds.contains(standardsId))
                {
                    missingStdIdList.add(standardsId);
                    prntStdIds.add(standardsId);
                }
             }
            
            if (!missingStdIdList.isEmpty())
            {
                List<Standards> prntRecs = standardsFinder.getStandardsByStdId(missingStdIdList, preferBrand, discontFilter);
                arlStandards.addAll(prntRecs);
            }
            
            LOG.debug("The size of arraylist in local service impl os standards specifications list is " + arlStandards.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlStandards;

    }

    /**
     * Fetch Guidelines for the filter
     * 
     * @return List of Guidelines
     */
    public List<Standards> getGuidelinesFilterResults(final Map<String, ?> criteriaMap, final boolean approverFlag,
            final String standardId, final String stdType, final String preferBrand, final String discontFilter, List<Long> prntStdIds)
            throws SystemException
    {
        final List<Standards> arlStandards = new ArrayList<Standards>();
        try
        {
            final List<Standards> arlGuidelines = standardsFinder.getStandardsAdvancedFilterResults(criteriaMap,
                    approverFlag, standardId, stdType, preferBrand, discontFilter);

            List<Long> missingStdIdList = new ArrayList<Long>();
            
            for (Standards standards : arlGuidelines)
            {
                final long standardsId = standards.getParentId();
                if (!prntStdIds.contains(standardsId))
                {
                    missingStdIdList.add(standardsId);
                    prntStdIds.add(standardsId);
                }
            }

            if (!missingStdIdList.isEmpty())
            {
                List<Standards> prntRecs = standardsFinder.getStandardsByStdId(missingStdIdList, preferBrand, discontFilter);
                arlStandards.addAll(prntRecs);
            }

            LOG.debug("The size of arraylist in local service impl os standards specifications list is " + arlStandards.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlStandards;

    }

    /**
     * Fetch Specifications for the filter
     * 
     * @return List of Specifications
     */
    public List<Standards> getSearchSpecificationsFilterResults(final Map<String, ?> criteriaMap, final boolean approverFlag,
            final String standardId, final String stdType, final String preferBrand, final String discontFilter)
            throws SystemException
    {
        List<Standards> arlStandards;
        try
        {
            arlStandards = standardsFinder.getStandardsAdvancedFilterResults(criteriaMap, approverFlag, standardId, stdType,
                    preferBrand, discontFilter);

            LOG.debug("The size of arraylist in local service impl os standards specifications list is " + arlStandards.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<Standards>();
        }
        return arlStandards;

    }

    /**
     * Fetch Guidelines for the filter
     * 
     * @return List of Guidelines
     */
    public List<Standards> getSearchGuidelinesFilterResults(final Map<String, ?> criteriaMap, final boolean approverFlag,
            final String standardId, final String stdType, final String preferBrand, final String discontFitler)
            throws SystemException
    {
        List<Standards> arlStandards;
        try
        {
            arlStandards = standardsFinder.getStandardsAdvancedFilterResults(criteriaMap, approverFlag, standardId, stdType,
                    preferBrand, discontFitler);

            LOG.debug("The size of arraylist in local service impl os standards specifications list is " + arlStandards.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<Standards>();
        }
        return arlStandards;

    }

    /**
     * Fetch Standards
     * 
     * @return List of Specifications
     */
    public List<Standards> getStandardsByTaxonomyId(long taxonomyId) throws SystemException
    {
        List<Standards> standards = Collections.emptyList();
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dq0 = DynamicQueryFactoryUtil.forClass(TaxonomyStandards.class, portletClassLoader)
                .setProjection(ProjectionFactoryUtil.property("stdId"))
                .add(PropertyFactoryUtil.forName("taxId").eq(new Long(taxonomyId)));
        DynamicQuery dq1 = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader)
                .add(PropertyFactoryUtil.forName("status").ne("DELETED")).add(PropertyFactoryUtil.forName("stdId").in(dq0))
                .addOrder(OrderFactoryUtil.asc("orderNumber"));
        try
        {
            standards = StandardsLocalServiceUtil.dynamicQuery(dq1);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        //LOG.debug("StandardsLocalServiceImpl.getStandardsByTaxonomyId");
        return standards;
    }

    /**
     * 
     * @param stdId
     * @param regionCode
     * @param brands
     * @return
     * @throws SystemException
     */
    public List<Standards> getSTD(long stdId, String regionCode, String[] brands) throws SystemException
    {
        return standardsFinder.findByStandardId(stdId, regionCode, brands);
    }

    /**
     * 
     * @param stdId
     * @return
     */
    public List<Standards> getCrossStandards(long stdId)
    {
        try
        {
            return standardsFinder.getStandards(stdId);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return Collections.emptyList();
    }

    /**
     * Get Standards by Standard Id and Record Type
     * 
     * @param stdId
     * @param guideLine
     * @return
     */
    public List<Standards> getStandardsByStdIdRecordType(long stdId, String recordType)
    {
        List<Standards> standards = Collections.emptyList();
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader)
                .add(PropertyFactoryUtil.forName("parentId").eq(new Long(stdId)))
                .add(PropertyFactoryUtil.forName("stdTyp").eq(recordType));
        Order defaultOrder = OrderFactoryUtil.asc("orderNumber");
        Order secondOrder = OrderFactoryUtil.asc("stdId");
        dq.addOrder(defaultOrder);
        dq.addOrder(secondOrder);
        try
        {
            standards = StandardsLocalServiceUtil.dynamicQuery(dq);
        }
        catch (SystemException e)
        {
            LOG.error("System Exception in getting specifications and guidelines", e);
        }
        return standards;
    }

    /**
     * Set Standards status to unlock
     * 
     * @exception SystemException exception
     */
    public void setStandardsStatusUnlock(String chainCode) throws SystemException
    {
        /*String sql = "UPDATE std SET stat_desc = '" + BSCommonConstants.AVAILABLE_STATUS + "' WHERE stat_desc = '"
                + BSCommonConstants.PUBLISH_LOCK_STATUS + "' ";
        LOG.debug("Unlock records query: " + sql);
        try
        {
            runSQL(sql);
        }
        catch (SystemException e)
        {
            LOG.error("Fail to unlock records", e);
            throw new SystemException(e);
        }*/
        standardsFinder.setStandardsStatusUnlock(chainCode);
    }

    /**
     * Get Locked Standards count
     * 
     * @return count
     */
    public long getLockedStandardsCount(String chainCode)
    {
        return standardsFinder.getLockedStandardsCount(chainCode);
    }

    /**
     * Find Standards by Author Name.
     * 
     * @param authorName author name
     */
    public List<Standards> getStandardsByAuthor(String authorName) throws SystemException
    {
        List<Standards> standards = Collections.emptyList();
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader);
        Criterion authorCriterion = RestrictionsFactoryUtil.ilike("author", "%" + authorName + "%");
        dynamicQuery.add(authorCriterion);
        LOG.debug(" Query is " + dynamicQuery.toString());
        try
        {
            standards = (List<Standards>) StandardsLocalServiceUtil.dynamicQuery(dynamicQuery);
        }
        catch (SystemException e)
        {
            LOG.error("System Exception in getting specifications and guidelines", e);
        }
        return standards;
    }

    /**
     * Find Standards by Owner Name.
     * 
     * @param ownerName owner name
     */
    public List<Standards> getStandardsByOwner(String ownerName) throws SystemException
    {
        return standardsPersistence.findByBusinessOwner(ownerName);
    }
    
    public List<Standards> getStandardsByParent(long stdId) throws SystemException
    {
    	List<Standards> arlStandards = new ArrayList<Standards>();
    	try
    	{
    	    ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader);
            Criterion stdCriterion = RestrictionsFactoryUtil.eq("parentId", stdId);
            Criterion statusCriterion = RestrictionsFactoryUtil.ne("status", "DELETED");
            dynamicQuery.add(stdCriterion);
            dynamicQuery.add(statusCriterion);
            arlStandards = StandardsLocalServiceUtil.dynamicQuery(dynamicQuery);
    	}
    	catch(Exception e)
    	{
    		  LOG.error("System Exception in getting specifications and guidelines", e);
    	}
    	return arlStandards;
    }
    
    public List<Long> getStandardsByRegion(long regionId) throws SystemException
    {
    	List<Long> arlStandardIds = new ArrayList<Long>();
    	List<Standards> arlStandards = new ArrayList<Standards>();
    	long globalRegionId = 1;
    	ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader);
    	Criterion stdCriterion = RestrictionsFactoryUtil.eq("regionId", regionId);				// criterion added to get regional standards
    	Criterion gblCriterion = RestrictionsFactoryUtil.eq("regionId", globalRegionId);						// criterion added to get global standards 
    	Criterion rgnOrCriterion = RestrictionsFactoryUtil.or(stdCriterion, gblCriterion);		// or criterion to get regional or global standards
    	Criterion statusCriterion = RestrictionsFactoryUtil.ne("status", "DELETED");
        dynamicQuery.add(rgnOrCriterion);
        dynamicQuery.add(statusCriterion);
        arlStandards = StandardsLocalServiceUtil.dynamicQuery(dynamicQuery);
        
        for(Standards globalPublish: arlStandards)
        {
        	arlStandardIds.add(globalPublish.getStdId());
        }
    	
    	return arlStandardIds;
    }
    
    /**
     * Find Spec/GDLN by Parent stdId.
     * @param stdId
     */
    public List<Standards> getByParentId(long stdId) throws SystemException
    {
        return standardsPersistence.findByParentId(stdId);
    }
    
    /**
     * Find standards by region code and parent id.
     * @param regionCode
     * @param prnt_std_id
     * @return List<Standards>
     * @throws SystemException
     */
    public List<Standards> getByRegionCodeAndParentId (String regionCode, long prnt_std_id) throws SystemException {
    	return standardsPersistence.findByregionCodeAndParentId(regionCode, prnt_std_id);
    }
    
    public void unLockRecords(String stdIds, String chainCode) throws SystemException
    {
        standardsFinder.unLockRecords(stdIds, chainCode);
    }
    
    public void lockRecords(String stdIds, String chainCode) throws SystemException
    {
        standardsFinder.lockRecords(stdIds, chainCode);
    }
    
    /**
     * 
     * @param stdId
     * @param regionId
     * @param chainCode
     * @return List<Standards>
     */
    public List<Standards> getStandardsByChainAndRegion (long stdId, long regionId, String regionCode, String chainCode, String stdType) {
    	return standardsFinder.getStandardsByChainAndRegion(stdId, regionId, regionCode, chainCode, stdType);
    }
    
    /**
     * This method will return the counter result of query (Ex:SELECT MAX(std_id) FROM STD)
     * @param query
     * @return
     */
    public long getTableSequenceEntryCount(String query) {
    	return standardsFinder.getTableSequenceEntryCount(query);
    }

    /**
     * Get active Bridge Publish Ids for specified standard id.
     * @param stdId standard id
     * @return String
     */
    public List<Long> getBridgePublishIdsByStdId(long stdId) throws SystemException
    {
        return bridgePublishFinder.getBridgePublishIdsByStdId(stdId);
    }
}
