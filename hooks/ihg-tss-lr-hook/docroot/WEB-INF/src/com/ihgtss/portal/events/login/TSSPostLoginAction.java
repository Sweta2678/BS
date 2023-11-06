package com.ihgtss.portal.events.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is the Custom Login Event Handler for "IHG Sales-Source (TSS)" application
 * This class is responsible to set certain role-permission on any user who accesses "Sales-Source" on login
 * 
 * @prerequisites:
 * "TSS_MEMBER" community role must be created & assigned with specific permissions
 * 
 * @author Jay Patel
 * 
 */

public class TSSPostLoginAction extends Action 
{
	private static final String SALES_SOURCE_COMMUNITY_NAME = "Sales Source";
	private static final String SALES_SOURCE_HOME_PAGE_FRIENDLY_URL = "/home";
	private static final String SALES_SOURCE_MEMBER_ROLE_NAME = "TSS_MEMBER";
	private static final String PARAM_PL_ID = "p_l_id";
	
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException
	{
		String remoteUser = request.getRemoteUser();
		
		User user = null;

		try{
			user = UserLocalServiceUtil.getUser(Long.valueOf(remoteUser));
		}catch(Exception e){
			_log.error("No User found with remoteUser:" + remoteUser, e);
		}
		
		if(user != null)
		{	
			long companyId = PortalUtil.getCompanyId(request);
			
			String salesSourceSiteName = SALES_SOURCE_COMMUNITY_NAME;
			
			Group group = getSalesSourceGroup(companyId, salesSourceSiteName);
			
			if(Validator.isNotNull(group) && isSalesSourceRequest(request, companyId, group))
			{
				assignSalesSourceRole(request, companyId, group.getGroupId(), user);
			}
		}
	}
	
	
	/**
	 * Gets Sales-Source Group
	 * 
	 * @param companyId
	 * @param salesSourceSiteName
	 * @return Group
	 */
	private Group getSalesSourceGroup(long companyId, String salesSourceSiteName)
	{
		Group group = null;
		
		try {
			group = GroupLocalServiceUtil.getGroup(companyId, salesSourceSiteName);
		} catch (PortalException e) {
			_log.error("Error while finding Sales-Source Site in getSalesSourceGroup()" + e.getMessage(), e);
		} catch (SystemException e) {
			_log.error("Error while finding Sales-Source Site in getSalesSourceGroup()" + e.getMessage(), e);
		}
		
		return group;
	}
	
	
	
	/**
	 * Checks whether it is "Meeting Point" request or not by checking layout id 
	 * 
	 * @param request
	 * @param companyId
	 * @return boolean
	 */
	private boolean isSalesSourceRequest(HttpServletRequest request, long companyId, Group group)
	{
		boolean isSalesSourceRequest = Boolean.FALSE;
		
		long plId = ParamUtil.getLong(request, PARAM_PL_ID);
		
		if(plId > 0)
		{
			Layout layout = null;
			
			try {
				layout = LayoutLocalServiceUtil.getLayout(plId);
			} catch (PortalException e) {
				_log.error("Error while finding TSS Site Layout in isSalesSourceRequest()" + e.getMessage(), e);
			} catch (SystemException e) {
				_log.error("Error while finding TSS Site Layout in isSalesSourceRequest()" + e.getMessage(), e);
			}
			
			if(layout != null)
			{
				if(layout.getGroupId() == group.getGroupId() 
						&& (SALES_SOURCE_HOME_PAGE_FRIENDLY_URL).equalsIgnoreCase(layout.getFriendlyURL()))
				{
					isSalesSourceRequest = Boolean.TRUE;
				}
			}
		}
		
		_log.info("isSalesSourceRequest :: " + isSalesSourceRequest);
		
		return isSalesSourceRequest;
	}
	
	
	/**
	 * Based on passed Community roleId, userId, groupId, checks whether user has that role or not
	 * 
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws SystemException            
	 */
	private boolean hasGroupRole(long groupId, long userId, long roleId) {
		boolean hasRole = Boolean.FALSE;

		try {
			hasRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId,
					groupId, roleId);
		} catch (SystemException e) {
			_log.error("UserId:" + userId + " does not have roleId:" + roleId
					+ " in group:" + groupId);
		}

		return hasRole;
	}
	
	
	
	/**
	 * Returns Role based on companyId & roleName
	 * 
	 * @param companyId
	 * @param roleName
	 * @return Role
	 * @throws PortalException
	 * @throws SystemException            
	 */
	private Role getRole(long companyId, String roleName) {
		Role role = null;

		try {
			role = RoleLocalServiceUtil.getRole(companyId, roleName);
		} catch (PortalException e) {
			_log.error("No such role with companyId:" + companyId
					+ " & roleName:" + roleName);
		} catch (SystemException e) {
			_log.error("No such role with companyId:" + companyId
					+ " & roleName:" + roleName);
		}

		return role;
	}
				
	
	/**
	 * Assign "TSS Member" role
	 * 
	 * @param request
	 * @param companyId
	 * @param groupId
	 * @param user
	 */
	private void assignSalesSourceRole(HttpServletRequest request, long companyId, long groupId, User user)
	{
		Role role = getRole(companyId, SALES_SOURCE_MEMBER_ROLE_NAME);
		
		if(Validator.isNotNull(role))
		{
			if(!hasGroupRole(groupId, user.getUserId(), role.getRoleId()))
			{
				long[] roleIds = {role.getRoleId()};
				
				try 
				{
					UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), groupId, roleIds);
				} 
				catch (Exception e) 
				{
					_log.error("Error while assiging user:" + user.getFullName() + " to role:" + role.getName(), e);
				}
			}
		}
	}
	
	
	
	private static final Log _log = LogFactoryUtil.getLog(TSSPostLoginAction.class);
}
