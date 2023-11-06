/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.util;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsDisplayOrder;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <a href="ChangeOrderUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 */
public class ChangeOrderUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(ChangeOrderUtil.class);
    public static boolean setOrder(HttpServletRequest request, String paramName)
    {
        boolean processed = false;
        String standardIds = (String) request.getParameter(paramName);
        if (!BrandStandardsUtil.IsNullOrBlank(standardIds))
        {
            try
            {
                String[] stdIds = standardIds.split(",");
                int iCount = 1;
                for (String stdId : stdIds)
                {
                        Standards standard = StandardsLocalServiceUtil.getStandards(Long.valueOf(stdId));
                        standard.setOrderNumber(iCount);
                        iCount++;
                        StandardsLocalServiceUtil.updateStandards(standard);
                }
                processed = true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return processed;
    }
    
    /**
     * 
     * @param request
     * @param paramName
     * @param regionCode
     * @param chainCode
     * @return boolean
     * @author Chintan Akhani
     */
    public static boolean setOrderByChainAndRegion(HttpServletRequest request, String paramName, String regionCode, String chainCode)
    {
        boolean processed = false;
        String standardIds = (String) request.getParameter(paramName);
        if (!BrandStandardsUtil.IsNullOrBlank(standardIds))
        {
            try
            {
                String[] stdIds = standardIds.split(",");
                long iCount = 1l;
                for (String stdId : stdIds)
                {
                    if(Validator.isNotNull(stdId))
                    {
                        StandardsDisplayOrderPK displayOrderPK = new StandardsDisplayOrderPK();
                        displayOrderPK.setChainCode(chainCode);
                        displayOrderPK.setRegionCode(regionCode);
                        displayOrderPK.setStdId(GetterUtil.getLong(stdId));
                        StandardsDisplayOrder displayOrder = null;
                        try {
                            displayOrder = StandardsDisplayOrderLocalServiceUtil.getStandardsDisplayOrder(displayOrderPK);
                            displayOrder.setDisplayOrder(iCount);
                            StandardsDisplayOrderLocalServiceUtil.updateStandardsDisplayOrder(displayOrder);
                        } catch (PortalException e) {
                            LOG.error(e.getMessage(), e);
                        } catch (SystemException e) {
                            LOG.error(e.getMessage(), e);
                        }
                        if (displayOrder == null) {
                            displayOrder = StandardsDisplayOrderLocalServiceUtil.createStandardsDisplayOrder(displayOrderPK);
                            displayOrder.setDisplayOrder(iCount);
                            displayOrder.setCreatedDate(new Date());
                            displayOrder.setCreatorId(StringPool.BLANK+PortalUtil.getUserId(request));
                            displayOrder.setUpdatedBy(StringPool.BLANK+PortalUtil.getUserId(request));
                            displayOrder.setUpdatedDate(new Date());
                            StandardsDisplayOrderLocalServiceUtil.updateStandardsDisplayOrder(displayOrder);
                        }
                        iCount++;
                    }
                }
                processed = true;
            }
            catch (Exception e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
        return processed;
    }
    
    /**
     * Save order for standards/specs/guidelines.
     * 
     * @param request
     * @param paramName
     * @return
     */
    public static boolean setOrderByRegionAndBrand(PortletRequest request, boolean saveOrCopy)
    {
        boolean processed = false;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        HttpSession session = hsrw.getSession();
        String standardIds = (String) hsrw.getParameter("std_ids");
        String taxonomyId = (String) hsrw.getParameter("taxonomyId");
        String treeSelection = (String) hsrw.getParameter("treeSelection");
       // String filterBrand = (String) hsrw.getParameter("brandList");
        Preferences preferences = (Preferences)session.getAttribute("Preferences");
        String prefRegionCode = getUserRegionCode(preferences, themeDisplay);
        String[] chainCodes = null;
        if (preferences != null && !saveOrCopy)
        {
           /* if(preferences.getBrand().equals(filterBrand) || filterBrand == null)
            {
                chainCodes = new String[] {preferences.getBrand()};
            }
            else
            {
                chainCodes = new String[] {filterBrand};
            }*/
            chainCodes = new String[] {preferences.getBrand()};
            request.setAttribute("taxonomyId", taxonomyId);
            request.setAttribute("treeSelection", treeSelection);
        }
        else
        {
            chainCodes =  hsrw.getParameter("brands").split(",");
        }
        
        if (!BrandStandardsUtil.IsNullOrBlank(standardIds) && !BrandStandardsUtil.IsNullOrBlank(prefRegionCode) && !BrandStandardsUtil.IsNullOrBlank(chainCodes))
        {
            try
            {
                
                String[] stdIds = standardIds.split(",");
                int iCount = 1;
                for (String stdId : stdIds)
                {
                    for (String chainCode : chainCodes) 
                    {  
                        if (!saveOrCopy || ( saveOrCopy && checkStdIdBrandAssign(Long.valueOf(stdId), chainCode)))
                        {
                            StandardsDisplayOrder standardDisplayOrder = StandardsDisplayOrderLocalServiceUtil.getStandardsDispalyOrder(Long.valueOf(stdId), chainCode, prefRegionCode);
                            
                            if (BrandStandardsUtil.IsNullOrBlank(standardDisplayOrder)) 
                            {
                                standardDisplayOrder =  StandardsDisplayOrderLocalServiceUtil.addStandardsDisplayOrder(Long.valueOf(stdId), chainCode, prefRegionCode);
                                standardDisplayOrder.setCreatedDate( new Date());
                                standardDisplayOrder.setCreatorId(StringPool.BLANK+themeDisplay.getUserId());
                                standardDisplayOrder.setUpdatedDate( new Date());
                                standardDisplayOrder.setUpdatedBy(StringPool.BLANK+themeDisplay.getUserId());
                                standardDisplayOrder.setDisplayOrder(iCount);
                            } 
                            else 
                            {
                                standardDisplayOrder.setDisplayOrder(iCount);
                                standardDisplayOrder.setUpdatedDate( new Date());
                                standardDisplayOrder.setUpdatedBy(StringPool.BLANK+themeDisplay.getUserId());
                            }
                            iCount++;
                            StandardsDisplayOrderLocalServiceUtil.updateStandardsDisplayOrder(standardDisplayOrder);
                        }
                    }   
                }
                processed = true;
            }
            catch (Exception e)
            {
                LOG.info("Exception when saving or updateing standards order",e);
            }
        }
        return processed;
    }
    
    /**
     * Check whether standards is associated with brands.
     * @param stdId Standard id 
     * @param chainCode chain code
     * @return true/false
     */
    public static boolean checkStdIdBrandAssign(long stdId, String chainCode)
    {
        try 
        {
            ChainStandards chainStandards = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(stdId, chainCode);
            if (!BrandStandardsUtil.IsNullOrBlank(chainStandards))
            {
                return true;
            }
        } 
        catch (NoSuchChainStandardsException e) 
        {
            LOG.info("No Such Chain standards available" + e.getMessage()); 
        } 
        catch (SystemException e) 
        {
            LOG.info("Exception when fetch records ", e);
        }
        return false;
        
    }
    /**
     * Get region code based on login user's role.
     * @param preferences
     * @param themeDisplay
     * @return regionCode.
     */
    public static String getUserRegionCode(Preferences preferences, ThemeDisplay themeDisplay)
    {
        String regionCode = StringPool.BLANK;
        List<Role> roles;
        try 
        {
            roles = themeDisplay.getUser().getRoles();
            boolean isSuperAdmin = StandardsUtil.isSuperAdmin(roles);
            if (isSuperAdmin) 
            {
                regionCode = preferences.getRegionCode();
                LOG.info("Super User "+regionCode);
            }
            else
            {
                regionCode = StandardsStatusUtil.getRegionCodeFromRole(StandardsStatusUtil.getApproverKey(themeDisplay.getUser()));
                LOG.info("Not Super admin region  "+regionCode);
            }
        } 
        catch (SystemException e) 
        {
            LOG.error("Exception when getting region code",e);
        }
     return regionCode; 
    }
    
    /**
     * Add standards order when standard is Add/Edit from standards portlet.
     * @param stdId  
     * @param regionCode
     * @param chains
     * @param userId
     */
    public static void addStandardsOrder(long stdId, String regionCode, String[] chains, long userId)
    {  
        final int sortOrder = 1000;
        if (!BrandStandardsUtil.IsNullOrBlank(chains))
        {
            for (String chainCode : chains) 
            {
                StandardsDisplayOrder standardDisplayOrder = StandardsDisplayOrderLocalServiceUtil.getStandardsDispalyOrder(stdId, chainCode, regionCode);
                if (BrandStandardsUtil.IsNullOrBlank(standardDisplayOrder)) 
                {
                	standardDisplayOrder =  StandardsDisplayOrderLocalServiceUtil.addStandardsDisplayOrder(Long.valueOf(stdId), chainCode, regionCode);
                    standardDisplayOrder.setCreatedDate( new Date());
                    standardDisplayOrder.setCreatorId(StringPool.BLANK+userId);
                    standardDisplayOrder.setUpdatedDate( new Date());
                    standardDisplayOrder.setUpdatedBy(StringPool.BLANK+userId);
                    standardDisplayOrder.setDisplayOrder(sortOrder);
                    try 
                    {
                        StandardsDisplayOrderLocalServiceUtil.updateStandardsDisplayOrder(standardDisplayOrder);
                    }
                    catch (SystemException e) 
                    {
                        LOG.info("Exception when update stanards display order",e);
                    }
                } 
            }
            
        }
    }
}
