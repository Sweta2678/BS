package com.ihg.mss.events.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihg.me2.mss.builder.model.Sector;
import com.ihg.mss.constants.BunchballConstants;
import com.ihg.mss.util.HookNitroServiceUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.ihg.mss.util.MSSPostLoginActionUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;

/**
 * Post Login event for firing "IHG Meeting Point" specific Actions
 * 
 * @author Jay Patel
 * 
 */

public class MSSPostLoginAction extends Action
{
	public static final String USER_TYPE_CODE_CORPORATE = "C";
	public static final String USER_TYPE_CODE_TEMPORARY_CONTRACTOR = "T";
	public static final String PARAM_PL_ID = "p_l_id";
	public static final String LANGUAGE_ID_ENGLISH = "en";
	public static final String COUNTRY_ID_US = "US";
	public static final String ROLE_DESC = "IHG MEETING POINT ROLE = DO NOT DELETE THIS ROLE";
	
	
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException
	{
		String remoteUser = request.getRemoteUser();

		if(_log.isDebugEnabled()) {
			_log.debug("remote user :: " + remoteUser);	
		}

		User user = null;

		try{
			user = UserLocalServiceUtil.getUser(Long.valueOf(remoteUser));
		}catch(Exception e){
			_log.error("No User found with remoteUser:" + remoteUser, e);
		}

		if(user != null)
		{	
			long companyId = PortalUtil.getCompanyId(request);						

			if(MSSPostLoginActionUtil.isMeetingPointRequest(request, companyId))
			{	
				MSSPostLoginActionUtil.promoteUserToExpert(companyId, user);
				
				String nitroSessionKey = HookNitroServiceUtil.getNitroSessionKey(user.getScreenName());

				/**
				 * Get User's points, lifetime points, sector-level info & store in custom attribute
				 * Also assign Role to user's based on his Profile in Nitro
				 */
				if(Validator.isNotNull(nitroSessionKey))
				{
					
						/* Get All sector Points & Lifetime Points */

					Map<String, String> userAllSectorPointsMap = HookNitroServiceUtil.
					getAllSectorPointBalance(user.getScreenName(), nitroSessionKey);

					if(_log.isDebugEnabled()) {
						_log.info("userAllSectorPoints: " + userAllSectorPointsMap);	
					}

					
						/* Get All sector Preferences */

					Map<String, String> userPreferencesMap = HookNitroServiceUtil.
					getAllPreferences(user.getScreenName(), nitroSessionKey);

					if(_log.isDebugEnabled()) {
						_log.info("userPreferencesMap: " + userPreferencesMap);
					}

					
					
					List<Map<String, String>> listAttributeMap = new ArrayList<Map<String, String>>();
					listAttributeMap.add(userAllSectorPointsMap);
					listAttributeMap.add(userPreferencesMap);


					/* Set Nitro Points & Preferences as Custom Attributes */

					MSSCommonsUtil.saveUserNitroAttributes(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME,
							BunchballConstants.NITRO_USER_CUSTOM_ATTRIBUTE_NAME, user.getUserId(), listAttributeMap, null);

					
					/**
					 * Make user member of the site, site name can be retrieved from "levelType"
					 */
					if(Validator.isNotNull(userPreferencesMap) && userPreferencesMap.size() > 0 ) {

						for (Map.Entry<String, String> userLevel : userPreferencesMap.entrySet())
						{
							String levelType = userLevel.getKey();
							
							Sector sector = null;
							if(Validator.isNotNull(levelType) && levelType.contains(PropsUtil.get("nitro.level.preference.suffix")))
							{
								sector = MSSCommonsUtil.getSectorByLevelPrefName(user.getCompanyId(), levelType);
							}
							
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
											+ e2.getMessage();
									_log.error(errorMessage, e2);						

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
										
										return;
									}
								}
							}						
							
						}
					}
					
					
					/**
					 * Assign Role to the user based on his latest Nitro Preferences
					 */
					if(Validator.isNotNull(userPreferencesMap) && userPreferencesMap.size() > 0 ) {

						for (Map.Entry<String, String> userLevel : userPreferencesMap.entrySet())
						{
							String levelType = userLevel.getKey();
							String levelValue = userLevel.getValue();
							
							if(levelType.contains(PropsUtil.get("nitro.level.preference.suffix"))) 
							{
								String roleName = levelType + StringPool.UNDERLINE + levelValue;
								MSSPostLoginActionUtil.assignUserRoles(roleName, user);
							}
						}
					}
				}
				else
				{
					_log.warn("Nitro Session key is null from MSSPostLoginHook, so " +
					"there may be some problem with Nitro Service call !!!");
				}
			}			
		}
	}	
	
	
	private static final Log _log = LogFactoryUtil.getLog(MSSPostLoginAction.class);

}
