package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class UnlockPortlet extends  BrandStandardsBridgePortlet {
	private static final Log LOG = LogFactoryUtil.getLog(UnlockPortlet.class);
    private static final String DELIMS = " ,;\n+";
	
	public void doView(RenderRequest renderRequest,	RenderResponse renderResponse) throws IOException, PortletException 
	{
        String brandCode = "";
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        if (preferences != null) {
            brandCode = preferences.getBrand();
        }
        
        long lockedCount = StandardsLocalServiceUtil.getLockedStandardsCount(brandCode);
        renderRequest.setAttribute("lockedCount", lockedCount);
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/unlock/view.jsp");
        dispatcher.include(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "releaseLockedRecords")
    public void releaseLockedRecords(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,PortletException
	{
        String brandCode = "";
        Preferences preferences = getBridgeUserPreferences(actionRequest);
        if (preferences != null) {
            brandCode = preferences.getBrand();
        }

        if(Validator.isNotNull(brandCode)){
			try {
				StandardsLocalServiceUtil.setStandardsStatusUnlock(brandCode);
			} catch (SystemException e) {
			    LOG.error("Failed to release Locked Records", e);
			}
		}
	}

	@ProcessAction(name = "unLockedRecords")
    public void unLockedRecords(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
		String brandCode = "";
		StringBuffer unlockStdIds = new StringBuffer();
		Preferences preferences = getBridgeUserPreferences(actionRequest);
        if (preferences != null) {
            brandCode = preferences.getBrand();
        }
        String lockOrUnlockStdIds = ParamUtil.getString(actionRequest, "lockOrUnlockStdIds");
        StringTokenizer strTok = new StringTokenizer(lockOrUnlockStdIds, DELIMS);
        while (strTok.hasMoreTokens()) {
        	if(Validator.isNotNull(unlockStdIds.toString())){
        		unlockStdIds.append(StringPool.COMMA);
        		unlockStdIds.append(StringPool.SPACE);
        		unlockStdIds.append(strTok.nextToken());
        	} else {
        		unlockStdIds.append(strTok.nextToken());
        	}
        }
        if(Validator.isNotNull(unlockStdIds.toString()) && Validator.isNotNull(brandCode)){
			try {
				StandardsLocalServiceUtil.unLockRecords(unlockStdIds.toString(), brandCode);
			} catch (SystemException e) {
				LOG.error("Failed to Unlock Records:"+unlockStdIds, e);
			}
        }
    }
	
	@ProcessAction(name = "lockedRecords")
    public void lockedRecords(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
		String brandCode = "";
		StringBuffer lockStdIds = new StringBuffer();
		Preferences preferences = getBridgeUserPreferences(actionRequest);
        if (preferences != null) {
            brandCode = preferences.getBrand();
        }
		String lockOrUnlockStdIds = ParamUtil.getString(actionRequest, "lockOrUnlockStdIds");
        StringTokenizer strTok = new StringTokenizer(lockOrUnlockStdIds, DELIMS);
        while (strTok.hasMoreTokens()) {
        	if(Validator.isNotNull(lockStdIds.toString())){
        		lockStdIds.append(StringPool.COMMA);
        		lockStdIds.append(StringPool.SPACE);
        		lockStdIds.append(strTok.nextToken());
        	} else {
        		lockStdIds.append(strTok.nextToken());
        	}
        }
        if(Validator.isNotNull(lockStdIds.toString()) && Validator.isNotNull(brandCode)){
        	try {
            	StandardsLocalServiceUtil.lockRecords(lockStdIds.toString(), brandCode);
        	} catch (SystemException e) {
    			LOG.error("Failed toLock Records:"+lockStdIds, e);
    		}
        }
    }

}
