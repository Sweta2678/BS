package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ManualsUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(ManualsUtil.class);

    public static final String MNL_AUTHORS_GLOBAL_ROLE = "BRND_STND_GLBL_MNL_AUTHOR";

    public static final String MNL_AUTHORS_AMER_ROLE = "BRND_STND_AMER_MNL_AUTHOR";

    public static final String MNL_AUTHORS_AMEA_ROLE = "BRND_STND_AMEA_MNL_AUTHOR";

    public static final String MNL_AUTHORS_EUROPE_ROLE = "BRND_STND_EURO_MNL_AUTHOR";

    public static final String MNL_AUTHORS_GC_ROLE = "BRND_STND_GC_MNL_AUTHOR";

    public static final String MANUAL_STATUS_NEW = "NEW";

    public static final String MANUAL_STATUS_DELETED = "DELETED";

    public static final String MANUAL_STATUS_NOT_EXISTS = "NOTEXISTS";

    public static final String MANUALS_ROOT_FOLDER_NAME = "ManualsAttachment";

    public static List<String> validManualAuthors = new ArrayList<String>();

    public static boolean hasCreateRights(final User user)
    {
        boolean accessFlag = false;
        try
        {
            final List<Role> currRoles = user.getRoles();
            for (Role currRole : currRoles)
            {
                if (getValidManualAuthors().contains(currRole.getName()))
                {
                    accessFlag = true;
                    break;
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return accessFlag;
    }

    public static boolean hasEditDeleteRigths(final User user, final HistManuals manual)
    {
        boolean accessFlag = false;
        try
        {
            final long creatorId = Long.valueOf(manual.getCreatorId());
            User creator = null;
            try
            {
                creator = UserLocalServiceUtil.getUser(creatorId);
            }
            catch (Exception e)
            {
                LOG.error(e.getMessage());
            }
            if(creator != null)
            {
                final List<Role> creatorRoles = creator.getRoles();
                final List<Role> currRoles = user.getRoles();
                for (Role currRole : currRoles)
                {
                    for (Role creatorRole : creatorRoles)
                    {
                        if ((currRole.equals(creatorRole) && getValidManualAuthors().contains(currRole.getName())))
                        {
                            accessFlag = true;
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
        return accessFlag;
    }

    public static boolean isEditable(final HistManuals manual)
    {
        long count = 1;
        try
        {
            if(manual != null){
                count = StandardsHistoricalManualLocalServiceUtil.getCountByHistMan(manual.getHistManualId());
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return count == 0;
    }

    public static List<String> getValidManualAuthors()
    {
        if (validManualAuthors.size() < 1)
        {
            validManualAuthors.add(MNL_AUTHORS_GLOBAL_ROLE);
            validManualAuthors.add(MNL_AUTHORS_AMER_ROLE);
            validManualAuthors.add(MNL_AUTHORS_AMEA_ROLE);
            validManualAuthors.add(MNL_AUTHORS_EUROPE_ROLE);
            validManualAuthors.add(MNL_AUTHORS_GC_ROLE);
            validManualAuthors.add(BRANDSTAND_ADMIN_ROLE);
        }
        return validManualAuthors;
    }
}
