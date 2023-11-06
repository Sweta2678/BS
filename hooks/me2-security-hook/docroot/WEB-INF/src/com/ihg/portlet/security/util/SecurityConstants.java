package com.ihg.portlet.security.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface SecurityConstants {

	/*
	 * tag names
	 */
	 public static final String MERLIN_TAG_NAME = "merlin";
	 public static final String TEAMSPACE_TAG_NAME = "teamspace";
	 public static final String INITIATIVE_TAG_NAME = "initiative";
	 public static final String CONFERENCE_TAG_NAME = "conference";
	 public static final String MERLIN_PUBLISHER_TAG_NAME = "merlin-publisher";
	 
	 public static final String [] COMMUNITY_TAGS  = {INITIATIVE_TAG_NAME,CONFERENCE_TAG_NAME,MERLIN_PUBLISHER_TAG_NAME};
	 
	 public static final List<String>  COMMUNITY_TAGS_LIST= new ArrayList<String>(Arrays.asList(COMMUNITY_TAGS));
	 
	 public static final String [] COMMUNITY_TAGS_FOR_GROUP  = {MERLIN_TAG_NAME,TEAMSPACE_TAG_NAME,INITIATIVE_TAG_NAME,CONFERENCE_TAG_NAME};
         
         public static final List<String>  COMMUNITY_TAGS_FOR_GROUP_LIST= new ArrayList<String>(Arrays.asList(COMMUNITY_TAGS_FOR_GROUP));
	 
	 /*
	  * Custom Fields
	  */
	 public static final String DEPARTMENT_CUSTOM_FIELD = "Department";
	 public static final String ABOUT_IHG_CUSTOM_FIELD = "About-IHG";
	 
	 /*
	  * Category names
	  */
	 
	 public static final String DEFAULT_CATEGORY_NAME = "Corporate And Temporary Contractors Only";
	 public static final String CORPORATE_CATEGORY_NAME = "User Type Corporate Only";
	 public static final String BRAND_CATEGORY_NAME = "Brands";
	 public static final String REGION_CATEGORY_NAME = "Regions";
	 public static final String USERTYPE_CATEGORY_NAME = "UserType";
	 
	 public static final String [] CATEGORY_NAMES  = {BRAND_CATEGORY_NAME,REGION_CATEGORY_NAME,USERTYPE_CATEGORY_NAME};
	 public static final List<String>  CATEGORY_NAMES_LIST = new ArrayList<String>(Arrays.asList(CATEGORY_NAMES));
	 /*
	  * Role names
	  */
	 
	 public static final String DEFAULT_ROLE_NAME = "User Type Corp and Temp";
		 
	 /*
	  * Community names
	  */
	 
	 public static final String NEWSROOM_COMMUNITY_NAME = "Newsroom";
	 public static final String OUR_PEOPLE = "Our People";
	 
	public static final String GLOBAL_CATEGORY_VOCABULARY_NAME = "Teamspaces";
	 	
	
	public static final String CORPORATE_AND_TEMP_CONTRACTORS_CAT_NAME = "Corporate And Temporary Contractors Only";
	public static final String CORPORATE_AND_TEMP_CONTRACTORS_ROLE_NAME = "User Type Corp and Temp";
	public static final String FRANCHISE_CAT_NAME = "Franchise Only";
	public static final String FRANCHISE_ROLE_NAME = "User Type Franchise";
	public static final String ORG_CONTENT_PUBLISHER_ROLE_NAME = "IHG Organization Content Publisher";
	public static final String OWNED_AND_MANAGED_CAT_NAME = "Owned Or Managed Only";
	public static final String OWNED_AND_MANAGED_ROLE_NAME = "User Type Owned and Managed";
	public static final String VENDORS_CAT_NAME = "Vendors Only";
	public static final String VENDORS_ROLE_NAME = "User Type Vendor";
	public static final String CORPORATE_CAT_NAME = "User Type Corporate Only";
	public static final String CORPORATE_ROLE_NAME = "User Type Corporate Only";
	
	public static final String IHG_CORP_BRAND_CAT_NAME="IHG Corporate Brand";
}
