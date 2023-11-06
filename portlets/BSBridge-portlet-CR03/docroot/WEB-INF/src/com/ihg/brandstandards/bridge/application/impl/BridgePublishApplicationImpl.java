package com.ihg.brandstandards.bridge.application.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.NoSuchBridgePublishException;
import com.ihg.brandstandards.db.model.BridgePublish;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.model.PublishStd;
import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.BridgePublishPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishPersistenceImpl;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsSortableUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class BridgePublishApplicationImpl 
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishApplicationImpl.class);

    public List<Standard> getMyPublishStandards(String chainCode, String regionId, String regionCode, String stdIds)
    {
        List<Standard> arlDisplayStandards = new ArrayList<Standard>();
        List<Standard> sortedStandards = null; 
        
        try
        {
            String query = BridgeQueryUtils.getMyPublicationQuery(chainCode, regionId, regionCode, stdIds);
            List<PublishStandardsExt> arlDisplayResults = BridgePublishLocalServiceUtil.getMyPublicationByBrand(chainCode, regionId, query);
            sortedStandards = StandardsSortableUtil.sort(arlDisplayStandards, arlDisplayResults);
            long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(chainCode, "BRIDGE");
            //get global must Ids
            List<Long> arlMustPublishStds = BridgeGlobalPublishLocalServiceUtil.getGlobalStandardsByPublishIdAndIndicator("Y", publishId);
			
			for(Standard std: sortedStandards)
			{
				if(arlMustPublishStds.contains(std.getStdId()))
				{
					std.setMustPublish(true);
				}
				List<Standard> arlSpecs = std.getSpecifications();
				for(Standard spec : arlSpecs)
				{
					if(arlMustPublishStds.contains(spec.getStdId()))
					{
						spec.setMustPublish(true);
					}
				}
				List<Standard> arlGdln = std.getGuidelines();
				for(Standard gdln : arlGdln)
				{
					if(arlMustPublishStds.contains(gdln.getStdId()))
					{
						gdln.setMustPublish(true);
					}
				}
			}
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        if (LOG.isDebugEnabled())
            LOG.debug("standards list size before returning to portlet is " + sortedStandards.size());
        return sortedStandards;
    }
    
    public void deleteStandards(long stdId, String regionCode, String brandCode) 
    {
    	long regionId = 0;
    	List<com.ihg.brandstandards.db.model.Standards> arlStandards = new ArrayList<com.ihg.brandstandards.db.model.Standards>();
    	List<Long> arlStandardIds = new ArrayList<Long>();
    	try
    	{
    		long bridgePublishId = PublicationLocalServiceUtil.getPublishIdByBrand(brandCode, "BRIDGE");
    		long prodPublishId = PublicationLocalServiceUtil.getPublishIdByBrand(brandCode, "PRODUCTION");
    		
    		regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
    		BridgePublish bridgePublish = BridgePublishLocalServiceUtil.getByPublishIdRegionIdAndStdId(bridgePublishId, regionId, stdId);
    		PublishStd publishStd = PublishStdLocalServiceUtil.getStandardByBrand(stdId, prodPublishId);
    		arlStandards = StandardsLocalServiceUtil.getStandardsByParent(stdId);
    		long prodStdId = publishStd.getStdId();
    		long bridgeStdId = bridgePublish.getStandardId();
    		if(!arlStandards.isEmpty())
    		{
    			for(com.ihg.brandstandards.db.model.Standards standards : arlStandards)
    			{
    				arlStandardIds.add(standards.getStdId());
    			}
    		}
    		else
    		{
    			arlStandardIds.add(stdId);
    		}
    		if(prodStdId == bridgeStdId)
    		{
    			for(long id : arlStandardIds)
    			{
    				try {
    					bridgePublish = BridgePublishLocalServiceUtil.getByPublishIdRegionIdAndStdId(bridgePublishId, regionId, id);
    				} catch (Exception e) {
    					LOG.error(e.getMessage());
    				}
    				if(bridgePublish != null)
    				{
    					BridgePublishCountryLocalServiceUtil.deleteBridgePublishCountries(bridgePublish.getBridgePublishId());
    					bridgePublish.setUnpublishInd("Y");
    					BridgePublishLocalServiceUtil.updateBridgePublish(bridgePublish);
    				}
    			}
    		}
    		else
    		{
    			for(long id : arlStandardIds)
    			{
    				try {
    					bridgePublish = BridgePublishLocalServiceUtil.getByPublishIdRegionIdAndStdId(bridgePublishId, regionId, id);
    				} catch (NoSuchBridgePublishException e) {
    					LOG.error(e);
    				} catch (SystemException e) {
    					LOG.error(e);
    				}
    				
    				if(bridgePublish != null)
    				{
    					BridgePublishLocalServiceUtil.deleteBridgePublish(bridgePublish);
    				}
    			}
    		}
    	}
    	catch(Exception e)
    	{
    	    LOG.error(e);
    	}
    }
    
    /**
     * After upload the application will validate the standard Ids against several criteria and show the status such as
     *  GLBLMST,GLBLMSTNOT, NOTRGN,NOTBRND,ORPHAN, MISSING, etc. 
     * @param stdIds
     * @param importedIds
     * @param chainCode
     * @param regionId
     * @param userId
     * @param regionCode
     */
    /*public void validateImportedStandards(List<Long> stdIds, List<Long> importedIds, String chainCode, long regionId, String userId, String regionCode)
    {
    	List<Long> arlMustPublishStds = new ArrayList<Long>();
    	List<Long> arlMustNotPublishIds = new ArrayList<Long>();
    	List<Long> arlStdsByChain = new ArrayList<Long>();
    	List<Long> arlStdsByRegion = new ArrayList<Long>();
    	List<Long> arlDiscountinuedStds = new ArrayList<Long>();
    	List<Long> arlMissingStds = new ArrayList<Long>();
    	List<Long> arlOrphanStds = new ArrayList<Long>();
    	List<PublishStandardsExt> arlUnpublishedStds = new ArrayList<PublishStandardsExt>();
    	long startTime = new Date().getTime();
    	try 
    	{
    		long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(chainCode, "BRIDGE");

    		//get missing & orphan standard ids
    		String query = BridgeQueryUtils.getMyPublicationImportFindMissingQuery(chainCode, String.valueOf(regionId), regionCode);
    		List<PublishStandardsExt> arlDisplayResults = BridgePublishLocalServiceUtil.getMyPublicationByBrand(chainCode, String.valueOf(regionId), query);
    		for (PublishStandardsExt publishStd : arlDisplayResults)
    		{
    			if (publishStd.getStatus().equals("MISSING"))
    			{
    				arlMissingStds.add(publishStd.getStdId());
    				stdIds.add(publishStd.getStdId());
    			}
    			else if (publishStd.getStatus().equals("ORPHAN") )
    			{
    				arlOrphanStds.add(publishStd.getStdId());
    			}
    		}
    		
    		//add Missing Standards in BridgePublishImport table
    		if (!arlMissingStds.isEmpty())
    		{
    			BridgePublishImportLocalServiceUtil.addBridgePublishImport(arlMissingStds, publishId, chainCode, regionId, userId);
    		}
			
    		//get global must Ids
			arlMustPublishStds = BridgeGlobalPublishLocalServiceUtil.getGlobalStandardsByPublishIdAndIndicator("Y", publishId);
			//get global must not Ids
			arlMustNotPublishIds = BridgeGlobalPublishLocalServiceUtil.getGlobalStandardsByPublishIdAndIndicator("N", publishId);
			//get standard ids by region and global 
			arlStdsByRegion = BridgePublishImportLocalServiceUtil.getStandardsByRegion(publishId, regionId);
			//get standards Ids by chain code
			arlStdsByChain = StandardsExtLocalServiceUtil.getStandardsByChain(chainCode);
			//get unpublished standard ids
			arlUnpublishedStds = BridgePublishLocalServiceUtil.getUnpublishedDetailsStandards(publishId, regionId, chainCode, regionCode);
			//get discontinued standard ids
			arlDiscountinuedStds = BridgePublishImportLocalServiceUtil.getDiscountinuedStandards(stdIds, chainCode);
			
			//get standard type and parent standard Id for all imported standardIds
			//compare each list with standard ids and update flags in the bridge publish import table
			
			if (LOG.isDebugEnabled())
			{
			     LOG.debug("publishId:" + publishId + " userId:" + userId + " chainCode:" + chainCode + " regionId:" + regionId);

	            LOG.debug("size of arlMustPublish: " + arlMustPublishStds.size() + " size of arlMustNotPublish: " + arlMustNotPublishIds.size() + 
	                        " arlStdsByRegion: " + arlStdsByRegion.size() + " arlStdsByChain: " + arlStdsByChain.size() + 
	                        " arlUnpublishedStds: " + arlUnpublishedStds.size() + " arlUnpublishedStds: " + arlDiscountinuedStds.size());
			}
			
			List<Long> mustPublish = new ArrayList<Long>();
            List<Long> mustNotPublish = new ArrayList<Long>();
            List<Long> unPublish = new ArrayList<Long>();
            List<Long> wrongBrand = new ArrayList<Long>();
            List<Long> wrongRgn = new ArrayList<Long>();
            List<Long> doPublish = new ArrayList<Long>();
            List<Long> discont = new ArrayList<Long>();
            List<Long> missing = new ArrayList<Long>();
            List<Long> orphan = new ArrayList<Long>();
			
			List<BridgePublishImport> stdImportLst = BridgePublishImportLocalServiceUtil.findByPublishIdAndRegionId(publishId, regionId);
			
			for (BridgePublishImport bridgeImport : stdImportLst)
			{
			    long stdId = bridgeImport.getStdId();
			    if (stdIds.contains(stdId))
			    {
			        boolean inRegion = arlStdsByRegion.contains(stdId);
			        
//                    LOG.info("stdId = " + stdId + " inRegion = " + inRegion + " GLBLMST = " + arlMustPublishStds.contains(stdId) + 
//                    " GLBLMSTNOT = " + arlMustNotPublishIds.contains(stdId) + " UNPUBLISH = " + arlUnpublishedStds.contains(stdId) +
//                    " NOTBRND = " + arlStdsByChain.contains(stdId));

    				if(arlMustPublishStds.contains(stdId) && inRegion)
    				{
    					bridgeImport.setStatus("GLBLMST");
    					bridgeImport.setSelectInd("Y");
    					mustPublish.add(bridgeImport.getPublishImportId());
    				}
    					//update import table
    				else if(arlMustNotPublishIds.contains(stdId) && inRegion)
    				{
    					//set status to must not publish
    					bridgeImport.setStatus("GLBLMSTNOT");
    					bridgeImport.setSelectInd("N");
    					mustNotPublish.add(bridgeImport.getPublishImportId());
    				}
    				else if(arlUnpublishedStds.contains(stdId))
    				{
    					bridgeImport.setStatus("UNPUBLISH");
    					bridgeImport.setSelectInd("N");
    					unPublish.add(bridgeImport.getPublishImportId());
    				}
    				else if(!arlStdsByChain.contains(stdId))
    				{
    					bridgeImport.setStatus("NOTBRND");
    					bridgeImport.setSelectInd("N");
    					wrongBrand.add(bridgeImport.getPublishImportId());
    				}
    				else if(!inRegion)
    				{
    					bridgeImport.setStatus("NOTRGN");
    					bridgeImport.setSelectInd("N");
    					wrongRgn.add(bridgeImport.getPublishImportId());
    				}
    				else if(arlDiscountinuedStds.contains(stdId))
    				{
    					bridgeImport.setStatus("DISCONT");
    					bridgeImport.setSelectInd("N");
    					discont.add(bridgeImport.getPublishImportId());
    				}
    				else if (arlMissingStds.contains(stdId))
    			    {
    			    	bridgeImport.setStatus("MISSING");
    					bridgeImport.setSelectInd("N");
    					missing.add(bridgeImport.getPublishImportId());
    			    }
    				else if(arlOrphanStds.contains(stdId))
    				{
    					bridgeImport.setStatus("ORPHAN");
    					bridgeImport.setSelectInd("N");
    					orphan.add(bridgeImport.getPublishImportId());
    				}
    				else
    				{
    					bridgeImport.setSelectInd("Y");
    					doPublish.add(bridgeImport.getPublishImportId());
    				}
    				
    				if (bridgeImport.getPublishImportId() > 0)
    				{
                        if (bridgeImport.getCreatorId() == null || bridgeImport.getCreatorId().isEmpty() || bridgeImport.getCreatedDate() == null)
                        {
                            bridgeImport.setCreatorId(userId);
                            bridgeImport.setCreatedDate(new Date());
                        }
                        bridgeImport.setUpdatedDate(new Date());
                        bridgeImport.setUpdatedBy(userId);
                    }
    				else 
    				{
    				    LOG.debug("Did NOT find import for stdId:" + stdId);
                    }
			    }
			}
			
            try {
                BridgePublishImportLocalServiceUtil.updateBridgePublishImport(publishId, mustPublish, mustNotPublish, unPublish, wrongBrand,
                        wrongRgn, doPublish, discont, missing, orphan);
            }
            catch (SystemException e) 
            {
                LOG.error("Failed to update PublishImport ", e);
                throw new SystemException(e);
            }

		} 
    	catch (SystemException e) 
    	{
    	    LOG.error(e);
		}
    	LOG.info("Time spent on update is " + (new Date().getTime() - startTime) + " ms");
    }*/
    
    public List<Standard> getMyPublishImportStandards(String chainCode, String regionId, String regionCode)
    {
        List<Standard> arlDisplayStandards = new ArrayList<Standard>();
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        List<Standard> sortedStandards = null; 
        
        BridgeApplicationImpl bridgeApp = new BridgeApplicationImpl();
        try
        {
            if (LOG.isDebugEnabled())
                LOG.debug("In BridgePublishApplicationImpl value of region code is " + regionId);
            
        	String query = BridgeQueryUtils.getMyPublicationImportQuery(chainCode, regionId, regionCode);
            arlDisplayResults = BridgePublishLocalServiceUtil.getMyPublicationByBrand(chainCode, regionId, query);
	        for (PublishStandardsExt publishStd : arlDisplayResults)
	        {
	            Standard standards = new Standard();
	            if (BSCommonConstants.STD_TYPE_STANDARD.equals(publishStd.getStdTyp()))
	            {
	                standards.setTaxonomyId(publishStd.getTaxonomyId());
	                standards.setTaxonomyPath(publishStd.getTaxonomyPath());
	                standards.setTaxonomyText(publishStd.getIndexTitle());
	                standards.setIndexOrder(publishStd.getIndexOrder());
	                standards.setParentTaxonomyId(publishStd.getParentTaxonomyId());
	                standards.setIndexSortOrder(publishStd.getLevelSortOrder());
	                standards.setLevel(publishStd.getIndexLvl());
	                standards.setPublishStdId(publishStd.getStdId());
	                standards.setStdId(publishStd.getStdId());
	                standards.setPubParentStdId(publishStd.getParentPublishId());
	                standards.setTitle(publishStd.getTitle());
	                standards.setDescription(publishStd.getDescription());
	                standards.setStdType(publishStd.getStdTyp());
	                standards.setStatus(publishStd.getStatus());
	                standards.setDisplayOrder(publishStd.getSortOrder());
	                standards.setFramework(publishStd.getFramework());
	                standards.setIsGlobal(publishStd.getIsGlobal());
	                standards.setRegionCode(publishStd.getRegionCode());
	                arlDisplayStandards.add(standards);
	                
	            }
	        }
	
	        bridgeApp.updateIndexOrder(arlDisplayStandards);
	       sortedStandards = bridgeApp.sortRecords(arlDisplayStandards);
	        for (Standard standards : sortedStandards)
	        {
	            List<Standard> arlSpecs = new ArrayList<Standard>();
	            List<Standard> arlGdlns = new ArrayList<Standard>();
	            for (PublishStandardsExt publishStd : arlDisplayResults)
	            {
	                if (standards.getPublishStdId() == publishStd.getParentPublishId())
	                {
	                	Standard specs = new Standard();
	                    specs.setPublishStdId(publishStd.getStdId());
	                    specs.setStdId(publishStd.getStdId());
	                    specs.setParentStdId(publishStd.getParentPublishId());
	                    specs.setTitle(publishStd.getTitle());
	                    specs.setDescription(publishStd.getDescription());
	                    specs.setStdType(publishStd.getStdTyp());
	                    specs.setStatus(publishStd.getStatus());
	                    specs.setDisplayOrder(publishStd.getSortOrder());
	                    specs.setFramework(publishStd.getFramework());
	                    specs.setIsGlobal(publishStd.getIsGlobal());
	                    specs.setRegionCode(publishStd.getRegionCode());
	                    if (BSCommonConstants.STD_TYPE_SPEC.equals(publishStd.getStdTyp()))
	                    {
	                        arlSpecs.add(specs);
	                    }
	                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(publishStd.getStdTyp()))
	                    {
	                        arlGdlns.add(specs);
	                    }
	                }
	            }
	            //Sort specifications / guidelines
	            Collections.sort(arlSpecs, new StandardsSortableUtil.StandardSortBySTDId());
	            Collections.sort(arlGdlns, new StandardsSortableUtil.StandardSortBySTDId());
	            standards.setSpecifications(arlSpecs);
	            standards.setGuidelines(arlGdlns);
	        }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        LOG.debug("standards list size before returning to portlet is "+sortedStandards.size());
        return sortedStandards;
    }
    
    public int getBridgeImportedRecordsCount(long publishId, long regionId) 
    {
    	int count = 0;
    	try
    	{
    		count = BridgePublishImportLocalServiceUtil.getBridgeImportedRecordsCount(publishId, regionId);
    	}
    	catch(SystemException e)
    	{
    	    LOG.error(e);
    	}
    	return count;
    }
	
    public void addStandardsToPublishAfterImport(String chainCode, long regionCode, long bridgePublishId, String screenName) throws SystemException
    {
    	try
    	{
            long prodPublishId = 0;
            try {
                Publication prodPublish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, BridgeConstants.PRODUCTION_ENVIRONMENT, chainCode);
                prodPublishId = prodPublish.getPublishId();
            } 
            catch (Exception e)
            {
                prodPublishId = 0;             
            }

    		boolean flag = BridgePublishLocalServiceUtil.updateBridgePublishAndCountryFromImport(bridgePublishId, prodPublishId, chainCode, regionCode, screenName );
    		if(flag == true)
    		{
    			BridgePublishImportLocalServiceUtil.deleteBridgeImportByPublishIdAndRegionId(bridgePublishId, regionCode);
    		}
    	}
    	catch(SystemException se)
    	{
    		LOG.error(se);
            throw new SystemException(se);
    	}
    	catch(Exception e)
    	{
    		LOG.error(e);
            throw new SystemException(e);
    	}
    }
    
    public Standard getStandardByStandardid(String chainCode, long regionId, long stdId) throws SystemException
    {
    	Standard standards = new Standard();
    	 List<Standard> arlDisplayStandards = new ArrayList<Standard>();
         List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
         List<Standard> sortedStandards = null; 
    	try
    	{
    		String regionCode  = BrandStandardsUtil.getRegionCode(regionId);
    		String query = BridgeQueryUtils.getMyPublicationFindByIdQuery(chainCode, regionCode, stdId, regionId);
            arlDisplayResults = BridgePublishLocalServiceUtil.getMyPublicationByBrand(chainCode, String.valueOf(regionCode), query);
            sortedStandards = StandardsSortableUtil.sort(arlDisplayStandards, arlDisplayResults);
            for(Standard std: sortedStandards)
            {
            	standards = std;
            }
    	}
    	catch(SystemException se)
    	{
    		LOG.error(se);
            throw new SystemException(se);
    	}
    	catch(Exception e)
    	{
    		LOG.error(e);
            throw new SystemException(e);
    	}
    	return standards;
    }
    
    public void editStandards(long publishId, String regionCode, String brandCode, List<Long> arlStdIds, long prntStdId, String user)
    {
    	List<PublishStandardsExt> arlBridgeStandards = new ArrayList<PublishStandardsExt>();
    	 long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
    	//String query = BridgeQueryUtils.getBridgePublishStandardIdsByParent(brandCode, prntStdId, regionId, publishId);
    	String query = BridgeQueryUtils.getMyPublicationFindByIdQuery(brandCode, regionCode, prntStdId, regionId);
    	List<String> stdCountries = new ArrayList<String>();
    	try
    	{
    		//arlBridgePublishStandards = BridgePublishLocalServiceUtil.getBridgePublishStandardsByParent(query);
    		arlBridgeStandards = BridgePublishLocalServiceUtil.getMyPublicationByBrand(brandCode, String.valueOf(regionCode), query);
    		BridgePublishPersistence bridgePersistence = new BridgePublishPersistenceImpl();
    		bridgePersistence.clearCache();
    		for(PublishStandardsExt standards : arlBridgeStandards)
    		{
    			if(arlStdIds.contains(standards.getStdId()) && standards.getPublishStdId()==0)
    			{
    				BridgePublish bp = BridgePublishLocalServiceUtil.createOraSequence();
    				bp.setPublishId(publishId);
    				bp.setStandardId(standards.getStdId());
    				bp.setRegionId(regionId);
    				bp.setUnpublishInd("N");
    				bp.setUpdatedBy(user);
    				bp.setCreatorId(user);
    				bp.setUpdatedDate(new Date());
    				bp.setCreatedDate(new Date());
    				BridgePublishLocalServiceUtil.addBridgePublish(bp);
    				Publication prodPublish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, BridgeConstants.PRODUCTION_ENVIRONMENT, brandCode);
    	            long prodPublishId = prodPublish.getPublishId();
    				BridgePublishLocalServiceUtil.updateBridgePublishAndCountryFromImport(publishId, prodPublishId,  brandCode,  regionId,  user );
    			}
    			else if(!arlStdIds.contains(standards.getStdId()) && standards.getStatus().equals("N"))
    			{
    				//String queryById = BridgeQueryUtils.getBridgePublishStandardsByIds(brandCode, standards.getStdId(), regionId, publishId, "N");
    				//BridgePublish bp = BridgePublishLocalServiceUtil.getBridgePublishStandardsById(queryById);
    				BridgePublish bridgePublish = BridgePublishLocalServiceUtil.getBridgePublish(standards.getPublishStdId());
    				bridgePublish.setUnpublishInd("Y");
					BridgePublishLocalServiceUtil.updateBridgePublish(bridgePublish);
    			}
    			else if(arlStdIds.contains(standards.getStdId()) && standards.getStatus().equals("Y"))
    			{
    				//String queryById = BridgeQueryUtils.getBridgePublishStandardsByIds(brandCode, standards.getStdId(), regionId, publishId, "Y");
    				//BridgePublish bp = BridgePublishLocalServiceUtil.getBridgePublishStandardsById(queryById);
    				BridgePublish bridgePublish = BridgePublishLocalServiceUtil.getBridgePublish(standards.getPublishStdId());
    				bridgePublish.setUnpublishInd("N");
					BridgePublishLocalServiceUtil.updateBridgePublish(bridgePublish);
    			}
    			else if(!arlStdIds.contains(standards.getStdId()) && standards.getPublishStdId()!=0)
    			{
    				deleteStandards(standards.getStdId(), regionCode, brandCode);
    			}
    		}
    		/*for(long l:arlStdIds)
    		{
    			if(!arlBridgePublishStandards.contains(l))
    			{
    				String queryById = BridgeQueryUtils.getBridgePublishStandardsByIds(brandCode, prntStdId, regionId, publishId, "Y");
    				BridgePublish bp = BridgePublishLocalServiceUtil.getBridgePublishStandardsById(queryById);
    				if(bp.getStandardId()>0)
    				{
    						bp.setUnpublishInd("N");
        					BridgePublishLocalServiceUtil.updateBridgePublish(bp);
        			}
    				//add standard to bridge publish
    				else
    				{
    					BridgePublish bridgePublish = BridgePublishFinderUtil.createOraSequence();
	    				//bridgePublish.setBridgePublishId(bridgePublishId);
	    				bridgePublish.setPublishId(publishId);
	    				bridgePublish.setRegionId(regionId);
	    				bridgePublish.setStandardId(l);
	    				bridgePublish.setUnpublishInd("N");
	    				bridgePublish.setCreatorId(user);
	    				bridgePublish.setCreatedDate(new Date());
	    				bridgePublish.setUpdatedBy(user);
	    				bridgePublish.setUpdatedDate(new Date());
	    				BridgePublishLocalServiceUtil.addBridgePublish(bridgePublish);
    				}
    			}
    		}*/
    		/*for(long l:arlBridgePublishStandards)
    		{
    			if(!arlStdIds.contains(l))
    			{
    				//delete standard from bridge publish
    				deleteStandards(String.valueOf(l), regionCode, brandCode);
    			}
    		}*/
    	}
    	catch(SystemException se)
    	{
    	    LOG.error(se);
    	}
    	catch(Exception e)
    	{
    	    LOG.error(e);
    	}
    }
    
    
}

