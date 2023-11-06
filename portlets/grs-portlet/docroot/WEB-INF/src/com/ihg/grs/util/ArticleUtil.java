
package com.ihg.grs.util;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.bean.MessagePojo;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.mail.GenericMail;
import com.ihg.me2.core.bean.ArticleInfo;
import com.ihg.me2.core.service.CoreArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.portlet.ResourceRequest;

/**
 * Utility class of Article.
 */
public final class ArticleUtil
{

	/**
	 *  Define a private constructor. 
	 */
	private ArticleUtil()
	{
	}
	private static final Log LOGGER = LogFactoryUtil.getLog(ArticleUtil.class);

	/**
	 * Converting list of articles into custom article info bean.
	 * 
	 * @param themeDisplay of ThemeDisplay
	 * @param articleList of List<JournalArticle>
	 * @return articleInfoList
	 */
	public static List<ArticleInfoBean> getArticleInfoFromArticleList(ThemeDisplay themeDisplay, List<JournalArticle> articleList)
	{
		LOGGER.info("Buildig Article Info Object from Journal Articles");
		List<ArticleInfoBean> articleInfoList = new ArrayList<ArticleInfoBean>();
		// Prepare List of ArticalInfo to perform sort on different fields

		try
		{
			for (JournalArticle journalArticle : articleList)
			{
				ArticleInfoBean articleInfoBean = new ArticleInfoBean();

				Map<String, String> dataMap = new HashMap<String, String>();

				ArticleInfo articalInfo = CoreArticleLocalServiceUtil.getArticleInfoByJournalArticle(journalArticle);

				articleInfoBean.setArticleId(articalInfo.getArticleId());
				articleInfoBean.setLikeCount(articalInfo.getLikeCount());
				articleInfoBean.setArtical(journalArticle);
				articleInfoBean.setResourcePK(journalArticle.getResourcePrimKey());
				articleInfoBean.setCommentCount(articalInfo.getCommentCount());
				articleInfoBean.setDispDate(articalInfo.getDate());
				articleInfoBean.setStructureType(journalArticle.getStructureId());

				if (journalArticle.getStructureId().equals(ApplicationConstants.BLOG_STRUCTURE_KEY))
				{
					dataMap = XMLUtils.getXMLDynamicData(journalArticle.getContent(), ApplicationConstants.DYNAMIC_BLOG_FIELDS);
					setArticleBlogInfo(articleInfoBean, dataMap);
				}
				else if (journalArticle.getStructureId().equals(ApplicationConstants.ARTICLE_STRUCTURE_KEY) || journalArticle.getStructureId().equals(ApplicationConstants.ROADMAP_STRUCTURE_KEY) ||
					journalArticle.getStructureId().equals(ApplicationConstants.ABOUT_GRS_STRUCTURE_KEY) || journalArticle.getStructureId().equals(ApplicationConstants.VIDEO_STRUCTURE_KEY))
				{
					dataMap = XMLUtils.getXMLDynamicData(journalArticle.getContent(), ApplicationConstants.DYNAMIC_ARTICLE_FIELDS);
					setArticleInfo(articleInfoBean, dataMap);
				}
				else if (journalArticle.getStructureId().equals(ApplicationConstants.FAQ_STRUCTURE_KEY))
				{
					dataMap = XMLUtils.getXMLDynamicData(journalArticle.getContent(), ApplicationConstants.DYNAMIC_FAQ_FIELDS);
					setFAQArticleInfo(articleInfoBean, dataMap);
				}
/*				else if (journalArticle.getStructureId().equals(ApplicationConstants.VIDEO_STRUCTURE_KEY))
				{
					dataMap = XMLUtils.getXMLDynamicData(journalArticle.getContent(), ApplicationConstants.DYNAMIC_VIDEO_FIELDS);
					setArticleVideoInfo(articleInfoBean, dataMap);
				}*/

				LOGGER.debug("================  XML Data Map ==============");
				LOGGER.debug(dataMap);

				articleInfoList.add(articleInfoBean);

			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		return articleInfoList;
	}

	/**
	 * This mehtod will return Article Info values from xmlDataMap.
	 * 
	 * @param articleInfo of ArticleInfoBean
	 * @param xmlDataMap of Map<String, String>
	 */
	private static void setArticleInfo(ArticleInfoBean articleInfo, Map<String, String> xmlDataMap)
	{
		String defaultImage = StringPool.BLANK;
		String defaultvideo = StringPool.BLANK;
		String contentType = ApplicationConstants.ARTICAL_IMAGE;

		String defaultImgUrls = ApplicationConstants.DEFAULT_ARTICLE_LANDING_IMAGE_URLS;

		String imageUrl = xmlDataMap.get(ApplicationConstants.ARTICLE_MAIN_PHOTO);
		String videoUrl = xmlDataMap.get(ApplicationConstants.ARTICLE_MAIN_VIDEO);

		if (Validator.isNotNull(videoUrl))
		{
			defaultvideo = videoUrl;
			contentType = ApplicationConstants.ARTICAL_VIDEO;

		}

		if (Validator.isNotNull(imageUrl))
		{
			defaultImage = imageUrl;
		}
		else
		{
			defaultImage = defaultImgUrls;
		}

		String content = xmlDataMap.get(ApplicationConstants.ARTICLE_DESCRTIPTION);

		articleInfo.setTitle(HtmlUtil.stripHtml(xmlDataMap.get(ApplicationConstants.ARTICLE_TITLE)));
		articleInfo.setShortTitle(StringUtil.shorten(HtmlUtil.stripHtml(xmlDataMap.get(ApplicationConstants.ARTICLE_TITLE)), ApplicationConstants.ARTICAL_DETAIL_TITLE_LENGTH));
		articleInfo.setImageUrl(defaultImage);
		articleInfo.setVideoUrl(defaultvideo);
		articleInfo.setContentType(contentType);
		articleInfo.setCaption(xmlDataMap.get(ApplicationConstants.ARTICLE_CAPTION));
		articleInfo.setShortContent(StringUtil.shorten(HtmlUtil.stripHtml(content), ApplicationConstants.ARTICLE_LISTING_DESCRIPTION_LENGTH));
		articleInfo.setShortDescription(StringUtil.shorten(HtmlUtil.stripHtml(content), ApplicationConstants.TOP_PICKS_DESCRIPTION_LENGTH));
		articleInfo.setFullDescription(content);
	}

	/**
	 * This mehtod will return Article Info values from xmlDataMap.
	 * 
	 * @param articleInfo of ArticleInfoBean
	 * @param xmlDataMap of Map<String, String>
	 */
	private static void setArticleBlogInfo(ArticleInfoBean articleInfo, Map<String, String> xmlDataMap)
	{
		String defaultImage = StringPool.BLANK;
		String defaultvideo = StringPool.BLANK;
		String contentType = ApplicationConstants.ARTICAL_IMAGE;

		String defaultImgUrls = ApplicationConstants.DEFAULT_ARTICLE_LANDING_IMAGE_URLS;

		String imageUrl = xmlDataMap.get(ApplicationConstants.BLOG_MAIN_PHOTO);
		String videoUrl = xmlDataMap.get(ApplicationConstants.BLOG_MAIN_VIDEO);

		if (Validator.isNotNull(videoUrl))
		{
			defaultvideo = videoUrl;
			contentType = ApplicationConstants.ARTICAL_VIDEO;

		}

		if (Validator.isNotNull(imageUrl))
		{
			defaultImage = imageUrl;
		}
		else
		{
			defaultImage = defaultImgUrls;
		}

		String content = xmlDataMap.get(ApplicationConstants.BLOG_DESCRTIPTION);

		articleInfo.setTitle(HtmlUtil.stripHtml(xmlDataMap.get(ApplicationConstants.BLOG_TITLE)));
		articleInfo.setShortTitle(StringUtil.shorten(HtmlUtil.stripHtml(xmlDataMap.get(ApplicationConstants.BLOG_TITLE)), ApplicationConstants.ARTICAL_DETAIL_TITLE_LENGTH));
		articleInfo.setImageUrl(defaultImage);
		articleInfo.setVideoUrl(defaultvideo);
		articleInfo.setContentType(contentType);
		articleInfo.setCaption(xmlDataMap.get(ApplicationConstants.BLOG_CAPTION));
		articleInfo.setShortContent(StringUtil.shorten(HtmlUtil.stripHtml(content), ApplicationConstants.BLOG_LISTING_DESCRIPTION_LENGTH));
		articleInfo.setShortDescription(StringUtil.shorten(HtmlUtil.stripHtml(content), ApplicationConstants.TOP_PICKS_DESCRIPTION_LENGTH));
		articleInfo.setFullDescription(content);
	}

	/**
	 * This mehtod will return FAQ Article Info values from xmlDataMap.
	 * 
	 * @param articleInfo of ArticleInfoBean
	 * @param xmlDataMap of Map<String, String>
	 */
	private static void setFAQArticleInfo(ArticleInfoBean articleInfo, Map<String, String> xmlDataMap)
	{

		articleInfo.setQuestion(xmlDataMap.get(ApplicationConstants.FAQ_QUESTION));
		articleInfo.setAnswer(xmlDataMap.get(ApplicationConstants.FAQ_ANSWER));

	}

	/**
	 * This method give list of comments for given articelId.
	 * 
	 * @param themeDisplay of ThemeDisplay
	 * @param userId This is userid
	 * @param groupId This is gorup id
	 * @param className This is passsing className
	 * @param classPK This is class primary key
	 * @return treeList
	 * @throws PortalException It is thows portletException
	 * @throws SystemException It is thows SystemException
	 */
	public static List<MessagePojo> getArticleCommentsList(ThemeDisplay themeDisplay, long userId, long groupId, String className, long classPK)
		throws PortalException, SystemException
	{
		MBMessage rootMessage = getRootMessage(userId, groupId, className, classPK);
		List<MBMessage> messagesList = getFullCommentsMessageList(userId, groupId, className, classPK);
		List<MessagePojo> treeList = new ArrayList<MessagePojo>();
		for (MBMessage msg : messagesList)
		{
			if (msg.getParentMessageId() == rootMessage.getMessageId())
			{
				MessagePojo msgPojo = new MessagePojo();
				msgPojo.setMessage(msg);
				String preferredName=getPreferredNamebyUserId(msg.getUserId(),true);
				msgPojo.setMessageUserName(preferredName);
				msgPojo.setMessageDate(DateUtil.getFormattedDateEST(msg.getCreateDate(), ApplicationConstants.COMMENT_DATE_FORMAT));
				msgPojo.setImapgePath(getImageUrl(msg.getUserId(), themeDisplay));

				treeList.add(msgPojo);
			}
		}

		return treeList;
	}

	/**
	 * This method give list of comments for given articelId.
	 * 
	 * @param themeDisplay of ThemeDisplay
	 * @param userId This is logged in userID
	 * @param groupId This is passing groupID
	 * @param className This is passing ClassName
	 * @param classPK  This is passing class primary key
	 * @return messagesListSize
	 */
	public static int getCommentCount(ThemeDisplay themeDisplay, long userId, long groupId, String className, long classPK)
	{
		try
		{
			List<MessagePojo> messagesList = getArticleCommentsList(themeDisplay, userId, groupId, className, classPK);
			return messagesList.size();
		}
		catch (PortalException e)
		{
			LOGGER.debug(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.debug(e.getMessage(), e);
		}

		return 0;
	}

	/**
	 * This method gives Root Message.
	 * 
	 * @param userId Logged in userID
	 * @param groupId This is passing groupId
	 * @param className This is passing className
	 * @param classPK  Passing class primary key
	 * @return MBMessage
	 * @throws PortalException It is thows portletException
	 * @throws SystemException It is thows SystemException
	 */
	private static MBMessage getRootMessage(long userId, long groupId, String className, long classPK)
		throws PortalException, SystemException
	{
		MBMessageDisplay messageDisplay =
			MBMessageLocalServiceUtil.getDiscussionMessageDisplay(userId, groupId, className, classPK, WorkflowConstants.STATUS_ANY, PropsUtil.get("discussion.thread.view"));
		MBThread thread = messageDisplay.getThread();
		return MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
	}

	/**
	 * This method gives List<MBMessage>.
	 * 
	 * @param userId This is logged in userID
	 * @param groupId This is gorupId.
	 * @param className Passing ClassName
	 * @param classPK Passing primary key of class
	 * @return List<MBMessage>
	 * @throws PortalException It is thows portletException
	 * @throws SystemException It is thows SystemException
	 */
	private static List<MBMessage> getFullCommentsMessageList(long userId, long groupId, String className, long classPK)
		throws PortalException, SystemException
	{

		MBMessage rootMessage = getRootMessage(userId, groupId, className, classPK);
		return MBMessageLocalServiceUtil.getThreadMessages(rootMessage.getThreadId(), 0);
	}

	/**
	 * This will return user object.
	 * 
	 * @param userId Logged in user id.
	 * @return user
	 */
	public static User getUser(long userId)
	{
		User user = null;
		try
		{
			user = UserLocalServiceUtil.getUser(userId);

		}
		catch (PortalException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		return user;
	}

	/**
	 * This will return user imageurl.
	 * @param themeDisplay of ThemeDisplay
	 * @param userId This is logged in userID
	 * @return imageUrl
	 */
	public static String getImageUrl(long userId, ThemeDisplay themeDisplay)
	{
		User user = null;
		String imageUrl = StringPool.BLANK;
		try
		{
			user = getUser(userId);
			if (user.getPortraitId() == 0)
			{
				imageUrl = ApplicationConstants.DEFAULT_USER_IMAGE_URLS;
			}
			else
			{
				imageUrl = user.getPortraitURL(themeDisplay);
			}
		}
		catch (PortalException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		return imageUrl;
	}

	/**
	 * This method will exclude Current article from articleList.
	 * 
	 * @param articleList of List<JournalArticle>
	 * @param articleId Passing ArticleID
	 * @param noOfArticles Size of Articles
	 * @return listOfArticles
	 */
	public static List<JournalArticle> excludeCurrentArticleFromList(List<JournalArticle> articleList, String articleId, int noOfArticles)
	{
		int count = 1;
		List<JournalArticle> listOfArticles = new ArrayList<JournalArticle>();
		for (JournalArticle article : articleList)
		{
			if (!article.getArticleId().equalsIgnoreCase(articleId) && count <= noOfArticles)
			{
				listOfArticles.add(article);
				count++;
			}
		}

		return listOfArticles;

	}

	/**
	 * Send mail by passing request and other parameters.
	 * 
	 * @param resourceRequest
	 *            Resource Request which contain parameters.
	 * @param toAddresses
	 *            To address for sending mail.
	 * @param contentTitle
	 *            Content title for mail.
	 * @param contentLink
	 *            Content link of sending content.
	 * @param isCCAddress
	 *            CC Email address if any passed.
	 * @throws AddressException
	 *             Throws address exception if any address related operation
	 *             fail.
	 */
	public static void sendMail(ResourceRequest resourceRequest, String[] toAddresses, String contentTitle, String contentLink, boolean isCCAddress)
		throws AddressException
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String from = GetterUtil.getString(PropsUtil.get("ihg.from.email.address"));
		String cc = GetterUtil.getString(PropsUtil.get(themeDisplay.getUser().getEmailAddress()));
		GenericMail mailMessage = new GenericMail();
		mailMessage.setFrom(from);
		mailMessage.setTo(toAddresses);
		if (isCCAddress)
		{
			mailMessage.setCC(cc);
		}
		mailMessage.setSubject(contentTitle);
		mailMessage.setBody(contentLink);
		mailMessage.sendEmail();
	}

	/**
	 * This mehod will check valid articleID.
	 * 
	 * @param articleList List of journalArticle
	 * @param articleId Article ID.
	 * @return articleID
	 */
	public static String hasValidArticleID(List<JournalArticle> articleList, String articleId)
	{
		String articleID = StringPool.BLANK;

		for (JournalArticle journalArticle : articleList)
		{
			if (journalArticle.getArticleId().equals(articleId))
			{
				articleID = articleId;
			}
		}
		return articleID;

	}
	
	public static String getPreferredNamebyUserId(long userID,boolean isLastNameRequired) throws PortalException, SystemException{
		String preferredName=new String();
		User user = UserLocalServiceUtil.getUserById(userID);
		preferredName=(String)user.getExpandoBridge().getAttribute("Preferred Name");
		if(Validator.isNull(preferredName)){
			preferredName=user.getFirstName();
		}
		if(isLastNameRequired){
			preferredName=preferredName+StringPool.SPACE+user.getLastName();
		}
		return preferredName;
	}
}
