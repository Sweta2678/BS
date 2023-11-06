package com.ihg.mss.servlet.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihg.mss.servlet.exception.MSSSecurityServiceException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;


/**
 * Main Security Utility class used to update role permissions
 *   
 * When new sector is assigned
 * When level is increased in sector
 * Utilities for Nitro Call-back to Portal 
 * 
 * @author Jay Patel
 *
 */
public class MSSSecurityUtil 
{
	
	/**
	 * Retrieves levelType, LevelValue & allLevelPoints parameter value from Nitro Request.
	 * 
	 * @param request
	 * @return Map<String, String>
	 * @throws MSSSecurityServiceException
	 */
	public static Map<String, String> getLevelPointsInfoFromNitroRequest(HttpServletRequest request) throws MSSSecurityServiceException
	{
		Map<String, String> paramMap = new HashMap<String, String>();
		
		String levelType = request.getParameter(PARAM_LEVEL_TYPE);
		String levelValue = request.getParameter(PARAM_LEVEL_VALUE);
		String allLevelPoints = request.getParameter(PARAM_ALL_LEVEL_POINTS);
		
		if(! Validator.isNotNull(levelType))
		{
			throw new MSSSecurityServiceException("No LEVEL_TYPE passed from Nitro Request !!!");
		}
		if(! Validator.isNotNull(levelValue))
		{
			throw new MSSSecurityServiceException("No LEVEL_VALUE passed from Nitro Request !!!");
		}
		/*if(! Validator.isNotNull(allLevelPoints))
		{
			throw new MSSSecurityServiceException("No ALL_LEVEL_POINTS passed from Nitro Request !!!");
		}*/
		
		paramMap.put(PARAM_LEVEL_TYPE, levelType);
		paramMap.put(PARAM_LEVEL_VALUE, levelValue);
		/*paramMap.put(PARAM_ALL_LEVEL_POINTS, allLevelPoints);*/
		
		return paramMap;
	}
	

	/**
	 * Retrieves user based on companyId & userId
	 * 
	 * @param request
	 * @param response
	 * @return User
	 * @throws MSSSecurityServiceException
	 */
	public static User getUserFromNitroRequest(HttpServletRequest request) 
			throws MSSSecurityServiceException
	{	
		String userId = request.getParameter(PARAM_USERID);
		
		if(! Validator.isNotNull(userId))
		{
			throw new MSSSecurityServiceException("No USER_ID passed from Nitro Request !!!");
		}
		
		String companyId = request.getParameter(PARAM_COMPANYID);
		
		if(! Validator.isNotNull(companyId))
		{
			throw new MSSSecurityServiceException("No COMPANY_ID passed from Nitro Request !!!");
		}
		
		User user = null;
		
		try 
		{
			user = UserLocalServiceUtil.getUserByScreenName(Long.valueOf(companyId), userId);
		} 
		catch (Exception e) 
		{
			throw new MSSSecurityServiceException("Can't find user with userId: " + userId + " ,error: " + e.getMessage());
		}
		
		return user;
	}
	
	
	
	/**
	 * Method used to authenticate Nitro's request for "Portal Call-back Security Service"
	 * 
	 * @param request
	 * @param response
	 * @return boolean
	 * @throws MSSSecurityServiceException
	 * 
	 */
	public static boolean authenticateNitroRequest(HttpServletRequest request) 
			throws MSSSecurityServiceException
	{
		boolean isSecure = Boolean.FALSE;
		
	    String username = request.getParameter(PARAM_USERNAME);
	    String password = request.getParameter(PARAM_PASSWORD);
	    
	    	/**
	    	 * @TODO: Check against properties file for "Admin" credentials
	    	 */
		if(! Validator.isNotNull(username))
		{
			throw new MSSSecurityServiceException("No USERNAME passed from Nitro Request !!!");
		}
		else if(! Validator.isNotNull(password))
		{
			throw new MSSSecurityServiceException("No PASSWORD passed from Nitro Request !!!");
		}
		else if( (username.equalsIgnoreCase("test")) && (password.equalsIgnoreCase("test")) )
		{
			isSecure = Boolean.TRUE;
		}
		else
		{
			throw new MSSSecurityServiceException("Invalid Credentials from Nitro Request !!!");
		}
		
		return isSecure;
	}
	
	
	/**
	 * Builds XML Success message for Portal Call-back response
	 * 
	 * @param message
	 * @return String xmlResponse
	 */
	public static String buildPortalCallbackResponse(String message)
	{
		if(! Validator.isNotNull(message))
		{
			message = DEFAULT_CALLBACK_MESSAGE;
		}
		
		StringBuilder responseBuilder = new StringBuilder(XML_HEADER);
		
		responseBuilder.append(XML_START_TAG_SUCCESS);
		responseBuilder.append(XML_START_TAG_MESSAGE);
		responseBuilder.append(message);
		responseBuilder.append(XML_END_TAG_MESSAGE);
		responseBuilder.append(XML_END_TAG_SUCCESS);
		
		_log.info("Response: " + responseBuilder.toString());
		
		return responseBuilder.toString();
	}
	
	
	/**
	 * Builds XML Error message for Portal Call-back response
	 * 
	 * @param errorMessage
	 * @return String xmlResponse
	 */
	public static String buildPortalCallbackErrorResponse(String errorMessage)
	{
		if(! Validator.isNotNull(errorMessage))
		{
			errorMessage = DEFAULT_CALLBACK_ERROR_MESSAGE;
		}
		
		StringBuilder responseBuilder = new StringBuilder(XML_HEADER);
		
		responseBuilder.append(XML_START_TAG_ERROR);
		responseBuilder.append(XML_START_TAG_MESSAGE);
		responseBuilder.append(errorMessage);
		responseBuilder.append(XML_END_TAG_MESSAGE);
		responseBuilder.append(XML_END_TAG_ERROR);
		
		_log.info("Error Response: " + responseBuilder.toString());
		
		return responseBuilder.toString();
	}
	
	
	/**
	 * Writes actual XML message into Response
	 * 
	 * @param response
	 * @param xmlResponse
	 * @throws IOException
	 */
	public static void writePortalCallbackResponse(HttpServletResponse response, String xmlResponse) throws IOException
	{
		response.setContentType("application/xml");
		
	    PrintWriter out = response.getWriter();
	    
	    out.println(xmlResponse);
	    
	    out.close();
	}
	
	
	private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	
	private static final String PARAM_USERID = "userId";
	
	private static final String PARAM_COMPANYID = "companyId";
	
	private static final String PARAM_USERNAME = "username";
	
	private static final String PARAM_PASSWORD = "password";
	
	public static final String PARAM_LEVEL_TYPE = "levelType";
	
	public static final String PARAM_LEVEL_VALUE = "levelValue";
	
	public static final String PARAM_ALL_LEVEL_POINTS = "allLevelPoints";
	
	private static final String XML_START_TAG_ERROR = "<error>";
	
	private static final String XML_START_TAG_MESSAGE = "<message>";
	
	private static final String XML_END_TAG_MESSAGE = "</message>";
	
	private static final String XML_END_TAG_ERROR = "</error>";
	
	private static final String XML_START_TAG_SUCCESS = "<success>";
	
	private static final String XML_END_TAG_SUCCESS = "</success>";
	
	private static final String DEFAULT_CALLBACK_ERROR_MESSAGE = "Error occurred while calling Portal Security Callback !!!";
	
	public static final String DEFAULT_CALLBACK_MESSAGE = "Portal Security Call-back Request executed successfully !!!";
	
	private static final Log _log = LogFactoryUtil.getLog(MSSSecurityUtil.class);
	
}
