package com.ihgtss.portal.events.pre;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * This is the Custom Service-Pre Action Event Handler for "IHG Sales-Source (TSS)" application
 * This class is responsible to set certain role-permission on any user who accesses "Sales-Source" on login
 * 
 * @prerequisites:
 * "TSS_MEMBER" community role must be created & assigned with specific permissions
 * 
 * @deprecated
 * Now deprecated as assigning roles-permissions is taken care through "Home" page service
 * 
 * @author Jay Patel
 * 
 */


public class TSSServicePreAction extends Action 
{
	
	private static final String SALES_SOURCE_COMMUNITY_NAME = "Sales Source";
	private static final String SALES_SOURCE_HOME_PAGE_FRIENDLY_URL = "/home";
	private static final String SALES_SOURCE_MEMBER_ROLE_NAME = "TSS_MEMBER";
	
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException
	{
		
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(TSSServicePreAction.class);
}
