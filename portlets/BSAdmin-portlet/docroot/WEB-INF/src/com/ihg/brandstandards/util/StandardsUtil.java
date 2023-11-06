package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ihg.brandstandards.bsadmin.model.StandardsView;
import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.NoSuchFlagCategoryException;
import com.ihg.brandstandards.db.NoSuchStandardsRegionException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.FlagStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.StandardsRegionLocale;
import com.ihg.brandstandards.db.model.StandardsStatus;
import com.ihg.brandstandards.db.model.StandardsTranslate;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsTranslateLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * All constants and util methods goes here.
 * 
 * @author DaveVi
 */
public class StandardsUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsUtil.class);

    public static final String SUCCESS_MESSAGE = "The form submitted successfully.";

    public static final String REQUEST_PARAM_HIDDEN_URL_LINKS = "hidden_url_links";

    public static final String REQUEST_PARAM_HIDDEN_URL_DEL_LINKS = "hidden_url_del_links";
    
    public static final String REQUEST_PARAM_HIDDEN_URL_EDIT_LINKS = "hidden_url_edit_links";

    public static final String REQUEST_PARAM_HIDDEN_IMAGES = "hidden_images";

    public static final String REQUEST_PARAM_HIDDEN_DEL_IMAGES = "hidden_del_images";

    public static final String REQUEST_PARAM_HIDDEN_EDIT_IMAGES = "hidden_edit_images";

    public static final String REQUEST_PARAM_HIDDEN_FILE_LINKS = "hidden_file_links";

    public static final String REQUEST_PARAM_HIDDEN_FILE_DEL_LINKS = "hidden_file_del_links";

    public static final String REQUEST_PARAM_HIDDEN_FILE_EDIT_LINKS = "hidden_file_edit_links";

    public static final String REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES = "hidden_manual_references";

    public static final String REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES = "hidden_del_manual_references";

    public static final String REQUEST_PARAM_HIDDEN_BIA_REFERENCES = "hidden_bia_references";

    public static final String REQUEST_PARAM_HIDDEN_DEL_BIA_REFERENCES = "hidden_del_bia_references";
    
    public static final String REQUEST_PARAM_HIDDEN_HOTEL_LIFECYCLE_FLAG = "hotel_lifecycle_flag"; 

    public static final int STANDARD_ROOT_PARENT_FOLDER_ID = 0;

    public static final String STANDARD_ROOT_FOLDER_NAME = "StandardsAttachments";

    public static final int HISTORICAL_MANUAL_TOCKENS_NUM = 8;

    public static final int HISTORICAL_MANUAL_STD_ID_INDX = 0;

    public static final int HISTORICAL_MANUAL_ID_INDX = 1;

    public static final int HISTORICAL_MANUAL_BRAND_INDX = 2;

    public static final int HISTORICAL_MANUAL_REGION_INDX = 3;

    public static final int HISTORICAL_MANUAL_CHANGE_TYPE_INDX = 4;

    public static final int HISTORICAL_MANUAL_DESC_INDX = 5;

    public static final int HISTORICAL_MANUAL_TITLE_INDX = 6;

    public static final int HISTORICAL_MANUAL_AUTHOR_ID = 7;

    public static final int IMAGE_TOCKENS_NUM = 10;//8

    public static final int IMAGE_ID_INDX = 4;

    public static final int IMAGE_SORT_ORDER_INDX = 1;

    public static final int IMAGE_TITLE_INDX = 3;

    public static final String STANDARDS_VIEW_KEY = "view";

    public static final String CHANGE_CODE_NEW = "NEW";
    public static final String CHANGE_CODE_NEW_VAL = "New";
    public static final String CHANGE_CODE_NO_CHANGE = "NO_CHANGE";
    public static final String CHANGE_CODE_NO_CHANGE_VAL = "No change";
    public static final String CHANGE_CODE_TEXT_CHANGE = "TEXT_CHANGE";
    public static final String CHANGE_CODE_TEXT_CHANGE_VAL = "Textual change";
    public static final String CHANGE_CODE_MATERIAL_CHANGE = "MATERIAL_CHANGE";
    public static final String CHANGE_CODE_MATERIAL_CHANGE_VAL = "Material change";

    private static List<String> validAuthors = new ArrayList<String>();
    private static Map<String, FlagCategory> flagCategoriesMap;
    
    private static final int MANUAL_BUILD = 257;
    private static final int MANUAL_OPERATE = 258;
    private static final int FLAG_HOTEL_LIFECYCLE_EXISTING = 479;
	
	public static final String GUIDELINE_TYPE = "GUIDELINE";
	 public static final String BRND_STND_HLC_ADMIN = "BRND_STND_HLC_ADMIN";
    /**
     * Check to see if FlagStandards contains selected flag.
     * 
     * @param flagStands - FlagStandards
     * @param selectedId - selected flag
     * @return true/false
     */
    public static boolean contains(final List<FlagStandards> flagStands, final long selectedId)
    {
        boolean found = false;
        if (!isNullOrBlank(flagStands))
        {
            for (FlagStandards flgstnd : flagStands)
            {
                if (flgstnd.getFlagCatId() == selectedId)
                {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    /**
     * Check to see if ChainStandards contains selected chain.
     * 
     * @param chainStnds - ChainStandards
     * @param chainCode - selected chain
     * @return true/false
     */
    public static boolean contains(final List<ChainStandards> chainStnds, final String chainCode)
    {
        boolean found = false;
        if (!isNullOrBlank(chainStnds))
        {
            for (ChainStandards chainStnd : chainStnds)
            {
                if (chainStnd.getChainCode().equalsIgnoreCase(chainCode))
                {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    /**
     * Verify if user has permission to edit record.
     * 
     * @param user - current user
     * @param standard - record
     * @return true/false
     */
    public static boolean hasEditAccess(final User user, final Standards standard)
    {
        boolean hasAccess = false;
        try
        {
            
            // Check if Standard is a global. And editor is Regional Author. Don't allow regional Author to edit.
            if (standard.getRegionCode().equalsIgnoreCase(REGION_GLBL))
            {
                hasAccess = isGlobalAuthor(user.getRoles());
            }
            else
            {
                hasAccess = hasEditRole(user.getRoles(), standard);
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return hasAccess;
    }

    /**
     * Verify if User has Add child permissions.
     * 
     * @param user current user
     * @param standard record
     * @return true/false
     */
    public static boolean hasAddChildAccess(final User user, final Standards standard)
    {
        boolean hasAccess = false;
        try
        {
            boolean isAuthor = false;
            for (Role currRole : user.getRoles())
            {
                if (getValidAuthors().contains(currRole.getName()))
                {
                    isAuthor = true;
                }
            }
            if (isAuthor)
            {
                if (standard.getRegionCode().equalsIgnoreCase(REGION_GLBL))
                {
                    hasAccess = true;
                }
                else
                {
                    hasAccess = hasEditRole(user.getRoles(), standard);
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return hasAccess;
    }

    /**
     * Verify if user is Administrator.
     * 
     * @param currRoles - user roles
     * @param standard - standard
     * @return true/false
     */
    private static boolean hasEditRole(final List<Role> currRoles, Standards standard)
    {
        boolean isAdmin = false;
        for (Role currRole : currRoles)
        {
            if ((currRole.getName().equals(AUTHORS_GLOBAL_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_GLBL))
                    || (currRole.getName().equals(AUTHORS_AMER_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_AMER))
                    || (currRole.getName().equals(AUTHORS_EUROPE_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_EUROPE))
                    || (currRole.getName().equals(AUTHORS_AMEA_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_AMEA))
                    || (currRole.getName().equals(AUTHORS_GC_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_GC)))
               {
                isAdmin = true;
                break;
            }
        }
        return isAdmin;
    }

    /**
     * Verify if user has AUTHORS_GLOBAL_ROLE role.
     * 
     * @param userRoles - user Roles
     * @return true/false
     */
    public static boolean isPublishAdmin(final List<Role> userRoles)
    {
        boolean isPublishAdmin = false;
        for (Role role : userRoles)
        {
            if (StandardsUtil.BRND_STND_PUBLISH_ADMIN.equalsIgnoreCase(role.getName()))
            {
                isPublishAdmin = true;
                break;
            }
        }
        return isPublishAdmin;
    }

    /**
     * Verify if user has AUTHORS_GLOBAL_ROLE role.
     * 
     * @param userRoles - user Roles
     * @return true/false
     */
    public static boolean isGlobalAuthor(final List<Role> userRoles)
    {
        boolean isGlobalUser = false;
        for (Role userRole : userRoles)
        {
            if (userRole.getName().equalsIgnoreCase(AUTHORS_GLOBAL_ROLE)
                    || userRole.getName().equalsIgnoreCase(StandardsUtil.BRANDSTAND_ADMIN_ROLE))
            {
                isGlobalUser = true;
                break;
            }
        }
        return isGlobalUser;
    }

    /**
     * Verify if user is valid Author.
     * 
     * @param currRoles - Roles
     * @return true/false
     */
    public static boolean validAuthor(final List<Role> currRoles)
    {
        boolean isGlobalAuthor = false;
        for (Role currRole : currRoles)
        {
            if (getValidAuthors().contains(currRole.getName()))
            {
                isGlobalAuthor = true;
                break;
            }
        }
        return isGlobalAuthor;
    }

    /**
     * Fetch Authors Roles.
     * 
     * @return list of Roles
     */
    public static List<String> getValidAuthors()
    {
        if (validAuthors.size() < 1)
        {
            validAuthors.add(AUTHORS_GLOBAL_ROLE);
            validAuthors.add(AUTHORS_AMER_ROLE);
            validAuthors.add(AUTHORS_AMEA_ROLE);
            validAuthors.add(AUTHORS_EUROPE_ROLE);
            validAuthors.add(AUTHORS_GC_ROLE);
            validAuthors.add(BRANDSTAND_ADMIN_ROLE);
            validAuthors.add(StandardsUtil.BRND_STND_SUPER_ADMIN);
        }
        return validAuthors;
    }

    /**
     * Resolve Chain code to description.
     * 
     * @param chain - chain code
     * @return - chain description
     */
    @SuppressWarnings("unchecked")
    public static String decodeChainCode(final String chain)
    {
        Map<String, String> chnCdMap = chainCodeMap();
        
        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : chnCdMap.entrySet())
        {
            if (chain.contains(entry.getKey()))
            {
                if (builder.length() > 0)
                {
                    builder.append(", ");
                }
                builder.append(entry.getValue());
            }
        }
        return builder.toString();
    }

    /**
     * Resolve Region code to description.
     * 
     * @param region - Region code
     * @return Region description
     */
    public static String decodeRegionCode(final String region)
    {
        final Map<String, String> regionCdMap = getRegions();

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : regionCdMap.entrySet())
        {
            if (region.contains(entry.getKey()))
            {
                if (builder.length() > 0)
                {
                    builder.append(", ");
                }
                builder.append(entry.getValue());
            }
        }
        return builder.toString();
    }

    /**
     * Resolve Change code to description.
     * 
     * @param change - Change code
     * @return Change description
     */
    public static String decodeChangeCode(final String change)
    {
        String decode = change.replaceAll(CHANGE_CODE_NEW, CHANGE_CODE_NEW_VAL);
        decode = decode.replaceAll(CHANGE_CODE_NO_CHANGE, CHANGE_CODE_NO_CHANGE_VAL);
        decode = decode.replaceAll(CHANGE_CODE_TEXT_CHANGE, CHANGE_CODE_TEXT_CHANGE_VAL);
        decode = decode.replaceAll(CHANGE_CODE_MATERIAL_CHANGE, CHANGE_CODE_MATERIAL_CHANGE_VAL);
        return decode;
    }

    /**
     * Create file types map.
     * 
     * @return map of file types
     */
    public static Map<String, String> fileTypes()
    {
        final Map<String, String> fileTypes = new LinkedHashMap<String, String>();
        // key length must be up to 20 characters - limited by database 
        fileTypes.put("", "Select a Type");
        fileTypes.put("SOP", "Standard Operating Procedure (SOP)");
        fileTypes.put("MSOP", "Measurement SOP");
        fileTypes.put("GUIDELINE", "Guideline");
        fileTypes.put("NOTES", "Briefing Notes");
        fileTypes.put("DE_GUIDELINE", "Design & Engineering Guideline");
        fileTypes.put("CC_GUIDELINE", "Communications Guideline");
        fileTypes.put("CC_TEMPLATE", "Communications Template");
        fileTypes.put("HTL_RDY_PLN", "Hotel Ready Plan");
        fileTypes.put("INTNL_TRAINING", "Internal Training");
        fileTypes.put("HTL_TRAINING", "Hotel Training");
        fileTypes.put("IMPL_PLAN", "Implementation Plan");
        fileTypes.put("AMD_CHNG_IMPACT", "Amendment Change Impact");
        fileTypes.put("STD_FORM", "Standards Form");
        fileTypes.put("PILOT_RESULTS", "Pilot Results");
        fileTypes.put("REVIEW_SUMMARY", "Review Summary");
        fileTypes.put("TABLE", "Table");
        return fileTypes;
    }

    /**
     * Create category map.
     * 
     * @return category map
     */
    public static Map<String, String> categoryMap()
    {
        final Map<String, String> categoryMap = new LinkedHashMap<String, String>();
        categoryMap.put("Foundation Framework", "Foundation Framework");
        categoryMap.put("Brand Framework", "Brand Framework");
        categoryMap.put("Operations Framework", "Operations Framework");
        categoryMap.put("Build Framework", "Build Framework");
        categoryMap.put("Regional", "Regional");

        return categoryMap;
    }

    /**
     * Create change map.
     * 
     * @return change map
     */
    public static Map<String, String> changeMap()
    {
        final Map<String, String> changeMap = new LinkedHashMap<String, String>();
        changeMap.put("NEW", "New");
        changeMap.put("NO_CHANGE", "No change");
        changeMap.put("TEXT_CHANGE", "Textual change");
        changeMap.put("MATERIAL_CHANGE", "Material change");

        return changeMap;
    }

    /**
     * Fetch flags from Flag Category table.
     * 
     * @return list of flags.
     */
    public static synchronized Map<String, FlagCategory> getFlagCategoryMap()
    {
        if (flagCategoriesMap == null || flagCategoriesMap.isEmpty())
        {
            flagCategoriesMap = new HashMap<String, FlagCategory>();

            try
            {
                List<FlagCategory> flags = FlagCategoryLocalServiceUtil.getFlagCategoryByType(StandardsUtil.FLAG_CAT_TYPE_FIELD);
                for (FlagCategory flg : flags)
                {
                    flagCategoriesMap.put(String.valueOf(flg.getFlagCatId()), flg);
                }
            }
            catch (SystemException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        return flagCategoriesMap;
    }

    /**
     * Find all Technical Writers.
     * 
     * @param companyId company id
     * @return list of Authors
     * @throws PortalException exception
     * @throws SystemException exception
     */
    public static List<User> getAllTechnicalWriters(final long companyId) throws PortalException, SystemException
    {
        String[] roleNames = { TECHNICAL_WRITERS_GLOBAL_ROLE, TECHNICAL_WRITERS_AMER_ROLE, TECHNICAL_WRITERS_AMEA_ROLE,
                TECHNICAL_WRITERS_EUROPE_ROLE, TECHNICAL_WRITERS_GC_ROLE };
        return getUsersForRoles(companyId, roleNames);
    }

    /**
     * Find all Business Owners.
     * 
     * @param companyId company id
     * @return list of Authors
     * @throws PortalException exception
     * @throws SystemException exception
     */
    public static List<User> getAllBusOwners(final long companyId) throws PortalException, SystemException
    {
        String[] roleNames = { BUSINESS_OWNERS_GLOBAL_ROLE, BUSINESS_OWNERS_AMER_ROLE, BUSINESS_OWNERS_AMEA_ROLE,
                BUSINESS_OWNERS_EUROPE_ROLE, BUSINESS_OWNERS_GC_ROLE };
        return getUsersForRoles(companyId, roleNames);
    }

    /**
     * Find Users for Specified Roles.
     * 
     * @param companyId company id
     * @param roleNames list of role names
     * @return list of users
     * @throws PortalException exception
     * @throws SystemException exception
     */
    private static List<User> getUsersForRoles(final long companyId, String[] roleNames) throws PortalException, SystemException
    {
        List<User> allUsers = new ArrayList<User>();
        for (String roleName : roleNames)
        {
            Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
            List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            allUsers.addAll(users);
        }
        sortUsers(allUsers);
        return allUsers;
    }

    /**
     * Sort Users by First and Last name.
     * 
     * @param roleId specific role id
     * @return sorted list
     * @throws SystemException
     */
    public static List<User> getRoleUsersSorted(final long roleId) throws SystemException
    {
        List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);
        List<User> newUsers = new ArrayList<User>(users);
        sortUsers(newUsers);
        return newUsers;
    }

    /**
     * Sort Users.
     * 
     * @param newUsers list of users
     */
    private static void sortUsers(List<User> newUsers)
    {
        Collections.sort(newUsers, new Comparator<User>()
        {
            public int compare(User u1, User u2)
            {

                int res = u1.getFirstName().toLowerCase().compareTo(u2.getFirstName().toLowerCase());
                if (res == 0)
                {
                    res = u1.getLastName().toLowerCase().compareTo(u2.getLastName().toLowerCase());
                }
                return res;
            }
        });
    }

    /**
     * Find Author role name.
     * 
     * @param user logged in user
     * @return role name or null
     */
    public static String getTechnicalWriterRole(User user)
    {
        try
        {
            final List<Role> roles = user.getRoles();
            for (Role role : roles)
            {
                if (role.getName().equals(AUTHORS_GLOBAL_ROLE) || role.getName().equalsIgnoreCase(BRANDSTAND_ADMIN_ROLE) || role.getName().equalsIgnoreCase(APPROVER_GLBL_ROLE)) 
                {
                    return TECHNICAL_WRITERS_GLOBAL_ROLE;
                }
                if (role.getName().equals(AUTHORS_AMER_ROLE)|| role.getName().equalsIgnoreCase(APPROVER_AMER_ROLE))
                {
                    return TECHNICAL_WRITERS_AMER_ROLE;
                }
                if (role.getName().equals(AUTHORS_AMEA_ROLE) || role.getName().equalsIgnoreCase(APPROVER_AMEA_ROLE))
                {
                    return TECHNICAL_WRITERS_AMEA_ROLE;
                }
                if (role.getName().equals(AUTHORS_EUROPE_ROLE) || role.getName().equalsIgnoreCase(APPROVER_EUROPE_ROLE))
                {
                    return TECHNICAL_WRITERS_EUROPE_ROLE;
                }
                if (role.getName().equals(AUTHORS_GC_ROLE) || role.getName().equalsIgnoreCase(APPROVER_GC_ROLE))
                {
                    return TECHNICAL_WRITERS_GC_ROLE;
                }
            }
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }
    
    /**
     * Find Author role name.
     * 
     * @param Standards : Current standard
     * @return role name or null
     */
    public static String getTechnicalWriterRole(Standards std)
    {
        try
        {
        	if (std.getRegionCode().equalsIgnoreCase(REGION_GLBL))
            {
        		 return TECHNICAL_WRITERS_GLOBAL_ROLE;
            }
            if (std.getRegionCode().equalsIgnoreCase(REGION_AMER) )
            {
            	return TECHNICAL_WRITERS_AMER_ROLE;
            }
            if (std.getRegionCode().equalsIgnoreCase(REGION_AMEA))
            {
            	return TECHNICAL_WRITERS_AMEA_ROLE;
            }
            if (std.getRegionCode().equalsIgnoreCase(REGION_EUROPE))
            {
            	return TECHNICAL_WRITERS_EUROPE_ROLE;
            }
            if (std.getRegionCode().equalsIgnoreCase(REGION_GC))
            {
            	return TECHNICAL_WRITERS_GC_ROLE;
            }
                
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }

    /**
     * Find Business Owner role name.
     * 
     * @param user logged in user
     * @return role name or null
     */
    public static String getBusinessOwnerRole(User user)
    {
        try
        {
            
            final List<Role> roles = user.getRoles();
            for (Role role : roles)
            {
                if (role.getName().equals(AUTHORS_GLOBAL_ROLE) || role.getName().equalsIgnoreCase(BRANDSTAND_ADMIN_ROLE)|| role.getName().equalsIgnoreCase(APPROVER_GLBL_ROLE))
                {
                    return BUSINESS_OWNERS_GLOBAL_ROLE;
                }
                if (role.getName().equals(AUTHORS_AMER_ROLE) || role.getName().equals(APPROVER_AMER_ROLE))
                {
                    return BUSINESS_OWNERS_AMER_ROLE;
                }
                if (role.getName().equals(AUTHORS_AMEA_ROLE) || role.getName().equals(APPROVER_AMEA_ROLE))
                {
                    return BUSINESS_OWNERS_AMEA_ROLE;
                }
                if (role.getName().equals(AUTHORS_EUROPE_ROLE) || role.getName().equals(APPROVER_EUROPE_ROLE))
                {
                    return BUSINESS_OWNERS_EUROPE_ROLE;
                }
                if (role.getName().equals(AUTHORS_GC_ROLE) || role.getName().equals(APPROVER_GC_ROLE))
                {
                    return BUSINESS_OWNERS_GC_ROLE;
                }
            }
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }
    
    /**
     * Find Business Owner role name.
     * 
     * @param Standards :  Current standard
     * @return role name or null
     */
    public static String getBusinessOwnerRole(Standards std)
    {
        try
        {
                if (std.getRegionCode().equalsIgnoreCase(REGION_GLBL))
                {
                    return BUSINESS_OWNERS_GLOBAL_ROLE;
                }
                if (std.getRegionCode().equalsIgnoreCase(REGION_AMER) )
                {
                    return BUSINESS_OWNERS_AMER_ROLE;
                }
                if (std.getRegionCode().equalsIgnoreCase(REGION_AMEA))
                {
                    return BUSINESS_OWNERS_AMEA_ROLE;
                }
                if (std.getRegionCode().equalsIgnoreCase(REGION_EUROPE))
                {
                    return BUSINESS_OWNERS_EUROPE_ROLE;
                }
                if (std.getRegionCode().equalsIgnoreCase(REGION_GC))
                {
                    return BUSINESS_OWNERS_GC_ROLE;
                }
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }

    public static boolean hasEditRole(StandardsHistoricalManual reference, User user) throws NumberFormatException,
            PortalException, SystemException
    {
        User creator = null;
        if (reference != null)
        {
            String creatorId = reference.getCreatorId();
            if (!IsNullOrBlank(creatorId))
            {
                try {
					creator = UserLocalServiceUtil.getUserById(Long.parseLong(creatorId));
				} catch (Exception e) {
					LOG.error("No User Exist with User id: "+creatorId);
				}
            }
        }
        if (creator != null)
        {
            return hasEditRole(user.getRoles(), creator.getRoles());
        }
        return false;
    }
    
    /**
     * Verify if user is Administrator.
     * 
     * @param currRoles - user roles
     * @param creatorRoles - creator roles
     * @return true/false
     */
    private static boolean hasEditRole(final List<Role> currRoles, final List<Role> creatorRoles)
    {
        boolean isAdmin = false;
        for (Role currRole : currRoles)
        {
            for (Role creatorRole : creatorRoles)
            {
                if ((currRole.equals(creatorRole) && getValidAuthors().contains(currRole.getName())))
                {
                    isAdmin = true;
                    break;
                }
            }
        }
        return isAdmin;
    }

    /**
     * Method to return list of languages from region code
     * 
     * @author hitesh.methani
     * @param regionCode
     * @return
     */
    public static List<StandardsLocale> getRegionLanguages(String regionCode)
    {
        List<StandardsLocale> languages = new ArrayList<StandardsLocale>();
        try
        {
            StandardsRegion region = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(regionCode);
            List<StandardsRegionLocale> regionLanguages = StandardsRegionLocaleLocalServiceUtil
                    .getStandardsRegionLocaleByRegionId(region.getRegionId());
            StandardsLocale locale;
            for (StandardsRegionLocale regionLocale : regionLanguages)
            {
                locale = BrandStandardsCacheUtil.getStandardsLocaleByLocaleCd(regionLocale.getLocaleCode());
                languages.add(locale);
            }
        }
        catch (NoSuchStandardsRegionException e)
        {
            LOG.error("No Region exists with code " + regionCode);
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getRegionLanguages() " + e.getMessage());
        }
        catch (PortalException e)
        {
            LOG.error("PortalException in getRegionLanguages() " + e.getMessage());
        }
        return languages;
    }

    /**
     * Method to get translations of a standard
     * 
     * @author hitesh.methani
     * @param stdId
     * @return
     */
    public static Map<String, StandardsTranslate> getTranslations(long stdId)
    {
        List<StandardsTranslate> stdTranslations = null;
        Map<String, StandardsTranslate> translationMap = new HashMap<String, StandardsTranslate>();
        try
        {
            stdTranslations = StandardsTranslateLocalServiceUtil.getStandardTranslateByStdId(stdId);
            if (Validator.isNotNull(stdTranslations))
            {
                for (StandardsTranslate translation : stdTranslations)
                {
                    translationMap.put(translation.getLocaleCode(), translation);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getTranslations with id " + stdId + e.getMessage());
        }

        return translationMap;
    }
    
    /**
     * Sort records by STD_ID.
     * 
     * @param standards list of records
     */
    public static List<Standards>  sortByStdId(final List<Standards> standards)
    {
        Collections.sort(standards, new Comparator<Standards>()
        {
            /* (non-Javadoc)
             * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
             */
            public int compare(Standards v1, Standards v2)
            {
                return compareLong(v1.getStdId(), v2.getStdId());
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
        return standards;
    }
 /**
     * To indicate if the translation exist for std or not
     * All the fields are indicated by single field only, creating a seperate field will cause a performance hit
     * The method is not used for now, it is under development
     * @author hitesh.methani
     * @param std
     * @return
     * @throws SystemException 
     */
    public static boolean isTranslationExist(Standards std) throws SystemException
    {
        if(Validator.isNotNull(std))
        {
            return isTextOrContextTransExist(std);
        }
        return false;
    }
    
    /**
     * Checks if translation for standard text or context exist for a particular standard
	 * The method is not used for now, it is under development
     * @param std
     * @return
     * @throws SystemException
     */
    private static boolean isTextOrContextTransExist(Standards std) throws SystemException
    {
        
        List<StandardsTranslate> stdXlats = StandardsTranslateLocalServiceUtil.getStandardTranslateByStdId(std.getStdId());
        for(StandardsTranslate stdXlat:stdXlats)
        {
            if(!(BrandStandardsUtil.DEFAULT_LOCALE.equals(stdXlat.getLocaleCode())) && (!StringPool.BLANK.equals(stdXlat.getTitle()) || !StringPool.BLANK.equals(stdXlat.getDescription())))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * To set if translation exists or not for a link
     * @author hitesh.methani
     * @param link
     */
    public static void setLinkTranslationExist(ExternalLinkStandards link)
    {
        List<ExternalLinkStandards> extLinks;
        try
        {
            extLinks = ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByParentId(link.getParentExtLinkId());
            for(ExternalLinkStandards extLink : extLinks)
            {
                if(extLink.getExtLinkId() != extLink.getParentExtLinkId())
                {
                    link.setLinkTranslationExist(true);
                    break;
                }
                else
                {
                    link.setLinkTranslationExist(false);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in fetching extLinks "+ e.getMessage());
        }
        
        
    }
    /**
     * To set if translation exists or not for an attachment
     * @author hitesh.methani
     * @param attachment
     */
    public static void setAttachmentTranslationExist(AttachmentsStandards attachment)
    {
        List<AttachmentsStandards> attachments;
        try
        {
            attachments = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentId(attachment.getParentAttachmentId());
            for(AttachmentsStandards attach : attachments)
            {
                if(attach.getAttachmentId() != attach.getParentAttachmentId())
                {
                    attachment.setTranslationExist(true);
                    break;
                }
                else
                {
                    attachment.setTranslationExist(false);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in fetching extLinks "+ e.getMessage());
        }
        
        
    }
    /**
     * To set if translation exists or not for an attachment
     * @author hitesh.methani
     * @param attachment
     */
    public static void setImageTranslationExist(StandardsImages stdImage)
    {
        List<StandardsImages> stdImages;
        try
        {
            stdImages = StandardsImagesLocalServiceUtil.getStdImagesByParentImageIdStdId(stdImage.getParentImageId(), stdImage.getStdId());
            for(StandardsImages image : stdImages)
            {
                if(image.getStdImageId() != image.getParentImageId())
                {
                    stdImage.setIsTranslationExist(true);
                    break;
                }
                else
                {
                    stdImage.setIsTranslationExist(false);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in fetching Images "+ e.getMessage());
        }
        
        
    }
    
    /**
     * Invalidating existing translation on change of text or context
     * @author hitesh.methani
     * @param std
     */
    public static void invalidateXlat(Standards std, String title, String description)
    {
        try
        {
            String isValidTitle = "Y";
            String isValidDesc = "Y";
            List<StandardsTranslate> stdXlats = StandardsTranslateLocalServiceUtil.getStandardTranslateByStdId(std.getStdId());
            if(Validator.isNotNull(std.getTitle()) && Validator.isNotNull(title) && !std.getTitle().equals(title))
            {
                isValidTitle = "N";
            }
            if( (IsNullOrBlank(std.getDescription()) && !IsNullOrBlank(description)) ||
                (Validator.isNotNull(std.getDescription()) && Validator.isNotNull(description)) && !std.getDescription().equals(description)
              )
            {
                isValidDesc = "N";
            }
            if(isValidTitle.equals("N") || isValidDesc.equals("N"))
            {
                for(StandardsTranslate stdXlat : stdXlats)
                {
                    if(isValidTitle.equals("N"))
                    {
                        stdXlat.setIsValidTxt(isValidTitle);   
                    }
                    if(isValidDesc.equals("N"))
                    {
                        stdXlat.setIsValidCntxt(isValidDesc);
                    }
                    stdXlat.setIsValidCntxt(isValidDesc);
                    StandardsTranslateLocalServiceUtil.updateStandardsTranslate(stdXlat);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getting StandardsTranslate "+e.getMessage());
        }
        
    }
    
    
    public static void setTextContextTransExist(StandardsView stdView) throws SystemException
    {
        List<StandardsTranslate> stdXlats = StandardsTranslateLocalServiceUtil.getStandardTranslateByStdId(stdView.getStandard().getStdId());
        boolean isTextTransExist = false;
        boolean isContextTransExist = false;
        if(Validator.isNotNull(stdXlats) && stdXlats.size() > 0)
        {
            for(StandardsTranslate stdXlat : stdXlats)
            {
                if(stdXlat.getIsValidTxt().equals("Y") && !isTextTransExist)
                {
                    isTextTransExist = true;
                }
                if(stdXlat.getIsValidCntxt().equals("Y") && !isContextTransExist)
                {
                    isContextTransExist = true;
                }
            }
        }
        stdView.getStandard().setTextTransExist(isTextTransExist);
        stdView.getStandard().setContextTransExist(isContextTransExist);
    }
    
    public static boolean isSuperAdmin(final List<Role> userRoles)
    {
        boolean isSuperAdmin = false;
        for (Role role : userRoles)
        {
            if (StandardsUtil.BRND_STND_SUPER_ADMIN.equalsIgnoreCase(role.getName()))
            {
            	isSuperAdmin = true;
                break;
            }
        }
        return isSuperAdmin;
    }
    public static boolean isHotelLifeCycleAdmin(final List<Role> userRoles)
    {
        boolean isHotelLifeCycleAdmin = false;
        for (Role role : userRoles)
        {
            if (BRND_STND_HLC_ADMIN.equalsIgnoreCase(role.getName()))
            {
            	isHotelLifeCycleAdmin = true;
                break;
            }
        }
        return isHotelLifeCycleAdmin;
    }
    /*public static boolean allowImportCompliance(final List<Role> userRoles)
    {
        boolean allow = false;
        for (Role role : userRoles)
        {
            if (StandardsUtil.BRND_STND_COMPLIANCE_IMPORT.equalsIgnoreCase(role.getName()))
            {
                allow = true;
                break;
            }
        }
        return allow;
    }*/
    
    /*
    /**
     * Check if translation for image exists for a particular standard
     * This function is not used for now, as we are checking only for text and context field
     * @param std
     * @return
     * @throws SystemException
     
    private static boolean isImageTransExist(Standards std) throws SystemException
    {
        List<StandardsImages> stdImages = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(std.getStdId());
        for(StandardsImages stdImage : stdImages)
        {
            if(!(BrandStandardsUtil.DEFAULT_LOCALE.equals(stdImage.getLocaleCode())) && (stdImage.getParentImageId()!= stdImage.getStdImageId()))
            {
                return true;
            }
        }
        return false;
    }
    */
    
    
    public static String getTechnicalWriterRoleForSuperAdmin(String regionCode)
    {
        try
        {
           // final List<Role> roles = user.getRoles();
            
                if (regionCode.equals("GLBL")) 
                {
                    return TECHNICAL_WRITERS_GLOBAL_ROLE;
                }
                if (regionCode.equals("AMER"))
                {
                    return TECHNICAL_WRITERS_AMER_ROLE;
                }
                if (regionCode.equals("AMEA"))
                {
                    return TECHNICAL_WRITERS_AMEA_ROLE;
                }
                if (regionCode.equals("EURO"))
                {
                    return TECHNICAL_WRITERS_EUROPE_ROLE;
                }
                if (regionCode.equals("GC"))
                {
                    return TECHNICAL_WRITERS_GC_ROLE;
                }
            
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }
    
    public static String getBusinessOwnerRoleForSuperAdmin(String regionCode)
    {
        try
        {
            
           
            if (regionCode.equals("GLBL"))
            {
                return BUSINESS_OWNERS_GLOBAL_ROLE;
            }
            if (regionCode.equals("AMER"))
            {
                return BUSINESS_OWNERS_AMER_ROLE;
            }
            if (regionCode.equals("AMEA"))
            {
                return BUSINESS_OWNERS_AMEA_ROLE;
            }
            if (regionCode.equals("EURO"))
            {
                return BUSINESS_OWNERS_EUROPE_ROLE;
            }
            if (regionCode.equals("GC"))
            {
                return BUSINESS_OWNERS_GC_ROLE;
            }
           
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }
    
    public static String setAuthorRoleForSuperAdmin(String regionCode)
    {
    	String authorRole = "";
    	 if (regionCode.equals("GLBL"))
         {
    		 authorRole = AUTHORS_GLOBAL_ROLE;
         }
         if (regionCode.equals("AMER"))
         {
        	 authorRole = AUTHORS_AMER_ROLE;
         }
         if (regionCode.equals("AMEA"))
         {
        	 authorRole = AUTHORS_AMEA_ROLE;
         }
         if (regionCode.equals("EURO"))
         {
        	 authorRole = AUTHORS_EUROPE_ROLE;
         }
         if (regionCode.equals("GC"))
         {
        	 authorRole = AUTHORS_GC_ROLE;
         }
    	return authorRole;
    }
    
    public static String getRegionNameFromRegionCode(String regionCode)
    {
    	String regionName = "";
    	 if (regionCode.equals("GLBL"))
         {
    		 regionName = "Global";
         }
         if (regionCode.equals("AMER"))
         {
        	 regionName = "Americas";
         }
         if (regionCode.equals("AMEA"))
         {
        	 regionName = "Asia, Middle East and Africa";
         }
         if (regionCode.equals("EURO"))
         {
        	 regionName = "Europe";
         }
         if (regionCode.equals("GC"))
         {
        	 regionName = "Greater China";
         }
    	return regionName;
    }
    
 // CR101 logic added.
    public static void processManualFlags(List<FlagStandards> selectedFlagStds, List<FlagStandards> assocFlagStds, List<FlagCategory> flagCategories)
    {
        if(!isNullOrBlank(assocFlagStds))
        {
           if(!contains(assocFlagStds, BSAdminConstants.BUILD_AND_OPERATE_ID))
           {
               for(int iSize = 0 ; iSize < flagCategories.size(); iSize++)
               {
                   boolean bFound = false;
                   for(FlagStandards assocFlagStd : assocFlagStds)
                   {
                       if(assocFlagStd.getFlagCatId() == flagCategories.get(iSize).getFlagCatId())
                       {
                           bFound = true;
                           break;
                       }
                   }
                   if(!bFound)
                   {
                       flagCategories.remove(flagCategories.get(iSize));
                       iSize --;
                   }
               }
           }
        }
    }
    
    /**
     * This method return  child flagstandards for specific parent standards.
     * 
     * @param childFlagStds
     * @param flagCategories
     * @return Comma seperated string of ids
     */
    public static String restrictManual(List<FlagStandards> childFlagStds, List<FlagCategory> flagCategories)
    {
        String flags = "";
        if(!isNullOrBlank(childFlagStds))
        {
            for(FlagCategory flagCategory : flagCategories)
            {
                boolean bFound = false;
                for(FlagStandards flgStd : childFlagStds)
                {
                    if(flgStd.getFlagCatId() == flagCategory.getFlagCatId())
                    {
                        bFound = true;
                        break;
                    }
                }
                if(bFound)
                {
                    flags = flags + flagCategory.getFlagCatId() + ",";
                }
            }
        }
        if (flags.length() > 0 && flags.contains(","))
        {
            flags = flags.substring(0, flags.length()-1);
        }
        return flags;
    }
    
    /**
     * Check to see if Standards has Operate and Build or Only build flag as a selected flag.
     * 
     * @param flagStands - FlagStandards
     * @param selectedId - selected flag
     * @return true/false
     */
    public static boolean hasBuildOperateFlag(final List<FlagStandards> flagStands)
    {
        boolean found = false;
        if (!isNullOrBlank(flagStands))
        {
            for (FlagStandards flgstnd : flagStands)
            {
                if (flgstnd.getFlagCatId() == MANUAL_BUILD  )
                {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
    
   
    /**
     * Get hotle lifecycle category assign to parent standards by passing 
     * @param stdId
     * @param flagCategories
     * @return
     * @throws NoSuchFlagCategoryException
     * @throws SystemException
     */
    public static List<FlagCategory> getSpecGuidelineFlags(long stdId, List<FlagCategory> flagCategories) throws NoSuchFlagCategoryException, SystemException 
    {
          // Get Parents. flag catgy for "hotle Lifecycle".
    	  List<FlagCategory> newFlagLists = new CopyOnWriteArrayList<FlagCategory>(flagCategories);
    	
          List<FlagStandards> flagStandards = FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(stdId);
          if(!isNullOrBlank(flagStandards))
          {
	          for (FlagCategory flagCategory : newFlagLists) 
	          {
	        	  boolean bFound = false;
	        	  for (FlagStandards flagStd : flagStandards) 
		          { 
		        	  if (flagCategory.getFlagCatId() == flagStd.getFlagCatId()) 
		        	  {
		        		 bFound = true; 
		        	  }
	        	  
		          }
	        	  if (!bFound) 
	        	  {
	        		  newFlagLists.remove(flagCategory);
	        	  }
	          }
	          
          } 
          return newFlagLists;
    }
    
    /**
     * Compliance Icon Show/Hide Checking based on Manul & Hotel Lifecycle Flag. 
     *  This method done in part of CR 50.3 
     * @param flagStands - FlagStandards
     * @param selectedId - selected flag
     * @return true/false
     */
    public static boolean showComplianceIcon(final long stdId)
    {
            
            List<FlagStandards> flagStands = new ArrayList<FlagStandards>();
                try {
                        flagStands = FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(stdId);
                } catch (SystemException e) {
                        LOG.error(StackTraceUtil.getStackTrace(e));
                }
        boolean isBuild = false;
        boolean isOperate = false;
        boolean isExisting = false;
        boolean isShowIcon = false;
        if (!isNullOrBlank(flagStands))
        {
            for (FlagStandards flgstnd : flagStands)
            {
                    
                if (  flgstnd.getFlagCatId() == MANUAL_BUILD  )
                {
                        isBuild = true;
                } 
                else if (flgstnd.getFlagCatId() == MANUAL_OPERATE)
                {
                        isOperate = true;
                } 
                else if (flgstnd.getFlagCatId() == FLAG_HOTEL_LIFECYCLE_EXISTING)
                {
                        isExisting = true;
                }
            }
            //For issue 6526
          /*  if ( (isOperate && !isBuild) || (isOperate && isBuild) || (!isOperate && isBuild && isExisting) )
            {
                    isShowIcon = true;
            }
            else if (!isOperate && isBuild && !isExisting)
            {
                    isShowIcon = false;
            }*/
            
            if( (isOperate && !isBuild)){
            	 isShowIcon = true;
            }else if(isOperate && isBuild){
            	if(isExisting){
            		isShowIcon = true;
            	}
            	
            }else if(!isOperate && isBuild){
            	if(isExisting){
            		isShowIcon = true;
            	}
            }
        }
        return isShowIcon;
    }
    
    
   
    /**
     * @param standards
     * @return List<Standards>
     */
    public static List<Standards> sortByOrderNumber (final List<Standards> standards)
    {
        Collections.sort(standards, new Comparator<Standards>()
        {
            /* (non-Javadoc)
             * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
             */
            public int compare(Standards v1, Standards v2)
            {
            	int result = 0;
                if (Validator.isNull(v1.getOrderNumber()) &&  Validator.isNull(v2.getOrderNumber())) {
                	result = compareLong(v1.getStdId(), v2.getStdId());
                } else {
                	result = compareLong(v1.getOrderNumber(), v2.getOrderNumber());
                }
            	return result;
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
        return standards;
    }
    
    public static void updateChildStatus(Standards standard, String brandCode,long status, User user ) {
    	try {
	    	 StandardsStatus stdStatus = StandardsStatusUtil.getStatusById(status);
	    	 if(stdStatus != null) {
	    		 final String currStatus =  stdStatus.getStatusCode();
	    		 if("D_FOR_REF".equals(currStatus) ||  "D_NOT_RQ".equals(currStatus) || "D_RPLCD".equals(currStatus)) {
	    			 List<Standards> stdList =  StandardsLocalServiceUtil.getStandardsByParent(standard.getStdId());
	    			 for(Standards standards : stdList) {
			        	 if(!BSAdminConstants.STD_TYPE.equals(standards.getStdTyp())) {
							try {
								ChainStandards chainStandards = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(standards.getStdId(), brandCode);
								if (chainStandards != null) {
									final String previousStatus =  StandardsStatusUtil.getStatusById(chainStandards.getStatusId()).getStatusCode();
									/*Issue Fix Oct 11 2016: Standard Status should not be copied to specification/guideline if the specification/guideline is discontinued*/ 
									if(!"D_FOR_REF".equals(previousStatus) & !"D_NOT_RQ".equals(previousStatus) && !"D_RPLCD".equals(previousStatus)){
										chainStandards.setStatusId(status);
										chainStandards.setUpdatedBy(Long.toString(user.getUserId()));
										chainStandards.setUpdatedDate(new Date());
										ChainStandardsLocalServiceUtil.updateChainStandards(chainStandards);
										if(LOG.isDebugEnabled()){
											LOG.debug("The values passed to workflow are: currStatus "+currStatus+" previousStatus "+previousStatus+" brandCode "+brandCode);
										}
									}
								}
							} catch (NoSuchChainStandardsException e) {
								LOG.error("NoSuchChainStandardsException in updating child status "+e.getMessage());
							}
			        	 }
	    			 }
	    		 }
	    	 }
    	} catch (SystemException e) {
    		LOG.error("SystemException in updating child status "+e.getMessage());
    	}
    }
}
