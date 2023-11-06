package com.ihg.mss.util;

import java.util.List;
import java.util.Map;

import com.ihg.mss.constants.BunchballConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;


/**
 * Main Utility class for all common methods to be called in Hook.
 * NO Direct Bunchball call should happen from these utility methods without invoking Nitro Service Utility.
 * 
 * @deprecated
 * @see : MSSCommonsUtil.java
 * 
 * @author Jay Patel
 *
 */

public class MSSHookUtil 
{	
	
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
	public static Group getDefaultMSSSite(long companyId, String siteName) throws PortalException, SystemException
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
	public static boolean isUserMSSMember(User user, Group mssSite)
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
	
	
	/**
	 * Based on companyId & remoteUser, finds out whether looged-in user is member of MSS or not
	 * 
	 * @param companyId
	 * @param remoteUser
	 * @return boolean
	 * 
	 */
	public static boolean isMSSSiteMember(long companyId, User user)
	{
		boolean isMSSMember = Boolean.FALSE;
		
		try 
		{	
			if(user != null && companyId > 0)
			{
					/*Get 'MSS' Group*/
				
				Group mssSite = MSSHookUtil.getDefaultMSSSite(companyId, BunchballConstants.COMMUNITY_NAME_MSS_DEFAULT);
				
				if(mssSite != null)
				{
						/*Is user 'MSS' member?*/
					
					isMSSMember = MSSHookUtil.isUserMSSMember(user, mssSite);
				}
			}
		} 
		catch (NumberFormatException e) 
		{
			_log.error("Error while trying to find out User's MSS Membership from Hook: ", e);
		} 
		catch (PortalException e) 
		{
			_log.error("Error while trying to find out User's MSS Membership from Hook: ", e);
		} 
		catch (SystemException e) 
		{
			_log.error("Error while trying to find out User's MSS Membership from Hook: ", e);
		}
		
		return isMSSMember;
	}
	
	
	
	/**
	 * Based on given parameters, saves Custom Attribute value
	 * userAttributesMap will have key-value pair like "Auto Points=500" etc.
	 * These key-value will be added as a Single attribute value with Comma separation like
	 * "Auto Points=500,Auto_Level=Beginner..."
	 * 
	 * @param companyId
	 * @param className
	 * @param expandoTableName
	 * @param expandoColumnName
	 * @param classPK
	 * @param userAttributesMap
	 * @param nitroData
	 * 
	 */
	public static void saveUserNitroAttributes(long companyId, String className, String expandoTableName, 
			String expandoColumnName, long classPK, List<Map<String, String>> listAttributeMap, String nitroData)
	{
		if((listAttributeMap != null && !listAttributeMap.isEmpty())
				|| Validator.isNotNull(nitroData))
		{
					/* Get Expando Table */
			
			ExpandoTable expandoTable = getNitroAttributesExpandoTable(companyId, className, expandoTableName);
			
			if(expandoTable != null)
			{
					/* Get Expando Column */
				
				ExpandoColumn nitroExpandoColumn = getNitroAttributesExpandoColumn(expandoTable, expandoColumnName);
				
				if(nitroExpandoColumn != null)
				{
					/*String data = getExpandoValue(companyId, className, expandoTableName, expandoColumnName, classPK);*/
					
					String data = StringPool.BLANK;
					
					if(Validator.isNotNull(nitroData))
					{
						/*If directly comma separated attributes are passed, then add in Custom Attribute without manipulating*/
						data = nitroData;
					}
					else
					{
						/*Else create comma separated string to add in Custom Attribute*/
						
						for(Map<String, String> attrMap : listAttributeMap)
						{
							if(attrMap != null)
							{
								for(String key : attrMap.keySet())
								{
									data += (key + StringPool.EQUAL + attrMap.get(key) + StringPool.COMMA); 
								}		
							}
						}						
					}
					
					_log.info("Nitro Custom Attribute Data: " + data);
					
						/*	Override Custom Attribute value */
					
					addExpandoValue(companyId, className, expandoTableName, expandoColumnName, classPK, data);
				}
			}
		}
	}
	
	
	/**
	 * Based on companyId, className & expandoTableName, this method creates/retrieves ExpandoTable
	 * 
	 * @param companyId
	 * @param className
	 * @param expandoTableName
	 * @return {@link ExpandoTable}
	 */
	public static ExpandoTable getNitroAttributesExpandoTable(long companyId, String className, String expandoTableName)
	{
		ExpandoTable nitroAttributesExpandoTable = null;
		
		try 
		{
			/* Get Expando Table */
			
			nitroAttributesExpandoTable = 
					ExpandoTableLocalServiceUtil.getTable(companyId, className, expandoTableName);
		} 
		catch (Exception e) 
		{
			_log.error("Error while getting NitroExpandoTable: " + expandoTableName + " , error: "+ e.getMessage());
			
			/* Create Expando Table */
			
			if(nitroAttributesExpandoTable == null)
			{
				try 
				{
					nitroAttributesExpandoTable = 
							ExpandoTableLocalServiceUtil.addTable(companyId, className, expandoTableName);
				} 
				catch (Exception e1) 
				{
					_log.error("Error while adding NitroExpandoTable: " + expandoTableName + " , error: "+ e1.getMessage());
				} 
			}
		}
		finally
		{
			if(nitroAttributesExpandoTable == null)
			{
				_log.error("System is unable to get/create NitroExpandoTable: " + expandoTableName + " !!!");
			}
		}
		
		return nitroAttributesExpandoTable;
	}
	
	
	
	/**
	 * Based on ExpandoTable & column name, gets/adds ExpandoColumn
	 * 
	 * @param expandoTable
	 * @param columnName
	 * @return {@link ExpandoColumn}
	 */
	public static ExpandoColumn getNitroAttributesExpandoColumn(ExpandoTable expandoTable, String columnName)
	{
		ExpandoColumn nitroExpandoColumn = null;
		
		try 
		{
			// no need to query "companyId" here
			nitroExpandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName);
		} 
		catch (Exception e) 
		{
			_log.error("Error while getting NitroExpandoColumn: " + columnName + " ,error: "+ e.getMessage());
			
			if(nitroExpandoColumn == null)
			{
				try 
				{
					nitroExpandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), 
							columnName, ExpandoColumnConstants.STRING);
				} 
				catch (Exception e1) 
				{
					_log.error("Error while adding NitroExpandoColumn: " + columnName + " ,error: "+ e1.getMessage());
				}
			}
		}
		finally
		{
			if(nitroExpandoColumn == null)
			{
				_log.error("System is unable to get/create NitroExpandoColumn: " + columnName + " !!!");
			}
		}
		
		return nitroExpandoColumn;
	}
	
	
	/**
	 * Based on given parameters, adds ExpandoValue
	 * 
	 * @param companyId
	 * @param className
	 * @param expandoTableName
	 * @param expandoColumnName
	 * @param classPK
	 * @param data
	 */
	public static void addExpandoValue(long companyId, String className, String expandoTableName,
			String expandoColumnName, long classPK, String data)
	{
		try 
		{
			ExpandoValueLocalServiceUtil.addValue(companyId, className, 
					expandoTableName, expandoColumnName, classPK, data);
		}
		catch (Exception e) 
		{
			_log.error("Error while adding expando attribute value, error: " + e.getMessage(), e);
		}
	}
	
	
	/**
	 * Based on given parameters, retrieves Expando Value
	 * 
	 * @param companyId
	 * @param className
	 * @param expandoTableName
	 * @param expandoColumnName
	 * @param classPK
	 * @param data
	 * @return Object
	 */
	public static String getExpandoValue(long companyId, String className, String expandoTableName,
			String expandoColumnName, long classPK)
	{
		String data = ""; 
				
		try 
		{
			Object attributeVale = ExpandoValueLocalServiceUtil.getData(companyId, className,
					expandoTableName, expandoColumnName, classPK);
			
			if(attributeVale != null)
			{
				data = attributeVale.toString();
			}
		}
		catch (Exception e) 
		{
			_log.error("Error while getting expando attribute value, error: " + e.getMessage(), e);
		}
		
		return data;
	}
	

	/**
	 * Based on parameters, updates to NEW attribute value
	 * 
	 * @TODO: This can be dropped eventually as every time the whole attribute value can be overridden based on Nitro's response.
	 * 
	 * @param currentAttributeValue
	 * @param attributeMap
	 * @return String
	 */
	public static String updateNitroAttributesString(String currentAttributeValue, Map<String, String> attributeMap)
	{
		String serializedString = StringPool.BLANK;
		
		if(currentAttributeValue.contains(StringPool.COMMA))
		{
			String[] keyValuePairArray = currentAttributeValue.split(StringPool.COMMA);
			
			if(keyValuePairArray != null && keyValuePairArray.length > 0)
			{
				for(String keyValuePair : keyValuePairArray)
				{
					if(keyValuePair.contains(StringPool.EQUAL))
					{
						String[] attributeArray = keyValuePair.split(StringPool.EQUAL);
						
						if(attributeArray != null && attributeArray.length > 2)
						{
							if(attributeMap.containsKey(attributeArray[0])){
								
							}
						}
					}
				}
			}
		}
		
		return serializedString;
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(MSSHookUtil.class);
	
}
