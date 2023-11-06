package com.ihg.me2.framework.custom.security.cache;

import java.util.ResourceBundle;

import com.ihg.me2.framework.custom.security.utils.GlobalConstants;
import com.ihg.me2.utils.session.MerlinCacheConstants;

/**
 * All constants
 * @author Hiren Patel
 *
 */
public interface MerlinCacheSecurityConstants extends MerlinCacheConstants
{

	public static final String SESSION_DELIMETER = ";";
	
	public static final ResourceBundle SESSION_MAPPING_BUNDLE = ResourceBundle.getBundle(GlobalConstants.MAPPING_FILE);
	public static final ResourceBundle SESSION_CONFIG =  ResourceBundle.getBundle(GlobalConstants.SESSION_CONF_MAPPING_FILE);
	public static final ResourceBundle COLUMN_TO_SESSION_BUNDLE = ResourceBundle.getBundle(GlobalConstants.COL_SESSION_CONF_MAPPING_FILE);
	
	public static final String BASE_ATTRIBUTE = "BASE_ATTRIBUTE";
	public static final String SECURITY_ID_VALUE_LOOKUP = "SECURITY_ID_VALUE_LOOKUP";
	public static final String CURRENT_ATTRIBUTE = "CURRENT_ATTRIBUTE";
	public static final String PRIMARYLOCATION = "PRIMARYLOCATION";	
	
	public static final String ALLOWED_USER_TYPES = "ALLOWED_USER_TYPES";
	public static final String HTLCD_REQ_PARAM = "HTLCD_REQ_PARAM";
	
	// Hard coded value. Should be exactly as it is in SessionMapping.properties
	public static final String ACCESS_LEVEL = "ACCLVL"; 
	public static final String USR_TYP = "USRTYP";
	
	//Hard coded value. Sould be exactly as it is SecurityAttributes.xml
	public static final String CTRY = "CTRY";
	public static final String STATE = "STATE";
	public static final String RGN_CTRY = "RGN_CTRY";
	public static final String BRAND = "BRND";
	public static final String CHAIN_BRAND = "CHAIN_BRAND";
	
	public static final String CTRY_CODE_US = "US";
	public static final String CTRY_CODE_CA = "CA";
	
}
