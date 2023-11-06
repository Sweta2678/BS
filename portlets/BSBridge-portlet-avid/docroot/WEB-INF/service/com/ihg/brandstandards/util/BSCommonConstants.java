package com.ihg.brandstandards.util;

public final class BSCommonConstants
{
    private BSCommonConstants()
    {
    }
    
    public static final String STD_TYPE_STANDARD = "STD";
    public static final String STD_TYPE_SPEC = "SPEC";
    public static final String STD_TYPE_GDLN = "GDLN";
    public static final String STANDARDS_TRANSLATE_OBJ_TYPE = "STDXLAT";
    public static final String PUBLISH_LOCK_STATUS = "PUBLISH_LOCKED";
    public static final String AVAILABLE_STATUS = "AVAILABLE";
    
    public static final String REGION_GLBL = "GLBL";
    public static final String REGION_AMER = "AMER";
    public static final String REGION_AMEA = "AMEA";
    public static final String REGION_EUROPE = "EURO";
    public static final String REGION_GC = "GC";
    
    public static final String ALL_BRAND = "GL";
    
    public static final String ATTRIBUTE_EMAIL_NOTIFICATION_FAIL = "ATTRIBUTE_EMAIL_NOTIFICATION_FAIL";

    public static final String NOT_APPLICABLE = "N";
    
    public static final String STANDARD_DEFAULT_STATUS_CD = "ILOEC";
    
    public static final String JOB_STATUS_NEW = "NEW";
    public static final String JOB_STATUS_INPROGRESS = "IN_PROGRESS";
    public static final String JOB_STATUS_SUCCESS = "SUCCESS";
    public static final String JOB_STATUS_FAILED = "FAILED";
    
    public static final String ELEMENT_MODULE_OBSM = "OBSM";
    public static final String ELEMENT_MODULE_PDF = "PDF";
    public static final String ELEMENT_MODULE_BRIDGE = "BRIDGE";

    public static final String PUBLISH_ENV_BRIDGE = "BRIDGE";
    public static final String PUBLISH_ENV_STAGING = "STAGING";
    public static final String PUBLISH_ENV_PROD = "PRODUCTION";
    
    /** Constants related Bridge Application -START */
    public static final String BRIDGE_PUBLISH_STATUS_CD = "PRESTAGE";
    public static final String BRIDGE_STATUS_CD_NEW = "NEW";
    public static final String BRIDGE_STATUS_CD_DEL = "DELETE";
    public static final String BRIDGE_STATUS_CD_UPD = "UPDATE";
    public static final String BRIDGE_STATUS_CD_NCH = "NO_CHANGE";
    public static final String BRIDGE_STATUS_CD_SEL = "SELECT";
    /** Constants related Bridge Application - END*/
    
    //CR 121 Countries constants for ERR_NOTIFICATION TABLE 
    public static final String BRIDGE_MESSAGE_DESTINATION = "brandstandards/asyncbus/message/destination";
    public static final String ERR_NOTIFICATION_COMPONENT_CMS_BRIDGE_SYNC = "CMS_BRIDGE_SYNC";
    public static final String ERR_NOTIFICATION_COMPONENT_BRIDGE_NOTIFICATION = "BRIDGE_NOTIFICATION";
    public static final String MESSAGE_REQ_TYPE_CMS_BRIDGE_SYNC = "MSG_CMS_BRIDGE_SYNC";
    public static final String REQ_TYPE_PARAM = "REQ_TYPE_PARAM";
    public static final String REQ_TYPE_UPD_COUNTRIES = "REQ_TYPE_UPD_COUNTRIES";
    public static final String REQ_TYPE_UPD_STATE = "REQ_TYPE_UPD_STATE";
    public static final String REQ_TYPE_UPD_COUNTRIES_AND_STATE = "REQ_TYPE_UPD_COUNTRIES_AND_STATE";
    public static final String REQ_SEVERITY_HIGH = "H";
    
    public static final String ERR_NOTIFICATION_STATUS_NEW = "NEW";
    public static final String ERR_NOTIFICATION_STATUS_IN_PROGRESS = "IN_PROGRESS";
    public static final String ERR_NOTIFICATION_STATUS_COMPLETE = "COMPLETE";
    public static final String ERR_NOTIFICATION_STATUS_SUCCESS = "SUCCESS";
    public static final String ERR_NOTIFICATION_STATUS_FAILED = "FAILED";
    public static final String ERR_NOTIFICATION_STATUS_DELETE = "DELETE";
}
