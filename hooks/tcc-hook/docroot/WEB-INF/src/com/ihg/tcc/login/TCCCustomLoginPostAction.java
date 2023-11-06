package com.ihg.tcc.login;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TCCCustomLoginPostAction extends Action
{
	private static final Log LOGGER = LogFactoryUtil.getLog(TCCCustomLoginPostAction.class);
	private static final String ROLE_SIGNATURE = "TCC_SIGNATURE";
	private static final String ROLE_VIRTUOSO = "TCC_VIRTUOSO";
	private static final String ADMIN_CONFIGURATION_FRIENDLY_URL = "/admin-configuration";
	private static final String TCC_COMMUNITY_NAME = "TCC";
	private static final String TCC_ADMIN_CONGIGURATION_PORTLET_ID = "tccadmin_WAR_tccportlet";
	private static final String IATA_NUMBER = "IATA Number";
	
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)throws ActionException 
	{
	    if (LOGGER.isDebugEnabled())
	    {
	        LOGGER.debug("==========TCCCustomLoginPostAction called for server : " + request.getServerName());
	    }
		
		setLuxuryHotelPagesBasedonAdminPreference(request);
		
		if(request.getServerName().contains("ihgagent.com"))
		{
			try
			{
				String redirectURL = STR_HTTPS + request.getServerName() + STR_TCC_HOME_PATH;
		        if (LOGGER.isDebugEnabled())
		        {
		            LOGGER.debug("Since this is a post-login event for TCC, redirecting to..." + redirectURL);
		        }
				response.sendRedirect(redirectURL);
			}
			catch (IOException e)
			{
				LOGGER.error("Error while redirecting to TCC site...");
			}
		}
	}
	
	public void setLuxuryHotelPagesBasedonAdminPreference(HttpServletRequest request)
	{
		try 
		{
			User user = PortalUtil.getUser(request);
			Company company = PortalUtil.getCompany(request);
			Group tccGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), TCC_COMMUNITY_NAME);
			String iataNo = getUserIATACode(user);
			request.getSession().setAttribute(IATA_NUMBER, iataNo);
			AdminConfiguration adminConfiguration = getAdminConfiguration(request,tccGroup);
			adminConfiguration.setIataNo(iataNo);
			if(isUserHasDefaultRoleToAccessMenu(user, adminConfiguration))
			{
				return;
			}
			Role signatureRole = null;
			Role virtuosoeRole = null;
			try {
				signatureRole = RoleLocalServiceUtil.getRole(company.getCompanyId(), ROLE_SIGNATURE);
				virtuosoeRole = RoleLocalServiceUtil.getRole(company.getCompanyId(), ROLE_VIRTUOSO);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				return;
			}
			long[] signatureRolesId = {signatureRole.getRoleId()};
			long[] virtuosoeRoleId = {virtuosoeRole.getRoleId()};
			if(isSignatureOrVirtuosoNumber(request, adminConfiguration, true))
			{
				if(signatureRole!=null && !UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), tccGroup.getGroupId(), signatureRole.getRoleId()))
				{
					UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), tccGroup.getGroupId(), signatureRolesId);
				}
			}
			else
			{
				if(signatureRole!=null)
				{
					UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user.getUserId(), tccGroup.getGroupId(), signatureRolesId);
				}
			}
			if(isSignatureOrVirtuosoNumber(request, adminConfiguration, false))
			{
				if(virtuosoeRole!=null && !UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), tccGroup.getGroupId(), virtuosoeRole.getRoleId()))
				{
					UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), tccGroup.getGroupId(), virtuosoeRoleId);
				}
			}
			else
			{
				if(virtuosoeRole!=null)
				{
					UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user.getUserId(), tccGroup.getGroupId(), virtuosoeRoleId);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} 
	}
	
	public boolean isSignatureOrVirtuosoNumber(HttpServletRequest request,AdminConfiguration adminConfiguration,boolean isSignatureCheck)
	{
        if (LOGGER.isDebugEnabled())
        {
            LOGGER.debug("==========iataCode is :- "+adminConfiguration.getIataNo());
        }
		if(Validator.isNull(adminConfiguration.getIataNo()))
		{
			return false;
		}
		String number = isSignatureCheck ? adminConfiguration.getSignatureNumber() : adminConfiguration.getVirtuosoNumber();
		String numberData[] = number.split(StringPool.COMMA);
		List<String> numberList = Arrays.asList(numberData);
		return numberList.contains(adminConfiguration.getIataNo());
		
	}
	
	public String getUserIATACode(User user)
	{
		String iataNo = null;
		try 
		{
			ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(user.getCompanyId(), User.class.getName());
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), IATA_NUMBER);
			if(Validator.isNotNull(column))
			{
				ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), column.getColumnId(), user.getUserId());
				if(Validator.isNotNull(expandoValue))
				{
					iataNo = expandoValue.getString();
				}
			}
			
		} catch (PortalException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}
		//LOGGER.info("========== iataNo Value is :- "+iataNo);
		return iataNo;
	}
	
	public boolean isUserHasDefaultRoleToAccessMenu(User user,AdminConfiguration adminConfiguration)
	{
		if(user==null)
		{
			return false;
		}
		List<String> defaultAceessRole = adminConfiguration.getDefaultRoleToAccessMenu();
		try {
			List<Role> roleList = RoleLocalServiceUtil.getUserRoles(user.getUserId());
			for(Role role : roleList)
			{
				if(defaultAceessRole.contains(role.getName()))
				{
					return true;
				}
			}
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return false;
	}
	
	public AdminConfiguration getAdminConfiguration(HttpServletRequest request,Group tccGroup)
	{
		AdminConfiguration adminConfiguration = new AdminConfiguration();
		try {
			Layout adminConfigLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(tccGroup.getGroupId(), false, ADMIN_CONFIGURATION_FRIENDLY_URL);
			javax.portlet.PortletPreferences prefs = PortletPreferencesFactoryUtil.getLayoutPortletSetup(adminConfigLayout, TCC_ADMIN_CONGIGURATION_PORTLET_ID);
			if(prefs!=null)
			{
				adminConfiguration.setSignatureNumber(prefs.getValue("adminConfiguration1", StringPool.BLANK));
				//LOGGER.info("========== adminConfiguration1 Value is :- "+prefs.getValue("adminConfiguration1", StringPool.BLANK));
				//LOGGER.info("========== adminConfiguration2 Value is :- "+prefs.getValue("adminConfiguration2", StringPool.BLANK));
				adminConfiguration.setVirtuosoNumber(prefs.getValue("adminConfiguration2", StringPool.BLANK));
				String configuration1 = prefs.getValue("adminConfiguration3", StringPool.BLANK);
				//configuration1 = "Administrator,Community Administrator,Community Owner";
				adminConfiguration.setConfiguration1(configuration1);
				adminConfiguration.setConfiguration2(prefs.getValue("adminConfiguration4", StringPool.BLANK));
				if(configuration1!=null)
				{
					String roleData[] = configuration1.split(StringPool.COMMA);
					if(roleData!=null)
					{
						adminConfiguration.setDefaultRoleToAccessMenu(Arrays.asList(roleData));
					}
				}
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return adminConfiguration;
	}
	
	
	private static final String STR_HTTPS = "https://";
	
	private static final String STR_TCC_HOME_PATH = "/web/tcc/home";
}
