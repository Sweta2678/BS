package com.ihg.mss.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihg.me2.utils.session.MerlinSession;
import com.ihg.mss.bunchball.method.Methods;
import com.ihg.mss.bunchball.model.ErrorType;
import com.ihg.mss.bunchball.model.LoginType;
import com.ihg.mss.bunchball.model.NitroType;
import com.ihg.mss.bunchball.parameter.Parameters;
import com.ihg.mss.exceptions.BunchballServiceException;
import com.ihg.mss.utils.BunchballUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * 
 * Util class which deals with Bunchball for the login Session key, which is required to call any Nitro Bunchball Service.
 * 
 * @author Jay Patel
 * 
 * @deprecated
 * 
 */

public class MSSLoginUtil 
{
	/**
	 * Main method which does Post login SessionKey processing
	 * 
	 * @param request
	 * @param remoteUser
	 * 
	 */
	public static void doPostLoginBunchballActions(HttpServletRequest request, String remoteUser)
	{
		try 
		{
			User user = UserLocalServiceUtil.getUser(Long.valueOf(remoteUser));
			
			if(user != null)
			{
				long companyId = PortalUtil.getCompanyId(request);
				
				if(companyId > 0)
				{
						/*Get 'MSS' Group*/
					
					Group mssSite = getDefaultMSSSite(companyId, DEFAULT_MSS_SITE_NAME);
					
					if(mssSite != null)
					{
							/*Is user 'MSS' member?*/
						
						boolean isMSSMember = isUserMSSMember(user, mssSite);
						
						if(isMSSMember)
						{
							boolean callBBLoginService = Boolean.TRUE;
							
								/*If 'MSS' member then check the sessionKey from MerlinSession*/
							
							Map<String, String> bunchballKeyMap = MerlinSession.get(MSS_BUNCHBALL_KEYS);
							
							if(bunchballKeyMap != null)
							{
								String sessionKey = bunchballKeyMap.get(BB_LOGIN_SESSION_KEY);
								
								if(Validator.isNotNull(sessionKey))
								{
									String keyCreationTime = bunchballKeyMap.get(BB_KEY_CREATION_TIME);
									
									if(Validator.isNotNull(keyCreationTime))
									{
										try
										{
											long creationTime = Long.parseLong(keyCreationTime);
											
											if(getTimeInDays(creationTime) < TIME_BEFORE_EXPIRATION_DAYS)
											{
												/*If 'creationTime' is less than 'TIME_BEFORE_EXPIRATION_DAYS',
												then no need to call BB Login service again, as old sessionKey
												from MerlinSession is still VALID & can be used to call any BB Service.*/
												
												callBBLoginService = Boolean.FALSE;
											}
										}
										catch(Exception e)
										{
											_log.error("Error while parsing 'keyCreationTime'", e);
										}
									}
								}
							}
							
								/*If 'callBBLoginService' is still TRUE, then call BB Login Service to get new SessionKey
								& store it in MerlinSession along with key creationTime.*/
							if(callBBLoginService)
							{
								callBunchballLoginService(user);
							}
						}
						else
						{
							_log.info("Logged-in User is not a member of 'IHG Meeting Point (MSS)' community, " +
									"hence no need to interact with Bunchball !!!");	
						}
					}
				}
			}
			
		} 
		catch (NumberFormatException e) 
		{
			_log.error("NumberFormatException, error is: " + e.getMessage(), e);
		} 
		catch (PortalException e) 
		{
			_log.error("PortalException, error: " + e.getMessage(), e);
		} 
		catch (SystemException e) 
		{
			_log.error("SystemException, error: " + e.getMessage(), e);
		}
	}
	
	
	/**
	 * Method which calls Bunchball login service, parse the response & stores the 'sessionKey' 
	 * & 'keyCreationTime' in MerlinSession
	 *   
	 */
	private static void callBunchballLoginService(User user)
	{
		_log.info("Start Executing Bunchball Service from MSSPostLoginHook...");
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_LOG_IN);
		queryStringParams.put(Parameters.USER_ID, user.getScreenName());
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			// check Nitro is errorType?
			if(nitroType.getError() != null)
			{
				ErrorType error = nitroType.getError();
				
				throw new BunchballServiceException(error.getMessage());
			}
			else
			{
				LoginType login = nitroType.getLogin();
				
				if(login != null)
				{
					String sessionKey = login.getSessionKey();
					
					_log.info("Newly fetched SessionKey is: " + sessionKey);
					
					Map<String, String> bbKeysMap = new HashMap<String, String>();
					
					bbKeysMap.put(BB_LOGIN_SESSION_KEY, sessionKey);
					bbKeysMap.put(BB_KEY_CREATION_TIME, String.valueOf(System.currentTimeMillis()));
					
					MerlinSession.set(MSS_BUNCHBALL_KEYS, bbKeysMap);
					
					_log.info("Newly fetched 'SessionKey' & 'keyCreationTime' set in MerlinSession successfully...");
				}
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball Login Service from Hook, \n error: " + e.getMessage(), e);
		}
	}
	
	
	/**
	 * Converts long time (milliseconds time) to Number of Days time. 
	 * 
	 * @param creationTime
	 * @return long
	 */
	private static long getTimeInDays(long creationTime)
	{
		/*long javaTime = creationTime - 0x19db1ded53e8000L;

		javaTime /= 10000;*/

		Date now = new Date();

		long javaTime = creationTime; 
				
		long nowMillis = now.getTime();

		long difference = nowMillis - javaTime;

		long NO_OF_DAYS = difference/ONE_DAY;
		
		return NO_OF_DAYS;
	}
	
	
	/**
	 * Get the default 'MSS' site 
	 * 
	 * @param companyId
	 * @param siteName
	 * @return {@link Group}
	 * @throws PortalException
	 * @throws SystemException
	 * 
	 */
	private static Group getDefaultMSSSite(long companyId, String siteName) throws PortalException, SystemException
	{
		return GroupLocalServiceUtil.getGroup(companyId, siteName);
	}
	
	
	/**
	 * Method to find out if the given 'user' is the member of the given 'group' or not
	 * 
	 * @param user
	 * @param mssSite
	 * @return boolean
	 * 
	 */
	private static boolean isUserMSSMember(User user, Group mssSite)
	{
		boolean isMSSMember = Boolean.FALSE;
		
		try
		{
			isMSSMember = GroupLocalServiceUtil.hasUserGroup(user.getUserId(), mssSite.getGroupId());
		}
		catch(Exception exc)
		{
			_log.error("User " + user.getFullName() + " is NOT a member of group " + mssSite.getName());
		}	
		
		return isMSSMember;
	}
	

	private static String DEFAULT_MSS_SITE_NAME = "IHG Meeting Point";
	
	private static String MSS_BUNCHBALL_KEYS = "mssBunchballKeys";
	
	private static String BB_LOGIN_SESSION_KEY = "bunchBallSessionKey";
	
	private static String BB_KEY_CREATION_TIME = "keyCreationTime";	
	
	private static long TIME_BEFORE_EXPIRATION_DAYS = 28;
	
	private static long ONE_DAY = 1000*60*60*24;
	
	private static final Log _log = LogFactoryUtil.getLog(MSSLoginUtil.class);
	
}
