package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.custom.model.StandardBase;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class StandardsSortableUtil 
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsSortableUtil.class);
    
    public static List<Standard> sort(List<Standard> arlDisplayStandards, List<PublishStandardsExt> arlDisplayResults)
    {
        StandardsSortableUtil sortable = new StandardsSortableUtil();
        return sortable.sortRecords(arlDisplayStandards, arlDisplayResults);
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public static List<Standard> sort(List<Standard> standards)
    {
        StandardsSortableUtil sortable = new StandardsSortableUtil();
        sortable.updateIndexOrder(standards);
        return sortable.sortRecords(standards);
    }

    private List<Standard> sortRecords(List<Standard> arlDisplayStandards, List<PublishStandardsExt> arlDisplayResults)
    {
        for (PublishStandardsExt publishStd : arlDisplayResults)
        {
            Standard standards = new Standard();
            if (BSCommonConstants.STD_TYPE_STANDARD.equals(publishStd.getStdTyp()))
            {
                populateStdData(publishStd, standards);
                //set std ref
                standards.setStdRefId(publishStd.getStdXrefListStdId());
                arlDisplayStandards.add(standards);
            }
        }

        updateIndexOrder(arlDisplayStandards);
        List<Standard> sortedStandards = sortRecords(arlDisplayStandards);
        for (Standard standards : sortedStandards)
        {
            List<Standard> arlSpecs = new ArrayList<Standard>();
            List<Standard> arlGdlns = new ArrayList<Standard>();
            for (PublishStandardsExt publishStd : arlDisplayResults)
            {
                populateSpecGdlnDdata(standards, arlSpecs, arlGdlns, publishStd);
            }
            Collections.sort(arlSpecs, new StandardSortBySTDId());
            Collections.sort(arlGdlns, new StandardSortBySTDId());
            standards.setSpecifications(arlSpecs);
            standards.setGuidelines(arlGdlns);
        }
        return sortedStandards;
    }

    private void populateStdData(PublishStandardsExt publishStd, Standard standards)
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
        standards.setParentStdId(publishStd.getParentPublishId());
        standards.setTitle(publishStd.getTitle());
        standards.setDescription(publishStd.getDescription());
        standards.setStdType(publishStd.getStdTyp());
        standards.setStatus(publishStd.getStatus());
        standards.setDisplayOrder(publishStd.getSortOrder());
        standards.setFramework(publishStd.getFramework());
        standards.setIsGlobal(publishStd.getIsGlobal());
        standards.setRegionCode(publishStd.getRegionCode());
        standards.setRemovable(publishStd.isRemovable());
        standards.setErrorType(publishStd.getErrorType());
    }

    private void populateSpecGdlnDdata(Standard standards, List<Standard> arlSpecs, List<Standard> arlGdlns,
            PublishStandardsExt publishStd)
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
            specs.setRemovable(publishStd.isRemovable());
            specs.setErrorType(publishStd.getErrorType());
            //standard ref
            specs.setStdRefId(publishStd.getStdXrefListStdId());
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

    /**
     * @param standards -Standards List
     * @param chainCd -Brand Code
     * @param environment - Environment information
     * @throws SystemException throws System Exception
     */
    private void updateIndexOrder(List<Standard> standards)
    {
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

        for (Standard std : standards)
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
    private List<Standard> sortRecords(List<Standard> standards)
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
    private void sortRecordsByIndex(List<Standard> standards)
    {
        Collections.sort(standards, new Comparator<Standard>()
        {
            public int compare(Standard s1, Standard s2)
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
     * Sort Standards Under each Index by specified sort order.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    private List<Standard> sortStdRecordsUnderIndex(List<Standard> standards)
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
                indexItem.put(std.getStdId(), stdItem);
                // create Index item with Standard
                indexRecords.put(std.getTaxonomyId(), indexItem);
            }
            // found Index; add Standard, Specification or Guideline
            else
            {
                List<Standard> stdItem = indexItem.get(std.getParentStdId());
                // this is should be Standard. For Specification and Guideline stdItem should NOT be null
                if (stdItem == null)
                {
                    stdItem = new ArrayList<Standard>();
                    indexItem.put(std.getStdId(), stdItem);
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
                    for (Standard rec : recordsList)
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
            for (Standard std : tmpList)
            {
                List<Standard> stdItems = stdRecords.get(std.getStdId());
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
     * @author Lakshminarayana
     */
    public static class StandardSortBySTDId implements Comparator<Standard>
    {
        /**
         * @param o1 - Standards objects.
         * @param o2 - Standards objects.
         * @return integer.
         */
        public int compare(Standard o1, Standard o2)
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
}
