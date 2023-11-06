package com.ihgtss.portal.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;


/**
 * Main Security Servlet for Sales-Source (TSS) project
 * This servlet is used to assign specific role to specific users
 * 
 * @author Jay Patel
 *
 * @prerequisites:
 * "TSS_MEMBER" community role must be created & assigned with specific permissions
 * Sales Source (TSS) site name on Liferay MUST be "Sales Source"
 * 
 */

public class TSSSecurityServlet extends HttpServlet
{
	
	private static final String PARAM_USER_ID 						= "userId";
	private static final String PARAM_COMPANY_ID 					= "companyId";
	private static final String SALES_SOURCE_COMMUNITY_NAME 		= "Sales Source";
	private static final String SALES_SOURCE_MEMBER_ROLE_NAME 		= "TSS_MEMBER";
	private static final String RESPONSE_SUCCESS			 		= "SUCCESS";
	
	/**
	 * @TODO: Change serialVersionUID later on
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Executes GET Call for TSS Servlet 
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		long userId = ParamUtil.getLong(request, PARAM_USER_ID, 0);
		
		long companyId = ParamUtil.getLong(request, PARAM_COMPANY_ID, 0);
		
		if(_log.isDebugEnabled()) {
			_log.debug("Execute TSSSecurityServlet.doGet() with userId:" + userId + " & companyId:" + companyId);	
		}
		
		if(userId > 0 && companyId > 0)
		{
			User user = null;
			
			try{
				user = UserLocalServiceUtil.getUser(userId);
			} catch (Exception e){
				_log.error("Error while getting User with userId:" + userId, e);
			}
			
			
			/**
			 * If user retrieved, update his information
			 */
			if(user != null)
			{
				String salesSourceSiteName = SALES_SOURCE_COMMUNITY_NAME;
				
				Group group = getSalesSourceGroup(companyId, salesSourceSiteName);
				
				if(group != null)
				{
					assignSalesSourceRole(companyId, group.getGroupId(), user);
				}
			}
		}
		
		writeResponse(response, RESPONSE_SUCCESS);
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
	 * Assign "TSS Member" role
	 *
	 * @param companyId
	 * @param groupId
	 * @param user
	 */
	private void assignSalesSourceRole(long companyId, long groupId, User user)
	{
		if(_log.isDebugEnabled()) {
			_log.debug("Start assigning 'TSS_MEMBER' to user:" + user.getScreenName());	
		}
		
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
		
		if(_log.isDebugEnabled()) {
			_log.debug("Done assigning 'TSS_MEMBER' to user:" + user.getScreenName());	
		}
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
	 * Writes given output to the response
	 * 
	 * @param response
	 * @throws IOException 
	 */
	private void writeResponse(HttpServletResponse response, String responseString) throws IOException
	{
		//response.setContentType("application/xml");
		
	    PrintWriter out = response.getWriter();
	    
	    out.println(responseString);
	    
	    out.close();
	}
	
	private static final Log _log = LogFactoryUtil.getLog(TSSSecurityServlet.class);
	 
}
