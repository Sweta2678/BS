package com.ihg.mss.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.me2.utils.session.MerlinSession;
import com.ihg.mss.bunchball.method.Methods;
import com.ihg.mss.bunchball.model.ErrorType;
import com.ihg.mss.bunchball.model.LoginType;
import com.ihg.mss.bunchball.model.NitroType;
import com.ihg.mss.bunchball.model.PointCategoriesType;
import com.ihg.mss.bunchball.model.PointCategoryType;
import com.ihg.mss.bunchball.model.UserPreferenceType;
import com.ihg.mss.bunchball.model.UserPreferencesType;
import com.ihg.mss.bunchball.parameter.Parameters;
import com.ihg.mss.constants.BunchballConstants;
import com.ihg.mss.exceptions.BunchballServiceException;
import com.ihg.mss.utils.BunchballUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;


/**
 * Main Utility class which calls Generic Nitro-Bunchball services like getPoints, getPreferences, etc. 
 * Portlet classes, Controller MUST NOT call Nitro services directly & MUST use this class to make Mitro call.
 * This class will have same methods as PortletNitroServiceUtil.java in Portlet context
 * 
 * @author Jay Patel
 *
 */

public class HookNitroServiceUtil 
{

	/**
	 * Retrieves Nitro Session Key from Merlin Session,
	 * If sessionKey NOT found in MerlinSession then calls Nitro Login Service to get sessionKey
	 * 
	 * @param nitroUserId
	 * @return String
	 */
	public static String getNitroSessionKey(String nitroUserId)
	{
		
		/**
		 * Retrieve Nitro Session key from Merlin Session
		 */
		String nitroSessionKey = HookNitroServiceUtil.getNitroSessionKeyFromMerlinSession();
		
		/**
		 * If Nitro Session Key is null, then call NitroLoginService again to get NEW Session Key
		 */
		if(Validator.isNotNull(nitroSessionKey))
		{
			return nitroSessionKey;
		}
		else
		{
			return HookNitroServiceUtil.callBunchballLoginService(nitroUserId);
		}
	}

	
	/**
	 * Retrieves Nitro Session Key from 'MerlinSession'
	 * 
	 * @return String
	 * 
	 */
	public static String getNitroSessionKeyFromMerlinSession()
	{
		String nitroLoginSessionKey = StringPool.BLANK; 
		
		Map<String, String> bunchballKeysMap = MerlinSession.get(BunchballConstants.MSS_BUNCHBALL_KEYS);
		
		if(bunchballKeysMap != null)
		{
			String sessionKey = bunchballKeysMap.get(BunchballConstants.BB_LOGIN_SESSION_KEY);
			
			if(Validator.isNotNull(sessionKey))
			{
				String keyCreationTime = bunchballKeysMap.get(BunchballConstants.BB_KEY_CREATION_TIME);
				
				if(Validator.isNotNull(keyCreationTime))
				{
					try
					{
						long creationTime = Long.parseLong(keyCreationTime);
						
						/*If 'creationTime' is less than 'TIME_BEFORE_EXPIRATION_DAYS',
						then NO need to call BB Login service again, as old sessionKey
						from MerlinSession is still VALID & can be used to call any BB Service,
						else we need to call Bunchball Login Service again */
						
						if(getTimeInDays(creationTime) < BunchballConstants.TIME_BEFORE_EXPIRATION_DAYS)
						{
							nitroLoginSessionKey = sessionKey;
						}
					}
					catch(Exception e)
					{
						_log.error("Error while parsing 'keyCreationTime'", e);
					}
				}
			}
		}
		
		return nitroLoginSessionKey;
	}
	
	
	/**
	 * Converts long time (milliseconds time) to Number of Days time. 
	 * 
	 * @param creationTime
	 * @return long
	 */
	public static long getTimeInDays(long creationTime)
	{
		/*long javaTime = creationTime - 0x19db1ded53e8000L;

		javaTime /= 10000;*/

		Date now = new Date();

		long javaTime = creationTime; 
				
		long nowMillis = now.getTime();

		long difference = nowMillis - javaTime;

		long NO_OF_DAYS = difference/BunchballConstants.ONE_DAY;
		
		return NO_OF_DAYS;
	}
	
	
	/**
	 * Method which calls Bunchball login service, parse the response & stores the 'sessionKey' 
	 * & 'keyCreationTime' in MerlinSession
	 * 
	 * @param nitroUserId
	 * @return String 
	 * 
	 */
	public static String callBunchballLoginService(String nitroUserId)
	{
		String newNitroSessionKey = StringPool.BLANK;
		
		_log.info("Start Executing Bunchball Service from MSSPostLoginHook...");
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_LOG_IN);
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			/**
			 * Check for Error
			 */
			if(nitroType.getRes().equalsIgnoreCase(BunchballConstants.BUNCHBALL_SERVICE_RESPONSE_ERROR)
					|| nitroType.getError() != null)
			{
				ErrorType error = nitroType.getError();
				
				throw new BunchballServiceException(error.getMessage());
			}
			else
			{
				LoginType login = nitroType.getLogin();
				
				if(login != null)
				{
					newNitroSessionKey = login.getSessionKey();
					
					_log.info("Newly fetched SessionKey is: " + newNitroSessionKey);
					
					Map<String, String> bbKeysMap = new HashMap<String, String>();
					
					bbKeysMap.put(BunchballConstants.BB_LOGIN_SESSION_KEY, newNitroSessionKey);
					bbKeysMap.put(BunchballConstants.BB_KEY_CREATION_TIME, String.valueOf(System.currentTimeMillis()));
					
					MerlinSession.set(BunchballConstants.MSS_BUNCHBALL_KEYS, bbKeysMap);
					
					_log.info("Newly fetched 'SessionKey' & 'keyCreationTime' set in MerlinSession successfully...");
				}
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball Login Service from Hook, \n error: " + e.getMessage(), e);
		}
		
		return newNitroSessionKey;
	}
	
	
	/**
	 * Calls Nitro Action Service & returns true if service executed successfully
	 * 
	 * @param activeDirectoryId
	 * @param nitroUserId
	 * @param actionTagName
	 * @return boolean
	 */
	public static boolean callBunchballActionService(String activeDirectoryId, String nitroUserId, String actionTagName)
	{
		boolean executed = Boolean.FALSE;
		
		String nitroSessionKey = HookNitroServiceUtil.getNitroSessionKey(activeDirectoryId);
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_LOG_ACTION);
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		queryStringParams.put(Parameters.SESSION_KEY, nitroSessionKey);
		
		/*When user.logAction is called, at that time, it is MUST to pass "action/tag" & "AD ID"*/ 
		queryStringParams.put(Parameters.ACTIVE_DIRECTORY_ID, activeDirectoryId);
		queryStringParams.put(Parameters.ACTION_NAME, actionTagName);
		
		/**
		 * Call Nitro Services
		 */
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			executed = Boolean.TRUE;
		}
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Nitro Action Service, message:" + e.getMessage(), e);
		}
		
		return executed;
	}
	

	/**
	 * Calls Nitro Action Service with Action value & returns true if service executed successfully
	 * 
	 * @param activeDirectoryId
	 * @param nitroUserId
	 * @param actionTagName
	 * @param actionValue
	 * @return boolean
	 */
	public static boolean callBunchballActionServiceWithValue(String activeDirectoryId, String nitroUserId, 
							String actionTagName, String actionValue)
	{
		boolean executed = Boolean.FALSE;
		
		String nitroSessionKey = HookNitroServiceUtil.getNitroSessionKey(activeDirectoryId);
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_LOG_ACTION);
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		queryStringParams.put(Parameters.SESSION_KEY, nitroSessionKey);
		
		/*When user.logAction is called, at that time, it is MUST to pass "action/tag" & "AD ID"*/ 
		queryStringParams.put(Parameters.ACTIVE_DIRECTORY_ID, activeDirectoryId);
		queryStringParams.put(Parameters.ACTION_NAME, actionTagName);
		queryStringParams.put(Parameters.VALUE, actionValue);
		
		/**
		 * Call Nitro Services
		 */
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			executed = Boolean.TRUE;
		}
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Nitro Action Service, message:" + e.getMessage(), e);
		}
		
		return executed;
	}
	
	
	/**
	 * Returns Map of User's Bunchball Points & Lifetime Points
	 * This service tries to get all the PointCategory like Auto, Pharma & Default & then based on groupName it returns results.
	 * See Also getAllPointBalanceService() method
	 * 
	 * @param user
	 * @param groupName
	 * @param nitroSessionKey
	 * @return Map<String, String>
	 * 
	 */
	public static Map<String, String> getPointsBalance(String nitroUserId, String groupName, String nitroSessionKey)
	{
		Map<String, String> userPointsMap = new HashMap<String, String>();
		
		int points = 0;
		int lifetimePoints = 0;
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_GET_POINTS_BALANCE);
		queryStringParams.put(Parameters.SESSION_KEY, nitroSessionKey);
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		
		if(BunchballConstants.COMMUNITY_NAME_MSS_AUTO.equalsIgnoreCase(groupName)){
			queryStringParams.put(Parameters.POINTS_CATEGORY, BunchballConstants.POINTS_AUTO);	
		}
		if(BunchballConstants.COMMUNITY_NAME_MSS_PHARMA.equalsIgnoreCase(groupName)){
			queryStringParams.put(Parameters.POINTS_CATEGORY, BunchballConstants.POINTS_PHARMA);
		}
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			if(nitroType != null)
			{
				if(nitroType.getBalance().getPointCategories() != null)
				{
					PointCategoriesType pointsCatType = nitroType.getBalance().getPointCategories();
					
					List<PointCategoryType> listPtCategory = pointsCatType.getPointCategory();
					
					if(listPtCategory != null && !listPtCategory.isEmpty())
					{
						for(PointCategoryType catType : listPtCategory)
						{
							if(BunchballConstants.COMMUNITY_NAME_MSS_AUTO.equalsIgnoreCase(groupName) 
									&& catType.getName().equalsIgnoreCase(BunchballConstants.POINTS_AUTO))
							{
								points = catType.getPoints();
								lifetimePoints = catType.getLifetimeBalance();
								break;
							}
							else if(BunchballConstants.COMMUNITY_NAME_MSS_PHARMA.equalsIgnoreCase(groupName) 
									&& catType.getName().equalsIgnoreCase(BunchballConstants.POINTS_PHARMA))
							{
								points = catType.getPoints();
								lifetimePoints = catType.getLifetimeBalance();
								break;
							}
						}						
						
						_log.info("Points : " + points + " LifetimePoints : " + lifetimePoints);
					}
				}
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball Points Service, error: " + e.getMessage(), e);
		}
		
		userPointsMap.put("userPoints", String.valueOf(points));
		userPointsMap.put("userLifetimePoints", String.valueOf(lifetimePoints));
		
		return userPointsMap;
	}
	

	
	/**
	 * Returns Map of User's Bunchball Points & Lifetime Points
	 * This service tries to get ALL the PointCategory like Auto, Pharma & Default & then 
	 * set Key Value pair in MAP like: "Auto Points=20", "Auto Points_lifetimeBalance=100" etc.
	 * 
	 * See also getPointsBalance()
	 * 
	 * @param user
	 * @param groupName
	 * @param nitroSessionKey
	 * @return Map<String, String>
	 * 
	 */
	public static Map<String, String> getAllSectorPointBalance(String nitroUserId, /*String groupName, */String nitroSessionKey)
	{
		Map<String, String> userAllSectorPointsMap = new HashMap<String, String>();
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_GET_POINTS_BALANCE);
		queryStringParams.put(Parameters.SESSION_KEY, nitroSessionKey);
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		queryStringParams.put(Parameters.POINTS_CATEGORY, BunchballConstants.BUNCHBALL_POINTS_CATEGORY_ALL);
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			if(nitroType != null)
			{
				if(nitroType.getBalance().getPointCategories() != null)
				{
					PointCategoriesType pointsCatType = nitroType.getBalance().getPointCategories();
					
					List<PointCategoryType> listPtCategory = pointsCatType.getPointCategory();
					
					if(listPtCategory != null && !listPtCategory.isEmpty())
					{
						for(PointCategoryType catType : listPtCategory)
						{
							
							/**
							 * Key Value pair in MAP:
							 * Auto Points=20
							 * Auto Points_lifetimeBalance=100
							 * 
							 */
							
							userAllSectorPointsMap.put(catType.getName(), String.valueOf(catType.getPoints()));
							userAllSectorPointsMap.put(catType.getName() + "_lifetimeBalance", String.valueOf(catType.getLifetimeBalance()));
							_log.info("Category Name:" + catType.getName() + " Points:" + catType.getPoints() + " Lifetime Points:" + catType.getLifetimeBalance());
						}	
					}
				}
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball ALL Points Service, error: " + e.getMessage(), e);
		}
		
		return userAllSectorPointsMap;
	}


	/**
	 * Returns Map of User's Bunchball (Nitro) Preferences
	 * This service tries to get ALL the Preferences & set Key Value pair in MAP like:  
	 * "Auto_Level=Beginner", "Pharma_Level=Intermediate" etc.
	 *  
	 * @param nitroUserId
	 * @param nitroSessionKey
	 * @return Map<String, String>
	 */
	public static Map<String, String> getAllPreferences(String nitroUserId, String nitroSessionKey)
	{
		Map<String, String> preferencesMap = new HashMap<String, String>();
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_GET_PREFERENCES);
		queryStringParams.put(Parameters.SESSION_KEY, nitroSessionKey);
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		// BY DEFAULT, ALL PREFERENCES RETURED BY NITRO
		
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			if(nitroType != null)
			{
				if(nitroType.getUserPreferences() != null)
				{
					UserPreferencesType prefs = nitroType.getUserPreferences();
				
					List<UserPreferenceType> listPref = prefs.getUserPreference();
					
					if(listPref != null && !listPref.isEmpty())
					{
						for(UserPreferenceType userPref : listPref)
						{
							if(userPref != null)
							{
								preferencesMap.put(userPref.getName(), userPref.getValue());
							}
						}
					}
				}
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball Preferences Service, error: " + e.getMessage(), e);
		}
		
		return preferencesMap;
	}
	
	
	/**
	 * Method to set Nitro Preference
	 * 
	 * @param nitroUserId
	 * @param preferenceName
	 * @param preferenceValue
	 * @return boolean
	 */
	public static boolean setPreference(String nitroUserId, String preferenceName, String preferenceValue)
	{
		boolean successfullyExecuted = Boolean.FALSE;
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_SET_PREFERENCE);
		queryStringParams.put(Parameters.SESSION_KEY, getNitroSessionKey(nitroUserId));
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		queryStringParams.put(Parameters.NAME, preferenceName);
		queryStringParams.put(Parameters.VALUE, preferenceValue);
	
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			if(nitroType != null)
			{
				successfullyExecuted = Boolean.TRUE;
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball setPreference Service, error: " + e.getMessage(), e);
		}	
		
		return successfullyExecuted;
	}
	
	/**
	 * Method to set Nitro Preferences
	 * 
	 * @param nitroUserId
	 * @param preferenceName
	 * @param preferenceValues
	 * @return boolean
	 */
	public static boolean setPreferences(String nitroUserId, String preferenceNames, String preferenceValues)
	{
		boolean successfullyExecuted = Boolean.FALSE;
		
		Map<String, String> queryStringParams = new HashMap<String, String>();
		
		queryStringParams.put(Parameters.METHOD, Methods.METHOD_USER_SET_PREFERENCES);
		queryStringParams.put(Parameters.SESSION_KEY, getNitroSessionKey(nitroUserId));
		queryStringParams.put(Parameters.USER_ID, nitroUserId);
		queryStringParams.put(Parameters.NAMES, preferenceNames);
		queryStringParams.put(Parameters.VALUES, preferenceValues);
	
		try 
		{
			NitroType nitroType = BunchballUtil.executeGET(queryStringParams);
			
			if(nitroType != null)
			{
				successfullyExecuted = Boolean.TRUE;
			}
		} 
		catch (BunchballServiceException e) 
		{
			_log.error("Error while calling Bunchball setPreferences Service, error: " + e.getMessage(), e);
		}	
		
		return successfullyExecuted;
	}
	
	private static Log _log = LogFactoryUtil.getLog(HookNitroServiceUtil.class);
}
