package com.ihg.me2.indexpostprocessor;

import com.liferay.portal.kernel.util.StringPool;
/***
 * 
 * @author ketan.savaliya
 *
 */
public interface CustomIndexerConstant {
	/**
	 * META DATA FIELD
	 */
	String META_DATA_CONTENT_SOURCE = "CONTENT_SOURCE";
	String META_DATA_CONTENT_TYPE = "CONTENT_TYPE";
	String META_DATA_CONTENT_LINK = "CONTENT_LINK";
	String META_DATA_CONTENT_PARENT_NAME = "CONTENT_PARENT_NAME";
	String META_DATA_CONTENT_PARENT_LINK = "CONTENT_PARENT_LINK";
	String META_DATA_RESOURCE_TYPE = "RESOURCE_TYPE";
	String META_DATA_PARENT_CONTENT_TYPE = "PARENT_CONTENT_TYPE";
	/**
	 * Constance for string literal
	 */
	String WEB =StringPool.SLASH +"web";
	String HOME = StringPool.SLASH +"home";
	String GROUP= StringPool.SLASH +"group";
	String ARTICLE_ID = StringPool.SLASH + "article?id=";
	
	/**
	 * Bookmark link
	 */
	String BOOKMARK_LINK = StringPool.SLASH + "c" + StringPool.SLASH + "bookmarks" + StringPool.SLASH +"open_entry?entryId=";
	/**
	 * DLFile path
	 */
	String DOCUMENT =StringPool.SLASH + "documents" +StringPool.SLASH;
	
	
	/**
	 * Constant for value of the the CONTENT_LINK,CONTENT_PARENT_NAME,CONTENT_PARENT_LINK
	 */
	String APPLICATIONS_ARTICLE_URL = "/web/applications/article?id=";
	String HOTEL_SOLUTION_ARTICLE_URL = "/web/hotel-solutions/solution-detail?solution-uuid=";
	String NEWSROOM_ARTICLE_URL = "/web/news/article?id=";
	
	String ORGANIZATION_PARENT = "Departments";
	String ORGANIZATION_PARENT_LINK = "/web/depts/home/";
	
	String USER_CONTENT_LINK ="/web/peopledir/detail?id=";
	String USER_PARENT ="People Directory";
	String USER_PARENT_LINK ="/web/peopledir/home/";
	
	String NEWS_PARENT_NAME="Newsroom";
	String NEWS_PARENT_LINK="/web/news/home/";
	
	String APPS_PARENT_NAME="Applications";
	String APPS_PARENT_LINK="/web/applications/home/";
	
	String MERLIN_PARENT_NAME="Merlin";
	String MERLIN_PARENT_LINK="/web/merlin/home/";

	
	/**
	 *  document type based on extension
	 */
	
	String[] DOC = {"doc", "docx", "odt"};
	String[] PPT = {"ppt", "pptx"};
	String[] XLS = {"xls", "xlsx"};
	String[] PDF = {"pdf"};
	String[] IMG = {"jpg", "png", "jpeg", "gif", "bmp"};
	String[] VID = {"mp4", "flv", "mv", "swf"};
	String[] AUD  = {"wma", "mp3"};
	
	String TAG_SEPARATOR=",";
	
	/* Constants for Generic Keys from Portal-ext.properties*/
	String RESOURCE_CONTENT_TYPE="resource-content-type-";
	String LINK_CONTENT_TYPE="link-content-type-";
	String WC_CONTENT_TYPE="wc-content-type-";
	String PARENT_CONTENT_TYPE="parent-content-type-";
	String PARENT_LINK="parent-content-link-";
	
}
