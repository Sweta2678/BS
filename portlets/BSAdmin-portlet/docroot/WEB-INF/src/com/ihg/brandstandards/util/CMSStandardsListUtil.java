package com.ihg.brandstandards.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.portlet.ResourceRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.ihg.brandstandards.db.NoSuchFlagCategoryException;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsChainImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK;
import com.ihg.brandstandards.xml.metadata.FieldType;
import com.ihg.brandstandards.xml.metadata.Metadata;
import com.ihg.brandstandards.xml.metadata.MetadataValidationEventHandler;
import com.ihg.brandstandards.xml.metadata.ObjectFactory;
import com.ihg.brandstandards.xml.metadata.ParamList;
import com.ihg.brandstandards.xml.metadata.ParamType;
import com.ihg.brandstandards.xml.metadata.Search;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class CMSStandardsListUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(CMSStandardsListUtil.class);

    public static List<StandardsChainImages> getStandardsImagesByStdIdChaincode(long stdId, String chainCode)
            throws SystemException
    {
        List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(stdId);
        List<StandardsChainImages> stdChainImages = new ArrayList<StandardsChainImages>();
        StandardsChainImages stdChainImage = null;
        for (StandardsImages stdImage : stdImgs)
        {
            StandardsChainImagesPK standardsChainImagesPK = new StandardsChainImagesPK(stdImage.getStdImageId(), chainCode);
            try
            {
                stdChainImage = StandardsChainImagesLocalServiceUtil.getStandardsChainImages(standardsChainImagesPK);
                stdChainImages.add(stdChainImage);
            }
            catch (Exception e)
            {
                LOG.warn(e.getMessage());
            }

        }
        return stdChainImages;
    }

    /**
     * Sort records for report.
     * 
     * @param standards - list of standards
     */
    public static void sortRecords(List<StandardsExt> standards)
    {
        Collections.sort(standards, new Comparator<StandardsExt>()
        {
            public int compare(StandardsExt s1, StandardsExt s2)
            {
                int res = compareLong(s1.getIndexOrder(), s2.getIndexOrder());
                if (res == 0)
                {
                    if (s1.getStdId() == 0 && s2.getStdId() == 0)
                    {
                        return 0;
                    }
                    res = compareLong(s1.getStdPrntId(), s2.getStdPrntId());
                    if (res == 0)
                    {
                        res = compareRecordType(s2.getStdType(), s1.getStdType());
                        if (res == 0)
                        {
                            if (s1.getStdOrderNumber() > 0L || s2.getStdOrderNumber() > 0L)
                            {
                                res = compareLong(s1.getStdOrderNumber(), s2.getStdOrderNumber());
                            }
                            else
                            {
                                res = compareLong(s1.getStdId(), s2.getStdId());
                            }
                            if (res == 0)
                            {
                                // sort descending on Audit Log Date
                                if (s2.getAuditLogDate() != null && s1.getAuditLogDate() != null)
                                {
                                    return compareLong(s2.getAuditLogDate().getTime(), s1.getAuditLogDate().getTime());
                                }
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
                    if ("STD".equals(t1) && !"STD".equals(t2))
                    {
                        return 1;
                    }
                    else if (!"STD".equals(t1) && "STD".equals(t2))
                    {
                        return -1;
                    }
                    else if ("STD".equals(t1) && "STD".equals(t2))
                    {
                        return 0;
                    }
                    else if ("SPEC".equals(t1) && !"SPEC".equals(t2))
                    {
                        return 1;
                    }
                    else if (!"SPEC".equals(t1) && "SPEC".equals(t2))
                    {
                        return -1;
                    }
                    else if ("SPEC".equals(t1) && "SPEC".equals(t2))
                    {
                        return 0;
                    }
                    else if ("GDLN".equals(t1) && "GDLN".equals(t2))
                    {
                        return 0;
                    }
                    else if ("GDLN".equals(t1) && !"GDLN".equals(t2))
                    {
                        return 1;
                    }
                    else if (!"GDLN".equals(t1) && "GDLN".equals(t2))
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
     * 
     * @param standards
     * @return
     */
    public static Map<Long, Map<StandardsExt, List<StandardsExt>>> getStdsWithChild(List<StandardsExt> standards)
    {
        Map<Long, Map<StandardsExt, List<StandardsExt>>> indexMap = getIndexMap(standards);
        indexMap = getUniqueStandard(standards, indexMap); // std
        for (StandardsExt standardsExt : standards)
        {
            if (!standardsExt.getStdType().equalsIgnoreCase(BrandStandardsUtil.STD_TYPE_STANDARD)
                    && Validator.isNotNull(standardsExt.getStdType()))
            {
                long prntId = standardsExt.getStdPrntId();
                for (long indexId : indexMap.keySet())
                {
                    Map<StandardsExt, List<StandardsExt>> stdMap = indexMap.get(indexId);
                    boolean bFound = false;
                    if (null != stdMap)
                    {
                        for (StandardsExt standPrnt : stdMap.keySet())
                        {
                            if (prntId == standPrnt.getStdId())
                            {
                                List<StandardsExt> specGdlns = stdMap.get(standPrnt);
                                if (specGdlns == null)
                                {
                                    specGdlns = new ArrayList<StandardsExt>();
                                    stdMap.put(standPrnt, specGdlns);
                                }
                                specGdlns.add(standardsExt);
                                bFound = true;
                                break;
                            }
                        }
                        if (bFound)
                        {
                            break;
                        }
                    }
                }
            }

        }
        return indexMap;
    }

    /**
     * Get Unique Standard.
     * 
     * @param standards
     * @param indexMap
     * @return
     */
    private static Map<Long, Map<StandardsExt, List<StandardsExt>>> getUniqueStandard(List<StandardsExt> standards,
            Map<Long, Map<StandardsExt, List<StandardsExt>>> indexMap)
    {
        Collections.sort(standards, new Comparator<StandardsExt>()
        {
            public int compare(StandardsExt s1, StandardsExt s2)
            {
                int res = 0;
                if (s1.getStdOrderNumber() > 0L || s2.getStdOrderNumber() > 0L)
                {
                    res = compareLong(s1.getStdOrderNumber(), s2.getStdOrderNumber());
                }
                else
                {
                    res = compareLong(s1.getStdId(), s2.getStdId());
                }
                return res;
            }

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
        for (StandardsExt standardsExt : standards)
        {
            if (standardsExt.getStdType().equalsIgnoreCase(BrandStandardsUtil.STD_TYPE_STANDARD)
                    || "".equals(standardsExt.getStdType()))
            {
                Map<StandardsExt, List<StandardsExt>> standMap = indexMap.get(standardsExt.getIndexId());
                if (standMap == null)
                {
                    standMap = new LinkedHashMap<StandardsExt, List<StandardsExt>>();
                    indexMap.put(standardsExt.getIndexId(), standMap);
                }
                standMap.put(standardsExt, null);
            }
        }

        return indexMap;
    }

    /**
     * Get Inedex Map.
     * 
     * @param standards
     * @return
     */
    private static Map<Long, Map<StandardsExt, List<StandardsExt>>> getIndexMap(List<StandardsExt> standards)
    {
        Map<Long, Map<StandardsExt, List<StandardsExt>>> indexMap = new LinkedHashMap<Long, Map<StandardsExt, List<StandardsExt>>>();
        for (StandardsExt std : standards)
        {
            indexMap.put(std.getIndexId(), null);
        }
        return indexMap;
    }

    /**
     * 
     * @param stdIndexWithSpcGdln
     */
    public static void sortOnStdOrder(Map<Long, Map<StandardsExt, List<StandardsExt>>> stdIndexWithSpcGdln)
    {
        for (long key : stdIndexWithSpcGdln.keySet())
        {
            Map<StandardsExt, List<StandardsExt>> stdMap = stdIndexWithSpcGdln.get(key);
            if (null != stdMap)
            {
                for (StandardsExt ext : stdMap.keySet())
                {
                    List<StandardsExt> stdExts = stdMap.get(ext);
                    if (null != stdExts && !stdExts.isEmpty())
                    {
                        Collections.sort(stdExts, new Comparator<StandardsExt>()
                        {
                            public int compare(StandardsExt s1, StandardsExt s2)
                            {
                                int res = compareRecordType(s2.getStdType(), s1.getStdType());
                                if (res == 0)
                                {
                                    if (s1.getStdOrderNumber() > 0L || s2.getStdOrderNumber() > 0L)
                                    {
                                        res = compareLong(s1.getStdOrderNumber(), s2.getStdOrderNumber());
                                    }
                                    else
                                    {
                                        res = compareLong(s1.getStdId(), s2.getStdId());
                                    }
                                }
                                return res;
                            }

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

                            private int compareRecordType(String t1, String t2)
                            {
                                if (t1 != null && t2 != null)
                                {
                                    if ("STD".equals(t1) && !"STD".equals(t2))
                                    {
                                        return 1;
                                    }
                                    else if (!"STD".equals(t1) && "STD".equals(t2))
                                    {
                                        return -1;
                                    }
                                    else if ("STD".equals(t1) && "STD".equals(t2))
                                    {
                                        return 0;
                                    }
                                    else if ("SPEC".equals(t1) && !"SPEC".equals(t2))
                                    {
                                        return 1;
                                    }
                                    else if (!"SPEC".equals(t1) && "SPEC".equals(t2))
                                    {
                                        return -1;
                                    }
                                    else if ("SPEC".equals(t1) && "SPEC".equals(t2))
                                    {
                                        return 0;
                                    }
                                    else if ("GDLN".equals(t1) && "GDLN".equals(t2))
                                    {
                                        return 0;
                                    }
                                    else if ("GDLN".equals(t1) && !"GDLN".equals(t2))
                                    {
                                        return 1;
                                    }
                                    else if (!"GDLN".equals(t1) && "GDLN".equals(t2))
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
                }
            }
        }
    }

    /**
     * 
     * @param stdIndexWithSpcGdln
     * @return
     */
    public static List<StandardsExt> generateSortedList(Map<Long, Map<StandardsExt, List<StandardsExt>>> stdIndexWithSpcGdln)
    {
        List<StandardsExt> stds = new ArrayList<StandardsExt>();
        for (long key : stdIndexWithSpcGdln.keySet())
        {
            Map<StandardsExt, List<StandardsExt>> stdMap = stdIndexWithSpcGdln.get(key);
            if (null != stdMap)
            {
                for (StandardsExt ext : stdMap.keySet())
                {
                    stds.add(ext);
                    List<StandardsExt> specGdlns = stdMap.get(ext);
                    if (null != specGdlns && !specGdlns.isEmpty())
                    {
                        for (StandardsExt specGdln : specGdlns)
                        {
                            stds.add(specGdln);
                        }
                    }
                }
            }
        }
        return stds;
    }

    /**
     * Set Audit log.
     * 
     * @param request request
     * @param standards record
     * @param previousStatus original status
     * @param comments comments
     * @return Audit object
     */
    public static Workflow setStandardsWorkflow(final ResourceRequest request, final Standards standards,
            final String previousStatus, final String comments)
    {
        return setStandardsWorkflow(request, standards, previousStatus, comments, null);
    }

    /**
     * Set Audit log.
     * 
     * @param request request
     * @param standards record
     * @param previousStatus original status
     * @param comments comments
     * @param brandCode Brand
     * @return Audit object
     */
    public static Workflow setStandardsWorkflow(final ResourceRequest request, final Standards standards,
            final String previousStatus, final String comments, final String brandCode)
    {
        return setStandardsWorkflow(request, standards, null, previousStatus, comments, brandCode);
    }

    /**
     * Set Workflow for a Standard.
     * 
     * @param request - ResourceRequest
     * @param standards - Standard record
     * @param previousStatus - previous status
     * @param comments - change comments.
     * @return - Workflow.
     */
    public static Workflow setStandardsWorkflow(final ResourceRequest request, final Standards standards,
            final String currStatus, final String previousStatus, final String comments, final String brandCode)
    {
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        final User user = themeDisplay.getUser();
        final Workflow workflow = WorkflowLocalServiceUtil.getWorkflowObject();
        try
        {
            final long workflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
            workflow.setWorkflowActvtId(workflowId);
            workflow.setObjectId(standards.getStdId());
            workflow.setObjectType(standards.getStdTyp());
            if (!BrandStandardsUtil.IsNullOrBlank(currStatus))
            {
                workflow.setStatus(currStatus);
            }
            else
            {
                workflow.setStatus(standards.getStatus());
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("values passed to workflow are previousStatus " + previousStatus + " currStatus " + currStatus
                        + " brandCode " + brandCode);
            }
            workflow.setPrevStatus(previousStatus);
            workflow.setCreatedBy(user.getScreenName());
            workflow.setUpdatedBy(Long.toString(user.getUserId()));
            workflow.setCreatorId(Long.toString(user.getUserId()));
            workflow.setCreatedDate(new Date());
            workflow.setUpdatedDate(new Date());
            workflow.setComment(comments);
            if (standards.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
            {
                workflow.setTitle(standards.getDescription());
            }
            else
            {
                workflow.setTitle(standards.getTitle());
            }
            if (!BrandStandardsUtil.IsNullOrBlank(brandCode))
            {
                workflow.setChainCode(brandCode);
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        return workflow;
    }

    /**
     * This method will build metadata xml based on type and params and return the xml.
     * 
     * @param type (metadata type. Ex: "XLS_REPORT")
     * @param metadataParams ({["Download_IDS", "12327,12328"],...)
     * @param searchParamName ("Search_Criteria")
     * @param searchFields ({["Download_IDS", "12327,12328"],...)
     * @return String (XML String)
     */
    public static String buildJobQueueMetadataXML(String type, Map<String, String> metadataParams, String searchParamName,
            Map<String, String> searchFields)
    {
        StringWriter stringWriter = new StringWriter();
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Metadata.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setEventHandler(new MetadataValidationEventHandler());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

            stringWriter = new StringWriter();
            ObjectFactory factory = new ObjectFactory();
            Metadata metadata = factory.createMetadata();
            ParamList paramList = factory.createParamList();

            if (metadataParams != null && !(metadataParams.isEmpty()))
            {
                List<ParamType> paramTypes = paramList.getParam();
                for (Map.Entry<String, String> paramEntry : metadataParams.entrySet())
                {
                    ParamType param = new ParamType();
                    param.setName(paramEntry.getKey());
                    param.setValue(paramEntry.getValue());
                    paramTypes.add(param);
                }
            }

            if (searchFields != null && !(searchFields.isEmpty()))
            {
                Search searchCriteria = factory.createSearch();
                searchCriteria.setName(searchParamName);
                List<FieldType> searchFileds = searchCriteria.getField();

                for (Map.Entry<String, String> paramEntry : searchFields.entrySet())
                {
                    FieldType fieldType = new FieldType();
                    fieldType.setName(paramEntry.getKey());
                    fieldType.setValue(paramEntry.getValue());
                    searchFileds.add(fieldType);
                }
                paramList.setSearch(searchCriteria);
            }

            metadata.setType(type);
            metadata.setParams(paramList);

            marshaller.marshal(metadata, stringWriter);
        }
        catch (PropertyException e)
        {
            LOG.error(e);
        }
        catch (JAXBException e)
        {
            LOG.error(e);
        }
        return stringWriter.toString();
    }

    /**
     * Get Authors by Role.
     * 
     * @param companyId
     * @param arlRole
     * @return
     */
    public static List getAuthorListByUserRole(long companyId, List<Role> arlRole, String regionCode)
    {
        List<String> arlAuthors = new ArrayList<String>();
        String userIdName = "";
        try
        {
            arlAuthors.add("ALL:All Users");
            arlAuthors.add("GLBL:Global Users");
            arlAuthors.add("AMER:AMER Users");
            arlAuthors.add("GC:GC Users");
            arlAuthors.add("EURO:EURO Users");
            arlAuthors.add("AMEA:AMEA Users");
            arlAuthors.add("SUPER:SUPER Users");
            String authorRole = getAuthorRoleFromUserRole(arlRole, regionCode);
            List<User> arlUsers = getUsersFromRole(companyId, authorRole);
            for (User user : arlUsers)
            {
                userIdName = user.getUserId() + ":" + user.getFullName();
                arlAuthors.add(userIdName);
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlAuthors;
    }

    public static List<User> getUsersFromRole(long companyId, String roleName)
    {
        List<User> arlUsers = new ArrayList<User>();
        try
        {
            Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
            arlUsers = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        return arlUsers;
    }

    public static String getAuthorRoleFromUserRole(List<Role> arlRole, String regionCode)
    {
        String authorRole = new String();
        try
        {
            for (Role role : arlRole)
            {
                String roleName = role.getName();
                if (roleName.contains("GLBL") || roleName.equalsIgnoreCase(StandardsUtil.BRANDSTAND_ADMIN_ROLE)
                        || roleName.equals(StandardsUtil.BUSINESS_OWNERS_ROLE)
                        || roleName.equals(StandardsUtil.TECHNICAL_WRITERS_ROLE))
                {
                    authorRole = StandardsUtil.AUTHORS_GLOBAL_ROLE;
                    break;
                }
                if (roleName.contains("AMER"))
                {
                    authorRole = StandardsUtil.AUTHORS_AMER_ROLE;
                    break;
                }
                if (roleName.contains("AMEA"))
                {
                    authorRole = StandardsUtil.AUTHORS_AMEA_ROLE;
                    break;
                }
                if (roleName.contains("GC"))
                {
                    authorRole = StandardsUtil.AUTHORS_GC_ROLE;
                    break;
                }
                if (roleName.contains("EURO"))
                {
                    authorRole = StandardsUtil.AUTHORS_EUROPE_ROLE;
                    break;
                }
                if (roleName.contains("SUPER") && regionCode != null)
                {
                    if (regionCode.equals("GLBL"))
                    {
                        authorRole = StandardsUtil.AUTHORS_GLOBAL_ROLE;
                    }
                    else if (regionCode.equals("AMER"))
                    {
                        authorRole = StandardsUtil.AUTHORS_AMER_ROLE;
                    }
                    else if (regionCode.equals("AMEA"))
                    {
                        authorRole = StandardsUtil.AUTHORS_AMEA_ROLE;
                    }
                    else if (regionCode.equals("EURO"))
                    {
                        authorRole = StandardsUtil.AUTHORS_EUROPE_ROLE;
                    }
                    else if (regionCode.equals("GC"))
                    {
                        authorRole = StandardsUtil.AUTHORS_GC_ROLE;
                    }

                    break;
                }
                else
                {
                    authorRole = StandardsUtil.AUTHORS_GLOBAL_ROLE;
                    break;
                }

            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return authorRole;
    }

    /**
     * Get hotel lifecycle attribute in reverse order.
     * 
     * @param flagCategoryId
     * @return
     * @throws NoSuchFlagCategoryException
     * @throws SystemException
     */
    public static List<FlagCategory> getReverseHotleLifecycle(long flagCategoryId) throws NoSuchFlagCategoryException,
            SystemException
    {

        List<FlagCategory> reverseFlagLists = new CopyOnWriteArrayList<FlagCategory>(
                FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(flagCategoryId));
        Collections.reverse(reverseFlagLists);
        return reverseFlagLists;
    }
}