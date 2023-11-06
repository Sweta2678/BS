package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * All constants and util methods goes here.
 * 
 * @author DaveVi
 */
public class RegionalUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(RegionalUtil.class);

    public static final String SUCCESS_MESSAGE = "The form submitted successfully.";

    public static final String REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES = "hidden_manual_references";

    public static final String REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES = "hidden_del_manual_references";

    public static final String REQUEST_PARAM_HIDDEN_COMMENT = "hidden_comment";

    public static final String REQUEST_PARAM_HIDDEN_REGIONS = "hidden_regions";

    public static final int HISTORICAL_MANUAL_TOCKENS_NUM = 7;

    public static final int HISTORICAL_MANUAL_STD_ID_INDX = 0;

    public static final int HISTORICAL_MANUAL_ID_INDX = 1;

    public static final int HISTORICAL_MANUAL_BRAND_INDX = 2;

    public static final int HISTORICAL_MANUAL_REGION_INDX = 3;

    public static final int HISTORICAL_MANUAL_CHANGE_TYPE_INDX = 4;

    public static final int HISTORICAL_MANUAL_DESC_INDX = 5;

    public static final int HISTORICAL_MANUAL_TITLE_INDX = 6;

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
    private static List<String> regionalAuthors = new ArrayList<String>();

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
     * Resolve Chain code to description.
     * 
     * @param chain - chain code
     * @return - chain description
     */
    @SuppressWarnings("unchecked")
    public static String decodeChainCode(final String chain)
    {
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();

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
            final long creatorId = Long.valueOf(standard.getCreatorId());
            User creator = null;
            
            try {
            	creator = UserLocalServiceUtil.getUser(creatorId);
			} catch (Exception e) {
				LOG.error("No User Exist with User Id:"+creatorId);
			}

            // Check if creator is admin/global. And editor is Regional Author. Allow admin to edit.
            if (creator != null && isGlobalAuthor(creator.getRoles()))
            {
                hasAccess = isRegionalAuthor(user.getRoles());
            }
            else
            {
                hasAccess = hasEditRole(user.getRoles());
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return hasAccess;
    }

    /**
     * Verify if record creator has AUTHORS_GLOBAL_ROLE role.
     * 
     * @param creatorRoles - creator Roles
     * @return true/false
     */
    public static boolean isGlobalAuthor(final List<Role> creatorRoles)
    {
        boolean isGlobalCreator = false;
        for (Role creatorRole : creatorRoles)
        {
            if (creatorRole.getName().equalsIgnoreCase(AUTHORS_GLOBAL_ROLE))
            {
                isGlobalCreator = true;
                break;
            }
        }
        return isGlobalCreator;
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
        }
        return validAuthors;
    }

    /**
     * Verify if user is Administrator.
     * 
     * @param currRoles - user roles
     * @return true/false
     */
    private static boolean hasEditRole(final List<Role> currRoles)
    {
        boolean isAdmin = false;
        for (Role currRole : currRoles)
        {
            if (currRole.getName().equalsIgnoreCase(BRANDSTAND_ADMIN_ROLE))
            {
                isAdmin = true;
                break;
            }

        }
        return isAdmin;
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
     * Verify if user is regional Author.
     * 
     * @param currRoles - Roles
     * @return true/false
     */
    public static boolean isRegionalAuthor(final List<Role> currRoles)
    {
        boolean isRegionalAuthor = false;
        for (Role currRole : currRoles)
        {
            if (getRegionalAuthors().contains(currRole.getName()))
            {
                isRegionalAuthor = true;
                break;
            }
        }
        return isRegionalAuthor;
    }

    /**
     * Fetch Regional Authors Roles.
     * 
     * @return list of Roles
     */
    public static List<String> getRegionalAuthors()
    {
        if (regionalAuthors.size() < 1)
        {
            regionalAuthors.add(AUTHORS_AMER_ROLE);
            regionalAuthors.add(AUTHORS_AMEA_ROLE);
            regionalAuthors.add(AUTHORS_EUROPE_ROLE);
            regionalAuthors.add(AUTHORS_GC_ROLE);
        }
        return regionalAuthors;
    }

    /**
     * Verify if user has permission to delete record.
     * 
     * @param user - current user
     * @param stdmanual - record
     * @return true/false
     */
    public static boolean hasDeleteAccess(final User user, final StandardsHistoricalManual stdmanual)
    {
        boolean canDelete = false;
        try
        {
            final long creatorId = Long.valueOf(stdmanual.getCreatorId());
            User creator = null;
            
            try {
            	creator = UserLocalServiceUtil.getUser(creatorId);
			} catch (Exception e) {
				LOG.error("No User Exist with User Id:"+creatorId);
			}

            for (Role currRole : user.getRoles())
            {
                if(creator != null) {
	            	for (Role creatorRole : creator.getRoles())
	                {
	                    if ((currRole.equals(creatorRole) && getValidAuthors().contains(currRole.getName()))
	                            || currRole.getName().equalsIgnoreCase(BRANDSTAND_ADMIN_ROLE))
	                    {
	                        canDelete = true;
	                        break;
	                    }
	                }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return canDelete;
    }

}
