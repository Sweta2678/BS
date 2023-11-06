package com.ihg.brandstandards.util;

import com.ihg.brandstandards.bsadmin.model.BrandRegionProperties;
import com.ihg.brandstandards.bsadmin.model.ComplianceView;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.StandardsRegionChain;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.CountryStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsComplianceExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.ChainStandardsPK;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author hitesh.methani
 * 
 */
public class ComplianceUtil
{
    public static String MONTHS = "months";
    public static String DEFAULT_COMPLIANCE_RULE = "0 " + MONTHS;
    public static long NOT_APPLICABLE_COMP_RULE = -1L;
    public static final String SUCCESS_MESSAGE = "Your request processed successfully.";
    private static final Log LOG = LogFactoryUtil.getLog(ComplianceUtil.class);
    
    private static Map<String, String> COMPLY_RULES = null;
    
    public static void setBrands(ComplianceView complianceView)
    {
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
        complianceView.setAllBrands(chnCdMap);
    }

    /**
     * 
     * @param complianceView
     * @param user
     * @param objId
     * @throws PortalException
     * @throws SystemException
     */
    public static void setBrandRegionMapping(ComplianceView complianceView, User user, long objId, RenderRequest renderRequest) throws PortalException,
            SystemException
    {
        Map<String, Map<String, BrandRegionProperties>> brandRegionMapping = new HashMap<String, Map<String, BrandRegionProperties>>();
        List<StandardsRegion> regions = StandardsRegionLocalServiceUtil.getStandardsRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        Standards std = StandardsLocalServiceUtil.getStandards(objId);
        if (Validator.isNotNull(std))
        {
            Set<String> assignedRegions = new HashSet<String>();
            // If region is global we need to check for regions of standard on the basis of countries assigned
            if (std.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL))
            {
                List<CountryStandards> assignedCountries = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(objId);
                Map<String, Map<String, String>> allCountries = BrandStandardsUtil.getCountries();
                Map<String, String> ameaCountryMap = allCountries.get(BrandStandardsUtil.REGION_AMEA);
                Map<String, String> amerCountryMap = allCountries.get(BrandStandardsUtil.REGION_AMER);
                Map<String, String> gcCountryMap = allCountries.get(BrandStandardsUtil.REGION_GC);
                Map<String, String> europeCountryMap = allCountries.get(BrandStandardsUtil.REGION_EUROPE);
                if (Validator.isNotNull(assignedCountries))
                {
                    for (CountryStandards assignedCountry : assignedCountries)
                    {
                        if (Validator.isNotNull(ameaCountryMap) && ameaCountryMap.containsKey(assignedCountry.getCountry()))
                        {
                            assignedRegions.add(BrandStandardsUtil.REGION_AMEA);
                        }
                        else if (Validator.isNotNull(ameaCountryMap) && amerCountryMap.containsKey(assignedCountry.getCountry()))
                        {
                            assignedRegions.add(BrandStandardsUtil.REGION_AMER);
                        }
                        else if (Validator.isNotNull(gcCountryMap) && gcCountryMap.containsKey(assignedCountry.getCountry()))
                        {
                            assignedRegions.add(BrandStandardsUtil.REGION_GC);
                        }
                        else if (Validator.isNotNull(europeCountryMap)
                                && europeCountryMap.containsKey(assignedCountry.getCountry()))
                        {
                            assignedRegions.add(BrandStandardsUtil.REGION_EUROPE);
                        }
                    }
                }
            }
            else
            {
                assignedRegions.add(std.getRegionCode());
            }

            if (Validator.isNotNull(complianceView.getAllBrands()))
            {
                for (String brandCode : complianceView.getAllBrands().keySet())
                {
                    Map<String, BrandRegionProperties> innerRegionMapping = new HashMap<String, BrandRegionProperties>();
                    for (StandardsRegion stdRegion : regions)
                    {
                        BrandRegionProperties brandRegionProperties = getBrandRegionProperties(complianceView, stdRegion,
                                brandCode, user, assignedRegions, std, renderRequest);
                        innerRegionMapping.put(stdRegion.getRegionCode(), brandRegionProperties);
                    }
                    brandRegionMapping.put(brandCode, innerRegionMapping);
                }
            }

            complianceView.setBrandRegionMapping(brandRegionMapping);
        }
    }

    private static BrandRegionProperties getBrandRegionProperties(ComplianceView complianceView, StandardsRegion stdRegion,
            String brandCode, User user, Set<String> assignedRegions, Standards std,RenderRequest renderRequest) throws SystemException, PortalException
    {
        String createdByRegion = std.getRegionCode();
        List<Role> roles = user.getRoles();
        BrandRegionProperties brandRegionProperties = new BrandRegionProperties();
        String brandPerspective = complianceView.getSelectedBrand();
        String signedInAuthorRegion = StringPool.BLANK;
        
        boolean isSuperAdmin = StandardsUtil.isSuperAdmin(roles);
        if (isSuperAdmin){
	        final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
	                .getHttpServletRequest(renderRequest));
	        final HttpSession session = httpReq.getSession();
	        Preferences preferences = (Preferences)session.getAttribute("Preferences");
	        if (preferences != null) {
	        	signedInAuthorRegion = preferences.getRegionCode();
	        }
        } else{
        	signedInAuthorRegion = getRegionalAuthourRole(roles);
        }

        // If brand perspective is "All Brands" or not current brand then it is not editable.
        if (brandPerspective.equals(BSAdminConstants.ALL_BRAND) || !brandPerspective.equals(brandCode))
        {
            brandRegionProperties.setEditable(false);
        }
        else
        {
            // Handling regional standards editable only if logged in with regional author role 
            if (stdRegion.getRegionCode().equals(signedInAuthorRegion) && !createdByRegion.equals(BrandStandardsUtil.REGION_GLBL))
            {
                if (assignedRegions.contains(stdRegion.getRegionCode()) && brandPerspective.equals(brandCode) && !isStandardPublished(std.getStdId(), brandCode) && !isNAstdRgnChain(std.getStdId() , stdRegion.getRegionCode(), brandCode))
                {
                    brandRegionProperties.setEditable(true);
                    String[] brandRegionEdit = new String[2];
                    brandRegionEdit[0] = brandCode;
                    brandRegionEdit[1] = stdRegion.getRegionCode();
                    complianceView.setBrandRegionEdit(brandRegionEdit);
                }
                else
                {
                    brandRegionProperties.setEditable(false);
                }
            }
            // Handling global standards
            else if (createdByRegion.equals(BrandStandardsUtil.REGION_GLBL))
            {
                // Global region compliance rules will be editable by global authors only
                if (signedInAuthorRegion.equals(BrandStandardsUtil.REGION_GLBL)
                        && stdRegion.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL) && brandPerspective.equals(brandCode) && !isStandardPublished(std.getStdId(), brandCode) && !isNAstdRgnChain(std.getStdId() , stdRegion.getRegionCode(), brandCode) )
                {
                    brandRegionProperties.setEditable(true);
                    String[] brandRegionEdit = new String[2];
                    brandRegionEdit[0] = brandCode;
                    brandRegionEdit[1] = stdRegion.getRegionCode();
                    complianceView.setBrandRegionEdit(brandRegionEdit);
                }
                // For regional authors, set editable to true, if regions are assigned to standards
                else if (!signedInAuthorRegion.equals(BrandStandardsUtil.REGION_GLBL)
                        && assignedRegions.contains(stdRegion.getRegionCode())
                        && signedInAuthorRegion.equals(stdRegion.getRegionCode()) && brandPerspective.equals(brandCode) && !isStandardPublished(std.getStdId(), brandCode) &&  !isNAstdRgnChain(std.getStdId() , stdRegion.getRegionCode(), brandCode))
                {
                    brandRegionProperties.setEditable(true);
                    String[] brandRegionEdit = new String[2];
                    brandRegionEdit[0] = brandCode;
                    brandRegionEdit[1] = stdRegion.getRegionCode();
                    complianceView.setBrandRegionEdit(brandRegionEdit);
                }
                else
                {
                    brandRegionProperties.setEditable(false);
                }
            }

        }

        assignComplianceRule(brandRegionProperties, complianceView, std, stdRegion, brandCode, assignedRegions);
        return brandRegionProperties;

    }

    private static boolean isNAstdRgnChain(long stdId, String regionCode, String brandCode)
    {
        try
        {
            StandardsRegionChain stdRgnChain = StandardsRegionChainLocalServiceUtil.getStandardsRegionChain(new StandardsRegionChainPK(stdId, regionCode, brandCode));
            if(Validator.isNotNull(stdRgnChain) && stdRgnChain.getComplianceRule() == -1L)
            {
                return true;
            }
        }
        catch (PortalException e)
        {
            return false;
        }
        catch (SystemException e)
        {
            return false;
        }
        return false;
    }

    public static boolean isStandardPublished(long stdId, String brandCode) throws SystemException
    {
        // Dynamic query for publish table not needed now, as we have published date field in chainstd
        /*DynamicQuery dqPublish = DynamicQueryFactoryUtil.forClass(Publish.class);
        dqPublish.add(RestrictionsFactoryUtil.eq("chainCode", brandCode));
        dqPublish.setProjection(ProjectionFactoryUtil.property("publishId"));
        DynamicQuery dqPublishStd = DynamicQueryFactoryUtil.forClass(PublishStd.class);
        dqPublishStd.add(RestrictionsFactoryUtil.eq("stdId", stdId));
        dqPublishStd.add(PropertyFactoryUtil.forName("publishId").in(dqPublish)); */

        try
        {
            ChainStandards chainStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId, brandCode);
            if(Validator.isNotNull(chainStd) && Validator.isNotNull(chainStd.getLastPublishedDate()))
            {
                return true;
            }
        }
        catch (NoSuchChainStandardsException e)
        {
            return false;
        }
        return false;
    }

    private static void assignComplianceRule(BrandRegionProperties brandRegionProperties, ComplianceView complianceView,
            Standards std, StandardsRegion stdRegion, String brandCode, Set<String> assignedRegions) throws SystemException,
            PortalException
    {
        try
        {
            ChainStandards assignedChain = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(std.getStdId(), brandCode);
            // Assign published date
            if(Validator.isNotNull(assignedChain) && Validator.isNotNull(assignedChain.getLastPublishedDate()))
            {
                if(Validator.isNull(complianceView.getBrandPublishedDate()))
                {
                    complianceView.setBrandPublishedDate(new HashMap<String, String>());
                }
                Date publishDate = assignedChain.getLastPublishedDate();
                DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String publishedFormat = df.format(publishDate);
                complianceView.getBrandPublishedDate().put(brandCode, publishedFormat);
            }
            
            // If the region is not global, it will be N/A for all other regions
            if (!std.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL))
            {
                if (std.getRegionCode().equals(stdRegion.getRegionCode()))
                {
                    StandardsRegionChainPK standardsRegionChainPK = new StandardsRegionChainPK(std.getStdId(),
                            stdRegion.getRegionCode(), brandCode);
                    try
                    {
                        setDefaultValidity(standardsRegionChainPK, brandRegionProperties, false, complianceView);
                    }
                    catch (PortalException e)
                    {
                        // PortalException occurs if no record for that region and chain is found, in that case we need to show default compliance rule
                        brandRegionProperties.setValidity(DEFAULT_COMPLIANCE_RULE);
                    }
                }
                else
                {
                    brandRegionProperties.setValidity("N/A");
                }
            }
            // If standard is global
            else
            {
                // If we are mapping for Global region
                if (stdRegion.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL))
                {
                    StandardsRegionChainPK standardsRegionChainPK = new StandardsRegionChainPK(std.getStdId(),
                            stdRegion.getRegionCode(), brandCode);
                    try
                    {
                        setDefaultValidity(standardsRegionChainPK, brandRegionProperties, true, complianceView);
                    }
                    catch (PortalException e)
                    {
                        // PortalException occurs if no record for that region and chain is found, in that case we need to show default compliance rule
                        brandRegionProperties.setValidity(DEFAULT_COMPLIANCE_RULE);
                    }
                }
                // If we are mapping Global standards to other regions
                else
                {
                    StandardsRegionChainPK standardsRegionChainPK = new StandardsRegionChainPK(std.getStdId(),
                            stdRegion.getRegionCode(), brandCode);
                    try
                    {
                        setDefaultValidity(standardsRegionChainPK, brandRegionProperties, false, complianceView);
                    }
                    catch (PortalException e)
                    {
                        // PortalException occurs if no record for that region and chain is found, in that case we need to show default compliance rule if region is assigned
                        if (assignedRegions.contains(stdRegion.getRegionCode()))
                        {
                            if (!stdRegion.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL))
                            {
                                brandRegionProperties.setValidity(StringPool.DASH);
                            }
                            else
                            {
                                brandRegionProperties.setValidity(DEFAULT_COMPLIANCE_RULE);
                            }
                        }
                        // set compliance rule to N/A if region is not assigned to the standard
                        else
                        {
                            brandRegionProperties.setValidity("N/A");
                        }
                    }

                }
            }

        }
        catch (NoSuchChainStandardsException e)
        {
            // If brand is not assigned to standard, then we need to set compliance rule to N/A and editable to false
            brandRegionProperties.setEditable(false);
            brandRegionProperties.setValidity("N/A");
        }
    }

    private static void setDefaultValidity(StandardsRegionChainPK standardsRegionChainPK,
            BrandRegionProperties brandRegionProperties, boolean setExpire, ComplianceView complianceView) throws PortalException, SystemException
    {
        StandardsRegionChain stdRgnChain = StandardsRegionChainLocalServiceUtil.getStandardsRegionChain(standardsRegionChainPK);

        if (Validator.isNotNull(stdRgnChain))
        {
            long complianceRule = stdRgnChain.getComplianceRule();
            if (complianceRule == NOT_APPLICABLE_COMP_RULE)
            {
                brandRegionProperties.setValidity("N/A");
            }
            // Indicates if compliance rule is not set, we need to set it to default
            else if (complianceRule == 0)
            {
                brandRegionProperties.setValidity(DEFAULT_COMPLIANCE_RULE);
            }
            else
            {
                if(complianceRule != 1)
                {
                    brandRegionProperties.setValidity(complianceRule + StringPool.SPACE + MONTHS);
                }
                else
                {
                    brandRegionProperties.setValidity(complianceRule + StringPool.SPACE + "month");
                }
            }
            // setExpire is set to true in case of global standard and global region only
            if(setExpire)
            {
                if(Validator.isNotNull(stdRgnChain.getExpiredIds()))
                {
                    if(complianceView.getExpireStds() == null)
                    {
                        complianceView.setExpireStds(new HashMap<String, Standards[]>());
                    }
                    if(complianceView.getExpireIds() == null)
                    {
                        complianceView.setExpireIds(new HashMap<String, String>());
                    }
                    complianceView.getExpireStds().put(standardsRegionChainPK.getChainCode(), getExpireArr(stdRgnChain.getExpiredIds()));
                    complianceView.getExpireIds().put(standardsRegionChainPK.getChainCode(), stdRgnChain.getExpiredIds());
                }
            }
        }
        else
        {
            brandRegionProperties.setValidity("N/A");
        }
    }
    
    private static Standards[] getExpireArr(String expireStr)
    {
        String[] expireIds = expireStr.split(StringPool.COMMA);
        Standards[] stds = new Standards[expireIds.length];
        int i=0;
        for(String expireId : expireIds)
        {
            long stdId = Long.parseLong(expireId);
            try
            {
                Standards std = StandardsLocalServiceUtil.getStandards(stdId);
                stds[i] = std;
            }
            catch (PortalException e)
            {
                LOG.error("PortalException in getExipreArr "+ expireId + e.getMessage());
            }
            catch (SystemException e)
            {
                LOG.error("SystemException in getExipreArr "+ expireId + e.getMessage());
            }
            i++;
        }
        return stds;
    }
    
    /**
     * 
     * @param roles
     * @return
     */
    public static String getRegionalAuthourRole(List<Role> roles)
    {
        for (Role role : roles)
        {
            if (role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_GLOBAL_ROLE))
            {
                return BrandStandardsUtil.REGION_GLBL;
            }
            else if (role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_AMEA_ROLE))
            {
                return BrandStandardsUtil.REGION_AMEA;
            }
            else if (role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_AMER_ROLE))
            {
                return BrandStandardsUtil.REGION_AMER;
            }
            else if (role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_EUROPE_ROLE))
            {
                return BrandStandardsUtil.REGION_EUROPE;
            }
            else if (role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_GC_ROLE))
            {
                return BrandStandardsUtil.REGION_GC;
            }
        }
        return StringPool.BLANK;
    }

    public static String validateExpireId(long searchStdId, long currentStdId, String[] expireIds, String currentBrand) throws PortalException, SystemException
    {
        Standards currentStd = StandardsLocalServiceUtil.getStandards(currentStdId);
        Standards searchStd = StandardsLocalServiceUtil.getStandards(searchStdId);
        String searchStdAsString = String.valueOf(searchStdId);
        // Validation Rule 1 : current id not allowed in expire rule
        if(searchStdId == currentStdId)
        {
            return "You cannot add the current standard or specification as an expiry rule";
        }
        // Validation Rule 2 : Parent standard cannot be added as an expiry rule
        else if(currentStd.getStdTyp().equals(BrandStandardsUtil.STD_TYPE_SPEC) && currentStd.getParentId() == searchStdId)
        {
            return "You cannot add the parent standard as an expiry rule";
        }
        // Validation Rule 3 : Duplicates should not be allowed
        else if(Validator.isNotNull(expireIds) && Arrays.asList(expireIds).contains(searchStdAsString))
        {
            return "Selected standard or specification already added";
        }
        // Validation Rule 4 : If a standard is already added then underlying specification cannot be added
        else if(Validator.isNotNull(searchStd) && searchStd.getStdTyp().equals(BrandStandardsUtil.STD_TYPE_SPEC) && Validator.isNotNull(expireIds) && Arrays.asList(expireIds).contains(String.valueOf(searchStd.getParentId())))
        {
            return "You cannot add the underlying specification as an expiry rule";
        }
        // Validation Rule 5 : Current brand should be attributed to assigned standard or specification
        else if(Validator.isNotNull(searchStd))
        {
            try
            {
                ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(searchStdId, currentBrand);
            }
            catch(NoSuchChainStandardsException e)
            {
                return "Standard or Specification not attributed to selected brand";
            }
        }
        return "valid";
    }
    /**
     * 
     * @param std
     */
    public static void updateRegions(Standards std, long userId)
    {
        try
        {
            List<CountryStandards> countryStd = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(std.getStdId());
            Set<String> notAssignedRegions = new HashSet<String>();
            Set<String> assignedRegions = new HashSet<String>();
            notAssignedRegions.add(BrandStandardsUtil.REGION_AMEA);
            notAssignedRegions.add(BrandStandardsUtil.REGION_AMER);
            notAssignedRegions.add(BrandStandardsUtil.REGION_GC);
            notAssignedRegions.add(BrandStandardsUtil.REGION_EUROPE);
            Map<String, Map<String, String>> allCountries = BrandStandardsUtil.getCountries();
            if(Validator.isNotNull(countryStd))
            {
                for(CountryStandards assignedCountry: countryStd)
                {
                    if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_AMEA)) && allCountries.get(BrandStandardsUtil.REGION_AMEA).containsKey(assignedCountry.getCountry()))
                    {
                        notAssignedRegions.remove(BrandStandardsUtil.REGION_AMEA);
                        assignedRegions.add(BrandStandardsUtil.REGION_AMEA);
                    }
                    else if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_AMER)) && allCountries.get(BrandStandardsUtil.REGION_AMER).containsKey(assignedCountry.getCountry()))
                    {
                        notAssignedRegions.remove(BrandStandardsUtil.REGION_AMER);
                        assignedRegions.add(BrandStandardsUtil.REGION_AMER);
                    }
                    else if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_GC)) && allCountries.get(BrandStandardsUtil.REGION_GC).containsKey(assignedCountry.getCountry()))
                    {
                        notAssignedRegions.remove(BrandStandardsUtil.REGION_GC);
                        assignedRegions.add(BrandStandardsUtil.REGION_GC);
                    }
                    else if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_EUROPE)) && allCountries.get(BrandStandardsUtil.REGION_EUROPE).containsKey(assignedCountry.getCountry()))
                    {
                        notAssignedRegions.remove(BrandStandardsUtil.REGION_EUROPE);
                        assignedRegions.add(BrandStandardsUtil.REGION_EUROPE);
                    }
                }
            }
            Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
            StandardsRegionChainPK stdRgnChainPK = new StandardsRegionChainPK();
            
            for(String chainCd : chnCdMap.keySet())
            {
                if(!isStandardPublished(std.getStdId(), chainCd))
                {
                    stdRgnChainPK.setChainCode(chainCd);
                    stdRgnChainPK.setStdId(std.getStdId());
                    for(String notAssignedRegion : notAssignedRegions)
                    {
                        stdRgnChainPK.setRegionCode(notAssignedRegion);
                        try
                        {
                            StandardsRegionChainLocalServiceUtil.deleteStandardsRegionChain(stdRgnChainPK);
                        }
                        catch (PortalException e)
                        {
                            LOG.error("StandardsRegionChain not found for deletion " + e.getMessage());
                        }
                    }
                }
                stdRgnChainPK.setChainCode(chainCd);
                stdRgnChainPK.setStdId(std.getStdId());
                // Adding GLBL region for GLBL standard
                if(std.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL))
                {
                    assignedRegions.add(BrandStandardsUtil.REGION_GLBL);
                }
                for(String assignedRegion : assignedRegions)
                {
                    stdRgnChainPK.setRegionCode(assignedRegion);
                    if(isBrandAssigned(std, chainCd))
                    {
                        if (isStandardPublished(std.getStdId(), chainCd))
                        {
                            addStdRgnChain(stdRgnChainPK, userId, -1L);
                        }
                        else
                        {
                            // Indicates standard is not published
                            StandardsRegionChainPK globalStandardsRegionChainPK = new StandardsRegionChainPK(std.getStdId(), BrandStandardsUtil.REGION_GLBL, chainCd);
                            long complianceRule = 0L;
                            try
                            {
                                StandardsRegionChain glblStdRgnChn = StandardsRegionChainLocalServiceUtil.getStandardsRegionChain(globalStandardsRegionChainPK);
                                complianceRule = glblStdRgnChn.getComplianceRule();
                            }
                            catch (PortalException e)
                            {
                                LOG.error("PortalException in getting StdRgnChain "+ e.getMessage());
                            }
                            addStdRgnChain(stdRgnChainPK, userId, complianceRule);
                        }
                    }
                }
            }
        }
        
        catch (SystemException e)
        {
            LOG.error("SystemException in fetching CountryStandards "+ e.getMessage());
        }
        
    }
    
    private static void addStdRgnChain(StandardsRegionChainPK stdRgnChainPK, long userId, long complianceRule) throws SystemException
    {
        StandardsRegionChain stdRgnChain;
        try
        {
            stdRgnChain = StandardsRegionChainLocalServiceUtil.getStandardsRegionChain(stdRgnChainPK);
        }
        catch (PortalException e)
        {
            // If stdRgnChain does not exist, it means new region is added for published brand, so setting it to N/A
            stdRgnChain = StandardsRegionChainLocalServiceUtil.createStandardsRegionChain(stdRgnChainPK);
            stdRgnChain.setComplianceRule(complianceRule);
            Date currDate = new Date();
            stdRgnChain.setCreatedDate(currDate);
            stdRgnChain.setCreatorId(String.valueOf(userId));
            stdRgnChain.setUpdatedBy(String.valueOf(userId));
            stdRgnChain.setUpdatedDate(currDate);
            StandardsRegionChainLocalServiceUtil.updateStandardsRegionChain(stdRgnChain);
        }
    }
    
    public static boolean isBrandAssigned(Standards std, String chainCode) throws SystemException
    {
        try
        {
            ChainStandards chainStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(std.getStdId(), chainCode);
            if(Validator.isNotNull(chainStd))
            {
                return true;
            }
        }
        catch (NoSuchChainStandardsException e)
        {
            return false;
        }
        return false;
    }
    
    public static void removeBrand(String chainCode, long stdId)
    {
        try
        {
            if(!isStandardPublished(stdId, chainCode))
            {
                List<StandardsRegionChain> stdRgnChains = StandardsRegionChainLocalServiceUtil.getStandardsRgnchainByStdId(stdId, chainCode);
                if(Validator.isNotNull(stdRgnChains) && stdRgnChains.size() > 0)
                {
                    for(StandardsRegionChain stdRgnChain : stdRgnChains)
                    {
                        stdRgnChain.setComplianceRule(-1);
                        StandardsRegionChainLocalServiceUtil.updateStandardsRegionChain(stdRgnChain);
                    }
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in removing stdRgnChain "+ e.getMessage());
        }
    }
    
    /**
     * To add workflow entry
     * @param brandEdit
     * @param regionEdit
     * @param stdId
     * @param comment
     * @param user
     */
    public static void updateWorkflowEntry(String brandEdit, String regionEdit, long stdId, String comment, User user)
    {
        try
        {
            final long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
            final Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
            Standards std = StandardsLocalServiceUtil.getStandards(stdId);
            Date currDate = new Date();
            ChainStandards chainStd = ChainStandardsLocalServiceUtil.getChainStandards(new ChainStandardsPK(brandEdit, stdId));
            workflow.setStatus(StandardsStatusLocalServiceUtil.getStandardsStatus(chainStd.getStatusId()).getStatusCode());
            workflow.setObjectId(std.getStdId());
            workflow.setObjectType(std.getStdTyp());
            workflow.setCreatedBy(user.getScreenName());
            workflow.setUpdatedBy(String.valueOf(user.getUserId()));
            workflow.setUpdatedDate(currDate);
            workflow.setCreatedDate(currDate);
            workflow.setCreatorId(String.valueOf(user.getUserId()));
            workflow.setComment(comment);
            workflow.setTitle(std.getTitle());
            WorkflowLocalServiceUtil.addWorkflow(workflow);
        }
        catch (PortalException e)
        {
            LOG.error("PortalException in adding workflow entry" + e.getMessage());
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in adding workflow entry" + e.getMessage());
        }
    }
    /**
     * 
     * @param user
     * @return
     * @throws SystemException 
     */
    public static boolean isAuthour(User user) throws SystemException
    {
        if(Validator.isNotNull(user))
        {
            if(StringPool.BLANK.equals(getRegionalAuthourRole(user.getRoles())))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
       return false; 
    }

    /**
     * Update all other regions complianceRule, if compliance rule for GLBL standard is changed
     * @param stdRgnChnPk
     * @throws SystemException 
     */
    public static void updateDependantStdRegions(StandardsRegionChain stdRgnChn) throws SystemException
    {
        List<StandardsRegionChain> stdRgnChains = StandardsRegionChainLocalServiceUtil.getStandardsRgnchainByStdId(stdRgnChn.getStdId(), stdRgnChn.getChainCode());
        if(Validator.isNotNull(stdRgnChains) && stdRgnChains.size() > 0)
        {
            Set<String> assignedRegions = getRegionAssigned(stdRgnChn.getStdId());
            for(StandardsRegionChain stdRgnChain : stdRgnChains)
            {
                if(!stdRgnChain.getRegionCode().equals(BrandStandardsUtil.REGION_GLBL) && Validator.isNotNull(assignedRegions) && assignedRegions.contains(stdRgnChain.getRegionCode()))
                {
                    stdRgnChain.setComplianceRule(stdRgnChn.getComplianceRule());
                    StandardsRegionChainLocalServiceUtil.updateStandardsRegionChain(stdRgnChain);
                }
            }
        }
    }
    
    /**
     * To get regions assigned to the standard
     * @param stdId
     * @return
     * @throws SystemException
     */
    public static Set<String> getRegionAssigned(long stdId) throws SystemException
    {
        List<CountryStandards> countryStd = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(stdId);
        Set<String> assignedRegions = new HashSet<String>();
        Map<String, Map<String, String>> allCountries = BrandStandardsUtil.getCountries();
        if(Validator.isNotNull(countryStd))
        {
            for(CountryStandards assignedCountry: countryStd)
            {
                if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_AMEA)) && allCountries.get(BrandStandardsUtil.REGION_AMEA).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BrandStandardsUtil.REGION_AMEA);
                }
                else if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_AMER)) && allCountries.get(BrandStandardsUtil.REGION_AMER).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BrandStandardsUtil.REGION_AMER);
                }
                else if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_GC)) && allCountries.get(BrandStandardsUtil.REGION_GC).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BrandStandardsUtil.REGION_GC);
                }
                else if (Validator.isNotNull(allCountries.get(BrandStandardsUtil.REGION_EUROPE)) && allCountries.get(BrandStandardsUtil.REGION_EUROPE).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BrandStandardsUtil.REGION_EUROPE);
                }
            }
        }
        return assignedRegions;
    }
    /**
     * 
     * @param stdId
     * @param chainCode
     */
    public static void addBrand(long stdId, String chainCode)
    {
        try
        {
            if(!isStandardPublished(stdId, chainCode))
            {
                List<StandardsRegionChain> stdRgnChains = StandardsRegionChainLocalServiceUtil.getStandardsRgnchainByStdId(stdId, chainCode);
                if(Validator.isNotNull(stdRgnChains) && stdRgnChains.size() > 0)
                {
                    for(StandardsRegionChain stdRgnChain : stdRgnChains)
                    {
                        if(stdRgnChain.getComplianceRule() == -1L)
                        {
                            stdRgnChain.setComplianceRule(0L);
                            StandardsRegionChainLocalServiceUtil.updateStandardsRegionChain(stdRgnChain);
                        }
                    }
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in removing stdRgnChain "+ e.getMessage());
        }
        
    }
    
    public static ComplianceView getBrandRegionMappingByStdIdAndBrandCode(ComplianceView complianceView, long stdId, User user, String chainCode )
    {
    	
    	 Map<String, String> assignedRegions = new HashMap<String, String>();
    	 try
    	 {
    		 Standards std = StandardsLocalServiceUtil.getStandards(stdId);
	         if (Validator.isNotNull(std))
	         {
	             List<Object> assignedCountries = CountryStandardsExtLocalServiceUtil.getRegionsCountryCount(stdId);
	             List<Object> regionStatuses = StandardsComplianceExtLocalServiceUtil.getRegionStatus(stdId, chainCode);
	             if (Validator.isNotNull(assignedCountries))
	             {
	                 for (Object assignedObj : assignedCountries)
	                 {
	                	 Object[] assignedCountry = (Object[])assignedObj;
	                	 String status = "ALL";
	                	 for(Object regionStatus : regionStatuses)
	                	 {
	                		 Object[] rgnStat = (Object[])regionStatus;
	                		 if(rgnStat[1].toString().equals(assignedCountry[0].toString()))
	                		 {
	                			 if(((BigDecimal) assignedCountry[1]).longValue() == ((BigDecimal) rgnStat[0]).longValue()){
	                				 String complinceExp="";
	                				 String ruleValue ="";
	                				 if(rgnStat[3].toString().equals("R")){
	                					 complinceExp="C";
		                				 ruleValue ="R";
	                				 }else{
	                					 complinceExp =rgnStat[2].toString();
	                					 ruleValue = rgnStat[3].toString();
	                				 }
	                				 
	                			 List<Object> objList= StandardsComplianceExtLocalServiceUtil.getRegionCmplyExprCount(stdId, chainCode, rgnStat[1].toString(), complinceExp,ruleValue);
	                			 BigDecimal maxValueCount = (BigDecimal)objList.get(0);
	                				 if(((BigDecimal) assignedCountry[1]).longValue() > ((BigDecimal) maxValueCount).longValue()){
	    	                			 status = "PARTIAL";
	    	                			 break;
	    	                		 }
	                				 
	                			 }else if(((BigDecimal) assignedCountry[1]).longValue() > ((BigDecimal) rgnStat[0]).longValue()){
	                			 status = "PARTIAL";
	                			 break;
	                			 }
	                		 }
	                	 }
	                	 assignedRegions.put(assignedCountry[0].toString(), status);
	                 }
	             }
	             assignedRegions.put(BrandStandardsUtil.REGION_GLBL, "ALL");        	 
	         }
	         complianceView.setStdId(std.getStdId());
        	 complianceView.setAssociatedRegions(assignedRegions);
        	 complianceView.setAuthor(isAuthour(user));
        	 complianceView.setAuthorsRegion(getRegionalAuthourRole(user.getRoles()));
        	 complianceView.setSuperAdmin(StandardsUtil.isSuperAdmin(user.getRoles()));
        	 complianceView.setGlobalAuthor(StandardsUtil.isGlobalAuthor(user.getRoles()));
	    }
    	catch(Exception se)
        {
    	 	LOG.error(se);
    	 	se.printStackTrace();
        }
    	return complianceView;
    }
    
    public static List<ChainStandards> getChainStandardsForViewCompliance(long stdId) throws SystemException
    {
    	List<ChainStandards> arlChainStandards = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(stdId);
    	
    	
    	return arlChainStandards;
    }
    
    public static Map<String, String> getComplianceRules()
    {
		if(COMPLY_RULES == null)
		{
	    	COMPLY_RULES = new LinkedHashMap<String, String>();
	    	COMPLY_RULES.put("0", "0 months");
	    	COMPLY_RULES.put("1", "1 month");
	    	COMPLY_RULES.put("3", "3 months");
	    	COMPLY_RULES.put("6", "6 months");
	    	COMPLY_RULES.put("9", "9 months");
	    	COMPLY_RULES.put("12", "12 months");
	    	COMPLY_RULES.put("18", "18 months");
	    	COMPLY_RULES.put("24", "24 months");
	    	COMPLY_RULES.put("36", "36 months");
	    	COMPLY_RULES.put("60", "60 months");
	    	COMPLY_RULES.put("120", "120 months");
		}
		return COMPLY_RULES;
    }
 
 
    
	}

