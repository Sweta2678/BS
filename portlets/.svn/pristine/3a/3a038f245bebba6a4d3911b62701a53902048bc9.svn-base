
package com.ihg.grs.util;

import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.constant.DiscussionConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.util.comparator.MessageCreateDateComparator;
import com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Common utility class for discussion portlet.
 */
public final class DiscussionCommonUtil
{

	private static final String ARTICLE_DETAILS_DATE_FORMAT = "dd MMM yyyy h:mm a";
	private static final Log LOGGER = LogFactoryUtil.getLog(DiscussionCommonUtil.class.getName());
	public static final int URLLENGTH = 100;

	/**
	 * Private constructor of DiscussionCommonUtil.
	 */
	private DiscussionCommonUtil()
	{

	}

	/**
	 * Returns list of files attached to a discussion.
	 * 
	 * @param uploadRequest
	 *            A request object.
	 * @param parameterName
	 *            A file name parameter.
	 * @return list of attached files
	 */
	public static List<ObjectValuePair<String, InputStream>> getFiles(UploadPortletRequest uploadRequest, String parameterName)
	{
		List<ObjectValuePair<String, InputStream>> files = new ArrayList<ObjectValuePair<String, InputStream>>();

		String fileName = uploadRequest.getFileName(parameterName);

		try
		{
			InputStream fileInputStream = uploadRequest.getFileAsStream(parameterName);
			if (Validator.isNotNull(fileInputStream))
			{
				ObjectValuePair<String, InputStream> ovp = new ObjectValuePair<String, InputStream>(fileName, fileInputStream);

				files.add(ovp);
			}
		}
		catch (IOException e)
		{
			LOGGER.error("Error while getting attachments:" + e.getMessage(), e);
		}
		return files;
	}

	/**
	 * @param request
	 *            A request object.
	 * @return ServiceContext A service context object
	 */
	public static ServiceContext getMBMessageServiceContext(PortletRequest request)
	{
		return DiscussionCommonUtil.getModelServiceContext(request, MBMessage.class.getName());
	}

	/**
	 * @param request
	 *            A request object.
	 * @param modelClassName
	 *            MBMessage class name.
	 * @return service context object
	 */
	public static ServiceContext getModelServiceContext(PortletRequest request, String modelClassName)
	{
		ServiceContext serviceContext = null;
		try
		{
			serviceContext = ServiceContextFactory.getInstance(modelClassName, request);
		}
		catch (PortalException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return serviceContext;
	}

	/**
	 * Returns user object based on userId.
	 * 
	 * @param userId
	 *            userId of a user.
	 * @return user object
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
			LOGGER.error("Error while fetching User based on UserId : " + userId, e);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while fetching User based on UserId : " + userId, e);
		}

		return user;

	}

	/**
	 * Returns string in a dd MMM yyyy h:mm a format.
	 * 
	 * @param themeDisplay
	 *            theme display object.
	 * @param date
	 *            date object
	 * @return String of formatted date.
	 */
	public static String getFormattedDate(ThemeDisplay themeDisplay, Date date)
	{

		DateFormat df = new SimpleDateFormat(ARTICLE_DETAILS_DATE_FORMAT);
		df.setTimeZone(TimeZone.getTimeZone(DiscussionConstant.COMMENT_DATE_TIMEZONE));
		String dateStr = df.format(date);
		dateStr = dateStr + StringPool.SPACE + DiscussionConstant.COMMENT_TIMEZONE;

		LOGGER.debug("formattedDate : " + dateStr);

		return dateStr;
	}

	/**
	 * Returns string in a dd MMM yyyy h:mm a format.
	 * 
	 * @param date
	 *            date object
	 * @return String of formatted date.
	 */
	public static String getDiscussionShortFormattedDate(Date date)
	{

		DateFormat df = new SimpleDateFormat(DiscussionConstant.DISCUSSION_COMMENTS_DATE_FORMAT);
		df.setTimeZone(TimeZone.getTimeZone(DiscussionConstant.COMMENT_DATE_TIMEZONE));
		String dateStr = df.format(date);
		dateStr = dateStr + StringPool.SPACE + ApplicationConstants.COMMENT_TIMEZONE;

		LOGGER.debug("getDiscussionShortFormattedDate() :: formattedDate : " + dateStr);

		return dateStr;

	}

	/**
	 * Returns total number of likes count of a discussion.
	 * 
	 * @param messageId
	 *            Id of root message. Message Board portlet.
	 * @return total count of likes.
	 */
	public static long getPostLikeCount(long messageId)
	{
		long likeCount = 0;
		try
		{
			likeCount = (long) RatingsStatsLocalServiceUtil.getStats(MBMessage.class.getName(), messageId).getTotalScore();
		}
		catch (SystemException e)
		{
			LOGGER.error("No like count found : " + e.getMessage());
		}
		return likeCount;
	}

	/**
	 * Returns string with html tags replaced.
	 * 
	 * @param html
	 *            A string to be replaced.
	 * @return string
	 */
	public static String htmlTagsRemover(String html)
	{
		return html.replaceAll("\\<(/?[^\\>]+)\\>", " ").replaceAll("\\s+", " ").trim();
	}

	/**
	 * Based on passed parameter name will display corresponding of discussion
	 * portlet.
	 * 
	 * @param request
	 *            A request object.
	 * @param paramName
	 *            Name of parameter.
	 * @return return string to display corresponding discussion page.
	 */
	public static String getParameterValue(RenderRequest request, String paramName)
	{

		HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		String paramValue = StringPool.BLANK;
		if (Validator.isNotNull(ParamUtil.getString(request, paramName)))
		{
			paramValue = ParamUtil.getString(request, paramName);
		}
		else if (Validator.isNotNull(httpServletRequest.getParameter(paramName)))
		{
			paramValue = httpServletRequest.getParameter(paramName);
		}
		else
		{
			paramValue = (String) request.getAttribute(paramName);
		}

		if (Validator.isNull(paramValue))
		{
			paramValue = StringPool.BLANK;
		}
		return paramValue;
	}

	/**
	 * Returns list of comments posted on discussion.
	 * 
	 * @param discussionId
	 *            Id of message board discussion.
	 * @param start
	 *            starting point of discussion comments list.
	 * @param end
	 *            ending point of discussion comments list.
	 * @return list of discussion comments.
	 */
	public static List<MBMessage> getDiscussionCommentsList(Long discussionId, int start, int end)
	{
		List<MBMessage> discussionCommentsList = null;
		List<MBMessage> messages = null;
		try
		{
			messages = MBMessageLocalServiceUtil.getThreadMessages(discussionId, WorkflowConstants.STATUS_ANY, 0, 1);
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		if (messages != null && messages.size() > 0)
		{
			MBMessage rootMessage = messages.get(0);
			discussionCommentsList = new ArrayList<MBMessage>();
			discussionCommentsList.add(rootMessage);
			discussionCommentsList.addAll(getDiscussionThread(discussionId, start, end));

		}

		return discussionCommentsList;
	}

	/**
	 * Returns list of root level discussion comments list.
	 * 
	 * @param discussionId
	 *            Id of message board discussion.
	 * @param start
	 *            starting point of discusssions list.
	 * @param end
	 *            ending point of discussions list.
	 * @return list of discussion.
	 */
	public static List<MBMessage> getDiscussionThread(Long discussionId, int start, int end)
	{

		List<MBMessage> discussionCommentsList = new ArrayList<MBMessage>();
		List<MBMessage> allComments = null;
		try
		{
			allComments = MBMessageLocalServiceUtil.getThreadMessages(discussionId, WorkflowConstants.STATUS_ANY);
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

		if (allComments != null && allComments.size() >= 1)
		{
			allComments.remove(0);

			allComments = ListUtil.sort(allComments, new MessageCreateDateComparator(false));
			discussionCommentsList.addAll(ListUtil.subList(allComments, start, end));
			/*
			 * if (end > commentCount) {
			 * discussionCommentsList.addAll(allComments); } else {
			 * discussionCommentsList.addAll(ListUtil.subList(allComments,
			 * start, end)); }
			 */
		}
		return discussionCommentsList;

	}

	/**
	 * Returns starting position of discussions list.
	 * 
	 * @param currentPageCount
	 *            Toatl number of discussions currently displayed on page.
	 * @param resultsPerPageCount
	 *            Default number of discussions to be displayed on page.
	 * @param totalResultCount
	 *            Total number of Message board discussions.
	 * @return Return start position of discussions list.
	 *//*
	public static int getPaginatorStartCount(int currentPageCount, int resultsPerPageCount, int totalResultCount)
	{

		int start = (currentPageCount * resultsPerPageCount) - resultsPerPageCount;
		int end = currentPageCount * resultsPerPageCount;

		if (totalResultCount <= end)
		{
			if (start == end || start >= end)
			{
				if (start - resultsPerPageCount <= 0)
				{
					start = 0;
					currentPageCount = 1;
				}
				else
				{
					start -= resultsPerPageCount;
					currentPageCount -= 1;
				}
			}
		}
		return start;
	}*/

	/**
	 * Returns ending position of discussions list.
	 * 
	 * @param currentPageCount
	 *            Toatl number of discussions currently displayed on page.
	 * @param resultsPerPageCount
	 *            Default number of discussions to be displayed on page.
	 * @param totalResultCount
	 *            Total number of Message board discussions.
	 * @return Return end position of discussions list.
	 */
	/*public static int getPaginatorEndCount(int currentPageCount, int resultsPerPageCount, int totalResultCount)
	{
		int end = currentPageCount * resultsPerPageCount;
		if (totalResultCount <= end)
		{
			end = totalResultCount;
		}
		return end;
	}*/

	/**
	 * Returns message board message object with primary key.
	 * 
	 * @param messageId
	 *            Primary key of message board message.
	 * @return message board message.
	 */
	public static MBMessage getMessage(long messageId)
	{
		MBMessage message = null;

		try
		{
			message = MBMessageLocalServiceUtil.getMBMessage(messageId);
		}
		catch (PortalException e)
		{
			LOGGER.error("Error while finding Message based on messageId:" + messageId, e);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while finding Message based on messageId:" + messageId, e);
		}

		return message;
	}

	/**
	 * Returns list of all attachments of a message board message.
	 * 
	 * @param message
	 *            MBMessage object
	 * @return list of attachments.
	 */
	public static List<FileEntry> getMessageAttachments(MBMessage message)
	{
		List<FileEntry> attachements = Collections.emptyList();
		try
		{
			if ((message != null) && message.getAttachmentsFileEntriesCount() > 0)
			{
				/*
				 * existingAttachments = DLLocalServiceUtil.getFileNames(
				 * message.getCompanyId(), CompanyConstants.SYSTEM,
				 * message.getAttachmentsDir());
				 */
				attachements = message.getAttachmentsFileEntries();
			}
		}
		catch (PortalException e)
		{
			LOGGER.error("Error while finding attachments for the given mbMessageId:" + message.getMessageId() + " ,error:" + e.getMessage());
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while finding attachments for the given mbMessageId:" + message.getMessageId() + " ,error:" + e.getMessage());
		}

		return attachements;
	}

	/**
	 * Returns URL of document image in GRS theme.
	 * 
	 * @param pathThemeDisplay
	 * @param extension
	 *            Extension of file attached.
	 * @return Full path of image for corresponding document type.
	 */
	public static String getFileIconPath(String pathThemeDisplay, String extension)
	{

		String path = StringPool.BLANK;
		if ("pdf".equals(extension))
		{
			path = pathThemeDisplay + "/content/one.jpg";
		}
		else if ("xls".equals(extension))
		{
			path = pathThemeDisplay + "/content/four.jpg";
		}
		else if ("jpg".equals(extension) || "bmp".equals(extension) || "png".equals(extension) || "jpeg".equals(extension))
		{
			path = pathThemeDisplay + "/content/five.jpg";
		}
		else if ("mp4".equals(extension) || "flv".equals(extension))
		{
			path = pathThemeDisplay + "/content/two.jpg";
		}
		else if ("doc".equals(extension))
		{
			path = pathThemeDisplay + "/content/document.png";
		}
		else if ("docx".equals(extension))
		{
			path = pathThemeDisplay + "/content/documentx.png";
		}
		else if ("ppt".equals(extension))
		{
			path = pathThemeDisplay + "/content/presentation.png";
		}
		else
		{
			path = pathThemeDisplay + "/content/default.png";
		}
		return path;
	}

	/**
	 * Returns type of attachment based on its extension.
	 * 
	 * @param extension
	 *            extension of the attachment.
	 * @return type of attachment based on extension.
	 */
	public static String getResourceType(String extension)
	{

		String resourceType = StringPool.BLANK;
		if ("pdf".equals(extension))
		{
			resourceType = "pdf";
		}
		else if ("xls".equals(extension) || "doc".equals(extension) || "docx".equals(extension))
		{
			resourceType = "document";
		}
		else if ("jpg".equals(extension) || "bmp".equals(extension) || "png".equals(extension) || "jpeg".equals(extension))
		{
			resourceType = "image";
		}
		else if ("mp4".equals(extension) || "flv".equals(extension))
		{
			resourceType = "video";
		}
		else if ("ppt".equals(extension))
		{
			resourceType = "presentation";
		}
		else
		{
			resourceType = "document";
		}
		return resourceType;
	}

	/**
	 * Return URL of a page.
	 * 
	 * @param portletRequest
	 *            A portlet request object.
	 * @param pageName
	 *            Page name of current site.
	 * @return URL of the page.
	 */
	public static String getFullURLByPageName(PortletRequest portletRequest, String pageName)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = null;
		StringBuilder pageFriendlyURL = new StringBuilder();

		try
		{
			if (Validator.isNotNull(pageName))
			{
				layout = getPageLayout(themeDisplay, pageName);
				if (Validator.isNotNull(layout))
				{
					Group currentGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
					String groupFriendlyUrl = currentGroup.getPathFriendlyURL(false, themeDisplay);
					String communityUrl = currentGroup.getFriendlyURL();
					pageFriendlyURL.append(groupFriendlyUrl).append(communityUrl).append(layout.getFriendlyURL());
					if (LOGGER.isDebugEnabled())
					{
						LOGGER.debug("groupFriendly URL :>>" + groupFriendlyUrl);
						LOGGER.debug("community URL :>>" + communityUrl);
					}
				}
			}
		}
		catch (PortalException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

		return pageFriendlyURL.toString();
	}

	/**
	 * Return layout object of corresponding page.
	 * 
	 * @param themeDisplay
	 *            A theme display object.
	 * @param pageName
	 *            page name of a site.
	 * @return URL of page.
	 */
	private static Layout getPageLayout(ThemeDisplay themeDisplay, String pageName)
	{

		List<Layout> layoutList = null;
		Layout pageLayout = null;

		try
		{
			layoutList = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);

			for (Layout layout : layoutList)
			{
				if (layout.getName(Locale.US).equalsIgnoreCase(pageName))
				{
					pageLayout = layout;
					break;
				}

				List<Layout> childLayouts = layout.getChildren();

				for (Layout childLayout : childLayouts)
				{
					if (childLayout.getName(Locale.US).equalsIgnoreCase(pageName))
					{
						pageLayout = childLayout;
						break;
					}
				}
			}
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return pageLayout;
	}

	/**
	 * Returns image URL of liferay user.
	 * 
	 * @param userId
	 *            UserId of liferay user.
	 * @param themeDisplay
	 *            A theme display object.
	 * @return Image URL of Liferay user portrait.
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
				imageUrl = DiscussionConstant.DEFAULT_USER_IMAGE_URLS;
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
	 * Returns image URL of liferay user.
	 * 
	 * @param userId
	 *            UserId of liferay user.
	 * @param themeDisplay
	 *            A theme display object.
	 * @return Image URL of Liferay user portrait.
	 */
	public static String getUserPortrait(ThemeDisplay themeDisplay, String userId)
	{

		String userPortrait = "";
		try
		{
			User user = UserLocalServiceUtil.getUser(Long.valueOf(userId));
			userPortrait = user.getPortraitURL(themeDisplay);
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (PortalException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

		return userPortrait;
	}

	/**
	 * Generate full URL of the attached file and return it as String.
	 * 
	 * @param file
	 *            An object to get file details.
	 * @return URL of attached file.
	 */
	public static String getFileURL(Object file)
	{
		FileEntry fileEntry = (FileEntry) file;
		StringBuilder builder = new StringBuilder(URLLENGTH);
		builder.append("/documents/portlet_file_entry/");
		builder.append(fileEntry.getGroupId()).append("/").append(fileEntry.getTitle()).append("/").append(fileEntry.getUuid());

		String fileUrl = builder.toString();

		return fileUrl;
	}
	
	public static void subscribeDiscussion(long userId, long messageId, boolean subscribe)
	{
		
		try
		{
			if (messageId > 0)
			{
				if (subscribe)
				{
					MBMessageLocalServiceUtil.subscribeMessage(userId, messageId);
				}
				else
				{
					MBMessageLocalServiceUtil.unsubscribeMessage(userId, messageId);
				}
			}
		}
		catch (PortalException e)
		{
			LOGGER.error("Error while un/subscribe message with messageId:"
					+ messageId + " , msd:" + e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while un/subscribe message with messageId:"
					+ messageId + " , msd:" + e.getMessage(), e);
		}
		
	}
}
