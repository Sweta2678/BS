package com.ihg.mss.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihg.me2.mss.builder.model.Sector;
import com.ihg.mss.servlet.exception.MSSSecurityServiceException;
import com.ihg.mss.servlet.util.MSSSecurityUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * Main Security Servlet of Portal Call-back service for Nitro (Bunchball)
 * 
 * @author Jay Patel
 *
 * @TODO: Remove hard-coded "companyId" or can be passed from Nitro 
 * 
 */

public class MSSSecurityServlet extends HttpServlet 
{

	/**
	 * @TODO: Change serialVersionUID later on
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Executes POST Call-back request from Nitro 
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		_log.info("MeetingPointSecurityServlet.doPost() ... ");


		/**
		 * Authenticate Nitro's request before executing Portal Call-back
		 */
		boolean isSecure = Boolean.TRUE;

		/*Authentication is no longer done in Service & it is done through SiteMinder Header, hence following code commented out*/
		/*try 
		{
			isSecure = MSSSecurityUtil.authenticateNitroRequest(request);
		} 
		catch (MSSSecurityServiceException e) 
		{
			_log.error("Issue while authenticating Nitro's call-back request, error: " + e.getMessage(), e);

			String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(e.getMessage());
			MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
			return;
		}*/

		if(isSecure)
		{
			/**
			 * Get User based on parameters from Nitro Request
			 */

			User user = null;

			try 
			{
				user = MSSSecurityUtil.getUserFromNitroRequest(request);
			} 
			catch (MSSSecurityServiceException e) 
			{
				_log.error("Issue while retrieving User based on Nitro's parameters, error: " + e.getMessage(), e);

				String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(e.getMessage());
				MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
				return;
			}

			/**
			 * If user retrieved, update his information
			 */
			if(user != null)
			{
				
				/**
				 * 1. Update Custom Attribute of User to set latest points & preferences from Nitro.
				 */

				Map<String, String> paramMap = null;

				try 
				{
					paramMap = MSSSecurityUtil.getLevelPointsInfoFromNitroRequest(request);
				}
				catch (MSSSecurityServiceException e) 
				{
					_log.error("Issue while retrieving Level-Points Info from Nitro Request, error: " + e.getMessage(), e);

					String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(e.getMessage());
					MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
					return;
				}

				if(paramMap != null)
				{
					/*String allLevelPoints = paramMap.get(MSSSecurityUtil.PARAM_ALL_LEVEL_POINTS);

					MSSCommonsUtil.saveUserNitroAttributes(user.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, 
							BunchballConstants.NITRO_USER_CUSTOM_ATTRIBUTE_NAME, user.getUserId(), null, allLevelPoints);*/
										
					

					/**
					 * 2. Make user member of the site, site name can be retrieved from "levelType"
					 */
					
					String levelType = paramMap.get(MSSSecurityUtil.PARAM_LEVEL_TYPE).trim();

					String levelValue = paramMap.get(MSSSecurityUtil.PARAM_LEVEL_VALUE).trim();
					
					Sector sector = MSSCommonsUtil.getSectorByLevelPrefName(user.getCompanyId(), levelType);
					
					if(sector != null)
					{
						String siteName = sector.getSectorCommNM();
					
						Group site = null;
						
						try 
						{
							site = GroupLocalServiceUtil.getGroup(user.getCompanyId(), siteName);
						} 
						catch (Exception e2)
						{
							String errorMessage = "Error while getting site with name: " + siteName 
									+ " , This MUST be created in order to execute call-back successfully ! "
									+ e2.getMessage();
							_log.error(errorMessage, e2);
							
							String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(errorMessage);
							MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
							return;
						}
						
						if(site != null)
						{
							try 
							{
								GroupLocalServiceUtil.addUserGroups(user.getUserId(), new long[]{site.getGroupId()});
							} 
							catch (Exception e3) 
							{
								String errorMessage = "Error while making user:" + user.getFullName() + " member of site:" 
										+ siteName + " , error: " + e3.getMessage();
								_log.error(errorMessage);
								
								String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(errorMessage);
								MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
								return;
							}
						}						
						

						
						/**
						 * 3. Update roles based on latest User preferences from Nitro. 
						 */
						
						String roleName = levelType + StringPool.UNDERLINE + levelValue;

						_log.info("Role name to be created/assigned: " + roleName);

						Role role = null;

						try 
						{
							role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
						} 
						catch(Exception e) 
						{
							if(e instanceof NoSuchRoleException)
							{
								/* Add Role if it does NOT exist */

								Map<Locale, String> titleMap = new HashMap<Locale, String>();
								titleMap.put(new Locale("en", "US"), roleName);
								
								Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
								descriptionMap.put(new Locale("en", "US"), "DO NOT REMOVE THIS ROLE");

								try 
								{
									role = RoleLocalServiceUtil.addRole(user.getUserId(), user.getCompanyId(), roleName,
											titleMap, descriptionMap, RoleConstants.TYPE_REGULAR);
								} 
								catch (Exception e1) 
								{
									String errorMessage = "Error while creating role:" + roleName + " by user:" + user.getFullName() 
											+ " , error:" + e1.getMessage(); 
									_log.error(errorMessage);

									String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(errorMessage);
									MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
									return;
								}
							}
							else
							{
								String errorMessage = "Error while retriving OR creating Role with name:" + roleName + " ,error:" + e.getMessage(); 
								_log.error(errorMessage);

								String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(errorMessage);
								MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
								return;	
							}
						}

						if(role != null)
						{
							try 
							{
								// This will remove all previous roles & sets new RoleIds passed for given user
								/*RoleLocalServiceUtil.setUserRoles(user.getUserId(), new long[]{role.getRoleId()});*//*10138L*/
								
								UserLocalServiceUtil.addRoleUsers(role.getRoleId(), new long[]{user.getUserId()});
							} 
							catch (Exception e) 
							{
								String errorMessage = "Error while assigning role:" + roleName + " to user:" + user.getFullName() 
										+ " ,error:" + e.getMessage(); 
								_log.error(errorMessage);

								String errorXMLResponse = MSSSecurityUtil.buildPortalCallbackErrorResponse(errorMessage);
								MSSSecurityUtil.writePortalCallbackResponse(response, errorXMLResponse);
								return;
							}
						}						
					}
				}
			}

			/**
			 * Finally send success message to Nitro to mark successful Portal Call-back service execution
			 */
			String xmlResponse = MSSSecurityUtil.buildPortalCallbackResponse(MSSSecurityUtil.DEFAULT_CALLBACK_MESSAGE);
			MSSSecurityUtil.writePortalCallbackResponse(response, xmlResponse);
		}
	}


	/**
	 * Executes GET Call-back request from Nitro 
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		_log.info("MeetingPointSecurityServlet.doGet() ... ");

		doPost(request, response);
	}	
	
	
	private static final Log _log = LogFactoryUtil.getLog(MSSSecurityServlet.class);

}
