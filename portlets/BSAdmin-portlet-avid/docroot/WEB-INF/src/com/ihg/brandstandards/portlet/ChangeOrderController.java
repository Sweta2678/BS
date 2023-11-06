/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.StandardsDisplayOrderExt;
import com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.ChangeOrderUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="ChangeOrderController.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 */
public class ChangeOrderController extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ChangeOrderController.class);

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        
    	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        getUserIndexAdminRoles(renderRequest, themeDisplay);
        final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(renderRequest);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        Preferences preferences = (Preferences)httpRequest.getSession().getAttribute("Preferences");
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
        String chainCode = StringPool.BLANK;
        if (!StandardsUtil.IsNullOrBlank(renderRequest.getParameter("selectedBrand1")))
        {
            chainCode = renderRequest.getParameter("selectedBrand1");
        }
        else if (preferences != null)
        {
        	chainCode = preferences.getBrand();
        }
        renderRequest.setAttribute("successMsg", renderRequest.getParameter("msgDisp"));
        renderRequest.setAttribute("selectedBrand", chainCode);
        renderRequest.setAttribute("chaCdMap",chnCdMap);
        PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(viewTemplate);
        rd.include(renderRequest, renderResponse);
    }

    @ProcessAction(name = "save")
    public void save(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        boolean success = ChangeOrderUtil.setOrderByRegionAndBrand(actionRequest, false);
        String chainCode =  ParamUtil.getString(actionRequest, "brandList");
        actionResponse.setRenderParameter("selectedBrand1", chainCode);
        if (success)
        {	
        	actionResponse.setRenderParameter("msgDisp", "true");
        }	
    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse response) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final String resourceID = resourceRequest.getResourceID();
        final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        getUserIndexAdminRoles(resourceRequest, themeDisplay);
       
        if ("getTreeData".equals(resourceID))
        {
        	ChangeOrderUtil.xmlTaxonomy(resourceRequest, response, LOG);
        }
        else if ("getStandards".equalsIgnoreCase(resourceID))
        {
        	
            getStandards(resourceRequest, response, httpRequest.getSession());
        }
        /*else if ("getFilteredStandards".equalsIgnoreCase(resourceID))
        {
        	getStandards(resourceRequest, response, httpRequest.getSession());
        }
        else if ("copyStandards".equalsIgnoreCase(resourceID))
        {
        	ChangeOrderUtil.setOrderByRegionAndBrand(resourceRequest, true);
    	}	*/
    }

    /**
     * Fetch Specifications and Guidelines from database.
     * 
     * @param resourceRequest - ResourceRequest
     * @throws PortletException - exception
     * @throws IOException - exception
     */
    private void getStandards(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse,
            final HttpSession session) throws PortletException, IOException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	List<StandardsDisplayOrderExt> standardsDisplayOrderExts = null;
        boolean addComma = false;
        StringBuffer standardsOrder = new StringBuffer();
        String chainCode = StringPool.BLANK;
        Preferences preferences = (Preferences)session.getAttribute("Preferences");
        String prefRegionCode = ChangeOrderUtil.getUserRegionCode(preferences, themeDisplay);
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
        long taxonomyId = Long.valueOf(ParamUtil.getString(resourceRequest, "indexId"));
        chainCode =  ParamUtil.getString(resourceRequest, "selectedBrand");
        
        if (StandardsUtil.IsNullOrBlank(chainCode))
        {
        	//Add for CR 29-2 s/s/g Change order based on brand/region
	        if (preferences != null)
	        {
	        	chainCode = preferences.getBrand();
	        }
        }
        else
        {
        	resourceRequest.setAttribute("selectedBrand", chainCode);
        }
        try
        {
        	standardsDisplayOrderExts = StandardsDisplayOrderExtLocalServiceUtil.getStandardsByTaxonomyIdChainCodeRegionCode(taxonomyId, chainCode, prefRegionCode);
            if (standardsDisplayOrderExts != null && standardsDisplayOrderExts.size() > 0) 
            {
                for (StandardsDisplayOrderExt standardsDisplayOrderExt : standardsDisplayOrderExts)
                {
                    if (addComma && !standardsOrder.toString().isEmpty())
                    {
                        standardsOrder.append(",");
                    }
                    standardsOrder.append(standardsDisplayOrderExt.getStdId());
                    addComma = true;
                }
            }
            
            resourceRequest.setAttribute("standardsDisplayOrders", standardsDisplayOrderExts);
            resourceRequest.setAttribute("standardsDisplayOrdersCount", standardsDisplayOrderExts.size());
            resourceRequest.setAttribute("originalStandardIdsOrder", standardsOrder.toString());
            resourceRequest.setAttribute("title", "Standards");
            resourceRequest.setAttribute("usrPrefchainCode", preferences.getBrand());
            resourceRequest.setAttribute("chaCdMap", chnCdMap);
           
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/changeorder/viewStandards.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
    }

    public void getUserIndexAdminRoles(PortletRequest portletRequest, ThemeDisplay themeDisplay)
    {
        boolean isIndexGLBLAdmin = false;
        boolean isIndexAmeaAdmin = false;
        boolean isIndexAmerAdmin = false;
        boolean isIndexEuroAdmin = false;
        boolean isIndexGCAdmin = false;
        StringBuffer indexAdminRoles = new StringBuffer();
        try
        {
            isIndexGLBLAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("standard.ordering.global.admin.role"), false);
            isIndexAmeaAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("standard.ordering.amea.admin.role"), false);
            isIndexAmerAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("standard.ordering.amer.admin.role"), false);
            isIndexEuroAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("standard.ordering.euro.admin.role"), false);
            isIndexGCAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("standard.ordering.gc.admin.role"), false);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }

        if (isIndexGLBLAdmin)
        {
            if (Validator.isNotNull(indexAdminRoles.toString()))
            {
                indexAdminRoles.append(StringPool.COMMA);
            }
            indexAdminRoles.append("GLBL");
        }

        if (isIndexAmeaAdmin)
        {
            if (Validator.isNotNull(indexAdminRoles.toString()))
            {
                indexAdminRoles.append(StringPool.COMMA);
            }
            indexAdminRoles.append("AMEA");
        }

        if (isIndexAmerAdmin)
        {
            if (Validator.isNotNull(indexAdminRoles.toString()))
            {
                indexAdminRoles.append(StringPool.COMMA);
            }
            indexAdminRoles.append("AMER");
        }

        if (isIndexEuroAdmin)
        {
            if (Validator.isNotNull(indexAdminRoles.toString()))
            {
                indexAdminRoles.append(StringPool.COMMA);
            }
            indexAdminRoles.append("EURO");
        }

        if (isIndexGCAdmin)
        {
            if (Validator.isNotNull(indexAdminRoles.toString()))
            {
                indexAdminRoles.append(StringPool.COMMA);
            }
            indexAdminRoles.append("GC");
        }
        portletRequest.setAttribute("isIndexGLBLAdmin", isIndexGLBLAdmin);
        portletRequest.setAttribute("indexAdminRoles", indexAdminRoles.toString());
        if (isIndexGLBLAdmin || isIndexAmeaAdmin || isIndexAmerAdmin || isIndexEuroAdmin || isIndexGCAdmin)
        {
            portletRequest.setAttribute("hasChangeOrderAccess", true);
        }
        else
        {
            portletRequest.setAttribute("hasChangeOrderAccess", false);
        }
    }
}