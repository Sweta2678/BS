package com.ihg.security.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PatelHet
 *
 */
public interface SecurityConstants
{
     static final String MERLIN_TAG_NAME = "merlin";
     static final String INITIATIVE_TAG_NAME = "initiative";
     static final String CONFERENCE_TAG_NAME = "conference";
    
     static final String VOCABULARY_NAME = "Teamspaces";
     static final String BRAND_CATEGORY_NAME = "Brands";
     static final String REGION_CATEGORY_NAME = "Regions";
     static final String USER_TYPE_CATEGORY_NAME = "UserType";
     
     static final String [] DEFAULT_GLOBAL_CATEGORY={"Corporate And Temporary Contractors Only"};
     
     static final String AUDIENCE_FIELD="//root/dynamic-element[@name='audience']/dynamic-content/option";
     
     static final String[] DYNAMIC_FIELDS = {AUDIENCE_FIELD};
    
     static final String [] CATEGORY_NAMES  = {BRAND_CATEGORY_NAME,REGION_CATEGORY_NAME,USER_TYPE_CATEGORY_NAME};
     
     static final List<String>  CATEGORY_NAMES_LIST = new ArrayList<String>(Arrays.asList(CATEGORY_NAMES));
    
     static final String [] COMMUNITY_TAGS  = {MERLIN_TAG_NAME,INITIATIVE_TAG_NAME,CONFERENCE_TAG_NAME};
    
     static final List<String>  COMMUNITY_TAGS_LIST= new ArrayList<String>(Arrays.asList(COMMUNITY_TAGS));
     
     static final String[] NEWSROOM_STRUCTURE_IDS= {"AWARDS","EVENTS","FEATURES","LATEST_STORIES","MOVERS_&_SHAKERS","PRESS_RELEASE","RESULTS","SUBMIT_YOUR_STORY"};
     
     static final List<String>  NEWSROOM_STRUCTURE_IDS_LIST= new ArrayList<String>(Arrays.asList(NEWSROOM_STRUCTURE_IDS));
     
     static final String[] APPLICATION_STRUCTURE_IDS= {"APPLICATION"};
     
     static final List<String>  APPLICATION_STRUCTURE_IDS_LIST= new ArrayList<String>(Arrays.asList(APPLICATION_STRUCTURE_IDS));
     
     static final String[] DEPARTMENT_STRUCTURE_IDS= {"HOT_TOPICS_DETAILS"};
     
     static final List<String>  DEPARTMENT_STRUCTURE_IDS_LIST= new ArrayList<String>(Arrays.asList(DEPARTMENT_STRUCTURE_IDS));
     
     static final String[] INITIATIVES_STRUCTURE_IDS= {"ALL_BULLETINS_DETAILS"};
     
     static final List<String>  INITIATIVES_STRUCTURE_IDS_LIST= new ArrayList<String>(Arrays.asList(INITIATIVES_STRUCTURE_IDS));
     
     static final String[] CONF_STRUCTURE_IDS= {"CONF_AGENDA_CONTENT","CONF_ALL_PHOTOS","CONF_AWARD","CONF_AWARDS_RICHTEXT","CONF_AWARD_SIDE_INFO_BOX",
         "CONF_CONTACT_US","CONF_EVENT_DETAILS","CONF_EVENT_SESSION","CONF_HEADER","CONF_LIVE_FEED","CONF_NEWS","CONF_PAGE_HEADER",
         "CONF_PARTNER_DETAIL","CONF_PHOTO_CAROUSEL","CONF_POSTEVENT_RICHTEXT","CONF_PRESS_RELEASES","CONF_REGISTRATION_IMAGE",
         "CONF_REGISTRATION_RICHTEXT","CONF_SIDE_INFO_BOX","CONF_SPEAKERSBIO","ONF_USEFUL_LINKS","CONF_VIDEO","CONF_VIDEO_COMING_SOON",
         "CONF_VIDEO_LIBRARY"};
     
     static final List<String>  CONF_STRUCTURE_IDS_LIST= new ArrayList<String>(Arrays.asList(CONF_STRUCTURE_IDS));
     
     static final String EXPANDO_REGION="Region";
     
     static final String OUR_PEOPLE = "Our People";
     
     
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
     
}
