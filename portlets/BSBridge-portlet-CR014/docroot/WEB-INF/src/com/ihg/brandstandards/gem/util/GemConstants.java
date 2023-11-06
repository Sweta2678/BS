package com.ihg.brandstandards.gem.util;

import java.util.Map;

import com.ihg.me2.utils.session.MerlinCache;

public final class GemConstants {
	
	/** Constants for Upload Template **/
	
	public static final String TYPE_UPLOAD_TEMPLATE = "uploadTemplate";
	public static final String TEMPLATE_TYPE_SA = "SA";
	public static final String TEMPLATE_TYPE_SE = "SE";
	public static final String TEMPLATE_TYPE_WAIVER = "WR";
	public static final String UPLOAD_TEMPLATE_SHEET_NAME = "Template";
	public static final String WAIVER_TEMPLATE_LABEL = "Waiver";
	public static final String GEM_DL_FOLDER = "GEM Templates";
	
	public static final String CMS_LOOKUP_CATEGORY_IDS="419, 412";
	public static final String JOB_TYPE_COUNTRY_GROUP = "COUNTRY_GROUP";
	public static final String GEM_ENVIRONMENT = "GEM";
	public static final String GEM_MESSAGE_DESTINATION = "liferay/gem/asyncbus/message/destination";
	public static final String TEMPLATE_COLUMN_ITEM_TEXT = "Item Text";
	public static final String TEMPLATE_COLUMN_TRIGGER = "Ans 1 Trigger #";
	public static final String GEM_TEMPLATE_SEQUECNE = "gem_template_id_seq";
	public static final String GEM_TEMPLATE_COLUMN_SEQUECNE = "gem_template_col_id_seq";
	public static final String GEM_TEMPLATE_VALUE_SEQUECNE = "gem_template_val_id_seq";
	public static final String GEM_TEMPLATE_REF_SEQUECNE = "gem_pub_ref_template_id_seq";
	/*** Notification Message **/
	public static final String SA_NOTIFICATION_MESSAGE = "SA Unique country group generation process is in progress.";
	public static final String SE_NOTIFICATION_MESSAGE = "SE Unique country group generation process is in progress.";
	public static final String WAIVER_NOTIFICATION_MESSAGE = "Waiver Unique country group generation process is in progress.";
	public static final String BRIDGE_NOTIFICATION_MESSAGE = "Unique country group generation process is in progress.";
	public static final String NOTIFICATION_SEVERITY = "H";
	public static final String UNIQUE_GROUP_PDF_NOTIFICATION = "An email with a link to your Report will be sent to you once the Report has been generated.";
	public static final String BLANK_RECORD_VAL = "BLANK";
	/*** End  **/

	/**** Supporting Material Messages ****/
	public static final String SUPPORTING_MATERIAL = "Supporting Material";
	public static final String DOWNLOAD_DOCUMENT = "Download";
	public static final String DOWNLOAD_MESSAGE = "Request for zip file submitted, a link will be emailed to you when complete. Please check your email for further details.";
	public static final String CLOSE_MODAL_WINDOW = "Close";
	public static final String HELP_BUTTON = "Help";
	public static final String HELP_MESSAGE = "We provide supporting material to help you deliver our standards consistently to our guests";
	public static final String LINK_SECTION = "Links";
	public static final String NEW_STATUS = "New";
	public static final String UPDATE_STATUS = "Update";
	/**  END  **/
	public static final String QLFORM_EXCLUDE_CATEGORIES = "Pre-Walk Through,Finalize";
	public static final String QL_FORM_DEFAULT_DUE_DATE = "01 Month";
	public static final String TRIGGER_QUESTION_NOT_REQUIRE = "Not Required";
	public static final String SA_REPORT_TYPE = "SA";
	public static final String SE_REPORT_TYPE = "SE";
	public static final String WAIVER_REPORT_TYPE = "WR";
	public static Map<String, Object> SUB_BRAND_DETAILS = null;
	public static final String GEM_ADMIN_ROLE = "BRND_STND_GEM_ADMIN";
	
	public static final String MANUAL_TYPE_BUILD = "BUILD";
    public static final String MANUAL_TYPE_OPERATE = "OPERATE";
    public static final String MANUAL_TYPE_BUILD_OPERATE = "BUILD_OPERATE";
    public static final String MANUAL_TYPE_FULL_BUILD_OPERATE = "FULL_BUILD_OPERATE";

    public static final int MANUAL_TYPE_ID_BUILD = 257;
    public static final int MANUAL_TYPE_ID_OPERATE = 258;
    public static final String PRE_STAGING_ENVIRONMENT = "BRIDGE";    
    public static final String SESN_ATR_STD_LIST = "listOfStdInSesn";

	static {
		if (SUB_BRAND_DETAILS == null) {
			SUB_BRAND_DETAILS = (Map<String, Object>) MerlinCache.getCacheData("CHAIN_BRAND");
		}
	}
	
}
