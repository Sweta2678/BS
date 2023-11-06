package com.ihg.mss.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihg.me2.mss.builder.model.Sector;
import com.ihg.me2.mss.builder.service.SectorLocalServiceUtil;
import com.ihg.mss.bunchball.parameter.Parameters;
import com.ihg.mss.constants.BunchballConstants;
import com.ihg.mss.events.login.MSSPostLoginAction;
import com.ihg.mss.portal.util.CommonUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * Utility class for "MSSPostLoginAction" class
 * 
 * @author Jay Patel
 *
 */

public class MSSPostLoginActionUtil 
{
	
	/**
	 * Promotes "Corporate" users (C) & "Temporary" Contractors (T) to "Expert" level in Meeting Point
	 * 
	 * @param companyId
	 * @param user
	 */
	public static void promoteUserToExpert(long companyId, User user)
	{
		String adId = StringPool.BLANK;
		String userType = StringPool.BLANK;
		String roleName = StringPool.BLANK;
		
		adId = user.getScreenName();
		userType = CommonUtil.getMerlinSessionAttributeValue(adId, Parameters.MERLIN_USER_TYPE);
		
		try
		{
			if(userType.equalsIgnoreCase(MSSPostLoginAction.USER_TYPE_CODE_CORPORATE)
					|| userType.equalsIgnoreCase(MSSPostLoginAction.USER_TYPE_CODE_TEMPORARY_CONTRACTOR)/*true*/)
			{
				_log.info("Promote User:" + user.getFullName() + " to Expert level as his userType is:" + userType);
				
				
				/**
				 * Step-1: Check if user is already member Gamified Sector Sites or not
				 */
				
				Group group = null;
				
				/*List<Sector> listSectors = SectorLocalServiceUtil.getAllSectors();*/
				List<Sector> listSectors = CommonUtil.getUserSectors(user);
				
				if(Validator.isNotNull(listSectors) && !listSectors.isEmpty())
				{
					for(Sector sector : listSectors)
					{
						group = GroupLocalServiceUtil.getGroup(companyId, sector.getSectorCommNM());
						
						if(!GroupLocalServiceUtil.hasUserGroup(user.getUserId(), group.getGroupId()))
						{
							_log.info("User " + user.getFullName() + " does not have Group " + sector.getSectorCommNM());
							
							GroupLocalServiceUtil.addUserGroups(user.getUserId(), new long[] {group.getGroupId()});
						}
					}
				}
				
				
				/**
				 * Step-2: Check if user is already member MP Home site or not
				 */
				
				String homeSiteName = PropsUtil.get("meetingpoint.home.site.name");			
				
				Group homeSite = GroupLocalServiceUtil.getGroup(companyId, homeSiteName);
				
				if(!GroupLocalServiceUtil.hasUserGroup(user.getUserId(), homeSite.getGroupId()))
				{
					_log.info("User " + user.getFullName() + " does not have Group " + homeSite.getName());
					
					GroupLocalServiceUtil.addUserGroups(user.getUserId(), new long[] {homeSite.getGroupId()});
				}
				
				
				/**
				 * Step-3: Assign "Expert" level in Nitro & assign "Expert" roles in Nitro
				 */
				
				Role role = null;
				
				if(Validator.isNotNull(listSectors) && !listSectors.isEmpty())
				{
					for(Sector sector : listSectors)
					{
						
						roleName = (new StringBuilder(sector.getSectorName()).append(PropsUtil.get("nitro.level.preference.suffix"))
						.append(StringPool.UNDERLINE).append(PropsUtil.get("level.value.expert"))).toString();
						
						_log.info("Role name to be assigned: " + roleName);
						
						assignUserRoles(roleName, user);
						
						String preferenceName = StringPool.BLANK;
						String preferenceValue = StringPool.BLANK;
						
						preferenceName = sector.getSctrLvlPrefNm();
						preferenceValue = PropsUtil.get("level.value.expert");
						
						HookNitroServiceUtil.setPreference(user.getScreenName(), preferenceName, preferenceValue);
					}
				}
			}	
		}
		catch (PortalException e) 
		{
			_log.error("Issue while making corporate user member of Meeting Point Sites in promoteCorporateUser():" + e.getMessage(), e);
		}
		catch (SystemException e) 
		{
			_log.error("Issue while making corporate user member of Meeting Point Sites in promoteCorporateUser():" + e.getMessage(), e);
		}
	}
	
	
	
	/**
	 * Checks whether it is "Meeting Point" request or not by checking layout id 
	 * 
	 * @param request
	 * @param companyId
	 * @return boolean
	 */
	public static boolean isMeetingPointRequest(HttpServletRequest request, long companyId)
	{
		boolean isMeetingPointRequest = Boolean.FALSE;
		
		/**
		 * Alternatively, request can be checked for "FRIENDLY_URL" & "CURRENT_URL" attribute for value like "/web/mss/home"
		 */
		long plId = ParamUtil.getLong(request, MSSPostLoginAction.PARAM_PL_ID);
		
		if(plId > 0)
		{
			Group group = null;
			Layout layout = null;
			
			String meetingPointHomeSiteName = BunchballConstants.COMMUNITY_NAME_MSS_DEFAULT;
			
			try {
				group = GroupLocalServiceUtil.getGroup(companyId, meetingPointHomeSiteName);
			} catch (PortalException e) {
				_log.error("Error while finding MP Home Site in isMeetingPointRequest()" + e.getMessage(), e);
			} catch (SystemException e) {
				_log.error("Error while finding MP Home Site in isMeetingPointRequest()" + e.getMessage(), e);
			}
			
			if(group != null)
			{
				try {
					layout = LayoutLocalServiceUtil.getLayout(plId);
				} catch (PortalException e) {
					_log.error("Error while finding MP Home Site Layout in isMeetingPointRequest()" + e.getMessage(), e);
				} catch (SystemException e) {
					_log.error("Error while finding MP Home Site Layout in isMeetingPointRequest()" + e.getMessage(), e);
				}
				
				if(layout != null)
				{
					if(layout.getGroupId() == group.getGroupId() 
							&& (PropsUtil.get("meetinpoint.homesite.landingpage.friendlyurl")).equalsIgnoreCase(layout.getFriendlyURL()))
					{
						isMeetingPointRequest = Boolean.TRUE;
					}
				}
			}
		}
		
		_log.info("isMeetingPointRequest :: " + isMeetingPointRequest);
		
		return isMeetingPointRequest;
	}
	
	
	/**
	 * This method is used to promote Corporate user to "Basic" level privileges without having him take "Qualification"   
	 * 
	 * @deprecated : Deprecated as now because "T" & "C" users are now promoted to "Expert" using method "promoteUserToExpert()" 
	 * @param themeDisplay
	 * @param user
	 */
	public static void promoteCorporateUser(long companyId, User user)
	{	
		String adId = StringPool.BLANK;
		String userType = StringPool.BLANK;
		String roleName = StringPool.BLANK;
		
		adId = user.getScreenName();
		userType = CommonUtil.getMerlinSessionAttributeValue(adId, Parameters.MERLIN_USER_TYPE);
		
		_log.info("Called promoteCorporateUser() for UserType: " + userType);
		
		
		/**
		 * If user is "Corporate" user then grant him "Basic" user access on Merlin + Nitro
		 */
		
		if(userType.equalsIgnoreCase(MSSPostLoginAction.USER_TYPE_CODE_CORPORATE)
				|| userType.equalsIgnoreCase(MSSPostLoginAction.USER_TYPE_CODE_TEMPORARY_CONTRACTOR)/*true*/)
		{
			try 
			{
				/**
				 * Step-1: Check if user is already member of MP-home site & Gamified Sector Sites
				 */
				
				Role role = null;
				Group group = null;
				
				boolean isBasicUser = Boolean.TRUE;
				boolean isSiteMember = Boolean.TRUE;
				
				List<Sector> listSectors = SectorLocalServiceUtil.getAllSectors();
				
				if(Validator.isNotNull(listSectors) && !listSectors.isEmpty())
				{
					for(Sector sector : listSectors)
					{
						roleName = sector.getSectorName() + PropsUtil.get("nitro.level.preference.suffix")
								+ StringPool.UNDERLINE + PropsUtil.get("level.value.basic");
						
						isBasicUser = UserLocalServiceUtil.hasRoleUser(companyId, roleName, user.getUserId(), Boolean.FALSE);
						
						if(!isBasicUser)
						{
							_log.info("Corporate User " + user.getFullName() + " does not have role " + roleName);
							break;
						}
						
						group = GroupLocalServiceUtil.getGroup(companyId, sector.getSectorCommNM());
						
						isSiteMember = GroupLocalServiceUtil.hasUserGroup(user.getUserId(), group.getGroupId());
						
						if(!isSiteMember)
						{
							_log.info("Corporate User " + user.getFullName() + " does not have Group " + sector.getSectorCommNM());
							break;
						}
					}
				}
				
				_log.info("Corporate User " + user.getFullName() + " isBasicUser:" + isBasicUser + " isSiteMember:" + isSiteMember);
				
				
				/**
				 * Step-2: Make member of MP-home site & Gamified Sector Sites
				 */
				
				if(!isBasicUser || !isSiteMember)
				{
					_log.info("Corporate User " + user.getFullName() + " is going to be made 'Basic' user now.....");
					
					String homeSiteName = PropsUtil.get("meetingpoint.home.site.name");			
					
					Group homeSite = GroupLocalServiceUtil.getGroup(companyId, homeSiteName);
					
					List<Long> listGroupIds = new ArrayList<Long>();
					listGroupIds.add(homeSite.getGroupId());
					
					
					
					if(Validator.isNotNull(listSectors) && !listSectors.isEmpty())
					{
						for(Sector sector : listSectors)
						{
							group = GroupLocalServiceUtil.getGroup(companyId, sector.getSectorCommNM());
							
							if(group != null)
							{
								listGroupIds.add(group.getGroupId());
							}
						}
					}
					
					long[] arrayGroupIds = new long[listGroupIds.size()];
					
					for(int i=0; i<listGroupIds.size(); i++)
					{
						arrayGroupIds[i] = listGroupIds.get(i);
					}
					
					GroupLocalServiceUtil.addUserGroups(user.getUserId(), arrayGroupIds);
					
					
					/**
					 * Step-3: Assign "Basic" role to User in every sector   
					 */
					
					String preferenceName = StringPool.BLANK;
					String preferenceValue = StringPool.BLANK;
					
					
					if(Validator.isNotNull(listSectors) && !listSectors.isEmpty())
					{
						for(Sector sector : listSectors)
						{
							roleName = sector.getSectorName() + PropsUtil.get("nitro.level.preference.suffix")
									+ StringPool.UNDERLINE + PropsUtil.get("level.value.basic");
							
							_log.info("Role name to be assigned: " + roleName);
							
							try
							{
								role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
								
								if(role != null)
								{
									UserLocalServiceUtil.addRoleUsers(role.getRoleId(), new long[]{user.getUserId()});
								}
							}
							catch(Exception e)
							{
								_log.error("Error while assigning Basic roles to Corporate User:" + e.getMessage(), e);
							}
							
							
							/**
							 * Step-3: Set Prefernces on Nitro like "Auto_Level=Basic" & "Pharma_Level=Basic"
							 */ 
							
							preferenceName = sector.getSctrLvlPrefNm();
							preferenceValue = PropsUtil.get("level.value.basic");
							
							HookNitroServiceUtil.setPreference(user.getScreenName(), preferenceName, preferenceValue);
						}
					}
				}
			} 
			catch (PortalException e) 
			{
				_log.error("Issue while making corporate user member of Meeting Point Sites in promoteCorporateUser():" + e.getMessage(), e);
			}
			catch (SystemException e) 
			{
				_log.error("Issue while making corporate user member of Meeting Point Sites in promoteCorporateUser():" + e.getMessage(), e);
			}
		}
	}

	
	/**
	 * Find out if Logged-in user is "IHG Meeting Point" (MSS) member or not?
	 * 
	 * @param companyId
	 * @param user
	 * @return boolean
	 */
	public static boolean isMeetingPointUser(long companyId, User user)
	{
		String meetingPointHomeName = BunchballConstants.COMMUNITY_NAME_MSS_DEFAULT;

		return MSSCommonsUtil.isUserSiteMember(companyId, user, meetingPointHomeName);	
	}	
	

	/**
	 * Assigns Role to the given User
	 * 
	 * @param roleName
	 * @param user
	 */
	public static void assignUserRoles(String roleName, User user)
	{
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
				titleMap.put(new Locale(MSSPostLoginAction.LANGUAGE_ID_ENGLISH, MSSPostLoginAction.COUNTRY_ID_US), roleName);
				
				Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
				descriptionMap.put(new Locale(MSSPostLoginAction.LANGUAGE_ID_ENGLISH, MSSPostLoginAction.COUNTRY_ID_US), MSSPostLoginAction.ROLE_DESC);

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
					return;
				}
			}
			else
			{
				String errorMessage = "Error while retriving OR creating Role with name:" + roleName + " ,error:" + e.getMessage(); 
				_log.error(errorMessage);
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
				return;
			}
		}
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(MSSPostLoginActionUtil.class);
}
