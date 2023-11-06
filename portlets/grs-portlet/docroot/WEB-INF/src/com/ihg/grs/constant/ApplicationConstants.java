
package com.ihg.grs.constant;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.portlet.PortletProps;

/**
 * Constant class for Application Portlet.
 * 
 * @author nakul.patel
 */
public final class ApplicationConstants
{

	/**
	 * private constructor for ApplicationConstants.
	 */
	private ApplicationConstants()
	{

	}

	// Article Listing Portlet
	public static final String PREFERECES_SET = "prefStructureKey";
	public static final String STRUCTURE_KEY = "structureKey";
	public static final String CATEGORY_ID = "categoryID";
	public static final String GLOBAL_CATEGORY_ID = "glblCategoryID";
	public static final String ARTICLE_PER_PAGE = "articlePerPage";
	public static final String PREFERECES_ARTICLE_PER_PAGE = "prefArticlePerPage";

	public static final String ARTICLE_DETAILS_DATE_FORMAT = "dd MMM yyyy";
	public static final String ARTICLE_TITLE = "Article_Title";
	public static final String ARTICLE_MAIN_PHOTO = "Article_Main_Photo";
	public static final String ARTICLE_MAIN_VIDEO = "Article_Main_Video";
	public static final String ARTICLE_CAPTION = "Article_Caption";
	public static final String ARTICLE_DESCRTIPTION = "Article_Description";
	public static final String ASSET_LIBRARY_SEARCH_RESULT = "Asset Library";

	public static final String[] DYNAMIC_ARTICLE_FIELDS = {
		ARTICLE_TITLE, ARTICLE_MAIN_PHOTO, ARTICLE_MAIN_VIDEO, ARTICLE_CAPTION, ARTICLE_DESCRTIPTION
	};

	public static final String ARTICLE_INFO_LIST = "articleList";
	public static final String PAGE_NAME_ARTICLE_LANDING = "Article Landing";
	public static final String PAGE_NAME_ARTICLE_DETAIL = "Article Detail";
	public static final String PAGE_NAME_VIDEO_DETAIL = "Video Detail";
	public static final int ARTICLE_LISTING_DESCRIPTION_LENGTH = GetterUtil.getInteger(PortletProps.get("article-description-length"), 200);
	public static final int ARTICLE_LISTING_START = GetterUtil.getInteger(PortletProps.get("article-listing-record-start"), 0);
	public static final int ARTICLE_LISTING_RECORDS_PER_PAGE = GetterUtil.getInteger(PortletProps.get("article-listing-records-per-page"), 10);
	public static final String ARTICLE_LISTING_CURR_PAGE = "pageno";
	public static final String ARTICLE_LISTING_TOTAL_PAGE = "totalPage";
	public static final String DEFAULT_ARTICLE_LANDING_IMAGE_URLS = "/grs-theme/images/main.jpg";

	public static final String ARTICLE_LISTING_DEFAULT_SORT_ORDER = "customDisplayDate_sortable";
	public static final String ARTICAL_IMAGE = "image";
	public static final String ARTICAL_VIDEO = "video";

	// Top picks portlet
	public static final String TOP_PICKS_ARTICLE_IDS = "articleIds";
	public static final String TOP_PICKS_PREF_ARTICLE_IDS = "prefArticleIds";

	public static final int TOP_PICKS_DESCRIPTION_LENGTH = GetterUtil.getInteger(PortletProps.get("latest-article-description-length"), 80);
	public static final int DISCUSSION_DESCRIPTION_LENGTH = GetterUtil.getInteger(PortletProps.get("discussion-description-length"), 200);

	// Article Detail

	public static final String ARTICLE_DETAIL_ARTICLE_ID = "id";
	public static final int ARTICAL_DETAIL_TITLE_LENGTH = GetterUtil.getInteger(PortletProps.get("article-title-length"), 60);
	public static final String DEFAULT_USER_IMAGE_URLS = "/grs-theme/images/userdefault.png";
	public static final String COMMENT_VISIBILITY = "visibility";
	public static final String PREF_COMMENT_VISIBILITY = "preftVisibility";
	public static final String ARTICLE_ID = "articleId";
	public static final String PREF_ARTICLE_ID = "prefArticleId";
	public static final String COMMENT_POLICY_WEBCONTENT_ID = "webcontentId";
	public static final String PREF_COMMENT_POLICY_WEBCONTENT_ID = "prefWebcontentId";
	public static final String COMMENT_DATE_FORMAT = "dd MMM yyyy h:mm a";
	public static final String COMMENT_DATE_TIMEZONE = "America/New_York";
	public static final String COMMENT_TIMEZONE = "EST";
	public static final String NO_OF_DISPLAY_COMMENT = "loadMoreComment";
	public static final String PREF_NO_OF_DISPLAY_COMMENT = "prefLoadMoreComment";

	// Latest Article
	public static final String NO_OF_LATEST_ARTICLE = "noOfArticle";
	public static final String PREF_NO_OF_LATEST_ARTICLE = "preNoOfArticle";

	// Homepage Carousel

	public static final String NO_OF_ARTICLES = "noOfArticles";
	public static final String CACHE_TIME = "cacheTime";
	public static final String COMMEN = "structureKey";

	// Blog Article
	public static final String PAGE_NAME_BLOG_LANDING = "Blog";
	public static final String PAGE_NAME_BLOG_DETAIL = "Blog Detail";

	public static final String BLOG_TITLE = "Blog_Title";
	public static final String BLOG_MAIN_PHOTO = "Blog_Main_Photo";
	public static final String BLOG_MAIN_VIDEO = "Blog_Main_Video";
	public static final String BLOG_CAPTION = "Blog_Caption";
	public static final String BLOG_DESCRTIPTION = "Blog_Description";
	
	public static final String[] DYNAMIC_BLOG_FIELDS = {
		BLOG_TITLE, BLOG_MAIN_PHOTO, BLOG_MAIN_VIDEO, BLOG_CAPTION, BLOG_DESCRTIPTION
	};
	
	public static final int BLOG_LISTING_DESCRIPTION_LENGTH = GetterUtil.getInteger(PortletProps.get("blog-article-description-length"), 350);

	public static final String ARTICLE_STRUCTURE_KEY = "GRS_ARTICLE";
	public static final String VIDEO_STRUCTURE_KEY = "GRS_VIDEO";
	public static final String BLOG_STRUCTURE_KEY = "GRS_BLOG";
	public static final String ROADMAP_STRUCTURE_KEY = "GRS_ROADMAP";
	public static final String ABOUT_GRS_STRUCTURE_KEY = "GRS_ABOUT";
	public static final String FAQ_STRUCTURE_KEY = "GRS_FAQ";	
	
	// About
	public static final String PAGE_NAME_ABOUT_GRS_DETAIL = "About";

	// FAQ
	public static final String FAQ_QUESTION = "Question";
	public static final String FAQ_ANSWER = "Answer";

	public static final String[] DYNAMIC_FAQ_FIELDS = {
		FAQ_QUESTION, FAQ_ANSWER
	};

	public static final String USER_CUSTOM_ATTRIBUTE_BUSINESS_JOB_TITLE = "Business JobTitle";

	public static final String PAGE_NAME_DIRECTORY_PUBLISHING = "Directory Publishing";
	public static final String PAGE_NAME_DIRECTORY = "Directory";

	// Site Search Results
	public static final String DEFAULT_SEARCH_RESULT_IMAGE_URLS = "/grs-theme/images/document-img/";
	public static final String IMAGE_EXTENSION = ".png";
	public static final int SITE_SEARCH_RESULTS__DESCRIPTION_LENGTH = GetterUtil.getInteger(PortletProps.get("site-search-result-description-length"), 200);
	public static final String SITE_SEARCH_RESULTS_PER_PAGE = "recordsPerPage";
	public static final String PREF_SITE_SEARCH_RESULTS_PER_PAGE = "prefRecordsPerPage";
	public static final String PAGE_NAME_SITE_SEARCH_RESULTS = "Search Results";
	public static final String PAGE_NAME_DISCUSSIONS = "Discussions";
	public static final String PAGE_NAME_FAQ = "FAQ";
	public static final String DOWNLOAD_PATH = "/documents/";
	public static final String ASSET_CATEGORY_ARCHIVES = "archived";
	public static final String SITE_SEARCH_STRUCTURE_KEYS = "structureKeys";
	public static final String SITE_SEARCH_PREF_STRUCTURE_KEYS = "prefStructureKeys";
	public static final String SITE_SEARCH_ARTICLE_TYPE = "article";
	public static final String SITE_SEARCH_BLOG_TYPE = "blog";
	public static final String SITE_SEARCH_FAQ_TYPE = "faq";
	public static final String SEARCH_TITLE = "customTitle_sortable"; // title //customTitle_sortable
	public static final String SEARCH_LAST_MODIFIED_DATE = "customModified_sortable"; // modified// customModified_sortable

	// Notifications
	public static final String NOTIFICATION_PAGE_URL = "/notifications";
	public static final String NOTIFICATION_MAX_RECORDS = "notificationMaxRecords";
	public static final String PREF_NOTIFICATION_MAX_RECORDS = "prefNotificationMaxRecords";
	
	//Hote Implementation Home Page
	public static final String GRS_COMM_GROUPID = "groupid";
	public static final String PREF_GRS_COMM_GROUPID = "prefgroupid";
	public static final String GRS_COMM_CATEGORYID_UNDERSTAND_GRS = "grsCommCategoryIDUnderstandTheGRS";
	public static final String PREF_GRS_COMM_CATEGORYID_UNDERSTAND_GRS = "prefgrsCommCategoryIDUnderstandTheGRS";
	public static final String GRS_COMM_CATEGORYID_GET_READY = "grsCommCategoryIDGetReady";
	public static final String PREF_GRS_COMM_CATEGORYID_GET_READY = "prefgrsCommCategoryIDGetReady";
	public static final String GRS_HOTELIMP_CATEGORYID_UNDERSTAND_GRS = "grsHotelImpCategoryIDUnderstandTheGRS";
	public static final String PREF_HOTELIMP_COMM_CATEGORYID_UNDERSTAND_GRS = "prefgrsHotelImpCategoryIDUnderstandTheGRS";
	public static final String GRS_HOTELIMP_CATEGORYID_GET_READY = "grsHotelImpCategoryIDGetReady";
	public static final String PREF_HOTELIMP_COMM_CATEGORYID_GET_READY = "prefgrsHotelImpCategoryIDGetReady";
	public static final String REGION_PORTAL_WEB_CONTENT_ID = "regionPortalWebContentId";
	public static final String PREF_REGION_PORTAL_WEB_CONTENT_ID = "prefregionPortalWebContentId";
	public static final String RECORDS_PER_PAGE = "recordsPerPage";
	public static final String PREFERECES_RECORDS_PER_PAGE = "prefRecordsPerPage";
	public static final String GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID = "grsImpHomePageDetailsWebConentId";
	public static final String PREFERECES_GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID = "prefGrsImpHomePageDetailsWebConentId";
	
	/*public static final String GRS_HOTEL_IMPL_UNDERSTAND_THE_GRS = "/grs-theme/images/understand.png";
	public static final String GRS_HOTEL_IMPL_GET_READY = "/grs-theme/images/getready.png";
	public static final String GRS_HOTEL_IMPL_REGIONAL_PORTAL = "/grs-theme/images/region_portal.png";*/
	
	public static final String GRS_HOTEL_IMPL_ABOUT_CONCERTO ="/grs-theme/images/AboutConcerto2.png";
	public static final String GRS_HOTEL_IMPL_GETTING_READY ="/grs-theme/images/getting_ready.png";
	public static final String GRS_HOTEL_IMPL_REGION_TOOLS_IMPL ="/grs-theme/images/Region_tools_resources.png";
	
	public static final String HOTEL_IMP_MAIN_TITLE = "Title";
	public static final String HOTEL_IMP_TITLE_1 = "Title_1";
	public static final String HOTEL_IMP_DESCRIPTION_1 = "Description_1";
	public static final String HOTEL_IMP_TITLE_2 = "Title_2";
	public static final String HOTEL_IMP_DESCRIPTION_2 = "Description_2";
	public static final String HOTEL_IMP_TITLE_3 = "Title_3";
	public static final String HOTEL_IMP_IMAGE_1 = "Image_1";
	public static final String HOTEL_IMP_LABEL_1 = "Label_1";
	public static final String HOTEL_IMP_URL_1 = "URL_1";
	public static final String HOTEL_IMP_IMAGE_2 = "Image_2";
	public static final String HOTEL_IMP_LABEL_2 = "Label_2";
	public static final String HOTEL_IMP_URL_2 = "URL_2";
	public static final String HOTEL_IMP_IMAGE_3 = "Image_3";
	public static final String HOTEL_IMP_LABEL_3 = "Label_3";
	public static final String HOTEL_IMP_URL_3 = "URL_3";
	public static final String HOTEL_IMP_IMAGE_4 = "Image_4";
	public static final String HOTEL_IMP_LABEL_4 = "Label_4";
	public static final String HOTEL_IMP_URL_4 = "URL_4";
	public static final String HOTEL_IMP_TITLE_5 = "Title_5";
	public static final String HOTEL_IMP_DESCRIPTION_5 = "Description_5";

	public static final String[] DYNAMIC_HOME_PAGE_FIELDS = {
		HOTEL_IMP_MAIN_TITLE, HOTEL_IMP_TITLE_1, HOTEL_IMP_DESCRIPTION_1, HOTEL_IMP_TITLE_2, HOTEL_IMP_DESCRIPTION_2, HOTEL_IMP_TITLE_3, HOTEL_IMP_IMAGE_1,
		HOTEL_IMP_LABEL_1, HOTEL_IMP_URL_1, HOTEL_IMP_IMAGE_2, HOTEL_IMP_LABEL_2, HOTEL_IMP_URL_2, HOTEL_IMP_IMAGE_3, HOTEL_IMP_LABEL_3, HOTEL_IMP_URL_3,
		HOTEL_IMP_IMAGE_4, HOTEL_IMP_LABEL_4, HOTEL_IMP_URL_4,HOTEL_IMP_TITLE_5,HOTEL_IMP_DESCRIPTION_5
	};
	
	public static final String SITE_GRS_HOTEL_IMPLEMENTATION = GetterUtil.getString(PortletProps.get("grs.hotel.implentation.site"), StringPool.BLANK);
	
}
