package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsStatus;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;

public class StandardsStatusUtil extends BrandStandardsUtil
{

    private static final Log LOG = LogFactoryUtil.getLog(StandardsStatusUtil.class);

    public static String UNIQUE_STATUSES = "GLBL";  //  TODO : Vipul, make it dynamic or set it nullable.

    // public static String DEFAULT_STATUS_CD = "ILOEC";
    
    public static String DEFAULT_STATUS_CD_AMEA = "AWT_APRV";
    
    public static String DEFAULT_STATUS_CD_AMER = "RFLR";
    
    public static String DEFAULT_STATUS_CD_EURO = "ILOEC";
    
    public static String DEFAULT_STATUS_CD_GC = "ILOEC";
    
    public static String DEFAULT_STATUS_CD_GLBL = "ILOEC";
    
    public static final String PUBLISH_LOCK_STATUS = "PUBLISH_LOCKED";

    public static final String AVAILABLE_STATUS = "AVAILABLE";

    public static final String DELETED_STATUS = "DELETED";

    public static List<StandardsStatus> getStatuses(User user,boolean isSuperAdmin, String regionCode)
    {
        return getStatuses(user, false, isSuperAdmin, regionCode);
    }

    public static List<StandardsStatus> getStatuses(User user, boolean unique, boolean isSuperAdmin, String regionCode)
    {
        List<StandardsStatus> statuses = null;
       // String rgnCode = "";
        if(!unique)
        {
            String role = UNIQUE_STATUSES;
            if(isSuperAdmin == true)
            {
            	role = getSuperAdminApproverRole(regionCode);
            	
            }
            else
            {
	            if (getApproverKey(user) != null)
	            {
	                role = getApproverKey(user);
	            }
	             regionCode = getRegionCodeFromRole(role);
            }
            try
            {
                statuses = StandardsStatusLocalServiceUtil.getStatusesByRegionCode(StandardsRegionLocalServiceUtil
                        .getStandardsRegionByRegionCode(regionCode).getRegionId());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        } else {
                try {
                    statuses = StandardsStatusLocalServiceUtil.getStandardsStatuses(0, StandardsStatusLocalServiceUtil.getStandardsStatusesCount());
                    Map<String, String> statusMap = new LinkedHashMap<String, String>();
                    for(StandardsStatus status : statuses)
                    {
                        statusMap.put(status.getStatusCode(), status.getTitle());
                    }
                    statuses = new ArrayList<StandardsStatus>();
                    for(String key : statusMap.keySet())
                    {
                        StandardsStatus stdStat = StandardsStatusLocalServiceUtil.getStandardsStatusObject();
                        stdStat.setStatusCode(key);
                        stdStat.setTitle(statusMap.get(key));
                        statuses.add(stdStat);
                    }
                } catch (SystemException e) {
                    LOG.error("System Exception in getting guidelines",e);
                }
        }
        return statuses;
    }

    public static String getStatusDescByCode(String statusCode)
    {
        return getStatusByCode(statusCode).getTitle();
    }

    public static StandardsStatus getStatusByCode(String statusCode)
    {
        StandardsStatus stdStatus = null;
        try
        {
            stdStatus = StandardsStatusLocalServiceUtil.getStatusesByStatusCode(statusCode).get(0);
        }
        catch (SystemException e)
        {
            e.printStackTrace();
        }
        return stdStatus;
    }
    
    public static StandardsStatus getStatusById(long statusId)
    {
        StandardsStatus stdStatus = null;
        try
        {
            stdStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(statusId);
        }
        catch (SystemException e)
        {
            e.printStackTrace();
        }
        catch (PortalException e)
        {
            e.printStackTrace();
        }
        return stdStatus;
    }

    public static List<StandardsStatus> getStatuses(String regionCode)
    {
        List<StandardsStatus> statuses = null;
        try
        {
            statuses = StandardsStatusLocalServiceUtil.getStatusesByRegionCode(StandardsRegionLocalServiceUtil
                    .getStandardsRegionByRegionCode(regionCode).getRegionId());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return statuses;
    }

    public static String getRegionCodeFromRole(String role)
    {
        if (role.contains(REGION_GLBL))
        {
            return REGION_GLBL;
        }
        else if (role.contains(REGION_AMER))
        {
            return REGION_AMER;
        }
        else if (role.contains(REGION_AMEA))
        {
            return REGION_AMEA;
        }
        else if (role.contains(REGION_EUROPE))
        {
            return REGION_EUROPE;
        }
        else if (role.contains(REGION_GC))
        {
            return REGION_GC;
        }
        else
        {
            return role;
        }

    }

    public static String getApproverKey(User user)
    {
        try
        {
            final List<Role> roles = user.getRoles();
            for (Role role : roles)
            {
                if (getApprovers().contains(role.getName()))
                {
                    return role.getName();
                }
                if (role.getName().equals(AUTHORS_GLOBAL_ROLE))
                {
                    return APPROVER_GLBL_ROLE;
                }
                if (role.getName().equals(AUTHORS_AMER_ROLE))
                {
                    return APPROVER_AMER_ROLE;
                }
                if (role.getName().equals(AUTHORS_AMEA_ROLE))
                {
                    return APPROVER_AMEA_ROLE;
                }
                if (role.getName().equals(AUTHORS_EUROPE_ROLE))
                {
                    return APPROVER_EUROPE_ROLE;
                }
                if (role.getName().equals(AUTHORS_GC_ROLE))
                {
                    return APPROVER_GC_ROLE;
                }
            }
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }

    public static boolean hasApproverRole(User user)
    {
        try
        {
            final List<Role> roles = user.getRoles();
            for (Role role : roles)
            {
                if (getApprovers().contains(role.getName()))
                {
                    return true;
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return false;
    }

    public static boolean hasApproverRole(User user, Standards standard)
    {
        boolean hasAccess = false;
        try
        {
            final List<Role> roles = user.getRoles();
            for (Role currRole : roles)
            {
                if ((currRole.getName().equals(APPROVER_GLBL_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_GLBL))
                     || (currRole.getName().equals(APPROVER_AMER_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_AMER))
                     || (currRole.getName().equals(APPROVER_EUROPE_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_EUROPE))
                     || (currRole.getName().equals(APPROVER_AMEA_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_AMEA))
                     || (currRole.getName().equals(APPROVER_GC_ROLE) && standard.getRegionCode().equalsIgnoreCase(REGION_GC))
                	 || (currRole.getName().equals(BrandStandardsUtil.BRND_STND_SUPER_ADMIN) && standard.getRegionCode().equalsIgnoreCase(REGION_GLBL)))
                {
                        hasAccess = true;
                        break;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return hasAccess;
    }

    public static List<StandardsStatus> getStatuses(final Standards standard)
    {
        try
        {
            return getStatuses(standard.getRegionCode());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return null;
    }
    
    public static String getSuperAdminApproverRole(String regionCode)
    {
        try
        {
           
            if (regionCode.equals("GLBL"))
            {
                return APPROVER_GLBL_ROLE;
            }
            if (regionCode.equals("AMER"))
            {
                return APPROVER_AMER_ROLE;
            }
            if (regionCode.equals("AMEA"))
            {
                return APPROVER_AMEA_ROLE;
            }
            if (regionCode.equals("EURO"))
            {
                return APPROVER_EUROPE_ROLE;
            }
            if (regionCode.equals("GC"))
            {
                return APPROVER_GC_ROLE;
            }
            
        }
        catch (Exception exc)
        {
            LOG.error(StackTraceUtil.getStackTrace(exc));
        }
        return null;
    }
	
	public static String getDefaultStatus(String regionCode)
    {
        if (regionCode.equals("GLBL"))
        {
            return DEFAULT_STATUS_CD_GLBL;
        }
        else if (regionCode.equals("AMER"))
        {
            return DEFAULT_STATUS_CD_AMER;
        }
        else if (regionCode.equals("AMEA"))
        {
            return DEFAULT_STATUS_CD_AMEA;
        }
        else if (regionCode.equals("EURO"))
        {
            return DEFAULT_STATUS_CD_EURO;
        }
        else if (regionCode.equals("GC"))
        {
            return DEFAULT_STATUS_CD_GC;
        }
        return null;
    }

    public static long getStatusIdByRegionCodeAndCode(String regionCode, String stCode)
    {
        try
        {
            List<StandardsStatus> statuses = StandardsStatusLocalServiceUtil.getStatusesByRegionCode(StandardsRegionLocalServiceUtil
                    .getStandardsRegionByRegionCode(regionCode).getRegionId());
            for(StandardsStatus status : statuses)
            {
                if(status.getStatusCode().equals(stCode))
                {
                    return status.getStatusId();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return -100;
    }
		
}
