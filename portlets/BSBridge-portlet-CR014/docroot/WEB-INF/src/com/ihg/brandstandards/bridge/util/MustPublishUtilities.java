package com.ihg.brandstandards.bridge.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.ihg.brandstandards.bridge.model.BridgePublishAppModel;
import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.NoSuchStandardsException;
import com.ihg.brandstandards.db.model.BridgeGlobalPublish;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.MustPublish;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsStatus;
import com.ihg.brandstandards.db.service.BridgeGlobalPublishCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.MustPublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/***
 * 
 * @author ketan.savaliya
 *
 */
public class MustPublishUtilities 
{
	
	private static final Log LOG = LogFactoryUtil.getLog(MustPublishUtilities.class);
	
	/**
	 * This method get records from BridgeGlobalPublish table and return List with sorting order
	 * @param brand
	 * @param isMustPublish
	 * @return List<MustPublishStandardsPojo>
	 */
	public static List<BridgePublishAppModel> getMustPublishStandardsList(RenderRequest renderRequest, String brand, boolean isMustPublish)
	{
		String findId = ParamUtil.getString(renderRequest, "findId");
        //String notFound = findId;
        String notFound = findId!=null && !findId.equals("")? findId: "";
        List<String> notFoundList = new LinkedList<String>( Arrays.asList(notFound.split(StringPool.SPACE)));
        List<MustPublish> mustPublishList = null;
        if (findId != null && !findId.isEmpty())
        {
            renderRequest.setAttribute("findId", findId);
            StringBuffer searchIdsHighlight = new StringBuffer();
            for (String id : findId.split(" "))
            {
                if (Validator.isNull(searchIdsHighlight.toString())) {
                	searchIdsHighlight.append("'");
                	searchIdsHighlight.append(id.trim());
                	searchIdsHighlight.append("'");
                } else {
                	searchIdsHighlight.append(",'");
                	searchIdsHighlight.append(id.trim());
                	searchIdsHighlight.append("'");
                }
            }
            renderRequest.setAttribute("highlightSearchIds", searchIdsHighlight.toString());
            mustPublishList = (List<MustPublish>) BridgeGlobalPublishLocalServiceUtil.getMustPublishStandardsByIdsAndBrand(findId.replaceAll(StringPool.SPACE, StringPool.COMMA), brand, isMustPublish);
        }
        else
        {
            mustPublishList = (List<MustPublish>) BridgeGlobalPublishLocalServiceUtil.getMustPublishStandardsByIdsAndBrand(null, brand, isMustPublish);
        }
		List<BridgePublishAppModel> display = new ArrayList<BridgePublishAppModel>();
		BridgePublishAppModel stdPojo = null;
		BridgePublishAppModel chiled= null;
		for (MustPublish mustPublish : mustPublishList ){
			if(BridgeConstants.TYPE_STD.equals(mustPublish.getStdType())){
				stdPojo = new BridgePublishAppModel();
				//notFound = notFound.replace(String.valueOf(mustPublish.getStdId()), StringPool.BLANK);
				notFoundList.remove(mustPublish.getStdId() + "");
				stdPojo.setStdId(mustPublish.getStdId());
				stdPojo.setTitle(mustPublish.getTitle());
				stdPojo.setTaxonomyPath(mustPublish.getPath().replace(mustPublish.getCurrentPath(),StringPool.BLANK));
				stdPojo.setCurrentPath(mustPublish.getCurrentPath());
				stdPojo.setRegionCode(mustPublish.getRegionCode());
				stdPojo.setAmer(mustPublish.getAmer());
				stdPojo.setAmea(mustPublish.getAmea());
				stdPojo.setEuro(mustPublish.getEuro());
				stdPojo.setGc(mustPublish.getGc());
				/// sort related fields
				stdPojo.setStatus(mustPublish.getStatus());
				stdPojo.setDisplayOrder(mustPublish.getDisplayOrder());
				stdPojo.setIndexOrder(mustPublish.getIndexOrder());
				stdPojo.setParentTaxonomyId(mustPublish.getParentTaxonomyId());
				stdPojo.setTaxonomyId(mustPublish.getTaxonomyId());
				stdPojo.setLevel(mustPublish.getLevel());
				stdPojo.setIndexSortOrder(mustPublish.getLevelSortOrder());
				stdPojo.setParentStdId(mustPublish.getParentId());
				stdPojo.setStdType(mustPublish.getStdType());
				stdPojo.setIsGlobal(mustPublish.getIsGlobal());
				stdPojo.setFramework(mustPublish.getFramework());
				//end sort related fields
				display.add(stdPojo);
			}	
		}
		
		updateIndexOrder(display);
		List<BridgePublishAppModel> sortedStandards = sortRecords(display);
		for (BridgePublishAppModel prnt : sortedStandards)
		{
			for (MustPublish mustPublish : mustPublishList )
			{
				if(mustPublish.getParentId() == prnt.getStdId() && !BridgeConstants.TYPE_STD.equals(mustPublish.getStdType()))
				{
					//notFound = notFound.replace(String.valueOf(mustPublish.getStdId()), StringPool.BLANK);
					notFoundList.remove(mustPublish.getStdId() + "");
					chiled = new BridgePublishAppModel();
					chiled.setStdId(mustPublish.getStdId());
					chiled.setTitle(mustPublish.getTitle());
					chiled.setTaxonomyPath(mustPublish.getPath().replace(mustPublish.getCurrentPath(),StringPool.BLANK));
					chiled.setCurrentPath(mustPublish.getCurrentPath());
					chiled.setRegionCode(mustPublish.getRegionCode());
					chiled.setAmer(mustPublish.getAmer());
					chiled.setAmea(mustPublish.getAmea());
					chiled.setEuro(mustPublish.getEuro());
					chiled.setGc(mustPublish.getGc());
					chiled.setIsGlobal(mustPublish.getIsGlobal());
					chiled.setFramework(mustPublish.getFramework());
					prnt.setChieldIds(prnt.getChieldIds().concat(String.valueOf(mustPublish.getStdId()).concat(StringPool.COMMA))); //This ids will use while delete parent
					if (BridgeConstants.TYPE_GDLN.equals(mustPublish.getStdType()))
					{
						List<BridgePublishAppModel> gndl = prnt.getGuidelines();
						gndl.add(chiled);
						prnt.setGuidelines(gndl);
					} 
					else 
					{
						List<BridgePublishAppModel> spec = prnt.getSpecifications();
						spec.add(chiled);
						prnt.setSpecifications(spec);
					}
				}	
			}
			Collections.sort(prnt.getSpecifications(), new SpecsGuidelinesSortBySTDId());
            Collections.sort(prnt.getGuidelines(), new SpecsGuidelinesSortBySTDId());
		}
		//renderRequest.setAttribute("notFound", notFound.trim().replace(StringPool.SPACE, StringPool.COMMA));
		notFound = Arrays.toString(notFoundList.toArray());
		notFound = notFound.replace("[", StringPool.BLANK).replace("]", StringPool.BLANK);
		renderRequest.setAttribute("notFound", notFound.trim());
		return sortedStandards;
	}
	
	/**
	 * Update IndexOrder for standards
	 * @param display
	 */
	public static void updateIndexOrder(List<BridgePublishAppModel> display) {
        final List<PublishStandardsExt> indexes = PublishStandardsExtLocalServiceUtil.getCMSAllIndexes();
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

        for (BridgePublishAppModel std : display)
        {
            PublishStandardsExt rec = indexMap.get(std.getTaxonomyId());
            if (rec != null)
            {
                std.setIndexOrder(rec.getIndexOrder());
            }
        }
		
	}
	
	/**
     * Sort records.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
	public static List<BridgePublishAppModel> sortRecords(List<BridgePublishAppModel> standards) {
		sortRecordsByIndex(standards);
        List<BridgePublishAppModel> sortedStandards = sortStdRecordsUnderIndex(standards);
        return sortedStandards;
	}
	
	 /**
     * Sort records.
     * 
     * @param standards - MustPublishStandardsPojo List
     */
	private static List<BridgePublishAppModel> sortStdRecordsUnderIndex(List<BridgePublishAppModel> standards)
    {
        Map<Long, Map<Long, List<BridgePublishAppModel>>> indexRecords = new LinkedHashMap<Long, Map<Long, List<BridgePublishAppModel>>>();

        for (BridgePublishAppModel std : standards)
        {
            Map<Long, List<BridgePublishAppModel>> indexItem = indexRecords.get(std.getTaxonomyId());
            // no Index found
            if (indexItem == null)
            {
                // create map to store Standard
                indexItem = new LinkedHashMap<Long, List<BridgePublishAppModel>>();
                List<BridgePublishAppModel> stdItem = new ArrayList<BridgePublishAppModel>();
                stdItem.add(std);
                indexItem.put(std.getStdId(), stdItem);
                // create Index item with Standard
                indexRecords.put(std.getTaxonomyId(), indexItem);
            }
            // found Index; add Standard, Specification or Guideline
            else
            {
                List<BridgePublishAppModel> stdItem = indexItem.get(std.getParentStdId());
                // this is should be Standard. For Specification and Guideline stdItem should NOT be null
                if (stdItem == null)
                {
                    stdItem = new ArrayList<BridgePublishAppModel>();
                    indexItem.put(std.getStdId(), stdItem);
                }
                stdItem.add(std);
            }
        }

        List<BridgePublishAppModel> sortedList = new ArrayList<BridgePublishAppModel>();
        List<BridgePublishAppModel> tmpList = new ArrayList<BridgePublishAppModel>();
        for (Map.Entry<Long, Map<Long, List<BridgePublishAppModel>>> indexEntry : indexRecords.entrySet())
        {
            tmpList.clear();
            // Standards for Index  === <prnt_std_id, list of Records> first records is a Standard
            Map<Long, List<BridgePublishAppModel>> stdRecords = indexEntry.getValue();
            for (Map.Entry<Long, List<BridgePublishAppModel>> stdEntry : stdRecords.entrySet())
            {
                List<BridgePublishAppModel> recordsList = stdEntry.getValue();
                if (recordsList != null && !recordsList.isEmpty())
                {
                    for (BridgePublishAppModel rec : recordsList)
                    {
                        //Standards rec = recordsList.get(0);
                        if (BSCommonConstants.STD_TYPE_STANDARD.equals(rec.getStdType()))
                        {
                            tmpList.add(rec);
                        }
                        else
                        {
                            LOG.error("Found ==" + rec.getStdType() + " in index 0, publish std id=" + rec.getStdId());
                        }
                    }
                }
            }

            sortStdBySortOrder(tmpList);
            for (BridgePublishAppModel std : tmpList)
            {
                List<BridgePublishAppModel> stdItems = stdRecords.get(std.getStdId());
                sortedList.addAll(stdItems);
            }
        }
        return sortedList;
    }
	
	/**
     * Sort records.
     * 
     * @param standards -MustPublishStandardsPojo List
     */
	private static void sortStdBySortOrder(List<BridgePublishAppModel> standards)
    {
        Collections.sort(standards, new Comparator<BridgePublishAppModel>()
        {
            
            public int compare(BridgePublishAppModel s1, BridgePublishAppModel s2)
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
     * Sort records.
     * 
     * @param standards -MustPublishStandardsPojo List
     */
	private static void sortRecordsByIndex(List<BridgePublishAppModel> standards)
    {
        Collections.sort(standards, new Comparator<BridgePublishAppModel>()
        {
            public int compare(BridgePublishAppModel s1, BridgePublishAppModel s2)
            {
                int res = compareLong(s1.getIndexOrder(), s2.getIndexOrder());
                if (res == 0)
                {
                    if (s1.getStdId() == 0 && s2.getStdId() == 0)
                    {
                        return 0;
                    }
                    res = compareLong(s1.getParentStdId(), s2.getParentStdId());
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
                                res = compareLong(s1.getStdId(), s2.getStdId());
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
                    if (BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && !BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_SPEC.equals(t1) && !BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_SPEC.equals(t1) && BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSCommonConstants.STD_TYPE_SPEC.equals(t1) && BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(t1) && BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(t1) && !BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_GDLN.equals(t1) && BSCommonConstants.STD_TYPE_GDLN.equals(t2))
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
     * @author Ketan.savaliya
     */
    static class SpecsGuidelinesSortBySTDId implements Comparator<BridgePublishAppModel>
    {
        /**
         * @param o1 - Standards objects.
         * @param o2 - Standards objects.
         * @return integer.
         */
        public int compare(BridgePublishAppModel o1, BridgePublishAppModel o2)
        {
            int res = 0;
            if (o1.getDisplayOrder() > 0L || o2.getDisplayOrder() > 0L)
            {
                Long object1 = o1.getDisplayOrder();
                Long object2 = o2.getDisplayOrder();
                res = object1.compareTo(object2);
            }
            else
            {
                Long object1 = o1.getStdId();
                Long object2 = o2.getStdId();
                res = object1.compareTo(object2);
            }

            return res;
        }
    }
    
	/**
	 * This method is use for entry adding to BridgeGlobalPublish
	 * @param stdIds
	 * @param brand
	 * @param userId
	 * @param activePublishId
	 * @param isMustPublish
	 */
	public static void importStandards(List<Long> stdIds, String brand, long userId, long activePublishId, String isMustPublish)
	{
		BridgeGlobalPublish mustPublish = null;
		Standards std = null;
		Standards parentStd = null;
		Map<Long,Boolean> parentsIds = new LinkedHashMap<Long, Boolean>(); //to maintain 1)process parents only once's while have multiple child's exist, 2) ignore GNDL/SPEC if parent is not added
		for (Long stdId : stdIds)
		{
			try 
			{
				 std = validateStandards(stdId, brand);
				 if (std != null)
				 {
					 //Bellow block is process only missing standards while adding standards in bulks part of fixing QC #1030
					 if ("Y".equals(isMustPublish) && !BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdTyp()) && !parentsIds.containsKey(std.getParentId())) // if parent not exist/process then add first
					 {
						 parentsIds.put(std.getParentId(),false);
						 parentStd = validateStandards(std.getParentId(), brand);
						 if (parentStd != null)
						 {
							 addParentStdIntoMustpublish(activePublishId, parentStd, isMustPublish, userId);
							 parentsIds.put(std.getParentId(),true);
						 }
					 }
					 mustPublish = BridgeGlobalPublishLocalServiceUtil.getByPublishIdAndStdId(activePublishId, stdId);
					 if (mustPublish == null && !parentsIds.containsKey(stdId))
					 {
						 if("N".equals(isMustPublish) || 
						   ("Y".equals(isMustPublish) && 
						   (BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdTyp()) || 
						   (!BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdTyp()) && parentsIds.get(std.getParentId())))))
						 {
							 addStandardsIntoMustPublish(mustPublish, userId, isMustPublish, activePublishId, stdId);
							 if (BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdTyp()))
							 {
								 parentsIds.put(stdId,true);
							 }
						 }
					 }
					
				}
			} catch (SystemException e) {
				LOG.info("Error during (Must/Must Not publish) Import : (StdId) " + stdId);
				LOG.error(StackTraceUtil.getStackTrace(e));
			}
		}
	}
    
    /**
     * This method will validate search stdId
     * @param stdIds
     * @param brand
     * @param isMust
     * @return String validation message
     * @throws SystemException
     * @throws PortalException
     */
    public static String getValidationMessage(long publishId, String stdIds, String brand, boolean isMust) throws SystemException, PortalException{
    	String messageText = StringPool.BLANK;
    	if (stdIds !=null && !StringPool.BLANK.equals(stdIds)){
			try {
				com.ihg.brandstandards.db.model.Standards std = StandardsLocalServiceUtil.getStandards(Long.valueOf(stdIds));
				if(std != null) { 
					try {
						ChainStandards cs = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(Long.valueOf(stdIds), brand);
						if(cs == null){
							messageText = "Standard ID [" + stdIds + "] not a [" +BrandStandardsUtil.chainCodeMap().get(brand) + "] Standard";
						} else if(validateStandards(Long.valueOf(stdIds), brand) == null){
							messageText = "Standard ID [" + stdIds + "] is Discontinued/Insight Required. You can not publish this Standard ID";
						} else if(isMust) {
							if(BridgeGlobalPublishLocalServiceUtil.getByStdIdAndMustPublishInd(publishId, Long.valueOf(stdIds), "N") != null){
								messageText = "Standard ID [" + stdIds + "] cannot be added as Global have mandated as must not publish. You can not publish this Standard ID";
							}
							else if(!BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdTyp())){
								if(!BridgeConstants.GLOBAL.equals(std.getRegionCode())){
									messageText = "Standard ID [" + stdIds + "] can not be added as global must standard.";
								}
							}
							else if(!BridgeConstants.GLOBAL.equals(std.getRegionCode())){
								messageText = "Standard ID [" + stdIds + "] can not be added as global must standard.";
							}
						} else if(!isMust){
							Standards addByIdSTD = StandardsLocalServiceUtil.getStandards(Long.valueOf(stdIds));
							if(addByIdSTD != null && !BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdTyp())){
								if(BridgeGlobalPublishLocalServiceUtil.getByStdIdAndMustPublishInd(publishId, Long.valueOf(stdIds), "Y") != null){
									messageText = "Standard ID [" + stdIds + "] cannot be added as Global have mandated as must publish. You can not publish this Standard ID";
								} else if(validateStandards(Long.valueOf(addByIdSTD.getParentId()), brand) == null){
									messageText = "Standard ID [" + stdIds + "] parent Standard ID [" + addByIdSTD.getParentId() + "] is Discontinued/Insight Required. You can not publish this Standard ID";
								} else if(BridgeGlobalPublishLocalServiceUtil.getByStdIdAndMustPublishInd(publishId, addByIdSTD.getParentId(), "Y") == null){
									messageText = "Standard ID [" + stdIds + "] cannot be added as it's parent standard is not a global must publish standard.";
								}
							} else if(BridgeGlobalPublishLocalServiceUtil.getByStdIdAndMustPublishInd(publishId, addByIdSTD.getParentId(), "Y") == null){
								messageText = "Standard ID [" + stdIds + "] cannot be added as it's parent standard is not a global must publish standard.";
							}
						}
					} catch (NoSuchChainStandardsException e){
						messageText = "Standard ID [" + stdIds + "] not a [" +BrandStandardsUtil.chainCodeMap().get(brand) + "] Standard";
					}
				} else {
					messageText = "Standard ID [" + stdIds + "] not found in CMS";
				}
				
			} catch(NoSuchStandardsException e){
				messageText = "Standard ID [" + stdIds + "] not found in CMS";
			}
		}
    	return messageText;
    }
    
    /**
     * This method will use to fill pojo list from db data list
     * @param list
     * @param display
     * @return boolean i.e. if standards entirely Added then true else false
     */
    public static boolean fillAddByIdSearchPojoList(List<BridgePublishPreview> list, List<BridgePublishAppModel> display){
    	boolean isEntirelyAdded = true;
    	BridgePublishAppModel stdPojo = null;
    	BridgePublishAppModel chiled= null;
		for (BridgePublishPreview mustPublish : list ){
			if(BridgeConstants.TYPE_STD.equals(mustPublish.getType())){
				stdPojo = new BridgePublishAppModel();
				stdPojo.setStdId(mustPublish.getStdId());
				stdPojo.setParentStdId(mustPublish.getParentStdId());
				stdPojo.setTitle(HtmlUtil.escape(mustPublish.getTitle()));
				stdPojo.setStdType(mustPublish.getType());
				stdPojo.setTaxonomyPath(mustPublish.getPath().replace(mustPublish.getTaxonomyTitle(), StringPool.BLANK));
				stdPojo.setCurrentPath(mustPublish.getTaxonomyTitle());
				stdPojo.setRegionCode(mustPublish.getCurrentTitle()); //RegionCode contain PublishId of BridgeGloblePublish
				if("-1".equals(mustPublish.getCurrentTitle())){
					isEntirelyAdded = false;
				}
				display.add(stdPojo);
			}	
		}
		
		for (BridgePublishAppModel prnt : display){
			for (BridgePublishPreview mustPublish : list  ){
				if(mustPublish.getParentStdId()==prnt.getStdId() && !BridgeConstants.TYPE_STD.equals(mustPublish.getType())){
					chiled = new BridgePublishAppModel();
					chiled.setStdId(mustPublish.getStdId());
					chiled.setParentStdId(mustPublish.getParentStdId());
					chiled.setTitle(HtmlUtil.escape(mustPublish.getTitle()));
					chiled.setStdType(mustPublish.getType());
					chiled.setTaxonomyPath(mustPublish.getPath().replace(mustPublish.getTaxonomyTitle(), StringPool.BLANK));
					chiled.setCurrentPath(mustPublish.getTaxonomyTitle());
					chiled.setRegionCode(mustPublish.getCurrentTitle());//CurrentTitle contain PublishId of BridgeGloblePublish
					if("-1".equals(mustPublish.getCurrentTitle())){
						isEntirelyAdded = false;
					}
					prnt.setChieldIds(prnt.getChieldIds().concat(String.valueOf(mustPublish.getStdId()).concat(StringPool.COMMA))); //This ids will use while delete parent
					if (BridgeConstants.TYPE_GDLN.equals(mustPublish.getType())){
						List<BridgePublishAppModel> gndl = prnt.getGuidelines();
						gndl.add(chiled);
						prnt.setGuidelines(gndl);
					} else {
						List<BridgePublishAppModel> spec = prnt.getSpecifications();
						spec.add(chiled);
						prnt.setSpecifications(spec);
					}
				}	
			}
			 
		}
		return isEntirelyAdded;
    }
    
	/**
     * This method will return portlet Preferences
     * @param renderRequest
     * @return PortletPreferences
     */
    public static PortletPreferences getPreferances(PortletRequest renderRequest)
    {
		try {
			return PortletPreferencesFactoryUtil.getPortletSetup(renderRequest);
		} catch (PortalException e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		} catch (SystemException e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		}
		return null;
    }
    
    /**
     * This method return Active PublishId from BrandCode
     * @param brand
     * @return long
     */
    public static long getActivePublishIdByBrand(String brand)
    {
    	Publication  publication = PublicationLocalServiceUtil.getPublishObjectByBrand(brand, BridgeConstants.BRIDGE_ENVIRONMENT, BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE);
		if(publication!=null)
		{
			return publication.getPublishId();
		}
		return 0;
    }
    
    /**
     * This method will process update country request from controller
     * @param actionRequest
     * @return
     */
    public static String updateCountry(ActionRequest actionRequest)
    {
    	long bridgeGlobalPublishId = ParamUtil.getLong(actionRequest, "bridgeGlobalPublishId");
		String[] country = actionRequest.getParameterValues("country");
		String regionCode = actionRequest.getParameter("regionCode");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return updateCountry(bridgeGlobalPublishId, country, regionCode, themeDisplay); 
    }

    /**
     * Update status of BridgeGlobalPublishCountry entry into DB
     * @param bridgeGlobalPublishId
     * @param country
     * @return
     */
    private static String updateCountry(long bridgeGlobalPublishId, String[] country, String regionCode, ThemeDisplay themeDisplay)
    {
        String error = StringPool.BLANK;
        long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        List<BridgeGlobalPublishCountry> countryList = new ArrayList<BridgeGlobalPublishCountry>();
		try {
				//countryList = BridgeGlobalPublishCountryLocalServiceUtil.getCountriesByGlobalPublishId(bridgeGlobalPublishId);
				countryList = BridgeGlobalPublishLocalServiceUtil.getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(bridgeGlobalPublishId, regionId);
				boolean isChange = false;
				for (BridgeGlobalPublishCountry bridgeCountry : countryList)
				{
					isChange = false;
					if (ArrayUtil.contains(country, bridgeCountry.getCountryCode()))
					{
						if(bridgeCountry.getPublishInd().equals("N"))
						{
							bridgeCountry.setPublishInd("Y");
							bridgeCountry.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
							bridgeCountry.setUpdatedDate(new Date());
							isChange = true;
						}
					} 
					else
					{
						if(bridgeCountry.getPublishInd().equals("Y"))
						{
							bridgeCountry.setPublishInd("N");
							bridgeCountry.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
							bridgeCountry.setUpdatedDate(new Date());
							isChange = true;
						}
					}
					if(isChange)
					{
						BridgeGlobalPublishCountryLocalServiceUtil.updateBridgeGlobalPublishCountry(bridgeCountry);
					}
				}
		} catch (SystemException e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
			error = e.getMessage();
		}
        return error;
    }
    
    /**
     * Method will process delete mustpublish request, and delete DB recored
     * @param actionRequest
     * @param actionResponse
     * @return
     */
    public static String deleteMustPublishStandrd(ActionRequest actionRequest, ActionResponse actionResponse, String brand)
    {
    	String error = StringPool.BLANK;
		String stdId = ParamUtil.getString(actionRequest, "stdId");
		long[] stdIds = StringUtil.split(stdId,StringPool.COMMA,1L);
		long publishId = MustPublishUtilities.getActivePublishIdByBrand(brand);
		String query = null;
		for(long id : stdIds)
		{
			BridgeGlobalPublish mustPublish = BridgeGlobalPublishLocalServiceUtil.getByPublishIdAndStdId(publishId, id);
			if(mustPublish != null)
			{
				try 
				{
					//Delete child country entries
					deleteBridgeGlobalPublishCountryForStandards(mustPublish.getGlobalPublishId());
					
					BridgeGlobalPublishLocalServiceUtil.deleteBridgeGlobalPublish(mustPublish);
					LOG.debug("Bridge_Global_Publish Stdid [" + id + "] deleted");
					//Delete regional record countries
					query = BridgeQueryUtils.getDeleteRegionalRecordCountriesQuery(publishId, id);
					if (LOG.isDebugEnabled()) {
						LOG.debug("Query to delete regional record countries :"+query);
					}
					MustPublishLocalServiceUtil.deleteRegionalRecordCountries(query);
					if (LOG.isDebugEnabled()) {
						LOG.debug("Countries delete for regional record :"+id);
					}
					
				} 
				catch (SystemException e) 
				{
					LOG.error(StackTraceUtil.getStackTrace(e));
					error = e.getMessage();
				}
			}
		}
		return error;
    }
    
    /**
     * Method will use to add child BridgeGlobalPublishCountry entries for BridgeGlobalPublish Standards.
     * @param stdId
     * @param bridgeGlobalPublish
     * @param userId
     * @throws SystemException
     */
    private static void addBridgeGlobalPublishCountryForStandards(long stdId, BridgeGlobalPublish bridgeGlobalPublish, long userId) throws SystemException
    {
    	List<CountryStandards> stdCoutnryList = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(stdId);
		for(CountryStandards country : stdCoutnryList)
		{
			BridgeGlobalPublishCountry bridgeGlobalPublishCountry = BridgeGlobalPublishLocalServiceUtil.getNewBridgeGlobalPublishCountry();
			bridgeGlobalPublishCountry.setGlobalPublishId(bridgeGlobalPublish.getGlobalPublishId());
			bridgeGlobalPublishCountry.setCountryCode(country.getCountry());
			bridgeGlobalPublishCountry.setPublishInd("Y");
			bridgeGlobalPublishCountry.setCreatorId(String.valueOf( userId));
			bridgeGlobalPublishCountry.setCreatedDate(new Date());
			bridgeGlobalPublishCountry.setUpdatedBy(String.valueOf( userId));
			bridgeGlobalPublishCountry.setUpdatedDate(new Date());
			BridgeGlobalPublishCountryLocalServiceUtil.updateBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
			LOG.debug("BridgeGlobalPublishCountry Created  : (StdId) " + stdId + ", (GlobalPublishId) " + bridgeGlobalPublish.getGlobalPublishId());
		}
    }
    
    /**
     * Remove child entries from DB for BridgeGlobalPublish standards
     * @param globalPublishId
     * @throws SystemException
     */
    private static void deleteBridgeGlobalPublishCountryForStandards(long globalPublishId) throws SystemException
    {
    	List<BridgeGlobalPublishCountry> countryList = BridgeGlobalPublishCountryLocalServiceUtil.getCountriesByGlobalPublishId(globalPublishId);
		for (BridgeGlobalPublishCountry country : countryList)
		{
			BridgeGlobalPublishCountryLocalServiceUtil.deleteBridgeGlobalPublishCountry(country);
			LOG.debug("Bridge_Global_Publish_Country GlobalPublishId [" + country.getGlobalPublishId()+ "] with [" + country.getCountryCode() + "] deleted");
		}
    }
    
    /**
     * This method will use to add parent automatically if not exist 
     * @param publishId
     * @param std
     * @param isMustPublish
     * @param userId
     * @throws SystemException
     */
    private static void addParentStdIntoMustpublish(long publishId, Standards std, String isMustPublish, long userId) throws SystemException
    {
    	BridgeGlobalPublish parentMustPublish = BridgeGlobalPublishLocalServiceUtil.getByPublishIdAndStdId(publishId, std.getStdId());
		if (parentMustPublish == null)
		{
			addStandardsIntoMustPublish(parentMustPublish, userId, isMustPublish, publishId, std.getStdId());
		}
    }
    
    /**
     * Add entries into DB for BridgeGlobalPublish
     * @param mustPublish
     * @param userId
     * @param isMustPublish
     * @param publishId
     * @param stdId
     * @throws SystemException
     */
    private static void addStandardsIntoMustPublish(BridgeGlobalPublish mustPublish, long userId, String isMustPublish, long publishId, long stdId ) throws SystemException
    {
    	mustPublish = BridgeGlobalPublishLocalServiceUtil.getNewBridgeGlobalPublish();
		mustPublish.setCreatedDate(new Date());
		mustPublish.setCreatorId(String.valueOf( userId));
		mustPublish.setMustPublishInd(isMustPublish);
		mustPublish.setPublishId(publishId);
		mustPublish.setStdId(stdId);
		mustPublish.setUpdatedBy(String.valueOf( userId));
		mustPublish.setUpdatedDate(new Date());
		
		BridgeGlobalPublishLocalServiceUtil.updateBridgeGlobalPublish(mustPublish);
		LOG.info("Mustpublish Import : (StdId) " + stdId);
		addBridgeGlobalPublishCountryForStandards(stdId, mustPublish, userId);
    }
    
    /**
     * Validate Standards for MustPublish
     * @param stdId
     * @param brand
     * @return
     */
    private static Standards validateStandards(long stdId, String brand)
    {
    	try {
    		Standards std = StandardsLocalServiceUtil.getStandards(stdId);
    		ChainStandards chainStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(stdId, brand);
    		StandardsStatus stdStatus = null;
			if (chainStd != null)  {
				stdStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chainStd.getStatusId());
			}
			if(std != null && stdStatus != null && !(BridgeConstants.STD_STATUS_CD_DELETE.equals(std.getStatus()) || 
			        BridgeConstants.STD_STATUS_CD_D_FOR_REF.equals(stdStatus.getStatusCode()) ||
			        BridgeConstants.STD_STATUS_CD_D_NOT_RQ.equals(stdStatus.getStatusCode()) ||
			        BridgeConstants.STD_STATUS_CD_D_RPLCD.equals(stdStatus.getStatusCode()) ||
			        BridgeConstants.STD_STATUS_CD_INST_RQ.equals(stdStatus.getStatusCode()) ) )
			{
				return std;
			}
			
	    } catch (SystemException e) {
			LOG.info("Error during (Must/Must Not publish) Validation : (StdId) " + stdId);
			LOG.error(StackTraceUtil.getStackTrace(e));
		} catch (PortalException e) {
			LOG.info("Error during (Must/Must not publish) Validation : (StdId) " + stdId);
			LOG.error(StackTraceUtil.getStackTrace(e));
		}
    	return null;
    }
    
    public static long getIssueCount(String isMustPublish,long publishId, String brand )
    {
        long noOfUnattrBrandIds = 0;
        long noOfRemovedRegionIds = 0;
        
        Map<String, Long> overAllIssues =  BridgeGlobalPublishLocalServiceUtil.getTotalIssuesforMustpublish(isMustPublish, publishId, brand);

        if (overAllIssues != null && !overAllIssues.isEmpty())
        {
            if (overAllIssues.get(BridgeConstants.COUNT_GLOBAL_MUST_BRAND) != null)
            {
            	noOfUnattrBrandIds = overAllIssues.get(BridgeConstants.COUNT_GLOBAL_MUST_BRAND);
            }
            if (overAllIssues.get(BridgeConstants.COUNT_GLOBAL_MUST_REGION) != null)
            {
            	noOfRemovedRegionIds = overAllIssues.get(BridgeConstants.COUNT_GLOBAL_MUST_REGION);
            }
             
        }

        return (noOfUnattrBrandIds + noOfRemovedRegionIds) ;
        
    }
}
