package com.ihg.brandstandards.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.ihg.brandstandards.db.service.StandardsRegionChainLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ComplianceRuleUtilityFix
 * @author hitesh.methani
 */
public class ComplianceRuleUtilityFix extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(ComplianceRuleUtilityFix.class);
    /**
     * Action for fixing stdRgnChain entries for old standards
     */
    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        LOG.info("Utility for fixing compliance rule data started");
        StandardsRegionChainLocalServiceUtil.cleanUpDataUtility();
        LOG.info("Utility for fixing compliance rule data ends");
    }
 
    
}
