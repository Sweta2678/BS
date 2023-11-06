package com.ihg.brandstandards.bridge.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.me2.utils.session.MerlinCache;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;

public class BrandStandardsUtil
{
    public static final String REGION_GLBL = "GLBL";
    public static final String REGION_AMER = "AMER";
    public static final String REGION_AMEA = "AMEA";
    public static final String REGION_EUROPE = "EURO";
    public static final String REGION_GC = "GC";
    public static final int DEFAULT_ITEMS_PER_PAGE = SearchContainer.DEFAULT_DELTA;
    public static final String REQUEST_PARAM_REC_PER_PAGE = "recPerPage";

    private static final Log LOG = LogFactoryUtil.getLog(BrandStandardsUtil.class);

    public static Map<String, String> chainCodeMap()
    {
        Map<String, String> chnCdMap = null;
        if (MerlinCache.getCacheMap("BRNDSTD_CHN") != null) {
            final Map<String, Object> chnFullMap = (Map<String, Object>) MerlinCache
                    .getCacheMap("BRNDSTD_CHN");
            Map<String, String>  tmpChnCdMap = (Map<String, String>) chnFullMap.get("SECURITY_VALUES");
            
            
            chnCdMap = new LinkedHashMap<String, String>();
            /* Need to remove below code after push new brand in Bridge and OBSM */
            for(Map.Entry<String,String> entry : tmpChnCdMap.entrySet()){
            	if(!(entry.getKey().contains("VX") || entry.getKey().contains("KI") || entry.getKey().contains("RE"))){
                	chnCdMap.put(entry.getKey(),entry.getValue());
                }
            }
            /*end CR11 - 18 */
        } else {
            chnCdMap = new LinkedHashMap<String, String>();
            chnCdMap.put("IC", "InterContinental Hotels");
            chnCdMap.put("IR", "InterContinental Resorts");
            chnCdMap.put("HI", "Holiday Inn");
            chnCdMap.put("EX", "Holiday Inn Express");
            chnCdMap.put("RS", "Holiday Inn Resort");
            chnCdMap.put("CV", "Holiday Inn Club Vacations");
            chnCdMap.put("CP", "Crowne Plaza Hotels");
            chnCdMap.put("CR", "Crowne Plaza Resorts");
            chnCdMap.put("UL", "HUALUXE Hotels & Resorts");
            chnCdMap.put("IN", "Hotel Indigo");
            chnCdMap.put("VN", "EVEN Hotels");
            chnCdMap.put("SB", "Staybridge Suites");
            chnCdMap.put("CW", "Candlewood Suites");
            chnCdMap.put("VA", "avid hotels");
            /* uncomment when introduce new brand in Bridge and OBSM 
             * chnCdMap.remove("VX");
            	chnCdMap.remove("KI");
           		chnCdMap.remove("RE");
             * */
        }        
        return chnCdMap;
    }

    public static String getUserRegionFromUserRole(List<Role> arlRole)
    {
        String region = new String();
        try
        {
            for (Role role : arlRole)
            {
                String roleName = role.getName().toUpperCase();
                if ("BRND_STND_BRIDGE_GLBL_ADMIN".equals(roleName) )
                {
                    region = REGION_GLBL;
                    break;
                }
                if ("BRND_STND_BRIDGE_AMER_ADMIN".equals(roleName) )
                {
                    region = REGION_AMER;
                    break;
                }
                if ("BRND_STND_BRIDGE_AMEA_ADMIN".equals(roleName) )
                {
                    region = REGION_AMEA;
                    break;
                }
                if ("BRND_STND_BRIDGE_GC_ADMIN".equals(roleName) )
                {
                    region = REGION_GC;
                    break;
                }
                if ("BRND_STND_BRIDGE_EURO_ADMIN".equals(roleName) )
                {
                    region = REGION_EUROPE;
                    break;
                }

            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return region;
    }
    
    public static String getGemUserRegionFromUserRole(List<Role> arlRole)
    {
        String region = new String();
        try
        {
            for (Role role : arlRole)
            {
                String roleName = role.getName().toUpperCase();
                if (roleName.contains("BRND_STND_GEM_GLBL"))
                {
                    region = REGION_GLBL;
                    break;
                }
                if (roleName.contains("BRND_STND_GEM_AMER"))
                {
                    region = REGION_AMER;
                    break;
                }
                if (roleName.contains("BRND_STND_GEM_AMEA"))
                {
                    region = REGION_AMEA;
                    break;
                }
                if (roleName.contains("BRND_STND_GEM_GC"))
                {
                    region = REGION_GC;
                    break;
                }
                if (roleName.contains("BRND_STND_GEM_EURO"))
                {
                    region = REGION_EUROPE;
                    break;
                }

            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return region;
    }
    
    public static boolean isGemGlobalDepartmentAdmin(List<Role> arlRole)
    {
        try
        {
            for (Role role : arlRole)
            {
                String roleName = role.getName().toUpperCase();
                if ("BRND_STND_GEM_ADMIN".equals(roleName) || roleName.contains("BRND_STND_GEM_GLBL"))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return false;
    }
    
    public static boolean isGemGlobalAdmin(List<Role> arlRole)
    {
        try
        {
            for (Role role : arlRole)
            {
                String roleName = role.getName().toUpperCase();
                if ("BRND_STND_GEM_ADMIN".equals(roleName) || "BRND_STND_GEM_GLBL_ADMIN".equals(roleName))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return false;
    }
    
    /**
     * Decode region code.
     * 
     * @param region region code
     * @return decoded region
     */
    public static String decodeRegionCode(String region)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("inside region code");
        }
        String regionCode = "";
        final Map<String, String> rgnCdMap = new LinkedHashMap<String, String>();
        rgnCdMap.put("AMR", "AMER");
        rgnCdMap.put("EUR", "EURO");
        rgnCdMap.put("AME", "AMEA");
        rgnCdMap.put("GC", "GC");
        rgnCdMap.put("GLB", "GLBL");

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : rgnCdMap.entrySet())
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
        regionCode = builder.toString();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("the value of region code is " + regionCode);
        }
        return regionCode;
    }

    public static String decodeReverseRegionCode(String region)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("inside region code");
        }
        String regionCode = "";
        final Map<String, String> rgnCdMap = new LinkedHashMap<String, String>();
        rgnCdMap.put("AMER", "AMR");
        rgnCdMap.put("EURO", "EUR");
        rgnCdMap.put("AMEA", "AME");
        rgnCdMap.put("GC", "GC");
        rgnCdMap.put("GLBL", "GLB");

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : rgnCdMap.entrySet())
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
        regionCode = builder.toString();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("the value of region code is " + regionCode);
        }
        return regionCode;
    }

    public static String decodeRegionName(String region)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("inside region code");
        }
        String regionCode = "";
        final Map<String, String> rgnCdMap = new LinkedHashMap<String, String>();
        rgnCdMap.put("AMER", "Americas");
        rgnCdMap.put("EURO", "Europe");
        rgnCdMap.put("AMEA", "Asia, Middle East and Africa");
        rgnCdMap.put("GC", "Greater China");
        rgnCdMap.put("GLBL", "Global");

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : rgnCdMap.entrySet())
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
        regionCode = builder.toString();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("the value of region name is " + regionCode);
        }
        return regionCode;
    }

    public static boolean IsNullOrBlank(final Object obj)
    {
        return obj == null || obj.toString().isEmpty();
    }

    /**
     * Get string value or empty string.
     * 
     * @param obj - value
     * @return - value
     */
    public static String getValueOrBlank(final Object obj)
    {
        return obj == null ? "" : obj.toString();
    }

    public static boolean isSubsequentPublication(String environment, String status, String chainCd)
    {
        boolean state = false;
        try
        {
            Publication pub = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(status, environment, chainCd);
            LOG.debug("pub  :  " + pub);
            if (pub != null)
            {
                state = true;
            }
        }
        catch (Exception exc)
        {
        	LOG.error(exc.getMessage());
        }
        return state;
    }
    
    public static String isReadOnlyForEditStates(String environment, String chainCd)
    {
        String readOnly = "false";
        try
        {
            List<Publication> publications = PublicationLocalServiceUtil.getPublishByEnvChainCode(environment, chainCd);
            LOG.debug("\n\n\n\npublication size for edit states      :  " + publications.size());
            if (publications == null || (publications != null && publications.size() < 1))
            {
            	readOnly = "false";
            }
            else if (publications.size() > 1)
            {
            	readOnly = "true";
            }
            else
            {
            	readOnly = "true";
            	Publication currPub = PublicationLocalServiceUtil.getPublishByStatEnvChainCode("ACTIVE", "BRIDGE", chainCd);
            	Publication firstPub = null;
            	for(Publication publication : publications)
            	{
            		if(publication.getPublishVerId()==1)
            		{
            			firstPub = publication;
            		}
            	}
            	LOG.debug("First Pub : "+ firstPub.getPublishContentType());
            	LOG.debug("Current Pub : "+ currPub.getPublishContentType());
            	if(firstPub!=null && firstPub.getPublishContentType().equals("OPERATE")
            			&& currPub!=null && currPub.getPublishContentType().contains("BUILD_OPERATE"))
            	{
            		readOnly = "TBD";
            	}
            }
        }
        catch (Exception exc)
        {
        	LOG.error(exc.getMessage());
        }
        return readOnly;
    }
    
    /**
     * @return Map<String, String>
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
	 * 
	 * @param companyId
	 * @param roleName
	 * @return long
	 */
	public static long getRoleId(long companyId, String roleName)
	{
		Role role = null;
		long roleId = 0; 
		
		try {
			role = RoleLocalServiceUtil.getRole(companyId, roleName);
			
			if(role != null){
				roleId = role.getRoleId();
			}
		} catch (PortalException e) {
			LOG.error("Could not find role with name : " + roleName);
		} catch (SystemException e) {
			LOG.error("Could not find role with name : " + roleName);
		}
		
		return roleId;
	}
	
	/**
	 * Get list of departments based on user's role based permission
	 * @param userRoleList
	 * @return List<Department>
	 */
	public static List<Department> getRoleBasedDeptList (List<Department> deptList, List<Role> userRoleList) {
		Set<String> deptRoleList = new HashSet<String>();
		List<Department> departmentList = new ArrayList<Department>();
		//Store all regular role description
		//To identify department, use description field of role
		if (userRoleList != null && userRoleList.size() > 0) {
			for (Role role : userRoleList) {
				deptRoleList.add(role.getDescriptionCurrentValue());
			}
		}
		for (Department department : deptList) {
			if (deptRoleList.contains(department.getDepartmentName())) {
				departmentList.add(department);
			}
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug(" Role List :"+deptRoleList);
		}
		return departmentList;
	}
	
	public static long getRegionIdForRegionCode(String regionCd)
    {
        long regionId;
        if (REGION_AMER.equals(regionCd))
        {
            regionId = 2;
        }
        else if (REGION_AMEA.equals(regionCd))
        {
            regionId = 3;
        }
        else if (REGION_EUROPE.equals(regionCd))
        {
            regionId = 4;
        }
        else if (REGION_GC.equals(regionCd))
        {
            regionId = 5;
        }
        else
        {
            // REGION_GLOBAL;
            regionId = 1;
        }
        
        return regionId;
    }
	
}
