/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.model.UserSearchCriteria;
import com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.UserSearchCriteriaLocalServiceUtil;
import com.ihg.brandstandards.util.StandardsSortableUtil;
import com.ihg.me2.brandstandards.custom.pojo.StandardsDisplayOptions;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.ApplicationUtil;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.QueryUtils;
import com.ihg.me2.brandstandards.custom.util.StandardsListUtil;
import com.ihg.me2.brandstandards.custom.util.WCOQueryUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="StandardsListApplication.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public class StandardsListApplication extends ApplicationImpl
{
    private static final String MILLISEC_TO_FETCH = " millisec to fetch ";
    private static final String RECORDS = " records.";
    private static final String EXCEPTION = "Exception: ";
    private static final String TRUE = "true";
    private static final String GDLN = "GDLN";
    private static final String SPEC = "SPEC";
    private static final String STD = "STD";
    private static final Log LOG = LogFactoryUtil.getLog(StandardsListApplication.class);
    private static final String DELIMS = " ,+";
    public static final String SEARCH_CRITERIA = "CRITERIA";
    public static final String DISPLAY_OPTIONS = "OPTIONS";

    /**
     * This method is used for search for Search Standards listing.
     * 
     * @param localeCode - Locale Code
     * @param chainCode -Brand Code
     * @param countryCode - Country Code
     * @param criteria - StandardsSearchCriteria
     * @param userId - User Id of the user
     * @param environment - Environment Name
     * @return return map
     * @throws SystemException throws System Exception
     */
    public Map<String, List<?>> getStandardsByBrandAndCountry(long publishId, String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria, long userId, String environment) throws SystemException
    {
        List<Standard> arlDisplayStandards = new ArrayList<Standard>();
        List<PublishStandardsExt> arlDisplayResults = null;
        List<Long> standardIdsOfSearch = new ArrayList<Long>();
        List<Long> allReferencedIds = new ArrayList<Long>();
        List<Standard> sortedStandards;
        long startTime = new Date().getTime();
        
        if(publishId > 0)
        {
            if (environment.equals(BrandStandardsConstant.ENVIRONMENT_PROD))
            {
                String searchQuery = QueryUtils.generateSearchQuery(publishId, localeCode, countryCode, criteria);
                arlDisplayResults = PublishStandardsExtLocalServiceUtil.getSearchResults(localeCode, chainCode, countryCode, "", searchQuery);
                LOG.info("PRODUCTION environment: Search Result took " + (new Date().getTime() - startTime) + MILLISEC_TO_FETCH
                        + arlDisplayResults.size() + RECORDS);
            }
            else if (environment.equals(BrandStandardsConstant.ENVIRONMENT_STG))
            {
                String searchQuery = QueryUtils.generateSearchQueryStaging(publishId, localeCode, countryCode, criteria);
                arlDisplayResults = PublishStandardsExtLocalServiceUtil.getSearchResults(localeCode, chainCode, countryCode, "", searchQuery);
                LOG.info("STAGING environment: Search Result took " + (new Date().getTime() - startTime) + MILLISEC_TO_FETCH
                        + arlDisplayResults.size() + RECORDS);
            }
            else
            {
                LOG.info("UNKNOWN ENVIRONMENT: " + environment);
                arlDisplayResults = new ArrayList<PublishStandardsExt>();
            }
            
            DateFormat df = new SimpleDateFormat("dd MMM yyyy");
    
            for (PublishStandardsExt publishStd : arlDisplayResults)
            {
                Standard standards = new Standard();
                if (STD.equals(publishStd.getStdTyp()))
                {
                	standardIdsOfSearch.add(publishStd.getStdId());
                    standards.setTaxonomyId(publishStd.getPublishTaxonomyId());
                    standards.setTaxonomyPath(publishStd.getTaxonomyPath());
                    //	LOG.info("the value of taxonomy path in application is "+publishStd.getTaxonomyPath());
                    standards.setTaxonomyText(publishStd.getIndexTitle());
                    standards.setTaxonomyDesc(publishStd.getIndexDescription());
                    standards.setIndexOrder(publishStd.getIndexOrder());
                    standards.setParentTaxonomyId(publishStd.getParentTaxonomyId());
                    standards.setIndexSortOrder(publishStd.getLevelSortOrder());
                    standards.setLevel(publishStd.getIndexLvl());
                    standards.setPublishId(publishStd.getPublishId());
                    standards.setStdId(publishStd.getStdId());
                    //LOG.info(" inside taxid and stdtaxid loop standards id is "+std.getStdId()+" taxonomy is "+tax.getTitle());
                    standards.setPublishStdId(publishStd.getPublishStdId());
                    standards.setPubParentStdId(publishStd.getParentPublishId());
                    standards.setTitle(publishStd.getTitle());
                    //LOG.info("standard title text from object is "+standards.getTitleText());
                    standards.setDescription(publishStd.getDescription());
                    standards.setStdType(publishStd.getStdTyp());
                    standards.setStatus(publishStd.getStatus());
                    standards.setPubParentStdId(publishStd.getParentPublishId());
                    standards.setStdRefId(publishStd.getStdXrefListStdId());
                    standards.setHotelLifeCycleFlags(StandardsListUtil.getHotleLifeCycelFlag(publishStd.getFlagStdId()));
                    //standards.setTaxonomyId(publishStd.getTaxonomyId());
                    if (TRUE.equalsIgnoreCase(publishStd.getAttachmentExists()))
                    {
                        standards.setAttachmentExists(true);
                    }
                    else
                    {
                        standards.setAttachmentExists(false);
                    }
                    if (TRUE.equalsIgnoreCase(publishStd.getImageExists()))
                    {
                        standards.setImageExists(true);
                    }
                    else
                    {
                        standards.setImageExists(false);
                    }
                    if (TRUE.equalsIgnoreCase(publishStd.getLinkExists()))
                    {
                        standards.setLinkExists(true);
                    }
                    else
                    {
                        standards.setLinkExists(false);
                    }
                    /*if (TRUE.equals(publishStd.getAttachmentExists()) || TRUE.equals(publishStd.getImageExists())
                            || TRUE.equals(publishStd.getLinkExists()))
                    {
                        publishedStdIds.add(publishStd.getPublishStdId());
                    }*/
                    standards.setAttachmentStatus(publishStd.getAttachmentStatus());
                    standards.setImageStatus(publishStd.getImageStatus());
                    standards.setLinkStatus(publishStd.getLinkStatus());
                    if (publishStd.getImplDate() != null)
                    {
                        standards.setComplianceDate(df.format(publishStd.getImplDate()));
                    }
                    standards.setDisplayOrder(publishStd.getSortOrder());
                    standards.setMatchedId(publishStd.getMatchedId());
                    standards.setSearchMatches(publishStd.isSearchMatches());
                    if(publishStd.getExpiryDate()!=null)
                    {
                    	standards.setExpiryDate(df.format(publishStd.getExpiryDate()));
                    }
                    if(publishStd.getExpiryDate() == null || (publishStd.getExpiryDate()!=null && publishStd.getExpiryDate().after(new Date())))
                	{   
    	                arlDisplayStandards.add(standards);
                	}
                    if (Validator.isNotNull(publishStd.getStdXrefListStdId())) {
                        for (String refId : publishStd.getStdXrefListStdId().split(",")) {
                            long referenceId = Long.parseLong(StringUtil.trim(refId));
                            if (!allReferencedIds.contains(referenceId)) {
                                allReferencedIds.add(referenceId);
                            }
                        }
                    }
                }
            }
    
            updateIndexOrder(arlDisplayStandards, publishId, environment);
            sortedStandards = sortRecords(arlDisplayStandards);
    
            for (Standard standards : sortedStandards)
            {
                List<Standard> arlSpecs = new ArrayList<Standard>();
                List<Standard> arlGdlns = new ArrayList<Standard>();
                for (PublishStandardsExt publishStd : arlDisplayResults)
                {
                    if (standards.getPublishStdId() == publishStd.getParentPublishId())
                    {
                    	Standard specs = new Standard();
                        specs.setStdId(publishStd.getStdId());
                        specs.setParentStdId(publishStd.getParentPublishId());
                        specs.setTitle(publishStd.getTitle());
                        specs.setDescription(publishStd.getDescription());
                        specs.setStdType(publishStd.getStdTyp());
                        specs.setParentStdId(publishStd.getParentPublishId());
                        specs.setPublishStdId(publishStd.getPublishStdId());
                        specs.setStdRefId(publishStd.getStdXrefListStdId());
                        specs.setHotelLifeCycleFlags(StandardsListUtil.getHotleLifeCycelFlag(publishStd.getFlagStdId()));
                        if (TRUE.equals(publishStd.getAttachmentExists()))
                        {
                            specs.setAttachmentExists(true);
                        }
                        if (TRUE.equals(publishStd.getImageExists()))
                        {
                            specs.setImageExists(true);
                        }
                        if (TRUE.equals(publishStd.getLinkExists()))
                        {
                            specs.setLinkExists(true);
                        }
                        /*if (TRUE.equals(publishStd.getAttachmentExists()) || TRUE.equals(publishStd.getImageExists())
                                || TRUE.equals(publishStd.getLinkExists()))
                        {
                            publishedStdIds.add(publishStd.getPublishStdId());
                        }*/
                        specs.setAttachmentStatus(publishStd.getAttachmentStatus());
                        specs.setImageStatus(publishStd.getImageStatus());
                        specs.setLinkStatus(publishStd.getLinkStatus());
                        specs.setStatus(publishStd.getStatus());
                        if (publishStd.getImplDate() != null)
                        {
                            specs.setComplianceDate(df.format(publishStd.getImplDate()));
                        }
                        if(publishStd.getExpiryDate()!=null)
                        {
                        	specs.setExpiryDate(df.format(publishStd.getExpiryDate()));
                        }
                        specs.setDisplayOrder(publishStd.getSortOrder());
                        specs.setMatchedId(publishStd.getMatchedId());
                        specs.setSearchMatches(publishStd.isSearchMatches());
                        if (SPEC.equals(publishStd.getStdTyp()))
                        {
                        	if(publishStd.getExpiryDate() == null || (publishStd.getExpiryDate()!=null && publishStd.getExpiryDate().after(new Date())))
                        	{ 
                        		arlSpecs.add(specs);
                        	}
                        }
                        else if (GDLN.equals(publishStd.getStdTyp()))
                        {
                            arlGdlns.add(specs);
                        }
                        
                        if (Validator.isNotNull(publishStd.getStdXrefListStdId())) {
                            for (String refId : publishStd.getStdXrefListStdId().split(",")) {
                                long referenceId = Long.parseLong(StringUtil.trim(refId));
                                if (!allReferencedIds.contains(referenceId)) {
                                    allReferencedIds.add(referenceId);
                                }
                            }
                        }
                    }
                }
                Collections.sort(arlSpecs, new StandardsSortableUtil.StandardSortBySTDId());
                Collections.sort(arlGdlns, new StandardsSortableUtil.StandardSortBySTDId());
                standards.setSpecifications(arlSpecs);
                standards.setGuidelines(arlGdlns);
                //	LOG.info("size of specs and guidelins is "+arlSpecs.size()+" and "+arlGdlns.size());
            }
        }
        else
        {
            sortedStandards = new ArrayList<Standard>();
        }
        
        if (criteria != null && (arlDisplayResults != null && !arlDisplayResults.isEmpty()))
        {
            saveSearchCriteria(userId, criteria, localeCode);
        }
        Map<String, List<?>> standardsMap = new HashMap<String, List<?>>();
        standardsMap.put("displayStandards", sortedStandards);
        standardsMap.put("standardIdsOfSearch", standardIdsOfSearch);
        // All reference standard Ids
        standardsMap.put("allReferencedIds", allReferencedIds);
        /*if (LOG.isDebugEnabled())
        {
            LOG.debug("Search Standard Ids:"+standardIdsOfSearch.size()+"::"+standardIdsOfSearch);
            LOG.debug("Search Standard Ids:"+arlMatchedStandards.size()+"::"+arlMatchedStandards);
        }*/
        LOG.info("Total time to fetch and process " + sortedStandards.size() + " records is "
                + (new Date().getTime() - startTime) + " milliseconds.");
        return standardsMap;
    }

    /**
     * This method is used for search for What changes on Standards listing.
     * 
     * @param localeCode - Locale Code
     * @param chainCode -Brand Code
     * @param countryCode - Country Code
     * @param criteria - StandardsSearchCriteria
     * @param userId - User Id of the user
     * @param selPublishId - Selected Publish Id
     * @param prevPublishId - Previous Publish Id
     * @param environment - Environment Name
     * @return returns map
     * @throws SystemException throws System Exception
     */
    @SuppressWarnings("rawtypes")
    public Map<String, List> getStandardsForWhatChangedOn(String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria, long userId, String selPublishId, String prevPublishId, String environment)
            throws SystemException
    {
        List<Standard> arlDisplayStandards = new ArrayList<Standard>();
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        List<Standard> arlSpecs = new ArrayList<Standard>();
        List<Standard> arlGdlns = new ArrayList<Standard>();
        List<PublishStandardsExt> finalRemovedResults = new ArrayList<PublishStandardsExt>();

        Map<String, List> standardsMap = new HashMap<String, List>();
        long startTime = new Date().getTime();

        if ((criteria.isFilterByNew() || criteria.isFilterByTextUpdate() || criteria.isFilterByComplianceUpdate() || criteria.isFilterByLifecycleUpdate()) 
        		&& selPublishId != null && !"-1".equalsIgnoreCase(selPublishId)) {
            String newOrUpdateQuery;
            if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment)) {
                newOrUpdateQuery = WCOQueryUtil.getWCOSearchQueryProd(localeCode, chainCode, countryCode, criteria, selPublishId, prevPublishId);
            } else {
                newOrUpdateQuery = WCOQueryUtil.getWCOSearchQueryStage(localeCode, chainCode, countryCode, criteria, selPublishId, prevPublishId);
            }
            arlDisplayResults.addAll(PublishStandardsExtLocalServiceUtil.getWhatChangedOnList(newOrUpdateQuery, false));
            if (LOG.isDebugEnabled()) {
                LOG.debug("Total results for NEW & UPDATE query:" + arlDisplayResults.size());
                LOG.debug(BrandStandardsConstant.ENVIRONMENT_PROD + " environment: NEW OR UPDATE Search for What Changed took "
                        + (new Date().getTime() - startTime) + MILLISEC_TO_FETCH + arlDisplayResults.size() + RECORDS);
                LOG.debug("New Or Update Search Query::" + newOrUpdateQuery);
            }
        }
        if (prevPublishId != null && !"-1".equalsIgnoreCase(prevPublishId)) {
            String removeQuery;
            if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment)) {
                removeQuery = WCOQueryUtil.getWCORemovedSearchQueryProd(localeCode, chainCode, countryCode, criteria, selPublishId, prevPublishId);
            } else {
                removeQuery = WCOQueryUtil.getWCORemovedSearchQueryStage(localeCode, chainCode, countryCode, criteria, selPublishId, prevPublishId);
            }
            if (arlDisplayResults != null && arlDisplayResults.size() > 0) {
                List<PublishStandardsExt> removedResults = PublishStandardsExtLocalServiceUtil.getWhatChangedOnList(removeQuery, false);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Total results before merge for removed query:" + removedResults.size());
                }
                //Merging removed Specifications & Guidelines to the existing STD to display under one standard list
                StringBuilder remSpecsGdlnsOfExistSTD = new StringBuilder();
                if (removedResults != null && removedResults.size() > 0) {
	                for (PublishStandardsExt removedStdExt : removedResults) {
	                    boolean duplicate = false;
	                    for (PublishStandardsExt publishStdExt : arlDisplayResults) {
	                        if (removedStdExt.getStdId() == publishStdExt.getStdId()) {
	                            duplicate = true;
	                            for (PublishStandardsExt duplicateRemStdExt : removedResults) {
	                                if ((SPEC.equalsIgnoreCase(duplicateRemStdExt.getStdTyp()) ||
	                                        GDLN.equalsIgnoreCase(duplicateRemStdExt.getStdTyp()))
	                                        && duplicateRemStdExt.getParentPublishId() == removedStdExt.getParentPublishId()
	                                        && "REMOVED".equalsIgnoreCase(duplicateRemStdExt.getStatus())) {
	                                		if (!(remSpecsGdlnsOfExistSTD.toString().contains(String.valueOf(duplicateRemStdExt.getStdId())+ StringPool.COMMA))) {
			                                	duplicateRemStdExt.setParentPublishId(publishStdExt.getParentPublishId());
			                                    remSpecsGdlnsOfExistSTD.append(duplicateRemStdExt.getStdId());
			                                    remSpecsGdlnsOfExistSTD.append(StringPool.COMMA);
			                                    finalRemovedResults.add(duplicateRemStdExt);
	                                		}
	                                }
	                            }
	                            break;
	                        }
	                    }
	
	                    if (!duplicate && !(remSpecsGdlnsOfExistSTD.toString().contains(String.valueOf(removedStdExt.getStdId())
	                                    + StringPool.COMMA))) {
	                    	remSpecsGdlnsOfExistSTD.append(removedStdExt.getStdId());
                            remSpecsGdlnsOfExistSTD.append(StringPool.COMMA);
	                        finalRemovedResults.add(removedStdExt);
	                    }
	                }
                }
            } else {
                finalRemovedResults = PublishStandardsExtLocalServiceUtil.getWhatChangedOnList(removeQuery, false);
            }

            arlDisplayResults.addAll(finalRemovedResults);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Final total results for removed query:" + finalRemovedResults.size());
                LOG.debug(BrandStandardsConstant.ENVIRONMENT_PROD + " environment: REMOVED Search for What Changed took "
                        + (new Date().getTime() - startTime) + MILLISEC_TO_FETCH + arlDisplayResults.size() + RECORDS);
                LOG.debug("Remove Search Query::" + removeQuery);
            }
        }
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");
        if (LOG.isDebugEnabled()) {
            LOG.debug("No Of What Changed On records from database:::" + arlDisplayResults.size());
        }
        for (PublishStandardsExt publishStdExt : arlDisplayResults) {
            Standard standards = new Standard();
            if (STD.equals(publishStdExt.getStdTyp())) {
                standards.setOrigTaxonomyId(publishStdExt.getTaxonomyId());
                standards.setTaxonomyId(publishStdExt.getPublishTaxonomyId());
                standards.setTaxonomyPath(publishStdExt.getTaxonomyPath());
                standards.setTaxonomyText(publishStdExt.getIndexTitle());
                standards.setTaxonomyDesc(publishStdExt.getIndexDescription());
                standards.setIndexOrder(publishStdExt.getIndexOrder());
                standards.setParentTaxonomyId(publishStdExt.getParentTaxonomyId());
                standards.setIndexSortOrder(publishStdExt.getLevelSortOrder());
                standards.setLevel(publishStdExt.getIndexLvl());
                standards.setPublishId(publishStdExt.getPublishId());
                standards.setStdId(publishStdExt.getStdId());
                standards.setPublishStdId(publishStdExt.getPublishStdId());
                standards.setPubParentStdId(publishStdExt.getParentPublishId());
                standards.setTitle(publishStdExt.getTitle());
                standards.setDescription(publishStdExt.getDescription());
                standards.setStdType(publishStdExt.getStdTyp());
                standards.setStatus(publishStdExt.getStatus());
                if (publishStdExt.getImplDate() != null) {
                    standards.setComplianceDate(df.format(publishStdExt.getImplDate()));
                }
                if(publishStdExt.getExpiryDate() != null) {
                	standards.setExpiryDate(df.format(publishStdExt.getExpiryDate()));
                }
                standards.setDisplayOrder(publishStdExt.getSortOrder());
                standards.setHotelLifeCycleFlags(StandardsListUtil.getHotleLifeCycelFlag(publishStdExt.getFlagStdId()));
                
                standards.setPrevTitleText(publishStdExt.getPrevPublishTitle());
                standards.setPrevDescription(publishStdExt.getPrevDescription());
                standards.setPrevCmplyDate(publishStdExt.getPrevCmplyDate());
                standards.setPrevExpiryDate(publishStdExt.getPrevExpiryDate());
                standards.setPrevFlagStdId(publishStdExt.getPrevFlagStdId());
                standards.setPrevHotelLifeCycleFlags(StandardsListUtil.getHotleLifeCycelFlag(publishStdExt.getPrevFlagStdId()));
                standards.setTitleChange(publishStdExt.getTitleChange());
                if("NO_CHANGE".equals(publishStdExt.getTitleChange())) {
                	standards.setTextUpdated(false);
                } else {
                	standards.setTextUpdated(true);
                }
                standards.setCmplyChange(publishStdExt.getCmplyChange());
                standards.setExprChange(publishStdExt.getExprChange());
                if("NO_CHANGE".equals(publishStdExt.getCmplyChange()) && "NO_CHANGE".equals(publishStdExt.getExprChange())) {
                	standards.setComplianceUpdated(false);
                } else {
                	standards.setComplianceUpdated(true);
                }
                standards.setHlcChange(publishStdExt.getHlcChange());
                if("NO_CHANGE".equals(publishStdExt.getHlcChange())) {
                	standards.setLifecycleUpdated(false);
                } else {
                	standards.setLifecycleUpdated(true);
                }
                standards.setChangedStatus(publishStdExt.getChangedStatus());
                
                
                arlDisplayStandards.add(standards);
            }
        }

        updateWhatChangedOnIndexOrder(arlDisplayStandards, chainCode, selPublishId, prevPublishId, environment);
        List<Standard> sortedStandards = sortRecords(arlDisplayStandards);

        for (Standard standards : sortedStandards) {
            arlSpecs = new ArrayList<Standard>();
            arlGdlns = new ArrayList<Standard>();
            for (PublishStandardsExt publishStdExt : arlDisplayResults) {
                if (standards.getPublishStdId() == publishStdExt.getParentPublishId()) {
                	if (SPEC.equals(publishStdExt.getStdTyp()) || GDLN.equals(publishStdExt.getStdTyp())) {
	                	Standard specs = new Standard();
	                    specs.setStdId(publishStdExt.getStdId());
	                    specs.setParentStdId(publishStdExt.getParentPublishId());
	                    specs.setTitle(publishStdExt.getTitle());
	                    specs.setDescription(publishStdExt.getDescription());
	                    specs.setStdType(publishStdExt.getStdTyp());
	                    specs.setPublishStdId(publishStdExt.getPublishStdId());
	                    specs.setStatus(publishStdExt.getStatus());
	                    if (publishStdExt.getImplDate() != null) {
	                        specs.setComplianceDate(df.format(publishStdExt.getImplDate()));
	                    }
	                    if(publishStdExt.getExpiryDate() != null) {
	                    	specs.setExpiryDate(df.format(publishStdExt.getExpiryDate()));
	                    }
	                    specs.setDisplayOrder(publishStdExt.getSortOrder());
	                    specs.setHotelLifeCycleFlags(StandardsListUtil.getHotleLifeCycelFlag(publishStdExt.getFlagStdId()));
	                    
	                    specs.setPrevTitleText(publishStdExt.getPrevPublishTitle());
	                    specs.setPrevDescription(publishStdExt.getPrevDescription());
	                    specs.setPrevCmplyDate(publishStdExt.getPrevCmplyDate());
	                    specs.setPrevExpiryDate(publishStdExt.getPrevExpiryDate());
	                    specs.setPrevFlagStdId(publishStdExt.getPrevFlagStdId());
	                    specs.setPrevHotelLifeCycleFlags(StandardsListUtil.getHotleLifeCycelFlag(publishStdExt.getPrevFlagStdId()));
	                    specs.setTitleChange(publishStdExt.getTitleChange());
	                    if("NO_CHANGE".equals(publishStdExt.getTitleChange())) {
	                    	specs.setTextUpdated(false);
	                    } else {
	                    	specs.setTextUpdated(true);
	                    }
	                    specs.setCmplyChange(publishStdExt.getCmplyChange());
	                    specs.setExprChange(publishStdExt.getExprChange());
	                    if("NO_CHANGE".equals(publishStdExt.getCmplyChange()) && "NO_CHANGE".equals(publishStdExt.getExprChange())) {
	                    	specs.setComplianceUpdated(false);
	                    } else {
	                    	specs.setComplianceUpdated(true);
	                    }
	                    specs.setHlcChange(publishStdExt.getHlcChange());
	                    if("NO_CHANGE".equals(publishStdExt.getHlcChange())) {
	                    	specs.setLifecycleUpdated(false);
	                    } else {
	                    	specs.setLifecycleUpdated(true);
	                    }
	                    specs.setChangedStatus(publishStdExt.getChangedStatus());
	                    
	                    if (SPEC.equals(publishStdExt.getStdTyp())) {
	                        arlSpecs.add(specs);
	                    } else if (GDLN.equals(publishStdExt.getStdTyp())) {
	                        arlGdlns.add(specs);
	                    }
                	}
                }
            }
            Collections.sort(arlSpecs, new StandardsSortableUtil.StandardSortBySTDId());
            Collections.sort(arlGdlns, new StandardsSortableUtil.StandardSortBySTDId());
            standards.setSpecifications(arlSpecs);
            standards.setGuidelines(arlGdlns);
        }

        standardsMap.put("displayStandards", sortedStandards);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Total time to fetch and process for What Changed" + sortedStandards.size() + " records is "
                    + (new Date().getTime() - startTime) + " millisec .");
            LOG.debug("No Of What Changed On Standards:" + sortedStandards.size());
            LOG.debug("No Of What Changed On Specifications:" + arlSpecs.size());
            LOG.debug("No Of What Changed On Guidelines:" + arlGdlns.size());
        }
        return standardsMap;
    }

    /**
     * @param standards -Standards List
     * @param chainCode -Brand Code
     * @param selPublishId - Selected Publish Id
     * @param prevPublishId - Previous Publish Id
     * @param environment - Environment information
     * @throws SystemException throws System Exception
     */
    private void updateWhatChangedOnIndexOrder(List<Standard> standards, final String chainCode, final String selPublishId,
            final String prevPublishId, final String environment) throws SystemException
    {
        long startTime = new Date().getTime();
        String allIndexQuery = null;
        if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment))
        {
            allIndexQuery = WCOQueryUtil.getWCOAllIndexQueryProd(selPublishId, prevPublishId);
        }
        else
        {
            allIndexQuery = WCOQueryUtil.getWCOAllIndexQueryStage(selPublishId, prevPublishId);
        }
        final List<PublishStandardsExt> indexes = PublishStandardsExtLocalServiceUtil.getWhatChangedOnList(allIndexQuery, true);
        LOG.info("All Index What Changed Search Result took " + (new Date().getTime() - startTime) + MILLISEC_TO_FETCH
                + indexes.size() + RECORDS);
        final Map<Long, PublishStandardsExt> indexMap = new HashMap<Long, PublishStandardsExt>();
        for (PublishStandardsExt indx : indexes)
        {
            if (indx.getPublishTaxonomyId() > 1L && indx.getTaxonomyId() > 1L)
            {
                indexMap.put(indx.getTaxonomyId(), indx);
            }
        }

        for (Standard std : standards)
        {
            PublishStandardsExt rec = indexMap.get(std.getOrigTaxonomyId());
            if (rec != null)
            {
                std.setIndexOrder(rec.getIndexOrder());
            }
            else
            {
                LOG.error("Index Order Missing: STDID: " + std.getStdId() + " Orinal TAXONOMY ID:" + std.getOrigTaxonomyId());
            }
        }
        LOG.info("Total time for What Changed to fetch and process " + indexes.size() + " indexes is "
                + (new Date().getTime() - startTime) + " millisecond.");
        if (LOG.isDebugEnabled())
        {
            LOG.debug("What Changed On Index Query:" + allIndexQuery);
            LOG.debug("What Changed On IndexMap size:" + indexMap.size());
        }
    }

    /**
     * @param standards -Standards List
     * @param chainCd -Brand Code
     * @param environment - Environment information
     * @throws SystemException throws System Exception
     */
    private void updateIndexOrder(List<Standard> standards, final long publishId, final String environment)
            throws SystemException
    {
        long startTime = new Date().getTime();
        String allIndexQuery = null;
        if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment))
        {
            allIndexQuery = QueryUtils.getAllIndexQueryProd(publishId);
        }
        else
        {
            allIndexQuery = QueryUtils.getAllIndexQueryStage(publishId);
        }
        final List<PublishStandardsExt> indexes = PublishStandardsExtLocalServiceUtil.getAllIndexes(allIndexQuery);
        LOG.info("All Index Search Result took " + (new Date().getTime() - startTime) + MILLISEC_TO_FETCH + indexes.size()
                + RECORDS);
        final Map<Long, PublishStandardsExt> indexMap = new HashMap<Long, PublishStandardsExt>();
        for (PublishStandardsExt indx : indexes)
        {
            if (indx.getPublishTaxonomyId() > 1L)
            {
                indexMap.put(indx.getPublishTaxonomyId(), indx);
            }
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("indexMap contains : " + indexMap.size());
        }

        for (Standard std : standards)
        {
            PublishStandardsExt rec = indexMap.get(std.getTaxonomyId());
            if (rec != null)
            {
                std.setIndexOrder(rec.getIndexOrder());
            }
        }
        LOG.info("Total time to fetch and process " + indexes.size() + " indexes is " + (new Date().getTime() - startTime)
                + " millisec.");
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public List<Standard> sortRecords(List<Standard> standards)
    {
        sortRecordsByIndex(standards);
        List<Standard> sortedStandards = sortStdRecordsUnderIndex(standards);
        return sortedStandards;
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     */
    public void sortRecordsByIndex(List<Standard> standards)
    {
        Collections.sort(standards, new Comparator<Standard>()
        {
            public int compare(Standard s1, Standard s2)
            {
                int res = compareLong(s1.getIndexOrder(), s2.getIndexOrder());
                if (res == 0)
                {
                    if (s1.getPublishStdId() == 0 && s2.getPublishStdId() == 0)
                    {
                        return 0;
                    }
                    res = compareLong(s1.getPubParentStdId(), s2.getPubParentStdId());
                    if (res == 0)
                    {
                        res = compareRecordType(s2.getStdType(), s1.getStdType());
                        if (res == 0)
                        {
                            if (s1.getDisplayOrder() > 0L || s2.getDisplayOrder() > 0L)
                            {
                                res = compareLong(s1.getDisplayOrder(), s2.getDisplayOrder());
                            }
                            else
                            {
                                res = compareLong(s1.getPublishStdId(), s2.getPublishStdId());
                            }
                        }
                    }
                }
                return res;
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

            /**
             * Compare long values.
             * 
             * @param t1 - record type 1
             * @param t2 - record type 2
             * @return 1, 0, -1
             */
            private int compareRecordType(String t1, String t2)
            {
                if (t1 != null && t2 != null)
                {
                    if (STD.equals(t1) && !STD.equals(t2))
                    {
                        return 1;
                    }
                    else if (!STD.equals(t1) && STD.equals(t2))
                    {
                        return -1;
                    }
                    else if (STD.equals(t1) && STD.equals(t2))
                    {
                        return 0;
                    }
                    else if (SPEC.equals(t1) && !SPEC.equals(t2))
                    {
                        return 1;
                    }
                    else if (!SPEC.equals(t1) && SPEC.equals(t2))
                    {
                        return -1;
                    }
                    else if (SPEC.equals(t1) && SPEC.equals(t2))
                    {
                        return 0;
                    }
                    else if (GDLN.equals(t1) && GDLN.equals(t2))
                    {
                        return 0;
                    }
                    else if (GDLN.equals(t1) && !GDLN.equals(t2))
                    {
                        return 1;
                    }
                    else if (!GDLN.equals(t1) && GDLN.equals(t2))
                    {
                        return -1;
                    }
                }
                else if (t1 != null && t2 == null)
                {
                    return 1;
                }
                else if (t1 == null && t2 != null)
                {
                    return -1;
                }
                return 0;
            }
        });
    }

    /**
     * Sort Standards Under each Index by specified sort order.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public List<Standard> sortStdRecordsUnderIndex(List<Standard> standards)
    {
        Map<Long, Map<Long, List<Standard>>> indexRecords = new LinkedHashMap<Long, Map<Long, List<Standard>>>();

        for (Standard std : standards)
        {
            Map<Long, List<Standard>> indexItem = indexRecords.get(std.getTaxonomyId());
            // no Index found
            if (indexItem == null)
            {
                // create map to store Standard
                indexItem = new LinkedHashMap<Long, List<Standard>>();
                List<Standard> stdItem = new ArrayList<Standard>();
                stdItem.add(std);
                indexItem.put(std.getPublishStdId(), stdItem);
                // create Index item with Standard
                indexRecords.put(std.getTaxonomyId(), indexItem);
            }
            // found Index; add Standard, Specification or Guideline
            else
            {
                List<Standard> stdItem = indexItem.get(std.getPubParentStdId());
                // this is should be Standard. For Specification and Guideline stdItem should NOT be null
                if (stdItem == null)
                {
                    stdItem = new ArrayList<Standard>();
                    indexItem.put(std.getPublishStdId(), stdItem);
                }
                stdItem.add(std);
            }
        }

        List<Standard> sortedList = new ArrayList<Standard>();
        List<Standard> tmpList = new ArrayList<Standard>();
        for (Map.Entry<Long, Map<Long, List<Standard>>> indexEntry : indexRecords.entrySet())
        {
            tmpList.clear();
            // Standards for Index  === <prnt_std_id, list of Records> first records is a Standard
            Map<Long, List<Standard>> stdRecords = indexEntry.getValue();
            for (Map.Entry<Long, List<Standard>> stdEntry : stdRecords.entrySet())
            {
                List<Standard> recordsList = stdEntry.getValue();
                if (recordsList != null && !recordsList.isEmpty())
                {
                    Standard rec = recordsList.get(0);
                    if (STD.equals(rec.getStdType()))
                    {
                        tmpList.add(rec);
                    }
                    else
                    {
                        LOG.error("Found ==" + rec.getStdType() + " in index 0, publish std id=" + rec.getPublishStdId());
                    }
                }
            }

            sortStdBySortOrder(tmpList);
            for (Standard std : tmpList)
            {
                List<Standard> stdItems = stdRecords.get(std.getPublishStdId());
                sortedList.addAll(stdItems);
            }
        }
        return sortedList;
    }

    /**
     * Sort records by Display order.
     * 
     * @param standards -Standard List
     */
    private void sortStdBySortOrder(List<Standard> standards)
    {
        Collections.sort(standards, new Comparator<Standard>()
        {
            public int compare(Standard s1, Standard s2)
            {
            	int res = 0;
            	if (s1.getDisplayOrder() ==  s2.getDisplayOrder() && s1.getDisplayOrder() > 0 && s2.getDisplayOrder() > 0)
                {
                    res = 0;
                }
                else if (s1.getDisplayOrder() > s2.getDisplayOrder() && s1.getDisplayOrder() > 0 && s2.getDisplayOrder() > 0)
                {
                	res = 1;
                } else if (s1.getDisplayOrder() == 0 && s2.getDisplayOrder() == 0){
                	res = compareLong(s1.getStdId(), s2.getStdId());
                } else if (s1.getDisplayOrder() > s2.getDisplayOrder() && s2.getDisplayOrder()  == 0)
                {
                	res = compareLong(s2.getDisplayOrder(), s1.getDisplayOrder());
                } else if (s2.getDisplayOrder() > s1.getDisplayOrder() && s1.getDisplayOrder()  == 0)
                {
                	res = compareLong(s2.getDisplayOrder(), s1.getDisplayOrder());
                } 
                else {
                	res = -1;
                }
            	
            	return res;
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

        });
    }

    /**
     * @param stdId -Standard Id
     * @param locale - Locale Code
     * @param brand - Brand code
     * @param countryCode - Country code
     * @param environment - Environment name
     * @param criteria - StandardsSearchCriteria
     * @return List<StdImage>
     */
    public static List<StdImage> getAssociatedImages(long stdId, String locale, String brand, String countryCode,
            String environment, StandardsSearchCriteria criteria)
    {
        AttachmentsApplication application = ApplicationUtil.getAtatchmentsApplicationObject();
        List<StdImage> images = application.getAssociatedImages(stdId, locale, brand, countryCode, environment, criteria);
        if (images == null)
        {
            images = new ArrayList<StdImage>();
        }
        return images;
    }

    /**
     * @param userId The userId of the users.
     * @param criteria The StandardsSearchCriteria object
     * @return boolean
     */
    public boolean saveSearchCriteria(long userId, StandardsSearchCriteria criteria, String localeCode)
    {
        boolean flag = false;
        String strCriteria = "";
        StringBuilder sbCriteria = new StringBuilder();
        try
        {
            String textCriteria = criteria.getTextSearch();
            String textSearchType = criteria.getTextSearchType();
            List<String> hoteLifecycle = criteria.getHotelLifecycle();
            List<String> specialism = criteria.getSpecialism();
            List<String> hotelLocations = criteria.getLocHotel();
            List<String> deptApplicability = criteria.getDeptApplicability();
            List<String> guestJourney = criteria.getGuestJourney();
            String complianceDeadline = criteria.getComplianceDeadline();
            boolean hasAttachments = criteria.isHasAttachments();
            boolean hasLinks = criteria.isHasLinks();
            boolean hasImages = criteria.isHasImages();
            boolean hasSOP = criteria.isHasSOP();
            boolean hasTM = criteria.isHasTrainingMaterial();
            LOG.info("inside search criteria");
            if (textCriteria != null && textCriteria.length() > 0)
            {
                sbCriteria.append("textSearch:" + textCriteria + ";");
                LOG.info("inside textsearch value is" + sbCriteria);
                if (textSearchType != null && textSearchType.length() > 0)
                {
                    sbCriteria.append("textSearchType:" + textSearchType + ";");
                    LOG.info("inside text search type value is " + sbCriteria);
                }
            }
            //CR: Special Word Search
            if (Validator.isNotNull(textCriteria) && Validator.isNotNull(localeCode)) {
            	String replacedTextSearch = StandardsListUtil.getReplacedSearchText(localeCode, textCriteria);
            	if(Validator.isNotNull(replacedTextSearch)){
            		sbCriteria.append("replacedTextSearch:" + StandardsListUtil.getReplacedSearchText(localeCode, textCriteria) + ";");
            	}
            }

            //Add CR 50.2 Changes
            if (hoteLifecycle != null && hoteLifecycle.size() > 0)
            {
                sbCriteria.append("hotelLifecycle:");
                for (int i = 0; i < hoteLifecycle.size(); i++)
                {
                    String hotelLife = hoteLifecycle.get(i);
                    if (i == (hoteLifecycle.size() - 1))
                    {
                        sbCriteria.append(hotelLife).append(";");
                    }
                    else
                    {
                        sbCriteria.append(hotelLife).append(",");
                    }
                }
                LOG.info("inside hotelLifecycle value is sbCriteria");
            }
            
            if (specialism != null && specialism.size() > 0)
            {
                sbCriteria.append("specialism:");
                for (int i = 0; i < specialism.size(); i++)
                {
                    String strSpecialism = specialism.get(i);
                    if (i == (specialism.size() - 1))
                    {
                        sbCriteria.append(strSpecialism).append(";");
                    }
                    else
                    {
                        sbCriteria.append(strSpecialism).append(",");
                    }
                }
                LOG.info("inside specialism value is sbCriteria");
            }
            //End CR 50.2 change 

            if (hotelLocations != null && hotelLocations.size() > 0)
            {
                sbCriteria.append("hotelLocation:");
                for (int i = 0; i < hotelLocations.size(); i++)
                {
                    String hotelLoc = hotelLocations.get(i);
                    if (i == (hotelLocations.size() - 1))
                    {
                        sbCriteria.append(hotelLoc).append(";");
                    }
                    else
                    {
                        sbCriteria.append(hotelLoc).append(",");
                    }
                }
                LOG.info("inside hotelLocation value is sbCriteria");
            }
            if (deptApplicability != null && deptApplicability.size() > 0)
            {
                sbCriteria.append("deptApplicability:");
                for (int i = 0; i < deptApplicability.size(); i++)
                {
                    String dept = deptApplicability.get(i);
                    if (i == (deptApplicability.size() - 1))
                    {
                        sbCriteria.append(dept).append(";");
                    }
                    else
                    {
                        sbCriteria.append(dept).append(",");
                    }
                }

            }
            if (guestJourney != null && guestJourney.size() > 0)
            {
                sbCriteria.append("guestJourney:");
                for (int i = 0; i < guestJourney.size(); i++)
                {
                    String guest = guestJourney.get(i);
                    if (i == (guestJourney.size() - 1))
                    {
                        sbCriteria.append(guest).append(";");
                    }
                    else
                    {
                        sbCriteria.append(guest).append(",");
                    }
                }

            }
            if (complianceDeadline != null && complianceDeadline.length() > 0)
            {
                sbCriteria.append("compliance:").append(complianceDeadline).append(";");
            }
            if (hasAttachments)
            {
                sbCriteria.append("Attachments:true;");
            }
            if (hasLinks)
            {
                sbCriteria.append("Links:true;");
            }
            if (hasImages)
            {
                sbCriteria.append("Images:true;");
            }
            if (hasSOP)
            {
                sbCriteria.append("SOP:true;");
            }
            if (hasTM)
            {
                sbCriteria.append("TM:true;");
            }
            
            strCriteria = new String(sbCriteria);
            UserSearchCriteria userCriteria = UserSearchCriteriaLocalServiceUtil.getSearchCriteriaBySearchName(userId,
                    SEARCH_CRITERIA);
            LOG.info("after getting userCriteria from db and b4 creating object to send to db value of sbcriteria is "
                    + sbCriteria);
            String userIdfromCriteria = "";
            if (userCriteria != null)
            {
                LOG.info("inside user criteria not null");
                userIdfromCriteria = userCriteria.getCreatorId();
                LOG.info("value of useridfrom criteria is " + userIdfromCriteria);
            }
            if ((userIdfromCriteria != null && userIdfromCriteria.length() > 0))
            {
                LOG.info("inside userIdCriteria not 0");
                userCriteria.setSearchCriteria(strCriteria);
                userCriteria.setUpdatedDate(new Date());
                UserSearchCriteriaLocalServiceUtil.updateUserSearchCriteria(userCriteria);
            }
            else
            {
                userCriteria = UserSearchCriteriaLocalServiceUtil.createUserSearchCriteria(CounterLocalServiceUtil.increment(UserSearchCriteria.class.getName()));
                userCriteria.setSearchName(SEARCH_CRITERIA);
                userCriteria.setSearchCriteria(strCriteria);
                userCriteria.setCreatorId("" + userId);
                userCriteria.setCreatedDate(new Date());
                userCriteria.setUpdatedBy("" + userId);
                userCriteria.setUpdatedDate(new Date());
                userCriteria.setModuleName("OBSM");
                UserSearchCriteriaLocalServiceUtil.addUserSearchCriteria(userCriteria);
                LOG.info("inside else of userid criteria not 0");
            }
            LOG.info("after saving search criteria in application class");
            flag = true;
        }
        catch (Exception e)
        {
            flag = false;
            LOG.info(EXCEPTION, e);
        }
        return flag;
    }

    /**
     * @param userId The userId of the users.
     * @return StandardsSearchCriteria
     */
    public StandardsSearchCriteria getUserSearchCriteria(long userId)
    {
        StandardsSearchCriteria stdSearchCriteria = null;
        List<String> arlFlags = new ArrayList<String>();

        LOG.info("inside get user search criteria in application");
        try
        {
            UserSearchCriteria userCriteria = UserSearchCriteriaLocalServiceUtil.getSearchCriteriaBySearchName(userId,
                    SEARCH_CRITERIA);
            if (userCriteria != null)
            {
                String searchCriteria = userCriteria.getSearchCriteria();
                //LOG.info("value of search criteria is "+searchCriteria+ "userId is"+userCriteria.getCreatorId());
                if (searchCriteria != null && searchCriteria.length() > 0)
                {
                    stdSearchCriteria = new StandardsSearchCriteria();
                    List<String> arlCriteria = new ArrayList<String>();
                    List<String> arlReplacedCriteria = new ArrayList<String>();
                    List<String> arlIdCriteria = new ArrayList<String>();
                    String[] criterias = searchCriteria.split(";");
                    for (String criteria : criterias)
                    {
                        String[] values = criteria.split(":");
                        if ("textSearch".equals(values[0]))
                        {
                            //String[] textSearches = criteria.split(":");
                            String textSearchValue = values[1];
                            LOG.info("value of text search is " + textSearchValue);
                            stdSearchCriteria.setTextSearch(textSearchValue);
                        }
                        if ("replacedTextSearch".equals(values[0]))
                        {
                            LOG.info("value of Replaced text search is " + values[1]);
                            stdSearchCriteria.setReplacedTextSearch(values[1]);
                        }
                        if (criteria.contains("textSearchType"))
                        {
                            String[] textSearchTypes = criteria.split(":");
                            String textSearchValue = textSearchTypes[1];
                            stdSearchCriteria.setTextSearchType(textSearchValue);
                            if ("all".equals(textSearchValue) || "any".equals(textSearchValue))
                            {
                                String searchValue = stdSearchCriteria.getTextSearch();
                                final StringTokenizer strTok = new StringTokenizer(searchValue, DELIMS);
                                while (strTok.hasMoreTokens())
                                {
                                    String value = strTok.nextToken();
                                    if (value.trim().length() > 0)
                                    {

                                        if (StandardsListUtil.isNumeric(value))
                                        {
                                            arlIdCriteria.add(value);
                                        }
                                        else
                                        {
                                            arlCriteria.add(value);
                                        }
                                    }
                                }
                            
                            /*if("exact".equals(textSearchValue)){// && arlCriteria.size()>0){
                            	arlCriteria= new ArrayList<String>();
                            	arlIdCriteria= new ArrayList<String>();
                            	arlCriteria.add(stdSearchCriteria.getTextSearch());
                            }*/	
                            }
                            else
                            {
                                arlCriteria.add(stdSearchCriteria.getTextSearch());
                            }
                            stdSearchCriteria.setSearchCriteria(arlCriteria);
                            stdSearchCriteria.setIdSearchCriteria(arlIdCriteria);
                        }
                        //CR Special Word Search
                        if (criteria.contains("replacedTextSearch") && stdSearchCriteria.getTextSearchType() != null)
                        {
                           if ("all".equals(stdSearchCriteria.getTextSearchType()) || "any".equals(stdSearchCriteria.getTextSearchType()))
                            {
                                String replacedSearchValue = stdSearchCriteria.getReplacedTextSearch();
                                final StringTokenizer strTok = new StringTokenizer(replacedSearchValue, DELIMS);
                                while (strTok.hasMoreTokens())
                                {
                                    String value = strTok.nextToken();
                                    if (value.trim().length() > 0)
                                    {

                                        if (StandardsListUtil.isNumeric(value))
                                        {
                                            arlIdCriteria.add(value);
                                        }
                                        else
                                        {
                                        	arlReplacedCriteria.add(value);
                                        }
                                    }
                                }
                           /* if("exact".equals(stdSearchCriteria.getTextSearchType())){// && arlReplacedCriteria.size()>0){
                            	arlReplacedCriteria= new ArrayList<String>();
                            	//arlIdCriteria= new ArrayList<String>();
                            	arlReplacedCriteria.add(stdSearchCriteria.getTextSearch());
                            }*/
                           }
                            else
                            {
                            	arlReplacedCriteria.add(stdSearchCriteria.getReplacedTextSearch());
                            }
                            stdSearchCriteria.setReplacedSearchCriteria(arlReplacedCriteria);
                            stdSearchCriteria.setIdSearchCriteria(arlIdCriteria);
                        }
                        
                        if (criteria.contains("hotelLifecycle"))
                        {
                            String[] hotelLifeCycleArr = criteria.split(":");
                            String lifeCycleValue = hotelLifeCycleArr[1];
                            String[] lifeCycleValues = lifeCycleValue.split(",");
                            List<String> arlHotelLifeCycles = new ArrayList<String>();
                            for (int i = 0; i < lifeCycleValues.length; i++)
                            {
                                arlHotelLifeCycles.add(lifeCycleValues[i]);
                            }
                            stdSearchCriteria.setHotelLifecycle(arlHotelLifeCycles);
                            arlFlags.addAll(arlHotelLifeCycles);
                        }
                        
                        if (criteria.contains("specialism"))
                        {
                            String[] specialismArr = criteria.split(":");
                            String specialismValue = specialismArr[1];
                            String[] specialismValues = specialismValue.split(",");
                            List<String> arlspecialisms = new ArrayList<String>();
                            for (int i = 0; i < specialismValues.length; i++)
                            {
                                arlspecialisms.add(specialismValues[i]);
                            }
                            stdSearchCriteria.setSpecialism(arlspecialisms);
                            arlFlags.addAll(arlspecialisms);
                        }

                        if (criteria.contains("hotelLocation"))
                        {
                            String[] hotelLocs = criteria.split(":");
                            String locValue = hotelLocs[1];
                            String[] locValues = locValue.split(",");
                            List<String> arlLocations = new ArrayList<String>();
                            for (int i = 0; i < locValues.length; i++)
                            {
                                arlLocations.add(locValues[i]);
                            }
                            stdSearchCriteria.setLocHotel(arlLocations);
                            arlFlags.addAll(arlLocations);
                        }
                        if (criteria.contains("deptApplicability"))
                        {
                            String[] depts = criteria.split(":");
                            String deptValue = depts[1];
                            String[] deptValues = deptValue.split(",");
                            List<String> arlDepts = new ArrayList<String>();
                            for (int i = 0; i < deptValues.length; i++)
                            {
                                arlDepts.add(deptValues[i]);
                            }
                            stdSearchCriteria.setDeptApplicability(arlDepts);
                            arlFlags.addAll(arlDepts);
                        }
                        if (criteria.contains("guestJourney"))
                        {
                            String[] guestJourneys = criteria.split(":");
                            String gJourney = guestJourneys[1];
                            String[] journey = gJourney.split(",");
                            List<String> arlLocations = new ArrayList<String>();
                            for (int i = 0; i < journey.length; i++)
                            {
                                arlLocations.add(journey[i]);
                            }
                            stdSearchCriteria.setGuestJourney(arlLocations);
                            arlFlags.addAll(arlLocations);
                        }
                        if (criteria.contains("Attachments"))
                        {
                            stdSearchCriteria.setHasAttachments(true);
                        }
                        if (criteria.contains("Links"))
                        {
                            stdSearchCriteria.setHasLinks(true);
                        }
                        if (criteria.contains("Images"))
                        {
                            stdSearchCriteria.setHasImages(true);
                        }
                        if (criteria.contains("SOP"))
                        {
                            stdSearchCriteria.setHasSOP(true);
                        }
                        if (criteria.contains("TM"))
                        {
                            stdSearchCriteria.setHasTrainingMaterial(true);
                        }
                        if (criteria.contains("compliance"))
                        {
                            String[] compliance = criteria.split(":");
                            String complianceValue = compliance[1];
                            stdSearchCriteria.setComplianceDeadline(complianceValue);
                        }
                    }
                    stdSearchCriteria.setFlags(arlFlags);
                }
            }
        }
        catch (SystemException se)
        {
            LOG.info("SystemException: ", se);
        }
        catch (Exception e)
        {
            LOG.info(EXCEPTION, e);
        }
        return stdSearchCriteria;
    }

    /**
     * @param userId The userId of the users.
     * @return StandardsDisplayOptions
     */
    public StandardsDisplayOptions getUserDisplayOptions(long userId)
    {
        StandardsDisplayOptions stdDisplayOptions = null;
        LOG.info("inside get user display option in application");
        try
        {
            UserSearchCriteria userCriteria = UserSearchCriteriaLocalServiceUtil.getSearchCriteriaBySearchName(userId,
                    DISPLAY_OPTIONS);
            if (userCriteria != null)
            {
                String displayOptionTxt = userCriteria.getSearchCriteria();
                //LOG.info("value of search criteria is "+searchCriteria+ "userId is"+userCriteria.getCreatorId());
                stdDisplayOptions = new StandardsDisplayOptions();
                if (displayOptionTxt != null && displayOptionTxt.length() > 0)
                {
                    stdDisplayOptions.setWhatsNew(!displayOptionTxt.contains("whatsNew"));
                    stdDisplayOptions.setCompDate(!displayOptionTxt.contains("compDate"));
                    stdDisplayOptions.setHighlight(displayOptionTxt.contains("highlight"));
                    stdDisplayOptions.setHotelLifeCycle(!displayOptionTxt.contains("hotelLifeCycle"));
                }
                else
                {
                    stdDisplayOptions.setWhatsNew(true);
                    stdDisplayOptions.setCompDate(true);
                    stdDisplayOptions.setHighlight(false);
                    stdDisplayOptions.setHotelLifeCycle(true);
                }
            }
        }
        catch (SystemException se)
        {
            LOG.info("SystemException: ", se);
        }
        catch (Exception e)
        {
            LOG.info(EXCEPTION, e);
        }
        return stdDisplayOptions;
    }

    /**
     * @param userId The userId of the users.
     * @param displayOptions StandardsDisplayOptions object
     * @return boolean
     */
    public boolean saveUserDisplayOptions(long userId, StandardsDisplayOptions displayOptions)
    {
        boolean flag = false;
        StringBuilder sbCriteria = new StringBuilder();
        try
        {
            boolean whatsNew = displayOptions.isWhatsNew();
            boolean compDate = displayOptions.isCompDate();
            boolean highlight = displayOptions.isHighlight();
            boolean hotelLifeCycle = displayOptions.isHotelLifeCycle();
            if (!whatsNew)
            {
                sbCriteria.append("whatsNew:false;");
            }
            if (!compDate)
            {
                sbCriteria.append("compDate:false;");
            }
            if (highlight)
            {
                sbCriteria.append("highlight:true;");
            }
            if (!hotelLifeCycle)
            {
                sbCriteria.append("hotelLifeCycle:false;");
            }
            String strCriteria = sbCriteria.toString();
            UserSearchCriteria userCriteria = UserSearchCriteriaLocalServiceUtil.getSearchCriteriaBySearchName(userId, DISPLAY_OPTIONS);
            LOG.debug("after getting userCriteria from db and b4 creating object to send to db value of displayoptions is " + sbCriteria);
            if (userCriteria != null)
            {
                userCriteria.setSearchCriteria(strCriteria);
                userCriteria.setUpdatedDate(new Date());
                UserSearchCriteriaLocalServiceUtil.updateUserSearchCriteria(userCriteria);
            }
            else
            {
                userCriteria = UserSearchCriteriaLocalServiceUtil.createUserSearchCriteria(CounterLocalServiceUtil.increment(UserSearchCriteria.class.getName()));
                userCriteria.setSearchName(DISPLAY_OPTIONS);
                userCriteria.setSearchCriteria(strCriteria);
                userCriteria.setCreatorId("" + userId);
                userCriteria.setCreatedDate(new Date());
                userCriteria.setUpdatedBy("" + userId);
                userCriteria.setUpdatedDate(new Date());
                userCriteria.setModuleName("OBSM");
                UserSearchCriteriaLocalServiceUtil.addUserSearchCriteria(userCriteria);
                LOG.debug("inside else of userid criteria not 0");
            }
        }
        catch (Exception e)
        {
            LOG.info(EXCEPTION, e);
        }
        return flag;
    }

    /**
     * This is separate sorting method for Referenced Standards/guidelines/Specifications of a standard. 
     * @param List object
     * @return Standards
     */
    public Standard sortRefStandardSpecsAndGdln(List standardDetails) {
        
        List<Standard> specsList= new ArrayList<Standard>();
        List<Standard> gdlnList = new ArrayList<Standard>();
        Standard std = null;
        if (Validator.isNotNull(standardDetails))
        {
            for (int i = 0; i < standardDetails.size(); i++)
            {
                Object[] obj = (Object[]) standardDetails.get(i);
                long standardId = ((BigDecimal) obj[0]).longValue();
                String standardTitle = (String) obj[1];
                String standardDesc = (String) obj[2];
                String standardType = (String) obj[3];
                long displayOrderNumber = ((BigDecimal) obj[4]).longValue();
                long prnt_std_id = ((BigDecimal) obj[5]).longValue();
                if ("STD".equals(standardType)) {
                    std = new Standard();
                    std.setStdId(standardId);
                    std.setTitle(standardTitle);
                    std.setDescription(standardDesc);
                    std.setStdType(standardType);
                    std.setDisplayOrder(displayOrderNumber);
                } else {
                    Standard specs = new Standard();
                     specs.setStdId(standardId);
                     specs.setTitle(standardTitle);
                     specs.setDescription(standardDesc);
                     specs.setStdType(standardType);
                     specs.setDisplayOrder(displayOrderNumber);
                     specs.setParentStdId(prnt_std_id);
                     if ("SPEC".equals(specs.getStdType()))
                     {
                            specsList.add(specs);
                     }
                     else if ("GDLN".equals(specs.getStdType()))
                     {
                         gdlnList.add(specs);
                     }
                }
            }
            Collections.sort(specsList, new StandardsSortableUtil.StandardSortBySTDId());
            Collections.sort(gdlnList, new StandardsSortableUtil.StandardSortBySTDId());
            std.setSpecifications(specsList);
            std.setGuidelines(gdlnList);
        }
        
        return std;
    }
}