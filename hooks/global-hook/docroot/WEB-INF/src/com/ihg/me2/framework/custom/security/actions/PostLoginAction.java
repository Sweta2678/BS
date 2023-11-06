/**
 * 
 */
package com.ihg.me2.framework.custom.security.actions;

import com.ihg.me2.framework.custom.security.cache.MerlinCacheSecurityConstants;
import com.ihg.me2.framework.custom.security.utils.GlobalConstants;
import com.ihg.me2.framework.custom.security.utils.GlobalUtil;
import com.ihg.me2.utils.session.MerlinCache;
import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SheladG
 *
 */
public class PostLoginAction extends Action  implements MerlinCacheSecurityConstants {
	
	private static Log LOG = LogFactoryUtil.getLog(PostLoginAction.class);

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.events.Action#run(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {

		try {
			long userId = PortalUtil.getUserId(request);
			User user = UserLocalServiceUtil.getUser(userId);
			if (LOG.isDebugEnabled()) {
				LOG.debug("PostLogin hook User Id :"+userId);
			}
			Map<String, String> session = new HashMap<String, String>();
			setSimpleMappingValues(user, session);
			setCurrentLocationValues(session);
			session.put(GlobalConstants.FIRST_NAME, user.getFirstName());
			session.put(GlobalConstants.MIDDLE_NAME, user.getMiddleName());
			session.put(GlobalConstants.LAST_NAME, user.getLastName());
			session.put(GlobalConstants.EMAIL, user.getEmailAddress());
			MerlinSession.set(user.getScreenName(), session);
			
			/* Academy FPS Lead role check starts */
			academyFPSLeadchk(user);
			/*Academy FPS Lead role check ends*/
			
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	
/*	*//**
	 * Setting simple mapping values - Expando column to Session.
	 * @param user
	 * @param session
	 * @throws MerlinDataAccessException
	 * @throws SecurityXMLException
	 * @throws PortalException
	 * @throws SystemException
	 *//*
	public static void setSimpleMappingValues(User user, Map<String, String> session) throws  PortalException, SystemException
	{
		
		long startTime = System.currentTimeMillis();
		Enumeration<String> e = SESSION_MAPPING_BUNDLE.getKeys();
		while (e.hasMoreElements()) 
		{
		    String sColumnName = e.nextElement();
		    String sValue = null;
		    if (user.getExpandoBridge().hasAttribute(sColumnName)) 
		    {
		    	Serializable entContactIdVal = ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, sColumnName, user.getUserId());
		    	if (entContactIdVal != null) 
		    	{
		    		sValue = entContactIdVal.toString();
		    		String[] sColumnValues = SESSION_MAPPING_BUNDLE.getString(sColumnName).split(StringPool.SEMICOLON);
		    		for (String sColumnValue : sColumnValues)
		    		{
			    		if (sColumnValue.equals(GlobalConstants.CURR_LOCATION) || sColumnValue.equals(GlobalConstants.LOCATIONS)) 
			    		{
			    			String[] allLocations  = sValue.split(StringPool.SEMICOLON);
			    			sValue = "";
			    			for (int i = 0 ; i < allLocations.length; i++) 
			    			{
			    				String location = allLocations[i];	
			    				sValue = sValue + GlobalUtil.getKeyCode(location);
			    				if (i + 1 < allLocations.length) 
			    				{
			    					sValue = sValue + StringPool.SEMICOLON;
			    				}
			    			}
			    		} 
			    		else 
			    		{
			    			sValue = GlobalUtil.getKeyCode(sValue);
			    		}
			    		session.put(sColumnValue, sValue);
		    		}
		    	}
		    } 
		    else 
		    {
		    	LOG.debug("Inavalid Attribute in SessionMapping Prop file:" + sColumnName);
		    }
		}
		long endTime = System.currentTimeMillis();
		LOG.debug("Time taken in ms for setSimpleMappingValues method: " + (endTime - startTime));
	}*/
	
	/**
	 * Setting simple mapping values - Expando column to Session.
	 * @param user
	 * @param session
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void setSimpleMappingValues(User user, Map<String, String> session) throws PortalException, SystemException
	{
		
		LOG.info("PostLoginAction.setSimpleMappingValues");
		long startTime = System.currentTimeMillis();
		Enumeration<String> e = SESSION_MAPPING_BUNDLE.getKeys();
		String currentLocation = SESSION_CONFIG.getString(CURRENT_ATTRIBUTE);
		String baseAttribute = SESSION_CONFIG.getString(BASE_ATTRIBUTE);
		while (e.hasMoreElements()) 
		{
		    String sColumnName = e.nextElement();
		    String sValue = null;
		    if (user.getExpandoBridge().hasAttribute(sColumnName)) 
		    {
		    	Serializable entContactIdVal = ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, sColumnName, user.getUserId());
		    	if (entContactIdVal != null) 
		    	{
		    		sValue = entContactIdVal.toString();
		    		String[] sColumnValues = SESSION_MAPPING_BUNDLE.getString(sColumnName).split(SESSION_DELIMETER);
		    		for (String sColumnValue : sColumnValues)
		    		{
			    		if (sColumnValue.equals(currentLocation) || sColumnValue.equals(baseAttribute)) 
			    		{
			    			String[] allLocations  = sValue.split(SESSION_DELIMETER);
			    			sValue = "";
			    			for (int i = 0 ; i < allLocations.length; i++) 
			    			{
			    				String location = allLocations[i];	
			    				sValue = sValue + GlobalUtil.getKeyCode(location);
			    				if (i + 1 < allLocations.length) 
			    				{
			    					sValue = sValue + SESSION_DELIMETER;
			    				}
			    			}
			    		} 
			    		else 
			    		{
			    			sValue = GlobalUtil.getKeyCode(sValue);
			    		}
			    		session.put(sColumnValue, sValue);
			    		LOG.debug("PostLoginAction.setSimpleMappingValues--Setting session " + sColumnValue + " = " + sValue);
		    		}
		    	}
		    } 
		    else 
		    {
		    	LOG.debug("Inavalid Attribute in SessionMapping Prop file:" + sColumnName);
		    }
		}
		long endTime = System.currentTimeMillis();
		LOG.info("Time taken in ms for setSimpleMappingValues method: " + (endTime - startTime));
	}
	
	
	/**
	 * Set Current Location and All location values.
	 * @param user
	 * @param session
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setCurrentLocationValues(Map<String, String> session) throws Exception 
	{
		long startTime = System.currentTimeMillis();
		
		LOG.info("PostLoginAction.setCurrentLocationValues");
		String baseAttribute = SESSION_CONFIG.getString(BASE_ATTRIBUTE);
		String ids = SESSION_CONFIG.getString(SECURITY_ID_VALUE_LOOKUP);
		String allLocs = (String) session.get(baseAttribute);
		String currentLocation = (String) session.get(SESSION_CONFIG.getString(CURRENT_ATTRIBUTE));
		LOG.debug("PostLoginAction.setCurrentLocationValues : CurrentLocation : " + currentLocation);
		LOG.debug("PostLoginAction.setCurrentLocationValues : All Location : " + allLocs);
		String[] allLocations = allLocs.split(SESSION_DELIMETER);
		//CacheManager cacheManager = (CacheManager) BeanFactory.getBean(BeanFactory.CACHE_MANAGER);
		String[] securityXMLIds = ids.split(SESSION_DELIMETER);
		for (String securityId : securityXMLIds) 
		{
			//Map<String, Object> mainMap = cacheManager.getSecurityDataMap(securityId);
			Map<String, Object> mainMap = MerlinCache.getCacheMap(securityId);
			if (mainMap != null) 
			{
				Map<String, Object> dataMap = MerlinCache.getCacheData(securityId) ;
				for (String location : allLocations) 
				{
					Map<String, String> innerMap = (Map<String, String>) dataMap.get(location);
					if (innerMap != null) 
					{
						processSessionValues(location, innerMap, session, location.equals(currentLocation), true);
						String existingVals = (String) session.get(securityId);
						
						// Set AllHotels and AllLocations
						if (existingVals != null && !"".equals(existingVals))
						{
							existingVals = existingVals + SESSION_DELIMETER + location;
						}
						else
						{
							existingVals = location;
						}
						session.put(securityId, existingVals);
						LOG.debug("*** Session Name : " + securityId + "    Session Value : " + existingVals);
					} 
				}
			}
		}
		long endTime = System.currentTimeMillis();
		LOG.info("Time taken in ms for setCurrentLocationValues method: " + (endTime - startTime));
	}
	
	/**
	 * process session value for the current row of database.
	 * @param location
	 * @param rowMap
	 * @param session
	 * @param current
	 */
	public static void processSessionValues(String location, Map<String, String> rowMap, Map<String, String> session, boolean setCurrent, boolean setAll) 
	{
		LOG.info("PostLoginAction.processSessionValues");
		long startTime = System.currentTimeMillis();
		Enumeration<String> e = COLUMN_TO_SESSION_BUNDLE.getKeys();
		while (e.hasMoreElements()) 
		{
			String sColumnName = e.nextElement();
			String sValue = rowMap.get(sColumnName);
			if (sValue != null && sValue.trim().length() > 0) 
			{
				sValue = GlobalUtil.getKeyCode(sValue);
				String[] values = COLUMN_TO_SESSION_BUNDLE.getString(sColumnName).split(",");
				if (setAll)
				{
					String existingVals = (String) session.get(values[1]);
					if (existingVals != null && !"".equals(existingVals))
					{
						session.put(values[1], existingVals + SESSION_DELIMETER + sValue);
						LOG.debug("*** Session Name : " + values[1] + "    Session Value : " + existingVals + SESSION_DELIMETER + sValue);
					}
					else
					{
						session.put(values[1], sValue);
						LOG.debug("*** Session Name : " + values[1] + "    Session Value : " + sValue);
					}
				}
				if (setCurrent) 
				{
					session.put(values[0], sValue);
					LOG.debug("*** Session Name : " + values[0] + "    Session Value : " + sValue);
				}
			}
		}
		long endTime = System.currentTimeMillis();
		LOG.info("Time taken in ms for processSessionValues method: " + (endTime - startTime));
	}
	
	/**
	 * Validate job title for FPS Lead for an user and assign regionadmin role based on Management New Region field
	 * @param user
	 */
	private void academyFPSLeadchk(User user)
	{
		LOG.info("PostLogin hook academyFPSLeadchk ::");
		
		Map<String,String> REGIONAL_ADMIN_REGION_MAP = null;
		REGIONAL_ADMIN_REGION_MAP = new HashMap<String, String>();
		REGIONAL_ADMIN_REGION_MAP.put("Europe[EURO]", "academy-euro-admin");
		REGIONAL_ADMIN_REGION_MAP.put("Asia Middle East and Africa [AMEA]", "academy-amea-admin");
		REGIONAL_ADMIN_REGION_MAP.put("Greater China [GC]", "academy-gc-admin");
		REGIONAL_ADMIN_REGION_MAP.put("Americas [AMER]", "academy-amer-admin");
		boolean isSiteMemberOfIhgAcademy = true;
		long[] roleIds = new long[1];
		String fpsLead = "mgr hotel performance support";
		long companyId = PortalUtil.getDefaultCompanyId();
		
		if(Validator.isNotNull(user)) {
			try {
				// No need to rely on custom filed 'Job Title'
				//	Serializable jobTitle = ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), User.class.getName(),ExpandoTableConstants.DEFAULT_TABLE_NAME, "Job Title", user.getUserId());
				String jobTitle = user.getJobTitle();
				if (Validator.isNotNull(jobTitle)) 
		    	{
						if(jobTitle.toLowerCase().contains(fpsLead)) {
						
						Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(companyId , "/ihg-academy");
						/* Assign User to IHG Academy group */
					
						isSiteMemberOfIhgAcademy  = UserLocalServiceUtil.hasGroupUser(group.getGroupId(),user.getUserId());
						LOG.info(user.getFirstName() +" is IHG Academy member : "+isSiteMemberOfIhgAcademy);
						
						if(!isSiteMemberOfIhgAcademy){
							UserLocalServiceUtil.addGroupUser(group.getGroupId(),user.getUserId()); 
						}
				       
						Serializable region = ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), User.class.getName(),ExpandoTableConstants.DEFAULT_TABLE_NAME, "Management New Region", user.getUserId());
				    
						if(Validator.isNotNull(region) && Validator.isNotNull(REGIONAL_ADMIN_REGION_MAP.get(region.toString()))) {
				    	   Role regionalAdminRole = RoleLocalServiceUtil.fetchRole(companyId, REGIONAL_ADMIN_REGION_MAP.get(region.toString()));
				    	   
				    	   if (regionalAdminRole != null) {
				    		   roleIds[0] = regionalAdminRole.getRoleId();
				    		   if (!UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), group.getGroupId(), regionalAdminRole.getRoleId())) {
				    			   UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), group.getGroupId(), roleIds);
				    			   LOG.info(user.getFirstName() +" has been assigned IHG Academy admin role : "+regionalAdminRole.getName());
				    		   } else {
				    			   LOG.info(user.getFirstName() +" already has admin role.");
				    		   }
				    	   }
				       }

					}
				}
			} catch (SystemException e) {
				LOG.error(e.getMessage(), e);
			} catch (PortalException e) {
				LOG.error(e.getMessage(), e);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
		
	}
	
	
}
